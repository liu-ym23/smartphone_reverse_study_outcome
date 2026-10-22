package com.obric.matrix.w;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes2.dex */
public final enum s extends Enum<s> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final s f10501g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final s f10502h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ProtoAdapter<s> f10503i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ s[] f10504j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f10505f;

    static {
        s r0 = new s("METHOD_GET", 0, 0);
        f10501g = r0;
        s r1 = new s("METHOD_POST", 1, 1);
        f10502h = r1;
        f10504j = new s[]{r0, r1};
        f10503i = new a();
    }

    private s(String r1, int r2, int r3) {
        super(r1, r2);
        this.f10505f = r3;
    }

    public static s a(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return f10502h;
    L10:
        return f10501g;
    }

    public static s valueOf(String r1) {
        return (s) Enum.valueOf(s.class, r1);
    }

    public static s[] values() {
        return (s[]) f10504j.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f10505f;
    }
}
