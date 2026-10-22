package com.android.settings.accessibility;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class VisualAccessibilitySettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private OCardListItem mColorCorrectionItemText;
    private OCardListItem mColorInversionItem;
    private OSwitch mColorInversionItemSwitch;
    private OCardListItem mLargePointerIconItem;
    private OSwitch mLargePointerIconItemSwitch;
    private ContentObserver mObserver;
    private OCardListItem mScreenMagnificationItemText;
    private View mShadowBelowSpeakPassword;
    private OCardListItem mSpeakPasswordItem;
    private OSwitch mSpeakPasswordItemSwitch;
    private OCardListItem mSpeechReadingItemText;
    private OCardListItem mTextHighContrastItem;
    OSwitch mTextHighContrastItemSwitch;

    public void com_android_settings_accessibility_VisualAccessibilitySettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_accessibility_VisualAccessibilitySettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_VisualAccessibilitySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_VisualAccessibilitySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public VisualAccessibilitySettingsFragment() {
    }

    static /* synthetic */ OSwitch access$000(VisualAccessibilitySettingsFragment r0) {
        return r0.mColorInversionItemSwitch;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mTitleResId = Integer.valueOf(R.string.accessibility_blind_mode);
        this.mRootView = r2.inflate(R.layout.visual_accessibility_settings_fragment, r3, false);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.speech_reading);
        this.mSpeechReadingItemText = r5;
        r5.setDefaultCustomEndView(3);
        this.mSpeechReadingItemText.showCustomEnd(true);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.screen_magnification);
        this.mScreenMagnificationItemText = r6;
        r6.setDefaultCustomEndView(3);
        this.mScreenMagnificationItemText.showCustomEnd(true);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.large_pointer_icon);
        this.mLargePointerIconItem = r7;
        r7.setDefaultCustomEndView(1);
        this.mLargePointerIconItem.showCustomEnd(true);
        OSwitch r8 = (OSwitch) this.mLargePointerIconItem.getCustomEndView();
        this.mLargePointerIconItemSwitch = r8;
        r8.setClickable(true);
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.color_correction);
        this.mColorCorrectionItemText = r9;
        r9.setDefaultCustomEndView(3);
        this.mColorCorrectionItemText.showCustomEnd(true);
        OCardListItem r10 = (OCardListItem) findViewByIdNullable(R.id.color_inversion);
        this.mColorInversionItem = r10;
        r10.setDefaultCustomEndView(1);
        this.mColorInversionItem.showCustomEnd(true);
        OSwitch r11 = (OSwitch) this.mColorInversionItem.getCustomEndView();
        this.mColorInversionItemSwitch = r11;
        r11.setClickable(true);
        OCardListItem r12 = (OCardListItem) findViewByIdNullable(R.id.text_high_contrast);
        this.mTextHighContrastItem = r12;
        r12.setDefaultCustomEndView(1);
        this.mTextHighContrastItem.showCustomEnd(true);
        this.mTextHighContrastItemSwitch = (OSwitch) this.mTextHighContrastItem.getCustomEndView();
        OCardListItem r13 = (OCardListItem) findViewByIdNullable(R.id.speak_password);
        this.mSpeakPasswordItem = r13;
        r13.setDefaultCustomEndView(1);
        OSwitch r14 = (OSwitch) this.mSpeakPasswordItem.getCustomEndView();
        this.mSpeakPasswordItemSwitch = r14;
        r14.setClickable(true);
        this.mSpeakPasswordItem.showCustomEnd(true);
        this.mShadowBelowSpeakPassword = findViewByIdNullable(R.id.shadow_below_speak_password);
        this.mSpeechReadingItemText.setOnContentClickListener(new VisualAccessibilitySettingsFragment$$ExternalSyntheticLambda0(this));
        this.mScreenMagnificationItemText.setOnContentClickListener(new VisualAccessibilitySettingsFragment$$ExternalSyntheticLambda1(this));
        this.mColorCorrectionItemText.setOnContentClickListener(new VisualAccessibilitySettingsFragment$$ExternalSyntheticLambda2(this));
        if (this.mIsExtDisplaying == false) goto L5;
        this.mSpeechReadingItemText.setVisibility(8);
        findViewByIdNullable(R.id.speech_tips).setVisibility(8);
    L5:
        final Handler r15 = Handler.createAsync(Looper.getMainLooper());
        this.mObserver = new AnonymousClass1(this, r15);
        getContentResolver().registerContentObserver(Settings.Secure.getUriFor("accessibility_display_inversion_enabled"), false, this.mObserver);
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-accessibility-VisualAccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m265xe305743d(View r1) {
        onClick(this.mSpeechReadingItemText);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-accessibility-VisualAccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m266x6550291c(View r1) {
        onClick(this.mScreenMagnificationItemText);
    }

    /* JADX INFO: renamed from: lambda$onCreateView$2$com-android-settings-accessibility-VisualAccessibilitySettingsFragment, reason: not valid java name */
    /* synthetic */ void m267xe79addfb(View r1) {
        onClick(this.mColorCorrectionItemText);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mLargePointerIconItemSwitch.setOnCheckedChangeListener(this);
        this.mColorInversionItemSwitch.setOnCheckedChangeListener(this);
        this.mTextHighContrastItemSwitch.setOnCheckedChangeListener(this);
        this.mSpeakPasswordItemSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (this.mObserver == null) goto L5;
        getContentResolver().unregisterContentObserver(this.mObserver);
    L5:
        super.onDestroyView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mSpeechReadingItemText) goto L6;
        start(AccessibilitySpeechReadingFragment.class);
        return;
    L6:
        if (r2 != this.mScreenMagnificationItemText) goto L9;
        start(AccessibilityScreenMagnificationSettingsFragment.class);
        return;
    L9:
        if (r2 != this.mColorCorrectionItemText) goto L14;
        start(AccessibilityColorCorrectionSettingsFragment.class);
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mLargePointerIconItemSwitch) goto L6;
        handleToggleLargePointerIconPreferenceClick(r3);
        return;
    L6:
        if (r2 != this.mColorInversionItemSwitch) goto L9;
        handleToggleInversionPreferenceChange(r3);
        return;
    L9:
        if (r2 != this.mTextHighContrastItemSwitch) goto L12;
        handleToggleTextContrastPreferenceClick(r3);
        return;
    L12:
        if (r2 != this.mSpeakPasswordItemSwitch) goto L18;
        handleToggleSpeakPasswordPreferenceClick(r3);
        return;
    }

    private void updateViews() {
        ContentResolver r0 = getContentResolver();
        OCardListItem r1 = this.mSpeechReadingItemText;
        boolean r3 = false;
        int r2 = Settings.Global.getInt(r0, "accessibility_speech_reading", 0);
        int r4 = R.string.settings_state_on;
        if (r2 != 1) goto L5;
        int r5 = R.string.settings_state_on;
    L6:
        r1.setEndDetailText(getString(r5));
        OCardListItem r6 = this.mScreenMagnificationItemText;
        if (Settings.Secure.getInt(r0, "accessibility_display_magnification_enabled", 0) != 1) goto L9;
        int r7 = R.string.settings_state_on;
    L10:
        r6.setEndDetailText(getString(r7));
        OCardListItem r8 = this.mColorCorrectionItemText;
        if (Settings.Secure.getInt(r0, "accessibility_display_daltonizer_enabled", 0) == 1) goto L14;
        r4 = R.string.settings_state_off;
    L14:
        r8.setEndDetailText(getString(r4));
        OSwitch r9 = this.mLargePointerIconItemSwitch;
        if (Settings.Secure.getInt(r0, "accessibility_large_pointer_icon", 0) != 1) goto L17;
        boolean r10 = true;
    L18:
        r9.setChecked(r10);
        OSwitch r11 = this.mColorInversionItemSwitch;
        if (Settings.Secure.getInt(r0, "accessibility_display_inversion_enabled", 0) != 1) goto L21;
        boolean r12 = true;
    L22:
        r11.setChecked(r12);
        OSwitch r13 = this.mTextHighContrastItemSwitch;
        if (Settings.Secure.getInt(r0, "high_text_contrast_enabled", 0) != 1) goto L25;
        r3 = true;
    L25:
        r13.setChecked(r3);
        this.mSpeakPasswordItemSwitch.setVisibility(8);
        this.mShadowBelowSpeakPassword.setVisibility(8);
        return;
    L21:
        r12 = false;
        goto L22
    L17:
        r10 = false;
        goto L18
    L9:
        r7 = R.string.settings_state_off;
        goto L10
    L5:
        r5 = R.string.settings_state_off;
        goto L6
    }

    private void handleToggleLargePointerIconPreferenceClick(boolean r2) {
        Settings.Secure.putInt(getContentResolver(), "accessibility_large_pointer_icon", r2 ? 1 : 0);
    }

    private void handleToggleInversionPreferenceChange(boolean r4) {
        OLog.d(this.TAG, "handleToggleInversionPreferenceChange checked: " + r4);
        Settings.Secure.putInt(getContentResolver(), "accessibility_display_inversion_enabled", r4 ? 1 : 0);
    }

    private void handleToggleTextContrastPreferenceClick(boolean r4) {
        OLog.d(this.TAG, "handleToggleTextContrastPreferenceClick checked: " + r4);
        Settings.Secure.putInt(getContentResolver(), "high_text_contrast_enabled", r4 ? 1 : 0);
    }

    private void handleToggleSpeakPasswordPreferenceClick(boolean r2) {
        Settings.Secure.putInt(getContentResolver(), "speak_password", r2 ? 1 : 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_VisualAccessibilitySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(VisualAccessibilitySettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_VisualAccessibilitySettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_VisualAccessibilitySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(VisualAccessibilitySettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_VisualAccessibilitySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_VisualAccessibilitySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(VisualAccessibilitySettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_VisualAccessibilitySettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
