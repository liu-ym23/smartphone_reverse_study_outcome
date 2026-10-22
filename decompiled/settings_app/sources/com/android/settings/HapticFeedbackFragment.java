package com.android.settings;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bytedanceos.api.VibratorSmt;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class HapticFeedbackFragment extends BaseFragment implements View.OnClickListener {
    private OCardListItem mClose;
    private OCardListItem mHigh;
    private OCardListItem mLow;
    private OCardListItem mMid;

    public void com_android_settings_HapticFeedbackFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_HapticFeedbackFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_HapticFeedbackFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_HapticFeedbackFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public HapticFeedbackFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.haptic_feedback_layout, r3, false);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.close_haptic_feedback);
        this.mClose = r5;
        OCardListItemUtils.setCustomEndImageView(r5);
        this.mClose.setOnContentClickListener(this);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.low_haptic_feedback);
        this.mLow = r6;
        OCardListItemUtils.setCustomEndImageView(r6);
        this.mLow.setOnContentClickListener(this);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.mid_haptic_feedback);
        this.mMid = r7;
        OCardListItemUtils.setCustomEndImageView(r7);
        this.mMid.setOnContentClickListener(this);
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.high_haptic_feedback);
        this.mHigh = r8;
        OCardListItemUtils.setCustomEndImageView(r8);
        this.mHigh.setOnContentClickListener(this);
        updateView();
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) this.mRootView.findViewById(R.id.page_container));
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3 != this.mClose.getContentContainer()) goto L6;
        android.provider.Settings.System.putInt(getContext().getContentResolver(), "haptic_feedback_intensity", 0);
    L14:
        updateView();
        playHapticFeedback();
        return;
    L6:
        if (r3 != this.mLow.getContentContainer()) goto L9;
        android.provider.Settings.System.putInt(getContext().getContentResolver(), "haptic_feedback_intensity", 1);
        goto L14
    L9:
        if (r3 != this.mMid.getContentContainer()) goto L12;
        android.provider.Settings.System.putInt(getContext().getContentResolver(), "haptic_feedback_intensity", 2);
        goto L14
    L12:
        if (r3 != this.mHigh.getContentContainer()) goto L14;
        android.provider.Settings.System.putInt(getContext().getContentResolver(), "haptic_feedback_intensity", 3);
        goto L14
    }

    private void updateView() {
        this.mClose.showCustomEnd(false);
        this.mLow.showCustomEnd(false);
        this.mMid.showCustomEnd(false);
        this.mHigh.showCustomEnd(false);
        int r0 = android.provider.Settings.System.getInt(getContext().getContentResolver(), "haptic_feedback_intensity", 3);
        if (r0 != 0) goto L5;
        this.mClose.showCustomEnd(true);
        return;
    L5:
        if (r0 != 1) goto L8;
        this.mLow.showCustomEnd(true);
        return;
    L8:
        if (r0 != 2) goto L10;
        this.mMid.showCustomEnd(true);
        return;
    L10:
        if (r0 != 3) goto L16;
        this.mHigh.showCustomEnd(true);
        return;
    }

    void playHapticFeedback() {
        VibratorSmt.vibrateEffectWithHapticPlayer((Vibrator) this.mContext.getSystemService("vibrator"), 0);     // Catch: NoSuchMethodError -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        OLog.e(this.TAG, "VibratorSmt.vibrateEffectWithHapticPlayer() failed");
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_HapticFeedbackFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(HapticFeedbackFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_HapticFeedbackFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_HapticFeedbackFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(HapticFeedbackFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_HapticFeedbackFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_HapticFeedbackFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(HapticFeedbackFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_HapticFeedbackFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
