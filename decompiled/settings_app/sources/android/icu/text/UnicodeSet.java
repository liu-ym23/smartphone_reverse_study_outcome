package android.icu.text;

import android.icu.util.Freezable;
import java.text.ParsePosition;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class UnicodeSet extends UnicodeFilter implements Iterable<String>, Comparable<UnicodeSet>, Freezable<UnicodeSet> {
    public static final int ADD_CASE_MAPPINGS = 4;
    public static final UnicodeSet ALL_CODE_POINTS = null;
    public static final int CASE = 2;
    public static final int CASE_INSENSITIVE = 2;
    public static final UnicodeSet EMPTY = null;
    public static final int IGNORE_SPACE = 1;
    public static final int MAX_VALUE = 1114111;
    public static final int MIN_VALUE = 0;

    public static final enum ComparisonStyle extends Enum<ComparisonStyle> {
        private static final /* synthetic */ ComparisonStyle[] $VALUES = null;
        public static final ComparisonStyle LEXICOGRAPHIC = null;
        public static final ComparisonStyle LONGER_FIRST = null;
        public static final ComparisonStyle SHORTER_FIRST = null;

        public static ComparisonStyle valueOf(String r1) {
            return (ComparisonStyle) Enum.valueOf(ComparisonStyle.class, r1);
        }

        public static ComparisonStyle[] values() {
            return (ComparisonStyle[]) $VALUES.clone();
        }

        private ComparisonStyle(String r1, int r2) {
            super(r1, r2);
        }

        static {
            ComparisonStyle r0 = new ComparisonStyle("SHORTER_FIRST", 0);
            SHORTER_FIRST = r0;
            ComparisonStyle r1 = new ComparisonStyle("LEXICOGRAPHIC", 1);
            LEXICOGRAPHIC = r1;
            ComparisonStyle r3 = new ComparisonStyle("LONGER_FIRST", 2);
            LONGER_FIRST = r3;
            $VALUES = new ComparisonStyle[]{r0, r1, r3};
        }
    }

    public static class EntryRange {
        public int codepoint;
        public int codepointEnd;

        EntryRange() {
            throw new RuntimeException("Stub!");
        }

        public String toString() {
            throw new RuntimeException("Stub!");
        }
    }

    public static final enum SpanCondition extends Enum<SpanCondition> {
        private static final /* synthetic */ SpanCondition[] $VALUES = null;
        public static final SpanCondition CONDITION_COUNT = null;
        public static final SpanCondition CONTAINED = null;
        public static final SpanCondition NOT_CONTAINED = null;
        public static final SpanCondition SIMPLE = null;

        public static SpanCondition valueOf(String r1) {
            return (SpanCondition) Enum.valueOf(SpanCondition.class, r1);
        }

        public static SpanCondition[] values() {
            return (SpanCondition[]) $VALUES.clone();
        }

        private SpanCondition(String r1, int r2) {
            super(r1, r2);
        }

        static {
            SpanCondition r0 = new SpanCondition("NOT_CONTAINED", 0);
            NOT_CONTAINED = r0;
            SpanCondition r1 = new SpanCondition("CONTAINED", 1);
            CONTAINED = r1;
            SpanCondition r3 = new SpanCondition("SIMPLE", 2);
            SIMPLE = r3;
            SpanCondition r5 = new SpanCondition("CONDITION_COUNT", 3);
            CONDITION_COUNT = r5;
            $VALUES = new SpanCondition[]{r0, r1, r3, r5};
        }
    }

    static {
    }

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ UnicodeSet cloneAsThawed() {
        return cloneAsThawed();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UnicodeSet r1) {
        return compareTo2(r1);
    }

    @Override // android.icu.util.Freezable
    public /* bridge */ /* synthetic */ UnicodeSet freeze() {
        return freeze();
    }

    public UnicodeSet() {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet(int... r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet(String r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet(String r1, boolean r2) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet(String r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet(String r1, ParsePosition r2, SymbolTable r3) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet(String r1, ParsePosition r2, SymbolTable r3, int r4) {
        throw new RuntimeException("Stub!");
    }

    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet set(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet set(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet applyPattern(String r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet applyPattern(String r1, boolean r2) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet applyPattern(String r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.UnicodeMatcher
    public String toPattern(boolean r1) {
        throw new RuntimeException("Stub!");
    }

    public StringBuffer _generatePattern(StringBuffer r1, boolean r2) {
        throw new RuntimeException("Stub!");
    }

    public StringBuffer _generatePattern(StringBuffer r1, boolean r2, boolean r3) {
        throw new RuntimeException("Stub!");
    }

    public int size() {
        throw new RuntimeException("Stub!");
    }

    public boolean isEmpty() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.UnicodeMatcher
    public boolean matchesIndexValue(int r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.UnicodeFilter, android.icu.text.UnicodeMatcher
    public int matches(Replaceable r1, int[] r2, int r3, boolean r4) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.UnicodeMatcher
    public void addMatchSetTo(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public int indexOf(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int charAt(int r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet add(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet addAll(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet add(int r1) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet add(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet addAll(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet retainAll(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet complementAll(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet removeAll(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet removeAllStrings() {
        throw new RuntimeException("Stub!");
    }

    public static UnicodeSet from(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public static UnicodeSet fromAll(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet retain(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet retain(int r1) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet retain(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet remove(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet remove(int r1) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet remove(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet complement(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet complement(int r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet complement() {
        throw new RuntimeException("Stub!");
    }

    public final UnicodeSet complement(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.text.UnicodeFilter
    public boolean contains(int r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean contains(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public final boolean contains(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean containsAll(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean containsAll(String r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean containsNone(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public boolean containsNone(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean containsNone(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public final boolean containsSome(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public final boolean containsSome(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public final boolean containsSome(CharSequence r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet addAll(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet retainAll(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet removeAll(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet complementAll(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet clear() {
        throw new RuntimeException("Stub!");
    }

    public int getRangeCount() {
        throw new RuntimeException("Stub!");
    }

    public int getRangeStart(int r1) {
        throw new RuntimeException("Stub!");
    }

    public int getRangeEnd(int r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet compact() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public <T extends Collection<String>> T addAllTo(T r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet add(Iterable<?> r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet addAll(Iterable<?> r1) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet applyIntPropertyValue(int r1, int r2) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet applyPropertyAlias(String r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet applyPropertyAlias(String r1, String r2, SymbolTable r3) {
        throw new RuntimeException("Stub!");
    }

    public UnicodeSet closeOver(int r1) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.icu.util.Freezable
    public boolean isFrozen() {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public UnicodeSet freeze() {
        throw new RuntimeException("Stub!");
    }

    public int span(CharSequence r1, SpanCondition r2) {
        throw new RuntimeException("Stub!");
    }

    public int span(CharSequence r1, int r2, SpanCondition r3) {
        throw new RuntimeException("Stub!");
    }

    public int spanBack(CharSequence r1, SpanCondition r2) {
        throw new RuntimeException("Stub!");
    }

    public int spanBack(CharSequence r1, int r2, SpanCondition r3) {
        throw new RuntimeException("Stub!");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.icu.util.Freezable
    public UnicodeSet cloneAsThawed() {
        throw new RuntimeException("Stub!");
    }

    public Iterable<EntryRange> ranges() {
        throw new RuntimeException("Stub!");
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        throw new RuntimeException("Stub!");
    }

    public <T extends CharSequence> boolean containsAll(Iterable<T> r1) {
        throw new RuntimeException("Stub!");
    }

    public <T extends CharSequence> boolean containsNone(Iterable<T> r1) {
        throw new RuntimeException("Stub!");
    }

    public final <T extends CharSequence> boolean containsSome(Iterable<T> r1) {
        throw new RuntimeException("Stub!");
    }

    public <T extends CharSequence> UnicodeSet addAll(T... r1) {
        throw new RuntimeException("Stub!");
    }

    public <T extends CharSequence> UnicodeSet removeAll(Iterable<T> r1) {
        throw new RuntimeException("Stub!");
    }

    public <T extends CharSequence> UnicodeSet retainAll(Iterable<T> r1) {
        throw new RuntimeException("Stub!");
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UnicodeSet r1) {
        throw new RuntimeException("Stub!");
    }

    public int compareTo(UnicodeSet r1, ComparisonStyle r2) {
        throw new RuntimeException("Stub!");
    }

    public int compareTo(Iterable<String> r1) {
        throw new RuntimeException("Stub!");
    }

    public Collection<String> strings() {
        throw new RuntimeException("Stub!");
    }
}
