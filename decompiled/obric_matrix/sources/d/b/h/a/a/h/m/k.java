package d.b.h.a.a.h.m;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.lang.reflect.Method;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k extends CookieManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f13449f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f13450g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.webkit.CookieManager f13451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile d.b.h.a.a.h.m.c f13452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Pattern f13453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f13454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayList<String> f13455e;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f13456f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ k f13457g;

        a(k r1, Context r2) {
            this.f13457g = r1;
            this.f13456f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.a(this.f13457g, new d.b.h.a.a.h.m.c(new i(this.f13456f), d.f13429a));
        }
    }

    public interface b {
        boolean a();

        void b(String r1, String r2, JSONObject r3);
    }

    private static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f13458f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f13459g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f13460h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f13461i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final c f13462j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final c f13463k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final /* synthetic */ c[] f13464l = null;

        static {
            c r0 = new c("UNKNOWN", 0);
            f13458f = r0;
            c r1 = new c("APP_COOKIE_STORE", 1);
            f13459g = r1;
            c r3 = new c("SHARE_INTERCEPTOR_MAIN", 2);
            f13460h = r3;
            c r5 = new c("SHARE_INTERCEPTOR_BACKUP", 3);
            f13461i = r5;
            c r7 = new c("MAIN", 4);
            f13462j = r7;
            c r9 = new c("BACKUP", 5);
            f13463k = r9;
            f13464l = new c[]{r0, r1, r3, r5, r7, r9};
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f13464l.clone();
        }
    }

    static {
    }

    public k(Context r5, int r6, android.webkit.CookieManager r7, ArrayList<String> r8, b r9) {
        this.f13453c = Pattern.compile("(?<=Domain=)([^;]*)", 2);
        if (d.b.h.a.a.e.b.b() == true) goto L7;
        if (r6 <= 0) goto L6;
        com.bytedance.common.utility.m.a.d().schedule(new a(this, r5), r6, TimeUnit.SECONDS);
        goto L7
    L6:
        this.f13452b = new d.b.h.a.a.h.m.c(new i(r5), d.f13429a);
    L7:
        this.f13451a = r7;
        this.f13455e = r8;
        this.f13454d = r9;
        if (r9 != null) goto L10;
        return;
    L10:
        if (r9.a() == false) goto L19;
        JSONObject r10 = new JSONObject();
        r10.put("init", "success");     // Catch: JSONException -> L15
    L13:
        this.f13454d.b("TTNET-COOKIE", "init", r10);
        return;
    }

    static /* synthetic */ d.b.h.a.a.h.m.c a(k r0, d.b.h.a.a.h.m.c r1) {
        r0.f13452b = r1;
        return r1;
    }

    private static boolean b(String r7) {
        if (r7.length() >= 2) goto L5;
        return false;
    L5:
        int r3 = 1;
        int r4 = 0;
    L7:
        if (r3 >= r7.length()) goto L14;
        if (r7.charAt(r3) != '.') goto L13;
        r4 = r4 + 1;
        if (r4 >= 2) goto L14;
    L13:
        r3 = r3 + 1;
    L14:
        if (r4 >= 2) goto L16;
        return false;
    L16:
        return true;
    }

    private JSONObject c() {
        b r0 = this.f13454d;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.a() == true) goto L8;
        return null;
    L8:
        return new JSONObject();
    }

    private void d(String r2, boolean r3) {
        if (r3 == false) goto L6;
        android.webkit.CookieManager.getInstance().flush();
        Logger.debug();
        return;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L22;
        ArrayList<String> r4 = this.f13455e;
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.isEmpty() == true) goto L24;
        Iterator<String> r1 = this.f13455e.iterator();
    L14:
        if (r1.hasNext() == false) goto L25;
        if (r2.equals(r1.next()) == false) goto L14;
        android.webkit.CookieManager.getInstance().flush();
        Logger.debug();
        return;
    L25:
        return;
    L24:
        return;
    }

    private Map<String, List<String>> e(List<String> r4, Map<String, List<String>> r5) {
        Map<String, List<String>> r0 = Collections.emptyMap();
        if (f13449f == false) goto L18;
        LinkedHashMap r1 = new LinkedHashMap();
        if (r5 == null) goto L10;
        List<String> r2 = g(r5, "Cookie");
        if (r2 == null) goto L10;
        if (r2.isEmpty() == true) goto L10;
    L12:
        if (r5 == null) goto L17;
        List<String> r3 = g(r5, CronetHttpURLConnection.SS_COOKIE);
        if (r3 == null) goto L17;
        if (r3.isEmpty() == true) goto L17;
        return r1;
    L17:
        r1.put(CronetHttpURLConnection.SS_COOKIE, r4);
        return r1;
    L10:
        r1.put("Cookie", r4);
        goto L12
    L18:
        if (r5 == null) goto L24;
        List<String> r6 = g(r5, "Cookie");
        if (r6 == null) goto L24;
        if (r6.isEmpty() == true) goto L24;
        return r0;
    L24:
        return Collections.singletonMap("Cookie", r4);
    }

    private static Map<String, List<String>> f(boolean r0, Map<String, List<String>> r1, c r2) {
        if (r0 == true) goto L4;
        return r1;
    L4:
        if (r1 != null) goto L7;
        return null;
    L7:
        LinkedHashMap r3 = new LinkedHashMap(r1);
        r3.put("x-tt-get-cookie-source", Collections.singletonList(String.valueOf(r2.ordinal())));
        return r3;
    }

    private List<String> g(Map<String, List<String>> r2, String r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L18;
        List<String> r1 = r2.get(r3);
        if (r1 == null) goto L13;
        if (r1.isEmpty() == true) goto L13;
        return r1;
    L13:
        return r2.get(r3.toLowerCase());
    L18:
        return null;
    }

    private boolean h(URI r3, String r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L22;
        String r5 = r3.getHost().toLowerCase();     // Catch: Throwable -> L16
        String r1 = "";
        Matcher r2 = this.f13453c.matcher(r4);     // Catch: Throwable -> L16
        if (r2.find() == false) goto L11;
        r1 = r2.group().toLowerCase();     // Catch: Throwable -> L16
    L11:
        if (TextUtils.isEmpty(r1) == true) goto L20;
        if (r5.endsWith(r1) == false) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L23:
        return false;
    L22:
        return false;
    }

    private /* synthetic */ void i(Map r4) {
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) r5.next();
        this.f13452b.d((URI) r0.getKey(), (List) r0.getValue());     // Catch: Throwable -> L9
        goto L4
    }

    private static void k(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        r1.put(r2, r3);     // Catch: JSONException -> L10
        return;
    L16:
        return;
    }

    private void l(String r2, String r3, Set<String> r4) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L17;
        r4.add(r2);
        this.f13451a.setCookie(r2, r3);
        d.b.h.a.a.h.g.k r1 = d.b.h.a.a.h.g.l();     // Catch: Throwable -> L12
        if (r1 == null) goto L16;
        r1.b(r2, r3);     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L18:
        return;
    }

    private void m(String r7, List<String> r8, Set<String> r9) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return;
    L5:
        if (com.bytedance.common.utility.collection.a.a(r8) == true) goto L34;
        r9.add(r7);
        boolean r0 = false;
        if (d.b.h.a.a.e.b.c() == true) goto L28;
    L10:
        d.b.h.a.a.h.g.k r10 = d.b.h.a.a.h.g.l();
        if (r0 == false) goto L14;
        if (r10 != null) goto L14;
        return;
    L14:
        Iterator<String> r11 = r8.iterator();
    L16:
        if (r11.hasNext() == false) goto L35;
        String r1 = r11.next();
        if (r0 == true) goto L20;
        this.f13451a.setCookie(r7, r1);
    L20:
        if (r10 == null) goto L16;
        r10.b(r7, r1);     // Catch: Throwable -> L25
        goto L16
    L35:
        return;
    L28:
        Method r12 = this.f13451a.getClass().getDeclaredMethod("setCookieList", new Class[]{String.class, List.class});     // Catch: Throwable -> L24
        r12.setAccessible(true);     // Catch: Throwable -> L24
        r0 = ((Boolean) r12.invoke(this.f13451a, new Object[]{r7, r8})).booleanValue();     // Catch: Throwable -> L24
        goto L10
    }

    private void n(URI r17, Map<String, List<String>> r18) {
        if (r17 == null) goto L117;
        if (r18 != null) goto L6;
        return;
    L6:
        if (r18.isEmpty() == true) goto L160;
        List<String> r3 = g(r18, "Set-Cookie");
        if (f13449f == false) goto L14;
        if (com.bytedance.common.utility.e.a(r3) == false) goto L14;
        r3 = g(r18, "X-SS-Set-Cookie");
    L14:
        if (com.bytedance.common.utility.e.a(r3) == false) goto L16;
        return;
    L16:
        d.b.h.a.a.h.g.j r4 = d.b.h.a.a.h.g.k();
        String r5 = null;
        if (r4 == null) goto L19;
        List<String> r6 = r4.g(r17.getHost());
    L20:
        JSONObject r7 = c();
        if (r7 == null) goto L28;
        k(r7, "version", "v2");
        k(r7, WsConstants.KEY_CONNECTION_URL, r17.toString());
        if (r6 != null) goto L25;
        String r8 = "";
    L26:
        k(r7, "shareHostList", r8);
        k(r7, "responseHeaders", r18.toString());
        k(r7, "setCookieList", r3.toString());
        goto L28
    L25:
        r8 = r6.toString();
    L28:
        if (d.b.h.a.a.e.a.c() == true) goto L30;
    L131:
        d.b.h.a.a.h.g.f r9 = d.b.h.a.a.h.g.g();     // Catch: Throwable -> L118
        if (r9 == null) goto L38;
        r9.b(r17, r18);     // Catch: Throwable -> L118
    L38:
        if (this.f13451a != null) goto L45;
        if (r7 == null) goto L41;
        boolean r10 = true;
    L42:
        String r1 = "mCookieMgr is null";
    L43:
        o(r7, r1, r10);
        return;
    L41:
        r10 = false;
        goto L42
    L45:
        HashSet r11 = new HashSet();
        List<String> r2 = r18.get("webview-origin-url");
        if (com.bytedance.common.utility.e.a(r2) == true) goto L49;
        r5 = r2.get(0);
    L49:
        if (TextUtils.isEmpty(r5) == false) goto L123;
    L51:
        final ConcurrentHashMap r12 = new ConcurrentHashMap();
        r12.put(r17, r3);
        Iterator<String> r13 = r3.iterator();
        boolean r14 = false;
    L53:
        if (r13.hasNext() == false) goto L94;
        String r15 = r13.next();
        Logger.debug();
        if (TextUtils.isEmpty(r15) == true) goto L53;
        String r16 = r15.toLowerCase().trim();
        if (r16.contains("sessionid=") == false) goto L60;
        r14 = true;
    L60:
        if (r14 == true) goto L69;
        if (d.b.h.a.a.e.b.f() == false) goto L69;
        if (r16.contains("store-country-code=") == false) goto L66;
    L67:
        r14 = true;
        goto L69
    L66:
        if (r16.contains("store-region=") == true) goto L67;
    L69:
        if (TextUtils.isEmpty(r5) == false) goto L53;
        if (com.bytedance.common.utility.e.a(r6) == true) goto L53;
        if (h(r17, r15) == false) goto L53;
        Iterator<String> r19 = r6.iterator();
    L79:
        if (r19.hasNext() == false) goto L53;
        String r110 = r19.next();
        if (TextUtils.isEmpty(r110) == true) goto L79;
        if (r17.getHost().endsWith(r110) == true) goto L79;
        String r111 = this.f13453c.matcher(r15).replaceFirst(r110);     // Catch: Throwable -> L120
        if (TextUtils.isEmpty(r111) == true) goto L79;
        URI r20 = URI.create(r17.getScheme() + "://" + r110 + "/");     // Catch: Throwable -> L120
        List r112 = (List) r12.get(r20);     // Catch: Throwable -> L120
        if (r112 == null) goto L91;
        r112.add(r111);     // Catch: Throwable -> L120
        goto L79
    L91:
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L120
        r113.add(r111);     // Catch: Throwable -> L120
        r12.put(r20, r113);     // Catch: Throwable -> L120
        goto L79
    L94:
        Iterator r21 = r12.entrySet().iterator();
    L96:
        if (r21.hasNext() == false) goto L98;
        Map.Entry r22 = (Map.Entry) r21.next();
        m(((URI) r22.getKey()).toString(), (List) r22.getValue(), r11);
        goto L96
    L98:
        d.b.h.a.a.h.g.k r23 = d.b.h.a.a.h.g.l();
        if (r11.isEmpty() == true) goto L129;
        if (r23 == null) goto L129;
        r23.a(r11);     // Catch: Throwable -> L121
    L129:
        d(r17.getPath(), r14);     // Catch: Throwable -> L122
    L104:
        if (this.f13452b != null) goto L109;
        if (r7 == null) goto L107;
        r10 = true;
    L108:
        r1 = "mAppCookieMgr is null";
        goto L43
    L107:
        r10 = false;
        goto L108
    L109:
        Runnable r24 = new d.b.h.a.a.h.m.a(this, r12);
        if (d.b.h.a.a.e.b.a() == false) goto L112;
        com.bytedance.common.utility.m.a.c().submit(r24);
    L113:
        if (r7 == null) goto L115;
        r10 = true;
    L116:
        r1 = "last return";
        goto L43
    L115:
        r10 = false;
        goto L116
    L112:
        r24.run();
        goto L113
    L123:
        q(r5, r3, r11);     // Catch: Throwable -> L119
        goto L51
    L30:
        if ("http".equalsIgnoreCase(r17.getScheme()) == false) goto L131;
        if (r6 == null) goto L33;
        r6.clear();
    L33:
        k(r7, "disable_share_insecure_cookie", LocationInfoConst.ALLOW_USE_LOCATION);
        goto L131
    L19:
        r6 = null;
        goto L20
    L160:
        return;
    }

    private void o(JSONObject r2, String r3, boolean r4) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.f13454d == null) goto L13;
        if (r4 == false) goto L14;
        r2.put("return", r3);     // Catch: JSONException -> L10
    L8:
        this.f13454d.b("TTNET-COOKIE", "put", r2);
        return;
    L14:
        return;
    }

    private String p(String r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L18;
        return null;
    L18:
        Matcher r3 = this.f13453c.matcher(r5);     // Catch: IllegalArgumentException -> L17
        if (r3.find() == false) goto L8;
        String r0 = r3.group().toLowerCase();     // Catch: IllegalArgumentException -> L17
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L13;
        return r5;
    L13:
        if (b(r0) == false) goto L20;
        return r3.replaceFirst(r4);
    L20:
        return null;
    L8:
        r0 = null;
    L21:
        return null;
    }

    private void q(String r4, List<String> r5, Set<String> r6) {
        ArrayList r0 = new ArrayList();
        Iterator<String> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        String r1 = p(r4, r7.next());
        if (TextUtils.isEmpty(r1) == true) goto L4;
        r0.add(r1);
        goto L4
    L10:
        if (r0.isEmpty() == false) goto L12;
        return;
    L12:
        Logger.debug();
        m(r4, r0, r6);
    }

    private void r(String r2, String r3, Set<String> r4) {
        if (this.f13451a != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        String r5 = p(r2, r3);
        if (TextUtils.isEmpty(r5) == false) goto L10;
        return;
    L10:
        Logger.debug();
        l(r2, r5, r4);
        return;
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public Map<String, List<String>> get(URI r7, Map<String, List<String>> r8) {
        android.webkit.CookieManager r1 = null;
        boolean r2 = false;
        String r3 = r7.toString();     // Catch: Throwable -> L28
        if (r8 != null) goto L74;
    L16:
        d.b.h.a.a.h.g.f r4 = d.b.h.a.a.h.g.g();     // Catch: Throwable -> L70
        if (r4 == null) goto L29;
        Map<String, List<String>> r5 = r4.a(r7, r8);     // Catch: Throwable -> L70
        if (r5 == null) goto L29;
        if (r5.isEmpty() == true) goto L29;
        if (r5.containsKey("Cookie") == true) goto L27;
        if (r5.containsKey(CronetHttpURLConnection.SS_COOKIE) == false) goto L29;
    L27:
        return f(r2, r5, c.f13459g);
    L29:
        if (r7 == null) goto L69;
        if (this.f13451a == null) goto L69;
        d.b.h.a.a.h.g.j r6 = d.b.h.a.a.h.g.k();     // Catch: Throwable -> L71
        if (r6 == null) goto L47;
        if (f13450g == true) goto L39;
        r1 = this.f13451a;     // Catch: Throwable -> L71
    L39:
        List<String> r9 = r6.e(r1, this.f13452b, r7);     // Catch: Throwable -> L71
        if (com.bytedance.common.utility.e.a(r9) == true) goto L47;
        c r10 = c.f13460h;     // Catch: Throwable -> L71
        if (r9.remove("x-tt-cookie-backup-source=1") == false) goto L44;
        r10 = c.f13461i;     // Catch: Throwable -> L71
    L44:
        return f(r2, e(r9, r8), r10);
    L47:
        if (f13450g == true) goto L53;
        String r11 = this.f13451a.getCookie(r3);     // Catch: Exception -> L72
        if (TextUtils.isEmpty(r11) == true) goto L53;
        Logger.debug();     // Catch: Exception -> L72
        return f(r2, e(Collections.singletonList(r11), r8), c.f13462j);
    L53:
        if (this.f13452b == null) goto L55;
        d.b.h.a.a.h.m.c r12 = this.f13452b;     // Catch: Throwable -> L73
        if (r8 != null) goto L59;
        Map<String, List<String>> r13 = new LinkedHashMap();     // Catch: Throwable -> L73
    L60:
        Map<String, List<String>> r14 = r12.get(r7, r13);     // Catch: Throwable -> L73
        if (r14 == null) goto L67;
        if (r14.isEmpty() == true) goto L67;
        return f(r2, e(r14.get("Cookie"), r8), c.f13463k);
    L59:
        r13 = r8;
    L67:
        return Collections.emptyMap();
    L55:
        return Collections.emptyMap();
    L69:
        return Collections.emptyMap();
    L74:
        r2 = r8.containsKey("x-tt-get-cookie-source");     // Catch: Throwable -> L70
        List<String> r15 = g(r8, "X-SS-No-Cookie");     // Catch: Throwable -> L70
        if (r15 == null) goto L16;
        Iterator<String> r16 = r15.iterator();     // Catch: Throwable -> L70
    L9:
        if (r16.hasNext() == false) goto L16;
        String r17 = r16.next();     // Catch: Throwable -> L70
        if (r17 == null) goto L9;
        if (Boolean.parseBoolean(r17) == false) goto L9;
        Logger.debug();     // Catch: Throwable -> L70
        return Collections.emptyMap();
    L28:
        r3 = null;
        goto L29
    }

    public /* synthetic */ void j(Map r1) {
        i(r1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(URI r26, Map<String, List<String>> r27) {
        if (d.b.h.a.a.e.b.d() == false) goto L6;
        n(r26, r27);
        return;
    L6:
        List<String> r3 = null;
        d.b.h.a.a.h.g.j r4 = d.b.h.a.a.h.g.k();
        if (r4 == null) goto L10;
        if (r26 == null) goto L10;
        r3 = r4.g(r26.getHost());
    L10:
        JSONObject r5 = new JSONObject();
        if (r27 != null) goto L13;
    L17:
        boolean r9 = false;
    L19:
        String r11 = "";
        if (r3 != null) goto L213;
        String r12 = "";
    L23:
        r5.put("shareHostList", r12);     // Catch: JSONException -> L186
        if (r9 == false) goto L27;
        r5.put("responseHeaders", r27.toString());     // Catch: JSONException -> L186
    L27:
        if (r26 == null) goto L30;
        r11 = r26.toString();     // Catch: JSONException -> L186
    L30:
        r5.put(WsConstants.KEY_CONNECTION_URL, r11);     // Catch: JSONException -> L186
        if (r26 != null) goto L33;
    L207:
        d.b.h.a.a.h.g.f r10 = d.b.h.a.a.h.g.g();     // Catch: Throwable -> L187
        if (r10 == null) goto L42;
        r10.b(r26, r27);     // Catch: Throwable -> L187
    L42:
        String r13 = "webview-origin-url";
        if (r27 != null) goto L45;
    L47:
        boolean r14 = false;
    L49:
        if (f13450g == true) goto L138;
        if (r26 == null) goto L135;
        if (r27 == null) goto L135;
        if (this.f13451a == null) goto L135;
        HashSet r15 = new HashSet();
        String r16 = r26.toString();
        if (f13449f == false) goto L58;
        String[] r17 = {"X-SS-Set-Cookie", "Set-Cookie"};
    L59:
        int r8 = r17.length;
        Object r18 = "Set-Cookie";
        int r6 = 0;
        boolean r7 = false;
        boolean r19 = false;
    L60:
        if (r6 >= r8) goto L128;
        int r20 = r8;
        String r21 = r17[r6];
        List<String> r22 = r27.get(r21);
        if (r22 != null) goto L64;
    L65:
        r22 = r27.get(r21.toLowerCase());
        if (r22 != null) goto L68;
    L126:
        String r23 = r13;
        String r24 = r16;
    L127:
        r6 = r6 + 1;
        r8 = r20;
        r17 = r17;
        r13 = r23;
        r16 = r24;
        goto L60
    L68:
        if (r22.isEmpty() == true) goto L126;
    L211:
        r5.put("cookieMgrList", r22.toString());     // Catch: JSONException -> L188
    L75:
        Iterator<String> r25 = r22.iterator();
    L77:
        if (r25.hasNext() == false) goto L125;
        String r110 = r25.next();
        boolean r28 = r7;
        Iterator<String> r111 = r25;
        if (r110.toLowerCase().trim().contains("sessionid=") == false) goto L81;
        r28 = true;
    L81:
        if (r28 == false) goto L83;
    L89:
        boolean r29 = r28;
    L90:
        l(r16, r110, r15);
        if (r14 == false) goto L94;
        String r210 = r13;
        r(r27.get(r13).get(0), r110, r15);
    L93:
        boolean r112 = r29;
        String r211 = r16;
    L124:
        r7 = r112;
        r25 = r111;
        r13 = r210;
        r16 = r211;
        goto L77
    L94:
        r210 = r13;
        if ((!com.bytedance.common.utility.e.a(r3)) == false) goto L93;
        if (h(r26, r110) == false) goto L93;
        Iterator<String> r30 = r3.iterator();     // Catch: Throwable -> L192
    L103:
        if (r30.hasNext() == false) goto L123;
        String r113 = r30.next();     // Catch: Throwable -> L192
        if (TextUtils.isEmpty(r113) == true) goto L103;
        boolean r114 = r29;
        if (r26.getHost().endsWith(r113) == false) goto L112;
        r29 = r114;
        goto L103
    L112:
        String r31 = this.f13453c.matcher(r110).replaceFirst(r113);     // Catch: Throwable -> L191
        if (TextUtils.isEmpty(r31) == true) goto L119;
        Iterator<String> r212 = r30;
        StringBuilder r32 = new StringBuilder();     // Catch: Throwable -> L190
        String r213 = r16;
        r32.append(r26.getScheme());     // Catch: Throwable -> L189
        r32.append("://");     // Catch: Throwable -> L189
        r32.append(r113);     // Catch: Throwable -> L189
        r32.append("/");     // Catch: Throwable -> L189
        l(r32.toString(), r31, r15);     // Catch: Throwable -> L189
    L122:
        r29 = r114;
        r30 = r212;
        r16 = r213;
    L120:
        r213 = r16;
    L119:
        r212 = r30;
    L121:
        r114 = r29;
    L123:
        r112 = r29;
        r211 = r16;
        Logger.debug();
        goto L124
    L83:
        if (d.b.h.a.a.e.b.f() == false) goto L89;
        if (r110.toLowerCase().trim().contains("store-country-code=") == false) goto L87;
    L88:
        r29 = true;
        goto L90
    L87:
        if (r110.toLowerCase().trim().contains("store-region=") == false) goto L89;
    L125:
        r23 = r13;
        r24 = r16;
        r19 = true;
        goto L127
    L64:
        if (r22.isEmpty() == false) goto L211;
    L128:
        d.b.h.a.a.h.g.k r33 = d.b.h.a.a.h.g.l();
        if (r15.isEmpty() == true) goto L132;
        if (r33 == null) goto L132;
        r33.a(r15);     // Catch: Throwable -> L193
    L132:
        if (r19 == true) goto L215;
    L139:
        if (r26 == null) goto L185;
        if (r27 == null) goto L185;
        if (this.f13452b == null) goto L185;
        LinkedHashMap r34 = new LinkedHashMap();     // Catch: Throwable -> L197
        if (f13449f == true) goto L147;
    L151:
        Object r35 = r18;
    L152:
        r34.putAll(r27);     // Catch: Throwable -> L197
        this.f13452b.put(r26, r34);     // Catch: Throwable -> L197
        if ((!com.bytedance.common.utility.e.a(r3)) == false) goto L182;
        if (r14 == true) goto L182;
        Iterator<String> r36 = r3.iterator();     // Catch: Throwable -> L197
    L158:
        if (r36.hasNext() == false) goto L184;
        String r37 = r36.next();     // Catch: Throwable -> L197
        if (TextUtils.isEmpty(r37) == true) goto L158;
        if (r26.getHost().endsWith(r37) == true) goto L158;
        List<String> r38 = r27.get(r35);     // Catch: Throwable -> L195
        if (r38 != null) goto L170;
        o(r5, "cookieList is null", r9);     // Catch: Throwable -> L195
        return;
    L170:
        LinkedList r115 = new LinkedList();     // Catch: Throwable -> L195
        Iterator<String> r39 = r38.iterator();     // Catch: Throwable -> L195
    L172:
        if (r39.hasNext() == false) goto L180;
        String r116 = r39.next();     // Catch: Throwable -> L195
        if (h(r26, r116) == false) goto L172;
        String r117 = this.f13453c.matcher(r116).replaceFirst(r37);     // Catch: Throwable -> L195 IllegalArgumentException -> L196
        if (TextUtils.isEmpty(r117) == true) goto L172;
        r115.add(r117);     // Catch: Throwable -> L195 IllegalArgumentException -> L196
        goto L172
    L180:
        r34.put(r35, r115);     // Catch: Throwable -> L195
        this.f13452b.put(URI.create(r26.getScheme() + "://" + r37), r34);     // Catch: Throwable -> L195
    L182:
        o(r5, "isInShareCookieList is false", r9);     // Catch: Throwable -> L197
        return;
    L147:
        if (r27.containsKey("X-SS-Set-Cookie") == false) goto L151;
        r35 = r18;
        if (r27.containsKey(r35) == true) goto L152;
        r34.put(r35, r27.get("X-SS-Set-Cookie"));     // Catch: Throwable -> L197
    L184:
        String r1 = "last return";
    L136:
        o(r5, r1, r9);
        return;
    L185:
        r1 = "uri responseHeaders or mAppCookieMgr is null";
        goto L136
    L215:
        d(r26.getPath(), r7);     // Catch: Throwable -> L194
        goto L139
    L58:
        r17 = new String[]{"Set-Cookie"};
    L135:
        r1 = "uri responseHeaders or mCookieMgr is null";
        goto L136
    L138:
        r18 = "Set-Cookie";
        goto L139
    L45:
        if (r27.containsKey("webview-origin-url") == false) goto L47;
        r14 = true;
        goto L49
    L33:
        if ("http".equalsIgnoreCase(r26.getScheme()) == false) goto L207;
        if (d.b.h.a.a.e.a.c() == false) goto L207;
        if (r3 == null) goto L38;
        r3.clear();     // Catch: JSONException -> L186
    L38:
        r5.put("disable_share_insecure_cookie", 1);     // Catch: JSONException -> L186
        goto L207
    L213:
        r12 = r3.toString();     // Catch: JSONException -> L186
        goto L23
    L13:
        if (r27.containsKey("Set-Cookie") == false) goto L15;
    L16:
        r9 = true;
        goto L19
    L15:
        if (r27.containsKey("X-SS-Set-Cookie") == false) goto L17;
        goto L16
    }
}
