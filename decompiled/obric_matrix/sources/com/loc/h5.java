package com.loc;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class h5 extends Exception {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f7357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f7358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f7359j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7360k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f7361l;
    private volatile boolean m;
    private Map<String, List<String>> n;

    public h5(String r17) {
        super(r17);
        this.f7355f = "未知的错误";
        this.f7356g = "";
        this.f7357h = "";
        this.f7358i = "1900";
        this.f7359j = "UnknownError";
        this.f7360k = -1;
        this.f7361l = -1;
        this.m = false;
        this.f7355f = r17;
        if ("IO 操作异常 - IOException".equals(r17) == false) goto L7;
        this.f7360k = 21;
        this.f7358i = "1902";
        String r3 = "IOException";
    L5:
        this.f7359j = r3;
    L76:
        if ("IO 操作异常 - IOException".equals(r17) == false) goto L80;
        this.f7361l = 7;
        return;
    L80:
        if ("socket 连接异常 - SocketException".equals(r17) == false) goto L84;
        this.f7361l = 6;
        return;
    L84:
        if ("socket 连接超时 - SocketTimeoutException".equals(r17) == false) goto L88;
        this.f7361l = 2;
        return;
    L88:
        if ("未知主机 - UnKnowHostException".equals(r17) == false) goto L90;
    L99:
        this.f7361l = 9;
        return;
    L90:
        if ("http连接失败 - ConnectionException".equals(r17) == false) goto L94;
        this.f7361l = 6;
        return;
    L94:
        if ("未知的错误".equals(r17) == true) goto L99;
        if ("DNS解析失败".equals(r17) == false) goto L99;
        this.f7361l = 3;
        return;
    L7:
        if ("socket 连接异常 - SocketException".equals(r17) == false) goto L11;
        int r4 = 22;
    L9:
        this.f7360k = r4;
        goto L76
    L11:
        if ("socket 连接超时 - SocketTimeoutException".equals(r17) == false) goto L14;
        this.f7360k = 23;
        this.f7358i = "1802";
        r3 = "SocketTimeoutException";
        goto L5
    L14:
        if ("无效的参数 - IllegalArgumentException".equals(r17) == false) goto L17;
        this.f7360k = 24;
        this.f7358i = "1901";
        r3 = "IllegalArgumentException";
        goto L5
    L17:
        if ("空指针异常 - NullPointException".equals(r17) == false) goto L20;
        this.f7360k = 25;
        this.f7358i = "1903";
        r3 = "NullPointException";
        goto L5
    L20:
        if ("url异常 - MalformedURLException".equals(r17) == false) goto L23;
        this.f7360k = 26;
        this.f7358i = "1803";
        r3 = "MalformedURLException";
        goto L5
    L23:
        if ("未知主机 - UnKnowHostException".equals(r17) == false) goto L26;
        this.f7360k = 27;
        this.f7358i = "1804";
        r3 = "UnknownHostException";
        goto L5
    L26:
        if ("服务器连接失败 - UnknownServiceException".equals(r17) == false) goto L29;
        this.f7360k = 28;
        this.f7358i = "1805";
        r3 = "CannotConnectToHostException";
        goto L5
    L29:
        if ("协议解析错误 - ProtocolException".equals(r17) == false) goto L32;
        this.f7360k = 29;
        this.f7358i = "1801";
        r3 = "ProtocolException";
        goto L5
    L32:
        if ("http连接失败 - ConnectionException".equals(r17) == false) goto L36;
        this.f7360k = 30;
        String r5 = "1806";
    L34:
        this.f7358i = r5;
        this.f7359j = "ConnectionException";
        goto L76
    L36:
        if ("服务QPS超限".equalsIgnoreCase(r17) == false) goto L39;
        this.f7360k = 30;
        r5 = "2001";
        goto L34
    L39:
        if ("未知的错误".equals(r17) == false) goto L42;
        r4 = 31;
        goto L9
    L42:
        if ("key鉴权失败".equals(r17) == false) goto L45;
        r4 = 32;
        goto L9
    L45:
        if ("requeust is null".equals(r17) == false) goto L48;
        r4 = 1;
        goto L9
    L48:
        if ("request url is empty".equals(r17) == false) goto L51;
        this.f7360k = 2;
        goto L76
    L51:
        if ("response is null".equals(r17) == false) goto L54;
    L52:
        this.f7360k = 3;
        goto L76
    L54:
        if ("thread pool has exception".equals(r17) == false) goto L57;
        r4 = 4;
        goto L9
    L57:
        if ("sdk name is invalid".equals(r17) == false) goto L60;
        r4 = 5;
        goto L9
    L60:
        if ("sdk info is null".equals(r17) == false) goto L63;
        this.f7360k = 6;
        goto L76
    L63:
        if ("sdk packages is null".equals(r17) == false) goto L66;
        this.f7360k = 7;
        goto L76
    L66:
        if ("线程池为空".equals(r17) == false) goto L69;
        r4 = 8;
        goto L9
    L69:
        if ("获取对象错误".equals(r17) == false) goto L72;
        r4 = 101;
        goto L9
    L72:
        if ("DNS解析失败".equals(r17) == true) goto L52;
        r4 = -1;
        goto L9
    }

    public h5(String r1, String r2, String r3) {
        this(r1);
        this.f7356g = r2;
        this.f7357h = r3;
    }

    public final String a() {
        return this.f7355f;
    }

    public final void b(String r1) {
    }

    public final void c(Map<String, List<String>> r1) {
        this.n = r1;
    }

    public final String d() {
        return this.f7358i;
    }

    public final String e() {
        return this.f7359j;
    }

    public final String f() {
        return this.f7356g;
    }

    public final String g() {
        return this.f7357h;
    }

    public final int h() {
        return this.f7360k;
    }

    public final int i() {
        return this.f7361l;
    }

    public final int j() {
        this.f7361l = 10;
        return 10;
    }

    public final boolean k() {
        return this.m;
    }

    public final void l() {
        this.m = true;
    }
}
