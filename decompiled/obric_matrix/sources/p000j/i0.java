package p000j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final enum i0 extends Enum<i0> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i0 f17775g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i0 f17776h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final i0 f17777i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final i0 f17778j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final i0 f17779k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ i0[] f17780l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f17781f;

    static {
        i0 r0 = new i0("TLS_1_3", 0, "TLSv1.3");
        f17775g = r0;
        i0 r1 = new i0("TLS_1_2", 1, "TLSv1.2");
        f17776h = r1;
        i0 r3 = new i0("TLS_1_1", 2, "TLSv1.1");
        f17777i = r3;
        i0 r5 = new i0("TLS_1_0", 3, "TLSv1");
        f17778j = r5;
        i0 r7 = new i0("SSL_3_0", 4, "SSLv3");
        f17779k = r7;
        f17780l = new i0[]{r0, r1, r3, r5, r7};
    }

    private i0(String r1, int r2, String r3) {
        super(r1, r2);
        this.f17781f = r3;
    }

    public static i0 a(String r3) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -503070503: goto L22;
            case -503070502: goto L18;
            case -503070501: goto L14;
            case 79201641: goto L10;
            case 79923350: goto L6;
            default: goto L25;
        };
    L25:
        switch(r1) {
            case 0: goto L37;
            case 1: goto L35;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L29;
            default: goto L27;
        };
    L27:
        throw new IllegalArgumentException("Unexpected TLS version: " + r3);
    L29:
        return f17778j;
    L31:
        return f17779k;
    L33:
        return f17775g;
    L35:
        return f17776h;
    L37:
        return f17777i;
    L6:
        if (r3.equals("TLSv1") == false) goto L25;
        r1 = 4;
        goto L25
    L10:
        if (r3.equals("SSLv3") == false) goto L25;
        r1 = 3;
        goto L25
    L14:
        if (r3.equals("TLSv1.3") == false) goto L25;
        r1 = 2;
        goto L25
    L18:
        if (r3.equals("TLSv1.2") == false) goto L25;
        r1 = 1;
        goto L25
    L22:
        if (r3.equals("TLSv1.1") == false) goto L25;
        r1 = 0;
        goto L25
    }

    static List<i0> b(String... r4) {
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(a(r4[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return Collections.unmodifiableList(r0);
    }

    public static i0 valueOf(String r1) {
        return (i0) Enum.valueOf(i0.class, r1);
    }

    public static i0[] values() {
        return (i0[]) f17780l.clone();
    }
}
