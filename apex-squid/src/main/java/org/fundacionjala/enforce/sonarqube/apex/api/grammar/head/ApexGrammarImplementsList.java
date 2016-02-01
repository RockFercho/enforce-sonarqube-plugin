/*
 * The MIT License
 *
 * Copyright 2016 Jalasoft.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.fundacionjala.enforce.sonarqube.apex.api.grammar.head;

import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.RuleKey.IDENTIFIER;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.RuleKey.IMPLEMENTS;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.RuleKey.IMPLEMENTS_LIST;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.RuleKey.MERGE_TYPE_IMPLEMENTS;
import org.sonar.sslr.grammar.LexerlessGrammarBuilder;

/**
 * The class creates the rule for a class can implement another class.
 */
public class ApexGrammarImplementsList {

    private final static String RULE_IMPLEMENTS_KEYWORD = "implements";
    private final static String RULE_EMPTY_KEYWORD = "";

    /**
     * Grammar is created to implement another class or not.
     *
     * @return The grammar to implement otherwise.
     */
    public static LexerlessGrammarBuilder createGrammarBuilder() {
        LexerlessGrammarBuilder grammarBuilder = LexerlessGrammarBuilder.create();
        grammarBuilder.rule(IMPLEMENTS).is(RULE_IMPLEMENTS_KEYWORD);
        grammarBuilder.rule(MERGE_TYPE_IMPLEMENTS).is(IMPLEMENTS,
                ApexGrammarIdentifier.createGrammarBuilder().build()
                .rule(IDENTIFIER));
        grammarBuilder.rule(IMPLEMENTS_LIST).is(grammarBuilder.firstOf(MERGE_TYPE_IMPLEMENTS, RULE_EMPTY_KEYWORD));

        return grammarBuilder;
    }
}
