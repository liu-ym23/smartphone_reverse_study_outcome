package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes.dex */
public class r extends b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static r f2861k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static r f2862l;
    public static final r m = null;

    static {
        f2861k = new r(k0.a("https://log.snssdk.com"), false, false);
        f2862l = new r(k0.a("https://boe.i.snssdk.com"), false, true);
        m = f2861k;
    }

    public r(k0 r2, boolean r3, boolean r4) {
        this(r2, r3, r4, false);
    }

    public r(k0 r1, boolean r2, boolean r3, boolean r4) {
        super(r1, r2, r3, r4);
    }
}
