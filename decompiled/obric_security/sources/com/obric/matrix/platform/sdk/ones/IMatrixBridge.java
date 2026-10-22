package com.obric.matrix.platform.sdk.ones;

import androidx.core.app.NotificationCompat;
import com.ss.android.message.log.PushLog;
import kotlin.Metadata;

/* JADX INFO: compiled from: IMatrixBridge.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/IMatrixBridge;", "", "appId", "", "appVersionCode", "did", "isOverSea", "", "logd", "", PushLog.KEY_TAG, NotificationCompat.CATEGORY_MESSAGE, "tr", "", "loge", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IMatrixBridge {
    String appId();

    String appVersionCode();

    String did();

    boolean isOverSea();

    void logd(String r1, String r2, Throwable r3);

    void loge(String r1, String r2, Throwable r3);
}
