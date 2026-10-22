package com.google.common.base;

import android.icu.util.ULocale;
import java.util.Arrays;
import java.util.BitSet;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class CharMatcher implements Predicate<Character> {
    private static final int DISTINCT_CHARS = 65536;

    private static final class And extends CharMatcher {
        final CharMatcher first;
        final CharMatcher second;

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return super.apply2(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return super.negate();
        }

        And(CharMatcher r1, CharMatcher r2) {
            this.first = (CharMatcher) Preconditions.checkNotNull(r1);
            this.second = (CharMatcher) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r2) {
            if (this.first.matches(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.second.matches(r2) == false) goto L7;
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r3) {
            BitSet r0 = new BitSet();
            this.first.setBits(r0);
            BitSet r1 = new BitSet();
            this.second.setBits(r1);
            r0.and(r1);
            r3.or(r0);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String r0 = String.valueOf(this.first);
            String r3 = String.valueOf(this.second);
            return new StringBuilder((String.valueOf(r0).length() + 19) + String.valueOf(r3).length()).append("CharMatcher.and(").append(r0).append(", ").append(r3).append(")").toString();
        }
    }

    private static final class Any extends NamedFastMatcher {
        static final Any INSTANCE = null;

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return negate();
        }

        static {
            INSTANCE = new Any();
        }

        private Any() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence r1) {
            if (r1.length() != 0) goto L5;
            return -1;
        L5:
            return 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence r1, int r2) {
            int r0 = r1.length();
            Preconditions.checkPositionIndex(r2, r0);
            if (r2 != r0) goto L6;
            return -1;
        L6:
            return r2;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(CharSequence r1) {
            return r1.length() - 1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence r1) {
            Preconditions.checkNotNull(r1);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence r1) {
            if (r1.length() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public String removeFrom(CharSequence r1) {
            Preconditions.checkNotNull(r1);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence r1, char r2) {
            char[] r0 = new char[r1.length()];
            Arrays.fill(r0, r2);
            return new String(r0);
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence r3, CharSequence r4) {
            StringBuilder r2 = new StringBuilder(r3.length() * r4.length());
            int r0 = 0;
        L4:
            if (r0 >= r3.length()) goto L7;
            r2.append(r4);
            r0 = r0 + 1;
            goto L4
        L7:
            return r2.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String collapseFrom(CharSequence r1, char r2) {
            if (r1.length() != 0) goto L6;
            return "";
        L6:
            return String.valueOf(r2);
        }

        @Override // com.google.common.base.CharMatcher
        public String trimFrom(CharSequence r1) {
            Preconditions.checkNotNull(r1);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence r1) {
            return r1.length();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher r1) {
            return (CharMatcher) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher r1) {
            Preconditions.checkNotNull(r1);
            return this;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher, java.util.function.Predicate
        public CharMatcher negate() {
            return none();
        }
    }

    private static final class AnyOf extends CharMatcher {
        private final char[] chars;

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return super.apply2(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return super.negate();
        }

        public AnyOf(CharSequence r1) {
            char[] r2 = r1.toString().toCharArray();
            this.chars = r2;
            Arrays.sort(r2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            if (Arrays.binarySearch(this.chars, r1) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r4) {
            char[] r3 = this.chars;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r4.set(r3[r1]);
            r1 = r1 + 1;
            goto L3
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder r0 = new StringBuilder("CharMatcher.anyOf(\"");
            char[] r4 = this.chars;
            int r1 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            r0.append(CharMatcher.access$100(r4[r2]));
            r2 = r2 + 1;
            goto L3
        L5:
            r0.append("\")");
            return r0.toString();
        }
    }

    private static final class Ascii extends NamedFastMatcher {
        static final Ascii INSTANCE = null;

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            if (r1 > 127) goto L5;
            return true;
        L5:
            return false;
        }

        static {
            INSTANCE = new Ascii();
        }

        Ascii() {
            super("CharMatcher.ascii()");
        }
    }

    private static final class BitSetMatcher extends NamedFastMatcher {
        private final BitSet table;

        /* synthetic */ BitSetMatcher(BitSet r1, String r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private BitSetMatcher(BitSet r2, String r3) {
            super(r3);
            if ((r2.length() + 64) >= r2.size()) goto L5;
            r2 = (BitSet) r2.clone();
        L5:
            this.table = r2;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            return this.table.get(r1);
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r1) {
            r1.or(this.table);
        }
    }

    private static final class BreakingWhitespace extends CharMatcher {
        static final CharMatcher INSTANCE = null;

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r3) {
            if (r3 != ' ') goto L5;
        L27:
            return true;
        L5:
            if (r3 == 133) goto L27;
            if (r3 == 5760) goto L27;
            if (r3 != 8199) goto L11;
            return false;
        L11:
            if (r3 == 8287) goto L27;
            if (r3 == 12288) goto L27;
            if (r3 == 8232) goto L27;
            if (r3 == 8233) goto L27;
            switch(r3) {
                case 9: goto L27;
                case 10: goto L27;
                case 11: goto L27;
                case 12: goto L27;
                case 13: goto L27;
                default: goto L20;
            };
        L20:
            if (r3 < 8192) goto L25;
            if (r3 > 8202) goto L25;
            return true;
        L25:
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }

        private BreakingWhitespace() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return super.apply2(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return super.negate();
        }

        static {
            INSTANCE = new BreakingWhitespace();
        }
    }

    private static final class Digit extends RangesMatcher {
        static final Digit INSTANCE = null;
        private static final String ZEROES = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０";

        private static char[] zeroes() {
            return ZEROES.toCharArray();
        }

        private static char[] nines() {
            char[] r1 = new char[37];
            int r2 = 0;
        L3:
            if (r2 >= 37) goto L5;
            r1[r2] = (char) (ZEROES.charAt(r2) + '\t');
            r2 = r2 + 1;
            goto L3
        L5:
            return r1;
        }

        static {
            INSTANCE = new Digit();
        }

        private Digit() {
            super("CharMatcher.digit()", zeroes(), nines());
        }
    }

    static abstract class FastMatcher extends CharMatcher {
        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }

        FastMatcher() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return super.apply2(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return negate();
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public CharMatcher negate() {
            return new NegatedFastMatcher(this);
        }
    }

    private static final class ForPredicate extends CharMatcher {
        private final Predicate<? super Character> predicate;

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return apply(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return super.negate();
        }

        ForPredicate(Predicate<? super Character> r1) {
            this.predicate = (Predicate) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            return this.predicate.apply(Character.valueOf(r1));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.CharMatcher
        public boolean apply(Character r1) {
            return this.predicate.apply(Preconditions.checkNotNull(r1));
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String r2 = String.valueOf(this.predicate);
            return new StringBuilder(String.valueOf(r2).length() + 26).append("CharMatcher.forPredicate(").append(r2).append(")").toString();
        }
    }

    private static final class InRange extends FastMatcher {
        private final char endInclusive;
        private final char startInclusive;

        InRange(char r2, char r3) {
            if (r3 < r2) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0);
            this.startInclusive = r2;
            this.endInclusive = r3;
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r2) {
            if (this.startInclusive <= r2) goto L5;
        L7:
            return false;
        L5:
            if (r2 > this.endInclusive) goto L7;
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r2) {
            r2.set(this.startInclusive, this.endInclusive + 1);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String r0 = CharMatcher.access$100(this.startInclusive);
            String r3 = CharMatcher.access$100(this.endInclusive);
            return new StringBuilder((String.valueOf(r0).length() + 27) + String.valueOf(r3).length()).append("CharMatcher.inRange('").append(r0).append("', '").append(r3).append("')").toString();
        }
    }

    private static final class Invisible extends RangesMatcher {
        static final Invisible INSTANCE = null;
        private static final String RANGE_ENDS = "  \u00ad\u0605\u061c\u06dd\u070f\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb";
        private static final String RANGE_STARTS = "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9";

        static {
            INSTANCE = new Invisible();
        }

        private Invisible() {
            super("CharMatcher.invisible()", RANGE_STARTS.toCharArray(), RANGE_ENDS.toCharArray());
        }
    }

    private static final class Is extends FastMatcher {
        private final char match;

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return negate();
        }

        Is(char r1) {
            this.match = r1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            if (r1 != this.match) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence r1, char r2) {
            return r1.toString().replace(this.match, r2);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher r2) {
            if (r2.matches(this.match) == false) goto L6;
            return this;
        L6:
            return none();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher r2) {
            if (r2.matches(this.match) == false) goto L6;
            return r2;
        L6:
            return super.or(r2);
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher, java.util.function.Predicate
        public CharMatcher negate() {
            return isNot(this.match);
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r1) {
            r1.set(this.match);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String r2 = CharMatcher.access$100(this.match);
            return new StringBuilder(String.valueOf(r2).length() + 18).append("CharMatcher.is('").append(r2).append("')").toString();
        }
    }

    private static final class IsEither extends FastMatcher {
        private final char match1;
        private final char match2;

        IsEither(char r1, char r2) {
            this.match1 = r1;
            this.match2 = r2;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r2) {
            if (r2 != this.match1) goto L5;
        L8:
            return true;
        L5:
            if (r2 == this.match2) goto L8;
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r2) {
            r2.set(this.match1);
            r2.set(this.match2);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String r0 = CharMatcher.access$100(this.match1);
            String r3 = CharMatcher.access$100(this.match2);
            return new StringBuilder((String.valueOf(r0).length() + 21) + String.valueOf(r3).length()).append("CharMatcher.anyOf(\"").append(r0).append(r3).append("\")").toString();
        }
    }

    private static final class IsNot extends FastMatcher {
        private final char match;

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return negate();
        }

        IsNot(char r1) {
            this.match = r1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            if (r1 == this.match) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher r2) {
            if (r2.matches(this.match) == true) goto L5;
            return r2;
        L5:
            return super.and(r2);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher r2) {
            if (r2.matches(this.match) == true) goto L5;
            return this;
        L5:
            return any();
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r3) {
            r3.set(0, this.match);
            r3.set(this.match + 1, 65536);
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher, java.util.function.Predicate
        public CharMatcher negate() {
            return is(this.match);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String r2 = CharMatcher.access$100(this.match);
            return new StringBuilder(String.valueOf(r2).length() + 21).append("CharMatcher.isNot('").append(r2).append("')").toString();
        }
    }

    private static final class JavaDigit extends CharMatcher {
        static final JavaDigit INSTANCE = null;

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaDigit()";
        }

        private JavaDigit() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return super.apply2(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return super.negate();
        }

        static {
            INSTANCE = new JavaDigit();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            return Character.isDigit(r1);
        }
    }

    private static final class JavaIsoControl extends NamedFastMatcher {
        static final JavaIsoControl INSTANCE = null;

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            if (r1 > 31) goto L5;
        L10:
            return true;
        L5:
            if (r1 >= 127) goto L7;
        L9:
            return false;
        L7:
            if (r1 > 159) goto L9;
            goto L9
        }

        static {
            INSTANCE = new JavaIsoControl();
        }

        private JavaIsoControl() {
            super("CharMatcher.javaIsoControl()");
        }
    }

    private static final class JavaLetter extends CharMatcher {
        static final JavaLetter INSTANCE = null;

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetter()";
        }

        private JavaLetter() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return super.apply2(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return super.negate();
        }

        static {
            INSTANCE = new JavaLetter();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            return Character.isLetter(r1);
        }
    }

    private static final class JavaLetterOrDigit extends CharMatcher {
        static final JavaLetterOrDigit INSTANCE = null;

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }

        private JavaLetterOrDigit() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return super.apply2(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return super.negate();
        }

        static {
            INSTANCE = new JavaLetterOrDigit();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            return Character.isLetterOrDigit(r1);
        }
    }

    private static final class JavaLowerCase extends CharMatcher {
        static final JavaLowerCase INSTANCE = null;

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }

        private JavaLowerCase() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return super.apply2(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return super.negate();
        }

        static {
            INSTANCE = new JavaLowerCase();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            return Character.isLowerCase(r1);
        }
    }

    private static final class JavaUpperCase extends CharMatcher {
        static final JavaUpperCase INSTANCE = null;

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }

        private JavaUpperCase() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return super.apply2(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return super.negate();
        }

        static {
            INSTANCE = new JavaUpperCase();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            return Character.isUpperCase(r1);
        }
    }

    static abstract class NamedFastMatcher extends FastMatcher {
        private final String description;

        NamedFastMatcher(String r1) {
            this.description = (String) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.CharMatcher
        public final String toString() {
            return this.description;
        }
    }

    private static class Negated extends CharMatcher {
        final CharMatcher original;

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return super.apply2(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return negate();
        }

        Negated(CharMatcher r1) {
            this.original = (CharMatcher) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            return !this.original.matches(r1);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence r1) {
            return this.original.matchesNoneOf(r1);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence r1) {
            return this.original.matchesAllOf(r1);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence r2) {
            return r2.length() - this.original.countIn(r2);
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r3) {
            BitSet r0 = new BitSet();
            this.original.setBits(r0);
            r0.flip(0, 65536);
            r3.or(r0);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public CharMatcher negate() {
            return this.original;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String r2 = String.valueOf(this.original);
            return new StringBuilder(String.valueOf(r2).length() + 9).append(r2).append(".negate()").toString();
        }
    }

    static class NegatedFastMatcher extends Negated {
        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }

        NegatedFastMatcher(CharMatcher r1) {
            super(r1);
        }
    }

    private static final class None extends NamedFastMatcher {
        static final None INSTANCE = null;

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r1) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return negate();
        }

        static {
            INSTANCE = new None();
        }

        private None() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence r1) {
            Preconditions.checkNotNull(r1);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence r1, int r2) {
            Preconditions.checkPositionIndex(r2, r1.length());
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(CharSequence r1) {
            Preconditions.checkNotNull(r1);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence r1) {
            if (r1.length() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence r1) {
            Preconditions.checkNotNull(r1);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String removeFrom(CharSequence r1) {
            return r1.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence r1, char r2) {
            return r1.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence r1, CharSequence r2) {
            Preconditions.checkNotNull(r2);
            return r1.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String collapseFrom(CharSequence r1, char r2) {
            return r1.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimFrom(CharSequence r1) {
            return r1.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimLeadingFrom(CharSequence r1) {
            return r1.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimTrailingFrom(CharSequence r1) {
            return r1.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence r1) {
            Preconditions.checkNotNull(r1);
            return 0;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher r1) {
            Preconditions.checkNotNull(r1);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher or(CharMatcher r1) {
            return (CharMatcher) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher, java.util.function.Predicate
        public CharMatcher negate() {
            return any();
        }
    }

    private static final class Or extends CharMatcher {
        final CharMatcher first;
        final CharMatcher second;

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return super.apply2(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return super.negate();
        }

        Or(CharMatcher r1, CharMatcher r2) {
            this.first = (CharMatcher) Preconditions.checkNotNull(r1);
            this.second = (CharMatcher) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r2) {
            this.first.setBits(r2);
            this.second.setBits(r2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r2) {
            if (this.first.matches(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (this.second.matches(r2) == true) goto L8;
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            String r0 = String.valueOf(this.first);
            String r3 = String.valueOf(this.second);
            return new StringBuilder((String.valueOf(r0).length() + 18) + String.valueOf(r3).length()).append("CharMatcher.or(").append(r0).append(", ").append(r3).append(")").toString();
        }
    }

    private static class RangesMatcher extends CharMatcher {
        private final String description;
        private final char[] rangeEnds;
        private final char[] rangeStarts;

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character r1) {
            return super.apply2(r1);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
            return super.negate();
        }

        RangesMatcher(String r4, char[] r5, char[] r6) {
            this.description = r4;
            this.rangeStarts = r5;
            this.rangeEnds = r6;
            if (r5.length != r6.length) goto L5;
            boolean r3 = true;
        L6:
            Preconditions.checkArgument(r3);
            int r7 = 0;
        L8:
            if (r7 >= r5.length) goto L21;
            if (r5[r7] > r6[r7]) goto L12;
            boolean r8 = true;
        L13:
            Preconditions.checkArgument(r8);
            int r9 = r7 + 1;
            if (r9 >= r5.length) goto L20;
            if (r6[r7] >= r5[r9]) goto L18;
            boolean r10 = true;
        L19:
            Preconditions.checkArgument(r10);
            goto L20
        L18:
            r10 = false;
        L20:
            r7 = r9;
            goto L8
        L12:
            r8 = false;
            goto L13
        L21:
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r3) {
            int r0 = Arrays.binarySearch(this.rangeStarts, r3);
            if (r0 < 0) goto L5;
            return true;
        L5:
            int r1 = (~r0) - 1;
            if (r1 >= 0) goto L8;
        L10:
            return false;
        L8:
            if (r3 > this.rangeEnds[r1]) goto L10;
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.description;
        }
    }

    private static final class SingleWidth extends RangesMatcher {
        static final SingleWidth INSTANCE = null;

        static {
            INSTANCE = new SingleWidth();
        }

        private SingleWidth() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    static final class Whitespace extends NamedFastMatcher {
        static final Whitespace INSTANCE = null;
        static final int MULTIPLIER = 1682554634;
        static final int SHIFT = 0;
        static final String TABLE = "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000";

        static {
            SHIFT = Integer.numberOfLeadingZeros(31);
            INSTANCE = new Whitespace();
        }

        Whitespace() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char r2) {
            if (TABLE.charAt((MULTIPLIER * r2) >>> SHIFT) != r2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet r2) {
            int r1 = 0;
        L4:
            if (r1 >= 32) goto L6;
            r2.set(TABLE.charAt(r1));
            r1 = r1 + 1;
            goto L4
        }
    }

    private static boolean isSmall(int r1, int r2) {
        if (r1 <= 1023) goto L5;
    L7:
        return false;
    L5:
        if (r2 <= ((r1 * 4) * 16)) goto L7;
        return true;
    }

    public abstract boolean matches(char r1);

    @Override // com.google.common.base.Predicate
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Character r1) {
        return apply2(r1);
    }

    @Override // java.util.function.Predicate
    public /* bridge */ /* synthetic */ java.util.function.Predicate negate() {
        return negate();
    }

    static /* synthetic */ String access$100(char r0) {
        return showCharacter(r0);
    }

    public static CharMatcher any() {
        return Any.INSTANCE;
    }

    public static CharMatcher none() {
        return None.INSTANCE;
    }

    public static CharMatcher whitespace() {
        return Whitespace.INSTANCE;
    }

    public static CharMatcher breakingWhitespace() {
        return BreakingWhitespace.INSTANCE;
    }

    public static CharMatcher ascii() {
        return Ascii.INSTANCE;
    }

    @Deprecated
    public static CharMatcher digit() {
        return Digit.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaDigit() {
        return JavaDigit.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaLetter() {
        return JavaLetter.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaLetterOrDigit() {
        return JavaLetterOrDigit.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaUpperCase() {
        return JavaUpperCase.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaLowerCase() {
        return JavaLowerCase.INSTANCE;
    }

    public static CharMatcher javaIsoControl() {
        return JavaIsoControl.INSTANCE;
    }

    @Deprecated
    public static CharMatcher invisible() {
        return Invisible.INSTANCE;
    }

    @Deprecated
    public static CharMatcher singleWidth() {
        return SingleWidth.INSTANCE;
    }

    public static CharMatcher is(char r1) {
        return new Is(r1);
    }

    public static CharMatcher isNot(char r1) {
        return new IsNot(r1);
    }

    public static CharMatcher anyOf(CharSequence r4) {
        int r0 = r4.length();
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L11;
        return new AnyOf(r4);
    L11:
        return isEither(r4.charAt(0), r4.charAt(1));
    L13:
        return is(r4.charAt(0));
    L15:
        return none();
    }

    public static CharMatcher noneOf(CharSequence r0) {
        return anyOf(r0).negate();
    }

    public static CharMatcher inRange(char r1, char r2) {
        return new InRange(r1, r2);
    }

    public static CharMatcher forPredicate(Predicate<? super Character> r1) {
        if ((r1 instanceof CharMatcher) == false) goto L6;
        return (CharMatcher) r1;
    L6:
        return new ForPredicate(r1);
    }

    protected CharMatcher() {
    }

    @Override // java.util.function.Predicate
    public CharMatcher negate() {
        return new Negated(this);
    }

    public CharMatcher and(CharMatcher r2) {
        return new And(this, r2);
    }

    public CharMatcher or(CharMatcher r2) {
        return new Or(this, r2);
    }

    public CharMatcher precomputed() {
        return Platform.precomputeCharMatcher(this);
    }

    CharMatcher precomputedInternal() {
        BitSet r0 = new BitSet();
        setBits(r0);
        int r1 = r0.cardinality();
        if ((r1 * 2) <= 65536) goto L5;
        r0.flip(0, 65536);
        int r3 = 65536 - r1;
        final String r2 = toString();
        if (r2.endsWith(".negate()") == false) goto L9;
        String r4 = r2.substring(0, r2.length() - 9);
    L13:
        final CharMatcher r5 = precomputedPositive(r3, r0, r4);
        return new AnonymousClass1(this, r5, r2);
    L9:
        String r6 = String.valueOf(r2);
        if (".negate()".length() == 0) goto L12;
        r4 = r6.concat(".negate()");
        goto L13
    L12:
        r4 = new String(r6);
        goto L13
    L5:
        return precomputedPositive(r1, r0, toString());
    }

    private static CharMatcher precomputedPositive(int r2, BitSet r3, String r4) {
        if (r2 == 0) goto L17;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L8;
        char r5 = (char) r3.nextSetBit(0);
        return isEither(r5, (char) r3.nextSetBit(r5 + 1));
    L8:
        if (isSmall(r2, r3.length()) == false) goto L11;
        return SmallCharMatcher.from(r3, r4);
    L11:
        return new BitSetMatcher(r3, r4, null);
    L15:
        return is((char) r3.nextSetBit(0));
    L17:
        return none();
    }

    void setBits(BitSet r3) {
        int r0 = 65535;
    L3:
        if (r0 < 0) goto L8;
        if (matches((char) r0) == false) goto L7;
        r3.set(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    public boolean matchesAnyOf(CharSequence r1) {
        return !matchesNoneOf(r1);
    }

    public boolean matchesAllOf(CharSequence r4) {
        int r0 = r4.length() - 1;
    L3:
        if (r0 < 0) goto L9;
        if (matches(r4.charAt(r0)) == false) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public boolean matchesNoneOf(CharSequence r1) {
        if (indexIn(r1) != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int indexIn(CharSequence r2) {
        return indexIn(r2, 0);
    }

    public int indexIn(CharSequence r3, int r4) {
        int r0 = r3.length();
        Preconditions.checkPositionIndex(r4, r0);
    L3:
        if (r4 >= r0) goto L8;
        if (matches(r3.charAt(r4)) == true) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return r4;
    L8:
        return -1;
    }

    public int lastIndexIn(CharSequence r3) {
        int r0 = r3.length() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (matches(r3.charAt(r0)) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r0;
    L8:
        return -1;
    }

    public int countIn(CharSequence r4) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r4.length()) goto L9;
        if (matches(r4.charAt(r0)) == false) goto L8;
        r1 = r1 + 1;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r1;
    }

    public String removeFrom(CharSequence r6) {
        String r7 = r6.toString();
        int r0 = indexIn(r7);
        if (r0 != (-1)) goto L5;
        return r7;
    L5:
        char[] r8 = r7.toCharArray();
        int r2 = 1;
    L6:
        r0 = r0 + 1;
    L8:
        if (r0 == r8.length) goto L10;
        if (matches(r8[r0]) == true) goto L13;
        r8[r0 - r2] = r8[r0];
        r0 = r0 + 1;
        goto L8
    L13:
        r2 = r2 + 1;
        goto L6
    L10:
        return new String(r8, 0, r0 - r2);
    }

    public String retainFrom(CharSequence r1) {
        return negate().removeFrom(r1);
    }

    public String replaceFrom(CharSequence r3, char r4) {
        String r5 = r3.toString();
        int r0 = indexIn(r5);
        if (r0 != (-1)) goto L5;
        return r5;
    L5:
        char[] r6 = r5.toCharArray();
        r6[r0] = r4;
    L6:
        r0 = r0 + 1;
        if (r0 >= r6.length) goto L12;
        if (matches(r6[r0]) == false) goto L6;
        r6[r0] = r4;
        goto L6
    L12:
        return new String(r6);
    }

    public String replaceFrom(CharSequence r8, CharSequence r9) {
        int r0 = r9.length();
        if (r0 == 0) goto L5;
        int r1 = 0;
        if (r0 == 1) goto L9;
        String r10 = r8.toString();
        int r2 = indexIn(r10);
        if (r2 != (-1)) goto L13;
        return r10;
    L13:
        int r4 = r10.length();
        StringBuilder r5 = new StringBuilder(((r4 * 3) / 2) + 16);
    L14:
        r5.append(r10, r1, r2);
        r5.append(r9);
        r1 = r2 + 1;
        r2 = indexIn(r10, r1);
        if (r2 != (-1)) goto L14;
        r5.append(r10, r1, r4);
        return r5.toString();
    L9:
        return replaceFrom(r8, r9.charAt(0));
    L5:
        return removeFrom(r8);
    }

    public String trimFrom(CharSequence r4) {
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (matches(r4.charAt(r1)) == false) goto L8;
        r1 = r1 + 1;
    L8:
        int r2 = r0 - 1;
    L9:
        if (r2 <= r1) goto L15;
        if (matches(r4.charAt(r2)) == false) goto L15;
        r2 = r2 - 1;
    L15:
        return r4.subSequence(r1, r2 + 1).toString();
    }

    public String trimLeadingFrom(CharSequence r4) {
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (matches(r4.charAt(r1)) == false) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r4.subSequence(r1, r0).toString();
    L9:
        return "";
    }

    public String trimTrailingFrom(CharSequence r3) {
        int r0 = r3.length() - 1;
    L3:
        if (r0 < 0) goto L9;
        if (matches(r3.charAt(r0)) == false) goto L7;
        r0 = r0 - 1;
        goto L3
    L7:
        return r3.subSequence(0, r0 + 1).toString();
    L9:
        return "";
    }

    public String collapseFrom(CharSequence r8, char r9) {
        int r3 = r8.length();
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L16;
        char r2 = r8.charAt(r1);
        if (matches(r2) == false) goto L14;
        if (r2 != r9) goto L13;
        if (r1 != (r3 - 1)) goto L10;
    L11:
        r1 = r1 + 1;
        goto L14
    L10:
        if (matches(r8.charAt(r1 + 1)) == false) goto L11;
    L13:
        return finishCollapseFrom(r8, r1 + 1, r3, r9, new StringBuilder(r3).append(r8, 0, r1).append(r9), true);
    L14:
        r1 = r1 + 1;
        goto L3
    L16:
        return r8.toString();
    }

    public String trimAndCollapseFrom(CharSequence r11, char r12) {
        int r0 = r11.length();
        int r1 = r0 - 1;
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L7;
        if (matches(r11.charAt(r5)) == false) goto L7;
        r5 = r5 + 1;
    L7:
        int r2 = r1;
    L8:
        if (r2 <= r5) goto L12;
        if (matches(r11.charAt(r2)) == false) goto L12;
        r2 = r2 - 1;
    L12:
        if (r5 != 0) goto L15;
        if (r2 != r1) goto L15;
        return collapseFrom(r11, r12);
    L15:
        int r6 = r2 + 1;
        return finishCollapseFrom(r11, r5, r6, r12, new StringBuilder(r6 - r5), false);
    }

    private String finishCollapseFrom(CharSequence r3, int r4, int r5, char r6, StringBuilder r7, boolean r8) {
    L2:
        if (r4 >= r5) goto L10;
        char r0 = r3.charAt(r4);
        if (matches(r0) == false) goto L7;
        if (r8 == true) goto L8;
        r7.append(r6);
        r8 = true;
    L8:
        r4 = r4 + 1;
        goto L2
    L7:
        r7.append(r0);
        r8 = false;
        goto L8
    L10:
        return r7.toString();
    }

    @Deprecated
    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public boolean apply2(Character r1) {
        return matches(r1.charValue());
    }

    public String toString() {
        return super.toString();
    }

    private static String showCharacter(char r6) {
        char[] r0 = {'\\', ULocale.UNICODE_LOCALE_EXTENSION, 0, 0, 0, 0};
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L7;
        r0[5 - r1] = "0123456789ABCDEF".charAt(r6 & 15);
        r6 = (char) (r6 >> 4);
        r1 = r1 + 1;
        goto L4
    L7:
        return String.copyValueOf(r0);
    }

    private static IsEither isEither(char r1, char r2) {
        return new IsEither(r1, r2);
    }
}
