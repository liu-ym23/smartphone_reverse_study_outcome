package tmsdkobf;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public class ya extends td {
    public static final int c = 0;
    public static final String d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f637a;
    String b;

    static {
        c = ve.d();
        d = null;
    }

    public ya() {
        this.f637a = TMSDKContext.getStrFromEnvMap(TMSDKContext.PRE_TCP_SERVER_ADDRESS);
        this.b = TMSDKContext.getStrFromEnvMap(TMSDKContext.PRE_HTTP_SERVER_URL);
    }

    private boolean c(int r1) {
        if (r1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static String e() {
        return "Main";
    }

    public static boolean f() {
        return false;
    }

    public static int g() {
        boolean r0 = b3.d();
        if (r0 == false) goto L6;
        q8.a("shark_PubSharkConfig", "bTest:[" + r0 + "]");
        return 1;
    L6:
        return 0;
    }

    public static String h() {
        return TMSDKContext.getApplicaionContext().getPackageName() + "_TMF_TMS";
    }

    @Override // tmsdkobf.td
    public int a() {
        return 1;
    }

    @Override // tmsdkobf.td
    public String b(int r1) {
        if (c(r1) == false) goto L10;
        if (b3.c() == true) goto L14;
        return "test_keyid";
    L14:
        return "app_secure_sdk_overseas";
    L10:
        if (b3.c() == true) goto L15;
        return "app_secure_sdk";
    L15:
        return "app_secure_sdk_overseas";
    }

    @Override // tmsdkobf.td
    public int c() {
        return 2;
    }

    @Override // tmsdkobf.td
    public List c(int r1, int r2) {
        q8.c("shark_PubSharkConfig", "getHttpUrls");
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(m6.a()) == true) goto L5;
        r0.add(m6.a());
    L5:
        return r0;
    }

    @Override // tmsdkobf.td
    public List d(int r1, int r2) {
        q8.c("shark_PubSharkConfig", "getHttpUrlsForIPv4Report");
        ArrayList r0 = new ArrayList();
        r0.add(m6.a());
        return r0;
    }

    @Override // tmsdkobf.td
    public List e(int r1, int r2) {
        q8.c("shark_PubSharkConfig", "getHttpUrlsIPv6");
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(m6.b()) == true) goto L5;
        r0.add(m6.b());
    L5:
        return r0;
    }

    @Override // tmsdkobf.td
    public List i(int r2, int r3) {
        q8.c("shark_PubSharkConfig", "getTcpIPPortsIPv6");
        ArrayList r1 = new ArrayList();
        if (TMSDKContext.getStrFromEnvMap(TMSDKContext.PRE_USE_IP_LIST).equals("false") == false) goto L5;
        return r1;
    L5:
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L14;
        if (m6.d().isEmpty() == true) goto L23;
        r1.addAll(m6.d());
    L23:
        return r1;
    L14:
        if (TextUtils.isEmpty(m6.h()) == true) goto L23;
        String r4 = m6.h();
    L22:
        r1.add(r4);
        goto L23
    L17:
        if (TextUtils.isEmpty(m6.j()) == true) goto L23;
        r4 = m6.j();
        goto L22
    L20:
        if (TextUtils.isEmpty(m6.f()) == true) goto L23;
        r4 = m6.f();
        goto L22
    }

    @Override // tmsdkobf.td
    public String a(int r1) {
        if (c(r1) == false) goto L10;
        if (b3.c() == false) goto L7;
        return "56f386008a13359faca41aae2e6eb8d641a967df6e05bbe7d469a09dc71f2ba300ca1b060fe9e10e9ff44d1fd5942898997f917067e0a241484fc79f123019b6";
    L7:
        return "d9140dd439ed059c554004dc94aca47ba66eebf45fb5bdb4cab3015143a4e67f435c7c4328b47fceb3b2873f75ece90e69f4f4eae95be0bdb3861ecccea2d488";
    L10:
        if (b3.c() == false) goto L12;
        return "56f386008a13359faca41aae2e6eb8d641a967df6e05bbe7d469a09dc71f2ba300ca1b060fe9e10e9ff44d1fd5942898997f917067e0a241484fc79f123019b6";
    L12:
        return "74cb851eaf447e152d21a73c8802d8f0f461801d98b582966a1b320477f7fbb147a317bc2f9fbcf94ca2d0e285c83322df8f21efd5e315742d039b6bd28740fa";
    }

    @Override // tmsdkobf.td
    public boolean d() {
        if (TextUtils.isEmpty(this.f637a) == true) goto L7;
        q8.c("shark_PubSharkConfig", "isSupportIPv6 false");
        return false;
    L7:
        if (TextUtils.isEmpty(m6.l()) == false) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(m6.b()) == true) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // tmsdkobf.td
    public List f(int r1, int r2) {
        q8.c("shark_PubSharkConfig", "getTcpDomainPorts");
        ArrayList r0 = new ArrayList();
        r0.add(m6.k());
        return r0;
    }

    @Override // tmsdkobf.td
    public List g(int r1, int r2) {
        q8.c("shark_PubSharkConfig", "getTcpDomainPortsIPv6");
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(m6.l()) == true) goto L5;
        r0.add(m6.l());
    L5:
        return r0;
    }

    @Override // tmsdkobf.td
    public List h(int r2, int r3) {
        q8.c("shark_PubSharkConfig", "getTcpIPPorts");
        ArrayList r1 = new ArrayList();
        if (TMSDKContext.getStrFromEnvMap(TMSDKContext.PRE_USE_IP_LIST).equals("false") == false) goto L5;
        return r1;
    L5:
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L14;
        if (m6.c().isEmpty() == true) goto L23;
        r1.addAll(m6.c());
    L23:
        return r1;
    L14:
        if (TextUtils.isEmpty(m6.g()) == true) goto L23;
        String r4 = m6.g();
    L22:
        r1.add(r4);
        goto L23
    L17:
        if (TextUtils.isEmpty(m6.i()) == true) goto L23;
        r4 = m6.i();
        goto L22
    L20:
        if (TextUtils.isEmpty(m6.e()) == true) goto L23;
        r4 = m6.e();
        goto L22
    }
}
