package com.bytedance.retrofit2.client;

/* JADX INFO: loaded from: classes3.dex */
public final class Header {
    private final String name;
    private final String value;

    public Header(String r1, String r2) {
        this.name = r1;
        this.value = r2;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L27:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L27;
        Header r6 = (Header) r5;
        String r2 = this.name;
        if (r2 == null) goto L16;
        if (r2.equals(r6.name) == false) goto L17;
    L18:
        String r4 = this.value;
        if (r4 == null) goto L24;
        if (r4.equals(r6.value) == false) goto L25;
    L26:
        return true;
    L25:
        return false;
    L24:
        if (r6.value == null) goto L26;
    L17:
        return false;
    L16:
        if (r6.name == null) goto L18;
        goto L17
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.value;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.name;
        String r2 = "";
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        StringBuilder r3 = r0.append(r1).append(": ");
        String r4 = this.value;
        if (r4 == null) goto L10;
        r2 = r4;
    L10:
        return r3.append(r2).toString();
    }
}
