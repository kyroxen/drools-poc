package com.codeusingjava.bootdrools.controller;

import com.codeusingjava.bootdrools.model.DepositRequest;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositRateController {

  private final KieContainer kieContainer;

  public DepositRateController(KieContainer kieContainer) {
    this.kieContainer = kieContainer;
  }

  @GetMapping(value = "/getInterestRate", produces = "application/json")
  public String getInterest(
      @RequestParam(required = true) String loanType,
      @RequestParam(required = true) Integer durationInYear,
      @RequestParam(required = true) Integer vehiclePrice) {
    KieSession kieSession = kieContainer.newKieSession();
    DepositRequest depositRequest = new DepositRequest(loanType, durationInYear, vehiclePrice);
    kieSession.insert(depositRequest);
    kieSession.fireAllRules();
    kieSession.dispose();
    return "The interest rate for this application is " + depositRequest.getInterestRate();
  }
}
