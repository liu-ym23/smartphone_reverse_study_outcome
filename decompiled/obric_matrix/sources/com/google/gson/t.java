package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum t extends Enum<t> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final t f7096f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final t f7097g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ t[] f7098h = null;

    final enum a extends t {
        a(String r2, int r3) {
            super(r2, r3, null);
        }
    }

    static {
        a r0 = new a("DEFAULT", 0);
        f7096f = r0;
        final String r3 = "STRING";
        final int r4 = 1;
        t r1 = new b(r3, r4);
        f7097g = r1;
        f7098h = new t[]{r0, r1};
    }

    private t(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ t(String r1, int r2, a r3) {
        this(r1, r2);
    }

    public static t valueOf(String r1) {
        return (t) Enum.valueOf(t.class, r1);
    }

    public static t[] values() {
        return (t[]) f7098h.clone();
    }
}
