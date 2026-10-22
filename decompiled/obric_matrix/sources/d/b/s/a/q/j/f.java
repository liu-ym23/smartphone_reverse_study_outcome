package d.b.s.a.q.j;

/* JADX INFO: loaded from: classes.dex */
public class f extends b {
    public final String p;
    public final int q;
    public String r;
    public long s;
    public String t;

    @Deprecated
    public String u;

    @Deprecated
    public long v;
    public String w;
    public long x;
    public String y;
    public String z;

    public String b() {
        return "ThirdTokenResponse{platformName='" + this.p + "', platformAppId=" + this.q + ", accessToken='" + com.ss.android.i.l.a.e(this.r) + "', expiresIn=" + this.s + ", openId='" + com.ss.android.i.l.a.e(this.t) + "', scopes='" + this.w + "'}";
    }

    @Override // d.b.s.a.q.j.b
    public String toString() {
        return "ThirdTokenResponse{platformName='" + this.p + "', platformAppId=" + this.q + ", accessToken='" + this.r + "', expiresIn=" + this.s + ", openId='" + this.t + "', refreshToken='" + this.u + "', refreshExpiresIn=" + this.v + ", scopes='" + this.w + "', refreshTime=" + this.x + ", captcha='" + this.y + "', descUrl='" + this.z + "'}";
    }
}
