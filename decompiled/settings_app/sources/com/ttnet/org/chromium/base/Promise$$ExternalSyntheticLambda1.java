package com.ttnet.org.chromium.base;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Promise$$ExternalSyntheticLambda1 implements Callback {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ Promise$$ExternalSyntheticLambda1(Promise r1) {
        this.f$0 = r1;
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final void onResult(Object r1) {
        this.f$0.reject((Exception) r1);
    }
}
