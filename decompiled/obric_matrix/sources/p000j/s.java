package p000j;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f18185a = null;

    static class a extends s {
        a() {
        }
    }

    static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ s f18186a;

        b(s r1) {
            this.f18186a = r1;
        }

        @Override // j.s.c
        public s a(e r1) {
            return this.f18186a;
        }
    }

    public interface c {
        s a(e r1);
    }

    static {
        f18185a = new a();
    }

    public s() {
    }

    static c n(s r1) {
        return new b(r1);
    }

    public void a(e r1) {
    }

    public void b(e r1, IOException r2) {
    }

    public void c(e r1, JSONObject r2) {
    }

    public void d(e r1) {
    }

    public void e(e r1, InetSocketAddress r2, Proxy r3, b0 r4) {
    }

    public void f(e r1, InetSocketAddress r2, Proxy r3, b0 r4, IOException r5) {
    }

    public void g(e r1, InetSocketAddress r2, Proxy r3, b0 r4, IOException r5, String r6) {
    }

    public void h(e r1, InetSocketAddress r2, Proxy r3) {
    }

    public void i(e r1, j r2) {
    }

    public void j(e r1, j r2) {
    }

    public void k(e r1, String r2, List<InetAddress> r3) {
    }

    public void l(e r1, String r2, List<InetAddress> r3, String r4) {
    }

    public void m(e r1, String r2) {
    }

    public void o(e r1, long r2) {
    }

    public void p(e r1) {
    }

    public void q(e r1, d0 r2) {
    }

    public void r(e r1) {
    }

    public void s(e r1, long r2) {
    }

    public void t(e r1) {
    }

    public void u(e r1, f0 r2) {
    }

    public void v(e r1) {
    }

    public void w(e r1, u r2) {
    }

    public void x(e r1) {
    }
}
