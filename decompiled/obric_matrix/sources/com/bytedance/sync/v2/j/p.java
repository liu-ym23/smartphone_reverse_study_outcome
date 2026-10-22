package com.bytedance.sync.v2.j;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum p extends Enum<p> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p f6134g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final p f6135h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final p f6136i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ProtoAdapter<p> f6137j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ p[] f6138k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6139f;

    static {
        p r0 = new p("SpecTopic", 0, 0);
        f6134g = r0;
        p r1 = new p("GlobalTopic", 1, 1);
        f6135h = r1;
        p r3 = new p("CustomTopic", 2, 2);
        f6136i = r3;
        f6138k = new p[]{r0, r1, r3};
        f6137j = new a();
    }

    private p(String r1, int r2, int r3) {
        super(r1, r2);
        this.f6139f = r3;
    }

    public static p a(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return f6136i;
    L12:
        return f6135h;
    L14:
        return f6134g;
    }

    public static p valueOf(String r1) {
        return (p) Enum.valueOf(p.class, r1);
    }

    public static p[] values() {
        return (p[]) f6138k.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f6139f;
    }
}
