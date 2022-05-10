package com.codeusingjava.bootdrools.custom;

import org.apache.tomcat.util.digester.Rules;

import java.time.LocalDate;
import java.util.Map;

public class RulesExecutionTracker {
  Map<Rules, String> rulesExecutedToErrorMap;
  Map<Rules, LocalDate> rulesExecutedToTimeMap;
}
