package com.bytedance.securityserver.trustcircle.account;

import a.a;
import android.content.Context;
import android.util.Log;
import com.bytedance.privacy.pseudoid.account.AccountApi;
import com.obric.matrix.platform.sdk.ones.IMatrixBridge;

/* JADX INFO: loaded from: classes.dex */
public class MatrixBridgeImpl implements IMatrixBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f74a;

    @Override // com.obric.matrix.platform.sdk.ones.IMatrixBridge
    public final String appId() {
        return "ocean_securityserver";
    }

    @Override // com.obric.matrix.platform.sdk.ones.IMatrixBridge
    public final String appVersionCode() {
        Context r2 = this.f74a;
        return Long.toString(r2.getPackageManager().getPackageInfo(r2.getPackageName(), 0).getLongVersionCode());
    L5:
        e = move-exception;
        a.C(e, new StringBuilder("get app version code failed, error:"), "Security-MatrixBridgeImpl");
        return "";
    }

    @Override // com.obric.matrix.platform.sdk.ones.IMatrixBridge
    public final String did() {
        return AccountApi.a();
    L4:
        th = move-exception;
        StringBuilder r0 = new StringBuilder("get did failed, return empty: ");
        if (th.getMessage() != null) goto L8;
        String r2 = th.getClass().getSimpleName();
    L9:
        r0.append(r2);
        Log.w("Security-MatrixBridgeImpl", r0.toString());
        return "";
    L8:
        r2 = th.getMessage();
        goto L9
    }

    @Override // com.obric.matrix.platform.sdk.ones.IMatrixBridge
    public final boolean isOverSea() {
        return false;
    }

    @Override // com.obric.matrix.platform.sdk.ones.IMatrixBridge
    public final void logd(String r1, String r2, Throwable r3) {
    }

    @Override // com.obric.matrix.platform.sdk.ones.IMatrixBridge
    public final void loge(String r1, String r2, Throwable r3) {
        Log.e(r1, r2);
    }
}
