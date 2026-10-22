package com.obric.matrix.w;

import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes2.dex */
public final enum o0 extends Enum<o0> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final o0 f10458g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final o0 f10459h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final o0 f10460i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final o0 f10461j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final o0 f10462k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final o0 f10463l = null;
    public static final o0 m = null;
    public static final o0 n = null;
    public static final o0 o = null;
    private static final /* synthetic */ o0[] p = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f10464f;

    static {
        o0 r0 = new o0("OK", 0, 0);
        f10458g = r0;
        o0 r1 = new o0("INVALID_APPKEY", 1, -100001);
        f10459h = r1;
        o0 r3 = new o0("USER_NO_LOGIN", 2, -100002);
        f10460i = r3;
        o0 r5 = new o0("REQUEST_BODY_IS_NULL", 3, -100003);
        f10461j = r5;
        o0 r7 = new o0("ERROR_UNKNOW", 4, -100004);
        f10462k = r7;
        o0 r9 = new o0("REQUEST_DATA_PARSE_ERROR", 5, -100005);
        f10463l = r9;
        o0 r11 = new o0("CMD_NOT_SUPPORT", 6, -100006);
        m = r11;
        o0 r13 = new o0("API_NO_PERMISSION", 7, -100007);
        n = r13;
        o0 r12 = new o0("ILLEGAL_REQUEST_PARAM", 8, -100008);
        o = r12;
        p = new o0[]{r0, r1, r3, r5, r7, r9, r11, r13, r12};
        new a();
    }

    private o0(String r1, int r2, int r3) {
        super(r1, r2);
        this.f10464f = r3;
    }

    public static o0 a(int r0) {
        if (r0 == 0) goto L23;
        switch(r0) {
            case -100008: goto L21;
            case -100007: goto L19;
            case -100006: goto L17;
            case -100005: goto L15;
            case -100004: goto L13;
            case -100003: goto L11;
            case -100002: goto L9;
            case -100001: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return f10459h;
    L9:
        return f10460i;
    L11:
        return f10461j;
    L13:
        return f10462k;
    L15:
        return f10463l;
    L17:
        return m;
    L19:
        return n;
    L21:
        return o;
    L23:
        return f10458g;
    }

    public static o0 valueOf(String r1) {
        return (o0) Enum.valueOf(o0.class, r1);
    }

    public static o0[] values() {
        return (o0[]) p.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f10464f;
    }
}
