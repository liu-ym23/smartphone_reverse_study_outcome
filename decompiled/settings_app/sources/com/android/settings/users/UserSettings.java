package com.android.settings.users;

import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.DimmableIconPreference;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.Utils;
import com.android.settings.accessibility.AccessibilitySettingsFragment;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.core.ObservablePreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.MainSwitchBarController;
import com.android.settings.widget.SwitchBar;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedSwitchPreference;
import com.android.settingslib.drawable.CircleFramedDrawable;
import com.android.vcard.VCardConfig;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class UserSettings extends ObservablePreferenceFragment implements Preference.OnPreferenceClickListener, View.OnClickListener, DialogInterface.OnDismissListener, Preference.OnPreferenceChangeListener, MultiUserSwitchBarController.OnMultiUserSwitchChangedListener, EditUserInfoController.OnContentChangedCallback {
    private static final String ACTION_EDIT_EMERGENCY_INFO = "android.settings.EDIT_EMERGENGY_INFO";
    private static final int DIALOG_ADD_USER = 2;
    private static final int DIALOG_CHOOSE_USER_TYPE = 6;
    private static final int DIALOG_CONFIRM_EXIT_GUEST = 8;
    private static final int DIALOG_CONFIRM_REMOVE = 1;
    private static final int DIALOG_NEED_LOCKSCREEN = 7;
    private static final int DIALOG_SETUP_PROFILE = 4;
    private static final int DIALOG_SETUP_USER = 3;
    private static final int DIALOG_USER_CANNOT_MANAGE = 5;
    private static final int DIALOG_USER_PROFILE_EDITOR = 9;
    private static final String EXTRA_OPEN_DIALOG_USER_PROFILE_EDITOR = "EXTRA_OPEN_DIALOG_USER_PROFILE_EDITOR";
    private static final String KEY_ADD_USER = "user_add";
    private static final String KEY_ADD_USER_LONG_MESSAGE_DISPLAYED = "key_add_user_long_message_displayed";
    private static final String KEY_EMERGENCY_INFO = "emergency_info";
    private static final String KEY_SUMMARY = "summary";
    private static final String KEY_TITLE = "title";
    private static final String KEY_USER_LIST = "user_list";
    private static final String KEY_USER_ME = "user_me";
    private static final int MENU_REMOVE_USER = 1;
    private static final int MESSAGE_CONFIG_USER = 3;
    private static final int MESSAGE_SETUP_USER = 2;
    private static final int MESSAGE_UPDATE_LIST = 1;
    private static final int REQUEST_CHOOSE_LOCK = 10;
    private static final String SAVE_ADDING_USER = "adding_user";
    private static final String SAVE_REMOVING_USER = "removing_user";
    private static final String TAG = "UserSettings";
    private static final int USER_TYPE_RESTRICTED_PROFILE = 2;
    private static final int USER_TYPE_USER = 1;
    private DimmableIconPreference mAddUser;
    private RestrictedSwitchPreference mAddUserWhenLocked;
    private int mAddedUserId;
    private boolean mAddingUser;
    private String mAddingUserName;
    private Drawable mDefaultIconDrawable;
    private EditUserInfoController mEditUserInfoController;
    private Preference mEmergencyInfoPreference;
    private Handler mHandler;
    private PreferenceGroup mLockScreenSettings;
    private UserPreference mMePreference;
    private int mRemovingUserId;
    private boolean mShouldUpdateUserList;
    private MultiUserSwitchBarController mSwitchBarController;
    private UserCapabilities mUserCaps;
    private BroadcastReceiver mUserChangeReceiver;
    private SparseArray<Bitmap> mUserIcons;
    private PreferenceGroup mUserListCategory;
    private final Object mUserLock;
    private UserManager mUserManager;

    @Override // com.android.settings.SettingsPreferenceFragment
    public int getHelpResource() {
        return R.string.help_url_users;
    }

    @Override // com.android.settings.core.ObservablePreferenceFragment, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_users_UserSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.core.ObservablePreferenceFragment, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_users_UserSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public UserSettings() {
        this.mRemovingUserId = -1;
        this.mAddedUserId = 0;
        this.mShouldUpdateUserList = true;
        this.mUserLock = new Object();
        this.mUserIcons = new SparseArray();
        this.mEditUserInfoController = new EditUserInfoController();
        this.mHandler = new AnonymousClass1(this);
        this.mUserChangeReceiver = new AnonymousClass2(this);
    }

    static /* synthetic */ void access$000(UserSettings r0) {
        r0.updateUserList();
    }

    static /* synthetic */ void access$100(UserSettings r0, int r1) {
        r0.onUserCreated(r1);
    }

    static /* synthetic */ int access$1000(UserSettings r0) {
        return r0.mAddedUserId;
    }

    static /* synthetic */ void access$1100(UserSettings r0, int r1) {
        r0.switchUserNow(r1);
    }

    static /* synthetic */ void access$1200(UserSettings r0, int r1) {
        r0.onAddUserClicked(r1);
    }

    static /* synthetic */ void access$1300(UserSettings r0) {
        r0.launchChooseLockscreen();
    }

    static /* synthetic */ void access$1400(UserSettings r0) {
        r0.exitGuest();
    }

    static /* synthetic */ Object access$1500(UserSettings r0) {
        return r0.mUserLock;
    }

    static /* synthetic */ UserInfo access$1600(UserSettings r0) {
        return r0.createTrustedUser();
    }

    static /* synthetic */ UserInfo access$1700(UserSettings r0) {
        return r0.createRestrictedProfile();
    }

    static /* synthetic */ boolean access$1802(UserSettings r0, boolean r1) {
        r0.mAddingUser = r1;
        return r1;
    }

    static /* synthetic */ void access$200(UserSettings r0, int r1, boolean r2) {
        r0.onManageUserClicked(r1, r2);
    }

    static /* synthetic */ int access$300(UserSettings r0) {
        return r0.mRemovingUserId;
    }

    static /* synthetic */ int access$302(UserSettings r0, int r1) {
        r0.mRemovingUserId = r1;
        return r1;
    }

    static /* synthetic */ SparseArray access$400(UserSettings r0) {
        return r0.mUserIcons;
    }

    static /* synthetic */ Handler access$500(UserSettings r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$600(UserSettings r0, String r1) {
        r0.finishLoadProfile(r1);
    }

    static /* synthetic */ UserManager access$700(UserSettings r0) {
        return r0.mUserManager;
    }

    static /* synthetic */ void access$800(UserSettings r0) {
        r0.removeUserNow();
    }

    static /* synthetic */ void access$900(UserSettings r0, int r1) {
        r0.addUserNow(r1);
    }

    public void com_android_settings_users_UserSettings__onCreate$___twin___(Bundle r9) {
        super.onCreate(r9);
        if (r9 != null) goto L5;
    L11:
        FragmentActivity r1 = getActivity();
        this.mUserCaps = UserCapabilities.create(r1);
        this.mUserManager = (UserManager) r1.getSystemService(PickApplicationActivity.EXTRA_USER);
        if (this.mUserCaps.mEnabled == true) goto L14;
        return;
    L14:
        int r5 = UserHandle.myUserId();
        addPreferencesFromResource(R.xml.user_settings);
        this.mUserListCategory = (PreferenceGroup) findPreference(KEY_USER_LIST);
        UserPreference r10 = new UserPreference(getPrefContext(), null, r5, null, null);
        this.mMePreference = r10;
        r10.setKey(KEY_USER_ME);
        this.mMePreference.setOnPreferenceClickListener(this);
        if (this.mUserCaps.mIsAdmin == false) goto L17;
        this.mMePreference.setSummary(R.string.user_admin);
    L17:
        this.mAddUser = (DimmableIconPreference) findPreference(KEY_ADD_USER);
        if (this.mUserCaps.mCanAddUser == true) goto L20;
    L24:
        this.mLockScreenSettings = (PreferenceGroup) findPreference("lock_screen_settings");
        this.mAddUserWhenLocked = (RestrictedSwitchPreference) findPreference("add_users_when_locked");
        this.mEmergencyInfoPreference = findPreference(KEY_EMERGENCY_INFO);
        setHasOptionsMenu(true);
        IntentFilter r4 = new IntentFilter("android.intent.action.USER_REMOVED");
        r4.addAction("android.intent.action.USER_INFO_CHANGED");
        r1.registerReceiverAsUser(this.mUserChangeReceiver, UserHandle.ALL, r4, null, this.mHandler);
        loadProfile();
        updateUserList();
        this.mShouldUpdateUserList = false;
        return;
    L20:
        if (Utils.isDeviceProvisioned(getActivity()) == false) goto L24;
        this.mAddUser.setOnPreferenceClickListener(this);
        if (this.mUserCaps.mCanAddRestrictedProfile == true) goto L24;
        this.mAddUser.setTitle(R.string.user_add_user_menu);
        goto L24
    L5:
        if (r9.containsKey(SAVE_ADDING_USER) == false) goto L8;
        this.mAddedUserId = r9.getInt(SAVE_ADDING_USER);
    L8:
        if (r9.containsKey(SAVE_REMOVING_USER) == false) goto L10;
        this.mRemovingUserId = r9.getInt(SAVE_REMOVING_USER);
    L10:
        this.mEditUserInfoController.onRestoreInstanceState(r9);
        goto L11
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r6) {
        super.onActivityCreated(r6);
        boolean r7 = getIntent().getBooleanExtra(EXTRA_OPEN_DIALOG_USER_PROFILE_EDITOR, false);
        SettingsActivity r0 = (SettingsActivity) getActivity();
        SwitchBar r2 = r0.getSwitchBar();
        r2.setType(1);
        r2.setTitle(getContext().getString(R.string.multiple_users_main_switch_title));
        if (this.mUserCaps.mIsGuest == false) goto L5;
    L7:
        r2.hide();
    L8:
        this.mSwitchBarController = new MultiUserSwitchBarController(r0, new MainSwitchBarController(r2), this);
        getSettingsLifecycle().addObserver(this.mSwitchBarController);
        if (r2.isChecked() == false) goto L13;
        if (r7 == false) goto L14;
        showDialog(9);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (this.mUserCaps.mUserSwitchingUiEnabled == false) goto L7;
        r2.show();
        r2.getSwitch().setVisibility(0);
        goto L8
    }

    public void com_android_settings_users_UserSettings__onResume$___twin___() {
        super.onResume();
        if (this.mUserCaps.mEnabled == true) goto L6;
        return;
    L6:
        if (this.mShouldUpdateUserList == false) goto L9;
        this.mUserCaps.updateAddUserCapabilities(getActivity());
        loadProfile();
        updateUserList();
        return;
    }

    @Override // com.android.settings.core.ObservablePreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.mShouldUpdateUserList = true;
        super.onPause();
    }

    @Override // com.android.settings.core.ObservablePreferenceFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mUserCaps.mEnabled == true) goto L5;
        return;
    L5:
        unregisterReceiver(this.mUserChangeReceiver);
    }

    @Override // com.android.settings.core.ObservablePreferenceFragment, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        this.mEditUserInfoController.onSaveInstanceState(r3);
        r3.putInt(SAVE_ADDING_USER, this.mAddedUserId);
        r3.putInt(SAVE_REMOVING_USER, this.mRemovingUserId);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void startActivityForResult(Intent r2, int r3) {
        this.mEditUserInfoController.startingActivityForResult();
        super.startActivityForResult(r2, r3);
    }

    @Override // com.android.settings.core.ObservablePreferenceFragment, com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r6, MenuInflater r7) {
        UserManager r0 = (UserManager) getContext().getSystemService(UserManager.class);
        boolean r1 = !r0.hasUserRestriction("no_remove_user");
        boolean r2 = r0.canSwitchUsers();
        if (this.mUserCaps.mIsAdmin == true) goto L7;
        if (r1 == false) goto L7;
        if (r2 == false) goto L7;
        r6.add(0, 1, 0, getResources().getString(R.string.user_remove_user_menu, new Object[]{this.mUserManager.getUserName()})).setShowAsAction(0);
    L7:
        super.onCreateOptionsMenu(r6, r7);
    }

    @Override // com.android.settings.core.ObservablePreferenceFragment, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r3) {
        if (r3.getItemId() != 1) goto L7;
        onRemoveUserClicked(UserHandle.myUserId());
        return true;
    L7:
        return super.onOptionsItemSelected(r3);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.android.settings.users.UserSettings$3] */
    private void loadProfile() {
        if (this.mUserCaps.mIsGuest == false) goto L6;
        this.mMePreference.setIcon(getEncircledDefaultIcon());
        this.mMePreference.setTitle(R.string.user_exit_guest_title);
        return;
    L6:
        new AnonymousClass3(this).execute(new Void[0]);
    }

    private void finishLoadProfile(String r4) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        this.mMePreference.setTitle(getString(R.string.user_you, new Object[]{r4}));
        int r5 = UserHandle.myUserId();
        Bitmap r0 = this.mUserManager.getUserIcon(r5);
        if (r0 == null) goto L9;
        this.mMePreference.setIcon(encircle(r0));
        this.mUserIcons.put(r5, r0);
        return;
    }

    private boolean hasLockscreenSecurity() {
        return new LockPatternUtils(getActivity()).isSecure(UserHandle.myUserId());
    }

    private void launchChooseLockscreen() {
        Intent r0 = new Intent("android.app.action.SET_NEW_PASSWORD");
        r0.putExtra("minimum_quality", 65536);
        startActivityForResult(r0, 10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 != 10) goto L8;
        if (r3 != 0) goto L6;
        return;
    L6:
        if (hasLockscreenSecurity() == false) goto L11;
        addUserNow(2);
        return;
    L11:
        return;
    L8:
        this.mEditUserInfoController.onActivityResult(r2, r3, r4);
    }

    private void onAddUserClicked(int r4) {
        Object r0 = this.mUserLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mRemovingUserId == (-1)) goto L7;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L7:
        if (this.mAddingUser == true) goto L17;
        if (r4 == 1) goto L16;
        if (r4 != 2) goto L17;
        if (hasLockscreenSecurity() == false) goto L15;
        addUserNow(2);     // Catch: Throwable -> L19
        goto L17
    L15:
        showDialog(7);     // Catch: Throwable -> L19
        goto L17
    L16:
        showDialog(2);     // Catch: Throwable -> L19
        goto L17
    }

    private void onRemoveUserClicked(int r4) {
        Object r0 = this.mUserLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mRemovingUserId == (-1)) goto L7;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mAddingUser == true) goto L9;
        this.mRemovingUserId = r4;     // Catch: Throwable -> L11
        showDialog(1);     // Catch: Throwable -> L11
        goto L9
    }

    private UserInfo createRestrictedProfile() {
        UserInfo r0 = this.mUserManager.createRestrictedProfile(this.mAddingUserName);
        if (r0 == null) goto L5;
        Utils.assignDefaultPhoto(getActivity(), r0.id);
    L5:
        return r0;
    }

    private UserInfo createTrustedUser() {
        UserInfo r0 = this.mUserManager.createUser(this.mAddingUserName, 0);
        if (r0 == null) goto L5;
        Utils.assignDefaultPhoto(getActivity(), r0.id);
    L5:
        return r0;
    }

    private void onManageUserClicked(int r11, boolean r12) {
        this.mAddingUser = false;
        if (r11 != (-11)) goto L6;
        Bundle r3 = new Bundle();
        r3.putBoolean("guest_user", true);
        Fragment r10 = (Fragment) null;
        ((SettingsActivity) getActivity()).startPreferencePanel(UserDetailsSettings.class.getName(), r3, R.string.user_guest, null, null, 0);
        return;
    L6:
        UserInfo r0 = this.mUserManager.getUserInfo(r11);
        if (r0.isRestricted() == false) goto L12;
        if (this.mUserCaps.mIsAdmin == false) goto L12;
        Bundle r5 = new Bundle();
        r5.putInt("user_id", r11);
        r5.putBoolean(AppRestrictionsFragment.EXTRA_NEW_USER, r12);
        Fragment r13 = (Fragment) null;
        ((SettingsActivity) getActivity()).startPreferencePanel(RestrictedProfileSettings.class.getName(), r5, R.string.user_restrictions_title, null, null, 0);
        return;
    L12:
        if (r0.id != UserHandle.myUserId()) goto L15;
        return;
    L15:
        if (this.mUserCaps.mIsAdmin == false) goto L19;
        Bundle r6 = new Bundle();
        r6.putInt("user_id", r11);
        Fragment r14 = (Fragment) null;
        ((SettingsActivity) getActivity()).startPreferencePanel(UserDetailsSettings.class.getName(), r6, -1, r0.name, null, 0);
        return;
    }

    private void onUserCreated(int r2) {
        this.mAddedUserId = r2;
        this.mAddingUser = false;
        UserInfo r3 = this.mUserManager.getUserInfo(r2);
        if (r3 != null) goto L5;
    L7:
        showDialog(3);
        return;
    L5:
        if (r3.isRestricted() == false) goto L7;
        showDialog(4);
    }

    @Override // com.android.settings.SettingsPreferenceFragment
    public void onDialogShowing() {
        super.onDialogShowing();
        setOnDismissListener(this);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.DialogCreatable
    public Dialog onCreateDialog(int r13) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        final int r2 = 2;
        switch(r13) {
            case 1: goto L31;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L9;
            default: goto L7;
        };
    L7:
        return null;
    L14:
        ArrayList r14 = new ArrayList();
        HashMap r1 = new HashMap();
        r1.put("title", getString(R.string.user_add_user_item_title));
        r1.put("summary", getString(R.string.user_add_user_item_summary));
        HashMap r3 = new HashMap();
        r3.put("title", getString(R.string.user_add_profile_item_title));
        r3.put("summary", getString(R.string.user_add_profile_item_summary));
        r14.add(r1);
        r14.add(r3);
        AlertDialog.Builder r6 = new AlertDialog.Builder(r0);
        SimpleAdapter r7 = new SimpleAdapter(r6.getContext(), r14, R.layout.two_line_list_item, new String[]{"title", "summary"}, new int[]{R.id.title, R.id.summary});
        r6.setTitle(R.string.user_add_user_type_title);
        r6.setAdapter(r7, new AnonymousClass8(this));
        return r6.create();
    L22:
        final SharedPreferences r5 = getActivity().getPreferences(0);
        final boolean r8 = r5.getBoolean(KEY_ADD_USER_LONG_MESSAGE_DISPLAYED, false);
        if (r8 == false) goto L25;
        int r9 = R.string.user_add_user_message_short;
    L26:
        if (r13 != 2) goto L29;
        r2 = 1;
    L29:
        return new AlertDialog.Builder(r0).setTitle(R.string.user_add_user_title).setMessage(r9).setPositiveButton(android.R.string.ok, new AnonymousClass5(this, r2, r8, r5)).setNegativeButton(android.R.string.cancel, null).create();
    L25:
        r9 = R.string.user_add_user_message_long;
        goto L26
    L9:
        return this.mEditUserInfoController.createDialog(this, this.mMePreference.getIcon(), this.mMePreference.getTitle(), R.string.profile_info_settings_title, this, Process.myUserHandle());
    L11:
        return new AlertDialog.Builder(r0).setTitle(R.string.user_exit_guest_confirm_title).setMessage(R.string.user_exit_guest_confirm_message).setPositiveButton(R.string.user_exit_guest_dialog_remove, new AnonymousClass10(this)).setNegativeButton(android.R.string.cancel, null).create();
    L13:
        return new AlertDialog.Builder(r0).setMessage(R.string.user_need_lock_message).setPositiveButton(R.string.user_set_lock_button, new AnonymousClass9(this)).setNegativeButton(android.R.string.cancel, null).create();
    L17:
        return new AlertDialog.Builder(r0).setMessage(R.string.user_cannot_manage_message).setPositiveButton(android.R.string.ok, null).create();
    L19:
        return new AlertDialog.Builder(r0).setMessage(R.string.user_setup_profile_dialog_message).setPositiveButton(android.R.string.ok, new AnonymousClass7(this)).setNegativeButton(android.R.string.cancel, null).create();
    L21:
        return new AlertDialog.Builder(r0).setTitle(R.string.user_setup_dialog_title).setMessage(R.string.user_setup_dialog_message).setPositiveButton(R.string.user_setup_button_setup_now, new AnonymousClass6(this)).setNegativeButton(R.string.user_setup_button_setup_later, null).create();
    L31:
        return UserDialogs.createRemoveDialog(getActivity(), this.mRemovingUserId, new AnonymousClass4(this));
    }

    private boolean emergencyInfoActivityPresent() {
        Intent r0 = new Intent(ACTION_EDIT_EMERGENCY_INFO).setPackage(AccessibilitySettingsFragment.EARTHQUAKE_WARNING_PACKAGE_NAME);
        List<ResolveInfo> r2 = getContext().getPackageManager().queryIntentActivities(r0, 0);
        if (r2 != null) goto L5;
    L9:
        return false;
    L5:
        if (r2.isEmpty() == true) goto L9;
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.android.settings.users.UserSettings$11] */
    private void removeUserNow() {
        if (this.mRemovingUserId != UserHandle.myUserId()) goto L5;
        removeThisUser();
        return;
    L5:
        new AnonymousClass11(this).start();
    }

    private void removeThisUser() {
        if (this.mUserManager.canSwitchUsers() == true) goto L10;
        OLog.w(TAG, "Cannot remove current user when switching is disabled");
        return;
    L10:
        ActivityManagerNative.getDefault().switchUser(0);     // Catch: RemoteException -> L8
        ((UserManager) getContext().getSystemService(UserManager.class)).removeUser(UserHandle.myUserId());     // Catch: RemoteException -> L8
        return;
    L8:
        OLog.e(TAG, "Unable to remove self user");
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.android.settings.users.UserSettings$12] */
    private void addUserNow(final int r3) {
        Object r0 = this.mUserLock;
        monitor-enter(r0);
        this.mAddingUser = true;     // Catch: Throwable -> L12
        if (r3 != 1) goto L8;
        String r1 = getString(R.string.user_new_user_name);     // Catch: Throwable -> L12
    L9:
        this.mAddingUserName = r1;     // Catch: Throwable -> L12
        new AnonymousClass12(this, r3).start();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L8:
        r1 = getString(R.string.user_new_profile_name);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private void switchUserNow(int r1) {
        ActivityManagerNative.getDefault().switchUser(r1);     // Catch: RemoteException -> L4
        return;
    }

    private void exitGuest() {
        if (this.mUserCaps.mIsGuest == true) goto L5;
        return;
    L5:
        removeThisUser();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [android.view.View$OnClickListener] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.view.View$OnClickListener] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r15v1, types: [android.view.View$OnClickListener] */
    /* JADX WARN: Type inference failed for: r16v0, types: [androidx.preference.Preference$OnPreferenceChangeListener, androidx.preference.Preference$OnPreferenceClickListener, com.android.settings.users.UserSettings] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
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
    private void updateUserList() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        boolean r2 = true;
        List r1 = this.mUserManager.getUsers(true);
        boolean r3 = Utils.isVoiceCapable(getActivity());
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        r5.add(this.mMePreference);
        Iterator r6 = r1.iterator();
    L6:
        RestrictedLockUtils.EnforcedAdmin r7 = null;
        ?? r8 = 0;
        boolean r9 = false;
        if (r6.hasNext() == false) goto L62;
        UserInfo r10 = (UserInfo) r6.next();
        if (r10.supportsSwitchToByUser() == false) goto L6;
        if (r10.id == UserHandle.myUserId()) goto L13;
        if (r10.isGuest() == true) goto L6;
        if (this.mUserCaps.mIsAdmin == false) goto L23;
        if (r3 == false) goto L21;
    L22:
        ?? r11 = true;
    L25:
        if (this.mUserCaps.mIsAdmin == false) goto L32;
        if (r3 == true) goto L32;
        if (r10.isRestricted() == true) goto L32;
        if (r10.isGuest() == true) goto L32;
        r9 = true;
    L32:
        Context r12 = getPrefContext();
        int r13 = r10.id;
        if (r11 == false) goto L35;
        ?? r14 = this;
    L36:
        if (r9 == false) goto L38;
        r8 = this;
    L38:
        UserPreference r15 = new UserPreference(r12, null, r13, r14, r8);
        r15.setKey("id=" + r10.id);
        r5.add(r15);
        if (r10.isAdmin() == false) goto L41;
        r15.setSummary(R.string.user_admin);
    L41:
        r15.setTitle(r10.name);
        r15.setOnPreferenceClickListener(this);
        r15.setSelectable(true);
        UserPreference r16 = r15;
    L42:
        if (r16 == null) goto L6;
        if (isInitialized(r10) == true) goto L52;
        if (r10.isRestricted() == false) goto L49;
        r16.setSummary(R.string.user_summary_restricted_not_set_up);
    L50:
        r16.setOnPreferenceClickListener(this);
        r16.setSelectable(true);
    L55:
        if (r10.iconPath != null) goto L57;
        r16.setIcon(getEncircledDefaultIcon());
        goto L6
    L57:
        if (this.mUserIcons.get(r10.id) == null) goto L58;
        setPhotoId(r16, r10);
        goto L6
    L58:
        r4.add(Integer.valueOf(r10.id));
        r16.setIcon(getEncircledDefaultIcon());
        goto L6
    L49:
        r16.setSummary(R.string.user_summary_not_set_up);
        goto L50
    L52:
        if (r10.isRestricted() == false) goto L55;
        r16.setSummary(R.string.user_summary_restricted_profile);
        goto L55
    L35:
        r14 = 0;
        goto L36
    L21:
        if (r10.isRestricted() == true) goto L22;
    L23:
        r11 = false;
        goto L25
    L13:
        r16 = this.mMePreference;
        goto L42
    L62:
        if (this.mAddingUser == false) goto L65;
        UserPreference r17 = new UserPreference(getPrefContext(), null, -10, null, null);
        r17.setEnabled(false);
        r17.setTitle(this.mAddingUserName);
        r17.setIcon(getEncircledDefaultIcon());
        r5.add(r17);
    L65:
        if (this.mUserCaps.mIsGuest == false) goto L67;
    L76:
        Collections.sort(r5, UserPreference.SERIAL_NUMBER_COMPARATOR);
        getActivity().invalidateOptionsMenu();
        if (r4.size() <= 0) goto L79;
        loadIconsAsync(r4);
    L79:
        PreferenceScreen r18 = getPreferenceScreen();
        r18.removeAll();
        if (this.mUserCaps.mCanAddRestrictedProfile == false) goto L82;
        this.mUserListCategory.removeAll();
        this.mUserListCategory.setOrder(Integer.MAX_VALUE);
        r18.addPreference(this.mUserListCategory);
        PreferenceGroup r19 = this.mUserListCategory;
    L83:
        Iterator r20 = r5.iterator();
    L85:
        if (r20.hasNext() == false) goto L88;
        UserPreference r21 = (UserPreference) r20.next();
        r21.setOrder(Integer.MAX_VALUE);
        r19.addPreference(r21);
        goto L85
    L88:
        if (this.mUserCaps.mCanAddUser == true) goto L92;
        if (this.mUserCaps.mDisallowAddUserSetByAdmin == true) goto L92;
    L111:
        if (this.mUserCaps.mIsAdmin == false) goto L125;
        if (this.mUserCaps.mDisallowAddUser == true) goto L115;
    L116:
        this.mLockScreenSettings.setOrder(Integer.MAX_VALUE);
        r18.addPreference(this.mLockScreenSettings);
        RestrictedSwitchPreference r22 = this.mAddUserWhenLocked;
        if (Settings.Global.getInt(getContentResolver(), "add_users_when_locked", 0) == 1) goto L120;
        r2 = false;
    L120:
        r22.setChecked(r2);
        this.mAddUserWhenLocked.setOnPreferenceChangeListener(this);
        RestrictedSwitchPreference r23 = this.mAddUserWhenLocked;
        if (this.mUserCaps.mDisallowAddUser == false) goto L123;
        r7 = this.mUserCaps.mEnforcedAdmin;
    L123:
        r23.setDisabledByAdmin(r7);
        goto L125
    L115:
        if (this.mUserCaps.mDisallowAddUserSetByAdmin == true) goto L116;
    L125:
        if (emergencyInfoActivityPresent() == false) goto L145;
        this.mEmergencyInfoPreference.setOnPreferenceClickListener(this);
        this.mEmergencyInfoPreference.setOrder(Integer.MAX_VALUE);
        r18.addPreference(this.mEmergencyInfoPreference);
        return;
    L145:
        return;
    L92:
        if (Utils.isDeviceProvisioned(getActivity()) == false) goto L111;
        boolean r24 = this.mUserManager.canAddMoreUsers();
        this.mAddUser.setOrder(Integer.MAX_VALUE);
        r18.addPreference(this.mAddUser);
        DimmableIconPreference r25 = this.mAddUser;
        if (r24 == true) goto L96;
    L98:
        boolean r26 = false;
    L99:
        r25.setEnabled(r26);
        if (r24 == true) goto L102;
        this.mAddUser.setSummary(getString(R.string.user_add_max_count, new Object[]{Integer.valueOf(getMaxRealUsers())}));
    L104:
        if (this.mAddUser.isEnabled() == false) goto L111;
        DimmableIconPreference r27 = this.mAddUser;
        if (this.mUserCaps.mDisallowAddUser == false) goto L108;
        RestrictedLockUtils.EnforcedAdmin r28 = this.mUserCaps.mEnforcedAdmin;
    L109:
        r27.setDisabledByAdmin(r28);
        goto L111
    L108:
        r28 = null;
        goto L109
    L102:
        this.mAddUser.setSummary(null);
        goto L104
    L96:
        if (this.mAddingUser == true) goto L98;
        r26 = true;
        goto L99
    L82:
        r19 = r18;
        goto L83
    L67:
        if (this.mUserCaps.mCanAddGuest == false) goto L69;
    L70:
        Context r110 = getPrefContext();
        if (this.mUserCaps.mIsAdmin == false) goto L74;
        if (r3 == false) goto L74;
        ?? r111 = this;
    L75:
        UserPreference r29 = new UserPreference(r110, null, -11, r111, null);
        r29.setTitle(R.string.user_guest);
        r29.setIcon(getEncircledDefaultIcon());
        r5.add(r29);
        r29.setOnPreferenceClickListener(this);
        r29.setSelectable(true);
    L74:
        r111 = 0;
        goto L75
    L69:
        if (this.mUserCaps.mDisallowAddUserSetByAdmin == false) goto L76;
        goto L70
    }

    private int getMaxRealUsers() {
        int r0 = UserManager.getMaxSupportedUsers() + 1;
        Iterator r3 = this.mUserManager.getUsers().iterator();
        int r1 = 0;
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((UserInfo) r3.next()).isManagedProfile() == false) goto L4;
        r1 = r1 + 1;
        goto L4
    L9:
        return r0 - r1;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.users.UserSettings$13] */
    private void loadIconsAsync(List<Integer> r3) {
        new AnonymousClass13(this).execute(new List[]{r3});
    }

    private Drawable getEncircledDefaultIcon() {
        if (this.mDefaultIconDrawable != null) goto L6;
        this.mDefaultIconDrawable = encircle(Utils.getDefaultUserIconAsBitmap(-10000));
    L6:
        return this.mDefaultIconDrawable;
    }

    private void setPhotoId(Preference r2, UserInfo r3) {
        Bitmap r4 = this.mUserIcons.get(r3.id);
        if (r4 == null) goto L6;
        r2.setIcon(encircle(r4));
        return;
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r5) {
        if (r5 != this.mMePreference) goto L13;
        if (this.mUserCaps.mIsGuest == false) goto L9;
        showDialog(8);
        return true;
    L9:
        if (this.mUserManager.isLinkedUser() == false) goto L11;
        onManageUserClicked(UserHandle.myUserId(), false);
    L43:
        return false;
    L11:
        showDialog(9);
        goto L43
    L13:
        if ((r5 instanceof UserPreference) == false) goto L35;
        if (this.mSwitchBarController.isSwitchEnable() == false) goto L31;
        if (canSwitchUserNow() == false) goto L31;
        int r0 = ((UserPreference) r5).getUserId();
        UserInfo r1 = this.mUserManager.getUserInfo(r0);
        if (r0 != (-11)) goto L24;
        UserInfo r6 = findGuest();
        if (r6 == null) goto L43;
        confirmToSwitchUser(r6.id, r6.name);
        goto L43
    L24:
        if (r1 != null) goto L26;
    L28:
        if (r1 == null) goto L43;
        confirmToSwitchUser(r1.id, r5.getTitle().toString());
        goto L43
    L26:
        if (isInitialized(r1) == true) goto L28;
        Handler r4 = this.mHandler;
        r4.sendMessage(r4.obtainMessage(2, r1.id, r1.serialNumber));
    L31:
        if (this.mSwitchBarController.isSwitchDisallow() == false) goto L33;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getActivity(), this.mUserCaps.mEnforcedAdmin);
    L33:
        return false;
    L35:
        if (r5 != this.mAddUser) goto L41;
        if (this.mUserCaps.mCanAddRestrictedProfile == false) goto L39;
        showDialog(6);
        goto L43
    L39:
        onAddUserClicked(1);
        goto L43
    L41:
        if (r5 != this.mEmergencyInfoPreference) goto L43;
        Intent r7 = new Intent(ACTION_EDIT_EMERGENCY_INFO);
        r7.setFlags(VCardConfig.FLAG_APPEND_TYPE_PARAM);
        startActivity(r7);
        goto L43
    }

    boolean canSwitchUserNow() {
        if (this.mUserManager.getUserSwitchability() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void confirmToSwitchUser(final int r5, String r6) {
        new AlertDialog.Builder(getActivity()).setTitle(R.string.dlg_title_notice).setMessage(getActivity().getString(R.string.user_switch_message, new Object[]{r6})).setNegativeButton(R.string.cancel, null).setPositiveButton(R.string.ok, new AnonymousClass14(this, r5)).show();
    }

    private UserInfo findGuest() {
        Iterator r2 = this.mUserManager.getUsers().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        UserInfo r0 = (UserInfo) r2.next();
        if (r0.isGuest() == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private boolean isInitialized(UserInfo r1) {
        if ((r1.flags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private Drawable encircle(Bitmap r1) {
        return CircleFramedDrawable.getInstance(getActivity(), r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if ((r4.getTag() instanceof UserPreference) == false) goto L15;
        int r0 = ((UserPreference) r4.getTag()).getUserId();
        int r5 = r4.getId();
        if (r5 != R.id.manage_user) goto L7;
        onManageUserClicked(r0, false);
        return;
    L7:
        if (r5 != R.id.trash_user) goto L18;
        RestrictedLockUtils.EnforcedAdmin r6 = MultiSDKAdapterNew.checkIfRestrictionEnforced(getContext(), "no_remove_user", UserHandle.myUserId());
        if (r6 == null) goto L12;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getContext(), r6);
        return;
    L12:
        onRemoveUserClicked(r0);
        return;
    L18:
        return;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r2) {
        Object r3 = this.mUserLock;
        monitor-enter(r3);
        this.mRemovingUserId = -1;     // Catch: Throwable -> L8
        updateUserList();     // Catch: Throwable -> L8
        monitor-exit(r3);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r3, Object r4) {
        int r1 = 0;
        if (r3 != this.mAddUserWhenLocked) goto L11;
        Boolean r5 = (Boolean) r4;
        ContentResolver r2 = getContentResolver();
        if (r5 != null) goto L7;
    L9:
        Settings.Global.putInt(r2, "add_users_when_locked", r1);
        return true;
    L7:
        if (r5.booleanValue() == false) goto L9;
        r1 = 1;
        goto L9
    L11:
        return false;
    }

    @Override // com.android.settings.users.EditUserInfoController.OnContentChangedCallback
    public void onPhotoChanged(Drawable r1) {
        this.mMePreference.setIcon(r1);
    }

    @Override // com.android.settings.users.EditUserInfoController.OnContentChangedCallback
    public void onLabelChanged(CharSequence r1) {
        this.mMePreference.setTitle(r1);
    }

    @Override // com.android.settings.users.MultiUserSwitchBarController.OnMultiUserSwitchChangedListener
    public void onMultiUserSwitchChanged(boolean r1) {
        updateUI();
    }

    private void updateUI() {
        this.mUserCaps.updateAddUserCapabilities(getActivity());
        loadProfile();
        updateUserList();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_users_UserSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(UserSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_users_UserSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_users_UserSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(UserSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_users_UserSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_users_UserSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(UserSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_users_UserSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
