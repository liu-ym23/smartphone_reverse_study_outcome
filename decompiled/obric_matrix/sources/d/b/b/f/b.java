package d.b.b.f;

import android.os.Process;
import com.bytedance.monitor.collector.k;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f12726a = 0;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f12727f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f12728g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f12729h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f12730i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ a[] f12731j = null;

        static {
            a r0 = new a("UNKNOWN", 0, -1);
            f12727f = r0;
            a r1 = new a("TOP_APP", 1, 0);
            f12728g = r1;
            a r3 = new a("FOREGROUND", 2, 1);
            f12729h = r3;
            a r5 = new a("BACKGROUND", 3, 2);
            f12730i = r5;
            f12731j = new a[]{r0, r1, r3, r5};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
        }

        public static a a(int r1) {
            if (r1 == (-1)) goto L18;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L14;
            if (r1 == 2) goto L12;
            return f12727f;
        L12:
            return f12730i;
        L14:
            return f12729h;
        L16:
            return f12728g;
        L18:
            return f12727f;
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f12731j.clone();
        }
    }

    static {
        f12726a = Process.myPid();
    }

    public static a a() {
        return a.a(k.n().q(f12726a));
    }
}
