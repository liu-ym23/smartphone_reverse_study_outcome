package com.google.zxing.oned.rss;

/* JADX INFO: loaded from: classes4.dex */
final class Pair extends DataCharacter {
    private int count;
    private final FinderPattern finderPattern;

    Pair(int r1, int r2, FinderPattern r3) {
        super(r1, r2);
        this.finderPattern = r3;
    }

    FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    int getCount() {
        return this.count;
    }

    void incrementCount() {
        this.count++;
    }
}
