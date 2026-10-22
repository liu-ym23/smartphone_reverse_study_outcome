package com.android.settings.eyesprotection;

import android.content.SharedPreferences;
import android.hardware.display.ColorDisplayManager;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.R;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.TimePickerDialog;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class EyesProtectionTimer extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private static final String KEY_LAST_TIMER_MODE = "key_eyes_protection_last_timer_mode";
    private static final String SHARED_PREFERENCES_NAME = "EyesProtectionTimer";
    private OCardListItem mAutoTimer;
    private OCardListItem mAutoTurnOnOff;
    private ColorDisplayManager mColorDisplayManager;
    private LocalTime mCustomEndTime;
    private LocalTime mCustomStartTime;
    private OCardListItem mCustomTimer;
    private LinearLayout mCustomTimerContainer;
    private OCardListItem mCustomTimerEnd;
    private OCardListItem mCustomTimerStart;
    private int mLastTimerMode;
    private SharedPreferences mLastTimerModePrefs;
    private LinearLayout mTimerContainer;

    public void com_android_settings_eyesprotection_EyesProtectionTimer__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_eyesprotection_EyesProtectionTimer__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_eyesprotection_EyesProtectionTimer_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_eyesprotection_EyesProtectionTimer_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ ColorDisplayManager access$000(EyesProtectionTimer r0) {
        return r0.mColorDisplayManager;
    }

    static /* synthetic */ String access$100(EyesProtectionTimer r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$200(EyesProtectionTimer r0) {
        r0.updateCustomTimer();
    }

    static /* synthetic */ String access$300(EyesProtectionTimer r0) {
        return r0.TAG;
    }

    public EyesProtectionTimer() {
        super(R.layout.protect_eyes_timer_layout);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        this.mColorDisplayManager = (ColorDisplayManager) this.mContext.getSystemService(ColorDisplayManager.class);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.auto_turn_on_off);
        this.mAutoTurnOnOff = r7;
        r7.getContentContainer().setClickable(false);
        if (getProtectEyesMode() == 0) goto L5;
        boolean r8 = true;
    L6:
        LinearLayout r1 = (LinearLayout) findViewByIdNullable(R.id.protect_eyes_timer_container);
        this.mTimerContainer = r1;
        int r2 = 8;
        if (r8 == false) goto L9;
        int r9 = 0;
    L10:
        r1.setVisibility(r9);
        OCardListItem r10 = (OCardListItem) findViewByIdNullable(R.id.auto_timer);
        this.mAutoTimer = r10;
        OCardListItemUtils.setCustomEndImageView(r10);
        OCardListItem r11 = this.mAutoTimer;
        if (getProtectEyesMode() != 2) goto L13;
        boolean r3 = true;
    L14:
        r11.showCustomEnd(r3);
        this.mAutoTimer.setOnContentClickListener(this);
        OCardListItem r12 = (OCardListItem) findViewByIdNullable(R.id.custom_timer);
        this.mCustomTimer = r12;
        OCardListItemUtils.setCustomEndImageView(r12);
        OCardListItem r13 = this.mCustomTimer;
        if (getProtectEyesMode() != 1) goto L17;
        boolean r4 = true;
    L18:
        r13.showCustomEnd(r4);
        this.mCustomTimer.setOnContentClickListener(this);
        LinearLayout r14 = (LinearLayout) findViewByIdNullable(R.id.protect_eyes_custom_timer_container);
        this.mCustomTimerContainer = r14;
        if (getProtectEyesMode() != 1) goto L21;
        r2 = 0;
    L21:
        r14.setVisibility(r2);
        OCardListItem r15 = (OCardListItem) findViewByIdNullable(R.id.custom_timer_start);
        this.mCustomTimerStart = r15;
        r15.setOnContentClickListener(this);
        OCardListItem r16 = (OCardListItem) findViewByIdNullable(R.id.custom_timer_end);
        this.mCustomTimerEnd = r16;
        r16.setOnContentClickListener(this);
        updateCustomTimer();
        SharedPreferences r17 = this.mContext.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        this.mLastTimerModePrefs = r17;
        this.mLastTimerMode = r17.getInt(KEY_LAST_TIMER_MODE, 0);
        return;
    L17:
        r4 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r9 = 8;
        goto L10
    L5:
        r8 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        if (getProtectEyesMode() == 0) goto L5;
        boolean r3 = true;
    L6:
        ((OSwitch) this.mAutoTurnOnOff.getCustomEndView()).setChecked(r3);
        ((OSwitch) this.mAutoTurnOnOff.getCustomEndView()).setOnCheckedChangeListener(this);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r7) {
        boolean r0 = this.mColorDisplayManager.isNightDisplayActivated();
        if (r7 != this.mAutoTimer.getContentContainer()) goto L6;
        this.mColorDisplayManager.setNightDisplayAutoMode(2);
        this.mCustomTimerContainer.setVisibility(8);
        this.mCustomTimer.showCustomEnd(false);
        this.mAutoTimer.showCustomEnd(true);
        this.mLastTimerModePrefs.edit().putInt(KEY_LAST_TIMER_MODE, 2).apply();
    L14:
        this.mColorDisplayManager.setNightDisplayActivated(r0);
        return;
    L6:
        if (r7 != this.mCustomTimer.getContentContainer()) goto L9;
        this.mColorDisplayManager.setNightDisplayAutoMode(1);
        this.mCustomTimerContainer.setVisibility(0);
        this.mCustomTimer.showCustomEnd(true);
        this.mAutoTimer.showCustomEnd(false);
        updateCustomTimer();
        this.mLastTimerModePrefs.edit().putInt(KEY_LAST_TIMER_MODE, 1).apply();
        goto L14
    L9:
        if (r7 != this.mCustomTimerStart.getContentContainer()) goto L12;
        showTimePicker(new AnonymousClass1(this), true);
        goto L14
    L12:
        if (r7 != this.mCustomTimerEnd.getContentContainer()) goto L14;
        showTimePicker(new AnonymousClass2(this), false);
        goto L14
    }

    private void updateCustomTimer() {
        this.mCustomStartTime = this.mColorDisplayManager.getNightDisplayCustomStartTime();
        this.mCustomEndTime = this.mColorDisplayManager.getNightDisplayCustomEndTime();
        if (DateFormat.is24HourFormat(this.mContext) == false) goto L5;
        String r0 = "HH:mm";
    L6:
        DateTimeFormatter r1 = DateTimeFormatter.ofPattern(r0);
        OCardListItemUtils.setCustomEndTipTextView(this.mCustomTimerStart, this.mCustomStartTime.format(r1));
        OCardListItemUtils.setCustomEndTipTextView(this.mCustomTimerEnd, this.mCustomEndTime.format(r1));
        OLog.d(this.TAG, "CustomStartTime:" + this.mCustomStartTime.getHour() + ":" + this.mCustomStartTime.getMinute() + ", CustomEndTime:" + this.mCustomEndTime.getHour() + ":" + this.mCustomEndTime.getMinute());
        return;
    L5:
        r0 = "a h:mm";
        goto L6
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        boolean r0 = this.mColorDisplayManager.isNightDisplayActivated();
        if (r3 != ((OSwitch) this.mAutoTurnOnOff.getCustomEndView())) goto L9;
        setProtectEyesMode(r4);
        LinearLayout r5 = this.mTimerContainer;
        if (r4 == false) goto L7;
        int r6 = 0;
    L8:
        r5.setVisibility(r6);
        goto L9
    L7:
        r6 = 8;
    L9:
        this.mColorDisplayManager.setNightDisplayActivated(r0);
    }

    private void setProtectEyesMode(boolean r4) {
        if (r4 == false) goto L10;
        int r5 = this.mLastTimerModePrefs.getInt(KEY_LAST_TIMER_MODE, 0);
        this.mLastTimerMode = r5;
        if (r5 == 0) goto L9;
        if (r5 == 2) goto L9;
        this.mColorDisplayManager.setNightDisplayAutoMode(1);
        this.mAutoTimer.showCustomEnd(false);
        this.mCustomTimer.showCustomEnd(true);
        this.mCustomTimerContainer.setVisibility(0);
        return;
    L9:
        this.mColorDisplayManager.setNightDisplayAutoMode(2);
        this.mAutoTimer.showCustomEnd(true);
        this.mCustomTimer.showCustomEnd(false);
        return;
    L10:
        this.mColorDisplayManager.setNightDisplayAutoMode(0);
    }

    private int getProtectEyesMode() {
        return this.mColorDisplayManager.getNightDisplayAutoMode();
    }

    private void showTimePicker(TimePickerDialog.OnTimeSetListener r9, boolean r10) {
        if (r10 == false) goto L4;
        LocalTime r11 = this.mCustomStartTime;
        String r0 = getString(R.string.eye_protection_cycle_enable_title);
    L5:
        FragmentActivity r1 = getActivity();
        new TimePickerDialog(r1, r0, r9, r11.getHour(), r11.getMinute(), DateFormat.is24HourFormat(this.mContext)).show();
        return;
    L4:
        r11 = this.mCustomEndTime;
        r0 = getString(R.string.eye_protection_cycle_disable_title);
        goto L5
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_eyesprotection_EyesProtectionTimer_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(EyesProtectionTimer r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_eyesprotection_EyesProtectionTimer__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_eyesprotection_EyesProtectionTimer_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(EyesProtectionTimer r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_eyesprotection_EyesProtectionTimer_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_eyesprotection_EyesProtectionTimer_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(EyesProtectionTimer r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_eyesprotection_EyesProtectionTimer__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
