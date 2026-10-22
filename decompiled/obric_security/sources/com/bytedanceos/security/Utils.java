package com.bytedanceos.security;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.NfcAdapter;
import android.os.Environment;
import android.os.IBinder;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import bytedanceos.util.LogTag;
import com.android.internal.util.DoppelgangerUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.powerusage.BatteryEntry;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.bytedanceos.security.reflect.ReflectHelper;
import com.bytedanceos.security.reflect.SpecialAppOpsManager;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.utils.DeviceType;
import com.obric.olog.OLog;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.security.R;
import java.io.File;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class Utils {
    public static final int BUTTON_WIDTH_H = 480;
    public static final int BUTTON_WIDTH_V = 240;
    private static final long DIFF = 300;
    private static final int EFFECTIVE_CODE_LENGTH = 32;
    public static final int ICON_SIZE_NORMAL = 96;
    public static final String INTENT_ACTION_NATIVE_PACKAGE_DETAIL = "com.bytedanceos.security.action.NATIVE_PACKAGE_DETAIL";
    public static final String INTENT_ACTION_PACKAGE_DETAIL = "com.bytedanceos.security.action.PACKAGE_DETAIL";
    public static final String INTENT_ACTION_PACKAGE_OVERVIEW = "com.bytedanceos.security.action.PACKAGE_OVERVIEW";
    public static final String INTENT_ACTION_RADIO_PERMISSIONS_NEW = "com.bytedanceos.security.action.RADIO_PERMISSIONS_NEW";
    public static final String INTENT_ACTION_SWITCH_PERMISSIONS_NEW = "com.bytedanceos.security.action.SWITCHED_PERMISSIONS_NEW";
    public static final String INTENT_KEY_BACKBTN = "backbutton";
    public static final String INTENT_KEY_DETAIL = "detail";
    public static final String INTENT_KEY_FROM_CENTER = "from_security_center";
    public static final String INTENT_KEY_HIDE_PROMPT = "hide_prompt";
    public static final String INTENT_KEY_INDEX = "index";
    public static final String INTENT_KEY_INFO = "package_info";
    public static final String INTENT_KEY_NATIVE_PERMISSION = "navite_permission";
    public static final String INTENT_KEY_OPS = "ops";
    public static final String INTENT_KEY_PERMISSION = "permission";
    public static final String INTENT_KEY_SHOW_ICON = "show_icon";
    public static final String INTENT_KEY_UID = "uid";
    public static final int MENU_POSITION_ALLOW = 0;
    public static final int MENU_POSITION_DENY = 2;
    public static final int MENU_POSITION_INUSE = 3;
    public static final int MENU_POSITION_PROMPT = 1;
    static final int PERM_GROUP_BOOTABLE = 0;
    static final int PERM_GROUP_LOCATION = 1;
    static final int PERM_GROUP_MEDIA = 4;
    static final int PERM_GROUP_MMS = 3;
    static final int PERM_GROUP_OTHER = 5;
    static final int PERM_GROUP_TELEPHONY = 2;
    public static final int PERM_INDEX_AUTORUN = 18;
    public static final int PERM_INDEX_BOOKMARK = 22;
    public static final int PERM_INDEX_CALL = 0;
    public static final int PERM_INDEX_CALL_LOG = 5;
    public static final int PERM_INDEX_CAMERA = 17;
    public static final int PERM_INDEX_CAPTURE_VIDEO_OUTPUT = 16;
    public static final int PERM_INDEX_CONTACTS = 3;
    static final int PERM_INDEX_COUNT = 30;
    public static final int PERM_INDEX_GET_LOCATION = 12;
    public static final int PERM_INDEX_INSTALL_UNKNOWN_APP = 27;
    public static final int PERM_INDEX_KILL_BACKGROUND_PROCESSES = 21;
    public static final int PERM_INDEX_NET_MOBILE = 13;
    public static final int PERM_INDEX_NET_WLAN = 14;
    public static final int PERM_INDEX_ONOFF_BT = 10;
    public static final int PERM_INDEX_ONOFF_MOBILEDATA = 8;
    public static final int PERM_INDEX_ONOFF_NFC = 11;
    public static final int PERM_INDEX_ONOFF_WIFI = 9;
    public static final int PERM_INDEX_READ_MMS = 7;
    public static final int PERM_INDEX_READ_SMS = 6;
    public static final int PERM_INDEX_RECORD_AUDIO = 15;
    public static final int PERM_INDEX_SEND_MMS = 2;
    public static final int PERM_INDEX_SEND_SMS = 1;
    public static final int PERM_INDEX_SHOW_ON_KEYGUARD = 26;
    public static final int PERM_INDEX_START_ON_BACKGROUND = 28;
    public static final int PERM_INDEX_SYSTEM_WINDOW = 20;
    public static final int PERM_INDEX_THIRD_PARTY_BOOTABLE = 19;
    public static final int PERM_INDEX_WRITE_CALL_LOG = 23;
    public static final int PERM_INDEX_WRITE_CONTACTS = 4;
    public static final int PERM_INDEX_WRITE_MMS = 25;
    public static final int PERM_INDEX_WRITE_SETTINGS = 29;
    public static final int PERM_INDEX_WRITE_SMS = 24;
    static final int PERM_VIEW_TYPE_RADIO = 0;
    static final int PERM_VIEW_TYPE_RADIO_NOPRO = 1;
    static final int PERM_VIEW_TYPE_SWITCH = 2;
    private static String TAG = "Utils";
    public static final int WIDTH_THRESHOLD_H = 720;
    static String[] mGroupResName;
    static final String[][] mMatchedPermissions = null;
    static final int[][] mOpCodes = null;
    static final int[] mParentGroups = null;
    static final boolean[] mPermissionIgnore = null;
    static final int[] mPermissionViewType = null;
    static final int[] mPermissionsOrder = null;
    static final boolean[] mPromptHide = null;
    static final String[] mShortNames = null;
    private static int sLastButtonId;
    private static long sLastClickTime;

    public static class AnimatorInfo {
        long delayDuration;
        long duration;
        Interpolator interpolator;
        String propertyName;
        float[] values;

        public AnimatorInfo(String propertyName, long duration, long delayDuration, Interpolator interpolator, float... values) {
            this.propertyName = propertyName;
            this.duration = duration;
            this.delayDuration = delayDuration;
            this.interpolator = interpolator;
            this.values = values;
        }
    }

    public static boolean isDesktop(Context context) {
        return false;
    }

    public Utils() {
    }

    static {
        mGroupResName = new String[]{"bootable_group_title", "net_location_permission_title", "phone_contact_permission_title", "mms_permission_title", "media_permission_title", "other_group_title"};
        mParentGroups = new int[]{2, 3, 3, 2, 2, 2, 3, 3, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 0, 0, 5, 5, 5, 2, 3, 3, 5, 5, 5, 5};
        mPermissionsOrder = new int[]{9, 14, 15, 10, 11, 12, 16, 17, 2, 3, 6, 7, 8, 4, 5, 21, 20, 22, 0, 1, 28, 30, 31, 13, 18, 19, 29, 26, 40, 27};
        mMatchedPermissions = new String[][]{new String[]{"android.permission.CALL_PHONE"}, new String[]{"android.permission.SEND_SMS"}, new String[]{"android.permission.SEND_SMS"}, new String[]{"android.permission.READ_CONTACTS"}, new String[]{"android.permission.WRITE_CONTACTS"}, new String[]{"android.permission.READ_CALL_LOG"}, new String[]{"android.permission.READ_SMS"}, new String[]{"android.permission.READ_SMS"}, new String[]{"android.permission.CHANGE_NETWORK_STATE"}, new String[]{"android.permission.CHANGE_WIFI_STATE"}, new String[]{"android.permission.BLUETOOTH"}, new String[]{"android.permission.NFC"}, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new String[]{"android.permission.INTERNET"}, new String[]{"android.permission.INTERNET"}, new String[]{"android.permission.RECORD_AUDIO"}, new String[]{"android.permission.CAPTURE_VIDEO_OUTPUT"}, new String[]{"android.permission.CAMERA"}, new String[]{"android.permission.RECEIVE_BOOT_COMPLETED"}, new String[]{"android.permission.RECEIVE_BOOT_COMPLETED"}, new String[]{"android.permission.SYSTEM_ALERT_WINDOW"}, new String[]{"android.permission.KILL_BACKGROUND_PROCESSES", "android.permission.RESTART_PACKAGES"}, new String[]{"com.android.browser.permission.WRITE_HISTORY_BOOKMARKS"}, new String[]{"android.permission.WRITE_CALL_LOG"}, new String[]{"android.permission.WRITE_SMS"}, new String[]{"android.permission.WRITE_SMS"}, new String[]{null}, new String[]{"android.permission.REQUEST_INSTALL_PACKAGES"}, new String[]{null}, new String[]{"android.permission.WRITE_SETTINGS"}};
        mShortNames = new String[]{"call_phone", "send_sms", "send_mms", "read_contacts", "write_contacts", "read_call_log", "read_sms", "read_mms", "change_network_state", "change_wifi_state", "bluetooth", "nfc", "access_fine_location", "net_mobile", "net_wlan", "record_audio", "capture_video_output", "camera", "launch_by_system", "launch_by_app", "system_alert_window", "kill_background_processes", "write_history_bookmarks", "write_call_log", "write_sms", "write_mms", "show_on_keyguard", "install_unknown_app", "start_on_background", "permission_write_settings"};
        mPermissionIgnore = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, true, false, false, false, false, false, false, true, false, true, false};
        mPromptHide = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, true, true, true, true, true, true, false, false, false, false, true, true, true, true};
        mOpCodes = new int[][]{new int[]{OpsManagerHelper.get_OP_CALL_PHONE()}, new int[]{OpsManagerHelper.get_OP_SEND_SMS()}, new int[]{OpsManagerHelper.get_OP_SEND_MMS()}, new int[]{OpsManagerHelper.get_OP_READ_CONTACTS()}, new int[]{OpsManagerHelper.get_OP_WRITE_CONTACTS()}, new int[]{OpsManagerHelper.get_OP_READ_CALL_LOG()}, new int[]{OpsManagerHelper.get_OP_READ_SMS()}, new int[]{OpsManagerHelper.get_OP_READ_MMS()}, new int[]{OpsManagerHelper.get_OP_DATA_CONNECT_CHANGE()}, new int[]{OpsManagerHelper.get_OP_WIFI_CHANGE()}, new int[]{OpsManagerHelper.get_OP_BLUETOOTH_CHANGE()}, new int[]{OpsManagerHelper.get_OP_NFC_CHANGE()}, new int[]{OpsManagerHelper.get_OP_LOCATION()}, new int[]{OpsManagerHelper.get_OP_NET_MOBILE()}, new int[]{OpsManagerHelper.get_OP_NET_WIFI()}, new int[]{OpsManagerHelper.get_OP_RECORD_AUDIO()}, new int[]{OpsManagerHelper.get_OP_PROJECT_MEDIA()}, new int[]{OpsManagerHelper.get_OP_CAMERA()}, new int[]{OpsManagerHelper.get_OP_BOOT_COMPLETED()}, new int[]{OpsManagerHelper.get_OP_THIRD_PARTY_BOOTABLE()}, new int[]{SpecialAppOpsManager.getSystemAlertWindowVirtualCode()}, new int[]{OpsManagerHelper.get_OP_KILL_BG_PROC()}, new int[]{OpsManagerHelper.get_OP_WRITE_BOOKMARK()}, new int[]{OpsManagerHelper.get_OP_WRITE_CALL_LOG()}, new int[]{OpsManagerHelper.get_OP_WRITE_SMS()}, new int[]{OpsManagerHelper.get_OP_WRITE_MMS()}, new int[]{OpsManagerHelper.get_OP_SHOW_ON_KEYGUARD()}, new int[]{OpsManagerHelper.get_OP_REQUEST_INSTALL_PACKAGES()}, new int[]{OpsManagerHelper.get_OP_START_ON_BACKGROUND()}, new int[]{SpecialAppOpsManager.getWriteSettingsVirtualCode()}, new int[]{OpsManagerHelper.get_OP_READ_PHONE_STATE()}};
        int[] r0 = new int[30];
        r0[0] = 0;
        r0[1] = 0;
        r0[2] = 0;
        r0[3] = 0;
        r0[4] = 0;
        r0[5] = 0;
        r0[6] = 0;
        r0[7] = 0;
        r0[8] = 0;
        r0[9] = 0;
        r0[10] = 0;
        r0[11] = 0;
        if (MultiSdkAdapter.isBeforeP() == false) goto L5;
        int r1 = 0;
    L6:
        r0[12] = r1;
        r0[13] = 2;
        r0[14] = 2;
        r0[15] = 0;
        r0[16] = 2;
        r0[17] = 2;
        r0[18] = 2;
        r0[19] = 2;
        r0[20] = 2;
        r0[21] = 2;
        r0[22] = 0;
        r0[23] = 0;
        r0[24] = 0;
        r0[25] = 0;
        r0[26] = 2;
        r0[27] = 2;
        r0[28] = 2;
        r0[29] = 2;
        mPermissionViewType = r0;
        sLastClickTime = 0;
        sLastButtonId = -1;
        return;
    L5:
        r1 = 2;
        goto L6
    }

    public static String shortedPermission(String permission) {
        return permission.substring(permission.lastIndexOf(46) + 1).toLowerCase();
    }

    public static final int dp2Pixels(Context context, float dip) {
        if (context != null) goto L6;
        return 0;
    L6:
        return (int) ((dip * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        return (int) ((pxValue / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void showSoftInputMethod(Context context, EditText editText) {
        InputMethodManager r1 = (InputMethodManager) context.getSystemService("input_method");
        if (r1 != null) goto L5;
        return;
    L5:
        editText.requestFocus();
        r1.showSoftInput(editText, 1);
    }

    public static void hideInputMethod(Context context, IBinder binder) {
        if (context == null) goto L8;
        if (binder == null) goto L9;
        InputMethodManager r1 = (InputMethodManager) context.getSystemService("input_method");
        if (r1 == null) goto L10;
        r1.hideSoftInputFromWindow(binder, 0);
        return;
    L10:
        return;
    L9:
        return;
    }

    public static void showShortToast(Context context, String text) {
        Toast.makeText(context, text, 0).show();
    }

    public static Animator makePropertyAnimator(AnimatorInfo info, View photoFrame) {
        ObjectAnimator r4 = ObjectAnimator.ofPropertyValuesHolder(photoFrame, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(info.propertyName, info.values)});
        r4.setDuration(info.duration);
        r4.setStartDelay(info.delayDuration);
        r4.setInterpolator(info.interpolator);
        return r4;
    }

    public static void setAnimatorScale(Context context) {
        ValueAnimator.setDurationScale(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f));
    }

    public static Bitmap resizeAppIcon(Bitmap bmp) {
        int r3 = bmp.getWidth();
        int r4 = bmp.getHeight();
        float r0 = 96.0f / r3;
        Matrix r5 = new Matrix();
        r5.postScale(r0, r0);
        return Bitmap.createBitmap(bmp, 0, 0, r3, r4, r5, true);
    }

    public static Drawable getResizedApkIcon(ApplicationInfo info, PackageManager pm) {
        Drawable r2 = info.loadIcon(pm);     // Catch: OutOfMemoryError -> L10
        if (UserHandle.getUserId(info.uid) != 10) goto L9;
        if (r2 == null) goto L9;
        if ((r2 instanceof BitmapDrawable) == true) goto L9;
        r2.getClass().getSimpleName().equals("AdaptiveIconDrawable");
    L9:
        return r2;
    L10:
        return null;
    }

    public static boolean isHiddenApp(String packageName) {
        if (packageName != null) goto L4;
    L14:
        return false;
    L4:
        if (packageName.startsWith("com.bytedanceos.theme") == false) goto L6;
    L13:
        return true;
    L6:
        if (packageName.startsWith("com.bytedanceos.launcher.theme") == true) goto L13;
        if (packageName.equals("com.bytedanceos.smartfolder.aoa") == true) goto L13;
        if (packageName.equals("com.bytedanceos.payment") == true) goto L13;
        if (packageName.startsWith("com.mediatek") == false) goto L14;
        goto L13
    }

    public static void deleteFile(File file) {
        if (file.isDirectory() == false) goto L10;
        File[] r0 = file.listFiles();
        if (r0 == null) goto L9;
        int r1 = r0.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        deleteFile(r0[r2]);
        r2 = r2 + 1;
    L9:
        file.delete();
        return;
    L10:
        file.delete();
    }

    public static boolean isDeviceType(String type) {
        if (TextUtils.isEmpty(type) == false) goto L5;
        return false;
    L5:
        Object r2 = ReflectHelper.getStaticVariable(DeviceType.class.getName(), type);
        if (r2 != null) goto L8;
        return false;
    L8:
        return DeviceType.is((DeviceType) r2);
    }

    public static boolean isNfcSupport(Context context) {
        if (isDeviceType(SmtDevice.DELTA) == false) goto L6;
        return false;
    L6:
        if (DeviceType.is(DeviceType.ODIN) == false) goto L10;
        return "advanced".equals(SystemProperties.get("ro.version_id"));
    L10:
        if (DeviceType.is(DeviceType.M1) == false) goto L12;
    L23:
        PackageManager r5 = context.getPackageManager();
        if (r5 != null) goto L27;
        return false;
    L27:
        return r5.hasSystemFeature("android.hardware.nfc");
    L12:
        if (DeviceType.is(DeviceType.M1L) == true) goto L23;
        int r0 = SystemProperties.getInt("ro.enable_nfc", 0);
        NfcAdapter r6 = NfcAdapter.getDefaultAdapter(context);
        StringBuilder r2 = new StringBuilder("ro.enable_nfc = ");
        if (r0 != 1) goto L17;
        boolean r4 = true;
    L18:
        LogTag.d("isNfcSupport", r2.append(r4).append(",nfcAdapter=").append(r6).toString());
        if (r6 == null) goto L28;
        if (r0 == 1) goto L22;
        return false;
    L22:
        return true;
    L28:
        return false;
    L17:
        r4 = false;
        goto L18
    }

    public static Drawable getDoppelgangerDrawableIcon(Resources resources, BitmapDrawable drawable) {
        return new BitmapDrawable(resources, DoppelgangerUtils.getDoppelgangerBitmap(drawable.getBitmap()));
    }

    public static int getResouceId(String packageName, String name, String type, int defaultValue) {
        int r1 = Resources.getSystem().getIdentifier(name, type, packageName);     // Catch: Resources.NotFoundException -> L6
        if (r1 <= 0) goto L5;
        return r1;
    L5:
        return defaultValue;
    }

    public static int getSMTResouceId(Context oriContext, String packageName, String name, String type, int defaultValue) {
        Context r1 = oriContext.createPackageContext(packageName, 2);     // Catch: Resources.NotFoundException -> L6 PackageManager.NameNotFoundException -> L9
        int r2 = r1.getResources().getIdentifier(name, type, r1.getPackageName());     // Catch: Resources.NotFoundException -> L6 PackageManager.NameNotFoundException -> L9
        if (r2 <= 0) goto L8;
        return r2;
    L6:
        e = move-exception;
        e.printStackTrace();
    L8:
        return defaultValue;
    }

    public static boolean hasTelephonyFeature(Context context) {
        if (context != null) goto L5;
        return false;
    L5:
        PackageManager r1 = context.getPackageManager();
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.hasSystemFeature("android.hardware.telephony");
    }

    public static boolean isPackageInstalled(Context context, String pkg) {
        if (pkg != null) goto L5;
        return false;
    L5:
        PackageInfo r1 = null;
        PackageManager r2 = context.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L13
        if (r2 == null) goto L10;
        r1 = r2.getPackageInfo(pkg, 0);     // Catch: PackageManager.NameNotFoundException -> L13
    L10:
        if (r1 == null) goto L16;
        return true;
    L16:
        return false;
    }

    public static String[] spliteSizeStr(String str) {
        if (str != null) goto L5;
        return null;
    L5:
        String r5 = str.replaceAll(" ", "");
        Matcher r0 = Pattern.compile("(\\d+(\\.\\d+)?)").matcher(r5);
        String[] r1 = {"", ""};
        if (r0.find() == false) goto L8;
        int r2 = r0.group(1).length();
        r1[0] = r5.substring(0, r2);
        r1[1] = r5.substring(r2, r5.length());
    L8:
        return r1;
    }

    public static int getSettingSupportVersion(Context context) {
        Context r5 = context.createPackageContext(BatteryEntry.SETTING_PACKAGE, 2);     // Catch: PackageManager.NameNotFoundException -> L7 Resources.NotFoundException -> L8
        int r1 = r5.getResources().getIdentifier("support_security_version", "integer", BatteryEntry.SETTING_PACKAGE);     // Catch: PackageManager.NameNotFoundException -> L7 Resources.NotFoundException -> L8
        if (r1 <= 0) goto L13;
        return r5.getResources().getInteger(r1);
    L13:
        return 0;
    L7:
        OLog.d("getSettingSupportVersion", "support_security_version NameNotFoundException");
        return 0;
    L8:
        OLog.d("getSettingSupportVersion", "support_security_version NotFoundException");
        return 0;
    }

    public static boolean isWifiNetwork(Context context) {
        if (context == null) goto L12;
        ConnectivityManager r2 = (ConnectivityManager) context.getSystemService("connectivity");
        if (r2 == null) goto L13;
        NetworkInfo r3 = r2.getActiveNetworkInfo();
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r3.getType() == 1) goto L11;
        return false;
    L11:
        return true;
    L13:
        return false;
    L12:
        return false;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager r1 = (ConnectivityManager) context.getSystemService("connectivity");
        if (r1 != null) goto L5;
        return false;
    L5:
        NetworkInfo r2 = r1.getActiveNetworkInfo();
        if (r2 != null) goto L8;
        return false;
    L8:
        if (r2.isConnected() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isLanguageZH(Context context) {
        Locale r1 = context.getResources().getConfiguration().locale;
        String r0 = r1.getLanguage().toLowerCase();
        r1.getCountry().toLowerCase();
        if (r0.endsWith("zh") == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean screenRecordIsShowing(Context context) {
        if (context != null) goto L6;
        return false;
    L6:
        if (Settings.Global.getInt(context.getContentResolver(), "screen_recorder_show_status", 0) == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public static String fillMD5(Context context, String string) {
        String r0 = context.getString(R.string.empty_imei);
        if (string == null) goto L14;
        if (string.length() <= 32) goto L9;
        return fillMD5(context, r0).substring(0, 32);
    L9:
        if (string.length() != 32) goto L12;
        return string;
    L12:
        return fillMD5(context, r0 + string);
    L14:
        return fillMD5(context, r0);
    }

    public static String getAndroidId(Context context) {
        String r0 = Settings.Secure.getString(context.getContentResolver(), "android_id");     // Catch: Exception -> L4
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L4
        r1.update(r0.getBytes());     // Catch: Exception -> L4
        return fillMD5(context, new BigInteger(1, r1.digest()).toString(16));
    L4:
        e = move-exception;
        String r3 = fillMD5(context, context.getResources().getString(R.string.empty_imei));
        LogTag.d(TAG, e.getMessage());
        return r3;
    }

    public static String getIMEIByBytedance() {
        Class<?> r1 = Class.forName("bytedanceos.util.Utils");     // Catch: Exception -> L18
        if (r1 != null) goto L6;
        return null;
    L6:
        Method r2 = r1.getDeclaredMethod("getBytedanceID", new Class[]{Context.class});     // Catch: Exception -> L18
        if (r2 != null) goto L10;
        return null;
    L10:
        if (r2.isAccessible() == true) goto L12;
        r2.setAccessible(true);     // Catch: Exception -> L18
    L12:
        Object r3 = r2.invoke(null, new Object[]{SecurityCenterApplication.getContext()});     // Catch: Exception -> L18
        if (r3 == null) goto L23;
        return (String) r3;
    L23:
        return null;
    L18:
        e = move-exception;
        LogTag.d(TAG, e.getMessage());
        return null;
    }

    public static String getAbsolutePath(Context context) {
        if (context != null) goto L5;
        context = SecurityCenterApplication.getContext();
    L5:
        return Environment.getExternalStorageDirectory().getAbsolutePath() + context.getResources().getString(R.string.apk_nouse_path);
    }

    public static String getSubStringPath(String string) {
        if (string != null) goto L4;
        return string;
    L4:
        if (string.contains(LibrarianImpl.Constants.SEPARATOR) == true) goto L6;
        return string;
    L6:
        return string.substring(0, string.lastIndexOf(LibrarianImpl.Constants.SEPARATOR));
    }

    public static boolean isNeedSetWidth(Context context) {
        if (context != null) goto L5;
        return false;
    L5:
        if (isDesktop(context) == true) goto L8;
        return false;
    L8:
        if (context.getResources().getConfiguration().screenWidthDp < 720) goto L12;
        return true;
    L12:
        return false;
    }

    public static void updateViewWidth(View view, Context context) {
        ViewGroup.LayoutParams r0 = view.getLayoutParams();
        ViewParent r1 = view.getParent();
        if (isDesktop(context) == false) goto L11;
        if ((view instanceof OListView) == false) goto L8;
        view.setVerticalScrollBarEnabled(false);
    L8:
        if ((r1 instanceof OScrollView) == false) goto L11;
        ((OScrollView) r1).setVerticalScrollBarEnabled(false);
    L11:
        if (isNeedSetWidth(context) == true) goto L13;
    L15:
        view.setLayoutParams(r0);
        return;
    L13:
        if (isDesktop(context) == false) goto L15;
        r0.width = dp2Pixels(context, 720.0f);
        goto L15
    }

    public static boolean support5G() {
        if (MultiSdkAdapter.isAfterQ() == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isFastDoubleClick() {
        return isFastDoubleClick(-1, 300);
    }

    public static boolean isFastDoubleClick(int buttonId, long diff) {
        long r0 = System.currentTimeMillis();
        long r2 = sLastClickTime;
        long r4 = r0 - r2;
        if (sLastButtonId == buttonId) goto L5;
    L10:
        sLastClickTime = r0;
        sLastButtonId = buttonId;
        return false;
    L5:
        if (r2 <= 0) goto L10;
        if (r4 >= diff) goto L10;
        return true;
    }
}
