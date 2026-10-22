package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes.dex */
public final enum m0 extends Enum<m0> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final m0 f2842f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m0 f2843g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ m0[] f2844h = null;

    static {
        m0 r0 = new m0("L0", 0, 0);
        f2842f = r0;
        m0 r1 = new m0("L1", 1, 1);
        f2843g = r1;
        f2844h = new m0[]{r0, r1};
    }

    private m0(String r1, int r2, int r3) {
        super(r1, r2);
    }

    public static m0 valueOf(String r1) {
        return (m0) Enum.valueOf(m0.class, r1);
    }

    public static m0[] values() {
        return (m0[]) f2844h.clone();
    }
}
