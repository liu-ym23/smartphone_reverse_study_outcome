package com.bytedance.android.sdk.bdticketguard;

/* JADX INFO: loaded from: classes.dex */
public final class o extends j0<r> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f922d;

    public o(r r9, String r10, String r11, String r12) {
        kotlin.n0.d.o.g(r9, "handleConsumerResponseParam");
        kotlin.n0.d.o.g(r10, "logid");
        kotlin.n0.d.o.g(r11, "remoteError");
        kotlin.n0.d.o.g(r12, "remoteAttestVerifyError");
        super(r9, r10, 0, 4, null);
        this.f921c = r11;
        this.f922d = r12;
    }

    public final String c() {
        return this.f922d;
    }

    public final String d() {
        return this.f921c;
    }
}
