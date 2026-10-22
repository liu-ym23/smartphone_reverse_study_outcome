package d.b.r;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final s f14542a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f14543b = false;

    static class a extends s {

        /* JADX INFO: renamed from: d.b.r.s$a$a, reason: collision with other inner class name */
        static class ExecutorC0393a implements Executor {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final Handler f14544f;

            ExecutorC0393a() {
                this.f14544f = new Handler(Looper.getMainLooper());
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable r1) {
                this.f14544f.post(r1);
            }
        }

        a() {
        }

        @Override // d.b.r.s
        List<? extends c.a> a(Executor r1) {
            if (r1 == null) goto L6;
            return Collections.singletonList(new j(r1));
        L6:
            throw new AssertionError();
        }

        @Override // d.b.r.s
        public Executor b() {
            return new ExecutorC0393a();
        }

        @Override // d.b.r.s
        List<? extends f.a> c() {
            return Collections.emptyList();
        }

        @Override // d.b.r.s
        int d() {
            return 0;
        }

        @Override // d.b.r.s
        boolean i(Method r2) {
            if (Build.VERSION.SDK_INT >= 24) goto L7;
            return false;
        L7:
            return r2.isDefault();
        }
    }

    static {
        f14542a = e();
        f14543b = f();
    }

    s() {
    }

    private static s e() {
        Class.forName("android.os.Build");     // Catch: ClassNotFoundException -> L8
        if (Build.VERSION.SDK_INT == 0) goto L7;
        return new a();
    L7:
        return new s();
    }

    private static boolean f() {
        new Retrofit.Builder();     // Catch: NoClassDefFoundError -> L5
        return true;
    L5:
        return false;
    }

    static s g() {
        return f14542a;
    }

    static boolean j() {
        return f14543b;
    }

    List<? extends c.a> a(Executor r1) {
        if (r1 == null) goto L6;
        Object r0 = new j(r1);
    L5:
        return Collections.singletonList(r0);
    L6:
        r0 = g.f14360a;
        goto L5
    }

    public Executor b() {
        return null;
    }

    List<? extends f.a> c() {
        return Collections.emptyList();
    }

    int d() {
        return 0;
    }

    Object h(Method r1, Class<?> r2, Object r3, Object... r4) {
        throw new UnsupportedOperationException();
    }

    boolean i(Method r1) {
        return false;
    }
}
