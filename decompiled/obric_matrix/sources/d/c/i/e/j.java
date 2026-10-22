package d.c.i.e;

import android.net.Uri;
import com.bytedance.bdlocation.client.LocationInfoConst;

/* JADX INFO: loaded from: classes2.dex */
public class j implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static j f15965d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String[] f15968c;

    static {
    }

    protected j() {
        this.f15966a = false;
        this.f15967b = false;
        this.f15968c = null;
    }

    public static synchronized j h() {
        monitor-enter(j.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f15965d != null) goto L7;
        f15965d = new j();     // Catch: Throwable -> L10
    L7:
        j r1 = f15965d;     // Catch: Throwable -> L10
        monitor-exit(j.class);
        return r1;
    }

    private String i(Uri r6) {
        if (r6 != null) goto L6;
        return "";
    L6:
        if ("http".equals(r6.getScheme()) == false) goto L8;
    L11:
        String[] r0 = this.f15968c;
        if (r0 == null) goto L30;
        if (r0.length <= 0) goto L30;
        String r1 = r6.getHost();
        if (r1 == null) goto L28;
        String[] r2 = this.f15968c;
        int r3 = r2.length;
        int r4 = 0;
    L19:
        if (r4 >= r3) goto L28;
        String r5 = r2[r4];
        if (r5 == null) goto L26;
        if (r1.endsWith(r5) == false) goto L26;
        return j(r6);
    L26:
        r4 = r4 + 1;
    L28:
        return r6.toString();
    L30:
        return r6.toString();
    L8:
        if (LocationInfoConst.HTTPS.equals(r6.getScheme()) == true) goto L11;
        return r6.toString();
    }

    private String j(Uri r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.getScheme());
        r0.append(":");
        if (r3.getEncodedAuthority() == null) goto L5;
        r0.append("//");
    L5:
        String r1 = r3.getEncodedPath();
        if (r1 == null) goto L9;
        r0.append(r1);
    L9:
        if (this.f15967b == true) goto L11;
        String r2 = r3.getEncodedQuery();
        if (r2 == null) goto L15;
        r0.append("?");
        r0.append(r2);
    L15:
        String r4 = r3.getEncodedFragment();
        if (r4 == null) goto L19;
        r0.append("#");
        r0.append(r4);
    L19:
        return r0.toString();
    L11:
        return r0.toString();
    }

    @Override // d.c.i.e.f
    public d.c.b.a.d a(d.c.i.q.b r10, Object r11) {
        Uri r0 = r10.v();
        f(r0);
        return new c(g(r0), r10.r(), r10.s(), r10.g(), null, null, r11);
    }

    @Override // d.c.i.e.f
    public d.c.b.a.d b(d.c.i.q.b r2, Object r3) {
        Uri r0 = r2.v();
        f(r0);
        return new v(r0.toString(), r2.r(), r2.u());
    }

    @Override // d.c.i.e.f
    public d.c.b.a.d c(d.c.i.q.b r1, Uri r2, Object r3) {
        f(r2);
        return new d.c.b.a.j(g(r2));
    }

    @Override // d.c.i.e.f
    public d.c.b.a.d d(d.c.i.q.b r11, Object r12) {
        d.c.i.q.d r0 = r11.j();
        if (r0 == null) goto L5;
        d.c.b.a.d r1 = r0.c();
        String r8 = r0.getClass().getName();
        d.c.b.a.d r7 = r1;
    L6:
        Uri r2 = r11.v();
        f(r2);
        return new c(g(r2), r11.r(), r11.s(), r11.g(), r7, r8, r12);
    L5:
        r7 = null;
        r8 = null;
        goto L6
    }

    @Override // d.c.i.e.f
    public d.c.b.a.d e(d.c.i.q.b r2, Object r3) {
        return c(r2, r2.v(), r3);
    }

    protected Uri f(Uri r1) {
        return r1;
    }

    protected String g(Uri r2) {
        if (this.f15966a == false) goto L7;
        return i(r2);
    L7:
        return r2.toString();
    }
}
