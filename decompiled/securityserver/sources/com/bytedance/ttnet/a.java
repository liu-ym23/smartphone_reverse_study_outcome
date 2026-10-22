package com.bytedance.ttnet;

import com.ss.android.agilelogger.INativeFuncAddrCallback;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements INativeFuncAddrCallback {
    @Override // com.ss.android.agilelogger.INativeFuncAddrCallback
    public final void onNativeFuncReady(long r1) {
        TTALog.a(r1);
    }
}
