package com.bytedance.sync.v2.j;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum h extends Enum<h> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h f6096g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f6097h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ProtoAdapter<h> f6098i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ h[] f6099j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6100f;

    static {
        h r0 = new h("OneByOne", 0, 0);
        f6096g = r0;
        h r1 = new h("Increment", 1, 1);
        f6097h = r1;
        f6099j = new h[]{r0, r1};
        f6098i = new a();
    }

    private h(String r1, int r2, int r3) {
        super(r1, r2);
        this.f6100f = r3;
    }

    public static h a(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return f6097h;
    L10:
        return f6096g;
    }

    public static h valueOf(String r1) {
        return (h) Enum.valueOf(h.class, r1);
    }

    public static h[] values() {
        return (h[]) f6099j.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f6100f;
    }
}
