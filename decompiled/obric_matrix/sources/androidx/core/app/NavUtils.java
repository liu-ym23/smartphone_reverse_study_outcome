package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static Intent getParentActivityIntent(Activity r0) {
            return r0.getParentActivityIntent();
        }

        @DoNotInline
        static boolean navigateUpTo(Activity r0, Intent r1) {
            return r0.navigateUpTo(r1);
        }

        @DoNotInline
        static boolean shouldUpRecreateTask(Activity r0, Intent r1) {
            return r0.shouldUpRecreateTask(r1);
        }
    }

    private NavUtils() {
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Activity r3) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        Intent r0 = Api16Impl.getParentActivityIntent(r3);
        if (r0 == null) goto L7;
        return r0;
    L7:
        String r1 = getParentActivityName(r3);
        if (r1 != null) goto L10;
        return null;
    L10:
        ComponentName r2 = new ComponentName(r3, r1);
    L16:
        Log.e(TAG, "getParentActivityIntent: bad parentActivityName '" + r1 + "' in manifest");
        return null;
    L12:
        if (getParentActivityName(r3, r2) != null) goto L15;
        return Intent.makeMainActivity(r2);
    L15:
        return new Intent().setComponent(r2);
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context r2, @NonNull ComponentName r3) {
        String r0 = getParentActivityName(r2, r3);
        if (r0 != null) goto L6;
        return null;
    L6:
        ComponentName r1 = new ComponentName(r3.getPackageName(), r0);
        if (getParentActivityName(r2, r1) != null) goto L10;
        return Intent.makeMainActivity(r1);
    L10:
        return new Intent().setComponent(r1);
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Context r1, @NonNull Class<?> r2) {
        String r3 = getParentActivityName(r1, new ComponentName(r1, r2));
        if (r3 != null) goto L6;
        return null;
    L6:
        ComponentName r0 = new ComponentName(r1, r3);
        if (getParentActivityName(r1, r0) != null) goto L10;
        return Intent.makeMainActivity(r0);
    L10:
        return new Intent().setComponent(r0);
    }

    @Nullable
    public static String getParentActivityName(@NonNull Activity r1) {
        return getParentActivityName(r1, r1.getComponentName());
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    @Nullable
    public static String getParentActivityName(@NonNull Context r5, @NonNull ComponentName r6) {
        PackageManager r0 = r5.getPackageManager();
        int r1 = Build.VERSION.SDK_INT;
        int r3 = 640;
        if (r1 < 29) goto L5;
        r3 = 269222528;
    L7:
        ActivityInfo r7 = r0.getActivityInfo(r6, r3);
        if (r1 < 16) goto L12;
        String r2 = r7.parentActivityName;
        if (r2 == null) goto L12;
        return r2;
    L12:
        Bundle r8 = r7.metaData;
        if (r8 != null) goto L15;
        return null;
    L15:
        String r9 = r8.getString(PARENT_ACTIVITY);
        if (r9 != null) goto L19;
        return null;
    L19:
        if (r9.charAt(0) == '.') goto L21;
        return r9;
    L21:
        return r5.getPackageName() + r9;
    L5:
        if (r1 < 24) goto L7;
        r3 = 787072;
        goto L7
    }

    public static void navigateUpFromSameTask(@NonNull Activity r3) {
        Intent r0 = getParentActivityIntent(r3);
        if (r0 == null) goto L7;
        navigateUpTo(r3, r0);
        return;
    L7:
        throw new IllegalArgumentException("Activity " + r3.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void navigateUpTo(@NonNull Activity r2, @NonNull Intent r3) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.navigateUpTo(r2, r3);
        return;
    L5:
        r3.addFlags(67108864);
        r2.startActivity(r3);
        r2.finish();
    }

    public static boolean shouldUpRecreateTask(@NonNull Activity r2, @NonNull Intent r3) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        String r4 = r2.getIntent().getAction();
        if (r4 != null) goto L9;
    L11:
        return false;
    L9:
        if (r4.equals("android.intent.action.MAIN") == true) goto L11;
        return true;
    L5:
        return Api16Impl.shouldUpRecreateTask(r2, r3);
    }
}
