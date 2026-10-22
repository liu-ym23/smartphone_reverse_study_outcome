package os.teatracker;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    public interface a {
        void a(String r1);

        void b(String r1);
    }

    public static void a(a r1) {
        d.h().b(r1);
    }

    private static void b() {
        f r0 = d.h().g();
        if (r0 == null) goto L8;
        if (TextUtils.isEmpty(r0.a()) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("You must first call method init to provide an appId via TeaConfig param.");
    }

    public static String c() {
        return d.h().e();
    }

    public static String d() {
        return d.h().f();
    }

    public static String e() {
        return d.h().i();
    }

    public static void f(Context r1, f r2) {
        d.h().j(r1, r2);
    }

    public static void g(String r2, JSONObject r3) {
        b();
        d.h().l(new h(r2, k.a(r3)));
    }
}
