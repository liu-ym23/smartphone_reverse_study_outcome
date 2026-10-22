package com.obric.matrix.platform.sdk.ones.internal.config;

import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Consumer {
    public final /* synthetic */ int b;

    public /* synthetic */ a(int r1) {
        this.b = r1;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r1) {
        switch(this.b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        MatrixOnesSdk.a((Throwable) r1);
        return;
    L6:
        SdkConfigManager.a((Long) r1);
    }
}
