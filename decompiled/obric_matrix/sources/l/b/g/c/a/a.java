package l.b.g.c.a;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Provider implements l.b.c.c.a.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f22216f = "BouncyCastle Post-Quantum Security Provider v1.67";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f22217g = "BCPQC";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f22218h = null;

    /* JADX INFO: renamed from: l.b.g.c.a.a$a, reason: collision with other inner class name */
    class C0597a implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f22219a;

        C0597a(a r1) {
            this.f22219a = r1;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            a.a(this.f22219a);
            return null;
        }
    }

    static class b implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f22220a;

        b(String r1) {
            this.f22220a = r1;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return Class.forName(this.f22220a);
        L4:
            return null;
        }
    }

    static {
        new HashMap();
        f22218h = new String[]{"Rainbow", "McEliece", "SPHINCS", "LMS", "NH", "XMSS", "QTESLA"};
    }

    public a() {
        super(f22217g, 1.67d, f22216f);
        AccessController.doPrivileged(new C0597a(this));
    }

    static /* synthetic */ void a(a r0) {
        r0.f();
    }

    private void c(String r5, String[] r6) {
        int r0 = 0;
    L4:
        if (r0 == r6.length) goto L13;
        Class r1 = e(a.class, r5 + r6[r0] + "$Mappings");
        if (r1 == null) goto L12;
        ((l.b.c.c.c.a) r1.newInstance()).a(this);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        throw new InternalError("cannot create instance of " + r5 + r6[r0] + "$Mappings : " + e);
    L12:
        r0 = r0 + 1;
        goto L4
    }

    static Class e(Class r0, String r1) {
        ClassLoader r2 = r0.getClassLoader();     // Catch: ClassNotFoundException -> L8
        if (r2 == null) goto L7;
        return r2.loadClass(r1);
    L7:
        return (Class) AccessController.doPrivileged(new b(r1));
    L8:
        return null;
    }

    private void f() {
        c("org.bouncycastle.pqc.jcajce.provider.", f22218h);
    }
}
