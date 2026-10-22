package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ParsedResult {
    private final ParsedResultType type;

    public abstract String getDisplayResult();

    protected ParsedResult(ParsedResultType r1) {
        this.type = r1;
    }

    public final ParsedResultType getType() {
        return this.type;
    }

    public final String toString() {
        return getDisplayResult();
    }

    public static void maybeAppend(String r1, StringBuilder r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.isEmpty() == false) goto L6;
        return;
    L6:
        if (r2.length() <= 0) goto L8;
        r2.append('\n');
    L8:
        r2.append(r1);
    }

    public static void maybeAppend(String[] r3, StringBuilder r4) {
        if (r3 == null) goto L6;
        int r0 = r3.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L8;
        maybeAppend(r3[r1], r4);
        r1 = r1 + 1;
        goto L4
    L8:
        return;
    }
}
