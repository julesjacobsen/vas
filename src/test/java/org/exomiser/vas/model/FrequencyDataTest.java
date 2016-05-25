package org.exomiser.vas.model;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by jules on 11/05/2016.
 */
public class FrequencyDataTest {

    @Test
    public void testNoData() {
        assertThat(FrequencyData.NO_DATA, equalTo(new FrequencyData(ImmutableSet.<Frequency>of())));
    }

    @Test
    public void getFrequencies() {
        Set<Frequency> frequencies = ImmutableSet.<Frequency>of(new GenericFrequency("source1", 0.01d));
        FrequencyData instance = new FrequencyData(frequencies);
        assertThat(instance.getFrequencies(), equalTo(frequencies));
    }
}