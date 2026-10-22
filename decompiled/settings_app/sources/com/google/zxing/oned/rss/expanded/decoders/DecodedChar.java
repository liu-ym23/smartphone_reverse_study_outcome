package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes4.dex */
final class DecodedChar extends DecodedObject {
    static final char FNC1 = '$';
    private final char value;

    DecodedChar(int r1, char r2) {
        super(r1);
        this.value = r2;
    }

    char getValue() {
        return this.value;
    }

    boolean isFNC1() {
        if (this.value != '$') goto L6;
        return true;
    L6:
        return false;
    }
}
