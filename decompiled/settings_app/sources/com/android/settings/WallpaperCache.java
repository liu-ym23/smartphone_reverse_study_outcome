package com.android.settings;

import android.app.Application;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.core.app.ActivityCompat;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class WallpaperCache {
    private static final Object FETCH_LOCK = null;
    private static volatile WallpaperCache sInstance;
    private final Runnable mFetchWallpaperTask;
    private volatile Drawable mLauncherWallpaper;
    private boolean mPrefetched;
    private final WallpaperManager.OnColorsChangedListener mWallpaperColorsChangedListener;

    public static class LauncherWallpaperChangedReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_WallpaperCache$LauncherWallpaperChangedReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        public LauncherWallpaperChangedReceiver() {
        }

        public void com_android_settings_WallpaperCache$LauncherWallpaperChangedReceiver__onReceive$___twin___(Context r1, Intent r2) {
            if ("android.intent.action.WALLPAPER_CHANGED".equals(r2.getAction()) == false) goto L6;
            OLog.d("WallpaperCache", "received wallpaper changed broadcast, fetch it.");
            WallpaperCache.access$000(WallpaperCache.getInstance());
            return;
        }

        @Insert("onReceive")
        public static void com_android_settings_WallpaperCache$LauncherWallpaperChangedReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(LauncherWallpaperChangedReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            LauncherWallpaperChangedReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settings_WallpaperCache$LauncherWallpaperChangedReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_WallpaperCache$LauncherWallpaperChangedReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_WallpaperCache$LauncherWallpaperChangedReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_WallpaperCache$LauncherWallpaperChangedReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    static /* synthetic */ void access$000(WallpaperCache r0) {
        r0.fetchWallpaperAsync();
    }

    static /* synthetic */ Object access$100() {
        return FETCH_LOCK;
    }

    static /* synthetic */ void access$200(WallpaperCache r0) {
        r0.fetch();
    }

    static {
        FETCH_LOCK = new Object();
    }

    public Drawable getLauncherWallpaper() {
        if (this.mLauncherWallpaper != null) goto L15;
        Object r0 = FETCH_LOCK;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mLauncherWallpaper != null) goto L9;
        fetch();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.mLauncherWallpaper.mutate().getConstantState().newDrawable();
    }

    public void prefetchWallpaperIfNeed() {
        if (this.mPrefetched == false) goto L5;
        return;
    L5:
        this.mPrefetched = true;
        fetchWallpaperAsync();
    }

    private void fetchWallpaperAsync() {
        OLog.d("WallpaperCache", "fetching launcher wallpaper ...");
        ExecutorManager.execute(this.mFetchWallpaperTask);
    }

    private void fetch() {
        this.mLauncherWallpaper = null;
        WallpaperManager r0 = WallpaperManager.getInstance(SettingsApplication.getContext());
        if (ActivityCompat.checkSelfPermission(SettingsApplication.getContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0) goto L6;
        OLog.e("WallpaperCache", "fetching launcher wallpaper failed, don't have permission...");
        return;
    L6:
        this.mLauncherWallpaper = r0.getDrawable();
    }

    public static WallpaperCache getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(WallpaperCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new WallpaperCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(WallpaperCache.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private WallpaperCache() {
        this.mFetchWallpaperTask = new AnonymousClass1(this);
        this.mWallpaperColorsChangedListener = new AnonymousClass2(this);
        listenWallpaperChanged();
    }

    private void listenWallpaperChanged() {
        WallpaperManager.getInstance(SettingsApplication.getContext()).addOnColorsChangedListener(this.mWallpaperColorsChangedListener, null);
    }
}
