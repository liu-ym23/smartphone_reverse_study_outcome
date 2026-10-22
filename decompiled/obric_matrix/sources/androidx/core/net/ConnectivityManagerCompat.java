package androidx.core.net;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectivityManagerCompat {
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
        @DoNotInline
        static boolean isActiveNetworkMetered(ConnectivityManager r0) {
            return r0.isActiveNetworkMetered();
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static int getRestrictBackgroundStatus(ConnectivityManager r0) {
            return r0.getRestrictBackgroundStatus();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface RestrictBackgroundStatus {
    }

    private ConnectivityManagerCompat() {
    }

    @Nullable
    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    @SuppressLint({"ReferencesDeprecated"})
    public static NetworkInfo getNetworkInfoFromBroadcast(@NonNull ConnectivityManager r1, @NonNull Intent r2) {
        NetworkInfo r3 = (NetworkInfo) r2.getParcelableExtra("networkInfo");
        if (r3 != null) goto L5;
        return null;
    L5:
        return r1.getNetworkInfo(r3.getType());
    }

    public static int getRestrictBackgroundStatus(@NonNull ConnectivityManager r2) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return 3;
    L5:
        return Api24Impl.getRestrictBackgroundStatus(r2);
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean isActiveNetworkMetered(@NonNull ConnectivityManager r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        NetworkInfo r3 = r2.getActiveNetworkInfo();
        if (r3 != null) goto L9;
        return true;
    L9:
        int r4 = r3.getType();
        if (r4 != 1) goto L12;
        return false;
    L12:
        if (r4 != 7) goto L14;
        return false;
    L14:
        if (r4 == 9) goto L19;
        return true;
    L19:
        return false;
    L5:
        return Api16Impl.isActiveNetworkMetered(r2);
    }
}
