package d.b.b.e.a.k;

import d.b.b.o.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
interface f {

    public static class a implements f {
        public a() {
        }

        @Override // d.b.b.e.a.k.f
        public byte[] a(HashMap<Long, JSONArray> r6) {
            JSONObject r5 = new JSONObject();     // Catch: Exception -> L14
            JSONArray r0 = new JSONArray();     // Catch: Exception -> L14
            Iterator<Long> r1 = r6.keySet().iterator();     // Catch: Exception -> L14
        L4:
            if (r1.hasNext() == false) goto L12;
            JSONArray r2 = r6.get(r1.next());     // Catch: Exception -> L14
            if (r2 == null) goto L4;
            int r3 = 0;
        L10:
            if (r3 >= r2.length()) goto L4;
            r0.put(r2.get(r3));     // Catch: Exception -> L14
            r3 = r3 + 1;     // Catch: Exception -> L14
            goto L10
        L12:
            r5.put("header", d.b.b.e.a.i.d.d(d.b.b.e.a.i.b.f().e(String.valueOf(d.b.b.e.a.i.d.c()))));     // Catch: Exception -> L14
            r5.put("data", r0);     // Catch: Exception -> L14
            return i.b(r5.toString());
        L14:
            return null;
        }

        @Override // d.b.b.e.a.k.f
        public List<String> b() {
            return d.b.b.e.a.k.c.e().d();
        }

        @Override // d.b.b.e.a.k.f
        public String getName() {
            return "exception";
        }
    }

    public static class b implements f {
        public b() {
        }

        @Override // d.b.b.e.a.k.f
        public byte[] a(HashMap<Long, JSONArray> r7) {
            JSONArray r6 = new JSONArray();     // Catch: Exception -> L27
            Iterator<Long> r0 = r7.keySet().iterator();     // Catch: Exception -> L27
        L5:
            if (r0.hasNext() == false) goto L12;
            Long r1 = r0.next();     // Catch: Exception -> L27
            d.b.b.e.a.i.a r4 = d.b.b.e.a.i.b.f().e(String.valueOf(r1));     // Catch: Exception -> L27
            if (r4 == null) goto L9;
            JSONObject r5 = new JSONObject();     // Catch: Exception -> L27
            r5.put("data", r7.get(r1));     // Catch: Exception -> L27
            r5.put("header", d.b.b.e.a.i.d.d(r4));     // Catch: Exception -> L27
            r6.put(r5);     // Catch: Exception -> L27
            goto L5
        L9:
            if (d.b.b.o.a.c() == false) goto L5;
            d.b.b.o.m.b.f(d.b.b.e.a.a.f12571a, "HeaderInfo null for key " + r1);     // Catch: Exception -> L27
            goto L5
        L12:
            JSONArray r8 = d.b.b.e.a.k.b.c().d();     // Catch: Exception -> L27
            if (r8 != null) goto L15;
        L19:
            JSONObject r9 = new JSONObject();     // Catch: Exception -> L27
            r9.put("list", r6);     // Catch: Exception -> L27
            if (d.b.b.o.a.c() == false) goto L22;
            d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "request:" + r9);     // Catch: Exception -> L27
        L22:
            d.b.b.n.i.a r10 = (d.b.b.n.i.a) d.b.b.n.c.a(d.b.b.n.i.a.class);     // Catch: Exception -> L27
            if (r10 == null) goto L25;
            r9 = r10.a(r9);     // Catch: Exception -> L27
        L25:
            return i.b(r9.toString());
        L15:
            if (r8.length() <= 0) goto L19;
            d.b.b.e.a.i.a r2 = d.b.b.e.a.i.b.f().e(String.valueOf(d.b.b.e.a.i.d.c()));     // Catch: Exception -> L27
            if (r2 == null) goto L19;
            JSONObject r3 = new JSONObject();     // Catch: Exception -> L27
            r3.put("data", r8);     // Catch: Exception -> L27
            r3.put("header", d.b.b.e.a.i.d.d(r2));     // Catch: Exception -> L27
            r6.put(r3);     // Catch: Exception -> L27
        L27:
            return null;
        }

        @Override // d.b.b.e.a.k.f
        public List<String> b() {
            return d.b.b.e.a.k.c.e().f();
        }

        @Override // d.b.b.e.a.k.f
        public String getName() {
            return "log";
        }
    }

    public static class c implements f {
        public c() {
        }

        @Override // d.b.b.e.a.k.f
        public byte[] a(HashMap<Long, JSONArray> r10) {
            JSONObject r9 = new JSONObject();     // Catch: Exception -> L29
            JSONArray r0 = new JSONArray();     // Catch: Exception -> L29
            Iterator<Long> r1 = r10.keySet().iterator();     // Catch: Exception -> L29
        L4:
            if (r1.hasNext() == false) goto L25;
            JSONArray r2 = r10.get(r1.next());     // Catch: Exception -> L29
            if (r2 == null) goto L4;
            int r3 = 0;
        L10:
            if (r3 >= r2.length()) goto L4;
            List<Object> r4 = d.b.b.o.b.a(r2.getJSONObject(r3));     // Catch: Exception -> L21
            if (d.b.b.o.f.b(r4) == true) goto L23;
            Iterator<Object> r5 = r4.iterator();     // Catch: Exception -> L21
        L16:
            if (r5.hasNext() == false) goto L23;
            Object r6 = r5.next();     // Catch: Exception -> L21
            r0.put(r6);     // Catch: Exception -> L21
            if (d.b.b.o.a.c() == false) goto L16;
            d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, ":" + r6);     // Catch: Exception -> L21
        L23:
            r3 = r3 + 1;     // Catch: Exception -> L29
        L21:
            e = move-exception;
            d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "serialize", e);     // Catch: Exception -> L29
            goto L23
        L25:
            if (d.b.b.o.a.c() == false) goto L27;
            d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "jsonArray:" + r0);     // Catch: Exception -> L29
        L27:
            r9.put("header", d.b.b.e.a.i.d.d(d.b.b.e.a.i.b.f().e(String.valueOf(d.b.b.e.a.i.d.c()))));     // Catch: Exception -> L29
            r9.put("data", r0);     // Catch: Exception -> L29
            return i.b(r9.toString());
        L29:
            return null;
        }

        @Override // d.b.b.e.a.k.f
        public List<String> b() {
            return d.b.b.e.a.k.c.e().h();
        }

        @Override // d.b.b.e.a.k.f
        public String getName() {
            return "trace";
        }
    }

    byte[] a(HashMap<Long, JSONArray> r1);

    List<String> b();

    String getName();
}
