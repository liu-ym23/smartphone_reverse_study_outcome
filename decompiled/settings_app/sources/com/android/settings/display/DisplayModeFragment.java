package com.android.settings.display;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.databinding.DisplayModeLayoutBinding;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.TimePickerDialog;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayModeFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "DisplayModeFragmentTAG";
    private DisplayModeLayoutBinding binding;
    private LocalTime endTime;
    private boolean mCurrentDisplayModeIsDark;
    private int mDisplayAutoMode;
    private DarkModeTimeFormatter mFormat;
    private PowerManager mPowerManager;
    private UiModeManager mUiModeManager;
    private LocalTime startTime;

    public void com_android_settings_display_DisplayModeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_display_DisplayModeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_display_DisplayModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_display_DisplayModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DisplayModeFragment() {
        this.mCurrentDisplayModeIsDark = false;
        this.mDisplayAutoMode = 0;
    }

    static /* synthetic */ DisplayModeLayoutBinding access$000(DisplayModeFragment r0) {
        return r0.binding;
    }

    static /* synthetic */ int access$100(DisplayModeFragment r0) {
        return r0.mDisplayAutoMode;
    }

    static /* synthetic */ void access$200(DisplayModeFragment r0, int r1) {
        r0.updateDisplayAutoMode(r1);
    }

    static /* synthetic */ boolean access$300(DisplayModeFragment r0) {
        return r0.mCurrentDisplayModeIsDark;
    }

    static /* synthetic */ UiModeManager access$400(DisplayModeFragment r0) {
        return r0.mUiModeManager;
    }

    static /* synthetic */ LocalTime access$502(DisplayModeFragment r0, LocalTime r1) {
        r0.startTime = r1;
        return r1;
    }

    static /* synthetic */ DarkModeTimeFormatter access$600(DisplayModeFragment r0) {
        return r0.mFormat;
    }

    static /* synthetic */ LocalTime access$702(DisplayModeFragment r0, LocalTime r1) {
        r0.endTime = r1;
        return r1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        this.binding = DisplayModeLayoutBinding.inflate(r1, r2, false);
        this.mUiModeManager = (UiModeManager) this.mContext.getSystemService(UiModeManager.class);
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        this.mFormat = new DarkModeTimeFormatter(this.mContext);
        return this.binding.getRoot();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.mCurrentDisplayModeIsDark = isDarkMode();
        this.mDisplayAutoMode = this.mUiModeManager.getNightMode();
        OLog.d(TAG, "mCurrentDisplayModeisDark is " + this.mCurrentDisplayModeIsDark + " mDisplayAutotMode is " + this.mDisplayAutoMode);
        if (this.mCurrentDisplayModeIsDark == false) goto L5;
        this.binding.displayLightMode.showCustomEnd(false);
        this.binding.displayDarkMode.showCustomEnd(true);
    L6:
        initCustomTime();
        this.binding.autoCloseCustom.setOnContentClickListener(new DisplayModeFragment$$ExternalSyntheticLambda0(this));
        this.binding.autoCloseSunTime.setOnContentClickListener(new DisplayModeFragment$$ExternalSyntheticLambda1(this));
        this.binding.displayDarkMode.setOnContentClickListener(new DisplayModeFragment$$ExternalSyntheticLambda2(this));
        this.binding.displayLightMode.setOnContentClickListener(new DisplayModeFragment$$ExternalSyntheticLambda3(this));
        this.binding.displayModeStartTime.setOnContentClickListener(new DisplayModeFragment$$ExternalSyntheticLambda4(this));
        this.binding.displayModeEndTime.setOnContentClickListener(new DisplayModeFragment$$ExternalSyntheticLambda5(this));
        return;
    L5:
        this.binding.displayLightMode.showCustomEnd(true);
        this.binding.displayDarkMode.showCustomEnd(false);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$0$com-android-settings-display-DisplayModeFragment, reason: not valid java name */
    /* synthetic */ void m439xee4772bb(View r1) {
        onClick(this.binding.autoCloseCustom);
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$1$com-android-settings-display-DisplayModeFragment, reason: not valid java name */
    /* synthetic */ void m440xdff118da(View r1) {
        onClick(this.binding.autoCloseSunTime);
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$2$com-android-settings-display-DisplayModeFragment, reason: not valid java name */
    /* synthetic */ void m441xd19abef9(View r1) {
        onClick(this.binding.displayDarkMode);
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$3$com-android-settings-display-DisplayModeFragment, reason: not valid java name */
    /* synthetic */ void m442xc3446518(View r1) {
        onClick(this.binding.displayLightMode);
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$4$com-android-settings-display-DisplayModeFragment, reason: not valid java name */
    /* synthetic */ void m443xb4ee0b37(View r1) {
        onClick(this.binding.displayModeStartTime);
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$5$com-android-settings-display-DisplayModeFragment, reason: not valid java name */
    /* synthetic */ void m444xa697b156(View r1) {
        onClick(this.binding.displayModeEndTime);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        initAutoDarkDisplayView();
        this.binding.setTimeOpenDarkMode.getEndSwitch().setOnCheckedChangeListener(new AnonymousClass1(this));
    }

    private boolean isDarkMode() {
        if ((this.mContext.getResources().getConfiguration().uiMode & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void initCustomTime() {
        UiModeManager r0 = this.mUiModeManager;
        if (r0 != null) goto L5;
        return;
    L5:
        this.startTime = r0.getCustomNightModeStart();
        this.endTime = this.mUiModeManager.getCustomNightModeEnd();
        this.binding.displayModeStartTime.setEndDetailText(this.mFormat.of(this.startTime));
        this.binding.displayModeEndTime.setEndDetailText(this.mFormat.of(this.endTime));
    }

    private void updateDisplayMode(boolean r3) {
        if (r3 != this.mCurrentDisplayModeIsDark) goto L5;
        return;
    L5:
        this.mCurrentDisplayModeIsDark = r3;
        if (r3 == false) goto L8;
        this.binding.displayLightMode.showCustomEnd(false);
        this.binding.displayDarkMode.showCustomEnd(true);
        this.mUiModeManager.setNightModeActivated(true);
        return;
    L8:
        this.binding.displayLightMode.showCustomEnd(true);
        this.binding.displayDarkMode.showCustomEnd(false);
        this.mUiModeManager.setNightModeActivated(false);
    }

    private void updateDisplayAutoMode(int r2) {
        if (r2 != this.mDisplayAutoMode) goto L5;
        return;
    L5:
        this.mDisplayAutoMode = r2;
        this.mUiModeManager.setNightMode(r2);
        initAutoDarkDisplayView();
    }

    private void initAutoDarkDisplayView() {
        int r0 = this.mDisplayAutoMode;
        if (r0 != 0) goto L5;
        this.binding.setTimeOpenDarkMode.getEndSwitch().setChecked(true);
        this.binding.timeOpenDarkModeContainer.setVisibility(0);
        this.binding.autoCloseCustomContainer.setVisibility(8);
        this.binding.autoCloseSunTime.showCustomEnd(true);
        this.binding.autoCloseCustom.showCustomEnd(false);
        return;
    L5:
        if (r0 == 3) goto L7;
        this.binding.setTimeOpenDarkMode.getEndSwitch().setChecked(false);
        this.binding.timeOpenDarkModeContainer.setVisibility(8);
        return;
    L7:
        this.binding.setTimeOpenDarkMode.getEndSwitch().setChecked(true);
        this.binding.timeOpenDarkModeContainer.setVisibility(0);
        this.binding.autoCloseCustomContainer.setVisibility(0);
        this.binding.autoCloseSunTime.showCustomEnd(false);
        this.binding.autoCloseCustom.showCustomEnd(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (this.binding.autoCloseCustom != r4) goto L6;
        updateDisplayAutoMode(3);
        return;
    L6:
        if (r4 != this.binding.autoCloseSunTime) goto L9;
        updateDisplayAutoMode(0);
        return;
    L9:
        if (r4 != this.binding.displayDarkMode) goto L12;
        updateDisplayMode(true);
        return;
    L12:
        if (r4 != this.binding.displayLightMode) goto L15;
        updateDisplayMode(false);
        return;
    L15:
        if (r4 != this.binding.displayModeStartTime) goto L18;
        showTimePicker(new AnonymousClass2(this), true);
        return;
    L18:
        if (r4 != this.binding.displayModeEndTime) goto L26;
        showTimePicker(new AnonymousClass3(this), false);
        return;
    }

    private String getTimeString(long r2) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r2);
        return formatTime(this.mContext, r0);
    }

    private String formatTime(Context r2, Calendar r3) {
        if (DateFormat.is24HourFormat(r2) == false) goto L5;
        SimpleDateFormat r1 = new SimpleDateFormat("HH:mm ", Locale.getDefault());
    L7:
        return r1.format(r3.getTime());
    L5:
        r1 = new SimpleDateFormat("a h:mm ", Locale.getDefault());
        goto L7
    }

    private void showTimePicker(TimePickerDialog.OnTimeSetListener r12, boolean r13) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (r13 == false) goto L5;
        r0.set(11, this.startTime.getHour());
        r0.set(12, this.startTime.getMinute());
        String r14 = getString(R.string.material_timepicker_select_time);
    L6:
        FragmentActivity r5 = getActivity();
        new TimePickerDialog(r5, r14, r12, r0.get(11), r0.get(12), DateFormat.is24HourFormat(this.mContext)).show();
        return;
    L5:
        r0.set(11, this.endTime.getHour());
        r0.set(12, this.endTime.getMinute());
        r14 = getString(R.string.material_timepicker_select_time);
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_display_DisplayModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DisplayModeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_display_DisplayModeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_display_DisplayModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DisplayModeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_display_DisplayModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_display_DisplayModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DisplayModeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_display_DisplayModeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
