package com.android.settings.accounts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceViewHolder;
import androidx.recyclerview.widget.RecyclerView;
import com.GlobalProxyLancet;
import com.android.settings.AccessiblePreferenceCategory;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsFeature;
import com.android.settings.SettingsInitialize;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.Utils;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.users.UserDialogs;
import com.android.settings.utils.DevicePolicyUtils;
import com.android.settings.wifi.preference.SectionLayoutPreference;
import com.android.settingslib.accounts.AuthenticatorHelper;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes2.dex */
public class AccountSettings extends SettingsPreferenceFragment23 implements AuthenticatorHelper.OnAccountsUpdateListener, Preference.OnPreferenceClickListener {
    private static final String ADD_ACCOUNT_ACTION = "android.settings.ADD_ACCOUNT_SETTINGS";
    private static final String KEY_ACCOUNT = "account";
    private static final int ORDER_FOOTER = 10000;
    private static final int ORDER_HEADER = 0;
    private static final int ORDER_LAST = 1001;
    private static final int ORDER_NEXT_TO_LAST = 1000;
    public static final String TAG = "AccountSettings";
    private IAccountAutoSyncItem mAccountAutoSyncItem;
    private AuthenticatorDescription[] mAuthDescs;
    private String[] mAuthorities;
    private int mAuthoritiesCount;
    private Context mContext;
    private SectionLayoutPreference mFooterPreference;
    private SectionLayoutPreference mHeaderPreference;
    private ManagedProfileBroadcastReceiver mManagedProfileBroadcastReceiver;
    private Preference mProfileNotAvailablePreference;
    private SparseArray<ProfileData> mProfiles;
    private ArrayList<String> mTypeList;
    private UserManager mUm;

    private class AccountPreference extends Preference implements Preference.OnPreferenceClickListener {
        private int bgStyle;
        private final String mFragment;
        private final Bundle mFragmentArguments;
        private int mItemCount;
        private int mPosition;
        private final CharSequence mTitle;
        final /* synthetic */ AccountSettings this$0;

        static /* synthetic */ CharSequence access$300(AccountPreference r0) {
            return r0.mTitle;
        }

        public void setPosition(int r1, int r2) {
            this.mPosition = r1;
            this.mItemCount = r2;
        }

        public AccountPreference(AccountSettings r1, Context r2, CharSequence r3, String r4, Bundle r5, Drawable r6) {
            this.this$0 = r1;
            super(r2);
            this.bgStyle = 3;
            this.mPosition = -1;
            this.mItemCount = 0;
            this.mTitle = r3;
            this.mFragment = r4;
            this.mFragmentArguments = r5;
            setLayoutResource(R.layout.bytedance_cloud_service_entry_layout);
            setTitle(r3);
            UserHandle r7 = (UserHandle) r5.getParcelable("android.intent.extra.USER");
            if (r7 != null) goto L5;
        L7:
            setIcon(r6);
            setOnPreferenceClickListener(this);
            return;
        L5:
            if (r7.getIdentifier() != 10) goto L7;
            r6 = AccountSettings.access$400(r1).getUserBadgedIcon(r6, r7);
            goto L7
        }

        @Override // androidx.preference.Preference.OnPreferenceClickListener
        public boolean onPreferenceClick(Preference r6) {
            if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(this.this$0.getActivity(), "no_modify_accounts") == false) goto L6;
            return true;
        L6:
            if (this.mFragment == null) goto L9;
            Intent r7 = new Intent(this.this$0.getActivity(), ManageAccountsSettingsActivity.class);
            String r1 = this.mFragmentArguments.getString(ManageAccountsSettings.KEY_ACCOUNT_TYPE);
            r7.putExtra("android.intent.extra.USER", this.mFragmentArguments.getParcelable("android.intent.extra.USER"));
            r7.putExtra(ManageAccountsSettings.KEY_ACCOUNT_TYPE, r1);
            r7.putExtra(ManageAccountsSettings.KEY_ACCOUNT_LABEL, this.mTitle);
            r7.putExtra("title", this.mTitle);
            r7.putExtra("back_text_id", R.string.advanced_item_account);
            Utils.startActivity(this.this$0.getActivity(), r7);
            return true;
        L9:
            return false;
        }

