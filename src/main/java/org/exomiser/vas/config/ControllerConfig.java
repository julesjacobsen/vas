package org.exomiser.vas.config;

import org.exomiser.vas.api.VariantAnnotationService;
import org.h2.mvstore.MVStore;
import org.monarchinitiative.exomiser.core.genome.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jules Jacobsen <j.jacobsen@qmul.ac.uk>
 */
@Configuration
public class ControllerConfig {

    @Bean
    public VariantAnnotationService hg19VariantAnnotationService(@Qualifier("hg19variantAnnotator") VariantAnnotator variantAnnotator, @Qualifier("hg19mvStore") MVStore alleleMvStore) {
        return new VariantAnnotationService(variantAnnotator, alleleMvStore);
    }

    @Bean
    public VariantAnnotationService hg38VariantAnnotationService(@Qualifier("hg38variantAnnotator") VariantAnnotator variantAnnotator, @Qualifier("hg38mvStore") MVStore alleleMvStore) {
        return new VariantAnnotationService(variantAnnotator, alleleMvStore);

    }

}
