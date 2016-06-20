package org.exomiser.vas.api;

import org.exomiser.vas.model.FrequencyData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

/**
 * Created by jules on 11/05/2016.
 */
@Controller
@RequestMapping("v1")
public class VariantAnnotationServer {

    @RequestMapping("/")
    @ResponseBody
    public String root(){
        return "Welcome to the Variant Annotation Server - API v1";
    }

    @RequestMapping("frequency")
    @ResponseBody
    public Mono<FrequencyData> getVariantFrequencyData(@RequestParam String chr, @RequestParam long start, @RequestParam String ref, @RequestParam String alt) {
        return Mono.just(FrequencyData.NO_DATA);
    }

    @RequestMapping("blocking/frequency")
    @ResponseBody
    public FrequencyData getBlockingVariantFrequencyData(@RequestParam String chr, @RequestParam long start, @RequestParam String ref, @RequestParam String alt) {
        return getVariantFrequencyData(chr, start, ref, alt).block();
    }
}
