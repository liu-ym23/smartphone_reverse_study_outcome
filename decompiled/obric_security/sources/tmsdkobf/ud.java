package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ud {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f555a = null;
    private static Map b;

    static /* synthetic */ class a {
    }

    public static class b {
        public long A;
        public int B;
        public boolean C;
        public boolean D;
        public boolean E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f556a;
        public boolean b;
        public String c;
        public String d;
        public z6 e;
        public t6 f;
        public String g;
        public boolean h;
        public boolean i;
        public n6 j;
        public int k;
        public boolean l;
        public boolean m;
        public boolean n;
        public boolean o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;
        public long v;
        public String w;
        public boolean x;
        public f6 y;
        public boolean z;

        /* synthetic */ b(Context r1, a r2) {
            this(r1);
        }

        public b a(c7 r1) {
            return this;
        }

        public b a(l6 r1) {
            return this;
        }

        public b b(boolean r1) {
            this.h = r1;
            return this;
        }

        public b c(boolean r1) {
            this.C = r1;
            return this;
        }

        public b d(boolean r1) {
            this.n = r1;
            return this;
        }

        public b e(boolean r1) {
            this.l = r1;
            return this;
        }

        public b f(boolean r1) {
            this.b = r1;
            return this;
        }

        public b g(boolean r1) {
            this.x = r1;
            return this;
        }

        public b h(boolean r1) {
            this.m = r1;
            return this;
        }

        private b(Context r5) {
            this.b = false;
            this.h = false;
            this.i = false;
            this.j = new n6();
            this.k = 0;
            this.l = true;
            this.m = true;
            this.n = false;
            this.o = false;
            this.p = 10485760;
            this.q = 2097152;
            this.r = 270;
            this.s = 300;
            this.t = 5;
            this.u = 5;
            this.v = WsConstants.EXIT_DELAY_TIME;
            this.w = "";
            this.x = true;
            this.z = true;
            this.A = 300;
            this.B = 0;
            this.C = true;
            this.D = true;
            this.E = false;
            this.f556a = r5;
        }

        public b b(int r1) {
            if (r1 <= 0) goto L4;
            this.s = r1;
        L4:
            return this;
        }

        public b c(int r1) {
            this.k = r1;
            return this;
        }

        public b a(int r1) {
            this.B = r1;
            return this;
        }

        public b b(String r1) {
            this.g = r1;
            return this;
        }

        public b c(String r1) {
            this.c = r1;
            return this;
        }

        public b a(boolean r1) {
            this.D = r1;
            return this;
        }

        public rd a() {
            cj.a(this.b);
            if (TextUtils.isEmpty(this.c) == true) goto L19;
            if (TextUtils.isEmpty(this.d) == true) goto L19;
            monitor-enter(ud.class);
            rd r1 = ud.a(this.c, this.d);     // Catch: Throwable -> L15
            if (r1 == null) goto L12;
            monitor-exit(ud.class);     // Catch: Throwable -> L15
            return r1;
        L12:
            rd r2 = new rd(this);     // Catch: Throwable -> L15
            ud.a(this.c, this.d, r2);     // Catch: Throwable -> L15
            monitor-exit(ud.class);     // Catch: Throwable -> L15
            return r2;
        L15:
            th = move-exception;
            throw th;
        L19:
            throw new IllegalArgumentException("SharkFactory.buid(): neither sharkPkg nor instanceName can be null!");
        }

        public b a(f6 r1) {
            this.y = r1;
            return this;
        }

        public b a(String r1) {
            this.d = r1;
            return this;
        }

        public b a(t6 r1) {
            this.f = r1;
            return this;
        }

        public b a(z6 r1) {
            this.e = r1;
            return this;
        }
    }

    static {
        f555a = new Object();
        b = new HashMap();
    }

    static /* synthetic */ void a(String r0, String r1, rd r2) {
        b(r0, r1, r2);
    }

    private static void b(String r1, String r2, rd r3) {
        String r4 = r1 + "-" + r2;
        Object r5 = f555a;
        monitor-enter(r5);
        b.put(r4, r3);     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static b a(Context r2) {
        if (r2 != null) goto L8;
        r2 = rd.e();
        if (r2 != null) goto L10;
        throw new RuntimeException("SharkFactory.builder(): context must not be null!");
    L10:
        return new b(r2, null);
    L8:
        rd.a(r2);
        goto L10
    }

    public static rd a(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == true) goto L15;
        if (TextUtils.isEmpty(r2) == true) goto L15;
        String r3 = r1 + "-" + r2;
        Object r4 = f555a;
        monitor-enter(r4);
        rd r5 = (rd) b.get(r3);     // Catch: Throwable -> L11
        monitor-exit(r4);     // Catch: Throwable -> L11
        return r5;
    L11:
        th = move-exception;
        throw th;
    L15:
        throw new IllegalArgumentException("getShark: neither sharkPkg nor instanceName can be null!");
    }
}
