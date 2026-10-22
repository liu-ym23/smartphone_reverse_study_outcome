package com.obric.matrix.sdk.network;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Consumer {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(int r1, Object r2) {
        this.b = r1;
        this.c = r2;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r2) {
        int r0 = this.b;
        Object r1 = this.c;
        switch(r0) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        HttpRequestManager.c((HttpRequestManager.DownloadCallback) r1, (Throwable) r2);
        return;
    L6:
        HttpRequestManager.d((HttpRequestManager.HttpErrorCallback) r1, (Throwable) r2);
        return;
    L8:
        HttpRequestManager.a((HttpRequestManager.HttpSuccessCallback) r1, (BaseResponseModel) r2);
    }
}
