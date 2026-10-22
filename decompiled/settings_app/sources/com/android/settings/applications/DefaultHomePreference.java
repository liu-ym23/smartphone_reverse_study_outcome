package com.android.settings.applications;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.os.UserManager;
import android.util.AttributeSet;
import com.android.settings.AppListPreference;
import com.android.settings.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultHomePreference extends AppListPreference {
    private final ArrayList<ComponentName> mAllHomeComponents;
    private final IntentFilter mHomeFilter;

    private boolean versionNumberAtLeastL(int r1) {
        if (r1 < 21) goto L5;
        return true;
    L5:
        return false;
    }

    public DefaultHomePreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mAllHomeComponents = new ArrayList();
        IntentFilter r3 = new IntentFilter("android.intent.action.MAIN");
        this.mHomeFilter = r3;
        r3.addCategory("android.intent.category.HOME");
        r3.addCategory("android.intent.category.DEFAULT");
        refreshHomeOptions();
    }

    @Override // androidx.preference.Preference
    public void performClick() {
        refreshHomeOptions();
        super.performClick();
    }

    @Override // androidx.preference.Preference
    protected boolean persistString(String r6) {
        if (r6 == null) goto L5;
        ComponentName r0 = ComponentName.unflattenFromString(r6);
        getContext().getPackageManager().replacePreferredActivity(this.mHomeFilter, 1048576, (ComponentName[]) this.mAllHomeComponents.toArray(new ComponentName[0]), r0);
        setSummary(getEntry());
    L5:
        return super.persistString(r6);
    }

    public void refreshHomeOptions() {
        String r0 = getContext().getPackageName();
        ArrayList r1 = new ArrayList();
        PackageManager r2 = getContext().getPackageManager();
        if (r2 == null) goto L5;
        ComponentName r4 = r2.getHomeActivities(r1);
    L6:
        ArrayList r5 = new ArrayList();
        this.mAllHomeComponents.clear();
        ArrayList r6 = new ArrayList();
        boolean r7 = hasManagedProfile();
        int r9 = 0;
    L8:
        if (r9 >= r1.size()) goto L19;
        ResolveInfo r10 = (ResolveInfo) r1.get(r9);
        ActivityInfo r11 = r10.activityInfo;
        ComponentName r12 = new ComponentName(r11.packageName, r11.name);
        this.mAllHomeComponents.add(r12);
        if (r11.packageName.equals(r0) == true) goto L18;
        r5.add(r12);
        if (r7 == true) goto L15;
    L17:
        r6.add(null);
        goto L18
    L15:
        if (launcherHasManagedProfilesFeature(r10, r2) == true) goto L17;
        r6.add(getContext().getString(R.string.home_work_profile_not_supported));
    L18:
        r9 = r9 + 1;
        goto L8
    L19:
        setComponentNames((ComponentName[]) r5.toArray(new ComponentName[0]), r4, (CharSequence[]) r6.toArray(new CharSequence[0]));
        return;
    L5:
        r4 = null;
        goto L6
    }

    private boolean launcherHasManagedProfilesFeature(ResolveInfo r2, PackageManager r3) {
        return versionNumberAtLeastL(r3.getApplicationInfo(r2.activityInfo.packageName, 0).targetSdkVersion);
    L5:
        return false;
    }

    private boolean hasManagedProfile() {
        Iterator r2 = ((UserManager) getContext().getSystemService(UserManager.class)).getProfiles(getContext().getUserId()).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (((UserInfo) r2.next()).isManagedProfile() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static boolean hasHomePreference(String r3, Context r4) {
        ArrayList r0 = new ArrayList();
        r4.getPackageManager().getHomeActivities(r0);
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L10;
        if (((ResolveInfo) r0.get(r1)).activityInfo.packageName.equals(r3) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static boolean isHomeDefault(String r1, Context r2) {
        ArrayList r0 = new ArrayList();
        ComponentName r3 = r2.getPackageManager().getHomeActivities(r0);
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.getPackageName().equals(r1) == false) goto L7;
        return true;
    }
}
