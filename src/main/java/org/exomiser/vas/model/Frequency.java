package org.exomiser.vas.model;

/**
 * Created by jules on 11/05/2016.
 */
public interface Frequency {

    /**
     * Unique identifier to describe the source of this frequency data.
     * @return
     */
    String getSource();

    //TODO: percentage?
    double getFrequency();
}
