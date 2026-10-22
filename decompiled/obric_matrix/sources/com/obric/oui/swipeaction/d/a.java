package com.obric.oui.swipeaction.d;

/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f11447f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f11448g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ a[] f11449h = null;

    static {
        a r0 = new a("Single", 0);
        f11447f = r0;
        a r1 = new a("Multiple", 1);
        f11448g = r1;
        f11449h = new a[]{r0, r1};
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    public static a valueOf(String r1) {
        return (a) Enum.valueOf(a.class, r1);
    }

    public static a[] values() {
        return (a[]) f11449h.clone();
    }
}
