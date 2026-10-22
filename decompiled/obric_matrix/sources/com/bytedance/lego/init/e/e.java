package com.bytedance.lego.init.e;

/* JADX INFO: loaded from: classes.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f4876f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f4877g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f4878h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f4879i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f4880j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f4881k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f4882l = null;
    public static final e m = null;
    public static final e n = null;
    public static final e o = null;
    public static final e p = null;
    public static final e q = null;
    public static final e r = null;
    public static final e s = null;
    private static final /* synthetic */ e[] t = null;

    static {
        e r0 = new e("SPLASH_ON_CREATE", 0);
        f4876f = r0;
        e r1 = new e("SPLASH_ON_START", 1);
        f4877g = r1;
        e r3 = new e("SPLASH_ON_RESUME", 2);
        f4878h = r3;
        e r5 = new e("SPLASH_ON_PAUSE", 3);
        f4879i = r5;
        e r7 = new e("SPLASH_ON_STOP", 4);
        f4880j = r7;
        e r9 = new e("SPLASH_ON_DESTROY", 5);
        f4881k = r9;
        e r11 = new e("SPLASH_ON_ANY", 6);
        f4882l = r11;
        e r13 = new e("MAIN_ON_CREATE", 7);
        m = r13;
        e r15 = new e("MAIN_ON_START", 8);
        n = r15;
        e r14 = new e("MAIN_ON_RESUME", 9);
        o = r14;
        e r12 = new e("MAIN_ON_PAUSE", 10);
        p = r12;
        e r10 = new e("MAIN_ON_STOP", 11);
        q = r10;
        e r8 = new e("MAIN_ON_DESTROY", 12);
        r = r8;
        e r6 = new e("MAIN_ON_ANY", 13);
        s = r6;
        t = new e[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6};
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    public static e a(String r2) {
        r2.hashCode();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case -1604499520: goto L58;
            case -364577614: goto L54;
            case 236883538: goto L50;
            case 735015050: goto L46;
            case 901014614: goto L42;
            case 1307299406: goto L38;
            case 1310616762: goto L34;
            case 1318882183: goto L30;
            case 1514603396: goto L26;
            case 1583537628: goto L22;
            case 1824808004: goto L18;
            case 1841695548: goto L14;
            case 1845012904: goto L10;
            case 1932470965: goto L6;
            default: goto L61;
        };
    L61:
        switch(r1) {
            case 0: goto L91;
            case 1: goto L89;
            case 2: goto L87;
            case 3: goto L85;
            case 4: goto L83;
            case 5: goto L81;
            case 6: goto L79;
            case 7: goto L77;
            case 8: goto L75;
            case 9: goto L73;
            case 10: goto L71;
            case 11: goto L69;
            case 12: goto L67;
            case 13: goto L65;
            default: goto L62;
        };
    L62:
        return null;
    L65:
        return f4878h;
    L67:
        return n;
    L69:
        return p;
    L71:
        return f4882l;
    L73:
        return q;
    L75:
        return f4876f;
    L77:
        return o;
    L79:
        return f4877g;
    L81:
        return f4879i;
    L83:
        return m;
    L85:
        return f4880j;
    L87:
        return f4881k;
    L89:
        return s;
    L91:
        return r;
    L6:
        if (r2.equals("SPLASH_ON_RESUME") == false) goto L61;
        r1 = 13;
        goto L61
    L10:
        if (r2.equals("MAIN_ON_START") == false) goto L61;
        r1 = 12;
        goto L61
    L14:
        if (r2.equals("MAIN_ON_PAUSE") == false) goto L61;
        r1 = 11;
        goto L61
    L18:
        if (r2.equals("SPLASH_ON_ANY") == false) goto L61;
        r1 = 10;
        goto L61
    L22:
        if (r2.equals("MAIN_ON_STOP") == false) goto L61;
        r1 = 9;
        goto L61
    L26:
        if (r2.equals("SPLASH_ON_CREATE") == false) goto L61;
        r1 = 8;
        goto L61
    L30:
        if (r2.equals("MAIN_ON_RESUME") == false) goto L61;
        r1 = 7;
        goto L61
    L34:
        if (r2.equals("SPLASH_ON_START") == false) goto L61;
        r1 = 6;
        goto L61
    L38:
        if (r2.equals("SPLASH_ON_PAUSE") == false) goto L61;
        r1 = 5;
        goto L61
    L42:
        if (r2.equals("MAIN_ON_CREATE") == false) goto L61;
        r1 = 4;
        goto L61
    L46:
        if (r2.equals("SPLASH_ON_STOP") == false) goto L61;
        r1 = 3;
        goto L61
    L50:
        if (r2.equals("SPLASH_ON_DESTROY") == false) goto L61;
        r1 = 2;
        goto L61
    L54:
        if (r2.equals("MAIN_ON_ANY") == false) goto L61;
        r1 = 1;
        goto L61
    L58:
        if (r2.equals("MAIN_ON_DESTROY") == false) goto L61;
        r1 = 0;
        goto L61
    }

    public static e valueOf(String r1) {
        return (e) Enum.valueOf(e.class, r1);
    }

    public static e[] values() {
        return (e[]) t.clone();
    }
}
