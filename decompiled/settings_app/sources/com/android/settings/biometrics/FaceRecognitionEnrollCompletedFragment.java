package com.android.settings.biometrics;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class FaceRecognitionEnrollCompletedFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private boolean mIsFromSetupWizard;
    private SettingItemSwitch mItemSwitchStayInLockScreen;
    private ImageView mIvFrPreviewSuc;
    private TextView mTipsFacePreviewSuc;

    public void com_android_settings_biometrics_FaceRecognitionEnrollCompletedFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_biometrics_FaceRecognitionEnrollCompletedFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_biometrics_FaceRecognitionEnrollCompletedFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public FaceRecognitionEnrollCompletedFragment() {
    }

    public void com_android_settings_biometrics_FaceRecognitionEnrollCompletedFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mIsFromSetupWizard = !Utils.isDeviceSetupComplete(this.mContext);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.face_recognition_enroll_completed_fragment, r3, false);
        this.mItemSwitchStayInLockScreen = (SettingItemSwitch) findViewByIdNullable(R.id.item_switch_stay_in_lock_screen);
        this.mIvFrPreviewSuc = (ImageView) findViewByIdNullable(R.id.iv_fr_preview_suc);
        this.mTipsFacePreviewSuc = (TextView) findViewByIdNullable(R.id.tips_face_preview_suc);
        findViewByIdNullable(R.id.btn_done).setOnClickListener(this);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        this.mBackView.setVisibility(8);
        updateViews();
        this.mItemSwitchStayInLockScreen.setOnCheckedChangeListener(this);
    }

    public void updateViews() {
        boolean r0 = FaceRecognitionManageFragment.isEnterDesktopWhenFaceRecognized(this.mContext);
        this.mItemSwitchStayInLockScreen.setChecked(r0);
        updateView(r0);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mItemSwitchStayInLockScreen.getSwitch()) goto L6;
        FaceRecognitionManageFragment.saveEnterDesktopWhenFaceRecognized(this.mContext, r3);
        updateView(r3);
        return;
    }

    private void updateView(boolean r3) {
        ImageView r0 = this.mIvFrPreviewSuc;
        if (r3 == false) goto L5;
        int r1 = R.drawable.setting_fr_preview_suc;
    L6:
        r0.setBackgroundResource(r1);
        TextView r2 = this.mTipsFacePreviewSuc;
        if (r3 == false) goto L9;
        int r4 = R.string.face_recognition_success_tips;
    L10:
        r2.setText(r4);
        return;
    L9:
        r4 = R.string.face_recognition_success_tips_stay_in_lock_screen;
        goto L10
    L5:
        r1 = R.drawable.setting_fr_preview_suc_unlocked;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2.getId() == R.id.btn_done) goto L6;
        return;
    L6:
        if (this.mIsFromSetupWizard == false) goto L8;
        turnToSetupWizardCompleteActivity();
    L8:
        finish();
    }

    private void turnToSetupWizardCompleteActivity() {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName("com.bytedanceos.setupwizard", "com.bytedanceos.setupwizard.SetupWizardCompleteActivity"));
        Utils.startActivity(this._mActivity, r0);
    }

    @Override // com.android.settings.base.BaseFragment
    public void finish() {
        super.finish();
        if (this.mIsFromSetupWizard == false) goto L6;
        TransitionAnimHelper.overrideEnterAnim(this._mActivity, TransitionAnimStyle.Standard);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_biometrics_FaceRecognitionEnrollCompletedFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FaceRecognitionEnrollCompletedFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_biometrics_FaceRecognitionEnrollCompletedFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_biometrics_FaceRecognitionEnrollCompletedFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FaceRecognitionEnrollCompletedFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_biometrics_FaceRecognitionEnrollCompletedFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_biometrics_FaceRecognitionEnrollCompletedFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FaceRecognitionEnrollCompletedFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_biometrics_FaceRecognitionEnrollCompletedFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
