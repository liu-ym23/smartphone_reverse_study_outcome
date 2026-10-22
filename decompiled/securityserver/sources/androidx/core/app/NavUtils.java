package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    private NavUtils() {
    }

    @Nullable
    public static Intent getParentActivityIntent(@NonNull Activity r3) {
        Intent r0 = r3.getParentActivityIntent();
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = getParentActivityName(r3);
        if (r1 != null) goto L8;
        return null;
    L8:
        ComponentName r2 = new ComponentName(r3, r1);
    L14:
        Log.e(TAG, "getParentActivityIntent: bad parentActivityName '" + r1 + "' in manifest");
        return null;
    L10:
        if (getParentActivityName(r3, r2) != null) goto L13;
        return Intent.makeMainActivity(r2);
    L13:
        return new Intent().setComponent(r2);
    }

    @Nullable
    public static String getParentActivityName(@NonNull Activity r1) {
        return getParentActivityName(r1, r1.getComponentName());
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static void navigateUpFromSameTask(@NonNull Activity r3) {
        Intent r0 = getParentActivityIntent(r3);
        if (r0 == null) goto L7;
        navigateUpTo(r3, r0);
        return;
    L7:
        throw new IllegalArgumentException("Activity " + r3.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void navigateUpTo(@NonNull Activity r0, @NonNull Intent r1) {
        r0.navigateUpTo(r1);
    }

    public static boolean shouldUpRecreateTask(@NonNull Activity r0, @NonNull Intent r1) {
        return r0.shouldUpRecreateTask(r1);
    }

    @Nullable
    public static String getParentActivityName(@NonNull Context r2, @NonNull ComponentName r3) {
        ActivityInfo r4 = r2.getPackageManager().getActivityInfo(r3, 269222528);
        String r0 = r4.parentActivityName;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Bundle r5 = r4.metaData;
        if (r5 != null) goto L8;
        return null;
    L8:
        String r6 = r5.getString(PARENT_ACTIVITY);
        if (r6 != null) goto L12;
        return null;
    L12:
        if (r6.charAt(0) == '.') goto L14;
        return r6;
    L14:
        return r2.getPackageName() + r6;
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
}
