package a.a.a.a.a.c;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.ss.android.message.log.PushLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/push/common/log/AndroidLogger;", "Lcom/obric/matrix/push/common/log/ILogger;", "()V", "logd", "", PushLog.KEY_TAG, "", NotificationCompat.CATEGORY_MESSAGE, "loge", "tr", "", "logi", "logv", "logw", "sdk_push_common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements b {
    public a() {
    }

    @Override // a.a.a.a.a.c.b
    public void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        Log.d(r1, r2);
    }

    @Override // a.a.a.a.a.c.b
    public void a(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        Log.e(r1, r2, r3);
    }

    @Override // a.a.a.a.a.c.b
    public void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        Log.i(r1, r2);
    }
}
