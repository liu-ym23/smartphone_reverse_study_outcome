package l.b.h;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f22287a = null;

    static class a implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f22288a;

        a(String r1) {
            this.f22288a = r1;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return Security.getProperty(this.f22288a);
        }
    }

    static class b implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f22289a;

        b(String r1) {
            this.f22289a = r1;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return System.getProperty(this.f22289a);
        }
    }

    static {
        f22287a = new ThreadLocal();
    }

    public static String a(String r1) {
        String r0 = (String) AccessController.doPrivileged(new a(r1));
        if (r0 == null) goto L5;
        return r0;
    L5:
        Map r2 = (Map) f22287a.get();
        if (r2 == null) goto L11;
        String r3 = (String) r2.get(r1);
        if (r3 == null) goto L11;
        return r3;
    L11:
        return (String) AccessController.doPrivileged(new b(r1));
    }

    public static boolean b(String r0) {
        return c(a(r0));
    L4:
        return false;
    }

    private static boolean c(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.length() == 4) goto L8;
        return false;
    L8:
        if (r5.charAt(0) == 't') goto L12;
        if (r5.charAt(0) == 'T') goto L12;
        return false;
    L12:
        if (r5.charAt(1) == 'r') goto L16;
        if (r5.charAt(1) == 'R') goto L16;
        return false;
    L16:
        if (r5.charAt(2) == 'u') goto L20;
        if (r5.charAt(2) == 'U') goto L20;
        return false;
    L20:
        if (r5.charAt(3) == 'e') goto L24;
        if (r5.charAt(3) == 'E') goto L24;
        return false;
    L24:
        return true;
    }
}
