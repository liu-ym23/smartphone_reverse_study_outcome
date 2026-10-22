package d.h.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<i> f16991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile f f16992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final List<g> f16993c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f16994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f16995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f16996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Context f16997g;

    static {
        f16991a = new ArrayList();
        f16993c = new ArrayList();
        f16994d = false;
        f16995e = false;
        f16996f = true;
    }

    public static void a(i r1) {
        f16991a.add(r1);
    }

    @Nullable
    static f b() {
        return f16992b;
    }

    public static boolean c() {
        return f16996f;
    }

    public static boolean d(Context r2) {
        ConnectivityManager r3 = (ConnectivityManager) r2.getSystemService("connectivity");     // Catch: Exception -> L11
        if (r3 == null) goto L14;
        NetworkInfo r4 = r3.getActiveNetworkInfo();     // Catch: Exception -> L11
        if (r4 == null) goto L15;
        if (r4.isAvailable() == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L14:
        return false;
    L17:
        return false;
    }

    static boolean e() {
        return f16994d;
    }

    static boolean f() {
        return f16995e;
    }

    static void g(boolean r2, String r3, JSONObject r4) {
        if (r2 == true) goto L11;
        Context r0 = f16997g;
        if (r0 == null) goto L9;
        if (d(r0) == true) goto L9;
        return;
    L9:
        if (d.b.i.a.a.a.a("image_monitor_error_v2") == false) goto L11;
        d.b.i.a.a.a.b("image_monitor_error_v2", r4);
    L11:
        Iterator<i> r1 = f16991a.iterator();
    L13:
        if (r1.hasNext() == false) goto L17;
        i r5 = r1.next();
        if (r5 == null) goto L13;
        r5.a(r2, r3, r4);
        goto L13
    }

    public static void h(Context r0) {
        f16997g = r0;
    }

    public static void i(boolean r0) {
        f16996f = r0;
    }

    @Deprecated
    public static void j(i r0) {
        a(r0);
    }

    public static void k(boolean r0) {
        f16994d = r0;
    }

    public static void l(boolean r0) {
        f16995e = r0;
    }
}
