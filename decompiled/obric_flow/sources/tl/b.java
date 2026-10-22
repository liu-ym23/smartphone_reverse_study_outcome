package tl;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k5.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f22138a = null;

    static {
        ConcurrentHashMap r5 = new ConcurrentHashMap();
        f22138a = r5;
        ll.a r10 = new ll.a();
        r10.f19678a = d.f18611p;
        if (r5.containsKey(ll.a.class) == true) goto L6;
        r5.clear();
        r5.put(ll.a.class, r10);
        return;
    }

    public static void a(String r5) {
        Iterator r10 = f22138a.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((a) ((Map.Entry) r10.next()).getValue()).d("PluginView", r5, null);
        goto L4
    }

    public static void b(String r5, String r10) {
        Iterator r11 = f22138a.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((a) ((Map.Entry) r11.next()).getValue()).e(r5, r10, null);
        goto L4
    }

    public static void c(String r5, String r10) {
        Iterator r11 = f22138a.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((a) ((Map.Entry) r11.next()).getValue()).i(r5, r10, null);
        goto L4
    }
}
