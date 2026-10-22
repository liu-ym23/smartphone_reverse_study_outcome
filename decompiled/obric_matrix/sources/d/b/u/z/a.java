package d.b.u.z;

import d.b.u.l;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final l<ExecutorService> f15128a = null;

    /* JADX INFO: renamed from: d.b.u.z.a$a, reason: collision with other inner class name */
    static class C0408a extends l<ExecutorService> {
        C0408a() {
        }

        @Override // d.b.u.l
        protected /* bridge */ /* synthetic */ ExecutorService a(Object[] r1) {
            return c(r1);
        }

        protected ExecutorService c(Object... r1) {
            return Executors.newSingleThreadExecutor();
        }
    }

    static {
        f15128a = new C0408a();
    }

    public static void a(Runnable r2) {
        f15128a.b(new Object[0]).submit(r2);
    }
}
