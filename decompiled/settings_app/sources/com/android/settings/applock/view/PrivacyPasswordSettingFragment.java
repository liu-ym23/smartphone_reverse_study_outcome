package com.android.settings.applock.view;

import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.AppLockUtil;
import com.android.settings.LockScreenFragment;
import com.android.settings.PrivacySecurity;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class PrivacyPasswordSettingFragment extends BaseFragment {
    protected static final int SIX_DIGIT_PIN = 6;
    private DevicePolicyManager mDpm;
    private boolean mExitSmilingCloud;
    private boolean mNeedFinish;

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applock_view_PrivacyPasswordSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applock_view_PrivacyPasswordSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PrivacyPasswordSettingFragment() {
    }

    public void com_android_settings_applock_view_PrivacyPasswordSettingFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        this.mDpm = (DevicePolicyManager) getSystemService("device_policy");
        if (getActivity() == null) goto L6;
        this.mExitSmilingCloud = Utils.getBooleanExtraSafely(getActivity().getIntent(), AppLockUtil.EXIT_SMILING_CLOUD, false);
        return;
    }

    public void com_android_settings_applock_view_PrivacyPasswordSettingFragment__onResume$___twin___() {
        super.onResume();
        this.mNeedFinish = true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.privacy_password_setting, r3, false);
        initView(this.mRootView);
        if (this.mExitSmilingCloud == false) goto L6;
        showClosePasswordDialog();
    L6:
        return this.mRootView;
    }

    private void initView(View r5) {
        SettingItemText r0 = (SettingItemText) NullSafe.nonNull(r5.findViewById(R.id.item_plate_lock));
        r0.setOnClickListener(new PrivacyPasswordSettingFragment$$ExternalSyntheticLambda1(this));
        SettingItemText r1 = (SettingItemText) NullSafe.nonNull(r5.findViewById(R.id.item_application_lock));
        r1.setOnClickListener(new PrivacyPasswordSettingFragment$$ExternalSyntheticLambda2(this));
        SettingItemText r2 = (SettingItemText) NullSafe.nonNull(r5.findViewById(R.id.item_origin_application_lock));
        r2.setOnClickListener(new PrivacyPasswordSettingFragment$$ExternalSyntheticLambda3(this));
        if (Utils.isBytedanceLauncher(this.mContext) == true) goto L5;
        r0.setVisibility(8);
        r1.setVisibility(8);
        r2.setVisibility(0);
    L5:
        ((SettingItemText) NullSafe.nonNull(r5.findViewById(R.id.item_change_password))).setOnClickListener(new PrivacyPasswordSettingFragment$$ExternalSyntheticLambda4(this));
        ((OButton) NullSafe.nonNull(r5.findViewById(R.id.close_password))).setOnClickListener(new PrivacyPasswordSettingFragment$$ExternalSyntheticLambda5(this));
    }

    /* JADX INFO: renamed from: lambda$initView$0$com-android-settings-applock-view-PrivacyPasswordSettingFragment, reason: not valid java name */
    /* synthetic */ void m325x9ed2f84a(View r1) {
        this.mNeedFinish = false;
        start(new DesktopPlateLockFragment());
    }

    /* JADX INFO: renamed from: lambda$initView$1$com-android-settings-applock-view-PrivacyPasswordSettingFragment, reason: not valid java name */
    /* synthetic */ void m326x9028069(View r1) {
        this.mNeedFinish = false;
        start(new AppLockListFragment());
    }

    /* JADX INFO: renamed from: lambda$initView$2$com-android-settings-applock-view-PrivacyPasswordSettingFragment, reason: not valid java name */
    /* synthetic */ void m327x73320888(View r1) {
        this.mNeedFinish = false;
        start(new AppLockListFragment());
    }

    /* JADX INFO: renamed from: lambda$initView$3$com-android-settings-applock-view-PrivacyPasswordSettingFragment, reason: not valid java name */
    /* synthetic */ void m328xdd6190a7(View r1) {
        this.mNeedFinish = false;
        changePassword();
    }

    /* JADX INFO: renamed from: lambda$initView$4$com-android-settings-applock-view-PrivacyPasswordSettingFragment, reason: not valid java name */
    /* synthetic */ void m329x479118c6(View r1) {
        showClosePasswordDialog();
    }

    private void changePassword() {
        LockScreenFragment.gotoChooseEasyPassword(getContext(), this.mDpm, 6, R.string.security_password_change, false, true, false);
    }

    private void showClosePasswordDialog() {
        DialogInterface.OnClickListener r0 = new PrivacyPasswordSettingFragment$$ExternalSyntheticLambda0(this);
        new AlertDialog.Builder(getContext()).setTitle(R.string.dlg_title_notice).setMessage(R.string.security_close_dialog_content).setPositiveButton(getString(R.string.okay), r0).setNegativeButton(getString(R.string.cancel), r0).create().show();
    }

    /* JADX INFO: renamed from: lambda$showClosePasswordDialog$5$com-android-settings-applock-view-PrivacyPasswordSettingFragment, reason: not valid java name */
    /* synthetic */ void m330x33c9bed6(DialogInterface r2, int r3) {
        if (r3 != (-2)) goto L5;
        r2.dismiss();
        return;
    L5:
        if (r3 != (-1)) goto L14;
        cleanPassword();
        if (getActivity() == null) goto L12;
        getActivity().finish();
        return;
    L12:
        return;
    }

    private void cleanPassword() {
        PrivacySecurity.getInstance(this.mContext).disableSecurity();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNeedFinish == false) goto L6;
        Utils.finishActivityDelay(getActivity());
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applock_view_PrivacyPasswordSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PrivacyPasswordSettingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applock_view_PrivacyPasswordSettingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applock_view_PrivacyPasswordSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PrivacyPasswordSettingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applock_view_PrivacyPasswordSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applock_view_PrivacyPasswordSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PrivacyPasswordSettingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applock_view_PrivacyPasswordSettingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
