package ms.bd.c;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q extends b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static q f22458a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f22459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f22460b;

        public a() {
        }

        public void a(String r3) {
            this.f22460b = r3;
            this.f22459a = System.currentTimeMillis();
        }

        public void b(String r11, int r12) {
            q r0 = q.c();
            if (r0 != null) goto L5;
            return;
        L5:
            long r1 = System.currentTimeMillis();
            long r3 = this.f22459a;
            r0.d(r1 - r3, r3, this.f22460b, null, r11, r12, null);
        }

        public void c(String r11, int r12) {
            q r0 = q.c();
            if (r0 != null) goto L5;
            return;
        L5:
            long r1 = System.currentTimeMillis();
            long r3 = this.f22459a;
            r0.h(r1 - r3, r3, this.f22460b, null, r11, r12, null);
        }
    }

    public q() {
    }

    public static synchronized q c() {
        monitor-enter(q.class);
        q r1 = f22458a;     // Catch: Throwable -> L7
        monitor-exit(q.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void f(q r1) {
        monitor-enter(q.class);
        f22458a = r1;     // Catch: Throwable -> L7
        monitor-exit(q.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // ms.bd.c.b.a
    public Object a(int r7, int r8, long r9, String r11, Object r12) {
        if (r7 != 131073) goto L11;
        if (r11 != null) goto L6;
    L9:
        return null;
    L6:
        if (g(r11) == false) goto L9;
        return (String) m.a(16777217, 0, 0, "2dd7b3", new byte[]{12, 77});
    L11:
        if (r7 != 131074) goto L19;
        String[] r13 = (String[]) r12;
        if (r11 == null) goto L19;
        if (r13 == null) goto L19;
        if (r13.length == 0) goto L19;
        e(r11, new JSONObject(r13[0]), new JSONObject(r13[1]), new JSONObject(r13[2]));
    L19:
        return null;
    }

    public abstract void d(long r1, long r3, String r5, String r6, String r7, int r8, JSONObject r9);

    public abstract void e(String r1, JSONObject r2, JSONObject r3, JSONObject r4);

    public abstract boolean g(String r1);

    public abstract void h(long r1, long r3, String r5, String r6, String r7, int r8, JSONObject r9);
}
