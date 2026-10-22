package com.android.settingslib.dream;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.icu.text.PluralRules;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.dreams.DreamService;
import android.service.dreams.IDreamManager;
import android.util.ArraySet;
import com.GlobalProxyLancet;
import com.android.internal.util.FrameworkStatsLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class DreamBackend {
    public static final int COMPLICATION_TYPE_AIR_QUALITY = 4;
    public static final int COMPLICATION_TYPE_CAST_INFO = 5;
    public static final int COMPLICATION_TYPE_DATE = 2;
    public static final int COMPLICATION_TYPE_HOME_CONTROLS = 6;
    public static final int COMPLICATION_TYPE_MEDIA_ENTRY = 8;
    public static final int COMPLICATION_TYPE_SMARTSPACE = 7;
    public static final int COMPLICATION_TYPE_TIME = 1;
    public static final int COMPLICATION_TYPE_WEATHER = 3;
    private static final boolean DEBUG = false;
    private static final int DS_TYPE_DREAM_COMPONENT = 2;
    private static final int DS_TYPE_ENABLED = 1;
    private static final int DS_TYPE_SHOW_ADDITIONAL_INFO = 4;
    private static final int DS_TYPE_SHOW_HOME_CONTROLS = 5;
    private static final int DS_TYPE_WHEN_TO_DREAM = 3;
    public static final int EITHER = 2;
    private static final int LOCKSCREEN_SHOW_CONTROLS_DEFAULT = 0;
    public static final int NEVER = 3;
    private static final int SCREENSAVER_HOME_CONTROLS_ENABLED_DEFAULT = 1;
    private static final String TAG = "DreamBackend";
    private static final int WHEN_TO_DREAM_CHARGING = 1;
    private static final int WHEN_TO_DREAM_CHARGING_OR_DOCKED = 3;
    private static final int WHEN_TO_DREAM_DOCKED = 2;
    private static final int WHEN_TO_DREAM_UNSPECIFIED = 0;
    public static final int WHILE_CHARGING = 0;
    public static final int WHILE_DOCKED = 1;
    private static DreamBackend sInstance;
    private final DreamInfoComparator mComparator;
    private final Context mContext;
    private final Set<ComponentName> mDisabledDreams;
    private final IDreamManager mDreamManager;
    private final boolean mDreamsActivatedOnDockByDefault;
    private final boolean mDreamsActivatedOnSleepByDefault;
    private final boolean mDreamsEnabledByDefault;
    private final List<String> mLoggableDreamPrefixes;
    private Set<Integer> mSupportedComplications;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ComplicationType {
    }

    public static class DreamInfo {
        public CharSequence caption;
        public ComponentName componentName;
        public CharSequence description;
        public int dreamCategory;
        public Drawable icon;
        public boolean isActive;
        public Drawable previewImage;
        public ComponentName settingsComponentName;
        public boolean supportsComplications;

        public DreamInfo() {
            this.supportsComplications = false;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder(DreamInfo.class.getSimpleName());
            r0.append('[').append(this.caption);
            if (this.isActive == false) goto L5;
            r0.append(",active");
        L5:
            r0.append(',').append(this.componentName);
            if (this.settingsComponentName == null) goto L9;
            r0.append("settings=").append(this.settingsComponentName);
        L9:
            return r0.append(']').toString();
        }
    }

    private static class DreamInfoComparator implements Comparator<DreamInfo> {
        private final ComponentName mDefaultDream;

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(DreamInfo r1, DreamInfo r2) {
            return compare2(r1, r2);
        }

        public DreamInfoComparator(ComponentName r1) {
            this.mDefaultDream = r1;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(DreamInfo r1, DreamInfo r2) {
            return sortKey(r1).compareTo(sortKey(r2));
        }

        private String sortKey(DreamInfo r3) {
            StringBuilder r0 = new StringBuilder();
            if (r3.componentName.equals(this.mDefaultDream) == false) goto L5;
            char r2 = '0';
        L6:
            r0.append(r2);
            r0.append(r3.caption);
            return r0.toString();
        L5:
            r2 = '1';
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface WhenToDream {
    }

    public static /* synthetic */ ComponentName $r8$lambda$mVB2YB61TxO4cQ_5vWZ3Rq7CXhk(String r0) {
        return ComponentName.unflattenFromString(r0);
    }

    private static void logd(String r0, Object... r1) {
    }

    public static DreamBackend getInstance(Context r1) {
        if (sInstance != null) goto L6;
        sInstance = new DreamBackend(r1);
    L6:
        return sInstance;
    }

    public DreamBackend(Context r3) {
        Context r4 = r3.getApplicationContext();
        this.mContext = r4;
        Resources r5 = r4.getResources();
        this.mDreamManager = IDreamManager.Stub.asInterface(ServiceManager.getService("dreams"));
        this.mComparator = new DreamInfoComparator(getDefaultDream());
        this.mDreamsEnabledByDefault = r5.getBoolean(R.bool.config_dozeWakeLockScreenSensorAvailable);
        this.mDreamsActivatedOnSleepByDefault = r5.getBoolean(R.bool.config_dozePulsePickup);
        this.mDreamsActivatedOnDockByDefault = r5.getBoolean(R.bool.config_dozePickupGestureEnabled);
        this.mDisabledDreams = (Set) Arrays.stream(r5.getStringArray(R.array.config_displayWhiteBalanceDisplayNominalWhite)).map(new DreamBackend$$ExternalSyntheticLambda0()).collect(Collectors.toSet());
        this.mLoggableDreamPrefixes = Arrays.stream(r5.getStringArray(R.array.config_nightDisplayColorTemperatureCoefficients)).toList();
        this.mSupportedComplications = (Set) Arrays.stream(r5.getIntArray(R.array.config_toastCrossUserPackages)).boxed().collect(Collectors.toSet());
    }

    public List<DreamInfo> getDreamInfos() {
        logd("getDreamInfos()", new Object[0]);
        ComponentName r0 = getActiveDream();
        PackageManager r1 = this.mContext.getPackageManager();
        List<ResolveInfo> r2 = r1.queryIntentServices(new Intent("android.service.dreams.DreamService"), 128);
        ArrayList r3 = new ArrayList(r2.size());
        Iterator<ResolveInfo> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L14;
        ResolveInfo r5 = r4.next();
        ComponentName r6 = getDreamComponentName(r5);
        if (r6 == null) goto L4;
        if (this.mDisabledDreams.contains(r6) == true) goto L4;
        DreamInfo r7 = new DreamInfo();
        r7.caption = r5.loadLabel(r1);
        r7.icon = r5.loadIcon(r1);
        r7.description = getDescription(r5, r1);
        r7.componentName = r6;
        r7.isActive = r7.componentName.equals(r0);
        DreamService.DreamMetadata r8 = DreamService.getDreamMetadata(this.mContext.getPackageManager(), r5.serviceInfo);
        if (r8 == null) goto L13;
        r7.settingsComponentName = r8.settingsActivity;
        r7.previewImage = r8.previewImage;
        r7.supportsComplications = r8.showComplications;
        r7.dreamCategory = r8.dreamCategory;
    L13:
        r3.add(r7);
        goto L4
    L14:
        r3.sort(this.mComparator);
        return r3;
    }

    private static CharSequence getDescription(ResolveInfo r4, PackageManager r5) {
        String r0 = r4.resolvePackageName;
        if (r0 != null) goto L5;
        r0 = r4.serviceInfo.packageName;
        ApplicationInfo r2 = r4.serviceInfo.applicationInfo;
    L7:
        if (r4.serviceInfo.descriptionRes != 0) goto L9;
        return null;
    L9:
        return r5.getText(r0, r4.serviceInfo.descriptionRes, r2);
    L5:
        r2 = null;
        goto L7
    }

    public ComponentName getDefaultDream() {
        IDreamManager r0 = this.mDreamManager;
        if (r0 != null) goto L10;
        return null;
    L10:
        return r0.getDefaultDreamComponentForUser(this.mContext.getUserId());
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Failed to get default dream", e);
        return null;
    }

    public CharSequence getActiveDreamName() {
        ComponentName r0 = getActiveDream();
        if (r0 == null) goto L9;
        PackageManager r3 = this.mContext.getPackageManager();
        ServiceInfo r1 = r3.getServiceInfo(r0, 0);     // Catch: PackageManager.NameNotFoundException -> L10
        if (r1 == null) goto L9;
        return r1.loadLabel(r3);
    L9:
        return null;
    }

    public Drawable getActiveIcon() {
        ComponentName r0 = getActiveDream();
        if (r0 == null) goto L9;
        PackageManager r3 = this.mContext.getPackageManager();
        ServiceInfo r1 = r3.getServiceInfo(r0, 0);     // Catch: PackageManager.NameNotFoundException -> L10
        if (r1 == null) goto L9;
        return r1.loadIcon(r3);
    L9:
        return null;
    }

    public int getWhenToDreamSetting() {
        if (isActivatedOnDock() == false) goto L8;
        if (isActivatedOnSleep() == false) goto L8;
        return 2;
    L8:
        if (isActivatedOnDock() == false) goto L11;
        return 1;
    L11:
        if (isActivatedOnSleep() == false) goto L13;
        return 0;
    L13:
        return 3;
    }

    public void setWhenToDream(int r5) {
        if (r5 == 3) goto L5;
        boolean r3 = true;
    L6:
        setEnabled(r3);
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L10;
        setActivatedOnDock(true);
        setActivatedOnSleep(false);
    L15:
        logDreamSettingChangeToStatsd(3);
        return;
    L10:
        if (r5 != 2) goto L15;
        setActivatedOnDock(true);
        setActivatedOnSleep(true);
        goto L15
    L14:
        setActivatedOnDock(false);
        setActivatedOnSleep(true);
        goto L15
    L5:
        r3 = false;
        goto L6
    }

    public Set<Integer> getEnabledComplications() {
        if (getComplicationsEnabled() == false) goto L5;
        ArraySet r0 = new ArraySet(this.mSupportedComplications);
    L7:
        if (getHomeControlsEnabled() == true) goto L10;
        r0.remove(6);
    L12:
        return r0;
    L10:
        if (this.mSupportedComplications.contains(6) == false) goto L12;
        r0.add(6);
        goto L12
    L5:
        r0 = new ArraySet();
        goto L7
    }

    public void setComplicationsEnabled(boolean r3) {
        Settings.Secure.putInt(this.mContext.getContentResolver(), "screensaver_complications_enabled", r3 ? 1 : 0);
        logDreamSettingChangeToStatsd(4);
    }

    public void setHomeControlsEnabled(boolean r3) {
        Settings.Secure.putInt(this.mContext.getContentResolver(), "screensaver_home_controls_enabled", r3 ? 1 : 0);
        logDreamSettingChangeToStatsd(5);
    }

    private boolean getHomeControlsEnabled() {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "lockscreen_show_controls", 0) == 1) goto L5;
        return false;
    L5:
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "screensaver_home_controls_enabled", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean getComplicationsEnabled() {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "screensaver_complications_enabled", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public Set<Integer> getSupportedComplications() {
        return this.mSupportedComplications;
    }

    public void setSupportedComplications(Set<Integer> r1) {
        this.mSupportedComplications = r1;
    }

    public boolean isEnabled() {
        return getBoolean("screensaver_enabled", this.mDreamsEnabledByDefault);
    }

    public void setEnabled(boolean r5) {
        logd("setEnabled(%s)", new Object[]{Boolean.valueOf(r5)});
        setBoolean("screensaver_enabled", r5);
        logDreamSettingChangeToStatsd(1);
    }

    public boolean isActivatedOnDock() {
        return getBoolean("screensaver_activate_on_dock", this.mDreamsActivatedOnDockByDefault);
    }

    public void setActivatedOnDock(boolean r4) {
        logd("setActivatedOnDock(%s)", new Object[]{Boolean.valueOf(r4)});
        setBoolean("screensaver_activate_on_dock", r4);
    }

    public boolean isActivatedOnSleep() {
        return getBoolean("screensaver_activate_on_sleep", this.mDreamsActivatedOnSleepByDefault);
    }

    public void setActivatedOnSleep(boolean r4) {
        logd("setActivatedOnSleep(%s)", new Object[]{Boolean.valueOf(r4)});
        setBoolean("screensaver_activate_on_sleep", r4);
    }

    private boolean getBoolean(String r1, boolean r2) {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), r1, r2 ? 1 : 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setBoolean(String r1, boolean r2) {
        Settings.Secure.putInt(this.mContext.getContentResolver(), r1, r2 ? 1 : 0);
    }

    public void setActiveDream(ComponentName r5) {
        logd("setActiveDream(%s)", new Object[]{r5});
        IDreamManager r1 = this.mDreamManager;
        if (r1 != null) goto L13;
        return;
    L13:
        ComponentName[] r0 = {r5};     // Catch: RemoteException -> L10
        if (r5 != null) goto L8;
        r0 = null;
    L8:
        r1.setDreamComponents(r0);     // Catch: RemoteException -> L10
        logDreamSettingChangeToStatsd(2);     // Catch: RemoteException -> L10
        return;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Failed to set active dream to " + r5, e);
    }

    public ComponentName getActiveDream() {
        IDreamManager r3 = this.mDreamManager;
        if (r3 != null) goto L14;
        return null;
    L14:
        ComponentName[] r4 = r3.getDreamComponents();     // Catch: RemoteException -> L11
        if (r4 != null) goto L8;
        return null;
    L8:
        if (r4.length <= 0) goto L17;
        return r4[0];
    L17:
        return null;
    L11:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Failed to get active dream", e);
        return null;
    }

    public void launchSettings(Context r2, DreamInfo r3) {
        logd("launchSettings(%s)", new Object[]{r3});
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.settingsComponentName == null) goto L10;
        r2.startActivity(new Intent().setComponent(r3.settingsComponentName).addFlags(276824064));
        return;
    }

    public void preview(ComponentName r3) {
        logd("preview(%s)", new Object[]{r3});
        IDreamManager r0 = this.mDreamManager;
        if (r0 == null) goto L13;
        if (r3 == null) goto L14;
        r0.testDream(this.mContext.getUserId(), r3);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Failed to preview " + r3, e);
        return;
    L14:
        return;
    }

    public void startDreaming() {
        logd("startDreaming()", new Object[0]);
        IDreamManager r2 = this.mDreamManager;
        if (r2 != null) goto L10;
        return;
    L10:
        r2.dream();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Failed to dream", e);
    }

    private static ComponentName getDreamComponentName(ResolveInfo r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.serviceInfo != null) goto L7;
        return null;
    L7:
        return new ComponentName(r2.serviceInfo.packageName, r2.serviceInfo.name);
    }

    private void logDreamSettingChangeToStatsd(int r9) {
        FrameworkStatsLog.write(705, UserHandle.myUserId(), isEnabled(), getActiveDreamComponentForStatsd(), getWhenToDreamForStatsd(), getComplicationsEnabled(), getHomeControlsEnabled(), r9);
    }

    private String getActiveDreamComponentForStatsd() {
        ComponentName r0 = getActiveDream();
        if (r0 != null) goto L6;
        return "";
    L6:
        String r1 = r0.flattenToShortString();
        if (isLoggableDreamComponentForStatsd(r1) == false) goto L9;
        return r1;
    L9:
        return PluralRules.KEYWORD_OTHER;
    }

    private boolean isLoggableDreamComponentForStatsd(String r4) {
        int r1 = 0;
    L4:
        if (r1 >= this.mLoggableDreamPrefixes.size()) goto L10;
        if (r4.startsWith(this.mLoggableDreamPrefixes.get(r1)) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private int getWhenToDreamForStatsd() {
        int r2 = getWhenToDreamSetting();
        if (r2 != 0) goto L5;
        return 1;
    L5:
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L9;
        return 0;
    L9:
        return 3;
    L11:
        return 2;
    }
}
