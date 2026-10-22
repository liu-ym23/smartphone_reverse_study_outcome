package com.android.settings;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.api.PackageManagerSmt;
import com.android.settings.applications.PreferredActivityChooserFragment;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.LauncherPreview;
import com.android.settings.widget.VerticalOptionsCheckView;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.api.WindowManagerSmt;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes2.dex */
public class LauncherSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, LauncherPreview.Callback, VerticalOptionsCheckView.OptionSelectListener {
    private static final String BYTEDANCE_LAUNCHER_ACTIVITY = "com.bytedanceos.launcher.Launcher";
    private static final String BYTEDANCE_LAUNCHER_PKG_NAME = "com.bytedanceos.launcher";
    private static final int DIALOG_ID_SWITCH_LAUNCHER = 1;
    private static final int DIALOG_ID_SWITCH_LAUNCHER_MODE_DEGRADE = 2;
    private static final int DIALOG_ID_SWITCH_LAUNCHER_THEME = 3;
    public static final long LAUNCH_NEW_LAUNCHER_DELAY_MILLIS = 200;
    private static final int MSG_LAUNCH_NEW_LAUNCHER = 1;
    private static final String ORIGINAL_LAUNCHER_ACTIVITY = "com.android.launcher3.Launcher";
    private static final String ORIGINAL_LAUNCHER_PKG_NAME = "com.android.launcher3";
    private static final String TAG = "LauncherSettings";
    private static final Handler sHandler = null;
    private final String BYTEDANCE_HOME;
    private final String ORIGINAL_HOME;
    private PreviewSettingItemView grids36Preview;
    private PreviewSettingItemView grids81Preview;
    private SettingItemText mBytedanceHomeEnable;
    private Context mContext;
    private VerticalOptionsCheckView mDockFlipView;
    private View mHideLableBottomGap;
    IntentFilter mHomeFilter;
    Intent mIntentHome;
    private boolean mIsThirdLauncher;
    private SettingItemSwitch mItemHideLable;
    private SettingItemSwitch mItemIconIllumination;
    private SettingItemTextVertical mItemLauncherAnim;
    private SettingItemTextVertical mItemLauncherTheme;
    private SettingItemTextVertical mItemLauncherWallpaper;
    private SettingItemSwitch mItemOriginalLauncherBlur;
    private SettingItemSwitch mItemUnlockAnim;
    private TextView mLauncherModelTitle;
    private LauncherPreview mLauncherPreview;
    private AlertDialog mLauncherSwitchDialog;
    private View mLauncherThemeStub;
    private TextView mMultiBlockTips;
    private int mNewLauncherMode;
    private int mNewMultiBlockMode;
    private int mOldLauncherMode;
    private Activity mParent;
    PackageManager mPm;
    private View mThemeSettingsBottomGap;
    private boolean mTransparentThemeOn;
    private View mViewLauncherTheme;
    private View mViewMultiBlocks;
    private View mViewSwitchers;

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        return R.string.launcher_settings_options;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_LauncherSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_LauncherSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.base.BaseFragment
    protected boolean shouldMonitorExtDisplayStatus() {
        return true;
    }

    public LauncherSettingsFragment() {
        this.BYTEDANCE_HOME = "com.bytedanceos.launcher";
        this.ORIGINAL_HOME = "com.android.launcher3";
    }

    static /* synthetic */ SettingItemSwitch access$000(LauncherSettingsFragment r0) {
        return r0.mItemIconIllumination;
    }

