package l.b.g.b.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, d> f22101c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22103b;

    static {
        HashMap r0 = new HashMap();
        r0.put(b("SHA-256", 32, 16, 67, 20, 2), new d(1, "XMSSMT_SHA2_20/2_256"));
        r0.put(b("SHA-256", 32, 16, 67, 20, 4), new d(2, "XMSSMT_SHA2_20/4_256"));
        r0.put(b("SHA-256", 32, 16, 67, 40, 2), new d(3, "XMSSMT_SHA2_40/2_256"));
        r0.put(b("SHA-256", 32, 16, 67, 40, 2), new d(4, "XMSSMT_SHA2_40/4_256"));
        r0.put(b("SHA-256", 32, 16, 67, 40, 4), new d(5, "XMSSMT_SHA2_40/8_256"));
        r0.put(b("SHA-256", 32, 16, 67, 60, 8), new d(6, "XMSSMT_SHA2_60/3_256"));
        r0.put(b("SHA-256", 32, 16, 67, 60, 6), new d(7, "XMSSMT_SHA2_60/6_256"));
        r0.put(b("SHA-256", 32, 16, 67, 60, 12), new d(8, "XMSSMT_SHA2_60/12_256"));
        r0.put(b("SHA-512", 64, 16, 131, 20, 2), new d(9, "XMSSMT_SHA2_20/2_512"));
        r0.put(b("SHA-512", 64, 16, 131, 20, 4), new d(10, "XMSSMT_SHA2_20/4_512"));
        r0.put(b("SHA-512", 64, 16, 131, 40, 2), new d(11, "XMSSMT_SHA2_40/2_512"));
        r0.put(b("SHA-512", 64, 16, 131, 40, 4), new d(12, "XMSSMT_SHA2_40/4_512"));
        r0.put(b("SHA-512", 64, 16, 131, 40, 8), new d(13, "XMSSMT_SHA2_40/8_512"));
        r0.put(b("SHA-512", 64, 16, 131, 60, 3), new d(14, "XMSSMT_SHA2_60/3_512"));
        r0.put(b("SHA-512", 64, 16, 131, 60, 6), new d(15, "XMSSMT_SHA2_60/6_512"));
        r0.put(b("SHA-512", 64, 16, 131, 60, 12), new d(16, "XMSSMT_SHA2_60/12_512"));
        r0.put(b("SHAKE128", 32, 16, 67, 20, 2), new d(17, "XMSSMT_SHAKE_20/2_256"));
        r0.put(b("SHAKE128", 32, 16, 67, 20, 4), new d(18, "XMSSMT_SHAKE_20/4_256"));
        r0.put(b("SHAKE128", 32, 16, 67, 40, 2), new d(19, "XMSSMT_SHAKE_40/2_256"));
        r0.put(b("SHAKE128", 32, 16, 67, 40, 4), new d(20, "XMSSMT_SHAKE_40/4_256"));
        r0.put(b("SHAKE128", 32, 16, 67, 40, 8), new d(21, "XMSSMT_SHAKE_40/8_256"));
        r0.put(b("SHAKE128", 32, 16, 67, 60, 3), new d(22, "XMSSMT_SHAKE_60/3_256"));
        r0.put(b("SHAKE128", 32, 16, 67, 60, 6), new d(23, "XMSSMT_SHAKE_60/6_256"));
        r0.put(b("SHAKE128", 32, 16, 67, 60, 12), new d(24, "XMSSMT_SHAKE_60/12_256"));
        r0.put(b("SHAKE256", 64, 16, 131, 20, 2), new d(25, "XMSSMT_SHAKE_20/2_512"));
        r0.put(b("SHAKE256", 64, 16, 131, 20, 4), new d(26, "XMSSMT_SHAKE_20/4_512"));
        r0.put(b("SHAKE256", 64, 16, 131, 40, 2), new d(27, "XMSSMT_SHAKE_40/2_512"));
        r0.put(b("SHAKE256", 64, 16, 131, 40, 4), new d(28, "XMSSMT_SHAKE_40/4_512"));
        r0.put(b("SHAKE256", 64, 16, 131, 40, 8), new d(29, "XMSSMT_SHAKE_40/8_512"));
        r0.put(b("SHAKE256", 64, 16, 131, 60, 3), new d(30, "XMSSMT_SHAKE_60/3_512"));
        r0.put(b("SHAKE256", 64, 16, 131, 60, 6), new d(31, "XMSSMT_SHAKE_60/6_512"));
        r0.put(b("SHAKE256", 64, 16, 131, 60, 12), new d(32, "XMSSMT_SHAKE_60/12_512"));
        f22101c = Collections.unmodifiableMap(r0);
    }

    private d(int r1, String r2) {
        this.f22102a = r1;
        this.f22103b = r2;
    }

    private static String b(String r1, int r2, int r3, int r4, int r5, int r6) {
        Objects.requireNonNull(r1, "algorithmName == null");
        return r1 + "-" + r2 + "-" + r3 + "-" + r4 + "-" + r5 + "-" + r6;
    }

    public static d c(String r1, int r2, int r3, int r4, int r5, int r6) {
        Objects.requireNonNull(r1, "algorithmName == null");
        return f22101c.get(b(r1, r2, r3, r4, r5, r6));
    }

    @Override // l.b.g.b.h.w
    public int a() {
        return this.f22102a;
    }

    public String toString() {
        return this.f22103b;
    }
}
