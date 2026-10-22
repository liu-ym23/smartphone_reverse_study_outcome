package d.h.a;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f16986a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f16987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f16988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f16989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f16990e;

    static {
        long r0 = e();
        f16986a = r0;
        f16987b = 2;
        f16988c = 20971520;
        f16989d = r0;
        f16990e = false;
    }

    public static void a(d.c.i.q.b r15, String r16, long r17, String r19) {
        d.c.i.a r0 = r15.t();
        if (r0 != null) goto L5;
        return;
    L5:
        Pair<Integer, Integer> r1 = r0.d();
        Pair<Integer, Integer> r2 = g(r16);
        if (r1 == null) goto L13;
        if (r2 == null) goto L15;
        int r3 = ((Integer) r1.first).intValue();
        int r4 = ((Integer) r1.second).intValue();
        int r12 = ((Integer) r2.first).intValue();
        int r5 = ((Integer) r2.second).intValue();
        long r13 = Long.parseLong(r19);
        if (b(r3, r4, r12, r5, r17, r13) == false) goto L14;
        d(r15.v().toString(), r17, r3, r4, r12, r5, r13, j.g(r0.i()));
        return;
    L14:
        return;
    L15:
        return;
    }

    private static boolean b(int r2, int r3, int r4, int r5, long r6, long r8) {
        int r0 = f16987b;
        if (r4 < (r2 * r0)) goto L8;
        if (r5 < (r3 * r0)) goto L8;
        return true;
    L8:
        if (r8 < f16989d) goto L11;
        return true;
    L11:
        if (r6 >= f16988c) goto L15;
        return false;
    L15:
        return true;
    }

    private static int c(int r0, int r1, int r2, int r3) {
        return Math.min((r2 * 1000) / r0, (r3 * 1000) / r1);
    }

    private static void d(String r4, long r5, int r7, int r8, int r9, int r10, long r11, String r13) {
        if (d.b.i.a.a.a.a("image_monitor_exceed_limit_v2") == false) goto L11;
        int r1 = c(r7, r8, r9, r10);
        JSONObject r2 = new JSONObject();
        r2.put(WsConstants.KEY_CONNECTION_URL, r4);     // Catch: JSONException -> L8
        r2.put("file_size", r5);     // Catch: JSONException -> L8
        r2.put("view_width", r7);     // Catch: JSONException -> L8
        r2.put("view_height", r8);     // Catch: JSONException -> L8
        r2.put("image_width", r9);     // Catch: JSONException -> L8
        r2.put("image_height", r10);     // Catch: JSONException -> L8
        r2.put("ram_size", r11);     // Catch: JSONException -> L8
        r2.put("contrast", r1);     // Catch: JSONException -> L8
        r2.put("view_info", r13);     // Catch: JSONException -> L8
    L6:
        d.b.i.a.a.a.b("image_monitor_exceed_limit_v2", r2);
        return;
    }

    private static long e() {
        DisplayMetrics r0 = Resources.getSystem().getDisplayMetrics();
        return (r0.heightPixels * r0.widthPixels) * 4;
    }

    public static boolean f() {
        return f16990e;
    }

    @Nullable
    private static Pair<Integer, Integer> g(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        String[] r4 = r3.split("x");
        if (r4.length == 2) goto L13;
        return null;
    L13:
        int r0 = Integer.parseInt(r4[0]);     // Catch: NumberFormatException -> L12
        int r5 = Integer.parseInt(r4[1]);     // Catch: NumberFormatException -> L12
        return new Pair(Integer.valueOf(r0), Integer.valueOf(r5));
    L15:
        return null;
    }
}
