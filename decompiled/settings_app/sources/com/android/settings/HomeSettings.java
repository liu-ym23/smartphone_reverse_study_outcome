package com.android.settings;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceViewHolder;
import com.GlobalProxyLancet;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.search.Index;
import com.android.settings.search.Indexable;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class HomeSettings extends SettingsPreferenceFragment implements Indexable {
    private static final String EXTRA_SUPPORT_MANAGED_PROFILES = "support_managed_profiles";
    public static final String HOME_PREFS = "home_prefs";
    public static final String HOME_PREFS_DO_SHOW = "do_show";
    public static final String HOME_SHOW_NOTICE = "show";
    static final int REQUESTING_UNINSTALL = 10;
    public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;
    static final String TAG = "HomeSettings";
    private HomeAppPreference mCurrentHome;
    View.OnClickListener mDeleteClickListener;
    View.OnClickListener mHomeClickListener;
    private ComponentName[] mHomeComponentSet;
    private final IntentFilter mHomeFilter;
    private HomePackageReceiver mHomePackageReceiver;
    private PackageManager mPm;
    private PreferenceGroup mPrefGroup;
    private ArrayList<HomeAppPreference> mPrefs;
    private boolean mShowNotice;

    private class HomeAppPreference extends Preference {
        ComponentName activityName;
        HomeSettings fragment;
        final ColorFilter grayscaleFilter;
        int index;
        boolean isChecked;
        boolean isSystem;
        final /* synthetic */ HomeSettings this$0;
        String uninstallTarget;

        public HomeAppPreference(HomeSettings r1, Context r2, ComponentName r3, int r4, Drawable r5, CharSequence r6, HomeSettings r7, ActivityInfo r8, boolean r9, CharSequence r10) {
            this.this$0 = r1;
            super(r2);
            setLayoutResource(R.layout.preference_home_app);
            setIcon(r5);
            setTitle(r6);
            setEnabled(r9);
            setSummary(r10);
            this.activityName = r3;
            this.fragment = r7;
            this.index = r4;
            ColorMatrix r11 = new ColorMatrix();
            r11.setSaturation(0.0f);
            r11.getArray()[18] = 0.5f;
            this.grayscaleFilter = new ColorMatrixColorFilter(r11);
            determineTargets(r8);
        }

        private void determineTargets(ActivityInfo r6) {
            Bundle r0 = r6.metaData;
            boolean r1 = false;
            if (r0 == null) goto L20;
            String r2 = r0.getString("android.app.home.alternate");
            if (r2 == null) goto L20;
        L17:
            e = move-exception;
            OLog.w(HomeSettings.TAG, "Unable to compare/resolve alternate", e);
            goto L20
        L7:
            if (HomeSettings.access$400(this.this$0).checkSignatures(r6.packageName, r2) < 0) goto L20;
            PackageInfo r3 = HomeSettings.access$400(this.this$0).getPackageInfo(r2, 0);     // Catch: Exception -> L17
            if (r3 != null) goto L12;
            return;
        L12:
            if ((r3.applicationInfo.flags & 1) == 0) goto L14;
            boolean r4 = true;
        L15:
            this.isSystem = r4;     // Catch: Exception -> L17
            this.uninstallTarget = r3.packageName;     // Catch: Exception -> L17
            return;
        L14:
            r4 = false;
        L20:
            if ((r6.applicationInfo.flags & 1) == 0) goto L22;
            r1 = true;
        L22:
            this.isSystem = r1;
            this.uninstallTarget = r6.packageName;
        }

        @Override // androidx.preference.Preference
        public void onBindViewHolder(PreferenceViewHolder r4) {
            super.onBindViewHolder(r4);
            ((RadioButton) r4.findViewById(R.id.home_radio)).setChecked(this.isChecked);
            Integer r0 = new Integer(this.index);
            ImageView r1 = (ImageView) r4.findViewById(R.id.home_app_uninstall);
            if (this.isSystem == false) goto L5;
            r1.setEnabled(false);
            r1.setColorFilter(this.grayscaleFilter);
        L6:
            View r5 = r4.findViewById(R.id.home_app_pref);
            r5.setTag(r0);
            r5.setOnClickListener(this.this$0.mHomeClickListener);
            return;
        L5:
            r1.setEnabled(true);
            r1.setOnClickListener(this.this$0.mDeleteClickListener);
            r1.setTag(r0);
            goto L6
        }

        void setChecked(boolean r2) {
            if (r2 == this.isChecked) goto L6;
            this.isChecked = r2;
            notifyChanged();
            return;
        }
    }

    private class HomePackageReceiver extends BroadcastReceiver {
        final /* synthetic */ HomeSettings this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_HomeSettings$HomePackageReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private HomePackageReceiver(HomeSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ HomePackageReceiver(HomeSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void com_android_settings_HomeSettings$HomePackageReceiver__onReceive$___twin___(Context r1, Intent r2) {
            HomeSettings.access$000(this.this$0);
            Index.getInstance(r1).updateFromClassNameResource(HomeSettings.class.getName(), true, true);
        }

        @Insert("onReceive")
        public static void com_android_settings_HomeSettings$HomePackageReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(HomePackageReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            HomePackageReceiver r1 = r7;
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
            r7.com_android_settings_HomeSettings$HomePackageReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_HomeSettings$HomePackageReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_HomeSettings$HomePackageReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_HomeSettings$HomePackageReceiver__onReceive$___twin___(r8, r9);
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

    private boolean versionNumberAtLeastL(int r1) {
        if (r1 < 21) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_HomeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_HomeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(HomeSettings r0) {
        r0.buildHomeActivitiesList();
    }

    static /* synthetic */ ArrayList access$200(HomeSettings r0) {
        return r0.mPrefs;
    }

    static /* synthetic */ HomeAppPreference access$300(HomeSettings r0) {
        return r0.mCurrentHome;
    }

    static /* synthetic */ PackageManager access$400(HomeSettings r0) {
        return r0.mPm;
    }

    public HomeSettings() {
        this.mCurrentHome = null;
        this.mHomePackageReceiver = new HomePackageReceiver(this, null);
        this.mHomeClickListener = new AnonymousClass1(this);
        this.mDeleteClickListener = new AnonymousClass2(this);
        IntentFilter r0 = new IntentFilter("android.intent.action.MAIN");
        this.mHomeFilter = r0;
        r0.addCategory("android.intent.category.HOME");
        r0.addCategory("android.intent.category.DEFAULT");
    }

    void makeCurrentHome(HomeAppPreference r5) {
        HomeAppPreference r0 = this.mCurrentHome;
        if (r0 == null) goto L5;
        r0.setChecked(false);
    L5:
        r5.setChecked(true);
        this.mCurrentHome = r5;
        this.mPm.replacePreferredActivity(this.mHomeFilter, 1048576, this.mHomeComponentSet, r5.activityName);
        getActivity().setResult(-1);
    }

    void uninstallApp(HomeAppPreference r4) {
        Intent r1 = new Intent("android.intent.action.UNINSTALL_PACKAGE", Uri.parse("package:" + r4.uninstallTarget));
        r1.putExtra("android.intent.extra.UNINSTALL_ALL_USERS", false);
        startActivityForResult(r1, (r4.isChecked ? 1 : 0) + 10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        buildHomeActivitiesList();
        if (r1 > 10) goto L5;
        return;
    L5:
        if (this.mCurrentHome != null) goto L16;
        int r4 = 0;
    L8:
        if (r4 >= this.mPrefs.size()) goto L18;
        HomeAppPreference r5 = this.mPrefs.get(r4);
        if (r5.isSystem == true) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        makeCurrentHome(r5);
        return;
    L18:
        return;
    }

    private void buildHomeActivitiesList() {
        ArrayList r13 = new ArrayList();
        ComponentName r14 = this.mPm.getHomeActivities(r13);
        Context r15 = getPrefContext();
        this.mCurrentHome = null;
        this.mPrefGroup.removeAll();
        this.mPrefs = new ArrayList();
        this.mHomeComponentSet = new ComponentName[r13.size()];
        boolean r0 = getActivity().getIntent().getBooleanExtra(EXTRA_SUPPORT_MANAGED_PROFILES, false);
        if (hasManagedProfile() == true) goto L7;
        if (r0 == true) goto L7;
        boolean r16 = false;
    L8:
        int r11 = 0;
        int r17 = 0;
    L10:
        if (r11 >= r13.size()) goto L36;
        ResolveInfo r1 = (ResolveInfo) r13.get(r11);
        ActivityInfo r9 = r1.activityInfo;
        ComponentName r10 = new ComponentName(r9.packageName, r9.name);
        this.mHomeComponentSet[r11] = r10;
        Drawable r6 = r9.loadIcon(this.mPm);     // Catch: Exception -> L32
        CharSequence r7 = r9.loadLabel(this.mPm);     // Catch: Exception -> L32
        if (r16 == true) goto L47;
    L21:
        ComponentName r20 = r10;
        int r18 = r11;
        HomeAppPreference r2 = new HomeAppPreference(this, r15, r20, r17, r6, r7, this, r9, true, null);     // Catch: Exception -> L30
    L22:
        this.mPrefs.add(r2);     // Catch: Exception -> L30
        this.mPrefGroup.addPreference(r2);     // Catch: Exception -> L30
        ComponentName r3 = r20;
    L28:
        e = e;
    L34:
        OLog.v(TAG, "Problem dealing with activity " + r3, e);
    L35:
        r11 = r18 + 1;
        goto L10
    L25:
        if (r3.equals(r14) == false) goto L27;
        this.mCurrentHome = r2;     // Catch: Exception -> L28
    L27:
        r17 = r17 + 1;
        goto L35
    L47:
    L19:
        e = e;
        r18 = r11;
        r3 = r10;
        goto L34
    L15:
        if (launcherHasManagedProfilesFeature(r1) == true) goto L21;
        r20 = r10;
        r18 = r11;
        r2 = new HomeAppPreference(this, r15, r10, r17, r6, r7, this, r9, false, getResources().getString(R.string.home_work_profile_not_supported));     // Catch: Exception -> L30
    L30:
        e = e;
        r3 = r20;
    L32:
        e = e;
        r3 = r10;
        r18 = r11;
        goto L34
    L36:
        HomeAppPreference r4 = this.mCurrentHome;
        if (r4 != null) goto L39;
        return;
    L39:
        if (r4.isEnabled() == false) goto L41;
        getActivity().setResult(-1);
    L41:
        new Handler().post(new AnonymousClass3(this));
        return;
    L7:
        r16 = true;
        goto L8
    }

    private boolean hasManagedProfile() {
        FragmentActivity r0 = getActivity();
        Iterator r2 = ((UserManager) getSystemService(PickApplicationActivity.EXTRA_USER)).getProfiles(r0.getUserId()).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (((UserInfo) r2.next()).isManagedProfile() == false) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean launcherHasManagedProfilesFeature(ResolveInfo r3) {
    L8:
        return false;
    L4:
        if (getPackageManager() != null) goto L6;
        return false;
    L6:
        return versionNumberAtLeastL(getPackageManager().getApplicationInfo(r3.activityInfo.packageName, 0).targetSdkVersion);
    }

    public void com_android_settings_HomeSettings__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        addPreferencesFromResource(R.xml.home_selection);
        this.mPm = getPackageManager();
        this.mPrefGroup = (PreferenceGroup) findPreference("home");
        Bundle r4 = getArguments();
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        this.mShowNotice = r0;
        return;
    L5:
        if (r4.getBoolean("show", false) == false) goto L7;
        r0 = true;
        goto L7
    }

    public void com_android_settings_HomeSettings__onResume$___twin___() {
        super.onResume();
        IntentFilter r0 = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        r0.addAction("android.intent.action.PACKAGE_REMOVED");
        r0.addAction("android.intent.action.PACKAGE_CHANGED");
        r0.addAction("android.intent.action.PACKAGE_REPLACED");
        r0.addDataScheme("package");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mHomePackageReceiver, r0, 2);
        buildHomeActivitiesList();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterReceiver(this.mHomePackageReceiver);
    }

    static {
        SEARCH_INDEX_DATA_PROVIDER = new AnonymousClass4();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_HomeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(HomeSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_HomeSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_HomeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(HomeSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_HomeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_HomeSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(HomeSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_HomeSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
