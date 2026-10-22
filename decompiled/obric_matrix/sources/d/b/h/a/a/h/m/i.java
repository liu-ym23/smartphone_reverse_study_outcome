package d.b.h.a.a.h.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class i implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f13443c = "i";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, String> f13444d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f13445e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f13446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<URI, Set<l>> f13447b;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f13448f;

        a(i r1) {
            this.f13448f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.d(this.f13448f);     // Catch: Throwable -> L4
            return;
        }
    }

    static {
        f13444d = new LinkedHashMap();
    }

    public i(Context r5) {
        this.f13447b = new LinkedHashMap();
        String r0 = f13445e;
        if (r0 != null) goto L6;
        r0 = "cookieStore";
    L6:
        if (Build.VERSION.SDK_INT >= 11) goto L8;
        int r1 = 0;
    L9:
        SharedPreferences r6 = c(r5, r0, r1);
        this.f13446a = r6;
        i(r6.getAll(), true);
        i(f13444d, false);
        return;
    L8:
        r1 = 4;
        goto L9
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences c(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ void d(i r0) {
        r0.l();
    }

    private boolean e(String r4, String r5) {
        if (r4 == null) goto L16;
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r5.length() >= r4.length()) goto L11;
        return r4.equalsIgnoreCase("." + r5);
    L11:
        if (r5.equalsIgnoreCase(r4) == false) goto L13;
    L14:
        return true;
    L13:
        if (r5.toLowerCase().endsWith("." + r4.toLowerCase()) == true) goto L14;
        return false;
    L16:
        return false;
    }

    private boolean f(String r4, String r5) {
        if (r5.equals(r4) == true) goto L13;
        if (r5.startsWith(r4) == false) goto L9;
        if (r4.charAt(r4.length() - 1) == '/') goto L13;
    L9:
        if (r5.startsWith(r4) == true) goto L11;
        return false;
    L11:
        if (r5.substring(r4.length()).charAt(0) == '/') goto L13;
        return false;
    L13:
        return true;
    }

    private static URI g(URI r4, g r5) {
        if (r5.y() == null) goto L18;
        String r0 = r5.y();
        if (r0.charAt(0) != '.') goto L16;
        r0 = r0.substring(1);
    L16:
    L13:
        e = move-exception;
        Log.w(f13443c, e);
        return r4;
    L8:
        if (r5.C() != null) goto L10;
        String r6 = "/";
    L11:
        return new URI("http", r0, r6, null);
    L10:
        r6 = r5.C();     // Catch: URISyntaxException -> L13
        goto L11
    L18:
        return r4;
    }

    private List<g> h(URI r6) {
        ArrayList r0 = new ArrayList();
        Iterator<URI> r1 = this.f13447b.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        URI r2 = r1.next();
        if (e(r2.getHost(), r6.getHost()) == false) goto L4;
        String r3 = r6.getPath();
        if (TextUtils.isEmpty(r3) == false) goto L11;
        r3 = "/";
    L11:
        if (f(r2.getPath(), r3) == false) goto L4;
        r0.addAll(this.f13447b.get(r2));
        goto L4
    L13:
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        Iterator r7 = r0.iterator();
    L15:
        if (r7.hasNext() == false) goto L21;
        l r8 = (l) r7.next();
        if (r8.g() == true) goto L18;
        r4.add(r8.e());
        goto L15
    L18:
        r5.add(r8);
        goto L15
    L21:
        if (r5.isEmpty() == true) goto L23;
        j(r6, r5);
    L23:
        return r4;
    }

    private synchronized void i(Map<String, ?> r5, boolean r6) {
        monitor-enter(this);
        if (r5 != null) goto L33;
    L26:
        monitor-exit(this);
        return;
    L33:
        if (r5.isEmpty() == true) goto L26;
        Iterator<Map.Entry<String, ?>> r7 = r5.entrySet().iterator();     // Catch: Throwable -> L28
    L9:
        if (r7.hasNext() == false) goto L19;
        Map.Entry<String, ?> r0 = r7.next();     // Catch: Throwable -> L28
        URI r2 = new URI(r0.getKey().split("\\|", 2)[0]);     // Catch: URISyntaxException -> L17 Throwable -> L28
        l r1 = l.b((String) r0.getValue());     // Catch: URISyntaxException -> L17 Throwable -> L28
        Set<l> r3 = this.f13447b.get(r2);     // Catch: URISyntaxException -> L17 Throwable -> L28
        goto L21
    L12:
        if (r3 != null) goto L14;
        r3 = new HashSet();     // Catch: URISyntaxException -> L17 Throwable -> L28
        this.f13447b.put(r2, r3);     // Catch: URISyntaxException -> L17 Throwable -> L28
    L14:
        if (r1 == null) goto L9;
        r3.add(r1);     // Catch: URISyntaxException -> L17 Throwable -> L28
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L28
        goto L9
    L19:
        if (r6 == false) goto L21;
        com.bytedance.common.utility.m.c.c(new a(this));     // Catch: Throwable -> L28
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    private void j(URI r4, List<l> r5) {
        SharedPreferences.Editor r3 = this.f13446a.edit();
        Iterator<l> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r0 = r4.toString() + "|" + r6.next().e().B();
        r3.remove(r0);
        f13444d.remove(r0);
        goto L4
    L6:
        r3.apply();
    }

    private void k(URI r6, l r7) {
        String r8 = r6.toString() + "|" + r7.e().B();
        String r0 = r7.c();
        if (r7.e().z() <= 0) goto L5;
        SharedPreferences.Editor r5 = this.f13446a.edit();
        r5.putString(r8, r0);
        r5.apply();
        return;
    L5:
        f13444d.put(r8, r0);
    }

    private synchronized void l() {
        monitor-enter(this);
        Map<URI, Set<l>> r0 = this.f13447b;     // Catch: Throwable -> L85
        if (r0 != null) goto L6;
    L83:
        monitor-exit(this);
        return;
    L6:
        if (r0.isEmpty() == true) goto L83;
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L85
        Iterator<Map.Entry<URI, Set<l>>> r2 = this.f13447b.entrySet().iterator();     // Catch: Throwable -> L85
    L10:
        if (r2.hasNext() == false) goto L20;
        Map.Entry<URI, Set<l>> r3 = r2.next();     // Catch: Throwable -> L85
        if (r3 == null) goto L10;
        URI r4 = r3.getKey();     // Catch: Throwable -> L85
        if (r4.getScheme() == null) goto L10;
        if (r4.getScheme().equals(LocationInfoConst.HTTPS) == false) goto L10;
        r1.put(r3.getKey(), r3.getValue());     // Catch: Throwable -> L85
        goto L10
    L20:
        if (r1.isEmpty() == false) goto L23;
        monitor-exit(this);
        return;
    L23:
        Iterator r5 = r1.entrySet().iterator();     // Catch: Throwable -> L85
    L24:
        if (r5.hasNext() == false) goto L92;
        Map.Entry r6 = (Map.Entry) r5.next();     // Catch: Throwable -> L85
        if (r6 == null) goto L24;
        URI r7 = (URI) r6.getKey();     // Catch: Throwable -> L85
        Set<l> r8 = (Set) r6.getValue();     // Catch: Throwable -> L85
        URI r9 = new URI(r7.toString().replace("https:", "http:"));     // Catch: Throwable -> L88
        Set<l> r10 = this.f13447b.get(r9);     // Catch: Throwable -> L88
        if (r10 == null) goto L60;
        if (r10.isEmpty() == true) goto L60;
        LinkedHashSet r11 = new LinkedHashSet();     // Catch: Throwable -> L88
        Iterator<l> r12 = r10.iterator();     // Catch: Throwable -> L88
    L37:
        if (r12.hasNext() == false) goto L52;
        l r13 = r12.next();     // Catch: Throwable -> L88
        boolean r14 = false;
        Iterator<l> r15 = r8.iterator();     // Catch: Throwable -> L88
    L40:
        if (r15.hasNext() == false) goto L50;
        l r16 = r15.next();     // Catch: Throwable -> L88
        if (r13 == null) goto L40;
        if (r16 == null) goto L40;
        if (r13.e().equals(r16.e()) == false) goto L40;
        if (r16.f().longValue() < r13.f().longValue()) goto L40;
        r11.add(r16);     // Catch: Throwable -> L88
        r14 = true;
        goto L40
    L50:
        if (r14 == true) goto L37;
        r11.add(r13);     // Catch: Throwable -> L88
        goto L37
    L52:
        Iterator<l> r17 = r8.iterator();     // Catch: Throwable -> L88
    L54:
        if (r17.hasNext() == false) goto L59;
        l r18 = r17.next();     // Catch: Throwable -> L88
        if (r11.contains(r18) == true) goto L54;
        r11.add(r18);     // Catch: Throwable -> L88
        goto L54
    L59:
        this.f13447b.remove(r7);     // Catch: Throwable -> L88
        this.f13447b.put(r9, r11);     // Catch: Throwable -> L88
    L60:
        this.f13447b.remove(r7);     // Catch: Throwable -> L88
        this.f13447b.put(r9, r8);     // Catch: Throwable -> L88
        goto L24
    L92:
        Map<URI, Set<l>> r19 = this.f13447b;     // Catch: Throwable -> L89
        if (r19 != null) goto L65;
    L79:
        monitor-exit(this);
        return;
    L65:
        if (r19.isEmpty() == true) goto L79;
        SharedPreferences.Editor r20 = this.f13446a.edit();     // Catch: Throwable -> L89
        r20.clear();     // Catch: Throwable -> L89
        Iterator<Map.Entry<URI, Set<l>>> r21 = this.f13447b.entrySet().iterator();     // Catch: Throwable -> L89
    L69:
        if (r21.hasNext() == false) goto L77;
        Map.Entry<URI, Set<l>> r22 = r21.next();     // Catch: Throwable -> L89
        URI r23 = r22.getKey();     // Catch: Throwable -> L89
        Iterator<l> r24 = r22.getValue().iterator();     // Catch: Throwable -> L89
    L72:
        if (r24.hasNext() == false) goto L69;
        l r25 = r24.next();     // Catch: Throwable -> L89
        String r26 = r23.toString() + "|" + r25.e().B();     // Catch: Throwable -> L89
        String r27 = r25.c();     // Catch: Throwable -> L89
        if (r25.e().z() > 0) goto L75;
        f13444d.put(r26, r27);     // Catch: Throwable -> L89
        goto L72
    L75:
        r20.putString(r26, r27);     // Catch: Throwable -> L89
        goto L72
    L77:
        com.bytedance.common.utility.o.a.a(r20);     // Catch: Throwable -> L89
    L81:
        monitor-exit(this);
        return;
    L85:
        th = move-exception;
        throw th;
    }

    public static void m() {
        f13445e = "ttnetCookieStore";
    }

    @Override // d.b.h.a.a.h.m.e
    public synchronized void a(URI r3, g r4) {
        monitor-enter(this);
        URI r5 = g(r3, r4);     // Catch: Throwable -> L10
        Set<l> r0 = this.f13447b.get(r5);     // Catch: Throwable -> L10
        l r1 = new l(r4);     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
        r0 = new HashSet();     // Catch: Throwable -> L10
        this.f13447b.put(r5, r0);     // Catch: Throwable -> L10
    L7:
        r0.add(r1);     // Catch: Throwable -> L10
        k(r5, r1);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r0.remove(r1);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // d.b.h.a.a.h.m.e
    public synchronized List<g> b(URI r1) {
        monitor-enter(this);
        List<g> r2 = h(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }
}
