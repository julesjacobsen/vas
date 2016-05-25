package org.exomiser.vas.model;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.Map;
import java.util.Set;

/**
 * Created by jules on 11/05/2016.
 */
public class FrequencyData {

    public static final FrequencyData NO_DATA = new FrequencyData(ImmutableSet.<Frequency>of());

    private final Set<Frequency> frequencies;

    public FrequencyData(Iterable<Frequency> frequencies) {
        this.frequencies = ImmutableSet.copyOf(frequencies);
    }

    public Set<Frequency> getFrequencies() {
        return frequencies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FrequencyData that = (FrequencyData) o;

        return frequencies.equals(that.frequencies);
    }

    @Override
    public int hashCode() {
        return frequencies.hashCode();
    }
}
