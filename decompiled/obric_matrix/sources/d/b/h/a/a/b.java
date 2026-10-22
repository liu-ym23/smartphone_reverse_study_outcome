package d.b.h.a.a;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile EnumC0353b f13211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f13212b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicLong f13213c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicLong f13214d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicLong f13215e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicLong f13216f = null;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13217a = null;

        static {
            int[] r0 = new int[EnumC0353b.values().length];
            f13217a = r0;
            r0[EnumC0353b.f13219h.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f13217a[EnumC0353b.f13220i.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f13217a[EnumC0353b.f13221j.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: renamed from: d.b.h.a.a.b$b, reason: collision with other inner class name */
    public static final enum EnumC0353b extends Enum<EnumC0353b> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0353b f13218g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final EnumC0353b f13219h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final EnumC0353b f13220i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final EnumC0353b f13221j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final /* synthetic */ EnumC0353b[] f13222k = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f13223f;

        static {
            EnumC0353b r0 = new EnumC0353b("NormalStart", 0, -1);
            f13218g = r0;
            EnumC0353b r1 = new EnumC0353b("ColdStart", 1, 0);
            f13219h = r1;
            EnumC0353b r3 = new EnumC0353b("HotStart", 2, 1);
            f13220i = r3;
            EnumC0353b r5 = new EnumC0353b("WarmStart", 3, 2);
            f13221j = r5;
            f13222k = new EnumC0353b[]{r0, r1, r3, r5};
        }

        private EnumC0353b(String r1, int r2, int r3) {
            super(r1, r2);
            this.f13223f = r3;
        }

        public static EnumC0353b valueOf(String r1) {
            return (EnumC0353b) Enum.valueOf(EnumC0353b.class, r1);
        }

        public static EnumC0353b[] values() {
            return (EnumC0353b[]) f13222k.clone();
        }

        public int a() {
            return this.f13223f;
        }
    }

    static {
        f13211a = EnumC0353b.f13218g;
        f13212b = new AtomicBoolean(false);
        f13213c = new AtomicLong(0);
        f13214d = new AtomicLong(0);
        f13215e = new AtomicLong(0);
        f13216f = new AtomicLong(0);
    }

    public static EnumC0353b a() {
        return f13211a;
    }

    public static EnumC0353b b() {
        Logger.debug();
        int r0 = a.f13217a[f13211a.ordinal()];
        if (r0 == 1) goto L21;
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L11;
        return f13211a;
    L11:
        if (d(f13213c.get(), f13216f.get()) == false) goto L14;
        f13211a = EnumC0353b.f13218g;
    L14:
        return f13211a;
    L16:
        if (d(f13213c.get(), f13215e.get()) == false) goto L19;
        f13211a = EnumC0353b.f13218g;
    L19:
        return f13211a;
    L21:
        if (d(f13213c.get(), f13214d.get()) == false) goto L24;
        f13211a = EnumC0353b.f13218g;
    L24:
        return f13211a;
    }

    public static boolean c() {
        return f13212b.get();
    }

    private static boolean d(long r4, long r6) {
        if (((System.currentTimeMillis() / 1000) - r4) <= r6) goto L5;
        return true;
    L5:
        return false;
    }

    public static void e(JSONObject r3) {
        AtomicBoolean r0 = f13212b;
        if (r3.optInt("request_tag_enabled") <= 0) goto L5;
        boolean r1 = true;
    L6:
        r0.set(r1);
        f13214d.set(r3.optInt("cold_start_seconds"));
        f13215e.set(r3.optInt("hot_start_seconds"));
        f13216f.set(r3.optInt("warm_start_seconds"));
        Logger.debug();
        return;
    L5:
        r1 = false;
        goto L6
    }
}
