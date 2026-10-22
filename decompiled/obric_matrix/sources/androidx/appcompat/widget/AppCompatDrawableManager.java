package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = null;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    static {
        DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public AppCompatDrawableManager() {
    }

    static /* synthetic */ PorterDuff.Mode access$000() {
        return DEFAULT_MODE;
    }

    public static synchronized AppCompatDrawableManager get() {
        monitor-enter(AppCompatDrawableManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L7;
        preload();     // Catch: Throwable -> L10
    L7:
        AppCompatDrawableManager r1 = INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(AppCompatDrawableManager.class);
        return r1;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int r1, PorterDuff.Mode r2) {
        monitor-enter(AppCompatDrawableManager.class);
        PorterDuffColorFilter r3 = ResourceManagerInternal.getPorterDuffColorFilter(r1, r2);     // Catch: Throwable -> L7
        monitor-exit(AppCompatDrawableManager.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void preload() {
        monitor-enter(AppCompatDrawableManager.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L7;
        AppCompatDrawableManager r1 = new AppCompatDrawableManager();     // Catch: Throwable -> L9
        INSTANCE = r1;     // Catch: Throwable -> L9
        r1.mResourceManager = ResourceManagerInternal.get();     // Catch: Throwable -> L9
        INSTANCE.mResourceManager.setHooks(new AnonymousClass1());     // Catch: Throwable -> L9
    L7:
        monitor-exit(AppCompatDrawableManager.class);
    }

    static void tintDrawable(Drawable r0, TintInfo r1, int[] r2) {
        ResourceManagerInternal.tintDrawable(r0, r1, r2);
    }

    public synchronized Drawable getDrawable(@NonNull Context r2, @DrawableRes int r3) {
        monitor-enter(this);
        Drawable r4 = this.mResourceManager.getDrawable(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized Drawable getDrawable(@NonNull Context r2, @DrawableRes int r3, boolean r4) {
        monitor-enter(this);
        Drawable r5 = this.mResourceManager.getDrawable(r2, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized ColorStateList getTintList(@NonNull Context r2, @DrawableRes int r3) {
        monitor-enter(this);
        ColorStateList r4 = this.mResourceManager.getTintList(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onConfigurationChanged(@NonNull Context r2) {
        monitor-enter(this);
        this.mResourceManager.onConfigurationChanged(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized Drawable onDrawableLoadedFromResources(@NonNull Context r2, @NonNull VectorEnabledTintResources r3, @DrawableRes int r4) {
        monitor-enter(this);
        Drawable r5 = this.mResourceManager.onDrawableLoadedFromResources(r2, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    boolean tintDrawableUsingColorFilter(@NonNull Context r1, @DrawableRes int r2, @NonNull Drawable r3) {
        return this.mResourceManager.tintDrawableUsingColorFilter(r1, r2, r3);
    }
}
