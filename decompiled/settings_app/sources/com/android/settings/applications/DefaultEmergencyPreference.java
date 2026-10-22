package com.android.settings.applications;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.AttributeSet;
import com.android.settings.AppListPreference;
import com.android.settings.SelfAvailablePreference;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultEmergencyPreference extends AppListPreference implements SelfAvailablePreference {
    private static final boolean DEFAULT_EMERGENCY_APP_IS_CONFIGURABLE = false;
    public static final Intent QUERY_INTENT = null;
    private final ContentResolver mContentResolver;

    @Override // com.android.settings.SelfAvailablePreference
    public boolean isAvailable(Context r1) {
        return false;
    }

    static /* synthetic */ Set access$000(DefaultEmergencyPreference r0) {
        return r0.resolveAssistPackageAndQueryApps();
    }

    static /* synthetic */ ContentResolver access$100(DefaultEmergencyPreference r0) {
        return r0.mContentResolver;
    }

    static {
        QUERY_INTENT = new Intent("android.telephony.action.EMERGENCY_ASSISTANCE");
    }

    public DefaultEmergencyPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mContentResolver = r1.getContentResolver();
        load();
    }

    @Override // androidx.preference.Preference
    protected boolean persistString(String r4) {
        String r0 = Settings.Secure.getString(this.mContentResolver, "emergency_assistance_application");
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L7:
        setSummary(getEntry());
        return true;
    L5:
        if (Objects.equals(r4, r0) == true) goto L7;
        Settings.Secure.putString(this.mContentResolver, "emergency_assistance_application", r4);
        goto L7
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.applications.DefaultEmergencyPreference$1] */
    private void load() {
        new AnonymousClass1(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private Set<String> resolveAssistPackageAndQueryApps() {
        ArraySet r0 = new ArraySet();
        PackageManager r1 = getContext().getPackageManager();
        boolean r3 = false;
        List<ResolveInfo> r2 = r1.queryIntentActivities(QUERY_INTENT, 0);
        int r4 = r2.size();
        PackageInfo r5 = null;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L20;
        ResolveInfo r7 = r2.get(r6);
        if (r7 == null) goto L19;
        if (r7.activityInfo == null) goto L19;
        if (r0.contains(r7.activityInfo.packageName) == true) goto L19;
        String r8 = r7.activityInfo.packageName;
        r0.add(r8);
        PackageInfo r9 = r1.getPackageInfo(r8, 0);     // Catch: PackageManager.NameNotFoundException -> L29
        if (isSystemApp(r9) == false) goto L19;
        if (r5 != null) goto L17;
    L18:
        r5 = r9;
        goto L19
    L17:
        if (r5.firstInstallTime > r9.firstInstallTime) goto L18;
    L19:
        r6 = r6 + 1;
        goto L3
    L20:
        String r10 = Settings.Secure.getString(this.mContentResolver, "emergency_assistance_application");
        if (TextUtils.isEmpty(r10) == false) goto L23;
    L24:
        r3 = true;
    L25:
        if (r5 == null) goto L28;
        if (r3 == false) goto L28;
        Settings.Secure.putString(this.mContentResolver, "emergency_assistance_application", r5.packageName);
    L28:
        return r0;
    L23:
        if (r0.contains(r10) == true) goto L25;
        goto L24
    }

    public static boolean isCapable(Context r1) {
        return r1.getResources().getBoolean(R.bool.config_watchlistUseFileHashesCache);
    }

    private static boolean isSystemApp(PackageInfo r1) {
        if (r1.applicationInfo != null) goto L5;
    L7:
        return false;
    L5:
        if ((r1.applicationInfo.flags & 1) == 0) goto L7;
        return true;
    }

    public static boolean hasEmergencyPreference(String r2, Context r3) {
        Intent r0 = new Intent(QUERY_INTENT);
        r0.setPackage(r2);
        List<ResolveInfo> r4 = r3.getPackageManager().queryIntentActivities(r0, 0);
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.size() == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isEmergencyDefault(String r1, Context r2) {
        String r3 = Settings.Secure.getString(r2.getContentResolver(), "emergency_assistance_application");
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.equals(r1) == false) goto L7;
        return true;
    }
}
