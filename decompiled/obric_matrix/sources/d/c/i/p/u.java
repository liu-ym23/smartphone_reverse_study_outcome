package d.c.i.p;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class u extends c<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f16434b;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ t f16435f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g0.a f16436g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ u f16437h;

        a(u r1, t r2, g0.a r3) {
            this.f16437h = r1;
            this.f16435f = r2;
            this.f16436g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16437h.h(this.f16435f, this.f16436g);
        }
    }

    class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Future f16438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g0.a f16439b;

        b(u r1, Future r2, g0.a r3) {
            this.f16438a = r2;
            this.f16439b = r3;
        }

        @Override // d.c.i.p.m0
        public void a() {
            if (this.f16438a.cancel(false) == false) goto L6;
            this.f16439b.b();
            return;
        }
    }

    public u(int r2) {
        this(Executors.newFixedThreadPool(3));
        this.f16433a = r2;
    }

    u(ExecutorService r1) {
        this.f16434b = r1;
    }

    private HttpURLConnection f(Uri r8, int r9) {
        HttpURLConnection r0 = k(r8);
        r0.setConnectTimeout(this.f16433a);
        int r1 = r0.getResponseCode();
        if (j(r1) == false) goto L6;
        return r0;
    L6:
        if (i(r1) == false) goto L23;
        String r2 = r0.getHeaderField("Location");
        r0.disconnect();
        if (r2 != null) goto L10;
        Uri r3 = null;
    L11:
        String r4 = r8.getScheme();
        if (r9 <= 0) goto L18;
        if (r3 == null) goto L18;
        if (r3.getScheme().equals(r4) == true) goto L18;
        return f(r3, r9 - 1);
    L18:
        if (r9 != 0) goto L20;
        String r7 = g("URL %s follows too many redirects", new Object[]{r8.toString()});
    L22:
        throw new IOException(r7);
    L20:
        r7 = g("URL %s returned %d without a valid redirect", new Object[]{r8.toString(), Integer.valueOf(r1)});
        goto L22
    L10:
        r3 = Uri.parse(r2);
        goto L11
    L23:
        r0.disconnect();
        throw new IOException(String.format("Image URL %s returned HTTP code %d", new Object[]{r8.toString(), Integer.valueOf(r1)}));
    }

    private static String g(String r1, Object... r2) {
        return String.format(Locale.getDefault(), r1, r2);
    }

    private static boolean i(int r1) {
        if (r1 != 307) goto L5;
        return true;
    L5:
        if (r1 == 308) goto L11;
        switch(r1) {
            case 300: goto L12;
            case 301: goto L12;
            case 302: goto L12;
            case 303: goto L12;
            default: goto L7;
        };
    L7:
        return false;
    L12:
        return true;
    L11:
        return true;
    }

    private static boolean j(int r1) {
        if (r1 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 300) goto L7;
        return true;
    }

    static HttpURLConnection k(Uri r0) {
        return (HttpURLConnection) d.c.c.k.f.m(r0).openConnection();
    }

    @Override // d.c.i.p.g0
    public void d(t r3, g0.a r4) {
        Future<?> r0 = this.f16434b.submit(new a(this, r3, r4));
        r3.c().d(new b(this, r0, r4));
    }

    @Override // d.c.i.p.g0
    public t e(k<d.c.i.l.e> r1, l0 r2) {
        return new t(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [d.c.i.p.u] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.net.HttpURLConnection] */
    void h(t r3, g0.a r4) {
        InputStream r0 = null;
        HttpURLConnection r2 = f(r3.j(), 5);     // Catch: Throwable -> L13 IOException -> L15
        if (r2 != null) goto L35;
    L9:
        if (r0 != null) goto L39;
    L11:
        if (r2 == null) goto L42;
    L21:
        r2.disconnect();
        return;
    L42:
        return;
    L39:
        r0.close();     // Catch: IOException -> L29
        goto L11
    L35:
        r0 = r2.getInputStream();     // Catch: IOException -> L7 Throwable -> L23
        r4.c(r0, -1);     // Catch: IOException -> L7 Throwable -> L23
    L7:
        e = e;
    L17:
        r4.a(e);     // Catch: Throwable -> L23
        if (r0 != null) goto L37;
    L20:
        if (r2 != null) goto L21;
        return;
    L37:
        r0.close();     // Catch: IOException -> L30
        goto L20
    L23:
        th = th;
    L24:
        if (0 != 0) goto L33;
    L26:
        if (this == 0) goto L44;
        this.disconnect();
        throw th;
    L44:
        throw th;
    L33:
        r0.close();     // Catch: IOException -> L31
    L15:
        e = e;
        r2 = null;
    L13:
        th = th;
        u this = 0;
        goto L24
    }
}
