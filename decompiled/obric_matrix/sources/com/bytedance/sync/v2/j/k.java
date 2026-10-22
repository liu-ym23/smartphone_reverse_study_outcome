package com.bytedance.sync.v2.j;

import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum k extends Enum<k> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f6114g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k f6115h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k f6116i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k f6117j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ k[] f6118k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6119f;

    static {
        k r0 = new k("Params", 0, 0);
        f6114g = r0;
        k r1 = new k("CustomParams", 1, 1);
        f6115h = r1;
        k r3 = new k("ErrCode", 2, 100);
        f6116i = r3;
        k r5 = new k("ErrMsg", 3, 101);
        f6117j = r5;
        f6118k = new k[]{r0, r1, r3, r5};
        new a();
    }

    private k(String r1, int r2, int r3) {
        super(r1, r2);
        this.f6119f = r3;
    }

    public static k a(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 100) goto L14;
        if (r1 == 101) goto L12;
        return null;
    L12:
        return f6117j;
    L14:
        return f6116i;
    L16:
        return f6115h;
    L18:
        return f6114g;
    }

    public static k valueOf(String r1) {
        return (k) Enum.valueOf(k.class, r1);
    }

    public static k[] values() {
        return (k[]) f6118k.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f6119f;
    }
}
