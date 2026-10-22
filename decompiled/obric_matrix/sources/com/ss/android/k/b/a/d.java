package com.ss.android.k.b.a;

/* JADX INFO: loaded from: classes2.dex */
final enum d extends Enum<d> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f11959f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f11960g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f11961h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ d[] f11962i = null;

    static {
        d r0 = new d("GRANTED", 0);
        f11959f = r0;
        d r1 = new d("DENIED", 1);
        f11960g = r1;
        d r3 = new d("NOT_FOUND", 2);
        f11961h = r3;
        f11962i = new d[]{r0, r1, r3};
    }

    private d(String r1, int r2) {
        super(r1, r2);
    }

    public static d valueOf(String r1) {
        return (d) Enum.valueOf(d.class, r1);
    }

    public static d[] values() {
        return (d[]) f11962i.clone();
    }
}
