package com.randompoem;

import com.randompoem.model.PoemRule;
import com.randompoem.model.RuleProvider;
import junit.framework.TestCase;

import java.util.HashMap;

/**
 * Created by mario on 2/6/16.
 */
public class RuleProviderTest extends TestCase {
    public void testPoemRuleAccess(){
        HashMap<String, PoemRule> poemRules = new HashMap<String, PoemRule>();
        PoemRule someRule = new PoemRule("SOMERULE", "RULE DEFINITIONS");
        poemRules.put("SOMERULE", someRule);
        RuleProvider.setRules(poemRules);
        PoemRule result = null;
        try {
            result = RuleProvider.getRule ("SOMERULE");
        } catch (RuleException e) {
            fail(e.getMessage());
        }
        assertNotNull(result);
    }
}
