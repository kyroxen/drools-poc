package com.codeusingjava.bootdrools.custom;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleRuleEngine implements RuleEngine{

  private final List<Rule> rules;

  public SimpleRuleEngine(List<Rule> rules) { //Spring IOC container will autowire the candidates
    this.rules = rules;
  }

  @Override
  public void process(RuleWrapper ruleWrapper) {
    for(Rule rule: rules){
      rule.isValid(ruleWrapper);
      rule.execute(ruleWrapper); //Formula execute
    }

  }

  @Override
  public RulesEngineTypeEnum getType() {
    return RulesEngineTypeEnum.SIMPLE;
  }
}
