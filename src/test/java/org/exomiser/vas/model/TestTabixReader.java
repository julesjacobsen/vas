package org.exomiser.vas.model;

import htsjdk.tribble.readers.TabixReader;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Jules Jacobsen <jules.jacobsen@sanger.ac.uk>
 */
public class TestTabixReader {

    @Test
    public void readVcfExampleWithStringInput() throws Exception {
        TabixReader tabixReader = new TabixReader("src/test/resources/vcfexample.vcf.gz");
        TabixReader.Iterator results = tabixReader.query("20:14370-123457");
        System.out.println(tabixReader.readLine());
        int numLines = 0;
        String line;
        while ((line = results.next()) != null) {
            numLines++;
            System.out.println(line);
        }
        assertThat(numLines, equalTo(6));
    }

    @Test
    public void readVcfExampleWithZeroBasedIntegerPositionInput() throws Exception {
        TabixReader tabixReader = new TabixReader("src/test/resources/vcfexample.vcf.gz");
        TabixReader.Iterator results = tabixReader.query("20", 14369, 123458);
        int numLines = 0;
        while ((results.next()) != null) {
            numLines++;
        }
        assertThat(numLines, equalTo(6));
    }

}
