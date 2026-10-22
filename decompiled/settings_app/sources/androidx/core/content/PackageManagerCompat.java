package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class PackageManagerCompat {
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    public static final String LOG_TAG = "PackageManagerCompat";

    private static class Api30Impl {
        private Api30Impl() {
        }

        static boolean areUnusedAppRestrictionsEnabled(Context r0) {
            return !r0.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    public static ListenableFuture<Integer> getUnusedAppRestrictionsStatus(Context r5) {
        ResolvableFuture r0 = ResolvableFuture.create();
        if (UserManagerCompat.isUserUnlocked(r5) == true) goto L7;
        r0.set(0);
        Log.e(LOG_TAG, "User is in locked direct boot mode");
        return r0;
    L7:
        if (areUnusedAppRestrictionsAvailable(r5.getPackageManager()) == true) goto L10;
        r0.set(1);
        return r0;
    L10:
        int r1 = r5.getApplicationInfo().targetSdkVersion;
        if (r1 >= 30) goto L15;
        r0.set(0);
        Log.e(LOG_TAG, "Target SDK version below API 30");
        return r0;
    L15:
        if (Api30Impl.areUnusedAppRestrictionsEnabled(r5) == true) goto L17;
        r0.set(2);
    L22:
        return r0;
    L17:
        if (r1 < 31) goto L19;
        int r6 = 5;
    L20:
        r0.set(Integer.valueOf(r6));
        goto L22
    L19:
        r6 = 4;
        goto L20
    }

    public static boolean areUnusedAppRestrictionsAvailable(PackageManager r0) {
        getPermissionRevocationVerifierApp(r0);
        return true;
    }

    public static String getPermissionRevocationVerifierApp(PackageManager r4) {
        String r3 = null;
        Iterator<ResolveInfo> r0 = r4.queryIntentActivities(new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", "com.example", null)), 0).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        String r1 = r0.next().activityInfo.packageName;
        if (r4.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", r1) != 0) goto L4;
        if (r3 != null) goto L9;
        r3 = r1;
        goto L4
    L9:
        return r3;
    L11:
        return r3;
    }
}
