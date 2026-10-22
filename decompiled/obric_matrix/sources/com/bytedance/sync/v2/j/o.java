package com.bytedance.sync.v2.j;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum o extends Enum<o> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final o f6128g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final o f6129h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final o f6130i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ProtoAdapter<o> f6131j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ o[] f6132k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6133f;

    static {
        o r0 = new o("NotExist", 0, 0);
        f6128g = r0;
        o r1 = new o("Active", 1, 1);
        f6129h = r1;
        o r3 = new o("Closed", 2, 2);
        f6130i = r3;
        f6132k = new o[]{r0, r1, r3};
        f6131j = new a();
    }

    private o(String r1, int r2, int r3) {
        super(r1, r2);
        this.f6133f = r3;
    }

    public static o a(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return f6130i;
    L12:
        return f6129h;
    L14:
        return f6128g;
    }

    public static o valueOf(String r1) {
        return (o) Enum.valueOf(o.class, r1);
    }

    public static o[] values() {
        return (o[]) f6132k.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f6133f;
    }
}
