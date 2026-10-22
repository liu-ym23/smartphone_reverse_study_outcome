package com.bytedance.securityserver;

import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.supplier.ObservableSupplierImpl;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ c(Object r1, Object r2, Object r3, int r4) {
        this.b = r4;
        this.c = r1;
        this.e = r2;
        this.f = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ObservableSupplierImpl.a((ObservableSupplierImpl) this.c, this.e, (Callback) this.f);
        return;
    L6:
        ((WorkflowManager.ApiCallback) this.c).onError("HTTP " + ((Response) this.e).code() + ": " + ((String) this.f));
    }
}
