package com.codeusingjava.bootdrools.custom;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LoanTenureValueRule implements Rule {

  @Override
  public boolean isValid(RuleWrapper ruleWrapper) {
    // F1 F2
    // Validations on input dto fields
    // Throw exceptions etc
    return false;
  }

  @Override
  public void execute(RuleWrapper ruleWrapper) {

    final RuleEngineInputDto inputDto = ruleWrapper.getInputDto(); //facts


    final RuleEngineOutputDto outputDto = ruleWrapper.getOutputDto(); //result

  }

  @Override
  public Set<RuleProcessTypeEnum> getTypes() {
    Set<RuleProcessTypeEnum> set = new HashSet<>();
    set.add(RuleProcessTypeEnum.PRE_CAR);
    set.add(RuleProcessTypeEnum.CHECKOUT);
    return set;
  }
}
