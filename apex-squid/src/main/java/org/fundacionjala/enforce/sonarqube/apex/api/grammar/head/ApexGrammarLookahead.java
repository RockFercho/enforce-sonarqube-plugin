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

import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.ABSTRACT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.ANOTATION;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.FINAL;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.NATIVE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.PRIVATE;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.PROTECTED;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.PUBLIC;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.STATIC;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.STRICTFP;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.SYNCHRONIZED;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.TRANSIENT;
import static org.fundacionjala.enforce.sonarqube.apex.api.ApexKeyword.VOLATILE;
import static org.fundacionjala.enforce.sonarqube.apex.api.grammar.RuleKey.LOOKAHEAD;
import org.sonar.sslr.grammar.LexerlessGrammarBuilder;

/**
 * The class creates all the rules for reserved word lookahead. Example: public,
 * private, final ...
 */
public class ApexGrammarLookahead {

    /**
     * Grammar for different access modifiers of a class is created..
     *
     * @return The grammar for a lookahead.
     */
    public static LexerlessGrammarBuilder createGrammarBuilder() {
        LexerlessGrammarBuilder grammarBuilder = LexerlessGrammarBuilder.create();
        grammarBuilder.rule(PUBLIC).is(PUBLIC.getValue());
        grammarBuilder.rule(STATIC).is(STATIC.getValue());
        grammarBuilder.rule(PROTECTED).is(PROTECTED.getValue());
        grammarBuilder.rule(PRIVATE).is(PRIVATE.getValue());
        grammarBuilder.rule(FINAL).is(FINAL.getValue());
        grammarBuilder.rule(ABSTRACT).is(ABSTRACT.getValue());
        grammarBuilder.rule(SYNCHRONIZED).is(SYNCHRONIZED.getValue());
        grammarBuilder.rule(NATIVE).is(NATIVE.getValue());
        grammarBuilder.rule(TRANSIENT).is(TRANSIENT.getValue());
        grammarBuilder.rule(VOLATILE).is(VOLATILE.getValue());
        grammarBuilder.rule(STRICTFP).is(STRICTFP.getValue());
        grammarBuilder.rule(ANOTATION).is(ANOTATION.getValue());
        grammarBuilder.rule(LOOKAHEAD).is(grammarBuilder.firstOf(
                PUBLIC,
                STATIC,
                PROTECTED,
                PRIVATE,
                FINAL,
                ABSTRACT,
                SYNCHRONIZED,
                NATIVE,
                TRANSIENT,
                VOLATILE,
                STRICTFP,
                ANOTATION));
        return grammarBuilder;
    }
}
