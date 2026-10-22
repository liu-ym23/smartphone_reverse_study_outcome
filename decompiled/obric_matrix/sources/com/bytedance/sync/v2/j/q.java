package com.bytedance.sync.v2.j;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum q extends Enum<q> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q f6140g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final q f6141h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final q f6142i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ProtoAdapter<q> f6143j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ q[] f6144k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6145f;

    static {
        q r0 = new q("Unknown", 0, 0);
        f6140g = r0;
        q r1 = new q("V1", 1, 1);
        f6141h = r1;
        q r3 = new q("V2", 2, 2);
        f6142i = r3;
        f6144k = new q[]{r0, r1, r3};
        f6143j = new a();
    }

    private q(String r1, int r2, int r3) {
        super(r1, r2);
        this.f6145f = r3;
    }

    public static q a(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return f6142i;
    L12:
        return f6141h;
    L14:
        return f6140g;
    }

    public static q valueOf(String r1) {
        return (q) Enum.valueOf(q.class, r1);
    }

    public static q[] values() {
        return (q[]) f6144k.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f6145f;
    }
}
