package com.android.settings.users;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionEntry;
import android.content.RestrictionsManager;
import android.content.pm.ActivityInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.ListPreference;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreference;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.android.settingslib.users.AppRestrictionsHelper;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class AppRestrictionsFragment extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener, View.OnClickListener, Preference.OnPreferenceClickListener, AppRestrictionsHelper.OnDisableUiForPackageListener {
    private static final int CUSTOM_REQUEST_CODE_START = 1000;
    private static final boolean DEBUG = false;
    private static final String DELIMITER = ";";
    public static final String EXTRA_NEW_USER = "new_user";
    public static final String EXTRA_USER_ID = "user_id";
    private static final int MAX_APP_RESTRICTIONS = 100;
    private static final String PKG_PREFIX = "pkg_";
    private static final String TAG = "AppRestrictionsFragment";
    private PreferenceGroup mAppList;
    private boolean mAppListChanged;
    private AsyncTask mAppLoadingTask;
    private int mCustomRequestCode;
    private HashMap<Integer, AppRestrictionsPreference> mCustomRequestMap;
    private boolean mFirstTime;
    private AppRestrictionsHelper mHelper;
    protected IPackageManager mIPm;
    private boolean mNewUser;
    protected PackageManager mPackageManager;
    private BroadcastReceiver mPackageObserver;
    protected boolean mRestrictedProfile;
    private PackageInfo mSysPackageInfo;
    protected UserHandle mUser;
    private BroadcastReceiver mUserBackgrounding;
    protected UserManager mUserManager;

    private class AppLoadingTask extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ AppRestrictionsFragment this$0;

        private AppLoadingTask(AppRestrictionsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AppLoadingTask(AppRestrictionsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... r1) {
            AppRestrictionsFragment.access$100(this.this$0).fetchAndMergeApps();
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r1) {
            AppRestrictionsFragment.access$500(this.this$0);
        }
    }

    static class AppRestrictionsPreference extends SwitchPreference {
        private boolean hasSettings;
        private boolean immutable;
        private View.OnClickListener listener;
        private List<Preference> mChildren;
        private boolean panelOpen;
        private ArrayList<RestrictionEntry> restrictions;

        static /* synthetic */ View.OnClickListener access$300(AppRestrictionsPreference r0) {
            return r0.listener;
        }

        static /* synthetic */ void access$600(AppRestrictionsPreference r0, boolean r1) {
            r0.setSettingsEnabled(r1);
        }

        static /* synthetic */ ArrayList access$700(AppRestrictionsPreference r0) {
            return r0.restrictions;
        }

        static /* synthetic */ boolean access$800(AppRestrictionsPreference r0) {
            return r0.hasSettings;
        }

        static /* synthetic */ List access$900(AppRestrictionsPreference r0) {
            return r0.mChildren;
        }

        AppRestrictionsPreference(Context r1, View.OnClickListener r2) {
            super(r1);
            this.mChildren = new ArrayList();
            setLayoutResource(R.layout.preference_app_restrictions);
            this.listener = r2;
        }

        private void setSettingsEnabled(boolean r1) {
            this.hasSettings = r1;
        }

        void setRestrictions(ArrayList<RestrictionEntry> r1) {
            this.restrictions = r1;
        }

        void setImmutable(boolean r1) {
            this.immutable = r1;
        }

        boolean isImmutable() {
            return this.immutable;
        }

        ArrayList<RestrictionEntry> getRestrictions() {
            return this.restrictions;
        }

        boolean isPanelOpen() {
            return this.panelOpen;
        }

        void setPanelOpen(boolean r1) {
            this.panelOpen = r1;
        }

        List<Preference> getChildren() {
            return this.mChildren;
        }

        @Override // androidx.preference.SwitchPreference, androidx.preference.Preference
        public void onBindViewHolder(PreferenceViewHolder r6) {
            super.onBindViewHolder(r6);
            View r0 = r6.findViewById(R.id.app_restrictions_settings);
            int r2 = 8;
            if (this.hasSettings == false) goto L5;
            int r1 = 0;
        L6:
            r0.setVisibility(r1);
            View r3 = r6.findViewById(R.id.settings_divider);
            if (this.hasSettings == false) goto L9;
            r2 = 0;
        L9:
            r3.setVisibility(r2);
            r0.setOnClickListener(this.listener);
            r0.setTag(this);
            View r4 = r6.findViewById(R.id.app_restrictions_pref);
            r4.setOnClickListener(this.listener);
            r4.setTag(this);
            ViewGroup r7 = (ViewGroup) r6.findViewById(android.R.id.widget_frame);
            r7.setEnabled(!isImmutable());
            if (r7.getChildCount() <= 0) goto L13;
            final Switch r8 = (Switch) r7.getChildAt(0);
            r8.setEnabled(!isImmutable());
            r8.setTag(this);
            r8.setClickable(true);
            r8.setFocusable(true);
            r8.setOnCheckedChangeListener(new AnonymousClass1(this, r8));
            return;
        L13:
            return;
        L5:
            r1 = 8;
            goto L6
        }
    }

    class RestrictionsResultReceiver extends BroadcastReceiver {
        private static final String CUSTOM_RESTRICTIONS_INTENT = "android.intent.extra.restrictions_intent";
        boolean invokeIfCustom;
        String packageName;
        AppRestrictionsPreference preference;
        final /* synthetic */ AppRestrictionsFragment this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_users_AppRestrictionsFragment$RestrictionsResultReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        RestrictionsResultReceiver(AppRestrictionsFragment r1, String r2, AppRestrictionsPreference r3, boolean r4) {
            this.this$0 = r1;
            this.packageName = r2;
            this.preference = r3;
            this.invokeIfCustom = r4;
        }

        public void com_android_settings_users_AppRestrictionsFragment$RestrictionsResultReceiver__onReceive$___twin___(Context r2, Intent r3) {
            Bundle r4 = getResultExtras(true);
            ArrayList<RestrictionEntry> r5 = r4.getParcelableArrayList("android.intent.extra.restrictions_list");
            Intent r6 = (Intent) r4.getParcelable(CUSTOM_RESTRICTIONS_INTENT);
            if (r5 == null) goto L8;
            if (r6 != null) goto L8;
            AppRestrictionsFragment.access$1000(this.this$0, this.preference, r5);
            if (this.this$0.mRestrictedProfile == false) goto L20;
            this.this$0.mUserManager.setApplicationRestrictions(this.packageName, RestrictionsManager.convertRestrictionsToBundle(r5), this.this$0.mUser);
            return;
        L20:
            return;
        L8:
            if (r6 == null) goto L22;
            this.preference.setRestrictions(r5);
            if (this.invokeIfCustom == true) goto L12;
            return;
        L12:
            if (this.this$0.isResumed() == false) goto L24;
            Intent r7 = assertSafeToStartCustomActivity(r6);     // Catch: Throwable -> L15
            this.this$0.startActivityForResult(r7, AppRestrictionsFragment.access$1200(this.this$0, this.preference));
            return;
        L15:
            e = move-exception;
            OLog.e(AppRestrictionsFragment.access$1100(), "Cannot start restrictionsIntent " + e);
            return;
        L24:
            return;
        }

        private Intent assertSafeToStartCustomActivity(Intent r5) {
            Intent r0 = new Intent(r5);
            ResolveInfo r1 = this.this$0.mPackageManager.resolveActivity(r0, 65536);
            if (r1 == null) goto L11;
            ActivityInfo r2 = r1.activityInfo;
            if (this.packageName.equals(r2.packageName) == false) goto L9;
            r0.setComponent(r2.getComponentName());
            r0.setPackage(r2.packageName);
            return r0;
        L9:
            throw new SecurityException("Application " + this.packageName + " is not allowed to start activity " + r5);
        L11:
            throw new ActivityNotFoundException("No result for resolving " + r5);
        }

        @Insert("onReceive")
        public static void com_android_settings_users_AppRestrictionsFragment$RestrictionsResultReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(RestrictionsResultReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            RestrictionsResultReceiver r1 = r7;
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
            r7.com_android_settings_users_AppRestrictionsFragment$RestrictionsResultReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_users_AppRestrictionsFragment$RestrictionsResultReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_users_AppRestrictionsFragment$RestrictionsResultReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_users_AppRestrictionsFragment$RestrictionsResultReceiver__onReceive$___twin___(r8, r9);
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

    static {
    }

    public AppRestrictionsFragment() {
        this.mFirstTime = true;
        this.mCustomRequestCode = 1000;
        this.mCustomRequestMap = new HashMap();
        this.mUserBackgrounding = new AnonymousClass1(this);
        this.mPackageObserver = new AnonymousClass2(this);
    }

    static /* synthetic */ boolean access$000(AppRestrictionsFragment r0) {
        return r0.mAppListChanged;
    }

    static /* synthetic */ AppRestrictionsHelper access$100(AppRestrictionsFragment r0) {
        return r0.mHelper;
    }

    static /* synthetic */ void access$1000(AppRestrictionsFragment r0, AppRestrictionsPreference r1, ArrayList r2) {
        r0.onRestrictionsReceived(r1, r2);
    }

    static /* synthetic */ String access$1100() {
        return TAG;
    }

    static /* synthetic */ int access$1200(AppRestrictionsFragment r0, AppRestrictionsPreference r1) {
        return r0.generateCustomActivityRequestCode(r1);
    }

    static /* synthetic */ void access$200(AppRestrictionsFragment r0, Intent r1) {
        r0.onPackageChanged(r1);
    }

    static /* synthetic */ void access$500(AppRestrictionsFragment r0) {
        r0.populateApps();
    }

    protected void init(Bundle r4) {
        if (r4 == null) goto L5;
        this.mUser = new UserHandle(r4.getInt("user_id"));
    L12:
        if (this.mUser != null) goto L14;
        this.mUser = Process.myUserHandle();
    L14:
        this.mHelper = new AppRestrictionsHelper(getContext(), this.mUser);
        this.mPackageManager = getActivity().getPackageManager();
        this.mIPm = IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
        UserManager r5 = (UserManager) getActivity().getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mUserManager = r5;
        this.mRestrictedProfile = r5.getUserInfo(this.mUser.getIdentifier()).isRestricted();
        this.mSysPackageInfo = this.mPackageManager.getPackageInfo(RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME, 64);     // Catch: PackageManager.NameNotFoundException -> L18
    L16:
        addPreferencesFromResource(R.xml.app_restrictions);
        PreferenceGroup r6 = getAppPreferenceGroup();
        this.mAppList = r6;
        r6.setOrderingAsAdded(false);
        return;
    L5:
        Bundle r7 = getArguments();
        if (r7 == null) goto L12;
        if (r7.containsKey("user_id") == false) goto L10;
        this.mUser = new UserHandle(r7.getInt("user_id"));
    L10:
        this.mNewUser = r7.getBoolean(EXTRA_NEW_USER, false);
        goto L12
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putInt("user_id", this.mUser.getIdentifier());
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mUserBackgrounding, new IntentFilter("android.intent.action.USER_BACKGROUND"), 2);
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.intent.action.PACKAGE_ADDED");
        r0.addAction("android.intent.action.PACKAGE_REMOVED");
        r0.addDataScheme("package");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mPackageObserver, r0, 2);
        this.mAppListChanged = false;
        AsyncTask r1 = this.mAppLoadingTask;
        if (r1 != null) goto L5;
    L6:
        this.mAppLoadingTask = new AppLoadingTask(this, null).execute(new Void[0]);
        return;
    L5:
        if (r1.getStatus() == AsyncTask.Status.FINISHED) goto L6;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.android.settings.users.AppRestrictionsFragment$3] */
    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mNewUser = false;
        unregisterReceiver(this.mUserBackgrounding);
        unregisterReceiver(this.mPackageObserver);
        if (this.mAppListChanged == false) goto L6;
        new AnonymousClass3(this).execute(new Void[0]);
        return;
    }

    private void onPackageChanged(Intent r2) {
        String r0 = r2.getAction();
        AppRestrictionsPreference r1 = (AppRestrictionsPreference) findPreference(getKeyForPackage(r2.getData().getSchemeSpecificPart()));
        if (r1 != null) goto L6;
        return;
    L6:
        if ("android.intent.action.PACKAGE_ADDED".equals(r0) == false) goto L10;
        if (r1.isChecked() == false) goto L10;
    L13:
        r1.setEnabled(true);
        return;
    L10:
        if ("android.intent.action.PACKAGE_REMOVED".equals(r0) == true) goto L12;
        return;
    L12:
        if (r1.isChecked() == false) goto L13;
    }

    protected PreferenceGroup getAppPreferenceGroup() {
        return getPreferenceScreen();
    }

    @Override // com.android.settingslib.users.AppRestrictionsHelper.OnDisableUiForPackageListener
    public void onDisableUiForPackage(String r1) {
        AppRestrictionsPreference r0 = (AppRestrictionsPreference) findPreference(getKeyForPackage(r1));
        if (r0 == null) goto L6;
        r0.setEnabled(false);
        return;
    }

    private boolean isPlatformSigned(PackageInfo r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.signatures != null) goto L7;
        return false;
    L7:
        if (this.mSysPackageInfo.signatures[0].equals(r3.signatures[0]) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private boolean isAppEnabledForUser(PackageInfo r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        int r0 = r3.applicationInfo.flags;
        int r4 = r3.applicationInfo.privateFlags;
        if ((r0 & 8388608) != 0) goto L8;
        return false;
    L8:
        if ((r4 & 1) == 0) goto L10;
        return false;
    L10:
        return true;
    }

    private void populateApps() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        PackageManager r1 = this.mPackageManager;
        IPackageManager r2 = this.mIPm;
        int r3 = this.mUser.getIdentifier();
        if (Utils.getExistingUser(this.mUserManager, this.mUser) != null) goto L8;
        return;
    L8:
        this.mAppList.removeAll();
        List<ResolveInfo> r4 = r1.queryBroadcastReceivers(new Intent("android.intent.action.GET_RESTRICTION_ENTRIES"), 0);
        Iterator<AppRestrictionsHelper.SelectableAppInfo> r5 = this.mHelper.getVisibleApps().iterator();
    L10:
        if (r5.hasNext() == false) goto L57;
        AppRestrictionsHelper.SelectableAppInfo r6 = r5.next();
        String r8 = r6.packageName;
        if (r8 == null) goto L10;
        boolean r9 = r8.equals(r0.getPackageName());
        AppRestrictionsPreference r10 = new AppRestrictionsPreference(getPrefContext(), this);
        boolean r11 = resolveInfoListHasPackage(r4, r8);
        if (r9 == true) goto L16;
        Drawable r12 = null;
        PackageInfo r13 = r2.getPackageInfo(r8, 8256, r3);     // Catch: RemoteException -> L20
    L21:
        if (r13 == null) goto L10;
        if (this.mRestrictedProfile == false) goto L29;
        if (isAppUnsupportedInRestrictedProfile(r13) == true) goto L10;
    L29:
        if (r6.icon == null) goto L31;
        r12 = r6.icon.mutate();
    L31:
        r10.setIcon(r12);
        r10.setChecked(false);
        r10.setTitle(r6.activityName);
        r10.setKey(getKeyForPackage(r8));
        if (r11 == true) goto L34;
    L36:
        boolean r14 = false;
    L37:
        AppRestrictionsPreference.access$600(r10, r14);
        r10.setPersistent(false);
        r10.setOnPreferenceChangeListener(this);
        r10.setOnPreferenceClickListener(this);
        r10.setSummary(getPackageSummary(r13, r6));
        if (r13.requiredForAllUsers == false) goto L40;
    L47:
        r10.setChecked(true);
        r10.setImmutable(true);
        if (r11 == false) goto L10;
        if (r6.primaryEntry != null) goto L54;
        requestRestrictionsForApp(r8, r10, false);
    L54:
        if (r6.primaryEntry == null) goto L56;
        r10.setImmutable(true);
        r10.setChecked(this.mHelper.isPackageSelected(r8));
    L56:
        r10.setOrder((this.mAppList.getPreferenceCount() + 2) * 100);
        this.mHelper.setPackageSelected(r8, r10.isChecked());
        this.mAppList.addPreference(r10);
        goto L10
    L40:
        if (isPlatformSigned(r13) == true) goto L47;
        if (this.mNewUser == true) goto L54;
        if (isAppEnabledForUser(r13) == false) goto L54;
        r10.setChecked(true);
        goto L54
    L34:
        if (r6.primaryEntry != null) goto L36;
        r14 = true;
    L20:
        r13 = null;
        goto L21
    L16:
        addLocationAppRestrictionsPreference(r6, r10);
        this.mHelper.setPackageSelected(r8, true);
        goto L10
    L57:
        this.mAppListChanged = true;
        if (this.mNewUser == true) goto L60;
        return;
    L60:
        if (this.mFirstTime == false) goto L82;
        this.mFirstTime = false;
        this.mHelper.applyUserAppsStates(this);
        return;
    }

    private String getPackageSummary(PackageInfo r4, AppRestrictionsHelper.SelectableAppInfo r5) {
        if (r5.primaryEntry == null) goto L13;
        if (this.mRestrictedProfile == false) goto L11;
        if (r4.restrictedAccountType == null) goto L11;
        return getString(R.string.app_sees_restricted_accounts_and_controlled_by, new Object[]{r5.primaryEntry.activityName});
    L11:
        return getString(R.string.user_restrictions_controlled_by, new Object[]{r5.primaryEntry.activityName});
    L13:
        if (r4.restrictedAccountType != null) goto L15;
        return null;
    L15:
        return getString(R.string.app_sees_restricted_accounts);
    }

    private static boolean isAppUnsupportedInRestrictedProfile(PackageInfo r1) {
        if (r1.requiredAccountType != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.restrictedAccountType != null) goto L7;
        return true;
    }

    private void addLocationAppRestrictionsPreference(AppRestrictionsHelper.SelectableAppInfo r4, AppRestrictionsPreference r5) {
        String r6 = r4.packageName;
        r5.setIcon(R.drawable.ic_settings_location);
        r5.setKey(getKeyForPackage(r6));
        ArrayList<RestrictionEntry> r7 = RestrictionUtils.getRestrictions(getActivity(), this.mUser);
        RestrictionEntry r1 = r7.get(0);
        r5.setTitle(r1.getTitle());
        r5.setRestrictions(r7);
        r5.setSummary(r1.getDescription());
        r5.setChecked(r1.getSelectedState());
        r5.setPersistent(false);
        r5.setOnPreferenceClickListener(this);
        r5.setOrder(100);
        this.mAppList.addPreference(r5);
    }

    private String getKeyForPackage(String r2) {
        return PKG_PREFIX + r2;
    }

    private boolean resolveInfoListHasPackage(List<ResolveInfo> r1, String r2) {
        Iterator<ResolveInfo> r0 = r1.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().activityInfo.packageName.equals(r2) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private void updateAllEntries(String r4, boolean r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.mAppList.getPreferenceCount()) goto L11;
        Preference r1 = this.mAppList.getPreference(r0);
        if ((r1 instanceof AppRestrictionsPreference) == false) goto L10;
        if (r4.equals(r1.getKey()) == false) goto L10;
        ((AppRestrictionsPreference) r1).setChecked(r5);
    L10:
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r6) {
        if ((r6.getTag() instanceof AppRestrictionsPreference) == false) goto L25;
        AppRestrictionsPreference r0 = (AppRestrictionsPreference) r6.getTag();
        if (r6.getId() != R.id.app_restrictions_settings) goto L8;
        onAppSettingsIconClicked(r0);
        return;
    L8:
        if (r0.isImmutable() == true) goto L27;
        r0.setChecked(!r0.isChecked());
        String r7 = r0.getKey().substring(4);
        if (r7.equals(getActivity().getPackageName()) == false) goto L13;
        ((RestrictionEntry) AppRestrictionsPreference.access$700(r0).get(0)).setSelectedState(r0.isChecked());
        RestrictionUtils.setRestrictions(getActivity(), AppRestrictionsPreference.access$700(r0), this.mUser);
        return;
    L13:
        this.mHelper.setPackageSelected(r7, r0.isChecked());
        if (r0.isChecked() == true) goto L16;
    L20:
        this.mAppListChanged = true;
        if (this.mRestrictedProfile == true) goto L23;
        this.mHelper.applyUserAppState(r7, r0.isChecked(), this);
    L23:
        updateAllEntries(r0.getKey(), r0.isChecked());
        return;
    L16:
        if (AppRestrictionsPreference.access$800(r0) == false) goto L20;
        if (AppRestrictionsPreference.access$700(r0) != null) goto L20;
        requestRestrictionsForApp(r7, r0, false);
        goto L20
    L27:
        return;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r9, Object r10) {
        String r0 = r9.getKey();
        if (r0 != null) goto L5;
    L26:
        return true;
    L5:
        if (r0.contains(DELIMITER) == false) goto L26;
        StringTokenizer r3 = new StringTokenizer(r0, DELIMITER);
        String r1 = r3.nextToken();
        String r2 = r3.nextToken();
        ArrayList<RestrictionEntry> r4 = ((AppRestrictionsPreference) this.mAppList.findPreference(PKG_PREFIX + r1)).getRestrictions();
        if (r4 == null) goto L26;
        Iterator<RestrictionEntry> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L26;
        RestrictionEntry r6 = r5.next();
        if (r6.getKey().equals(r2) == false) goto L10;
        int r7 = r6.getType();
        if (r7 == 1) goto L24;
        if (r7 == 2) goto L23;
        if (r7 == 3) goto L23;
        if (r7 != 4) goto L10;
        Set r11 = (Set) r10;
        String[] r12 = new String[r11.size()];
        r11.toArray(r12);
        r6.setAllSelectedStrings(r12);
    L25:
        this.mUserManager.setApplicationRestrictions(r1, RestrictionsManager.convertRestrictionsToBundle(r4), this.mUser);
    L23:
        String r13 = (String) r10;
        r6.setSelectedString(r13);
        ((ListPreference) r9).setSummary(findInArray(r6.getChoiceEntries(), r6.getChoiceValues(), r13));
        goto L25
    L24:
        r6.setSelectedState(((Boolean) r10).booleanValue());
        goto L25
    }

    private void removeRestrictionsForApp(AppRestrictionsPreference r4) {
        Iterator r0 = AppRestrictionsPreference.access$900(r4).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Preference r1 = (Preference) r0.next();
        this.mAppList.removePreference(r1);
        goto L4
    L6:
        AppRestrictionsPreference.access$900(r4).clear();
    }

    private void onAppSettingsIconClicked(AppRestrictionsPreference r4) {
        if (r4.getKey().startsWith(PKG_PREFIX) == true) goto L5;
        return;
    L5:
        if (r4.isPanelOpen() == false) goto L7;
        removeRestrictionsForApp(r4);
    L8:
        r4.setPanelOpen(!r4.isPanelOpen());
        return;
    L7:
        requestRestrictionsForApp(r4.getKey().substring(4), r4, true);
        goto L8
    }

    private void requestRestrictionsForApp(String r10, AppRestrictionsPreference r11, boolean r12) {
        Bundle r0 = this.mUserManager.getApplicationRestrictions(r10, this.mUser);
        Intent r2 = new Intent("android.intent.action.GET_RESTRICTION_ENTRIES");
        r2.setPackage(r10);
        r2.putExtra("android.intent.extra.restrictions_bundle", r0);
        r2.addFlags(32);
        getActivity().sendOrderedBroadcast(r2, null, new RestrictionsResultReceiver(this, r10, r11, r12), null, -1, null, null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void onRestrictionsReceived(AppRestrictionsPreference r10, ArrayList<RestrictionEntry> r11) {
        removeRestrictionsForApp(r10);
        Iterator<RestrictionEntry> r0 = r11.iterator();
        int r2 = 1;
    L4:
        if (r0.hasNext() == false) goto L21;
        RestrictionEntry r3 = r0.next();
        int r4 = r3.getType();
        if (r4 != 1) goto L8;
        SwitchPreference r5 = new SwitchPreference(getPrefContext());
        r5.setTitle(r3.getTitle());
        r5.setSummary(r3.getDescription());
        r5.setChecked(r3.getSelectedState());
        Preference r6 = r5;
    L19:
        if (r6 == null) goto L4;
        r6.setPersistent(false);
        r6.setOrder(r10.getOrder() + r2);
        r6.setKey(r10.getKey().substring(4) + DELIMITER + r3.getKey());
        this.mAppList.addPreference(r6);
        r6.setOnPreferenceChangeListener(this);
        r6.setIcon(R.drawable.empty_icon);
        AppRestrictionsPreference.access$900(r10).add(r6);
        r2 = r2 + 1;
        goto L4
    L8:
        if (r4 != 2) goto L10;
    L14:
        ListPreference r7 = new ListPreference(getPrefContext());
        r7.setTitle(r3.getTitle());
        String r8 = r3.getSelectedString();
        if (r8 != null) goto L17;
        r8 = r3.getDescription();
    L17:
        r7.setSummary(findInArray(r3.getChoiceEntries(), r3.getChoiceValues(), r8));
        r7.setEntryValues(r3.getChoiceValues());
        r7.setEntries(r3.getChoiceEntries());
        r7.setValue(r8);
        r7.setDialogTitle(r3.getTitle());
        r6 = r7;
        goto L19
    L10:
        if (r4 == 3) goto L14;
        if (r4 == 4) goto L13;
        r6 = null;
        goto L19
    L13:
        MultiSelectListPreference r9 = new MultiSelectListPreference(getPrefContext());
        r9.setTitle(r3.getTitle());
        r9.setEntryValues(r3.getChoiceValues());
        r9.setEntries(r3.getChoiceEntries());
        HashSet r12 = new HashSet();
        Collections.addAll(r12, r3.getAllSelectedStrings());
        r9.setValues(r12);
        r9.setDialogTitle(r3.getTitle());
        r6 = r9;
        goto L19
    L21:
        r10.setRestrictions(r11);
        if (r2 == 1) goto L24;
        return;
    L24:
        if (r10.isImmutable() == true) goto L26;
        return;
    L26:
        if (r10.isChecked() == false) goto L36;
        this.mAppList.removePreference(r10);
        return;
    }

    private int generateCustomActivityRequestCode(AppRestrictionsPreference r3) {
        int r0 = this.mCustomRequestCode + 1;
        this.mCustomRequestCode = r0;
        this.mCustomRequestMap.put(Integer.valueOf(r0), r3);
        return this.mCustomRequestCode;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r4, int r5, Intent r6) {
        super.onActivityResult(r4, r5, r6);
        AppRestrictionsPreference r0 = this.mCustomRequestMap.get(Integer.valueOf(r4));
        if (r0 != null) goto L7;
        OLog.w(TAG, "Unknown requestCode " + r4);
        return;
    L7:
        if (r5 != (-1)) goto L13;
        String r7 = r0.getKey().substring(4);
        ArrayList<RestrictionEntry> r1 = r6.getParcelableArrayListExtra("android.intent.extra.restrictions_list");
        Bundle r8 = GlobalProxyLancet.com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r6, "android.intent.extra.restrictions_bundle");
        if (r1 == null) goto L11;
        r0.setRestrictions(r1);
        this.mUserManager.setApplicationRestrictions(r7, RestrictionsManager.convertRestrictionsToBundle(r1), this.mUser);
        goto L13
    L11:
        if (r8 == null) goto L13;
        this.mUserManager.setApplicationRestrictions(r7, r8, this.mUser);
    L13:
        this.mCustomRequestMap.remove(Integer.valueOf(r4));
    }

    private String findInArray(String[] r2, String[] r3, String r4) {
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L10;
        if (r3[r1].equals(r4) == true) goto L8;
        r1 = r1 + 1;
        goto L4
    L8:
        return r2[r1];
    L10:
        return r4;
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r5) {
        if (r5.getKey().startsWith(PKG_PREFIX) == false) goto L8;
        AppRestrictionsPreference r6 = (AppRestrictionsPreference) r5;
        if (r6.isImmutable() == true) goto L7;
        String r0 = r6.getKey().substring(4);
        boolean r2 = !r6.isChecked();
        r6.setChecked(r2);
        this.mHelper.setPackageSelected(r0, r2);
        updateAllEntries(r6.getKey(), r2);
        this.mAppListChanged = true;
        this.mHelper.applyUserAppState(r0, r2, this);
    L7:
        return true;
    L8:
        return false;
    }
}
