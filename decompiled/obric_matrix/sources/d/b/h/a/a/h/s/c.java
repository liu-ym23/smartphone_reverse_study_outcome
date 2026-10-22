package d.b.h.a.a.h.s;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f13741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f13742b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f13743c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f13744d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile List<String> f13745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile List<String> f13746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f13747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile List<Pattern> f13748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile List<String> f13749i;

    static {
        f13745e = new ArrayList();
        f13746f = new ArrayList();
        f13747g = false;
        f13748h = new ArrayList();
        f13749i = new CopyOnWriteArrayList();
    }

    private static String a(String r2, String r3) {
        if (f13744d == true) goto L5;
        return r2;
    L5:
        String r0 = null;
        if (r3.equals(LocationInfoConst.HTTPS) == false) goto L9;
        r0 = "http";
    L12:
        if (com.bytedance.common.utility.k.c(r0) == false) goto L14;
        return r2;
    L14:
        return r2.replaceFirst(r3, r0);
    L9:
        if (r3.equals("wss") == false) goto L12;
        r0 = "ws";
        goto L12
    }

    public static void b(boolean r0) {
        f13743c = r0;
    }

    private static int c(String r4, String r5, int r6) {
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r6) goto L11;
        if (r1 != 0) goto L6;
        int r3 = 0;
    L7:
        r2 = r4.indexOf(r5, r3);
        if (r2 == (-1)) goto L9;
        r1 = r1 + 1;
        goto L3
    L9:
        return 0;
    L6:
        r3 = r2 + 1;
        goto L7
    L11:
        return r2;
    }

    public static String d(Context r2, String r3) {
        InputStream r0 = null;
        r0 = r2.getAssets().open(r3);     // Catch: Throwable -> L9
        byte[] r4 = new byte[r0.available()];     // Catch: Throwable -> L9
        r0.read(r4);     // Catch: Throwable -> L9
        String r5 = new String(r4, "UTF-8");     // Catch: Throwable -> L9
        if (r0 == null) goto L22;
        r0.close();     // Catch: IOException -> L7
        return r5;
    L7:
        e = move-exception;
        e.printStackTrace();
        return r5;
    L22:
        return r5;
    L9:
        if (r0 != null) goto L16;
    L14:
        return "";
    L16:
        r0.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    private static boolean e(String r4, String r5) {
        if (f13745e.isEmpty() == true) goto L5;
    L11:
        Iterator<String> r0 = f13745e.iterator();
    L13:
        if (r0.hasNext() == false) goto L17;
        if (l.i(r4, r0.next()) == false) goto L13;
        return true;
    L17:
        Iterator<String> r1 = f13749i.iterator();
    L19:
        if (r1.hasNext() == false) goto L23;
        if (l.i(r4, r1.next()) == false) goto L19;
        return true;
    L23:
        Iterator<String> r2 = f13746f.iterator();
    L25:
        if (r2.hasNext() == false) goto L29;
        if (l.i(r5, r2.next()) == false) goto L25;
        return true;
    L29:
        String r6 = r4 + r5;
        Iterator<Pattern> r7 = f13748h.iterator();
    L31:
        if (r7.hasNext() == false) goto L36;
        if (r7.next().matcher(r6).matches() == false) goto L31;
        return true;
    L36:
        return false;
    L5:
        if (f13746f.isEmpty() == false) goto L11;
        if (f13748h.isEmpty() == false) goto L11;
        if (f13749i.isEmpty() == false) goto L11;
        return false;
    }

    public static boolean f(Context r2) {
        String r3 = r2.getFilesDir().getAbsolutePath();
        if (TextUtils.isEmpty(r3) == false) goto L11;
        return false;
    L11:
        if (new File(r3 + "/ttnet_boe.flag").exists() == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public static boolean g(Context r2) {
        String r3 = d(r2, "ttnet_config.json");
        if (TextUtils.isEmpty(r3) == false) goto L10;
    L8:
        return false;
    L10:
        if (new JSONObject(r3).optBoolean("boe_proxy_enabled", false) == false) goto L8;
        return true;
    }

    public static boolean h() {
        return f13743c;
    }

    public static void i(JSONObject r3) {
        if (f13743c == false) goto L16;
        if (r3 == null) goto L20;
        JSONArray r4 = r3.optJSONArray("boe_bypass_host_list");
        if (r4 != null) goto L9;
        return;
    L9:
        int r0 = 0;
    L11:
        if (r0 >= r4.length()) goto L21;
        String r1 = r4.optString(r0);
        if (com.bytedance.common.utility.k.c(r1) == true) goto L15;
        f13749i.add(r1);
    L15:
        r0 = r0 + 1;
        goto L11
    L21:
        return;
    L20:
        return;
    }

    private static String j(String r3, String r4) {
        if (TextUtils.isEmpty(f13742b) == false) goto L5;
        return r3;
    L5:
        String[] r5 = r4.split("\\.");
        int r0 = r5.length;
        if (r0 >= 2) goto L8;
        return r3;
    L8:
        int r1 = r0 - 2;
        String r6 = r5[r1];
        if (r6.contains(f13742b) == false) goto L12;
        return r3;
    L12:
        return k(r3, c(r3, ".", r1), r6, r6 + f13742b);
    }

    private static String k(String r1, int r2, String r3, String r4) {
        return r1.substring(0, r2) + r1.substring(r2).replaceFirst(r3, r4);
    }

    public static String l(String r3) {
        if (f13743c == true) goto L5;
    L20:
        return null;
    L5:
        if (f13744d == false) goto L20;
        if (r3 == null) goto L20;
        if (r3.contains(f13741a) == false) goto L20;
        String r0 = Uri.parse(r3).getScheme();
        String r1 = "http";
        if ("http".equals(r0) == false) goto L15;
        String r2 = LocationInfoConst.HTTPS;
    L14:
        r3 = r3.replaceFirst(r1, r2);
    L19:
        return r3.replaceFirst(f13741a, "");
    L15:
        r1 = "ws";
        if ("ws".equals(r0) == false) goto L19;
        r2 = "wss";
        goto L14
    }

    public static void m(String r0) {
        f13742b = r0;
        if (TextUtils.isEmpty(r0) == true) goto L6;
        f13744d = false;
        return;
    }

    public static void n(String r0) {
        f13741a = r0;
        if (TextUtils.isEmpty(r0) == true) goto L6;
        f13744d = true;
        return;
    }

    public static String o(Context r5, String r6, List<d.b.r.h0.b> r7) {
        boolean r1 = false;
        if (f13747g == true) goto L15;
        if (f13743c == true) goto L15;
        if (g(r5) == false) goto L9;
    L12:
        boolean r8 = true;
    L13:
        f13743c = r8;
        f13747g = true;
        goto L15
    L9:
        if (f(r5) == true) goto L12;
        r8 = false;
    L15:
        if (f13743c == true) goto L17;
    L61:
        return r6;
    L17:
        if (TextUtils.isEmpty(f13741a) == true) goto L19;
    L21:
        Uri r9 = Uri.parse(r6);
        if (com.bytedance.common.utility.k.c(r9.getScheme()) == true) goto L61;
        if (com.bytedance.common.utility.k.c(r9.getHost()) == true) goto L61;
        if (com.bytedance.common.utility.k.c(r9.getPath()) == true) goto L61;
        if (e(r9.getHost(), r9.getPath()) == false) goto L31;
        return r6;
    L31:
        Iterator<d.b.r.h0.b> r10 = r7.iterator();
    L33:
        if (r10.hasNext() == false) goto L44;
        d.b.r.h0.b r0 = r10.next();
        if (com.bytedance.common.utility.k.c(r0.a()) == true) goto L33;
        if (com.bytedance.common.utility.k.c(r0.b()) == true) goto L33;
        if (r0.a().equals("bypass-boe") == false) goto L33;
        if (r0.b().equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L33;
        return r6;
    L44:
        String r11 = a(r6, r9.getScheme());
        if (e.a(r9.getHost()) == false) goto L47;
    L50:
        r1 = true;
    L51:
        if (r1 == false) goto L53;
        return r11;
    L53:
        boolean r12 = f13744d;
        String r13 = r9.getHost();
        if (r12 == false) goto L60;
        if (r13.contains(f13741a) == false) goto L58;
        return r11;
    L58:
        return r11.replaceFirst(r13, r13 + f13741a);
    L60:
        return j(r11, r13);
    L47:
        if (e.c(r9.getHost()) == true) goto L50;
        if (e.b(r9.getHost()) == false) goto L51;
    L19:
        if (TextUtils.isEmpty(f13742b) == false) goto L21;
        goto L21
    }
}
