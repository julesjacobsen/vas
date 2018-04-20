package org.exomiser.vas.model;

import de.charite.compbio.jannovar.annotation.VariantEffect;
import org.monarchinitiative.exomiser.core.genome.GenomeAssembly;
import org.monarchinitiative.exomiser.core.model.TranscriptAnnotation;
import org.monarchinitiative.exomiser.core.model.Variant;
import org.monarchinitiative.exomiser.core.model.VariantAnnotation;
import org.monarchinitiative.exomiser.core.model.frequency.FrequencyData;
import org.monarchinitiative.exomiser.core.model.pathogenicity.PathogenicityData;

import java.util.List;

/**
 * @author Jules Jacobsen <j.jacobsen@qmul.ac.uk>
 */
public class AnnotatedVariant implements Variant {

    private final GenomeAssembly genomeAssembly;
    private final int chr;
    private final String chromosomeName;
    private final int pos;
    private final String ref;
    private final String alt;

    private final String geneSymbol;
    private final String geneId;
    private final VariantEffect variantEffect;
    private final List<TranscriptAnnotation> annotations;

    private final FrequencyData frequencyData;
    private final PathogenicityData pathogenicityData;

    public static AnnotatedVariant from(VariantAnnotation variantAnnotation, FrequencyData frequencyData, PathogenicityData pathogenicityData) {
        return new AnnotatedVariant(variantAnnotation, frequencyData, pathogenicityData);
    }

    private AnnotatedVariant(VariantAnnotation variantAnnotation, FrequencyData frequencyData, PathogenicityData pathogenicityData) {
        this.genomeAssembly = variantAnnotation.getGenomeAssembly();
        this.chr = variantAnnotation.getChromosome();
        this.chromosomeName = variantAnnotation.getChromosomeName();
        this.pos = variantAnnotation.getPosition();
        this.ref = variantAnnotation.getRef();
        this.alt = variantAnnotation.getAlt();

        this.geneSymbol = variantAnnotation.getGeneSymbol();
        this.geneId = variantAnnotation.getGeneId();
        this.variantEffect = variantAnnotation.getVariantEffect();
        this.annotations = variantAnnotation.getTranscriptAnnotations();
        this.frequencyData = frequencyData;
        this.pathogenicityData = pathogenicityData;
    }

    @Override
    public GenomeAssembly getGenomeAssembly() {
        return genomeAssembly;
    }

    @Override
    public int getChromosome() {
        return chr;
    }

    @Override
    public String getChromosomeName() {
        return chromosomeName;
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public String getRef() {
        return ref;
    }

    @Override
    public String getAlt() {
        return alt;
    }

    //variant-derived annotations
    @Override
    public String getGeneSymbol() {
        return geneSymbol;
    }

    @Override
    public String getGeneId() {
        return geneId;
    }

    @Override
    public VariantEffect getVariantEffect() {
        return variantEffect;
    }

    @Override
    public List<TranscriptAnnotation> getTranscriptAnnotations() {
        return annotations;
    }

    @Override
    public boolean hasTranscriptAnnotations() {
        return !annotations.isEmpty();
    }

    public FrequencyData getFrequencyData() {
        return frequencyData;
    }

    public PathogenicityData getPathogenicityData() {
        return pathogenicityData;
    }
}
