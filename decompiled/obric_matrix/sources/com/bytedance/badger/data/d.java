package com.bytedance.badger.data;

/* JADX INFO: loaded from: classes.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f2540g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f2541h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ d[] f2542i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f2543f;

    static {
        d r1 = new d("ERROR", 0, -1);
        f2540g = r1;
        d r2 = new d("TIMEOUT", 3, 2);
        f2541h = r2;
        f2542i = new d[]{r1, new d("NO_UPDATE", 1, 0), new d("FULL", 2, 1), r2};
    }

    private d(String r1, int r2, int r3) {
        super(r1, r2);
        this.f2543f = r3;
    }

    public static d valueOf(String r1) {
        return (d) Enum.valueOf(d.class, r1);
    }

    public static d[] values() {
        return (d[]) f2542i.clone();
    }

    public final int a() {
        return this.f2543f;
    }
}
