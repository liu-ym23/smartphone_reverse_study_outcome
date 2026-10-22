package com.android.settings.eyesprotection;

import android.database.ContentObserver;
import android.hardware.display.ColorDisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.slider.SeekBarFloatCompat;
import com.obric.privacy.GrantUtil;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class EyesProtectionFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    public final String RHYTHM_TEMPERATURE_MODE;
    private final int SEEK_BAR_DEFAULT;
    private final int SEEK_BAR_MAX;
    private OCardListItem mAutoTurnOnOff;
    private ColorDisplayManager mColorDisplayManager;
    private SeekBarFloatCompat mColorTemperatureSlider;
    private OButton mDefaultBtn;
    private final ContentObserver mEyesProtectionObserver;
    private OCardListItem mProtectEyesEnable;
    private OCardListItem mRhythmEyeProtection;
    private TextView mTempAdjustmentTip;
    private OUILinearLayout mTempContainer;

    public void com_android_settings_eyesprotection_EyesProtectionFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_eyesprotection_EyesProtectionFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_eyesprotection_EyesProtectionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_eyesprotection_EyesProtectionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(EyesProtectionFragment r0, int r1) {
        r0.setColorTemperature(r1);
    }

    static /* synthetic */ void access$100(EyesProtectionFragment r0) {
        r0.updateEyesProtectionSwitchState();
    }

    static /* synthetic */ void access$200(EyesProtectionFragment r0) {
        r0.updateTempContainer();
    }

    public EyesProtectionFragment() {
        super(R.layout.protect_eyes_settings_layout);
        this.RHYTHM_TEMPERATURE_MODE = "rhythm_temperature_mode";
        this.SEEK_BAR_MAX = 100;
        this.SEEK_BAR_DEFAULT = 50;
        final Handler r1 = new Handler();
        this.mEyesProtectionObserver = new AnonymousClass2(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.mColorDisplayManager = (ColorDisplayManager) this.mContext.getSystemService(ColorDisplayManager.class);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.protect_eyes_enable);
        this.mProtectEyesEnable = r5;
        r5.getContentContainer().setClickable(false);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.auto_turn_on_off);
        this.mAutoTurnOnOff = r6;
        r6.setOnContentClickListener(this);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.rhythmic_eye_protection);
        this.mRhythmEyeProtection = r7;
        r7.getContentContainer().setClickable(false);
        if (isProtectEyesEnable() == false) goto L5;
        this.mRhythmEyeProtection.setVisibility(0);
    L6:
        this.mTempContainer = (OUILinearLayout) findViewByIdNullable(R.id.temperature_container);
        if (isProtectEyesEnable() == true) goto L9;
        this.mTempContainer.setVisibility(8);
    L13:
        OButton r8 = (OButton) findViewByIdNullable(R.id.btn_default);
        this.mDefaultBtn = r8;
        r8.setOnClickListener(this);
        SeekBarFloatCompat r9 = (SeekBarFloatCompat) findViewByIdNullable(R.id.color_temperature_seekbar);
        this.mColorTemperatureSlider = r9;
        r9.setMax(100);
        this.mColorTemperatureSlider.setProgress(getColorTemperature());
        this.mColorTemperatureSlider.setOnSeekBarChangeListener(new AnonymousClass1(this));
        this.mContext.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("night_display_activated"), true, this.mEyesProtectionObserver);
        updateEyesProtectionSwitchState();
        updateTempContainer();
        return;
    L9:
        if (getRhythmEyeProtection() == false) goto L11;
        this.mTempContainer.setVisibility(8);
        goto L13
    L11:
        this.mTempContainer.setVisibility(0);
        goto L13
    L5:
        this.mRhythmEyeProtection.setVisibility(8);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        ((OSwitch) this.mProtectEyesEnable.getCustomEndView()).setChecked(isProtectEyesEnable());
        ((OSwitch) this.mProtectEyesEnable.getCustomEndView()).setOnCheckedChangeListener(this);
        ((OSwitch) this.mRhythmEyeProtection.getCustomEndView()).setChecked(getRhythmEyeProtection());
        ((OSwitch) this.mRhythmEyeProtection.getCustomEndView()).setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateEyesProtectionSwitchState();
        updateTempContainer();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mContext.getContentResolver().unregisterContentObserver(this.mEyesProtectionObserver);
    }

    private void updateEyesProtectionSwitchState() {
        boolean r0 = isProtectEyesEnable();
        ((OSwitch) this.mProtectEyesEnable.getCustomEndView()).setChecked(r0);
        ((OSwitch) this.mRhythmEyeProtection.getCustomEndView()).setChecked(getRhythmEyeProtection());
        if (r0 == false) goto L5;
        this.mRhythmEyeProtection.setVisibility(0);
    L6:
        if (r0 == true) goto L8;
        this.mTempContainer.setVisibility(8);
    L12:
        int r1 = this.mColorDisplayManager.getNightDisplayAutoMode();
        if (r1 != 0) goto L15;
        if (r0 == false) goto L29;
        int r2 = R.string.protect_eyes_summary_on;
    L30:
        String r3 = getString(r2);
    L31:
        this.mProtectEyesEnable.setSubTitle(r3);
        return;
    L29:
        r2 = R.string.protect_eyes_summary_off;
        goto L30
    L15:
        if (r1 != 1) goto L17;
        LocalTime r4 = this.mColorDisplayManager.getNightDisplayCustomStartTime();
        LocalTime r5 = this.mColorDisplayManager.getNightDisplayCustomEndTime();
        if (r0 == false) goto L26;
        r3 = getString(R.string.protect_eyes_summary_custom_timer_on, new Object[]{r5.format(DateTimeFormatter.ofPattern("HH:mm"))});
        goto L31
    L26:
        r3 = getString(R.string.protect_eyes_summary_custom_timer_off, new Object[]{r4.format(DateTimeFormatter.ofPattern("HH:mm"))});
        goto L31
    L17:
        if (r1 == 2) goto L19;
        r3 = "";
        goto L31
    L19:
        if (r0 == false) goto L21;
        int r6 = R.string.protect_eyes_summary_auto_timer_on;
    L22:
        r3 = getString(r6);
        goto L31
    L21:
        r6 = R.string.protect_eyes_summary_auto_timer_off;
        goto L22
    L8:
        if (getRhythmEyeProtection() == false) goto L10;
        this.mTempContainer.setVisibility(8);
        goto L12
    L10:
        this.mTempContainer.setVisibility(0);
        goto L12
    L5:
        this.mRhythmEyeProtection.setVisibility(8);
        goto L6
    }

    private void updateTempContainer() {
        if (isProtectEyesEnable() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        this.mTempContainer.setVisibility(0);
        return;
    L10:
        this.mTempContainer.setVisibility(8);
        return;
    L5:
        if (getRhythmEyeProtection() == true) goto L7;
        r0 = true;
        goto L8
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        if (r3 != ((OSwitch) this.mProtectEyesEnable.getCustomEndView())) goto L9;
        setProtectEyesEnable(r4);
        if (r4 == false) goto L7;
        this.mRhythmEyeProtection.setVisibility(0);
        goto L9
    L7:
        this.mRhythmEyeProtection.setVisibility(8);
    L9:
        if (r3 != ((OSwitch) this.mRhythmEyeProtection.getCustomEndView())) goto L11;
        setRhythmEyeProtection(r4);
    L11:
        updateTempContainer();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mAutoTurnOnOff.getContentContainer()) goto L6;
        start(EyesProtectionTimer.class);
    L6:
        if (r2 != this.mDefaultBtn) goto L9;
        setColorTemperature(50);
        this.mColorTemperatureSlider.setProgress(50);
        return;
    }

    private boolean isProtectEyesEnable() {
        return this.mColorDisplayManager.isNightDisplayActivated();
    }

    private void setProtectEyesEnable(boolean r1) {
        this.mColorDisplayManager.setNightDisplayActivated(r1);
    }

    private void setRhythmEyeProtection(boolean r2) {
        Settings.Secure.putInt(this.mContext.getContentResolver(), "rhythm_temperature_mode", r2 ? 1 : 0);
    }

    private boolean getRhythmEyeProtection() {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "rhythm_temperature_mode", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private int getColorTemperature() {
        int r5 = this.mColorDisplayManager.getMinimumColorTemperature();     // Catch: Throwable -> L14
        int r6 = this.mColorDisplayManager.getMaximumColorTemperature();     // Catch: Throwable -> L14
        int r7 = this.mColorDisplayManager.getDefaultColorTemperature();     // Catch: Throwable -> L14
        OLog.d(this.TAG, "minTemp: " + r5 + ", maxTemp: " + r6 + ", defaultTemp: " + r7);     // Catch: Throwable -> L14
        if (r7 < r5) goto L12;
        if (r7 > r6) goto L12;
        int r0 = this.mColorDisplayManager.getNightDisplayColorTemperature();     // Catch: Throwable -> L14
        if (r0 < r7) goto L10;
        int r1 = (int) (((r6 - r0) / (r6 - r7)) * 50.0f);     // Catch: Throwable -> L14
    L11:
        int r4 = r1;
        OLog.d(this.TAG, "process: " + r4);     // Catch: Throwable -> L14
        return r4;
    L10:
        r1 = (int) (100.0f - (((r0 - r5) / (r7 - r5)) * 50.0f));     // Catch: Throwable -> L14
    L12:
        OLog.d(this.TAG, "defaultTemp is invalid, defaultTemp: " + r7 + ", minTemp: " + r5 + ", maxTemp: " + r6);     // Catch: Throwable -> L14
        return 50;
    L14:
        e = move-exception;
        e.printStackTrace();
        return 50;
    }

    private void setColorTemperature(int r10) {
        OLog.d(this.TAG, "setColorTemperature: " + r10);     // Catch: Throwable -> L14
        int r4 = this.mColorDisplayManager.getMinimumColorTemperature();     // Catch: Throwable -> L14
        int r5 = this.mColorDisplayManager.getMaximumColorTemperature();     // Catch: Throwable -> L14
        int r6 = this.mColorDisplayManager.getDefaultColorTemperature();     // Catch: Throwable -> L14
        OLog.d(this.TAG, "minTemp: " + r4 + ", maxTemp: " + r5 + ", defaultTemp: " + r6);     // Catch: Throwable -> L14
        if (r6 < r4) goto L12;
        if (r6 > r5) goto L12;
        if (r10 > 50) goto L10;
        int r11 = (int) (r5 - (((r5 - r6) * r10) / 50.0f));     // Catch: Throwable -> L14
    L11:
        OLog.d(this.TAG, "setColorTemperature: " + r11);     // Catch: Throwable -> L14
        this.mColorDisplayManager.setNightDisplayColorTemperature(r11);     // Catch: Throwable -> L14
        return;
    L10:
        r11 = (int) (r6 - (((r6 - r4) * (r10 - 50)) / 50.0f));     // Catch: Throwable -> L14
    L12:
        OLog.d(this.TAG, "defaultTemp is invalid, defaultTemp: " + r6 + ", minTemp: " + r4 + ", maxTemp: " + r5);     // Catch: Throwable -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_eyesprotection_EyesProtectionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(EyesProtectionFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_eyesprotection_EyesProtectionFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_eyesprotection_EyesProtectionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(EyesProtectionFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_eyesprotection_EyesProtectionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_eyesprotection_EyesProtectionFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(EyesProtectionFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_eyesprotection_EyesProtectionFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
