package com.obric.matrix.w;

import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes2.dex */
public final enum p extends Enum<p> implements WireEnum {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final p f10465g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final p f10466h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final p f10467i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final p f10468j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final p f10469k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final p f10470l = null;
    public static final p m = null;
    public static final p n = null;
    public static final p o = null;
    public static final p p = null;
    public static final p q = null;
    public static final p r = null;
    public static final p s = null;
    public static final p t = null;
    public static final p u = null;
    public static final p v = null;
    public static final p w = null;
    public static final p x = null;
    private static final /* synthetic */ p[] y = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f10471f;

    static {
        p r0 = new p("CMD_NOT_USED", 0, 0);
        f10465g = r0;
        p r1 = new p("CMD_BIZ_EXAMPLE", 1, 100000);
        f10466h = r1;
        p r3 = new p("CMD_SEND_WS_MESSAGE", 2, 101001);
        f10467i = r3;
        p r5 = new p("CMD_SUBSCRIBE_WS_MSG", 3, 101002);
        f10468j = r5;
        p r7 = new p("CMD_SUBSCRIBE_WS_STATUS", 4, 101003);
        f10469k = r7;
        p r9 = new p("CMD_SUBSCRIBE_WS_MSG_PROVIDER", 5, 101004);
        f10470l = r9;
        p r11 = new p("CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK", 6, 101005);
        m = r11;
        p r13 = new p("CMD_SUBSCRIBE_WS_MSG_BY_BROADCAST", 7, 101006);
        n = r13;
        p r12 = new p("CMD_GET_LOCATION", 8, 102001);
        o = r12;
        p r10 = new p("CMD_REFRESH_LOCATION", 9, 102002);
        p = r10;
        p r8 = new p("CMD_DECODE_LOCATION", 10, 102003);
        q = r8;
        p r6 = new p("CMD_GET_INTERSECT_FENCES", 11, 102004);
        r = r6;
        p r4 = new p("CMD_PRIVATE_START_PICO_LINKS", 12, 111001);
        s = r4;
        p r2 = new p("CMD_PRIVATE_PICO_LINKS_CALLBACK", 13, 111002);
        t = r2;
        p r14 = new p("CMD_PRIVATE_COMMON_NET_REQUEST", 14, 112001);
        u = r14;
        p r15 = new p("CMD_PRIVATE_SEND_APPLOG_EVENT", 15, 112002);
        v = r15;
        p r16 = new p("CMD_SEND_NETWORK_REQUEST", 16, 112003);
        w = r16;
        p r17 = new p("CMD_GET_TTNET_PARAMETERS", 17, 112004);
        x = r17;
        y = new p[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2, r14, r15, r16, r17};
        new a();
    }

    private p(String r1, int r2, int r3) {
        super(r1, r2);
        this.f10471f = r3;
    }

    public static p a(int r1) {
        if (r1 == 0) goto L46;
        if (r1 == 100000) goto L44;
        switch(r1) {
            case 101001: goto L42;
            case 101002: goto L40;
            case 101003: goto L38;
            case 101004: goto L36;
            case 101005: goto L34;
            case 101006: goto L32;
            default: goto L6;
        };
    L6:
        switch(r1) {
            case 102001: goto L30;
            case 102002: goto L28;
            case 102003: goto L26;
            case 102004: goto L24;
            default: goto L7;
        };
    L7:
        switch(r1) {
            case 111001: goto L22;
            case 111002: goto L20;
            default: goto L8;
        };
    L8:
        switch(r1) {
            case 112001: goto L18;
            case 112002: goto L16;
            case 112003: goto L14;
            case 112004: goto L12;
            default: goto L9;
        };
    L9:
        return null;
    L12:
        return x;
    L14:
        return w;
    L16:
        return v;
    L18:
        return u;
    L20:
        return t;
    L22:
        return s;
    L24:
        return r;
    L26:
        return q;
    L28:
        return p;
    L30:
        return o;
    L32:
        return n;
    L34:
        return m;
    L36:
        return f10470l;
    L38:
        return f10469k;
    L40:
        return f10468j;
    L42:
        return f10467i;
    L44:
        return f10466h;
    L46:
        return f10465g;
    }

    public static p valueOf(String r1) {
        return (p) Enum.valueOf(p.class, r1);
    }

    public static p[] values() {
        return (p[]) y.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.f10471f;
    }
}
