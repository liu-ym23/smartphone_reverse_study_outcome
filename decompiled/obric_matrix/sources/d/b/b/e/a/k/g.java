package d.b.b.e.a.k;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f12695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f12696b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<f> f12697c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f.a f12698d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f.c f12699e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final f.b f12700f = null;

    static {
        f12695a = new AtomicInteger(0);
        f12696b = Arrays.asList(new String[]{"tracing"});
        f.a r0 = new f.a();
        f12698d = r0;
        f.c r1 = new f.c();
        f12699e = r1;
        f.b r2 = new f.b();
        f12700f = r2;
        ArrayList r3 = new ArrayList();
        f12697c = r3;
        r3.add(r0);
        r3.add(r1);
        r3.add(r2);
    }

    private static void a(Map<Long, List<d.b.b.e.a.j.b>> r9) {
        if (d.b.b.o.a.c() == false) goto L12;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "sendLog: input sendList merged into " + r9.size() + " group(s)");
        Iterator<Long> r0 = r9.keySet().iterator();
        int r2 = 0;
    L6:
        if (r0.hasNext() == false) goto L15;
        Long r3 = r0.next();
        List<d.b.b.e.a.j.b> r4 = r9.get(r3);
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "----------------");
        d.b.b.e.a.i.a r5 = d.b.b.e.a.i.b.f().e(String.valueOf(r3));
        String r6 = d.b.b.e.a.a.f12571a;
        StringBuilder r7 = new StringBuilder();
        r7.append("group ");
        int r8 = r2 + 1;
        r7.append(r2);
        r7.append(" header:");
        r7.append(r5);
        d.b.b.o.m.b.a(r6, r7.toString());
        int r10 = 0;
    L9:
        if (r10 >= r4.size()) goto L11;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "  log[" + r10 + "]=" + r4.get(r10).toString());
        r10 = r10 + 1;
        goto L9
    L11:
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "----------------");
        r2 = r8;
        goto L6
    L15:
        return;
    }

    private static f b(JSONObject r1) {
        String r2 = r1.optString("log_type");
        if (d.b.b.e.a.a.f12572b.contains(r2) == false) goto L7;
        return f12698d;
    L7:
        if (f12696b.contains(r2) == false) goto L11;
        return f12699e;
    L11:
        return f12700f;
    }

    public static List<f> c() {
        return f12697c;
    }

    public static Map<f, byte[]> d(List<d.b.b.e.a.j.a> r22, int r23) {
        String r1 = "_debug_self";
        HashMap r2 = new HashMap();     // Catch: Throwable -> L78
        long r3 = r22.size();     // Catch: Throwable -> L78
        Iterator<d.b.b.e.a.j.a> r5 = r22.iterator();     // Catch: Throwable -> L78
        long r6 = 0;
        long r8 = 0;
    L5:
        if (r5.hasNext() == false) goto L10;
        d.b.b.e.a.j.a r10 = r5.next();     // Catch: Throwable -> L78
        long r11 = r10.e();     // Catch: Throwable -> L78
        List r13 = (List) r2.get(Long.valueOf(r11));     // Catch: Throwable -> L78
        if (r13 != null) goto L9;
        r13 = new ArrayList();     // Catch: Throwable -> L78
        r2.put(Long.valueOf(r11), r13);     // Catch: Throwable -> L78
    L9:
        r6 = r6 + ((long) r10.f());     // Catch: Throwable -> L78
        r8 = r8 + ((long) r10.g());     // Catch: Throwable -> L78
        r13.addAll(r10.c());     // Catch: Throwable -> L78
        goto L5
    L10:
        a(r2);     // Catch: Throwable -> L78
        File r7 = a.g().f();     // Catch: Throwable -> L78
        if (r7 == null) goto L15;
        String[] r9 = r7.list();     // Catch: Throwable -> L78
        if (r9 == null) goto L15;
        int r12 = r9.length;     // Catch: Throwable -> L78
    L16:
        HashMap r14 = new HashMap();     // Catch: Throwable -> L78
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L78
        Iterator r16 = r2.keySet().iterator();     // Catch: Throwable -> L78
    L18:
        if (r16.hasNext() == false) goto L70;
        Long r17 = (Long) r16.next();     // Catch: Throwable -> L78
        List r18 = (List) r2.get(r17);     // Catch: Throwable -> L78
        if (r18 == null) goto L18;
        HashMap r19 = r2;
        int r110 = 0;
    L24:
        if (r110 >= r18.size()) goto L69;
        Iterator r111 = r16;
        List r112 = r18;
        JSONObject r113 = new JSONObject(new String(((d.b.b.e.a.j.b) r18.get(r110)).a()));     // Catch: Exception -> L84 Throwable -> L78
        if (d.b.b.e.a.k.h.a.a().d(r113, d.b.b.i.c.a.h()) == false) goto L33;
        f r4 = b(r113);     // Catch: Throwable -> L78
        if ((r4 instanceof f.b) == true) goto L95;
        r1 = r1;
        r110 = r110;
        r14 = r14;
    L60:
        Map r114 = (Map) r14.get(r4);     // Catch: Throwable -> L78
        if (r114 != null) goto L64;
        r114 = new HashMap();     // Catch: Throwable -> L78
        r14.put(r4, r114);     // Catch: Throwable -> L78
    L64:
        if (r114.containsKey(r17) == true) goto L66;
        r114.put(r17, new JSONArray());     // Catch: Throwable -> L78
    L66:
        ((JSONArray) r114.get(r17)).put(r113);     // Catch: Throwable -> L78
        goto L68
    L95:
        JSONObject r115 = r113.optJSONObject(r1);     // Catch: Exception -> L52 Throwable -> L78
        if (r115 != null) goto L42;
        r115 = new JSONObject();     // Catch: Exception -> L52 Throwable -> L78
        r113.put(r1, r115);     // Catch: Exception -> L52 Throwable -> L78
    L42:
        r1 = r1;
        r110 = r110;
        r115.put("debug_sender_number", f12695a.getAndIncrement());     // Catch: Exception -> L51 Throwable -> L78
        HashMap r20 = r14;
        r115.put("debug_sender_sid", d.b.b.i.c.a.u());     // Catch: Exception -> L82 Throwable -> L78
        r115.put("debug_total_bytes", r6);     // Catch: Exception -> L82 Throwable -> L78
        r115.put("debug_total_count", r8);     // Catch: Exception -> L82 Throwable -> L78
        r115.put("debug_merge_file_count", r3);     // Catch: Exception -> L82 Throwable -> L78
        r115.put("debug_second_file_count", r12);     // Catch: Exception -> L82 Throwable -> L78
        r115.put("debug_left_file_count", r23);     // Catch: Exception -> L81 Throwable -> L78
    L56:
        if (r113.has("seq_no") == false) goto L58;
        r15.add(String.valueOf(r113.get("seq_no")));     // Catch: Throwable -> L78
    L58:
        r14 = r20;
    L51:
        r20 = r14;
    L53:
        r110 = r110;
        r20 = r14;
    L52:
        r1 = r1;
        goto L53
    L33:
        if (d.b.b.o.a.c() == false) goto L68;
        d.b.b.o.m.b.a("APM-Downgrade", r113.toString());     // Catch: Throwable -> L78
    L68:
        r14 = r14;
        r110 = r110 + 1;     // Catch: Throwable -> L78
        r16 = r111;
        r18 = r112;
        r1 = r1;
    L67:
        r112 = r18;
        goto L68
    L69:
        r2 = r19;
        goto L18
    L70:
        HashMap r21 = r14;
        HashMap r0 = new HashMap();     // Catch: Throwable -> L78
        Iterator r24 = r21.keySet().iterator();     // Catch: Throwable -> L78
    L72:
        if (r24.hasNext() == false) goto L75;
        f r25 = (f) r24.next();     // Catch: Throwable -> L78
        r0.put(r25, r25.a((HashMap) r21.get(r25)));     // Catch: Throwable -> L78
        goto L72
    L75:
        if (com.bytedance.apm.x.a.c() == null) goto L77;
        com.bytedance.apm.x.a.c().a(d.b.b.e.a.a.f12571a, "seqNoList:" + r15.toString());     // Catch: Throwable -> L78
    L77:
        return r0;
    L15:
        r12 = 0;
    L78:
        th = move-exception;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "LogSender serialize failed.", th);
        return null;
    }
}
