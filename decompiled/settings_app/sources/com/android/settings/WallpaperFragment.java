package com.android.settings;

import android.app.ActivityManager;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.CustomTheme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bytedanceos.api.ActivityManagerSmt;
import bytedanceos.api.ConfigurationSmt;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes2.dex */
public class WallpaperFragment extends BaseFragment implements View.OnClickListener {
    private ArrayList<SettingItemTextVertical> mAllOptions;
    private SettingItemTextVertical mItemDeviceTheme;
    private SettingItemTextVertical mItemIcons;
    private SettingItemTextVertical mItemLauncherAnim;
    private SettingItemTextVertical mItemLauncherTheme;
    private SettingItemTextVertical mItemLauncherWallpaper;
    private SettingItemTextVertical mItemLockscreenWallpaper;
    private int mTitleStringResId;
    private boolean mTransparentThemeOn;
    private View mViewBytedanceLauncherSettings;
    private WallpaperManager mWallpaperManager;

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_WallpaperFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_WallpaperFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public WallpaperFragment() {
    }

    static /* synthetic */ Bitmap access$000(WallpaperFragment r0) {
        return r0.getLockscreenWallpaperIcon();
    }

    public void com_android_settings_WallpaperFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.wallpaper_layout, r4, false);
        this.mAllOptions = new ArrayList();
        this.mWallpaperManager = WallpaperManager.getInstance(this.mContext);
        this.mTitleStringResId = R.string.wall_paper_header_title;
        int r6 = (int) getResources().getDimension(R.dimen.wallpaper_settings_item_icon_width);
        int r7 = (int) getResources().getDimension(R.dimen.wallpaper_settings_item_icon_height);
        this.mViewBytedanceLauncherSettings = findViewByIdNullable(R.id.laucher_theme_viewstub);
        SettingItemTextVertical r8 = (SettingItemTextVertical) findViewByIdNullable(R.id.item_id_lockscreen_wallpaper);
        this.mItemLockscreenWallpaper = r8;
        this.mAllOptions.add(r8);
        this.mItemLockscreenWallpaper.setOnClickListener(this);
        this.mItemLockscreenWallpaper.setIconScale(r6, r7);
        SettingItemTextVertical r9 = (SettingItemTextVertical) this.mViewBytedanceLauncherSettings.findViewById(R.id.item_id_launcher_theme);
        this.mItemLauncherTheme = r9;
        this.mAllOptions.add(r9);
        this.mItemLauncherTheme.setOnClickListener(this);
        SettingItemTextVertical r10 = (SettingItemTextVertical) this.mViewBytedanceLauncherSettings.findViewById(R.id.item_id_launcher_anim);
        this.mItemLauncherAnim = r10;
        this.mAllOptions.add(r10);
        this.mItemLauncherAnim.setOnClickListener(this);
        SettingItemTextVertical r11 = (SettingItemTextVertical) findViewByIdNullable(R.id.item_id_launcher_wallpaper);
        this.mItemLauncherWallpaper = r11;
        this.mAllOptions.add(r11);
        this.mItemLauncherWallpaper.setOnClickListener(this);
        this.mItemLauncherWallpaper.setIconScale(r6, r7);
        SettingItemTextVertical r12 = (SettingItemTextVertical) findViewByIdNullable(R.id.item_id_device_theme);
        this.mItemDeviceTheme = r12;
        r12.setVisibility(8);
        this.mAllOptions.add(this.mItemDeviceTheme);
        this.mItemDeviceTheme.setIconScale(r6, r7);
        SettingItemTextVertical r13 = (SettingItemTextVertical) findViewByIdNullable(R.id.item_id_icons);
        this.mItemIcons = r13;
        this.mAllOptions.add(r13);
        this.mItemIcons.setOnClickListener(this);
        this.mItemIcons.setVisibility(8);
        this.mItemIcons.getSummaryView().setMaxLines(3);
        return this.mRootView;
    }

    public void com_android_settings_WallpaperFragment__onResume$___twin___() {
        super.onResume();
        this.mTransparentThemeOn = true;
        updateLauncherItemAndIconItem();
        setupBackgroundForOptions();
        ExecutorManager.execute(new AnonymousClass1(this));
    }

    private void setupBackgroundForOptions() {
        ArrayList r0 = new ArrayList();
        Iterator<SettingItemTextVertical> r1 = this.mAllOptions.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        SettingItemTextVertical r2 = r1.next();
        if (r2.getVisibility() != 0) goto L4;
        r0.add(r2);
        goto L4
    L8:
        int r3 = r0.size();
        int r4 = 1;
        if (r3 != 1) goto L11;
        ((SettingItemTextVertical) r0.get(0)).setBackgroundStyle(1);
        return;
    L11:
        if (r3 <= 1) goto L22;
        OLog.d(this.TAG, "visibleCount=" + r3);
        ((SettingItemTextVertical) r0.get(0)).setBackgroundStyle(2);
        int r5 = r3 - 1;
        ((SettingItemTextVertical) r0.get(r5)).setBackgroundStyle(4);
    L13:
        if (r4 >= r5) goto L23;
        ((SettingItemTextVertical) r0.get(r4)).setBackgroundStyle(3);
        r4 = r4 + 1;
        goto L13
    L23:
        return;
    }

    private void updateDeviceColorThemeItem() {
        if ("beige".equals(Utils.getDeviceColor()) == false) goto L5;
        String r0 = "BytedanceOSEnsyuNezumi";
    L6:
        ActivityManager r1 = (ActivityManager) this.mContext.getSystemService("activity");
        Configuration r2 = ActivityManagerSmt.getInstance().getConfiguration(r1);     // Catch: Exception -> L22
        CustomTheme r3 = ConfigurationSmt.getInstance().get_customTheme(r2);
        if (r3 != null) goto L11;
    L13:
        Resources r4 = getResources();
        TypedArray r5 = r4.obtainTypedArray(R.array.device_theme_icon_small);
        String[] r6 = r4.getStringArray(R.array.device_theme_id);
        int r7 = 0;
    L15:
        if (r7 >= r6.length) goto L20;
        if (r0.equals(r6[r7]) == false) goto L19;
        this.mItemDeviceTheme.setIcon(r5.getDrawable(r7));
    L19:
        r7 = r7 + 1;
        goto L15
    L20:
        r5.recycle();
        return;
    L11:
        if (TextUtils.isEmpty(r3.getThemeId()) == true) goto L13;
        r0 = r3.getThemeId();
    L22:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        r0 = "BytedanceOSDefault";
        goto L6
    }

    private void updateLauncherItemAndIconItem() {
        int r0 = Utils.getCurrentLauncherMode(this.mContext);
        if (Utils.isThirdPartHome(this.mContext) == false) goto L6;
        this.mItemLauncherTheme.setVisibility(8);
        this.mItemLauncherAnim.setVisibility(8);
        updateTitleText(true);
        this.mItemIcons.setVisibility(8);
        updateLauncherWallpaperIcon();
        return;
    L6:
        if (r0 != 9) goto L8;
    L14:
        updateLauncherThemePreview();
        updateLauncherAnimPreview();
        if (this.mTransparentThemeOn == false) goto L17;
        updateLauncherWallpaperIcon();
    L17:
        updateTitleText(false);
    L18:
        this.mItemIcons.setVisibility(8);
        return;
    L8:
        if (r0 == 12) goto L14;
        if (r0 == 16) goto L14;
        if (r0 == 20) goto L14;
        updateLauncherWallpaperIcon();
        updateTitleText(false);
        goto L18
    }

    public void updateTitleText(boolean r2) {
        Utils.shouldDisplayTheme();
        if (r2 == false) goto L5;
        this.mTitleStringResId = R.string.wall_paper_header_title_withLauncher3;
    L6:
        OFloatingTitleBar r3 = this.mTitleView;
        if (r3 == null) goto L10;
        r3.setCenterTitle(getString(this.mTitleStringResId));
        return;
    L10:
        return;
    L5:
        this.mTitleStringResId = R.string.wall_paper_header_title;
        goto L6
    }

    private void updateLauncherWallpaperIcon() {
        this.mItemLauncherTheme.setVisibility(8);
        this.mItemLauncherAnim.setVisibility(8);
        this.mItemLauncherWallpaper.setVisibility(0);
    }

    private Bitmap getBytedanceWallpaperBitmap(int r1) {
        return WallpaperUtils.getResizedWallpaperBitmap(this.mContext, r1);
    }

    private Bitmap getLockscreenWallpaperIcon() {
        return Utils.resizeWallpaper(getBytedanceWallpaperBitmap(1), Utils.THUMBNAIL_WIDTH);
    }

    private void updateLauncherThemePreview() {
        if (this.mTransparentThemeOn == false) goto L5;
        this.mItemLauncherTheme.setVisibility(8);
        this.mItemLauncherAnim.setVisibility(8);
        this.mItemLauncherWallpaper.setVisibility(0);
        return;
    L5:
        this.mItemLauncherTheme.setVisibility(0);
        this.mItemLauncherAnim.setVisibility(0);
        this.mItemLauncherWallpaper.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (this.mItemLockscreenWallpaper != r4) goto L6;
        start(ChooseWallpaperTypeFragment.newInstance(1));
        SettingsTracker.onItemClick(905);
        return;
    L6:
        if (this.mItemLauncherWallpaper != r4) goto L9;
        start(ChooseWallpaperTypeFragment.newInstance(2));
        SettingsTracker.onItemClick(901);
        return;
    L9:
        if (this.mItemIcons != r4) goto L12;
        start(AppIconsSettingsFragment.class);
        SettingsTracker.onItemClick(907);
        return;
    L12:
        if (this.mItemLauncherTheme != r4) goto L15;
        Intent r5 = new Intent();
        r5.setClassName("com.bytedanceos.launcher", "com.bytedanceos.launcher.theme.ThemeChooserActivity");
        r5.setAction("android.intent.action.MAIN");
        r5.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        r5.putExtra(BaseActivity.FROM_ACTIVITY, PageConstants.LAUNCH_PAGE_WALLPAPER);
        r5.putExtra(Utils.EXTRA_FROM_SETTINGS, true);
        Utils.startActivity(this._mActivity, r5, 0);
        SettingsTracker.onItemClick(902);
        return;
    L15:
        if (r4 != this.mItemLauncherAnim) goto L18;
        start(LauncherAnimPreviewFragment.class);
        SettingsTracker.onItemClick(903);
        return;
    L18:
        if (this.mItemDeviceTheme != r4) goto L26;
        startActivity(new Intent(this.mContext, ThemeChooserActivity.class).putExtra("back_text_id", this.mTitleStringResId));
        SettingsTracker.onItemClick(904);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ExecutorManager.execute(new AnonymousClass2(this));
        EventBus.getDefault().unregister(this);
        WallpaperManager r1 = this.mWallpaperManager;
        if (r1 == null) goto L6;
        r1.forgetLoadedWallpaper();
        return;
    }

    private void updateLauncherAnimPreview() {
        int r0 = Utils.getAnimIndexFromValue(android.provider.Settings.Global.getInt(getContentResolver(), "launcher_page_animation", 0));
        TypedArray r1 = getResources().obtainTypedArray(R.array.launcher_anim_preview_upper);
        this.mItemLauncherAnim.setIcon(r1.getDrawable(r0));
        r1.recycle();
    }

    private boolean isTransparentThemeOn() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "launcher_grid_theme", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventType.LauncherThemeIconUpdateEvent r1) {
        this.mItemLauncherTheme.setIcon(r1.themeIcon);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventType.LockscreenWallpaperIconUpdateEvent r1) {
        this.mItemLockscreenWallpaper.setIcon(r1.lockscreenWallpaper);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventType.LauncherWallpaperGotEvent r1) {
        this.mItemLauncherWallpaper.setIcon(r1.wallpaper);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_WallpaperFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WallpaperFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_WallpaperFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_WallpaperFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WallpaperFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_WallpaperFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_WallpaperFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WallpaperFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_WallpaperFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
