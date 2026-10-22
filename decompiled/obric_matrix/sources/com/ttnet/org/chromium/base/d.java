package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Promise f12338f;

    public /* synthetic */ d(Promise r1) {
        this.f12338f = r1;
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final void onResult(Object r1) {
        this.f12338f.reject((Exception) r1);
    }
}
