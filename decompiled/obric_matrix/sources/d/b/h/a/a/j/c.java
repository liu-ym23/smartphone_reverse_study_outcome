package d.b.h.a.a.j;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import d.b.h.a.a.h.s.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f13777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f13778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<String> f13779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Set<String> f13780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Set<Pattern> f13781g;

    static {
    }

    public c(int r2) {
        this.f13777c = false;
        this.f13778d = new HashSet();
        this.f13779e = new HashSet();
        this.f13780f = new HashSet();
        this.f13781g = new HashSet();
        this.f13775a = r2;
        this.f13776b = r2;
    }

    protected static c a(String r1, int r2, int r3, JSONObject r4) {
        if (r1.equals("rm") == false) goto L6;
        c r5 = new f(r2);
    L8:
        r5.i(r4);
        r5.m(r3);
        return r5;
    L6:
        if (r1.equals("encrypt") == false) goto L10;
        r5 = new b(r2);
        goto L8
    L10:
        return null;
    }

    private boolean c(d.b.r.h0.c r2, Map<String, List<String>> r3) {
        if (e(r2) == true) goto L7;
        return false;
    L7:
        return b(r2, r3);
    }

    private boolean e(d.b.r.h0.c r1) {
        if (r1.C() <= this.f13775a) goto L6;
        return false;
    L6:
        return true;
    }

    private static boolean f(Set<?> r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.isEmpty() == true) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean g(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        Iterator<String> r2 = this.f13778d.iterator();
    L7:
        if (r2.hasNext() == false) goto L15;
        if (l.i(r3, r2.next()) == false) goto L7;
        return true;
    L15:
        return false;
    }

    private static void k(JSONArray r3, Set<Pattern> r4) {
        if (r3 == null) goto L13;
        if (r4 == null) goto L23;
        int r0 = 0;
    L16:
        if (r0 >= r3.length()) goto L25;
        String r1 = r3.getString(r0);     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r4.add(Pattern.compile(r1, 2));     // Catch: Throwable -> L14
    L12:
        r0 = r0 + 1;
        goto L16
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    private void l(JSONArray r3, Set<String> r4) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L19;
        int r2 = 0;
    L14:
        if (r2 >= r3.length()) goto L21;
        String r0 = r3.getString(r2);     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r0) == true) goto L11;
        r4.add(r0);     // Catch: JSONException -> L13
    L11:
        r2 = r2 + 1;
        goto L14
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    private void m(int r1) {
        this.f13776b = r1;
    }

    protected abstract boolean b(d.b.r.h0.c r1, Map<String, List<String>> r2);

    public int d() {
        return this.f13775a;
    }

    protected boolean h(d.b.r.h0.c r6) {
        if (this.f13777c == false) goto L8;
        if (e.f().f13790c.get() == true) goto L8;
        return false;
    L8:
        if (f(this.f13778d) == false) goto L10;
    L12:
        String r7 = r6.A();
        if (TextUtils.isEmpty(r7) == false) goto L16;
        Logger.debug();
        return false;
    L16:
        int r0 = r7.length();
        if (r0 <= 1) goto L22;
        int r1 = r0 - 1;
        if (r7.substring(r1).equals("/") == false) goto L22;
        r7 = r7.substring(0, r1);
    L22:
        if (f(this.f13779e) == true) goto L27;
        if (this.f13779e.contains(r7) == false) goto L27;
        return true;
    L27:
        if (f(this.f13780f) == true) goto L35;
        Iterator<String> r2 = this.f13780f.iterator();
    L30:
        if (r2.hasNext() == false) goto L35;
        if (r7.startsWith(r2.next()) == false) goto L30;
        return true;
    L35:
        if (f(this.f13781g) == true) goto L44;
        Iterator<Pattern> r5 = this.f13781g.iterator();
    L38:
        if (r5.hasNext() == false) goto L44;
        Pattern r3 = r5.next();
        if (r3 == null) goto L38;
        if (r3.matcher(r7).matches() == false) goto L38;
        return true;
    L44:
        return false;
    L10:
        if (g(r6.w()) == true) goto L12;
        return false;
    }

    protected abstract void i(JSONObject r1);

    protected void j(JSONObject r3) {
        l(r3.optJSONArray("host_group"), this.f13778d);
        l(r3.optJSONArray("equal_group"), this.f13779e);
        l(r3.optJSONArray("prefix_group"), this.f13780f);
        k(r3.optJSONArray("pattern_group"), this.f13781g);
    }

    protected boolean n(d.b.r.h0.c r4, Map<String, List<String>> r5, List<a> r6) {
        a r0 = new a();
        r0.g(SystemClock.uptimeMillis());
        boolean r7 = c(r4, r5);
        if (r7 == false) goto L5;
        r4.U(this.f13776b);
    L5:
        r0.e(r7);
        r0.f(this.f13775a);
        r0.d(SystemClock.uptimeMillis());
        r6.add(r0);
        return r7;
    }
}
