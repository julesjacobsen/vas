package org.exomiser.vas;

import org.exomiser.vas.model.Frequency;
import org.exomiser.vas.model.FrequencyData;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by jules on 11/05/2016.
 */
public class VariantAnnotationServerTest {

    private VariantAnnotationServer instance = new VariantAnnotationServer();

    @Test
    public void root() throws Exception {
        assertThat(instance.root(), equalTo("Welcome to the Variant Annotation Server"));
    }

    @Test
    public void getVariantFrequencyData() throws Exception {
        assertThat(instance.getVariantFrequencyData("wibble", 1L, "A", "T"), equalTo(FrequencyData.NO_DATA));
    }

}