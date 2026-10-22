package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Callback {
    public final /* synthetic */ int b;
    public final /* synthetic */ Promise c;
    public final /* synthetic */ Function e;

    public /* synthetic */ d(Promise.AsyncFunction r2, Promise r3) {
        this.b = 0;
        this.e = r2;
        this.c = r3;
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final void onResult(Object r2) {
        switch(this.b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Promise.c(this.c, this.e, r2);
        return;
    L6:
        Promise.a((Promise.AsyncFunction) this.e, this.c, r2);
    }

    public /* synthetic */ d(Promise r2, Function r3) {
        this.b = 1;
        this.c = r2;
        this.e = r3;
    }
}
