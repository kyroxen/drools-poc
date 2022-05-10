package com.codeusingjava.bootdrools.custom;

import lombok.Data;

@Data
public class RuleWrapper {
  private RuleEngineInputDto inputDto;
  private RuleEngineOutputDto outputDto;

  RulesExecutionTracker tracker;
  RuleProcessTypeEnum type;
}
