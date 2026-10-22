package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public final class AppLocalesMetadataHolderService extends Service {

    private static class Api24Impl {
        static int getDisabledComponentFlag() {
            return 512;
        }

        private Api24Impl() {
        }
    }

    public AppLocalesMetadataHolderService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        throw new UnsupportedOperationException();
    }

    public static ServiceInfo getServiceInfo(Context r4) throws PackageManager.NameNotFoundException {
        int r0 = Api24Impl.getDisabledComponentFlag() | 128;
        return r4.getPackageManager().getServiceInfo(new ComponentName(r4, AppLocalesMetadataHolderService.class), r0);
    }
}
