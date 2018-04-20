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

/**
 * @author Jules Jacobsen <j.jacobsen@qmul.ac.uk>
 */
public class VariantAnnotationService {

    private final VariantAnnotator variantAnnotator;
    private final MVMap<AlleleProto.AlleleKey, AlleleProperties> alleleMap;

    public VariantAnnotationService(VariantAnnotator variantAnnotator, MVStore alleleMvStore) {
        this.variantAnnotator = variantAnnotator;
        this.alleleMap = MvStoreUtil.openAlleleMVMap(alleleMvStore);
    }

    public AnnotatedVariant annotate(String contig, int pos, String ref, String alt){

        VariantAnnotation variantAnnotation = variantAnnotator.annotate(contig, pos, ref, alt);

        AlleleProperties alleleProperties = alleleMap.getOrDefault(MvStoreUtil.generateAlleleKey(variantAnnotation), AlleleProperties
                .getDefaultInstance());
        FrequencyData frequencyData = AlleleProtoAdaptor.toFrequencyData(alleleProperties);
        PathogenicityData pathogenicityData = AlleleProtoAdaptor.toPathogenicityData(alleleProperties);

        return AnnotatedVariant.from(variantAnnotation, frequencyData, pathogenicityData);
    }
}
