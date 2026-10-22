package com.obric.oui.banner;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f10800f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f10801g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f10802h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ b[] f10803i = null;

    static {
        b r1 = new b("FILL", 0, 0);
        f10800f = r1;
        b r2 = new b("INDENT", 1, 1);
        f10801g = r2;
        b r3 = new b("TRIPTYCH", 2, 2);
        f10802h = r3;
        f10803i = new b[]{r1, r2, r3};
    }

    private b(String r1, int r2, int r3) {
        super(r1, r2);
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f10803i.clone();
    }
}
