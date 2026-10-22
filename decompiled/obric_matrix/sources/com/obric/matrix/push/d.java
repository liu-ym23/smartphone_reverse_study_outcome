package com.obric.matrix.push;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes2.dex */
public final enum d extends Enum<d> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f9530g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f9531h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f9532i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f9533j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ProtoAdapter<d> f9534k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ d[] f9535l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9536f;

    static {
        d r0 = new d("DEFAULT", 0, 0);
        f9530g = r0;
        d r1 = new d("DATA", 1, 1);
        f9531h = r1;
        d r3 = new d("FIN", 2, 2);
        f9532i = r3;
        d r5 = new d("PULL", 3, 3);
        f9533j = r5;
        f9535l = new d[]{r0, r1, r3, r5};
        f9534k = new a();
    }

    private d(String r1, int r2, int r3) {
        super(r1, r2);
        this.f9536f = r3;
    }

    public static d a(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return f9533j;
    L14:
        return f9532i;
    L16:
        return f9531h;
    L18:
        return f9530g;
    }

    public static d valueOf(String r1) {
        return (d) Enum.valueOf(d.class, r1);
    }

    public static d[] values() {
        return (d[]) f9535l.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f9536f;
    }
}
