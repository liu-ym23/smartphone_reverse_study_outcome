package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class PackageManagerCompat {

    @SuppressLint({"ActionValue"})
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String LOG_TAG = "PackageManagerCompat";

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        static boolean areUnusedAppRestrictionsEnabled(@NonNull Context r0) {
            return !r0.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean areUnusedAppRestrictionsAvailable(@NonNull PackageManager r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L5;
        boolean r4 = true;
    L7:
        if (r0 < 23) goto L10;
        if (r0 >= 30) goto L10;
        boolean r1 = true;
    L12:
        if (getPermissionRevocationVerifierApp(r6) == null) goto L14;
        boolean r7 = true;
    L15:
        if (r4 == true) goto L21;
        if (r1 == false) goto L20;
        if (r7 == false) goto L20;
        return true;
    L20:
        return false;
    L21:
        return true;
    L14:
        r7 = false;
    L10:
        r1 = false;
        goto L12
    L5:
        r4 = false;
        goto L7
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String getPermissionRevocationVerifierApp(@NonNull PackageManager r4) {
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

    @NonNull
    public static d.e.a.a.a.a<Integer> getUnusedAppRestrictionsStatus(@NonNull Context r7) {
        ResolvableFuture<Integer> r0 = ResolvableFuture.create();
        if (UserManagerCompat.isUserUnlocked(r7) == true) goto L7;
        r0.set(0);
        Log.e(LOG_TAG, "User is in locked direct boot mode");
        return r0;
    L7:
        if (areUnusedAppRestrictionsAvailable(r7.getPackageManager()) == true) goto L10;
        r0.set(1);
        return r0;
    L10:
        int r1 = r7.getApplicationInfo().targetSdkVersion;
        if (r1 >= 30) goto L14;
        r0.set(0);
        Log.e(LOG_TAG, "Target SDK version below API 30");
        return r0;
    L14:
        int r2 = Build.VERSION.SDK_INT;
        int r3 = 4;
        if (r2 >= 31) goto L17;
        if (r2 == 30) goto L26;
        final UnusedAppRestrictionsBackportServiceConnection r4 = new UnusedAppRestrictionsBackportServiceConnection(r7);
        r0.addListener(new t(r4), Executors.newSingleThreadExecutor());
        r4.connectAndFetchResult(r0);
        return r0;
    L26:
        if (Api30Impl.areUnusedAppRestrictionsEnabled(r7) == true) goto L29;
        r3 = 2;
    L29:
        r0.set(Integer.valueOf(r3));
        return r0;
    L17:
        if (Api30Impl.areUnusedAppRestrictionsEnabled(r7) == false) goto L21;
        if (r1 < 31) goto L20;
        r3 = 5;
    L20:
        int r8 = Integer.valueOf(r3);
    L22:
        r0.set(r8);
        return r0;
    L21:
        r8 = 2;
        goto L22
    }
}
