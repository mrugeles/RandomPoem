package com.randompoem.model;

import com.randompoem.RuleException;

import java.util.HashMap;

public class RuleProvider {
    private static RuleProvider singleton = new RuleProvider( );

    private HashMap<String, PoemRule> poemRules = null;
    private HashMap<String, String> KEYWORDS_VALUES = null;

    public static final String RULE_DEFINITION = "^<\\w+>$";
    public static final String KEYWORD_DEFINITION = "^(\\$)\\w+";

    private RuleProvider(){ }

    public static RuleProvider getInstance( ) {
        return singleton;
    }

    public void setRules(HashMap<String, PoemRule> rules){
        if(poemRules == null){
            poemRules = rules;
        }
    }


    public PoemRule getRule(String key) throws RuleException {
        key = key.replaceAll("[<>]", "");
        if(poemRules.containsKey(key)){
            return poemRules.get(key);
        } else {
            throw new RuleException(String.format("Rule Not Found:%s ", key));
        }
    }
}
