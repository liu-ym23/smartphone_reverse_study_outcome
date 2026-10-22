package com.obric.matrix.push;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes2.dex */
public final enum l extends Enum<l> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l f9625g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l f9626h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ProtoAdapter<l> f9627i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ l[] f9628j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9629f;

    static {
        l r0 = new l("UNKNOWN", 0, 0);
        f9625g = r0;
        l r1 = new l("V1", 1, 1);
        f9626h = r1;
        f9628j = new l[]{r0, r1};
        f9627i = new a();
    }

    private l(String r1, int r2, int r3) {
        super(r1, r2);
        this.f9629f = r3;
    }

    public static l a(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return f9626h;
    L10:
        return f9625g;
    }

    public static l valueOf(String r1) {
        return (l) Enum.valueOf(l.class, r1);
    }

    public static l[] values() {
        return (l[]) f9628j.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f9629f;
    }
}
