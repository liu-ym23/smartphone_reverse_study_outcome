package com.android.settings.revone;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.SettingsTracker;
import com.android.settings.TrackerConstants;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.TickMarkView;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;
import obric.widget.ShadowDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class MouseSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int DEFAULT_POINTER_SPEED = 0;
    private static final int DEFAULT_POINTER_WHEEL_SPEED = 0;
    private static final int MARKER_SIZE = 15;
    private static final int MAX_POINTER_SPEED = 7;
    private static final int MAX_POINTER_WHEEL_SPEED = 0;
    private static final int MIN_POINTER_SPEED = -7;
    private static final int MIN_POINTER_WHEEL_SPEED = 0;
    private static final int[] PROGRESS_VALUE_ARRAY = null;
    private static final int STANDARD_INDEX = 7;
    private SettingItemCheck mMouseMainButtonLeft;
    private SettingItemCheck mMouseMainButtonRight;
    private TickMarkView mMousePointerSpeed;
    private SettingItemSwitch mMouseScrollFling;
    private SettingItemCheck mMouseScrollOrientationNatural;
    private SettingItemCheck mMouseScrollOrientationStandard;
    private TickMarkView mMouseScrollSpeed;
    private SettingItemCheck mMouseStyleCircle;
    private SettingItemCheck mMouseStylePointer;

    public void com_android_settings_revone_MouseSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_MouseSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_MouseSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_MouseSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static {
        PROGRESS_VALUE_ARRAY = new int[]{-7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7};
    }

    public MouseSettingsFragment() {
        super(R.layout.revone_fragment_mouse_settings);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mMouseMainButtonLeft = (SettingItemCheck) findViewByIdNullable(R.id.mouse_main_button_left);
        this.mMouseMainButtonRight = (SettingItemCheck) findViewByIdNullable(R.id.mouse_main_button_right);
        this.mMouseStyleCircle = (SettingItemCheck) findViewByIdNullable(R.id.mouse_style_circle);
        this.mMouseStylePointer = (SettingItemCheck) findViewByIdNullable(R.id.mouse_style_pointer);
        this.mMousePointerSpeed = (TickMarkView) findViewByIdNullable(R.id.mouse_pointer_speed);
        this.mMouseScrollSpeed = (TickMarkView) findViewByIdNullable(R.id.mouse_scroll_speed);
        this.mMouseScrollOrientationStandard = (SettingItemCheck) findViewByIdNullable(R.id.mouse_scroll_orientation_standard);
        this.mMouseScrollOrientationNatural = (SettingItemCheck) findViewByIdNullable(R.id.mouse_scroll_orientation_natural);
        this.mMouseScrollFling = (SettingItemSwitch) findViewByIdNullable(R.id.mouse_scroll_fling);
        initSeekBar();
        this.mMouseMainButtonLeft.setOnClickListener(this);
        this.mMouseMainButtonRight.setOnClickListener(this);
        this.mMouseScrollOrientationStandard.setOnClickListener(this);
        this.mMouseScrollOrientationNatural.setOnClickListener(this);
        this.mMouseStyleCircle.setOnClickListener(this);
        this.mMouseStylePointer.setOnClickListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mMouseScrollFling.setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateViews() {
        this.mMousePointerSpeed.setMarker(getMousePointerSpeedIndex());
        this.mMouseScrollSpeed.setMarker(getMouseScrollSpeedIndex());
        updateMouseMainButtonView(isMouseLeftMainButton());
        updateMouseScrollOrientation(isMouseScrollStandard());
        updateMouseStyle(isCircleMouse());
        SettingItemSwitch r0 = this.mMouseScrollFling;
        boolean r2 = true;
        if (Settings.System.getInt(this.mContext.getContentResolver(), "mouse_scroll_fling_enabled", 1) == 1) goto L6;
        r2 = false;
    L6:
        r0.setChecked(r2);
    }

    private void updateMouseMainButtonView(boolean r2) {
        this.mMouseMainButtonLeft.setChecked(r2);
        this.mMouseMainButtonRight.setChecked(!r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View r8) {
        SettingItemCheck r0 = this.mMouseMainButtonLeft;
        boolean r2 = false;
        boolean r3 = 0;
        boolean r4 = false;
        if (r8 != r0) goto L5;
    L25:
        if (r8 != r0) goto L28;
        r2 = true;
    L28:
        if (r2 == isMouseLeftMainButton()) goto L31;
        saveMouseLeftMainButton(r2);
        updateMouseMainButtonView(r2);
    L31:
        if (r8 != this.mMouseMainButtonLeft) goto L33;
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.MOUSE_PRIMARY_BUTTON, 0);
        return;
    L33:
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.MOUSE_PRIMARY_BUTTON, 1);
        return;
    L5:
        if (r8 == this.mMouseMainButtonRight) goto L25;
        SettingItemCheck r1 = this.mMouseScrollOrientationStandard;
        if (r8 != r1) goto L10;
    L19:
        if (r8 != r1) goto L21;
        r4 = true;
    L21:
        saveMouseScrollOrientation(r4);
        updateMouseScrollOrientation(r4);
        if (r8 != this.mMouseScrollOrientationStandard) goto L24;
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.SCROLL_DIRECTION, 0);
        return;
    L24:
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.SCROLL_DIRECTION, 1);
        return;
    L10:
        if (r8 == this.mMouseScrollOrientationNatural) goto L19;
        SettingItemCheck r5 = this.mMouseStyleCircle;
        if (r8 != r5) goto L15;
    L16:
        if (r8 != r5) goto L18;
        r3 = 1;
    L18:
        Settings.Global.putInt(getContentResolver(), "cursor_shape", !r3);
        updateMouseStyle(r3);
        return;
    L15:
        if (r8 == this.mMouseStylePointer) goto L16;
    }

    private void saveMouseScrollOrientation(boolean r2) {
        Settings.Global.putInt(getContentResolver(), "mouse_scroll_orientation", !r2 ? 1 : 0);
    }

    private void updateMouseScrollOrientation(boolean r2) {
        this.mMouseScrollOrientationStandard.setChecked(r2);
        this.mMouseScrollOrientationNatural.setChecked(!r2);
    }

    private void updateMouseStyle(boolean r2) {
        this.mMouseStyleCircle.setChecked(r2);
        this.mMouseStylePointer.setChecked(!r2);
    }

    private void initSeekBar() {
        this.mMousePointerSpeed.setOnMarkerChangeListener(new MouseSettingsFragment$$ExternalSyntheticLambda0(this));
        this.mMousePointerSpeed.setMarkerSize(15);
        this.mMousePointerSpeed.setMarkerLabels(getResources().getString(R.string.tts_speech_rate_slower), getResources().getString(R.string.tts_speech_rate_faster), getResources().getString(R.string.force_touch_pressure_standard), 7, 15);
        ShadowDrawable.setViewBackground(this.mMousePointerSpeed, R.drawable.group_list_item_unpressed_bg_single, R.drawable.list_item_single_shadow);
        this.mMouseScrollSpeed.setOnMarkerChangeListener(new MouseSettingsFragment$$ExternalSyntheticLambda1(this));
        this.mMouseScrollSpeed.setMarkerSize(15);
        this.mMouseScrollSpeed.setMarkerLabels(getResources().getString(R.string.tts_speech_rate_slower), getResources().getString(R.string.tts_speech_rate_faster), getResources().getString(R.string.force_touch_pressure_standard), 7, 15);
        ShadowDrawable.setViewBackground(this.mMouseScrollSpeed, R.drawable.group_list_item_unpressed_bg_single, R.drawable.list_item_single_shadow);
    }

    /* JADX INFO: renamed from: lambda$initSeekBar$0$com-android-settings-revone-MouseSettingsFragment, reason: not valid java name */
    /* synthetic */ void m556xe99bcce4(int r2) {
        setMousePointerSpeed(PROGRESS_VALUE_ARRAY[r2]);
    }

    /* JADX INFO: renamed from: lambda$initSeekBar$1$com-android-settings-revone-MouseSettingsFragment, reason: not valid java name */
    /* synthetic */ void m557x2d26eaa5(int r2) {
        setMouseScrollSpeed(PROGRESS_VALUE_ARRAY[r2]);
    }

    private boolean isMouseLeftMainButton() {
        if (Settings.Global.getInt(getContentResolver(), "mouse_left_main_button_enable", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isMouseScrollStandard() {
        if (Settings.Global.getInt(getContentResolver(), "mouse_scroll_orientation", 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isCircleMouse() {
        if (Settings.Global.getInt(getContentResolver(), "cursor_shape", 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void saveMouseLeftMainButton(boolean r2) {
        Settings.Global.putInt(getContentResolver(), "mouse_left_main_button_enable", r2 ? 1 : 0);
    }

    private int getMouseScrollSpeedIndex() {
        int r0 = Settings.Global.getInt(getContentResolver(), "mouse_scroll_speed", 0);
        OLog.d(this.TAG, "getMouseScrollSpeedProgress: scrollSpeed=" + r0);
        int r5 = getInRangeValue(r0, 0, 0);
        int r1 = 0;
    L3:
        int[] r2 = PROGRESS_VALUE_ARRAY;
        if (r1 >= r2.length) goto L9;
        if (r2[r1] == r5) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r1;
    L9:
        return 0;
    }

    private void setMouseScrollSpeed(int r3) {
        int r4 = getInRangeValue(r3, 0, 0);
        Settings.Global.putInt(getContentResolver(), "mouse_scroll_speed", r4);
        OLog.d(this.TAG, "setMouseScrollSpeed : " + r4);
    }

    private int getMousePointerSpeedIndex() {
        int r0 = Settings.System.getInt(getContentResolver(), "pointer_speed", 0);
        OLog.d(this.TAG, "getMousePointerSpeedProgress: pointerSpeed=" + r0);
        int r5 = getInRangeValue(r0, 7, -7);
        int r1 = 0;
    L3:
        int[] r2 = PROGRESS_VALUE_ARRAY;
        if (r1 >= r2.length) goto L9;
        if (r2[r1] == r5) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r1;
    L9:
        return 0;
    }

    private void setMousePointerSpeed(int r3) {
        int r4 = getInRangeValue(r3, 7, -7);
        Settings.System.putInt(getContentResolver(), "pointer_speed", r4);
        OLog.d(this.TAG, "setMousePointerSpeed : " + r4);
    }

    private int getInRangeValue(int r1, int r2, int r3) {
        return Math.max(Math.min(r2, r1), r3);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mMouseScrollFling.getSwitch()) goto L6;
        Settings.System.putInt(this.mContext.getContentResolver(), "mouse_scroll_fling_enabled", r3 ? 1 : 0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_MouseSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MouseSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_MouseSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_MouseSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MouseSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_MouseSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_MouseSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MouseSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_MouseSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
