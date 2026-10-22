package com.android.settings.intent;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.net.wifi.SoftApConfiguration;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.nfc.NfcAdapter;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.provider.Settings;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.IWindowManager;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.MultiSimAdapter;
import com.android.settings.NotificationSettingsFragment;
import com.android.settings.R;
import com.android.settings.SoundSettingsFragment;
import com.android.settings.StatusBarSettingFragment;
import com.android.settings.bluetooth.LocalBluetoothAdapter;
import com.android.settings.eyesprotection.EyesProtectionAPI;
import com.android.settingslib.Utils;
import com.google.gson.Gson;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemSwitchModeIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemSwitchModeParams;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.Continuation;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SwitchModeIntent extends BaseSystemSwitchModeIntent {
    private final String AIRPLANE_MODE;
    private final String BATTERY_PERCENTAGE_MODE;
    private final String BLUETOOTH_MODE;
    private final String BRIGHTNESS_ADAPTIVE_MODE;
    private final String FLASHLIGHT_MODE;
    private final String HIGH_PRIORITY_NOTIFICATION;
    private final String HOTSPOT_MODE;
    private final String KEY;
    private final String LOCATION_MODE;
    private final String MOBILE_MODE;
    private final String NET_SPEED_MODE;
    private final String NFC_MODE;
    private final String NIGHT_DISPLAY_MODE;
    private final String NIGHT_MODE;
    private final String POWER_SAVE_MODE;
    private final String ROTATION_MODE;
    private final String SILENT_MODE;
    private final String TAG;
    private final String VIBRATION_MODE;
    private final String WIFI_MODE;
    private final String ZEN_MODE;
    private Gson gson;
    private IntentResult mResult;

    public SwitchModeIntent() {
        this.TAG = "SwitchModeIntent";
        this.WIFI_MODE = "wifi";
        this.MOBILE_MODE = "mobile";
        this.BLUETOOTH_MODE = "bluetooth";
        this.AIRPLANE_MODE = "airplane";
        this.FLASHLIGHT_MODE = "flashlight";
        this.ZEN_MODE = "zenmode";
        this.POWER_SAVE_MODE = "powersave";
        this.NIGHT_MODE = "nightmode";
        this.LOCATION_MODE = "location";
        this.NIGHT_DISPLAY_MODE = "nightdisplay";
        this.ROTATION_MODE = "rotation";
        this.VIBRATION_MODE = "vibration";
        this.HOTSPOT_MODE = "hotspot";
        this.BRIGHTNESS_ADAPTIVE_MODE = "brightnessadaptive";
        this.BATTERY_PERCENTAGE_MODE = "batterypercentage";
        this.SILENT_MODE = "silentmode";
        this.HIGH_PRIORITY_NOTIFICATION = "highprioritynotification";
        this.NFC_MODE = SettingsSwitchKeyUtil.NFC;
        this.NET_SPEED_MODE = "netspeed";
        this.KEY = "result_detail_extras";
        this.gson = new Gson();
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSwitchModeIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* bridge */ /* synthetic */ Object doAction(Parcelable r1, DispatchContext r2, Continuation<? super IntentResult<Empty>> r3) {
        return doAction((SystemSwitchModeParams) r1, r2, r3);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSwitchModeIntent
    public Object doAction(SystemSwitchModeParams r5, DispatchContext r6, Continuation<? super IntentResult<Empty>> r7) {
        OLog.d("SwitchModeIntent", "enter SwitchModeIntent doAction");
        Context r8 = r6.getContext();
        this.mResult = new IntentResult();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L7;
        OLog.d("SwitchModeIntent", "start privacy activity");
        PrivacyIntentHelper.getInstance().openPrivacyActivity(r6);
        this.mResult.setRet(201);
        return this.mResult;
    L7:
        if (r5.getMode() != null) goto L9;
    L113:
        this.mResult.setRet(103);
        OLog.e("SwitchModeIntent", "params is null");
        return this.mResult;
    L9:
        if (r5.getEnable() == null) goto L113;
        boolean r9 = r5.getEnable().booleanValue();
        String r1 = r5.getMode();
        r1.hashCode();
        byte r3 = -1;
        switch(r1.hashCode()) {
            case -1183073498: goto L87;
            case -1068855134: goto L83;
            case -1014685241: goto L79;
            case -677011630: goto L75;
            case -397211962: goto L71;
            case -81857902: goto L67;
            case -40300674: goto L63;
            case 108971: goto L59;
            case 3649301: goto L55;
            case 19831672: goto L51;
            case 418473265: goto L47;
            case 422261863: goto L43;
            case 846086146: goto L39;
            case 1099603663: goto L35;
            case 1309790410: goto L31;
            case 1366479291: goto L27;
            case 1529440682: goto L23;
            case 1901043637: goto L19;
            case 1968882350: goto L15;
            default: goto L90;
        };
    L90:
        switch(r3) {
            case 0: goto L110;
            case 1: goto L109;
            case 2: goto L108;
            case 3: goto L107;
            case 4: goto L106;
            case 5: goto L105;
            case 6: goto L104;
            case 7: goto L103;
            case 8: goto L102;
            case 9: goto L101;
            case 10: goto L100;
            case 11: goto L99;
            case 12: goto L98;
            case 13: goto L97;
            case 14: goto L96;
            case 15: goto L95;
            case 16: goto L94;
            case 17: goto L93;
            case 18: goto L92;
            default: goto L91;
        };
    L91:
        OLog.e("SwitchModeIntent", "SystemSwitchModeParams mode: " + r5.getMode() + " is error.");
    L112:
        return this.mResult;
    L92:
        setBluetoothEnabled(r8, r9);
        goto L112
    L93:
        setLocationEnabled(r8, r9);
        goto L112
    L94:
        setNightDisplayEnabled(r8, r9);
        goto L112
    L95:
        setNightModeEnabled(r8, r9);
        goto L112
    L96:
        setNetSpeedEnabled(r8, r9);
        goto L112
    L97:
        setHotspotEnabled(r8, r9);
        goto L112
    L98:
        setPowerSaveModeEnabled(r8, r9);
        goto L112
    L99:
        setBatteyPercentageEnabled(r8, r9);
        goto L112
    L100:
        setHighPriorityNotificationEnabled(r8, r9);
        goto L112
    L101:
        setSilentModeEnabled(r8, r9);
        goto L112
    L102:
        setWifiEnabled(r8, r9);
        goto L112
    L103:
        setNfcEnabled(r8, r9);
        goto L112
    L104:
        setRotationEnabled(r8, r9);
        goto L112
    L105:
        setVibrationEnabled(r8, r9);
        goto L112
    L106:
        setZenModeEnabled(r8, r9);
        goto L112
    L107:
        setAirplaneEnabled(r8, r9);
        goto L112
    L108:
        setBrightnessAdaptiveEnabled(r8, r9);
        goto L112
    L109:
        setMobileEnabled(r8, r9);
        goto L112
    L110:
        setFlashLightEnabled(r8, r9);
        goto L112
    L15:
        if (r1.equals("bluetooth") == false) goto L90;
        r3 = 18;
        goto L90
    L19:
        if (r1.equals("location") == false) goto L90;
        r3 = 17;
        goto L90
    L23:
        if (r1.equals("nightdisplay") == false) goto L90;
        r3 = 16;
        goto L90
    L27:
        if (r1.equals("nightmode") == false) goto L90;
        r3 = 15;
        goto L90
    L31:
        if (r1.equals("netspeed") == false) goto L90;
        r3 = 14;
        goto L90
    L35:
        if (r1.equals("hotspot") == false) goto L90;
        r3 = 13;
        goto L90
    L39:
        if (r1.equals("powersave") == false) goto L90;
        r3 = 12;
        goto L90
    L43:
        if (r1.equals("batterypercentage") == false) goto L90;
        r3 = 11;
        goto L90
    L47:
        if (r1.equals("highprioritynotification") == false) goto L90;
        r3 = 10;
        goto L90
    L51:
        if (r1.equals("silentmode") == false) goto L90;
        r3 = 9;
        goto L90
    L55:
        if (r1.equals("wifi") == false) goto L90;
        r3 = 8;
        goto L90
    L59:
        if (r1.equals(SettingsSwitchKeyUtil.NFC) == false) goto L90;
        r3 = 7;
        goto L90
    L63:
        if (r1.equals("rotation") == false) goto L90;
        r3 = 6;
        goto L90
    L67:
        if (r1.equals("vibration") == false) goto L90;
        r3 = 5;
        goto L90
    L71:
        if (r1.equals("zenmode") == false) goto L90;
        r3 = 4;
        goto L90
    L75:
        if (r1.equals("airplane") == false) goto L90;
        r3 = 3;
        goto L90
    L79:
        if (r1.equals("brightnessadaptive") == false) goto L90;
        r3 = 2;
        goto L90
    L83:
        if (r1.equals("mobile") == false) goto L90;
        r3 = 1;
        goto L90
    L87:
        if (r1.equals("flashlight") == false) goto L90;
        r3 = 0;
        goto L90
    }

    private void setWifiEnabled(Context r4, boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setWifiEnabled, enabled is ".concat(r0));
        if (((WifiManager) r4.getSystemService("wifi")).setWifiEnabled(r5) == false) goto L8;
        setCardPara(1, r4.getString(R.string.switch_mode_wifi), r5);
        this.mResult.setDetails(getDetailsString(r4, R.string.switch_mode_wifi, r5));
        this.mResult.setRet(0);
        return;
    L8:
        this.mResult.setRet(102);
        if (r5 == false) goto L11;
        String r3 = "open";
    L12:
        OLog.e("SwitchModeIntent", r3.concat(" wifi failed."));
        return;
    L11:
        r3 = "close";
        goto L12
    L4:
        r0 = "false";
        goto L5
    }

    private void setMobileEnabled(Context r5, boolean r6) {
        if (r6 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setMobileEnabled, enabled is ".concat(r0));
        TelephonyManager r1 = (TelephonyManager) r5.getSystemService(MultiSimAdapter.PHONE_KEY);
        if (r1.hasIccCard() == true) goto L9;
        this.mResult.setRet(102);
        this.mResult.setDetails(r5.getString(R.string.switch_mode_mobile_data_no_sim));
        return;
    L9:
        r1.createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).setDataEnabledForReason(0, r6);
        setCardPara(16384, r5.getString(R.string.switch_mode_mobile_data), r6);
        this.mResult.setDetails(getDetailsString(r5, R.string.switch_mode_mobile_data, r6));
        this.mResult.setRet(0);
        return;
    L4:
        r0 = "false";
        goto L5
    }

    private void setBluetoothEnabled(Context r4, boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setBluetoothEnabled, enabled is ".concat(r0));
        LocalBluetoothAdapter r1 = LocalBluetoothAdapter.getInstance();
        if (r1 == null) goto L8;
        r1.setBluetoothEnabled(r5);
    L8:
        setCardPara(2, r4.getString(R.string.switch_mode_bluetooth), r5);
        this.mResult.setDetails(getDetailsString(r4, R.string.switch_mode_bluetooth, r5));
        this.mResult.setRet(0);
        return;
    L4:
        r0 = "false";
        goto L5
    }

    private void setAirplaneEnabled(Context r4, boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setAirplaneEnabled, enabled is ".concat(r0));
        Settings.Global.putInt(r4.getContentResolver(), "airplane_mode_on", r5 ? 1 : 0);
        Intent r1 = new Intent("android.intent.action.AIRPLANE_MODE");
        r1.putExtra("state", r5);
        r4.sendBroadcastAsUser(r1, UserHandle.ALL);
        setCardPara(8, r4.getString(R.string.switch_mode_airplane), r5);
        this.mResult.setDetails(getDetailsString(r4, R.string.switch_mode_airplane, r5));
        this.mResult.setRet(0);
        return;
    L4:
        r0 = "false";
        goto L5
    }

    private String getCameraId(Context r8) throws CameraAccessException {
        CameraManager r7 = (CameraManager) r8.getSystemService("camera");
        String[] r9 = r7.getCameraIdList();
        int r0 = r9.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        String r2 = r9[r1];
        CameraCharacteristics r3 = r7.getCameraCharacteristics(r2);
        Boolean r4 = (Boolean) r3.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        Integer r5 = (Integer) r3.get(CameraCharacteristics.LENS_FACING);
        OLog.d("SwitchModeIntent", "get camera id: " + r2 + " flashAvailable: " + r4 + " lensFacing: " + r5);
        if (r4 == null) goto L12;
        if (r4.booleanValue() == false) goto L12;
        if (r5 == null) goto L12;
        if (r5.intValue() != 1) goto L12;
        return r2;
    L12:
        r1 = r1 + 1;
        goto L3
    L13:
        return null;
    }

    private void setFlashLightEnabled(Context r5, boolean r6) {
        if (r6 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setFlashLightEnabled, enabled is ".concat(r0));
        String r1 = getCameraId(r5);     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        ((CameraManager) r5.getSystemService("camera")).setTorchMode(r1, r6);     // Catch: Throwable -> L11
    L9:
        setCardPara(16, r5.getString(R.string.switch_mode_flashlight), r6);     // Catch: Throwable -> L11
        this.mResult.setDetails(getDetailsString(r5, R.string.switch_mode_flashlight, r6));     // Catch: Throwable -> L11
        this.mResult.setRet(0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        this.mResult.setRet(102);
        if (r6 == false) goto L15;
        String r4 = "open";
    L16:
        OLog.e("SwitchModeIntent", r4.concat(" flash light failed."));
        OLog.e("SwitchModeIntent", "setFlashLightEnabled Throwable error:" + th);
        return;
    L15:
        r4 = "close";
        goto L16
    L4:
        r0 = "false";
        goto L5
    }

    private void setZenModeEnabled(Context r4, boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setZenModeEnabled, enabled is ".concat(r0));
        Settings.Secure.putInt(r4.getContentResolver(), "NoDisturbOn", r5 ? 1 : 0);
        setCardPara(1024, r4.getString(R.string.switch_mode_zen), r5);
        this.mResult.setDetails(getDetailsString(r4, R.string.switch_mode_zen, r5));
        this.mResult.setRet(0);
        return;
    L4:
        r0 = "false";
        goto L5
    }

    private void setPowerSaveModeEnabled(final Context r4, final boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setPowerSaveModeEnabled, enabled is ".concat(r0));
        AsyncTask.execute(new AnonymousClass1(this, r4, r5));
        setCardPara(256, r4.getString(R.string.switch_mode_powersave), r5);
        this.mResult.setDetails(getDetailsString(r4, R.string.switch_mode_powersave, r5));
        this.mResult.setRet(0);
        return;
    L4:
        r0 = "false";
        goto L5
    }

    private void setNightModeEnabled(Context r4, boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setNightModeEnabled, enabled is ".concat(r0));
        UiModeManager r1 = (UiModeManager) r4.getSystemService(UiModeManager.class);
        if (r1 != null) goto L8;
        OLog.d("SwitchModeIntent", "uiModeManager is null");
        this.mResult.setDetails(getFailedDetailsString(r4, R.string.switch_mode_nightmode, r5));
        this.mResult.setRet(1);
        return;
    L8:
        r1.setNightModeActivated(r5);
        this.mResult.setDetails(getDetailsString(r4, R.string.switch_mode_nightmode, r5));
        this.mResult.setRet(0);
        return;
    L4:
        r0 = "false";
        goto L5
    }

    private void setLocationEnabled(Context r4, boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setLocationEnabled, enabled is ".concat(r0));
        Utils.updateLocationEnabled(r4, r5, UserHandle.myUserId(), 1);
        setCardPara(4, r4.getString(R.string.switch_mode_location), r5);
        this.mResult.setDetails(getDetailsString(r4, R.string.switch_mode_location, r5));
        this.mResult.setRet(0);
        return;
    L4:
        r0 = "false";
        goto L5
    }

    private void setNightDisplayEnabled(Context r4, boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setNightDisplayEnabled, enabled is ".concat(r0));
        if (r5 == false) goto L8;
        EyesProtectionAPI.openEyesProtection();
    L9:
        setCardPara(64, r4.getString(R.string.switch_mode_nightdisplay), r5);
        this.mResult.setDetails(getDetailsString(r4, R.string.switch_mode_nightdisplay, r5));
        this.mResult.setRet(0);
        return;
    L8:
        EyesProtectionAPI.closeEyesProtection();
        goto L9
    L4:
        r0 = "false";
        goto L5
    }

    private void setRotationEnabled(Context r5, boolean r6) {
        if (r6 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setRotationEnabled, enabled is ".concat(r0));
        IWindowManager r1 = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));     // Catch: RemoteException -> L12
        if (r6 == false) goto L9;
        r1.thawRotation(r5.getPackageName());     // Catch: RemoteException -> L12
    L10:
        this.mResult.setDetails(getDetailsString(r5, R.string.switch_mode_rotation, r6));     // Catch: RemoteException -> L12
        this.mResult.setRet(0);     // Catch: RemoteException -> L12
        return;
    L9:
        r1.freezeRotation(0, r5.getPackageName());     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        this.mResult.setRet(102);
        if (r6 == false) goto L16;
        String r4 = "open";
    L17:
        OLog.e("SwitchModeIntent", r4.concat(" rotation failed."));
        OLog.e("SwitchModeIntent", "setRotationEnabled Throwable error:" + e);
        return;
    L16:
        r4 = "close";
        goto L17
    L4:
        r0 = "false";
        goto L5
    }

    private void setVibrationEnabled(Context r6, boolean r7) {
        if (r7 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setVibrationEnabled, enabled is ".concat(r0));
        if (r7 == false) goto L8;
        int r1 = 1;
    L9:
        boolean r2 = setRingerMode(r6, r1);
        setCardPara(32, r6.getString(R.string.switch_mode_vibrate), r7);
        if (r2 == false) goto L12;
        this.mResult.setDetails(getDetailsString(r6, R.string.switch_mode_vibrate, r7));
        this.mResult.setRet(0);
        return;
    L12:
        this.mResult.setDetails(getFailedDetailsString(r6, R.string.switch_mode_vibrate, r7));
        this.mResult.setRet(1);
        return;
    L8:
        r1 = 2;
        goto L9
    L4:
        r0 = "false";
        goto L5
    }

    private boolean setRingerMode(Context r4, int r5) {
        OLog.d("SwitchModeIntent", "start setRingerMode, ringerMode is " + r5);
        AudioManager r3 = (AudioManager) r4.getSystemService("audio");
        int r1 = 0;
        if (r3 != null) goto L6;
        OLog.e("SwitchModeIntent", "setRingerMode audioManager is null");
        return false;
    L6:
        r3.setRingerModeInternal(r5);
        if (r5 == 2) goto L9;
        Settings.Global.putInt(r4.getContentResolver(), SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED, 1);
        int r6 = Settings.System.getInt(r4.getContentResolver(), "notification_vibration_intensity", 3);
        Settings.System.putInt(r4.getContentResolver(), "notification_vibration_intensity", r6);
        Settings.System.putInt(r4.getContentResolver(), "ring_vibration_intensity", r6);
    L13:
        return true;
    L9:
        if (Settings.System.getInt(r4.getContentResolver(), SoundSettingsFragment.VIBRATION_ON_RING_SWITCH_ON, 1) != 1) goto L11;
        r1 = 1;
    L11:
        Settings.Global.putInt(r4.getContentResolver(), SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED, r1);
        goto L13
    }

    private void setHotspotEnabled(Context r5, boolean r6) {
        if (r6 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setHotspotEnabled, enabled is ".concat(r0));
        WifiManager r1 = (WifiManager) r5.getApplicationContext().getSystemService("wifi");
        if (r1.isWifiApEnabled() != r6) goto L10;
        sethotspotCardPara(r5, r6);
        this.mResult.setRet(0);
        return;
    L10:
        if (MultiSDKAdapter.setWifiApEnabled(r1, null, r6) == false) goto L12;
        sethotspotCardPara(r5, r6);
        this.mResult.setRet(0);
        return;
    L12:
        this.mResult.setRet(102);
        if (r6 == false) goto L15;
        String r4 = "open";
    L16:
        OLog.e("SwitchModeIntent", r4.concat(" hotspot failed."));
        return;
    L15:
        r4 = "close";
        goto L16
    L4:
        r0 = "false";
        goto L5
    }

    private void setBrightnessAdaptiveEnabled(Context r4, boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setBrightnessAdaptiveEnabled, enabled is ".concat(r0));
        Settings.System.putInt(r4.getContentResolver(), "screen_brightness_mode", r5 ? 1 : 0);
        setCardPara(8192, r4.getString(R.string.switch_mode_adaptive_brightness), r5);
        this.mResult.setDetails(getDetailsString(r4, R.string.switch_mode_adaptive_brightness, r5));
        this.mResult.setRet(0);
        return;
    L4:
        r0 = "false";
        goto L5
    }

    private void setBatteyPercentageEnabled(Context r4, boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setBatteyPercentageEnabled, enabled is ".concat(r0));
        Settings.System.putInt(r4.getContentResolver(), "status_bar_show_battery_percent", r5 ? 1 : 0);
        setCardPara(2048, r4.getString(R.string.switch_mode_batterypercentage), r5);
        this.mResult.setDetails(getDetailsString(r4, R.string.switch_mode_batterypercentage, r5));
        this.mResult.setRet(0);
        return;
    L4:
        r0 = "false";
        goto L5
    }

    private void setSilentModeEnabled(Context r4, boolean r5) {
        if (r5 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setSilentModeEnabled, enabled is ".concat(r0));
        AudioManager r1 = (AudioManager) r4.getApplicationContext().getSystemService("audio");
        if (r5 == false) goto L8;
        int r2 = 0;
    L9:
        r1.setRingerModeInternal(r2);
        this.mResult.setDetails(getDetailsString(r4, R.string.switch_mode_silent, r5));
        this.mResult.setRet(0);
        return;
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "false";
        goto L5
    }

    private void setHighPriorityNotificationEnabled(Context r3, boolean r4) {
        if (r4 == false) goto L4;
        String r0 = "true";
    L5:
        OLog.d("SwitchModeIntent", "start setHighPriorityNotificationEnabled, enabled is ".concat(r0));
        Settings.System.putInt(r3.getContentResolver(), NotificationSettingsFragment.HIGH_PRIORITY_NOTIFICATION, r4 ? 1 : 0);
        this.mResult.setDetails(getDetailsString(r3, R.string.switch_mode_high_priority_notification, r4));
        this.mResult.setRet(0);
        return;
    L4:
        r0 = "false";
        goto L5
    }

    private void setNfcEnabled(Context r4, boolean r5) {
        OLog.d("SwitchModeIntent", "start setNfcEnabled, enabled is " + r5);
        NfcAdapter r0 = NfcAdapter.getDefaultAdapter(r4);
        if (r0 != null) goto L6;
        this.mResult.setRet(102);
        OLog.e("SwitchModeIntent", "NFC adapter not available.");
        return;
    L6:
        if (r5 == false) goto L8;
        r0.enable();
    L9:
        String r6 = getQuoteDetailsString(r4, R.string.switch_mode_nfc, r5);
        OLog.d("SwitchModeIntent", "setNfcEnabled, enabled is " + r5 + ", resultDetails is " + r6);
        this.mResult.setDetails(r6);
        this.mResult.setRet(0);
        return;
    L8:
        r0.disable();
        goto L9
    }

    private void setNetSpeedEnabled(Context r4, boolean r5) {
        OLog.d("SwitchModeIntent", "start setNetSpeedEnabled, enabled is " + r5);
        Settings.Secure.putInt(r4.getContentResolver(), StatusBarSettingFragment.STATUS_BAR_SHOW_NETWORK_SPEED, r5 ? 1 : 0);
        String r6 = getQuoteDetailsString(r4, R.string.switch_mode_net_speed, r5);
        OLog.d("SwitchModeIntent", "setNetSpeedEnabled, enabled is " + r5 + ", resultDetails is " + r6);
        this.mResult.setDetails(r6);
        this.mResult.setRet(0);
    }

    private void setCardPara(int r2, String r3, boolean r4) {
        SettingsParaInChatMessage r0 = new SettingsParaInChatMessage(r2, r3, Boolean.valueOf(r4));
        ConcurrentHashMap<String, String> r5 = new ConcurrentHashMap();
        r5.put("result_detail_extras", this.gson.toJson(r0));
        this.mResult.setExt(r5);
        this.mResult.setUiType(32768);
    }

    private void sethotspotCardPara(Context r6, boolean r7) {
        WifiQrcodeParamInChatMessage r0 = new WifiQrcodeParamInChatMessage(r7);
        if (r7 == false) goto L8;
        WifiManager r1 = (WifiManager) r6.getApplicationContext().getSystemService("wifi");
        SoftApConfiguration r2 = r1.getSoftApConfiguration();
        WifiConfiguration r3 = r2.toWifiConfiguration();
        if (r3 != null) goto L7;
        r3 = new WifiConfiguration();
        r3.SSID = r2.getSsid();
        r3.preSharedKey = r2.getPassphrase();
        r3.allowedKeyManagement.set(4);
    L7:
        r0.ssid = r3.SSID;
        r0.phase = r3.preSharedKey;
        r0.qrcodeStr = com.android.settings.wifi.Utils.createContent(r1, r3, true);
    L8:
        ConcurrentHashMap<String, String> r4 = new ConcurrentHashMap();
        r4.put("result_detail_extras", this.gson.toJson(r0));
        this.mResult.setExt(r4);
        this.mResult.setUiType(524288);
        if (r7 == false) goto L11;
        this.mResult.setDetails(r6.getString(R.string.wifi_tether_success_open));
        return;
    L11:
        this.mResult.setDetails(r6.getString(R.string.wifi_tether_success_close));
    }

    private String getDetailsString(Context r3, int r4, boolean r5) {
        Resources r2 = r3.getResources();
        Object[] r0 = new Object[2];
        if (r5 == false) goto L5;
        int r6 = R.string.switch_mode_open;
    L6:
        r0[0] = r3.getString(r6);
        r0[1] = r3.getString(r4);
        return r2.getString(R.string.switch_intent_finish, r0);
    L5:
        r6 = R.string.switch_mode_close;
        goto L6
    }

    private String getQuoteDetailsString(Context r3, int r4, boolean r5) {
        Resources r2 = r3.getResources();
        Object[] r0 = new Object[2];
        if (r5 == false) goto L5;
        int r6 = R.string.switch_mode_open;
    L6:
        r0[0] = r3.getString(r6);
        r0[1] = r3.getString(r4);
        return r2.getString(R.string.switch_intent_finish_with_quote, r0);
    L5:
        r6 = R.string.switch_mode_close;
        goto L6
    }

    private String getFailedDetailsString(Context r3, int r4, boolean r5) {
        Resources r2 = r3.getResources();
        Object[] r0 = new Object[2];
        if (r5 == false) goto L5;
        int r6 = R.string.switch_mode_open;
    L6:
        r0[0] = r3.getString(r6);
        r0[1] = r3.getString(r4);
        return r2.getString(R.string.switch_intent_finish_failed, r0);
    L5:
        r6 = R.string.switch_mode_close;
        goto L6
    }
}
