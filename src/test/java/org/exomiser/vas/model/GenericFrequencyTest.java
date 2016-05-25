package org.exomiser.vas.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by jules on 11/05/2016.
 */
public class GenericFrequencyTest {
    private final GenericFrequency instance = new GenericFrequency("wibble", 100d);

    @Test
    public void getSource() throws Exception {
        assertThat(instance.getSource(), equalTo("wibble"));
    }

    @Test
    public void getFrequency() throws Exception {
        assertThat(instance.getFrequency(), equalTo(100d));
    }

    @Test
    public void equals() throws Exception {
        assertThat(instance, equalTo(new GenericFrequency("wibble", 100d)));
    }

    @Test
    public void testHashCode() throws Exception {
        assertThat(instance.hashCode(), equalTo(new GenericFrequency("wibble", 100d).hashCode()));

    }

    @Test
    public void testToString() throws Exception {
        assertThat(instance.toString(), equalTo("GenericFrequency{source=wibble, frequency=100.0}"));
    }

}