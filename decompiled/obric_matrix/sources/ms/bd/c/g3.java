package ms.bd.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f22359a;

    public interface a {
        void a(String r1);
    }

    public g3(a r1) {
        this.f22359a = r1;
    }

    private String a(String r27) {
        if (r27 != null) goto L14;
        return null;
    L14:
        Class<?> r2 = Class.forName((String) m.a(16777217, 0, 0, "05bc89", new byte[]{32, 57, 21, 5, 8, 39, 55, 90, 60, 32, 111, 4, 8, 4, 19, 43, 62, 36, 33, 60, 49, 50, 3, 3, 14, 43, 32}));     // Catch: Exception -> L12
        Method r0 = r2.getMethod((String) m.a(16777217, 0, 0, "ed851d", new byte[]{115, 99, 95}), new Class[]{String.class, String.class});     // Catch: Exception -> L12
        Object[] r3 = new Object[2];     // Catch: Exception -> L12
        r3[0] = r27;     // Catch: Exception -> L12
        r3[1] = (String) m.a(16777217, 0, 0, "78aa76", new byte[]{51, 52, 25, 27, 7, 54, 58});     // Catch: Exception -> L12
        return (String) r0.invoke(r2, r3);
    L12:
        return null;
    }

    static String b(g3 r0) {
        r0.getClass();
        return Build.MANUFACTURER.toUpperCase();
    }

    static /* synthetic */ a e(g3 r0) {
        return r0.f22359a;
    }

    public void c(Context r3) {
        new Thread(new f3(this, r3)).start();
    }

    public boolean d() {
        String r7 = a((String) m.a(16777217, 0, 0, "c79c0a", new byte[]{96, 58, 4, 21, 26, 127, 108, 18, 38, 37, 119, 39, 89, 30, 0, 120, 46, 19, 101, 38, 123}));
        if (TextUtils.isEmpty(r7) == false) goto L5;
    L7:
        return false;
    L5:
        if (r7.contains((String) m.a(16777217, 0, 0, "524086", new byte[]{49, 62, 76, 74, 8, 54, 56})) == true) goto L7;
        return true;
    }

    public boolean f() {
        String r7 = a((String) m.a(16777217, 0, 0, "c5ba33", new byte[]{96, 56, 95, 24, 5, 49, 105, 90, 38, 56, 60, 33, 20, 7, 31, 45, 111, 26, 125, 63, 115, 58, 20}));
        if (TextUtils.isEmpty(r7) == false) goto L5;
    L7:
        return false;
    L5:
        if (r7.contains((String) m.a(16777217, 0, 0, "adbc30", new byte[]{101, 104, 26, 25, 3, 48, 108})) == true) goto L7;
        return true;
    }
}
