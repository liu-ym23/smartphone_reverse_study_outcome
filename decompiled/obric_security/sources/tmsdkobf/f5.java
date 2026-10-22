package tmsdkobf;

import android.os.Debug;
import android.os.HandlerThread;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap f196a;
    private static e7 b;
    private static g5.a c;

    class a implements g5.a {
        a() {
        }

        @Override // tmsdkobf.g5.a
        public void a(Thread r1, Runnable r2) {
            g7 r0 = (g7) f5.m2379$$Nest$sfgeta().get(r1);
            if (r0 == null) goto L6;
            f5.m2381$$Nest$smb();
            f5.m2380$$Nest$sfgetb().b(r0);
            r0.f = System.currentTimeMillis();
            r0.g = Debug.threadCpuTimeNanos();
            return;
        }

        @Override // tmsdkobf.g5.a
        public void b(Thread r3, Runnable r4) {
            g7 r2 = (g7) f5.m2379$$Nest$sfgeta().remove(r3);
            if (r2 == null) goto L6;
            r2.f = System.currentTimeMillis() - r2.f;
            r2.g = Debug.threadCpuTimeNanos() - r2.g;
            f5.m2381$$Nest$smb();
            f5.m2380$$Nest$sfgetb().a(r2);
            return;
        }

        @Override // tmsdkobf.g5.a
        public void c(Thread r3, Runnable r4) {
            g7 r2 = new g7();
            r2.f214a = 3;
            r2.b = ((e5) r3).a();
            r2.c = r3.getName();
            r2.d = r3.getPriority();
            r2.f = -1;
            r2.g = -1;
            f5.m2379$$Nest$sfgeta().put(r3, r2);
            f5.m2381$$Nest$smb();
            f5.m2380$$Nest$sfgetb().a(r2, f5.a());
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgeta, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m2379$$Nest$sfgeta() {
        return f196a;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetb, reason: not valid java name */
    static /* bridge */ /* synthetic */ e7 m2380$$Nest$sfgetb() {
        return b;
    }

    /* JADX INFO: renamed from: -$$Nest$smb, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2381$$Nest$smb() {
        b();
    }

    static {
        f196a = new HashMap();
        c = new a();
    }

    public static int a() {
        return f196a.size();
    }

    private static void b() {
        if (b != null) goto L6;
        b = o2.e();
        return;
    }

    public static g5.a c() {
        return c;
    }

    public static HandlerThread a(String r1, int r2, long r3) {
        return new e5(r1, r2, r3);
    }
}
