package com.taxcalc.resouce;

import com.taxcalc.model.request.TaxCalcRequest;
import com.taxcalc.model.response.TaxCalcResponse;
import com.taxcalc.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/tax")
public class TaxDetailsResource {

    @Autowired
    private TaxService taxService;

    @PostMapping("/calc")
    public String getDetails(@Valid @RequestBody TaxCalcRequest taxCalcRequest, Model model) {
        TaxCalcResponse response = taxService.calculate(taxCalcRequest);
        model.addAttribute("response", response);
        System.out.println("response: "+response);
        return "tax calculated. Check console for response";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello nasreen";
    }
}
