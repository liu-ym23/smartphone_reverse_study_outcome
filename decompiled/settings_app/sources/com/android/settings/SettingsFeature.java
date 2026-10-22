package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import bytedanceos.api.StorageManagerSmt;
import bytedanceos.util.DeviceType;
import bytedanceos.util.Features;
import bytedanceos.util.SettingsUtil;
import com.android.settings.servicemanager.ISettingsFeatureService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsFeature {
    public static boolean ADVANCE_SCREEN_ROTATION_MANUAL = false;
    public static boolean COLOR_STATUS_BAR_ENABLED = false;
    public static boolean ENABLE_DOUBLE_TIMEZONE_FEATURE = false;
    public static boolean ENABLE_THUMB_PULLDOWN_WALLPAPER = false;
    public static boolean ENABLE_VOICE_INPUT_FEATURE = false;
    private static final boolean IS_SUPPORT_SD = false;
    public static boolean LAUNCHER_4X5_SUPPORTED = false;
    public static boolean LONG_PRESS_HOME_SETTINGS_FEATURE = false;
    public static boolean NEW_NOFITICATION_FEATURE = false;
    public static boolean OBSESSION_DISPLAY_LARGE_BATTERY_IN_LOCKSCREEN = false;
    public static boolean SENSOR_SWITHCER_SUPPORT = false;
    public static boolean SHORTCUT_KEY_SETTINGS_FEATURE = false;
    public static boolean SLIDE_UP_SETTING = false;
    public static boolean SUPPORT_DISPLAY_SIZE = false;
    public static boolean SUPPORT_UNKOWN_SOURCE_SETTINGS = false;
    private static final String TAG = "SettingsFeature";
    private static final boolean TEMP_DDS_ENABLED = false;
    public static boolean WIRELESS_CHARGING_SUPPORT;

    public static boolean hasMultiCustomKey() {
        return false;
    }

    public static boolean isDataTransferEnabled() {
        return true;
    }

    public static boolean isEyesProtectionRejectColorMode() {
        return true;
    }

    public static final boolean isFeatureDomestic(Context r0) {
        return true;
    }

    public static boolean isGameAccelerateSupport() {
        return false;
    }

    public static boolean isHomeKeyNavigationFeature() {
        return false;
    }

    public static boolean isKeyguardSettingsSupport() {
        return false;
    }

    public static boolean isLauncher12GridsSupport() {
        return true;
    }

    public static boolean isNewSystemUI() {
        return true;
    }

    public static boolean isNotificationCustomAvailable() {
        return true;
    }

    public static boolean isShowTikTokOnLock() {
        return false;
    }

    public static boolean isSmartKeyCustomized() {
        return false;
    }

    public static boolean isSupportAIButtonKeyFingerprint() {
        return true;
    }

    public static boolean isSupportClickLightScreen() {
        return false;
    }

    public static boolean isSupportCustomizeVolKey() {
        return true;
    }

    public static boolean isSupportDTSSound() {
        return false;
    }

    public static boolean isSupportGameHideNotification() {
        return false;
    }

    public static boolean isSupportIconIllumination() {
        return false;
    }

    public static boolean isSupportLED() {
        return false;
    }

    public static boolean isSupportNetOnNonDataSim() {
        return false;
    }

    public static boolean isSupportNubiaShare() {
        return true;
    }

    public static boolean isSupportReadMode() {
        return false;
    }

    public static boolean isSupportScreenColorTemperature() {
        return true;
    }

    public static boolean isSupportScreenRefreshRate() {
        return false;
    }

    public static boolean isSupportSmartDisplay() {
        return false;
    }

    public static boolean isSupportStatusBarStyle() {
        return false;
    }

    public static boolean isSupportSwapAiAndPowerKey() {
        return false;
    }

    public static boolean isSupportSwitchLauncher() {
        return false;
    }

    public static boolean isSupportTopWindowFeature() {
        return true;
    }

    public static boolean isSupportTrackBall() {
        return false;
    }

    public static boolean isSupportZteFaceRecognition() {
        return true;
    }

    public static boolean isTTSUISuitable() {
        return true;
    }

    public static boolean isVoipSupport(Context r0) {
        return false;
    }

    public SettingsFeature() {
    }

    static {
        if (SystemProperties.getInt("ro.storage.exsdcard", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        IS_SUPPORT_SD = r0;
        ENABLE_DOUBLE_TIMEZONE_FEATURE = false;
        SUPPORT_UNKOWN_SOURCE_SETTINGS = false;
        ENABLE_THUMB_PULLDOWN_WALLPAPER = false;
        ENABLE_VOICE_INPUT_FEATURE = false;
        SENSOR_SWITHCER_SUPPORT = isSensorSwitcherSupport();
        LONG_PRESS_HOME_SETTINGS_FEATURE = isLongPressHomeSettingsEnabled();
        SHORTCUT_KEY_SETTINGS_FEATURE = true;
        LAUNCHER_4X5_SUPPORTED = true;
        NEW_NOFITICATION_FEATURE = false;
        SUPPORT_DISPLAY_SIZE = !DeviceType.isOneOf(new DeviceType[]{DeviceType.T1, DeviceType.T2, DeviceType.U1, DeviceType.M1, DeviceType.M1L, DeviceType.A1, DeviceType.BONO, DeviceType.ODIN});
        COLOR_STATUS_BAR_ENABLED = false;
        WIRELESS_CHARGING_SUPPORT = DeviceType.is(DeviceType.TRIDENT);
        ADVANCE_SCREEN_ROTATION_MANUAL = DeviceType.isOneOf(new DeviceType[]{DeviceType.TRIDENT, DeviceType.OCEAN, DeviceType.DELTA, DeviceType.DARWIN});
        OBSESSION_DISPLAY_LARGE_BATTERY_IN_LOCKSCREEN = DeviceType.isOneOf(new DeviceType[]{DeviceType.TRIDENT, DeviceType.OCEAN});
        SLIDE_UP_SETTING = false;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static boolean isFaceRecognitionEnable() {
        return Utils.isPackageInstalled(SettingsApplication.getContext(), "com.bytedance.facerecognition");
    }

    public static boolean isTextBoomFeatureEnable(Context r1) {
        return Utils.isPackageInstalled(r1, Constants.PKG_BIG_BANG);
    }

    public static boolean isLEDBrightnessSettingsEnabled() {
        if (DeviceType.is(DeviceType.U1) == false) goto L5;
    L8:
        return true;
    L5:
        if (DeviceType.is(DeviceType.BONO) == true) goto L8;
        return false;
    }

    public static boolean isHiFiSupport() {
        if (DeviceType.is(DeviceType.T2) == false) goto L5;
    L10:
        return true;
    L5:
        if (DeviceType.is(DeviceType.M1) == true) goto L10;
        if (DeviceType.is(DeviceType.M1L) == true) goto L10;
        return false;
    }

    public static boolean isLauncher81GridsSupport() {
        return !DeviceType.is(DeviceType.U1);
    }

    public static boolean isLockAppSettingsVisible(Context r0) {
        return Utils.isBytedanceLauncher(r0);
    }

    public static boolean isGoogleSettingsAvailable(Context r4) {
        ISettingsFeatureService r0 = (ISettingsFeatureService) ServiceManager.getService(ISettingsFeatureService.class);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        boolean r5 = Utils.isPackageInstalled(r4, "com.google.android.gms");
        if (r1 == false) goto L14;
        if (r5 == true) goto L13;
        return false;
    L13:
        return true;
    L14:
        return false;
    L5:
        if (r0.isGoogleSettingsItemVisible() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static boolean isCameraLocationSettingsAvailable() {
        return DeviceType.is(DeviceType.T1);
    }

    public static boolean isFingerprintSensorInBackside() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.OSBORN, DeviceType.TRIDENT, DeviceType.OCEAN});
    }

    public static boolean isSim2CanNotBeDataCardWhenSim1IsCdma() {
        return DeviceType.is(DeviceType.U1);
    }

    public static boolean isMtkDevice() {
        return DeviceType.is(DeviceType.BONO);
    }

    public static boolean isDoubleSideKey() {
        return !DeviceType.isOneOf(new DeviceType[]{DeviceType.ODIN, DeviceType.OSBORN, DeviceType.OSCAR, DeviceType.TRIDENT, DeviceType.OCEAN, DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSidekeySwitchSongAvailable(Context r3) {
        int r4 = android.provider.Settings.Global.getInt(r3.getContentResolver(), "brightness_key_function", 1);
        boolean r2 = false;
        if (r4 != 2) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
    L12:
        r2 = true;
    L14:
        return !r2;
    L11:
        if (isDoubleSideKey() == true) goto L14;
    L5:
        if (r4 == 3) goto L8;
        r5 = false;
        goto L9
    }

    public static boolean isCoverCaribrationSupport() {
        return DeviceType.is(DeviceType.U1);
    }

    public static boolean isVirtualKeySupport() {
        if (DeviceType.is(DeviceType.U1) == false) goto L5;
    L10:
        return true;
    L5:
        if (DeviceType.is(DeviceType.A1) == true) goto L10;
        if (DeviceType.is(DeviceType.BONO) == true) goto L10;
        return false;
    }

    public static boolean isFingerprintNavigationDevice() {
        if (DeviceType.is(DeviceType.M1) == false) goto L5;
    L10:
        return true;
    L5:
        if (DeviceType.is(DeviceType.M1L) == true) goto L10;
        if (DeviceType.is(DeviceType.ODIN) == true) goto L10;
        return false;
    }

    public static boolean isWalletFeatureEnabled(Context r2) {
        if (DeviceType.is(DeviceType.TRIDENT) == false) goto L6;
        return false;
    L6:
        boolean r3 = Utils.isPackageInstalled(r2, "com.bytedanceos.wallet");
        OLog.d(TAG, "isWalletFeatureEnabled = " + r3);
        return r3;
    }

    public static boolean isWalletNfcFeatureEnabled(Context r1) {
        return Utils.isPackageInstalled(r1, "com.zte.wallet");
    }

    public static boolean isSupportEyesProtection() {
        return SettingsUtil.isEyesProtectionSupport();
    }

    public static boolean isEyesProtectionRejectColorTemperature() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.TRIDENT, DeviceType.OCEAN, DeviceType.DELTA, DeviceType.DARWIN, DeviceType.UNKNOWN});
    }

    public static void resetNavbarTheme(Context r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (android.provider.Settings.Global.getInt(r3.getContentResolver(), "navigationbar_theme", 0) != 0) goto L8;
        android.provider.Settings.Global.putInt(r3.getContentResolver(), "navigationbar_theme", 1);
        return;
    }

    public static boolean isDisplayWhenScreenOffSupport() {
        return DeviceType.is(DeviceType.OCEAN);
    }

    public static boolean isThemeClockSupport() {
        return DeviceType.is(DeviceType.TRIDENT);
    }

    public static boolean isWeChatPayAvailable(Context r3) {
        boolean r0 = Utils.isPackageInstalled(r3, "com.tencent.mm");
        int r4 = Utils.getMMApiLevel(r3);
        OLog.d(TAG, "apiLevel = " + r4);
        if (r0 == true) goto L5;
    L7:
        return false;
    L5:
        if (r4 < 8) goto L7;
        return true;
    }

    public static boolean isAliPayAvailable(Context r1) {
        return Utils.isPackageInstalled(r1, "com.eg.android.AlipayGphone");
    }

    public static boolean isSmilingCloudAvailable(Context r1) {
        if (Utils.isPackageInstalled(r1, "com.bytedanceos.cloudsync") == true) goto L5;
    L7:
        return false;
    L5:
        if (isFeatureDomestic(SettingsApplication.getContext()) == false) goto L7;
        return true;
    }

    public static boolean hasMenuAndBackKeys() {
        if (DeviceType.is(DeviceType.T1) == false) goto L5;
    L10:
        return true;
    L5:
        if (DeviceType.is(DeviceType.T2) == true) goto L10;
        if (DeviceType.is(DeviceType.U1) == true) goto L10;
        return false;
    }

    public static boolean hasHomeKeySettings(Context r0) {
        return isWalletFeatureEnabled(r0);
    }

    public static boolean hasBottomKeysSettings(Context r0) {
        return hasMenuAndBackKeys();
    }

    public static boolean isSupportSd() {
        return IS_SUPPORT_SD;
    }

    public static boolean isSdMounted() {
        if (IS_SUPPORT_SD == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(StorageManagerSmt.getExternalSdcardPath()) == true) goto L7;
        return true;
    }

    private static boolean isSensorSwitcherSupport() {
        if (DeviceType.is(DeviceType.T2) == false) goto L5;
    L14:
        boolean r0 = true;
    L16:
        return !r0;
    L5:
        if (DeviceType.is(DeviceType.U1) == true) goto L14;
        if (DeviceType.is(DeviceType.M1) == true) goto L14;
        if (DeviceType.is(DeviceType.M1L) == true) goto L14;
        if (DeviceType.is(DeviceType.DARWIN) == true) goto L14;
        r0 = false;
        goto L16
    }

    public static boolean hasPowerKey() {
        if (DeviceType.is(DeviceType.T1) == false) goto L5;
    L10:
        return true;
    L5:
        if (DeviceType.is(DeviceType.U1) == true) goto L10;
        if (DeviceType.is(DeviceType.ODIN) == true) goto L10;
        return false;
    }

    private static boolean isLongPressHomeSettingsEnabled() {
        if (DeviceType.is(DeviceType.T1) == false) goto L5;
    L8:
        return true;
    L5:
        if (DeviceType.is(DeviceType.ODIN) == true) goto L8;
        return false;
    }

    public static boolean isGameModeSupport() {
        return !DeviceType.isOneOf(new DeviceType[]{DeviceType.UNKNOWN, DeviceType.T1, DeviceType.T2, DeviceType.U1, DeviceType.M1, DeviceType.M1L, DeviceType.A1, DeviceType.BONO, DeviceType.ODIN});
    }

    public static boolean isGameSideBarSupport() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isGameNetworkAccelerateSupport() {
        return Utils.isPackageInstalled(SettingsApplication.getContext(), "com.bytedanceos.gamespeedup");
    }

    public static boolean isGameModeLockAutoBrightnessSupport() {
        return isGameModeSupport();
    }

    public static boolean hasNoPowerKey() {
        if (DeviceType.is(DeviceType.T2) == false) goto L5;
    L10:
        return true;
    L5:
        if (DeviceType.is(DeviceType.M1) == true) goto L10;
        if (DeviceType.is(DeviceType.M1L) == true) goto L10;
        return false;
    }

    public static boolean supportFingerprint(Context r1) {
        FingerprintManager r2 = (FingerprintManager) r1.getApplicationContext().getSystemService("fingerprint");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.isHardwareDetected() == false) goto L7;
        return true;
    }

    public static boolean isPhoneChargeSupport(Context r0) {
        if (isFeatureDomestic(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (Utils.isCtaTestModeOn() == true) goto L7;
        return true;
    }

    public static boolean isPhoneChargeInstalled(Context r1) {
        return Utils.isPackageInstalled(r1, Constants.PKG_PHONE_CHARGE);
    }

    @Deprecated
    public static boolean hasNavigationBar() {
        return SettingsUtil.hasNavigationBar();
    }

    public static boolean isAccessibilitySupport(Context r5) {
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.UNKNOWN, DeviceType.T1, DeviceType.T2, DeviceType.U1, DeviceType.A1, DeviceType.BONO}) == false) goto L5;
        return false;
    L5:
        if (isFeatureDomestic(r5) == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isBytedanceAccessibilitySupport(Context r3) {
        if (isAccessibilitySupport(r3) == true) goto L5;
        return false;
    L5:
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.M1, DeviceType.M1L}) == false) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isSupportSmartScreenProtection() {
        return DeviceType.is(DeviceType.OSBORN);
    }

    public static boolean isSupportOneStep(Context r0) {
        return !SettingsUtil.isAccessibilityEnabled(r0);
    }

    public static boolean isSupportInfinityScreen(Context r4) {
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.OCEAN, DeviceType.TRIDENT}) == true) goto L5;
        return false;
    L5:
        if (SettingsUtil.isAccessibilityEnabled(r4) == false) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isSmartDenoiseSupport() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.TRIDENT, DeviceType.OSCAR, DeviceType.OCEAN});
    }

    public static boolean isNormalAppsSmartDenoiseSupport() {
        if (isSmartDenoiseSupport() == true) goto L5;
        return false;
    L5:
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.OCEAN}) == false) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isScreenColorModeSupport() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.OCEAN, DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSupportColorOverride() {
        return !Utils.isGintamaVersion();
    }

    public static boolean isSupportHomeSwipeVibration() {
        return DeviceType.is(DeviceType.OSCAR);
    }

    public static boolean isSupportHomeBack() {
        if (DeviceType.is(DeviceType.OSCAR) == false) goto L5;
    L8:
        return true;
    L5:
        if (isFingerprintNavigationDevice() == true) goto L8;
        return false;
    }

    public static boolean isNarrowModeNavBarSupport() {
        return !DeviceType.isOneOf(new DeviceType[]{DeviceType.TRIDENT, DeviceType.OCEAN, DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isOscarFeature() {
        return DeviceType.is(DeviceType.OSCAR);
    }

    public static boolean isWineRedNavigationBarSupport() {
        return !DeviceType.isOneOf(new DeviceType[]{DeviceType.TRIDENT, DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSupportForceTouch() {
        return DeviceType.is(DeviceType.TRIDENT);
    }

    public static boolean hasPhysicalVirtualKey() {
        return DeviceType.is(DeviceType.OCEAN);
    }

    public static boolean isSystemAppDefaultImmersive() {
        return DeviceType.is(DeviceType.OCEAN);
    }

    public static boolean isPowerShortcutSupport() {
        return !DeviceType.isOneOf(new DeviceType[]{DeviceType.T1, DeviceType.T2, DeviceType.U1, DeviceType.M1, DeviceType.M1L, DeviceType.A1, DeviceType.BONO, DeviceType.ODIN, DeviceType.OSBORN, DeviceType.OSCAR, DeviceType.UNKNOWN});
    }

    public static boolean isSupportNavbarVibrationSetting() {
        return DeviceType.is(DeviceType.TRIDENT);
    }

    public static boolean isNavBarMode(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "navigationbar_trigger_mode", 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isCmelVersion() {
        return "trident_cmel".equals(SystemProperties.get("ro.product.name"));
    }

    public static boolean isSupportTNT() {
        return !DeviceType.isOneOf(new DeviceType[]{DeviceType.T1, DeviceType.T2, DeviceType.U1, DeviceType.M1, DeviceType.M1L, DeviceType.A1, DeviceType.BONO, DeviceType.ODIN, DeviceType.OSBORN, DeviceType.OSCAR, DeviceType.UNKNOWN});
    }

    public static boolean isSupport2KDisplayFeature() {
        return DeviceType.is(DeviceType.OCEAN);
    }

    public static boolean isSupportLeakCanary() {
        return Build.isDebuggable();
    }

    public static boolean isSupportFrontFP() {
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN, DeviceType.UNKNOWN}) == true) goto L7;
        if (com.android.settings.utils.DeviceType.is(com.android.settings.utils.DeviceType.PACIFIC) == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isSupportRightSideFP() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.UNKNOWN});
    }

    public static boolean isSupportDC() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSupportForbidNavBar() {
        return !DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSupportNewPhoneFrame() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSupportNewCamera() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSupportLimitedMinBrightness() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN, DeviceType.UNKNOWN});
    }

    public static boolean isSupportHearing() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSupportThumbPullDown() {
        return !DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSupportNewOneStep() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isEyesProtection() {
        if (android.provider.Settings.Global.getInt(SettingsApplication.getContext().getContentResolver(), "read_mode_enable", 0) == 1) goto L5;
        return false;
    L5:
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.OCEAN, DeviceType.TRIDENT, DeviceType.UNKNOWN}) == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isSupportLightScreen() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN, DeviceType.OCEAN, DeviceType.UNKNOWN});
    }

    public static boolean isSupportNewNumberAssistant() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.TRIDENT, DeviceType.OCEAN, DeviceType.DARWIN});
    }

    public static boolean isSupportPrinter() {
        return Features.hasFeature(Constants.FEATURE_SYSTEM_PRINTER);
    }

    public static boolean isDarwin() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DARWIN});
    }

    public static boolean isWaterDropScreen() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.TRIDENT, DeviceType.DELTA});
    }

    public static boolean isDiggingScreen() {
        return DeviceType.is(DeviceType.DARWIN);
    }

    public static boolean isInfiniteScreen() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DARWIN, DeviceType.UNKNOWN});
    }

    public static boolean isSupportScreenRefresh() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DARWIN});
    }

    public static boolean isSupportNewCalibration() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.TRIDENT, DeviceType.OCEAN, DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSupportPSensorCalibration() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.TRIDENT, DeviceType.OCEAN, DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSupportScreenResolution() {
        if (Build.VERSION.SDK_INT <= 33) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isRoundCorner() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean skipFaceInfoSetupPage() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSupportGloveMode() {
        return DeviceType.isOneOf(new DeviceType[]{DeviceType.TRIDENT, DeviceType.OCEAN, DeviceType.DELTA, DeviceType.DARWIN});
    }

    public static boolean isSupportBostonKeyboard() {
        return DeviceType.is(DeviceType.DARWIN);
    }

    public static boolean isSupportSideDialKey() {
        return DeviceType.is(DeviceType.DARWIN);
    }

    public static boolean isPalmRejectionSupport() {
        return DeviceType.is(DeviceType.DELTA);
    }

    public static boolean isSupport5G() {
        return DeviceType.is(DeviceType.DARWIN);
    }

    public static boolean isSupportSecurityKeyboard(Context r1) {
        return Utils.isPackageInstalled(r1, Constants.PACKAGE_SECURITY_IME2);
    }

    public static boolean isSupportAssistantRole() {
        if (ProductFlavor.isNeridaHk() == false) goto L7;
        return true;
    L7:
        return "true".equals(SystemProperties.get("sys.debug.support_change_assistant_role", ""));
    }

    public static boolean isWifiFailAuth(Intent r1) {
        ISettingsFeatureService r0 = (ISettingsFeatureService) ServiceManager.getService(ISettingsFeatureService.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isWifiFailAuth(r1);
    }
}
