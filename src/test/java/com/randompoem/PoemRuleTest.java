package com.randompoem;

import com.randompoem.model.PoemRule;
import com.randompoem.model.RuleProvider;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by mario on 2/6/16.
 */
public class PoemRuleTest extends TestCase{

    public void testRuleDefinition(){
        PoemRule poemRule = new PoemRule("my_rule", "red blue yellow");
        assertTrue(poemRule.getDefinitionList().get(1)[0].equals("blue"));
    }

    public void testWordRule(){
        PoemRule poemRule = new PoemRule("my_rule", "above|across|against|along|among|around|before|behind|beneath|beside|between|beyond|during|inside|onto|outside|under|underneath|upon|with|without|through <NOUN>|<PRONOUN>|<ADJECTIVE>");
        try {
            assertTrue(poemRule.getRuleWords().contains("beneath"));
        } catch (RuleException e) {
            fail(e.getMessage());
        }
    }
}
