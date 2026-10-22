package p000j;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final enum b0 extends Enum<b0> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b0 f17672g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b0 f17673h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b0 f17674i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b0 f17675j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b0 f17676k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b0 f17677l = null;
    private static final /* synthetic */ b0[] m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f17678f;

    static {
        b0 r0 = new b0("HTTP_1_0", 0, "http/1.0");
        f17672g = r0;
        b0 r1 = new b0("HTTP_1_1", 1, "http/1.1");
        f17673h = r1;
        b0 r3 = new b0("SPDY_3", 2, "spdy/3.1");
        f17674i = r3;
        b0 r5 = new b0("HTTP_2", 3, "h2");
        f17675j = r5;
        b0 r7 = new b0("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        f17676k = r7;
        b0 r9 = new b0("QUIC", 5, "quic");
        f17677l = r9;
        m = new b0[]{r0, r1, r3, r5, r7, r9};
    }

    private b0(String r1, int r2, String r3) {
        super(r1, r2);
        this.f17678f = r3;
    }

    public static b0 a(String r3) {
        b0 r0 = f17672g;
        if (r3.equals(r0.f17678f) == false) goto L5;
        return r0;
    L5:
        b0 r1 = f17673h;
        if (r3.equals(r1.f17678f) == false) goto L8;
        return r1;
    L8:
        b0 r2 = f17676k;
        if (r3.equals(r2.f17678f) == false) goto L11;
        return r2;
    L11:
        b0 r4 = f17675j;
        if (r3.equals(r4.f17678f) == false) goto L14;
        return r4;
    L14:
        b0 r5 = f17674i;
        if (r3.equals(r5.f17678f) == false) goto L17;
        return r5;
    L17:
        b0 r6 = f17677l;
        if (r3.equals(r6.f17678f) == false) goto L21;
        return r6;
    L21:
        throw new IOException("Unexpected protocol: " + r3);
    }

    public static b0 valueOf(String r1) {
        return (b0) Enum.valueOf(b0.class, r1);
    }

    public static b0[] values() {
        return (b0[]) m.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f17678f;
    }
}
