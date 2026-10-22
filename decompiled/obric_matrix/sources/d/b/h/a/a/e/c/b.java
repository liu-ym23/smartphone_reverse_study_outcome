package d.b.h.a.a.e.c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import d.b.h.a.a.e.c.c;
import d.b.h.a.a.h.s.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T extends c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AtomicBoolean f13270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Pair<a, T>> f13271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f13272c;

    public b() {
        this.f13270a = new AtomicBoolean(false);
        this.f13271b = new CopyOnWriteArrayList();
    }

    public abstract String a();

    public T b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L84:
        return null;
    L5:
        if (this.f13270a.get() == false) goto L84;
        Uri r11 = Uri.parse(r10);
        if (r11 != null) goto L10;
        return null;
    L10:
        String r0 = r11.getHost();
        String r12 = r11.getPath();
        if (TextUtils.isEmpty(r0) == true) goto L84;
        if (TextUtils.isEmpty(r12) == true) goto L84;
        Iterator<Pair<a, T>> r1 = this.f13271b.iterator();
    L17:
        if (r1.hasNext() == false) goto L82;
        Pair<a, T> r2 = r1.next();
        if (r2 == null) goto L17;
        a r3 = (a) r2.first;
        if (r3 == null) goto L17;
        Set<String> r4 = r3.f13264a;
        boolean r5 = false;
        boolean r6 = true;
        if (r4 != null) goto L27;
    L29:
        boolean r7 = false;
    L30:
        if (r7 == true) goto L39;
        Set<String> r8 = r3.f13265b;
        if (r8 == null) goto L39;
        Iterator<String> r9 = r8.iterator();
    L35:
        if (r9.hasNext() == false) goto L39;
        if (l.i(r0, r9.next()) == false) goto L35;
        Logger.debug();
        r7 = true;
    L39:
        if (r7 == false) goto L82;
        Set<String> r13 = r3.f13266c;
        if (r13 != null) goto L44;
    L46:
        if (r5 == true) goto L55;
        Set<String> r14 = r3.f13267d;
        if (r14 == null) goto L55;
        Iterator<String> r15 = r14.iterator();
    L51:
        if (r15.hasNext() == false) goto L55;
        if (r12.startsWith(r15.next()) == false) goto L51;
        Logger.debug();
        r5 = true;
    L55:
        if (r5 == true) goto L64;
        Set<String> r16 = r3.f13268e;
        if (r16 == null) goto L64;
        Iterator<String> r17 = r16.iterator();
    L60:
        if (r17.hasNext() == false) goto L64;
        if (r12.contains(r17.next()) == false) goto L60;
        Logger.debug();
        r5 = true;
    L64:
        if (r5 == true) goto L77;
        Set<Pattern> r18 = r3.f13269f;
        if (r18 == null) goto L77;
        Iterator<Pattern> r19 = r18.iterator();
    L69:
        if (r19.hasNext() == false) goto L77;
        Pattern r20 = r19.next();
        if (r20 == null) goto L69;
        if (r20.matcher(r12).matches() == false) goto L69;
        Logger.debug();     // Catch: Throwable -> L76
    L78:
        if (r6 == false) goto L17;
        return (T) r2.second;
    L76:
        r5 = true;
    L77:
        r6 = r5;
        goto L78
    L44:
        if (r13.contains(r12) == false) goto L46;
        Logger.debug();
        r5 = true;
        goto L46
    L27:
        if (r4.contains(r0) == false) goto L29;
        Logger.debug();
        r7 = true;
    L82:
        Logger.debug();
        return this.f13272c;
    }

    public List<Pair<a, T>> c() {
        return this.f13271b;
    }

    public boolean d() {
        return this.f13270a.get();
    }

    public abstract T e(Object r1);

    protected Set<String> f(JSONArray r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.length() == 0) goto L19;
        HashSet r3 = new HashSet();
        int r0 = 0;
    L8:
        if (r0 >= r4.length()) goto L13;
        String r1 = r4.optString(r0);
        if (TextUtils.isEmpty(r1) == true) goto L12;
        r3.add(r1);
    L12:
        r0 = r0 + 1;
        goto L8
    L13:
        return r3;
    L19:
        return null;
    }

    boolean g(JSONObject r1) {
        return true;
    }

    public boolean h(JSONObject r8) {
        int r1 = 0;
        this.f13270a.set(false);
        this.f13271b.clear();
        if (r8 != null) goto L5;
    L85:
        return false;
    L5:
        if (r8.length() == 0) goto L85;
        JSONObject r9 = r8.optJSONObject(a());
        if (r9 != null) goto L10;
    L84:
        return true;
    L10:
        if (r9.length() == 0) goto L84;
        AtomicBoolean r2 = this.f13270a;
        if (r9.optInt("enabled", 0) <= 0) goto L15;
        boolean r3 = true;
    L16:
        r2.set(r3);
        if (this.f13270a.get() == true) goto L20;
        return true;
    L20:
        if (g(r9) == true) goto L22;
        return false;
    L22:
        Object r4 = r9.opt("default");
        if (r4 == null) goto L25;
        this.f13272c = (T) e(r4);
    L25:
        JSONArray r10 = r9.optJSONArray("rule_list");
        if (r10 != null) goto L28;
    L83:
        return false;
    L28:
        if (r10.length() == 0) goto L83;
    L31:
        if (r1 >= r10.length()) goto L82;
        JSONObject r5 = r10.optJSONObject(r1);
        if (r5 == null) goto L81;
        if (r5.length() == 0) goto L81;
        a r6 = new a();
        r6.f13264a = f(r5.optJSONArray("host_eq"));
        r6.f13265b = f(r5.optJSONArray("host_wc"));
        Set<String> r7 = r6.f13264a;
        if (r7 != null) goto L40;
    L41:
        Set<String> r11 = r6.f13265b;
        if (r11 != null) goto L44;
    L73:
        Logger.debug();
        goto L81
    L44:
        if (r11.isEmpty() == true) goto L73;
    L46:
        r6.f13266c = f(r5.optJSONArray("path_eq"));
        r6.f13267d = f(r5.optJSONArray("path_prefix"));
        r6.f13268e = f(r5.optJSONArray("path_contain"));
        Set<String> r12 = f(r5.optJSONArray("path_pattern"));
        if (r12 == null) goto L54;
        r6.f13269f = new HashSet();
        Iterator<String> r13 = r12.iterator();
    L50:
        if (r13.hasNext() == false) goto L54;
        r6.f13269f.add(Pattern.compile(r13.next()));     // Catch: Throwable -> L86
    L54:
        Set<String> r14 = r6.f13266c;
        if (r14 != null) goto L57;
    L58:
        Set<String> r15 = r6.f13267d;
        if (r15 != null) goto L61;
    L62:
        Set<String> r16 = r6.f13268e;
        if (r16 != null) goto L65;
    L66:
        Set<Pattern> r17 = r6.f13269f;
        if (r17 == null) goto L73;
        if (r17.isEmpty() == true) goto L73;
    L71:
        Object r18 = r5.opt("value");
        if (r18 == null) goto L73;
        c r19 = e(r18);
        if (r19 == null) goto L73;
        String r20 = r5.optString("sign");
        if (TextUtils.isEmpty(r20) == true) goto L80;
        r19.f13273a = r20;
    L80:
        this.f13271b.add(new Pair(r6, r19));
        goto L81
    L65:
        if (r16.isEmpty() == false) goto L71;
    L61:
        if (r15.isEmpty() == false) goto L71;
    L57:
        if (r14.isEmpty() == false) goto L71;
    L40:
        if (r7.isEmpty() == false) goto L46;
    L81:
        r1 = r1 + 1;
        goto L31
    L82:
        return true;
    L15:
        r3 = false;
        goto L16
    }

    public void i(boolean r1) {
        this.f13270a.set(r1);
    }
}
