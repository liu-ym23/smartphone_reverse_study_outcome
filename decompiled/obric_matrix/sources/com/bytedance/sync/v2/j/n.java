package com.bytedance.sync.v2.j;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum n extends Enum<n> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final n f6123g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final n f6124h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ProtoAdapter<n> f6125i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ n[] f6126j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6127f;

    static {
        n r0 = new n("Full", 0, 0);
        f6123g = r0;
        n r1 = new n("OnlySave", 1, 1);
        f6124h = r1;
        f6126j = new n[]{r0, r1};
        f6125i = new a();
    }

    private n(String r1, int r2, int r3) {
        super(r1, r2);
        this.f6127f = r3;
    }

    public static n a(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return f6124h;
    L10:
        return f6123g;
    }

    public static n valueOf(String r1) {
        return (n) Enum.valueOf(n.class, r1);
    }

    public static n[] values() {
        return (n[]) f6126j.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f6127f;
    }
}
