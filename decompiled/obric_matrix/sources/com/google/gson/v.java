package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum v extends Enum<v> implements w {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v f7104f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v f7105g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v f7106h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v f7107i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ v[] f7108j = null;

    final enum a extends v {
        a(String r2, int r3) {
            super(r2, r3, null);
        }

        @Override // com.google.gson.w
        public /* bridge */ /* synthetic */ Number a(com.google.gson.a0.a r1) {
            return b(r1);
        }

        public Double b(com.google.gson.a0.a r1) {
            return Double.valueOf(r1.S());
        }
    }

    static {
        a r0 = new a("DOUBLE", 0);
        f7104f = r0;
        final String r3 = "LAZILY_PARSED_NUMBER";
        final int r4 = 1;
        v r1 = new b(r3, r4);
        f7105g = r1;
        final String r5 = "LONG_OR_DOUBLE";
        final int r6 = 2;
        v r7 = new c(r5, r6);
        f7106h = r7;
        final String r8 = "BIG_DECIMAL";
        final int r9 = 3;
        v r10 = new d(r8, r9);
        f7107i = r10;
        f7108j = new v[]{r0, r1, r7, r10};
    }

    private v(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ v(String r1, int r2, a r3) {
        this(r1, r2);
    }

    public static v valueOf(String r1) {
        return (v) Enum.valueOf(v.class, r1);
    }

    public static v[] values() {
        return (v[]) f7108j.clone();
    }
}
