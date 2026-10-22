package com.google.gson.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f7041a = 0;

    static {
        f7041a = a();
    }

    private static int a() {
        return c(System.getProperty("java.version"));
    }

    private static int b(String r4) {
        StringBuilder r0 = new StringBuilder();     // Catch: NumberFormatException -> L10
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L8;
        char r2 = r4.charAt(r1);     // Catch: NumberFormatException -> L10
        if (Character.isDigit(r2) == false) goto L8;
        r0.append(r2);     // Catch: NumberFormatException -> L10
        r1 = r1 + 1;     // Catch: NumberFormatException -> L10
    L8:
        return Integer.parseInt(r0.toString());
    L10:
        return -1;
    }

    static int c(String r2) {
        int r0 = e(r2);
        if (r0 != (-1)) goto L5;
        r0 = b(r2);
    L5:
        if (r0 != (-1)) goto L8;
        return 6;
    L8:
        return r0;
    }

    public static boolean d() {
        if (f7041a < 9) goto L5;
        return true;
    L5:
        return false;
    }

    private static int e(String r3) {
        String[] r4 = r3.split("[._]");     // Catch: NumberFormatException -> L9
        int r0 = Integer.parseInt(r4[0]);     // Catch: NumberFormatException -> L9
        if (r0 == 1) goto L5;
    L8:
        return r0;
    L5:
        if (r4.length <= 1) goto L8;
        return Integer.parseInt(r4[1]);
    L9:
        return -1;
    }
}
