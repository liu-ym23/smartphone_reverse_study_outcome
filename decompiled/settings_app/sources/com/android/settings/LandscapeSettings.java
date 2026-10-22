package com.android.settings;

import android.casthal.CasthalManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.GlobalProxyLancet;
import com.android.settings.about.AboutPhoneFragment;
import com.android.settings.applications.PreferredActivityCategoryFragment;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.bluetooth.BluetoothSettingsFragment;
import com.android.settings.revone.DockSettingsFragment;
import com.android.settings.revone.KeyboardSettingsFragment;
import com.android.settings.revone.MouseSettingsFragment;
import com.android.settings.revone.StylusSearchFragment;
import com.android.settings.revone.TNTSoundSettingsFragment;
import com.android.settings.revone.TNTVoiceSettings;
import com.android.settings.revone.TabletWallpaperSettings;
import com.android.settings.revone.TntAssistFragment;
import com.android.settings.revone.WindowTitleBarStyleFragment;
import com.android.settings.revone.boston.BostonSettingsFragment;
import com.android.settings.revone.boston.GestureFragment;
import com.android.settings.revone.boston.TouchpadSettingsFragment;
import com.android.settings.search.SearchFragment;
import com.android.settings.textboom.RevoneTextBoomSettingsFragment;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.SettingLeftMenuAdapter;
import com.android.settings.wifi.WifiSettings;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;
import obric.tablet.TabletLayout;
import obric.tablet.navigationlist.HeaderListAdapter;
import obric.tablet.navigationlist.HeaderViewHolder;
import obric.tablet.navigationlist.ItemViewHolder;
import obric.tablet.navigationlist.ViewHolder;
import obric.tablet.widget.SearchBar;

