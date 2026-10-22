package com.bytedance.securityserver.trustcircle.account;

import android.util.Log;
import com.obric.matrix.platform.sdk.ones.account.api.ILogger;

/* JADX INFO: loaded from: classes.dex */
public class AccountLogger implements ILogger {
    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public final void d(String r1, String r2, Throwable r3) {
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public final void e(String r1, String r2, Throwable r3) {
        Log.e(r1, r2);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public final void i(String r1, String r2, Throwable r3) {
        Log.i(r1, r2);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public final void v(String r1, String r2, Throwable r3) {
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public final void w(String r1, String r2, Throwable r3) {
    }
}
