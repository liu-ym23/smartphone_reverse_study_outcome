package com.android.settings.accounts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SyncAdapterType;
import android.content.SyncInfo;
import android.content.SyncStatusInfo;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import bytedanceos.util.NavigationBarHelper;
import com.android.settings.AccountPreference;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.Utils;
import com.android.settings.location.LocationSettings;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.wifi.preference.SectionLayoutPreference;
import com.android.settingslib.accounts.AuthenticatorHelper;
import com.bytedance.android.standard.tools.ui.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItemPositionHelper;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ManageAccountsSettings extends AccountPreferenceBase implements AuthenticatorHelper.OnAccountsUpdateListener, Preference.OnPreferenceClickListener {
    private static final String ACCOUNT_KEY = "account";
    public static final String KEY_ACCOUNT_LABEL = "account_label";
    public static final String KEY_ACCOUNT_TYPE = "account_type";
    private static final String LAUNCHING_LOCATION_SETTINGS = "com.android.settings.accounts.LAUNCHING_LOCATION_SETTINGS";
    private static final int MENU_SYNC_CANCEL_ID = 2;
    private static final int MENU_SYNC_NOW_ID = 1;
    private static final int ORDER_FOOTER = 10000;
    private static final int REQUEST_SHOW_SYNC_SETTINGS = 1;
    private LayoutInflater inflater;
    private String mAccountType;
    private LinearLayout mAuthenticatorContainer;
    private String[] mAuthorities;
    private ViewGroup mContainer;
    private Context mContext;
    private TextView mErrorInfoView;
    private Account mFirstAccount;
    private SectionLayoutPreference mFooterPreference;
    private OButton mSyncBtn;

    private class FragmentStarter implements Preference.OnPreferenceClickListener {
        private final String mClass;
        private final int mTitleRes;
        final /* synthetic */ ManageAccountsSettings this$0;

        public FragmentStarter(ManageAccountsSettings r1, String r2, int r3) {
            this.this$0 = r1;
            this.mClass = r2;
            this.mTitleRes = r3;
        }

        @Override // androidx.preference.Preference.OnPreferenceClickListener
        public boolean onPreferenceClick(Preference r8) {
            Fragment r9 = (Fragment) null;
            ((SettingsActivity) this.this$0.getActivity()).startPreferencePanel(this.mClass, null, this.mTitleRes, null, null, 0);
            if (this.mClass.equals(LocationSettings.class.getName()) == false) goto L7;
            Intent r10 = new Intent(ManageAccountsSettings.LAUNCHING_LOCATION_SETTINGS);
            this.this$0.getActivity().sendBroadcast(r10, "android.permission.WRITE_SECURE_SETTINGS");
            return true;
        L7:
            return true;
        }
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase, com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accounts_ManageAccountsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase, com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onResume() {
        com_android_settings_accounts_ManageAccountsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ManageAccountsSettings() {
    }

    static /* synthetic */ void access$000(ManageAccountsSettings r0, boolean r1) {
        r0.requestOrCancelSyncForAccounts(r1);
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase
    public /* bridge */ /* synthetic */ PreferenceScreen addPreferencesForType(String r1, PreferenceScreen r2) {
        return super.addPreferencesForType(r1, r2);
    }

    public /* bridge */ /* synthetic */ void com_android_settings_accounts_ManageAccountsSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase
    public /* bridge */ /* synthetic */ ArrayList getAuthoritiesForAccountType(String r1) {
        return super.getAuthoritiesForAccountType(r1);
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase, com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase
    public /* bridge */ /* synthetic */ void updateAuthDescriptions() {
        super.updateAuthDescriptions();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r1) {
        super.onAttach(r1);
        this.mContext = r1;
    }

    public void com_android_settings_accounts_ManageAccountsSettings__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getActivity().getIntent().getExtras();
        if (r4 != null) goto L5;
    L7:
        setHasOptionsMenu(false);
        this.inflater = LayoutInflater.from(getActivity());
        return;
    L5:
        if (r4.containsKey(KEY_ACCOUNT_TYPE) == false) goto L7;
        this.mAccountType = r4.getString(KEY_ACCOUNT_TYPE);
        goto L7
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
        super.onCreatePreferences(r1, r2);
        addPreferencesFromResource(R.xml.manage_accounts_settings);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mAuthenticatorHelper.listenToAccountUpdates();
        updateAuthDescriptions();
        showAccountsIfNeeded();
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        this.mContainer = r2;
        View r4 = super.onCreateView(r1, r2, r3);
        initErrorInfoTv(r4);
        return r4;
    }

    private void initErrorInfoTv(View r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        LinearLayout r7 = (LinearLayout) r6.findViewById(R.id.container_material);
        TextView r0 = new TextView(this.mContext);
        r0.setId(R.id.sync_settings_error_info);
        ViewGroup.MarginLayoutParams r1 = new ViewGroup.MarginLayoutParams(-1, -2);
        int r2 = (int) UIUtils.dip2Px(this.mContext, 8.0f);
        r1.setMargins(r2, r2, r2, r2);
        r0.setLayoutParams(r1);
        Drawable r3 = ContextCompat.getDrawable(this.mContext, R.drawable.ic_sync_red_holo);
        int r4 = (int) UIUtils.dip2Px(this.mContext, 22.0f);
        r3.setBounds(0, 0, r4, r4);
        r0.setCompoundDrawablesRelative(r3, null, null, null);
        r0.setCompoundDrawablePadding(r2);
        r0.setText(R.string.sync_is_failing);
        r0.setTextColor(ContextCompat.getColor(this.mContext, R.color.oui_text_3));
        r7.addView(r0);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        FragmentActivity r6 = getActivity();
        TextView r0 = (TextView) r4.findViewById(R.id.sync_settings_error_info);
        this.mErrorInfoView = r0;
        r0.setVisibility(8);
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(this.mErrorInfoView);
        this.mAuthorities = r6.getIntent().getStringArrayExtra(AccountPreferenceBase.AUTHORITIES_FILTER_KEY);
        Bundle r7 = getActivity().getIntent().getExtras();
        if (r7 != null) goto L5;
    L7:
        RecyclerView r8 = getListView();
        r8.setItemAnimator(null);
        Utils.prepareCustomPreferencesList(this.mContainer, r4, r8, false);
        r8.setPadding(0, getResources().getDimensionPixelSize(R.dimen.main_settings_first_item_card_gap), 0, getResources().getDimensionPixelSize(R.dimen.settings_container_bottom_padding));
        initAuthenticatorSettingsBottomView();
        return;
    L5:
        if (r7.containsKey(KEY_ACCOUNT_LABEL) == false) goto L7;
        getActivity().setTitle(r7.getString(KEY_ACCOUNT_LABEL));
        goto L7
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mAuthenticatorHelper.stopListeningToAccountUpdates();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r2) {
        if ((r2 instanceof AccountPreference) == false) goto L7;
        startAccountSettings((AccountPreference) r2);
        return true;
    L7:
        return super.onPreferenceTreeClick(r2);
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r2) {
        if ((r2 instanceof AccountPreference) == false) goto L6;
        startAccountSettings((AccountPreference) r2);
        return true;
    L6:
        return false;
    }

    private void startAccountSettings(AccountPreference r4) {
        Bundle r0 = new Bundle();
        r0.putParcelable("account", r4.getAccount());
        r0.putParcelable("android.intent.extra.USER", this.mUserHandle);
        r0.putString("back_text", getActivity().getIntent().getExtras().getString(KEY_ACCOUNT_LABEL));
        r0.putString("title", r4.getAccount().name);
        Intent r5 = new Intent(getActivity(), AccountSyncSettingsActivity.class);
        r5.putExtras(r0);
        Utils.startActivity(getActivity(), r5);
    }

    private void initAuthenticatorSettingsBottomView() {
        View r0 = this.inflater.inflate(R.layout.authenticator_settings_layout, null);
        this.mAuthenticatorContainer = (LinearLayout) r0.findViewById(R.id.authenticator_container);
        OButton r1 = (OButton) r0.findViewById(R.id.sync_btn);
        this.mSyncBtn = r1;
        r1.setOnClickListener(new AnonymousClass1(this));
        new OCardListItemPositionHelper((FrameLayout) r0.findViewById(R.id.btnLayout), true, getContext().getColor(R.color.oui_fill_list_item_card), 3).setCardPosition(3);
        SectionLayoutPreference r2 = new SectionLayoutPreference(this.mContext, r0);
        this.mFooterPreference = r2;
        r2.setSelectable(false);
        this.mFooterPreference.setOrder(10000);
        getPreferenceScreen().addPreference(this.mFooterPreference);
    }

    private void requestOrCancelSyncForAccounts(boolean r12) {
        int r0 = this.mUserHandle.getIdentifier();
        SyncAdapterType[] r1 = ContentResolver.getSyncAdapterTypesAsUser(r0);
        Bundle r2 = new Bundle();
        r2.putBoolean("force", true);
        r2.putBoolean("sync_extras_user_click", true);
        int r3 = getPreferenceScreen().getPreferenceCount();
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L18;
        Preference r6 = getPreferenceScreen().getPreference(r5);
        if ((r6 instanceof AccountPreference) == false) goto L17;
        Account r7 = ((AccountPreference) r6).getAccount();
        int r8 = 0;
    L8:
        if (r8 >= r1.length) goto L17;
        SyncAdapterType r9 = r1[r8];
        if (r9.accountType.equals(this.mAccountType) == false) goto L16;
        if (ContentResolver.getSyncAutomaticallyAsUser(r7, r9.authority, r0) == false) goto L16;
        if (r12 == false) goto L15;
        ContentResolver.requestSyncAsUser(r7, r9.authority, r0, r2);
        goto L16
    L15:
        ContentResolver.cancelSyncAsUser(r7, r9.authority, r0);
    L16:
        r8 = r8 + 1;
    L17:
        r5 = r5 + 1;
        goto L3
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase
    protected void onSyncStateUpdated() {
        showSyncState();
    }

    private void showSyncState() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        int r1 = this.mUserHandle.getIdentifier();
        List<SyncInfo> r2 = ContentResolver.getCurrentSyncsAsUser(r1);
        Date r3 = new Date();
        SyncAdapterType[] r4 = ContentResolver.getSyncAdapterTypesAsUser(r1);
        HashSet r5 = new HashSet();
        int r6 = r4.length;
        int r8 = 0;
    L6:
        if (r8 >= r6) goto L11;
        SyncAdapterType r9 = r4[r8];
        if (r9.isUserVisible() == false) goto L10;
        r5.add(r9.authority);
    L10:
        r8 = r8 + 1;
        goto L6
    L11:
        int r7 = getPreferenceScreen().getPreferenceCount();
        int r10 = 0;
        boolean r11 = false;
        boolean r12 = false;
    L12:
        if (r10 >= r7) goto L69;
        Preference r13 = getPreferenceScreen().getPreference(r10);
        if ((r13 instanceof AccountPreference) == true) goto L17;
        int r25 = r1;
        List<SyncInfo> r26 = r2;
    L68:
        r10 = r10 + 1;
        r1 = r25;
        r2 = r26;
        goto L12
    L17:
        AccountPreference r14 = (AccountPreference) r13;
        Account r15 = r14.getAccount();
        ArrayList<String> r16 = r14.getAuthorities();
        if (r16 == null) goto L48;
        Iterator<String> r17 = r16.iterator();
        long r19 = 0;
        int r18 = 0;
        boolean r110 = false;
        boolean r111 = false;
    L21:
        if (r17.hasNext() == false) goto L47;
        String r112 = r17.next();
        SyncStatusInfo r20 = ContentResolver.getSyncStatusAsUser(r15, r112, r1);
        boolean r22 = isSyncEnabled(r1, r15, r112);
        boolean r23 = ContentResolver.isSyncPending(r15, r112);
        boolean r24 = isSyncing(r2, r15, r112);
        if (r20 == null) goto L30;
        if (r22 == false) goto L30;
        int r27 = r1;
        List<SyncInfo> r28 = r2;
        if (r20.lastFailureTime != 0) goto L28;
    L31:
        boolean r21 = false;
    L32:
        if (r21 == false) goto L36;
        if (r24 == true) goto L36;
        if (r23 == true) goto L36;
        r11 = true;
        r110 = true;
    L36:
        r111 = r111 | r24;
        if (r20 != null) goto L39;
    L41:
        if (r22 == true) goto L43;
    L45:
        int r29 = 0;
    L46:
        r18 = r18 + r29;
        r1 = r27;
        r2 = r28;
        goto L21
    L43:
        if (r5.contains(r112) == false) goto L45;
        r29 = 1;
        goto L46
    L39:
        if (r19 >= r20.lastSuccessTime) goto L41;
        r19 = r20.lastSuccessTime;
        goto L41
    L28:
        if (r20.getLastFailureMesgAsInt(0) == 1) goto L31;
        r21 = true;
    L30:
        r27 = r1;
        r28 = r2;
        goto L31
    L47:
        r25 = r1;
        r26 = r2;
        long r30 = r19;
    L52:
        if (r18 <= 0) goto L54;
        boolean r31 = true;
    L55:
        r12 = r12 | r31;
        if (r110 == false) goto L59;
        r14.setSyncStatus(2, true);
        goto L68
    L59:
        if (r18 != 0) goto L61;
        r14.setSyncStatus(1, true);
        goto L68
    L61:
        if (r18 <= 0) goto L67;
        if (r111 == false) goto L64;
        r14.setSyncStatus(3, true);
        goto L68
    L64:
        r14.setSyncStatus(0, true);
        if (r30 <= 0) goto L68;
        r14.setSyncStatus(0, false);
        r3.setTime(r30);
        r14.setSummary(getResources().getString(R.string.last_synced, new Object[]{formatSyncDate(r3)}));
        AccountSyncSettings.notifyCalendarAccountSynced(getActivity(), r15);
        goto L68
    L67:
        r14.setSyncStatus(1, true);
        goto L68
    L54:
        r31 = false;
        goto L55
    L48:
        r25 = r1;
        r26 = r2;
        if (Log.isLoggable(AccountSettings.TAG, 2) == false) goto L51;
        OLog.v(AccountSettings.TAG, "no syncadapters found for " + r15);
    L51:
        r30 = 0;
        r18 = 0;
        r110 = false;
        r111 = false;
        goto L52
    L69:
        int r32 = 0;
        TextView r33 = this.mErrorInfoView;
        if (r11 == true) goto L73;
        r32 = 8;
    L73:
        r33.setVisibility(r32);
        this.mSyncBtn.setEnabled(r12);
    }

    private boolean isSyncing(List<SyncInfo> r5, Account r6, String r7) {
        int r4 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L11;
        SyncInfo r2 = r5.get(r1);
        if (r2.account.equals(r6) == false) goto L10;
        if (r2.authority.equals(r7) == false) goto L10;
        return true;
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        return false;
    }

    private boolean isSyncEnabled(int r1, Account r2, String r3) {
        if (ContentResolver.getSyncAutomaticallyAsUser(r2, r3, r1) == true) goto L5;
    L9:
        return false;
    L5:
        if (ContentResolver.getMasterSyncAutomaticallyAsUser(r1) == false) goto L9;
        if (ContentResolver.getIsSyncableAsUser(r2, r3, r1) <= 0) goto L9;
        return true;
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase, com.android.settingslib.accounts.AuthenticatorHelper.OnAccountsUpdateListener
    public void onAccountsUpdate(UserHandle r1) {
        showAccountsIfNeeded();
        onSyncStateUpdated();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        showAccountsIfNeeded();
    }

    private void showAccountsIfNeeded() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        Account[] r0 = AccountManager.get(getActivity()).getAccountsAsUser(this.mUserHandle.getIdentifier());
        removeItemPreferences(getPreferenceScreen());
        this.mFirstAccount = null;
        int r1 = r0.length;
        int r3 = 0;
        int r11 = 0;
    L6:
        if (r3 >= r1) goto L28;
        Account r12 = r0[r3];
        if (this.mAccountType != null) goto L10;
    L12:
        ArrayList r8 = getAuthoritiesForAccountType(r12.type);
        String[] r4 = this.mAuthorities;
        boolean r5 = true;
        if (r4 == null) goto L22;
        if (r8 == null) goto L22;
        int r6 = r4.length;
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L21;
        if (r8.contains(r4[r7]) == true) goto L22;
        r7 = r7 + 1;
        goto L16
    L21:
        r5 = false;
    L22:
        if (r5 == false) goto L26;
        AccountPreference r13 = new AccountPreference(getActivity(), r12, getDrawableForType(r12.type), r8, true, r11);
        r13.setOnPreferenceClickListener(this);
        getPreferenceScreen().addPreference(r13);
        r11 = r11 + 1;
        if (this.mFirstAccount != null) goto L26;
        this.mFirstAccount = r12;
        getActivity().invalidateOptionsMenu();
    L26:
        r3 = r3 + 1;
        goto L6
    L10:
        if (r12.type.equals(this.mAccountType) == true) goto L12;
    L28:
        if (this.mAccountType != null) goto L30;
    L32:
        getActivity().finish();
        return;
    L30:
        if (this.mFirstAccount == null) goto L32;
        addAuthenticatorSettings();
    }

    private void removeItemPreferences(PreferenceScreen r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.removeAll();
        SectionLayoutPreference r0 = this.mFooterPreference;
        if (r0 == null) goto L8;
        r1.addPreference(r0);
        return;
    }

    private void addAuthenticatorSettings() {
        PreferenceScreen r0 = addPreferencesForType(this.mAccountType, getPreferenceScreen());
        if (r0 == null) goto L6;
        updatePreferenceIntents(r0);
        return;
    }

    private void updatePreferenceIntents(PreferenceGroup r8) {
        PackageManager r0 = getActivity().getPackageManager();
        this.mAuthenticatorContainer.removeAllViews();
        int r1 = 0;
    L4:
        if (r1 >= r8.getPreferenceCount()) goto L20;
        Preference r2 = r8.getPreference(r1);
        if ((r2 instanceof PreferenceGroup) == false) goto L8;
        updatePreferenceIntents((PreferenceGroup) r2);
    L8:
        final Intent r3 = r2.getIntent();
        if (r3 == null) goto L19;
        if (r3.getAction().equals("android.settings.LOCATION_SOURCE_SETTINGS") == true) goto L19;
        if (r0.resolveActivityAsUser(r3, 65536, this.mUserHandle.getIdentifier()) == null) goto L15;
        if ("com.google.android.gms.settings.ADS_PRIVACY".equals(r3.getAction()) == true) goto L19;
        r3.putExtra("account", this.mFirstAccount);
        r3.setFlags(r3.getFlags() | 268435456);
        OLog.d(AccountSettings.TAG, "btn intent:" + r3);
        OListItemSettings r4 = new OListItemSettings(getActivity(), null);
        r4.setTitleString(r2.getTitle());
        r4.setOnClickListener(new AnonymousClass2(this, r3));
        this.mAuthenticatorContainer.addView(r4);
        goto L19
    L15:
        r8.removePreference(r2);
    L19:
        r1 = r1 + 1;
        goto L4
    }

    private boolean isSafeIntent(PackageManager r7, Intent r8) {
        AuthenticatorDescription r0 = this.mAuthenticatorHelper.getAccountTypeDescription(this.mAccountType);
        ResolveInfo r6 = r7.resolveActivityAsUser(r8, 0, this.mUserHandle.getIdentifier());
        if (r6 != null) goto L5;
        return false;
    L5:
        ActivityInfo r9 = r6.activityInfo;
        ApplicationInfo r2 = r9.applicationInfo;
    L19:
        e = move-exception;
        OLog.e(AccountSettings.TAG, "Intent considered unsafe due to exception.", e);
        return false;
    L7:
        if (r9.exported == true) goto L9;
    L14:
        ApplicationInfo r10 = r7.getApplicationInfo(r0.packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L19
        if (r2.uid != r10.uid) goto L18;
        r8.setComponent(r9.getComponentName());     // Catch: PackageManager.NameNotFoundException -> L19
        return true;
    L18:
        return false;
    L9:
        if (r9.permission != null) goto L12;
        return true;
    L12:
        if (r7.checkPermission(r9.permission, r0.packageName) != 0) goto L14;
        return true;
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase
    protected void onAuthDescriptionsUpdated() {
        int r0 = 0;
    L4:
        if (r0 >= getPreferenceScreen().getPreferenceCount()) goto L9;
        Preference r1 = getPreferenceScreen().getPreference(r0);
        if ((r1 instanceof AccountPreference) == false) goto L8;
        AccountPreference r2 = (AccountPreference) r1;
        r2.setSummary(getLabelForType(r2.getAccount().type));
    L8:
        r0 = r0 + 1;
        goto L4
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accounts_ManageAccountsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ManageAccountsSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accounts_ManageAccountsSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accounts_ManageAccountsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ManageAccountsSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accounts_ManageAccountsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accounts_ManageAccountsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ManageAccountsSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accounts_ManageAccountsSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
