package android.icu.text;

import java.text.CharacterIterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class SearchIterator {
    public static final int DONE = -1;
    protected BreakIterator breakIterator;
    protected int matchLength;
    protected CharacterIterator targetText;

    public static final enum ElementComparisonType extends Enum<ElementComparisonType> {
        private static final /* synthetic */ ElementComparisonType[] $VALUES = null;
        public static final ElementComparisonType ANY_BASE_WEIGHT_IS_WILDCARD = null;
        public static final ElementComparisonType PATTERN_BASE_WEIGHT_IS_WILDCARD = null;
        public static final ElementComparisonType STANDARD_ELEMENT_COMPARISON = null;

        public static ElementComparisonType valueOf(String r1) {
            return (ElementComparisonType) Enum.valueOf(ElementComparisonType.class, r1);
        }

        public static ElementComparisonType[] values() {
            return (ElementComparisonType[]) $VALUES.clone();
        }

        private ElementComparisonType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            ElementComparisonType r0 = new ElementComparisonType("STANDARD_ELEMENT_COMPARISON", 0);
            STANDARD_ELEMENT_COMPARISON = r0;
            ElementComparisonType r1 = new ElementComparisonType("PATTERN_BASE_WEIGHT_IS_WILDCARD", 1);
            PATTERN_BASE_WEIGHT_IS_WILDCARD = r1;
            ElementComparisonType r3 = new ElementComparisonType("ANY_BASE_WEIGHT_IS_WILDCARD", 2);
            ANY_BASE_WEIGHT_IS_WILDCARD = r3;
            $VALUES = new ElementComparisonType[]{r0, r1, r3};
        }
    }

    public abstract int getIndex();

    protected abstract int handleNext(int r1);

    protected abstract int handlePrevious(int r1);

    protected SearchIterator(CharacterIterator r1, BreakIterator r2) {
        throw new RuntimeException("Stub!");
    }

    public void setIndex(int r1) {
        throw new RuntimeException("Stub!");
    }

    public void setOverlapping(boolean r1) {
        throw new RuntimeException("Stub!");
    }

    public void setBreakIterator(BreakIterator r1) {
        throw new RuntimeException("Stub!");
    }

    public void setTarget(CharacterIterator r1) {
        throw new RuntimeException("Stub!");
    }

    public int getMatchStart() {
        throw new RuntimeException("Stub!");
    }

    public int getMatchLength() {
        throw new RuntimeException("Stub!");
    }

    public BreakIterator getBreakIterator() {
        throw new RuntimeException("Stub!");
    }

    public CharacterIterator getTarget() {
        throw new RuntimeException("Stub!");
    }

    public String getMatchedText() {
        throw new RuntimeException("Stub!");
    }

    public int next() {
        throw new RuntimeException("Stub!");
    }

    public int previous() {
        throw new RuntimeException("Stub!");
    }

    public boolean isOverlapping() {
        throw new RuntimeException("Stub!");
    }

    public void reset() {
        throw new RuntimeException("Stub!");
    }

    public final int first() {
        throw new RuntimeException("Stub!");
    }

    public final int following(int r1) {
        throw new RuntimeException("Stub!");
    }

    public final int last() {
        throw new RuntimeException("Stub!");
    }

    public final int preceding(int r1) {
        throw new RuntimeException("Stub!");
    }

    protected void setMatchLength(int r1) {
        throw new RuntimeException("Stub!");
    }

    public void setElementComparisonType(ElementComparisonType r1) {
        throw new RuntimeException("Stub!");
    }

    public ElementComparisonType getElementComparisonType() {
        throw new RuntimeException("Stub!");
    }
}
