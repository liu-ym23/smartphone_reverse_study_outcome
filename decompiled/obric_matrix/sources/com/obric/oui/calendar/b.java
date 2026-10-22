package com.obric.oui.calendar;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f10870g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f10871h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ b[] f10872i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f10873f;

    static {
        b r0 = new b("MONTHS", 0, 6);
        f10870g = r0;
        b r1 = new b("WEEKS", 1, 1);
        f10871h = r1;
        f10872i = new b[]{r0, r1};
    }

    private b(String r1, int r2, int r3) {
        super(r1, r2);
        this.f10873f = r3;
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f10872i.clone();
    }
}
