package com.bytedance.android.sdk.bdticketguard;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g f697f;

    public b(g r1) {
        this.f697f = r1;
    }

    public final g a() {
        return this.f697f;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Attestation already finished";
    }
}
