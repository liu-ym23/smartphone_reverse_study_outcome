package com.bytedance.common.wschannel.r;

/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f3655g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f3656h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ a[] f3657i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3658f;

    static {
        a r0 = new a("CHANNEL_SELF", 0, 1);
        f3655g = r0;
        a r1 = new a("CHANNEL_OK", 1, 2);
        f3656h = r1;
        f3657i = new a[]{r0, r1};
    }

    private a(String r1, int r2, int r3) {
        super(r1, r2);
        this.f3658f = r3;
    }

    public static a b(int r1) {
        if (r1 != 1) goto L7;
        return f3655g;
    L7:
        return f3656h;
    }

    public static a valueOf(String r1) {
        return (a) Enum.valueOf(a.class, r1);
    }

    public static a[] values() {
        return (a[]) f3657i.clone();
    }

    public int a() {
        return this.f3658f;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ChannelType{Type=" + this.f3658f + '}';
    }
}
