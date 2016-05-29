package org.exomiser.vas.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Created by jules on 11/05/2016.
 */
public class GenericFrequency implements Frequency {

    private final String source;
    private final double frequency;

    public GenericFrequency(String source, double frequency) {
        this.source = source;
        this.frequency = frequency;
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public double getFrequency() {
        return frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericFrequency that = (GenericFrequency) o;
        return Double.compare(that.frequency, frequency) == 0 &&
                Objects.equal(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(source, frequency);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("source", source)
                .add("frequency", frequency)
                .toString();
    }
}
