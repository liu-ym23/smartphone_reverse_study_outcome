package com.google.gson;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum c extends Enum<c> implements com.google.gson.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f6884f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f6885g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f6886h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f6887i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f6888j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f6889k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f6890l = null;
    private static final /* synthetic */ c[] m = null;

    final enum a extends c {
        a(String r2, int r3) {
            super(r2, r3, null);
        }

        @Override // com.google.gson.d
        public String a(Field r1) {
            return r1.getName();
        }
    }

    static {
        a r0 = new a("IDENTITY", 0);
        f6884f = r0;
        final String r3 = "UPPER_CAMEL_CASE";
        final int r4 = 1;
        c r1 = new b(r3, r4);
        f6885g = r1;
        final String r5 = "UPPER_CAMEL_CASE_WITH_SPACES";
        final int r6 = 2;
        c r7 = new C0209c(r5, r6);
        f6886h = r7;
        final String r8 = "UPPER_CASE_WITH_UNDERSCORES";
        final int r9 = 3;
        c r10 = new d(r8, r9);
        f6887i = r10;
        final String r11 = "LOWER_CASE_WITH_UNDERSCORES";
        final int r12 = 4;
        c r13 = new e(r11, r12);
        f6888j = r13;
        final String r14 = "LOWER_CASE_WITH_DASHES";
        final int r15 = 5;
        c r16 = new f(r14, r15);
        f6889k = r16;
        final String r17 = "LOWER_CASE_WITH_DOTS";
        final int r18 = 6;
        c r19 = new g(r17, r18);
        f6890l = r19;
        m = new c[]{r0, r1, r7, r10, r13, r16, r19};
    }

    private c(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ c(String r1, int r2, a r3) {
        this(r1, r2);
    }

    static String b(String r5, char r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        char r3 = r5.charAt(r2);
        if (Character.isUpperCase(r3) == false) goto L9;
        if (r0.length() == 0) goto L9;
        r0.append(r6);
    L9:
        r0.append(r3);
        r2 = r2 + 1;
        goto L3
    L11:
        return r0.toString();
    }

    static String c(String r5) {
        int r0 = r5.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        char r3 = r5.charAt(r2);
        if (Character.isLetter(r3) == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        if (Character.isUpperCase(r3) == false) goto L9;
        return r5;
    L9:
        char r1 = Character.toUpperCase(r3);
        if (r2 != 0) goto L14;
        return r1 + r5.substring(1);
    L14:
        return r5.substring(0, r2) + r1 + r5.substring(r2 + 1);
    L16:
        return r5;
    }

    public static c valueOf(String r1) {
        return (c) Enum.valueOf(c.class, r1);
    }

    public static c[] values() {
        return (c[]) m.clone();
    }
}
