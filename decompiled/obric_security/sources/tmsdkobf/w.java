package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e4 f587a = null;
    public static final e4 b = null;
    public static final ki[] c = null;
    public static long d;
    public static final m8 e = null;

    public class a implements m8 {
        public a() {
        }

        public void a(ki r5) {
            int r4 = r5.b;
            if (r4 != 2) goto L5;
        L21:
            e4 r6 = w.b;
            monitor-enter(r6);
            r6.a(r5);     // Catch: Throwable -> L26
            monitor-exit(r6);     // Catch: Throwable -> L26
            return;
        L26:
            th = move-exception;
            throw th;
        L5:
            if (r4 == 3) goto L21;
            h2 r7 = r5.c;
            if (r7 == null) goto L20;
            long r0 = Math.abs(r7.f236a - w.d);
            w.d = System.currentTimeMillis();
            if (r0 >= 1000) goto L12;
            return;
        L12:
            e4 r8 = w.f587a;
            monitor-enter(r8);
            r8.a(r5);     // Catch: Throwable -> L17
            monitor-exit(r8);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }
    }

    static {
        f587a = new e4(3);
        b = new e4(3);
        c = new ki[0];
        d = 0;
        e = new a();
    }
}
