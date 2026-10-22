package com.bytedance.common.wschannel.r;

/* JADX INFO: loaded from: classes.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f3663g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f3664h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f3665i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f3666j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f3667k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ c[] f3668l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f3669f;

    static {
        c r0 = new c("CONNECTION_UNKNOWN", 0, 1);
        f3663g = r0;
        c r1 = new c("CONNECTING", 1, 2);
        f3664h = r1;
        c r4 = new c("CONNECT_FAILED", 2, 4);
        f3665i = r4;
        c r6 = new c("CONNECT_CLOSED", 3, 8);
        f3666j = r6;
        c r8 = new c("CONNECTED", 4, 16);
        f3667k = r8;
        f3668l = new c[]{r0, r1, r4, r6, r8};
    }

    private c(String r1, int r2, int r3) {
        super(r1, r2);
        this.f3669f = r3;
    }

    public static c valueOf(String r1) {
        return (c) Enum.valueOf(c.class, r1);
    }

    public static c[] values() {
        return (c[]) f3668l.clone();
    }

    public int a() {
        return this.f3669f;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ConnectionState{State=" + this.f3669f + '}';
    }
}
