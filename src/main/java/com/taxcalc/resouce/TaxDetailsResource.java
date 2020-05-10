package com.taxcalc.resouce;

import com.taxcalc.model.request.TaxCalcRequest;
import com.taxcalc.model.response.TaxCalcResponse;
import com.taxcalc.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
//@Controller
@RequestMapping("/tax")
public class TaxDetailsResource {

    @Autowired
    private TaxService taxService;

    @PostMapping("/calc")
    public TaxCalcResponse getDetails(@Valid @RequestBody TaxCalcRequest taxCalcRequest, Model model) {
        TaxCalcResponse response = taxService.calculate(taxCalcRequest);
        model.addAttribute("response", response);
        System.out.println("response: "+response);
        return response;
    }

    @GetMapping("/hello")
    public String hello() {
        return "index";
    }
}
