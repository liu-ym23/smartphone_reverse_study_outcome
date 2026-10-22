package com.bytedance.lego.init.e;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final enum k extends Enum<k> implements Serializable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f4892g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f4893h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f4894i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k f4895j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final k f4896k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final k f4897l = null;
    public static final k m = null;
    public static final k n = null;
    public static final k o = null;
    public static final k p = null;
    public static final k q = null;
    public static final k r = null;
    public static final k s = null;
    private static final /* synthetic */ k[] t = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4898f;

    static {
        k r0 = new k("APP_ATTACHBASE2SUPER", 0, 0);
        f4892g = r0;
        k r1 = new k("APP_SUPER2ATTACHBASEEND", 1, 1);
        f4893h = r1;
        k r3 = new k("APP_ONCREATE2SUPER", 2, 2);
        f4894i = r3;
        k r5 = new k("APP_SUPER2ONCREATEEND", 3, 3);
        f4895j = r5;
        k r7 = new k("SPLASH_ONCREATE2SUPER", 4, 4);
        f4896k = r7;
        k r9 = new k("SPLASH_SUPER2ONCREATEEND", 5, 5);
        f4897l = r9;
        k r11 = new k("SPLASH_ONRESUME2SUPER", 6, 6);
        m = r11;
        k r13 = new k("SPLASH_SUPER2ONRESUMEEND", 7, 7);
        n = r13;
        k r15 = new k("MAIN_ONCREATE2SUPER", 8, 8);
        o = r15;
        k r14 = new k("MAIN_SUPER2ONCREATEEND", 9, 9);
        p = r14;
        k r12 = new k("MAIN_ONRESUME2SUPER", 10, 10);
        q = r12;
        k r10 = new k("MAIN_SUPER2ONRESUMEEND", 11, 11);
        r = r10;
        k r8 = new k("NONE", 12, 12);
        s = r8;
        t = new k[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
    }

    private k(String r1, int r2, int r3) {
        super(r1, r2);
        this.f4898f = r3;
    }

    public static k valueOf(String r1) {
        return (k) Enum.valueOf(k.class, r1);
    }

    public static k[] values() {
        return (k[]) t.clone();
    }

    public int a() {
        return this.f4898f;
    }
}
