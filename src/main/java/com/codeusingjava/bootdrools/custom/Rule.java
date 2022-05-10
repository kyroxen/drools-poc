package com.codeusingjava.bootdrools.custom;

import java.util.Set;

public interface Rule {

  boolean isValid(RuleWrapper ruleWrapper);

  default void preExecution(RuleWrapper ruleWrapper){
    //Do nothing
  }

  void execute(RuleWrapper ruleWrapper); // Updates are done inside the wrapper in this version. More functionality.
  // API is less clear though.

//  RuleEngineOutputDto execute(RuleEngineInputDto inputDto, RuleEngineOutputDto outputDto); // Updates are clearly visible
//  // in the output object. Clear code. But less functionality.


  default void postExecution(RuleWrapper ruleWrapper){
    //Do nothing
  }

  Set<RuleProcessTypeEnum> getTypes();
}
