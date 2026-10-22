package com.bytedance.sync.v2.j;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum g extends Enum<g> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f6091g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g f6092h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ProtoAdapter<g> f6093i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ g[] f6094j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6095f;

    static {
        g r0 = new g("Device", 0, 0);
        f6091g = r0;
        g r1 = new g("User", 1, 1);
        f6092h = r1;
        f6094j = new g[]{r0, r1};
        f6093i = new a();
    }

    private g(String r1, int r2, int r3) {
        super(r1, r2);
        this.f6095f = r3;
    }

    public static g a(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return f6092h;
    L10:
        return f6091g;
    }

    public static g valueOf(String r1) {
        return (g) Enum.valueOf(g.class, r1);
    }

    public static g[] values() {
        return (g[]) f6094j.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f6095f;
    }
}
