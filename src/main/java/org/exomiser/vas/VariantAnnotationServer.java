package org.exomiser.vas;

import com.google.common.collect.ImmutableSet;
import org.exomiser.vas.model.Frequency;
import org.exomiser.vas.model.FrequencyData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jules on 11/05/2016.
 */
@Controller
public class VariantAnnotationServer {

    @RequestMapping("/")
    @ResponseBody
    public String root(){
        return "Welcome to the Variant Annotation Server";
    }

    @RequestMapping("frequency")
    @ResponseBody
    public FrequencyData getVariantFrequencyData(@RequestParam String chr, @RequestParam long start, @RequestParam String ref, @RequestParam String alt) {
        return new FrequencyData(ImmutableSet.<Frequency>of());
    }
}
