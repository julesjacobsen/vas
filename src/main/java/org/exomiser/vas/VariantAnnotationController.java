package org.exomiser.vas;

import org.exomiser.vas.api.VariantAnnotationService;
import org.exomiser.vas.model.AnnotatedVariant;
import org.exomiser.vas.model.AnnotationException;
import org.monarchinitiative.exomiser.core.genome.GenomeAssembly;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jules on 11/05/2016.
 */
@RestController
public class VariantAnnotationController {

    private final VariantAnnotationService hg19VariantAnnotationService;
    private final VariantAnnotationService hg38VariantAnnotationService;

    public VariantAnnotationController(VariantAnnotationService hg19VariantAnnotationService, VariantAnnotationService hg38VariantAnnotationService){
        this.hg19VariantAnnotationService = hg19VariantAnnotationService;
        this.hg38VariantAnnotationService = hg38VariantAnnotationService;
    }

    @RequestMapping("/")
    public String root(){
        return "Welcome to the Variant Annotation Server";
    }

    @RequestMapping("annotate")
    public AnnotatedVariant getVariantFrequencyData(@RequestParam String assembly, @RequestParam String chr, @RequestParam int start, @RequestParam String ref, @RequestParam String alt) {
        GenomeAssembly genomeAssembly = GenomeAssembly.fromValue(assembly);
        if (genomeAssembly == GenomeAssembly.HG19) {
            return hg19VariantAnnotationService.annotate(chr, start, ref, alt);
        } else if (genomeAssembly == GenomeAssembly.HG38) {
            return hg38VariantAnnotationService.annotate(chr, start, ref, alt);
        }
        throw new AnnotationException();
    }

}
