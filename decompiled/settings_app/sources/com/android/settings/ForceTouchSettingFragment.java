package com.android.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.ForceTouchGifAnimView;
import com.android.settings.widget.SettingPreviewSeekBar;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class ForceTouchSettingFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SettingPreviewSeekBar.OnItemCheckListener {
    private static final float FORCE_TOUCH_PRESSURE_DEFAULT = 0.45f;
    private static final float FORCE_TOUCH_PRESSURE_MAX = 0.6f;
    private static final float FORCE_TOUCH_PRESSURE_MIN = 0.3f;
    private static final int SHORTCUT_TYPE_IMAGE = 2;
    private static final int SHORTCUT_TYPE_TEXT = 1;
    private final ArrayList<Float> PRESSURE_VALUES;
    private ForceTouchGifAnimView mForceTouchGifView;
    private SettingItemText mImageShortcut;
    private SettingItemText mLockScreenShortcut;
    private SettingPreviewSeekBar mPressureSeekBar;
    private SettingItemSwitch mQuickPushpin;
    private SettingItemText mTextShortcut;
    private SettingItemText mTrackBallShortcut;

    public void com_android_settings_ForceTouchSettingFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ForceTouchSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ForceTouchSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ForceTouchSettingFragment() {
        this.PRESSURE_VALUES = new ArrayList();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.force_touch_settings_layout, r4, false);
        this.mTitleResId = Integer.valueOf(R.string.force_touch_title);
        this.mForceTouchGifView = (ForceTouchGifAnimView) findViewByIdNullable(R.id.gif_view);
        this.mPressureSeekBar = (SettingPreviewSeekBar) findViewByIdNullable(R.id.id_force_touch_pressure);
        this.mLockScreenShortcut = (SettingItemText) findViewByIdNullable(R.id.item_lock_screen_shortcut);
        this.mTextShortcut = (SettingItemText) findViewByIdNullable(R.id.item_text_shortcut);
        this.mImageShortcut = (SettingItemText) findViewByIdNullable(R.id.item_image_shortcut);
        this.mTrackBallShortcut = (SettingItemText) findViewByIdNullable(R.id.item_track_ball_shortcut);
        this.mQuickPushpin = (SettingItemSwitch) findViewByIdNullable(R.id.item_quick_pushpin_shortcut);
        this.mLockScreenShortcut.setVisibility(0);
        this.mLockScreenShortcut.setOnClickListener(this);
        if (SettingsFeature.isSupportTrackBall() == false) goto L5;
        this.mTrackBallShortcut.setVisibility(0);
    L6:
        this.mTextShortcut.setOnClickListener(this);
        this.mImageShortcut.setOnClickListener(this);
        this.mTrackBallShortcut.setOnClickListener(this);
        this.PRESSURE_VALUES.addAll(Arrays.asList(new Float[]{Float.valueOf(0.3f), Float.valueOf(FORCE_TOUCH_PRESSURE_DEFAULT), Float.valueOf(0.6f)}));
        this.mPressureSeekBar.setMax(this.PRESSURE_VALUES.size() - 1);
        this.mPressureSeekBar.setItenCheckListener(this);
        return this.mRootView;
    L5:
        this.mTrackBallShortcut.setVisibility(8);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mQuickPushpin.setOnCheckedChangeListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        switch(r3.getId()) {
            case 2131429420: goto L11;
            case 2131429437: goto L7;
            case 2131429541: goto L6;
            case 2131429550: goto L5;
            default: goto L16;
        };
    L5:
        start(TrackBallSettingsFragment.class);
        return;
    L6:
        startShortcutToolActivity(1);
        return;
    L7:
        Intent r4 = new Intent();
        r4.setClassName(Constants.PKG_KEYGUARD, "com.bytedanceos.keyguard.QuickItemSettingActivity");
        if (this.mTitleResId == null) goto L10;
        r4.putExtra("back_text", getString(this.mTitleResId.intValue()));
    L10:
        Utils.startActivity(this._mActivity, r4);
        return;
    L11:
        startShortcutToolActivity(2);
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mQuickPushpin.getSwitch()) goto L6;
        android.provider.Settings.Global.putInt(getContentResolver(), "force_touch_pushpin_state", r3 ? 1 : 0);
        return;
    }

    public void com_android_settings_ForceTouchSettingFragment__onResume$___twin___() {
        super.onResume();
        this.mForceTouchGifView.startAnim();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mForceTouchGifView.cancelAnim();
    }

    @Override // com.android.settings.widget.SettingPreviewSeekBar.OnItemCheckListener
    public boolean onItemCheck(int r2) {
        if (r2 >= 0) goto L4;
        return false;
    L4:
        if (r2 >= this.PRESSURE_VALUES.size()) goto L10;
        android.provider.Settings.Global.putFloat(getContentResolver(), "pressure_of_forcetouch", this.PRESSURE_VALUES.get(r2).floatValue());
        return true;
    L10:
        return false;
    }

    private void updateViews() {
        this.mPressureSeekBar.setSelect(this.PRESSURE_VALUES.indexOf(Float.valueOf(android.provider.Settings.Global.getFloat(getContentResolver(), "pressure_of_forcetouch", FORCE_TOUCH_PRESSURE_DEFAULT))));
        SettingItemSwitch r0 = this.mQuickPushpin;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "force_touch_pushpin_state", 1) != 1) goto L5;
        boolean r1 = true;
    L6:
        r0.setChecked(r1);
        this.mLockScreenShortcut.setSubTitle(Utils.getSwitchStateResId(this.mContext, "keyguard_force_touch_state", 1));
        this.mTextShortcut.setSubTitle(Utils.getSwitchStateResId(this.mContext, "text_sector_view_enable", 1));
        this.mImageShortcut.setSubTitle(Utils.getSwitchStateResId(this.mContext, "image_sector_view_enable", 1));
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void startShortcutToolActivity(int r4) {
        Intent r0 = new Intent();
        r0.setClassName("com.bytedanceos.sidebar", "com.bytedanceos.sidebar.setting.SectorItemSettingActivity");
        r0.putExtra("SectorItemActivityDirection", r4);
        if (this.mTitleResId == null) goto L5;
        r0.putExtra("back_text", getString(this.mTitleResId.intValue()));
    L5:
        Utils.startActivity(this._mActivity, r0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ForceTouchSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ForceTouchSettingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ForceTouchSettingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ForceTouchSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ForceTouchSettingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ForceTouchSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ForceTouchSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ForceTouchSettingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ForceTouchSettingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
