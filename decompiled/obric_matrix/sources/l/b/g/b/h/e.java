package l.b.g.b.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, e> f22104c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22106b;

    static {
        HashMap r0 = new HashMap();
        r0.put(b("SHA-256", 32, 16, 67, 10), new e(1, "XMSS_SHA2_10_256"));
        r0.put(b("SHA-256", 32, 16, 67, 16), new e(2, "XMSS_SHA2_16_256"));
        r0.put(b("SHA-256", 32, 16, 67, 20), new e(3, "XMSS_SHA2_20_256"));
        r0.put(b("SHA-512", 64, 16, 131, 10), new e(4, "XMSS_SHA2_10_512"));
        r0.put(b("SHA-512", 64, 16, 131, 16), new e(5, "XMSS_SHA2_16_512"));
        r0.put(b("SHA-512", 64, 16, 131, 20), new e(6, "XMSS_SHA2_20_512"));
        r0.put(b("SHAKE128", 32, 16, 67, 10), new e(7, "XMSS_SHAKE_10_256"));
        r0.put(b("SHAKE128", 32, 16, 67, 16), new e(8, "XMSS_SHAKE_16_256"));
        r0.put(b("SHAKE128", 32, 16, 67, 20), new e(9, "XMSS_SHAKE_20_256"));
        r0.put(b("SHAKE256", 64, 16, 131, 10), new e(10, "XMSS_SHAKE_10_512"));
        r0.put(b("SHAKE256", 64, 16, 131, 16), new e(11, "XMSS_SHAKE_16_512"));
        r0.put(b("SHAKE256", 64, 16, 131, 20), new e(12, "XMSS_SHAKE_20_512"));
        f22104c = Collections.unmodifiableMap(r0);
    }

    private e(int r1, String r2) {
        this.f22105a = r1;
        this.f22106b = r2;
    }

    private static String b(String r1, int r2, int r3, int r4, int r5) {
        Objects.requireNonNull(r1, "algorithmName == null");
        return r1 + "-" + r2 + "-" + r3 + "-" + r4 + "-" + r5;
    }

    public static e c(String r1, int r2, int r3, int r4, int r5) {
        Objects.requireNonNull(r1, "algorithmName == null");
        return f22104c.get(b(r1, r2, r3, r4, r5));
    }

    @Override // l.b.g.b.h.w
    public int a() {
        return this.f22105a;
    }

    public String toString() {
        return this.f22106b;
    }
}
