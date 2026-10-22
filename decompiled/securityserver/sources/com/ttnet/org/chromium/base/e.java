package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Callback {
    public final /* synthetic */ int b;
    public final /* synthetic */ Promise c;

    public /* synthetic */ e(Promise r1, int r2) {
        this.b = r2;
        this.c = r1;
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final void onResult(Object r2) {
        int r0 = this.b;
        Promise r1 = this.c;
        switch(r0) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        r1.fulfill(r2);
        return;
    L6:
        r1.reject((Exception) r2);
    }
}
