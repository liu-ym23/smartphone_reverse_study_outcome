package tmsdkobf;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected td f657a;
    private el b;
    private a c;

    public interface a {
    }

    public z6(String r1, td r2, int r3) {
        if (r2 == null) goto L7;
        this.f657a = r2;
        this.b = new el(r1, this, r3);
        return;
    L7:
        throw new IllegalArgumentException("ISharkOutlet(): sharkConfig must not be null!");
    }

    public abstract void a(int r1, int r2);

    public void a(int r1, String r2, int r3) {
    }

    public void a(Thread r1, Throwable r2, String r3, byte[] r4) {
    }

    public void a(Socket r1) {
    }

    public void a(HashMap r1) {
    }

    public boolean a() {
        return true;
    }

    public long b() {
        return 0;
    }

    public void b(int r1, int r2) {
    }

    public abstract boolean b(int r1);

    public int c() {
        return 0;
    }

    public void c(int r1, int r2) {
    }

    public abstract int d();

    public nd d(int r2) {
        if (t() == true) goto L5;
        return null;
    L5:
        return this.b.c(r2);
    }

    public abstract void d(String r1);

    public abstract boolean d(String r1, boolean r2);

    public int e() {
        return -9999;
    }

    public String f() {
        return this.b.b();
    }

    public abstract String g();

    public long h() {
        return this.b.c();
    }

    public d1 i() {
        return this.b.d();
    }

    public j1 j() {
        return this.b.e();
    }

    public abstract String k();

    public abstract d1 l();

    public pc m() {
        return this.b.g();
    }

    public td n() {
        return this.f657a;
    }

    public String o() {
        return this.b.h();
    }

    public abstract String p();

    public String q() {
        return null;
    }

    public void r() {
    }

    public void s() {
    }

    public boolean t() {
        return false;
    }

    public boolean u() {
        return false;
    }

    public void e(int r1) {
        this.b.e(r1);
    }

    public void f(int r1) {
        this.b.d(r1);
    }

    public u5 b(String r1) {
        return this.b.a(r1);
    }

    public void c(int r2) {
        if (t() == false) goto L6;
        this.b.a(r2);
        return;
    }

    public void e(String r1, boolean r2) {
        this.b.a(r1, r2);
    }

    public void b(String r1, boolean r2) {
        d(r1);
    }

    public void c(String r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.b.d(r1);
    }

    public int a(int r1) {
        return this.b.b(r1);
    }

    public void c(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.b.c(r1);
    }

    public boolean a(Context r1) {
        if (((TelephonyManager) r1.getSystemService("phone")).getSimState() != 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean a(String r1) {
        return this.b.b(r1);
    }

    public void a(String r1, boolean r2) {
        c(r1);
    }

    public void a(long r1) {
        this.b.a(r1);
    }

    public void a(String r1, long r2, List r4) {
        this.b.a(r1, r2, r4);
    }

    public void a(d1 r1) {
        this.b.a(r1);
    }

    public void a(j1 r1) {
        this.b.a(r1);
    }

    public void a(nd r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (t() == false) goto L8;
        this.b.a(r2);
        return;
    }

    public void a(pc r1) {
        this.b.a(r1);
    }

    public void a(a r1) {
        this.c = r1;
    }

    public void a(c7 r1) {
        this.b.a(r1);
    }
}
