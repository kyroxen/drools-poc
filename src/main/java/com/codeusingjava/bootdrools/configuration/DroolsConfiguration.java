package com.codeusingjava.bootdrools.configuration;

import lombok.extern.slf4j.Slf4j;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;

@Configuration
@Slf4j
public class DroolsConfiguration {

  private static final String DRL_FILE =
      "/Users/xen/Downloads/boot-drools-decision/src/main/resources/drlFile.drl";
  private static final String XLSX_FILE =
      "/Users/xen/Downloads/boot-drools-decision/src/main/resources/rules-custom.xlsx";
  private final KieServices kieServices = KieServices.Factory.get();

  @Bean
  public KieContainer kieContainer() {
    KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
    kieFileSystem.write(ResourceFactory.newClassPathResource("rules-custom.xlsx"));
    KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
    kb.buildAll();
    KieModule kieModule = kb.getKieModule();
    printDrl();
    return kieServices.newKieContainer(kieModule.getReleaseId());
  }

  private void printDrl() {
    File dtf = new File(XLSX_FILE);
    InputStream is = null;
    try {
      is = new FileInputStream(dtf);
      SpreadsheetCompiler ssComp = new SpreadsheetCompiler();
      String s = ssComp.compile(is, InputType.XLS);

      try (BufferedWriter writer = new BufferedWriter(new FileWriter(DRL_FILE))) {
        writer.write(s);
      }

      log.info("=== Begin generated DRL ===");
      log.info(s);
      log.info("=== End generated DRL ===");
    } catch (IOException e) {
      log.error("Exception caught while writing drl file {}", e.getMessage(), e);
    }
  }
}
