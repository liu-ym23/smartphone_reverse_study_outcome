package com.ss.android;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11864b;

    public f(String r1, String r2) {
        this.f11863a = r1;
        this.f11864b = r2;
    }

    public String a() {
        return this.f11863a;
    }

    public String b() {
        return this.f11864b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L27:
        return false;
    L8:
        if (f.class != r5.getClass()) goto L27;
        f r6 = (f) r5;
        String r2 = this.f11863a;
        if (r2 == null) goto L16;
        if (r2.equals(r6.f11863a) == false) goto L17;
    L18:
        String r4 = this.f11864b;
        if (r4 == null) goto L24;
        if (r4.equals(r6.f11864b) == false) goto L25;
    L26:
        return true;
    L25:
        return false;
    L24:
        if (r6.f11864b == null) goto L26;
    L17:
        return false;
    L16:
        if (r6.f11863a == null) goto L18;
        goto L17
    }

    public int hashCode() {
        String r0 = this.f11863a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f11864b;
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
        String r1 = this.f11863a;
        String r2 = "";
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        r0.append(r1);
        r0.append(": ");
        String r3 = this.f11864b;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.append(r2);
        return r0.toString();
    }
}
