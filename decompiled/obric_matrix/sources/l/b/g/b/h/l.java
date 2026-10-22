package l.b.g.b.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class l implements w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, l> f22132c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22134b;

    static {
        HashMap r0 = new HashMap();
        r0.put(b("SHA-256", 32, 16, 67), new l(16777217, "WOTSP_SHA2-256_W16"));
        r0.put(b("SHA-512", 64, 16, 131), new l(33554434, "WOTSP_SHA2-512_W16"));
        r0.put(b("SHAKE128", 32, 16, 67), new l(50331651, "WOTSP_SHAKE128_W16"));
        r0.put(b("SHAKE256", 64, 16, 131), new l(67108868, "WOTSP_SHAKE256_W16"));
        f22132c = Collections.unmodifiableMap(r0);
    }

    private l(int r1, String r2) {
        this.f22133a = r1;
        this.f22134b = r2;
    }

    private static String b(String r1, int r2, int r3, int r4) {
        Objects.requireNonNull(r1, "algorithmName == null");
        return r1 + "-" + r2 + "-" + r3 + "-" + r4;
    }

    protected static l c(String r1, int r2, int r3, int r4) {
        Objects.requireNonNull(r1, "algorithmName == null");
        return f22132c.get(b(r1, r2, r3, r4));
    }

    @Override // l.b.g.b.h.w
    public int a() {
        return this.f22133a;
    }

    public String toString() {
        return this.f22134b;
    }
}
