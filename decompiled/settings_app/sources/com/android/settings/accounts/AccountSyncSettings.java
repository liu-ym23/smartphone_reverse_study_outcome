package com.android.settings.accounts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SyncAdapterType;
import android.content.SyncInfo;
import android.content.SyncStatusInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.UserInfo;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceScreen;
import com.android.settings.R;
import com.android.settings.StorageLowState;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.google.android.collect.Lists;
import com.obric.olog.OLog;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalVertical;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.divider.ODivider;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OCardListItemPositionHelper;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.utils.StyleUtil;
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
public class AccountSyncSettings extends AccountPreferenceBase implements View.OnClickListener {
    public static final String ACCOUNT_KEY = "account";
    private static final String CALENDAR_AUTHORITY = "com.android.calendar";
    private static final int CANT_DO_ONETIME_SYNC_DIALOG = 102;
    private static final int FAILED_REMOVAL_DIALOG = 101;
    private static final int MENU_REMOVE_ACCOUNT_ID = 3;
    private static final int MENU_SYNC_CANCEL_ID = 2;
    private static final int MENU_SYNC_NOW_ID = 1;
    private static final int REALLY_REMOVE_DIALOG = 100;
    static final String SYNC_EXTRAS_USER_CLICK = "sync_extras_user_click";
    private Account mAccount;
    private AccountItemAdapter mAccountItemAdapter;
    private OBottomActionBarNormalVertical mBottomActionBar;
    private OButton mBtnDelete;
    private ArrayList<SyncStateCheckBoxPreference> mCheckBoxes;
    private TextView mErrorInfoView;
    private ArrayList<SyncAdapterType> mInvisibleAdapters;
    private ListView mList;

    private class AccountItemAdapter extends BaseAdapter {
        private boolean showSyncBtn;
        final /* synthetic */ AccountSyncSettings this$0;

        class ViewHolder {
            OButton buttonSync;
            OCardListItem item;
            OSwitch oSwitch;
            final /* synthetic */ AccountItemAdapter this$1;

