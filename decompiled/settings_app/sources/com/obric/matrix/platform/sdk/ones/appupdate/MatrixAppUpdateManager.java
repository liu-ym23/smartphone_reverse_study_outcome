package com.obric.matrix.platform.sdk.ones.appupdate;

import android.app.Activity;
import com.obric.appstore.autoupdate.ObricAutoUpdateUtils;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixAppUpdateManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/appupdate/MatrixAppUpdateManager;", "", "()V", "TAG", "", "abortUpdate", "", "checkUpdate", "activity", "Landroid/app/Activity;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixAppUpdateManager {
    public static final MatrixAppUpdateManager INSTANCE = null;
    private static final String TAG = "MatrixAppUpdateManager";

    static {
        INSTANCE = new MatrixAppUpdateManager();
    }

    private MatrixAppUpdateManager() {
    }

    public final void checkUpdate(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        ObricAutoUpdateUtils.getInstance().onStartCheckUpdate(r2, r2.getPackageName());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MLog.e(TAG, "checkUpdate error", e);
    }

    public final void abortUpdate() {
        ObricAutoUpdateUtils.getInstance().onDestoryCheckUpdate();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MLog.e(TAG, "abortUpdate error", e);
    }
}
