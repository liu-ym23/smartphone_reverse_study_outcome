package com.bytedance.android.sdk.bdticketguard;

/* JADX INFO: loaded from: classes.dex */
public final class c extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f702g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f703h;

    public c(int r2, String r3, Throwable r4) {
        kotlin.n0.d.o.g(r3, "errorMessage");
        this(null, r2, r3, r4);
    }

    public /* synthetic */ c(int r1, String r2, Throwable r3, int r4, kotlin.n0.d.g r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public c(i r2, int r3, String r4, Throwable r5) {
        kotlin.n0.d.o.g(r4, "errorMessage");
        super(r4, r5);
        this.f701f = r2;
        this.f702g = r3;
        this.f703h = r4;
    }

    public /* synthetic */ c(i r1, int r2, String r3, Throwable r4, int r5, kotlin.n0.d.g r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }

    public final int a() {
        return this.f702g;
    }

    public final i b() {
        return this.f701f;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Attestation local exception, error code: " + this.f702g + ", error message: " + this.f703h;
    }
}
