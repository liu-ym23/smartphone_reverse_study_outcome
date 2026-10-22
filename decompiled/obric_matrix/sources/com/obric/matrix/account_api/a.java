package com.obric.matrix.account_api;

import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\bH\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007¢\u0006\u0002\u0010\u0019J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0007HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J\t\u0010P\u001a\u00020\u0017HÆ\u0003J\t\u0010Q\u001a\u00020\u0007HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0007HÆ\u0003J\t\u0010T\u001a\u00020\u0007HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0007HÆ\u0003J\t\u0010W\u001a\u00020\u0007HÆ\u0003J\t\u0010X\u001a\u00020\u0007HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003JÇ\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0007HÆ\u0001J\u0013\u0010[\u001a\u00020\u00032\b\u0010\\\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010]\u001a\u00020\u0005HÖ\u0001J\t\u0010^\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010#\"\u0004\b(\u0010%R\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001b\"\u0004\b*\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010#\"\u0004\b,\u0010%R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010!R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010!R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001dR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001b\"\u0004\b>\u0010\u001dR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001b\"\u0004\b@\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001dR\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u0010\u001dR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001b\"\u0004\bF\u0010\u001d¨\u0006_"}, d2 = {"Lcom/obric/matrix/account_api/AccountInfo;", "", "loginState", "", "logoutScene", "", "secUserId", "", "userId", "odinUserType", "xTTToken", "innerSSOToken", "avatarUrl", "countryCode", "userName", "screenName", "userEmail", "userMobile", "hasPassword", "userGender", "isNewUser", "userSession", "loginUtcTime", "", "loginPhoneNumber", "(ZILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZLjava/lang/String;JLjava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getCountryCode", "()I", "setCountryCode", "(I)V", "getHasPassword", "()Z", "setHasPassword", "(Z)V", "getInnerSSOToken", "setInnerSSOToken", "setNewUser", "getLoginPhoneNumber", "setLoginPhoneNumber", "getLoginState", "setLoginState", "getLoginUtcTime", "()J", "setLoginUtcTime", "(J)V", "getLogoutScene", "setLogoutScene", "getOdinUserType", "setOdinUserType", "getScreenName", "setScreenName", "getSecUserId", "setSecUserId", "getUserEmail", "setUserEmail", "getUserGender", "setUserGender", "getUserId", "setUserId", "getUserMobile", "setUserMobile", "getUserName", "setUserName", "getUserSession", "setUserSession", "getXTTToken", "setXTTToken", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "account_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f8814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f8815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8816i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f8817j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f8818k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f8819l;
    private String m;
    private boolean n;
    private int o;
    private boolean p;
    private String q;
    private long r;
    private String s;

    public a() {
        this(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);
    }

    public a(boolean r14, int r15, String r16, String r17, int r18, String r19, String r20, String r21, int r22, String r23, String r24, String r25, String r26, boolean r27, int r28, boolean r29, String r30, long r31, String r33) {
        o.f(r16, "secUserId");
        o.f(r17, "userId");
        o.f(r19, "xTTToken");
        o.f(r20, "innerSSOToken");
        o.f(r21, "avatarUrl");
        o.f(r23, "userName");
        o.f(r24, "screenName");
        o.f(r25, "userEmail");
        o.f(r26, "userMobile");
        o.f(r30, "userSession");
        o.f(r33, "loginPhoneNumber");
        this.f8808a = r14;
        this.f8809b = r15;
        this.f8810c = r16;
        this.f8811d = r17;
        this.f8812e = r18;
        this.f8813f = r19;
        this.f8814g = r20;
        this.f8815h = r21;
        this.f8816i = r22;
        this.f8817j = r23;
        this.f8818k = r24;
        this.f8819l = r25;
        this.m = r26;
        this.n = r27;
        this.o = r28;
        this.p = r29;
        this.q = r30;
        this.r = r31;
        this.s = r33;
    }

    public /* synthetic */ a(boolean r22, int r23, String r24, String r25, int r26, String r27, String r28, String r29, int r30, String r31, String r32, String r33, String r34, boolean r35, int r36, boolean r37, String r38, long r39, String r41, int r42, g r43) {
        if ((r42 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r42 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r42 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r42 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r42 & 16) == 0) goto L21;
        int r7 = 0;
    L23:
        if ((r42 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r42 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r42 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r42 & 256) == 0) goto L37;
        int r11 = 86;
    L39:
        if ((r42 & 512) == 0) goto L41;
        String r12 = "";
    L43:
        if ((r42 & 1024) == 0) goto L45;
        String r13 = "";
    L47:
        if ((r42 & 2048) == 0) goto L49;
        String r14 = "";
    L51:
        if ((r42 & 4096) == 0) goto L53;
        String r15 = "";
    L55:
        if ((r42 & 8192) == 0) goto L57;
        boolean r2 = false;
    L59:
        if ((r42 & 16384) == 0) goto L61;
        int r5 = 0;
    L63:
        if ((r42 & 32768) == 0) goto L65;
        boolean r16 = false;
    L67:
        if ((r42 & 65536) == 0) goto L69;
        String r17 = "";
    L71:
        if ((r42 & 131072) == 0) goto L73;
        long r18 = 0;
    L75:
        if ((r42 & 262144) == 0) goto L77;
        String r0 = "";
    L78:
        this(r1, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r5, r16, r17, r18, r0);
        return;
    L77:
        r0 = r41;
        goto L78
    L73:
        r18 = r39;
        goto L75
    L69:
        r17 = r38;
        goto L71
    L65:
        r16 = r37;
        goto L67
    L61:
        r5 = r36;
        goto L63
    L57:
        r2 = r35;
        goto L59
    L53:
        r15 = r34;
        goto L55
    L49:
        r14 = r33;
        goto L51
    L45:
        r13 = r32;
        goto L47
    L41:
        r12 = r31;
        goto L43
    L37:
        r11 = r30;
        goto L39
    L33:
        r10 = r29;
        goto L35
    L29:
        r9 = r28;
        goto L31
    L25:
        r8 = r27;
        goto L27
    L21:
        r7 = r26;
        goto L23
    L17:
        r6 = r25;
        goto L19
    L13:
        r4 = r24;
        goto L15
    L9:
        r3 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L7
    }

    public final String a() {
        return this.f8815h;
    }

    public final int b() {
        return this.f8816i;
    }

    public final boolean c() {
        return this.n;
    }

    public final String d() {
        return this.f8814g;
    }

    public final String e() {
        return this.s;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.f8808a == r9.f8808a) goto L12;
        return false;
    L12:
        if (this.f8809b == r9.f8809b) goto L15;
        return false;
    L15:
        if (o.a(this.f8810c, r9.f8810c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f8811d, r9.f8811d) == true) goto L21;
        return false;
    L21:
        if (this.f8812e == r9.f8812e) goto L24;
        return false;
    L24:
        if (o.a(this.f8813f, r9.f8813f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.f8814g, r9.f8814g) == true) goto L30;
        return false;
    L30:
        if (o.a(this.f8815h, r9.f8815h) == true) goto L33;
        return false;
    L33:
        if (this.f8816i == r9.f8816i) goto L36;
        return false;
    L36:
        if (o.a(this.f8817j, r9.f8817j) == true) goto L39;
        return false;
    L39:
        if (o.a(this.f8818k, r9.f8818k) == true) goto L42;
        return false;
    L42:
        if (o.a(this.f8819l, r9.f8819l) == true) goto L45;
        return false;
    L45:
        if (o.a(this.m, r9.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (o.a(this.q, r9.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r9.r) goto L63;
        return false;
    L63:
        if (o.a(this.s, r9.s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final boolean f() {
        return this.f8808a;
    }

    public final long g() {
        return this.r;
    }

    public final int h() {
        return this.f8809b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    public int hashCode() {
        boolean r0 = this.f8808a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = ((((((((((((((((((((((((r2 * 31) + Integer.hashCode(this.f8809b)) * 31) + this.f8810c.hashCode()) * 31) + this.f8811d.hashCode()) * 31) + Integer.hashCode(this.f8812e)) * 31) + this.f8813f.hashCode()) * 31) + this.f8814g.hashCode()) * 31) + this.f8815h.hashCode()) * 31) + Integer.hashCode(this.f8816i)) * 31) + this.f8817j.hashCode()) * 31) + this.f8818k.hashCode()) * 31) + this.f8819l.hashCode()) * 31) + this.m.hashCode()) * 31;
        boolean r4 = this.n;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (((r3 + r5) * 31) + Integer.hashCode(this.o)) * 31;
        boolean r7 = this.p;
        if (r7 == true) goto L13;
        r1 = r7;
    L13:
        return ((((((r6 + r1) * 31) + this.q.hashCode()) * 31) + Long.hashCode(this.r)) * 31) + this.s.hashCode();
    }

    public final int i() {
        return this.f8812e;
    }

    public final String j() {
        return this.f8818k;
    }

    public final String k() {
        return this.f8810c;
    }

    public final String l() {
        return this.f8819l;
    }

    public final int m() {
        return this.o;
    }

    public final String n() {
        return this.f8811d;
    }

    public final String o() {
        return this.m;
    }

    public final String p() {
        return this.f8817j;
    }

    public final String q() {
        return this.q;
    }

    public final String r() {
        return this.f8813f;
    }

    public final boolean s() {
        return this.p;
    }

    public String toString() {
        return "AccountInfo(loginState=" + this.f8808a + ", logoutScene=" + this.f8809b + ", secUserId=" + this.f8810c + ", userId=" + this.f8811d + ", odinUserType=" + this.f8812e + ", xTTToken=" + this.f8813f + ", innerSSOToken=" + this.f8814g + ", avatarUrl=" + this.f8815h + ", countryCode=" + this.f8816i + ", userName=" + this.f8817j + ", screenName=" + this.f8818k + ", userEmail=" + this.f8819l + ", userMobile=" + this.m + ", hasPassword=" + this.n + ", userGender=" + this.o + ", isNewUser=" + this.p + ", userSession=" + this.q + ", loginUtcTime=" + this.r + ", loginPhoneNumber=" + this.s + ')';
    }
}
