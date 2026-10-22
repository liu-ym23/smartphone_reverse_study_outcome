package d.b.b.e.a.i;

import com.bytedance.bdlocation.client.LocationInfoConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private JSONObject A;
    private String B;
    private long C;
    private long D;
    private long E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f12608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f12610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f12612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f12613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f12614j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f12615k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f12616l;
    private int m;
    private String n;
    private String o;
    private String p;
    private String q;
    private long r;
    private String s;
    private String t;
    private String u;
    private long v;
    private long w;
    private String x;
    private JSONObject y;
    private JSONObject z;

    public a() {
        this.f12614j = LocationInfoConst.SYSTEM;
        this.f12615k = "android";
        this.C = -1;
    }

    long A() {
        return this.v;
    }

    String B() {
        return this.f12608d;
    }

    String C() {
        return this.x;
    }

    String D() {
        return this.f12611g;
    }

    String E() {
        return this.f12612h;
    }

    void F(int r1) {
        this.f12605a = r1;
    }

    void G(int r1) {
        this.m = r1;
    }

    void H(String r1) {
        this.f12609e = r1;
    }

    void I(String r1) {
        this.f12607c = r1;
    }

    void J(long r1) {
        this.C = r1;
    }

    void K(String r1) {
        this.B = r1;
    }

    void L(String r1) {
        this.o = r1;
    }

    void M(String r1) {
        this.f12606b = r1;
    }

    void N(String r1) {
        this.p = r1;
    }

    void O(String r1) {
        this.n = r1;
    }

    void P(String r1) {
        this.f12615k = r1;
    }

    public void Q(JSONObject r1) {
        this.y = r1;
    }

    void R(JSONObject r1) {
        this.A = r1;
    }

    void S(String r1) {
        this.f12610f = r1;
    }

    void T(String r1) {
        this.u = r1;
    }

    public void U(long r1) {
        this.E = r1;
    }

    public void V(long r1) {
        this.D = r1;
    }

    void W(String r1) {
        this.f12614j = r1;
    }

    void X(String r1) {
        this.f12616l = r1;
    }

    void Y(String r1) {
        this.t = r1;
    }

    void Z(long r1) {
        this.w = r1;
    }

    int a() {
        return this.f12605a;
    }

    void a0(String r1) {
        this.q = r1;
    }

    int b() {
        return this.m;
    }

    void b0(String r1) {
        this.f12613i = r1;
    }

    String c() {
        return this.f12609e;
    }

    void c0(String r1) {
        this.s = r1;
    }

    String d() {
        return this.f12607c;
    }

    void d0(long r1) {
        this.r = r1;
    }

    long e() {
        return this.C;
    }

    public void e0(JSONObject r1) {
        this.z = r1;
    }

    String f() {
        return this.B;
    }

    void f0(long r1) {
        this.v = r1;
    }

    String g() {
        return this.o;
    }

    void g0(String r1) {
        this.f12608d = r1;
    }

    String h() {
        return this.f12606b;
    }

    void h0(String r1) {
        this.x = r1;
    }

    String i() {
        return this.p;
    }

    void i0(String r1) {
        this.f12611g = r1;
    }

    String j() {
        return this.n;
    }

    void j0(String r1) {
        this.f12612h = r1;
    }

    String k() {
        return this.f12615k;
    }

    public JSONObject l() {
        return this.y;
    }

    JSONObject m() {
        return this.A;
    }

    String n() {
        return this.f12610f;
    }

    String o() {
        return this.u;
    }

    public long p() {
        return this.E;
    }

    public long q() {
        return this.D;
    }

    String r() {
        return this.f12614j;
    }

    String s() {
        return this.f12616l;
    }

    String t() {
        return this.t;
    }

    public String toString() {
        return "HeaderInfo{aid=" + this.f12605a + ", deviceId='" + this.f12606b + "', channel='" + this.f12607c + "', updateVersionCode='" + this.f12608d + "', appVersion='" + this.f12609e + "', manifestVersionCode='" + this.f12610f + "', versionCode='" + this.f12611g + "', versionName='" + this.f12612h + "', releaseBuild='" + this.f12613i + "', os='" + this.f12614j + "', devicePlatform='" + this.f12615k + "', osVersion='" + this.f12616l + "', apiVersion=" + this.m + ", deviceModel='" + this.n + "', deviceBrand='" + this.o + "', deviceManufacturer='" + this.p + "', processName='" + this.q + "', sid=" + this.r + ", romVersion='" + this.s + "', packageName='" + this.t + "', monitorVersion='" + this.u + "', uid=" + this.v + ", phoneStartTime=" + this.w + ", verifyInfo='" + this.x + "', dynamicExtra=" + this.y + ", stableExtra=" + this.z + ", filters=" + this.A + ", currentUpdateVersionCode='" + this.B + "'}";
    }

    long u() {
        return this.w;
    }

    String v() {
        return this.q;
    }

    String w() {
        return this.f12613i;
    }

    String x() {
        return this.s;
    }

    long y() {
        return this.r;
    }

    public JSONObject z() {
        return this.z;
    }
}
