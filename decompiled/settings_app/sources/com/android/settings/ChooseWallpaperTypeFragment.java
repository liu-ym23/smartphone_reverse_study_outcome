package com.android.settings;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemCheck;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class ChooseWallpaperTypeFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int currentAutoSwitchFrequencyIndex;
    private SettingItemSwitch mAutoSwitchLockScreenWallpaper;
    private LinearLayout mAutoSwitchLockScreenWallpaperFrequencyContainer;
    private TextView mAutoSwitchLockScreenWallpaperFrequencyTips;
    private SettingItemTextVertical mHistoryWallpaper;
    private SettingItemTextVertical mOnlineWallpaper;
    private SettingItemSwitch mOriginalLauncherWallpaperBlur;
    private View mOriginalLauncherWallpaperBlurShadow;
    private ScrollView mScrollView;
    private AnimatorSet mShowViewAnim;
    private SettingItemSwitch mSwitchFourFingersChangeLockscreen;
    private TextView mSwitchFourFingersChangeLockscreenTipsView;
    private int mSwitchTop;
    private SettingItemTextVertical mSystemWallpaper;
    private SettingItemSwitch mTiktokOnKeyguard;
    private int mType;

    public void com_android_settings_ChooseWallpaperTypeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_ChooseWallpaperTypeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ChooseWallpaperTypeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ChooseWallpaperTypeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ChooseWallpaperTypeFragment() {
        this.currentAutoSwitchFrequencyIndex = 0;
    }

    static /* synthetic */ void access$000(ChooseWallpaperTypeFragment r0, int r1) {
        r0.setAutoSwitchLockScreenWallpaperFrequency(r1);
    }

    static /* synthetic */ int access$100(ChooseWallpaperTypeFragment r0) {
        return r0.currentAutoSwitchFrequencyIndex;
    }

    static /* synthetic */ int access$102(ChooseWallpaperTypeFragment r0, int r1) {
        r0.currentAutoSwitchFrequencyIndex = r1;
        return r1;
    }

    static /* synthetic */ LinearLayout access$200(ChooseWallpaperTypeFragment r0) {
        return r0.mAutoSwitchLockScreenWallpaperFrequencyContainer;
    }

    static /* synthetic */ String access$300(ChooseWallpaperTypeFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ ScrollView access$400(ChooseWallpaperTypeFragment r0) {
        return r0.mScrollView;
    }

    static /* synthetic */ int access$500(ChooseWallpaperTypeFragment r0) {
        return r0.mSwitchTop;
    }

    public static ChooseWallpaperTypeFragment newInstance(int r3) {
        ChooseWallpaperTypeFragment r0 = new ChooseWallpaperTypeFragment();
        Bundle r1 = new Bundle();
        r1.putInt(WallpaperUtils.EXTRA_WALLPAPER_TYPE, r3);
        r0.setArguments(r1);
        return r0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        int r0 = 0;
        this.mRootView = r3.inflate(R.layout.choose_wallpaper_type_layout, r4, false);
        Bundle r6 = getArguments();
        int r1 = r6.getInt(WallpaperUtils.EXTRA_WALLPAPER_TYPE, -1);
        this.mType = r1;
        if (r1 == (-1)) goto L29;
    L9:
        int r7 = (int) getResources().getDimension(R.dimen.wallpaper_settings_item_icon_width);
        int r8 = (int) getResources().getDimension(R.dimen.wallpaper_settings_item_icon_height);
        this.mScrollView = (ScrollView) findViewByIdNullable(R.id.page_scrollview);
        SettingItemTextVertical r9 = (SettingItemTextVertical) findViewByIdNullable(R.id.item_id_system_wallpaper);
        this.mSystemWallpaper = r9;
        r9.setOnClickListener(this);
        this.mSystemWallpaper.setIconScale(r7, r8);
        SettingItemTextVertical r10 = (SettingItemTextVertical) findViewByIdNullable(R.id.item_id_online_wallpaper);
        this.mOnlineWallpaper = r10;
        r10.setOnClickListener(this);
        this.mOnlineWallpaper.setIconScale(r7, r8);
        SettingItemTextVertical r11 = (SettingItemTextVertical) findViewByIdNullable(R.id.item_id_history_wallpaper);
        this.mHistoryWallpaper = r11;
        r11.getSummaryView().setMaxLines(3);
        if (Utils.isChineseLocale() == true) goto L12;
        Utils.limitTextSizeAsDp(this.mContext, this.mHistoryWallpaper.getSummaryView());
    L12:
        this.mHistoryWallpaper.setOnClickListener(this);
        this.mHistoryWallpaper.setIconScale(r7, r8);
        int r12 = this.mType;
        if (r12 != 1) goto L16;
        this.mSystemWallpaper.setSummary(R.string.lockscreen_system_wallpaper_subtitle);
        this.mOnlineWallpaper.setSummary(R.string.lockscreen_online_wallpaper_subtitle);
        this.mHistoryWallpaper.setSummary(R.string.history_lockscreen_wallpaper_subtitle);
    L18:
        SettingItemSwitch r13 = (SettingItemSwitch) findViewByIdNullable(R.id.item_four_fingers_change_lockscreen);
        this.mSwitchFourFingersChangeLockscreen = r13;
        r13.setSwitchDisabledTips(R.string.no_enough_wallpaper_tips);
        this.mSwitchFourFingersChangeLockscreenTipsView = (TextView) findViewByIdNullable(R.id.item_four_fingers_change_lockscreen_tips);
        this.mOriginalLauncherWallpaperBlur = (SettingItemSwitch) findViewByIdNullable(R.id.original_launcher_wallpaper_blur);
        this.mOriginalLauncherWallpaperBlurShadow = findViewByIdNullable(R.id.original_launcher_wallpaper_blur_shadow);
        this.mAutoSwitchLockScreenWallpaper = (SettingItemSwitch) findViewByIdNullable(R.id.item_id_auto_switch_lock_screen_wallpaper);
        this.mAutoSwitchLockScreenWallpaperFrequencyContainer = (LinearLayout) findViewByIdNullable(R.id.item_id_auto_switch_wallpaper_frequency_container);
        initAutoSwitchLockScreenWallpaperFrequencyContainer(getAutoSwitchLockScreenWallpaperFrequency());
        this.mAutoSwitchLockScreenWallpaperFrequencyTips = (TextView) findViewByIdNullable(R.id.item_id_auto_switch_lock_screen_wallpaper_tips);
        if (this.mType != 1) goto L21;
        this.mTitleResId = Integer.valueOf(R.string.lockscreen_wallpaper_setting_text);
    L22:
        View r14 = findViewByIdNullable(R.id.tiktok_on_keyguard);
        if (Utils.isDesktop(getActivity()) == false) goto L25;
    L26:
        r0 = 8;
    L27:
        r14.setVisibility(r0);
        this.mTiktokOnKeyguard = (SettingItemSwitch) findViewByIdNullable(R.id.item_id_tiktok_on_keyguard);
        return this.mRootView;
    L25:
        if (SettingsFeature.isShowTikTokOnLock() == true) goto L27;
    L21:
        this.mTitleResId = Integer.valueOf(R.string.launcher_wallpaper_setting_text);
        goto L22
    L16:
        if (r12 != 2) goto L18;
        this.mSystemWallpaper.setSummary(R.string.launcher_system_wallpaper_subtitle);
        this.mOnlineWallpaper.setSummary(R.string.launcher_online_wallpaper_subtitle);
        this.mHistoryWallpaper.setSummary(R.string.history_launcher_wallpaper_subtitle);
        goto L18
    L29:
        this.mType = Integer.valueOf(r6.getString(WallpaperUtils.EXTRA_WALLPAPER_TYPE)).intValue();     // Catch: NumberFormatException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        updateViews();
        this.mSwitchFourFingersChangeLockscreen.setOnCheckedChangeListener(this);
        this.mOriginalLauncherWallpaperBlur.setOnCheckedChangeListener(this);
        this.mAutoSwitchLockScreenWallpaper.setChecked(false);
        this.mAutoSwitchLockScreenWallpaper.setOnCheckedChangeListener(this);
        this.mTiktokOnKeyguard.setOnCheckedChangeListener(this);
    }

    public void updateViews() {
        int r0 = this.mType;
        if (r0 != 1) goto L5;
        if (r0 == 1) goto L5;
    L7:
        if (this.mType != 2) goto L9;
        Utils.isThirdPartHome(this.mContext);
    L9:
        this.mOriginalLauncherWallpaperBlur.setVisibility(8);
        this.mOriginalLauncherWallpaperBlurShadow.setVisibility(8);
        this.mSwitchFourFingersChangeLockscreen.setChecked(isFourFingersChangeLockscreenEnabled());
        this.mOriginalLauncherWallpaperBlur.setChecked(isOriginalLauncherBlurOn());
        this.mAutoSwitchLockScreenWallpaper.setChecked(isAutoSwitchLockScreenWallpaperEnable());
        updateAutoSwitchFrequency(false);
        this.mTiktokOnKeyguard.setChecked(isTiktokOnKeyguardEnable());
        return;
    L5:
        this.mSwitchFourFingersChangeLockscreen.setVisibility(8);
        this.mSwitchFourFingersChangeLockscreenTipsView.setVisibility(8);
        this.mAutoSwitchLockScreenWallpaper.setVisibility(8);
        this.mAutoSwitchLockScreenWallpaperFrequencyTips.setVisibility(8);
        findViewByIdNullable(R.id.tiktok_on_keyguard).setVisibility(8);
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private boolean isFourFingersChangeLockscreenEnabled() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "four_fingers_change_lockscreen_enable", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isOriginalLauncherBlurOn() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "original_launcher_wallpaper_blur_on", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isAutoSwitchLockScreenWallpaperEnable() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "auto_switch_lockscreen_wallpaper_enable", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private int getAutoSwitchLockScreenWallpaperFrequency() {
        return android.provider.Settings.Global.getInt(getContentResolver(), "auto_switch_lockscreen_wallpaper_frequency", 0);
    }

    private void setFourFingersChangeLockscreenEnable(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "four_fingers_change_lockscreen_enable", r2 ? 1 : 0);
    }

    private void setOriginalLauncherBlur(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "original_launcher_wallpaper_blur_on", r2 ? 1 : 0);
    }

    private void setAutoSwitchLockScreenWallpaperEnable(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "auto_switch_lockscreen_wallpaper_enable", r2 ? 1 : 0);
    }

    private void setAutoSwitchLockScreenWallpaperFrequency(int r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "auto_switch_lockscreen_wallpaper_frequency", r2);
    }

    private void setTiktokOnKeyguardEnable(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "enable_tiktok_on_keyguard", r2 ? 1 : 0);
    }

    private boolean isTiktokOnKeyguardEnable() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "enable_tiktok_on_keyguard", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mSwitchFourFingersChangeLockscreen.getSwitch()) goto L6;
        setFourFingersChangeLockscreenEnable(r3);
        SettingsTracker.onSwitcherClick(90504, r3);
        return;
    L6:
        if (r2 != this.mOriginalLauncherWallpaperBlur.getSwitch()) goto L9;
        setOriginalLauncherBlur(r3);
        SettingsTracker.onSwitcherClick(90103, r3);
        return;
    L9:
        if (r2 != this.mAutoSwitchLockScreenWallpaper.getSwitch()) goto L15;
        setAutoSwitchLockScreenWallpaperEnable(r3);
        if (r3 == false) goto L13;
        Intent r4 = new Intent("com.obric.wallpaper.ACTION_SWITCH_WALLPAPER");
        r4.setPackage(Constants.PKG_WALLPAPER_PROVIDER);
        r4.putExtra("uri_update", null);
        sendBroadcast(r4);
    L13:
        updateAutoSwitchFrequency(true);
        return;
    L15:
        if (r2 != this.mTiktokOnKeyguard.getSwitch()) goto L21;
        setTiktokOnKeyguardEnable(r3);
        return;
    }

    private void initAutoSwitchLockScreenWallpaperFrequencyContainer(int r8) {
        String[] r0 = getResources().getStringArray(R.array.auto_switch_lockscreen_wallpaper_options);
        final String[] r1 = getResources().getStringArray(R.array.auto_switch_lockscreen_wallpaper_values);
        final int r2 = this.mAutoSwitchLockScreenWallpaperFrequencyContainer.getChildCount();
        View.OnClickListener r3 = new AnonymousClass1(this, r1, r2);
        int r4 = 0;
    L4:
        if (r4 >= r0.length) goto L16;
        ListContentItemCheck r5 = new ListContentItemCheck(getContext());
        if (r4 != 0) goto L9;
        r5.setBackgroundStyle(2);
    L12:
        r5.setTitle(r0[r4]);
        r5.setTag(Integer.valueOf(r4));
        r5.setOnClickListener(r3);
        r5.setChecked(r1[r4].equals(String.valueOf(r8)));
        if (r5.isChecked() == false) goto L15;
        this.currentAutoSwitchFrequencyIndex = r4;
    L15:
        this.mAutoSwitchLockScreenWallpaperFrequencyContainer.addView(r5);
        r4 = r4 + 1;
        goto L4
    L9:
        if (r4 != (r0.length - 1)) goto L11;
        r5.setBackgroundStyle(4);
        goto L12
    L11:
        r5.setBackgroundStyle(3);
        goto L12
    }

    private void updateAutoSwitchFrequency(boolean r12) {
        if (this.mType == 1) goto L5;
        return;
    L5:
        final boolean r0 = this.mAutoSwitchLockScreenWallpaper.isChecked();
        int r2 = 0;
        if (r12 == true) goto L13;
        LinearLayout r11 = this.mAutoSwitchLockScreenWallpaperFrequencyContainer;
        if (r0 == true) goto L11;
        r2 = 8;
    L11:
        r11.setVisibility(r2);
        return;
    L13:
        initScrollMarginTop();
        AnimatorSet r13 = this.mShowViewAnim;
        if (r13 == null) goto L16;
        r13.cancel();
    L16:
        this.mAutoSwitchLockScreenWallpaperFrequencyContainer.setVisibility(0);
        this.mAutoSwitchLockScreenWallpaperFrequencyContainer.measure(0, 0);
        int r14 = this.mAutoSwitchLockScreenWallpaperFrequencyContainer.getMeasuredHeight();
        float r4 = 1.0f;
        if (r0 == false) goto L19;
        final int r15 = -r14;
        float r5 = 1.0f;
        r4 = 0.0f;
        int r3 = 0;
    L20:
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.mAutoSwitchLockScreenWallpaperFrequencyContainer, "alpha", new float[]{r4, r5});
        r6.setDuration(300);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.mAutoSwitchLockScreenWallpaperFrequencyContainer, "Bottom", new float[]{r15, r3});
        r7.setDuration(300);
        r7.addUpdateListener(new AnonymousClass2(this, r15, r0));
        r7.addListener(new AnonymousClass3(this, r0));
        AnimatorSet r16 = new AnimatorSet();
        this.mShowViewAnim = r16;
        r16.playTogether(new Animator[]{r7, r6});
        this.mShowViewAnim.start();
        return;
    L19:
        r5 = 0.0f;
        r3 = -r14;
        r15 = 0;
        goto L20
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        Intent r0 = new Intent();
        if (r5 != this.mSystemWallpaper) goto L9;
        r0.setClassName(Constants.PKG_WALLPAPER_PROVIDER, "com.obric.wallpaper.LockscreenWallpapersActivity");
        if (this.mType != 1) goto L7;
        SettingsTracker.onItemClick(90501);
    L20:
        r0.putExtra(WallpaperUtils.EXTRA_WALLPAPER_TYPE, this.mType);
        if (this.mTitleResId == null) goto L24;
        r0.putExtra("back_text", getString(this.mTitleResId.intValue()));
    L24:
        if ((r5 instanceof SettingItemTextVertical) == false) goto L26;
        r0.putExtra("title", ((SettingItemTextVertical) r5).getTitle());
    L26:
        Utils.startActivity(this._mActivity, r0, 0);
        return;
    L7:
        SettingsTracker.onItemClick(90102);
        goto L20
    L9:
        if (r5 != this.mOnlineWallpaper) goto L15;
        r0.setClassName(Constants.PKG_WALLPAPER_PROVIDER, "com.obric.wallpaper.NetworkWallpaperActivity");
        if (this.mType != 1) goto L13;
        SettingsTracker.onItemClick(90502);
        goto L20
    L13:
        SettingsTracker.onItemClick(90201);
        goto L20
    L15:
        if (r5 != this.mHistoryWallpaper) goto L20;
        r0.setClassName(Constants.PKG_WALLPAPER_PROVIDER, "com.obric.wallpaper.PhoneHistoryWallpaperActivity");
        if (this.mType != 1) goto L19;
        SettingsTracker.onItemClick(90503);
        goto L20
    L19:
        SettingsTracker.onItemClick(90202);
        goto L20
    }

    private void initScrollMarginTop() {
        int r0 = getResources().getDimensionPixelOffset(R.dimen.item_block_gap);
        Rect r1 = new Rect();
        this.mAutoSwitchLockScreenWallpaper.getGlobalVisibleRect(r1);
        OLog.d(this.TAG, "switchRect " + r1);
        Rect r2 = new Rect();
        this.mTitleView.getGlobalVisibleRect(r2);
        this.mAutoSwitchLockScreenWallpaper.getTop();
        this.mAutoSwitchLockScreenWallpaper.getY();
        this.mTitleView.getBottom();
        this.mSwitchTop = (r1.top - r2.bottom) - r0;
        OLog.d(this.TAG, "mSwitchTop " + this.mSwitchTop);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        AnimatorSet r0 = this.mShowViewAnim;
        if (r0 == null) goto L6;
        r0.cancel();
        this.mShowViewAnim = null;
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ChooseWallpaperTypeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ChooseWallpaperTypeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ChooseWallpaperTypeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ChooseWallpaperTypeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ChooseWallpaperTypeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ChooseWallpaperTypeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ChooseWallpaperTypeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ChooseWallpaperTypeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ChooseWallpaperTypeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
