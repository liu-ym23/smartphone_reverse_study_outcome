package com.android.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceModelSettings extends Fragment implements CompoundButton.OnCheckedChangeListener {
    public static final String EXTRA_DEVICE = "extra_device";
    private static final String KEY_BUTTON_LIGHTS_ON = "button_lights_on";
    private static final String KEY_LED_LIGHTS_ON = "led_lights_on";
    private static final String TAG = "DeviceModelSettings";
    private String device;
    private SettingItemSwitch mButtonLightsSwitch;
    private SupportedDeviceType mDeviceType;
    private SettingItemSwitch mLedLightsSwitch;

    public static final enum SupportedDeviceType extends Enum<SupportedDeviceType> {
        private static final /* synthetic */ SupportedDeviceType[] $VALUES = null;
        public static final SupportedDeviceType aries = null;
        public static final SupportedDeviceType find5 = null;
        public static final SupportedDeviceType i9300 = null;
        public static final SupportedDeviceType n7100 = null;

        private static /* synthetic */ SupportedDeviceType[] $values() {
            return new SupportedDeviceType[]{i9300, find5, aries, n7100};
        }

        private SupportedDeviceType(String r1, int r2) {
            super(r1, r2);
        }

        public static SupportedDeviceType valueOf(String r1) {
            return (SupportedDeviceType) Enum.valueOf(SupportedDeviceType.class, r1);
        }

        public static SupportedDeviceType[] values() {
            return (SupportedDeviceType[]) $VALUES.clone();
        }

        static {
            i9300 = new SupportedDeviceType("i9300", 0);
            find5 = new SupportedDeviceType("find5", 1);
            aries = new SupportedDeviceType("aries", 2);
            n7100 = new SupportedDeviceType("n7100", 3);
            $VALUES = $values();
        }
    }

    static {
    }

    public void com_android_settings_DeviceModelSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DeviceModelSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_DeviceModelSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DeviceModelSettings() {
    }

    public void com_android_settings_DeviceModelSettings__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        if (r4 != null) goto L7;
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L8;
        this.device = r5.getIntent().getStringExtra(EXTRA_DEVICE);
    L8:
        String r6 = this.device;
        if (r6 == null) goto L17;
        this.mDeviceType = SupportedDeviceType.valueOf(r6);     // Catch: IllegalArgumentException -> L12
        return;
    L12:
        e = move-exception;
        this.mDeviceType = null;
        OLog.w(TAG, "unknown device type :" + this.device, e.fillInStackTrace());
        return;
    L17:
        return;
    L7:
        this.device = r4.getString(EXTRA_DEVICE);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(R.layout.device_model_settings_fragment, r3, false);
        this.mLedLightsSwitch = (SettingItemSwitch) r5.findViewById(R.id.item_led_lights_switch);
        this.mButtonLightsSwitch = (SettingItemSwitch) r5.findViewById(R.id.item_button_lights_switch);
        if (this.mDeviceType != SupportedDeviceType.aries) goto L5;
        this.mButtonLightsSwitch.setVisibility(8);
        this.mLedLightsSwitch.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_single);
    L5:
        return r5;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        this.mLedLightsSwitch.setChecked(isLedLightsOn());
        this.mButtonLightsSwitch.setChecked(isButtonLightsOn());
        this.mLedLightsSwitch.setOnCheckedChangeListener(this);
        this.mButtonLightsSwitch.setOnCheckedChangeListener(this);
    }

    private boolean isLedLightsOn() {
        return isLightsOn(KEY_LED_LIGHTS_ON);
    }

    private boolean isButtonLightsOn() {
        return isLightsOn(KEY_BUTTON_LIGHTS_ON);
    }

    private boolean isLightsOn(String r2) {
        if (android.provider.Settings.Global.getInt(getActivity().getContentResolver(), r2, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void setLightState(String r1, boolean r2) {
        android.provider.Settings.Global.putInt(getActivity().getContentResolver(), r1, r2 ? 1 : 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        r2.putString(EXTRA_DEVICE, this.device);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mLedLightsSwitch.getSwitch()) goto L6;
        setLightState(KEY_LED_LIGHTS_ON, r3);
        return;
    L6:
        if (r2 != this.mButtonLightsSwitch.getSwitch()) goto L10;
        setLightState(KEY_BUTTON_LIGHTS_ON, r3);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DeviceModelSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DeviceModelSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DeviceModelSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DeviceModelSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DeviceModelSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_DeviceModelSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DeviceModelSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DeviceModelSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DeviceModelSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
