package com.obric.security.ota;

import android.os.UpdateEngineCallback;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.olog.OLog;
import kotlin.Metadata;

/* JADX INFO: compiled from: OtaUpdateEngineCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/security/ota/OtaUpdateEngineCallback;", "Landroid/os/UpdateEngineCallback;", "()V", "onPayloadApplicationComplete", "", AccountConst.KEY_ERROR_CODE, "", "onStatusUpdate", "status", "percent", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OtaUpdateEngineCallback extends UpdateEngineCallback {
    public void onPayloadApplicationComplete(int r1) {
    }

    public OtaUpdateEngineCallback() {
    }

    public void onStatusUpdate(int r2, float r3) {
        OLog.d("OceanDownloaderHelper", "onStatusUpdate:status" + r2 + ", percent:" + r3);
    }
}
