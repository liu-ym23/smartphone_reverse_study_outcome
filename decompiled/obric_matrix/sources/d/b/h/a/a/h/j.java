package d.b.h.a.a.h;

import d.b.r.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c.C0358c> f13401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<a> f13403c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f13407d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f13408e;

        public a(String r1, String r2, int r3, long r4, long r6, boolean r8) {
            this.f13404a = r1;
            this.f13405b = r2;
            this.f13406c = r3;
            this.f13407d = r4;
            this.f13408e = r6;
        }
    }

    public j(List<c.C0358c> r3) {
        ArrayList r0 = new ArrayList();
        this.f13401a = r0;
        this.f13402b = 0;
        this.f13403c = new CopyOnWriteArrayList();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L10;
        r0.addAll(r3);
        return;
    }

    public JSONObject a() {
        if (this.f13403c.isEmpty() == false) goto L6;
        return null;
    L6:
        JSONObject r0 = new JSONObject();
        Iterator<a> r6 = this.f13403c.iterator();     // Catch: JSONException -> L13
    L9:
        if (r6.hasNext() == false) goto L12;
        a r1 = r6.next();     // Catch: JSONException -> L13
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L13
        r2.put("callback_duration", r1.f13407d);     // Catch: JSONException -> L13
        r2.put("request_duration", r1.f13408e);     // Catch: JSONException -> L13
        r2.put("code", r1.f13406c);     // Catch: JSONException -> L13
        r0.put(r1.f13404a + r1.f13405b, r2);     // Catch: JSONException -> L13
    L12:
        return r0;
    }

    public c.C0358c b() {
        if (this.f13402b < this.f13401a.size()) goto L6;
        return null;
    L6:
        List<c.C0358c> r0 = this.f13401a;
        int r1 = this.f13402b;
        this.f13402b = r1 + 1;
        return r0.get(r1);
    }

    public boolean c() {
        if (this.f13401a.isEmpty() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f13402b >= this.f13401a.size()) goto L8;
        return false;
    }

    public void d(String r12, String r13, int r14, long r15, i r17, b r18) {
        if (r17 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean r10 = r1;
        long r2 = r18.U;
        if (r2 > 0) goto L12;
        r2 = r18.f13361h;
    L12:
        a r3 = new a(r12, r13, r14, r15, System.currentTimeMillis() - r2, r10);
        this.f13403c.add(r3);
        y r0 = r18.Y;
        if (r0 == null) goto L16;
        r0.H0 = a();
        return;
    L16:
        return;
    L5:
        if (r17.d() == false) goto L7;
        r1 = true;
        goto L8
    }
}
