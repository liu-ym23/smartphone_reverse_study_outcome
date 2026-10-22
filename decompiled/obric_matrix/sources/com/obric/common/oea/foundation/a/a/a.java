package com.obric.common.oea.foundation.a.a;

/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f8157f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f8158g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f8159h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f8160i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f8161j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ a[] f8162k = null;

    static {
        a r1 = new a("QUADRATIC", 0);
        f8157f = r1;
        a r2 = new a("SKETCH", 1);
        f8158g = r2;
        a r3 = new a("FIGMA", 2);
        f8159h = r3;
        a r4 = new a("BASIC", 3);
        f8160i = r4;
        a r5 = new a("QUADRATIC_CAPSULE", 4);
        f8161j = r5;
        f8162k = new a[]{r1, r2, r3, r4, r5};
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    public static a valueOf(String r1) {
        return (a) Enum.valueOf(a.class, r1);
    }

    public static a[] values() {
        return (a[]) f8162k.clone();
    }
}
