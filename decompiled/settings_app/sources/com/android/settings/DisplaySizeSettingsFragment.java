package com.android.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.display.DisplayDensityUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DisplaySizeSettingsFragment extends BaseFragment implements View.OnClickListener {
    public static final int[] DISPLAY_SIZE_VALUES = null;
    public static final int LARGE_DISPLAY_INDEX = 2;
    public static final int LARGE_DISPLAY_SIZE = 640;
    public static final int NORMAL_DISPLAY_INDEX = 1;
    public static final int NORMAL_DISPLAY_SIZE = 560;
    public static final float RESOLUTION_SCALE = 0.875f;
    public static final int SMALL_DISPLAY_INDEX = 0;
    public static final int SMALL_DISPLAY_SIZE = 480;
    private int mDefaultDensity;
    private DisplayDensityUtils mDensity;
    private OCardListItem mLargeDisplaySizeItem;
    private OCardListItem mNormalDisplaySizeItem;
    private int mSelectedIndex;
    private OCardListItem mSmallDisplaySizeItem;

    public void com_android_settings_DisplaySizeSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DisplaySizeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_DisplaySizeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static {
        DISPLAY_SIZE_VALUES = new int[]{480, 560, 640};
    }

    public DisplaySizeSettingsFragment() {
        super(R.layout.display_size_settings_layout);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        DisplayDensityUtils r4 = new DisplayDensityUtils(getActivity());
        this.mDensity = r4;
        this.mDefaultDensity = r4.getDefaultDensityForDefaultDisplay();
        this.mDensity.getDefaultDisplayDensityValues();
        ((LinearLayout) findViewByIdNullable(R.id.page_container)).setOnClickListener(this);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.small_display);
        this.mSmallDisplaySizeItem = r5;
        OCardListItemUtils.setCustomEndImageView(r5);
        this.mSmallDisplaySizeItem.showCustomEnd(false);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.normal_display);
        this.mNormalDisplaySizeItem = r6;
        OCardListItemUtils.setCustomEndImageView(r6);
        this.mNormalDisplaySizeItem.showCustomEnd(false);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.large_display);
        this.mLargeDisplaySizeItem = r7;
        OCardListItemUtils.setCustomEndImageView(r7);
        this.mLargeDisplaySizeItem.showCustomEnd(false);
        this.mSmallDisplaySizeItem.setOnContentClickListener(this);
        this.mNormalDisplaySizeItem.setOnContentClickListener(this);
        this.mLargeDisplaySizeItem.setOnContentClickListener(this);
        if (this.mDensity.getCurrentIndexForDefaultDisplay() >= 0) goto L5;
        OLog.e(this.TAG, "Failed to obtain default density");
        this.mDefaultDensity = getResources().getDisplayMetrics().densityDpi;
        this.mSmallDisplaySizeItem.setVisibility(8);
        this.mLargeDisplaySizeItem.setVisibility(8);
        this.mNormalDisplaySizeItem.setCardPosition(0);
    L6:
        int r8 = this.mDensity.getCurrentIndexForDefaultDisplay();
        this.mSelectedIndex = r8;
        updateView(r8);
        return;
    L5:
        this.mDefaultDensity = this.mDensity.getDefaultDensityForDefaultDisplay();
        goto L6
    }

    public void com_android_settings_DisplaySizeSettingsFragment__onResume$___twin___() {
        super.onResume();
        int r0 = this.mDensity.getCurrentIndexForDefaultDisplay();
        this.mSelectedIndex = r0;
        updateView(r0);
    }

    private void updateView(int r3) {
        this.mSmallDisplaySizeItem.showCustomEnd(false);
        this.mNormalDisplaySizeItem.showCustomEnd(false);
        this.mLargeDisplaySizeItem.showCustomEnd(false);
        if (r3 >= 0) goto L5;
        this.mNormalDisplaySizeItem.showCustomEnd(true);
        return;
    L5:
        if (r3 != 0) goto L7;
        this.mSmallDisplaySizeItem.showCustomEnd(true);
    L7:
        if (r3 != 1) goto L10;
        this.mNormalDisplaySizeItem.showCustomEnd(true);
    L10:
        if (r3 != 2) goto L14;
        this.mLargeDisplaySizeItem.showCustomEnd(true);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mSmallDisplaySizeItem.getContentContainer()) goto L6;
        this.mDensity.setForcedDisplayDensity(0);
        return;
    L6:
        if (r2 != this.mNormalDisplaySizeItem.getContentContainer()) goto L9;
        this.mDensity.clearForcedDisplayDensity();
        return;
    L9:
        if (r2 != this.mLargeDisplaySizeItem.getContentContainer()) goto L14;
        this.mDensity.setForcedDisplayDensity(2);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DisplaySizeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DisplaySizeSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DisplaySizeSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DisplaySizeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DisplaySizeSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_DisplaySizeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DisplaySizeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DisplaySizeSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DisplaySizeSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
