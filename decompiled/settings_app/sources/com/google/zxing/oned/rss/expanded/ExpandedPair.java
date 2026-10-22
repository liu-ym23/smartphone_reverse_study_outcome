package com.google.zxing.oned.rss.expanded;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

/* JADX INFO: loaded from: classes4.dex */
final class ExpandedPair {
    private final FinderPattern finderPattern;
    private final DataCharacter leftChar;
    private final boolean mayBeLast;
    private final DataCharacter rightChar;

    ExpandedPair(DataCharacter r1, DataCharacter r2, FinderPattern r3, boolean r4) {
        this.leftChar = r1;
        this.rightChar = r2;
        this.finderPattern = r3;
        this.mayBeLast = r4;
    }

    boolean mayBeLast() {
        return this.mayBeLast;
    }

    DataCharacter getLeftChar() {
        return this.leftChar;
    }

    DataCharacter getRightChar() {
        return this.rightChar;
    }

    FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    public boolean mustBeLast() {
        if (this.rightChar != null) goto L6;
        return true;
    L6:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[ ").append(this.leftChar).append(" , ").append(this.rightChar).append(" : ");
        FinderPattern r2 = this.finderPattern;
        if (r2 != null) goto L5;
        Object r3 = "null";
    L7:
        return r0.append(r3).append(" ]").toString();
    L5:
        r3 = Integer.valueOf(r2.getValue());
        goto L7
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof ExpandedPair) == true) goto L5;
        return false;
    L5:
        ExpandedPair r5 = (ExpandedPair) r4;
        if (equalsOrNull(this.leftChar, r5.leftChar) == true) goto L8;
    L13:
        return false;
    L8:
        if (equalsOrNull(this.rightChar, r5.rightChar) == false) goto L13;
        if (equalsOrNull(this.finderPattern, r5.finderPattern) == false) goto L13;
        return true;
    }

    private static boolean equalsOrNull(Object r0, Object r1) {
        if (r0 != null) goto L9;
        if (r1 != null) goto L6;
        return true;
    L6:
        return false;
    L9:
        return r0.equals(r1);
    }

    public int hashCode() {
        int r0 = hashNotNull(this.leftChar) ^ hashNotNull(this.rightChar);
        return hashNotNull(this.finderPattern) ^ r0;
    }

    private static int hashNotNull(Object r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }
}
