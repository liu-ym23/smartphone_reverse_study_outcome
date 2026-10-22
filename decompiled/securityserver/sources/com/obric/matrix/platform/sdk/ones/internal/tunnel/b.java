package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.obric.matrix.platform.sdk.ones.SendCMDResultCallback;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Consumer {
    public final /* synthetic */ int b;
    public final /* synthetic */ SendCMDResultCallback c;

    public /* synthetic */ b(SendCMDResultCallback r1, int r2) {
        this.b = r2;
        this.c = r1;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r2) {
        int r0 = this.b;
        SendCMDResultCallback r1 = this.c;
        Pair r3 = (Pair) r2;
        switch(r0) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        CmdManager.g(r1, r3);
        return;
    L6:
        CmdManager.a(r1, r3);
    }
}
