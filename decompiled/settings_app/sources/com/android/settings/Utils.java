package com.android.settings;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.accounts.AccountManager;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.app.AppGlobals;
import android.app.Dialog;
import android.app.IActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.SmtPCUtils;
import android.app.admin.DevicePolicyManager;
import android.bluetooth.BluetoothDevice;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.om.OverlayManager;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.IntentFilterVerificationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.face.FaceManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.usb.UsbManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.INetworkManagementService;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StatFs;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.preference.PreferenceFrameLayout;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.service.persistentdata.PersistentDataBlockManager;
import android.telephony.TelephonyManager;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.style.TtsSpan;
import android.util.ArraySet;
import android.util.Log;
import android.util.NtpTrustedTime;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import bytedanceos.api.ActivityManagerSmt;
import bytedanceos.api.ApplicationInfoSmt;
import bytedanceos.api.IntentSmt;
import bytedanceos.api.PackageManagerSmt;
import bytedanceos.api.TextViewSmt;
import bytedanceos.util.DeviceType;
import bytedanceos.util.Features;
import bytedanceos.util.SettingsUtil;
import com.android.internal.app.UnlaunchableAppActivity;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DoppelgangerUtils;
import com.android.internal.util.UserIcons;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.settings.about.DeviceUtils;
import com.android.settings.accessibility.AccessibilitySettingsFragment;
import com.android.settings.accounts.ManageAccountsSettingsActivity;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.applications.PreferredActivityChooserFragment;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.bluetooth.BluetoothSettings;
import com.android.settings.provision.NextPageRouting.RoutingUtils;
import com.android.settings.provision.WizardManagerHelper;
import com.android.settings.utils.NullSafe;
import com.android.settings.utils.OTAUpdateManager;
import com.android.settings.utils.SLog;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.android.settingslib.display.DisplayDensityUtils;
import com.android.vcard.VCardConfig;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.sremlib.LibUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.simplified.OLocalListItemText;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import obric.api.WindowManagerSmt;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import obric.time.HttpHeadTimeFetcher;
import obric.util.VibratorHelper;
import obric.widget.ListContentItem;
import org.apache.commons.io.FileSystemUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class Utils extends com.android.settingslib.Utils {
    public static final boolean ACTIVATE_MODE = false;
    private static final Uri APP_BASE_LAYER_URI = null;
    public static final String APP_STORE_PACKAGE = "com.obric.appstore";
    public static final int[] BADNESS_COLORS = null;
    private static final List<String> BATTERY_MANAGER_WHITELIST_APP = null;
    public static final int CHECK_STATE_GENERATE = 1;
    public static final int CHECK_STATE_INIT = 0;
    public static final int CHECK_STATE_NO_SPACE = -2;
    public static final int CHECK_STATE_SAME_FILE = -1;
    private static final int DEFAULT_FLY_BACK_ANIM_DURATION = 300;
    private static final float DEFAULT_SCALING = 1.1f;
    private static final int DEVICE_HYBRID = 1;
    public static int DEVICE_NAME_MAX_LENGTH = 0;
    private static final int DEVICE_PHONE = 0;
    private static final int DEVICE_TABLET = 2;
    private static final long DIFF = 1000;
    public static final float DISABLED_ALPHA = 0.4f;
    public static final String EXTRA_FROM_SETTINGS = "from_settings";
    public static final List<String> FAKE_SYSTEM_APPS = null;
    public static final int FT_SUPPORT_DATEUSAGE = 0;
    public static final int FT_SUPPORT_POWERSAVE = 2;
    public static final int FT_SUPPORT_STORAGE = 1;
    public static int ICON_SIZE_NORMAL = 0;
    private static final String INTENT_SEND_TO_ANDROID_FROM_TEXTBOOM = "textboom_app_ocr_status_changed_intent";
    private static final Gson JSON_CONVERT = null;
    public static String KEY_IF_NEED_READ_DEVICE_NAME_AP = null;
    public static String KEY_IF_NEED_READ_DEVICE_NAME_BT = null;
    private static String LAUNCHER_THEME_CLASSIC_BLACK_ID = null;
    private static final long MB = 1048576;
    private static final List<String> OPEN_SYSTEM_APPS = null;
    public static final String OS_PKG = "os";
    private static final String RESET_OAID = "reset_bytedance_oaid";
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final String SECURITY_PKG = "com.obric.security";
    public static final String SETTINGS_PACKAGE_NAME = "com.android.settings";
    public static int STANDARD_WALLPAPER_HEIGHT = 0;
    public static int STANDARD_WALLPAPER_WIDTH = 0;
    private static final String SWAP_FEATURE_PROPERTY_SIZE = "persist.vendor.bytedanceswap.size";
    private static final long SWAP_FEATURE_PROPERTY_SIZE_2G = 2147483648L;
    private static final String SWAP_FILE_PATH = "/data/vendor/swap/swapfile";
    public static final String SYSTEMUI_PACKAGE_NAME = "com.android.systemui";
    public static final List<String> SYSTEM_COMPONENT_APPS = null;
    private static final String TAG = "Settings-Utils";
    public static int THUMBNAIL_WIDTH = 0;
    public static final String TOGGLEABLE_SERVICE_KEY = "isToggleableService";
    public static final int TRANSACTION_ANIM_MODAL = 3;
    public static final int TRANSACTION_ANIM_NONE = 1;
    public static final int TRANSACTION_ANIM_PUSH_UP = 2;
    public static final int TRANSACTION_ANIM_SLIDE = 0;
    public static final int UPDATE_PREFERENCE_FLAG_SET_TITLE_TO_MATCHING_ACTIVITY = 1;
    private static int mDeviceType;
    private static String[] mDoppelgangerAppArray;
    private static int[] mSecurityFeature;
    private static final StringBuilder sBuilder = null;
    private static SparseArray<Bitmap> sDarkDefaultUserBitmapCache;
    private static final Formatter sFormatter = null;
    private static int sLastButtonId;
    private static long sLastClickTime;

    public static final class LockType {
        public static final int COMPLEX = 4;
        public static final int NONE = 0;
        public static final int PATTERN = 1;
        public static final int PIN_4 = 2;
        public static final int PIN_6 = 3;

        public LockType() {
        }
    }

    public interface StartActivityFailCallBack {
        void onFailed();
    }

    public static int getAnimIndexFromValue(int r2) {
        if (r2 != 3) goto L5;
        return 1;
    L5:
        if (r2 != 4) goto L7;
        return 2;
    L7:
        if (r2 == 6) goto L10;
        return 0;
    L10:
        return 3;
    }

    public static int getItemBgStyle(int r1, int r2) {
        if (r1 != 1) goto L5;
        return 1;
    L5:
        if (r2 != 0) goto L9;
        return 2;
    L9:
        if (r2 != (r1 - 1)) goto L12;
        return 4;
    L12:
        return 3;
    }

    public static int getValueFromPosition(int r2) {
        if (r2 != 1) goto L5;
        return 3;
    L5:
        if (r2 == 2) goto L11;
        if (r2 == 3) goto L9;
        return 0;
    L9:
        return 6;
    L11:
        return 4;
    }

    public static boolean isOnlySupportTnt() {
        return false;
    }

    @Deprecated
    public static boolean shouldDisplayTheme() {
        return true;
    }

    public Utils() {
    }

    static {
        BADNESS_COLORS = new int[]{0, -3917784, -1750760, -754944, -344276, -9986505, -16089278};
        sDarkDefaultUserBitmapCache = new SparseArray();
        mDeviceType = -1;
        ICON_SIZE_NORMAL = 96;
        THUMBNAIL_WIDTH = 160;
        STANDARD_WALLPAPER_WIDTH = 1080;
        STANDARD_WALLPAPER_HEIGHT = 1920;
        KEY_IF_NEED_READ_DEVICE_NAME_AP = "read_device_name_ap";
        KEY_IF_NEED_READ_DEVICE_NAME_BT = "read_device_name_bt";
        DEVICE_NAME_MAX_LENGTH = 32;
        ACTIVATE_MODE = Features.FEATURE_SETUP_WIZARD_FORCE_ACTIVATION.booleanValue();
        APP_BASE_LAYER_URI = Uri.parse("content://com.bytedanceos.appbaselayer");
        JSON_CONVERT = new Gson();
        ArrayList r1 = new ArrayList();
        OPEN_SYSTEM_APPS = r1;
        r1.add("com.android.calendar");
        r1.add("com.obric.recorder");
        r1.add(Constants.PKG_MUSIC);
        r1.add(Constants.PACKAGE_NOTES);
        r1.add(SmtPCUtils.PKG_CAMERA_2);
        r1.add("com.obric.filemanager");
        r1.add(APP_STORE_PACKAGE);
        r1.add("com.android.browser");
        r1.add("com.android.gallery3d");
        r1.add("com.obric.calculator");
        r1.add("com.obric.calendar");
        r1.add("com.obric.weather");
        r1.add("com.obric.clock");
        r1.add(com.android.settings.settingitemsprovider.Constants.CAMERA_PACKAGE);
        r1.add("com.android.contacts");
        r1.add("com.obric.compass");
        r1.add("com.obric.screenrecorder");
        r1.add("com.bytedance.android.doubaoime");
        r1.add("com.android.gallery3d");
        r1.add("com.android.inputmethod.latin");
        r1.add("com.ss.android.lark");
        r1.add("com.volcengine.corplink");
        r1.add("com.obric.browser");
        r1.add("com.larus.nova");
        r1.add("com.obric.aiagent.executionengine");
        r1.add(Constants.PKG_MMS);
        r1.add("com.obric.health");
        r1.add("com.zte.wallet");
        r1.add("com.zte.wallet.support");
        r1.add("com.zte.zdm");
        r1.add("com.android.camera");
        r1.add(AccessibilitySettingsFragment.EARTHQUAKE_WARNING_PACKAGE_NAME);
        r1.add("com.google.android.gms");
        if (ProductFlavor.isNeridaHk() == false) goto L5;
        r1.add("com.obric.account");
        r1.add("com.obric.cloudservice");
    L5:
        ArrayList r2 = new ArrayList();
        BATTERY_MANAGER_WHITELIST_APP = r2;
        r2.add("com.obric.calculator");
        r2.add("com.obric.calendar");
        r2.add("com.obric.recorder");
        r2.add("com.obric.weather");
        r2.add("com.obric.clock");
        r2.add(Constants.PACKAGE_NOTES);
        r2.add(com.android.settings.settingitemsprovider.Constants.CAMERA_PACKAGE);
        r2.add("com.android.contacts");
        r2.add("com.obric.filemanage");
        r2.add("com.obric.compass");
        r2.add("com.obric.screenrecorder");
        r2.add(APP_STORE_PACKAGE);
        r2.add("com.obric.browser");
        r2.add("com.android.gallery3d");
        ArrayList r3 = new ArrayList();
        FAKE_SYSTEM_APPS = r3;
        ArrayList r4 = new ArrayList();
        SYSTEM_COMPONENT_APPS = r4;
        r3.add("cn.wps.moffice.lite.smartison_large");
        r4.add(AppLockUtil.PACKAGE_NAME);
        LAUNCHER_THEME_CLASSIC_BLACK_ID = "bytedance_theme_black";
        StringBuilder r5 = new StringBuilder(50);
        sBuilder = r5;
        sFormatter = new Formatter(r5, Locale.getDefault());
        mSecurityFeature = null;
        mDoppelgangerAppArray = null;
        sLastClickTime = 0;
        sLastButtonId = -1;
    }

    public static boolean isOpenSystemApp(String r1) {
        return OPEN_SYSTEM_APPS.contains(r1);
    }

    public static boolean isBatteryManagerWhitelistApp(String r1) {
        return BATTERY_MANAGER_WHITELIST_APP.contains(r1);
    }

    public static boolean updatePreferenceToSpecificActivityOrRemove(Context r7, PreferenceGroup r8, String r9, int r10) {
        Preference r11 = r8.findPreference(r9);
        if (r11 != null) goto L5;
        return false;
    L5:
        Intent r1 = r11.getIntent();
        if (r1 == null) goto L16;
        PackageManager r12 = r7.getPackageManager();
        List<ResolveInfo> r2 = r12.queryIntentActivities(r1, 0);
        int r3 = r2.size();
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L16;
        ResolveInfo r5 = r2.get(r4);
        if ((r5.activityInfo.applicationInfo.flags & 1) != 0) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        r11.setIntent(new Intent().setClassName(r5.activityInfo.packageName, r5.activityInfo.name));
        if ((r10 & 1) == 0) goto L14;
        r11.setTitle(r5.loadLabel(r12));
    L14:
        return true;
    L16:
        r8.removePreference(r11);
        return false;
    }

    public static UserManager getUserManager(Context r1) {
        UserManager r2 = UserManager.get(r1);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("Unable to load UserManager");
    }

    public static boolean isMonkeyRunning() {
        return ActivityManager.isUserAMonkey();
    }

    public static void showShortToast(Context r0, String r1) {
        ToastUtils.show(r0, r1);
    }

    public static void showLongToast(Context r0, String r1) {
        ToastUtils.show(r0, r1);
    }

    public static boolean isVoiceCapable(Context r1) {
        TelephonyManager r2 = (TelephonyManager) r1.getSystemService(MultiSimAdapter.PHONE_KEY);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.isVoiceCapable() == false) goto L7;
        return true;
    }

    public static boolean isHeadsetConnected(Context r1) {
        AudioManager r2 = (AudioManager) r1.getSystemService("audio");
        if (r2.isWiredHeadsetOn() == false) goto L5;
    L8:
        return true;
    L5:
        if (r2.isBluetoothA2dpOn() == true) goto L8;
        return false;
    }

    public static boolean isWifiOnly(Context r1) {
        return !((ConnectivityManager) r1.getSystemService("connectivity")).isNetworkSupported(0);
    }

    public static boolean isNetworkAvailable(Context r1) {
        NetworkInfo r2 = ((ConnectivityManager) r1.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.isConnected() == false) goto L7;
        return true;
    }

    public static boolean isSimExists() {
        int r1 = MultiSimAdapter.getSimState(0);
        if (r1 == 1) goto L5;
        boolean r3 = true;
    L7:
        if (isMultiSimSupport() == false) goto L16;
        int r4 = MultiSimAdapter.getSimState(1);
        OLog.d("", "simState1:" + r1 + "   simState2:" + r4);
        if (r4 == 1) goto L11;
        boolean r2 = true;
    L12:
        if (r3 == true) goto L15;
        if (r2 == true) goto L15;
        return false;
    L15:
        return true;
    L11:
        r2 = false;
        goto L12
    L16:
        return r3;
    L5:
        r3 = false;
        goto L7
    }

    public static boolean isSoftsimEnabled(Context r0) {
        return Features.isFeatureSoftsimEnabled(r0);
    }

    public static boolean simExistsButUnknown() {
        int r1 = MultiSimAdapter.getSimState(0);
        if (isMultiSimSupport() == false) goto L10;
        int r2 = MultiSimAdapter.getSimState(1);
        OLog.d("", "simState1:" + r1 + "   simState2:" + r2);
        int r4 = r1 | r2;
        if (r4 == 0) goto L9;
        if (r4 != 1) goto L13;
        if (r1 != r2) goto L9;
        return false;
    L13:
        return false;
    L9:
        return true;
    L10:
        if (r1 == 0) goto L12;
        return false;
    L12:
        return true;
    }

    public static boolean isMultiSimSupport() {
        if (MultiSimAdapter.getPhoneCount() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean hasMultiSimInDevice() {
        if (MultiSimAdapter.isMultiSimEnabled() == true) goto L5;
        return false;
    L5:
        if (MultiSimAdapter.hasIccCard(0) == true) goto L7;
        return false;
    L7:
        if (MultiSimAdapter.hasIccCard(1) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public static boolean hasTelephonyFeature(Context r1) {
        if (r1 != null) goto L5;
        return false;
    L5:
        PackageManager r2 = r1.getPackageManager();
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.hasSystemFeature("android.hardware.telephony");
    }

    public static boolean isCmccVersion(Context r0) {
        return Features.isFeatureCMCCEnabled(r0).booleanValue();
    }

    public static boolean isNfcSupport(Context r2) {
        boolean r3 = r2.getPackageManager().hasSystemFeature("android.hardware.nfc");
        OLog.d(TAG, "hasNFCFeature " + r3);
        return r3;
    }

    public static boolean isWifiNetwork(Context r2) {
        if (r2 == null) goto L12;
        ConnectivityManager r3 = (ConnectivityManager) r2.getSystemService("connectivity");
        if (r3 == null) goto L13;
        NetworkInfo r4 = r3.getActiveNetworkInfo();
        if (r4 != null) goto L9;
        return false;
    L9:
        if (r4.getType() == 1) goto L11;
        return false;
    L11:
        return true;
    L13:
        return false;
    L12:
        return false;
    }

    public static boolean isWifiConnected(Context r1) {
        NetworkInfo r2 = ((ConnectivityManager) r1.getSystemService("connectivity")).getNetworkInfo(1);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.isConnected() == false) goto L7;
        return true;
    }

    public static boolean findSystemUpdatable(Context r2) {
        OTAUpdateManager.getInstance(r2);
        return PreferenceMgr.getInstance(r2).getBoolean(BytedanceEventReceiver.KEY_SHOW_OTA_UPDATABLE_BADGE, false);
    }

    public static void notifyEmailReceivedRingoneChange(Context r2, Uri r3) {
        OLog.d(TAG, "uri:" + r3);
        Intent r0 = new Intent("bytedance.action.EMAIL_RINGTONE_CHANGED");
        r0.putExtra("extra_email_received_ringtone_uri", r3);
        r2.sendBroadcast(r0);
    }

    public static boolean isPackageInstalledAndIsSystemApp(Context r1, String r2) {
        if (r2 != null) goto L11;
        return false;
    L11:
        if ((r1.getPackageManager().getPackageInfo(r2, 0).applicationInfo.flags & 1) != 0) goto L9;
        return false;
    L9:
        return true;
    L14:
        return false;
    }

    public static boolean isPackageInstalled(Context r2, String r3) {
        if (r3 != null) goto L11;
        return false;
    L11:
        PackageInfo r4 = r2.getPackageManager().getPackageInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L7
    L8:
        if (r4 == null) goto L13;
        return true;
    L13:
        return false;
    L7:
        OLog.w(TAG, "pkg:" + r3 + " not installed");
        r4 = null;
        goto L8
    }

    public static long getAvailableSize(File r4) {
        if (r4 != null) goto L5;
    L12:
        OLog.d(TAG, "getAvailableSize: invalid file " + r4);
        return 0;
    L5:
        if (r4.exists() == false) goto L12;
        return new StatFs(r4.getPath()).getAvailableBytes();
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static long getTotalSize(File r4) {
        if (r4 != null) goto L5;
    L12:
        OLog.d(TAG, "getTotalSize: invalid file " + r4);
        return 0;
    L5:
        if (r4.exists() == false) goto L12;
        return new StatFs(r4.getPath()).getTotalBytes();
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static String formatSize(Context r0, long r1) {
        return android.text.format.Formatter.formatFileSize(r0, r1).replace('k', 'K');
    }

    public static String formatFileSize(Context r5, long r6) {
        if (r5 != null) goto L5;
        return "";
    L5:
        float r7 = r6;
        if (r7 <= 1024.0f) goto L8;
        r7 = r7 / 1024.0f;
        int r1 = R.string.kilobyteShort;
    L10:
        if (r7 <= 1024.0f) goto L13;
        r7 = r7 / 1024.0f;
        r1 = R.string.megabyteShort;
    L13:
        if (r7 <= 1024.0f) goto L16;
        r7 = r7 / 1024.0f;
        r1 = R.string.gigabyteShort;
    L16:
        if (r7 <= 1024.0f) goto L19;
        r7 = r7 / 1024.0f;
        r1 = R.string.terabyteShort;
    L19:
        if (r7 <= 1024.0f) goto L21;
        r7 = r7 / 1024.0f;
        r1 = R.string.petabyteShort;
    L21:
        String r8 = String.format("%.1f", new Object[]{Float.valueOf(r7)});
        if (r8 == null) goto L27;
        if (r8.endsWith(".0") == false) goto L27;
        r8 = r8.replace(".0", "");
    L27:
        return r5.getResources().getString(R.string.fileSizeSuffix, new Object[]{r8, r5.getString(r1)});
    L8:
        r1 = R.string.byteShort;
        goto L10
    }

    public static String getFileMD5(File r7) {
        if (r7.exists() == true) goto L5;
    L17:
        return null;
    L5:
        if (r7.isFile() == false) goto L17;
        byte[] r2 = new byte[1024];
        MessageDigest r3 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L15
        FileInputStream r4 = new FileInputStream(r7);     // Catch: Exception -> L15
    L9:
        int r5 = r4.read(r2, 0, 1024);     // Catch: Exception -> L15
        if (r5 == (-1)) goto L12;
        r3.update(r2, 0, r5);     // Catch: Exception -> L15
        goto L9
    L12:
        r4.close();     // Catch: Exception -> L15
        return new BigInteger(1, r3.digest()).toString(16);
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static String getFileMD5(String r1) {
        return getFileMD5(new File(r1));
    }

    public static String getWifiIpAddresses(Context r1) {
        return formatIpAddresses(((ConnectivityManager) r1.getSystemService("connectivity")).getLinkProperties(1));
    }

    public static String getDefaultIpAddresses(ConnectivityManager r0) {
        return formatIpAddresses(r0.getActiveLinkProperties());
    }

    private static String formatIpAddresses(LinkProperties r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Iterator r3 = r2.getAllAddresses().iterator();
        if (r3.hasNext() == true) goto L8;
        return null;
    L8:
        String r0 = "";
    L10:
        if (r3.hasNext() == false) goto L14;
        r0 = r0 + ((InetAddress) r3.next()).getHostAddress();
        if (r3.hasNext() == false) goto L10;
        r0 = r0 + "\n";
        goto L10
    L14:
        return r0;
    }

    public static Locale createLocaleFromString(String r4) {
        if (r4 == null) goto L4;
        String[] r5 = r4.split("_", 3);
        if (1 != r5.length) goto L10;
        return new Locale(r5[0]);
    L10:
        if (2 != r5.length) goto L14;
        return new Locale(r5[0], r5[1]);
    L14:
        return new Locale(r5[0], r5[1], r5[2]);
    L4:
        return Locale.getDefault();
    }

    public static boolean isBatteryPresent(Intent r2) {
        return r2.getBooleanExtra("present", true);
    }

    public static String getBatteryPercentage(Intent r0) {
        return formatPercentage(getBatteryLevel(r0));
    }

    public static void forcePrepareCustomPreferencesList(ViewGroup r1, View r2, ListView r3, boolean r4) {
        r3.setScrollBarStyle(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        r3.setClipToPadding(false);
        prepareCustomPreferencesList(r1, r2, r3, r4);
    }

    public static void prepareCustomPreferencesList(ViewGroup r5, View r6, View r7, boolean r8) {
        if (r7.getScrollBarStyle() != 33554432) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        Resources r1 = r7.getResources();
        int r2 = r1.getDimensionPixelSize(R.dimen.settings_side_margin);
        int r3 = r1.getDimensionPixelSize(17106087);
        if ((r5 instanceof PreferenceFrameLayout) == false) goto L13;
        r6.getLayoutParams().removeBorders = true;
        if (r8 == false) goto L12;
        r2 = 0;
    L12:
        r7.setPaddingRelative(r2, 0, r2, r3);
        return;
    L13:
        r7.setPaddingRelative(r2, 0, r2, r3);
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void forceCustomPadding(View r4, boolean r5) {
        Resources r0 = r4.getResources();
        int r1 = r0.getDimensionPixelSize(R.dimen.settings_side_margin);
        if (r5 == false) goto L5;
        int r3 = r4.getPaddingStart();
    L6:
        int r6 = r3 + r1;
        if (r5 == false) goto L9;
        int r7 = r4.getPaddingEnd();
    L10:
        r4.setPaddingRelative(r6, 0, r1 + r7, r0.getDimensionPixelSize(17106087));
        return;
    L9:
        r7 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public static void copyMeProfilePhoto(Context r3, UserInfo r4) {
        Uri r0 = ContactsContract.Profile.CONTENT_URI;
        if (r4 == null) goto L5;
        int r5 = r4.id;
    L6:
        InputStream r1 = ContactsContract.Contacts.openContactPhotoInputStream(r3.getContentResolver(), r0, true);
        if (r1 != null) goto L10;
        assignDefaultPhoto(r3, r5);
        return;
    L10:
        ((UserManager) r3.getSystemService(PickApplicationActivity.EXTRA_USER)).setUserIcon(r5, BitmapFactory.decodeStream(r1));
        r1.close();     // Catch: IOException -> L13
        return;
    L16:
        return;
    L5:
        r5 = UserHandle.myUserId();
        goto L6
    }

    public static void assignDefaultPhoto(Context r1, int r2) {
        ((UserManager) NullSafe.nonNull(r1.getSystemService(PickApplicationActivity.EXTRA_USER))).setUserIcon(r2, getDefaultUserIconAsBitmap(r2));
    }

    public static String getMeProfileName(Context r0, boolean r1) {
        if (r1 == false) goto L6;
        return getProfileDisplayName(r0);
    L6:
        return getShorterNameIfPossible(r0);
    }

    private static String getShorterNameIfPossible(Context r2) {
        String r0 = getLocalProfileGivenName(r2);
        if (TextUtils.isEmpty(r0) == true) goto L6;
        return r0;
    L6:
        return getProfileDisplayName(r2);
    }

    private static String getLocalProfileGivenName(Context r10) {
        ContentResolver r11 = r10.getContentResolver();
        Cursor r0 = r11.query(ContactsContract.Profile.CONTENT_RAW_CONTACTS_URI, new String[]{"_id"}, "account_type IS NULL AND account_name IS NULL", null, null);
        if (r0 != null) goto L29;
        return null;
    L29:
    L26:
        th = move-exception;
        r0.close();
        throw th;
    L6:
        if (r0.moveToFirst() == true) goto L10;
        r0.close();
        return null;
    L10:
        long r1 = r0.getLong(0);     // Catch: Throwable -> L26
        r0.close();
        Cursor r12 = r11.query(ContactsContract.Profile.CONTENT_URI.buildUpon().appendPath("data").build(), new String[]{DBHelper.COL_DATA2, DBHelper.COL_DATA3}, "raw_contact_id=" + r1, null, null);
        if (r12 != null) goto L31;
        return null;
    L31:
    L23:
        th = move-exception;
        r12.close();
        throw th;
    L15:
        if (r12.moveToFirst() == true) goto L18;
        r12.close();
        return null;
    L18:
        String r2 = r12.getString(0);     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r2) == false) goto L21;
        r2 = r12.getString(1);     // Catch: Throwable -> L23
    L21:
        r12.close();
        return r2;
    }

    private static final String getProfileDisplayName(Context r6) {
        Cursor r7 = r6.getContentResolver().query(ContactsContract.Profile.CONTENT_URI, new String[]{"display_name"}, null, null, null);
        if (r7 != null) goto L16;
        return null;
    L16:
    L13:
        th = move-exception;
        r7.close();
        throw th;
    L6:
        if (r7.moveToFirst() == true) goto L10;
        r7.close();
        return null;
    L10:
        String r0 = r7.getString(0);     // Catch: Throwable -> L13
        r7.close();
        return r0;
    }

    public static Dialog buildGlobalChangeWarningDialog(Context r1, int r2, final Runnable r3) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(r1);
        r0.setTitle(r2);
        r0.setMessage(R.string.global_change_warning);
        r0.setPositiveButton(android.R.string.ok, new AnonymousClass1(r3));
        r0.setNegativeButton(android.R.string.cancel, null);
        return r0.create();
    }

    public static boolean hasMultipleUsers(Context r1) {
        if (((UserManager) r1.getSystemService(PickApplicationActivity.EXTRA_USER)).getUsers().size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void startWithFragment(Context r8, String r9, Bundle r10, Fragment r11, int r12, int r13, CharSequence r14) {
        startWithFragment(r8, r9, r10, r11, r12, r13, r14, false);
    }

    public static void startWithFragment(Context r7, String r8, Bundle r9, Fragment r10, int r11, int r12, CharSequence r13, boolean r14) {
        Intent r15 = onBuildStartFragmentIntent(r7, r8, r9, null, r12, r13, r14);
        if (r10 != null) goto L5;
        r7.startActivity(r15);
        return;
    L5:
        r10.startActivityForResult(r15, r11);
    }

    public static void startWithFragmentAsUser(Context r14, String r15, Bundle r16, int r17, CharSequence r18, boolean r19, UserHandle r20) {
        if (r20.getIdentifier() != UserHandle.myUserId()) goto L5;
        startWithFragment(r14, r15, r16, null, 0, r17, r18, r19);
        return;
    L5:
        Intent r0 = onBuildStartFragmentIntent(r14, r15, r16, null, r17, r18, r19);
        r0.addFlags(268435456);
        r0.addFlags(32768);
        r14.startActivityAsUser(r0, r20);
    }

    public static void startWithFragmentAsUser(Context r2, String r3, Bundle r4, String r5, int r6, CharSequence r7, boolean r8, UserHandle r9) {
        if (r9.getIdentifier() == UserHandle.myUserId()) goto L7;
        Intent r10 = onBuildStartFragmentIntent(r2, r3, r4, r5, r6, r7, r8);
        r10.addFlags(268435456);
        r10.addFlags(32768);
        r2.startActivityAsUser(r10, r9);
        return;
    }

    public static Intent onBuildStartFragmentIntent(Context r3, String r4, Bundle r5, String r6, int r7, CharSequence r8, boolean r9) {
        Intent r0 = new Intent("android.intent.action.MAIN");
        if (BluetoothSettings.class.getName().equals(r4) == false) goto L5;
        r0.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT_AS_SUBSETTING, true);
    L6:
        r0.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT, r4);
        r0.putExtra(":settings:show_fragment_args", r5);
        r0.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT_TITLE_RES_PACKAGE_NAME, r6);
        r0.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT_TITLE_RESID, r7);
        r0.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT_TITLE, r8);
        r0.putExtra(SettingsActivity.EXTRA_SHOW_FRAGMENT_AS_SHORTCUT, r9);
        if ((r3 instanceof BaseActivity) == false) goto L9;
        CharSequence r10 = ((BaseActivity) r3).getTitleName();
    L10:
        if (r10 == null) goto L12;
    L14:
        if (r10 == null) goto L16;
        r0.putExtra("back_text", r10);
    L16:
        return r0;
    L12:
        if ((r3 instanceof Activity) == false) goto L14;
        r10 = ((Activity) r3).getTitle();
        goto L14
    L9:
        r10 = null;
        goto L10
    L5:
        r0.setClass(r3, SubSettings.class);
        goto L6
    }

    public static UserHandle getManagedProfile(UserManager r6) {
        List<UserHandle> r0 = r6.getUserProfiles();
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        UserHandle r3 = r0.get(r2);
        if (r3.getIdentifier() == r6.getUserHandle()) goto L10;
        if (r6.getUserInfo(r3.getIdentifier()).isManagedProfile() == false) goto L10;
        return r3;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return null;
    }

    public static boolean isManagedProfile(UserManager r1) {
        return isManagedProfile(r1, UserHandle.myUserId());
    }

    public static int getManagedProfileId(UserManager r3, int r4) {
        int[] r5 = r3.getProfileIdsWithDisabled(r4);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r5[r1];
        if (r2 != r4) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return -10000;
    }

    public static boolean isManagedProfile(UserManager r0, int r1) {
        if (r0 == null) goto L9;
        UserInfo r2 = r0.getUserInfo(r1);
        if (r2 != null) goto L10;
        return false;
    L10:
        return r2.isManagedProfile();
    L9:
        throw new IllegalArgumentException("userManager must not be null");
    }

    public static UserHandle getSecureTargetUser(IBinder r4, UserManager r5, Bundle r6, Bundle r7) {
        UserHandle r0 = new UserHandle(UserHandle.myUserId());
        IActivityManager r1 = ActivityManagerNative.getDefault();
        boolean r2 = "com.android.settings".equals(r1.getLaunchedFromPackage(r4));     // Catch: RemoteException -> L28
        UserHandle r3 = new UserHandle(UserHandle.getUserId(r1.getLaunchedFromUid(r4)));     // Catch: RemoteException -> L28
        if (r3.equals(r0) == false) goto L6;
    L8:
        UserHandle r8 = null;
        if (r7 == null) goto L11;
        UserHandle r9 = (UserHandle) r7.getParcelable("android.intent.extra.USER");     // Catch: RemoteException -> L28
    L12:
        if (r9 != null) goto L14;
    L19:
        if (r6 == null) goto L21;
        r8 = (UserHandle) r6.getParcelable("android.intent.extra.USER");     // Catch: RemoteException -> L28
    L21:
        if (r8 != null) goto L23;
    L30:
        return r0;
    L23:
        if (r8.equals(r0) == true) goto L30;
        if (r2 == false) goto L30;
        if (isProfileOf(r5, r8) == false) goto L30;
        return r8;
    L14:
        if (r9.equals(r0) == true) goto L19;
        if (r2 == false) goto L19;
        if (isProfileOf(r5, r9) == false) goto L19;
        return r9;
    L11:
        r9 = null;
        goto L12
    L6:
        if (isProfileOf(r5, r3) == false) goto L8;
        return r3;
    L28:
        e = move-exception;
        OLog.v(TAG, "Could not talk to activity manager.", e);
        goto L30
    }

    public static UserHandle getInsecureTargetUser(IBinder r4, Bundle r5, Bundle r6) {
        UserHandle r0 = new UserHandle(UserHandle.myUserId());
        UserHandle r3 = new UserHandle(UserHandle.getUserId(ActivityManagerNative.getDefault().getLaunchedFromUid(r4)));     // Catch: RemoteException -> L22
        if (r3.equals(r0) == true) goto L7;
        return r3;
    L7:
        if (r6 == null) goto L9;
        UserHandle r7 = (UserHandle) r6.getParcelable("android.intent.extra.USER");     // Catch: RemoteException -> L22
    L10:
        if (r7 != null) goto L12;
    L14:
        if (r5 == null) goto L16;
        UserHandle r8 = (UserHandle) r5.getParcelable("android.intent.extra.USER");     // Catch: RemoteException -> L22
    L17:
        if (r8 == null) goto L21;
        if (r8.equals(r0) == true) goto L21;
        return r8;
    L21:
        return r0;
    L16:
        r8 = null;
        goto L17
    L12:
        if (r7.equals(r0) == true) goto L14;
        return r7;
    L9:
        r7 = null;
    L22:
        e = move-exception;
        OLog.v(TAG, "Could not talk to activity manager.", e);
        return null;
    }

    private static boolean isProfileOf(UserManager r3, UserHandle r4) {
        if (r3 == null) goto L12;
        if (r4 != null) goto L7;
        return false;
    L7:
        if (UserHandle.myUserId() != r4.getIdentifier()) goto L9;
    L10:
        return true;
    L9:
        if (r3.getUserProfiles().contains(r4) == true) goto L10;
        return false;
    L12:
        return false;
    }

    static boolean isOemUnlockEnabled(Context r1) {
        return ((PersistentDataBlockManager) r1.getSystemService("persistent_data_block")).getOemUnlockEnabled();
    }

    static void setOemUnlockEnabled(Context r1, boolean r2) {
        ((PersistentDataBlockManager) r1.getSystemService("persistent_data_block")).setOemUnlockEnabled(r2);
    }

    public static boolean showSimCardTile(Context r1) {
        if (((TelephonyManager) r1.getSystemService(MultiSimAdapter.PHONE_KEY)).getSimCount() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean showAccount(Context r5, String r6) {
        String[] r7 = r5.getResources().getStringArray(R.array.hide_account_list);
        if (r7 != null) goto L5;
    L13:
        return true;
    L5:
        if (r7.length == 0) goto L13;
        int r1 = r7.length;
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L13;
        if (r7[r3].equals(r6) == true) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return false;
    }

    public static boolean isSystemPackage(Context r1, String r2) {
        if ((r1.getPackageManager().getPackageInfo(r2, 0).applicationInfo.flags & 129) != 0) goto L13;
        return false;
    L13:
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean isSystemPackageOrSystemProcess(Context r1, String r2) {
        PackageInfo r3 = r1.getPackageManager().getPackageInfo(r2, 0);     // Catch: PackageManager.NameNotFoundException -> L9
        if ((r3.applicationInfo.flags & 129) != 0) goto L15;
        if (r3.applicationInfo.uid <= 10000) goto L15;
        return false;
    L15:
        return true;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean isSystemPackage(ApplicationInfo r0) {
        if ((r0.flags & 129) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static String formatElapsedTime(Context r7, double r8, boolean r10) {
        StringBuilder r0 = new StringBuilder();
        int r9 = (int) Math.floor(r8 / 1000.0d);
        if (r10 == true) goto L6;
        r9 = r9 + 30;
    L6:
        if (r9 < 86400) goto L8;
        int r2 = r9 / 86400;
        r9 = r9 - (86400 * r2);
    L10:
        if (r9 < 3600) goto L12;
        int r11 = r9 / 3600;
        r9 = r9 - (r11 * 3600);
    L14:
        if (r9 < 60) goto L16;
        int r3 = r9 / 60;
        r9 = r9 - (r3 * 60);
    L18:
        if (r10 == false) goto L26;
        if (r2 <= 0) goto L21;
        r0.append(r7.getString(R.string.battery_history_days, new Object[]{Integer.valueOf(r2), Integer.valueOf(r11), Integer.valueOf(r3), Integer.valueOf(r9)}));
    L32:
        return r0.toString();
    L21:
        if (r11 <= 0) goto L23;
        r0.append(r7.getString(R.string.battery_history_hours, new Object[]{Integer.valueOf(r11), Integer.valueOf(r3), Integer.valueOf(r9)}));
        goto L32
    L23:
        if (r3 <= 0) goto L25;
        r0.append(r7.getString(R.string.battery_history_minutes, new Object[]{Integer.valueOf(r3), Integer.valueOf(r9)}));
        goto L32
    L25:
        r0.append(r7.getString(R.string.battery_history_seconds, new Object[]{Integer.valueOf(r9)}));
        goto L32
    L26:
        if (r2 <= 0) goto L28;
        r0.append(r7.getString(R.string.battery_history_days_no_seconds, new Object[]{Integer.valueOf(r2), Integer.valueOf(r11), Integer.valueOf(r3)}));
        goto L32
    L28:
        if (r11 <= 0) goto L30;
        r0.append(r7.getString(R.string.battery_history_hours_no_seconds, new Object[]{Integer.valueOf(r11), Integer.valueOf(r3)}));
        goto L32
    L30:
        r0.append(r7.getString(R.string.battery_history_minutes_no_seconds, new Object[]{Integer.valueOf(r3)}));
        goto L32
    L16:
        r3 = 0;
        goto L18
    L12:
        r11 = 0;
        goto L14
    L8:
        r2 = 0;
        goto L10
    }

    public static boolean isOriginalLauncher(Context r0) {
        if (getCurrentLauncherMode(r0) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isBytedanceLauncher(Context r1) {
        return "com.bytedanceos.launcher".equals(getDefaultLauncherPkg(r1));
    }

    public static boolean isUseStrictLockScreen(Context r4) {
        boolean r2 = false;
        if (android.provider.Settings.Global.getInt(r4.getContentResolver(), "use_fingerprint_in_lockscreen", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r0;
    L8:
        if (SettingsFeature.isFaceRecognitionEnable() == true) goto L10;
        return r0;
    L10:
        if (android.provider.Settings.Global.getInt(r4.getContentResolver(), "faceid_enable", 0) != 1) goto L13;
        r2 = true;
    L13:
        return r2;
    L5:
        r0 = false;
        goto L6
    }

    public static boolean hasTrustedAP(Context r2) {
        List<WifiConfiguration> r3 = ((WifiManager) r2.getApplicationContext().getSystemService("wifi")).getConfiguredNetworks();     // Catch: RuntimeException -> L5
    L8:
        if (r3 != null) goto L10;
        return false;
    L10:
        Iterator<WifiConfiguration> r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L22;
        if (WifiConfigurationSmtOnly.get_isTrustedAp(r4.next()) == false) goto L12;
        return true;
    L22:
        return false;
    L5:
        e = move-exception;
        e.printStackTrace();
        r3 = null;
        goto L8
    }

    public static String getDeviceColor() {
        return Features.getDeviceColor();
    }

    public static boolean isVisiableCoverCaribrationItem() {
        if (SettingsFeature.isCoverCaribrationSupport() == true) goto L5;
    L7:
        return false;
    L5:
        if (shouldDisplayTheme() == false) goto L7;
        return true;
    }

    public static View inflateListTransparentHeader(Context r3) {
        View r0 = LayoutInflater.from(r3).inflate(R.layout.settings_list_header_footer_view, null);
        r0.setMinimumHeight(r3.getResources().getDimensionPixelSize(R.dimen.list_item_vertical_gap));
        return r0;
    }

    public static View inflateListTransparentHeader(Context r1, ViewGroup r2, boolean r3) {
        return LayoutInflater.from(r1).inflate(R.layout.settings_list_header_view, r2, false);
    }

    public static View inflateListTransparentFooter(Context r1, ViewGroup r2, boolean r3) {
        return LayoutInflater.from(r1).inflate(R.layout.settings_list_header_footer_view, r2, r3);
    }

    public static View inflateListTransparentFooterWithExtra(Context r1, ViewGroup r2, boolean r3) {
        return LayoutInflater.from(r1).inflate(R.layout.settings_list_header_footer_with_exta_view, r2, r3);
    }

    public static View inflateGapView(ViewGroup r3) {
        return LayoutInflater.from(r3.getContext()).inflate(R.layout.item_sub_settings_padding_layout, r3, false);
    }

    public static View inflateGapView2(ViewGroup r3) {
        return LayoutInflater.from(r3.getContext()).inflate(R.layout.item_sub_settings_padding_layout2, r3, false);
    }

    public static View inflateListTransparentFooterOnlyExtra(Context r1, ViewGroup r2, boolean r3) {
        return LayoutInflater.from(r1).inflate(R.layout.extra_view_layout, r2, false);
    }

    public static View inflateListViewHeaderTitle(Context r2, int r3) {
        View r4 = LayoutInflater.from(r2).inflate(R.layout.header_text_layout, null);
        ((TextView) r4.findViewById(R.id.header_text)).setText(r3);
        return r4;
    }

    public static void showSoftInputMethod(Context r2, EditText r3) {
        if (r3 == null) goto L4;
        r3.requestFocus();
    L4:
        InputMethodManager r4 = (InputMethodManager) r2.getApplicationContext().getSystemService("input_method");
        if (r4.showSoftInput(r3, 1) == true) goto L9;
        if (r3 == null) goto L10;
        r4.checkFocus();
        OLog.w(TAG, "Fail to showSoftInput,=" + r4.showSoftInput(r3, 1));
        return;
    L10:
        return;
    }

    public static void hideInputMethod(Activity r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getWindow().getDecorView() == null) goto L12;
        IBinder r0 = r2.getWindow().getDecorView().getWindowToken();
        if (r0 == null) goto L11;
        ((InputMethodManager) r2.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(r0, 0);
        return;
    L11:
        return;
    }

    public static float caculateTextWidth(TextView r2) {
        Paint r0 = new Paint();
        r0.setTextSize(r2.getTextSize());
        if (r2.getText() != null) goto L7;
        return 0.0f;
    L7:
        return r0.measureText(r2.getText().toString());
    }

    public static void setMaxTextSizeForTextView(TextView r1, float r2) {
        if (r1 == null) goto L5;
        TextViewSmt.getInstance().setMaxTextSize(r1, r2);
        return;
    }

    public static void resetTextViewFontSizeAttr(Context r2, TextView r3, int r4) {
        TextViewSmt.getInstance().setMaxTextSize(r3, Float.MAX_VALUE);
        r3.setTextSize(0, r2.getResources().getDimensionPixelSize(r4));
    }

    public static boolean isTextEllipsized(TextView r2) {
        Layout r3 = r2.getLayout();
        if (r3 == null) goto L9;
        int r0 = r3.getLineCount();
        if (r0 > 0) goto L7;
        return false;
    L7:
        if (r3.getEllipsisCount(r0 - 1) <= 0) goto L12;
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    public static Bitmap resizeAppIcon(Bitmap r7) {
        int r3 = r7.getWidth();
        int r4 = r7.getHeight();
        float r0 = ICON_SIZE_NORMAL / r3;
        Matrix r5 = new Matrix();
        r5.postScale(r0, r0);
        return Bitmap.createBitmap(r7, 0, 0, r3, r4, r5, true);
    }

    public static Bitmap resizeWallpaper(Bitmap r7, int r8) {
        if (r7 != null) goto L5;
        return null;
    L5:
        int r3 = r7.getWidth();
        int r4 = r7.getHeight();
        float r9 = r8 / r3;
        Matrix r5 = new Matrix();
        r5.postScale(r9, r9);
        return Bitmap.createBitmap(r7, 0, 0, r3, r4, r5, true);
    }

    public static Bitmap resizeWallpaper(Bitmap r7, int r8, int r9) {
        int r3 = r7.getWidth();
        int r4 = r7.getHeight();
        Matrix r5 = new Matrix();
        r5.postScale(r8 / r3, r9 / r4);
        return Bitmap.createBitmap(r7, 0, 0, r3, r4, r5, true);
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap r7) {
        Bitmap r0 = Bitmap.createBitmap(r7.getWidth(), r7.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        Paint r2 = new Paint();
        Rect r3 = new Rect(0, 0, r7.getWidth(), r7.getHeight());
        RectF r4 = new RectF(r3);
        r2.setAntiAlias(true);
        r1.drawARGB(0, 0, 0, 0);
        r2.setColor(-12434878);
        r1.drawRoundRect(r4, 3.0f, 3.0f, r2);
        r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r1.drawBitmap(r7, r3, r3, r2);
        return r0;
    }

    public static final int dp2Pixels(Context r0, float r1) {
        return (int) ((r1 * r0.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getIndexOfValue(float r3, String[] r4) {
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L9;
        if (Float.valueOf(r4[r1]).floatValue() == r3) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return 0;
    }

    public static void launchOptionsActivity(Activity r0, OptionsInfo r1, String r2, String r3, int r4) {
        r0.startActivity(getOptionsActivityIntent(r0, r1, r2, r3, r4));
        TransitionAnimHelper.overrideEnterAnim(r0, TransitionAnimStyle.Standard);
    }

    public static Intent getOptionsActivityIntent(Context r2, OptionsInfo r3, String r4, String r5, int r6) {
        Intent r0 = new Intent(r2, Settings.OptionsActivity.class);
        Bundle r7 = new Bundle();
        r7.putParcelable("extra_option_info", r3);
        r7.putString("extra_current_value", r4);
        r7.putString("title", r5);
        r7.putInt("back_text_id", r6);
        r0.putExtras(r7);
        return r0;
    }

    public static void launchOptionsActivity(Fragment r2, String[] r3, int r4, String r5, String r6, int r7, boolean r8) {
        Bundle r0 = new Bundle();
        r0.putInt("extra_index", r4);
        r0.putStringArray("extra_options", r3);
        r0.putBoolean("extra_auto_finish", true);
        r0.putString("title", r5);
        r0.putString("back_text", r6);
        if (r8 == false) goto L5;
        r0.putBoolean(BaseActivity.EXTRA_FROM_SECURITY, true);
    L5:
        Intent r9 = new Intent(r2.getActivity(), Settings.OptionsActivity.class);
        r9.putExtras(r0);
        r2.startActivityForResult(r9, r7);
        TransitionAnimHelper.overrideEnterAnim(r2.getActivity(), TransitionAnimStyle.Standard);
    }

    public static void launchOptionsActivity(BaseFragment r2, OptionsInfo r3, String r4, String r5, int r6, boolean r7) {
        Bundle r0 = new Bundle();
        r0.putParcelable("extra_option_info", r3);
        r0.putString("extra_current_value", r4);
        r0.putString("title", r5);
        r0.putInt("back_text_id", r6);
        r0.putBoolean("extra_auto_finish", r7);
        OptionsFragment r8 = new OptionsFragment();
        r8.setArguments(r0);
        r2.start(r8);
    }

    public static void startActivity(Context r1, Intent r2) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if ((r1 instanceof Activity) == false) goto L5;
        startActivity((Activity) r1, r2);     // Catch: ActivityNotFoundException -> L7
    L10:
        return;
    L5:
        r1.startActivity(r2);     // Catch: ActivityNotFoundException -> L7
        goto L10
    }

    public static void startActivity(Activity r1, Intent r2) {
    L7:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "startActivity err=" + e, e);
        return;
    L3:
        if (WizardManagerHelper.isAnySetupWizard(r2) == false) goto L5;
        WizardManagerHelper.copyWizardManagerExtras(r1.getIntent(), r2);     // Catch: ActivityNotFoundException -> L7
    L5:
        r1.startActivity(r2);     // Catch: ActivityNotFoundException -> L7
        TransitionAnimHelper.overrideEnterAnim(r1, TransitionAnimStyle.Standard);     // Catch: ActivityNotFoundException -> L7
    }

    public static void startActivityForResult(Activity r0, Intent r1, int r2) {
        r0.startActivityForResult(r1, r2);     // Catch: ActivityNotFoundException -> L4
        TransitionAnimHelper.overrideEnterAnim(r0, TransitionAnimStyle.Standard);     // Catch: ActivityNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "startActivityForResult err=" + e);
    }

    public static void startActivity(Context r1, Intent r2, int r3) {
        startActivity(r1, r2, r3, -1);
    }

    public static void startActivityForResult(Context r0, Intent r1, int r2, int r3) {
        startActivity(r0, r1, r2, r3);
    }

    public static void startActivity(Fragment r1, Intent r2, int r3) {
        startActivity(r1, r2, 0, r3);
    }

    public static void startActivity(Context r1, Intent r2, int r3, int r4) {
        startActivityWithFailCallBack(r1, r2, r3, r4, null);
    }

    public static void startActivityWithFailCallBack(Context r2, Intent r3, int r4, int r5, StartActivityFailCallBack r6) {
        r3.putExtra(Constants.EXTRA_OUTER, false);
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L16;
        if (r4 == 2) goto L20;
        if (r4 == 3) goto L12;
        return;
    L12:
        if ((r2 instanceof Activity) == false) goto L14;
        ((Activity) r2).startActivityForResult(r3, r5);     // Catch: ActivityNotFoundException -> L27
        TransitionAnimHelper.overrideEnterAnim((Activity) r2, TransitionAnimStyle.Modal);     // Catch: ActivityNotFoundException -> L27
    L32:
        return;
    L14:
        r2.startActivity(r3);     // Catch: ActivityNotFoundException -> L27
        goto L32
    L16:
        if ((r2 instanceof Activity) == false) goto L18;
        ((Activity) r2).startActivityForResult(r3, r5);     // Catch: ActivityNotFoundException -> L27
        ((Activity) r2).overridePendingTransition(0, 0);     // Catch: ActivityNotFoundException -> L27
        goto L32
    L18:
        r2.startActivity(r3);     // Catch: ActivityNotFoundException -> L27
    L20:
        if ((r2 instanceof Activity) == false) goto L25;
        ((Activity) r2).startActivityForResult(r3, r5);     // Catch: ActivityNotFoundException -> L27
        if (isSetupCompelete(r2) == false) goto L24;
        TransitionAnimHelper.overrideEnterAnim((Activity) r2, TransitionAnimStyle.Standard);     // Catch: ActivityNotFoundException -> L27
        goto L32
    L24:
        RoutingUtils.overrideStarting((Activity) r2);     // Catch: ActivityNotFoundException -> L27
        goto L32
    L25:
        r2.startActivity(r3);     // Catch: ActivityNotFoundException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        if (r6 == null) goto L36;
        r6.onFailed();
        return;
    }

    public static void startActivity(Fragment r1, Intent r2, int r3, int r4) {
        if (r3 != 0) goto L4;
    L17:
        if (r4 <= 0) goto L19;
        r1.startActivityForResult(r2, r4);     // Catch: ActivityNotFoundException -> L25
    L21:
        if (isSetupCompelete(r1.getActivity()) == false) goto L23;
        TransitionAnimHelper.overrideEnterAnim(r1.getActivity(), TransitionAnimStyle.Standard);     // Catch: ActivityNotFoundException -> L25
        return;
    L23:
        RoutingUtils.overrideStarting(r1.getActivity());     // Catch: ActivityNotFoundException -> L25
        return;
    L19:
        r1.startActivity(r2);     // Catch: ActivityNotFoundException -> L25
        goto L21
    L4:
        if (r3 == 1) goto L14;
        if (r3 == 2) goto L17;
        if (r3 != 3) goto L34;
        if (r4 <= 0) goto L12;
        r1.startActivityForResult(r2, r4);     // Catch: ActivityNotFoundException -> L25
        TransitionAnimHelper.overrideEnterAnim(r1.getActivity(), TransitionAnimStyle.Modal);     // Catch: ActivityNotFoundException -> L25
        return;
    L12:
        r1.startActivity(r2);     // Catch: ActivityNotFoundException -> L25
        TransitionAnimHelper.overrideEnterAnim(r1.getActivity(), TransitionAnimStyle.Modal);     // Catch: ActivityNotFoundException -> L25
        return;
    L34:
        return;
    L14:
        if (r4 <= 0) goto L16;
        r1.startActivityForResult(r2, r4);     // Catch: ActivityNotFoundException -> L25
        r1.getActivity().overridePendingTransition(0, 0);     // Catch: ActivityNotFoundException -> L25
        return;
    L16:
        r1.startActivity(r2);     // Catch: ActivityNotFoundException -> L25
        r1.getActivity().overridePendingTransition(0, 0);     // Catch: ActivityNotFoundException -> L25
        return;
    L25:
        e = move-exception;
        e.printStackTrace();
    }

    public static String getDeviceName(Context r0) {
        return DeviceUtils.INSTANCE.getDeviceName();
    }

    public static String getDeviceNameReal(Context r2) {
        String r0 = android.provider.Settings.Global.getString(r2.getContentResolver(), "device_name");
        if (r0 != null) goto L11;
        String r1 = android.provider.Settings.Global.getString(r2.getContentResolver(), "device_owner");
        if (r1 != null) goto L7;
    L9:
        return "";
    L7:
        if (r1.length() <= 0) goto L9;
        return r1 + getAuxiliaryWord(r2, r1);
    L11:
        return r0;
    }

    private static String getAuxiliaryWord(Context r2, String r3) {
        String r0 = r2.getResources().getString(R.string.device_name_auxiliary_word);
        if (String.valueOf(r3.charAt(r3.length() - 1)).matches("[\\u4e00-\\u9fa5]") == false) goto L5;
        return r0;
    L5:
        return r2.getResources().getString(R.string.device_name_auxiliary_word_with_space);
    }

    public static void lockUserTooFastAction(final View r3, int r4) {
        if (r3.isClickable() == false) goto L6;
        r3.setClickable(false);
        r3.postDelayed(new AnonymousClass2(r3), r4);
        return;
    }

    public static Drawable optLauncherThemeThumbnail(Context r12) {
        String r0 = "com.bytedanceos.launcher";
        if (r12 != null) goto L5;
        return null;
    L5:
        String r2 = android.provider.Settings.Global.getString(r12.getContentResolver(), "launcher_theme");
        int r3 = getCurrentLauncherMode(r12);
        if (r3 != 16) goto L8;
    L11:
        String r4 = "thumbnail_settings_16";
    L40:
        PackageManager r13 = r12.getPackageManager();     // Catch: Exception -> L37
        if (LAUNCHER_THEME_CLASSIC_BLACK_ID.equals(r2) == false) goto L16;
        Resources r14 = r13.getResourcesForApplication("com.bytedanceos.launcher");     // Catch: Exception -> L37
        OLog.d(TAG, "LAUNCHER_THEME_CLASSIC_BLACK_ID....");     // Catch: Exception -> L37
    L34:
        if (r14 == null) goto L39;
        int r5 = r14.getIdentifier(r4, "drawable", r0);     // Catch: Exception -> L37
        OLog.d(TAG, "resourceName:" + r4 + "   pkg:" + r0 + "  id:" + r5);     // Catch: Exception -> L37
        return r14.getDrawable(r5);
    L39:
        return null;
    L16:
        List<PackageInfo> r6 = r13.getInstalledPackages(0);     // Catch: Exception -> L37
        int r7 = 0;
        Resources r1 = null;
        String r8 = null;
    L18:
        if (r7 >= r6.size()) goto L33;
        String r9 = r6.get(r7).packageName;     // Catch: Exception -> L37
        if (r9 != null) goto L23;
    L32:
        r7 = r7 + 1;     // Catch: Exception -> L37
        goto L18
    L23:
        if (r9.startsWith("com.bytedanceos.launcher.theme") == false) goto L32;
        OLog.d(TAG, "packageName:" + r9);     // Catch: Exception -> L37
        Resources r10 = r13.getResourcesForApplication(r9);     // Catch: Exception -> L37
        if (r10 == null) goto L32;
        if (r10.getString(r10.getIdentifier("theme_id", "string", r9)).equals(r2) == false) goto L32;
        r8 = r9;
        r1 = r10;
        goto L32
    L30:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L37
        goto L32
    L33:
        r14 = r1;
        r0 = r8;
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L8:
        if (r3 == 20) goto L11;
        r4 = "thumbnail_settings";
        goto L40
    }

    public static boolean isChineseLocale() {
        Locale r0 = Locale.getDefault();
        if (Locale.SIMPLIFIED_CHINESE.equals(r0) == false) goto L5;
    L8:
        return true;
    L5:
        if (Locale.TRADITIONAL_CHINESE.equals(r0) == true) goto L8;
        return false;
    }

    public static boolean isEnglishLocale() {
        return Locale.US.equals(Locale.getDefault());
    }

    public static boolean isRussianLocale() {
        return "ru_RU".equals(Locale.getDefault().toString());
    }

    public static float getCurrentFontScale() {
        Configuration r0 = new Configuration();
        r0.updateFrom(ActivityManagerNative.getDefault().getConfiguration());     // Catch: RemoteException -> L5
        return r0.fontScale;
    L5:
        return 1.0f;
    }

    public static String getCurrentDisplayDensityStr(Context r3) {
        int r0 = new DisplayDensityUtils(r3).getCurrentIndexForDefaultDisplay();
        if (r0 < 0) goto L5;
        if (r0 != 0) goto L10;
        return r3.getResources().getString(R.string.small_font);
    L10:
        if (r0 != 1) goto L14;
        return r3.getResources().getString(R.string.font_scale_normal);
    L14:
        if (r0 != 2) goto L18;
        return r3.getResources().getString(R.string.large_font);
    L18:
        return r3.getResources().getString(R.string.font_scale_normal);
    L5:
        return r3.getResources().getString(R.string.font_scale_normal);
    }

    public static String getCurrentFontScaleStr(Context r1) {
        return getFontScaleStr(r1, getCurrentFontScale());
    }

    public static String getFontScaleStr(Context r2, float r3) {
        return r2.getResources().getStringArray(R.array.font_scale_entries)[Arrays.asList(r2.getResources().getStringArray(R.array.font_scale_values)).indexOf(Float.toString(r3))];
    L5:
        e = move-exception;
        OLog.d(TAG, "current font scale:" + r3);
        e.printStackTrace();
        return "";
    }

    public static int getDetectedColor(Context r2) {
        return android.provider.Settings.System.getInt(r2.getContentResolver(), "rear_cover_color", 7);
    }

    public static int getCurrentColor(Context r5, int r6) {
        String r7 = getCalibrateList(r5);
        if (r7 != null) goto L5;
    L14:
        return r6;
    L5:
        if (r7.length() == 0) goto L14;
        String[] r8 = r7.split(",");
        int r0 = r8.length;
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L14;
        String r3 = r8[r2];
        if (Integer.parseInt(r3.substring(0, 1)) == r6) goto L12;
        r2 = r2 + 1;
        goto L8
    L12:
        return Integer.parseInt(r3.substring(2));
    }

    private static String getCalibrateList(Context r1) {
        return android.provider.Settings.System.getString(r1.getContentResolver(), "rear_cover_color_final");
    }

    public static String getStringExtraSafely(Intent r2, String r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        return r2.getStringExtra(r3);
    L9:
        OLog.d(TAG, "exception happen when get " + r3);
        return null;
    L14:
        return null;
    }

    public static int getIntExtraSafely(Intent r1, String r2, int r3) {
        if (r1 != null) goto L4;
        return r3;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        return r1.getIntExtra(r2, r3);
    L8:
        OLog.d(TAG, "exception happen when get " + r2);
        return r3;
    L13:
        return r3;
    }

    public static boolean hasExtraSafely(Intent r2, String r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        return r2.hasExtra(r3);
    L9:
        OLog.d(TAG, "exception happen when get " + r3);
        return false;
    L14:
        return false;
    }

    public static Intent checkIntentVulnerability(Intent r2) {
    L6:
        e = move-exception;
        OLog.e(TAG, "check intent catch exception: " + Log.getStackTraceString(e));
        return new Intent();
    L3:
        if (r2.getExtras() == null) goto L11;
        r2.getExtras().isEmpty();     // Catch: Exception -> L6
        return r2;
    L11:
        return r2;
    }

    public static boolean getBooleanExtraSafely(Intent r1, String r2, boolean r3) {
        if (r1 != null) goto L4;
        return r3;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        return r1.getBooleanExtra(r2, r3);
    L8:
        OLog.d(TAG, "exception happen when get " + r2);
        return r3;
    L13:
        return r3;
    }

    public static long getLongExtraSafely(Intent r1, String r2, long r3) {
        if (r1 != null) goto L4;
        return r3;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        return r1.getLongExtra(r2, r3);
    L8:
        OLog.d(TAG, "exception happen when get " + r2);
        return r3;
    L13:
        return r3;
    }

    public static UserInfo getExistingUser(UserManager r2, UserHandle r3) {
        List r4 = r2.getUsers(true);
        int r5 = r3.getIdentifier();
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        UserInfo r0 = (UserInfo) r6.next();
        if (r0.id != r5) goto L4;
        return r0;
    L8:
        return null;
    }

    public static View inflateCategoryHeader(LayoutInflater r5, ViewGroup r6) {
        TypedArray r0 = r5.getContext().obtainStyledAttributes(null, com.android.internal.R.styleable.Preference, android.R.attr.preferenceCategoryStyle, 0);
        int r1 = r0.getResourceId(3, 0);
        r0.recycle();
        return r5.inflate(r1, r6, false);
    }

    public static boolean isLowStorage(Context r4) {
        if (((StorageManager) NullSafe.nonNull(StorageManager.from(r4))).getStorageBytesUntilLow(r4.getFilesDir()) >= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static Bitmap getDefaultUserIconAsBitmap(int r2) {
        Bitmap r0 = sDarkDefaultUserBitmapCache.get(r2);
        if (r0 != null) goto L6;
        Bitmap r1 = UserIcons.convertToBitmap(MultiSDKAdapter.getDefaultUserIcon(Resources.getSystem(), r2, false));
        sDarkDefaultUserBitmapCache.put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    public static boolean hasPreferredActivities(PackageManager r2, String r3) {
        ArrayList r0 = new ArrayList();
        r2.getPreferredActivities(new ArrayList(), r0, r3);
        OLog.d(TAG, "Have " + r0.size() + " number of activities in preferred list");
        if (r0.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static ArraySet<String> getHandledDomains(PackageManager r3, String r4) {
        List r0 = r3.getIntentFilterVerifications(r4);
        List r5 = r3.getAllIntentFilters(r4);
        ArraySet<String> r6 = new ArraySet();
        if (r0.size() <= 0) goto L11;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        Iterator r2 = ((IntentFilterVerificationInfo) r1.next()).getDomains().iterator();
    L9:
        if (r2.hasNext() == false) goto L6;
        r6.add((String) r2.next());
    L11:
        if (r5 != null) goto L13;
    L24:
        return r6;
    L13:
        if (r5.size() <= 0) goto L24;
        Iterator r7 = r5.iterator();
    L16:
        if (r7.hasNext() == false) goto L24;
        IntentFilter r8 = (IntentFilter) r7.next();
        if (r8.hasCategory("android.intent.category.BROWSABLE") == false) goto L16;
        if (r8.hasDataScheme("http") == true) goto L23;
        if (r8.hasDataScheme(HttpHeadTimeFetcher.FETCHER_TYPE) == false) goto L16;
    L23:
        r6.addAll(r8.getHostsList());
        goto L16
    }

    public static void handleLoadingContainer(View r1, View r2, boolean r3, boolean r4) {
        setViewShown(r1, !r3, r4);
        setViewShown(r2, r3, r4);
    }

    private static void setViewShown(final View r2, boolean r3, boolean r4) {
        int r0 = 0;
        if (r4 == false) goto L13;
        Context r5 = r2.getContext();
        if (r3 == false) goto L7;
        int r1 = android.R.anim.fade_in;
    L8:
        Animation r6 = AnimationUtils.loadAnimation(r5, r1);
        if (r3 == false) goto L11;
        r2.setVisibility(0);
    L12:
        r2.startAnimation(r6);
        return;
    L11:
        r6.setAnimationListener(new AnonymousClass3(r2));
        goto L12
    L7:
        r1 = android.R.anim.fade_out;
        goto L8
    L13:
        r2.clearAnimation();
        if (r3 == true) goto L17;
        r0 = 4;
    L17:
        r2.setVisibility(r0);
    }

    public static ApplicationInfo getAdminApplicationInfo(Context r4, int r5) {
        ComponentName r6 = ((DevicePolicyManager) r4.getSystemService("device_policy")).getProfileOwnerAsUser(r5);
        if (r6 != null) goto L5;
        return null;
    L5:
        String r7 = r6.getPackageName();
        return AppGlobals.getPackageManager().getApplicationInfo(r7, 0, r5);
    L8:
        e = move-exception;
        OLog.e(TAG, "Error while retrieving application info for package " + r7 + ", userId " + r5, e);
        return null;
    }

    public static boolean isBandwidthControlEnabled() {
        return INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management")).isBandwidthControlEnabled();
    L5:
        return false;
    }

    public static SpannableString createAccessibleSequence(CharSequence r3, String r4) {
        SpannableString r0 = new SpannableString(r3);
        r0.setSpan(new TtsSpan.TextBuilder(r4).build(), 0, r3.length(), 18);
        return r0;
    }

    public static int getUserIdFromBundle(Context r2, Bundle r3) {
        if (r3 != null) goto L6;
        return getCredentialOwnerUserId(r2);
    L6:
        return enforceSameOwner(r2, r3.getInt("android.intent.extra.USER_ID", UserHandle.myUserId()));
    }

    public static int enforceSameOwner(Context r2, int r3) {
        if (ArrayUtils.contains(getUserManager(r2).getProfileIdsWithDisabled(UserHandle.myUserId()), r3) == false) goto L6;
        return r3;
    L6:
        throw new SecurityException("Given user id " + r3 + " does not belong to user " + UserHandle.myUserId());
    }

    public static int getCredentialOwnerUserId(Context r1) {
        return getCredentialOwnerUserId(r1, UserHandle.myUserId());
    }

    public static int getCredentialOwnerUserId(Context r0, int r1) {
        return getUserManager(r0).getCredentialOwnerProfile(r1);
    }

    public static int resolveResource(Context r2, int r3) {
        TypedValue r0 = new TypedValue();
        r2.getTheme().resolveAttribute(r3, r0, true);
        return r0.resourceId;
    }

    public static String formatDateRange(Context r10, long r11, long r13) {
        StringBuilder r0 = sBuilder;
        monitor-enter(r0);
        r0.setLength(0);     // Catch: Throwable -> L8
        String r12 = DateUtils.formatDateRange(r10, sFormatter, r11, r13, 65552, null).toString();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    public static List<String> getNonIndexable(int r3, Context r4) {
        if (Looper.myLooper() != null) goto L5;
        Looper.prepare();
    L5:
        ArrayList r0 = new ArrayList();
        checkPrefs(new PreferenceManager(r4).inflateFromResource(r4, r3, null), r0);
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void checkPrefs(PreferenceGroup r4, List<String> r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = 0;
    L6:
        if (r0 >= r4.getPreferenceCount()) goto L18;
        Preference r1 = r4.getPreference(r0);
        if ((r1 instanceof SelfAvailablePreference) == false) goto L15;
        if (((SelfAvailablePreference) r1).isAvailable(r4.getContext()) == true) goto L15;
        r5.add(r1.getKey());
        if ((r1 instanceof PreferenceGroup) == false) goto L17;
        addAll((PreferenceGroup) r1, r5);
    L17:
        r0 = r0 + 1;
    L15:
        if ((r1 instanceof PreferenceGroup) == false) goto L17;
        checkPrefs((PreferenceGroup) r1, r5);
        goto L17
    }

    private static void addAll(PreferenceGroup r3, List<String> r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = 0;
    L6:
        if (r0 >= r3.getPreferenceCount()) goto L11;
        Preference r1 = r3.getPreference(r0);
        r4.add(r1.getKey());
        if ((r1 instanceof PreferenceGroup) == false) goto L10;
        addAll((PreferenceGroup) r1, r4);
    L10:
        r0 = r0 + 1;
        goto L6
    }

    public static boolean isDeviceProvisioned(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "device_provisioned", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean startQuietModeDialogIfNecessary(Context r1, UserManager r2, int r3) {
        if (r2.isQuietModeEnabled(UserHandle.of(r3)) == false) goto L6;
        r1.startActivity(UnlaunchableAppActivity.createInQuietModeDialogIntent(r3));
        return true;
    L6:
        return false;
    }

    public static CharSequence getApplicationLabel(Context r2, String r3) {
        PackageManager r0 = r2.getPackageManager();     // Catch: Throwable -> L8
        if (r0 == null) goto L13;
        ApplicationInfo r1 = r0.getApplicationInfo(r3, 8704);     // Catch: Throwable -> L8
        if (r1 == null) goto L14;
        return r1.loadLabel(r2.getPackageManager());
    L14:
        return null;
    L13:
        return null;
    L8:
        OLog.w(TAG, "Unable to find info for package: " + r3);
        return null;
    }

    public static boolean isPackageEnabled(Context r1, String r2) {
        PackageManager r3 = r1.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L10
        if (r3 == null) goto L9;
        ApplicationInfo r4 = r3.getApplicationInfo(r2, 0);     // Catch: PackageManager.NameNotFoundException -> L10
        if (r4 == null) goto L9;
        return r4.enabled;
    L9:
        return false;
    }

    public static void setItemBgStyle(ListContentItem r0, int r1, int r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.setBackgroundStyle(getItemBgStyle(r1, r2));
    }

    public static void setItemIconSize(ListContentItem r1, int r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        ImageView r4 = r1.getIconView();
        if (r4 != null) goto L7;
        return;
    L7:
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 != null) goto L10;
        return;
    L10:
        r0.width = r2;
        r0.height = r3;
        r4.setLayoutParams(r0);
    }

    public static void setItemBottomPaddingGap(ListContentItem r4, int r5) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.getContext() == null) goto L21;
        Object r0 = r4.getParent();
        if ((r0 instanceof View) == true) goto L9;
        return;
    L9:
        boolean r1 = true;
        if (r5 != 1) goto L12;
    L15:
        if (r1 == false) goto L17;
        int r6 = r4.getContext().getResources().getDimensionPixelSize(R.dimen.settings_item_top_bottom_margin);
    L18:
        ((View) r0).setPadding(0, 0, 0, r6);
        return;
    L17:
        r6 = 0;
        goto L18
    L12:
        if (r5 == 4) goto L15;
        r1 = false;
        goto L15
    }

    public static boolean isNetworkSettingsApkAvailable(Context r3) {
        Intent r0 = new Intent("org.codeaurora.settings.NETWORK_OPERATOR_SETTINGS_ASYNC");
        List<ResolveInfo> r4 = r3.getPackageManager().queryIntentActivities(r0, 0);
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterator<ResolveInfo> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        if ((r5.next().activityInfo.applicationInfo.flags & 1) == 0) goto L7;
        return true;
    L11:
        return false;
    }

    public static void ciActionOnSysUpdate(Context r5, PersistableBundle r6) {
        String r0 = r6.getString("ci_action_on_sys_update_intent_string");
        if (TextUtils.isEmpty(r0) == true) goto L9;
        String r1 = r6.getString("ci_action_on_sys_update_extra_string");
        String r7 = r6.getString("ci_action_on_sys_update_extra_val_string");
        Intent r2 = new Intent(r0);
        if (TextUtils.isEmpty(r1) == true) goto L7;
        r2.putExtra(r1, r7);
    L7:
        OLog.d(TAG, "ciActionOnSysUpdate: broadcasting intent " + r0 + " with extra " + r1 + ", " + r7);
        r5.getApplicationContext().sendBroadcast(r2);
        return;
    }

    public static String getPackageString(Context r1, String r2, String r3) {
        return getContextString(r1.createPackageContext(r2, 2), r3);
    L5:
        e = move-exception;
        OLog.e(TAG, "Can not find " + r2 + " Context: ", e);
        return "Todo 暂未接入app:" + r2;
    }

    public static boolean getPackageBoolean(Context r3, String r4, String r5) {
        Context r6 = r3.createPackageContext(r4, 2);     // Catch: PackageManager.NameNotFoundException -> L7
        int r7 = r6.getResources().getIdentifier(r5, "bool", r6.getPackageName());     // Catch: PackageManager.NameNotFoundException -> L7
        if (r7 <= 0) goto L13;
        return Boolean.parseBoolean(r6.getString(r7));
    L13:
        return false;
    L7:
        e = move-exception;
        OLog.e(TAG, "Can not find " + r4 + " Context: ", e);
        return false;
    }

    public static String getContextString(Context r3, String r4) {
        int r5 = r3.getResources().getIdentifier(r4, "string", r3.getPackageName());     // Catch: Resources.NotFoundException -> L6
        if (r5 <= 0) goto L15;
        return r3.getString(r5);
    L15:
        PackageManager r6 = r3.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L10
        return r6.getApplicationInfo(r3.getPackageName(), 0).loadLabel(r6).toString();
    L10:
        e = move-exception;
        e.printStackTrace();
        return "";
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static String[] getOutsideAppArray(Context r2, String r3, String r4) {
        Context r5 = r2.createPackageContext(r3, 2);     // Catch: PackageManager.NameNotFoundException -> L7 Resources.NotFoundException -> L9
        int r6 = r5.getResources().getIdentifier(r4, "array", r3);     // Catch: PackageManager.NameNotFoundException -> L7 Resources.NotFoundException -> L9
        if (r6 <= 0) goto L15;
        return r5.getResources().getStringArray(r6);
    L15:
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Drawable getDrawableFromPkg(Context r2, String r3, String r4) {
        Resources r5 = r2.getPackageManager().getResourcesForApplication(r3);     // Catch: Resources.NotFoundException -> L8 PackageManager.NameNotFoundException -> L10
        if (r5 != null) goto L6;
        return null;
    L6:
    L16:
        return r5.getDrawable(r5.getIdentifier(r4, "drawable", r3));
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Bitmap getBitmapFromPkg(Context r1, String r2, String r3) {
        Resources r4 = r1.getPackageManager().getResourcesForApplication(r2);     // Catch: PackageManager.NameNotFoundException -> L5
        return BitmapFactory.decodeResource(r4, r4.getIdentifier(r3, "drawable", r2));
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static int getPackageIntegerRes(Context r1, String r2, String r3) throws Resources.NotFoundException {
        return getIntegerRes(r1.createPackageContext(r2, 2), r3);
    L5:
        e = move-exception;
        OLog.e(TAG, "Can not find " + r2 + " Context: ", e);
        throw new Resources.NotFoundException();
    }

    public static int getIntegerRes(Context r3, String r4) throws Resources.NotFoundException {
        int r5 = r3.getResources().getIdentifier(r4, "integer", r3.getPackageName());
        if (r5 <= 0) goto L7;
        return r3.getResources().getInteger(r5);
    L7:
        throw new Resources.NotFoundException();
    }

    public static boolean isSmilingCloudLogin(Context r1) {
        if (((AccountManager) r1.getSystemService("account")).getAccountsByType(ManageAccountsSettingsActivity.BYTEDANCE_ACCOUNT_TYPE).length <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isThirdPartHome(Context r1) {
        return !isSystemPackage(r1, getDefaultLauncherPkg(r1));
    }

    public static String getDefaultLauncherPkg(Context r2) {
        Intent r0 = new Intent("android.intent.action.MAIN");
        r0.addCategory("android.intent.category.HOME");
        r0.addCategory("android.intent.category.DEFAULT");
        ResolveInfo r3 = ((PackageManager) NullSafe.nonNull(r2.getPackageManager())).resolveActivity(r0, 65536);
        if (r3 != null) goto L5;
        String r4 = null;
    L6:
        OLog.d("Settings", "getDefaultLauncherPkg return " + r4);
        return r4;
    L5:
        r4 = r3.activityInfo.packageName;
        goto L6
    }

    public static boolean hasThirdPartHome(Context r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        PackageManager r1 = r6.getPackageManager();
        Intent r2 = new Intent("android.intent.action.MAIN");
        r2.addCategory("android.intent.category.HOME");
        r2.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> r3 = r1.queryIntentActivities(r2, 65600);
        if (r3 != null) goto L8;
    L15:
        return false;
    L8:
        if (r3.size() <= 0) goto L15;
        ResolveInfo r4 = r3.get(0);
        int r5 = r3.size();
        int r7 = 0;
    L10:
        if (r7 >= r5) goto L15;
        if (isSystemPackage(r6, r3.get(r7).activityInfo.packageName) == false) goto L13;
        r7 = r7 + 1;
        goto L10
    L13:
        return true;
    }

    public static int getEffectiveUserId(Context r1) {
        UserManager r2 = UserManager.get(r1.getApplicationContext());
        if (r2 != null) goto L5;
        OLog.e(TAG, "Unable to acquire UserManager");
        return UserHandle.myUserId();
    L5:
        return r2.getCredentialOwnerProfile(UserHandle.myUserId());
    }

    public static void setBackgroundForGridItemChooser(int r3, int r4, View r5) {
        if (r4 <= 2) goto L19;
        if (r3 != 0) goto L6;
        r5.setBackgroundResource(R.drawable.selector_grid_bg_top_left);
        return;
    L6:
        if (r3 != 1) goto L9;
        r5.setBackgroundResource(R.drawable.selector_grid_bg_top_right);
        return;
    L9:
        if (r3 != (r4 - 2)) goto L12;
        r5.setBackgroundResource(R.drawable.selector_grid_bg_bottom_left);
        return;
    L12:
        if (r3 != (r4 - 1)) goto L14;
        r5.setBackgroundResource(R.drawable.selector_grid_bg_bottom_right);
        return;
    L14:
        int r6 = r3 % 2;
        if (r6 != 0) goto L17;
        r5.setBackgroundResource(R.drawable.selector_grid_bg_middle_left);
        return;
    L17:
        if (r6 != 1) goto L29;
        r5.setBackgroundResource(R.drawable.selector_grid_bg_middle_right);
        return;
    L29:
        return;
    L19:
        if (r3 != 0) goto L21;
        r5.setBackgroundResource(R.drawable.selector_grid_bg_single_left);
        return;
    L21:
        if (r3 != 1) goto L32;
        r5.setBackgroundResource(R.drawable.selector_grid_bg_single_right);
        return;
    }

    public static boolean isDeviceSetupComplete(Context r2) {
        if (android.provider.Settings.Secure.getInt(r2.getContentResolver(), "user_setup_complete", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isFingerprintExists(Context r1) {
        FingerprintManager r2 = (FingerprintManager) r1.getSystemService("fingerprint");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.isHardwareDetected() == false) goto L7;
        return r2.hasEnrolledFingerprints();
    }

    public static void hideNavigationForNormal(Activity r3) {
        r3.getWindow().getDecorView().setSystemUiVisibility(9216);
        r3.getWindow().setStatusBarColor(r3.getColor(R.color.oui_bg_base_1));
        r3.getWindow().setNavigationBarColor(r3.getColor(R.color.oui_bg_base_1));
    }

    public static void hideNavigationBar(Activity r0) {
        hideNavigationForNormal(r0);
    }

    public static void notifyNotificationSettingsChanged(Context r2) {
        r2.sendBroadcast(new Intent("bytedanceos.intent.action.NOTIFICATION_SETTINGS_CHANGED"));
    }

    public static boolean launchConfirmPassword(Activity r3, int r4) {
        boolean r5 = new ChooseLockSettingsHelper(r3).launchConfirmationActivity(r4, null, 2);
        if (r5 == true) goto L5;
        OLog.w("Settings", "try launch confirm password activity without password setup");
        r3.finish();
    L5:
        return r5;
    }

    public static boolean launchConfirmPassword(BaseFragment r3, int r4) {
        boolean r5 = new ChooseLockSettingsHelper(r3.getActivity(), r3).launchConfirmationActivity(r4, null, 2);
        if (r5 == true) goto L5;
        OLog.w("Settings", "try launch confirm password activity without password setup");
        r3.finish();
    L5:
        return r5;
    }

    public static ComponentName getTopActivity(Context r4) {
        ComponentName r5 = ActivityManagerSmt.getInstance().getTopActivity((ActivityManager) r4.getSystemService("activity"));     // Catch: Exception -> L5
    L7:
        OLog.i(TAG, "getTopActivity, " + r5);
        OEALogger.INSTANCE.i(TAG, "getTopActivity, " + r5);
        return r5;
    L5:
        e = move-exception;
        e.printStackTrace();
        OLog.e("Settings", "getTopActivity error: " + e);
        r5 = null;
        goto L7
    }

    public static boolean isScreenOn(Context r1) {
        return ((PowerManager) r1.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).isScreenOn();
    }

    public static ObjectAnimator createShakeAnim(View r9, Animator.AnimatorListener r10) {
        float r3 = -25;
        float r5 = 25;
        ObjectAnimator r11 = ObjectAnimator.ofPropertyValuesHolder(r9, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, r3), Keyframe.ofFloat(0.26f, r5), Keyframe.ofFloat(0.42f, r3), Keyframe.ofFloat(0.58f, r5), Keyframe.ofFloat(0.74f, r3), Keyframe.ofFloat(0.9f, r5), Keyframe.ofFloat(1.0f, 0.0f)})}).setDuration(400);
        if (r10 == null) goto L5;
        r11.addListener(r10);
    L5:
        return r11;
    }

    public static Drawable getDoppelgangerDrawableIcon(Resources r1, BitmapDrawable r2) {
        return new BitmapDrawable(r1, DoppelgangerUtils.getDoppelgangerBitmap(r2.getBitmap()));
    }

    public static int getMMApiLevel(Context r3) {
        ApplicationInfo r4 = r3.getPackageManager().getApplicationInfo("com.tencent.mm", 128);     // Catch: PackageManager.NameNotFoundException -> L13
        int r1 = r4.metaData.getInt("wechat_ext_api_level", 0);     // Catch: PackageManager.NameNotFoundException -> L13
        if (r1 <= 0) goto L6;
        return r1;
    L6:
        String r5 = r4.metaData.getString("wechat_fun_support");     // Catch: PackageManager.NameNotFoundException -> L13
        if (r5 == null) goto L12;
        if (r5.length() <= 0) goto L12;
        return 1;
    L12:
        return 0;
    L13:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static void setTranslucentStatus(Context r1, Window r2, View r3, boolean r4) {
        if (isDeviceSetupComplete(r1) == true) goto L5;
        return;
    L5:
        r2.getDecorView().setSystemUiVisibility(1280);
        r2.addFlags(Integer.MIN_VALUE);
        r2.setStatusBarColor(0);
        setupStatusBarView(r1, (ViewGroup) r2.getDecorView(), r3, true);
    }

    public static void setTranslucentStatusAndNavigation(Context r2, Window r3) {
        if (isDeviceSetupComplete(r2) == true) goto L5;
        return;
    L5:
        r3.getDecorView().setSystemUiVisibility(1280);
        r3.addFlags(Integer.MIN_VALUE);
        r3.setStatusBarColor(ContextCompat.getColor(r2, R.color.some_activities_bg_color));
        r3.setNavigationBarColor(0);
        setLightStatusBarIcon(r3, true);
        setNavigationBarBtnColor(r3, true);
    }

    public static boolean isLightStatusBar(Context r1) {
        if ((r1.getResources().getConfiguration().uiMode & 48) == 32) goto L5;
        return true;
    L5:
        return false;
    }

    public static void edgeToEdgeSystemViews(Activity r3) {
        Window r0 = r3.getWindow();
        r0.getDecorView().setSystemUiVisibility(1792);
        r0.addFlags(Integer.MIN_VALUE);
        r0.setStatusBarColor(0);
        if (isThreeButtonNavBarEnabled(r3) == false) goto L5;
        int r2 = r3.getColor(R.color.oui_bg_base_1);
    L6:
        r0.setNavigationBarColor(r2);
        r0.setNavigationBarContrastEnforced(false);
        setLightStatusBarIcon(r0, Boolean.valueOf(isLightStatusBar(r3)));
        setNavigationBarBtnColor(r0, Boolean.valueOf(isLightStatusBar(r3)));
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public static void setLightStatusBarIcon(Window r1, Boolean r2) {
        int r0 = r1.getDecorView().getSystemUiVisibility();
        if (r2.booleanValue() == false) goto L5;
        int r3 = r0 | 8192;
    L6:
        r1.getDecorView().setSystemUiVisibility(r3);
        return;
    L5:
        r3 = r0 & (-8193);
        goto L6
    }

    public static void setNavigationBarBtnColor(Window r1, Boolean r2) {
        int r0 = r1.getDecorView().getSystemUiVisibility();
        if (r2.booleanValue() == false) goto L5;
        int r3 = r0 | 16;
    L6:
        r1.getDecorView().setSystemUiVisibility(r3);
        return;
    L5:
        r3 = r0 & (-17);
        goto L6
    }

    public static boolean isThreeButtonNavBarEnabled(Activity r3) {
        return ((OverlayManager) r3.getSystemService(OverlayManager.class)).getOverlayInfo("com.android.internal.systemui.navbar.threebutton", new UserHandle(r3.getUserId())).isEnabled();
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean isGesturalNavBarEnabled(Activity r3) {
        return ((OverlayManager) r3.getSystemService(OverlayManager.class)).getOverlayInfo("com.android.internal.systemui.navbar.gestural", new UserHandle(r3.getUserId())).isEnabled();
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static void setupStatusBarView(Context r3, ViewGroup r4, View r5, boolean r6) {
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, r3.getResources().getDimensionPixelSize(17106400));
        r1.gravity = 48;
        r5.setLayoutParams(r1);
        if (r6 == false) goto L5;
        r5.setBackgroundResource(R.drawable.securitycenter_blue_status_bar_bg);
    L6:
        r4.addView(r5);
        return;
    L5:
        r5.setBackgroundColor(r3.getResources().getColor(android.R.color.background_dark));
        goto L6
    }

    public static boolean doppelgangerAppExist(PackageManager r3, int r4) {
        String[] r1 = r3.getPackagesForUid(r4);     // Catch: PackageManager.NameNotFoundException -> L13
        if (r1 != null) goto L6;
    L8:
        String r2 = null;
    L9:
        if (r3.getApplicationInfoAsUser(r2, 0, UserHandle.getUserId(r4)) == null) goto L15;
        return true;
    L15:
        return false;
    L6:
        if (r1.length <= 0) goto L8;
        r2 = r1[0];     // Catch: PackageManager.NameNotFoundException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static boolean hasLockedPackages(PackageManager r3) {
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        if (PackageManagerSmt.getInstance().hasLockedPackages(r3) == true) goto L7;
        if (PackageManagerSmt.getInstance().hasLockedPackages(r3, 10) == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static void writeStringToFile(String r3, File r4) {
        BufferedWriter r0 = null;
        BufferedWriter r1 = new BufferedWriter(new FileWriter(r4));     // Catch: Throwable -> L11 IOException -> L13
        r1.write(r3);     // Catch: Throwable -> L7 IOException -> L9
        r1.flush();     // Catch: Throwable -> L7 IOException -> L9
        r1.close();     // Catch: IOException -> L21
    L23:
    L26:
        return;
    L9:
        e = e;
        r0 = r1;
    L14:
        e.printStackTrace();     // Catch: Throwable -> L11
        if (r0 == null) goto L26;
        r0.close();     // Catch: IOException -> L21
    L7:
        th = th;
        r0 = r1;
    L18:
        if (r0 != null) goto L30;
    L20:
        throw th;
    L30:
        r0.close();     // Catch: IOException -> L22
    L13:
        e = e;
    L34:
        return;
    L11:
        th = th;
        goto L18
    }

    public static String readStringFromFile(File r4) {
        String r0 = null;
        r0 = null;
        r0 = null;
        BufferedReader r1 = null;
        r0 = null;
        r0 = null;
        if (r4 != null) goto L35;
    L33:
        return r0;
    L35:
        if (r4.exists() == false) goto L33;
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L17 IOException -> L19
        BufferedReader r3 = new BufferedReader(new FileReader(r4));     // Catch: Throwable -> L17 IOException -> L19
    L39:
        String r5 = r3.readLine();     // Catch: IOException -> L15 Throwable -> L25
        if (r5 == null) goto L10;
        r2.append(r5);     // Catch: IOException -> L15 Throwable -> L25
        goto L39
    L10:
        r0 = r2.toString();     // Catch: IOException -> L15 Throwable -> L25
        r3.close();     // Catch: IOException -> L13
    L34:
    L15:
        e = e;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L25
        if (r3 == null) goto L33;
        r3.close();     // Catch: IOException -> L13
    L25:
        th = th;
        r1 = r3;
    L27:
        if (r1 != null) goto L37;
    L32:
        throw th;
    L37:
        r1.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L19:
        e = e;
        r3 = null;
    L17:
        th = th;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L33
    }

    public static long getRealCurrentTimeMillis(Context r4) {
        NtpTrustedTime r5 = NtpTrustedTime.getInstance(r4);
        if (r5.hasCache() == false) goto L5;
        long r2 = r5.currentTimeMillis();
        OLog.d(TAG, "use ntp time: " + new Date(r2));
        return r2;
    L5:
        long r3 = System.currentTimeMillis();
        OLog.d(TAG, "use system time: " + new Date(r3));
        return r3;
    }

    public static String getDeviceIMEI() {
        TelephonyManager r0 = (TelephonyManager) SettingsApplication.getContext().getSystemService(MultiSimAdapter.PHONE_KEY);
        SLog.d(TAG, "imei getDeviceId " + r0.getDeviceId());
        SLog.d(TAG, "imei getImei " + r0.getImei());
        if (MultiSimAdapter.isMultiSimEnabled() == false) goto L6;
        return r0.getImei(0);
    L6:
        return r0.getImei();
    }

    public static boolean isExperienceVersion() {
        if (SystemProperties.getInt("ro.bytedance.experience", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isCtaTestModeOn() {
        if (SystemProperties.getInt("persist.radio.cta.test.mode", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static int getHistoryWallpaperCount(Context r8, int r9) {
        Cursor r1 = null;
        r1 = r8.getContentResolver().query(WallpaperUtils.CONTENT_URI, null, "wallpaper_type=?", new String[]{String.valueOf(r9)}, null);     // Catch: Throwable -> L13 Exception -> L15
        if (r1 != null) goto L6;
    L11:
        if (r1 != null) goto L18;
    L19:
        return 0;
    L18:
        r1.close();
        goto L19
    L6:
        if (r1.moveToFirst() == false) goto L11;
        int r10 = r1.getCount();     // Catch: Throwable -> L13 Exception -> L15
        if (r1 == null) goto L10;
        r1.close();
    L10:
        return r10;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        if (r1 == null) goto L19;
    L13:
        th = move-exception;
        if (r1 == null) goto L22;
        r1.close();
    L22:
        throw th;
    }

    public static void limitTextSizeAsDp(Context r2, TextView r3) {
        float r0 = r3.getTextSize();
        float r4 = r2.getResources().getConfiguration().fontScale;
        TextViewSmt.getInstance().setMaxTextSize(r3, r0 / r4);
    }

    public static Bundle getWalletData(Context r3) {
        return r3.getContentResolver().call(Uri.parse("content://com.bytedanceos.wallet.centerprovider"), "getbankcard", null, null);
    L5:
        e = move-exception;
        e.printStackTrace();
        OLog.d(TAG, "queryHasBankCardInWallet method exception: " + e.getMessage());
        return null;
    }

    public static int getAppUid(Context r2, String r3) {
        int r0 = -1;
        PackageManager r4 = r2.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L7
        if (r4 == null) goto L9;
        r0 = r4.getPackageUid(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L7
    L9:
        OLog.d(TAG, "package name " + r3 + " , uid = " + r0);
        return r0;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static String getPackageNameViaUid(Context r2, int r3) {
        String[] r4 = r2.getPackageManager().getPackagesForUid(r3);
        if (r4 != null) goto L5;
    L7:
        String r5 = null;
    L8:
        OLog.d(TAG, "getPackageNameViaUid, uid " + r3 + " --> " + r5);
        return r5;
    L5:
        if (r4.length <= 0) goto L7;
        r5 = r4[0];
        goto L8
    }

    public static View findViewByName(Context r2, View r3, String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return null;
    L7:
        return r3.findViewById(r2.getResources().getIdentifier(r4, "id", r2.getPackageName()));
    }

    public static void setAppLabelAndIconViews(View r5, String r6, int r7) {
        Context r0 = r5.getContext();
        PackageManager r1 = r0.getPackageManager();
        PackageInfo r8 = r1.getPackageInfo(r6, 0);     // Catch: PackageManager.NameNotFoundException -> L16
        if (r8 == null) goto L7;
        String r3 = r8.versionName;     // Catch: PackageManager.NameNotFoundException -> L16
    L8:
        OLocalListItemText r9 = (OLocalListItemText) r5.findViewById(R.id.app_snippet).findViewById(R.id.app_item);
        if (r8 == null) goto L11;
        r9.setContentImage(ObricIconUtils.getDrawable(r8.packageName, r7));
    L11:
        if (r8 == null) goto L13;
        r9.setTitleString(r8.applicationInfo.loadLabel(r1));
    L13:
        if (r3 == null) goto L21;
        r9.setSubTitleString(r0.getString(R.string.version_text, new Object[]{String.valueOf(r3)}));
        return;
    L21:
        return;
    L7:
        r3 = null;
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    public static void setAppLabelAndIconViews(View r5, PackageInfo r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.applicationInfo == null) goto L9;
        Context r0 = r5.getContext();
        PackageManager r1 = r0.getPackageManager();
        String r2 = r6.versionName;
        OLocalListItemText r7 = (OLocalListItemText) r5.findViewById(R.id.app_snippet).findViewById(R.id.app_item);
        r7.setContentImage(ObricIconUtils.getDrawable(r6.packageName, r6.applicationInfo.uid));
        r7.setTitleString(r6.applicationInfo.loadLabel(r1));
        r7.setSubTitleString(r0.getString(R.string.version_text, new Object[]{String.valueOf(r2)}));
        return;
    }

    public static Drawable loadAppIcon(Context r1, String r2) {
        PackageManager r3 = r1.getPackageManager();
        return r3.getPackageInfo(r2, 0).applicationInfo.loadIcon(r3);
    L5:
        return null;
    }

    public static void syncFeedBack(final Context r1, final String r2, final String r3) {
        AsyncTask.execute(new AnonymousClass4(r2, r3, r1));
    }

    public static CharSequence getRingtoneName(Context r10, String r11, boolean r12) {
        ContentResolver r7 = r10.getContentResolver();
        String r1 = android.provider.Settings.System.getString(r7, r11);
        if (r1 == null) goto L11;
        Uri r2 = Uri.parse(r1);
        if (r12 == true) goto L7;
    L10:
        Uri r13 = r2;
    L12:
        String r9 = r10.getString(android.R.string.storage_internal);
        if (r13 == null) goto L35;
    L29:
        e = move-exception;
        e.printStackTrace();
    L32:
        return r9;
    L16:
        if (r11.equals("ringtone") == false) goto L18;
    L21:
        String r14 = "is_ringtone";
    L22:
        Cursor r15 = r7.query(r13, new String[]{"title"}, r14.concat("=0"), null, null);     // Catch: SQLiteException -> L29
        if (r15 == null) goto L32;
        if (r15.moveToFirst() == false) goto L27;
        r9 = r15.getString(0);     // Catch: SQLiteException -> L29
        ContentValues r0 = new ContentValues();     // Catch: SQLiteException -> L29
        r0.put(r14, 1);     // Catch: SQLiteException -> L29
        r7.update(r13, r0, null, null);     // Catch: SQLiteException -> L29
    L27:
        r15.close();     // Catch: SQLiteException -> L29
        goto L32
    L18:
        if (r11.equals("ringtone_2") == true) goto L21;
        r14 = "is_notification";
        goto L22
    L35:
        return r10.getString(android.R.string.stk_cc_ussd_to_ussd);
    L7:
        if (r1.startsWith("content://media/internal/") == true) goto L10;
        return "";
    L11:
        r13 = null;
        goto L12
    }

    public static int getLockPasswordType(Context r3) {
        r3.getContentResolver();
        LockPatternUtils r0 = new LockPatternUtils(r3);
        if (r0.isSecure(UserHandle.myUserId()) == false) goto L23;
        int r4 = r0.getKeyguardStoredPasswordQuality(UserHandle.myUserId());
        if (r4 != 65536) goto L7;
        return 1;
    L7:
        if (r4 == 131072) goto L18;
        if (r4 == 196608) goto L18;
        if (r4 != 262144) goto L13;
        return 4;
    L13:
        if (r4 != 327680) goto L15;
        return 4;
    L15:
        if (r4 != 393216) goto L23;
        return 4;
    L18:
        if (((int) LockPatternUtilsOnly.getPasswordLengthBytedance(r0, UserHandle.myUserId())) != 4) goto L20;
        int r5 = 2;
    L28:
        return r5;
    L20:
        r5 = 3;
    L23:
        return 0;
    }

    public static int getPhoneFrameResId() {
        String r0 = getDeviceColor();
        if ("golden".equals(r0) == false) goto L6;
        return R.drawable.page_animations_preview_phone_golden;
    L6:
        if ("Steel".equalsIgnoreCase(r0) == false) goto L9;
        return R.drawable.page_animations_preview_phone_steel;
    L9:
        if ("wine-red".equalsIgnoreCase(r0) == false) goto L12;
        return R.drawable.page_animations_preview_phone_wine_red;
    L12:
        if ("copper-red".equals(r0) == false) goto L15;
        return R.drawable.page_animations_preview_phone_copper_red;
    L15:
        if ("light-golden".equals(r0) == false) goto L17;
    L31:
        return R.drawable.page_animations_preview_phone_light_golden;
    L17:
        if ("gintama".equals(r0) == true) goto L31;
        if ("beige".equals(r0) == true) goto L31;
        if ("white".equals(r0) == false) goto L25;
        return R.drawable.page_animations_preview_phone_white;
    L25:
        if ("blue".equals(r0) == false) goto L28;
        return R.drawable.page_animations_preview_phone_blue;
    L28:
        if ("pine-green".equals(r0) == false) goto L30;
        return R.drawable.page_animations_preview_phone_pine_green;
    L30:
        return R.drawable.page_animations_preview_phone;
    }

    public static int getSpecialPhoneFrameResId() {
        String r0 = getDeviceColor();
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.DELTA, DeviceType.DARWIN}) == false) goto L13;
        if ("white".equals(r0) == false) goto L8;
        return R.drawable.page_theme_preview_phone_white;
    L8:
        if ("pine-green".equals(r0) == false) goto L10;
        return R.drawable.page_theme_preview_phone_pine_green;
    L10:
        return R.drawable.page_theme_preview_phone;
    L13:
        if ("golden".equals(r0) == false) goto L16;
        return R.drawable.page_animations_preview_phone_golden;
    L16:
        if ("Steel".equalsIgnoreCase(r0) == false) goto L19;
        return R.drawable.page_animations_preview_phone_steel;
    L19:
        if ("wine-red".equalsIgnoreCase(r0) == false) goto L22;
        return R.drawable.page_animations_preview_phone_wine_red;
    L22:
        if ("copper-red".equals(r0) == false) goto L25;
        return R.drawable.page_animations_preview_phone_special_copper_red;
    L25:
        if ("light-golden".equals(r0) == false) goto L27;
    L41:
        return R.drawable.page_animations_preview_phone_light_golden;
    L27:
        if ("gintama".equals(r0) == true) goto L41;
        if ("beige".equals(r0) == true) goto L41;
        if ("white".equals(r0) == false) goto L35;
        return R.drawable.page_animations_preview_phone_special_white;
    L35:
        if ("blue".equals(r0) == false) goto L38;
        return R.drawable.page_animations_preview_phone_special_blue;
    L38:
        if ("pine-green".equals(r0) == false) goto L40;
        return R.drawable.page_animations_preview_phone_special_pine_green;
    L40:
        return R.drawable.page_animations_preview_phone_special;
    }

    public static String getVoiceAssistKey() {
        if (SettingsFeature.hasMenuAndBackKeys() == false) goto L5;
        return "voice_assit_by_menu";
    L5:
        return "voice_assit_by_home";
    }

    public static Bitmap drawableToBitmap(Drawable r5) {
        if ((r5 instanceof BitmapDrawable) == false) goto L9;
        BitmapDrawable r0 = (BitmapDrawable) r5;
        if (r0.getBitmap() == null) goto L9;
        return r0.getBitmap();
    L9:
        if (r5.getIntrinsicWidth() > 0) goto L11;
    L14:
        Bitmap r1 = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    L15:
        Canvas r2 = new Canvas(r1);
        r5.setBounds(0, 0, r2.getWidth(), r2.getHeight());
        r5.draw(r2);
        return r1;
    L11:
        if (r5.getIntrinsicHeight() <= 0) goto L14;
        r1 = Bitmap.createBitmap(r5.getIntrinsicWidth(), r5.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        goto L15
    }

    public static boolean isRightHandMode(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "one_hand_mode", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static String getStorageVersion() {
        long r0 = getTotalSize(Environment.getExternalStorageDirectory());
        OLog.d("Settings", "total size " + r0);
        long r1 = (long) Math.pow(2.0d, Long.toBinaryString(r0 << 1).length() - 1);
        long r4 = (long) Math.pow(2.0d, 30.0d);
        long r2 = r1 / ((long) Math.pow(2.0d, 40.0d));
        if (r2 <= 0) goto L7;
        return r2 + " TB";
    L7:
        return new StringBuilder().append(r1 / r4).append(" GB").toString();
    }

    public static boolean isNotificationWhiteApp(Context r3, ApplicationsState r4, ApplicationInfo r5) {
        String r6 = r5.packageName;
        if ("com.android.contacts".equals(r6) == false) goto L6;
        return true;
    L6:
        if (Constants.PKG_MMS.equals(r6) == false) goto L9;
        return false;
    L9:
        if (ApplicationsState.sWhiteAppList.contains(r6) == false) goto L12;
        return false;
    L12:
        if (new HashSet(Arrays.asList(r3.getResources().getStringArray(17236265))).contains(r6) == false) goto L15;
        return true;
    L15:
        return ApplicationsState.isBlackListOrHiddenApp(r5);
    }

    public static void showNotification(Context r7, int r8, int r9, int r10, int r11, Intent r12) {
        Resources r0 = r7.getResources();
        String r4 = r0.getString(r10);
        if (r11 <= 0) goto L5;
        String r13 = r0.getString(r11);
    L6:
        showNotification(r7, r8, r9, r4, r13, r12);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public static void showNotification(Context r2, int r3, int r4, String r5, String r6, Intent r7) {
        PendingIntent r8 = PendingIntent.getActivity(r2, 0, r7, VCardConfig.FLAG_CONVERT_PHONETIC_NAME_STRINGS);
        Notification.Builder r0 = new Notification.Builder(r2);
        r0.setSmallIcon(r4);
        r0.setContentIntent(r8);
        r0.setTicker(r5);
        r0.setContentTitle(r5);
        if (TextUtils.isEmpty(r6) == true) goto L5;
        r0.setContentText(r6);
    L5:
        r0.setAutoCancel(true);
        Notification r9 = r0.build();
        ((NotificationManager) r2.getSystemService("notification")).notify(r3, r9);
    }

    public static boolean canUninstall(Context r1, String r2) {
        return canUninstall(r1.getPackageManager().getApplicationInfo(r2, 0));
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean canUninstall(ApplicationInfo r3) {
        boolean r0 = isSystemPackage(r3);
        ApplicationInfoSmt r1 = ApplicationInfoSmt.getInstance();
        if (r0 == true) goto L5;
        return true;
    L5:
        if ((r1.getBytedanceFlag(r3) & 8) != 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean canBundledUninstall(ApplicationInfo r1) {
        if (canUninstall(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (isRemovableSysApp(r1.packageName) == true) goto L8;
        return false;
    }

    public static boolean isRemovableSysApp(String r8) {
        Object r9 = Class.forName("android.content.pm.ObricPackageManager").getMethod("isRemovableSysApp", new Class[]{String.class}).invoke(null, new Object[]{r8});     // Catch: Throwable -> L7
        OLog.d(TAG, "isRemovableSysApp:" + r9);     // Catch: Throwable -> L7
        if ((r9 instanceof Boolean) == false) goto L9;
        return ((Boolean) r9).booleanValue();
    L9:
        return false;
    L7:
        th = move-exception;
        OLog.e(TAG, "isRemovableSysApp", th);
        goto L9
    }

    public static Object getClassField(Class<?> r0, String r1) {
        return getClassField(r0.getName(), r1);
    }

    public static Object getClassField(String r3, String r4) {
        Field r0 = Class.forName(r3).getField(r4);     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        Object r1 = r0.get(r4);     // Catch: Exception -> L4
    L6:
        OLog.d(TAG, "getClassField " + r4 + " from " + r3 + " return " + r1);
        return r1;
    L4:
        e = move-exception;
        e.printStackTrace();
        r1 = null;
        goto L6
    }

    public static void killCurrentInputMethodPkg(Context r8) {
        InputMethodManager r2 = (InputMethodManager) r8.getSystemService("input_method");
        Method r5 = InputMethodManager.class.getDeclaredMethod("clearBindingLocked", new Class[0]);     // Catch: Exception -> L5
        r5.setAccessible(true);     // Catch: Exception -> L5
        r5.invoke(r2, new Object[0]);     // Catch: Exception -> L5
        OLog.d(TAG, "refection call InputMethodManager.clearBindingLocked");     // Catch: Exception -> L5
    L7:
        String r3 = android.provider.Settings.Secure.getString(r8.getContentResolver(), "default_input_method");
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return;
    L10:
        if (r3.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L25;
        String r4 = r3.split(LibrarianImpl.Constants.SEPARATOR)[0];
        ActivityManager r6 = (ActivityManager) r8.getSystemService("activity");     // Catch: Exception -> L17
        ApplicationInfo r9 = r8.getPackageManager().getApplicationInfo(r4, 1);     // Catch: Exception -> L17
        if (r9 != null) goto L15;
        return;
    L15:
        r6.killUid(r9.uid, " change nav bar mode");     // Catch: Exception -> L17
        OLog.d(TAG, "kill " + r4 + " for change nav bar mode");     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L25:
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void finishActivityDelay(final Activity r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        new Handler(r4.getMainLooper()).postDelayed(new AnonymousClass5(r4), 300);
    }

    public static void enableAccessiblityService(Context r1, String r2) {
        enableAccessibilityService(r1, r2, true);
    }

    public static void enableAccessibilityService(Context r3, String r4, boolean r5) {
        Set r0 = AccessibilityUtils.getEnabledServicesFromSettings(r3);
        if (r0 != Collections.emptySet()) goto L5;
        r0 = new HashSet();
    L5:
        if (r5 == false) goto L7;
        r0.add(ComponentName.unflattenFromString(r4));
    L8:
        StringBuilder r6 = new StringBuilder();
        Iterator r7 = r0.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        r6.append(((ComponentName) r7.next()).flattenToString());
        r6.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        goto L10
    L12:
        int r8 = r6.length();
        int r1 = 1;
        if (r8 <= 0) goto L15;
        r6.deleteCharAt(r8 - 1);
    L15:
        android.provider.Settings.Secure.putString(r3.getContentResolver(), "enabled_accessibility_services", r6.toString());
        ContentResolver r9 = r3.getContentResolver();
        if (r0.size() > 0) goto L19;
        r1 = 0;
    L19:
        android.provider.Settings.Secure.putInt(r9, "accessibility_enabled", r1);
        return;
    L7:
        r0.remove(ComponentName.unflattenFromString(r4));
        goto L8
    }

    public static void switchToOriginalLauncher(Context r7) {
        if ("com.android.launcher3".equals(getDefaultLauncherPkg(r7)) == false) goto L5;
        return;
    L5:
        PackageManager r0 = r7.getPackageManager();
        ComponentName r2 = new ComponentName("com.android.launcher3", "com.android.launcher3.Launcher");
        IntentFilter r1 = new IntentFilter("android.intent.action.MAIN");
        r1.addCategory("android.intent.category.HOME");
        r1.addCategory("android.intent.category.DEFAULT");
        Intent r3 = PreferredActivityChooserFragment.makeIntentByFilter(r1);
        PackageManagerSmt.getInstance().clearPreferredActivities(r0, r3);
        resetThumbMode(r7);
        unlockAllPackages(r0);
        saveOrRestoreLastLauncherMode(r7, r0, r3, r2);
        List<ResolveInfo> r8 = r0.queryIntentActivities(r3, 65600);
        if (r8 == null) goto L24;
        List r4 = Arrays.asList(new String[]{Constants.PKG_BACKUP, "com.android.settings"});
        Iterator<ResolveInfo> r5 = r8.iterator();
    L9:
        if (r5.hasNext() == false) goto L15;
        ResolveInfo r6 = r5.next();
        if (r6.activityInfo == null) goto L9;
        if (r4.contains(r6.activityInfo.packageName) == false) goto L9;
        r5.remove();
        goto L9
    L15:
        ComponentName[] r9 = new ComponentName[r8.size()];
        ComponentName r10 = new ComponentName("com.bytedanceos.launcher", "com.bytedanceos.launcher.Launcher");
        r0.addPreferredActivity(r1, 1048576, r9, r2);
        setLauncherEnabledState(r0, r2, 1);
        setLauncherEnabledState(r0, r10, 2);
        return;
    }

    public static int getSystemDefaultLauncher(Context r2) {
        int r3 = getPackageIntegerRes(r2, Constants.PKG_SETTINGS_PROVIDER, "def_launcher_mode");     // Catch: Resources.NotFoundException -> L4
    L9:
        OLog.d(TAG, "getSystemDefaultLauncher " + r3);
        return r3;
    L4:
        e = move-exception;
        e.printStackTrace();
        if (SettingsFeature.isLauncher12GridsSupport() == false) goto L8;
        r3 = 12;
        goto L9
    L8:
        r3 = 9;
        goto L9
    }

    public static int getCurrentLauncherMode(Context r2) {
        return android.provider.Settings.Global.getInt(r2.getContentResolver(), "launcher_mode");
    L5:
        return getSystemDefaultLauncher(r2);
    }

    public static int getCurrentLauncherTheme(Context r2) {
        return android.provider.Settings.Global.getInt(r2.getContentResolver(), "launcher_grid_theme", 0);
    }

    public static void launchAppStoreForPackage(Context r2, String r3) {
        Intent r0 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + r3));     // Catch: ActivityNotFoundException -> L5
        r0.setPackage(APP_STORE_PACKAGE);     // Catch: ActivityNotFoundException -> L5
        r0.addFlags(268435456);     // Catch: ActivityNotFoundException -> L5
        startActivity(r2, r0);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static int getCurrentLauncherMultiBlockMode(Context r2) {
        return android.provider.Settings.Global.getInt(r2.getContentResolver(), "multi_block_mode");
    L4:
        int r3 = getCurrentLauncherMode(r2);
        if (r3 != 9) goto L7;
        return 36;
    L7:
        if (r3 != 12) goto L9;
        return 48;
    L9:
        if (r3 != 16) goto L11;
        return 64;
    L11:
        if (r3 == 20) goto L14;
        return 0;
    L14:
        return 80;
    }

    public static void unlockAllPackages(PackageManager r1) {
        PackageManagerSmt.getInstance().unlockAllPackages(r1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean isPackageLocked(PackageManager r1, String r2, int r3) {
        return PackageManagerSmt.getInstance().isPackageLocked(r1, r2, r3);
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean isPackageAlreadyLocked(PackageManager r1, String r2, int r3) {
        return PackageManagerSmt.getInstance().isPackageAlreadyLocked(r1, r2, UserHandle.getUserId(r3));
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void resetThumbMode(Context r1) {
        WindowManager r2 = (WindowManager) r1.getSystemService("window");
        if (WindowManagerSmt.getInstance().isWindowInthumbMode(r2) == false) goto L6;
        WindowManagerSmt.getInstance().resetWindowOneHandedState(r2);
        return;
    }

    private static void saveOrRestoreLastLauncherMode(Context r6, PackageManager r7, Intent r8, ComponentName r9) {
        ResolveInfo r10 = r7.resolveActivity(r8, 65536);
        if (r10 == null) goto L5;
        ComponentName r11 = new ComponentName(r10.activityInfo.packageName, r10.activityInfo.name);
    L7:
        if (r11 == null) goto L12;
        if ("com.bytedanceos.launcher".equals(r11.getPackageName()) == false) goto L12;
        int r2 = getCurrentLauncherMode(r6);
        OLog.d(TAG, "saveOrRestoreLastLauncherMode: currentLauncherMode:" + r2);
        android.provider.Settings.Global.putInt(r6.getContentResolver(), "last_grid_launcher_mode", r2);
    L12:
        if ("com.bytedanceos.launcher".equals(r9.getPackageName()) == false) goto L27;
        int r0 = android.provider.Settings.Global.getInt(r6.getContentResolver(), "last_grid_launcher_mode", getSystemDefaultLauncher(r6));
        OLog.d(TAG, "saveOrRestoreLastLauncherMode: lastGridLauncherMode:" + r0);
        android.provider.Settings.Global.putInt(r6.getContentResolver(), "launcher_mode", r0);
        int r1 = 3;
        if (r0 == 9) goto L22;
        int r4 = 4;
        if (r0 != 12) goto L18;
    L25:
        android.provider.Settings.Global.putInt(r6.getContentResolver(), "launcher_grids_x", r1);
        android.provider.Settings.Global.putInt(r6.getContentResolver(), "launcher_grids_y", r4);
        goto L27
    L18:
        if (r0 != 16) goto L20;
        r1 = 4;
        goto L25
    L20:
        if (r0 == 20) goto L23;
        r1 = 0;
        goto L22
    L23:
        r4 = 5;
        r1 = 4;
    L22:
        r4 = r1;
    L27:
        if ("com.android.launcher3".equals(r9.getPackageName()) == false) goto L29;
        android.provider.Settings.Global.putInt(r6.getContentResolver(), "launcher_mode", 0);
    L29:
        if (r11 == null) goto L32;
        forceStopPackage(r6, r11.getPackageName());
        return;
    L32:
        return;
    L5:
        r11 = null;
        goto L7
    }

    private static void setLauncherEnabledState(PackageManager r1, ComponentName r2, int r3) {
        String r4 = r2.getPackageName();
        int r0 = 1;
        if (1 == r3) goto L6;
        r0 = 0;
    L6:
        r1.setApplicationEnabledSetting(r4, r3, r0);
    }

    private static void forceStopPackage(Context r1, String r2) {
        ((ActivityManager) r1.getSystemService("activity")).forceStopPackage(r2);
    }

    public static boolean isTalkbackApp(Context r4, String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        String[] r6 = r4.getResources().getStringArray(R.array.accessibility_talkback_apps);
        int r0 = r6.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        if (r5.contains(r6[r2]) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static int getNavbarVibrationResIdByMode(Context r5) {
        ContentResolver r6 = r5.getContentResolver();
        int r1 = 0;
        if (android.provider.Settings.Global.getInt(r6, SettingsSwitchKeyUtil.SMART_SCREEN_PROTECTOR, 0) != 1) goto L5;
        boolean r0 = true;
    L7:
        if (SettingsFeature.hasPhysicalVirtualKey() == false) goto L9;
        r1 = 2;
    L9:
        int r7 = android.provider.Settings.Global.getInt(r6, "navigationbar_trigger_mode", r1);
        int r2 = R.string.navigationbar_vibration;
        if (r7 == 0) goto L15;
        if (r7 != 1) goto L15;
        r2 = R.string.navigationbar_gesture_vibration;
    L15:
        if (SettingsFeature.isSupportSmartScreenProtection() == false) goto L19;
        if (r0 == false) goto L20;
        return R.string.navigationbar_smartscreen_vibration;
    L20:
        return r2;
    L19:
        return r2;
    L5:
        r0 = false;
        goto L7
    }

    public static String getNavbarVibrationValueByMode(Context r1) {
        return r1.getString(getNavbarVibrationResIdByMode(r1));
    }

    public static String buildToggleServiceExtra(Context r6, ComponentName r7, String r8) {
        AccessibilityServiceInfo r0 = getToggleServiceInfo(r6, r7);
        if (r0 != null) goto L5;
        return null;
    L5:
        PackageManager r2 = r6.getPackageManager();
        StringBuilder r3 = new StringBuilder("isToggleableService=true");
        CharSequence r4 = r0.getResolveInfo().loadLabel(r2);
        if (r4 != null) goto L8;
        return null;
    L8:
        String r1 = r4.toString();
        r3.append(r8);
        r3.append("preference_key=").append(r7.flattenToString()).append(r8);
        r3.append("checked=").append(SettingsUtil.isAccessibilityEnabled(r6, r7.getPackageName())).append(r8);
        r3.append("title=").append(r1).append(r8);
        String r5 = r0.loadDescription(r2);
        if (TextUtils.isEmpty(r5) == false) goto L11;
        r5 = r6.getString(R.string.accessibility_service_default_description);
    L11:
        r3.append("summary=").append(r5).append(r8);
        String r9 = r0.getSettingsActivityName();
        if (TextUtils.isEmpty(r9) == true) goto L14;
        r3.append("settings_title=").append(r6.getString(R.string.accessibility_menu_item_settings)).append(r8);
        r3.append("settings_component_name=").append(new ComponentName(r0.getResolveInfo().serviceInfo.packageName, r9).flattenToString()).append(r8);
    L14:
        r3.append("component_name=").append(r7.flattenToString()).append(r8);
        r3.append("no_warning_dialog=true");
        return r3.toString();
    }

    public static AccessibilityServiceInfo getToggleServiceInfo(Context r7, ComponentName r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        List<AccessibilityServiceInfo> r9 = AccessibilityManager.getInstance(r7).getInstalledAccessibilityServiceList();
        int r1 = r9.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        AccessibilityServiceInfo r3 = r9.get(r2);
        ResolveInfo r4 = r3.getResolveInfo();
        if (r8.getPackageName().equals(r4.serviceInfo.packageName) == false) goto L12;
        if (r8.getClassName().equals(r4.serviceInfo.name) == false) goto L12;
        return r3;
    L12:
        r2 = r2 + 1;
        goto L6
    L13:
        OLog.w(TAG, "getToggleServiceInfo: " + r8 + " not installed, please make sure that.");
        return null;
    }

    public static void launchNewLauncher(Context r2) {
        Intent r0 = new Intent("android.intent.action.MAIN");     // Catch: ActivityNotFoundException -> L4
        r0.setFlags(268435456);     // Catch: ActivityNotFoundException -> L4
        r0.addCategory("android.intent.category.HOME");     // Catch: ActivityNotFoundException -> L4
        r2.startActivity(r0);     // Catch: ActivityNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static List<AccessibilityServiceInfo> getInstalledSpeakingAccessibilityServices(Context r4) {
        ArrayList r0 = new ArrayList();
        String[] r1 = r4.getResources().getStringArray(R.array.accessibility_talkback_apps);
        r0.addAll(AccessibilityManager.getInstance(r4).getInstalledAccessibilityServiceList());
        List r5 = Arrays.asList(r1);
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        AccessibilityServiceInfo r3 = (AccessibilityServiceInfo) r2.next();
        if ((r3.feedbackType & 1) == 0) goto L7;
        if (r5.contains(r3.getResolveInfo().serviceInfo.packageName) == true) goto L4;
        r2.remove();
        goto L4
    L7:
        r2.remove();
        goto L4
    L11:
        return r0;
    }

    public static boolean isGintamaVersion() {
        return "gintama".equals(getDeviceColor());
    }

    public static boolean isScreenRecording(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "screen_recorder_status", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isRecorderRecording(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "recorder_recording_state", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static long getDirectorySize(String r2) {
        return getDirectorySize(new File(r2));
    }

    public static long getDirectorySize(File r6) {
        long r1 = 0;
        if (r6.exists() == true) goto L6;
        return 0;
    L6:
        if (r6.isDirectory() == false) goto L15;
        if (r6.listFiles() != null) goto L10;
        return 0;
    L10:
        File[] r7 = r6.listFiles();
        int r0 = r7.length;
        int r3 = 0;
    L11:
        if (r3 >= r0) goto L13;
        r1 = r1 + getDirectorySize(r7[r3]);
        r3 = r3 + 1;
        goto L11
    L13:
        return r1;
    L15:
        return r6.length();
    }

    public static void setListViewIgnoreAccessibilityItemCount(ListView r1, final int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.setAccessibilityDelegate(new AnonymousClass6(r2));
    }

    public static boolean isCameraInScreen() {
        return SettingsFeature.isWaterDropScreen();
    }

    public static boolean isDesktop(Activity r1) {
        if (r1.getBaseContext() != null) goto L5;
        return false;
    L5:
        return SmtPCUtils.isValidExtDisplayId(r1.getBaseContext());
    }

    public static void createShortcut(Context r2, String r3, Class r4, int r5) {
        Intent r0 = new Intent(r2, r4);
        r0.addFlags(268435456);
        r0.addFlags(VCardConfig.FLAG_CONVERT_PHONETIC_NAME_STRINGS);
        r0.setPackage(r2.getPackageName());
        Intent r6 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        r6.putExtra("android.intent.extra.shortcut.NAME", r3);
        r6.putExtra("android.intent.extra.shortcut.INTENT", r0);
        r6.putExtra("android.intent.extra.shortcut.ICON", createRemoteIcon(r2, r5));
        r2.sendBroadcast(r6);
    }

    private static Bitmap createRemoteIcon(Context r0, int r1) {
        return BitmapFactory.decodeResource(r0.getResources(), r1);
    }

    public static void removeShortcut(Context r2, String r3, ComponentName r4) {
        Intent r0 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        r0.putExtra("android.intent.extra.shortcut.NAME", r3);
        Intent r5 = new Intent("android.intent.action.MAIN");
        r5.setComponent(r4);
        r0.putExtra("android.intent.extra.shortcut.INTENT", r5);
        r2.sendBroadcast(r0);
    }

    public static boolean isAppInstalled(Context r2, String r3) {
        if (r2.getPackageManager().getApplicationInfo(r3, 0) == null) goto L11;
        return true;
    L11:
        return false;
    L7:
        OLog.d(TAG, "app not fond:" + r3);
        return false;
    }

    public static boolean isPackageInLockedBlock(PackageManager r1, String r2) {
        return PackageManagerSmt.getInstance().isPackageAlreadyLocked(r1, r2);
    L4:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "isPackageInLockedBlock: RemoteException");
        return false;
    }

    public static Resources getLocalizedResources(Context r2, Locale r3) {
        Configuration r0 = new Configuration(r2.getResources().getConfiguration());
        r0.setLocale(r3);
        return r2.createConfigurationContext(r0).getResources();
    }

    public static String[] getLocalizedStringArrayResources(Context r0, Locale r1, int r2) {
        return getLocalizedResources(r0, r1).getStringArray(r2);
    }

    public static String getLocalizedStringResources(Context r0, Locale r1, int r2) {
        return getLocalizedResources(r0, r1).getString(r2);
    }

    public static void setUsbCurrentFunction(UsbManager r7, String r8, boolean r9) {
        DeviceType.is(DeviceType.OSCAR);
        UsbManager.class.getMethod("setCurrentFunction", new Class[]{String.class, Boolean.TYPE}).invoke(r7, new Object[]{r8, Boolean.valueOf(r9)});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean isAppRunning(Context r2, String r3) {
        List<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) r2.getSystemService("activity")).getRunningAppProcesses();
        if (r4 != null) goto L5;
        return false;
    L5:
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        if (r5.next().processName.equals(r3) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public static String getBatteryStatus(Resources r4, Intent r5) {
        int r0 = r5.getIntExtra("plugged", 0);
        OLog.d(TAG, "plugType " + r0);
        int r6 = r5.getIntExtra("status", 1);
        if (r6 != 2) goto L13;
        if (r0 != 1) goto L6;
        int r7 = R.string.battery_info_status_charging_ac;
    L22:
        return r4.getString(r7);
    L6:
        if (r0 != 2) goto L8;
        r7 = R.string.battery_info_status_charging_usb;
        goto L22
    L8:
        if (r0 != 4) goto L10;
        r7 = R.string.battery_info_status_charging_wireless;
        goto L22
    L10:
        r7 = R.string.battery_info_status_charging;
        goto L22
    L13:
        if (r6 == 3) goto L23;
        if (r6 != 4) goto L18;
        return r4.getString(R.string.battery_info_status_not_charging);
    L18:
        if (r6 != 5) goto L21;
        return r4.getString(R.string.battery_info_status_full);
    L21:
        return r4.getString(R.string.battery_info_status_unknown);
    L23:
        return r4.getString(R.string.battery_info_status_discharging);
    }

    public static void launchWebsite(Context r2, String r3) {
        Intent r0 = new Intent();
        Uri r4 = Uri.parse(r3);
        r0.setAction("android.intent.action.VIEW");
        r0.setData(r4);
        startActivity(r2, r0);
    }

    public static int getSwitchStateResId(Context r0, String r1, int r2) {
        if (android.provider.Settings.Global.getInt(r0.getContentResolver(), r1, r2) != 1) goto L5;
        return R.string.settings_state_on;
    L5:
        return R.string.settings_state_off;
    }

    public static Drawable getBitmapDrawable(Context r5, Drawable r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        Bitmap r0 = Bitmap.createBitmap(r6.getIntrinsicWidth(), r6.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r0);
        r6.setBounds(0, 0, r1.getWidth(), r1.getHeight());
        r6.draw(r1);
        return new BitmapDrawable(r5.getResources(), r0);
    }

    public static boolean needJumpToSecurity(Context r3, int r4) {
        int[] r0 = mSecurityFeature;
        if (r0 != null) goto L5;
    L6:
        mSecurityFeature = getSecurityFeatureArray(r3);
    L7:
        int[] r5 = mSecurityFeature;
        if (r5 != null) goto L10;
        return false;
    L10:
        if (r5.length >= 0) goto L12;
        return false;
    L12:
        if ((r4 + 1) <= r5.length) goto L14;
        return false;
    L14:
        if (r5[r4] == 1) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (r0.length != 0) goto L7;
        goto L6
    }

    public static int[] getSecurityFeatureArray(Context r5) {
        Context r6 = r5.createPackageContext("com.obric.security", 2);     // Catch: PackageManager.NameNotFoundException -> L7 Resources.NotFoundException -> L9
        int r1 = r6.getResources().getIdentifier("security_feature", "array", "com.obric.security");     // Catch: PackageManager.NameNotFoundException -> L7 Resources.NotFoundException -> L9
        if (r1 <= 0) goto L15;
        return r6.getResources().getIntArray(r1);
    L15:
        return null;
    L7:
        e = move-exception;
        OLog.d(TAG, "needJumpToSecurity NameNotFoundException");
        e.printStackTrace();
        return null;
    L9:
        e = move-exception;
        OLog.d(TAG, "needJumpToSecurity NotFoundException");
        e.printStackTrace();
        return null;
    }

    public static String[] getDoppelgangerAppArray(Context r2) {
        String[] r0 = mDoppelgangerAppArray;
        if (r0 != null) goto L5;
    L6:
        mDoppelgangerAppArray = getOutsideAppArray(r2, "com.obric.security", "recommend_comdoppelganger_app");
    L7:
        String[] r1 = mDoppelgangerAppArray;
        if (r1 != null) goto L10;
    L11:
        mDoppelgangerAppArray = r2.getResources().getStringArray(R.array.recommend_comdoppelganger_app);
    L13:
        return mDoppelgangerAppArray;
    L10:
        if (r1.length != 0) goto L13;
    L5:
        if (r0.length != 0) goto L7;
        goto L6
    }

    public static void calculateTouchOffset(MotionEvent r2, View r3, int[] r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        Rect r5 = getRectInWindow(r3);
        r4[0] = r5.centerX() - ((int) r2.getRawX());
        r4[1] = r5.centerY() - ((int) r2.getRawY());
    }

    public static Rect getRectInWindow(View r3) {
        if (r3 == null) goto L4;
        int[] r0 = new int[2];
        r3.getLocationInWindow(r0);
        Rect r1 = new Rect();
        r1.left = r0[0];
        r1.top = r0[1];
        r1.right = r1.left + r3.getWidth();
        r1.bottom = r1.top + r3.getHeight();
        return r1;
    L4:
        return new Rect();
    }

    public static void doFlyBackAnim(int r10, int r11, int r12, int r13, View r14, Animator.AnimatorListener r15) {
        doFlyBackAnim(r10, r11, r12, r13, DEFAULT_SCALING, DEFAULT_SCALING, 300, new DecelerateInterpolator(1.5f), r14, r15);
    }

    public static void doFlyBackAnim(int r4, int r5, int r6, int r7, float r8, float r9, int r10, Interpolator r11, View r12, Animator.AnimatorListener r13) {
        if (r12 != null) goto L4;
        return;
    L4:
        AnimatorSet r0 = new AnimatorSet();
        r0.playTogether(new Animator[]{ObjectAnimator.ofFloat(r12, "translationX", new float[]{r4, r6}), ObjectAnimator.ofFloat(r12, "translationY", new float[]{r5, r7}), ObjectAnimator.ofFloat(r12, "scaleX", new float[]{r8, 1.0f}), ObjectAnimator.ofFloat(r12, "scaleY", new float[]{r9, 1.0f})});
        r0.setDuration(r10);
        r0.setInterpolator(r11);
        r0.addListener(r13);
        r0.start();
    }

    public static boolean isSetupCompelete(Context r2) {
        if (android.provider.Settings.Secure.getInt(r2.getContentResolver(), "user_setup_complete", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static byte[] bitmap2Bytes(Bitmap r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        r3.compress(Bitmap.CompressFormat.PNG, 100, r0);
        return r0.toByteArray();
    }

    public static Drawable getAppIcon(Context r4, ComponentName r5) {
        if (r5 == null) goto L5;
        PackageManager r1 = r4.getPackageManager();
        Drawable r2 = r1.getActivityIcon(r5);     // Catch: PackageManager.NameNotFoundException -> L14
        if (r2 == null) goto L19;
    L15:
        if (r2 == null) goto L17;
        return r2;
    L17:
        return r4.getDrawable(R.drawable.default_icon);
    L19:
        ActivityInfo r6 = r1.getActivityInfo(r5, 16);     // Catch: PackageManager.NameNotFoundException -> L18
        if (r6 == null) goto L15;
        r2 = r6.loadIcon(r1);     // Catch: PackageManager.NameNotFoundException -> L18
    L14:
        r2 = null;
        goto L15
    L5:
        return r4.getDrawable(R.drawable.default_icon);
    }

    public static Bitmap zoomImage(Bitmap r9, double r10, double r12) {
        float r0 = r9.getWidth();
        float r1 = r9.getHeight();
        Matrix r7 = new Matrix();
        r7.postScale(((float) r10) / r0, ((float) r12) / r1);
        return Bitmap.createBitmap(r9, 0, 0, (int) r0, (int) r1, r7, true);
    }

    public static boolean isPathPrefixMatch(Uri r5, Uri r6) {
        if (Objects.equals(r5.getScheme(), r6.getScheme()) == true) goto L6;
        return false;
    L6:
        if (Objects.equals(r5.getAuthority(), r6.getAuthority()) == true) goto L8;
        return false;
    L8:
        List<String> r7 = r5.getPathSegments();
        List<String> r8 = r6.getPathSegments();
        int r0 = r8.size();
        if (r7.size() >= r0) goto L11;
        return false;
    L11:
        int r2 = 0;
    L12:
        if (r2 >= r0) goto L17;
        if (Objects.equals(r7.get(r2), r8.get(r2)) == false) goto L15;
        r2 = r2 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    public static boolean isNotchStatusBar(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "notch_status_bar_state", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static List<String> array2List(String[] r1) {
        ArrayList r0 = new ArrayList();
        Collections.addAll(r0, r1);
        return r0;
    }

    public static String getSideBarEnabledApp(Context r1) {
        return android.provider.Settings.Global.getString(r1.getContentResolver(), "game_float_app");
    }

    public static void updateSideBarEnabledApp(Context r1, String r2) {
        android.provider.Settings.Global.putString(r1.getContentResolver(), "game_float_app", r2);
    }

    public static String removePackageNameAndUserId(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r4;
    L5:
        if (r4.contains(r5) == false) goto L17;
        String r6 = r4.replaceAll(r5 + ";", "").replaceAll(r5, "");
        if (r6.endsWith(";") == false) goto L10;
        r6 = r6.substring(0, r6.length() - 1);
    L10:
        if (r6.startsWith(";") == true) goto L12;
        return r6;
    L12:
        if (r6.length() <= 1) goto L15;
        return r6.substring(1);
    L15:
        return "";
    L17:
        return r4;
    }

    public static int getNewPhoneFrameResId() {
        String r0 = getDeviceColor();
        if ("white".equals(r0) == false) goto L6;
        return R.drawable.page_theme_preview_phone_white;
    L6:
        if ("pine-green".equals(r0) == false) goto L8;
        return R.drawable.page_theme_preview_phone_pine_green;
    L8:
        return R.drawable.page_theme_preview_phone;
    }

    public static boolean isGame(ApplicationInfo r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (ApplicationInfoSmt.getInstance().isGameApp(r3) == false) goto L8;
    L11:
        return true;
    L8:
        if ((r3.flags & VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING) != 0) goto L11;
        if ((ApplicationInfoSmt.getInstance().getBytedanceFlag(r3) & 4) != 0) goto L11;
        return false;
    }

    public static void sendIntentToAndroid(Context r2) {
        Intent r0 = new Intent(INTENT_SEND_TO_ANDROID_FROM_TEXTBOOM);
        r0.setPackage(RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME);
        r0.addFlags(IntentSmt.get_FLAG_RECEIVER_SM_USER_AWARE());
        r2.sendBroadcast(r0);
    }

    public static boolean checkTaskId(Activity r3, Intent r4) {
        if (r4 == null) goto L10;
        if (r3 == null) goto L10;
        int r5 = r4.getIntExtra("taskId", -1);
        int r6 = r3.getTaskId();
        if (r5 == (-1)) goto L10;
        if (r5 != r6) goto L10;
        return true;
    L10:
        return false;
    }

    public static void removeTask(Context r2, int r3) {
        if (r2 != null) goto L9;
        return;
    L9:
        ActivityManager r4 = (ActivityManager) r2.getSystemService("activity");     // Catch: Exception -> L6
        ActivityManagerSmt.getInstance().removeTask(r4, r3, 0);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static int getCurrentColorMode(Context r2) {
        return android.provider.Settings.Global.getInt(r2.getContentResolver(), "screen_color_mode", 0);
    }

    public static int getPreviousColorMode(Context r2) {
        return android.provider.Settings.Global.getInt(r2.getContentResolver(), "screen_color_mode_previous", 0);
    }

    public static void setCurrentColorMode(Context r1, int r2) {
        android.provider.Settings.Global.putInt(r1.getContentResolver(), "screen_color_mode", r2);
    }

    public static void vibratorUnlockNoPass(Context r1) {
        VibratorHelper.INSTANCE.reject(r1);
    }

    public static void vibratorSwitch(Context r1) {
        VibratorHelper.INSTANCE.press(r1);
    }

    public static void resetOaid(Context r2) {
        android.provider.Settings.Global.putInt(r2.getContentResolver(), "oaid_reset_notify", 1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.e(TAG, "resetOaid error:" + e);
    }

    public static int[] getIntExtraSafely(Intent r2, String r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        return r2.getIntArrayExtra(r3);
    L9:
        OLog.d(TAG, "exception happen when get " + r3);
        return null;
    L14:
        return null;
    }

    public static boolean isSupportProvider(Context r2, String r3) {
        PackageManager r4 = r2.getPackageManager();     // Catch: Exception -> L11
        if (r4 == null) goto L9;
        if (r4.resolveContentProvider(r3, 0) == null) goto L9;
        return true;
    L9:
        OLog.e(TAG, "Provider " + r3 + " is not found");
        return false;
    }

    public static String getStylusName(BluetoothDevice r3, Context r4) {
        String r1 = null;
        HashMap<String, String> r0 = getStylus(r4, Constants.KEY_STYLUS_NAME, null);
        if (r0 == null) goto L6;
        if (r3 == null) goto L6;
        String r2 = r0.get(r3.getAddress());
    L7:
        if (r2 != null) goto L11;
        if (r3 == null) goto L10;
        r1 = r3.getName();
    L10:
        r2 = r1;
    L11:
        if (r2 != null) goto L13;
        r2 = r4.getString(R.string.stylus_default_name);
    L13:
        OLog.i(TAG, "getStylusName:" + r0 + ",name:" + r2 + ",device.getName():" + r3.getName());
        return r2;
    L6:
        r2 = null;
        goto L7
    }

    public static HashMap<String, String> getStylus(Context r2, String r3, String r4) {
        return (HashMap) fromJson(r2.getSharedPreferences(Constants.KEY_CACHE_SETTINGS_STYLUS, 0).getString(r3, r4), new AnonymousClass7());
    }

    public static void putStylus(Context r2, String r3, HashMap<String, String> r4) {
        SharedPreferences.Editor r5 = r2.getSharedPreferences(Constants.KEY_CACHE_SETTINGS_STYLUS, 0).edit();
        r5.putString(r3, toJson(r4));
        r5.commit();
    }

    public static <T> String toJson(Object r1) {
        return JSON_CONVERT.toJson(r1);
    }

    public static <T> T fromJson(String r1, TypeToken<T> r2) {
        return (T) JSON_CONVERT.fromJson(r1, r2.getType());
    }

    public static boolean isFastDoubleClick() {
        return isFastDoubleClick(-1, 1000);
    }

    public static boolean isFastDoubleClick(int r8, long r9) {
        long r0 = System.currentTimeMillis();
        long r2 = sLastClickTime;
        long r4 = r0 - r2;
        if (sLastButtonId == r8) goto L5;
    L12:
        sLastClickTime = r0;
        sLastButtonId = r8;
        return false;
    L5:
        if (r2 <= 0) goto L12;
        if (r4 >= r9) goto L12;
        if (r4 < 0) goto L12;
        return true;
    }

    public static boolean isPackageAlreadyLockedByUserId(PackageManager r1, String r2, int r3) {
        return PackageManagerSmt.getInstance().isPackageAlreadyLocked(r1, r2, r3);
    }

    public static void setAnimatorScale(Context r2) {
        ValueAnimator.setDurationScale(android.provider.Settings.Global.getFloat(r2.getContentResolver(), "animator_duration_scale", 1.0f));
    }

    public static int getResouceId(String r1, String r2, String r3, int r4) {
        int r5 = Resources.getSystem().getIdentifier(r2, r3, r1);     // Catch: Resources.NotFoundException -> L5
        if (r5 <= 0) goto L6;
        return r5;
    L6:
        return r4;
    L5:
        OLog.d("getResouceId", "Can not find resources id");
        goto L6
    }

    public static boolean isPrivacyPasswordEnable(Context r2) {
        if (android.provider.Settings.Secure.getInt(r2.getContentResolver(), "security_privacy", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static int checkVirtualMemorySpace() {
        long r0 = (((long) SystemProperties.getInt(SWAP_FEATURE_PROPERTY_SIZE, 8192)) * 1048576) + 2147483648L;
        File r2 = new File(SWAP_FILE_PATH);
        if (r2.isFile() == false) goto L21;
        if (r2.exists() == false) goto L21;
        if (r2.length() == r0) goto L23;
        return 1;
    L23:
        return -1;
    L21:
        long r5 = FileSystemUtils.freeSpaceKb(LibUtil.EXCEPTION_PATH);     // Catch: IOException -> L13
    L16:
        if (r5 > 0) goto L18;
        return 1;
    L18:
        if ((r5 * 1024) >= r0) goto L25;
        return -2;
    L25:
        return 1;
    L13:
        e = move-exception;
        e.printStackTrace();
        r5 = 0;
        goto L16
    }

    public static boolean isFaceRecognitionDataExist(Context r1) {
        FaceManager r2 = getFaceManagerOrNull(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        return !r2.getEnrolledFaces(UserHandle.myUserId()).isEmpty();
    }

    public static FaceManager getFaceManagerOrNull(Context r2) {
        if (r2.getPackageManager().hasSystemFeature("android.hardware.biometrics.face") == true) goto L5;
        return null;
    L5:
        return (FaceManager) r2.getSystemService("face");
    }

    public static boolean hasFingerprintEnrolled(Context r1) {
        return hasFingerprintEnrolled(r1, UserHandle.myUserId());
    }

    private static boolean hasFingerprintEnrolled(Context r1, int r2) {
        FingerprintManager r3 = (FingerprintManager) r1.getSystemService(FingerprintManager.class);
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.isHardwareDetected() == true) goto L7;
        return false;
    L7:
        return !r3.getEnrolledFingerprints(r2).isEmpty();
    }

    public static boolean isSeDevice() {
        return "SE".equals(SystemProperties.get("ro.vendor.secure_boot", ""));
    L4:
        e = move-exception;
        OLog.e(TAG, "isSeDevice error:" + e);
        return false;
    }

    public static boolean isSupportCTPA(Context r1) {
        return r1.getApplicationContext().getResources().getBoolean(R.bool.config_support_CT_PA);
    }

    public static boolean carrierTableFieldValidate(String r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ("authtype".equalsIgnoreCase(r3) == false) goto L8;
    L15:
        return true;
    L8:
        if (ApnSettings.SUB_ID.equalsIgnoreCase(r3) == true) goto L15;
        String r4 = r3.toUpperCase();
        Telephony.Carriers.class.getDeclaredField(r4);     // Catch: NoSuchFieldException -> L13
        return true;
    L13:
        OLog.w(TAG, r4 + "is not a valid field in class Telephony.Carriers");
        return false;
    }

    public static boolean isSystemAlertWindowEnabled(Context r1) {
        if (((ActivityManager) r1.getSystemService("activity")).isLowRamDevice() == false) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isStopedIntent(Intent r0) {
        if ((r0.getFlags() & 32) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isInsidePackage(Activity r1) {
        return r1.getPackageName().equals(r1.getCallingPackage());
    }

    public static Intent getPasswordIntent(LockscreenCredential r2, boolean r3) {
        Intent r0 = new Intent();
        if (r2 != null) goto L5;
    L8:
        return r0;
    L5:
        if (r2.isNone() == true) goto L8;
        if (r3 == false) goto L8;
        r0.putExtra("password", r2.duplicate());
        goto L8
    }

    public static String getConfirmCredentialStringForUser(Context r1, int r2, int r3) {
        int r4 = UserManager.get(r1).getCredentialOwnerProfile(r2);
        if (UserManager.get(r1).isManagedProfile(r4) == false) goto L6;
        return null;
    L6:
        if (r3 == 1) goto L17;
        if (r3 == 3) goto L15;
        if (r3 == 4) goto L13;
        return null;
    L13:
        return r1.getString(R.string.lockpassword_confirm_your_password_generic);
    L15:
        return r1.getString(R.string.lockpassword_confirm_your_pin_generic);
    L17:
        return r1.getString(R.string.lockpassword_confirm_your_pattern_generic);
    }

    public static int getCredentialType(Context r1, int r2) {
        return new LockPatternUtils(r1).getCredentialTypeForUser(r2);
    }

    public static UserHandle getManagedProfileIn16(UserManager r4) {
        Iterator<UserHandle> r0 = r4.getUserProfiles().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        UserHandle r1 = r0.next();
        if (r1.getIdentifier() == r4.getProcessUserId()) goto L4;
        if (r4.getUserInfo(r1.getIdentifier()).isManagedProfile() == false) goto L4;
        return r1;
    L11:
        return null;
    }

    public static void loadUrlWithExplorer(Context r3, String r4) {
        if (r4 != null) goto L9;
        return;
    L9:
        Intent r0 = new Intent("android.intent.action.VIEW");     // Catch: ActivityNotFoundException -> L6
        r0.setPackage("com.obric.browser");     // Catch: ActivityNotFoundException -> L6
        r0.putExtra("create_new_tab", true);     // Catch: ActivityNotFoundException -> L6
        r0.addCategory("android.intent.category.BROWSABLE");     // Catch: ActivityNotFoundException -> L6
        r0.putExtra("support_dark_mode", true);     // Catch: ActivityNotFoundException -> L6
        r0.setData(Uri.parse(r4));     // Catch: ActivityNotFoundException -> L6
        startActivity(r3, r0);     // Catch: ActivityNotFoundException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static UserHandle getProfileOfType(UserManager r3, int r4) {
        List<UserHandle> r0 = r3.getUserProfiles();
        String r5 = getUmUserType(r4);
        Iterator<UserHandle> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        UserHandle r2 = r1.next();
        if (Objects.equals(r5, r3.getUserInfo(r2.getIdentifier()).userType) == false) goto L4;
        return r2;
    L8:
        return null;
    }

    private static String getUmUserType(int r1) throws IllegalArgumentException {
        if (r1 != 2) goto L7;
        return "android.os.usertype.profile.MANAGED";
    L7:
        if (r1 != 4) goto L11;
        return "android.os.usertype.profile.PRIVATE";
    L11:
        if (r1 != 1) goto L15;
        return "android.os.usertype.full.SYSTEM";
    L15:
        throw new IllegalArgumentException("Cannot get user type for ALL types");
    }
}
