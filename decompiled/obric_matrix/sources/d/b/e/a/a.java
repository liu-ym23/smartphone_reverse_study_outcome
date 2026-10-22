package d.b.e.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f13191a;

    /* JADX INFO: renamed from: d.b.e.a.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0350a {
    }

    private static class b {
        private b() {
        }

        /* synthetic */ b(C0350a r1) {
            this();
        }

        public long a(ActivityManager.MemoryInfo r1) {
            return 0;
        }
    }

    @TargetApi(16)
    private static class c extends b {
        private c() {
            super(null);
        }

        /* synthetic */ c(C0350a r1) {
            this();
        }

        @Override // d.b.e.a.a.b
        public long a(ActivityManager.MemoryInfo r1) {
            return r1.totalMem;
        }
    }

    static {
        C0350a r1 = null;
        if (Build.VERSION.SDK_INT < 16) goto L5;
        b r0 = new c(r1);
    L6:
        f13191a = r0;
        return;
    L5:
        r0 = new b(r1);
        goto L6
    }

    public static long a(ActivityManager.MemoryInfo r2) {
        return f13191a.a(r2);
    }
}
