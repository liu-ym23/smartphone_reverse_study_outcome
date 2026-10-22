package com.bytedance.common.wschannel;

/* JADX INFO: loaded from: classes.dex */
public final enum i extends Enum<i> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f3529g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f3530h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final i f3531i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final i f3532j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final i f3533k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ i[] f3534l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f3535f;

    static {
        i r0 = new i("TUDP", 0, 0);
        f3529g = r0;
        i r1 = new i("TLS", 1, 1);
        f3530h = r1;
        i r3 = new i("HTTP2", 2, 2);
        f3531i = r3;
        i r5 = new i("TUDP_PROXY", 3, 3);
        f3532j = r5;
        i r7 = new i("TLS_PROXY", 4, 4);
        f3533k = r7;
        f3534l = new i[]{r0, r1, r3, r5, r7};
    }

    private i(String r1, int r2, int r3) {
        super(r1, r2);
        this.f3535f = r3;
    }

    public static i valueOf(String r1) {
        return (i) Enum.valueOf(i.class, r1);
    }

    public static i[] values() {
        return (i[]) f3534l.clone();
    }

    public int a() {
        return this.f3535f;
    }
}
