package ms.bd.c;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o f22438b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f22439c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.mobsec.metasec.ml.b.a.c f22440a;

    static {
        f22438b = new o();
    }

    public o() {
    }

    public static o a() {
        return f22438b;
    }

    public String b() {
        com.bytedance.mobsec.metasec.ml.b.a.c r15 = this.f22440a;
        if (r15 != null) goto L5;
        return null;
    L5:
        if (f22439c == false) goto L24;
        return null;
    L24:
        f22439c = true;     // Catch: Exception -> L23
        String r16 = r15.a();     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r16) == false) goto L11;
        return null;
    L11:
        if (r16.trim().length() > 3) goto L14;
        return null;
    L14:
        if (r16.contains((String) m.a(16777217, 0, 0, "b5e414", new byte[]{112, 56, 24, 84, 11, 45, 117})) == false) goto L20;
        return new JSONObject(r16).getString((String) m.a(16777217, 0, 0, "623652", new byte[]{36, 63, 78, 86, 15, 43, 33}));
    L20:
        return r16.trim();
    L28:
        return null;
    }
}
