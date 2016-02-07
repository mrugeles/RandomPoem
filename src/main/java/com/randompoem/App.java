package com.randompoem;

import com.randompoem.model.PoemRule;
import com.randompoem.model.RuleProvider;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws RuleException {
        Scanner sc = new Scanner(System.in);
        PoemRule poem = PoemParser.loadPoem(sc);
        System.out.println(poem.getRuleValue());
    }
}
