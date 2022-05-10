package com.codeusingjava.bootdrools.custom;

public interface RuleProcess {
  void preProcess(RuleWrapper ruleWrapper);
  void execute(RuleWrapper ruleWrapper);
  void postProcess(RuleWrapper ruleWrapper);
}