/* JADX INFO: loaded from: classes2.dex */
public class LandscapeSettings extends BaseActivity implements HeaderListAdapter.OnItemClickListener {
    private static final int ID_ABOUT = 25;
    private static final int ID_ADVANCED = 23;
    private static final int ID_APPLICATION = 20;
    private static final int ID_BIGBANG = 17;
    private static final int ID_BLUETOOTH = 16;
    private static final int ID_BOSTON_SETTINGS = 12;
    private static final int ID_CELLULAR = 14;
    private static final int ID_CLOUD = 22;
    private static final int ID_DOCK = 2;
    private static final int ID_GESTURE = 7;
    private static final int ID_IDEA_PILLS = 19;
    private static final int ID_KEYBOARD = 4;
    private static final int ID_LANGUAGE = 3;
    private static final int ID_MOUSE = 6;
    private static final int ID_NETWORK = 15;
    private static final int ID_NOTIFICATION = 21;
    private static final int ID_ONE_STEP = 18;
    private static final int ID_OTA = 24;
    private static final int ID_SCREEN = 8;
    private static final int ID_STYLUS = 26;
    private static final int ID_TNTCONNECTIONMODE = 11;
    private static final int ID_TOUCHPAD = 5;
    private static final int ID_VOICE = 9;
    private static final int ID_VOICEINPUT = 10;
    private static final int ID_WALLPAPER = 0;
    private static final int ID_WINDOW = 1;
    private static final int ID_WLAN = 13;
    private static final int INDEX_NETWORK_CELLULAR = 1;
    protected static final String LAUNCH_PAGE_KEY = "launchPage";
    private static final int NETWORK_LIST_SIZE = 4;
    protected static final String TAG = "LandscapeSettings";
    private static ArrayList<HeaderViewHolder> mHeaderViewHolders;
    private ItemViewHolder mAbout;
    private ItemViewHolder mAdvanced;
    private ItemViewHolder mApplication;
    private ItemViewHolder mBigBang;
    private Fragment mBindFragment;
    private ItemViewHolder mBluetooth;
    private ItemViewHolder mBostonSettings;
    private ItemViewHolder mBytedanceTnt;
    private ItemViewHolder mCellular;
    private ItemViewHolder mCloud;
    private ViewGroup mContentView;
    private ItemViewHolder mDock;
    private ItemViewHolder mGesture;
    private HeaderListAdapter mHeaderListAdapter;
    private ItemViewHolder mKeyboard;
    private BroadcastReceiver mKeyboardReceiver;
    private ImageView mLanguageView;
    protected String mLaunchPage;
    private ListView mListView;
    private BroadcastReceiver mLocaleChangeReceiver;
    private ItemViewHolder mMouse;
    private ItemViewHolder mNetwork;
    private ItemViewHolder mNotification;
    private ItemViewHolder mOneStep;
    private ItemViewHolder mOta;
    private ItemViewHolder mScreen;
    private SearchBar mSearchBar;
    private EditText mSearchEditor;
    private SearchTextListener mSearchTextListener;
    private ItemViewHolder mStylus;
    private TabletLayout mTabletLayout;
    private ItemViewHolder mTouchpad;
    private ItemViewHolder mVoice;
    private ItemViewHolder mVoiceInput;
    private ItemViewHolder mWallpaper;
    private ItemViewHolder mWindow;
    private ItemViewHolder mWlan;
    private ItemViewHolder mthinkboost;

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_LandscapeSettings_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r1) {
        com_android_settings_LandscapeSettings_com_obric_hook_lancet_PrivacyHook_onNewIntent(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_LandscapeSettings_com_obric_hook_lancet_PrivacyHook_onPause(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_LandscapeSettings_com_obric_hook_lancet_PrivacyHook_onResume(this);
    }

    public LandscapeSettings() {
        this.mLocaleChangeReceiver = new AnonymousClass5(this);
        this.mKeyboardReceiver = new AnonymousClass6(this);
    }

    static /* synthetic */ void access$000(LandscapeSettings r0, boolean r1) {
        r0.setSearchBarListener(r1);
    }

    static /* synthetic */ HeaderListAdapter access$100(LandscapeSettings r0) {
        return r0.mHeaderListAdapter;
    }

    static /* synthetic */ Bundle access$200(LandscapeSettings r0, String r1) {
        return r0.createSearchBundle(r1);
    }

    static /* synthetic */ void access$300(LandscapeSettings r0, Class r1, Bundle r2) {
        r0.replaceFragment(r1, r2);
    }

    static /* synthetic */ SearchBar access$400(LandscapeSettings r0) {
        return r0.mSearchBar;
    }

    static /* synthetic */ SearchTextListener access$500(LandscapeSettings r0) {
        return r0.mSearchTextListener;
    }

    static /* synthetic */ ImageView access$600(LandscapeSettings r0) {
        return r0.mLanguageView;
    }

    static /* synthetic */ void access$700(LandscapeSettings r0, Class r1) {
        r0.replaceFragment(r1);
    }

    static /* synthetic */ void access$800(LandscapeSettings r0) {
        r0.initItems();
    }

    static {
        mHeaderViewHolders = new ArrayList(5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void com_android_settings_LandscapeSettings__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Intent r4 = getIntent();
        if (tryHandleRoute(r4) == false) goto L6;
        finish();
        return;
    L6:
        setContentView(R.layout.land_scape_settings_layout);
        Bundle r5 = r4.getExtras();
        if (r5 == null) goto L9;
        this.mLaunchPage = r5.getString(LAUNCH_PAGE_KEY);
    L9:
        initView();
        Fragment r0 = getBindFragment();
        this.mBindFragment = r0;
        if (r0 != null) goto L14;
        finish();
        return;
    L14:
        if (this.mIsLandScreen == true) goto L16;
    L18:
        initPort();
    L19:
        OLog.d(TAG, "onCreate: mIsLandScreen : " + this.mIsLandScreen);
        bindBundle(this.mBindFragment, r5);
        Fragment r6 = findFragment(this.mBindFragment.getClass());
        if (r6 != null) goto L22;
        loadRootFragment(this.mTabletLayout.getSecondColumnLayoutId(), this.mBindFragment);
        return;
    L22:
        OLog.d(TAG, "no need load root fragment " + r6);
        return;
    L16:
        if (this.mIsLaunchFromActivityStackView == true) goto L18;
        initLand();
        initSelectedItem(this.mBindFragment);
        goto L19
    }

    private void initView() {
        TabletLayout r0 = (TabletLayout) findViewById(R.id.settings_root_view_container);
        this.mTabletLayout = r0;
        r0.requestFeature(1);
        this.mTabletLayout.initTabletView();
        ListView r1 = this.mTabletLayout.getNavigationListView();
        this.mListView = r1;
        r1.setBackgroundResource(R.color.side_menu_background_color);
        this.mListView.setVerticalScrollBarEnabled(false);
        SearchBar r2 = this.mTabletLayout.getSearchBarView();
        this.mSearchBar = r2;
        this.mSearchEditor = (EditText) r2.getSearchEditor();
        this.mContentView = this.mTabletLayout.getSecondColumnLayout();
    }

    protected void initSelectedItem(Fragment r3) {
        if (TextUtils.isEmpty(this.mLaunchPage) == false) goto L6;
        updateSelectedItem(r3);
        return;
    L6:
        List<String> r0 = StepBackUtils.getStepBackList(this.mLaunchPage);
        if (r0.size() <= 0) goto L9;
        updateSelectedItem(StepBackUtils.getSupportFragment(r0.get(0)));
        return;
    L9:
        updateSelectedItem(r3);
    }

    private void initPort() {
        TabletLayout r0 = this.mTabletLayout;
        ViewGroup r1 = (ViewGroup) NullSafe.nonNull(r0.findViewById(r0.getFirstColumnLayoutId()));
        View r2 = this.mTabletLayout.findViewById(R.id.first_divider);
        if (r2 == null) goto L5;
        r2.setVisibility(8);
    L5:
        r1.setVisibility(8);
    }

    private void initLand() {
        initItems();
        TabletLayout r0 = this.mTabletLayout;
        ((ViewGroup) r0.findViewById(r0.getFirstColumnLayoutId())).setVisibility(0);
        SettingLeftMenuAdapter r1 = new SettingLeftMenuAdapter(this, mHeaderViewHolders, this);
        this.mHeaderListAdapter = r1;
        r1.setListBottomPadding(0);
        this.mListView.setAdapter(this.mHeaderListAdapter);
        this.mListView.addFooterView(createLanguageView());
        this.mSearchEditor.setOnFocusChangeListener(new AnonymousClass1(this));
        this.mSearchEditor.addTextChangedListener(new AnonymousClass2(this));
    }

    private void setSearchBarListener(boolean r2) {
        if (r2 == false) goto L5;
        this.mSearchBar.setListener(new AnonymousClass3(this));
        return;
    }

    private void initItems() {
        mHeaderViewHolders.clear();
        this.mWallpaper = new ItemViewHolder(0, R.string.wallpaper_pager_header_title, R.drawable.setting_item_icon_wallpaper_land);
        this.mWindow = new ItemViewHolder(1, R.string.window_pager_header_title, R.drawable.setting_item_icon_window_land);
        this.mDock = new ItemViewHolder(2, R.string.dock_pager_header_title, R.drawable.setting_item_icon_dock_land);
        this.mScreen = new ItemViewHolder(8, R.string.screen_pager_header_title, R.drawable.setting_item_icon_display_land);
        this.mVoice = new ItemViewHolder(9, R.string.voice_pager_header_title, R.drawable.setting_item_icon_sound_land);
        HeaderViewHolder r0 = new HeaderViewHolder(this.mContext.getString(R.string.header_item_personalise_title));
        ArrayList<ViewHolder> r1 = new ArrayList();
        r1.add(this.mWallpaper);
        r1.add(this.mWindow);
        r1.add(this.mDock);
        r1.add(this.mScreen);
        r1.add(this.mVoice);
        r0.setChildren(r1);
        mHeaderViewHolders.add(r0);
        this.mStylus = new ItemViewHolder(26, R.string.setting_stylus, R.drawable.setting_item_icon_stylus_land);
        this.mKeyboard = new ItemViewHolder(4, R.string.keyboard_pager_header_title, R.drawable.setting_item_icon_keyboard_land);
        this.mTouchpad = new ItemViewHolder(5, R.string.touchpad_pager_header_title, R.drawable.setting_item_icon_touchpad);
        this.mMouse = new ItemViewHolder(6, R.string.mouse_pager_header_title, R.drawable.setting_item_icon_mouse_land);
        this.mGesture = new ItemViewHolder(7, R.string.screen_gesture, R.drawable.setting_item_icon_gesture);
        this.mVoiceInput = new ItemViewHolder(10, R.string.voiceinput_pager_header_title, R.drawable.setting_item_icon_voiceinput_land);
        this.mBytedanceTnt = new ItemViewHolder(11, R.string.connection_mode_pager_header_title, R.drawable.setting_item_tnt_screen_land);
        this.mBostonSettings = new ItemViewHolder(12, R.string.boston_settings, R.drawable.setting_item_boston_setting);
        HeaderViewHolder r2 = new HeaderViewHolder(this.mContext.getString(R.string.header_item_hardware_title));
        ArrayList<ViewHolder> r3 = new ArrayList();
        r3.add(this.mKeyboard);
        if (CasthalManager.getInstance(this).isKeyboardConnected() == false) goto L5;
        r3.add(this.mTouchpad);
    L5:
        r3.add(this.mMouse);
        if (Constants.sIsBostonConnected == false) goto L8;
        r3.add(this.mStylus);
    L8:
        r3.add(this.mGesture);
        r3.add(this.mVoiceInput);
        r3.add(this.mBytedanceTnt);
        if (Constants.sIsBostonConnected == false) goto L11;
        r3.add(this.mBostonSettings);
    L11:
        r2.setChildren(r3);
        mHeaderViewHolders.add(r2);
        this.mBigBang = new ItemViewHolder(17, R.string.text_boom_settings, R.drawable.setting_item_big_bang_land);
        this.mOneStep = new ItemViewHolder(18, R.string.one_step_settings, R.drawable.setting_item_icon_onestep_land);
        this.mthinkboost = new ItemViewHolder(19, R.string.idea_pills_beta, R.drawable.setting_item_icon_pills_land);
        HeaderViewHolder r4 = new HeaderViewHolder(this.mContext.getString(R.string.header_item_tool_title));
        ArrayList<ViewHolder> r5 = new ArrayList();
        r5.add(this.mOneStep);
        r5.add(this.mthinkboost);
        r4.setChildren(r5);
        mHeaderViewHolders.add(r4);
        this.mWlan = new ItemViewHolder(13, R.string.wifi_settings_title, R.drawable.setting_item_icon_wifi_land);
        this.mCellular = new ItemViewHolder(14, R.string.data_usage_summary_title, R.drawable.setting_item_icon_data_land);
        this.mNetwork = new ItemViewHolder(15, R.string.network_pager_header_title, R.drawable.setting_item_icon_moreweb_land);
        this.mBluetooth = new ItemViewHolder(16, R.string.bluetooth_settings_title, R.drawable.setting_item_icon_bluetooth_land);
        HeaderViewHolder r6 = new HeaderViewHolder(this.mContext.getString(R.string.header_item_network_title));
        ArrayList<ViewHolder> r7 = new ArrayList();
        r7.add(this.mWlan);
        r7.add(this.mCellular);
        r7.add(this.mBluetooth);
        r7.add(this.mNetwork);
        r6.setChildren(r7);
        mHeaderViewHolders.add(r6);
        this.mNotification = new ItemViewHolder(21, R.string.system_notification_title, R.drawable.setting_item_icon_notification_land);
        this.mApplication = new ItemViewHolder(20, R.string.manager_application, R.drawable.setting_item_icon_appmanage_land);
        this.mCloud = new ItemViewHolder(22, R.string.cloud_setting_title, R.drawable.setting_item_icon_cloud_land);
        this.mAdvanced = new ItemViewHolder(23, R.string.advanced_settings_header_title, R.drawable.setting_item_icon_morenet_land);
        this.mOta = new ItemViewHolder(24, R.string.about_item_title_update, R.drawable.setting_item_icon_update_land);
        this.mAbout = new ItemViewHolder(25, R.string.about_settings, R.drawable.setting_item_icon_about_land);
        if (Utils.findSystemUpdatable(this) == false) goto L14;
        this.mOta.setRightIconResId(R.drawable.badge_bg);
    L14:
        HeaderViewHolder r8 = new HeaderViewHolder(this.mContext.getString(R.string.header_item_system_title));
        ArrayList<ViewHolder> r9 = new ArrayList();
        r9.add(this.mNotification);
        r9.add(this.mApplication);
        r9.add(this.mCloud);
        r9.add(this.mAdvanced);
        r9.add(this.mOta);
        r9.add(this.mAbout);
        r8.setChildren(r9);
        mHeaderViewHolders.add(r8);
    }

    public void com_android_settings_LandscapeSettings__onNewIntent$___twin___(Intent r2) {
        super.onNewIntent(r2);
        tryHandleRoute(r2);
        OLog.d(TAG, "onNewIntent " + r2);
    }

    @Override // com.android.settings.base.BaseActivity
    public <T extends Fragment> T getBindFragment() {
        throw new RuntimeException("subclass of MainSettings must overwrite getBindFragment method,and return real fragment instance");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        Fragment r0 = getTopFragment();
        if (r0 == null) goto L6;
        r0.onActivityResult(r1, r2, r3);
        return;
    }

    @Override // obric.tablet.navigationlist.HeaderListAdapter.OnItemClickListener
    public void onItemClicked(View r5, ItemViewHolder r6) {
        int r7 = r6.getId();
        this.mLaunchPage = null;
        this.mLanguageView.setActivated(false);
        Intent r8 = new Intent();
        r8.putExtra("back_text_id", R.string.default_value);
        r8.putExtra(Utils.EXTRA_FROM_SETTINGS, true);
        switch(r7) {
            case 0: goto L29;
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L55;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L55;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L18;
            case 14: goto L17;
            case 15: goto L16;
            case 16: goto L15;
            case 17: goto L14;
            case 18: goto L13;
            case 19: goto L12;
            case 20: goto L11;
            case 21: goto L10;
            case 22: goto L9;
            case 23: goto L8;
            case 24: goto L7;
            case 25: goto L6;
            case 26: goto L5;
            default: goto L55;
        };
    L5:
        replaceFragment(StylusSearchFragment.class);
        return;
    L6:
        replaceFragment(AboutPhoneFragment.class);
        return;
    L7:
        replaceFragment(EmptyFragment.class);
        r8.setClassName("com.bytedanceos.updater", "com.bytedanceos.updater.TntUpdatesCheck");
        r8.setFlags(268468224);
        return;
    L8:
        replaceFragment(AdvancedSettingsFragment.class);
        return;
    L9:
        replaceFragment(EmptyFragment.class);
        r8.setClassName("com.bytedanceos.cloudsync", "com.bytedanceos.accounts.AccountsActivity");
        r8.setAction("android.intent.action.MAIN");
        r8.putExtra("bytedance_origin_app_tag", "settings");
        r8.setFlags(268468224);
        return;
    L10:
        replaceFragment(NotificationSettingsFragment.class);
        return;
    L11:
        replaceFragment(EmptyFragment.class);
        r8.setClassName(Constants.PKG_SECURITY, "com.bytedanceos.appmanager.ApplicationManagerActivitySettings");
        r8.setAction("android.intent.action.MAIN");
        r8.putExtra(BaseActivity.EXTRA_FROM_SECURITY, false);
        r8.setFlags(268468224);
        return;
    L12:
        replaceFragment(EmptyFragment.class);
        r8.setClassName("com.bytedanceos.sara", "com.bytedanceos.sara.bubble.SettingActivity");
        r8.setAction("android.intent.action.MAIN");
        r8.setFlags(268468224);
        return;
    L13:
        replaceFragment(EmptyFragment.class);
        r8.setClassName("com.bytedanceos.sidebar", "com.bytedanceos.sidebar.setting.SettingActivity");
        r8.putExtra("back_text", getString(R.string.settings_label));
        r8.putExtra("from_setting", 1);
        r8.setAction("android.intent.action.MAIN");
        r8.setFlags(268468224);
        return;
    L14:
        replaceFragment(RevoneTextBoomSettingsFragment.class);
        return;
    L15:
        replaceFragment(BluetoothSettingsFragment.class);
        return;
    L16:
        replaceFragment(NetworkSettingsFragment.class);
        return;
    L17:
        replaceFragment(EmptyFragment.class);
        r8.setClassName("com.android.phone", "com.android.phone.MobileNetworkSettingsTnt");
        r8.setFlags(268468224);
        return;
    L18:
        replaceFragment(WifiSettings.class);
        return;
    L19:
        replaceFragment(BostonSettingsFragment.class);
        return;
    L20:
        replaceFragment(TntAssistFragment.class);
        return;
    L21:
        replaceFragment(TNTVoiceSettings.class);
        return;
    L22:
        replaceFragment(TNTSoundSettingsFragment.class);
        return;
    L23:
        replaceFragment(GestureFragment.class);
        return;
    L24:
        replaceFragment(MouseSettingsFragment.class);
        return;
    L25:
        replaceFragment(TouchpadSettingsFragment.class);
        return;
    L26:
        replaceFragment(KeyboardSettingsFragment.class);
        return;
    L27:
        replaceFragment(DockSettingsFragment.class);
        return;
    L28:
        replaceFragment(WindowTitleBarStyleFragment.class);
        return;
    L29:
        replaceFragment(TabletWallpaperSettings.class);
        return;
    }

    private View createLanguageView() {
        View r0 = LayoutInflater.from(this.mContext).inflate(R.layout.tablet_list_footer_view, null);
        ImageView r1 = (ImageView) NullSafe.nonNull(r0.findViewById(R.id.image_view));
        this.mLanguageView = r1;
        r1.setOnClickListener(new AnonymousClass4(this));
        return r0;
    }

    private void replaceFragment(Class<?> r2) {
        replaceFragment(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void replaceFragment(Class<?> r2, Bundle r3) {
        Fragment r0 = createSupportFragment(r2);
        if (r0 != 0) goto L5;
        return;
    L5:
        bindBundle(r0, r3);
        Fragment r4 = getTopFragment();
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.getClass() != r2) goto L10;
        return;
    L10:
        if (r2 != SearchFragment.class) goto L12;
        this.mSearchTextListener = (SearchTextListener) r0;
    L13:
        replaceFragment(r0, false);
        return;
    L12:
        clearSearchEditText();
        goto L13
    }

    private Fragment createSupportFragment(Class<?> r2) {
        return (Fragment) r2.getConstructor(new Class[0]).newInstance(new Object[0]);
    L5:
        e = move-exception;
        e.printStackTrace();
        OLog.w(TAG, "failed create class " + SearchFragment.class);
        return null;
    }

    protected void bindBundle(Fragment r4, Bundle r5) {
        OLog.d(TAG, "bindBundle Fragment : " + r4 + " , Bundle : " + r5);
        if (r4 != null) goto L6;
        return;
    L6:
        if ((r4 instanceof BaseFragment) == false) goto L19;
        BaseFragment r6 = (BaseFragment) r4;
        if (r5 != null) goto L11;
        r5 = new Bundle();
    L11:
        if (TextUtils.isEmpty(this.mLaunchPage) == false) goto L13;
        r5.putBoolean(BaseActivity.EXTRA_SHOW_TITLE_BACK_BTN, false);
    L17:
        r6.setArguments(r5);
        return;
    L13:
        if (StepBackUtils.getStepBackList(this.mLaunchPage).size() > 0) goto L15;
        r5.putBoolean(BaseActivity.EXTRA_SHOW_TITLE_BACK_BTN, false);
    L15:
        r5.putString(LAUNCH_PAGE_KEY, this.mLaunchPage);
        goto L17
    }

    protected void updateSelectedItem(Fragment r3) {
        if (r3 == null) goto L58;
        HeaderListAdapter r0 = this.mHeaderListAdapter;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getSelectedItem() == null) goto L10;
        this.mHeaderListAdapter.getSelectedItem().setSelected(false);
    L10:
        if ((r3 instanceof TabletWallpaperSettings) == false) goto L13;
        this.mHeaderListAdapter.setSelectedItem(this.mWallpaper);
        return;
    L13:
        if ((r3 instanceof WindowTitleBarStyleFragment) == false) goto L16;
        this.mHeaderListAdapter.setSelectedItem(this.mWindow);
        return;
    L16:
        if ((r3 instanceof DockSettingsFragment) == false) goto L19;
        this.mHeaderListAdapter.setSelectedItem(this.mDock);
        return;
    L19:
        if ((r3 instanceof KeyboardSettingsFragment) == false) goto L22;
        this.mHeaderListAdapter.setSelectedItem(this.mKeyboard);
        return;
    L22:
        if ((r3 instanceof MouseSettingsFragment) == false) goto L25;
        this.mHeaderListAdapter.setSelectedItem(this.mMouse);
        return;
    L25:
        if ((r3 instanceof TNTSoundSettingsFragment) == false) goto L28;
        this.mHeaderListAdapter.setSelectedItem(this.mVoice);
        return;
    L28:
        if ((r3 instanceof TNTVoiceSettings) == false) goto L31;
        this.mHeaderListAdapter.setSelectedItem(this.mVoiceInput);
        return;
    L31:
        if ((r3 instanceof TntAssistFragment) == false) goto L34;
        this.mHeaderListAdapter.setSelectedItem(this.mBytedanceTnt);
        return;
    L34:
        if ((r3 instanceof BostonSettingsFragment) == false) goto L37;
        this.mHeaderListAdapter.setSelectedItem(this.mBostonSettings);
        return;
    L37:
        if ((r3 instanceof WifiSettings) == false) goto L40;
        this.mHeaderListAdapter.setSelectedItem(this.mWlan);
        return;
    L40:
        if ((r3 instanceof NetworkSettingsFragment) == false) goto L43;
        this.mHeaderListAdapter.setSelectedItem(this.mNetwork);
        return;
    L43:
        if ((r3 instanceof BluetoothSettingsFragment) == false) goto L46;
        this.mHeaderListAdapter.setSelectedItem(this.mBluetooth);
        return;
    L46:
        if ((r3 instanceof RevoneTextBoomSettingsFragment) == false) goto L49;
        this.mHeaderListAdapter.setSelectedItem(this.mBigBang);
        return;
    L49:
        if ((r3 instanceof NotificationSettingsFragment) == false) goto L52;
        this.mHeaderListAdapter.setSelectedItem(this.mNotification);
        return;
    L52:
        if ((r3 instanceof AdvancedSettingsFragment) == false) goto L55;
        this.mHeaderListAdapter.setSelectedItem(this.mAdvanced);
        return;
    L55:
        if ((r3 instanceof PreferredActivityCategoryFragment) == false) goto L74;
        this.mHeaderListAdapter.setSelectedItem(this.mApplication);
        return;
    L74:
        return;
    }

    private Bundle createSearchBundle(String r2) {
        Bundle r1 = new Bundle();
        r1.putString(SearchFragment.SEARCH_KEY, r2);
        return r1;
    }

    private void clearSearchEditText() {
        if (TextUtils.isEmpty(this.mSearchEditor.getText()) == true) goto L5;
        this.mSearchEditor.setText("");
    L5:
        this.mSearchEditor.clearFocus();
        this.mSearchTextListener = null;
    }

    public void com_android_settings_LandscapeSettings__onResume$___twin___() {
        super.onResume();
        if (this.mIsLandScreen == false) goto L6;
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mLocaleChangeReceiver, new IntentFilter("android.intent.action.LOCALE_CHANGED"), 2);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mKeyboardReceiver, new IntentFilter(CasthalManager.HALL_KEYBOARD_CONNECTION_CHANGED_ACTION), 2);
        return;
    }

    public void com_android_settings_LandscapeSettings__onPause$___twin___() {
        super.onPause();
        if (this.mIsLandScreen == false) goto L6;
        unregisterReceiver(this.mLocaleChangeReceiver);
        unregisterReceiver(this.mKeyboardReceiver);
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r2) {
        super.onWindowFocusChanged(r2);
        Fragment r1 = getTopFragment();
        if ((r1 instanceof BaseFragment) == false) goto L6;
        ((BaseFragment) r1).onWindowFocusChanged(r2);
        return;
    }

    private boolean tryHandleRoute(Intent r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        ComponentName r1 = r7.getComponent();
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L13;
        return false;
    L13:
        String r3 = r7.getStringExtra("route_target_page");
        if (TextUtils.isEmpty(r3) == false) goto L16;
        return false;
    L16:
        r3.hashCode();
        if (r3.equals("ota") == true) goto L19;
        return false;
    L19:
        Intent r4 = new Intent("android.intent.action.MAIN");
        r4.setClassName("com.obric.updater", "com.obric.updater.UpdatesCheck");
        Bundle r8 = r7.getExtras();
        if (r8 == null) goto L22;
        r4.putExtras(r8);
    L22:
        r4.removeExtra("route_target_page");
        startActivityForResult(r4, 0);
        return true;
    L8:
        if (r1.getClassName().equals("com.android.settings.RouteActivity") == false) goto L10;
        r2 = true;
        goto L11
    }

    @Insert("onCreate")
    public static void com_android_settings_LandscapeSettings_com_obric_hook_lancet_PrivacyHook_onCreate(LandscapeSettings r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LandscapeSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_LandscapeSettings__onCreate$___twin___(r4);
    }

    @Insert("onResume")
    public static void com_android_settings_LandscapeSettings_com_obric_hook_lancet_PrivacyHook_onResume(LandscapeSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LandscapeSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_LandscapeSettings__onResume$___twin___();
    }

    @Insert("onPause")
    public static void com_android_settings_LandscapeSettings_com_obric_hook_lancet_PrivacyHook_onPause(LandscapeSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LandscapeSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_LandscapeSettings__onPause$___twin___();
    }

    @Insert("onNewIntent")
    public static void com_android_settings_LandscapeSettings_com_obric_hook_lancet_PrivacyHook_onNewIntent(LandscapeSettings r3, Intent r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        LandscapeSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onNewIntentWhenPrivacyNotOk(null);
        r0.superOnNewIntent(r4);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_LandscapeSettings__onNewIntent$___twin___(r4);
    }
}
