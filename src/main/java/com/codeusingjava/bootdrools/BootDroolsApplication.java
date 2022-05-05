package com.codeusingjava.bootdrools;

import com.codeusingjava.bootdrools.model.OfferEngineRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class BootDroolsApplication {

  public BootDroolsApplication(KieContainer kieContainer) {
    this.kieContainer = kieContainer;
  }

  public static void main(String[] args) {
    SpringApplication.run(BootDroolsApplication.class, args);
  }

  private final KieContainer kieContainer;

  @PostConstruct
  public void getInterest() {
    log.info("getInterest()");
    KieSession kieSession = kieContainer.newKieSession();
    OfferEngineRequestDto depositRequest =
        OfferEngineRequestDto.builder()
            .bajajSegment(1)
            .bajajStatus("PQ")
            .cibil(300)
            .employmentType("Salaried")
            .income(5000D)
            .incomeProof("TRUE")
            .build();


    kieSession.insert(depositRequest);
    kieSession.fireAllRules();
    kieSession.dispose();

    log.info("Result: {}", depositRequest);
  }
}
