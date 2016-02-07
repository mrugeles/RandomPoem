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
}