    static /* synthetic */ Context access$100(LauncherSettingsFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ SettingItemTextVertical access$200(LauncherSettingsFragment r0) {
        return r0.mItemLauncherTheme;
    }

    static {
        sHandler = new AnonymousClass1();
    }

    public void com_android_settings_LauncherSettingsFragment__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        this.mContext = getActivity().getApplicationContext();
        IntentFilter r5 = new IntentFilter("android.intent.action.MAIN");
        this.mHomeFilter = r5;
        r5.addCategory("android.intent.category.HOME");
        this.mHomeFilter.addCategory("android.intent.category.DEFAULT");
        Intent r6 = new Intent("android.intent.action.MAIN");
        this.mIntentHome = r6;
        r6.addCategory("android.intent.category.HOME");
        this.mIntentHome.addCategory("android.intent.category.DEFAULT");
        FragmentActivity r7 = getActivity();
        this.mParent = r7;
        this.mPm = r7.getPackageManager();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.launcher_settings_activity, r3, false);
        LauncherPreview r5 = (LauncherPreview) findViewByIdNullable(R.id.id_launcher_preview);
        this.mLauncherPreview = r5;
        r5.setCallback(this);
        this.mLauncherThemeStub = NullSafe.nonNull(findViewByIdNullable(R.id.laucher_theme_viewstub));
        this.mLauncherModelTitle = (TextView) findViewByIdNullable(R.id.bytedance_launcher_mode_title);
        SettingItemText r6 = (SettingItemText) findViewByIdNullable(R.id.bytedance_desktop_enable);
        this.mBytedanceHomeEnable = r6;
        r6.setOnClickListener(this);
        if (SettingsFeature.isSupportSwitchLauncher() == false) goto L5;
        this.mBytedanceHomeEnable.setVisibility(0);
    L5:
        this.mViewMultiBlocks = findViewByIdNullable(R.id.multi_block_viewstub);
        this.mViewLauncherTheme = NullSafe.nonNull(findViewByIdNullable(R.id.laucher_theme_viewstub));
        this.mViewSwitchers = findViewByIdNullable(R.id.launcher_settings_switcher_viewstub);
        this.mItemOriginalLauncherBlur = (SettingItemSwitch) findViewByIdNullable(R.id.original_launcher_blur_switch);
        this.mItemIconIllumination = (SettingItemSwitch) findViewByIdNullable(R.id.item_id_icon_illumination);
        if (SettingsFeature.isSupportIconIllumination() == false) goto L8;
        this.mItemIconIllumination.setVisibility(0);
    L8:
        this.mItemHideLable = (SettingItemSwitch) findViewByIdNullable(R.id.item_id_hide_lable);
        View r7 = findViewByIdNullable(R.id.hide_lable_bottom_gap);
        this.mHideLableBottomGap = r7;
        r7.setVisibility(8);
        this.mThemeSettingsBottomGap = findViewByIdNullable(R.id.launcher_theme_bottom_gap);
        VerticalOptionsCheckView r8 = (VerticalOptionsCheckView) findViewByIdNullable(R.id.id_launcher_setting_docker_view);
        this.mDockFlipView = r8;
        r8.setTitle(R.string.launcher_flip_orientation_title);
        this.mDockFlipView.setOptionSelectListener(this);
        EventBus.getDefault().register(this);
        initBottomView();
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment
    protected void onExtDisplayChanged(boolean r1) {
        updateExtDisplayItems(r1);
    }

