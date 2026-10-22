package com.android.settingslib.users;

import android.app.AppGlobals;
import android.bluetooth.client.pbap.BluetoothPbapClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.IntentCompat;
import com.GlobalProxyLancet;
import com.android.settings.CustomKeyUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AppRestrictionsHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "AppRestrictionsHelper";
    private final Context mContext;
    private final IPackageManager mIPm;
    private final Injector mInjector;
    private boolean mLeanback;
    private final PackageManager mPackageManager;
    private final boolean mRestrictedProfile;
    HashMap<String, Boolean> mSelectedPackages;
    private final UserHandle mUser;
    private final UserManager mUserManager;
    private List<SelectableAppInfo> mVisibleApps;

    /* JADX INFO: renamed from: com.android.settingslib.users.AppRestrictionsHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AppLabelComparator implements Comparator<SelectableAppInfo> {
        private AppLabelComparator() {
        }

        /* synthetic */ AppLabelComparator(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(SelectableAppInfo r1, SelectableAppInfo r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(SelectableAppInfo r1, SelectableAppInfo r2) {
            String r0 = r1.activityName.toString();
            String r3 = r2.activityName.toString();
            return r0.toLowerCase().compareTo(r3.toLowerCase());
        }
    }

    static class Injector {
        private Context mContext;
        private UserHandle mUser;

        Injector(Context r1, UserHandle r2) {
            this.mContext = r1;
            this.mUser = r2;
        }

        Context getContext() {
            return this.mContext;
        }

        UserHandle getUser() {
            return this.mUser;
        }

        PackageManager getPackageManager() {
            return this.mContext.getPackageManager();
        }

        IPackageManager getIPackageManager() {
            return AppGlobals.getPackageManager();
        }

        UserManager getUserManager() {
            return (UserManager) this.mContext.getSystemService(UserManager.class);
        }

        List<InputMethodInfo> getInputMethodList() {
            return ((InputMethodManager) getContext().getSystemService("input_method")).getInputMethodListAsUser(this.mUser.getIdentifier());
        }
    }

    public interface OnDisableUiForPackageListener {
        void onDisableUiForPackage(String r1);
    }

    public static class SelectableAppInfo {
        public CharSequence activityName;
        public CharSequence appName;
        public Drawable icon;
        public String packageName;
        public SelectableAppInfo primaryEntry;

        public SelectableAppInfo() {
        }

        public String toString() {
            return this.packageName + ": appName=" + this.appName + "; activityName=" + this.activityName + "; icon=" + this.icon + "; primaryEntry=" + this.primaryEntry;
        }
    }

    public AppRestrictionsHelper(Context r2, UserHandle r3) {
        this(new Injector(r2, r3));
    }

    AppRestrictionsHelper(Injector r2) {
        this.mSelectedPackages = new HashMap();
        this.mInjector = r2;
        this.mContext = r2.getContext();
        this.mPackageManager = r2.getPackageManager();
        this.mIPm = r2.getIPackageManager();
        UserHandle r0 = r2.getUser();
        this.mUser = r0;
        UserManager r3 = r2.getUserManager();
        this.mUserManager = r3;
        this.mRestrictedProfile = r3.getUserInfo(r0.getIdentifier()).isRestricted();
    }

    public void setPackageSelected(String r1, boolean r2) {
        this.mSelectedPackages.put(r1, Boolean.valueOf(r2));
    }

    public boolean isPackageSelected(String r1) {
        return this.mSelectedPackages.get(r1).booleanValue();
    }

    public void setLeanback(boolean r1) {
        this.mLeanback = r1;
    }

    public List<SelectableAppInfo> getVisibleApps() {
        return this.mVisibleApps;
    }

    public void applyUserAppsStates(OnDisableUiForPackageListener r4) {
        if (this.mRestrictedProfile == false) goto L5;
    L8:
        Iterator<Map.Entry<String, Boolean>> r0 = this.mSelectedPackages.entrySet().iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        Map.Entry<String, Boolean> r1 = r0.next();
        applyUserAppState(r1.getKey(), r1.getValue().booleanValue(), r4);
        goto L10
    L12:
        return;
    L5:
        if (this.mUser.getIdentifier() == UserHandle.myUserId()) goto L8;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Cannot apply application restrictions on another user!");
    }

    public void applyUserAppState(String r11, boolean r12, OnDisableUiForPackageListener r13) {
        int r0 = this.mUser.getIdentifier();
        if (r12 == false) goto L18;
        ApplicationInfo r14 = this.mIPm.getApplicationInfo(r11, BluetoothPbapClient.VCARD_ATTR_KEY, r0);     // Catch: RemoteException -> L24
        if (r14 != null) goto L7;
    L10:
        this.mIPm.installExistingPackageAsUser(r11, this.mUser.getIdentifier(), 4194304, 0, null);     // Catch: RemoteException -> L24
    L11:
        if (r14 != null) goto L13;
        return;
    L13:
        if ((1 & r14.privateFlags) != 0) goto L15;
        return;
    L15:
        if ((r14.flags & 8388608) == 0) goto L28;
        r13.onDisableUiForPackage(r11);     // Catch: RemoteException -> L24
        this.mIPm.setApplicationHiddenSettingAsUser(r11, false, r0);     // Catch: RemoteException -> L24
        return;
    L28:
        return;
    L7:
        if (r14.enabled == false) goto L10;
        if ((r14.flags & 8388608) != 0) goto L11;
    L18:
        if (this.mIPm.getApplicationInfo(r11, 0, r0) != null) goto L20;
        return;
    L20:
        if (this.mRestrictedProfile == false) goto L22;
        this.mPackageManager.deletePackageAsUser(r11, null, 4, this.mUser.getIdentifier());     // Catch: RemoteException -> L24
        return;
    L22:
        r13.onDisableUiForPackage(r11);     // Catch: RemoteException -> L24
        this.mIPm.setApplicationHiddenSettingAsUser(r11, true, r0);     // Catch: RemoteException -> L24
        return;
    }

    public void fetchAndMergeApps() {
        this.mVisibleApps = new ArrayList();
        PackageManager r0 = this.mPackageManager;
        IPackageManager r1 = this.mIPm;
        HashSet r2 = new HashSet();
        addSystemImes(r2);
        Intent r3 = new Intent("android.intent.action.MAIN");
        if (this.mLeanback == false) goto L5;
        r3.addCategory(IntentCompat.CATEGORY_LEANBACK_LAUNCHER);
    L6:
        addSystemApps(this.mVisibleApps, r3, r2);
        addSystemApps(this.mVisibleApps, new Intent("android.appwidget.action.APPWIDGET_UPDATE"), r2);
        Iterator<ApplicationInfo> r4 = r0.getInstalledApplications(4194304).iterator();
    L8:
        if (r4.hasNext() == false) goto L25;
        ApplicationInfo r5 = r4.next();
        if ((8388608 & r5.flags) == 0) goto L8;
        if ((r5.flags & 1) == 0) goto L15;
    L64:
        PackageInfo r6 = r0.getPackageInfo(r5.packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L62
        if (this.mRestrictedProfile == false) goto L8;
        if (r6.requiredAccountType == null) goto L8;
        if (r6.restrictedAccountType != null) goto L8;
        this.mSelectedPackages.put(r5.packageName, false);     // Catch: PackageManager.NameNotFoundException -> L62
        goto L8
    L15:
        if ((r5.flags & 128) != 0) goto L64;
        SelectableAppInfo r7 = new SelectableAppInfo();
        r7.packageName = r5.packageName;
        r7.appName = r5.loadLabel(r0);
        r7.activityName = r7.appName;
        r7.icon = r5.loadIcon(r0);
        this.mVisibleApps.add(r7);
        goto L8
    L25:
        AnonymousClass1 r8 = null;
        ParceledListSlice r9 = r1.getInstalledApplications(8192, this.mUser.getIdentifier());     // Catch: RemoteException -> L63
        if (r9 == null) goto L30;
        List r10 = r9.getList();     // Catch: RemoteException -> L63
    L31:
        if (r10 == null) goto L43;
        Iterator r11 = r10.iterator();
    L34:
        if (r11.hasNext() == false) goto L43;
        ApplicationInfo r12 = (ApplicationInfo) r11.next();
        if ((r12.flags & 8388608) == 0) goto L34;
        if ((r12.flags & 1) != 0) goto L34;
        if ((r12.flags & 128) != 0) goto L34;
        SelectableAppInfo r13 = new SelectableAppInfo();
        r13.packageName = r12.packageName;
        r13.appName = r12.loadLabel(r0);
        r13.activityName = r13.appName;
        r13.icon = r12.loadIcon(r0);
        this.mVisibleApps.add(r13);
    L43:
        Collections.sort(this.mVisibleApps, new AppLabelComparator(r8));
        HashSet r14 = new HashSet();
        int r15 = this.mVisibleApps.size() - 1;
    L44:
        if (r15 < 0) goto L54;
        SelectableAppInfo r16 = this.mVisibleApps.get(r15);
        String r17 = r16.packageName + CustomKeyUtils.KEY_SEPARATE_FOR_SHOW + r16.activityName;
        if (TextUtils.isEmpty(r16.packageName) == false) goto L48;
    L52:
        r14.add(r17);
    L53:
        r15 = r15 - 1;
        goto L44
    L48:
        if (TextUtils.isEmpty(r16.activityName) == true) goto L52;
        if (r14.contains(r17) == false) goto L52;
        this.mVisibleApps.remove(r15);
        goto L53
    L54:
        HashMap r18 = new HashMap();
        Iterator<SelectableAppInfo> r19 = this.mVisibleApps.iterator();
    L56:
        if (r19.hasNext() == false) goto L61;
        SelectableAppInfo r20 = r19.next();
        if (r18.containsKey(r20.packageName) == true) goto L59;
        r18.put(r20.packageName, r20);
        goto L56
    L59:
        r20.primaryEntry = (SelectableAppInfo) r18.get(r20.packageName);
        goto L56
    L61:
        return;
    L30:
        r10 = null;
        goto L31
    L5:
        r3.addCategory("android.intent.category.LAUNCHER");
        goto L6
    }

    private void addSystemImes(Set<String> r4) {
        Iterator<InputMethodInfo> r0 = this.mInjector.getInputMethodList().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        InputMethodInfo r1 = r0.next();
        if (r1.isDefault(this.mContext) == false) goto L4;
        if (isSystemPackage(r1.getPackageName()) == false) goto L4;
        r4.add(r1.getPackageName());     // Catch: Resources.NotFoundException -> L13
        goto L4
    }

    private void addSystemApps(List<SelectableAppInfo> r6, Intent r7, Set<String> r8) {
        PackageManager r0 = this.mPackageManager;
        Iterator<ResolveInfo> r9 = r0.queryIntentActivities(r7, 8704).iterator();
    L4:
        if (r9.hasNext() == false) goto L29;
        ResolveInfo r1 = r9.next();
        if (r1.activityInfo == null) goto L4;
        if (r1.activityInfo.applicationInfo == null) goto L4;
        String r2 = r1.activityInfo.packageName;
        int r3 = r1.activityInfo.applicationInfo.flags;
        if ((r3 & 1) != 0) goto L14;
        if ((r3 & 128) == 0) goto L4;
    L14:
        if (r8.contains(r2) == true) goto L4;
        int r4 = r0.getApplicationEnabledSetting(r2);
        if (r4 != 4) goto L19;
    L20:
        ApplicationInfo r5 = getAppInfoForUser(r2, 0, this.mUser);
        if (r5 == null) goto L4;
        if ((r5.flags & 8388608) == 0) goto L4;
    L25:
        SelectableAppInfo r10 = new SelectableAppInfo();
        r10.packageName = r1.activityInfo.packageName;
        r10.appName = r1.activityInfo.applicationInfo.loadLabel(r0);
        r10.icon = r1.activityInfo.loadIcon(r0);
        r10.activityName = r1.activityInfo.loadLabel(r0);
        if (r10.activityName != null) goto L28;
        r10.activityName = r10.appName;
    L28:
        r6.add(r10);
        goto L4
    L19:
        if (r4 != 2) goto L25;
    }

    private boolean isSystemPackage(String r2) {
        PackageInfo r1 = this.mPackageManager.getPackageInfo(r2, 0);     // Catch: PackageManager.NameNotFoundException -> L14
        if (r1.applicationInfo != null) goto L6;
        return false;
    L6:
        int r3 = r1.applicationInfo.flags;     // Catch: PackageManager.NameNotFoundException -> L14
        if ((r3 & 1) == 0) goto L10;
        return true;
    L10:
        if ((r3 & 128) == 0) goto L13;
        return true;
    L13:
        return false;
    }

    private ApplicationInfo getAppInfoForUser(String r3, int r4, UserHandle r5) {
        return this.mIPm.getApplicationInfo(r3, r4, r5.getIdentifier());
    L4:
        return null;
    }
}
