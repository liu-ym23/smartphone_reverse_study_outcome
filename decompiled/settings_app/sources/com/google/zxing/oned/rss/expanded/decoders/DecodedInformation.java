package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes4.dex */
final class DecodedInformation extends DecodedObject {
    private final String newString;
    private final boolean remaining;
    private final int remainingValue;

    DecodedInformation(int r1, String r2) {
        super(r1);
        this.newString = r2;
        this.remaining = false;
        this.remainingValue = 0;
    }

    DecodedInformation(int r1, String r2, int r3) {
        super(r1);
        this.remaining = true;
        this.remainingValue = r3;
        this.newString = r2;
    }

    String getNewString() {
        return this.newString;
    }

    boolean isRemaining() {
        return this.remaining;
    }

    int getRemainingValue() {
        return this.remainingValue;
    }
}