        public void setBackgroundStyle(int r1) {
            this.bgStyle = r1;
        }

        @Override // androidx.preference.Preference
        public void onBindViewHolder(PreferenceViewHolder r3) {
            super.onBindViewHolder(r3);
            OCardListItem r4 = (OCardListItem) r3.itemView.findViewById(R.id.bytedance_cloud_service);
            r4.setTitle(getTitle());
            r4.setSubTitle(getSummary());
            r4.showSubTitle(true);
            r4.setAppIcon(getIcon());
            r4.showIcon(true);
            r4.setOnContentClickListener(new AccountSettings$AccountPreference$$ExternalSyntheticLambda0(this));
            int r1 = this.mItemCount;
            if (r1 != 1) goto L5;
            r4.setCardPosition(0);
            return;
        L5:
            int r2 = this.mPosition;
            if (r2 != 0) goto L9;
            r4.setCardPosition(1);
            return;
        L9:
            if (r2 != (r1 - 1)) goto L11;
            r4.setCardPosition(3);
            return;
        L11:
            r4.setCardPosition(2);
        }

        /* JADX INFO: renamed from: lambda$onBindViewHolder$0$com-android-settings-accounts-AccountSettings$AccountPreference, reason: not valid java name */
        /* synthetic */ void m269x9324a2bf(View r1) {
            onPreferenceClick(this);
        }
    }

    public static class AccountPreferenceListGotEvent {
        public ArrayList<AccountPreference> accountPreferences;
        public ProfileData profileData;

        public AccountPreferenceListGotEvent(ProfileData r1, ArrayList<AccountPreference> r2) {
            this.profileData = r1;
            this.accountPreferences = r2;
        }
    }

    private class ManagedProfileBroadcastReceiver extends BroadcastReceiver {
        private boolean listeningToManagedProfileEvents;
        final /* synthetic */ AccountSettings this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_accounts_AccountSettings$ManagedProfileBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private ManagedProfileBroadcastReceiver(AccountSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ManagedProfileBroadcastReceiver(AccountSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void com_android_settings_accounts_AccountSettings$ManagedProfileBroadcastReceiver__onReceive$___twin___(Context r3, Intent r4) {
            if (r4.getAction().equals("android.intent.action.MANAGED_PROFILE_REMOVED") == false) goto L5;
        L9:
            OLog.v(AccountSettings.TAG, "Received broadcast: " + r4.getAction());
            AccountSettings.access$500(this.this$0);
            AccountSettings.access$600(this.this$0);
            this.this$0.updateUi();
            AccountSettings.access$700(this.this$0);
            this.this$0.getActivity().invalidateOptionsMenu();
            return;
        L5:
            if (r4.getAction().equals("android.intent.action.MANAGED_PROFILE_ADDED") == true) goto L9;
            OLog.w(AccountSettings.TAG, "Cannot handle received broadcast: " + r4.getAction());
        }

        public void register(Context r3) {
            if (this.listeningToManagedProfileEvents == true) goto L6;
            IntentFilter r0 = new IntentFilter();
            r0.addAction("android.intent.action.MANAGED_PROFILE_REMOVED");
            r0.addAction("android.intent.action.MANAGED_PROFILE_ADDED");
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, this, r0, 2);
            this.listeningToManagedProfileEvents = true;
            return;
        }

        public void unregister(Context r2) {
            if (this.listeningToManagedProfileEvents == false) goto L6;
            r2.unregisterReceiver(this);
            this.listeningToManagedProfileEvents = false;
            return;
        }

        @Insert("onReceive")
        public static void com_android_settings_accounts_AccountSettings$ManagedProfileBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(ManagedProfileBroadcastReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            ManagedProfileBroadcastReceiver r1 = r7;
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
            r7.com_android_settings_accounts_AccountSettings$ManagedProfileBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_accounts_AccountSettings$ManagedProfileBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_accounts_AccountSettings$ManagedProfileBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_accounts_AccountSettings$ManagedProfileBroadcastReceiver__onReceive$___twin___(r8, r9);
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

    private static class ProfileData {
        public Preference addAccountPreference;
        public AuthenticatorHelper authenticatorHelper;
        public Preference managedProfilePreference;
        public PreferenceGroup preferenceGroup;
        public Preference removeWorkProfilePreference;
        public UserInfo userInfo;

        private ProfileData() {
        }

        /* synthetic */ ProfileData(AnonymousClass1 r1) {
            this();
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accounts_AccountSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accounts_AccountSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AccountSettings() {
        this.mProfiles = new SparseArray();
        this.mManagedProfileBroadcastReceiver = new ManagedProfileBroadcastReceiver(this, null);
        this.mAuthoritiesCount = 0;
        this.mTypeList = new ArrayList();
    }

    static /* synthetic */ UserManager access$100(AccountSettings r0) {
        return r0.mUm;
    }

    static /* synthetic */ PackageManager access$400(AccountSettings r0) {
        return r0.getPackageManager();
    }

    static /* synthetic */ void access$500(AccountSettings r0) {
        r0.stopListeningToAccountUpdates();
    }

    static /* synthetic */ void access$600(AccountSettings r0) {
        r0.cleanUpPreferences();
    }

    static /* synthetic */ void access$700(AccountSettings r0) {
        r0.listenToAccountUpdates();
    }

    public void com_android_settings_accounts_AccountSettings__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mContext = getActivity().getApplicationContext();
        this.mUm = (UserManager) getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mProfileNotAvailablePreference = new Preference(getActivity());
        String[] r3 = getActivity().getIntent().getStringArrayExtra(AccountPreferenceBase.AUTHORITIES_FILTER_KEY);
        this.mAuthorities = r3;
        if (r3 == null) goto L5;
        this.mAuthoritiesCount = r3.length;
    L5:
        EventBus.getDefault().register(this);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
        super.onCreatePreferences(r1, r2);
        addPreferencesFromResource(R.xml.account_settings);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        RecyclerView r5 = getListView();
        r5.setItemAnimator(null);
        r5.setPadding(0, getResources().getDimensionPixelSize(R.dimen.main_settings_first_item_card_gap), 0, getResources().getDimensionPixelSize(R.dimen.settings_container_bottom_padding));
        r5.setClipChildren(false);
        initHeaderView();
        initFooterView();
    }

    private Drawable getSmilingCloudIcon() {
        return getActivity().getPackageManager().getApplicationIcon("com.bytedanceos.cloudsync");
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private void initHeaderView() {
        getActivity();
    }

    private void initFooterView() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        View r1 = LayoutInflater.from(r0).inflate(R.layout.bytedance_cloud_service_entry_layout, null);
        OCardListItem r2 = (OCardListItem) r1.findViewById(R.id.bytedance_cloud_service);
        r2.setTitle(getString(R.string.cloud_setting_title));
        r2.setAppIcon(getSmilingCloudIcon());
        r2.setOnContentClickListener(new AnonymousClass1(this));
        if (SettingsFeature.isSmilingCloudAvailable(r0) == true) goto L8;
        r2.setVisibility(8);
    L8:
        SectionLayoutPreference r3 = new SectionLayoutPreference(this.mContext, r1);
        this.mFooterPreference = r3;
        r3.setOrder(10000);
        this.mFooterPreference.setSelectable(false);
        getPreferenceScreen().addPreference(this.mFooterPreference);
    }

    private void onAuthDescriptionsUpdated() {
        this.mAuthDescs = AccountManager.get(this.mContext).getAuthenticatorTypes();
        this.mTypeList.clear();
        int r1 = 0;
    L3:
        AuthenticatorDescription[] r2 = this.mAuthDescs;
        if (r1 >= r2.length) goto L21;
        String r3 = r2[r1].type;
        if (ManageAccountsSettingsActivity.BYTEDANCE_ACCOUNT_TYPE.equals(r3) == false) goto L8;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L20;
        this.mTypeList.add(r3);
    L20:
        r1 = r1 + 1;
        goto L3
    L8:
        if (ManageAccountsSettingsActivity.BYTEDANCE_MOVER_TYPE.equals(r3) == true) goto L17;
        if (r3.equals("com.android.sim") == true) goto L17;
        if (r3.equals("com.android.localphone") == true) goto L17;
        if (r3.equals("se.dirac.account") == true) goto L17;
        r4 = true;
        goto L18
    }

    public Intent createAddWritableAccountIntent() {
        onAuthDescriptionsUpdated();
        ArrayList r1 = new ArrayList();
        ArrayList<String> r8 = this.mTypeList;
        return AccountManager.newChooseAccountIntent(null, r1, (String[]) r8.toArray(new String[r8.size()]), false, null, null, null, null);
    }

    public void com_android_settings_accounts_AccountSettings__onResume$___twin___() {
        super.onResume();
        OLog.d(TAG, "onResume");
        updateUi();
        this.mManagedProfileBroadcastReceiver.register(getActivity());
        listenToAccountUpdates();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        stopListeningToAccountUpdates();
        this.mManagedProfileBroadcastReceiver.unregister(getActivity());
        cleanUpPreferences();
    }

    @Override // com.android.settingslib.accounts.AuthenticatorHelper.OnAccountsUpdateListener
    public void onAccountsUpdate(UserHandle r3) {
        if (r3.getIdentifier() != 10) goto L6;
        return;
    L6:
        if (this.mProfiles.get(r3.getIdentifier()) == null) goto L8;
        OLog.d(TAG, "onAccountsUpdate");
        updateUi();
        return;
    L8:
        OLog.w(TAG, "Missing Settings screen for: " + r3.getIdentifier());
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r8) {
        int r0 = this.mProfiles.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L17;
        ProfileData r3 = this.mProfiles.valueAt(r2);
        if (r8 == r3.addAccountPreference) goto L6;
        if (r8 == r3.managedProfilePreference) goto L10;
        if (r8 == r3.removeWorkProfilePreference) goto L14;
        r2 = r2 + 1;
        goto L3
    L14:
        final int r9 = r3.userInfo.id;
        UserDialogs.createRemoveDialog(getActivity(), r9, new AnonymousClass2(this, r9)).show();
        return true;
    L10:
        Intent r1 = new Intent(r8.getContext(), Settings.ManagedProfileSettingsActivity.class);
        r1.putExtra("android.intent.extra.USER", r3.userInfo.getUserHandle());
        startActivity(r1);
        return true;
    L6:
        Intent r10 = new Intent(ADD_ACCOUNT_ACTION);
        r10.putExtra("android.intent.extra.USER", r3.userInfo.getUserHandle());
        r10.putExtra(AccountPreferenceBase.AUTHORITIES_FILTER_KEY, this.mAuthorities);
        Utils.startActivity(getActivity(), r10);
        return true;
    L17:
        return false;
    }

    void updateUi() {
        OLog.d(TAG, "updateUi");
        if (Utils.isManagedProfile(this.mUm) == false) goto L6;
        OLog.e(TAG, "We should not be showing settings for a managed profile");
        finish();
        return;
    L6:
        PreferenceScreen r0 = (PreferenceScreen) findPreference("account");
        int r2 = 0;
        if (this.mUm.isLinkedUser() == false) goto L11;
        UserInfo r1 = this.mUm.getUserInfo(UserHandle.myUserId());
        if (r1 == null) goto L33;
        updateProfileUi(r1, false, r0);
    L33:
        removeItemPreferences(r0);
        int r3 = this.mProfiles.size();
    L34:
        if (r2 >= r3) goto L49;
        ProfileData r4 = this.mProfiles.valueAt(r2);
        if (r4 == null) goto L48;
        if (r4.preferenceGroup != null) goto L40;
    L42:
        addAutoSyncPreferenceIfNeeded(r4);
        updateAccountTypesAsync(r4);
        if (r4.managedProfilePreference == null) goto L46;
        r4.preferenceGroup.addPreference(r4.managedProfilePreference);
    L46:
        if (r4.removeWorkProfilePreference == null) goto L48;
        r4.preferenceGroup.addPreference(r4.removeWorkProfilePreference);
        goto L48
    L40:
        if (r4.preferenceGroup.equals(r0) == true) goto L42;
        r0.addPreference(r4.preferenceGroup);
    L48:
        r2 = r2 + 1;
        goto L34
    L49:
        return;
    L11:
        List r5 = this.mUm.getProfiles(UserHandle.myUserId());
        int r6 = r5.size();
        Iterator r7 = r5.iterator();
        boolean r8 = false;
    L13:
        if (r7.hasNext() == false) goto L22;
        UserInfo r9 = (UserInfo) r7.next();
        if (r9.id != 0) goto L17;
    L20:
        r8 = true;
    L21:
        if (r8 == true) goto L13;
    L17:
        if (r9.id == 10) goto L20;
        r8 = false;
    L22:
        if (r6 <= 1) goto L24;
        boolean r10 = true;
    L25:
        int r11 = 0;
    L26:
        if (r11 >= r6) goto L33;
        UserInfo r12 = (UserInfo) r5.get(r11);
        if (r10 == false) goto L31;
        if (r8 == true) goto L31;
        boolean r13 = true;
    L32:
        updateProfileUi(r12, r13, r0);
        r11 = r11 + 1;
    L31:
        r13 = false;
        goto L32
    L24:
        r10 = false;
        goto L25
    }

    private void removeItemPreferences(PreferenceScreen r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.removeAll();
        SectionLayoutPreference r0 = this.mHeaderPreference;
        if (r0 == null) goto L7;
        r2.addPreference(r0);
    L7:
        SectionLayoutPreference r1 = this.mFooterPreference;
        if (r1 == null) goto L11;
        r2.addPreference(r1);
        return;
    }

    private void updateProfileUi(UserInfo r6, boolean r7, PreferenceScreen r8) {
        Context r0 = this.mContext;
        ProfileData r1 = new ProfileData(null);
        r1.userInfo = r6;
        if (r7 == false) goto L9;
        r1.preferenceGroup = new AccessiblePreferenceCategory(r0);
        if (r6.isManagedProfile() == false) goto L7;
        r1.preferenceGroup.setLayoutResource(R.layout.work_profile_category);
        r1.preferenceGroup.setTitle(R.string.category_work);
        String r9 = getWorkGroupSummary(r0, r6);
        r1.preferenceGroup.setSummary(r9);
        ((AccessiblePreferenceCategory) r1.preferenceGroup).setContentDescription(getString(R.string.accessibility_category_work, new Object[]{r9}));
        r1.managedProfilePreference = newManagedProfilePreference(r0, r6.getUserHandle());
        r1.removeWorkProfilePreference = newRemoveWorkProfilePreference(r0);
    L8:
        r8.addPreference(r1.preferenceGroup);
    L11:
        if (r6.isEnabled() == false) goto L13;
        r1.authenticatorHelper = new AuthenticatorHelper(r0, r6.getUserHandle(), this);
    L13:
        this.mProfiles.put(r6.id, r1);
        return;
    L7:
        r1.preferenceGroup.setLayoutResource(R.layout.work_profile_category);
        r1.preferenceGroup.setTitle(R.string.category_personal);
        ((AccessiblePreferenceCategory) r1.preferenceGroup).setContentDescription(getString(R.string.accessibility_category_personal));
        goto L8
    L9:
        r1.preferenceGroup = r8;
        goto L11
    }

    private void addAutoSyncPreferenceIfNeeded(ProfileData r4) {
        if (this.mAccountAutoSyncItem != null) goto L6;
        this.mAccountAutoSyncItem = (IAccountAutoSyncItem) ServiceManager.getService(IAccountAutoSyncItem.class);
    L6:
        if (this.mAccountAutoSyncItem == null) goto L24;
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.preferenceGroup != null) goto L11;
        return;
    L11:
        if (r4.userInfo != null) goto L14;
        return;
    L14:
        if (r4.userInfo.id != 10) goto L16;
        return;
    L16:
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L19;
        return;
    L19:
        View r3 = this.mAccountAutoSyncItem.create(r0, r4.userInfo.getUserHandle(), r4.userInfo.isManagedProfile());
        if (r3 != null) goto L22;
        return;
    L22:
        SectionLayoutPreference r1 = new SectionLayoutPreference(r0, r3);
        r1.setOrder(1000);
        r1.setSelectable(false);
        r4.preferenceGroup.addPreference(r1);
        return;
    }

    private Preference newAddAccountPreference(Context r2) {
        Preference r0 = new Preference(r2);
        r0.setTitle(R.string.add_account_label);
        r0.setOnPreferenceClickListener(this);
        r0.setOrder(1000);
        return r0;
    }

    private Preference newRemoveWorkProfilePreference(Context r2) {
        Preference r0 = new Preference(r2);
        r0.setTitle(R.string.remove_managed_profile_label);
        r0.setOnPreferenceClickListener(this);
        r0.setOrder(1001);
        return r0;
    }

    private Preference newManagedProfilePreference(Context r1, UserHandle r2) {
        Preference r3 = new Preference(r1);
        r3.setTitle(R.string.managed_profile_settings_title);
        r3.setOnPreferenceClickListener(this);
        r3.setOrder(1001);
        return r3;
    }

    private String getWorkGroupSummary(Context r2, UserInfo r3) {
        PackageManager r0 = r2.getPackageManager();
        ApplicationInfo r4 = Utils.getAdminApplicationInfo(r2, r3.id);
        if (r4 != null) goto L7;
        return null;
    L7:
        return getString(R.string.managing_admin, new Object[]{r0.getApplicationLabel(r4)});
    }

    private void cleanUpPreferences() {
        this.mProfiles.clear();
    }

    private void listenToAccountUpdates() {
        int r0 = this.mProfiles.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        AuthenticatorHelper r2 = this.mProfiles.valueAt(r1).authenticatorHelper;
        if (r2 == null) goto L7;
        r2.listenToAccountUpdates();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    private void stopListeningToAccountUpdates() {
        int r0 = this.mProfiles.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        AuthenticatorHelper r2 = this.mProfiles.valueAt(r1).authenticatorHelper;
        if (r2 == null) goto L7;
        r2.stopListeningToAccountUpdates();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    private void updateAccountTypesAsync(ProfileData r3) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (getActivity() != null) goto L8;
        return;
    L8:
        if (r3.authenticatorHelper != null) goto L10;
        return;
    L10:
        ArrayList<AccountPreference> r2 = getAccountTypePreferences(r3.authenticatorHelper, r3.userInfo.getUserHandle());
        EventBus.getDefault().post(new AccountPreferenceListGotEvent(r3, r2));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(AccountPreferenceListGotEvent r1) {
        updateAccountTypes(r1);
    }

    private void updateAccountTypes(AccountPreferenceListGotEvent r5) {
        ProfileData r0 = r5.profileData;
        int r2 = 0;
        if (r0.userInfo.isEnabled() == false) goto L11;
        ArrayList<AccountPreference> r4 = r5.accountPreferences;
        OLog.d(TAG, "getAccountTypePreferences " + r4.size());
        int r6 = r4.size();
        if (r6 != 1) goto L7;
        r4.get(0).setBackgroundStyle(1);
    L9:
        if (r2 >= r6) goto L15;
        r0.preferenceGroup.addPreference(r4.get(r2));
        r2 = r2 + 1;
        goto L9
    L15:
        return;
    L7:
        if (r6 <= 1) goto L9;
        r4.get(0).setBackgroundStyle(2);
        r4.get(r6 - 1).setBackgroundStyle(4);
        goto L9
    L11:
        this.mProfileNotAvailablePreference.setEnabled(false);
        this.mProfileNotAvailablePreference.setIcon(R.drawable.empty_icon);
        this.mProfileNotAvailablePreference.setTitle(null);
        this.mProfileNotAvailablePreference.setSummary(R.string.managed_profile_not_available_label);
        r0.preferenceGroup.addPreference(this.mProfileNotAvailablePreference);
    }

    private ArrayList<AccountPreference> getAccountTypePreferences(AuthenticatorHelper r14, UserHandle r15) {
        String[] r0 = r14.getEnabledAccountTypes();
        ArrayList<AccountPreference> r1 = new ArrayList(r0.length);
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r0.length) goto L30;
        String r4 = r0[r3];
        if (ManageAccountsSettingsActivity.BYTEDANCE_ACCOUNT_TYPE.equals(r4) == true) goto L29;
        if (ManageAccountsSettingsActivity.BYTEDANCE_MOVER_TYPE.equals(r4) == true) goto L29;
        if ("se.dirac.account".equals(r4) == true) goto L29;
        if (accountTypeHasAnyRequestedAuthorities(r14, r4) == false) goto L29;
        CharSequence r9 = r14.getLabelForType(this.mContext, r4);
        if (r9 == null) goto L29;
        Account[] r5 = AccountManager.get(this.mContext).getAccountsByTypeAsUser(r4, r15);
        boolean r7 = true;
        if (r5.length == 1) goto L21;
    L23:
        r7 = false;
    L25:
        if (r7 == false) goto L27;
        Bundle r11 = new Bundle();
        r11.putParcelable("account", r5[0]);
        r11.putParcelable("android.intent.extra.USER", r15);
        r11.putString(ManageAccountsSettings.KEY_ACCOUNT_TYPE, r4);
        r1.add(new AccountPreference(this, getActivity(), r9, AccountSyncSettings.class.getName(), r11, ObricIconUtils.getDrawable(r14.getPackageForType(r4))));
    L28:
        r14.preloadDrawableForType(this.mContext, r4);
        goto L29
    L27:
        Bundle r12 = new Bundle();
        r12.putString(ManageAccountsSettings.KEY_ACCOUNT_TYPE, r4);
        r12.putString(ManageAccountsSettings.KEY_ACCOUNT_LABEL, r9.toString());
        r12.putParcelable("android.intent.extra.USER", r15);
        r1.add(new AccountPreference(this, this.mContext, r9, ManageAccountsSettings.class.getName(), r12, ObricIconUtils.getDrawable(r14.getPackageForType(r4))));
        goto L28
    L21:
        if (r14.hasAccountPreferences(r4) == true) goto L23;
    L29:
        r3 = r3 + 1;
        goto L4
    L30:
        Collections.sort(r1, new AnonymousClass3(this));
        int r13 = r1.size();
    L31:
        if (r2 >= r13) goto L33;
        r1.get(r2).setPosition(r2, r13);
        r2 = r2 + 1;
        goto L31
    L33:
        return r1;
    }

    private boolean accountTypeHasAnyRequestedAuthorities(AuthenticatorHelper r4, String r5) {
        if (this.mAuthoritiesCount != 0) goto L5;
        return true;
    L5:
        ArrayList<String> r6 = r4.getAuthoritiesForAccountType(r5);
        if (r6 != null) goto L9;
        OLog.d(TAG, "No sync authorities for account type: " + r5);
        return false;
    L9:
        int r7 = 0;
    L11:
        if (r7 >= this.mAuthoritiesCount) goto L16;
        if (r6.contains(this.mAuthorities[r7]) == true) goto L14;
        r7 = r7 + 1;
        goto L11
    L14:
        return true;
    L16:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accounts_AccountSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AccountSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accounts_AccountSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accounts_AccountSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AccountSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accounts_AccountSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accounts_AccountSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AccountSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accounts_AccountSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
