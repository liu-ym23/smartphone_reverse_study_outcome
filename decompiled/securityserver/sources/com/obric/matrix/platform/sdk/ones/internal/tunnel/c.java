package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.obric.matrix.platform.sdk.ones.SendCMDResultCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Consumer {
    public final /* synthetic */ int b;
    public final /* synthetic */ SendCMDResultCallback c;
    public final /* synthetic */ int e;

    public /* synthetic */ c(SendCMDResultCallback r1, int r2, int r3) {
        this.b = r3;
        this.c = r1;
        this.e = r2;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r2) {
        switch(this.b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        SendCMDResultCallback r1 = this.c;
        CmdManager.f(r1, this.e, (Throwable) r2);
        return;
    L6:
        SendCMDResultCallback r3 = this.c;
        CmdManager.e(r3, this.e, (Throwable) r2);
    }
}
