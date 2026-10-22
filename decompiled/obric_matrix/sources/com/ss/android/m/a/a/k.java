package com.ss.android.m.a.a;

/* JADX INFO: loaded from: classes2.dex */
public final enum k extends Enum<k> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k f12171f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f12172g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f12173h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f12174i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k f12175j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final k f12176k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ k[] f12177l = null;

    static {
        k r0 = new k("IO", 0);
        f12171f = r0;
        k r1 = new k("DEFAULT", 1);
        f12172g = r1;
        k r3 = new k("BACKGROUND", 2);
        f12173h = r3;
        k r5 = new k("SCHEDULED", 3);
        f12174i = r5;
        k r7 = new k("SERIAL", 4);
        f12175j = r7;
        k r9 = new k("FIXED", 5);
        f12176k = r9;
        f12177l = new k[]{r0, r1, r3, r5, r7, r9};
    }

    private k(String r1, int r2) {
        super(r1, r2);
    }

    public static k valueOf(String r1) {
        return (k) Enum.valueOf(k.class, r1);
    }

    public static k[] values() {
        return (k[]) f12177l.clone();
    }
}
