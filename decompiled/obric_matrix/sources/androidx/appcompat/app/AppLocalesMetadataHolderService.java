package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class AppLocalesMetadataHolderService extends Service {

    @RequiresApi(24)
    private static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static int getDisabledComponentFlag() {
            return 512;
        }
    }

    public AppLocalesMetadataHolderService() {
    }

    @NonNull
    public static ServiceInfo getServiceInfo(@NonNull Context r4) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        int r0 = Api24Impl.getDisabledComponentFlag() | 128;
    L7:
        return r4.getPackageManager().getServiceInfo(new ComponentName(r4, AppLocalesMetadataHolderService.class), r0);
    L5:
        r0 = 640;
        goto L7
    }

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@NonNull Intent r1) {
        throw new UnsupportedOperationException();
    }
}
