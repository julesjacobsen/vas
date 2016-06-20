package org.exomiser.vas.api;

import org.exomiser.vas.model.FrequencyData;
import org.junit.Test;
import reactor.core.publisher.Mono;
import reactor.core.test.TestSubscriber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by jules on 11/05/2016.
 */
public class VariantAnnotationServerTest {

    private VariantAnnotationServer instance = new VariantAnnotationServer();

    @Test
    public void root() throws Exception {
        assertThat(instance.root(), equalTo("Welcome to the Variant Annotation Server - API v1"));
    }

    @Test
    public void getVariantFrequencyData() throws Exception {
        Mono<FrequencyData> mono = instance.getVariantFrequencyData("wibble", 1L, "A", "T");

        TestSubscriber
                .subscribe(mono)
                .assertValues(FrequencyData.NO_DATA)
                .assertComplete();
    }

    @Test
    public void getBlockingVariantFrequencyData() throws Exception {
        assertThat(instance.getBlockingVariantFrequencyData("wibble", 1L, "A", "T"), equalTo(FrequencyData.NO_DATA));
    }
}