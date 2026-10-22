package com.android.launcher3.icons;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.LauncherActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import androidx.core.os.BuildCompat;
import com.GlobalProxyLancet;
import com.android.launcher3.util.SafeCloseable;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settingslib.R;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Calendar;
import java.util.Iterator;
import java.util.function.Supplier;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes.dex */
public class IconProvider {
    public static final boolean ATLEAST_T = false;
    static final int CONFIG_ICON_MASK_RES_ID = 0;
    private static final boolean DEBUG = false;
    private static final String ICON_METADATA_KEY_PREFIX = ".dynamic_icons";
    private static final String SYSTEM_STATE_SEPARATOR = " ";
    private static final String TAG = "IconProvider";
    private final String ACTION_OVERLAY_CHANGED;
    private final ComponentName mCalendar;
    private final ComponentName mClock;
    protected final Context mContext;

    public interface IconChangeListener {
        void onAppIconChanged(String r1, UserHandle r2);

        void onSystemIconStateChanged(String r1);
    }

    private class IconChangeReceiver extends BroadcastReceiver implements SafeCloseable {
        private final IconChangeListener mCallback;
        private String mIconState;
        final /* synthetic */ IconProvider this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_launcher3_icons_IconProvider$IconChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        IconChangeReceiver(IconProvider r3, IconChangeListener r4, Handler r5) {
            this.this$0 = r3;
            this.mCallback = r4;
            this.mIconState = r3.getSystemIconState();
            IntentFilter r6 = new IntentFilter("android.intent.action.OVERLAY_CHANGED");
            r6.addDataScheme("package");
            r6.addDataSchemeSpecificPart(RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME, 0);
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3.mContext, this, r6, null, r5);
            if (IconProvider.access$000(r3) == null) goto L5;
        L6:
            IntentFilter r7 = new IntentFilter("android.intent.action.TIMEZONE_CHANGED");
            if (IconProvider.access$000(r3) == null) goto L9;
            r7.addAction("android.intent.action.TIME_SET");
            r7.addAction("android.intent.action.DATE_CHANGED");
        L9:
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3.mContext, this, r7, null, r5);
            return;
        L5:
            if (IconProvider.access$100(r3) != null) goto L6;
        }

        public void com_android_launcher3_icons_IconProvider$IconChangeReceiver__onReceive$___twin___(Context r3, Intent r4) {
            String r5 = r4.getAction();
            r5.hashCode();
            byte r1 = -1;
            switch(r5.hashCode()) {
                case -1946981856: goto L18;
                case 502473491: goto L14;
                case 505380757: goto L10;
                case 1041332296: goto L6;
                default: goto L21;
            };
        L21:
            switch(r1) {
                case 0: goto L32;
                case 1: goto L24;
                case 2: goto L27;
                case 3: goto L27;
                default: goto L39;
            };
        L32:
            String r6 = this.this$0.getSystemIconState();
            if (this.mIconState.equals(r6) == true) goto L38;
            this.mIconState = r6;
            this.mCallback.onSystemIconStateChanged(r6);
            return;
        L38:
            return;
        L39:
            return;
        L24:
            if (IconProvider.access$100(this.this$0) == null) goto L27;
            this.mCallback.onAppIconChanged(IconProvider.access$100(this.this$0).getPackageName(), Process.myUserHandle());
        L27:
            if (IconProvider.access$000(this.this$0) == null) goto L37;
            Iterator<UserHandle> r7 = ((UserManager) r3.getSystemService(UserManager.class)).getUserProfiles().iterator();
        L30:
            if (r7.hasNext() == false) goto L40;
            UserHandle r8 = r7.next();
            this.mCallback.onAppIconChanged(IconProvider.access$000(this.this$0).getPackageName(), r8);
            goto L30
        L40:
            return;
        L37:
            return;
        L6:
            if (r5.equals("android.intent.action.DATE_CHANGED") == false) goto L21;
            r1 = 3;
            goto L21
        L10:
            if (r5.equals("android.intent.action.TIME_SET") == false) goto L21;
            r1 = 2;
            goto L21
        L14:
            if (r5.equals("android.intent.action.TIMEZONE_CHANGED") == false) goto L21;
            r1 = 1;
            goto L21
        L18:
            if (r5.equals("android.intent.action.OVERLAY_CHANGED") == false) goto L21;
            r1 = 0;
            goto L21
        }

        @Override // com.android.launcher3.util.SafeCloseable, java.lang.AutoCloseable
        public void close() {
            this.this$0.mContext.unregisterReceiver(this);
        }

        @Insert("onReceive")
        public static void com_android_launcher3_icons_IconProvider$IconChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(IconChangeReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            IconChangeReceiver r1 = r7;
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
            r7.com_android_launcher3_icons_IconProvider$IconChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_launcher3_icons_IconProvider$IconChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_launcher3_icons_IconProvider$IconChangeReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_launcher3_icons_IconProvider$IconChangeReceiver__onReceive$___twin___(r8, r9);
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

    public static class ThemeData {
        final int mResID;
        final Resources mResources;

        public ThemeData(Resources r1, int r2) {
            this.mResources = r1;
            this.mResID = r2;
        }

        Drawable loadPaddedDrawable() {
            if ("drawable".equals(this.mResources.getResourceTypeName(this.mResID)) == true) goto L7;
            return null;
        L7:
            return new InsetDrawable(new InsetDrawable(this.mResources.getDrawable(this.mResID).mutate(), 0.2f), AdaptiveIconDrawable.getExtraInsetFraction() / ((AdaptiveIconDrawable.getExtraInsetFraction() * 2.0f) + 1.0f));
        }
    }

    protected ThemeData getThemeDataForPackage(String r1) {
        return null;
    }

    static /* synthetic */ ComponentName access$000(IconProvider r0) {
        return r0.mCalendar;
    }

    static /* synthetic */ ComponentName access$100(IconProvider r0) {
        return r0.mClock;
    }

    static {
        CONFIG_ICON_MASK_RES_ID = Resources.getSystem().getIdentifier("config_icon_mask", "string", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        ATLEAST_T = BuildCompat.isAtLeastT();
    }

    public IconProvider(Context r2) {
        this.ACTION_OVERLAY_CHANGED = "android.intent.action.OVERLAY_CHANGED";
        this.mContext = r2;
        this.mCalendar = parseComponentOrNull(r2, R.string.calendar_component_name);
        this.mClock = parseComponentOrNull(r2, R.string.clock_component_name);
    }

    public String getSystemStateForPackage(String r1, String r2) {
        ComponentName r0 = this.mCalendar;
        if (r0 != null) goto L5;
    L8:
        return r1;
    L5:
        if (r0.getPackageName().equals(r2) == false) goto L8;
        return r1 + " " + getDay();
    }

    public Drawable getIcon(final LauncherActivityInfo r3, final int r4) {
        return getIconWithOverrides(r3.getApplicationInfo().packageName, r4, new IconProvider$$ExternalSyntheticLambda1(r3, r4));
    }

    static /* synthetic */ Drawable lambda$getIcon$0(LauncherActivityInfo r0, int r1) {
        return r0.getIcon(r1);
    }

    public Drawable getIcon(ActivityInfo r2) {
        return getIcon(r2, this.mContext.getResources().getConfiguration().densityDpi);
    }

    public Drawable getIcon(final ActivityInfo r3, final int r4) {
        return getIconWithOverrides(r3.applicationInfo.packageName, r4, new IconProvider$$ExternalSyntheticLambda0(this, r3, r4));
    }

    /* JADX INFO: renamed from: lambda$getIcon$1$com-android-launcher3-icons-IconProvider, reason: not valid java name */
    /* synthetic */ Drawable m70lambda$getIcon$1$comandroidlauncher3iconsIconProvider(ActivityInfo r1, int r2) {
        return loadActivityInfoIcon(r1, r2);
    }

    private Drawable getIconWithOverrides(String r3, int r4, Supplier<Drawable> r5) {
        ThemeData r0 = getThemeDataForPackage(r3);
        ComponentName r1 = this.mCalendar;
        if (r1 != null) goto L5;
    L7:
        ComponentName r2 = this.mClock;
        if (r2 != null) goto L10;
    L12:
        Drawable r6 = null;
    L13:
        if (r6 != null) goto L23;
        Drawable r7 = r5.get();
        if (ATLEAST_T == true) goto L17;
        return r7;
    L17:
        if ((r7 instanceof AdaptiveIconDrawable) == false) goto L25;
        if (r0 == null) goto L26;
        AdaptiveIconDrawable r8 = (AdaptiveIconDrawable) r7;
        if (r8.getMonochrome() == null) goto L22;
        return r7;
    L22:
        return new AdaptiveIconDrawable(r8.getBackground(), r8.getForeground(), r0.loadPaddedDrawable());
    L26:
        return r7;
    L25:
        return r7;
    L23:
        return r6;
    L10:
        if (r2.getPackageName().equals(r3) == false) goto L12;
        r6 = ClockDrawableWrapper.forPackage(this.mContext, this.mClock.getPackageName(), r4, r0);
        goto L13
    L5:
        if (r1.getPackageName().equals(r3) == false) goto L7;
        r6 = loadCalendarDrawable(r4, r0);
        goto L13
    }

    private Drawable loadActivityInfoIcon(ActivityInfo r4, int r5) {
        int r0 = r4.getIconResource();
        if (r5 == 0) goto L7;
        if (r0 == 0) goto L7;
        Drawable r6 = this.mContext.getPackageManager().getResourcesForApplication(r4.applicationInfo).getDrawableForDensity(r0, r5);     // Catch: Throwable -> L11
    L8:
        if (r6 == null) goto L10;
        return r6;
    L10:
        return r4.loadIcon(this.mContext.getPackageManager());
    L7:
        r6 = null;
        goto L8
    }

    private Drawable loadCalendarDrawable(int r5, ThemeData r6) {
        PackageManager r0 = this.mContext.getPackageManager();
        Bundle r2 = r0.getActivityInfo(this.mCalendar, 8320).metaData;     // Catch: PackageManager.NameNotFoundException -> L21
        Resources r1 = r0.getResourcesForApplication(this.mCalendar.getPackageName());     // Catch: PackageManager.NameNotFoundException -> L21
        int r4 = getDynamicIconId(r2, r1);     // Catch: PackageManager.NameNotFoundException -> L21
        if (r4 == 0) goto L20;
        Drawable r7 = r1.getDrawableForDensity(r4, r5, null);     // Catch: PackageManager.NameNotFoundException -> L21
        if (ATLEAST_T == true) goto L8;
        return r7;
    L8:
        if ((r7 instanceof AdaptiveIconDrawable) == false) goto L25;
        if (r6 == null) goto L26;
        AdaptiveIconDrawable r8 = (AdaptiveIconDrawable) r7;     // Catch: PackageManager.NameNotFoundException -> L21
        if (r8.getMonochrome() == null) goto L14;
        return r7;
    L14:
        if ("array".equals(r6.mResources.getResourceTypeName(r6.mResID)) == false) goto L27;
        TypedArray r3 = r6.mResources.obtainTypedArray(r6.mResID);     // Catch: PackageManager.NameNotFoundException -> L21
        int r9 = r3.getResourceId(getDay(), 0);     // Catch: PackageManager.NameNotFoundException -> L21
        r3.recycle();     // Catch: PackageManager.NameNotFoundException -> L21
        if (r9 == 0) goto L28;
        return new AdaptiveIconDrawable(r8.getBackground(), r8.getForeground(), new ThemeData(r6.mResources, r9).loadPaddedDrawable());
    L28:
        return r7;
    L27:
        return r7;
    L26:
        return r7;
    L25:
        return r7;
    L20:
        return null;
    }

    private int getDynamicIconId(Bundle r3, Resources r4) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        int r2 = r3.getInt(this.mCalendar.getPackageName() + ICON_METADATA_KEY_PREFIX, 0);
        if (r2 != 0) goto L11;
        return 0;
    L11:
        return r4.obtainTypedArray(r2).getResourceId(getDay(), 0);
    L10:
        return 0;
    }

    private static int getDay() {
        return Calendar.getInstance().get(5) - 1;
    }

    private static ComponentName parseComponentOrNull(Context r0, int r1) {
        String r2 = r0.getString(r1);
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return null;
    L6:
        return ComponentName.unflattenFromString(r2);
    }

    public String getSystemIconState() {
        int r0 = CONFIG_ICON_MASK_RES_ID;
        if (r0 != 0) goto L6;
        return "";
    L6:
        return this.mContext.getResources().getString(r0);
    }

    public SafeCloseable registerIconChangeListener(IconChangeListener r2, Handler r3) {
        return new IconChangeReceiver(this, r2, r3);
    }
}
