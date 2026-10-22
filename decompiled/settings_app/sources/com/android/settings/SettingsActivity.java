package com.android.settings;

import android.app.ActionBar;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.telephony.CarrierConfigManager;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import com.GlobalProxyLancet;
import com.android.internal.util.ArrayUtils;
import com.android.settings.accessibility.AccessibilitySettings;
import com.android.settings.accessibility.CaptionPropertiesFragment;
import com.android.settings.accessibility.ToggleDaltonizerPreferenceFragment;
import com.android.settings.accessibility.ToggleScreenMagnificationPreferenceFragment;
import com.android.settings.accounts.AccountSettings;
import com.android.settings.accounts.AccountSyncSettings;
import com.android.settings.accounts.ChooseAccountActivity;
import com.android.settings.accounts.ManagedProfileSettings;
import com.android.settings.applications.AdvancedAppSettings;
import com.android.settings.applications.DrawOverlayDetails;
import com.android.settings.applications.ExternalSourcesDetails;
import com.android.settings.applications.InstalledAppDetails;
import com.android.settings.applications.ManageApplications;
import com.android.settings.applications.ManageAssist;
import com.android.settings.applications.ProcessStatsSummary;
import com.android.settings.applications.ProcessStatsUi;
import com.android.settings.applications.UsageAccessDetails;
import com.android.settings.applications.VrListenerSettings;
import com.android.settings.applications.WriteSettingsDetails;
import com.android.settings.base.BaseActivity;
import com.android.settings.bluetooth.BluetoothSettings;
import com.android.settings.deviceinfo.PrivateVolumeForget;
import com.android.settings.deviceinfo.PrivateVolumeSettings;
import com.android.settings.deviceinfo.PublicVolumeSettings;
import com.android.settings.deviceinfo.Status;
import com.android.settings.deviceinfo.StorageSettings;
import com.android.settings.inputmethod.AvailableVirtualKeyboardFragment;
import com.android.settings.inputmethod.InputMethodAndLanguageSettings;
import com.android.settings.inputmethod.KeyboardLayoutPickerFragment;
import com.android.settings.inputmethod.KeyboardLayoutPickerFragment2;
import com.android.settings.inputmethod.PhysicalKeyboardFragment;
import com.android.settings.inputmethod.SpellCheckersSettings;
import com.android.settings.inputmethod.UserDictionaryList;
import com.android.settings.localepicker.LocaleListEditor;
import com.android.settings.location.LocationSettings;
import com.android.settings.nfc.AndroidBeam;
import com.android.settings.nfc.PaymentSettings;
import com.android.settings.notification.ConfigureNotificationSettings;
import com.android.settings.notification.NotificationAccessSettings;
import com.android.settings.notification.NotificationStation;
import com.android.settings.notification.OtherSoundSettings;
import com.android.settings.notification.SoundSettings;
import com.android.settings.print.PrintJobSettingsFragment;
import com.android.settings.print.PrintSettingsFragment;
import com.android.settings.search.DynamicIndexableContentMonitor;
import com.android.settings.specialaccess.appinfo.ManageExternalStorageDetails;
import com.android.settings.users.UserSettings;
import com.android.settings.vpn2.VpnSettings;
import com.android.settings.wfd.WifiDisplaySettings;
import com.android.settings.widget.SwitchBar;
import com.android.settings.wifi.SavedAccessPointsWifiSettings;
import com.android.settings.wifi.WifiAPITest;
import com.android.settings.wifi.WifiInfo;
import com.android.settings.wifi.WifiSettings;
import com.android.settings.wifi.p2p.WifiP2pSettings;
import com.android.settingslib.drawer.DashboardCategory;
import com.android.settingslib.drawer.Tile;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsActivity extends BaseActivity implements PreferenceManager.OnPreferenceTreeClickListener, PreferenceFragmentCompat.OnPreferenceStartFragmentCallback, ButtonBarHandler, FragmentManager.OnBackStackChangedListener, SearchView.OnQueryTextListener, SearchView.OnCloseListener, MenuItem.OnActionExpandListener {
    private static final String ACTION_TIMER_SWITCH = "qualcomm.intent.action.TIMER_SWITCH";
    public static final String BACK_STACK_PREFS = ":settings:prefs";
    private static final String EMPTY_QUERY = "";
    private static final String[] ENTRY_FRAGMENTS = null;
    public static final String EXTRA_FRAGMENT_ARG_KEY = ":settings:fragment_args_key";
    public static final String EXTRA_HIDE_DRAWER = ":settings:hide_drawer";
    public static final String EXTRA_LAUNCH_ACTIVITY_ACTION = ":settings:launch_activity_action";
    protected static final String EXTRA_PREFS_SET_BACK_TEXT = "extra_prefs_set_back_text";
    protected static final String EXTRA_PREFS_SET_NEXT_TEXT = "extra_prefs_set_next_text";
    protected static final String EXTRA_PREFS_SHOW_BUTTON_BAR = "extra_prefs_show_button_bar";
    private static final String EXTRA_PREFS_SHOW_SKIP = "extra_prefs_show_skip";
    public static final String EXTRA_SHOW_FRAGMENT = ":settings:show_fragment";
    public static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":settings:show_fragment_args";
    public static final String EXTRA_SHOW_FRAGMENT_AS_SHORTCUT = ":settings:show_fragment_as_shortcut";
    public static final String EXTRA_SHOW_FRAGMENT_AS_SUBSETTING = ":settings:show_fragment_as_subsetting";
    public static final String EXTRA_SHOW_FRAGMENT_SUBTITLE_RESID = ":settings:show_fragment_subtitle_resid";
    public static final String EXTRA_SHOW_FRAGMENT_TITLE = ":settings:show_fragment_title";
    public static final String EXTRA_SHOW_FRAGMENT_TITLE_RESID = ":settings:show_fragment_title_resid";
    public static final String EXTRA_SHOW_FRAGMENT_TITLE_RES_PACKAGE_NAME = ":settings:show_fragment_title_res_package_name";
    private static final String EXTRA_UI_OPTIONS = "settings:ui_options";
    private static final String[] LIKE_SHORTCUT_INTENT_ACTION_ARRAY = null;
    private static final int LOADER_ID_INDEXABLE_CONTENT_MONITOR = 1;
    private static final String LOG_TAG = "Settings";
    private static final String LTE_4G_FRAGMENT = "com.android.settings.Lte4GEnableSetting";
    public static final String META_DATA_KEY_FRAGMENT_CLASS = "com.android.settings.FRAGMENT_CLASS";
    public static final String META_DATA_KEY_LAUNCH_ACTIVITY_ACTION = "com.android.settings.ACTIVITY_ACTION";
    private static final String MOBILENETWORK_FRAGMENT = "com.android.settings.MobileNetworkMain";
    private static final String MSG_DATA_FORCE_REFRESH = "msg_data_force_refresh";
    private static final String PROFILEMGR_MAIN_FRAGMENT = "com.android.settings.ProfileMgrMain";
    private static final int REQUEST_SUGGESTION = 42;
    private static final String SAVE_KEY_CATEGORIES = ":settings:categories";
    private static final String SAVE_KEY_HOME_ACTIVITIES_COUNT = ":settings:home_activities_count";
    private static final String SAVE_KEY_SEARCH_MENU_EXPANDED = ":settings:search_menu_expanded";
    private static final String SAVE_KEY_SEARCH_QUERY = ":settings:search_query";
    private static final String SAVE_KEY_SHOW_HOME_AS_UP = ":settings:show_home_as_up";
    private static final String SAVE_KEY_SHOW_SEARCH = ":settings:show_search";
    private static final String SYSTEM_UPDATE = "android.settings.SystemUpdateActivity";
    private String[] SETTINGS_FOR_RESTRICTED;
    private ActionBar mActionBar;
    private String mActivityAction;
    private BroadcastReceiver mBatteryInfoReceiver;
    private boolean mBatteryPresent;
    private ArrayList<DashboardCategory> mCategories;
    private ViewGroup mContent;
    private ComponentName mCurrentSuggestion;
    private SharedPreferences mDevelopmentPreferences;
    private SharedPreferences.OnSharedPreferenceChangeListener mDevelopmentPreferencesListener;
    private boolean mDisplayHomeAsUpEnabled;
    private boolean mDisplaySearch;
    private final DynamicIndexableContentMonitor mDynamicIndexableContentMonitor;
    private String mFragmentClass;
    private CharSequence mInitialTitle;
    private int mInitialTitleResId;
    private boolean mIsShortcut;
    private boolean mIsShowingDashboard;
    private int mMainContentId;
    private boolean mNeedToRevertToInitialFragment;
    private Button mNextButton;
    private Intent mResultIntentData;
    private MenuItem mSearchMenuItem;
    private boolean mSearchMenuItemExpanded;
    private String mSearchQuery;
    private SearchView mSearchView;
    private SwitchBar mSwitchBar;
    private String mTitleString;

    private void switchToSearchResultsFragmentIfNeeded() {
    }

    @Override // android.widget.SearchView.OnCloseListener
    public boolean onClose() {
        return false;
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_SettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_android_settings_SettingsActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r1) {
        return false;
    }

    public void onProfileTileOpen() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_settings_SettingsActivity_com_obric_hook_lancet_PrivacyHook_onStart(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_SettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(this);
    }

    public void onTileClicked(Tile r1) {
    }

    public void openTile(Tile r1) {
    }

    @Override // com.android.settings.ButtonBarHandler
    public void updateBottomLine(boolean r1) {
    }

    @Override // com.android.settings.ButtonBarHandler
    public void updateNextButton(boolean r1) {
    }

    public SettingsActivity() {
        this.SETTINGS_FOR_RESTRICTED = new String[]{Settings.PowerUsageSummaryActivity2.class.getName()};
        this.mBatteryPresent = true;
        this.mBatteryInfoReceiver = new AnonymousClass1(this);
        this.mDynamicIndexableContentMonitor = new DynamicIndexableContentMonitor();
        this.mMainContentId = R.id.main_content;
        this.mSearchMenuItemExpanded = false;
        this.mCategories = new ArrayList();
        this.mNeedToRevertToInitialFragment = false;
    }

    static /* synthetic */ boolean access$000(SettingsActivity r0) {
        return r0.mBatteryPresent;
    }

    static /* synthetic */ boolean access$002(SettingsActivity r0, boolean r1) {
        r0.mBatteryPresent = r1;
        return r1;
    }

    static /* synthetic */ void access$100(SettingsActivity r0) {
        r0.updateTilesList();
    }

    static /* synthetic */ void access$200(SettingsActivity r0) {
        r0.doUpdateTilesList();
    }

    static {
        ENTRY_FRAGMENTS = new String[]{WifiSettings.class.getName(), SavedAccessPointsWifiSettings.class.getName(), BluetoothSettings.class.getName(), WifiP2pSettings.class.getName(), VpnSettings.class.getName(), OtherDeviceFunctionsSettings.class.getName(), LocaleListEditor.class.getName(), InputMethodAndLanguageSettings.class.getName(), AvailableVirtualKeyboardFragment.class.getName(), SpellCheckersSettings.class.getName(), UserDictionaryList.class.getName(), UserDictionarySettings.class.getName(), HomeSettings.class.getName(), ManageApplications.class.getName(), ManageAssist.class.getName(), ProcessStatsUi.class.getName(), NotificationStation.class.getName(), LocationSettings.class.getName(), SecuritySettings.class.getName(), UsageAccessDetails.class.getName(), PrivacySettings.class.getName(), DeviceAdminSettings.class.getName(), AccessibilitySettings.class.getName(), CaptionPropertiesFragment.class.getName(), ToggleDaltonizerPreferenceFragment.class.getName(), ToggleScreenMagnificationPreferenceFragment.class.getName(), StorageSettings.class.getName(), PrivateVolumeForget.class.getName(), PrivateVolumeSettings.class.getName(), PublicVolumeSettings.class.getName(), DevelopmentSettings.class.getName(), AndroidBeam.class.getName(), WifiDisplaySettings.class.getName(), AccountSyncSettings.class.getName(), AccountSettings.class.getName(), CryptKeeperSettings.class.getName(), DreamSettings.class.getName(), UserSettings.class.getName(), NotificationAccessSettings.class.getName(), PrintSettingsFragment.class.getName(), PrintJobSettingsFragment.class.getName(), TrustedCredentialsSettings.class.getName(), PaymentSettings.class.getName(), KeyboardLayoutPickerFragment.class.getName(), KeyboardLayoutPickerFragment2.class.getName(), PhysicalKeyboardFragment.class.getName(), SoundSettings.class.getName(), ConfigureNotificationSettings.class.getName(), ChooseLockPassword.ChooseLockPasswordFragment.class.getName(), ChooseLockPattern.ChooseLockPatternFragment.class.getName(), InstalledAppDetails.class.getName(), OtherSoundSettings.class.getName(), ApnSettings.class.getName(), ApnEditor.class.getName(), ProcessStatsUi.class.getName(), ProcessStatsSummary.class.getName(), DrawOverlayDetails.class.getName(), WriteSettingsDetails.class.getName(), AdvancedAppSettings.class.getName(), WallpaperTypeSettings.class.getName(), VrListenerSettings.class.getName(), ManagedProfileSettings.class.getName(), ChooseAccountActivity.class.getName(), IccLockSettings.class.getName(), SimStatus.class.getName(), Status.class.getName(), TestingSettings.class.getName(), WifiAPITest.class.getName(), WifiInfo.class.getName(), ExternalSourcesDetails.class.getName(), ManageExternalStorageDetails.class.getName()};
        LIKE_SHORTCUT_INTENT_ACTION_ARRAY = new String[]{"android.settings.APPLICATION_DETAILS_SETTINGS"};
    }

    public SwitchBar getSwitchBar() {
        return this.mSwitchBar;
    }

    @Override // androidx.preference.PreferenceFragmentCompat.OnPreferenceStartFragmentCallback
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat r1, Preference r2) {
        r2.getTitle();
        if (r2.getFragment().equals(WallpaperTypeSettings.class.getName()) == false) goto L7;
        getString(R.string.wallpaper_settings_fragment_title);
        return true;
    L7:
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu r4) {
        if (this.mDisplaySearch == true) goto L5;
        return false;
    L5:
        getMenuInflater().inflate(R.menu.options_menu, r4);
        String r0 = this.mSearchQuery;
        MenuItem r5 = r4.findItem(R.id.search);
        this.mSearchMenuItem = r5;
        SearchView r6 = (SearchView) r5.getActionView();
        this.mSearchView = r6;
        MenuItem r2 = this.mSearchMenuItem;
        if (r2 == null) goto L14;
        if (r6 == null) goto L14;
        r2.setOnActionExpandListener(this);
        this.mSearchView.setOnQueryTextListener(this);
        this.mSearchView.setOnCloseListener(this);
        if (this.mSearchMenuItemExpanded == false) goto L12;
        this.mSearchMenuItem.expandActionView();
    L12:
        this.mSearchView.setQuery(r0, true);
        return true;
    L14:
        return false;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String r3, int r4) {
        if (r3.equals(getPackageName() + "_preferences") == false) goto L7;
        return new SharedPreferencesLogger(this, getMetricsTag());
    L7:
        return super.getSharedPreferences(r3, r4);
    }

    private String getMetricsTag() {
        String r0 = getClass().getName();
        if (getIntent() == null) goto L8;
        if (getIntent().hasExtra(EXTRA_SHOW_FRAGMENT) == false) goto L8;
        r0 = getIntent().getStringExtra(EXTRA_SHOW_FRAGMENT);
    L8:
        if (TextUtils.isEmpty(r0) == false) goto L10;
        return r0;
    L10:
        if (r0.startsWith("com.android.settings.") == true) goto L12;
        return r0;
    L12:
        return r0.replace("com.android.settings.", "");
    }

    private static boolean isShortCutIntent(Intent r1) {
        Set<String> r2 = r1.getCategories();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.contains("com.android.settings.SHORTCUT") == false) goto L7;
        return true;
    }

    private static boolean isLikeShortCutIntent(Intent r4) {
        String r5 = r4.getAction();
        if (r5 != null) goto L5;
        return false;
    L5:
        int r1 = 0;
    L6:
        String[] r2 = LIKE_SHORTCUT_INTENT_ACTION_ARRAY;
        if (r1 >= r2.length) goto L13;
        if (r2[r1].equals(r5) == true) goto L10;
        r1 = r1 + 1;
        goto L6
    L10:
        return true;
    L13:
        return false;
    }

    public void com_android_settings_SettingsActivity__onCreate$___twin___(Bundle r14) {
        requestWindowFeature(1);
        super.onCreate(r14);
        System.currentTimeMillis();
        getMetaData();
        Intent r1 = getIntent();
        if (r1.hasExtra(EXTRA_LAUNCH_ACTIVITY_ACTION) == false) goto L12;
        if (this.mActivityAction != null) goto L68;
    L9:
        finish();
        return;
    L68:
        startActivity(new Intent(this.mActivityAction));     // Catch: ActivityNotFoundException -> L8
    L8:
        OLog.w(LOG_TAG, "Activity not found for action: " + this.mActivityAction);
        goto L9
    L12:
        if (r1.hasExtra(EXTRA_UI_OPTIONS) == false) goto L14;
        getWindow().setUiOptions(r1.getIntExtra(EXTRA_UI_OPTIONS, 0));
    L14:
        this.mDevelopmentPreferences = getSharedPreferences("development", 0);
        String r6 = r1.getStringExtra(EXTRA_SHOW_FRAGMENT);
        if (isShortCutIntent(r1) == false) goto L17;
    L22:
        boolean r2 = true;
    L23:
        this.mIsShortcut = r2;
        r1.getComponent().getClassName();
        boolean r3 = r1.getBooleanExtra(EXTRA_SHOW_FRAGMENT_AS_SUBSETTING, false);
        if (r3 == false) goto L26;
        getThemeResId();
    L26:
        setContentView(R.layout.settings_main_prefs);
        this.mContent = (ViewGroup) findViewById(this.mMainContentId);
        setupBackBtnOnTitle();
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        if (r14 == null) goto L33;
        this.mSearchMenuItemExpanded = r14.getBoolean(SAVE_KEY_SEARCH_MENU_EXPANDED);
        this.mSearchQuery = r14.getString(SAVE_KEY_SEARCH_QUERY);
        setTitleFromIntent(r1);
        ArrayList r0 = r14.getParcelableArrayList(SAVE_KEY_CATEGORIES);
        if (r0 == null) goto L31;
        this.mCategories.clear();
        this.mCategories.addAll(r0);
        setTitleFromBackStack();
    L31:
        this.mDisplayHomeAsUpEnabled = r14.getBoolean(SAVE_KEY_SHOW_HOME_AS_UP);
        this.mDisplaySearch = r14.getBoolean(SAVE_KEY_SHOW_SEARCH);
    L42:
        ActionBar r15 = getActionBar();
        this.mActionBar = r15;
        if (r15 == null) goto L45;
        r15.setDisplayHomeAsUpEnabled(this.mDisplayHomeAsUpEnabled);
        this.mActionBar.setHomeButtonEnabled(this.mDisplayHomeAsUpEnabled);
        this.mActionBar.hide();
    L45:
        SwitchBar r16 = (SwitchBar) findViewById(R.id.switch_bar);
        this.mSwitchBar = r16;
        if (r16 == null) goto L49;
        r16.setMetricsTag(getMetricsTag());
    L49:
        if (r1.getBooleanExtra(EXTRA_PREFS_SHOW_BUTTON_BAR, false) == false) goto L70;
        View r17 = findViewById(R.id.button_bar);
        if (r17 == null) goto L71;
        r17.setVisibility(0);
        Button r18 = (Button) findViewById(R.id.back_button);
        r18.setOnClickListener(new AnonymousClass2(this));
        Button r4 = (Button) findViewById(R.id.skip_button);
        r4.setOnClickListener(new AnonymousClass3(this));
        Button r5 = (Button) findViewById(R.id.next_button);
        this.mNextButton = r5;
        r5.setOnClickListener(new AnonymousClass4(this));
        if (r1.hasExtra(EXTRA_PREFS_SET_NEXT_TEXT) == false) goto L59;
        String r7 = r1.getStringExtra(EXTRA_PREFS_SET_NEXT_TEXT);
        if (TextUtils.isEmpty(r7) == false) goto L57;
        this.mNextButton.setVisibility(8);
        goto L59
    L57:
        this.mNextButton.setText(r7);
    L59:
        if (r1.hasExtra(EXTRA_PREFS_SET_BACK_TEXT) == false) goto L65;
        String r13 = r1.getStringExtra(EXTRA_PREFS_SET_BACK_TEXT);
        if (TextUtils.isEmpty(r13) == false) goto L63;
        r18.setVisibility(8);
        goto L65
    L63:
        r18.setText(r13);
    L65:
        if (r1.getBooleanExtra(EXTRA_PREFS_SHOW_SKIP, false) == false) goto L72;
        r4.setVisibility(0);
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L33:
        if (this.mIsShowingDashboard == true) goto L41;
        this.mDisplaySearch = false;
        if (this.mIsShortcut == false) goto L37;
        this.mDisplayHomeAsUpEnabled = r3;
    L40:
        setTitleFromIntent(r1);
        switchToFragment(r6, GlobalProxyLancet.com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r1, ":settings:show_fragment_args"), true, false, this.mInitialTitleResId, this.mInitialTitle, false);
        goto L42
    L37:
        if (r3 == false) goto L39;
        this.mDisplayHomeAsUpEnabled = true;
        goto L40
    L39:
        this.mDisplayHomeAsUpEnabled = false;
        goto L40
    L41:
        this.mDisplayHomeAsUpEnabled = false;
        this.mDisplaySearch = true;
        this.mInitialTitleResId = R.string.dashboard_title;
        goto L42
    L17:
        if (isLikeShortCutIntent(r1) == true) goto L22;
        if (r1.getBooleanExtra(EXTRA_SHOW_FRAGMENT_AS_SHORTCUT, false) == true) goto L22;
        r2 = false;
        goto L23
    }

    protected void setMainContentId(int r1) {
        this.mMainContentId = r1;
    }

    private void setTitleFromIntent(Intent r4) {
        int r0 = r4.getIntExtra(EXTRA_SHOW_FRAGMENT_TITLE_RESID, -1);
        if (r0 <= 0) goto L10;
        this.mInitialTitle = null;
        this.mInitialTitleResId = r0;
        String r5 = r4.getStringExtra(EXTRA_SHOW_FRAGMENT_TITLE_RES_PACKAGE_NAME);
        if (r5 != null) goto L16;
        setTitle(this.mInitialTitleResId);
        return;
    L16:
        CharSequence r1 = createPackageContextAsUser(r5, 0, new UserHandle(UserHandle.myUserId())).getResources().getText(this.mInitialTitleResId);     // Catch: PackageManager.NameNotFoundException -> L8
        this.mInitialTitle = r1;     // Catch: PackageManager.NameNotFoundException -> L8
        setTitle(r1);     // Catch: PackageManager.NameNotFoundException -> L8
        this.mInitialTitleResId = -1;     // Catch: PackageManager.NameNotFoundException -> L8
        return;
    L8:
        OLog.w(LOG_TAG, "Could not find package" + r5);
        return;
    L10:
        this.mInitialTitleResId = -1;
        CharSequence r6 = r4.getStringExtra(EXTRA_SHOW_FRAGMENT_TITLE);
        if (r6 != null) goto L14;
        r6 = getTitle();
    L14:
        this.mInitialTitle = r6;
        setTitle(r6);
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        setTitleFromBackStack();
    }

    private int setTitleFromBackStack() {
        int r0 = getFragmentManager().getBackStackEntryCount();
        if (r0 != 0) goto L10;
        int r1 = this.mInitialTitleResId;
        if (r1 <= 0) goto L7;
        setTitle(r1);
        return 0;
    L7:
        setTitle(this.mInitialTitle);
        return 0;
    L10:
        setTitleFromBackStackEntry(getSupportFragmentManager().getBackStackEntryAt(r0 - 1));
        return r0;
    }

    private void setTitleFromBackStackEntry(FragmentManager.BackStackEntry r2) {
        int r0 = r2.getBreadCrumbTitleRes();
        if (r0 <= 0) goto L5;
        CharSequence r3 = getText(r0);
    L6:
        if (r3 == null) goto L9;
        setTitle(r3);
        return;
    L9:
        return;
    L5:
        r3 = r2.getBreadCrumbTitle();
        goto L6
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        if (this.mCategories.size() <= 0) goto L5;
        r3.putParcelableArrayList(SAVE_KEY_CATEGORIES, this.mCategories);
    L5:
        r3.putBoolean(SAVE_KEY_SHOW_HOME_AS_UP, this.mDisplayHomeAsUpEnabled);
        r3.putBoolean(SAVE_KEY_SHOW_SEARCH, this.mDisplaySearch);
        if (this.mDisplaySearch == false) goto L19;
        MenuItem r0 = this.mSearchMenuItem;
        if (r0 != null) goto L10;
    L12:
        boolean r1 = false;
    L13:
        r3.putBoolean(SAVE_KEY_SEARCH_MENU_EXPANDED, r1);
        SearchView r2 = this.mSearchView;
        if (r2 == null) goto L16;
        String r4 = r2.getQuery().toString();
    L17:
        r3.putString(SAVE_KEY_SEARCH_QUERY, r4);
        return;
    L16:
        r4 = "";
        goto L17
    L10:
        if (r0.isActionViewExpanded() == false) goto L12;
        r1 = true;
        goto L13
    }

    public void com_android_settings_SettingsActivity__onStart$___twin___() {
        super.onStart();
        if (this.mNeedToRevertToInitialFragment == false) goto L5;
        revertToInitialFragment();
    L5:
        SharedPreferences.OnSharedPreferenceChangeListener r0 = new AnonymousClass5(this);
        this.mDevelopmentPreferencesListener = r0;
        this.mDevelopmentPreferences.registerOnSharedPreferenceChangeListener(r0);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mBatteryInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2);
        this.mDynamicIndexableContentMonitor.register(this, 1);
        if (this.mDisplaySearch == true) goto L8;
    L10:
        updateTilesList();
        return;
    L8:
        if (TextUtils.isEmpty(this.mSearchQuery) == true) goto L10;
        onQueryTextSubmit(this.mSearchQuery);
        goto L10
    }

    public void com_android_settings_SettingsActivity__onStop$___twin___() {
        super.onStop();
        unregisterReceiver(this.mBatteryInfoReceiver);
        this.mDynamicIndexableContentMonitor.unregister();
    }

    public void com_android_settings_SettingsActivity__onDestroy$___twin___() {
        super.onDestroy();
        SharedPreferences.OnSharedPreferenceChangeListener r0 = this.mDevelopmentPreferencesListener;
        if (r0 == null) goto L6;
        this.mDevelopmentPreferences.unregisterOnSharedPreferenceChangeListener(r0);
        this.mDevelopmentPreferencesListener = null;
        return;
    }

    protected boolean isValidFragment(String r4) {
        int r0 = 0;
    L3:
        String[] r1 = ENTRY_FRAGMENTS;
        if (r0 >= r1.length) goto L10;
        if (r1[r0].equals(r4) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        Intent r0 = super.getIntent();
        String r1 = getStartingFragmentClass(r0);
        if (r1 == null) goto L11;
        Intent r2 = new Intent(r0);
        r2.putExtra(EXTRA_SHOW_FRAGMENT, r1);
        r2.putExtra(EXTRA_SHOW_FRAGMENT_TITLE, this.mTitleString);
        Bundle r4 = r0.getExtras();
        if (r4 == null) goto L7;
        Bundle r3 = new Bundle(r4);
    L8:
        r3.putParcelable("intent", r0);
        r2.putExtra(":settings:show_fragment_args", r3);
        return r2;
    L7:
        r3 = new Bundle();
        goto L8
    L11:
        if (this.mActivityAction == null) goto L14;
        Intent r5 = new Intent(r0);
        r5.putExtra(EXTRA_LAUNCH_ACTIVITY_ACTION, this.mActivityAction);
        return r5;
    L14:
        return r0;
    }

    private String getStartingFragmentClass(Intent r2) {
        String r0 = this.mFragmentClass;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r3 = r2.getComponent().getClassName();
        if (r3.equals(getClass().getName()) == false) goto L10;
        return null;
    L10:
        if ("com.android.settings.ManageApplications".equals(r3) == true) goto L16;
        if ("com.android.settings.RunningServices".equals(r3) == true) goto L16;
        if ("com.android.settings.applications.StorageUse".equals(r3) == true) goto L16;
        return r3;
    L16:
        return ManageApplications.class.getName();
    }

    public void startPreferencePanel(String r9, Bundle r10, int r11, CharSequence r12, Fragment r13, int r14) {
        if (r11 >= 0) goto L6;
        if (r12 == null) goto L5;
        String r15 = r12.toString();
    L7:
        Utils.startWithFragment(this, r9, r10, r13, r14, r11, r15, this.mIsShortcut);
        return;
    L5:
        r15 = "";
        goto L7
    L6:
        r15 = null;
        goto L7
    }

    public void startPreferencePanelAsUser(String r10, Bundle r11, int r12, CharSequence r13, UserHandle r14) {
        if (r14.getIdentifier() != UserHandle.myUserId()) goto L5;
        Fragment r15 = (Fragment) null;
        startPreferencePanel(r10, r11, r12, r13, null, 0);
        return;
    L5:
        if (r12 >= 0) goto L9;
        if (r13 == null) goto L8;
        String r16 = r13.toString();
    L10:
        Utils.startWithFragmentAsUser(this, r10, r11, r12, r16, this.mIsShortcut, r14);
        return;
    L8:
        r16 = "";
        goto L10
    L9:
        r16 = null;
        goto L10
    }

    public void finishPreferencePanel(Fragment r1, int r2, Intent r3) {
        setResult(r2, r3);
        finish();
    }

    public void startPreferenceFragment(Fragment r2, boolean r3) {
        FragmentTransaction r0 = getSupportFragmentManager().beginTransaction();
        r0.replace(this.mMainContentId, r2);
        if (r3 == false) goto L5;
        r0.setTransition(4097);
        r0.addToBackStack(BACK_STACK_PREFS);
    L6:
        r0.commitAllowingStateLoss();
        return;
    L5:
        r0.setTransition(4099);
        goto L6
    }

    public void startPreferenceFragment(android.app.Fragment r2, boolean r3) {
        android.app.FragmentTransaction r0 = getFragmentManager().beginTransaction();
        r0.replace(this.mMainContentId, r2);
        if (r3 == false) goto L5;
        r0.setTransition(4097);
        r0.addToBackStack(BACK_STACK_PREFS);
    L6:
        r0.commitAllowingStateLoss();
        return;
    L5:
        r0.setTransition(4099);
        goto L6
    }

    private Fragment switchToFragment(String r3, Bundle r4, boolean r5, boolean r6, int r7, CharSequence r8, boolean r9) {
        if (LTE_4G_FRAGMENT.equals(r3) == false) goto L7;
        Intent r10 = new Intent("android.settings.SETTINGS");
        r10.addFlags(268435456);
        startActivity(r10);
        finish();
        return null;
    L7:
        if (PROFILEMGR_MAIN_FRAGMENT.equals(r3) == false) goto L11;
        Intent r11 = new Intent();
        r11.setAction("com.codeaurora.STARTPROFILE");
        r11.setPackage("com.android.profile");
        startActivity(r11);
        finish();
        return null;
    L11:
        if (MOBILENETWORK_FRAGMENT.equals(r3) == false) goto L15;
        Intent r12 = new Intent();
        r12.setAction("android.settings.DATA_ROAMING_SETTINGS");
        r12.setPackage("com.qualcomm.qti.networksetting");
        startActivity(r12);
        finish();
        return null;
    L15:
        if (SYSTEM_UPDATE.equals(r3) == false) goto L18;
        SystemUpdateHandle();
        return null;
    L18:
        if (r3 != null) goto L20;
    L39:
        OLog.d(this.TAG, "Invalid fragment for this activity");
        return null;
    L20:
        if (r3.isEmpty() == true) goto L39;
        if (r5 == true) goto L24;
    L28:
        Fragment r13 = Fragment.instantiate(this, r3, r4);
        FragmentTransaction r14 = getSupportFragmentManager().beginTransaction();
        r14.replace(this.mMainContentId, r13);
        if (r9 == false) goto L31;
        TransitionManager.beginDelayedTransition(this.mContent);
    L31:
        if (r6 == false) goto L33;
        r14.addToBackStack(BACK_STACK_PREFS);
    L33:
        if (r7 <= 0) goto L35;
        r14.setBreadCrumbTitle(r7);
    L37:
        r14.commitAllowingStateLoss();
        getFragmentManager().executePendingTransactions();
        return r13;
    L35:
        if (r8 == null) goto L37;
        r14.setBreadCrumbTitle(r8);
        goto L37
    L24:
        if (isValidFragment(r3) == true) goto L28;
        throw new IllegalArgumentException("Invalid fragment for this activity: " + r3);
    }

    public void SystemUpdateHandle() {
        PersistableBundle r0 = ((CarrierConfigManager) getBaseContext().getSystemService("carrier_config")).getConfig();
        if (r0 != null) goto L5;
    L7:
        Intent r1 = new Intent("android.settings.SYSTEM_UPDATE_SETTINGS");
        PackageManager r2 = getBaseContext().getPackageManager();
        if (r2 != null) goto L10;
        return;
    L10:
        int r3 = 0;
        List<ResolveInfo> r4 = r2.queryIntentActivities(r1, 0);
        if (r4 != null) goto L13;
        return;
    L13:
        int r5 = r4.size();
    L14:
        if (r3 >= r5) goto L20;
        ResolveInfo r6 = r4.get(r3);
        if ((r6.activityInfo.applicationInfo.flags & 1) != 0) goto L17;
        r3 = r3 + 1;
        goto L14
    L17:
        Intent r7 = new Intent().setClassName(r6.activityInfo.packageName, r6.activityInfo.name);
        r7.addFlags(268435456);
        startActivity(r7);
        finish();
        return;
    L20:
        return;
    L5:
        if (r0.getBoolean("ci_action_on_sys_update_bool") == false) goto L7;
        Utils.ciActionOnSysUpdate(getBaseContext(), r0);
        goto L7
    }

    private void updateTilesList() {
        AsyncTask.execute(new AnonymousClass6(this));
    }

    private void doUpdateTilesList() {
        PackageManager r0 = getPackageManager();
        boolean r1 = UserManager.get(this).isAdminUser();
        setTileEnabled(new ComponentName(getPackageName(), Settings.PowerUsageSummaryActivity2.class.getName()), this.mBatteryPresent, r1, r0);
    }

    private void setTileEnabled(ComponentName r1, boolean r2, boolean r3, PackageManager r4) {
        if (r3 == false) goto L4;
        return;
    L4:
        if (getPackageName().equals(r1.getPackageName()) == false) goto L8;
        ArrayUtils.contains(this.SETTINGS_FOR_RESTRICTED, r1.getClassName());
        return;
    }

    private void getMetaData() {
        ActivityInfo r0 = getPackageManager().getActivityInfo(getComponentName(), 128);     // Catch: PackageManager.NameNotFoundException -> L10
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.metaData == null) goto L14;
        this.mFragmentClass = r0.metaData.getString(META_DATA_KEY_FRAGMENT_CLASS);     // Catch: PackageManager.NameNotFoundException -> L10
        this.mTitleString = r0.metaData.getString(EXTRA_SHOW_FRAGMENT_TITLE);     // Catch: PackageManager.NameNotFoundException -> L10
        this.mActivityAction = r0.metaData.getString(META_DATA_KEY_LAUNCH_ACTIVITY_ACTION);     // Catch: PackageManager.NameNotFoundException -> L10
        return;
    L14:
        return;
    L10:
        OLog.d(LOG_TAG, "Cannot get Metadata for: " + getComponentName().toString());
    }

    @Override // com.android.settings.ButtonBarHandler
    public boolean hasNextButton() {
        if (this.mNextButton == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.settings.ButtonBarHandler
    public Button getNextButton() {
        return this.mNextButton;
    }

    @Override // android.app.Activity
    public boolean shouldUpRecreateTask(Intent r2) {
        return super.shouldUpRecreateTask(new Intent(this, SettingsActivity.class));
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String r1) {
        switchToSearchResultsFragmentIfNeeded();
        this.mSearchQuery = r1;
        return false;
    }

    @Override // android.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String r1) {
        this.mSearchQuery = r1;
        return false;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionExpand(MenuItem r2) {
        if (r2.getItemId() != this.mSearchMenuItem.getItemId()) goto L7;
        switchToSearchResultsFragmentIfNeeded();
        return true;
    L7:
        return true;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public boolean onMenuItemActionCollapse(MenuItem r2) {
        if (r2.getItemId() == this.mSearchMenuItem.getItemId()) goto L5;
        return true;
    L5:
        if (this.mSearchMenuItemExpanded == false) goto L10;
        revertToInitialFragment();
        return true;
    L10:
        return true;
    }

    public List<DashboardCategory> getDashboardCategories() {
        return new ArrayList();
    }

    public void needToRevertToInitialFragment() {
        this.mNeedToRevertToInitialFragment = true;
    }

    private void revertToInitialFragment() {
        this.mNeedToRevertToInitialFragment = false;
        this.mSearchMenuItemExpanded = false;
        getFragmentManager().popBackStackImmediate(BACK_STACK_PREFS, 1);
        MenuItem r3 = this.mSearchMenuItem;
        if (r3 == null) goto L6;
        r3.collapseActionView();
        return;
    }

    public Intent getResultIntentData() {
        return this.mResultIntentData;
    }

    public void setResultIntentData(Intent r1) {
        this.mResultIntentData = r1;
    }

    public void startSuggestion(Intent r2) {
        this.mCurrentSuggestion = r2.getComponent();
        startActivityForResult(r2, 42);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r5, int r6, Intent r7) {
        if (r5 == 42) goto L5;
    L8:
        super.onActivityResult(r5, r6, r7);
        return;
    L5:
        if (this.mCurrentSuggestion == null) goto L8;
        if (r6 == 0) goto L8;
        getPackageManager().setComponentEnabledSetting(this.mCurrentSuggestion, 2, 1);
        goto L8
    }

    @Insert("onCreate")
    public static void com_android_settings_SettingsActivity_com_obric_hook_lancet_PrivacyHook_onCreate(SettingsActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_SettingsActivity__onCreate$___twin___(r4);
    }

    @Insert("onStart")
    public static void com_android_settings_SettingsActivity_com_obric_hook_lancet_PrivacyHook_onStart(SettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r3.com_android_settings_SettingsActivity__onStart$___twin___();
    }

    @Insert("onStop")
    public static void com_android_settings_SettingsActivity_com_obric_hook_lancet_PrivacyHook_onStop(SettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_SettingsActivity__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_SettingsActivity_com_obric_hook_lancet_PrivacyHook_onDestroy(SettingsActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        SettingsActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_SettingsActivity__onDestroy$___twin___();
    }
}
