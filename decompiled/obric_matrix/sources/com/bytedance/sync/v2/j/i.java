package com.bytedance.sync.v2.j;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes.dex */
public final enum i extends Enum<i> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f6101g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f6102h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final i f6103i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ProtoAdapter<i> f6104j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ i[] f6105k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6106f;

    static {
        i r0 = new i("Default", 0, 0);
        f6101g = r0;
        i r1 = new i("HttpPoll", 1, 1);
        f6102h = r1;
        i r3 = new i("HeartbeatPong", 2, 2);
        f6103i = r3;
        f6105k = new i[]{r0, r1, r3};
        f6104j = new a();
    }

    private i(String r1, int r2, int r3) {
        super(r1, r2);
        this.f6106f = r3;
    }

    public static i a(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return f6103i;
    L12:
        return f6102h;
    L14:
        return f6101g;
    }

    public static i valueOf(String r1) {
        return (i) Enum.valueOf(i.class, r1);
    }

    public static i[] values() {
        return (i[]) f6105k.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f6106f;
    }
}
