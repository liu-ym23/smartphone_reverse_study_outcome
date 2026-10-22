package d.b.h.a.a.h.o.b.y;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import d.b.h.a.a.h.s.k;
import d.b.h.a.a.h.s.l;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f13633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f13634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ReentrantReadWriteLock f13635c = null;

    static {
        f13635c = new ReentrantReadWriteLock();
    }

    private c() {
    }

    public static c b() {
        if (f13633a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13633a != null) goto L9;
        f13633a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f13633a;
    }

    private List<d.b.r.h0.b> c(d.b.r.h0.c r6, d r7, b r8) {
        ArrayList r5 = null;
        if (r6 == null) goto L40;
        if (r7 == null) goto L40;
        if (r8 == null) goto L40;
        if (com.bytedance.common.utility.collection.a.a(r7.f13639e) == false) goto L12;
        if (r7.f13638d != null) goto L12;
    L13:
        return null;
    L12:
        if (r7.f13638d.isEmpty() == true) goto L13;
        ArrayList r0 = new ArrayList();
        HashSet r1 = new HashSet();
        if (com.bytedance.common.utility.collection.a.a(r7.f13639e) == true) goto L25;
        if (r6.v().isEmpty() == true) goto L25;
        Iterator<String> r2 = r7.f13639e.iterator();
    L20:
        if (r2.hasNext() == false) goto L25;
        String r3 = r2.next();
        List<d.b.r.h0.b> r4 = r6.H(r3);
        if (r4 == null) goto L20;
        r0.addAll(r4);
        r1.add(r3);
    L25:
        if (r1.isEmpty() == true) goto L27;
        r8.f13631d = r1;
        r5 = new ArrayList(r6.v());
        r5.removeAll(r0);
    L27:
        Map<String, String> r9 = r7.f13638d;
        if (r9 == null) goto L40;
        if (r9.isEmpty() == true) goto L40;
        if (r5 != null) goto L33;
        r5 = new ArrayList(r6.v());
    L33:
        HashSet r10 = new HashSet();
        Iterator<Map.Entry<String, String>> r11 = r7.f13638d.entrySet().iterator();
    L35:
        if (r11.hasNext() == false) goto L38;
        Map.Entry<String, String> r12 = r11.next();
        r5.add(new d.b.r.h0.b(r12.getKey(), r12.getValue()));
        r10.add(r12.getKey());
        goto L35
    L38:
        if (r10.isEmpty() == true) goto L40;
        r8.f13630c = r10;
    L40:
        return r5;
    }

    private void d(Map<String, List<String>> r5, d r6, b r7) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L45;
        if (r6 == null) goto L46;
        if (r7 != null) goto L9;
        return;
    L9:
        if (com.bytedance.common.utility.collection.a.a(r6.f13637c) == true) goto L26;
        HashSet r4 = new HashSet();
        Iterator<String> r0 = r6.f13637c.iterator();
    L12:
        if (r0.hasNext() == false) goto L24;
        String r1 = r0.next();
        String r2 = URLDecoder.decode(r1, "UTF-8");     // Catch: UnsupportedEncodingException -> L20
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (r5.containsKey(r2) == false) goto L12;
        r5.remove(r2);
        r4.add(r1);
    L20:
        e = move-exception;
        throw new RuntimeException(e);
    L24:
        if (r4.isEmpty() == true) goto L26;
        r7.f13629b = r4;
    L26:
        HashSet r8 = new HashSet();
        Iterator<Map.Entry<String, String>> r9 = r6.f13636b.entrySet().iterator();
    L28:
        if (r9.hasNext() == false) goto L31;
        Map.Entry<String, String> r3 = r9.next();
        r5.put(r3.getKey(), Collections.singletonList(r3.getValue()));
        r8.add(r3.getKey());
        goto L28
    L31:
        if (r8.isEmpty() == true) goto L47;
        r7.f13628a = r8;
        return;
    L47:
        return;
    L46:
        return;
    }

    public static void e(JSONObject r2) {
        ReentrantReadWriteLock r0 = f13635c;     // Catch: Throwable -> L16
        r0.writeLock().lock();     // Catch: Throwable -> L16
        a r1 = new a();     // Catch: Throwable -> L16
        f13634b = r1;     // Catch: Throwable -> L16
        if (r2 != null) goto L7;
        r0.writeLock().unlock();
        return;
    L7:
        if (r1.h(r2) == true) goto L9;
        f13634b.i(false);     // Catch: Throwable -> L16
    L9:
        List<Pair<d.b.h.a.a.e.c.a, d>> r3 = f13634b.c();     // Catch: Throwable -> L16
        if (r3 != null) goto L12;
    L13:
        f13634b.i(false);     // Catch: Throwable -> L16
    L14:
        r0.writeLock().unlock();
        return;
    L12:
        if (r3.isEmpty() == false) goto L14;
    L16:
        th = move-exception;
        f13635c.writeLock().unlock();
        throw th;
    }

    public String a(String r5, d.b.r.h0.c r6, b r7, List<d.b.r.h0.b> r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        Pair<String, String> r1 = null;
        ReentrantReadWriteLock r2 = f13635c;     // Catch: Throwable -> L16
        r2.readLock().lock();     // Catch: Throwable -> L16
        a r3 = f13634b;     // Catch: Throwable -> L16
        if (r3 != null) goto L6;
    L10:
        r2.readLock().unlock();
        return r5;
    L6:
        if (r3.d() == false) goto L10;
        d r4 = f13634b.b(r5);     // Catch: Throwable -> L16
        if (r4 == null) goto L10;
        r1 = l.k(r5, r0);     // Catch: Throwable -> L16
        d(r0, r4, r7);     // Catch: Throwable -> L16
        List<d.b.r.h0.b> r9 = c(r6, r4, r7);     // Catch: Throwable -> L16
        if (com.bytedance.common.utility.collection.a.a(r9) == true) goto L15;
        r8.addAll(r9);     // Catch: Throwable -> L16
    L15:
        ReentrantReadWriteLock.ReadLock r10 = r2.readLock();
    L17:
        r10.unlock();
        if (r1 != null) goto L46;
        return r5;
    L46:
        k r11 = new k(((String) r1.first) + ((String) r1.second));     // Catch: Throwable -> L43
        if (r0.isEmpty() == true) goto L39;
        Iterator<Map.Entry<String, List<String>>> r12 = r0.entrySet().iterator();     // Catch: Throwable -> L43
    L24:
        if (r12.hasNext() == false) goto L39;
        Map.Entry<String, List<String>> r13 = r12.next();     // Catch: Throwable -> L43
        if (r13 == null) goto L24;
        if (TextUtils.isEmpty(r13.getKey()) == true) goto L24;
        List<String> r14 = r13.getValue();     // Catch: Throwable -> L43
        if (r14 == null) goto L24;
        if (r14.isEmpty() == true) goto L24;
        Iterator<String> r15 = r14.iterator();     // Catch: Throwable -> L43
    L37:
        if (r15.hasNext() == false) goto L24;
        r11.b(r13.getKey(), r15.next());     // Catch: Throwable -> L43
    L39:
        String r16 = r11.c();     // Catch: Throwable -> L43
        String r17 = Uri.parse(r5).getEncodedFragment();     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r17) == true) goto L61;
        return r16 + "#" + r17;
    L61:
        return r16;
    L43:
        return r5;
    L16:
        r10 = f13635c.readLock();
        goto L17
    }
}
