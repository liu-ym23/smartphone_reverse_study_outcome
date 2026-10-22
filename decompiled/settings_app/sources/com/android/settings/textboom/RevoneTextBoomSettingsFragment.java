package com.android.settings.textboom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.RevOneBigBangGifAnimView;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class RevoneTextBoomSettingsFragment extends BaseFragment implements View.OnClickListener {
    private RevOneBigBangGifAnimView mDemoAnimView;
    private SettingItemText mOCRLanguage;

    public void com_android_settings_textboom_RevoneTextBoomSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_textboom_RevoneTextBoomSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_textboom_RevoneTextBoomSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public RevoneTextBoomSettingsFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.revone_bigbang_settings_layout, r3, false);
        SettingItemText r5 = (SettingItemText) findViewByIdNullable(R.id.id_ocr_language);
        this.mOCRLanguage = r5;
        r5.setOnClickListener(this);
        this.mTitleResId = Integer.valueOf(R.string.text_boom_settings);
        this.mDemoAnimView = (RevOneBigBangGifAnimView) findViewByIdNullable(R.id.anim_view);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mOCRLanguage.setSubTitle(OCRDetalSettingsFragment.getOCRLangSubtitle(this.mContext));
        this.mDemoAnimView.startAnim();
    }

    public void com_android_settings_textboom_RevoneTextBoomSettingsFragment__onResume$___twin___() {
        super.onResume();
        this.mOCRLanguage.setSubTitle(OCRDetalSettingsFragment.getOCRLangSubtitle(this.mContext));
        this.mDemoAnimView.startAnim();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mDemoAnimView.stopAnim();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (this.mOCRLanguage != r2) goto L6;
        start(OCRLanguageChooserFragment.class);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_textboom_RevoneTextBoomSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(RevoneTextBoomSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_RevoneTextBoomSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_RevoneTextBoomSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(RevoneTextBoomSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_textboom_RevoneTextBoomSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_RevoneTextBoomSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(RevoneTextBoomSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_RevoneTextBoomSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
