package com.randompoem.model;

import com.randompoem.RuleException;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by mario on 2/6/16.
 */
public class PoemRule {

    private String ruleKey = "";


    private ArrayList<String[]> definitionList = new ArrayList<String[]>();

    public PoemRule(String ruleKey, String ruleDefinition) {
        this.ruleKey = ruleKey;
        initRuleDefinitions(ruleDefinition);
    }

    private void initRuleDefinitions(String ruleDefinition) {
        String[] splitDefinition = ruleDefinition.split(" ");
        for (String groupValues: splitDefinition) {
            String[] values = groupValues.split("\\|");
            definitionList.add(values);
        }
    }

    public String getRuleKey() {
        return ruleKey;
    }

    public ArrayList<String[]> getDefinitionList() {
        return definitionList;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public String getRuleValue() throws RuleException {
        StringBuilder sb = new StringBuilder();
        for (String[] arrayValues:this.definitionList) {
            String value = getRandomValue(arrayValues);
            sb.append(parseValue(value));
        }

        return sb.toString();
    }

    private String parseValue(String value) throws RuleException {
        if(value.matches(RuleProvider.RULE_DEFINITION)){
            PoemRule poemRule = RuleProvider.getInstance().getRule(value);
            return poemRule.getRuleValue();
        }
        if(value.matches(RuleProvider.KEYWORD_DEFINITION)){
            return value.equals("$LINEBREAK")?"\n":"";
        }
        return String.format("%s ", value);
    }

    public ArrayList<String> getRuleWords() throws RuleException {
        ArrayList<String> wordList = new ArrayList<String>();
        for (String[] arrayValues:this.definitionList) {
            for (String value: arrayValues) {
                if(!value.matches(RuleProvider.RULE_DEFINITION) && !value.matches(RuleProvider.KEYWORD_DEFINITION)){
                    wordList.add(value);
                }

            }
        }
        return wordList;
    }

    private String getRandomValue(String[] arrayValues) throws RuleException {
        if (arrayValues != null && arrayValues.length > 0) {
            Random randomIndex = new Random();
            return arrayValues[randomIndex.nextInt(arrayValues.length)];
        }
        return "";
    }
}
