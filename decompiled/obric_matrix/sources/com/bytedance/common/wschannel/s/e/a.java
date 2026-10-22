package com.bytedance.common.wschannel.s.e;

/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f3689f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f3690g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f3691h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f3692i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ a[] f3693j = null;

    static {
        a r0 = new a("STATE_FOREGROUND", 0);
        f3689f = r0;
        a r1 = new a("STATE_BACKGROUND", 1);
        f3690g = r1;
        a r3 = new a("STATE_LIGHT_DOZE", 2);
        f3691h = r3;
        a r5 = new a("STATE_DOZE", 3);
        f3692i = r5;
        f3693j = new a[]{r0, r1, r3, r5};
    }

    private a(String r1, int r2) {
        super(r1, r2);
    }

    public static a valueOf(String r1) {
        return (a) Enum.valueOf(a.class, r1);
    }

    public static a[] values() {
        return (a[]) f3693j.clone();
    }
}
