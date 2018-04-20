package org.exomiser.vas;

import org.exomiser.vas.model.AnnotatedVariant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.monarchinitiative.exomiser.test.ExomiserStubDataConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by jules on 11/05/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {VariantAnnotationControllerTest.class, ExomiserStubDataConfig.class})
public class VariantAnnotationControllerTest {

    @Test
    public void testContextLoads() {
    }
}