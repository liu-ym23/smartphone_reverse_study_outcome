package androidx.core.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectivityManagerCompat {
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    static class Api16Impl {
        private Api16Impl() {
        }

        static boolean isActiveNetworkMetered(ConnectivityManager r0) {
            return r0.isActiveNetworkMetered();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static int getRestrictBackgroundStatus(ConnectivityManager r0) {
            return r0.getRestrictBackgroundStatus();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RestrictBackgroundStatus {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager r0) {
        return Api16Impl.isActiveNetworkMetered(r0);
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager r1, Intent r2) {
        NetworkInfo r3 = (NetworkInfo) r2.getParcelableExtra("networkInfo");
        if (r3 != null) goto L5;
        return null;
    L5:
        return r1.getNetworkInfo(r3.getType());
    }

    public static int getRestrictBackgroundStatus(ConnectivityManager r0) {
        return Api24Impl.getRestrictBackgroundStatus(r0);
    }

    private ConnectivityManagerCompat() {
    }
}
