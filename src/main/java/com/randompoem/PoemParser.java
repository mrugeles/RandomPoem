package com.randompoem;

import com.randompoem.model.PoemRule;
import com.randompoem.model.RuleProvider;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by mario on 2/6/16.
 */
public class PoemParser {

    public static PoemRule loadPoem(Scanner sc) throws RuleException {
        HashMap<String, PoemRule> poemRules = new HashMap<String, PoemRule>();
        int line = 0;
        while (sc.hasNextLine()){
            String fileLine = sc.nextLine();
            if(fileLine.matches("(([\\w+\\W]+)): ([\\w+\\W|<>\\$ ]+)")){
                String[] lineRule = fileLine.split(":");
                PoemRule rule = new PoemRule(lineRule[0].trim(), lineRule[1].trim());
                poemRules.put(rule.getRuleKey(), rule);
            }else{
                throw new RuleException(String.format("Invalid rule format, line: %d", line));
            }
            line++;
        }
        RuleProvider.getInstance().setRules(poemRules);
        return poemRules.get("POEM");
    }

}
