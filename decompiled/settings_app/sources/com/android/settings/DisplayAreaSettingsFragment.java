package com.android.settings;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.pm.IPackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bytedanceos.api.PackageManagerSmt;
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
public class DisplayAreaSettingsFragment extends BaseFragment implements View.OnClickListener {
    public static final String EXTRA_APP_LABEL = "label";
    public static final String EXTRA_APP_PKG_NAME = "pkg";
    private static final int SETTINGS_NOTCH_ANDROID = 1;
    private static final int SETTINGS_NOTCH_BYTEDANCE = 2;
    private static final String TAG = "ltan/DisplayAreaSettingsFrag";
    private static final int TYPE_LANDSCAPE = 1;
    private static final int TYPE_PORTRAIT = 0;
    private ActivityManager mActivityManager;
    private String mAppLabel;
    private IPackageManager mIPackageManager;
    private SettingItemCheck mOptionAdapter;
    private SettingItemCheck mOptionBelowStatus;
    private String mPackageName;

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DisplayAreaSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_DisplayAreaSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DisplayAreaSettingsFragment() {
    }

    static /* synthetic */ void access$000(DisplayAreaSettingsFragment r0) {
        r0.updateItemView();
    }

    static /* synthetic */ IPackageManager access$100(DisplayAreaSettingsFragment r0) {
        return r0.mIPackageManager;
    }

    static /* synthetic */ String access$200(DisplayAreaSettingsFragment r0) {
        return r0.mPackageName;
    }

    static /* synthetic */ ActivityManager access$300(DisplayAreaSettingsFragment r0) {
        return r0.mActivityManager;
    }

    static /* synthetic */ void access$400(DisplayAreaSettingsFragment r0, boolean r1) {
        r0.updateView(r1);
    }

    public void com_android_settings_DisplayAreaSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.display_area_settings_layout, r3, false);
        this.mOptionAdapter = (SettingItemCheck) findViewByIdNullable(R.id.status_bar_title_adaptive);
        this.mOptionBelowStatus = (SettingItemCheck) findViewByIdNullable(R.id.show_content_below_status_bar);
        this.mOptionAdapter.setOnClickListener(this);
        this.mOptionBelowStatus.setOnClickListener(this);
        findViewByIdNullable(R.id.status_bar_title_adaptive_image).setOnClickListener(this);
        findViewByIdNullable(R.id.show_content_below_status_bar_image).setOnClickListener(this);
        processArgs();
        this.mActivityManager = (ActivityManager) this.mContext.getSystemService("activity");
        return this.mRootView;
    }

    private void setLandscapeLayoutMargin(PreviewSettingItemView r3) {
        int r0 = getResources().getDimensionPixelOffset(R.dimen.notch_display_area_landscape_preview_top_margin);
        int r2 = getResources().getDimensionPixelOffset(R.dimen.notch_display_area_landscape_check_right_margin);
        r3.setPreviewImgMarginDimens(r0, 0, 0, 0);
        r3.setCheckImgMarginDimens(r0, r2, 0, 0);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        setTitle(this.mAppLabel);
        updateItemView();
    }

    private void processArgs() {
        Bundle r0 = getArguments();
        this.mPackageName = r0.getString("pkg");
        this.mAppLabel = r0.getString("label");
        OLog.d(TAG, "processArgs: mPackageName:" + this.mPackageName + ", mAppLabel:" + this.mAppLabel);
    }

    public void com_android_settings_DisplayAreaSettingsFragment__onResume$___twin___() {
        super.onResume();
        updateItemView();
    }

    private void showDialog(final boolean r4) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(this._mActivity);
        r0.setTitle(R.string.dlg_title_notice);
        r0.setNegativeButton(R.string.cancel, new AnonymousClass1(this));
        r0.setPositiveButton(R.string.ok, new AnonymousClass2(this, r4));
        r0.setMessage(getString(R.string.setting_display_area_switch_tips, new Object[]{this.mAppLabel}));
        r0.create().show();
    }

    private void updateItemView() {
        int r0 = PackageManagerSmt.getInstance().getNotchState(getPackageManager(), this.mPackageName);
        OLog.d(TAG, "updateItemView: state:" + Integer.toBinaryString(r0));
        boolean r1 = true;
        if (r0 == 1) goto L6;
        r1 = false;
    L6:
        updateView(r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3 == this.mOptionAdapter) goto L16;
        if (r3.getId() == R.id.status_bar_title_adaptive_image) goto L16;
        if (r3 == this.mOptionBelowStatus) goto L12;
        if (r3.getId() == R.id.show_content_below_status_bar_image) goto L12;
        return;
    L12:
        if (this.mOptionBelowStatus.isChecked() == false) goto L14;
        return;
    L14:
        setNotchState(false);
        return;
    L16:
        if (this.mOptionAdapter.isChecked() == false) goto L18;
        return;
    L18:
        setNotchState(true);
    }

    private void updateView(boolean r2) {
        this.mOptionAdapter.setChecked(r2);
        this.mOptionBelowStatus.setChecked(!r2);
    }

    private void setNotchState(boolean r4) {
        if (Utils.isAppRunning(this.mContext, this.mPackageName) == false) goto L5;
        showDialog(r4);
        return;
    L5:
        if (r4 == false) goto L7;
        int r0 = 1;
    L8:
        AdaptUtils.setAppNotchState(this.mIPackageManager, this.mPackageName, r0);
        this.mActivityManager.forceStopPackage(this.mPackageName);
        updateView(r4);
        return;
    L7:
        r0 = 2;
        goto L8
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DisplayAreaSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DisplayAreaSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DisplayAreaSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DisplayAreaSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DisplayAreaSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_DisplayAreaSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DisplayAreaSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DisplayAreaSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DisplayAreaSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