    public void com_android_settings_LauncherSettingsFragment__onResume$___twin___() {
        super.onResume();
        OLog.d(TAG, "onResume");
        registerSwitch(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateDockPreview();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateViews() {
        updateLauncherModeView();
        updateSwitches();
        updateExtDisplayItems(this.mIsExtDisplayConnected);
    }

    private void updateExtDisplayItems(boolean r1) {
        this.mBytedanceHomeEnable.setEnabled(!r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        registerSwitch(null);
    }

    private void registerSwitch(CompoundButton.OnCheckedChangeListener r2) {
        this.mItemIconIllumination.setOnCheckedChangeListener(r2);
        this.mItemHideLable.setOnCheckedChangeListener(r2);
        this.mItemUnlockAnim.setOnCheckedChangeListener(this);
        this.mItemOriginalLauncherBlur.setOnCheckedChangeListener(r2);
    }

    private void initBottomView() {
        this.grids36Preview = (PreviewSettingItemView) this.mViewMultiBlocks.findViewById(R.id.multi_block_36_grids);
        this.grids81Preview = (PreviewSettingItemView) NullSafe.nonNull(this.mViewMultiBlocks.findViewById(R.id.multi_block_81_grids));
        this.mMultiBlockTips = (TextView) this.mViewMultiBlocks.findViewById(R.id.multi_block_tips);
        this.grids36Preview.setOnClickListener(this);
        this.grids81Preview.setOnClickListener(this);
        this.mItemUnlockAnim = (SettingItemSwitch) this.mViewSwitchers.findViewById(R.id.item_id_unlock_anim);
        this.mItemLauncherWallpaper = (SettingItemTextVertical) this.mViewLauncherTheme.findViewById(R.id.item_id_launcher_wallpaper);
        int r0 = (int) getResources().getDimension(R.dimen.wallpaper_settings_item_icon_width);
        int r1 = (int) getResources().getDimension(R.dimen.wallpaper_settings_item_icon_height);
        this.mItemLauncherWallpaper.setIconScale(r0, r1);
        this.mItemLauncherWallpaper.setOnClickListener(this);
        SettingItemTextVertical r2 = (SettingItemTextVertical) this.mViewLauncherTheme.findViewById(R.id.item_id_launcher_theme);
        this.mItemLauncherTheme = r2;
        if (r2 == null) goto L5;
        r2.setOnClickListener(this);
    L5:
        SettingItemTextVertical r3 = (SettingItemTextVertical) this.mViewLauncherTheme.findViewById(R.id.item_id_launcher_anim);
        this.mItemLauncherAnim = r3;
        if (r3 == null) goto L9;
        r3.setOnClickListener(this);
        return;
    }

    private static void setLauncherGridsCount(ContentResolver r1, int r2, int r3) {
        android.provider.Settings.Global.putInt(r1, "launcher_grids_x", r2);
        android.provider.Settings.Global.putInt(r1, "launcher_grids_y", r3);
    }

    private int getDefaultLauncherMode() {
        return Utils.getCurrentLauncherMode(this.mContext);
    }

    public static void setDefaultLauncherMode(ContentResolver r3, int r4) {
        android.provider.Settings.Global.putInt(r3, "launcher_mode", r4);
        if (r4 != 9) goto L5;
        setLauncherGridsCount(r3, 3, 3);
        return;
    L5:
        if (r4 != 12) goto L7;
        setLauncherGridsCount(r3, 3, 4);
        return;
    L7:
        if (r4 != 16) goto L9;
        setLauncherGridsCount(r3, 4, 4);
        return;
    L9:
        if (r4 != 20) goto L19;
        setLauncherGridsCount(r3, 4, 5);
        return;
    }

    private static int getDefaultMultiBlockMode(Context r0) {
        return Utils.getCurrentLauncherMultiBlockMode(r0);
    }

    public void setupDefaultMultiBlockMode() {
        setupDefaultMultiBlockMode(this.mParent.getContentResolver(), this.mNewMultiBlockMode);
    }

    public static void setupDefaultMultiBlockMode(ContentResolver r1, int r2) {
        android.provider.Settings.Global.putInt(r1, "multi_block_mode", r2);
    }

    private void setHideLabel(boolean r2) {
        android.provider.Settings.System.putString(this.mParent.getContentResolver(), "launcher_hide_lable", Boolean.toString(r2));
    }

    private boolean isHideLabel() {
        String r2 = android.provider.Settings.System.getString(this.mParent.getContentResolver(), "launcher_hide_lable");
        OLog.d(TAG, "isHideLabel changed ; current value is " + r2);
        return Boolean.parseBoolean(r2);
    }

    private void setOriginalLauncherBlur(boolean r2) {
        android.provider.Settings.Global.putInt(this.mParent.getContentResolver(), "original_launcher_wallpaper_blur_on", r2 ? 1 : 0);
    }

    private boolean isOriginalLauncherBlurOn() {
        if (android.provider.Settings.Global.getInt(this.mParent.getContentResolver(), "original_launcher_wallpaper_blur_on", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setUnlockAnimEnabled(boolean r2) {
        android.provider.Settings.Global.putInt(this.mParent.getContentResolver(), "launcher_unlock_animation_enabled", r2 ? 1 : 0);
    }

    private boolean isUnlockAnimEnabled() {
        if (android.provider.Settings.Global.getInt(this.mParent.getContentResolver(), "launcher_unlock_animation_enabled", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isTransparentThemeOn() {
        if (android.provider.Settings.Global.getInt(this.mParent.getContentResolver(), "launcher_grid_theme", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void updateLauncherModeView() {
        OLog.d(TAG, "updateLauncherModeView");
        this.mIsThirdLauncher = Utils.isThirdPartHome(this.mParent);
        int r0 = getDefaultLauncherMode();
        this.mOldLauncherMode = r0;
        this.mNewLauncherMode = r0;
        this.mNewMultiBlockMode = getDefaultMultiBlockMode(this.mParent);
        boolean r1 = isTransparentThemeOn();
        this.mTransparentThemeOn = r1;
        boolean r3 = false;
        if (this.mIsThirdLauncher == true) goto L8;
        int r2 = this.mNewLauncherMode;
        if (r2 == 0) goto L8;
        this.mLauncherPreview.updateViews(r2, r1);
        this.mLauncherPreview.setVisibility(0);
    L9:
        updateEnableBytedanceHomeView();
        if (this.mIsThirdLauncher == false) goto L13;
        this.mLauncherModelTitle.setVisibility(8);
        this.mViewMultiBlocks.setVisibility(8);
        this.mViewSwitchers.setVisibility(8);
        this.mViewLauncherTheme.setVisibility(0);
        this.mItemLauncherAnim.setVisibility(8);
        this.mItemLauncherTheme.setVisibility(8);
        this.mItemLauncherWallpaper.setVisibility(0);
        this.mItemOriginalLauncherBlur.setVisibility(8);
        this.mItemHideLable.setVisibility(8);
        this.mHideLableBottomGap.setVisibility(8);
        this.mThemeSettingsBottomGap.setVisibility(8);
        this.mItemIconIllumination.setVisibility(8);
        findViewByIdNullable(R.id.icon_illumination_tips).setVisibility(8);
        updateDockFlipView(false);
        updateLauncherWallpaperIcon();
        return;
    L13:
        int r4 = this.mNewLauncherMode;
        if (r4 != 0) goto L16;
        this.mLauncherModelTitle.setVisibility(8);
        this.mViewMultiBlocks.setVisibility(8);
        this.mViewSwitchers.setVisibility(8);
        this.mViewLauncherTheme.setVisibility(0);
        this.mItemLauncherAnim.setVisibility(8);
        this.mItemLauncherTheme.setVisibility(8);
        this.mItemLauncherWallpaper.setVisibility(0);
        this.mItemOriginalLauncherBlur.setVisibility(0);
        this.mItemHideLable.setBackgroundStyle(4);
        this.mItemHideLable.setVisibility(0);
        this.mHideLableBottomGap.setVisibility(0);
        this.mThemeSettingsBottomGap.setVisibility(8);
        this.mItemIconIllumination.setVisibility(8);
        findViewByIdNullable(R.id.icon_illumination_tips).setVisibility(8);
    L38:
        if (android.provider.Settings.Global.getInt(this.mParent.getContentResolver(), "launcher_switching_orientation", 0) != 0) goto L40;
        r3 = true;
    L40:
        updateLauncherThemePreview();
        updateDockFlipView(r3);
        updateDockPreview();
        updateMultiBlockView();
        updateLauncherAnimPreview();
        updateLauncherWallpaperIcon();
        return;
    L16:
        if (r4 != 9) goto L18;
    L27:
        this.mLauncherModelTitle.setVisibility(0);
        this.mViewSwitchers.setVisibility(0);
        this.mViewLauncherTheme.setVisibility(0);
        this.mItemUnlockAnim.setVisibility(0);
        updateThemeViews();
        this.mItemOriginalLauncherBlur.setVisibility(8);
        this.mItemHideLable.setBackgroundStyle(2);
        this.mItemHideLable.setVisibility(0);
        this.mHideLableBottomGap.setVisibility(8);
        this.mThemeSettingsBottomGap.setVisibility(0);
        if (this.mNewLauncherMode == 9) goto L30;
    L32:
        this.mViewMultiBlocks.setVisibility(8);
    L34:
        if (SettingsFeature.isSupportIconIllumination() == false) goto L38;
        this.mItemIconIllumination.setVisibility(0);
        findViewByIdNullable(R.id.icon_illumination_tips).setVisibility(0);
        goto L38
    L30:
        if (SettingsFeature.isLauncher81GridsSupport() == false) goto L32;
        this.mViewMultiBlocks.setVisibility(0);
        goto L34
    L18:
        if (r4 == 12) goto L27;
        if (r4 != 16) goto L22;
    L24:
        this.mLauncherModelTitle.setVisibility(0);
        this.mViewMultiBlocks.setVisibility(8);
        this.mViewSwitchers.setVisibility(0);
        this.mViewLauncherTheme.setVisibility(0);
        this.mItemUnlockAnim.setVisibility(0);
        updateThemeViews();
        this.mItemOriginalLauncherBlur.setVisibility(8);
        this.mItemHideLable.setBackgroundStyle(2);
        this.mItemHideLable.setVisibility(0);
        this.mHideLableBottomGap.setVisibility(8);
        this.mThemeSettingsBottomGap.setVisibility(0);
        if (SettingsFeature.isSupportIconIllumination() == false) goto L38;
        this.mItemIconIllumination.setVisibility(0);
        findViewByIdNullable(R.id.icon_illumination_tips).setVisibility(0);
        goto L38
    L22:
        if (r4 == 20) goto L24;
    L8:
        this.mLauncherPreview.setVisibility(8);
        goto L9
    }

    private void updateThemeViews() {
        if (this.mTransparentThemeOn == false) goto L5;
        this.mItemLauncherWallpaper.setVisibility(0);
        this.mItemLauncherTheme.setVisibility(8);
        this.mItemLauncherAnim.setVisibility(8);
        return;
    L5:
        this.mItemLauncherWallpaper.setVisibility(8);
        this.mItemLauncherTheme.setVisibility(0);
        this.mItemLauncherAnim.setVisibility(0);
    }

    private void updateMultiBlockView() {
        int r0 = this.mNewMultiBlockMode;
        if (r0 != 36) goto L5;
        this.grids36Preview.setChecked(true);
        this.grids81Preview.setChecked(false);
        this.mMultiBlockTips.setText(R.string.launcher_multi_block_mode_tips_36);
        return;
    L5:
        if (r0 != 81) goto L11;
        this.grids36Preview.setChecked(false);
        this.grids81Preview.setChecked(true);
        this.mMultiBlockTips.setText(R.string.launcher_multi_block_mode_tips_81);
        return;
    }

    private void updateSwitches() {
        SettingItemSwitch r0 = this.mItemIconIllumination;
        boolean r3 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "icon_illumination", 0) != 1) goto L5;
        r3 = true;
    L5:
        r0.setChecked(r3);
        this.mItemHideLable.setChecked(isHideLabel());
        this.mItemUnlockAnim.setChecked(isUnlockAnimEnabled());
        this.mItemOriginalLauncherBlur.setChecked(isOriginalLauncherBlurOn());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5 != this.grids36Preview) goto L6;
        this.mNewMultiBlockMode = 36;
        updateMultiBlockView();
        setupDefaultMultiBlockMode();
        updateDockPreview();
        return;
    L6:
        if (r5 != this.grids81Preview) goto L9;
        this.mNewMultiBlockMode = 81;
        updateMultiBlockView();
        setupDefaultMultiBlockMode();
        updateDockPreview();
        return;
    L9:
        if (r5 != this.mItemLauncherWallpaper) goto L12;
        start(ChooseWallpaperTypeFragment.newInstance(2));
        SettingsTracker.onItemClick(PointerIconCompat.TYPE_VERTICAL_TEXT);
        return;
    L12:
        if (r5 != this.mItemLauncherTheme) goto L15;
        Intent r6 = new Intent();
        r6.setClassName("com.bytedanceos.launcher", "com.bytedanceos.launcher.theme.ThemeChooserActivity");
        r6.setAction("android.intent.action.MAIN");
        r6.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        r6.putExtra(BaseActivity.FROM_ACTIVITY, "launcher");
        r6.putExtra(Utils.EXTRA_FROM_SETTINGS, true);
        Utils.startActivity(this.mParent, r6, 0);
        SettingsTracker.onItemClick(1002);
        return;
    L15:
        if (r5 != this.mItemLauncherAnim) goto L18;
        start(LauncherAnimPreviewFragment.class);
        SettingsTracker.onItemClick(1003);
        return;
    L18:
        if (r5 != this.mBytedanceHomeEnable) goto L26;
        PreferredActivityChooserFragment r7 = new PreferredActivityChooserFragment();
        Bundle r0 = new Bundle();
        r0.putParcelable("filter", this.mHomeFilter);
        r0.putInt("title_id", R.string.bytedance_desktop_enable);
        r0.putInt("position", 0);
        r7.setArguments(r0);
        start(r7);
        SettingsTracker.onItemClick(1001);
        return;
    }

    private void switchLauncherTo(int r2) {
        if (r2 != 9) goto L5;
        this.mNewLauncherMode = 9;
        this.mNewMultiBlockMode = getLast9LauncherMultiPanelMode(this.mParent);
    L17:
        if (this.mNewLauncherMode >= this.mOldLauncherMode) goto L19;
        int r3 = 2;
    L20:
        showDialogType(r3);
        return;
    L19:
        r3 = 1;
        goto L20
    L5:
        if (r2 != 12) goto L7;
        this.mNewLauncherMode = 12;
        this.mNewMultiBlockMode = 48;
        goto L17
    L7:
        if (r2 != 16) goto L9;
        this.mNewLauncherMode = 16;
        this.mNewMultiBlockMode = 64;
        goto L17
    L9:
        if (r2 == 20) goto L12;
        OLog.w(TAG, "invalid launcher type " + r2);
        return;
    L12:
        this.mNewLauncherMode = 20;
        this.mNewMultiBlockMode = 80;
        goto L17
    }

    private static int getMultiBlockMode(Context r1, int r2) {
        if (r2 == 9) goto L19;
        if (r2 != 12) goto L7;
        return 48;
    L7:
        if (r2 != 16) goto L9;
        return 64;
    L9:
        if (r2 == 20) goto L12;
        return 0;
    L12:
        return 80;
    L19:
        return getLast9LauncherMultiPanelMode(r1);
    }

    private void showDialogType(int r2) {
        AlertDialog r0 = this.mLauncherSwitchDialog;
        if (r0 == null) goto L8;
        if (r0.isShowing() == false) goto L8;
        return;
    L8:
        if (r2 != 1) goto L10;
    L15:
        this.mLauncherSwitchDialog = showLauncherModeDialog(this, this.mOldLauncherMode, this.mNewLauncherMode);
        return;
    L10:
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L18;
        this.mLauncherSwitchDialog = showLauncherThemeDialog(this, this.mTransparentThemeOn);
        return;
    }

    public static AlertDialog showLauncherModeDialog(final BaseFragment r5, final int r6, final int r7) {
        final FragmentActivity r0 = r5.getActivity();
        if (r7 >= r6) goto L5;
        String r1 = getLauncherModeNumberString(r0, r6);
        String r2 = getLauncherModeNumberString(r0, r7);
        String r3 = r0.getString(R.string.dlg_switch_launcher_mode_degraded, new Object[]{r1, r2, r2, r2, r1});
    L7:
        return new AlertDialog.Builder(r0).setTitle(R.string.dlg_switch_launcher_title).setMessage(r3).setNegativeButton(r0.getString(R.string.dlg_cancel), null).setPositiveButton(r0.getString(R.string.dlg_ok), new AnonymousClass2(r0, r6, r7, r5)).show();
    L5:
        r3 = r0.getString(R.string.dlg_switch_launcher_msg);
        goto L7
    }

    public static AlertDialog showLauncherThemeDialog(final BaseFragment r4, final boolean r5) {
        final FragmentActivity r0 = r4.getActivity();
        return new AlertDialog.Builder(r0).setTitle(R.string.dlg_switch_launcher_title).setMessage(R.string.dlg_switch_launcher_msg).setNegativeButton(r0.getString(R.string.dlg_cancel), null).setPositiveButton(r0.getString(R.string.dlg_ok), new AnonymousClass3(r0, r5, r4)).show();
    }

    public void showReloadLauncherDialog(final BaseFragment r5, final boolean r6) {
        final FragmentActivity r0 = r5.getActivity();
        AlertDialog.Builder r1 = new AlertDialog.Builder(r0).setTitle(R.string.dlg_icon_illumination_title);
        if (r6 == false) goto L5;
        int r2 = R.string.dlg_icon_illumination_msg;
    L6:
        r1.setMessage(r2).setNegativeButton(this.mContext.getString(R.string.cancel), null).setOnDismissListener(new AnonymousClass5(this)).setPositiveButton(r0.getString(R.string.dlg_ok), new AnonymousClass4(this, r5, r6, r0)).show();
        return;
    L5:
        r2 = R.string.dlg_switch_launcher_msg;
        goto L6
    }

    public static String getLauncherModeNumberString(Context r1, int r2) {
        if (r2 == 9) goto L19;
        if (r2 == 12) goto L17;
        if (r2 == 16) goto L15;
        if (r2 == 20) goto L13;
        return "";
    L13:
        return r1.getString(R.string.launcher_mode_number_20);
    L15:
        return r1.getString(R.string.launcher_mode_number_16);
    L17:
        return r1.getString(R.string.launcher_mode_number_12);
    L19:
        return r1.getString(R.string.launcher_mode_number_9);
    }

    public static void setDefaultBytedanceLauncher(Context r1, int r2, int r3) {
        ContentResolver r0 = r1.getContentResolver();
        saveLast9LauncherMultiPanelMode(r1, r2);
        setDefaultLauncherMode(r0, r3);
        setupDefaultMultiBlockMode(r0, getMultiBlockMode(r1, r3));
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AlertDialog r0 = this.mLauncherSwitchDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        AlertDialog r0 = this.mLauncherSwitchDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private boolean isWifiDisplayEnabled() {
        if (((WifiManager) this.mParent.getSystemService("wifi")).getWifiState() != 3) goto L5;
        boolean r0 = true;
    L7:
        if (android.provider.Settings.Global.getInt(this.mParent.getContentResolver(), "wifi_display_on", 0) != 1) goto L9;
        boolean r4 = true;
    L10:
        if (r0 == false) goto L14;
        if (r4 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r4 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mItemHideLable.getSwitch()) goto L6;
        setHideLabel(r3);
        SettingsTracker.onSwitcherClick(1004, r3);
        return;
    L6:
        if (r2 != this.mItemUnlockAnim.getSwitch()) goto L9;
        setUnlockAnimEnabled(r3);
        SettingsTracker.onSwitcherClick(1005, r3);
        return;
    L9:
        if (r2 != this.mItemOriginalLauncherBlur.getSwitch()) goto L12;
        setOriginalLauncherBlur(r3);
        SettingsTracker.onSwitcherClick(PointerIconCompat.TYPE_TEXT, r3);
        return;
    L12:
        if (r2 != this.mItemIconIllumination.getSwitch()) goto L18;
        showReloadLauncherDialog(this, r3);
        return;
    }

    @Override // com.android.settings.widget.VerticalOptionsCheckView.OptionSelectListener
    public void onOptionSelected(int r2) {
        if (r2 == 0) goto L4;
        int r3 = 0;
    L5:
        android.provider.Settings.Global.putInt(getContentResolver(), "launcher_switching_orientation", r3);
        return;
    L4:
        r3 = 1;
        goto L5
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.android.settings.LauncherSettingsFragment$6] */
    private void updateLauncherThemePreview() {
        OLog.d(TAG, "updateLauncherThemePreview");
        Void r2 = (Void) null;
        new AnonymousClass6(this).execute(new Void[]{null});
    }

    private void updateLauncherAnimPreview() {
        int r0 = Utils.getAnimIndexFromValue(android.provider.Settings.Global.getInt(this.mParent.getContentResolver(), "launcher_page_animation", 0));
        TypedArray r1 = getResources().obtainTypedArray(R.array.launcher_anim_preview_upper);
        this.mItemLauncherAnim.setIcon(r1.getDrawable(r0));
        r1.recycle();
    }

    private void updateDockFlipView(boolean r3) {
        if (this.mNewLauncherMode != 0) goto L5;
    L12:
        this.mDockFlipView.setVisibility(8);
        return;
    L5:
        if (this.mIsThirdLauncher == true) goto L12;
        int r1 = 0;
        this.mDockFlipView.setVisibility(0);
        VerticalOptionsCheckView r2 = this.mDockFlipView;
        if (r3 == false) goto L10;
        r1 = 2;
    L10:
        r2.setCheck(r1);
    }

    private void updateDockPreview() {
        if (this.mIsThirdLauncher == false) goto L5;
        return;
    L5:
        if (this.mNewLauncherMode == 0) goto L29;
        int r0 = this.mNewMultiBlockMode;
        if (r0 != 64) goto L11;
        this.mDockFlipView.bindOptionPreview(R.drawable.flip_64_right, R.drawable.flip_64_left);
        return;
    L11:
        if (r0 != 36) goto L14;
        this.mDockFlipView.bindOptionPreview(R.drawable.flip_36_right, R.drawable.flip_36_left);
        return;
    L14:
        if (r0 != 81) goto L17;
        this.mDockFlipView.bindOptionPreview(R.drawable.flip_81_right, R.drawable.flip_81_left);
        return;
    L17:
        if (r0 != 80) goto L20;
        this.mDockFlipView.bindOptionPreview(R.drawable.flip_80_right, R.drawable.flip_80_left);
        return;
    L20:
        if (r0 != 48) goto L28;
        this.mDockFlipView.bindOptionPreview(R.drawable.flip_48_right, R.drawable.flip_48_left);
        return;
    L28:
        return;
    }

    private void setLauncherEnabledState(ComponentName r2, int r3) {
        PackageManager r1 = this.mPm;     // Catch: Exception -> L8
        String r4 = r2.getPackageName();     // Catch: Exception -> L8
        int r0 = 1;
        if (1 == r3) goto L6;
        r0 = 0;
    L6:
        r1.setApplicationEnabledSetting(r4, r3, r0);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void resetThumbMode(Context r1) {
        WindowManager r2 = (WindowManager) r1.getSystemService("window");
        if (WindowManagerSmt.getInstance().isWindowInthumbMode(r2) == false) goto L6;
        WindowManagerSmt.getInstance().resetWindowOneHandedState(r2);
        return;
    }

    public static void launchNewLauncherDelay(BaseFragment r3) {
        Handler r0 = sHandler;
        r0.sendMessageDelayed(r0.obtainMessage(1, new WeakReference(r3)), 200);
    }

    public static void launchNewLauncher(BaseFragment r2) {
        if (r2.getActivity() != null) goto L11;
        OLog.e(TAG, "fragment to launch new launcher is not attached to activity, it's finished already?");
        return;
    L11:
        Intent r0 = new Intent("android.intent.action.MAIN");     // Catch: ActivityNotFoundException -> L8
        r0.setFlags(268435456);     // Catch: ActivityNotFoundException -> L8
        r0.addCategory("android.intent.category.HOME");     // Catch: ActivityNotFoundException -> L8
        r2.startActivity(r0);     // Catch: ActivityNotFoundException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    private void clearPreferredActivities(Intent r2) {
        PackageManagerSmt.getInstance().clearPreferredActivities(this.mPm, r2);
    }

    public static void killLauncher(Context r1) {
        forceStopPackage(r1, "com.bytedanceos.launcher");
    }

    private static void forceStopPackage(Context r1, String r2) {
        ((ActivityManager) r1.getSystemService("activity")).forceStopPackage(r2);
    }

    private void updateEnableBytedanceHomeView() {
        ResolveInfo r0 = getDefaultHome();
        if ("com.bytedanceos.launcher".equals(r0.activityInfo.packageName) == false) goto L5;
        this.mBytedanceHomeEnable.setSubTitle(R.string.bytedance_desktop_title);
        return;
    L5:
        this.mBytedanceHomeEnable.setSubTitle(r0.activityInfo.applicationInfo.loadLabel(this.mPm));
    }

    private ResolveInfo getDefaultHome() {
        return this.mPm.resolveActivity(this.mIntentHome, 65536);
    }

    private boolean isThumbPushDownOn() {
        return Boolean.parseBoolean(android.provider.Settings.Global.getString(getActivity().getContentResolver(), SettingsSwitchKeyUtil.THUMB_PUSH_DOWN));
    }

    public static void saveLast9LauncherMultiPanelMode(Context r1, int r2) {
        if (r2 != 9) goto L6;
        android.provider.Settings.Global.putInt(r1.getContentResolver(), Constants.LAST_NINE_LAUNCHER_MULTI_PANEL_MODE, getDefaultMultiBlockMode(r1));
        return;
    }

    private static int getLast9LauncherMultiPanelMode(Context r2) {
        return android.provider.Settings.Global.getInt(r2.getContentResolver(), Constants.LAST_NINE_LAUNCHER_MULTI_PANEL_MODE, 36);
    }

    private void updateLauncherWallpaperIcon() {
        if (this.mItemLauncherWallpaper.getVisibility() == 0) goto L5;
        return;
    L5:
        ExecutorManager.execute(new AnonymousClass7(this));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventType.LauncherWallpaperGotEvent r1) {
        this.mItemLauncherWallpaper.setIcon(r1.wallpaper);
    }

    @Override // com.android.settings.widget.LauncherPreview.Callback
    public void onLauncherTypeChanged(int r3) {
        OLog.d(TAG, "onLauncherTypeChanged " + r3);
        switchLauncherTo(r3);
    }

    @Override // com.android.settings.widget.LauncherPreview.Callback
    public void onLauncherThemeChanged(boolean r3) {
        OLog.d(TAG, "onLauncherThemeChanged " + r3);
        this.mTransparentThemeOn = r3;
        showDialogType(3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SettingsTracker.trackLauncherSettings(this.mContext);
        EventBus.getDefault().unregister(this);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_LauncherSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LauncherSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_LauncherSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LauncherSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LauncherSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_LauncherSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LauncherSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LauncherSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_LauncherSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
