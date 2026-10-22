package com.android.settings.permission;

import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.android.settings.SettingsApplication;
import com.obric.olog.OLog;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OpsManagerHelper {
    private static final String ANDROID_APP_APP_OPS_MANAGER = "android.app.AppOpsManager";
    private static final String ANDROID_APP_SMT_OPS_MANAGER = "android.app.SmtOpsManager";
    private static final String APP_OPS_MANAGER_SMT = "bytedanceos.api.AppOpsManagerSmt";
    private static final String TAG = "OpsManagerHelper";
    private static volatile OpsManagerHelper sInstance;
    private Object mAppOpsManager;
    private final IPackageManager mIPackageManager;
    private boolean mIsSmt;
    private Object mManager;
    private final PackageManager mPackageManager;
    private Object mSmtOpsManager;

    public static OpsManagerHelper getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(OpsManagerHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new OpsManagerHelper(SettingsApplication.getApplication());     // Catch: Throwable -> L11
    L9:
        monitor-exit(OpsManagerHelper.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private OpsManagerHelper(Context r7) {
        this.mIsSmt = false;
        this.mManager = null;
        this.mSmtOpsManager = null;
        this.mAppOpsManager = null;
        Object r3 = ReflectHelper.getStaticVariable("bytedanceos.api.ContextSmt", "SMT_OPS_SERVICE");
        if (r3 != null) goto L9;
        r3 = ReflectHelper.getStaticVariable("android.content.Context", "APP_OPS_SERVICE");
        if (r3 == null) goto L8;
        this.mIsSmt = false;
    L10:
        this.mManager = r7.getSystemService((String) r3);
        this.mSmtOpsManager = r7.getSystemService((String) ReflectHelper.getStaticVariable("bytedanceos.api.ContextSmt", "SMT_OPS_SERVICE"));
        this.mAppOpsManager = r7.getSystemService((String) ReflectHelper.getStaticVariable("android.content.Context", "APP_OPS_SERVICE"));
        this.mPackageManager = SettingsApplication.getApplication().getPackageManager();
        this.mIPackageManager = AppGlobals.getPackageManager();
        return;
    L8:
        throw new RuntimeException("fail to get APP_OPS_SERVICE");
    L9:
        this.mIsSmt = true;
        goto L10
    }

    private static int getProperty(String r3) {
        Object r0 = ReflectHelper.getStaticVariable(ANDROID_APP_SMT_OPS_MANAGER, r3);
        if (r0 != null) goto L14;
        if ("OP_LOCATION".equals(r3) == false) goto L7;
        r3 = "OP_COARSE_LOCATION";
    L7:
        Object r1 = ReflectHelper.getStaticVariable(ANDROID_APP_APP_OPS_MANAGER, r3);
        if (r1 == null) goto L10;
    L12:
        r0 = r1;
        goto L14
    L10:
        if ("OP_NFC_CHANGE".equals(r3) == false) goto L12;
        r3 = "OP_NFC";
        r0 = ReflectHelper.getStaticVariable(ANDROID_APP_APP_OPS_MANAGER, "OP_NFC");
    L14:
        if (r0 == null) goto L16;
    L19:
        if (r0 != null) goto L22;
        return -1;
    L22:
        return ((Integer) r0).intValue();
    L16:
        if ("OP_PROJECT_MEDIA".equals(r3) == true) goto L19;
        OLog.e(TAG, "fail to get property: " + r3);
        return -1;
    }

    private static Object getProperty(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return null;
    L8:
        return ReflectHelper.getStaticVariable(r2, r1);
    }

    public static int get_OP_BOOT_COMPLETED() {
        return getProperty("OP_BOOT_COMPLETED");
    }

    public static int get_OP_THIRD_PARTY_BOOTABLE() {
        return getProperty("OP_THIRD_PARTY_BOOTABLE");
    }

    public static int get_MODE_ALLOWED() {
        return getProperty("MODE_ALLOWED");
    }

    public static int get_MODE_IGNORED() {
        return getProperty("MODE_IGNORED");
    }

    public static int get_MODE_INVALID() {
        return getProperty("MODE_INVALID");
    }

    public static int get_MODE_FOREGROUND() {
        Object r0 = getProperty("MODE_FOREGROUND", ANDROID_APP_APP_OPS_MANAGER);
        if (r0 != null) goto L7;
        return get_MODE_INVALID();
    L7:
        return ((Integer) r0).intValue();
    }

    public static int get_MODE_ASK() {
        return getProperty("MODE_ASK");
    }

    public static int get_MODE_DURING_USE() {
        return getProperty("MODE_DURING_USE");
    }

    public static int get_OP_LOCATION() {
        return getProperty("OP_LOCATION");
    }

    public static int get_OP_SEND_SMS() {
        return getProperty("OP_SEND_SMS");
    }

    public static int get_OP_READ_SMS() {
        return getProperty("OP_READ_SMS");
    }

    public static int get_OP_WRITE_SMS() {
        return getProperty("OP_WRITE_SMS");
    }

    public static int get_OP_SEND_MMS() {
        return getProperty("OP_SEND_MMS");
    }

    public static int get_OP_READ_MMS() {
        return getProperty("OP_READ_MMS");
    }

    public static int get_OP_WRITE_MMS() {
        return getProperty("OP_WRITE_MMS");
    }

    public static int get_OP_CALL_PHONE() {
        return getProperty("OP_CALL_PHONE");
    }

    public static int get_OP_READ_CONTACTS() {
        return getProperty("OP_READ_CONTACTS");
    }

    public static int get_OP_READ_CALL_LOG() {
        return getProperty("OP_READ_CALL_LOG");
    }

    public static int get_OP_DATA_CONNECT_CHANGE() {
        return getProperty("OP_DATA_CONNECT_CHANGE");
    }

    public static int get_OP_WIFI_CHANGE() {
        return getProperty("OP_WIFI_CHANGE");
    }

    public static int get_OP_BLUETOOTH_CHANGE() {
        return getProperty("OP_BLUETOOTH_CHANGE");
    }

    public static int get_OP_NFC_CHANGE() {
        return getProperty("OP_NFC_CHANGE");
    }

    public static int get_OP_RECORD_AUDIO() {
        return getProperty("OP_RECORD_AUDIO");
    }

    public static int get_OP_PROJECT_MEDIA() {
        return getProperty("OP_PROJECT_MEDIA");
    }

    public static int get_OP_CAMERA() {
        return getProperty("OP_CAMERA");
    }

    public static int get_OP_SYSTEM_ALERT_WINDOW() {
        Object r0 = getProperty("OP_SYSTEM_ALERT_WINDOW", ANDROID_APP_APP_OPS_MANAGER);
        if (r0 != null) goto L5;
        return -1;
    L5:
        return ((Integer) r0).intValue();
    }

    public static int get_OP_WRITE_CONTACTS() {
        return getProperty("OP_WRITE_CONTACTS");
    }

    public static int get_OP_WRITE_CALL_LOG() {
        return getProperty("OP_WRITE_CALL_LOG");
    }

    public static int get_OP_NET_MOBILE() {
        return getProperty("OP_NET_MOBILE");
    }

    public static int get_OP_NET_WIFI() {
        return getProperty("OP_NET_WIFI");
    }

    public static int get_OP_KILL_BG_PROC() {
        return getProperty("OP_KILL_BG_PROC");
    }

    public static int get_OP_WRITE_BOOKMARK() {
        return getProperty("OP_WRITE_BOOKMARK");
    }

    public static int get_OP_SHOW_ON_KEYGUARD() {
        return getProperty("OP_SHOW_ON_KEYGUARD");
    }

    public static int get_OP_REQUEST_INSTALL_PACKAGES() {
        return getProperty("OP_REQUEST_INSTALL_PACKAGES");
    }

    public static int get_OP_START_ON_BACKGROUND() {
        return getProperty("OP_START_ON_BACKGROUND");
    }

    public static int get_OP_WRITE_SETTINGS() {
        Object r0 = getProperty("OP_WRITE_SETTINGS", ANDROID_APP_APP_OPS_MANAGER);
        if (r0 != null) goto L5;
        return -1;
    L5:
        return ((Integer) r0).intValue();
    }

    public static int get_NUM_OP() {
        return getProperty("_NUM_OP");
    }

    public boolean setEnabled(boolean r3) {
        boolean r0 = setEnabled(this.mSmtOpsManager, r3, ANDROID_APP_SMT_OPS_MANAGER);
        boolean r2 = setOpsEnabled((AppOpsManager) this.mAppOpsManager, r3);
        if (r0 == false) goto L6;
        if (r2 == false) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean setEnabled(Object r4, boolean r5, String r6) {
        if (r4 != null) goto L5;
    L13:
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        Object r3 = ReflectHelper.invokeProxyMethod(r6, "setEnabled", r4, new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r5)});
        if (r3 == null) goto L12;
        return ((Boolean) r3).booleanValue();
    L12:
        throw new RuntimeException("fail to setEnabled");
    }

    public boolean getEnabled() {
        boolean r0 = getEnabled(this.mSmtOpsManager, ANDROID_APP_SMT_OPS_MANAGER);
        boolean r2 = getOpsEnable((AppOpsManager) this.mAppOpsManager);
        if (r0 == false) goto L6;
        if (r2 == false) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean getEnabled(Object r4, String r5) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L14;
        Object r6 = ReflectHelper.invokeProxyMethod(r5, "getEnabled", r4, new Class[0], new Object[0]);
        if (r6 != null) goto L12;
        OLog.e(TAG, "fail to getEnabled");
        return false;
    L12:
        return ((Boolean) r6).booleanValue();
    L14:
        return false;
    }

    public static boolean getOpsEnable(AppOpsManager r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(APP_OPS_MANAGER_SMT) == true) goto L15;
        Class<?> r1 = Class.forName(APP_OPS_MANAGER_SMT);     // Catch: ReflectiveOperationException -> L9
        Object r2 = r1.getDeclaredMethod("getInstance", new Class[0]).invoke(r1, new Object[0]);     // Catch: ReflectiveOperationException -> L9
        Method r3 = r1.getDeclaredMethod("getEnabled", new Class[]{AppOpsManager.class});     // Catch: ReflectiveOperationException -> L9
        r3.setAccessible(true);     // Catch: ReflectiveOperationException -> L9
        return ((Boolean) r3.invoke(r2, new Object[]{r7})).booleanValue();
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    L15:
        return false;
    }

    public static boolean setOpsEnabled(AppOpsManager r8, boolean r9) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(APP_OPS_MANAGER_SMT) == true) goto L15;
        Class<?> r1 = Class.forName(APP_OPS_MANAGER_SMT);     // Catch: ReflectiveOperationException -> L9
        Object r2 = r1.getDeclaredMethod("getInstance", new Class[0]).invoke(r1, new Object[0]);     // Catch: ReflectiveOperationException -> L9
        Method r3 = r1.getDeclaredMethod("setEnabled", new Class[]{AppOpsManager.class, Boolean.TYPE});     // Catch: ReflectiveOperationException -> L9
        r3.setAccessible(true);     // Catch: ReflectiveOperationException -> L9
        return ((Boolean) r3.invoke(r2, new Object[]{r8, Boolean.valueOf(r9)})).booleanValue();
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    L15:
        return false;
    }

    private String getProxy(int r3) {
        boolean r0 = SpecialAppOpsManager.isSpecialAppOps(r3);
        String r1 = ANDROID_APP_APP_OPS_MANAGER;
        if (r0 == false) goto L6;
        return ANDROID_APP_APP_OPS_MANAGER;
    L6:
        if (r3 <= get_NUM_OP()) goto L8;
        String r4 = ANDROID_APP_APP_OPS_MANAGER;
    L9:
        if (r4 == null) goto L11;
        return r4;
    L11:
        if (this.mIsSmt == false) goto L14;
        r1 = ANDROID_APP_SMT_OPS_MANAGER;
    L14:
        return r1;
    L8:
        r4 = null;
        goto L9
    }

    private Object getLocalManager(String r2) {
        if (r2.equals(ANDROID_APP_SMT_OPS_MANAGER) == false) goto L7;
        return this.mSmtOpsManager;
    L7:
        return this.mAppOpsManager;
    }

    public int getMode(int r10, String r11, int[] r12) {
        int r0 = 0;
        String r1 = getProxy(r12[0]);
        if (SpecialAppOpsManager.isSpecialAppOps(r12[0]) == false) goto L5;
        r12 = new int[]{SpecialAppOpsManager.getRealCodeByVirtualCode(r12[0])};
    L5:
        Object r2 = getLocalManager(r1);
        Object r5 = ReflectHelper.invokeProxyMethod(r1, "getOpsForPackage", r2, new Class[]{Integer.TYPE, String.class, int[].class}, new Object[]{Integer.valueOf(r10), r11, r12});
        if (r5 != null) goto L8;
        int r13 = getOpDefaultMode(r12[0], r10, r11, r1);
    L17:
        if (r2 != this.mAppOpsManager) goto L33;
        if (r13 == 0) goto L33;
        if (r12[0] != get_OP_REQUEST_INSTALL_PACKAGES()) goto L33;
        if (r13 != 3) goto L40;
        ApplicationInfo r14 = this.mPackageManager.getApplicationInfo(r11, 0);     // Catch: Throwable -> L30
        if (r14 == null) goto L28;
        if (this.mIPackageManager.checkUidPermission("android.permission.REQUEST_INSTALL_PACKAGES", r14.uid) == 0) goto L41;
        r0 = 1;
    L41:
        return r0;
    L28:
        r0 = r13;
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L33
    L40:
        return 1;
    L33:
        return r13;
    L8:
        List r6 = (List) r5;
        if (r6.size() > 0) goto L11;
        r13 = getOpDefaultMode(r12[0], r10, r11, r1);
        goto L17
    L11:
        Object r15 = ReflectHelper.invokeProxyMethod(r1 + "$PackageOps", "getOps", r6.get(0), new Class[0], new Object[0]);
        if (r15 == null) goto L37;
        Object r16 = ReflectHelper.invokeProxyMethod(r1 + "$OpEntry", "getMode", ((List) r15).get(0), new Class[0], new Object[0]);
        if (r16 == null) goto L35;
        r13 = ((Integer) r16).intValue();
        goto L17
    L35:
        throw new RuntimeException("fail to getMode");
    L37:
        throw new RuntimeException("fail to getOps");
    }

    private int getOpDefaultMode(int r8, int r9, String r10, String r11) {
        Object r0 = getLocalManager(r11);
        if (this.mIsSmt == true) goto L5;
        int r7 = ((Integer) ReflectHelper.invokeMethod(ANDROID_APP_APP_OPS_MANAGER, "opToSwitch", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r8)})).intValue();
        Object r12 = ReflectHelper.invokeProxyMethod(ANDROID_APP_APP_OPS_MANAGER, "getOpDefaultMode", r0, new Class[]{Integer.TYPE, Integer.TYPE, String.class}, new Object[]{Integer.valueOf(r7), Integer.valueOf(r9), r10});
        if (r12 != null) goto L21;
        r12 = ReflectHelper.invokeProxyMethod(ANDROID_APP_APP_OPS_MANAGER, "getOpDefaultMode", r0, new Class[]{Integer.TYPE, String.class}, new Object[]{Integer.valueOf(r7), r10});
        if (r12 != null) goto L21;
        throw new RuntimeException("fail to getOpDefaultMode appops");
    L21:
        return ((Integer) r12).intValue();
    L5:
        if (r11.equals(ANDROID_APP_SMT_OPS_MANAGER) == false) goto L7;
        Object r13 = ReflectHelper.invokeProxyMethod(ANDROID_APP_SMT_OPS_MANAGER, "getOpDefaultMode", r0, new Class[]{Integer.TYPE, Integer.TYPE, String.class}, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9), r10});
    L8:
        if (r13 == null) goto L12;
        return ((Integer) r13).intValue();
    L12:
        throw new RuntimeException("fail to getOpDefaultMode smtops");
    L7:
        r13 = ReflectHelper.invokeProxyMethod(ANDROID_APP_APP_OPS_MANAGER, "opToDefaultMode", r0, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r8)});
        goto L8
    }

    public void setMode(int r9, int r10, String r11, int r12) {
        String r0 = getProxy(r9);
        if (SpecialAppOpsManager.isSpecialAppOps(r9) == false) goto L5;
        r9 = SpecialAppOpsManager.getRealCodeByVirtualCode(r9);
    L5:
        ReflectHelper.invokeProxyMethod(r0, "setMode", getLocalManager(r0), new Class[]{Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE}, new Object[]{Integer.valueOf(r9), Integer.valueOf(r10), r11, Integer.valueOf(r12)});
    }

    public Object getManager() {
        return this.mManager;
    }

    public Class<?> findOpChangedListener() {
        Class<?> r2 = null;
    L31:
        e = e;
    L32:
        e.printStackTrace();
        return r2;
    L4:
        if (this.mIsSmt == false) goto L6;
        Class<?> r3 = Class.forName(ANDROID_APP_SMT_OPS_MANAGER);     // Catch: ReflectiveOperationException -> L31
    L8:
        if (r3 != null) goto L11;
        OLog.e(TAG, "can't find class ,mIsSmt=" + this.mIsSmt);     // Catch: ReflectiveOperationException -> L31
        return null;
    L11:
        Class<?>[] r1 = r3.getDeclaredClasses();     // Catch: ReflectiveOperationException -> L31
        if (r1 == null) goto L14;
        int r7 = r1.length;     // Catch: ReflectiveOperationException -> L31
        int r0 = 0;
    L20:
        if (r0 >= r7) goto L25;
        Class<?> r4 = r1[r0];     // Catch: ReflectiveOperationException -> L31
        if (TextUtils.equals(r4.getSimpleName(), "OnOpChangedListener") == true) goto L26;
        r0 = r0 + 1;
    L26:
        if (r4 != null) goto L39;
        OLog.e(TAG, "can't find opChangedListener");     // Catch: ReflectiveOperationException -> L29
        return null;
    L29:
        e = e;
        r2 = r4;
        goto L32
    L39:
        return r4;
    L25:
        r4 = null;
        goto L26
    L14:
        if (this.mIsSmt == false) goto L16;
        String r8 = "SmtOpsManager";
    L17:
        OLog.e(TAG, "can't find inner class in =".concat(r8));     // Catch: ReflectiveOperationException -> L31
        return null;
    L16:
        r8 = "AppOpsManager";
        goto L17
    L6:
        r3 = Class.forName(ANDROID_APP_APP_OPS_MANAGER);     // Catch: ReflectiveOperationException -> L31
        goto L8
    }
}
