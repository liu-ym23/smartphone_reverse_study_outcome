package com.bytedance.bdturing.v;

import com.bytedance.ttnet.TTNetInit;

/* JADX INFO: loaded from: classes.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f3195g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f3196h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f3197i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f3198j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f3199k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ e[] f3200l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f3201f;

    static {
        e r1 = new e("CN", 0, "cn");
        f3195g = r1;
        e r2 = new e("SINGAPOER", 1, "sg");
        f3196h = r2;
        e r3 = new e("USA_EAST", 2, "va");
        f3197i = r3;
        e r4 = new e("INDIA", 3, "in");
        f3198j = r4;
        e r5 = new e("BOE", 4, TTNetInit.DOMAIN_BOE_KEY);
        f3199k = r5;
        f3200l = new e[]{r1, r2, r3, r4, r5};
    }

    private e(String r1, int r2, String r3) {
        super(r1, r2);
        this.f3201f = r3;
    }

    public static e valueOf(String r1) {
        return (e) Enum.valueOf(e.class, r1);
    }

    public static e[] values() {
        return (e[]) f3200l.clone();
    }

    public final String a() {
        return this.f3201f;
    }
}
