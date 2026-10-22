package com.android.settings.revone.boston;

import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.ExecutorManager;
import com.android.settings.R;
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
public class TouchpadSettingsFragment extends GestureFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private static final int MARKER_SIZE = 15;
    private static final int REFRESH_DELAY_TIME = 200;
    private static final int STANDARD_INDEX = 7;
    private static final int[] mProgressValueArray = null;
    private SettingItemCheck mScrollDirectionForward;
    private SettingItemCheck mScrollDirectionReverse;
    private TickMarkView mSeekbar;
    private SettingItemSwitch mTouchToClick;
    private ContentObserver mTouchToClickObserver;
    private SettingItemCheck mTouchpadAlwaysOn;
    private SettingItemCheck mTouchpadDisableWhenMouseConnected;
    private Handler mUiHandler;

    public void com_android_settings_revone_boston_TouchpadSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.revone.boston.GestureFragment, com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_boston_TouchpadSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_boston_TouchpadSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TouchpadSettingsFragment() {
        final Handler r1 = null;
        this.mTouchToClickObserver = new AnonymousClass1(this, r1);
    }

    static /* synthetic */ void access$000(TouchpadSettingsFragment r0) {
        r0.updateViews();
    }

    static /* synthetic */ Handler access$100(TouchpadSettingsFragment r0) {
        return r0.mUiHandler;
    }

    static {
        mProgressValueArray = new int[]{-7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7};
    }

    public void com_android_settings_revone_boston_TouchpadSettingsFragment__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        this.mType = 2;
        if (getActivity() == null) goto L5;
        getActivity().getContentResolver().registerContentObserver(Settings.Global.getUriFor("touch_to_click"), false, this.mTouchToClickObserver);
    L5:
        this.mUiHandler = new Handler();
    }

    @Override // com.android.settings.revone.boston.GestureFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        View r11 = super.onCreateView(r8, r9, r10);
        View r12 = requireActivity().getLayoutInflater().inflate(R.layout.revone_touchpad_header, null, false);
        this.mTouchToClick = (SettingItemSwitch) r12.findViewById(R.id.touch_to_click);
        this.mScrollDirectionForward = (SettingItemCheck) r12.findViewById(R.id.scroll_direction_forward);
        this.mScrollDirectionReverse = (SettingItemCheck) r12.findViewById(R.id.scroll_direction_reverse);
        this.mTouchpadAlwaysOn = (SettingItemCheck) r12.findViewById(R.id.touchpad_always_on);
        this.mTouchpadDisableWhenMouseConnected = (SettingItemCheck) r12.findViewById(R.id.touchpad_disable_when_mouse_connected);
        TickMarkView r13 = (TickMarkView) r12.findViewById(R.id.pointer_speed);
        this.mSeekbar = r13;
        r13.setOnMarkerChangeListener(new TouchpadSettingsFragment$$ExternalSyntheticLambda0(this));
        this.mSeekbar.setMarkerSize(15);
        this.mSeekbar.setMarkerLabels(getResources().getString(R.string.tts_speech_rate_slower), getResources().getString(R.string.tts_speech_rate_faster), getResources().getString(R.string.force_touch_pressure_standard), 7, 15);
        ShadowDrawable.setViewBackground(this.mSeekbar, R.drawable.group_list_item_unpressed_bg_single, R.drawable.list_item_single_shadow);
        this.mScrollDirectionForward.setOnClickListener(this);
        this.mScrollDirectionReverse.setOnClickListener(this);
        this.mTouchpadAlwaysOn.setOnClickListener(this);
        this.mTouchpadDisableWhenMouseConnected.setOnClickListener(this);
        this.mListview.addHeaderView(r12);
        return r11;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-revone-boston-TouchpadSettingsFragment, reason: not valid java name */
    /* synthetic */ void m579x31279502(int r2) {
        setTouchpadProgress(mProgressValueArray[r2]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mTouchToClick.setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateViews() {
        boolean r2 = false;
        int r0 = Settings.System.getInt(this.mContext.getContentResolver(), "touch_pointer_speed", 0);
        OLog.d("TouchpadSettingsFragment", "updateView:  pointerSpeed=" + r0);
        int r3 = 7;
        int r1 = getInRangeValue(r0, 7, -7);
        int r4 = 0;
    L3:
        int[] r5 = mProgressValueArray;
        if (r4 >= r5.length) goto L9;
        if (r1 != r5[r4]) goto L8;
        r3 = r4;
    L8:
        r4 = r4 + 1;
        goto L3
    L9:
        this.mSeekbar.setMarker(r3);
        SettingItemSwitch r6 = this.mTouchToClick;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "touch_to_click", 1) != 1) goto L12;
        r2 = true;
    L12:
        r6.setChecked(r2);
        updateScrollDirection(isScrollDirection());
        updateTouchpadAlwaysOn(isTouchpadAlwaysOn());
    }

    private void setTouchpadProgress(int r3) {
        int r4 = getInRangeValue(r3, 7, -7);
        OLog.d("TouchpadSettingsFragment", "setTouchpadProgress:  pointerSpeed=" + r4);
        Settings.System.putInt(getContentResolver(), "touch_pointer_speed", r4);
    }

    private int getInRangeValue(int r1, int r2, int r3) {
        return Math.max(Math.min(r2, r1), r3);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, final boolean r3) {
        Settings.Global.putInt(this.mContext.getContentResolver(), "touch_to_click", r3 ? 1 : 0);
        ExecutorManager.execute(new AnonymousClass2(this, r3), true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (getActivity() == null) goto L6;
        getActivity().getContentResolver().unregisterContentObserver(this.mTouchToClickObserver);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        SettingItemCheck r0 = this.mScrollDirectionForward;
        boolean r1 = true;
        if (r5 != r0) goto L5;
    L15:
        if (r5 == r0) goto L18;
        r1 = false;
    L18:
        saveScrollDirection(r1);
        updateScrollDirection(r1);
        return;
    L5:
        if (r5 == this.mScrollDirectionReverse) goto L15;
        SettingItemCheck r2 = this.mTouchpadAlwaysOn;
        if (r5 != r2) goto L10;
    L11:
        if (r5 == r2) goto L14;
        r1 = false;
    L14:
        saveTouchpadAlwaysOn(r1);
        updateTouchpadAlwaysOn(r1);
        return;
    L10:
        if (r5 == this.mTouchpadDisableWhenMouseConnected) goto L11;
    }

    private void saveScrollDirection(boolean r2) {
        Settings.Global.putInt(getContentResolver(), "touchpad_gesture_swipe_reverse", !r2 ? 1 : 0);
    }

    private void updateScrollDirection(boolean r2) {
        this.mScrollDirectionForward.setChecked(r2);
        this.mScrollDirectionReverse.setChecked(!r2);
    }

    private boolean isScrollDirection() {
        if (Settings.Global.getInt(getContentResolver(), "touchpad_gesture_swipe_reverse", 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void saveTouchpadAlwaysOn(boolean r2) {
        Settings.Global.putInt(getContentResolver(), "touchpad_gesture_disable_when_mouse_connected", !r2 ? 1 : 0);
    }

    private void updateTouchpadAlwaysOn(boolean r2) {
        this.mTouchpadAlwaysOn.setChecked(r2);
        this.mTouchpadDisableWhenMouseConnected.setChecked(!r2);
    }

    private boolean isTouchpadAlwaysOn() {
        if (Settings.Global.getInt(getContentResolver(), "touchpad_gesture_disable_when_mouse_connected", 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_boston_TouchpadSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TouchpadSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_boston_TouchpadSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_boston_TouchpadSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TouchpadSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_boston_TouchpadSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_boston_TouchpadSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TouchpadSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_boston_TouchpadSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
