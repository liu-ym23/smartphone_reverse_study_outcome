package l.b.c.c.b.a;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: l.b.c.c.b.a.a$a, reason: collision with other inner class name */
    static class C0593a implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f21871a;

        C0593a(String r1) {
            this.f21871a = r1;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return Class.forName(this.f21871a);
        L4:
            return null;
        }
    }

    public static Class a(Class r0, String r1) {
        ClassLoader r2 = r0.getClassLoader();     // Catch: ClassNotFoundException -> L8
        if (r2 == null) goto L7;
        return r2.loadClass(r1);
    L7:
        return (Class) AccessController.doPrivileged(new C0593a(r1));
    L8:
        return null;
    }
}
