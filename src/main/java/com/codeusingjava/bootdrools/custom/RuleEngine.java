package com.codeusingjava.bootdrools.custom;

public interface RuleEngine {
  void process(RuleWrapper ruleWrapper);
  RulesEngineTypeEnum getType();
}
