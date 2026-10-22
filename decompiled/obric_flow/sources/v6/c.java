package v6;

import android.text.TextUtils;
import com.bytedance.apm.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap f22519c;
    public HashMap d;
    public HashMap e;
    public HashMap f;
    public HashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap f22520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public sg.a f22521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f22522j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap f22523k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f22524l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double f22525m;

    public final void a(long r5, String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        boolean r12 = j.f3887a;
        int r13 = com.bytedance.apm.util.g.f3916a;
        throw null;     // Catch: Exception -> L7
    L8:
        if (r7.a.a(s7.a.class) != null) goto L50;
        if (this.f22519c != null) goto L13;
        this.f22519c = new HashMap();
    L13:
        if (this.d != null) goto L16;
        this.d = new HashMap();
    L16:
        if (this.e != null) goto L19;
        this.e = new HashMap();
    L19:
        if (this.f != null) goto L22;
        this.f = new HashMap();
    L22:
        if (this.g != null) goto L25;
        this.g = new HashMap();
    L25:
        if (this.f22519c.containsKey(r10) == false) goto L27;
        ((a) this.f22519c.get(r10)).a(r5, r11);
    L29:
        if (this.f.containsKey(r10) == false) goto L31;
        ((a) this.f.get(r10)).a(r5, r11);
    L33:
        if (this.f22520h != null) goto L36;
        this.f22520h = new HashMap();
    L36:
        if (this.f22520h.containsKey(r10) == false) goto L38;
        ((a) this.f22520h.get(r10)).a(r5, r11);
    L39:
        HashMap r14 = this.f22523k;
        if (r14 == null) goto L48;
        Iterator r15 = r14.entrySet().iterator();
    L43:
        if (r15.hasNext() == false) goto L59;
        Map r16 = (Map) ((Map.Entry) r15.next()).getValue();
        if (r16.containsKey(r10) == true) goto L46;
        a r17 = new a(r10);
        r17.a(r5, r11);
        r16.put(r10, r17);
        goto L43
    L46:
        ((a) r16.get(r10)).a(r5, r11);
        goto L43
    L59:
        return;
    L48:
        return;
    L38:
        a r18 = new a(r10);
        r18.a(r5, r11);
        this.f22520h.put(r10, r18);
        goto L39
    L31:
        a r19 = new a(r10);
        r19.a(r5, r11);
        this.f.put(r10, r19);
        goto L33
    L27:
        a r20 = new a(r10);
        r20.a(r5, r11);
        this.f22519c.put(r10, r20);
        goto L29
    L50:
        throw new ClassCastException();
    }
}
