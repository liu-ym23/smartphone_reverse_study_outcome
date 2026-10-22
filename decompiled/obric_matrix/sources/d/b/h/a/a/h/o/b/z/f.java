package d.b.h.a.a.h.o.b.z;

import android.net.Uri;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f13668a;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13669a = null;

        static {
            int[] r0 = new int[b.values().length];
            f13669a = r0;
            r0[b.f13671g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f13669a[b.f13676l.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f13670f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f13671g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f13672h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f13673i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f13674j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final b f13675k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final b f13676l = null;
        public static final b m = null;
        private static final /* synthetic */ b[] n = null;

        static {
            b r0 = new b("UNKNOWN_DISPATCH_STRATEGY", 0);
            f13670f = r0;
            b r1 = new b("STATIC_DISPATCH_STRATEGY", 1);
            f13671g = r1;
            b r3 = new b("WRR_DISPATCH_STRATEGY", 2);
            f13672h = r3;
            b r5 = new b("CONSERVATIVE_DISPATCH_STRATEGY", 3);
            f13673i = r5;
            b r7 = new b("OPTIMIZED_DISPATCH_STRATEGY", 4);
            f13674j = r7;
            b r9 = new b("ROUTE_SELECTION_DISPATCH_STRATEGY", 5);
            f13675k = r9;
            b r11 = new b("REQUEST_HEADER_DISPATCH_STRATEGY", 6);
            f13676l = r11;
            b r13 = new b("DISPATCH_STRATEGY_SUPPORTED_LAST", 7);
            m = r13;
            n = new b[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r1) {
            return (b) Enum.valueOf(b.class, r1);
        }

        public static b[] values() {
            return (b[]) n.clone();
        }
    }

    static {
    }

    public f(b r1) {
        this.f13668a = r1;
    }

    public static f b(b r0, JSONObject r1, String r2, long r3, int r5) {
        int r4 = a.f13669a[r0.ordinal()];
        if (r4 == 1) goto L11;
        if (r4 == 2) goto L9;
        Logger.debug();
        return new d.b.h.a.a.h.o.b.z.b();
    L9:
        return new h(r1);
    L11:
        return new i(r1);
    }

    public abstract void a(m r1);

    public b c() {
        return this.f13668a;
    }

    public abstract String d(Uri r1);

    public abstract boolean e();
}
