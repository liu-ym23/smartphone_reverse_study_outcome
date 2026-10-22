package androidx.window.core;

import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Landroidx/window/core/AndroidLogger;", "Landroidx/window/core/Logger;", "()V", "debug", "", LocationMonitorConst.TAG, "", "message", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AndroidLogger implements Logger {
    public static final AndroidLogger INSTANCE = null;

    static {
        INSTANCE = new AndroidLogger();
    }

    private AndroidLogger() {
    }

    @Override // androidx.window.core.Logger
    public void debug(String r1, String r2) {
        o.f(r1, LocationMonitorConst.TAG);
        o.f(r2, "message");
        Log.d(r1, r2);
    }
}
