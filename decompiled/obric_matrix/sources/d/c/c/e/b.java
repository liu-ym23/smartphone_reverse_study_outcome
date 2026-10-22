package d.c.c.e;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f15388c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15390b;

    static {
        f15388c = new b();
    }

    private b() {
        this.f15389a = EnvironmentCompat.MEDIA_UNKNOWN;
        this.f15390b = 5;
    }

    public static b i() {
        return f15388c;
    }

    private static String j(String r1, Throwable r2) {
        return r1 + '\n' + k(r2);
    }

    private static String k(Throwable r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        StringWriter r0 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r0));
        return r0.toString();
    }

    private String l(String r2) {
        if (this.f15389a != null) goto L5;
        return r2;
    L5:
        return this.f15389a + ":" + r2;
    }

    private void m(int r1, String r2, String r3) {
        Log.println(r1, l(r2), r3);
    }

    private void n(int r1, String r2, String r3, Throwable r4) {
        Log.println(r1, l(r2), j(r3, r4));
    }

    @Override // d.c.c.e.c
    public void a(String r2, String r3) {
        m(3, r2, r3);
    }

    @Override // d.c.c.e.c
    public void b(String r2, String r3, Throwable r4) {
        n(6, r2, r3, r4);
    }

    @Override // d.c.c.e.c
    public void c(String r2, String r3) {
        m(6, r2, r3);
    }

    @Override // d.c.c.e.c
    public void d(String r2, String r3) {
        m(5, r2, r3);
    }

    @Override // d.c.c.e.c
    public void d(String r2, String r3, Throwable r4) {
        n(3, r2, r3, r4);
    }

    @Override // d.c.c.e.c
    public void e(String r2, String r3) {
        m(2, r2, r3);
    }

    @Override // d.c.c.e.c
    public void e(String r2, String r3, Throwable r4) {
        n(6, r2, r3, r4);
    }

    @Override // d.c.c.e.c
    public void f(String r2, String r3) {
        m(6, r2, r3);
    }

    @Override // d.c.c.e.c
    public boolean g(int r1) {
        if (this.f15390b > r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // d.c.c.e.c
    public void h(int r1) {
        this.f15390b = r1;
    }

    @Override // d.c.c.e.c
    public void w(String r2, String r3, Throwable r4) {
        n(5, r2, r3, r4);
    }
}
