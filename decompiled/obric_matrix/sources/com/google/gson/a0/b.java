package com.google.gson.a0;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f6869f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f6870g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f6871h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f6872i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f6873j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f6874k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f6875l = null;
    public static final b m = null;
    public static final b n = null;
    public static final b o = null;
    private static final /* synthetic */ b[] p = null;

    static {
        b r0 = new b("BEGIN_ARRAY", 0);
        f6869f = r0;
        b r1 = new b("END_ARRAY", 1);
        f6870g = r1;
        b r3 = new b("BEGIN_OBJECT", 2);
        f6871h = r3;
        b r5 = new b("END_OBJECT", 3);
        f6872i = r5;
        b r7 = new b("NAME", 4);
        f6873j = r7;
        b r9 = new b("STRING", 5);
        f6874k = r9;
        b r11 = new b("NUMBER", 6);
        f6875l = r11;
        b r13 = new b("BOOLEAN", 7);
        m = r13;
        b r15 = new b("NULL", 8);
        n = r15;
        b r14 = new b("END_DOCUMENT", 9);
        o = r14;
        p = new b[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
    }

    private b(String r1, int r2) {
        super(r1, r2);
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) p.clone();
    }
}
