package com.randompoem;

import com.randompoem.model.PoemRule;
import com.randompoem.model.RuleProvider;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws RuleException {
        HashMap<String, PoemRule> poemRules = new HashMap<String, PoemRule>();
        PoemRule poem = new PoemRule("POEM", "<LINE> <LINE> <LINE> <LINE> <LINE>");
        PoemRule line = new PoemRule("LINE", "<NOUN>|<PREPOSITION>|<PRONOUN> $LINEBREAK");
        PoemRule adjective = new PoemRule("ADJECTIVE", "black|white|dark|light|bright|murky|muddy|clear <NOUN>|<ADJECTIVE>|$END");
        PoemRule noun = new PoemRule("NOUN", "<VERB>|<PREPOSITION>|$END");
        PoemRule pronoun = new PoemRule("PRONOUN", "my|your|his|her <NOUN>|<ADJECTIVE>");
        PoemRule verb = new PoemRule("VERB", "runs|walks|stands|climbs|crawls|flows|flies|transcends|ascends|descends|sinks <PREPOSITION>|<PRONOUN>|$END");
        PoemRule preposition = new PoemRule("PREPOSITION", "above|across|against|along|among|around|before|behind|beneath|beside|between|beyond|during|inside|onto|outside|under|underneath|upon|with|without|through <NOUN>|<PRONOUN>|<ADJECTIVE>");
        PoemRule end = new PoemRule("$END", "");
        PoemRule lineBreak = new PoemRule("$LINEBREAK", "\n");

        poemRules.put("POEM", poem);
        poemRules.put("LINE", line);
        poemRules.put("ADJECTIVE", adjective);
        poemRules.put("NOUN", noun);
        poemRules.put("PRONOUN", pronoun);
        poemRules.put("VERB", verb);
        poemRules.put("PREPOSITION", preposition);
        poemRules.put("$END", end);
        poemRules.put("$LINEBREAK", lineBreak);

        RuleProvider.setRules(poemRules);
        System.out.println(poem.getRuleValue());
    }
}
