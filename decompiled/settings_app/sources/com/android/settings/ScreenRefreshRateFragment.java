package com.android.settings;

import android.app.DynamicRefreshRateManager;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DeviceBrand;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenRefreshRateFragment extends BaseFragment implements View.OnClickListener {
    private static final int DELAY_UPDATING_VIEW_TIME = 100;
    public static final String SCREEN_REFRESH_RATE = "screen_refresh_rate";
    public static final int SCREEN_REFRESH_RATE_AUTO_MODE = 0;
    public static final int SCREEN_REFRESH_RATE_HIGH_MODE = 2;
    public static final int SCREEN_REFRESH_RATE_STANDARD_MODE = 1;
    private OCardListItem mAutoScreenRefreshRate;
    private Handler mHandler;
    private OCardListItem mHighScreenRefreshRate;
    private ContentObserver mLowBatteryMode;
    private OCardListItem mStandardScreenRefreshRate;
    private OCardListItem mUseHighRefreshRateApp;

    public void com_android_settings_ScreenRefreshRateFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_ScreenRefreshRateFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ScreenRefreshRateFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ScreenRefreshRateFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ScreenRefreshRateFragment() {
        this.mHandler = new Handler(Looper.getMainLooper());
        final Handler r1 = null;
        this.mLowBatteryMode = new AnonymousClass1(this, r1);
    }

    static /* synthetic */ boolean access$000(ScreenRefreshRateFragment r0) {
        return r0.isLowBatteryMode();
    }

    static /* synthetic */ void access$100(ScreenRefreshRateFragment r0, boolean r1) {
        r0.updateViewDelay(r1);
    }

    static /* synthetic */ String access$200(ScreenRefreshRateFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$300(ScreenRefreshRateFragment r0) {
        r0.updateView();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.screen_refresh_rate_setting, r3, false);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.auto_screen_refresh_rate);
        this.mAutoScreenRefreshRate = r5;
        OCardListItemUtils.setCustomEndImageView(r5);
        this.mAutoScreenRefreshRate.setOnContentClickListener(this);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.standard_screen_refresh_rate);
        this.mStandardScreenRefreshRate = r6;
        OCardListItemUtils.setCustomEndImageView(r6);
        this.mStandardScreenRefreshRate.setOnContentClickListener(this);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.high_screen_refresh_rate);
        this.mHighScreenRefreshRate = r7;
        OCardListItemUtils.setCustomEndImageView(r7);
        this.mHighScreenRefreshRate.setOnContentClickListener(this);
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.use_high_screen_refresh_reta_app);
        this.mUseHighRefreshRateApp = r8;
        r8.setOnContentClickListener(this);
        if (DeviceBrand.isNubia() == false) goto L6;
        this.mHighScreenRefreshRate.setSubTitle(this._mActivity.getString(R.string.high_screen_refresh_reta_summery_n1));
        this.mUseHighRefreshRateApp.setSubTitle(this._mActivity.getString(R.string.use_high_screen_refresh_reta_app_summery_n1));
    L6:
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        updateView();
        registerContentObserver();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r6) {
        if (this.mAutoScreenRefreshRate.getContentContainer() != r6) goto L6;
        setScreenRefreshRateMode(0);
        this.mAutoScreenRefreshRate.getCustomEndView().setVisibility(0);
        this.mAutoScreenRefreshRate.showCustomEnd(true);
        this.mStandardScreenRefreshRate.showCustomEnd(false);
        this.mHighScreenRefreshRate.showCustomEnd(false);
        this.mUseHighRefreshRateApp.setVisibility(8);
        return;
    L6:
        if (this.mStandardScreenRefreshRate.getContentContainer() != r6) goto L9;
        setScreenRefreshRateMode(1);
        this.mAutoScreenRefreshRate.getCustomEndView().setVisibility(4);
        this.mStandardScreenRefreshRate.showCustomEnd(true);
        this.mHighScreenRefreshRate.showCustomEnd(false);
        this.mUseHighRefreshRateApp.setVisibility(8);
        return;
    L9:
        if (this.mHighScreenRefreshRate.getContentContainer() != r6) goto L12;
        setScreenRefreshRateMode(2);
        this.mAutoScreenRefreshRate.getCustomEndView().setVisibility(4);
        this.mStandardScreenRefreshRate.showCustomEnd(false);
        this.mHighScreenRefreshRate.showCustomEnd(true);
        this.mUseHighRefreshRateApp.setVisibility(0);
        return;
    L12:
        if (this.mUseHighRefreshRateApp.getContentContainer() != r6) goto L18;
        start(ScreenRefreshRateAppsSettingsFragment.class);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateView();
        registerContentObserver();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterContentObserver();
    }

    private void setScreenRefreshRateMode(int r2) {
        DynamicRefreshRateManager.updateSettingConfigId(r2);
        android.provider.Settings.Global.putInt(getContentResolver(), SCREEN_REFRESH_RATE, r2);
    }

    private int getScreenRefreshRateMode() {
        return DynamicRefreshRateManager.getSettingConfigId();
    }

    private boolean isLowBatteryMode() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "low_power", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void registerContentObserver() {
        getContentResolver().registerContentObserver(android.provider.Settings.Global.getUriFor("low_power"), true, this.mLowBatteryMode);
    }

    private void unregisterContentObserver() {
        getContentResolver().unregisterContentObserver(this.mLowBatteryMode);
    }

    private void updateViewDelay(final boolean r3) {
        this.mHandler.postDelayed(new AnonymousClass2(this, r3), 100);
    }

    private void updateView() {
        int r0 = getScreenRefreshRateMode();
        this.mAutoScreenRefreshRate.getCustomEndView().setVisibility(4);
        this.mStandardScreenRefreshRate.showCustomEnd(false);
        this.mHighScreenRefreshRate.showCustomEnd(false);
        this.mUseHighRefreshRateApp.setVisibility(8);
        if (r0 != 0) goto L5;
        this.mAutoScreenRefreshRate.getCustomEndView().setVisibility(0);
        this.mAutoScreenRefreshRate.showCustomEnd(true);
        return;
    L5:
        if (r0 != 1) goto L8;
        this.mStandardScreenRefreshRate.showCustomEnd(true);
        return;
    L8:
        if (r0 != 2) goto L13;
        this.mHighScreenRefreshRate.showCustomEnd(true);
        this.mUseHighRefreshRateApp.setVisibility(0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ScreenRefreshRateFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ScreenRefreshRateFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ScreenRefreshRateFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ScreenRefreshRateFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ScreenRefreshRateFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ScreenRefreshRateFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ScreenRefreshRateFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ScreenRefreshRateFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ScreenRefreshRateFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
