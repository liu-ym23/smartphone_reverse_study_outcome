package com.qti.snapdragon.sdk.display;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.slice.core.SliceHints;
import com.android.settings.utils.HanziToPinyin;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class ColorManager {
    public static final long BITFLAG_COLOR_BALANCE = 0;
    public static final long BITFLAG_GLOBAL_PICTURE_ADJUSTMENT = 0;
    public static final long BITFLAG_MEMORY_COLOR_FOLIAGE = 0;
    public static final long BITFLAG_MEMORY_COLOR_SKIN = 0;
    public static final long BITFLAG_MEMORY_COLOR_SKY = 0;
    public static final int COLOR_BALANCE_WARMTH_LOWER_BOUND = -100;
    public static final int COLOR_BALANCE_WARMTH_UPPER_BOUND = 100;
    private static final int INIT_VALUE = -999;
    public static final int MODE_NAME_MAX_LENGTH = 32;
    private static final int NUM_DISPLAY_TYPES = 3;
    private static int PA_GLOBAL_CON = 0;
    private static int PA_GLOBAL_DESAT = 0;
    private static int PA_GLOBAL_DISABLE = 0;
    private static int PA_GLOBAL_HUE = 0;
    private static int PA_GLOBAL_SAT = 0;
    private static int PA_GLOBAL_SAT_THRESH = 0;
    private static int PA_GLOBAL_VAL = 0;
    private static final String REMOTE_SERVICE_NAME = null;
    public static final int RET_FAILURE = -999;
    public static final int RET_FEATURE_DISABLED = -905;
    public static final int RET_ILLEGAL_ARGUMENT = -904;
    public static final int RET_NOT_SUPPORTED = -901;
    public static final int RET_PERMISSION_DENIED = -903;
    public static final int RET_SUCCESS = 0;
    public static final int RET_VALUE_OUT_OF_RANGE = -902;
    private static final String SERVICE_INTENT_NAME = "com.qti.service.colorservice.ColorServiceApp";
    private static final String SERVICE_INTENT_PACKAGE = "com.qti.service.colorservice";
    private static final String SERVICE_PKG_NAME = "com.qti.service.colorservice";
    private static String TAG = "ColorManager";
    private static boolean VERBOSE_ENABLED = true;
    private static ColorManagerListener colorMgrListener = null;
    private static DisplayConn conn = null;
    private static boolean isConnecting = false;
    private static ColorManager[] myInstance = null;
    private static final String permission = "com.qti.snapdragon.sdk.permission.DISPLAY_SETTINGS";
    private static IColorService service;
    private static Context serviceContext;
    private int displayId;
    private boolean isSystemApp;
    HashMap<String, Integer> memColorRanges;
    private Application myApplication;
    HashMap<String, Integer> paRanges;

    /* JADX INFO: renamed from: com.qti.snapdragon.sdk.display.ColorManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final enum ACTIVE_FEATURE_TYPE extends Enum<ACTIVE_FEATURE_TYPE> {
        private static final /* synthetic */ ACTIVE_FEATURE_TYPE[] $VALUES = null;
        public static final ACTIVE_FEATURE_TYPE FEATURE_ADAPTIVE_BACKLIGHT = null;
        public static final ACTIVE_FEATURE_TYPE FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT = null;
        private int value;

        public static ACTIVE_FEATURE_TYPE valueOf(String r1) {
            return (ACTIVE_FEATURE_TYPE) Enum.valueOf(ACTIVE_FEATURE_TYPE.class, r1);
        }

        public static ACTIVE_FEATURE_TYPE[] values() {
            return (ACTIVE_FEATURE_TYPE[]) $VALUES.clone();
        }

        static {
            ACTIVE_FEATURE_TYPE r0 = new ACTIVE_FEATURE_TYPE("FEATURE_ADAPTIVE_BACKLIGHT", 0, 0);
            FEATURE_ADAPTIVE_BACKLIGHT = r0;
            ACTIVE_FEATURE_TYPE r1 = new ACTIVE_FEATURE_TYPE("FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT", 1, 1);
            FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT = r1;
            $VALUES = new ACTIVE_FEATURE_TYPE[]{r0, r1};
        }

        private ACTIVE_FEATURE_TYPE(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        protected int getValue() {
            return this.value;
        }
    }

    public static final enum ADAPTIVE_BACKLIGHT_QUALITY_LEVEL extends Enum<ADAPTIVE_BACKLIGHT_QUALITY_LEVEL> {
        private static final /* synthetic */ ADAPTIVE_BACKLIGHT_QUALITY_LEVEL[] $VALUES = null;
        public static final ADAPTIVE_BACKLIGHT_QUALITY_LEVEL AUTO = null;
        public static final ADAPTIVE_BACKLIGHT_QUALITY_LEVEL HIGH = null;
        public static final ADAPTIVE_BACKLIGHT_QUALITY_LEVEL LOW = null;
        public static final ADAPTIVE_BACKLIGHT_QUALITY_LEVEL MEDIUM = null;
        private int value;

        public static ADAPTIVE_BACKLIGHT_QUALITY_LEVEL valueOf(String r1) {
            return (ADAPTIVE_BACKLIGHT_QUALITY_LEVEL) Enum.valueOf(ADAPTIVE_BACKLIGHT_QUALITY_LEVEL.class, r1);
        }

        public static ADAPTIVE_BACKLIGHT_QUALITY_LEVEL[] values() {
            return (ADAPTIVE_BACKLIGHT_QUALITY_LEVEL[]) $VALUES.clone();
        }

        static {
            ADAPTIVE_BACKLIGHT_QUALITY_LEVEL r0 = new ADAPTIVE_BACKLIGHT_QUALITY_LEVEL("LOW", 0, 0);
            LOW = r0;
            ADAPTIVE_BACKLIGHT_QUALITY_LEVEL r1 = new ADAPTIVE_BACKLIGHT_QUALITY_LEVEL("MEDIUM", 1, 1);
            MEDIUM = r1;
            ADAPTIVE_BACKLIGHT_QUALITY_LEVEL r3 = new ADAPTIVE_BACKLIGHT_QUALITY_LEVEL("HIGH", 2, 2);
            HIGH = r3;
            ADAPTIVE_BACKLIGHT_QUALITY_LEVEL r5 = new ADAPTIVE_BACKLIGHT_QUALITY_LEVEL("AUTO", 3, 3);
            AUTO = r5;
            $VALUES = new ADAPTIVE_BACKLIGHT_QUALITY_LEVEL[]{r0, r1, r3, r5};
        }

        private ADAPTIVE_BACKLIGHT_QUALITY_LEVEL(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        protected int getValue() {
            return this.value;
        }
    }

    private static final enum CONTROL_REQUEST_TYPE extends Enum<CONTROL_REQUEST_TYPE> {
        private static final /* synthetic */ CONTROL_REQUEST_TYPE[] $VALUES = null;
        public static final CONTROL_REQUEST_TYPE OFF = null;
        public static final CONTROL_REQUEST_TYPE ON = null;
        private int value;

        public static CONTROL_REQUEST_TYPE valueOf(String r1) {
            return (CONTROL_REQUEST_TYPE) Enum.valueOf(CONTROL_REQUEST_TYPE.class, r1);
        }

        public static CONTROL_REQUEST_TYPE[] values() {
            return (CONTROL_REQUEST_TYPE[]) $VALUES.clone();
        }

        static {
            CONTROL_REQUEST_TYPE r0 = new CONTROL_REQUEST_TYPE("ON", 0, 0);
            ON = r0;
            CONTROL_REQUEST_TYPE r1 = new CONTROL_REQUEST_TYPE("OFF", 1, 1);
            OFF = r1;
            $VALUES = new CONTROL_REQUEST_TYPE[]{r0, r1};
        }

        private CONTROL_REQUEST_TYPE(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        protected int getValue() {
            return this.value;
        }
    }

    public interface ColorManagerListener {
        void onConnected();
    }

    public static final enum DCM_DISPLAY_TYPE extends Enum<DCM_DISPLAY_TYPE> {
        private static final /* synthetic */ DCM_DISPLAY_TYPE[] $VALUES = null;
        public static final DCM_DISPLAY_TYPE DISP_EXTERNAL = null;
        public static final DCM_DISPLAY_TYPE DISP_PRIMARY = null;
        public static final DCM_DISPLAY_TYPE DISP_WIFI = null;
        private int value;

        public static DCM_DISPLAY_TYPE valueOf(String r1) {
            return (DCM_DISPLAY_TYPE) Enum.valueOf(DCM_DISPLAY_TYPE.class, r1);
        }

        public static DCM_DISPLAY_TYPE[] values() {
            return (DCM_DISPLAY_TYPE[]) $VALUES.clone();
        }

        static {
            DCM_DISPLAY_TYPE r0 = new DCM_DISPLAY_TYPE("DISP_PRIMARY", 0, 0);
            DISP_PRIMARY = r0;
            DCM_DISPLAY_TYPE r1 = new DCM_DISPLAY_TYPE("DISP_EXTERNAL", 1, 1);
            DISP_EXTERNAL = r1;
            DCM_DISPLAY_TYPE r3 = new DCM_DISPLAY_TYPE("DISP_WIFI", 2, 2);
            DISP_WIFI = r3;
            $VALUES = new DCM_DISPLAY_TYPE[]{r0, r1, r3};
        }

        private DCM_DISPLAY_TYPE(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        protected int getValue() {
            return this.value;
        }
    }

    public static final enum DCM_FEATURE extends Enum<DCM_FEATURE> {
        private static final /* synthetic */ DCM_FEATURE[] $VALUES = null;
        public static final DCM_FEATURE FEATURE_ADAPTIVE_BACKLIGHT = null;
        public static final DCM_FEATURE FEATURE_COLOR_BALANCE = null;
        public static final DCM_FEATURE FEATURE_COLOR_MODE_MANAGEMENT = null;
        public static final DCM_FEATURE FEATURE_COLOR_MODE_SELECTION = null;
        public static final DCM_FEATURE FEATURE_GLOBAL_PICTURE_ADJUSTMENT = null;
        public static final DCM_FEATURE FEATURE_MEMORY_COLOR_ADJUSTMENT = null;
        public static final DCM_FEATURE FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT = null;
        private int value;

        public static DCM_FEATURE valueOf(String r1) {
            return (DCM_FEATURE) Enum.valueOf(DCM_FEATURE.class, r1);
        }

        public static DCM_FEATURE[] values() {
            return (DCM_FEATURE[]) $VALUES.clone();
        }

        static {
            DCM_FEATURE r0 = new DCM_FEATURE("FEATURE_COLOR_BALANCE", 0, 0);
            FEATURE_COLOR_BALANCE = r0;
            DCM_FEATURE r1 = new DCM_FEATURE("FEATURE_COLOR_MODE_SELECTION", 1, 1);
            FEATURE_COLOR_MODE_SELECTION = r1;
            DCM_FEATURE r3 = new DCM_FEATURE("FEATURE_COLOR_MODE_MANAGEMENT", 2, 2);
            FEATURE_COLOR_MODE_MANAGEMENT = r3;
            DCM_FEATURE r5 = new DCM_FEATURE("FEATURE_ADAPTIVE_BACKLIGHT", 3, 3);
            FEATURE_ADAPTIVE_BACKLIGHT = r5;
            DCM_FEATURE r7 = new DCM_FEATURE("FEATURE_GLOBAL_PICTURE_ADJUSTMENT", 4, 4);
            FEATURE_GLOBAL_PICTURE_ADJUSTMENT = r7;
            DCM_FEATURE r9 = new DCM_FEATURE("FEATURE_MEMORY_COLOR_ADJUSTMENT", 5, 5);
            FEATURE_MEMORY_COLOR_ADJUSTMENT = r9;
            DCM_FEATURE r11 = new DCM_FEATURE("FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT", 6, 6);
            FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT = r11;
            $VALUES = new DCM_FEATURE[]{r0, r1, r3, r5, r7, r9, r11};
        }

        private DCM_FEATURE(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        protected int getValue() {
            return this.value;
        }
    }

    private static class DisplayConn implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
        }

        private DisplayConn() {
        }

        /* synthetic */ DisplayConn(AnonymousClass1 r1) {
            this();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r1, IBinder r2) {
            if (ColorManager.access$100() != null) goto L6;
            Log.e(ColorManager.access$200(), "Listener is null");
            return;
        L6:
            ColorManager.access$302(IColorService.Stub.asInterface(r2));
            if (ColorManager.access$400() != true) goto L9;
            Log.v(ColorManager.access$200(), "Callback called");
            ColorManager.access$100().onConnected();
        L10:
            ColorManager.access$402(false);
            return;
        L9:
            Log.v(ColorManager.access$200(), "Callback not called");
            goto L10
        }
    }

    protected static class Log {
        protected Log() {
        }

        protected static void i(String r1, String r2) {
            if (ColorManager.access$500() == false) goto L6;
            android.util.Log.i(r1, r2);
            return;
        }

        protected static void d(String r1, String r2) {
            if (ColorManager.access$500() == false) goto L6;
            android.util.Log.d(r1, r2);
            return;
        }

        protected static void e(String r0, String r1) {
            android.util.Log.e(r0, r1);
        }

        protected static void v(String r1, String r2) {
            if (ColorManager.access$500() == false) goto L6;
            android.util.Log.v(r1, r2);
            return;
        }
    }

    public static final enum MODE_TYPE extends Enum<MODE_TYPE> {
        private static final /* synthetic */ MODE_TYPE[] $VALUES = null;
        public static final MODE_TYPE MODE_ALL = null;
        public static final MODE_TYPE MODE_SYSTEM = null;
        public static final MODE_TYPE MODE_USER = null;
        private int value;

        public static MODE_TYPE valueOf(String r1) {
            return (MODE_TYPE) Enum.valueOf(MODE_TYPE.class, r1);
        }

        public static MODE_TYPE[] values() {
            return (MODE_TYPE[]) $VALUES.clone();
        }

        static {
            MODE_TYPE r0 = new MODE_TYPE("MODE_SYSTEM", 0, 0);
            MODE_SYSTEM = r0;
            MODE_TYPE r1 = new MODE_TYPE("MODE_USER", 1, 1);
            MODE_USER = r1;
            MODE_TYPE r3 = new MODE_TYPE("MODE_ALL", 2, 2);
            MODE_ALL = r3;
            $VALUES = new MODE_TYPE[]{r0, r1, r3};
        }

        private MODE_TYPE(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        protected int getValue() {
            return this.value;
        }
    }

    static /* synthetic */ ColorManagerListener access$100() {
        return colorMgrListener;
    }

    static /* synthetic */ String access$200() {
        return TAG;
    }

    static /* synthetic */ IColorService access$302(IColorService r0) {
        service = r0;
        return r0;
    }

    static /* synthetic */ boolean access$400() {
        return isConnecting;
    }

    static /* synthetic */ boolean access$402(boolean r0) {
        isConnecting = r0;
        return r0;
    }

    static /* synthetic */ boolean access$500() {
        return VERBOSE_ENABLED;
    }

    static {
        BITFLAG_COLOR_BALANCE = Long.parseLong("1", 2);
        BITFLAG_GLOBAL_PICTURE_ADJUSTMENT = Long.parseLong("10", 2);
        BITFLAG_MEMORY_COLOR_SKIN = Long.parseLong("100", 2);
        BITFLAG_MEMORY_COLOR_SKY = Long.parseLong("1000", 2);
        BITFLAG_MEMORY_COLOR_FOLIAGE = Long.parseLong("10000", 2);
        PA_GLOBAL_HUE = 1;
        PA_GLOBAL_SAT = 2;
        PA_GLOBAL_VAL = 4;
        PA_GLOBAL_CON = 8;
        PA_GLOBAL_SAT_THRESH = 16;
        PA_GLOBAL_DESAT = 32;
        PA_GLOBAL_DISABLE = 64;
        myInstance = new ColorManager[3];
        REMOTE_SERVICE_NAME = IColorService.class.getName();
        serviceContext = null;
        conn = new DisplayConn(null);
        isConnecting = false;
    }

    public static int connect(Context r6, ColorManagerListener r7) {
        if (r6 == null) goto L35;
        if (r7 == null) goto L35;
        if (r6.getApplicationContext().checkCallingOrSelfPermission(permission) == 0) goto L9;
        Log.e(TAG, "Required permission 'com.qti.snapdragon.sdk.permission.DISPLAY_SETTINGS' is missing");
        return -999;
    L9:
        colorMgrListener = r7;
        serviceContext = r6;
        if (isConnecting == false) goto L14;
        Log.v(TAG, "Connection already in progress");
        return -999;
    L14:
        if (isServiceRunning() == false) goto L21;
        Log.v(TAG, "Service running");
        Intent r8 = new Intent();
        r8.setClassName("com.qti.service.colorservice", SERVICE_INTENT_NAME);
        if (r6.getApplicationContext().bindService(r8, conn, 1) != true) goto L19;
        Log.v(TAG, "Running service bound");
        colorMgrListener.onConnected();
        return 0;
    L19:
        Log.e(TAG, "Bind failed even when service is running");
        return -999;
    L21:
        Log.v(TAG, "Service is not running");
        isConnecting = true;     // Catch: SecurityException -> L32
        r6.getApplicationContext().unbindService(conn);     // Catch: Exception -> L25 SecurityException -> L32
    L27:
        Intent r9 = new Intent();     // Catch: SecurityException -> L32
        r9.setClassName("com.qti.service.colorservice", SERVICE_INTENT_NAME);     // Catch: SecurityException -> L32
        if (r6.getApplicationContext().bindService(r9, conn, 1) != true) goto L30;
        return 0;
    L30:
        Log.e(TAG, "Failed to connect to remote service");     // Catch: SecurityException -> L32
        isConnecting = false;     // Catch: SecurityException -> L32
        return -999;
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: SecurityException -> L32
    L32:
        e = move-exception;
        isConnecting = false;
        e.printStackTrace();
        return -999;
    L35:
        Log.e(TAG, "One of the parmeter passed is null");
        return RET_ILLEGAL_ARGUMENT;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private ColorManager(Application r3, int r4) {
        boolean r0 = false;
        this.isSystemApp = false;
        this.memColorRanges = new HashMap();
        this.paRanges = new HashMap();
        if (service == null) goto L10;
        this.myApplication = r3;
        if ((r3.getApplicationInfo().flags & 129) == 0) goto L7;
        r0 = true;
    L7:
        this.isSystemApp = r0;
        Log.v(TAG, "System app? " + this.isSystemApp);
        this.displayId = r4;
        return;
    L10:
        throw new IllegalStateException("Failed to find IService by name [" + REMOTE_SERVICE_NAME + "]");
    }

    public static ColorManager getInstance(Application r5, Context r6, DCM_DISPLAY_TYPE r7) throws IllegalArgumentException {
        if (r5 == null) goto L22;
        if (r6 == null) goto L22;
        if (r7 != null) goto L7;
        Log.e(TAG, "Display Id passed is null");
        throw new IllegalArgumentException("Display ID passed is null");
    L7:
        if (r5.checkCallingOrSelfPermission(permission) == 0) goto L11;
        Log.e(TAG, "Required permission 'com.qti.snapdragon.sdk.permission.DISPLAY_SETTINGS' is missing");
        return null;
    L11:
        if (myInstance[r7.getValue()] == null) goto L24;
        Log.v(TAG, "Returning existing instance");
        return myInstance[r7.getValue()];
    L24:
        myInstance[r7.getValue()] = new ColorManager(r5, r7.getValue());     // Catch: Exception -> L15
        Log.v(TAG, "Instance created for display type " + r7);     // Catch: Exception -> L15
        return myInstance[r7.getValue()];
    L15:
        e = move-exception;
        e.printStackTrace();
        myInstance[r7.getValue()] = null;
        return null;
    L22:
        Log.e(TAG, "Application or context passed is null");
        throw new IllegalArgumentException("Null passed for Application or context");
    }

    public boolean isFeatureSupported(DCM_FEATURE r5) throws IllegalArgumentException {
        Application r0 = this.myApplication;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r5 != null) goto L20;
        Log.e(TAG, "Feature id passed is null");
        throw new IllegalArgumentException("Feature ID passed is null");
    L20:
        r0.getPackageManager().getPackageInfo("com.qti.service.colorservice", 128);     // Catch: PackageManager.NameNotFoundException -> L13
        return service.isFeatureSupported(this.displayId, r5.getValue());
    L10:
        e = move-exception;
        e.printStackTrace();
        Log.e(TAG, "Service isFeatureSupported crashed");
        return false;
    L13:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public int setColorBalance(int r7) {
        if (myInstance[this.displayId] != null) goto L29;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L29:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_BALANCE) == true) goto L10;
        return RET_NOT_SUPPORTED;
    L10:
        if (r7 >= (-100)) goto L12;
    L22:
        Log.e(TAG, "Warmth given is outside the range (-100, 100)");
        return RET_VALUE_OUT_OF_RANGE;
    L12:
        if (r7 > 100) goto L22;
        Log.v(TAG, "Calling setColorBalance for display " + this.displayId);     // Catch: RemoteException -> L20
        int r6 = service.setColorBalance(this.displayId, r7);     // Catch: RemoteException -> L20
        if (r6 != 0) goto L18;
        Log.v(TAG, "SetColorBalance() worked");     // Catch: RemoteException -> L20
        return r6;
    L18:
        Log.e(TAG, "Service setColorBalance failed with return value " + r6);     // Catch: RemoteException -> L20
        return -999;
    L20:
        Log.e(TAG, "Service set color balance failed");
        return -999;
    L24:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int getColorBalance() {
        if (myInstance[this.displayId] != null) goto L22;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L22:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_BALANCE) == true) goto L20;
        return RET_NOT_SUPPORTED;
    L20:
        Log.v(TAG, "Calling getColorBalance for display " + this.displayId);     // Catch: RemoteException -> L13
        int r5 = service.getColorBalance(this.displayId);     // Catch: RemoteException -> L13
        if (r5 >= (-100)) goto L12;
        Log.e(TAG, "Service getColorBalance failed with return value " + (r5 - (-100)));     // Catch: RemoteException -> L13
        return -999;
    L12:
        return r5;
    L13:
        Log.e(TAG, "Service get color balance failed");
        return -999;
    L15:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int getNumOfModes(MODE_TYPE r6) throws IllegalArgumentException {
        if (myInstance[this.displayId] != null) goto L25;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L25:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_MODE_SELECTION) == true) goto L8;
        return RET_NOT_SUPPORTED;
    L8:
        if (r6 != null) goto L23;
        Log.e(TAG, "Feature id passed is null");
        throw new IllegalArgumentException("Type passed is null");
    L23:
        Log.v(TAG, "Calling getNumOfModes for display " + this.displayId);     // Catch: RemoteException -> L14
        int r5 = service.getNumModes(this.displayId, r6.getValue());     // Catch: RemoteException -> L14
        if (r5 >= 0) goto L13;
        Log.e(TAG, "Service getNumModes failed with return value " + r5);     // Catch: RemoteException -> L14
        return -999;
    L13:
        return r5;
    L14:
        Log.e(TAG, "Service get num modes failed");
        return -999;
    L18:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int[] getActiveMode() {
        int[] r2 = {-999, 0};
        if (myInstance[this.displayId] != null) goto L29;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        r2[0] = -999;
        return r2;
    L29:
    L24:
        e = move-exception;
        e.printStackTrace();
        r2[0] = -901;
        return r2;
    L6:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_MODE_SELECTION) == true) goto L31;
        r2[0] = -901;     // Catch: IllegalArgumentException -> L24
        return r2;
    L31:
        Log.v(TAG, "Calling getActiveMode() for display " + this.displayId);     // Catch: RemoteException -> L22
        long[] r10 = service.getActiveMode(this.displayId);     // Catch: RemoteException -> L22
        if (r10 != null) goto L12;
    L20:
        Log.e(TAG, "getActive service returned null ");     // Catch: RemoteException -> L22
        r2[0] = -999;     // Catch: RemoteException -> L22
        return r2;
    L12:
        if (r10.length <= 0) goto L20;
        long r6 = r10[0];     // Catch: RemoteException -> L22
        if (r6 >= 0) goto L18;
        Log.e(TAG, "Service getActiveMode failed with return value " + r10[0]);     // Catch: RemoteException -> L22
        r2[0] = -999;     // Catch: RemoteException -> L22
        return r2;
    L18:
        r2[0] = (int) r6;     // Catch: RemoteException -> L22
        r2[1] = (int) r10[1];     // Catch: RemoteException -> L22
        return r2;
    L22:
        Log.e(TAG, "Service get active mode failed");
        r2[0] = -999;
        return r2;
    }

    public int setActiveMode(int r7) {
        if (myInstance[this.displayId] != null) goto L26;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L26:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_MODE_SELECTION) == true) goto L9;
        return RET_NOT_SUPPORTED;
    L9:
        if (r7 >= 0) goto L25;
        Log.e(TAG, "Mode ID provided is less than 0");
        return RET_VALUE_OUT_OF_RANGE;
    L25:
        Log.v(TAG, "Calling setActiveMode for display " + this.displayId);     // Catch: RemoteException -> L18
        int r6 = service.setActiveMode(this.displayId, r7);     // Catch: RemoteException -> L18
        if (r6 != 0) goto L16;
        Log.v(TAG, "SetActiveMode() worked");     // Catch: RemoteException -> L18
        return r6;
    L16:
        Log.e(TAG, "Service setActiveMode failed with return value " + r6);     // Catch: RemoteException -> L18
        return -999;
    L18:
        Log.e(TAG, "Service set active mode failed");
        return -999;
    L20:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public ModeInfo[] getModes(MODE_TYPE r4) throws IllegalArgumentException {
        if (myInstance[this.displayId] != null) goto L21;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return null;
    L21:
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_MODE_SELECTION) == true) goto L8;
        Log.e(TAG, "FEATURE_COLOR_MODE_SELECTION is not supported for display " + this.displayId);     // Catch: IllegalArgumentException -> L16
        return null;
    L8:
        if (r4 != null) goto L23;
        Log.e(TAG, "Mode Type passed is null");
        throw new IllegalArgumentException("Type passed is null");
    L23:
        return service.getModes(this.displayId, r4.getValue());
    L11:
        e = move-exception;
        Log.e(TAG, "Service get modes failed");
        e.printStackTrace();
        return null;
    }

    public int deleteMode(int r6) {
        if (myInstance[this.displayId] != null) goto L29;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L29:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_MODE_MANAGEMENT) == true) goto L10;
        return RET_NOT_SUPPORTED;
    L10:
        if (this.isSystemApp == true) goto L13;
        Log.e(TAG, "You do not have permission to perform this operation");
        return RET_PERMISSION_DENIED;
    L13:
        if (r6 >= 0) goto L31;
        Log.e(TAG, "Mode ID provided is less than 0");
        return RET_VALUE_OUT_OF_RANGE;
    L31:
        int r5 = service.deleteMode(this.displayId, r6);     // Catch: RemoteException -> L22
        if (r5 != 0) goto L20;
        Log.v(TAG, "deleteMode() worked");     // Catch: RemoteException -> L22
        return r5;
    L20:
        Log.e(TAG, "Service deleteMode failed with return value " + r5);     // Catch: RemoteException -> L22
        return -999;
    L22:
        Log.e(TAG, "Service set active mode failed");
        return -999;
    L24:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int createNewMode(String r12, EnumSet<DCM_FEATURE> r13, int r14) {
        if (myInstance[this.displayId] != null) goto L59;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L59:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_MODE_MANAGEMENT) == true) goto L10;
        return RET_NOT_SUPPORTED;
    L10:
        if (this.isSystemApp == true) goto L13;
        Log.e(TAG, "You do not have permission to perform this operation");
        return RET_PERMISSION_DENIED;
    L13:
        if (r12 != null) goto L15;
    L51:
        Log.e(TAG, "Mode name is missing or crossing max length");
        return -999;
    L15:
        if (r12.equals("") == true) goto L51;
        if (r12.length() > 32) goto L51;
        if (r13 != null) goto L21;
    L49:
        Log.e(TAG, "FeatureList missing");
        return -999;
    L21:
        if (r13.isEmpty() == true) goto L49;
        if (r13.contains(DCM_FEATURE.FEATURE_COLOR_BALANCE) == true) goto L26;
        long r8 = 0;
    L38:
        if (r8 != 0) goto L58;
        Log.e(TAG, "FeatureList is incomplete. Colorbalance missing");
        return -999;
    L58:
        Log.v(TAG, "For createNewMode- " + r12 + HanziToPinyin.Token.SEPARATOR + r8 + HanziToPinyin.Token.SEPARATOR + r14);     // Catch: RemoteException -> L47
        int r11 = service.createNewMode(this.displayId, r12, r8, r14);     // Catch: RemoteException -> L47
        if (r11 < 0) goto L45;
        Log.v(TAG, "createNewMode() worked");     // Catch: RemoteException -> L47
        return r11;
    L45:
        Log.e(TAG, "Service createNewMode failed with return value " + r11);     // Catch: RemoteException -> L47
        return -999;
    L47:
        Log.e(TAG, "Service create new mode failed");
        return -999;
    L26:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_BALANCE) == true) goto L28;
        Log.e(TAG, "FEATURE_COLOR_BALANCE is not supported");
        return RET_NOT_SUPPORTED;
    L28:
        if (r14 >= (-100)) goto L30;
    L32:
        Log.e(TAG, "Color balance value passed is out of range");
        return RET_VALUE_OUT_OF_RANGE;
    L30:
        if (r14 > 100) goto L32;
        r8 = BITFLAG_COLOR_BALANCE | 0;
    L53:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int modifyMode(int r10, String r11, EnumSet<DCM_FEATURE> r12, int r13) {
        if (myInstance[this.displayId] != null) goto L62;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L62:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_MODE_MANAGEMENT) == true) goto L10;
        return RET_NOT_SUPPORTED;
    L10:
        if (this.isSystemApp == true) goto L13;
        Log.e(TAG, "You do not have permission to perform this operation");
        return RET_PERMISSION_DENIED;
    L13:
        if (r10 >= 0) goto L16;
        Log.e(TAG, "Mode id passed is negative");
        return -999;
    L16:
        if (r11 != null) goto L18;
    L54:
        Log.e(TAG, "Mode name is missing or crossing max length");
        return -999;
    L18:
        if (r11.equals("") == true) goto L54;
        if (r11.length() > 32) goto L54;
        if (r12 != null) goto L24;
    L52:
        Log.e(TAG, "FeatureList missing");
        return -999;
    L24:
        if (r12.isEmpty() == true) goto L52;
        if (r12.contains(DCM_FEATURE.FEATURE_COLOR_BALANCE) == true) goto L29;
        long r7 = 0;
    L41:
        if (r7 != 0) goto L61;
        Log.e(TAG, "FeatureList is incomplete. Colorbalance missing");
        return -999;
    L61:
        Log.v(TAG, "For modifyMode- " + r10 + HanziToPinyin.Token.SEPARATOR + r11 + HanziToPinyin.Token.SEPARATOR + r7 + HanziToPinyin.Token.SEPARATOR + r13);     // Catch: RemoteException -> L50
        int r9 = service.modifyModeAllFeatures(this.displayId, r10, r11);     // Catch: RemoteException -> L50
        if (r9 != 0) goto L48;
        Log.v(TAG, "modifyMode() worked");     // Catch: RemoteException -> L50
        return r9;
    L48:
        Log.e(TAG, "Service modifyMode failed with return value " + r9);     // Catch: RemoteException -> L50
        return -999;
    L50:
        Log.e(TAG, "Service modify mode failed");
        return -999;
    L29:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_BALANCE) == true) goto L31;
        Log.e(TAG, "FEATURE_COLOR_BALANCE is not supported");
        return RET_NOT_SUPPORTED;
    L31:
        if (r13 >= (-100)) goto L33;
    L35:
        Log.e(TAG, "Color balance value passed is out of range");
        return RET_VALUE_OUT_OF_RANGE;
    L33:
        if (r13 > 100) goto L35;
        r7 = BITFLAG_COLOR_BALANCE | 0;
    L56:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int getDefaultMode() {
        if (myInstance[this.displayId] != null) goto L20;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L20:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_MODE_SELECTION) == true) goto L22;
        return RET_NOT_SUPPORTED;
    L22:
        Log.v(TAG, "Calling getDefaultMode() for display " + this.displayId);     // Catch: RemoteException -> L13
        int r5 = service.getDefaultMode(this.displayId);     // Catch: RemoteException -> L13
        if (r5 >= 0) goto L12;
        Log.e(TAG, "Service getDefaultMode failed with return value " + r5);     // Catch: RemoteException -> L13
        return -999;
    L12:
        return r5;
    L13:
        Log.e(TAG, "Service get default mode failed");
        return -999;
    L15:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int setDefaultMode(int r7) {
        if (myInstance[this.displayId] != null) goto L29;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L29:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_MODE_SELECTION) == true) goto L10;
        return RET_NOT_SUPPORTED;
    L10:
        if (this.isSystemApp == true) goto L13;
        Log.e(TAG, "You do not have permission to perform this operation");
        return RET_PERMISSION_DENIED;
    L13:
        if (r7 >= 0) goto L31;
        Log.e(TAG, "Mode ID provided is less than 0");
        return RET_VALUE_OUT_OF_RANGE;
    L31:
        Log.v(TAG, "Calling setDefaultMode for display " + this.displayId);     // Catch: RemoteException -> L22
        int r6 = service.setDefaultMode(this.displayId, r7);     // Catch: RemoteException -> L22
        if (r6 != 0) goto L20;
        Log.v(TAG, "SetDefaultMode() worked");     // Catch: RemoteException -> L22
        return r6;
    L20:
        Log.e(TAG, "Service setDefaultMode failed with return value " + r6);     // Catch: RemoteException -> L22
        return -999;
    L22:
        Log.e(TAG, "Service set default mode failed");
        return -999;
    L24:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int createNewMode(String r7) {
        if (myInstance[this.displayId] != null) goto L34;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L34:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_MODE_MANAGEMENT) == true) goto L10;
        return RET_NOT_SUPPORTED;
    L10:
        if (this.isSystemApp == true) goto L13;
        Log.e(TAG, "You do not have permission to perform this operation");
        return RET_PERMISSION_DENIED;
    L13:
        if (r7 != null) goto L15;
    L27:
        Log.e(TAG, "Mode name is missing or crossing max length");
        return -999;
    L15:
        if (r7.equals("") == true) goto L27;
        if (r7.length() > 32) goto L27;
        Log.v(TAG, "For createNewMode- " + r7);     // Catch: RemoteException -> L25
        int r6 = service.createNewModeAllFeatures(this.displayId, r7);     // Catch: RemoteException -> L25
        if (r6 < 0) goto L23;
        Log.v(TAG, "createNewMode() worked");     // Catch: RemoteException -> L25
        return r6;
    L23:
        Log.e(TAG, "Service createNewMode failed with return value " + r6);     // Catch: RemoteException -> L25
        return -999;
    L25:
        Log.e(TAG, "Service create new mode failed");
        return -999;
    L29:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int modifyMode(int r7, String r8) {
        if (myInstance[this.displayId] != null) goto L37;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L37:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_COLOR_MODE_MANAGEMENT) == true) goto L10;
        return RET_NOT_SUPPORTED;
    L10:
        if (this.isSystemApp == true) goto L13;
        Log.e(TAG, "You do not have permission to perform this operation");
        return RET_PERMISSION_DENIED;
    L13:
        if (r7 >= 0) goto L16;
        Log.e(TAG, "Mode id passed is negative");
        return -999;
    L16:
        if (r8 != null) goto L18;
    L30:
        Log.e(TAG, "Mode name is missing or crossing max length");
        return -999;
    L18:
        if (r8.equals("") == true) goto L30;
        if (r8.length() > 32) goto L30;
        Log.v(TAG, "For modifyMode- " + r7 + HanziToPinyin.Token.SEPARATOR + r8);     // Catch: RemoteException -> L28
        int r6 = service.modifyModeAllFeatures(this.displayId, r7, r8);     // Catch: RemoteException -> L28
        if (r6 != 0) goto L26;
        Log.v(TAG, "modifyMode() worked");     // Catch: RemoteException -> L28
        return r6;
    L26:
        Log.e(TAG, "Service modifyMode failed with return value " + r6);     // Catch: RemoteException -> L28
        return -999;
    L28:
        Log.e(TAG, "Service modify mode failed");
        return -999;
    L32:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int getMaxSunlightVisibilityStrength() {
        if (myInstance[this.displayId] != null) goto L21;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L21:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT) == true) goto L9;
        return RET_NOT_SUPPORTED;
    L9:
        if (isSunlightVisibilityEnabled() == true) goto L23;
        Log.e(TAG, "FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT is disabled");
        return RET_FEATURE_DISABLED;
    L23:
        Log.v(TAG, "Calling getMaxSVI for display " + this.displayId);     // Catch: RemoteException -> L14
        return service.getRangeSunlightVisibilityStrength(this.displayId, 1);
    L14:
        Log.e(TAG, "Service getMaxSVI failed");
        return -999;
    L16:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int getMinSunlightVisibilityStrength() {
        if (myInstance[this.displayId] != null) goto L21;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L21:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT) == true) goto L9;
        return RET_NOT_SUPPORTED;
    L9:
        if (isSunlightVisibilityEnabled() == true) goto L23;
        Log.e(TAG, "FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT is disabled");
        return RET_FEATURE_DISABLED;
    L23:
        Log.v(TAG, "Calling getMinSVI for display " + this.displayId);     // Catch: RemoteException -> L14
        return service.getRangeSunlightVisibilityStrength(this.displayId, 0);
    L14:
        Log.e(TAG, "Service getMinSVI failed");
        return -999;
    L16:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int setSunlightVisibilityStrength(int r7) {
        if (myInstance[this.displayId] != null) goto L34;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L34:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT) == true) goto L10;
        return RET_NOT_SUPPORTED;
    L10:
        if (isSunlightVisibilityEnabled() == true) goto L14;
        Log.e(TAG, "FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT is disabled");
        return RET_FEATURE_DISABLED;
    L14:
        if (r7 >= getMinSunlightVisibilityStrength()) goto L16;
    L26:
        Log.e(TAG, "strengthVal given is outside the range (" + getMinSunlightVisibilityStrength() + "," + getMaxSunlightVisibilityStrength() + ")");
        return RET_VALUE_OUT_OF_RANGE;
    L16:
        if (r7 > getMaxSunlightVisibilityStrength()) goto L26;
        Log.v(TAG, "Calling setSVI for display " + this.displayId);     // Catch: RemoteException -> L24
        int r6 = service.setSunlightVisibilityStrength(this.displayId, r7);     // Catch: RemoteException -> L24
        if (r6 != 0) goto L22;
        Log.v(TAG, "setSunlightVisibilityStrength() worked");     // Catch: RemoteException -> L24
        return r6;
    L22:
        Log.e(TAG, "Service setSunlightVisibilityStrength failed with return value " + r6);     // Catch: RemoteException -> L24
        return -999;
    L24:
        Log.e(TAG, "Service setSunlightVisibilityStrength failed");
        return -999;
    L28:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int getSunlightVisibilityStrength() {
        if (myInstance[this.displayId] != null) goto L26;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L26:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT) == true) goto L9;
        return RET_NOT_SUPPORTED;
    L9:
        if (isSunlightVisibilityEnabled() == true) goto L24;
        Log.e(TAG, "FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT is disabled");
        return RET_FEATURE_DISABLED;
    L24:
        Log.v(TAG, "Calling getSunlightVisibilityStrength for display " + this.displayId);     // Catch: RemoteException -> L17
        int r1 = service.getSunlightVisibilityStrength(this.displayId);     // Catch: RemoteException -> L17
        if (r1 >= getMinSunlightVisibilityStrength()) goto L16;
        Log.e(TAG, "Service getSunlightVisibilityStrength failed with return value " + r1);     // Catch: RemoteException -> L17
        return -999;
    L16:
        return r1;
    L17:
        Log.e(TAG, "Service getSunlightVisibilityStrength failed");
        return -999;
    L19:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public ADAPTIVE_BACKLIGHT_QUALITY_LEVEL getBacklightQualityLevel() {
        if (myInstance[this.displayId] != null) goto L27;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return null;
    L27:
    L22:
        e = move-exception;
        e.printStackTrace();
        Log.e(TAG, "FEATURE_ADAPTIVE_BACKLIGHT is not supported");
        return null;
    L5:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_ADAPTIVE_BACKLIGHT) == true) goto L9;
        Log.e(TAG, "FEATURE_ADAPTIVE_BACKLIGHT is not supported");     // Catch: IllegalArgumentException -> L22
        return null;
    L9:
        if (isAdaptiveBacklightEnabled() == true) goto L29;
        Log.e(TAG, "FEATURE_ADAPTIVE_BACKLIGHT is disabled");
        return null;
    L29:
        Log.v(TAG, "Calling getBacklightQualityLevel for display " + this.displayId);     // Catch: RemoteException -> L20
        int r5 = service.getBacklightQualityLevel(this.displayId);     // Catch: RemoteException -> L20
        if (r5 >= 0) goto L30;
        Log.v(TAG, "getBacklightQualityLevel returned error value " + r5);     // Catch: RemoteException -> L20
        return null;
    L30:
        return ADAPTIVE_BACKLIGHT_QUALITY_LEVEL.values()[r5];
    L18:
        Log.e(TAG, "Level type mismatch");     // Catch: RemoteException -> L20
        return null;
    L20:
        Log.e(TAG, "Service getBacklightQualityLevel failed");
        return null;
    }

    public int setBacklightQualityLevel(ADAPTIVE_BACKLIGHT_QUALITY_LEVEL r7) {
        if (myInstance[this.displayId] != null) goto L29;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L29:
    L24:
        e = move-exception;
        e.printStackTrace();
        Log.e(TAG, "FEATURE_ADAPTIVE_BACKLIGHT is not supported");
        return RET_NOT_SUPPORTED;
    L6:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_ADAPTIVE_BACKLIGHT) == true) goto L10;
        Log.e(TAG, "FEATURE_ADAPTIVE_BACKLIGHT is not supported");     // Catch: IllegalArgumentException -> L24
        return RET_NOT_SUPPORTED;
    L10:
        if (isAdaptiveBacklightEnabled() == true) goto L13;
        Log.e(TAG, "FEATURE_ADAPTIVE_BACKLIGHT is disabled");
        return RET_FEATURE_DISABLED;
    L13:
        if (r7 != null) goto L31;
        Log.e(TAG, "level passed is null");
        return RET_ILLEGAL_ARGUMENT;
    L31:
        Log.v(TAG, "Calling setBacklightQualityLevel for display " + this.displayId);     // Catch: RemoteException -> L22
        int r6 = service.setBacklightQualityLevel(this.displayId, r7.getValue());     // Catch: RemoteException -> L22
        if (r6 != 0) goto L20;
        Log.v(TAG, "setBacklightQualityLevel() worked");     // Catch: RemoteException -> L22
        return r6;
    L20:
        Log.e(TAG, "Service setBacklightQualityLevel failed with return value " + r6);     // Catch: RemoteException -> L22
        return -999;
    L22:
        Log.e(TAG, "Service setBacklightQualityLevel failed");
        return -999;
    }

    public int getAdaptiveBacklightScale() {
        if (myInstance[this.displayId] != null) goto L21;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L21:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_ADAPTIVE_BACKLIGHT) == true) goto L9;
        return RET_NOT_SUPPORTED;
    L9:
        if (isAdaptiveBacklightEnabled() == true) goto L23;
        Log.e(TAG, "FEATURE_ADAPTIVE_BACKLIGHT is disabled");
        return RET_FEATURE_DISABLED;
    L23:
        Log.v(TAG, "Calling getAdaptiveBacklightScale for display " + this.displayId);     // Catch: RemoteException -> L14
        return service.getAdaptiveBacklightScale(this.displayId);
    L14:
        Log.e(TAG, "Service getAdaptiveBacklightScale failed");
        return -999;
    L16:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public boolean isSunlightVisibilityEnabled() {
        if (myInstance[this.displayId] != null) goto L20;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return false;
    L20:
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT) == true) goto L22;
        Log.e(TAG, "FEATURE_SUNLIGHT_VISIBILITY_IMPROVEMENT is not supported");     // Catch: IllegalArgumentException -> L15
        return false;
    L22:
        Log.v(TAG, "Calling isSunlightVisibilityEnabled for display " + this.displayId);     // Catch: RemoteException -> L13
        if (service.isActiveFeatureOn(this.displayId, ACTIVE_FEATURE_TYPE.FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT.getValue()) != 1) goto L12;
        Log.v(TAG, "isActiveFeatureOn returned retVal");     // Catch: RemoteException -> L13
        return true;
    L12:
        return false;
    L13:
        Log.e(TAG, "Service isActiveFeatureOn failed");
        return false;
    }

    public boolean isAdaptiveBacklightEnabled() {
        if (myInstance[this.displayId] != null) goto L20;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return false;
    L20:
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_ADAPTIVE_BACKLIGHT) == true) goto L22;
        Log.e(TAG, "FEATURE_ADAPTIVE_BACKLIGHT is not supported");     // Catch: IllegalArgumentException -> L15
        return false;
    L22:
        Log.v(TAG, "Calling isAdaptiveBacklightEnabled for display " + this.displayId);     // Catch: RemoteException -> L13
        if (service.isActiveFeatureOn(this.displayId, ACTIVE_FEATURE_TYPE.FEATURE_ADAPTIVE_BACKLIGHT.getValue()) != 1) goto L12;
        Log.v(TAG, "isActiveFeatureOn returned retVal");     // Catch: RemoteException -> L13
        return true;
    L12:
        return false;
    L13:
        Log.e(TAG, "Service isActiveFeatureOn failed");
        return false;
    }

    public int setSunlightVisibilityEnabled(boolean r6) {
        if (myInstance[this.displayId] != null) goto L5;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L5:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT) == true) goto L22;
        Log.e(TAG, "FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT is not supported");
        return RET_NOT_SUPPORTED;
    L22:
        Log.v(TAG, "Calling setActiveFeatureControl for display " + this.displayId);     // Catch: RemoteException -> L18
        if (r6 != true) goto L11;
        CONTROL_REQUEST_TYPE r7 = CONTROL_REQUEST_TYPE.ON;     // Catch: RemoteException -> L18
    L12:
        int r5 = service.setActiveFeatureControl(this.displayId, ACTIVE_FEATURE_TYPE.FEATURE_SUNLIGHT_VISBILITY_IMPROVEMENT.getValue(), r7.getValue());     // Catch: RemoteException -> L18
        if (r5 != 0) goto L16;
        Log.v(TAG, "setActiveFeatureControl() worked");     // Catch: RemoteException -> L18
        return r5;
    L16:
        Log.e(TAG, "Service setActiveFeatureControl failed with return value " + r5);     // Catch: RemoteException -> L18
        return -999;
    L11:
        r7 = CONTROL_REQUEST_TYPE.OFF;     // Catch: RemoteException -> L18
    L18:
        Log.e(TAG, "Service setActiveFeatureControl failed");
        return -999;
    }

    public int setAdaptiveBacklightEnabled(boolean r6) {
        if (myInstance[this.displayId] != null) goto L5;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L5:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_ADAPTIVE_BACKLIGHT) == true) goto L22;
        Log.e(TAG, "FEATURE_ADAPTIVE_BACKLIGHT is not supported");
        return RET_NOT_SUPPORTED;
    L22:
        Log.v(TAG, "Calling setActiveFeatureControl for display " + this.displayId);     // Catch: RemoteException -> L18
        if (r6 != true) goto L11;
        CONTROL_REQUEST_TYPE r7 = CONTROL_REQUEST_TYPE.ON;     // Catch: RemoteException -> L18
    L12:
        int r5 = service.setActiveFeatureControl(this.displayId, ACTIVE_FEATURE_TYPE.FEATURE_ADAPTIVE_BACKLIGHT.getValue(), r7.getValue());     // Catch: RemoteException -> L18
        if (r5 != 0) goto L16;
        Log.v(TAG, "setActiveFeatureControl() worked");     // Catch: RemoteException -> L18
        return r5;
    L16:
        Log.e(TAG, "Service setActiveFeatureControl failed with return value " + r5);     // Catch: RemoteException -> L18
        return -999;
    L11:
        r7 = CONTROL_REQUEST_TYPE.OFF;     // Catch: RemoteException -> L18
    L18:
        Log.e(TAG, "Service setActiveFeatureControl failed");
        return -999;
    }

    public int getMaxLimitMemoryColor(MemoryColorConfig.MEMORY_COLOR_TYPE r6, MemoryColorConfig.MEMORY_COLOR_PARAMS r7) {
        if (myInstance[this.displayId] != null) goto L33;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L33:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_MEMORY_COLOR_ADJUSTMENT) == true) goto L8;
        return RET_NOT_SUPPORTED;
    L8:
        if (r6 == null) goto L26;
        if (r7 == null) goto L26;
        String r1 = r6 + "" + r7 + "max";     // Catch: RemoteException -> L24
        Integer r3 = this.memColorRanges.get(r1);     // Catch: RemoteException -> L24
        if (r3 != null) goto L14;
        Log.v(TAG, "Calling getMaxLimitMemoryColor for display " + this.displayId);     // Catch: RemoteException -> L24
        int[] r8 = service.getRangeMemoryColorParameter(this.displayId, r6.getValue());     // Catch: RemoteException -> L24
        if (r8 != null) goto L18;
    L22:
        Log.e(TAG, "Service did not return proper parameter");     // Catch: RemoteException -> L24
        return -999;
    L18:
        if (r8.length < 6) goto L22;
        int r9 = (r7.getValue() * 2) + 1;     // Catch: RemoteException -> L24
        this.memColorRanges.put(r1, Integer.valueOf(r8[r9]));     // Catch: RemoteException -> L24
        return r8[r9];
    L14:
        return r3.intValue();
    L24:
        Log.e(TAG, "Service getMaxLimitMemoryColor failed");
        return -999;
    L26:
        Log.e(TAG, "Feature type or request passed is null");
        return RET_ILLEGAL_ARGUMENT;
    L28:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int getMinLimitMemoryColor(MemoryColorConfig.MEMORY_COLOR_TYPE r6, MemoryColorConfig.MEMORY_COLOR_PARAMS r7) {
        if (myInstance[this.displayId] != null) goto L34;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L34:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_MEMORY_COLOR_ADJUSTMENT) == true) goto L8;
        return RET_NOT_SUPPORTED;
    L8:
        if (r6 == null) goto L26;
        if (r7 == null) goto L26;
        String r1 = r6 + "" + r7 + SliceHints.SUBTYPE_MIN;     // Catch: RemoteException -> L24
        Integer r3 = this.memColorRanges.get(r1);     // Catch: RemoteException -> L24
        if (r3 != null) goto L14;
        Log.v(TAG, "Calling getMinLimitMemoryColor for display " + this.displayId);     // Catch: RemoteException -> L24
        int[] r8 = service.getRangeMemoryColorParameter(this.displayId, r6.getValue());     // Catch: RemoteException -> L24
        if (r8 != null) goto L18;
    L22:
        Log.e(TAG, "Service did not return proper parameter");     // Catch: RemoteException -> L24
        return -999;
    L18:
        if (r8.length < 6) goto L22;
        int r9 = r7.getValue() * 2;     // Catch: RemoteException -> L24
        this.memColorRanges.put(r1, Integer.valueOf(r8[r9]));     // Catch: RemoteException -> L24
        return r8[r9];
    L14:
        return r3.intValue();
    L24:
        Log.e(TAG, "Service getMinLimitMemoryColor failed");
        return -999;
    L26:
        Log.e(TAG, "Feature type or request passed is null");
        return RET_ILLEGAL_ARGUMENT;
    L28:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int setMemoryColorParams(MemoryColorConfig r11) {
        if (myInstance[this.displayId] != null) goto L49;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L49:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_MEMORY_COLOR_ADJUSTMENT) == true) goto L8;
        return RET_NOT_SUPPORTED;
    L8:
        if (r11 != null) goto L10;
    L40:
        Log.e(TAG, "MemoryColorConfig instance or the Memory color type passed is null");
        return RET_ILLEGAL_ARGUMENT;
    L10:
        if (r11.getMemoryColorType() == null) goto L40;
        if (r11.getHue() >= getMinLimitMemoryColor(r11.getMemoryColorType(), MemoryColorConfig.MEMORY_COLOR_PARAMS.HUE)) goto L15;
    L38:
        Log.e(TAG, "Hue is out of range");
        return RET_VALUE_OUT_OF_RANGE;
    L15:
        if (r11.getHue() > getMaxLimitMemoryColor(r11.getMemoryColorType(), MemoryColorConfig.MEMORY_COLOR_PARAMS.HUE)) goto L38;
        if (r11.getSaturation() >= getMinLimitMemoryColor(r11.getMemoryColorType(), MemoryColorConfig.MEMORY_COLOR_PARAMS.SATURATION)) goto L20;
    L36:
        Log.e(TAG, "Saturation is out of range");
        return RET_VALUE_OUT_OF_RANGE;
    L20:
        if (r11.getSaturation() > getMaxLimitMemoryColor(r11.getMemoryColorType(), MemoryColorConfig.MEMORY_COLOR_PARAMS.SATURATION)) goto L36;
        if (r11.getIntensity() >= getMinLimitMemoryColor(r11.getMemoryColorType(), MemoryColorConfig.MEMORY_COLOR_PARAMS.INTENSITY)) goto L25;
    L34:
        Log.e(TAG, "Intensity value is out of range");
        return RET_VALUE_OUT_OF_RANGE;
    L25:
        if (r11.getIntensity() > getMaxLimitMemoryColor(r11.getMemoryColorType(), MemoryColorConfig.MEMORY_COLOR_PARAMS.INTENSITY)) goto L34;
        Log.v(TAG, "Calling setMemoryColorParams for display " + this.displayId);     // Catch: RemoteException -> L32
        int r10 = service.setMemoryColorParameters(this.displayId, r11.getMemoryColorType().getValue(), r11.getHue(), r11.getSaturation(), r11.getIntensity());     // Catch: RemoteException -> L32
        if (r10 == 0) goto L31;
        Log.e(TAG, "setMemorycolorParams failed with return value " + r10);     // Catch: RemoteException -> L32
        return -999;
    L31:
        return r10;
    L32:
        Log.e(TAG, "Service setMemoryColorParams failed");
        return -999;
    L42:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public MemoryColorConfig getMemoryColorParams(MemoryColorConfig.MEMORY_COLOR_TYPE r8) {
        if (myInstance[this.displayId] != null) goto L31;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return null;
    L31:
    L26:
        e = move-exception;
        e.printStackTrace();
        Log.e(TAG, "FEATURE_MEMORY_COLOR_ADJUSTMENT is not supported");
        return null;
    L5:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_MEMORY_COLOR_ADJUSTMENT) == true) goto L8;
        Log.e(TAG, "FEATURE_MEMORY_COLOR_ADJUSTMENT is not supported");     // Catch: IllegalArgumentException -> L26
        return null;
    L8:
        if (r8 != null) goto L33;
        Log.e(TAG, "Mem color type passed is null");
        return null;
    L33:
        Log.v(TAG, "Calling getMemoryColorParams for display " + this.displayId);     // Catch: RemoteException -> L24
        int[] r7 = service.getMemoryColorParameters(this.displayId, r8.getValue());     // Catch: RemoteException -> L24
        if (r7 != null) goto L14;
    L22:
        Log.e(TAG, "getMemorycolorParams failed ");     // Catch: RemoteException -> L24
        return null;
    L14:
        if (r7.length < 4) goto L22;
        boolean r1 = false;
        MemoryColorConfig r0 = new MemoryColorConfig(r8, r7[0], r7[1], r7[2]);     // Catch: RemoteException -> L24
        if (r7[3] == 0) goto L20;
        r1 = true;
    L20:
        r0.isEnabled = r1;     // Catch: RemoteException -> L24
        return r0;
    L24:
        Log.e(TAG, "Service getMemoryColorParams failed");
        return null;
    }

    public int disableMemoryColorConfig(MemoryColorConfig.MEMORY_COLOR_TYPE r6) {
        if (myInstance[this.displayId] != null) goto L23;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L23:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_MEMORY_COLOR_ADJUSTMENT) == true) goto L8;
        return RET_NOT_SUPPORTED;
    L8:
        if (r6 != null) goto L25;
        Log.e(TAG, "Memory color type passed is null");
        return RET_ILLEGAL_ARGUMENT;
    L25:
        Log.v(TAG, "Calling disableMemoryColorConfig for display " + this.displayId);     // Catch: RemoteException -> L16
        int r5 = service.disableMemoryColorConfiguration(this.displayId, r6.getValue());     // Catch: RemoteException -> L16
        if (r5 == 0) goto L15;
        Log.e(TAG, "disableMemoryColorConfig failed with return value " + r5);     // Catch: RemoteException -> L16
        return -999;
    L15:
        return r5;
    L16:
        Log.e(TAG, "Service disableMemoryColorConfig failed");
        return -999;
    L18:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int getMaxLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS r6) {
        if (myInstance[this.displayId] != null) goto L31;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L31:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_GLOBAL_PICTURE_ADJUSTMENT) == true) goto L8;
        return RET_NOT_SUPPORTED;
    L8:
        if (r6 != null) goto L33;
        Log.e(TAG, "Parameter passed is null");
        return RET_ILLEGAL_ARGUMENT;
    L33:
        String r1 = r6 + "max";     // Catch: RemoteException -> L24
        Integer r3 = this.paRanges.get(r1);     // Catch: RemoteException -> L24
        if (r3 != null) goto L14;
        Log.v(TAG, "Calling getMaxLimitPictureAdjustment for display " + this.displayId);     // Catch: RemoteException -> L24
        int[] r0 = service.getRangePAParameter(this.displayId);     // Catch: RemoteException -> L24
        if (r0 != null) goto L18;
    L22:
        Log.e(TAG, "Service did not return proper parameter");     // Catch: RemoteException -> L24
        return -999;
    L18:
        if (r0.length < 10) goto L22;
        int r7 = (r6.getValue() * 2) + 1;     // Catch: RemoteException -> L24
        this.paRanges.put(r1, Integer.valueOf(r0[r7]));     // Catch: RemoteException -> L24
        return r0[r7];
    L14:
        return r3.intValue();
    L24:
        Log.e(TAG, "Service getMaxLimitPictureAdjustment failed");
        return -999;
    L26:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int getMinLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS r6) {
        if (myInstance[this.displayId] != null) goto L31;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L31:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_GLOBAL_PICTURE_ADJUSTMENT) == true) goto L8;
        return RET_NOT_SUPPORTED;
    L8:
        if (r6 != null) goto L33;
        Log.e(TAG, "Parameter passed is null");
        return RET_ILLEGAL_ARGUMENT;
    L33:
        String r1 = r6 + SliceHints.SUBTYPE_MIN;     // Catch: RemoteException -> L24
        Integer r3 = this.paRanges.get(r1);     // Catch: RemoteException -> L24
        if (r3 != null) goto L14;
        Log.v(TAG, "Calling getMinLimitPictureAdjustment for display " + this.displayId);     // Catch: RemoteException -> L24
        int[] r0 = service.getRangePAParameter(this.displayId);     // Catch: RemoteException -> L24
        if (r0 != null) goto L18;
    L22:
        Log.e(TAG, "Service did not return proper parameter");     // Catch: RemoteException -> L24
        return -999;
    L18:
        if (r0.length < 10) goto L22;
        int r7 = r6.getValue() * 2;     // Catch: RemoteException -> L24
        this.paRanges.put(r1, Integer.valueOf(r0[r7]));     // Catch: RemoteException -> L24
        return r0[r7];
    L14:
        return r3.intValue();
    L24:
        Log.e(TAG, "Service getMaxLimitPictureAdjustment failed");
        return -999;
    L26:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int setPictureAdjustmentParams(PictureAdjustmentConfig r17) {
        if (myInstance[this.displayId] != null) goto L71;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L71:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_GLOBAL_PICTURE_ADJUSTMENT) == true) goto L9;
        return RET_NOT_SUPPORTED;
    L9:
        if (r17 != null) goto L11;
    L64:
        Log.e(TAG, "Parameter passed is null or the enumset of parameters is null");
        return RET_ILLEGAL_ARGUMENT;
    L11:
        if (r17.getParamFlags() == null) goto L64;
        EnumSet<PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS> r5 = r17.getParamFlags();
        int r8 = 0;
        if (r5.contains(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.HUE) == false) goto L22;
        r8 = 0 | PA_GLOBAL_HUE;
        if (r17.getHue() >= getMinLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.HUE)) goto L18;
    L19:
        Log.e(TAG, "Hue is out of range");
        return RET_VALUE_OUT_OF_RANGE;
    L18:
        if (r17.getHue() > getMaxLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.HUE)) goto L19;
    L22:
        if (r5.contains(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.SATURATION) == false) goto L30;
        r8 = r8 | PA_GLOBAL_SAT;
        if (r17.getSaturation() >= getMinLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.SATURATION)) goto L26;
    L27:
        Log.e(TAG, "Saturation is out of range");
        return RET_VALUE_OUT_OF_RANGE;
    L26:
        if (r17.getSaturation() > getMaxLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.SATURATION)) goto L27;
    L30:
        if (r5.contains(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.INTENSITY) == false) goto L38;
        r8 = r8 | PA_GLOBAL_VAL;
        if (r17.getIntensity() >= getMinLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.INTENSITY)) goto L34;
    L35:
        Log.e(TAG, "Intensity is out of range");
        return RET_VALUE_OUT_OF_RANGE;
    L34:
        if (r17.getIntensity() > getMaxLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.INTENSITY)) goto L35;
    L38:
        if (r5.contains(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.CONTRAST) == false) goto L46;
        r8 = r8 | PA_GLOBAL_CON;
        if (r17.getContrast() >= getMinLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.CONTRAST)) goto L42;
    L43:
        Log.e(TAG, "Contrast is out of range");
        return RET_VALUE_OUT_OF_RANGE;
    L42:
        if (r17.getContrast() > getMaxLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.CONTRAST)) goto L43;
    L46:
        if (r5.contains(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.SATURATION_THRESHOLD) == false) goto L53;
        r8 = r8 | PA_GLOBAL_SAT_THRESH;
        if (r17.getSaturationThreshold() >= getMinLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.SATURATION_THRESHOLD)) goto L50;
    L51:
        Log.e(TAG, "Saturation threshold is out of range");
        return RET_VALUE_OUT_OF_RANGE;
    L50:
        if (r17.getSaturationThreshold() > getMaxLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.SATURATION_THRESHOLD)) goto L51;
    L53:
        int r10 = r8;
        if (r10 != 0) goto L73;
        Log.e(TAG, "The enumset passed is empty");
        return RET_ILLEGAL_ARGUMENT;
    L73:
        Log.v(TAG, "Calling setPAParameters for display " + this.displayId);     // Catch: RemoteException -> L62
        int r0 = service.setPAParameters(this.displayId, r10, r17.getHue(), r17.getSaturation(), r17.getIntensity(), r17.getContrast(), r17.getSaturationThreshold());     // Catch: RemoteException -> L62
        if (r0 == 0) goto L61;
        Log.e(TAG, "setPAParameters failed with return value " + r0);     // Catch: RemoteException -> L62
        return -999;
    L61:
        return r0;
    L62:
        Log.e(TAG, "Service setPAParameters failed");
        return -999;
    L66:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int setPictureAdjustmentSaturationThreshold(int r13) {
        if (myInstance[this.displayId] != null) goto L27;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L27:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_GLOBAL_PICTURE_ADJUSTMENT) == true) goto L9;
        return RET_NOT_SUPPORTED;
    L9:
        if (r13 >= getMinLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.SATURATION_THRESHOLD)) goto L11;
    L20:
        Log.e(TAG, "Saturation threshold is out of range");
        return RET_VALUE_OUT_OF_RANGE;
    L11:
        if (r13 > getMaxLimitPictureAdjustment(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.SATURATION_THRESHOLD)) goto L20;
        Log.v(TAG, "Calling setPictureAdjustmentSaturationThreshold for display " + this.displayId);     // Catch: RemoteException -> L18
        int r12 = service.setPAParameters(this.displayId, PA_GLOBAL_SAT_THRESH, 0, 0, 0, 0, r13);     // Catch: RemoteException -> L18
        if (r12 == 0) goto L17;
        Log.e(TAG, "setPictureAdjustmentSaturationThreshold failed with return value " + r12);     // Catch: RemoteException -> L18
        return -999;
    L17:
        return r12;
    L18:
        Log.e(TAG, "Service setPictureAdjustmentSaturationThreshold failed");
        return -999;
    L22:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int enablePictureAdjustmentDesaturation() {
        if (myInstance[this.displayId] != null) goto L22;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L22:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_GLOBAL_PICTURE_ADJUSTMENT) == true) goto L20;
        return RET_NOT_SUPPORTED;
    L20:
        Log.v(TAG, "Calling enablePictureAdjustmentDesaturation for display " + this.displayId);     // Catch: RemoteException -> L13
        int r12 = service.setPAParameters(this.displayId, PA_GLOBAL_DESAT, 0, 0, 0, 0, 0);     // Catch: RemoteException -> L13
        if (r12 == 0) goto L12;
        Log.e(TAG, "enablePictureAdjustmentDesaturation failed with return value " + r12);     // Catch: RemoteException -> L13
        return -999;
    L12:
        return r12;
    L13:
        Log.e(TAG, "Service enablePictureAdjustmentDesaturation failed");
        return -999;
    L15:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public int disablePictureAdjustmentConfig() {
        if (myInstance[this.displayId] != null) goto L22;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return -999;
    L22:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_GLOBAL_PICTURE_ADJUSTMENT) == true) goto L20;
        return RET_NOT_SUPPORTED;
    L20:
        Log.v(TAG, "Calling disablePictureAdjustmentConfig for display " + this.displayId);     // Catch: RemoteException -> L13
        int r12 = service.setPAParameters(this.displayId, PA_GLOBAL_DISABLE, 0, 0, 0, 0, 0);     // Catch: RemoteException -> L13
        if (r12 == 0) goto L12;
        Log.e(TAG, "disablePictureAdjustmentConfig failed with return value " + r12);     // Catch: RemoteException -> L13
        return -999;
    L12:
        return r12;
    L13:
        Log.e(TAG, "Service disablePictureAdjustmentConfig failed");
        return -999;
    L15:
        e = move-exception;
        e.printStackTrace();
        return RET_NOT_SUPPORTED;
    }

    public PictureAdjustmentConfig getPictureAdjustmentParams() {
        if (myInstance[this.displayId] != null) goto L37;
        Log.e(TAG, "Instance for the display type " + this.displayId + " doesnt exist");
        return null;
    L37:
        if (isFeatureSupported(DCM_FEATURE.FEATURE_GLOBAL_PICTURE_ADJUSTMENT) == true) goto L39;
        return null;
    L39:
        Log.v(TAG, "Calling getPictureAdjustmentParams for display " + this.displayId);     // Catch: RemoteException -> L30
        int[] r0 = service.getRangePAParameter(this.displayId);     // Catch: RemoteException -> L30
        if (r0 != null) goto L10;
    L28:
        Log.e(TAG, "getRanagePAParameter failed");     // Catch: RemoteException -> L30
        return null;
    L10:
        if (r0.length < 10) goto L28;
        int[] r11 = service.getPAParameters(this.displayId);     // Catch: RemoteException -> L30
        if (r11 != null) goto L15;
    L26:
        Log.e(TAG, "getPictureAdjustmentParams failed");     // Catch: RemoteException -> L30
        return null;
    L15:
        if (r11.length < 6) goto L26;
        EnumSet r4 = EnumSet.allOf(PictureAdjustmentConfig.PICTURE_ADJUSTMENT_PARAMS.class);     // Catch: RemoteException -> L30
        boolean r1 = false;
        int r2 = r11[0];     // Catch: RemoteException -> L30
        if ((PA_GLOBAL_DESAT & r2) == 0) goto L20;
        boolean r10 = true;
    L22:
        if ((r2 & PA_GLOBAL_DISABLE) == 0) goto L24;
        r1 = true;
    L24:
        PictureAdjustmentConfig r3 = new PictureAdjustmentConfig(r4, r11[1], r11[2], r11[3], r11[4], r11[5]);     // Catch: RemoteException -> L30
        r3.isDesaturation = r10;     // Catch: RemoteException -> L30
        r3.isGlobalPADisabled = r1;     // Catch: RemoteException -> L30
        return r3;
    L20:
        r10 = false;
    L30:
        Log.e(TAG, "Service getPictureAdjustmentParams failed");
        return null;
    L32:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public void release() {
        ColorManager[] r0 = myInstance;
        int r1 = this.displayId;
        if (r0[r1] == null) goto L6;
        r0[r1] = null;
        this.myApplication = null;
        return;
    }

    private int checkModeValidity(ModeInfo r1) {
        if (r1 != null) goto L6;
        Log.e(TAG, "Mode data missing");
        return -999;
    L6:
        if (r1.getId() >= 0) goto L9;
        Log.e(TAG, "ID out of range");
        return RET_VALUE_OUT_OF_RANGE;
    L9:
        return 0;
    }

    private static boolean isServiceRunning() {
        boolean r1 = false;
        InputStream r2 = null;
        r2 = new ProcessBuilder(new String[]{"/system/bin/sh", "-c", "ps"}).start().getInputStream();     // Catch: Throwable -> L14 IOException -> L16
        byte[] r3 = new byte[1024];     // Catch: Throwable -> L14 IOException -> L16
    L5:
        if (r2.read(r3) == (-1)) goto L9;
        if (new String(r3).contains("colorservice") == false) goto L5;
        r1 = true;
        goto L9
    L9:
        if (r2 == null) goto L20;
        r2.close();     // Catch: IOException -> L12
    L32:
    L20:
        return r1;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        if (r2 == null) goto L20;
        r2.close();     // Catch: IOException -> L12
    L14:
        th = move-exception;
        if (r2 != null) goto L27;
    L26:
        throw th;
    L27:
        r2.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        android.util.Log.d(TAG, "Harmless exception on close!");
        e.printStackTrace();
    L12:
        e = move-exception;
        android.util.Log.d(TAG, "Harmless exception on close!");
        e.printStackTrace();
        goto L20
    }
}
