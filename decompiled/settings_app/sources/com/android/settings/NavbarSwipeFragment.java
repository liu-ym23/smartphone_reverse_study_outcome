package com.android.settings;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class NavbarSwipeFragment extends BaseFragment {
    private View.OnClickListener mHeaderClickListener;
    private View mImageTipsSwipe;
    private View mImageTipsTap;
    private SettingItemCheck mNavbarSwipeTrigger;
    private SettingItemCheck mNavbarTapTrigger;
    private boolean mTriggerModeTap;

    public void com_android_settings_NavbarSwipeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_NavbarSwipeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_NavbarSwipeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_NavbarSwipeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NavbarSwipeFragment() {
        this.mHeaderClickListener = new AnonymousClass1(this);
    }

    static /* synthetic */ SettingItemCheck access$000(NavbarSwipeFragment r0) {
        return r0.mNavbarTapTrigger;
    }

    static /* synthetic */ boolean access$100(NavbarSwipeFragment r0) {
        return r0.mTriggerModeTap;
    }

    static /* synthetic */ boolean access$102(NavbarSwipeFragment r0, boolean r1) {
        r0.mTriggerModeTap = r1;
        return r1;
    }

    static /* synthetic */ SettingItemCheck access$200(NavbarSwipeFragment r0) {
        return r0.mNavbarSwipeTrigger;
    }

    static /* synthetic */ void access$300(NavbarSwipeFragment r0, boolean r1) {
        r0.updateTriggerMode(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.navbar_swipe_layout, r3, false);
        this.mNavbarTapTrigger = (SettingItemCheck) findViewByIdNullable(R.id.id_trigger_navbar_tap);
        this.mNavbarSwipeTrigger = (SettingItemCheck) findViewByIdNullable(R.id.id_trigger_navbar_swipe);
        this.mImageTipsTap = findViewByIdNullable(R.id.id_navbar_image_tap_container);
        this.mImageTipsSwipe = findViewByIdNullable(R.id.id_navbar_image_swipe);
        this.mNavbarTapTrigger.setOnClickListener(this.mHeaderClickListener);
        this.mNavbarSwipeTrigger.setOnClickListener(this.mHeaderClickListener);
        DisplayMetrics r5 = getResources().getDisplayMetrics();
        getResources().getDimensionPixelSize(R.dimen.navbar_item_check_title_max_size);
        int r6 = r5.densityDpi;
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        refreshCurrentState();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        refreshCurrentState();
        updateViews();
    }

    private void refreshCurrentState() {
        boolean r2 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "navbar_tap_or_swipe", 0) != 0) goto L5;
        r2 = true;
    L5:
        this.mTriggerModeTap = r2;
    }

    public void updateViews() {
        this.mNavbarTapTrigger.setChecked(false);
        this.mNavbarSwipeTrigger.setChecked(false);
        if (this.mTriggerModeTap == false) goto L5;
        this.mNavbarTapTrigger.setChecked(true);
        this.mImageTipsSwipe.setVisibility(8);
        this.mImageTipsTap.setVisibility(0);
        return;
    L5:
        this.mNavbarSwipeTrigger.setChecked(true);
        this.mImageTipsTap.setVisibility(8);
        this.mImageTipsSwipe.setVisibility(0);
    }

    private void updateTriggerMode(boolean r2) {
        this.mTriggerModeTap = r2;
        updateViews();
        android.provider.Settings.Global.putInt(getContentResolver(), "navbar_tap_or_swipe", !r2 ? 1 : 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_NavbarSwipeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NavbarSwipeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NavbarSwipeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NavbarSwipeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NavbarSwipeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_NavbarSwipeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NavbarSwipeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NavbarSwipeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NavbarSwipeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