            ViewHolder(AccountItemAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private AccountItemAdapter(AccountSyncSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AccountItemAdapter(AccountSyncSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void setShowSyncBtn(boolean r1) {
            this.showSyncBtn = r1;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return AccountSyncSettings.access$300(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return AccountSyncSettings.access$300(this.this$0).get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r8, View r9, ViewGroup r10) {
            final SyncStateCheckBoxPreference r11 = (SyncStateCheckBoxPreference) AccountSyncSettings.access$300(this.this$0).get(r8);
            if (r9 != null) goto L5;
            ViewHolder r12 = new ViewHolder(this);
            View r1 = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.list_content_item_switch_with_icon, null, false);
            r1.setTag(r12);
            new OCardListItemPositionHelper((FrameLayout) r1.findViewById(R.id.btnLayout), true, this.this$0.getContext().getColor(R.color.oui_fill_list_item_card), 3).setCardPosition(3);
        L6:
            r12.item = (OCardListItem) r1.findViewById(R.id.item_check);
            r12.buttonSync = (OButton) r1.findViewById(R.id.button_sync);
            r12.buttonSync.setOnClickListener(new AccountSyncSettings$AccountItemAdapter$$ExternalSyntheticLambda0(this));
            r12.buttonSync.setEnabled(this.showSyncBtn);
            r12.item.setTitle(r11.getTitle());
            if (r11.getSummaryResId() == 0) goto L10;
            r12.item.setSubTitle(this.this$0.getContext().getString(r11.getSummaryResId()));
        L10:
            if (r11.getSummary() != null) goto L12;
        L14:
            r12.item.showSubTitle(true);
            r12.item.setAppIcon(r11.getIcon());
            r12.oSwitch = (OSwitch) r12.item.getCustomEndView();
            r12.oSwitch.setChecked(r11.getSyncState());
            r12.oSwitch.setOnCheckedChangeListener(new AnonymousClass1(this, r11));
            if (r11.isOneTimeSyncMode() == false) goto L21;
            r12.item.showCustomEnd(false);
            if (r11.getSummary() == null) goto L19;
            String r13 = r11.getSummary();
        L20:
            r12.item.setSubTitle(this.this$0.getContext().getString(R.string.sync_one_time_sync, new Object[]{r13}));
        L22:
            return r1;
        L19:
            r13 = "";
            goto L20
        L21:
            r12.item.showCustomEnd(true);
            goto L22
        L12:
            if (r11.getSummary().isEmpty() == true) goto L14;
            r12.item.setSubTitle(r11.getSummary());
            goto L14
        L5:
            r1 = r9;
            r12 = (ViewHolder) r9.getTag();
            goto L6
        }

        /* JADX INFO: renamed from: lambda$getView$0$com-android-settings-accounts-AccountSyncSettings$AccountItemAdapter, reason: not valid java name */
        /* synthetic */ void m272x62df61c9(View r2) {
            Context r3 = r2.getContext();
            if (StorageLowState.checkStorageLowMode(r3) == false) goto L6;
            Utils.showShortToast(r3, this.this$0.getString(R.string.account_sync_low_storage_tips));
            return;
        L6:
            if (Utils.isNetworkAvailable(r3) == true) goto L8;
            Utils.showShortToast(r3, this.this$0.getString(R.string.network_unavailable_tips));
            return;
        L8:
            AccountSyncSettings.access$400(this.this$0, true);
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment23
    protected int getHelpResource() {
        return R.string.help_url_accounts;
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase, com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accounts_AccountSyncSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase, com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accounts_AccountSyncSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AccountSyncSettings() {
        this.mCheckBoxes = new ArrayList();
        this.mInvisibleAdapters = Lists.newArrayList();
    }

    static /* synthetic */ Account access$000(AccountSyncSettings r0) {
        return r0.mAccount;
    }

    static /* synthetic */ void access$100(AccountSyncSettings r0, int r1) {
        r0.showDialog(r1);
    }

    static /* synthetic */ ArrayList access$300(AccountSyncSettings r0) {
        return r0.mCheckBoxes;
    }

    static /* synthetic */ void access$400(AccountSyncSettings r0, boolean r1) {
        r0.requestOrCancelSyncForEnabledProviders(r1);
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase
    public /* bridge */ /* synthetic */ PreferenceScreen addPreferencesForType(String r1, PreferenceScreen r2) {
        return super.addPreferencesForType(r1, r2);
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase
    public /* bridge */ /* synthetic */ ArrayList getAuthoritiesForAccountType(String r1) {
        return super.getAuthoritiesForAccountType(r1);
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase, androidx.fragment.app.Fragment
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase
    public /* bridge */ /* synthetic */ void updateAuthDescriptions() {
        super.updateAuthDescriptions();
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, com.android.settings.DialogCreatable
    public Dialog onCreateDialog(int r5) {
        if (r5 != 100) goto L6;
        return new OAlertDialogBuilder(getActivity()).autoDismiss(false).horizontalButton(true).title(R.string.really_remove_account_title).message(R.string.really_remove_account_message).negativeButton(android.R.string.cancel, new AnonymousClass2(this)).positiveButton(R.string.account_settings_button_delete_account_2, new AnonymousClass1(this)).createDialog();
    L6:
        if (r5 != 101) goto L9;
        return new OAlertDialogBuilder(getActivity()).autoDismiss(false).horizontalButton().title(R.string.really_remove_account_title).message(R.string.remove_account_failed).positiveButton(android.R.string.ok, new AnonymousClass3(this)).createDialog();
    L9:
        if (r5 == 102) goto L15;
        return null;
    L15:
        return new OAlertDialogBuilder(getActivity()).autoDismiss(false).horizontalButton().title(R.string.cant_sync_dialog_title).message(R.string.cant_sync_dialog_message).positiveButton(android.R.string.ok, new AnonymousClass4(this)).createDialog();
    }

    public void com_android_settings_accounts_AccountSyncSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setHasOptionsMenu(false);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(R.layout.account_sync_screen, r3, false);
        this.mList = (ListView) r5.findViewById(R.id.view_list);
        AccountItemAdapter r6 = new AccountItemAdapter(this, null);
        this.mAccountItemAdapter = r6;
        this.mList.setAdapter(r6);
        initializeUi(r5);
        initFooterView(r5);
        return r5;
    }

    protected void initializeUi(View r2) {
        TextView r0 = (TextView) r2.findViewById(R.id.sync_settings_error_info);
        this.mErrorInfoView = r0;
        r0.setVisibility(8);
        ViewGroup r1 = (ViewGroup) r2.findViewById(R.id.list_content);
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase, com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Bundle r4 = getActivity().getIntent().getExtras();
        if (r4 != null) goto L6;
        OLog.e(AccountSettings.TAG, "No arguments provided when starting intent. ACCOUNT_KEY needed.");
        getActivity().finish();
        return;
    L6:
        Account r5 = (Account) r4.getParcelable("account");
        this.mAccount = r5;
        if (accountExists(r5) == true) goto L11;
        OLog.e(AccountSettings.TAG, "Account provided does not exist: " + this.mAccount);
        getActivity().finish();
        return;
    L11:
        if (Log.isLoggable(AccountSettings.TAG, 2) == false) goto L13;
        OLog.v(AccountSettings.TAG, "Got account: " + this.mAccount);
    L13:
        this.mList = (ListView) getView().findViewById(R.id.view_list);
        AccountItemAdapter r6 = new AccountItemAdapter(this, null);
        this.mAccountItemAdapter = r6;
        this.mList.setAdapter(r6);
    }

    private void setAccessibilityTitle() {
        UserInfo r0 = ((UserManager) getSystemService(PickApplicationActivity.EXTRA_USER)).getUserInfo(this.mUserHandle.getIdentifier());
        if (r0 == null) goto L5;
        boolean r1 = r0.isManagedProfile();
    L6:
        CharSequence r2 = getActivity().getTitle();
        if (r1 == false) goto L9;
        int r3 = R.string.accessibility_work_account_title;
    L10:
        getActivity().setTitle(Utils.createAccessibleSequence(r2, getString(r3, new Object[]{r2})));
        return;
    L9:
        r3 = R.string.accessibility_personal_account_title;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private View initFooterView(View r5) {
        OBottomActionBarNormalVertical r0 = (OBottomActionBarNormalVertical) r5.findViewById(R.id.bottom_action_bar);
        this.mBottomActionBar = r0;
        int r1 = r0.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        View r3 = this.mBottomActionBar.getChildAt(r2);
        if ((r3 instanceof ODivider) == false) goto L7;
        r3.setVisibility(8);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        OButton r4 = (OButton) StyleUtil.createWidgetWithStyle(r5.getContext(), 2132017995, new AccountSyncSettings$$ExternalSyntheticLambda0(this));
        this.mBtnDelete = r4;
        r4.setText(R.string.account_settings_button_delete_account);
        this.mBtnDelete.setOnClickListener(this);
        this.mBottomActionBar.addButton(this.mBtnDelete);
        return r5;
    }

    /* JADX INFO: renamed from: lambda$initFooterView$0$com-android-settings-accounts-AccountSyncSettings, reason: not valid java name */
    /* synthetic */ OButton m271xa653e759(Context r2, Integer r3, Integer r4) {
        OButton r5 = new OButton(r2, null);
        this.mBtnDelete = r5;
        r5.setTextColor(r2.getColor(R.color.oui_red_6));
        ViewGroup.LayoutParams r6 = new ViewGroup.LayoutParams(-1, r4.intValue());
        this.mBtnDelete.setLayoutParams(r6);
        return this.mBtnDelete;
    }

    public void com_android_settings_accounts_AccountSyncSettings__onResume$___twin___() {
        this.mAuthenticatorHelper.listenToAccountUpdates();
        updateAuthDescriptions();
        onAccountsUpdate(UserHandle.getUserHandleForUid(UserHandle.getCallingUserId()));
        super.onResume();
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mAuthenticatorHelper.stopListeningToAccountUpdates();
    }

    private void addSyncStateCheckBox(Account r8, String r9) {
        SyncStateCheckBoxPreference r0 = new SyncStateCheckBoxPreference(getActivity(), r8, r9, getDrawableForType(r8.type), this.mUserHandle.getIdentifier());
        ProviderInfo r10 = getPackageManager().resolveContentProviderAsUser(r9, 0, this.mUserHandle.getIdentifier());
        if (r10 == null) goto L5;
    L11:
        PackageManager r1 = getPackageManager();
        if (r1 == null) goto L18;
        CharSequence r11 = r10.loadLabel(r1);
        if (TextUtils.isEmpty(r11) == false) goto L17;
        OLog.e(AccountSettings.TAG, "Provider needs a label for authority '" + r9 + "'");
        return;
    L17:
        r0.setTitle(getString(R.string.sync_item_title, new Object[]{r11}));
    L18:
        this.mCheckBoxes.add(r0);
        return;
    L5:
        if (ActivityManager.getCurrentUser() == 0) goto L7;
    L9:
        if (r10 != null) goto L11;
        return;
    L7:
        if (this.mUserHandle.getIdentifier() != 10) goto L9;
        r10 = getPackageManager().resolveContentProviderAsUser(r9, 0, 0);
        goto L9
    }

    private void startSyncForEnabledProviders() {
        requestOrCancelSyncForEnabledProviders(true);
        getActivity().invalidateOptionsMenu();
    }

    private void cancelSyncForEnabledProviders() {
        requestOrCancelSyncForEnabledProviders(false);
        getActivity().invalidateOptionsMenu();
    }

    private void requestOrCancelSyncForEnabledProviders(boolean r5) {
        int r0 = this.mCheckBoxes.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        SyncStateCheckBoxPreference r2 = this.mCheckBoxes.get(r1);
        if (r2.isChecked() == false) goto L8;
        requestOrCancelSync(r2.getAccount(), r2.getAuthority(), r5);
    L8:
        r1 = r1 + 1;
        goto L3
    L10:
        if (this.mAccount == null) goto L15;
        Iterator<SyncAdapterType> r3 = this.mInvisibleAdapters.iterator();
    L13:
        if (r3.hasNext() == false) goto L20;
        SyncAdapterType r4 = r3.next();
        requestOrCancelSync(this.mAccount, r4.authority, r5);
        goto L13
    L20:
        return;
    }

    private void requestOrCancelSync(Account r3, String r4, boolean r5) {
        if (r5 == false) goto L4;
        Bundle r6 = new Bundle();
        r6.putBoolean("force", true);
        r6.putBoolean(SYNC_EXTRAS_USER_CLICK, true);
        ContentResolver.requestSyncAsUser(r3, r4, this.mUserHandle.getIdentifier(), r6);
        return;
    L4:
        ContentResolver.cancelSyncAsUser(r3, r4, this.mUserHandle.getIdentifier());
    }

    private static boolean isSyncing(List<SyncInfo> r2, Account r3, String r4) {
        Iterator<SyncInfo> r5 = r2.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        SyncInfo r0 = r5.next();
        if (r0.account.equals(r3) == false) goto L4;
        if (r0.authority.equals(r4) == false) goto L4;
        return true;
    L11:
        return false;
    }

    private static boolean isCalendarSyncAutomatically(Account r1) {
        return ContentResolver.getSyncAutomatically(r1, CALENDAR_AUTHORITY);
    }

    private static boolean isCalendarSyncable(Account r1) {
        if (ContentResolver.getIsSyncable(r1, CALENDAR_AUTHORITY) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isCalendarSyncing(Account r2) {
        List<SyncInfo> r0 = ContentResolver.getCurrentSyncs();
        if (r0 != null) goto L5;
        return false;
    L5:
        return isSyncing(r0, r2, CALENDAR_AUTHORITY);
    }

    private static SyncStatusInfo getCalendarSyncStatus(Account r1) {
        return ContentResolver.getSyncStatus(r1, CALENDAR_AUTHORITY);
    }

    private void notifyCalendarAccountDeleted(Account r3) {
        OLog.d(AccountSettings.TAG, "notify account deleted:" + r3.name);
        Intent r0 = new Intent("action_account_deleted_with_calendar_authority");
        r0.putExtra("account_name", r3.name);
        getActivity().sendBroadcast(r0);
    }

    protected static void notifyCalendarAccountSynced(Context r8, Account r9) {
        if (isCalendarSyncable(r9) == true) goto L5;
        return;
    L5:
        if (isCalendarSyncAutomatically(r9) == true) goto L7;
        return;
    L7:
        if (isCalendarSyncing(r9) == true) goto L18;
        SyncStatusInfo r0 = getCalendarSyncStatus(r9);
        if (r0 != null) goto L11;
        long r1 = 0;
    L12:
        long r2 = System.currentTimeMillis();
        long r4 = r2 - r1;
        if (r4 >= 5000) goto L19;
        OLog.d(AccountSettings.TAG, "notifyCalendarAccountSynced time:" + r1 + " current:" + r2 + " account:" + r9.name + "  delta:" + r4);
        Intent r3 = new Intent("action_account_synced_with_calendar_authority");
        r3.putExtra("account_name", r9.name);
        r8.sendBroadcast(r3);
        return;
    L19:
        return;
    L11:
        r1 = r0.lastSuccessTime;
        goto L12
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase
    protected void onSyncStateUpdated() {
        if (isResumed() == true) goto L5;
        return;
    L5:
        setFeedsState();
        showSyncState();
    }

    private void setFeedsState() {
        Date r1 = new Date();
        int r2 = this.mUserHandle.getIdentifier();
        List r3 = ContentResolver.getCurrentSyncsAsUser(r2);
        updateAccountCheckboxes();
        int r4 = this.mCheckBoxes.size();
        int r6 = 0;
        boolean r7 = false;
    L3:
        if (r6 >= r4) goto L60;
        SyncStateCheckBoxPreference r8 = this.mCheckBoxes.get(r6);
        String r9 = r8.getAuthority();
        Account r10 = r8.getAccount();
        SyncStatusInfo r11 = ContentResolver.getSyncStatusAsUser(r10, r9, r2);
        boolean r12 = ContentResolver.getSyncAutomaticallyAsUser(r10, r9, r2);
        if (r11 != null) goto L7;
        boolean r13 = false;
    L8:
        if (r11 != null) goto L10;
        boolean r14 = false;
    L11:
        boolean r15 = isSyncing(r3, r10, r9);
        int r18 = r6;
        if (r11 != null) goto L14;
    L18:
        boolean r5 = false;
    L19:
        if (r12 == true) goto L21;
        r5 = false;
    L21:
        if (r5 == false) goto L25;
        if (r15 == true) goto L25;
        if (r13 == true) goto L25;
        r7 = true;
    L25:
        List r19 = r3;
        if (Log.isLoggable(AccountSettings.TAG, 2) == false) goto L29;
        OLog.d(AccountSettings.TAG, "Update sync status: " + r10 + HanziToPinyin.Token.SEPARATOR + r9 + " active = " + r15 + " pend =" + r13);
    L29:
        if (r11 != null) goto L31;
        long r16 = 0;
    L32:
        if (r12 == true) goto L35;
        r8.setSummary(R.string.sync_disabled);
    L34:
        boolean r17 = false;
    L41:
        int r20 = ContentResolver.getIsSyncableAsUser(r10, r9, r2);
        if (r15 == false) goto L46;
        if (r20 < 0) goto L46;
        if (r14 == true) goto L46;
        boolean r21 = true;
    L47:
        r8.setActive(r21);
        if (r13 == false) goto L52;
        if (r20 < 0) goto L52;
        if (r14 == true) goto L52;
        boolean r22 = true;
    L53:
        r8.setPending(r22);
        r8.setFailed(r5);
        boolean r23 = !ContentResolver.getMasterSyncAutomaticallyAsUser(r2);
        r8.setOneTimeSyncMode(r23);
        if (r23 == true) goto L58;
        if (r12 == true) goto L58;
        boolean r24 = r17;
    L59:
        r8.setChecked(r24);
        this.mAccountItemAdapter.notifyDataSetChanged();
        r6 = r18 + 1;
        r3 = r19;
        r4 = r4;
    L58:
        r24 = true;
    L52:
        r22 = r17;
    L46:
        r21 = r17;
        goto L47
    L35:
        if (r15 == false) goto L38;
        r8.setSummary(R.string.sync_in_progress);
        goto L34
    L38:
        if (r16 == 0) goto L40;
        r1.setTime(r16);
        r17 = false;
        r8.setSummary(getResources().getString(R.string.last_synced, new Object[]{formatSyncDate(r1)}));
        goto L41
    L40:
        r17 = false;
        r8.setSummary("");
        goto L41
    L31:
        r16 = r11.lastSuccessTime;
        goto L32
    L14:
        if (r11.lastFailureTime == 0) goto L18;
        if (r11.getLastFailureMesgAsInt(0) == 1) goto L18;
        r5 = true;
        goto L19
    L10:
        r14 = r11.initialize;
        goto L11
    L7:
        r13 = r11.pending;
        goto L8
    L60:
        TextView r25 = this.mErrorInfoView;
        if (r7 == false) goto L63;
        int r26 = 0;
    L64:
        r25.setVisibility(r26);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L71;
        r0.invalidateOptionsMenu();
        return;
    L71:
        return;
    L63:
        r26 = 8;
        goto L64
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase, com.android.settingslib.accounts.AuthenticatorHelper.OnAccountsUpdateListener
    public void onAccountsUpdate(UserHandle r1) {
        super.onAccountsUpdate(r1);
        if (accountExists(this.mAccount) == true) goto L6;
        getActivity().finish();
        return;
    L6:
        updateAccountCheckboxes();
        onSyncStateUpdated();
    }

    private boolean accountExists(Account r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        Account[] r4 = AccountManager.get(getActivity()).getAccountsByTypeAsUser(r5.type, this.mUserHandle);
        int r1 = r4.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        if (r4[r2].equals(r5) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private void updateAccountCheckboxes() {
        this.mInvisibleAdapters.clear();
        SyncAdapterType[] r0 = ContentResolver.getSyncAdapterTypesAsUser(this.mUserHandle.getIdentifier());
        ArrayList r1 = new ArrayList();
        int r2 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L16;
        SyncAdapterType r7 = r0[r4];
        if (r7.accountType.equals(this.mAccount.type) == false) goto L15;
        if (r7.isUserVisible() == true) goto L11;
        this.mInvisibleAdapters.add(r7);
        goto L15
    L11:
        if (Log.isLoggable(AccountSettings.TAG, 2) == false) goto L13;
        OLog.d(AccountSettings.TAG, "updateAccountCheckboxes: added authority " + r7.authority + " to accountType " + r7.accountType);
    L13:
        r1.add(r7.authority);
    L15:
        r4 = r4 + 1;
        goto L4
    L16:
        this.mCheckBoxes.clear();
        if (Log.isLoggable(AccountSettings.TAG, 2) == false) goto L19;
        OLog.d(AccountSettings.TAG, "looking for sync adapters that match account " + this.mAccount);
    L19:
        int r5 = r1.size();
    L20:
        if (r3 >= r5) goto L27;
        String r6 = (String) r1.get(r3);
        int r8 = ContentResolver.getIsSyncableAsUser(this.mAccount, r6, this.mUserHandle.getIdentifier());
        if (Log.isLoggable(AccountSettings.TAG, 2) == false) goto L24;
        OLog.d(AccountSettings.TAG, "  found authority " + r6 + HanziToPinyin.Token.SEPARATOR + r8);
    L24:
        if (r8 <= 0) goto L26;
        addSyncStateCheckBox(this.mAccount, r6);
    L26:
        r3 = r3 + 1;
        goto L20
    }

    @Override // com.android.settings.accounts.AccountPreferenceBase
    protected void onAuthDescriptionsUpdated() {
        super.onAuthDescriptionsUpdated();
        this.mCheckBoxes.clear();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (this.mBtnDelete != r2) goto L6;
        showDialog(100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    private void showSyncState() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        int r0 = this.mUserHandle.getIdentifier();
        SyncAdapterType[] r1 = ContentResolver.getSyncAdapterTypesAsUser(r0);
        HashSet r2 = new HashSet();
        int r3 = r1.length;
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L11;
        SyncAdapterType r6 = r1[r5];
        if (r6.isUserVisible() == false) goto L10;
        r2.add(r6.authority);
    L10:
        r5 = r5 + 1;
        goto L6
    L11:
        int r4 = this.mCheckBoxes.size();
        int r7 = 0;
        int r8 = 0;
    L12:
        int r9 = 1;
        if (r7 >= r4) goto L27;
        SyncStateCheckBoxPreference r10 = this.mCheckBoxes.get(r7);
        Account r11 = r10.getAccount();
        String r12 = r10.getAuthority();
        if (r12 == null) goto L24;
        if (isSyncEnabled(r0, r11, r12) == true) goto L19;
    L21:
        r9 = 0;
    L22:
        r8 = r8 + r9;
    L26:
        r7 = r7 + 1;
        goto L12
    L19:
        if (r2.contains(r12) == false) goto L21;
    L24:
        if (Log.isLoggable(AccountSettings.TAG, 2) == false) goto L26;
        OLog.v(AccountSettings.TAG, "no syncadapters found for " + r11);
        goto L26
    L27:
        if (r8 > 0) goto L30;
        r9 = 0;
    L30:
        boolean r13 = 0 | r9;
        AccountItemAdapter r14 = this.mAccountItemAdapter;
        if (r14 == null) goto L41;
        r14.setShowSyncBtn(r13);
        return;
    }

    private boolean isSyncEnabled(int r1, Account r2, String r3) {
        return ContentResolver.getSyncAutomaticallyAsUser(r2, r3, r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accounts_AccountSyncSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AccountSyncSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accounts_AccountSyncSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accounts_AccountSyncSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AccountSyncSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accounts_AccountSyncSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accounts_AccountSyncSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AccountSyncSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accounts_AccountSyncSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
