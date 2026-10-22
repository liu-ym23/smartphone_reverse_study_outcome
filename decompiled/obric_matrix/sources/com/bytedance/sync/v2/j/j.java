package com.bytedance.sync.v2.j;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum j extends Enum<j> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j f6107g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final j f6108h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final j f6109i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final j f6110j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final j f6111k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final j f6112l = null;
    public static final ProtoAdapter<j> m = null;
    private static final /* synthetic */ j[] n = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6113f;

    static {
        j r0 = new j("None", 0, 0);
        f6107g = r0;
        j r1 = new j("ACK", 1, 1);
        f6108h = r1;
        j r3 = new j("Data", 2, 2);
        f6109i = r3;
        j r5 = new j("Sync", 3, 3);
        f6110j = r5;
        j r7 = new j("Poll", 4, 4);
        f6111k = r7;
        j r9 = new j("FIN", 5, 5);
        f6112l = r9;
        n = new j[]{r0, r1, r3, r5, r7, r9};
        m = new a();
    }

    private j(String r1, int r2, int r3) {
        super(r1, r2);
        this.f6113f = r3;
    }

    public static j a(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return f6112l;
    L18:
        return f6111k;
    L20:
        return f6110j;
    L22:
        return f6109i;
    L24:
        return f6108h;
    L26:
        return f6107g;
    }

    public static j valueOf(String r1) {
        return (j) Enum.valueOf(j.class, r1);
    }

    public static j[] values() {
        return (j[]) n.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f6113f;
    }
}
