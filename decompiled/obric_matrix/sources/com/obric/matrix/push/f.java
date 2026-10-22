package com.obric.matrix.push;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes2.dex */
public final enum f extends Enum<f> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f9557g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f9558h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f9559i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f9560j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f f9561k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f f9562l = null;
    public static final f m = null;
    public static final ProtoAdapter<f> n = null;
    private static final /* synthetic */ f[] o = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9563f;

    static {
        f r0 = new f("NONE", 0, 0);
        f9557g = r0;
        f r1 = new f("PUSH", 1, 1);
        f9558h = r1;
        f r3 = new f("IM", 2, 2);
        f9559i = r3;
        f r5 = new f("SETTINGS", 3, 3);
        f9560j = r5;
        f r7 = new f("EVENT", 4, 4);
        f9561k = r7;
        f r9 = new f("HTTP", 5, 5);
        f9562l = r9;
        f r11 = new f("REVOKE", 6, 6);
        m = r11;
        o = new f[]{r0, r1, r3, r5, r7, r9, r11};
        n = new a();
    }

    private f(String r1, int r2, int r3) {
        super(r1, r2);
        this.f9563f = r3;
    }

    public static f a(int r0) {
        switch(r0) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return m;
    L8:
        return f9562l;
    L10:
        return f9561k;
    L12:
        return f9560j;
    L14:
        return f9559i;
    L16:
        return f9558h;
    L18:
        return f9557g;
    }

    public static f valueOf(String r1) {
        return (f) Enum.valueOf(f.class, r1);
    }

    public static f[] values() {
        return (f[]) o.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f9563f;
    }
}
