package com.obric.oui.titlebar;

/* JADX INFO: loaded from: classes2.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f11543g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ a[] f11544h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f11545f;

    static {
        a r1 = new a("FIXED_CENTER", 0, 0);
        f11543g = r1;
        f11544h = new a[]{r1, new a("FLOW_WITH_ACTION", 1, 1), new a("LEFT_IN_ACTION", 2, 2)};
    }

    private a(String r1, int r2, int r3) {
        super(r1, r2);
        this.f11545f = r3;
    }

    public static a valueOf(String r1) {
        return (a) Enum.valueOf(a.class, r1);
    }

    public static a[] values() {
        return (a[]) f11544h.clone();
    }

    public final int a() {
        return this.f11545f;
    }
}
