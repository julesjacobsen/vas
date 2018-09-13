package org.exomiser.vas.api;

import org.exomiser.vas.model.AnnotatedVariant;
import org.h2.mvstore.MVMap;
import org.h2.mvstore.MVStore;
import org.monarchinitiative.exomiser.core.genome.VariantAnnotator;
import org.monarchinitiative.exomiser.core.genome.dao.serialisers.MvStoreUtil;
import org.monarchinitiative.exomiser.core.model.AlleleProtoAdaptor;
import org.monarchinitiative.exomiser.core.model.VariantAnnotation;
import org.monarchinitiative.exomiser.core.model.frequency.FrequencyData;
import org.monarchinitiative.exomiser.core.model.pathogenicity.PathogenicityData;
import org.monarchinitiative.exomiser.core.proto.AlleleProto;
import org.monarchinitiative.exomiser.core.proto.AlleleProto.AlleleProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Jules Jacobsen <j.jacobsen@qmul.ac.uk>
 */
public class VariantAnnotationService {

    private static final Logger logger = LoggerFactory.getLogger(VariantAnnotationService.class);

    private final VariantAnnotator variantAnnotator;
    private final MVMap<AlleleProto.AlleleKey, AlleleProperties> alleleMap;

    public VariantAnnotationService(VariantAnnotator variantAnnotator, MVStore alleleMvStore) {
        this.variantAnnotator = variantAnnotator;
        this.alleleMap = MvStoreUtil.openAlleleMVMap(alleleMvStore);
    }

    public AnnotatedVariant annotate(String contig, int pos, String ref, String alt){
        logger.debug("Received annotate request for {} {} {} {}", contig, pos, ref, alt);
        Instant start = Instant.now();
        VariantAnnotation variantAnnotation = variantAnnotator.annotate(contig, pos, ref, alt);
        logger.debug("Annotation finished - fetching variant data");
        AlleleProperties alleleProperties = alleleMap.getOrDefault(AlleleProtoAdaptor.toAlleleKey(variantAnnotation), AlleleProperties
                .getDefaultInstance());
        FrequencyData frequencyData = AlleleProtoAdaptor.toFrequencyData(alleleProperties);
        PathogenicityData pathogenicityData = AlleleProtoAdaptor.toPathogenicityData(alleleProperties);
        Instant end = Instant.now();
        logger.debug("Returning AnnotatedVariant - query time {} ms", Duration.between(start, end).toMillis());
        return AnnotatedVariant.from(variantAnnotation, frequencyData, pathogenicityData);
    }
}
