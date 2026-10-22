package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppCompatDelegate {
    static final boolean DEBUG = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;

    @Deprecated
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;

    @Deprecated
    public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;
    static final String TAG = "AppCompatDelegate";
    private static final ArraySet<WeakReference<AppCompatDelegate>> sActivityDelegates = null;
    private static final Object sActivityDelegatesLock = null;
    private static int sDefaultNightMode = -100;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NightMode {
    }

    static {
        sActivityDelegates = new ArraySet();
        sActivityDelegatesLock = new Object();
    }

    public AppCompatDelegate() {
    }

    public static void addActiveDelegate(@NonNull AppCompatDelegate r3) {
        Object r0 = sActivityDelegatesLock;
        monitor-enter(r0);
        removeDelegateFromActives(r3);     // Catch: Throwable -> L7
        sActivityDelegates.add(new WeakReference(r3));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void applyDayNightToActiveDelegates() {
        Object r0 = sActivityDelegatesLock;
        monitor-enter(r0);
        Iterator<WeakReference<AppCompatDelegate>> r1 = sActivityDelegates.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L12;
        AppCompatDelegate r2 = r1.next().get();     // Catch: Throwable -> L10
        if (r2 == null) goto L6;
        r2.applyDayNight();     // Catch: Throwable -> L10
        goto L6
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Activity r1, @Nullable AppCompatCallback r2) {
        return new AppCompatDelegateImpl(r1, r2);
    }

    public static int getDefaultNightMode() {
        return sDefaultNightMode;
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
    }

    public static void removeActivityDelegate(@NonNull AppCompatDelegate r1) {
        Object r0 = sActivityDelegatesLock;
        monitor-enter(r0);
        removeDelegateFromActives(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void removeDelegateFromActives(@NonNull AppCompatDelegate r3) {
        Object r0 = sActivityDelegatesLock;
        monitor-enter(r0);
        Iterator<WeakReference<AppCompatDelegate>> r1 = sActivityDelegates.iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L13;
        AppCompatDelegate r2 = r1.next().get();     // Catch: Throwable -> L11
        if (r2 == r3) goto L10;
        if (r2 != null) goto L6;
    L10:
        r1.remove();     // Catch: Throwable -> L11
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean r0) {
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(r0);
    }

    public static void setDefaultNightMode(int r1) {
        if (r1 == (-1)) goto L13;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L13;
        Log.d(TAG, "setDefaultNightMode() called with an unknown mode");
        return;
    L13:
        if (sDefaultNightMode == r1) goto L17;
        sDefaultNightMode = r1;
        applyDayNightToActiveDelegates();
        return;
    }

    public abstract void addContentView(View r1, ViewGroup.LayoutParams r2);

    public abstract boolean applyDayNight();

    @Deprecated
    public void attachBaseContext(Context r1) {
    }

    @NonNull
    @CallSuper
    public Context attachBaseContext2(@NonNull Context r1) {
        attachBaseContext(r1);
        return r1;
    }

    public abstract View createView(@Nullable View r1, String r2, @NonNull Context r3, @NonNull AttributeSet r4);

    @Nullable
    public abstract <T extends View> T findViewById(@IdRes int r1);

    @Nullable
    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    public abstract MenuInflater getMenuInflater();

    @Nullable
    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int r1);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration r1);

    public abstract void onCreate(Bundle r1);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle r1);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle r1);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int r1);

    public abstract void setContentView(@LayoutRes int r1);

    public abstract void setContentView(View r1);

    public abstract void setContentView(View r1, ViewGroup.LayoutParams r2);

    public abstract void setHandleNativeActionModesEnabled(boolean r1);

    @RequiresApi(17)
    public abstract void setLocalNightMode(int r1);

    public abstract void setSupportActionBar(@Nullable Toolbar r1);

    public void setTheme(@StyleRes int r1) {
    }

    public abstract void setTitle(@Nullable CharSequence r1);

    @Nullable
    public abstract ActionMode startSupportActionMode(@NonNull ActionMode.Callback r1);

    @NonNull
    public static AppCompatDelegate create(@NonNull Dialog r1, @Nullable AppCompatCallback r2) {
        return new AppCompatDelegateImpl(r1, r2);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Context r1, @NonNull Window r2, @Nullable AppCompatCallback r3) {
        return new AppCompatDelegateImpl(r1, r2, r3);
    }

    @NonNull
    public static AppCompatDelegate create(@NonNull Context r1, @NonNull Activity r2, @Nullable AppCompatCallback r3) {
        return new AppCompatDelegateImpl(r1, r2, r3);
    }
}
