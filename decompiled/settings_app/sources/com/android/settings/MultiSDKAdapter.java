package com.android.settings;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.GrantedUriPermission;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.admin.DevicePolicyManager;
import android.app.usage.ExternalStorageStats;
import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.app.usage.StorageStatsManager;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothPbap;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.fingerprint.Fingerprint;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.input.InputDeviceIdentifier;
import android.hardware.input.InputManager;
import android.hardware.input.KeyboardLayout;
import android.hardware.usb.UsbManager;
import android.media.AudioManager;
import android.net.NetworkTemplate;
import android.net.TetheringManager;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiDevice;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.IStorageManager;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.security.IKeyChainService;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.Choreographer;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.SpellCheckerSubtype;
import bytedanceos.api.LayoutParamsSmt;
import bytedanceos.api.PackageManagerSmt;
import com.android.ims.ImsManager;
import com.android.internal.app.IMediaContainerService;
import com.android.internal.telephony.Phone;
import com.android.internal.util.UserIcons;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.deviceinfo.StorageMeasurement;
import com.android.settings.utils.NullSafe;
import com.android.settingslib.applications.ApplicationsState;
import com.android.settingslib.applications.StorageStatsSource;
import com.android.vcard.VCardConfig;
import com.obric.olog.OLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class MultiSDKAdapter {
    public static final String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED";
    public static final String ACTION_FACTORY_RESET = "android.intent.action.FACTORY_RESET";
    private static final String BLUETOOTH_NOTIFICATION_CHANNEL = "bluetooth_notification_channel";
    private static final String BLUETOOTH_TIMER_NOTIFICATION_CHANNEL = "bluetooth_timer_notification_channel";
    public static final int CODEC_AAC = 1;
    public static final int CODEC_APTX = 2;
    public static final int CODEC_APTX_ADAPTIVE = 7;
    public static final int CODEC_APTX_HD = 3;
    public static final int CODEC_ERROR = -1;
    public static final int CODEC_LDAC = 4;
    public static final int CODEC_SBC = 0;
    public static int ENCRYPTION_STATE_ERROR_CORRUPT = 0;
    public static int ENCRYPTION_STATE_ERROR_MDTP_ACTIVATED = -5;
    public static int ENCRYPTION_STATE_NONE = 1;
    public static int ENCRYPTION_STATE_OK = 0;
    public static int ENCRYPTION_STATE_OK_MDTP_ACTIVATED = 2;
    public static final int ENROLL_WINDOW_TYPE = 2060;
    public static final int FINGER_KEY_SM_PRIVATE_FLAG = 16777216;
    public static final int MAX_ALLOWED_SEQUENCE = 3;
    public static final float MIN_DIM_VALUE = 0.001f;
    public static final int NOTIFICATION_ID_BLUETOOTH = 1;
    public static final int NOTIFICATION_ID_BLUETOOTH_TIMER = 3;
    public static final int NOTIFICATION_ID_WIFIAP = 2;
    public static final int NOTIFICATION_ID_WIFIP2P = 4;
    public static final int POLICY_NONE = 0;
    public static final int POLICY_REJECT_ALL_BACKGROUND_SCREEN_OFF = 8;
    public static final int POLICY_REJECT_BACKGROUND = 16;
    private static final String TAG = "MultiSDKAdapter";
    public static final int UID_TETHERING = -5;
    private static final String WIFIAP_NOTIFICATION_CHANNEL = "wifiap_notification_channel";
    private static final String WIFIP2P_NOTIFICATION_CHANNEL = "wifip2p_notification_channel";
    public static final int WIFI_DEVICE_BLACKLISTED = 2;

    public static abstract class PackageStatsObserverEx {
        public abstract void onGetStatsCompleted(PackageStats r1, boolean r2) throws RemoteException;

        public PackageStatsObserverEx() {
        }
    }

    public static abstract class RemovalCallback extends FingerprintManager.RemovalCallback {
        public void onRemovalSucceeded(Fingerprint r1) {
        }

        public RemovalCallback() {
        }

        public void onRemovalSucceeded(Fingerprint r1, int r2) {
            onRemovalSucceeded(r1);
        }
    }

    public static class UriPermissionCompat {
        private final GrantedUriPermission compat;

        public UriPermissionCompat(GrantedUriPermission r1) {
            this.compat = r1;
        }

        public Uri getUri() {
            GrantedUriPermission r0 = this.compat;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.uri;
        }
    }

    static {
    }

    public static boolean configHciSnoopLog(boolean r0) {
        return false;
    }

    public static int decryptStorage(String r0) throws RemoteException {
        return 0;
    }

    public static int encryptStorage(int r0, String r1) throws RemoteException {
        return 0;
    }

    public static int encryptWipeStorage(int r0, String r1) throws RemoteException {
        return -1;
    }

    public static int getEncryptionState() throws RemoteException {
        return 0;
    }

    public static int getLocationMode() {
        return 3;
    }

    public static int getPasswordType() throws RemoteException {
        return 0;
    }

    public static void getPhoneDataCallList(Phone r0) {
    }

    public static String getStorageField(String r0) throws RemoteException {
        return "";
    }

    public static boolean isVoLTEAvailable(Context r0, boolean r1, SubscriptionManager r2, int r3) {
        return false;
    }

    public static void sendFpEvent(FingerprintManager r0, boolean r1) {
    }

    public static void setCallbackForScreenChange(Choreographer r0, Runnable r1) {
    }

    public static void setCellInfoListRate(Phone r0, TelephonyManager r1, int r2) {
    }

    public static void setLaunchStackId(ActivityOptions r0, int r1) {
    }

    public static boolean setLockSm(LockPatternUtils r0) {
        return true;
    }

    public static void setPhoneDataEnabled(Context r0, Phone r1, boolean r2) {
    }

    public static void setStorageField(String r0, String r1) throws RemoteException {
    }

    public MultiSDKAdapter() {
    }

    public static void setCurrentSpellChecker(Context r2, SpellCheckerInfo r3) {
        android.provider.Settings.Secure.putString(r2.getContentResolver(), "selected_spell_checker", r3.getId());
        android.provider.Settings.Secure.putInt(r2.getContentResolver(), "selected_spell_checker_subtype", 0);
    }

    public static void setSpellCheckerSubtype(Context r1, SpellCheckerSubtype r2) {
        if (r2 != null) goto L4;
        int r3 = 0;
    L5:
        android.provider.Settings.Secure.putInt(r1.getContentResolver(), "selected_spell_checker_subtype", r3);
        return;
    L4:
        r3 = r2.hashCode();
        goto L5
    }

    public static void setSpellCheckerEnabled(Context r1, boolean r2) {
        android.provider.Settings.Secure.putInt(r1.getContentResolver(), "spell_checker_enabled", r2 ? 1 : 0);
    }

    public static List<String> getSystemCaAliases(IKeyChainService r0) throws RemoteException {
        return r0.getSystemCaAliases().getList();
    }

    public static List<String> getUserCaAliases(IKeyChainService r0) throws RemoteException {
        return r0.getUserCaAliases().getList();
    }

    private static IStorageManager getStorageManager() {
        return IStorageManager.Stub.asInterface((IBinder) NullSafe.nonNull(ServiceManager.getService("mount")));
    }

    public static List<WifiDevice> getConfiguredStations(Context r1) {
        return ((WifiManager) r1.getSystemService("wifi")).getConfiguredStations();
    }

    public static long getTotalBytes(Context r9) {
        long r0 = 0;
        if (r9 != null) goto L18;
        return 0;
    L18:
        NetworkStats r10 = ((NetworkStatsManager) r9.getSystemService(NetworkStatsManager.class)).querySummary(0, null, 0, System.currentTimeMillis());     // Catch: Throwable -> L15
        NetworkStats.Bucket r2 = new NetworkStats.Bucket();     // Catch: Throwable -> L15
    L8:
        if (r10.hasNextBucket() == false) goto L17;
        if (r10.getNextBucket(r2) == false) goto L17;
        if (r2.getUid() != (-5)) goto L8;
        r0 = r0 + (r2.getTxBytes() + r2.getRxBytes());
    L17:
        return r0;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static int installExistingPackageAsUser(IPackageManager r6, String r7, int r8) throws RemoteException {
        return r6.installExistingPackageAsUser(r7, r8, 4194304, 0, null);
    }

    public static void deletePackageAsUser(PackageManager r6, String r7, IPackageDeleteObserver r8, int r9, int r10) {
        PackageManagerSmt.getInstance().deletePackageAsUser(r6, r7, r8, r10, r9);
    }

    public static boolean setWifiApEnabled(WifiManager r2, WifiConfiguration r3, boolean r4) {
        Context r5 = SettingsApplication.getContext();
        TetheringManager r6 = (TetheringManager) r5.getSystemService(TetheringManager.class);
        if (r6 != null) goto L5;
        return false;
    L5:
        if (r4 == false) goto L7;
        r6.startTethering(new TetheringManager.TetheringRequest.Builder(0).setShouldShowEntitlementUi(false).setExemptFromEntitlementCheck(true).build(), r5.getMainExecutor(), new AnonymousClass1());
    L8:
        return true;
    L7:
        r6.stopTethering(0);
        goto L8
    }

    public static void getPackageSizeInfoAsUser(PackageManager r0, final ApplicationInfo r1, int r2, final PackageStatsObserverEx r3) {
        ExecutorManager.execute(new AnonymousClass2(r1, r3), true);
    }

    public static void getPackageSizeInfoAsUser(final Context r0, final ApplicationInfo r1, int r2, final PackageStatsObserverEx r3) {
        ExecutorManager.execute(new AnonymousClass3(r1, r0, r3), true);
    }

    public static boolean isWrongPSWDReason(Intent r2) {
        if (r2.getIntExtra(AdaptWifi.WIFI_MANAGER_EXTRA_SUPPLICANT_ERROR_REASON, 0) != 2) goto L6;
        return true;
    L6:
        return false;
    }

    public static NotificationManager getNotificationManager(Context r4, int r5) {
        if (r5 != 1) goto L5;
        NotificationManager r6 = (NotificationManager) r4.getSystemService("notification");
        r6.createNotificationChannel(new NotificationChannel(BLUETOOTH_NOTIFICATION_CHANNEL, r4.getString(R.string.bluetooth), 4));
        return r6;
    L5:
        if (r5 != 2) goto L7;
        NotificationManager r7 = (NotificationManager) r4.getSystemService("notification");
        r7.createNotificationChannel(new NotificationChannel(WIFIAP_NOTIFICATION_CHANNEL, "WifiApService", 2));
        return r7;
    L7:
        if (r5 == 3) goto L13;
        if (r5 != 4) goto L10;
        NotificationManager r8 = (NotificationManager) r4.getSystemService("notification");
        r8.createNotificationChannel(new NotificationChannel(WIFIP2P_NOTIFICATION_CHANNEL, "WifiLoginAndP2pNotificationBroadcast", 2));
        return r8;
    L10:
        return (NotificationManager) r4.getSystemService("notification");
    L13:
        NotificationManager r9 = (NotificationManager) r4.getSystemService("notification");
        r9.createNotificationChannel(new NotificationChannel(BLUETOOTH_TIMER_NOTIFICATION_CHANNEL, "BluetoothTimerService", 2));
        return r9;
    }

    public static Notification.Builder getNotificationBuilder(Context r1, int r2) {
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L17;
        if (r2 == 3) goto L15;
        if (r2 == 4) goto L13;
        return new Notification.Builder(r1);
    L13:
        return new Notification.Builder(r1, WIFIP2P_NOTIFICATION_CHANNEL);
    L15:
        return new Notification.Builder(r1, BLUETOOTH_TIMER_NOTIFICATION_CHANNEL);
    L17:
        return new Notification.Builder(r1, WIFIAP_NOTIFICATION_CHANNEL);
    L19:
        return new Notification.Builder(r1, BLUETOOTH_NOTIFICATION_CHANNEL);
    }

    public static boolean isImsConnected(Context r1, int r2) {
        if (ImsManager.getInstance(r1, r2).getImsServiceState() != 2) goto L13;
        return true;
    L13:
        return false;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static StorageMeasurement.DeviceStorageInfo getDeviceStorageInfo(IMediaContainerService r4, String r5) {
        StorageMeasurement.DeviceStorageInfo r6 = new StorageMeasurement.DeviceStorageInfo();
        new File(r5);
        StorageStatsManager r7 = (StorageStatsManager) SettingsApplication.getContext().getSystemService(StorageStatsManager.class);
        Iterator r0 = ((StorageManager) SettingsApplication.getContext().getSystemService(StorageManager.class)).getVolumes().iterator();     // Catch: IOException -> L10
    L5:
        if (r0.hasNext() == false) goto L12;
        VolumeInfo r1 = (VolumeInfo) r0.next();     // Catch: IOException -> L10
        if (r1.isPrimary() == false) goto L5;
        r6.totalSize = r7.getTotalBytes(r1.fsUuid);     // Catch: IOException -> L10
        r6.availableSize = r7.getFreeBytes(r1.fsUuid);     // Catch: IOException -> L10
    L12:
        return r6;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static long getOtherFileSize() {
        Context r0 = SettingsApplication.getContext();
        StorageStatsManager r1 = (StorageStatsManager) r0.getSystemService(StorageStatsManager.class);
        StorageManager r2 = (StorageManager) r0.getSystemService(StorageManager.class);
        StorageStatsSource r3 = new StorageStatsSource(r0);
        Iterator r4 = r2.getVolumes().iterator();
    L3:
        long r5 = 0;
        if (r4.hasNext() == false) goto L17;
        VolumeInfo r6 = (VolumeInfo) r4.next();
        if (r6.isPrimary() == false) goto L3;
        StorageStatsSource.ExternalStorageStats r7 = r3.getExternalStorageStats(r6.fsUuid, UserHandle.of(0));     // Catch: IOException -> L9
        r5 = (((r7.totalBytes - r7.audioBytes) - r7.videoBytes) - r7.imageBytes) - r7.appBytes;     // Catch: IOException -> L9
        OLog.d("Settings", "otherExternalBytes " + r5);     // Catch: IOException -> L9
        return r5;
    L9:
        e = move-exception;
        e.printStackTrace();
        return r5;
    L17:
        return 0;
    }

    public static long getAppSize() {
        Context r0 = SettingsApplication.getContext();
        StorageStatsManager r1 = (StorageStatsManager) r0.getSystemService(StorageStatsManager.class);
        StorageManager r2 = (StorageManager) r0.getSystemService(StorageManager.class);
        StorageStatsSource r3 = new StorageStatsSource(r0);
        int r4 = 0;
        List r5 = r0.getPackageManager().getInstalledApplicationsAsUser(0, 0);
        UserHandle r6 = UserHandle.of(0);
        int r7 = r5.size();
        long r8 = 0;
    L3:
        if (r4 >= r7) goto L11;
        ApplicationInfo r9 = (ApplicationInfo) r5.get(r4);
        StorageStatsSource.AppStorageStats r10 = r3.getStatsForPackage(r9.volumeUuid, r9.packageName, r6);     // Catch: Throwable -> L12
        long r11 = r10.getDataBytes();
        long r12 = r1.getCacheQuotaBytes(r9.volumeUuid, r9.uid);
        long r14 = r10.getCacheBytes();
        if (r12 >= r14) goto L9;
        r11 = (r11 - r14) + r12;
    L9:
        r8 = r8 + (r11 + r10.getCodeBytes());
    L10:
        r4 = r4 + 1;
        goto L3
    L11:
        return r8;
    }

    public static void calculateMediaSize(HashMap<String, Long> r6, Set<String> r7, IMediaContainerService r8) {
        Environment.UserEnvironment r9 = new Environment.UserEnvironment(ActivityManager.getCurrentUser());
        StorageStatsManager r10 = (StorageStatsManager) SettingsApplication.getContext().getSystemService(StorageStatsManager.class);
        Iterator r0 = ((StorageManager) SettingsApplication.getContext().getSystemService(StorageManager.class)).getVolumes().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        VolumeInfo r1 = (VolumeInfo) r0.next();
        OLog.d("SettingsStorage", "volumeInfo " + r1);
        if (r1.isPrimary() == false) goto L4;
        ExternalStorageStats r2 = r10.queryExternalStatsForUser(r1.fsUuid, UserHandle.SYSTEM);     // Catch: IOException -> L9
        OLog.d("Settings", "calculateMediaSize imageBytes = " + r2.imageBytes + " , videoBytes = " + r2.videoBytes + " , audioBytes = " + r2.audioBytes);     // Catch: IOException -> L9
        r6.put(Environment.DIRECTORY_PICTURES, Long.valueOf(r2.imageBytes));     // Catch: IOException -> L9
        r6.put(Environment.DIRECTORY_MOVIES, Long.valueOf(r2.videoBytes));     // Catch: IOException -> L9
        r6.put(Environment.DIRECTORY_MUSIC, Long.valueOf(r2.audioBytes));     // Catch: IOException -> L9
        r6.put(Environment.DIRECTORY_DOWNLOADS, Long.valueOf(Utils.getDirectorySize(r9.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS))));     // Catch: IOException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public static void handleBluetoothA2dpDeviceConfigChange(Context r0, BluetoothDevice r1) {
        AudioManager r2 = (AudioManager) r0.getSystemService("audio");
    }

    public static boolean isNotificationListenerAccessGranted(NotificationManager r0, ComponentName r1) {
        return r0.isNotificationListenerAccessGranted(r1);
    }

    public static void setNotificationListenerAccessGranted(NotificationManager r2, ComponentName r3, boolean r4) {
        OLog.d("SettingsTag", "setNotificationListenerAccessGranted " + r3 + " as " + r4);
        r2.setNotificationListenerAccessGranted(r3, r4);
    }

    public static void setNotificationChannelId(Notification.Builder r0, String r1) {
        if (r0 == null) goto L5;
        r0.setChannelId(r1);
        return;
    }

    public static void createNotificationChannel(NotificationManager r2, String r3, String r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.createNotificationChannel(new NotificationChannel(r3, r4, 5));
    }

    public static void resumeSession(ApplicationsState.Session r0) {
        r0.onResume();
    }

    public static void pauseSession(ApplicationsState.Session r0) {
        r0.onPause();
    }

    public static void releaseSession(ApplicationsState.Session r0) {
        r0.onDestroy();
    }

    public static Drawable getDefaultUserIcon(Resources r0, int r1, boolean r2) {
        return UserIcons.getDefaultUserIcon(r0, r1, r2);
    }

    public static long getMaximumTimeToLock(DevicePolicyManager r1, int r2) {
        return r1.getMaximumTimeToLock(null, r2);
    }

    public static boolean isChargingUsbFunction(UsbManager r4) {
        if (r4.getCurrentFunctions() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setChargingUsbFunction(UsbManager r2, boolean r3) {
        r2.setCurrentFunctions(4096);
    }

    public static boolean containsUsbFunction(UsbManager r0, String r1, String r2) {
        return containsFunction(r1, r2);
    }

    private static boolean containsFunction(String r4, String r5) {
        int r0 = r4.indexOf(r5);
        if (r0 >= 0) goto L6;
        return false;
    L6:
        if (r0 > 0) goto L8;
    L10:
        int r1 = r0 + r5.length();
        if (r1 < r4.length()) goto L13;
        return true;
    L13:
        if (r4.charAt(r1) == ',') goto L17;
        return false;
    L17:
        return true;
    L8:
        if (r4.charAt(r0 - 1) == ',') goto L10;
        return false;
    }

    public static void setUserQuietModeEnabled(UserManager r0, UserHandle r1, IntentSender r2, boolean r3) {
        r0.requestQuietModeEnabled(r3, r1, r2);
    }

    public static List<UriPermissionCompat> getGrantedUriPermissionsCompat(ActivityManager r2, String r3) {
        List r4 = r2.getGrantedUriPermissions(r3).getList();
        if (r4 != null) goto L6;
        return null;
    L6:
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r5.add(new UriPermissionCompat((GrantedUriPermission) r6.next()));
        goto L8
    L10:
        return r5;
    }

    public static void addKeyboardLayoutForInputDevice(InputManager r0, InputDeviceIdentifier r1, InputMethodInfo r2, InputMethodSubtype r3, KeyboardLayout r4) {
        r0.addKeyboardLayoutForInputDevice(r1, r4.getDescriptor());
    }

    public static KeyboardLayout getKeyboardLayoutForInputDevice(InputManager r0, InputDeviceIdentifier r1, InputMethodInfo r2, InputMethodSubtype r3) {
        return r0.getKeyboardLayout(r0.getCurrentKeyboardLayoutForInputDevice(r1));
    }

    public static void removeDeviceFromDatabase(BluetoothDevice r0, String r1) {
        if (r0 == null) goto L5;
        r0.removeDeviceFromDatabase(r1);
        return;
    }

    public static void addDeviceToDatabase(BluetoothDevice r0, String r1) {
        if (r0 == null) goto L5;
        r0.addDeviceToDatabase(r1);
        return;
    }

    public static NetworkTemplate buildTemplateMobile(String r0, String r1) {
        return NetworkTemplate.buildTemplateMobileAll(r0);
    }

    public static void disconnect(BluetoothPbap r0, BluetoothDevice r1) {
        r0.disconnect(r1);
    }

    public static boolean getWifiStaSapConcurrency(WifiManager r0) {
        return AdaptWifi.getWifiStaSapConcurrency(r0);
    }

    public static String getBasebandInfo(TelephonyManager r0, String r1) {
        return r0.getBasebandVersionForPhone(0);
    }

    public static void updateWindowFlagByDim(WindowManager.LayoutParams r2, boolean r3, float r4) {
        if (r3 == false) goto L10;
        LayoutParamsSmt.getInstance().add_bytedancePrivateFlag(r2, VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        if (Math.abs(AdaptUtils.getDimAmountForBrightness(r2) - r4) >= 0.001f) goto L7;
        r4 = r4 + 0.001f;
    L7:
        AdaptUtils.setDimAmountForBrightness(r2, r4);
        if (AdaptUtils.getDimAmountForBrightness(r2) != 0.0f) goto L12;
        AdaptUtils.setDimAmountForBrightness(r2, 0.001f);
        return;
    L12:
        return;
    L10:
        LayoutParamsSmt.getInstance().removeBytedancePrivateFlag(r2, VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        AdaptUtils.setDimAmountForBrightness(r2, 0.0f);
    }
}
