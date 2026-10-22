package com.android.settings;

import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.IActivityManager;
import android.app.SmtPCUtils;
import android.bluetooth.BluetoothCodecConfig;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.debug.IAdbManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.service.oemlock.OemLockManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.DisplayInfo;
import android.view.IWindowManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.core.view.PointerIconCompat;
import bytedanceos.util.Features;
import com.GlobalProxyLancet;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OptionsPopover;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.bluetooth.BluetoothUtils;
import com.android.settings.bluetooth.codec.BluetoothCodecBitsSettingsActivity;
import com.android.settings.bluetooth.codec.BluetoothCodecSampleRateSettingsActivity;
import com.android.settings.bluetooth.codec.BluetoothCodecSettingsActivity;
import com.android.settings.bluetooth.codec.IBluetoothCodecCallback;
import com.android.settings.bluetooth.codec.utils.BluetoothCodecHelper;
import com.android.settings.deviceinfo.UsbBackend;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.SettingsProviderUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OCardListItemPositionHelper;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.privacy.GrantUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.FeedbackLauncher;
import org.codeaurora.internal.IExtTelephony;

/* JADX INFO: loaded from: classes2.dex */
public class DevelopmentSettings extends BaseActivity implements CompoundButton.OnCheckedChangeListener, DialogInterface.OnClickListener, View.OnClickListener {
    private static final String ACTION_BT_DEBUG = "bytedance.bluetooth.action.DEBUG_STATE_CHANGED";
    private static final String ALLOW_MOCK_MODEM_PROPERTY = "persist.radio.allow_mock_modem";
    private static final int BG_RES_BOTTOM = 3;
    private static final int BG_RES_MID = 2;
    private static final int BG_RES_SINGLE = 0;
    private static final int BG_RES_TOP = 1;
    private static final int DEV_TYPE_BTN = 3;
    private static final int DEV_TYPE_DIV = 0;
    private static final int DEV_TYPE_SUMMARY = 4;
    private static final int DEV_TYPE_SWITCH = 2;
    private static final int DEV_TYPE_TEXT = 1;
    public static final int DIALOG_ENABLE_DEMO_MODE = 2;
    public static final int DIALOG_ENABLE_DISPLAY_PORTRAIT_MODE = 3;
    public static final int DIALOG_ENABLE_THIRD_IME_MODE = 4;
    private static final String DISABLE_SCREEN_SHARE_PROTECTIONS_FOR_APPS_AND_NOTIFICATIONS = "disable_screen_share_protections_for_apps_and_notifications";
    private static final int DURATION_ANIMATION_SCALE_ID = 2;
    private static final String ENABLE_DEMO_MODE = "perfect_statusbar_mode";
    private static final String ENABLE_QUICKBOOT = "enable_quickboot";
    private static final String ENABLE_THIRD_IME = "enable_third_ime_tnt";
    private static final String EXTRA_ON_OFF = "on_off";
    private static final String EXTRA_PKG = "packageName";
    private static final String GMS_SERVICE_ENABLED = "gms_service_enabled";
    private static final String HARDWARE_UI_PROPERTY = "persist.sys.ui.hw";
    private static final String HDCP_CHECKING_PROPERTY = "persist.sys.hdcp_checking";
    private static final int ID_ACCELEROMETER_CALIBRATION = 68;
    private static final int ID_ALLOW_DRAG_WINDOWS = 29;
    private static final int ID_ALLOW_DRAG_WINDOWS_DIV = 30;
    private static final int ID_ALLOW_USB_INSTALL = 16;
    private static final int ID_ANIM_DUFATION_SCALE = 55;
    private static final int ID_APP_PROCESS_LIMIT = 76;
    private static final int ID_BLUETOOTH_CODEC_BITS = 22;
    private static final int ID_BLUETOOTH_CODEC_CHANGE = 20;
    private static final int ID_BLUETOOTH_CODEC_GROUP_GAP = 24;
    private static final int ID_BLUETOOTH_CODEC_SAMPLE_RATE = 21;
    private static final int ID_BLUETOOTH_CODEC_SELECT = 23;
    private static final int ID_BUGREPORT = 82;
    private static final int ID_CLEAR_ADB_KEYS = 11;
    private static final int ID_DC_DIMMING = 37;
    private static final int ID_DC_DIMMING_DIV = 39;
    private static final int ID_DC_DIMMING_TIPS = 38;
    private static final int ID_DEBUG_APP = 13;
    private static final int ID_DEBUG_HW_OVERDRAW = 61;
    private static final int ID_DEFER_MOTION_TIME_SETTINGS = 97;
    private static final int ID_DEFER_MOTION_TIME_SETTINGS_DIV = 98;
    private static final int ID_DEMO_MODE = 40;
    private static final int ID_DEMO_MODE_DIV = 42;
    private static final int ID_DEMO_MODE_INTRODUCE = 41;
    private static final int ID_DEVICE_COLOR_SETTING = 34;
    private static final int ID_DEVICE_COLOR_SETTING_DIV = 36;
    private static final int ID_DEVICE_COLOR_SETTING_TIPS = 35;
    private static final int ID_DISABLE_OVERLAYS = 66;
    private static final int ID_DISABLE_OVERLAYS_DIV = 67;
    private static final int ID_DISABLE_SCREEN_SHARE_PROTECTIONS = 80;
    private static final int ID_DISABLE_SCREEN_SHARE_PROTECTIONS_DIV = 81;
    private static final int ID_DPI_SETTINGS = 95;
    private static final int ID_DPI_SETTINGS_DIV = 96;
    private static final int ID_EDGE_PALM_REJECTION = 31;
    private static final int ID_EDGE_PALM_REJECTION_DIV = 33;
    private static final int ID_EDGE_PALM_REJECTION_TIPS = 32;
    private static final int ID_ENABLE_ADB = 10;
    private static final int ID_ENABLE_HW_DEBUG = 65;
    private static final int ID_ENABLE_OPENGL_TRACES = 73;
    private static final int ID_ENABLE_OPENGL_TRACES_DIV = 74;
    private static final int ID_ENABLE_QUICKBOOT_DIV = 92;
    private static final int ID_FORCE_HW_UI = 58;
    private static final int ID_FORCE_MSAA = 63;
    private static final int ID_FORCE_MSAA_DIV = 64;
    private static final int ID_GMS_SETTINGS = 90;
    private static final int ID_GMS_SETTINGS_TIPS = 91;
    private static final int ID_GYROSCOPE_CALIBRATION = 69;
    private static final int ID_HDCP_CHECK = 85;
    private static final int ID_HIDE_DEV_BTN = 94;
    private static final int ID_IMMEDIATELY_DESTROY_ACTIVITIES = 75;
    private static final int ID_KEEP_SCREEN_ON = 83;
    private static final int ID_KEEP_SCREEN_ON_EX = 84;
    private static final int ID_LEAK_CANARY_APP = 15;
    private static final int ID_MOCK_LOCATION = 12;
    private static final int ID_MOCK_MODEM_SETTINGS = 87;
    private static final int ID_MOTION_DELAY_SETTINGS = 99;
    private static final int ID_MOTION_DELAY_SETTINGS_DIV = 100;
    private static final int ID_OEM_UNLOCK = 18;
    private static final int ID_OVERLAY_DISPLAY_DEVICES = 56;
    private static final int ID_OVERLAY_DISPLAY_DEVICES_DIV = 57;
    private static final int ID_POINTER_LOCATION = 26;
    private static final int ID_POINTER_LOCATION_DIV = 28;
    private static final int ID_PORTRAIT_DISPLAY = 43;
    private static final int ID_PORTRAIT_DISPLAY_DIV = 45;
    private static final int ID_PORTRAIT_DISPLAY_INTRO = 44;
    private static final int ID_RESET_ALL_BTN = 92;
    private static final int ID_RESET_ALL_BTN_DIV = 93;
    private static final int ID_RUNNING_SERVICES = 78;
    private static final int ID_SA_MODE_DIV = 49;
    private static final int ID_SA_MODE_ENABLE = 47;
    private static final int ID_SA_MODE_INTRO = 48;
    private static final int ID_SCENE_AWARENESS = 89;
    private static final int ID_SCENE_AWARENESS_DIV = 88;
    private static final int ID_SHOW_ALL_ANRS = 77;
    private static final int ID_SHOW_ALL_ANRS_DIV = 79;
    private static final int ID_SHOW_CPU_USAGE = 71;
    private static final int ID_SHOW_DEBUG_LAYOUT = 52;
    private static final int ID_SHOW_HDR_SDR_RATIO = 152;
    private static final int ID_SHOW_HW_LAYERS_UDPATES = 60;
    private static final int ID_SHOW_HW_SCREEN_UPDATES = 59;
    private static final int ID_SHOW_NON_RECT_CLIP = 62;
    private static final int ID_SHOW_REFRESH_RATE = 151;
    private static final int ID_SHOW_SCREEN_UPDATE = 51;
    private static final int ID_SHOW_TOP_WINDOW = 27;
    private static final int ID_SHOW_TOUCHES = 25;
    private static final int ID_STRICT_MODE = 70;
    private static final int ID_TELEPHONY_NETWORK_SETTINGS = 87;
    private static final int ID_TNT_THIRD_IME_ENABLE = 46;
    private static final int ID_TNT_THIRD_IME_ENABLE_DIV = 48;
    private static final int ID_TNT_THIRD_IME_ENABLE_INTRO = 47;
    private static final int ID_TRACK_FRAME_TIME = 72;
    private static final int ID_TRANSITION_ANIM_SCALE = 54;
    private static final int ID_USB_CONFIG = 17;
    private static final int ID_VERIFY_APPS_OVER_USB = 15;
    private static final int ID_VERIFY_APPS_OVER_USB_DIV = 19;
    private static final int ID_WAIT_FOR_DEBUGGER = 14;
    private static final int ID_WEB_VIEW_PROVIDER = 49;
    private static final int ID_WEB_VIEW_PROVIDER_DIV = 50;
    private static final int ID_WIFI_VERBOSE_LOG = 86;
    private static final int ID_WINDOW_ANIM_SCALE = 53;
    private static final String INTENT_TELEPHONE_NETWORK_FROM = "telephony_network_from";
    private static final String INTENT_TELEPHONE_NETWORK_TITLE = "telephony_network_settings_title";
    private static final String KEY_SHOW_WIFI_VERBOSE_LOG_SETTING = "key_show_wifi_verbose_log_settings";
    private static final String LEAK_CANARY_APP = "leakcanary_app";
    private static final int[] MOCK_LOCATION_APP_OPS = null;
    private static final String MSAA_PROPERTY = "debug.egl.force_msaa";
    private static final int MSG_ID_UPDATE_USB_CONFIG_DELAY = 1;
    private static final String MULTI_WINDOW_SYSTEM_PROPERTY = "persist.sys.debug.multi_window";
    private static final int NR_MODE_NSA = 1;
    private static final int NR_MODE_SA_NSA = 0;
    private static final String OEM_UNLOCK_SUPPORTED_KEY = "ro.oem_unlock_supported";
    private static final int ON = 1;
    private static final String OPENGL_TRACES_PROPERTY = "debug.egl.trace";
    private static final String PACKAGE_MIME_TYPE = "application/vnd.android.package-archive";
    private static final String PARAMS_TELEPHONE_NETWORK_FROM = "development_settings";
    public static final String PREF_FILE = "development";
    public static final String PREF_SHOW = "show";
    private static final String PROP_ADB_INSTALL_WARNING = "persist.sys.adb_install";
    private static final int REQUEST_CODE_ENABLE_OEM_UNLOCK = 0;
    private static final int RESULT_DEBUG_APP = 1000;
    private static final int RESULT_LEAK_CANARY_APP = 1002;
    private static final int RESULT_MOCK_LOCATION_APP = 1001;
    private static final String SCENE_AWARENESS_CLASS_NAME = "com.obric.cae.userAware.ui.UserAwareLauncherActivity";
    private static final String SCENE_AWARENESS_PACKAGE_NAME = "com.obric.cae";
    private static final int SENSOR_TYPE_ACCELEROMETER = 1;
    private static final int SENSOR_TYPE_GYROSCOPE = 4;
    private static final int SETTING_VALUE_OFF = 0;
    private static final int SETTING_VALUE_ON = 1;
    private static final int SETTING_VALUE_QUERY = 2;
    private static final String SMTBugreportName = "com.obric.feedback";
    private static final String SUPPORTED = "1";
    private static final String SURFACE_COMPOSER_INTERFACE_KEY = "android.ui.ISurfaceComposer";
    private static final String TAG = "DevelopmentSettings";
    private static final int TRANSITION_ANIMATION_SCALE_ID = 1;
    private static final String UNSUPPORTED = "-9999";
    public static final String VIRTUAL_DISPLAY_PORTRAIT_MODE = "debug.virtual.display.portrait";
    private static final String VISIBLE_WINDOW = "visible_window";
    private static final int WINDOW_ANIMATION_SCALE_ID = 0;
    private DevItem mAccelerometerCalibration;
    private OAlertDialog mAdbDialog;
    private OAlertDialog mAdbKeysDialog;
    private DevItem mAllowDragTntWindows;
    private DevItem mAllowDragTntWindowsDiv;
    private DevItem mAllowUsbInstall;
    private DevItem mAnimDurationScale;
    private DevItem mAppProcessLimit;
    private DevItem mBluetoothCodecBits;
    private IBluetoothCodecCallback mBluetoothCodecCallback;
    private DevItem mBluetoothCodecChange;
    private DevItem mBluetoothCodecGap;
    private BluetoothCodecHelper mBluetoothCodecHelper;
    private DevItem mBluetoothCodecSampleRate;
    private DevItem mBluetoothCodecSelect;
    private DevItem mBugreport;
    private DevItem mClearAdbKeys;
    private BluetoothCodecConfig mCurrentBluetoothCodecConfig;
    private DevItem mDebugApp;
    private String mDebugAppPackage;
    private DevItem mDebugHwOverdraw;
    private DevItem mDeferMotionTimeSettings;
    private DevItem mDeferMotionTimeSettingsDiv;
    private DevItem mDelayForRemoveDisplaySettings;
    private DevItem mDelayForRemoveDisplaySettingsDiv;
    private DevItem mDemoModeDiv;
    private DevItem mDemoModeSwitch;
    private DevItem mDemoModeText;
    private BaseAdapter mDevAdapter;
    private ArrayList<DevItem> mDevItems;
    private OptionsInfo mDeviceColorInfo;
    private DevItem mDeviceColorSetting;
    private DevItem mDeviceColorSettingDiv;
    private DevItem mDeviceColorSettingTips;
    private DevItem mDisableOverlays;
    private DevItem mDisableOverlaysDiv;
    private DevItem mDisableScreenShareProtections;
    private DevItem mDisableScreenShareProtectionsDiv;
    private boolean mDontPokeProperties;
    private DevItem mDpiSettings;
    private DevItem mDpiSettingsDiv;
    private DevItem mEdgePalmRejectionDiv;
    private DevItem mEdgePalmRejectionSwitch;
    private DevItem mEdgePalmRejectionTips;
    private DevItem mEnableAdb;
    private DevItem mEnableHwDebug;
    private DevItem mEnableOpenglTraces;
    private DevItem mEnableOpenglTracesDiv;
    private DevItem mEnableQuickbootDiv;
    private IExtTelephony mExtTelephony;
    private DevItem mForceHwUi;
    private DevItem mForceMsaa;
    private DevItem mForceMsaaDiv;
    private DevItem mGMSSettings;
    private DevItem mGMSSettingsTips;
    private DevItem mGyroscopeCalibration;
    private DevItem mGyroscopeCalibrationDiv;
    private Handler mHandler;
    private DevItem mHdcpCheck;
    private DevItem mHideDevBtn;
    private DevItem mImmediatelyDestroyActivities;
    private boolean mIsUsbDataSignalingIsDisabled;
    private DevItem mKeepScreenOn;
    private DevItem mKeepScreenOnEx;
    private DevItem mLeakCanaryApp;
    private String mLeakCanaryApps;
    private DevItem mMockLocation;
    private String mMockLocationApp;
    private DevItem mMockModem;
    private DevItem mMotionDelaySettings;
    private DevItem mMotionDelaySettingsDiv;
    private OemLockManager mOemLockManager;
    private DevItem mOemUnlock;
    private OAlertDialog mOemUnlockConfirmDialog;
    private DevItem mOverlayDisplayDevices;
    private DevItem mOverlayDisplayDevicesDiv;
    private DevItem mPointerLocation;
    private DevItem mPointerLocationDiv;
    private OptionsPopover mPopover;
    private DevItem mPortraitDisplayDiv;
    private DevItem mPortraitDisplaySummary;
    private DevItem mPortraitDisplaySwitch;
    private DevItem mReduceStrobeSwitch;
    private DevItem mReduceStrobeSwitchDiv;
    private DevItem mReduceStrobeSwitchTips;
    private DevItem mResetAllBtn;
    private DevItem mResetAllBtnDiv;
    private ArrayList<DevItem> mResetOptions;
    private DevItem mRunningSevices;
    private OAlertDialog mSaModeDialog;
    private DevItem mSaModeDiv;
    private DevItem mSaModeSummary;
    private DevItem mSaModeSwitch;
    private DevItem mSceneAwareness;
    private DevItem mSceneAwarenessDiv;
    private ContentObserver mScreenStayOnObserver;
    private ContentObserver mScreenStayOnWhilePluggedObserver;
    private DevItem mShowAllAnrs;
    private DevItem mShowAllAnrsDiv;
    private DevItem mShowCpuUsage;
    private DevItem mShowDebugLayout;
    private DevItem mShowHdrSdrRatio;
    private DevItem mShowHwLayersUpdates;
    private DevItem mShowHwScreenUpdates;
    private DevItem mShowNonRectClip;
    private DevItem mShowRefreshRate;
    private DevItem mShowScreenUpdate;
    private DevItem mShowTopWindow;
    private DevItem mShowTouches;
    private ContentObserver mShowTouchesObserver;
    private DevItem mStrictMode;
    private TelephonyManager mTelephonyManager;
    private DevItem mTelephonyNetworkSettings;
    private DevItem mThirdIMEEnableDiv;
    private DevItem mThirdIMEEnableSummary;
    private DevItem mThirdIMEEnableSwitch;
    private int mTitleRes;
    private DevItem mTrackFrameTime;
    private DevItem mTransitionAnimScale;
    private UserManager mUm;
    private boolean mUnavailable;
    private DevItem mUsbConfiguration;
    private BroadcastReceiver mUsbReceiver;
    private DevItem mVerifyAppsOverUsb;
    private DevItem mVerifyAppsOverUsbDiv;
    private DevItem mWaitForDebugger;
    private WifiManager mWifiManager;
    private DevItem mWifiVerboseLog;
    private DevItem mWindowAnimScale;
    private IWindowManager mWindowManager;

    static abstract class AbstractSelectListener implements OptionsInfo.OnSelectListener {
        String[] mValues;

        @Override // com.android.settings.OptionsInfo.OnSelectListener
        public abstract boolean onSelect(int r1);

        AbstractSelectListener() {
        }
    }

    static class AnimationSettingSelectListener extends AbstractSelectListener {
        int mAnimId;

        public AnimationSettingSelectListener(int r1, String[] r2) {
            this.mAnimId = r1;
            this.mValues = r2;
        }

        @Override // com.android.settings.DevelopmentSettings.AbstractSelectListener, com.android.settings.OptionsInfo.OnSelectListener
        public boolean onSelect(int r3) {
            IWindowManager.Stub.asInterface(ServiceManager.getService("window")).setAnimationScale(this.mAnimId, Float.parseFloat(this.mValues[r3]));     // Catch: RemoteException -> L5 NumberFormatException -> L7
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        L7:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static class AppLimitSelectListener extends AbstractSelectListener {
        public AppLimitSelectListener(String[] r1) {
            this.mValues = r1;
        }

        @Override // com.android.settings.DevelopmentSettings.AbstractSelectListener, com.android.settings.OptionsInfo.OnSelectListener
        public boolean onSelect(int r1) {
            return DevelopmentSettings.access$2000(this.mValues[r1]);
        }
    }

    static class DHCPCheckSelectListener extends AbstractSelectListener {
        public DHCPCheckSelectListener(String[] r1) {
            this.mValues = r1;
        }

        @Override // com.android.settings.DevelopmentSettings.AbstractSelectListener, com.android.settings.OptionsInfo.OnSelectListener
        public boolean onSelect(int r1) {
            SystemProperties.set(DevelopmentSettings.HDCP_CHECKING_PROPERTY, this.mValues[r1]);
            return true;
        }
    }

    static class DebugHwOverdrawSelectListener extends AbstractSelectListener {
        public DebugHwOverdrawSelectListener(String[] r1) {
            this.mValues = r1;
        }

        @Override // com.android.settings.DevelopmentSettings.AbstractSelectListener, com.android.settings.OptionsInfo.OnSelectListener
        public boolean onSelect(int r1) {
            DevelopmentSettings.access$1600(this.mValues[r1]);     // Catch: NumberFormatException -> L5
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    private class DevAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        final /* synthetic */ DevelopmentSettings this$0;

        class DevelopmentDetail {
            public OCardListItem item;
            final /* synthetic */ DevAdapter this$1;

            DevelopmentDetail(DevAdapter r1) {
                this.this$1 = r1;
                this.item = null;
            }
        }

        class DevelopmentSwitch {
            public OCardListItem item;
            public OSwitch switchObject;
            final /* synthetic */ DevAdapter this$1;

            DevelopmentSwitch(DevAdapter r1) {
                this.this$1 = r1;
                this.item = null;
                this.switchObject = null;
            }
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 5;
        }

        public DevAdapter(DevelopmentSettings r1) {
            this.this$0 = r1;
            this.mInflater = LayoutInflater.from(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return DevelopmentSettings.access$2100(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return DevelopmentSettings.access$2100(this.this$0).get(r1);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return ((DevItem) DevelopmentSettings.access$2100(this.this$0).get(r1)).mId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [com.obric.oui.button.OButton] */
        /* JADX WARN: Type inference failed for: r4v28 */
        /* JADX WARN: Type inference failed for: r4v29 */
        /* JADX WARN: Type inference failed for: r4v31 */
        /* JADX WARN: Type inference failed for: r4v32 */
        /* JADX WARN: Type inference failed for: r5v0, types: [com.obric.oui.sectiontitlebar.OSectionSupportiveText] */
        /* JADX WARN: Type inference failed for: r5v18 */
        /* JADX WARN: Type inference failed for: r5v20 */
        /* JADX WARN: Type inference failed for: r5v21 */
        /* JADX WARN: Type inference failed for: r5v22 */
        @Override // android.widget.Adapter
        public View getView(int r9, View r10, ViewGroup r11) {
            int r0 = getItemViewType(r9);
            if (r0 != 0) goto L5;
            r10 = Utils.inflateGapView2(r11);
        L11:
            View r1 = r10;
            DevelopmentSwitch r12 = null;
            DevelopmentDetail r13 = null;
        L12:
            DevelopmentDetail r4 = r13;
            ?? r5 = r4;
            ?? r6 = r4;
        L18:
            final DevItem r14 = (DevItem) DevelopmentSettings.access$2100(this.this$0).get(r9);
            if (r14 == null) goto L41;
            if (r12 == null) goto L25;
            r12.switchObject.setOnCheckedChangeListener(null);
            r12.switchObject.setChecked(r14.mChecked);
            r12.item.setTitle(this.this$0.getString(r14.mTitleRes));
            if (r14.mSecSubtitle == "") goto L24;
            r12.item.setSubTitle(r14.mSecSubtitle);
        L24:
            r12.item.showSubTitle(r14.mShowSecSubtitleWhenEndSwitch);
            r12.item.setEnabled(r14.mEnable);
            r12.switchObject.setEnabled(r14.mEnable);
            r12.switchObject.setAlpha(1.0f);
            r12.switchObject.setOnCheckedChangeListener(new AnonymousClass1(this, r14));
            r12.item.setCardPosition(r14.mBgStyle);
        L35:
            if (r14 != DevelopmentSettings.access$1200(this.this$0)) goto L41;
            if (r12 == null) goto L41;
            if (DevelopmentSettings.access$200(this.this$0) == false) goto L40;
            r12.item.getEndSwitch().setEnabled(false);
            OCardListItemUtils.setContentContainerEnabled(r12.item, false);
            r12.item.getContentContainer().setClickable(true);
            r12.item.setOnContentClickListener(new DevelopmentSettings$DevAdapter$$ExternalSyntheticLambda1(this));
            goto L41
        L40:
            r12.item.getEndSwitch().setEnabled(true);
            OCardListItemUtils.setContentContainerEnabled(r12.item, true);
            r12.item.setOnContentClickListener(null);
            goto L41
        L25:
            if (r13 == null) goto L27;
            r13.item.setId(r14.mId);
            r13.item.setTitle(this.this$0.getString(r14.mTitleRes));
            r13.item.setEndDetailText(r14.mSubtitle.toString());
            r13.item.showCustomEnd(true);
            r13.item.setSubTitle(r14.mSecSubtitle);
            r13.item.showSubTitle(true);
            r13.item.setOnClickListener(this.this$0);
            r13.item.setEnabled(r14.mEnable);
            new ImageView(this.this$0.mContext).setImageResource(R.drawable.o_icon_down);
            int r7 = r14.mId;
            r13.item.setCardPosition(r14.mBgStyle);
            r13.item.setDefaultTailIcon(r14.tailIconType);
            final OCardListItem r8 = r13.item;
            r13.item.setOnContentClickListener(new DevelopmentSettings$DevAdapter$$ExternalSyntheticLambda0(r8));
            goto L35
        L27:
            if (r6 == 0) goto L32;
            r6.setId(r14.mId);
            r6.setText(r14.mTitleRes);
            View r15 = r1.findViewById(R.id.btnLayout);
            if ((r15 instanceof FrameLayout) == false) goto L31;
            new OCardListItemPositionHelper((FrameLayout) r15, true, this.this$0.mContext.getColor(R.color.oui_fill_list_item_card), r14.mBgStyle);
        L31:
            r6.setOnClickListener(this.this$0);
            goto L35
        L32:
            if (r5 == 0) goto L35;
            r5.setSectionDes(this.this$0.getResources().getString(r14.mTitleRes));
        L41:
            return r1;
        L5:
            if (r0 != 1) goto L7;
            DevelopmentDetail r16 = new DevelopmentDetail(this);
            View r17 = this.mInflater.inflate(R.layout.list_content_item_text_oui_2, r11, false);
            r16.item = (OCardListItem) r17.findViewById(R.id.item_text);
            r16.item.setDefaultCustomEndView(3);
            r16.item.showCustomEnd(true);
            r17.setTag(r16);
            r1 = r17;
            r6 = 0;
            r5 = 0;
            r13 = r16;
            r12 = null;
            goto L18
        L7:
            if (r0 == 2) goto L15;
            if (r0 != 3) goto L10;
            View r18 = this.mInflater.inflate(R.layout.list_content_item_button, r11, false);
            OButton r19 = (OButton) r18.findViewById(R.id.item_button);
            r18.setTag(r19);
            r1 = r18;
            r6 = r19;
            r12 = null;
            r13 = null;
            r5 = 0;
            goto L18
        L10:
            if (r0 != 4) goto L11;
            View r110 = this.mInflater.inflate(R.layout.list_item_tips, r11, false);
            OSectionSupportiveText r111 = (OSectionSupportiveText) r110.findViewById(R.id.item_tips);
            r110.setTag(r111);
            r1 = r110;
            r5 = r111;
            r12 = null;
            r13 = null;
            r6 = 0;
            goto L18
        L15:
            r12 = new DevelopmentSwitch(this);
            View r112 = this.mInflater.inflate(R.layout.list_content_item_text_oui_2, r11, false);
            r12.item = (OCardListItem) r112.findViewById(R.id.item_text);
            r12.item.setDefaultCustomEndView(1);
            r12.item.showCustomEnd(true);
            r12.item.showTailIcon(false);
            r12.switchObject = (OSwitch) r12.item.getCustomEndView();
            r12.switchObject.setClickable(true);
            r112.setTag(r12);
            r1 = r112;
            r13 = null;
            goto L12
        }

        static /* synthetic */ void lambda$getView$0(View r0, View r1) {
            r0.performClick();
        }

        /* JADX INFO: renamed from: lambda$getView$1$com-android-settings-DevelopmentSettings$DevAdapter, reason: not valid java name */
        /* synthetic */ void m124x95792b07(View r1) {
            RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.this$0.mContext, getDeviceOwner());
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r1) {
            return ((DevItem) DevelopmentSettings.access$2100(this.this$0).get(r1)).mType;
        }

        private RestrictedLockUtils.EnforcedAdmin getDeviceOwner() {
            return RestrictedLockUtilsInternal.getDeviceOwner(this.this$0.mContext);
        }
    }

    private static class DevItem {
        public static final int TAIL_ICON_ARROW = 0;
        public static final int TAIL_ICON_CHEVRON = 1;
        int mBgStyle;
        boolean mChecked;
        boolean mEnable;
        int mId;
        CharSequence mSecSubtitle;
        boolean mShowSecSubtitleWhenEndSwitch;
        CharSequence mSubtitle;
        int mTitleRes;
        int mType;
        int tailIconType;

        public DevItem(int r3, int r4, int r5, int r6) {
            this.mSubtitle = "";
            this.mSecSubtitle = "";
            this.mShowSecSubtitleWhenEndSwitch = false;
            this.mEnable = true;
            this.tailIconType = 0;
            this.mId = r3;
            this.mType = r4;
            this.mTitleRes = r5;
            this.mBgStyle = r6;
        }
    }

    static class DeviceColorSettingListener extends AbstractSelectListener {
        DeviceColorSettingListener(String[] r1) {
            this.mValues = r1;
        }

        @Override // com.android.settings.DevelopmentSettings.AbstractSelectListener, com.android.settings.OptionsInfo.OnSelectListener
        public boolean onSelect(int r1) {
            SystemProperties.set(Constants.PROP_DEVICE_COLOR, this.mValues[r1]);
            return true;
        }
    }

    static class NonRectClipSelectListener extends AbstractSelectListener {
        public NonRectClipSelectListener(String[] r1) {
            this.mValues = r1;
        }

        @Override // com.android.settings.DevelopmentSettings.AbstractSelectListener, com.android.settings.OptionsInfo.OnSelectListener
        public boolean onSelect(int r1) {
            DevelopmentSettings.access$1700(this.mValues[r1]);     // Catch: NumberFormatException -> L5
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static class OpenGLTracesSelectListener extends AbstractSelectListener {
        public OpenGLTracesSelectListener(String[] r1) {
            this.mValues = r1;
        }

        @Override // com.android.settings.DevelopmentSettings.AbstractSelectListener, com.android.settings.OptionsInfo.OnSelectListener
        public boolean onSelect(int r1) {
            DevelopmentSettings.access$1900(this.mValues[r1]);     // Catch: NumberFormatException -> L5
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    static class SystemPropPoker extends AsyncTask<Void, Void, Void> {
        SystemPropPoker() {
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... r9) {
            String[] r8 = ServiceManager.listServices();
            if (r8 != null) goto L5;
            return null;
        L5:
            int r0 = r8.length;
            int r2 = 0;
        L6:
            if (r2 >= r0) goto L16;
            String r3 = r8[r2];
            IBinder r4 = ServiceManager.checkService(r3);
            if (r4 == null) goto L15;
            Parcel r5 = Parcel.obtain();
            r4.transact(1599295570, r5, null, 0);     // Catch: Exception -> L12 RemoteException -> L17
        L12:
            e = move-exception;
            OLog.i(DevelopmentSettings.TAG, "Someone wrote a bad service '" + r3 + "' that doesn't like to be poked: " + e);
        L14:
            r5.recycle();
        L15:
            r2 = r2 + 1;
            goto L6
        L16:
            return null;
        }
    }

    static class TrackFrameTimeSelectListener extends AbstractSelectListener {
        public TrackFrameTimeSelectListener(String[] r1) {
            this.mValues = r1;
        }

        @Override // com.android.settings.DevelopmentSettings.AbstractSelectListener, com.android.settings.OptionsInfo.OnSelectListener
        public boolean onSelect(int r1) {
            DevelopmentSettings.access$1800(this.mValues[r1]);     // Catch: NumberFormatException -> L5
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    private void updateForceRtlOptions() {
    }

    private void updateWifiDisplayCertificationOptions() {
    }

    private void writeWifiDisplayCertificationOptions() {
    }

    public void com_android_settings_DevelopmentSettings__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_DevelopmentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_android_settings_DevelopmentSettings_com_obric_hook_lancet_PrivacyHook_onDestroy(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_android_settings_DevelopmentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_DevelopmentSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_DevelopmentSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_DevelopmentSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public DevelopmentSettings() {
        this.mResetOptions = new ArrayList();
        this.mIsUsbDataSignalingIsDisabled = false;
        this.mDevItems = new ArrayList();
        this.mUsbReceiver = new AnonymousClass1(this);
        this.mHandler = new AnonymousClass2(this);
        final Handler r1 = this.mHandler;
        this.mScreenStayOnObserver = new AnonymousClass3(this, r1);
        final Handler r2 = this.mHandler;
        this.mScreenStayOnWhilePluggedObserver = new AnonymousClass4(this, r2);
        final Handler r3 = this.mHandler;
        this.mShowTouchesObserver = new AnonymousClass5(this, r3);
        this.mCurrentBluetoothCodecConfig = null;
        this.mBluetoothCodecCallback = new AnonymousClass6(this);
    }

    static /* synthetic */ void access$000(DevelopmentSettings r0, boolean r1) {
        r0.writeBtHciSnoopLogOptions(r1);
    }

    static /* synthetic */ void access$100(DevelopmentSettings r0, boolean r1) {
        r0.updateUsbConfigurationValues(r1);
    }

    static /* synthetic */ void access$1000(DevelopmentSettings r0) {
        r0.updateBluetoothCodecSettings();
    }

    static /* synthetic */ BluetoothCodecConfig access$1102(DevelopmentSettings r0, BluetoothCodecConfig r1) {
        r0.mCurrentBluetoothCodecConfig = r1;
        return r1;
    }

    static /* synthetic */ DevItem access$1200(DevelopmentSettings r0) {
        return r0.mEnableAdb;
    }

    static /* synthetic */ DevItem access$1300(DevelopmentSettings r0) {
        return r0.mDemoModeSwitch;
    }

    static /* synthetic */ DevItem access$1400(DevelopmentSettings r0) {
        return r0.mPortraitDisplaySwitch;
    }

    static /* synthetic */ DevItem access$1500(DevelopmentSettings r0) {
        return r0.mThirdIMEEnableSwitch;
    }

    static /* synthetic */ void access$1600(Object r0) {
        writeDebugHwOverdrawOptions(r0);
    }

    static /* synthetic */ void access$1700(Object r0) {
        writeShowNonRectClipOptions(r0);
    }

    static /* synthetic */ void access$1800(Object r0) {
        writeTrackFrameTimeOptions(r0);
    }

    static /* synthetic */ void access$1900(Object r0) {
        writeOpenGLTracesOptions(r0);
    }

    static /* synthetic */ boolean access$200(DevelopmentSettings r0) {
        return r0.mIsUsbDataSignalingIsDisabled;
    }

    static /* synthetic */ boolean access$2000(Object r0) {
        return writeAppProcessLimitOptions(r0);
    }

    static /* synthetic */ boolean access$202(DevelopmentSettings r0, boolean r1) {
        r0.mIsUsbDataSignalingIsDisabled = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$2100(DevelopmentSettings r0) {
        return r0.mDevItems;
    }

    static /* synthetic */ IExtTelephony access$2200(DevelopmentSettings r0) {
        return r0.mExtTelephony;
    }

    static /* synthetic */ void access$300(DevelopmentSettings r0) {
        r0.initDevItems();
    }

    static /* synthetic */ BaseAdapter access$400(DevelopmentSettings r0) {
        return r0.mDevAdapter;
    }

    static /* synthetic */ DevItem access$500(DevelopmentSettings r0) {
        return r0.mKeepScreenOnEx;
    }

    static /* synthetic */ void access$600(DevelopmentSettings r0, DevItem r1, boolean r2) {
        r0.updateCheckBox(r1, r2);
    }

    static /* synthetic */ DevItem access$700(DevelopmentSettings r0) {
        return r0.mKeepScreenOn;
    }

    static /* synthetic */ void access$800(DevelopmentSettings r0) {
        r0.updateShowTouchesOptions();
    }

    static /* synthetic */ BluetoothCodecHelper access$900(DevelopmentSettings r0) {
        return r0.mBluetoothCodecHelper;
    }

    static {
        MOCK_LOCATION_APP_OPS = new int[]{58};
    }

    public void com_android_settings_DevelopmentSettings__onCreate$___twin___(Bundle r8) {
        super.onCreate(r8);
        this.mUm = (UserManager) getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        this.mExtTelephony = IExtTelephony.Stub.asInterface(ServiceManager.getService("extphone"));
        if (Utils.isMonkeyRunning() == false) goto L7;
        OLog.d(TAG, "monkey is running ,skip create DevelopmentSettings");
        return;
    L7:
        if (Process.myUserHandle().getIdentifier() == 0) goto L9;
    L31:
        this.mUnavailable = true;
        OLog.d(TAG, "is unavailable ,skip create DevelopmentSettings");
        return;
    L9:
        if (this.mUm.hasUserRestriction("no_debugging_features") == true) goto L31;
        if (TextUtils.equals(SystemProperties.get(OEM_UNLOCK_SUPPORTED_KEY, UNSUPPORTED), "1") == true) goto L14;
        this.mOemLockManager = null;
        OLog.w(TAG, "oem_unlock not supported.");
    L15:
        this.mTelephonyManager = (TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY);
        setContentView(R.layout.settings_layout);
        initDevItems();
        initDeviceColorOptions();
        ListView r9 = (ListView) findViewById(R.id.list_view);
        View r2 = LayoutInflater.from(this).inflate(R.layout.item_sub_settings_padding_layout2, r9, false);
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.height = getResources().getDimensionPixelSize(R.dimen.main_settings_first_item_card_gap);
        r2.setLayoutParams(r3);
        r9.addHeaderView(r2);
        r9.addFooterView(LayoutInflater.from(this).inflate(R.layout.item_bottom_shadow_layout2, r9, false));
        DevAdapter r4 = new DevAdapter(this);
        this.mDevAdapter = r4;
        r9.setAdapter(r4);
        if (showVerifierSetting() == true) goto L18;
        this.mVerifyAppsOverUsb.mEnable = false;
    L18:
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.hardware.usb.action.USB_STATE");
        if (GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this, this.mUsbReceiver, r10, 2) != null) goto L21;
        updateUsbConfigurationValues(true);
    L21:
        this.mResetOptions.add(this.mEnableAdb);
        this.mResetOptions.add(this.mAllowUsbInstall);
        this.mResetOptions.add(this.mShowHwLayersUpdates);
        this.mResetOptions.add(this.mForceMsaa);
        this.mResetOptions.add(this.mWifiVerboseLog);
        this.mResetOptions.add(this.mMockLocation);
        this.mResetOptions.add(this.mWaitForDebugger);
        this.mResetOptions.add(this.mShowTouches);
        this.mResetOptions.add(this.mPointerLocation);
        if (SettingsFeature.isSupportTopWindowFeature() == false) goto L24;
        this.mResetOptions.add(this.mShowTopWindow);
    L24:
        this.mResetOptions.add(this.mPortraitDisplaySwitch);
        if (SettingsFeature.isDarwin() == false) goto L27;
        this.mResetOptions.add(this.mSaModeSwitch);
    L27:
        this.mResetOptions.add(this.mThirdIMEEnableSwitch);
        this.mResetOptions.add(this.mShowDebugLayout);
        this.mResetOptions.add(this.mShowHwScreenUpdates);
        this.mResetOptions.add(this.mShowScreenUpdate);
        this.mResetOptions.add(this.mDisableOverlays);
        this.mResetOptions.add(this.mForceHwUi);
        this.mResetOptions.add(this.mStrictMode);
        this.mResetOptions.add(this.mShowCpuUsage);
        this.mResetOptions.add(this.mImmediatelyDestroyActivities);
        this.mResetOptions.add(this.mShowAllAnrs);
        this.mWindowManager = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
        this.mTitleRes = R.string.advanced_item_development;
        UIUtils.setUpFakeStatusBarOnApplyWindowInsets(findViewById(R.id.fake_status_bar));
        getIntent().putExtra("title", getString(this.mTitleRes));     // Catch: Exception -> L33
    L29:
        setupBackBtnOnTitle();
        getContentResolver().registerContentObserver(android.provider.Settings.Global.getUriFor("stay_on_alltime"), false, this.mScreenStayOnObserver);
        getContentResolver().registerContentObserver(android.provider.Settings.Global.getUriFor("stay_on_while_plugged_in"), false, this.mScreenStayOnWhilePluggedObserver);
        getContentResolver().registerContentObserver(android.provider.Settings.Global.getUriFor("show_touches"), false, this.mShowTouchesObserver);
        BluetoothCodecHelper r11 = new BluetoothCodecHelper(TAG, this.mContext, this.mBluetoothCodecCallback);
        this.mBluetoothCodecHelper = r11;
        r11.connect();
        return;
    L14:
        this.mOemLockManager = (OemLockManager) getSystemService("oem_lock");
        goto L15
    }

    private void initDevItems() {
        this.mDevItems.clear();
        DevItem r0 = new DevItem(10, 2, R.string.enable_adb, 1);
        this.mEnableAdb = r0;
        this.mDevItems.add(r0);
        if (SystemProperties.getBoolean("ro.adb.secure", true) == false) goto L5;
        this.mClearAdbKeys = new DevItem(11, 1, R.string.clear_adb_keys, 2);
    L5:
        DevItem r1 = new DevItem(12, 1, R.string.mock_location_app, 2);
        this.mMockLocation = r1;
        this.mDevItems.add(r1);
        DevItem r2 = new DevItem(13, 1, R.string.debug_app, 2);
        this.mDebugApp = r2;
        this.mDevItems.add(r2);
        DevItem r3 = new DevItem(14, 2, R.string.wait_for_debugger, 2);
        this.mWaitForDebugger = r3;
        this.mDevItems.add(r3);
        if (SettingsFeature.isSupportLeakCanary() == false) goto L8;
        DevItem r4 = new DevItem(15, 1, R.string.dev_leak_canary_app, 2);
        this.mLeakCanaryApp = r4;
        this.mDevItems.add(r4);
    L8:
        DevItem r5 = new DevItem(15, 2, R.string.verify_apps_over_usb_title, 2);
        this.mVerifyAppsOverUsb = r5;
        this.mDevItems.add(r5);
        DevItem r6 = new DevItem(16, 2, R.string.keep_allow_usb_install, 2);
        this.mAllowUsbInstall = r6;
        this.mDevItems.add(r6);
        DevItem r7 = new DevItem(17, 1, R.string.select_usb_config_title, 2);
        this.mUsbConfiguration = r7;
        if (this.mIsUsbDataSignalingIsDisabled == true) goto L11;
        this.mDevItems.add(r7);
    L11:
        DevItem r8 = new DevItem(18, 2, R.string.oem_unlock, 3);
        this.mOemUnlock = r8;
        this.mDevItems.add(r8);
        DevItem r9 = new DevItem(19, 0, 0, 0);
        this.mVerifyAppsOverUsbDiv = r9;
        this.mDevItems.add(r9);
        DevItem r10 = new DevItem(20, 1, R.string.codec_settings, 1);
        this.mBluetoothCodecChange = r10;
        this.mDevItems.add(r10);
        DevItem r11 = new DevItem(21, 1, R.string.bluetooth_select_a2dp_codec_sample_rate, 2);
        this.mBluetoothCodecSampleRate = r11;
        this.mDevItems.add(r11);
        DevItem r12 = new DevItem(22, 1, R.string.bluetooth_select_a2dp_codec_bits_per_sample, 2);
        this.mBluetoothCodecBits = r12;
        this.mDevItems.add(r12);
        DevItem r13 = new DevItem(23, 1, R.string.bluetooth_select_a2dp_codec_select, 3);
        this.mBluetoothCodecSelect = r13;
        this.mDevItems.add(r13);
        DevItem r14 = new DevItem(24, 0, 0, 0);
        this.mBluetoothCodecGap = r14;
        this.mDevItems.add(r14);
        DevItem r15 = new DevItem(25, 2, R.string.show_touches, 1);
        this.mShowTouches = r15;
        this.mDevItems.add(r15);
        boolean r16 = SettingsFeature.isSupportTopWindowFeature();
        if (r16 == false) goto L14;
        int r17 = 2;
    L15:
        DevItem r18 = new DevItem(26, 2, R.string.pointer_location, r17);
        this.mPointerLocation = r18;
        this.mDevItems.add(r18);
        if (r16 == false) goto L18;
        DevItem r19 = new DevItem(27, 2, R.string.dev_show_top_window_title, 3);
        this.mShowTopWindow = r19;
        this.mDevItems.add(r19);
    L18:
        DevItem r20 = new DevItem(28, 0, 0, 0);
        this.mPointerLocationDiv = r20;
        this.mDevItems.add(r20);
        if (this.mIsExtDisplaying == false) goto L21;
        DevItem r21 = new DevItem(95, 1, R.string.dpi_settings_title, 0);
        this.mDpiSettings = r21;
        this.mDevItems.add(r21);
        DevItem r22 = new DevItem(96, 0, 0, 0);
        this.mDpiSettingsDiv = r22;
        this.mDevItems.add(r22);
    L21:
        this.mAllowDragTntWindows = new DevItem(29, 2, R.string.allow_drag_windows, 0);
        this.mAllowDragTntWindowsDiv = new DevItem(30, 0, 0, 0);
        if (this.mIsExtDisplaying == false) goto L24;
        this.mDevItems.add(this.mAllowDragTntWindows);
        this.mDevItems.add(this.mAllowDragTntWindowsDiv);
    L24:
        this.mEdgePalmRejectionSwitch = new DevItem(31, 2, R.string.edge_palm_rejection_title, 0);
        this.mEdgePalmRejectionTips = new DevItem(32, 4, R.string.edge_palm_rejection_tips, 0);
        this.mEdgePalmRejectionDiv = new DevItem(33, 0, 0, 0);
        this.mDevItems.add(this.mEdgePalmRejectionSwitch);
        this.mDevItems.add(this.mEdgePalmRejectionTips);
        this.mDevItems.add(this.mEdgePalmRejectionDiv);
        this.mDeviceColorSetting = new DevItem(34, 1, R.string.dev_device_color_option, 0);
        this.mDeviceColorSettingTips = new DevItem(35, 4, R.string.dev_device_color_option_tips, 0);
        this.mDeviceColorSettingDiv = new DevItem(36, 0, 0, 0);
        this.mReduceStrobeSwitch = new DevItem(37, 2, R.string.reduce_screen_strobe, 0);
        this.mReduceStrobeSwitchTips = new DevItem(38, 4, R.string.reduce_screen_strobe_darwin_tips, 0);
        this.mReduceStrobeSwitchDiv = new DevItem(39, 0, 0, 0);
        DevItem r23 = new DevItem(43, 2, R.string.portrait_mode_wifi_display_title, 0);
        this.mPortraitDisplaySwitch = r23;
        this.mDevItems.add(r23);
        DevItem r24 = new DevItem(44, 4, R.string.portrait_mode_wifi_display_summary, 0);
        this.mPortraitDisplaySummary = r24;
        this.mDevItems.add(r24);
        DevItem r25 = new DevItem(45, 0, 0, 0);
        this.mPortraitDisplayDiv = r25;
        this.mDevItems.add(r25);
        this.mSaModeSwitch = new DevItem(47, 2, R.string.nr_sa_mode_title, 0);
        this.mSaModeSummary = new DevItem(48, 4, R.string.sa_mode_summary, 0);
        this.mSaModeDiv = new DevItem(49, 0, 0, 0);
        if (SettingsFeature.isDarwin() == false) goto L27;
        this.mDevItems.add(this.mSaModeSwitch);
        this.mDevItems.add(this.mSaModeSummary);
        this.mDevItems.add(this.mSaModeDiv);
    L27:
        DevItem r26 = new DevItem(51, 2, R.string.show_screen_updates, 1);
        this.mShowScreenUpdate = r26;
        this.mDevItems.add(r26);
        DevItem r27 = new DevItem(151, 2, R.string.show_refresh_rate, 2);
        this.mShowRefreshRate = r27;
        this.mDevItems.add(r27);
        DevItem r28 = new DevItem(152, 2, R.string.show_hrd_sdr_ratio, 2);
        this.mShowHdrSdrRatio = r28;
        this.mDevItems.add(r28);
        DevItem r29 = new DevItem(52, 2, R.string.debug_layout, 2);
        this.mShowDebugLayout = r29;
        this.mDevItems.add(r29);
        DevItem r30 = new DevItem(53, 1, R.string.window_animation_scale_title, 2);
        this.mWindowAnimScale = r30;
        r30.tailIconType = 1;
        this.mDevItems.add(this.mWindowAnimScale);
        DevItem r31 = new DevItem(54, 1, R.string.transition_animation_scale_title, 2);
        this.mTransitionAnimScale = r31;
        r31.tailIconType = 1;
        this.mDevItems.add(this.mTransitionAnimScale);
        DevItem r32 = new DevItem(55, 1, R.string.animator_duration_scale_title, 2);
        this.mAnimDurationScale = r32;
        r32.tailIconType = 1;
        this.mDevItems.add(this.mAnimDurationScale);
        DevItem r33 = new DevItem(56, 1, R.string.overlay_display_devices_title, 3);
        this.mOverlayDisplayDevices = r33;
        r33.tailIconType = 1;
        this.mDevItems.add(this.mOverlayDisplayDevices);
        DevItem r34 = new DevItem(57, 0, 0, 0);
        this.mOverlayDisplayDevicesDiv = r34;
        this.mDevItems.add(r34);
        DevItem r35 = new DevItem(58, 2, R.string.force_hw_ui, 1);
        this.mForceHwUi = r35;
        this.mDevItems.add(r35);
        DevItem r36 = new DevItem(59, 2, R.string.show_hw_screen_updates, 2);
        this.mShowHwScreenUpdates = r36;
        this.mDevItems.add(r36);
        DevItem r37 = new DevItem(60, 2, R.string.show_hw_layers_updates, 2);
        this.mShowHwLayersUpdates = r37;
        this.mDevItems.add(r37);
        DevItem r38 = new DevItem(61, 1, R.string.debug_hw_overdraw, 2);
        this.mDebugHwOverdraw = r38;
        r38.tailIconType = 1;
        this.mDevItems.add(this.mDebugHwOverdraw);
        DevItem r39 = new DevItem(62, 1, R.string.show_non_rect_clip, 2);
        this.mShowNonRectClip = r39;
        r39.tailIconType = 1;
        this.mDevItems.add(this.mShowNonRectClip);
        this.mDisableOverlays = new DevItem(66, 2, R.string.disable_overlays, 2);
        if (SettingsFeature.isDarwin() == false) goto L32;
        DevItem r40 = new DevItem(63, 2, R.string.force_msaa, 3);
        this.mForceMsaa = r40;
        this.mDevItems.add(r40);
        DevItem r41 = new DevItem(64, 0, 0, 0);
        this.mForceMsaaDiv = r41;
        this.mDevItems.add(r41);
        this.mEnableHwDebug = new DevItem(65, 2, R.string.enable_hw_debug, 1);
        if (Build.TYPE.equals(PickApplicationActivity.EXTRA_USER) == true) goto L33;
        this.mDevItems.add(this.mEnableHwDebug);
        this.mDevItems.add(this.mDisableOverlays);
    L33:
        DevItem r42 = new DevItem(68, 1, R.string.accelerometer_calibration, 2);
        this.mAccelerometerCalibration = r42;
        this.mDevItems.add(r42);
        DevItem r43 = new DevItem(69, 1, R.string.gyroscope_calibration, 3);
        this.mGyroscopeCalibration = r43;
        this.mDevItems.add(r43);
        DevItem r44 = new DevItem(69, 0, 0, 0);
        this.mGyroscopeCalibrationDiv = r44;
        this.mDevItems.add(r44);
        DevItem r45 = new DevItem(70, 2, R.string.strict_mode, 1);
        this.mStrictMode = r45;
        this.mDevItems.add(r45);
        this.mShowCpuUsage = new DevItem(71, 2, R.string.show_cpu_usage, 2);
        if (Build.IS_DEBUGGABLE == false) goto L36;
        this.mDevItems.add(this.mShowCpuUsage);
    L36:
        DevItem r46 = new DevItem(72, 1, R.string.track_frame_time, 2);
        this.mTrackFrameTime = r46;
        r46.tailIconType = 1;
        this.mDevItems.add(this.mTrackFrameTime);
        DevItem r47 = new DevItem(73, 1, R.string.enable_opengl_traces_title, 3);
        this.mEnableOpenglTraces = r47;
        r47.tailIconType = 1;
        this.mDevItems.add(this.mEnableOpenglTraces);
        DevItem r48 = new DevItem(74, 0, 0, 0);
        this.mEnableOpenglTracesDiv = r48;
        this.mDevItems.add(r48);
        DevItem r49 = new DevItem(75, 2, R.string.immediately_destroy_activities, 1);
        this.mImmediatelyDestroyActivities = r49;
        this.mDevItems.add(r49);
        DevItem r50 = new DevItem(76, 1, R.string.app_process_limit_title, 2);
        this.mAppProcessLimit = r50;
        r50.tailIconType = 1;
        this.mDevItems.add(this.mAppProcessLimit);
        if (Features.isFeatureCMCCEnabled(this.mContext).booleanValue() == false) goto L39;
        this.mShowAllAnrs = new DevItem(77, 2, R.string.show_all_anrs, 2);
        this.mRunningSevices = new DevItem(78, 1, R.string.runningservices_settings_title, 3);
        this.mDevItems.add(this.mShowAllAnrs);
        this.mDevItems.add(this.mRunningSevices);
    L40:
        DevItem r51 = new DevItem(79, 0, 0, 0);
        this.mShowAllAnrsDiv = r51;
        this.mDevItems.add(r51);
        initDisableScreenShareProtections();
        if (XTSUtils.isInXtsMode() == false) goto L43;
        this.mDevItems.add(this.mDisableScreenShareProtections);
        this.mDevItems.add(this.mDisableScreenShareProtectionsDiv);
    L43:
        DevItem r52 = new DevItem(82, 1, R.string.about_user_feedback, 1);
        this.mBugreport = r52;
        this.mDevItems.add(r52);
        DevItem r53 = new DevItem(83, 2, R.string.stay_awake_when_battery_plugged, 2);
        this.mKeepScreenOn = r53;
        this.mDevItems.add(r53);
        DevItem r54 = new DevItem(84, 2, R.string.stay_awake_alltime, 2);
        this.mKeepScreenOnEx = r54;
        this.mDevItems.add(r54);
        DevItem r55 = new DevItem(85, 1, R.string.hdcp_checking_title, 2);
        this.mHdcpCheck = r55;
        r55.tailIconType = 1;
        this.mDevItems.add(this.mHdcpCheck);
        DevItem r56 = new DevItem(86, 2, R.string.wifi_verbose_logging, 2);
        this.mWifiVerboseLog = r56;
        this.mDevItems.add(r56);
        DevItem r57 = new DevItem(87, 1, R.string.telephony_network_settings, 2);
        this.mTelephonyNetworkSettings = r57;
        this.mDevItems.add(r57);
        DevItem r58 = new DevItem(87, 2, R.string.allow_mock_modem, 3);
        this.mMockModem = r58;
        r58.mSecSubtitle = getString(R.string.allow_mock_modem_sub_title);
        this.mMockModem.mShowSecSubtitleWhenEndSwitch = true;
        this.mDevItems.add(this.mMockModem);
        this.mGMSSettings = new DevItem(90, 2, R.string.GMS_settings_title, 2);
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), GMS_SERVICE_ENABLED, 0) != 1) goto L46;
        this.mGMSSettings.mChecked = true;
        this.mGMSSettings.mEnable = false;
    L46:
        this.mGMSSettingsTips = new DevItem(91, 4, R.string.GMS_settings_summary, 0);
        DevItem r59 = new DevItem(92, 0, 0, 0);
        this.mEnableQuickbootDiv = r59;
        this.mDevItems.add(r59);
        DevItem r60 = new DevItem(92, 3, R.string.dev_reset_all_options, 1);
        this.mResetAllBtn = r60;
        this.mDevItems.add(r60);
        this.mResetAllBtnDiv = new DevItem(93, 0, 0, 0);
        DevItem r61 = new DevItem(94, 3, R.string.dev_hide_dev_page, 3);
        this.mHideDevBtn = r61;
        this.mDevItems.add(r61);
        return;
    L39:
        DevItem r62 = new DevItem(77, 2, R.string.show_all_anrs, 3);
        this.mShowAllAnrs = r62;
        this.mDevItems.add(r62);
        goto L40
    L32:
        DevItem r63 = new DevItem(63, 2, R.string.force_msaa, 2);
        this.mForceMsaa = r63;
        this.mDevItems.add(r63);
        this.mDevItems.add(this.mDisableOverlays);
        goto L33
    L14:
        r17 = 3;
        goto L15
    }

    private void initDeviceColorOptions() {
        SettingsFeature.isSupportColorOverride();
    }

    public void com_android_settings_DevelopmentSettings__onResume$___twin___() {
        super.onResume();
        if (Utils.isMonkeyRunning() == false) goto L5;
    L9:
        finish();
        return;
    L5:
        if (this.mUnavailable == true) goto L9;
        updateAllOptions();
    }

    public void com_android_settings_DevelopmentSettings__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_DevelopmentSettings__onDestroy$___twin___() {
        super.onDestroy();
        BluetoothCodecHelper r0 = this.mBluetoothCodecHelper;
        if (r0 == null) goto L6;
        r0.disconnect();
    L6:
        if (Utils.isMonkeyRunning() == false) goto L8;
    L16:
        OLog.d(TAG, "not need unregisterReceiver, mUnavailable = " + this.mUnavailable + ", monkey = " + Utils.isMonkeyRunning());
        return;
    L8:
        if (this.mUnavailable == true) goto L16;
        unregisterReceiver(this.mUsbReceiver);     // Catch: IllegalArgumentException -> L12
    L14:
        this.mHandler.removeCallbacksAndMessages(null);
        getContentResolver().unregisterContentObserver(this.mScreenStayOnObserver);
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        checkStatechanged(((Integer) r1.getTag()).intValue(), r2);
    }

    private void checkStatechanged(int r8, boolean r9) {
        if (Utils.isMonkeyRunning() == false) goto L5;
        return;
    L5:
        String r0 = "true";
        int r2 = 3;
        switch(r8) {
            case 10: goto L70;
            case 14: goto L69;
            case 15: goto L68;
            case 16: goto L67;
            case 18: goto L59;
            case 25: goto L58;
            case 26: goto L57;
            case 27: goto L56;
            case 29: goto L55;
            case 31: goto L54;
            case 37: goto L53;
            case 40: goto L50;
            case 43: goto L47;
            case 46: goto L46;
            case 47: goto L43;
            case 51: goto L42;
            case 52: goto L41;
            case 58: goto L37;
            case 59: goto L36;
            case 60: goto L35;
            case 63: goto L34;
            case 65: goto L29;
            case 66: goto L28;
            case 70: goto L27;
            case 71: goto L26;
            case 75: goto L25;
            case 77: goto L24;
            case 80: goto L23;
            case 83: goto L18;
            case 84: goto L17;
            case 86: goto L16;
            case 87: goto L12;
            case 90: goto L10;
            case 151: goto L9;
            case 152: goto L8;
            default: goto L119;
        };
    L8:
        writeShowHdrSdrRatioSetting(r9);
        return;
    L9:
        writeShowRefreshRateSetting(r9);
        return;
    L10:
        if (r9 == false) goto L79;
        this.mGMSSettings.mEnable = false;
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), GMS_SERVICE_ENABLED, 1);
        this.mDevAdapter.notifyDataSetChanged();
        return;
    L79:
        return;
    L12:
        if (r9 == true) goto L15;
        r0 = "false";
    L15:
        SystemProperties.set(ALLOW_MOCK_MODEM_PROPERTY, r0);
        return;
    L16:
        writeWifiVerboseLoggingOptions(r9);
        return;
    L17:
        android.provider.Settings.Global.putInt(getContentResolver(), "stay_on_alltime", r9 ? 1 : 0);
        return;
    L18:
        ContentResolver r7 = getContentResolver();
        if (r9 == true) goto L22;
        r2 = 0;
    L22:
        android.provider.Settings.Global.putInt(r7, "stay_on_while_plugged_in", r2);
        return;
    L23:
        android.provider.Settings.Global.putInt(getContentResolver(), DISABLE_SCREEN_SHARE_PROTECTIONS_FOR_APPS_AND_NOTIFICATIONS, r9 ? 1 : 0);
        return;
    L24:
        android.provider.Settings.Secure.putInt(getContentResolver(), "anr_show_background", r9 ? 1 : 0);
        return;
    L25:
        writeImmediatelyDestroyActivitiesOptions(r9);
        return;
    L26:
        writeCpuUsageOptions(r9);
        return;
    L27:
        writeStrictModeVisualOptions(r9);
        return;
    L28:
        android.provider.Settings.Global.putInt(getContentResolver(), "disable_hw_overlay", r9 ? 1 : 0);
        return;
    L29:
        android.provider.Settings.Global.putInt(getContentResolver(), "enable_debug_hw_overlay", r9 ? 1 : 0);
        if (r9 == false) goto L32;
        this.mDisableOverlays.mEnable = r9;
    L33:
        this.mDevAdapter.notifyDataSetChanged();
        return;
    L32:
        android.provider.Settings.Global.putInt(getContentResolver(), "disable_hw_overlay", 0);
        this.mDisableOverlays.mEnable = r9;
        this.mDisableOverlays.mChecked = r9;
        goto L33
    L34:
        writeMsaaOptions(r9);
        return;
    L35:
        writeShowHwLayersUpdatesOptions(r9);
        return;
    L36:
        writeShowHwScreenUpdatesOptions(r9);
        return;
    L37:
        if (r9 == true) goto L40;
        r0 = "false";
    L40:
        SystemProperties.set(HARDWARE_UI_PROPERTY, r0);
        return;
    L41:
        MultiSDKAdapterNew.setDebugLayoutProperty(r9);
        pokeSystemPropertiesIfStatusOk();
        return;
    L42:
        writeShowUpdatesOption(r9);
        return;
    L43:
        if (r9 == true) goto L45;
        changeSaMode(false);
        return;
    L45:
        showSaModeEnableDialog();
        return;
    L46:
        android.provider.Settings.Global.putInt(getContentResolver(), ENABLE_THIRD_IME, r9 ? 1 : 0);
        return;
    L47:
        if (r9 == false) goto L49;
        showDialog(3);
        return;
    L49:
        SystemProperties.set(VIRTUAL_DISPLAY_PORTRAIT_MODE, "0");
        return;
    L50:
        if (r9 == false) goto L52;
        showDialog(2);
        return;
    L52:
        android.provider.Settings.Global.putInt(getContentResolver(), ENABLE_DEMO_MODE, r9 ? 1 : 0);
        return;
    L53:
        writeDcDimming(r9);
        return;
    L54:
        android.provider.Settings.Global.putInt(getContentResolver(), "edge_palm_rejection", r9 ? 1 : 0);
        return;
    L55:
        android.provider.Settings.Global.putInt(getContentResolver(), DevelopingSettings.ALLOW_DRAG_TNT_WINDOWS, r9 ? 1 : 0);
        return;
    L56:
        writeShowTopWindowOptions(r9);
        return;
    L57:
        writePointerLocationOptions(r9);
        return;
    L58:
        writeShowTouchesOptions(r9);
        return;
    L59:
        if (r9 == true) goto L61;
        OemLockManager r10 = this.mOemLockManager;
        if (r10 == null) goto L113;
        r10.setOemUnlockAllowedByUser(false);
        ToastUtils.show(this.mActivity, getString(R.string.oem_lock_info_message));
        return;
    L113:
        return;
    L61:
        if (new LockPatternUtils(this).isSecure(UserHandle.myUserId()) == false) goto L63;
        new ChooseLockSettingsHelper(this).launchConfirmationActivity(0, null, 2, true);
        return;
    L63:
        showOemUnlockConfirmDialog();
        return;
    L67:
        writeAllowUsbInstall(r9);
        return;
    L68:
        writeVerifyAppsOverUsbOptions(r9);
        return;
    L69:
        writeDebuggerOptions(r9);
        return;
    L70:
        if (r9 == true) goto L72;
        android.provider.Settings.Global.putInt(getContentResolver(), "adb_enabled", 0);
        resetAllOptions();
        this.mAllowUsbInstall.mEnable = false;
        return;
    L72:
        if (this.mAdbDialog != null) goto L74;
        OAlertDialog r11 = (OAlertDialog) new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton(true).title(R.string.adb_warning_title).message(R.string.adb_warning_message).icon(R.drawable.o_icon_alert).negativeButton(android.R.string.no, this).positiveButton(android.R.string.yes, this).onCancel(new AnonymousClass7(this)).createDialog();
        this.mAdbDialog = r11;
        r11.show();
    L74:
        this.mAdbDialog.show();
        return;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(final int r4) {
        if (isFinishing() == false) goto L6;
        return null;
    L6:
        if (r4 != 2) goto L8;
        int r0 = R.string.dialog_msg_enable_demo_mode;
    L16:
        return new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton().title(R.string.dialog_title_alert).message(r0).icon(R.drawable.o_icon_alert).negativeButton(android.R.string.cancel, new AnonymousClass10(this, r4)).positiveButton(R.string.enter_save_power_ok, new AnonymousClass9(this, r4)).onCancel(new AnonymousClass8(this)).createDialog();
    L8:
        if (r4 != 3) goto L10;
        r0 = R.string.portrait_mode_wifi_display_warning;
        goto L16
    L10:
        if (r4 == 4) goto L12;
        return null;
    L12:
        r0 = R.string.tnt_enable_third_ime_warning;
        goto L16
    }

    public void com_android_settings_DevelopmentSettings__onStop$___twin___() {
        super.onStop();
        removeDialog(2);
        removeDialog(3);
        removeDialog(4);
    }

    private void resetAllOptions() {
        this.mDontPokeProperties = true;
        int r2 = 0;
    L4:
        if (r2 >= this.mResetOptions.size()) goto L11;
        DevItem r3 = this.mResetOptions.get(r2);
        if (r3 == null) goto L10;
        if (r3.mChecked == false) goto L10;
        r3.mChecked = false;
        checkStatechanged(r3.mId, r3.mChecked);
    L10:
        r2 = r2 + 1;
        goto L4
    L11:
        resetDebuggerOptions();
        if (SettingsFeature.isSupportLeakCanary() == false) goto L14;
        android.provider.Settings.System.putString(getContentResolver(), LEAK_CANARY_APP, null);
    L14:
        writeAnimationScaleOption(0, null);
        writeAnimationScaleOption(1, null);
        writeAnimationScaleOption(2, null);
        writeForceRtlOptions(false);
        writeOverlayDisplayDevicesOptions(null);
        writeAppProcessLimitOptions(null);
        android.provider.Settings.Global.putInt(getContentResolver(), "wifi_display_certification_on", 0);
        writeDebugHwOverdrawOptions(getResources().getStringArray(R.array.debug_hw_overdraw_values)[0]);
        writeShowNonRectClipOptions(getResources().getStringArray(R.array.show_non_rect_clip_values)[0]);
        writeTrackFrameTimeOptions(getResources().getStringArray(R.array.track_frame_time_values)[0]);
        writeOpenGLTracesOptions(getResources().getStringArray(R.array.enable_opengl_traces_values)[0]);
        writeAppProcessLimitOptions(getResources().getStringArray(R.array.app_process_limit_values)[0]);
        SystemProperties.set(HDCP_CHECKING_PROPERTY, getResources().getStringArray(R.array.hdcp_checking_values)[1]);
        android.provider.Settings.Global.putInt(getContentResolver(), "edge_palm_rejection", 1);
        updateAllOptions();
        this.mDontPokeProperties = false;
        pokeSystemPropertiesIfStatusOk();
        android.provider.Settings.Global.putInt(getContentResolver(), "disable_hw_overlay", 0);
        android.provider.Settings.Global.putInt(getContentResolver(), "stay_on_alltime", 0);
        android.provider.Settings.Global.putInt(getContentResolver(), "stay_on_while_plugged_in", 0);
        writeShowRefreshRateSetting(false);
        writeShowHdrSdrRatioSetting(false);
        ToastUtils.showLeftIcon(this.mActivity, getString(R.string.dev_reset_all_options_toast), R.drawable.settings_oic_checkmark_checked);
    }

    private void updateAllOptions() {
        ContentResolver r0 = getContentResolver();
        DevItem r1 = this.mKeepScreenOn;
        boolean r3 = false;
        if (android.provider.Settings.Global.getInt(r0, "stay_on_while_plugged_in", 0) == 0) goto L5;
        boolean r2 = true;
    L6:
        updateCheckBox(r1, r2);
        DevItem r4 = this.mKeepScreenOnEx;
        if (android.provider.Settings.Global.getInt(r0, "stay_on_alltime", 0) == 0) goto L9;
        boolean r5 = true;
    L10:
        updateCheckBox(r4, r5);
        DevItem r6 = this.mEnableAdb;
        if (android.provider.Settings.Global.getInt(r0, "adb_enabled", 0) == 0) goto L13;
        boolean r7 = true;
    L14:
        updateCheckBox(r6, r7);
        updateMockLocation();
        DevItem r8 = this.mWaitForDebugger;
        if (android.provider.Settings.Global.getInt(r0, "wait_for_debugger", 0) == 0) goto L17;
        boolean r9 = true;
    L18:
        updateCheckBox(r8, r9);
        this.mDebugAppPackage = android.provider.Settings.Global.getString(r0, "debug_app");
        if (SettingsFeature.isSupportLeakCanary() == false) goto L21;
        this.mLeakCanaryApps = android.provider.Settings.System.getString(r0, LEAK_CANARY_APP);
    L21:
        updateDebuggerOptions(this.mDebugAppPackage);
        updateEdgePalmRejectionSwitch();
        updateShowTouchesOptions();
        updatePointerLocationOptions();
        if (SettingsFeature.isSupportTopWindowFeature() == false) goto L24;
        updateShowTopWindowOptions();
    L24:
        updateAllowDragTntWindows();
        updateCheckBox(this.mShowDebugLayout, MultiSDKAdapterNew.getDebugLayoutProperty());
        updateShowHwScreenUpdatesOptions();
        updateFlingerOptions();
        if (this.mShowRefreshRate == null) goto L27;
        updateShowRefreshRateSetting();
    L27:
        updateShowHdrSdrRatioSetting();
        if (SettingsFeature.isDarwin() == false) goto L30;
        updateEnableHwDebug();
    L31:
        updateCheckBox(this.mForceHwUi, SystemProperties.getBoolean(HARDWARE_UI_PROPERTY, false));
        DevItem r10 = this.mStrictMode;
        if (currentStrictModeActiveIndex() != 1) goto L34;
        boolean r11 = true;
    L35:
        updateCheckBox(r10, r11);
        DevItem r12 = this.mShowCpuUsage;
        if (android.provider.Settings.Global.getInt(r0, "show_processes", 0) == 0) goto L38;
        boolean r13 = true;
    L39:
        updateCheckBox(r12, r13);
        DevItem r14 = this.mImmediatelyDestroyActivities;
        if (android.provider.Settings.Global.getInt(r0, "always_finish_activities", 0) == 0) goto L42;
        boolean r15 = true;
    L43:
        updateCheckBox(r14, r15);
        DevItem r16 = this.mShowAllAnrs;
        if (android.provider.Settings.Secure.getInt(r0, "anr_show_background", 0) == 0) goto L46;
        boolean r17 = true;
    L47:
        updateCheckBox(r16, r17);
        updateDisableScreenShareProtectionsVisibility();
        if (this.mDevItems.contains(this.mDisableScreenShareProtections) == false) goto L54;
        DevItem r18 = this.mDisableScreenShareProtections;
        if (android.provider.Settings.Global.getInt(r0, DISABLE_SCREEN_SHARE_PROTECTIONS_FOR_APPS_AND_NOTIFICATIONS, 0) == 0) goto L52;
        boolean r19 = true;
    L53:
        updateCheckBox(r18, r19);
        goto L54
    L52:
        r19 = false;
    L54:
        this.mHdcpCheck.mSubtitle = getResources().getStringArray(R.array.hdcp_checking_titles)[getDHCPCurrentId()];
        this.mWindowAnimScale.mSubtitle = getAnimationText(0);
        this.mTransitionAnimScale.mSubtitle = getAnimationText(1);
        this.mAnimDurationScale.mSubtitle = getAnimationText(2);
        updateAppProcessLimitOptions();
        updateVerifyAppsOverUsbOptions();
        updateUsbInstallSwitcher();
        updateBluetoothCodecSettings();
        updateOverlayDisplayDevicesOptions();
        updateShowHwLayersUpdatesOptions();
        updateDebugHwOverdrawOptions();
        updateShowNonRectClipOptions();
        updateMsaaOptions();
        updateTrackFrameTimeOptions();
        updateOpenGLTracesOptions();
        updateCheckBox(this.mWifiVerboseLog, readWifiVerboseLoggingOptions());
        DevItem r20 = this.mPortraitDisplaySwitch;
        if (SystemProperties.getInt(VIRTUAL_DISPLAY_PORTRAIT_MODE, 0) != 1) goto L57;
        boolean r21 = true;
    L58:
        updateCheckBox(r20, r21);
        updateForceRtlOptions();
        updateUsbConfigurationValues(true);
        updateDeviceColorValues();
        if (this.mIsExtDisplaying == false) goto L61;
        updateTNTScreenSettingsValues();
    L61:
        updateSaMode();
        DevItem r22 = this.mReduceStrobeSwitch;
        if (android.provider.Settings.Global.getInt(r0, "reduce_screen_strobe", 1) != 1) goto L64;
        r3 = true;
    L64:
        updateCheckBox(r22, r3);
        updateOemUnlockPreference();
        updateMockModemStatus();
        this.mDevAdapter.notifyDataSetChanged();
        return;
    L57:
        r21 = false;
        goto L58
    L46:
        r17 = false;
        goto L47
    L42:
        r15 = false;
        goto L43
    L38:
        r13 = false;
        goto L39
    L34:
        r11 = false;
        goto L35
    L30:
        updateDisableHwOverlays();
        goto L31
    L17:
        r9 = false;
        goto L18
    L13:
        r7 = false;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private void updateMockLocation() {
        List r0 = ((AppOpsManager) getSystemService("appops")).getPackagesForOps(MOCK_LOCATION_APP_OPS);
        if (r0 == null) goto L11;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        AppOpsManager.PackageOps r2 = (AppOpsManager.PackageOps) r1.next();
        if (((AppOpsManager.OpEntry) r2.getOps().get(0)).getMode() != 0) goto L6;
        this.mMockLocationApp = r2.getPackageName();
    L11:
        if (TextUtils.isEmpty(this.mMockLocationApp) == true) goto L17;
        String r3 = this.mMockLocationApp;
        ApplicationInfo r4 = getPackageManager().getApplicationInfo(this.mMockLocationApp, 512);     // Catch: PackageManager.NameNotFoundException -> L19
        CharSequence r5 = getPackageManager().getApplicationLabel(r4);     // Catch: PackageManager.NameNotFoundException -> L19
        if (r5 == null) goto L16;
        r3 = r5.toString();     // Catch: PackageManager.NameNotFoundException -> L19
    L16:
        this.mMockLocation.mSubtitle = r3;
        return;
    L17:
        this.mMockLocation.mSubtitle = "";
    }

    private void updateBugreportOptions() {
        if (PickApplicationActivity.EXTRA_USER.equals(Build.TYPE) == false) goto L6;
        android.provider.Settings.Global.getInt(getContentResolver(), "adb_enabled", 0);
        return;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r6, int r7) {
        if (r6 != this.mAdbDialog) goto L11;
        if (r7 != (-1)) goto L7;
        android.provider.Settings.Global.putInt(getContentResolver(), "adb_enabled", 1);
        this.mEnableAdb.mChecked = true;
        this.mAllowUsbInstall.mEnable = true;
        r6.dismiss();
    L9:
        updateVerifyAppsOverUsbOptions();
        this.mDevAdapter.notifyDataSetChanged();
        return;
    L7:
        if (r7 != (-2)) goto L9;
        android.provider.Settings.Global.putInt(getContentResolver(), "adb_enabled", 0);
        this.mEnableAdb.mChecked = false;
        this.mAllowUsbInstall.mEnable = false;
        r6.dismiss();
        goto L9
    L11:
        if (r6 != this.mAdbKeysDialog) goto L17;
        if (r7 != (-1)) goto L14;
        MultiSDKAdapterNew.clearUsbDebuggingKeys(IAdbManager.Stub.asInterface(ServiceManager.getService("adb")));
        r6.dismiss();
        return;
    L14:
        if (r7 != (-2)) goto L29;
        r6.dismiss();
        return;
    L29:
        return;
    L17:
        if (r6 != this.mOemUnlockConfirmDialog) goto L31;
        if (r7 != (-1)) goto L23;
        OemLockManager r8 = this.mOemLockManager;
        if (r8 == null) goto L22;
        r8.setOemUnlockAllowedByUser(true);
        this.mOemUnlock.mChecked = true;
    L22:
        r6.dismiss();
    L25:
        this.mDevAdapter.notifyDataSetChanged();
        return;
    L23:
        if (r7 != (-2)) goto L25;
        this.mOemUnlock.mChecked = false;
        updateOemUnlockPreference();
        r6.dismiss();
        goto L25
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r7) {
        if (Utils.isMonkeyRunning() == false) goto L6;
        return;
    L6:
        switch(r7.getId()) {
            case 11: goto L41;
            case 12: goto L40;
            case 13: goto L39;
            case 15: goto L38;
            case 17: goto L37;
            case 20: goto L36;
            case 21: goto L35;
            case 22: goto L34;
            case 23: goto L33;
            case 34: goto L32;
            case 49: goto L31;
            case 53: goto L30;
            case 54: goto L29;
            case 55: goto L28;
            case 56: goto L27;
            case 61: goto L26;
            case 62: goto L25;
            case 68: goto L24;
            case 69: goto L23;
            case 72: goto L22;
            case 73: goto L21;
            case 76: goto L20;
            case 78: goto L19;
            case 82: goto L16;
            case 85: goto L15;
            case 87: goto L14;
            case 89: goto L13;
            case 92: goto L12;
            case 94: goto L11;
            case 95: goto L10;
            case 97: goto L9;
            case 99: goto L8;
            default: goto L75;
        };
    L8:
        launchSimulateMotionDelaySettings();
        return;
    L9:
        launchSimulateDeferMotionTimeSettings();
        return;
    L10:
        launchTNTScreenSettings();
        return;
    L11:
        getSharedPreferences("development", 0).edit().remove("show").apply();
        DatabaseHelper.getInstance(this.mContext).updateDevelopmentSettingsSearchable(false);
        android.provider.Settings.Global.putInt(getContentResolver(), "development_settings_enabled", 0);
        finish();
        return;
    L12:
        resetAllOptions();
        return;
    L13:
        enableSceneAwareness(this.mContext);
        return;
    L14:
        launchTelephonyNetworkSettings();
        return;
    L15:
        launchDHCPCheckOptions(r7);
        return;
    L16:
        Bundle r8 = new Bundle();
        r8.putInt("activity", 1);
        r8.putBoolean("start_from_setting", true);
        if (FeedbackLauncher.startFeedback(this, r8) == true) goto L51;
        showBugReportDialog();
        return;
    L51:
        return;
    L19:
        launchRunningServiceSettings();
        return;
    L20:
        launchAppLimitOptions(r7);
        return;
    L21:
        launchOpenGLTracesOptions(r7);
        return;
    L22:
        launchTrackFrameTimeOptions(r7);
        return;
    L23:
        launchSensorCalibration(4);
        return;
    L24:
        launchSensorCalibration(1);
        return;
    L25:
        launchNonRectClipOptions(r7);
        return;
    L26:
        launchDebugHwOverdrawOptions(r7);
        return;
    L27:
        launchOverlayDisplayOptions(r7);
        return;
    L28:
        launchAnimationSettingOptions(2, R.string.animator_duration_scale_title, r7);
        return;
    L29:
        launchAnimationSettingOptions(1, R.string.transition_animation_scale_title, r7);
        return;
    L30:
        launchAnimationSettingOptions(0, R.string.window_animation_scale_title, r7);
        return;
    L31:
        launchWebViewProviderSetting();
        return;
    L32:
        String r9 = Features.getDeviceColor();
        Bundle r0 = new Bundle();
        r0.putInt("extra_option_tips_res", R.string.dev_device_color_override_tips);
        this.mDeviceColorInfo.setExtrasArgs(r0);
        Utils.launchOptionsActivity(this, this.mDeviceColorInfo, r9, getString(R.string.dev_device_color_option), this.mTitleRes);
        return;
    L33:
        Intent r10 = new Intent();
        r10.setComponent(new ComponentName("com.qualcomm.qtil.aptxacu", "com.qualcomm.qtil.aptxacu.aptxacuSettingsActivity"));
        Utils.startActivity(this, r10);
        return;
    L34:
        Utils.startActivity(this, new Intent(this, BluetoothCodecBitsSettingsActivity.class));
        return;
    L35:
        Utils.startActivity(this, new Intent(this, BluetoothCodecSampleRateSettingsActivity.class));
        return;
    L36:
        Utils.startActivity(this, new Intent(this, BluetoothCodecSettingsActivity.class));
        return;
    L37:
        launchUsbConfigSettings();
        return;
    L38:
        Intent r11 = new Intent(this, AppPickerActivity.class);
        r11.putExtra(AppPickerActivity.EXTRA_LEAKCANARY, true);
        r11.putExtra(AppPickerActivity.SELECTED_APP, this.mLeakCanaryApps);
        r11.putExtra("title_id", R.string.dev_leak_canary_app);
        r11.putExtra("back_text_id", this.mTitleRes);
        Utils.startActivity(this, r11, 0, 1002);
        return;
    L39:
        Intent r12 = new Intent(this, AppPickerActivity.class);
        r12.putExtra(AppPickerActivity.EXTRA_DEBUGGABLE, true);
        r12.putExtra(AppPickerActivity.SELECTED_APP, this.mDebugAppPackage);
        r12.putExtra("title_id", R.string.debug_app);
        r12.putExtra("back_text_id", this.mTitleRes);
        Utils.startActivity(this, r12, 0, 1000);
        return;
    L40:
        Intent r13 = new Intent(this, AppPickerActivity.class);
        r13.putExtra(AppPickerActivity.EXTRA_REQUESTIING_PERMISSION, "android.permission.ACCESS_MOCK_LOCATION");
        r13.putExtra(AppPickerActivity.SELECTED_APP, this.mMockLocationApp);
        r13.putExtra("title_id", R.string.mock_location_app);
        r13.putExtra("back_text_id", this.mTitleRes);
        Utils.startActivity(this, r13, 0, 1001);
        return;
    L41:
        showAdbClearKeysDialog();
        return;
    }

    private void launchSensorCalibration(int r3) {
        Intent r0 = new Intent(this, SensorCalibrationActivity.class);
        r0.putExtra("sensor_type", r3);
        Utils.startActivity(this, r0);
    }

    private void launchWebViewProviderSetting() {
        Utils.startActivity(this, new Intent(this, WebViewImplementation.class));
    }

    private void launchRunningServiceSettings() {
        Intent r0 = new Intent(this, RunningServicesActivity.class);
        r0.putExtra("back_text_id", this.mTitleRes);
        Utils.startActivity(this, r0);
    }

    private void writeBtHciSnoopLogOptions(boolean r3) {
        OLog.d(TAG, "writeBtHciSnoopLogOptions " + r3);
        MultiSDKAdapter.configHciSnoopLog(r3);
        android.provider.Settings.Secure.putInt(getContentResolver(), "bluetooth_hci_log", r3 ? 1 : 0);
    }

    private void writeDebuggerOptions(boolean r3) {
        String r2 = android.provider.Settings.Global.getString(getContentResolver(), "debug_app");     // Catch: RemoteException -> L8
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.length() <= 0) goto L12;
        ActivityManagerNative.getDefault().setDebugApp(r2, r3, true);     // Catch: RemoteException -> L8
        return;
    L12:
        return;
    }

    private void writeMockLocation() {
        AppOpsManager r0 = (AppOpsManager) getSystemService("appops");
        List r1 = r0.getPackagesForOps(MOCK_LOCATION_APP_OPS);
        if (r1 == null) goto L13;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L13;
        AppOpsManager.PackageOps r5 = (AppOpsManager.PackageOps) r2.next();
        if (((AppOpsManager.OpEntry) r5.getOps().get(0)).getMode() == 2) goto L6;
        String r6 = r5.getPackageName();
        r0.setMode(58, getPackageManager().getApplicationInfo(r6, 512).uid, r6, 2);     // Catch: PackageManager.NameNotFoundException -> L16
    L13:
        if (TextUtils.isEmpty(this.mMockLocationApp) == true) goto L27;
        r0.setMode(58, getPackageManager().getApplicationInfo(this.mMockLocationApp, 512).uid, this.mMockLocationApp, 0);     // Catch: PackageManager.NameNotFoundException -> L17
        return;
    L28:
        return;
    }

    private static void resetDebuggerOptions() {
        ActivityManagerNative.getDefault().setDebugApp(null, false, true);     // Catch: RemoteException -> L4
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r3, int r4, Intent r5) {
        if (r3 != 1000) goto L7;
        if (r4 != (-1)) goto L24;
        writeDebuggerOptions(r5.getAction());
        return;
    L24:
        return;
    L7:
        if (r3 != 1001) goto L11;
        if (r4 != (-1)) goto L26;
        this.mMockLocationApp = r5.getAction();
        writeMockLocation();
        updateMockLocation();
        return;
    L26:
        return;
    L11:
        if (r3 != 1002) goto L14;
        if (r4 != (-1)) goto L28;
        this.mLeakCanaryApps = r5.getAction();
        android.provider.Settings.System.putString(getContentResolver(), LEAK_CANARY_APP, this.mLeakCanaryApps);
        return;
    L28:
        return;
    L14:
        if (r3 != 0) goto L22;
        if (r4 == (-1)) goto L17;
        return;
    L17:
        if (this.mOemUnlock.mChecked == false) goto L19;
        showOemUnlockConfirmDialog();
        return;
    L19:
        OemLockManager r2 = this.mOemLockManager;
        if (r2 == null) goto L32;
        r2.setOemUnlockAllowedByUser(false);
        return;
    L32:
        return;
    L22:
        super.onActivityResult(r3, r4, r5);
    }

    private void writeDebuggerOptions(String r5) {
        IActivityManager r0 = ActivityManagerNative.getDefault();     // Catch: RemoteException -> L7
        boolean r3 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "wait_for_debugger", 0) == 0) goto L5;
        r3 = true;
    L5:
        r0.setDebugApp(r5, r3, true);     // Catch: RemoteException -> L7
        updateDebuggerOptions(r5);     // Catch: RemoteException -> L7
        return;
    }

    private void writeShowUpdatesOption(boolean r5) {
        IBinder r0 = ServiceManager.getService("SurfaceFlinger");     // Catch: RemoteException -> L10
        if (r0 == null) goto L13;
        Parcel r1 = Parcel.obtain();     // Catch: RemoteException -> L10
        r1.writeInterfaceToken(SURFACE_COMPOSER_INTERFACE_KEY);     // Catch: RemoteException -> L10
        if (r5 == false) goto L7;
        int r6 = 1;
    L8:
        r1.writeInt(r6);     // Catch: RemoteException -> L10
        r0.transact(1002, r1, null, 0);     // Catch: RemoteException -> L10
        r1.recycle();     // Catch: RemoteException -> L10
        updateFlingerOptions();     // Catch: RemoteException -> L10
        return;
    L7:
        r6 = 0;
        goto L8
    L13:
        return;
    }

    void writeShowRefreshRateSetting(boolean r5) {
        IBinder r0 = ServiceManager.getService("SurfaceFlinger");     // Catch: RemoteException -> L11
        if (r0 == null) goto L9;
        Parcel r1 = Parcel.obtain();     // Catch: RemoteException -> L11
        r1.writeInterfaceToken(SURFACE_COMPOSER_INTERFACE_KEY);     // Catch: RemoteException -> L11
        if (r5 == false) goto L7;
        int r6 = 1;
    L8:
        r1.writeInt(r6);     // Catch: RemoteException -> L11
        r0.transact(1034, r1, null, 0);     // Catch: RemoteException -> L11
        r1.recycle();     // Catch: RemoteException -> L11
        goto L9
    L7:
        r6 = 0;
    L9:
        updateShowRefreshRateSetting();
    }

    private void showBugReportDialog() {
        new AlertDialog.Builder(this).setTitle(R.string.about_user_feedback).setMessage(android.R.string.carrier_app_notification_title).setPositiveButton(android.R.string.status_bar_battery, new AnonymousClass11(this)).setNegativeButton(R.string.cancel, null).create().show();
    }

    private void updateDebuggerOptions(String r3) {
        if (r3 != null) goto L4;
    L9:
        DevItem r4 = this.mDebugApp;
        r4.mSubtitle = getResources().getString(R.string.debug_app_not_set);
        this.mWaitForDebugger.mEnable = false;
        return;
    L4:
        if (r3.length() <= 0) goto L9;
        ApplicationInfo r0 = getPackageManager().getApplicationInfo(r3, 512);     // Catch: PackageManager.NameNotFoundException -> L11
        CharSequence r1 = getPackageManager().getApplicationLabel(r0);     // Catch: PackageManager.NameNotFoundException -> L11
        if (r1 == null) goto L8;
        r3 = r1.toString();     // Catch: PackageManager.NameNotFoundException -> L11
    L8:
        this.mDebugApp.mSubtitle = r3;
        this.mWaitForDebugger.mEnable = true;
    }

    private void writeForceRtlOptions(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "debug.force_rtl", r2 ? 1 : 0);
        if (r2 == false) goto L5;
        String r1 = "1";
    L6:
        SystemProperties.set("debug.force_rtl", r1);
        return;
    L5:
        r1 = "0";
        goto L6
    }

    private void writeShowTouchesOptions(boolean r2) {
        android.provider.Settings.System.putInt(getContentResolver(), "show_touches", r2 ? 1 : 0);
    }

    private void updateShowTouchesOptions() {
        DevItem r0 = this.mShowTouches;
        boolean r3 = false;
        if (android.provider.Settings.System.getInt(getContentResolver(), "show_touches", 0) == 0) goto L5;
        r3 = true;
    L5:
        updateCheckBox(r0, r3);
    }

    private void updateEdgePalmRejectionSwitch() {
        DevItem r0 = this.mEdgePalmRejectionSwitch;
        boolean r3 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "edge_palm_rejection", 1) != 0) goto L6;
        r3 = false;
    L6:
        updateCheckBox(r0, r3);
    }

    private void writePointerLocationOptions(boolean r2) {
        android.provider.Settings.System.putInt(getContentResolver(), "pointer_location", r2 ? 1 : 0);
    }

    private void writeShowTopWindowOptions(boolean r2) {
        android.provider.Settings.System.putInt(getContentResolver(), VISIBLE_WINDOW, r2 ? 1 : 0);
    }

    private void updatePointerLocationOptions() {
        DevItem r0 = this.mPointerLocation;
        boolean r3 = false;
        if (android.provider.Settings.System.getInt(getContentResolver(), "pointer_location", 0) == 0) goto L5;
        r3 = true;
    L5:
        updateCheckBox(r0, r3);
    }

    private void updateShowTopWindowOptions() {
        DevItem r0 = this.mShowTopWindow;
        boolean r3 = false;
        if (android.provider.Settings.System.getInt(getContentResolver(), VISIBLE_WINDOW, 0) == 0) goto L5;
        r3 = true;
    L5:
        updateCheckBox(r0, r3);
    }

    private void updateAllowDragTntWindows() {
        if (this.mIsExtDisplaying == true) goto L5;
        return;
    L5:
        DevItem r0 = this.mAllowDragTntWindows;
        boolean r3 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), DevelopingSettings.ALLOW_DRAG_TNT_WINDOWS, 1) != 0) goto L9;
        r3 = false;
    L9:
        updateCheckBox(r0, r3);
    }

    private void updateDisableHwOverlays() {
        DevItem r0 = this.mDisableOverlays;
        boolean r3 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "disable_hw_overlay", 0) != 1) goto L5;
        r3 = true;
    L5:
        updateCheckBox(r0, r3);
    }

    private void updateEnableHwDebug() {
        if (SettingsFeature.isDarwin() == true) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "enable_debug_hw_overlay", 0) != 1) goto L8;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L15;
        updateCheckBox(this.mEnableHwDebug, true);
        DevItem r1 = this.mDisableOverlays;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "disable_hw_overlay", 0) != 1) goto L14;
        r2 = true;
    L14:
        updateCheckBox(r1, r2);
        return;
    L15:
        this.mDisableOverlays.mEnable = false;
        android.provider.Settings.Global.putInt(getContentResolver(), "disable_hw_overlay", 0);
        return;
    L8:
        r0 = false;
        goto L10
    }

    private void updateFlingerOptions() {
        IBinder r0 = ServiceManager.getService("SurfaceFlinger");     // Catch: RemoteException -> L9
        if (r0 == null) goto L12;
        Parcel r1 = Parcel.obtain();     // Catch: RemoteException -> L9
        Parcel r2 = Parcel.obtain();     // Catch: RemoteException -> L9
        r1.writeInterfaceToken(SURFACE_COMPOSER_INTERFACE_KEY);     // Catch: RemoteException -> L9
        boolean r4 = false;
        r0.transact(PointerIconCompat.TYPE_ALIAS, r1, r2, 0);     // Catch: RemoteException -> L9
        r2.readInt();     // Catch: RemoteException -> L9
        r2.readInt();     // Catch: RemoteException -> L9
        int r3 = r2.readInt();     // Catch: RemoteException -> L9
        DevItem r5 = this.mShowScreenUpdate;     // Catch: RemoteException -> L9
        if (r3 == 0) goto L7;
        r4 = true;
    L7:
        updateCheckBox(r5, r4);     // Catch: RemoteException -> L9
        r2.recycle();     // Catch: RemoteException -> L9
        r1.recycle();     // Catch: RemoteException -> L9
        return;
    L12:
        return;
    }

    private void updateShowRefreshRateSetting() {
        IBinder r0 = ServiceManager.getService("SurfaceFlinger");     // Catch: RemoteException -> L6
        if (r0 == null) goto L9;
        Parcel r1 = Parcel.obtain();     // Catch: RemoteException -> L6
        Parcel r2 = Parcel.obtain();     // Catch: RemoteException -> L6
        r1.writeInterfaceToken(SURFACE_COMPOSER_INTERFACE_KEY);     // Catch: RemoteException -> L6
        r1.writeInt(2);     // Catch: RemoteException -> L6
        r0.transact(1034, r1, r2, 0);     // Catch: RemoteException -> L6
        boolean r3 = r2.readBoolean();     // Catch: RemoteException -> L6
        updateCheckBox(this.mShowRefreshRate, r3);     // Catch: RemoteException -> L6
        r2.recycle();     // Catch: RemoteException -> L6
        r1.recycle();     // Catch: RemoteException -> L6
        return;
    L9:
        return;
    }

    private void updateShowHdrSdrRatioSetting() {
        IBinder r0 = ServiceManager.getService("SurfaceFlinger");     // Catch: RemoteException -> L6
        if (r0 == null) goto L9;
        Parcel r1 = Parcel.obtain();     // Catch: RemoteException -> L6
        Parcel r2 = Parcel.obtain();     // Catch: RemoteException -> L6
        r1.writeInterfaceToken(SURFACE_COMPOSER_INTERFACE_KEY);     // Catch: RemoteException -> L6
        r1.writeInt(2);     // Catch: RemoteException -> L6
        r0.transact(1043, r1, r2, 0);     // Catch: RemoteException -> L6
        boolean r3 = r2.readBoolean();     // Catch: RemoteException -> L6
        updateCheckBox(this.mShowHdrSdrRatio, r3);     // Catch: RemoteException -> L6
        r2.recycle();     // Catch: RemoteException -> L6
        r1.recycle();     // Catch: RemoteException -> L6
        return;
    L9:
        return;
    }

    void writeShowHdrSdrRatioSetting(boolean r5) {
        IBinder r0 = ServiceManager.getService("SurfaceFlinger");     // Catch: RemoteException -> L11
        if (r0 == null) goto L9;
        Parcel r1 = Parcel.obtain();     // Catch: RemoteException -> L11
        r1.writeInterfaceToken(SURFACE_COMPOSER_INTERFACE_KEY);     // Catch: RemoteException -> L11
        if (r5 == false) goto L7;
        int r6 = 1;
    L8:
        r1.writeInt(r6);     // Catch: RemoteException -> L11
        r0.transact(1043, r1, null, 0);     // Catch: RemoteException -> L11
        r1.recycle();     // Catch: RemoteException -> L11
        goto L9
    L7:
        r6 = 0;
    L9:
        updateShowHdrSdrRatioSetting();
    }

    private static int currentStrictModeActiveIndex() {
        if (TextUtils.isEmpty(SystemProperties.get("persist.sys.strictmode.visual")) == false) goto L6;
        return 0;
    L6:
        if (SystemProperties.getBoolean("persist.sys.strictmode.visual", false) == false) goto L8;
        return 1;
    L8:
        return 2;
    }

    private void writeStrictModeVisualOptions(boolean r1) {
        IWindowManager r0 = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));     // Catch: RemoteException -> L8
        if (r1 == false) goto L5;
        String r2 = "1";
    L6:
        r0.setStrictModeVisualIndicatorPreference(r2);     // Catch: RemoteException -> L8
        return;
    L5:
        r2 = "";
    }

    private void writeCpuUsageOptions(boolean r4) {
        android.provider.Settings.Global.putInt(getContentResolver(), "show_processes", r4 ? 1 : 0);
        Intent r0 = new Intent().setClassName("com.android.systemui", "com.android.systemui.LoadAverageService");
        if (r4 == false) goto L5;
        startService(r0);
        return;
    L5:
        stopService(r0);
    }

    private void writeImmediatelyDestroyActivitiesOptions(boolean r1) {
        ActivityManagerNative.getDefault().setAlwaysFinish(r1);     // Catch: RemoteException -> L4
        return;
    }

    private int getDHCPCurrentId() {
        String r0 = SystemProperties.get(HDCP_CHECKING_PROPERTY);
        String[] r3 = getResources().getStringArray(R.array.hdcp_checking_values);
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L9;
        if (r0.equals(r3[r1]) == true) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        return r1;
    L9:
        return 1;
    }

    private void launchDHCPCheckOptions(View r5) {
        String[] r0 = getResources().getStringArray(R.array.hdcp_checking_titles);
        String[] r1 = getResources().getStringArray(R.array.hdcp_checking_values);
        launchOptionsActivity(new OptionsInfo(r0, r1, new DHCPCheckSelectListener(r1)), r1[getDHCPCurrentId()], getString(R.string.hdcp_checking_dialog_title), r5);
    }

    private int getAnimationIndex(int r4) {
        float r5 = this.mWindowManager.getAnimationScale(r4);     // Catch: RemoteException -> L4
    L6:
        String[] r3 = getResources().getStringArray(R.array.window_animation_scale_values);
        int r1 = 0;
    L8:
        if (r1 >= r3.length) goto L18;
        if (r5 <= Float.parseFloat(r3[r1].toString())) goto L13;
        r1 = r1 + 1;
        goto L8
    L13:
        return r1;
    L18:
        return 0;
    L4:
        e = move-exception;
        e.printStackTrace();
        r5 = 1.0f;
        goto L6
    }

    private String getAnimationText(int r3) {
        return getResources().getStringArray(R.array.window_animation_scale_entries)[getAnimationIndex(r3)];
    }

    private void launchAnimationSettingOptions(int r5, int r6, View r7) {
        String[] r0 = getResources().getStringArray(R.array.window_animation_scale_entries);
        String[] r1 = getResources().getStringArray(R.array.window_animation_scale_values);
        launchOptionsActivity(new OptionsInfo(r0, r1, new AnimationSettingSelectListener(r5, r1)), r1[getAnimationIndex(r5)], getString(r6), r7);
    }

    private void launchOptionsActivity(OptionsInfo r8, String r9, String r10, View r11) {
        OptionsPopover r0 = this.mPopover;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        OptionsPopover r1 = new OptionsPopover(this, r11, r8, r9, r10);
        this.mPopover = r1;
        r1.onSelect(new DevelopmentSettings$$ExternalSyntheticLambda0(this));
        this.mPopover.show();
    }

    /* JADX INFO: renamed from: lambda$launchOptionsActivity$0$com-android-settings-DevelopmentSettings, reason: not valid java name */
    /* synthetic */ Unit m121xf2e80b99(View r1, Integer r2) {
        updateAllOptions();
        OptionsPopover r0 = this.mPopover;
        if (r0 == null) goto L6;
        r0.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    private void writeAnimationScaleOption(int r1, Object r2) {
        if (r2 != null) goto L8;
        float r3 = 1.0f;
    L5:
        this.mWindowManager.setAnimationScale(r1, r3);     // Catch: RemoteException -> L7
        return;
    L10:
        return;
    L8:
        r3 = Float.parseFloat(r2.toString());     // Catch: RemoteException -> L7
        goto L5
    }

    private void updateOverlayDisplayDevicesOptions() {
        int r0 = getOverlayDisplayIndex();
        String[] r1 = getResources().getStringArray(R.array.overlay_display_devices_entries);
        DevItem r3 = this.mOverlayDisplayDevices;
        r3.mSubtitle = r1[r0];
    }

    private void writeOverlayDisplayDevicesOptions(Object r3) {
        android.provider.Settings.Global.putString(getContentResolver(), "overlay_display_devices", (String) r3);
        updateOverlayDisplayDevicesOptions();
    }

    private int getOverlayDisplayIndex() {
        String r0 = android.provider.Settings.Global.getString(getContentResolver(), "overlay_display_devices");
        String[] r4 = getResources().getStringArray(R.array.overlay_display_devices_values);
        int r2 = 0;
    L4:
        if (r2 >= r4.length) goto L9;
        if (r4[r2].equals(r0) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        return r2;
    L9:
        return 0;
    }

    private void launchOverlayDisplayOptions(View r6) {
        String[] r0 = getResources().getStringArray(R.array.overlay_display_devices_entries);
        String[] r1 = getResources().getStringArray(R.array.overlay_display_devices_values);
        launchOptionsActivity(new OptionsInfo(r0, r1, OptionsInfo.SaveTargetTable.Global, "overlay_display_devices"), r1[getOverlayDisplayIndex()], getString(R.string.overlay_display_devices_title), r6);
    }

    private int getDebugHwOverdrawIndex() {
        String r0 = SystemProperties.get("debug.hwui.overdraw");
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String[] r4 = getResources().getStringArray(R.array.debug_hw_overdraw_values);
        int r2 = 0;
    L7:
        if (r2 >= r4.length) goto L12;
        if (r0.equals(r4[r2]) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return r2;
    L12:
        return 0;
    }

    private void updateDebugHwOverdrawOptions() {
        String[] r0 = getResources().getStringArray(R.array.debug_hw_overdraw_entries);
        DevItem r1 = this.mDebugHwOverdraw;
        r1.mSubtitle = r0[getDebugHwOverdrawIndex()];
    }

    private static void writeDebugHwOverdrawOptions(Object r1) {
        if (r1 != null) goto L4;
        String r2 = "";
    L5:
        SystemProperties.set("debug.hwui.overdraw", r2);
        pokeSystemProperties();
        return;
    L4:
        r2 = r1.toString();
        goto L5
    }

    private void launchDebugHwOverdrawOptions(View r5) {
        String[] r0 = getResources().getStringArray(R.array.debug_hw_overdraw_entries);
        String[] r1 = getResources().getStringArray(R.array.debug_hw_overdraw_values);
        launchOptionsActivity(new OptionsInfo(r0, r1, new DebugHwOverdrawSelectListener(r1)), r1[getDebugHwOverdrawIndex()], getString(R.string.debug_hw_overdraw), r5);
    }

    private int getShowNonRectClipValueIndex() {
        String r0 = SystemProperties.get("debug.hwui.show_non_rect_clip");
        if (r0 != null) goto L5;
        r0 = "hide";
    L5:
        String[] r4 = getResources().getStringArray(R.array.show_non_rect_clip_values);
        int r2 = 0;
    L7:
        if (r2 >= r4.length) goto L12;
        if (r0.equals(r4[r2]) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return r2;
    L12:
        return 0;
    }

    private void updateShowNonRectClipOptions() {
        String[] r0 = getResources().getStringArray(R.array.show_non_rect_clip_entries);
        DevItem r1 = this.mShowNonRectClip;
        r1.mSubtitle = r0[getShowNonRectClipValueIndex()];
    }

    private static void writeShowNonRectClipOptions(Object r1) {
        if (r1 != null) goto L4;
        String r2 = "";
    L5:
        SystemProperties.set("debug.hwui.show_non_rect_clip", r2);
        pokeSystemProperties();
        return;
    L4:
        r2 = r1.toString();
        goto L5
    }

    private void launchNonRectClipOptions(View r5) {
        String[] r0 = getResources().getStringArray(R.array.show_non_rect_clip_entries);
        String[] r1 = getResources().getStringArray(R.array.show_non_rect_clip_values);
        launchOptionsActivity(new OptionsInfo(r0, r1, new NonRectClipSelectListener(r1)), r1[getShowNonRectClipValueIndex()], getString(R.string.show_non_rect_clip), r5);
    }

    private int getTrackframeTimeValueIndex() {
        String r0 = SystemProperties.get("debug.hwui.profile");
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String[] r4 = getResources().getStringArray(R.array.track_frame_time_values);
        int r2 = 0;
    L7:
        if (r2 >= r4.length) goto L12;
        if (r0.equals(r4[r2]) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return r2;
    L12:
        return 0;
    }

    private void updateTrackFrameTimeOptions() {
        String[] r0 = getResources().getStringArray(R.array.track_frame_time_entries);
        DevItem r1 = this.mTrackFrameTime;
        r1.mSubtitle = r0[getTrackframeTimeValueIndex()];
    }

    private static void writeTrackFrameTimeOptions(Object r1) {
        if (r1 != null) goto L4;
        String r2 = "";
    L5:
        SystemProperties.set("debug.hwui.profile", r2);
        pokeSystemProperties();
        return;
    L4:
        r2 = r1.toString();
        goto L5
    }

    private void launchTrackFrameTimeOptions(View r5) {
        String[] r0 = getResources().getStringArray(R.array.track_frame_time_entries);
        String[] r1 = getResources().getStringArray(R.array.track_frame_time_values);
        launchOptionsActivity(new OptionsInfo(r0, r1, new TrackFrameTimeSelectListener(r1)), r1[getTrackframeTimeValueIndex()], getString(R.string.track_frame_time), r5);
    }

    private int getOpenGLTracesValueIndex() {
        String r0 = SystemProperties.get(OPENGL_TRACES_PROPERTY);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String[] r4 = getResources().getStringArray(R.array.enable_opengl_traces_values);
        int r2 = 0;
    L7:
        if (r2 >= r4.length) goto L12;
        if (r0.equals(r4[r2]) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return r2;
    L12:
        return 0;
    }

    private void updateOpenGLTracesOptions() {
        String[] r0 = getResources().getStringArray(R.array.enable_opengl_traces_entries);
        DevItem r1 = this.mEnableOpenglTraces;
        r1.mSubtitle = r0[getOpenGLTracesValueIndex()];
    }

    private static void writeOpenGLTracesOptions(Object r1) {
        if (r1 != null) goto L4;
        String r2 = "";
    L5:
        SystemProperties.set(OPENGL_TRACES_PROPERTY, r2);
        pokeSystemProperties();
        return;
    L4:
        r2 = r1.toString();
        goto L5
    }

    private void launchOpenGLTracesOptions(View r5) {
        String[] r0 = getResources().getStringArray(R.array.enable_opengl_traces_entries);
        String[] r1 = getResources().getStringArray(R.array.enable_opengl_traces_values);
        launchOptionsActivity(new OptionsInfo(r0, r1, new OpenGLTracesSelectListener(r1)), r1[getOpenGLTracesValueIndex()], getString(R.string.enable_opengl_traces_title), r5);
    }

    private void updateMsaaOptions() {
        updateCheckBox(this.mForceMsaa, SystemProperties.getBoolean(MSAA_PROPERTY, false));
    }

    private void writeMsaaOptions(boolean r2) {
        if (r2 == false) goto L4;
        String r3 = "true";
    L5:
        SystemProperties.set(MSAA_PROPERTY, r3);
        pokeSystemPropertiesIfStatusOk();
        return;
    L4:
        r3 = "false";
        goto L5
    }

    private void updateAppProcessLimitOptions() {
        String[] r0 = getResources().getStringArray(R.array.app_process_limit_entries);
        DevItem r1 = this.mAppProcessLimit;
        r1.mSubtitle = r0[getAppLimitIndex()];
    }

    private int getAppLimitIndex() {
        String[] r4 = getResources().getStringArray(R.array.app_process_limit_values);
        int r1 = ActivityManagerNative.getDefault().getProcessLimit();     // Catch: RemoteException -> L10
        int r2 = 0;
    L5:
        if (r2 >= r4.length) goto L12;
        if (Integer.parseInt(r4[r2].toString()) >= r1) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return r2;
    L12:
        return 0;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    private static boolean writeAppProcessLimitOptions(Object r7) {
        if (r7 != null) goto L13;
        int r2 = -1;
    L6:
        ActivityManagerNative.getDefault().setProcessLimit(r2);     // Catch: RemoteException -> L12
        OLog.d(TAG, r7 + " > " + new SimpleDateFormat("yyyy:MM:dd HH:mm:ss:SSS").format(new Date()) + " startToModifyTheBackgroundProcessLimit >>> " + r2 + "\n startPrintingMethodStack >>");     // Catch: RemoteException -> L12
        StackTraceElement[] r8 = Thread.currentThread().getStackTrace();     // Catch: RemoteException -> L12
        StringBuffer r3 = new StringBuffer("\n \n\n");     // Catch: RemoteException -> L12
        int r4 = r8.length;     // Catch: RemoteException -> L12
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L9;
        r3.append(r8[r5].toString()).append("\n");     // Catch: RemoteException -> L12
        r5 = r5 + 1;     // Catch: RemoteException -> L12
        goto L7
    L9:
        OLog.d(TAG, r3.toString());     // Catch: RemoteException -> L12
        return true;
    L12:
        return false;
    L13:
        r2 = Integer.parseInt(r7.toString());     // Catch: RemoteException -> L12
        goto L6
    }

    private void updateCheckBox(DevItem r1, boolean r2) {
        r1.mChecked = r2;
    }

    private void initDisableScreenShareProtections() {
        DevItem r0 = new DevItem(80, 2, R.string.disable_screen_share_protections_for_apps_and_notifications, 0);
        this.mDisableScreenShareProtections = r0;
        r0.mSecSubtitle = getString(R.string.disable_screen_share_protections_for_apps_and_notifications_summary);
        this.mDisableScreenShareProtections.mShowSecSubtitleWhenEndSwitch = true;
        this.mDisableScreenShareProtectionsDiv = new DevItem(81, 0, 0, 0);
    }

    private void updateDisableScreenShareProtectionsVisibility() {
        DevItem r0 = this.mShowAllAnrsDiv;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mDisableScreenShareProtections != null) goto L7;
        return;
    L7:
        if (this.mDisableScreenShareProtectionsDiv != null) goto L9;
        return;
    L9:
        if (this.mDevItems.contains(r0) == true) goto L12;
        return;
    L12:
        if (XTSUtils.isInXtsMode() == true) goto L14;
        this.mDevItems.remove(this.mDisableScreenShareProtections);
        this.mDevItems.remove(this.mDisableScreenShareProtectionsDiv);
        return;
    L14:
        if (this.mDevItems.contains(this.mDisableScreenShareProtections) == true) goto L17;
        int r1 = this.mDevItems.indexOf(this.mShowAllAnrsDiv) + 1;
        this.mDevItems.add(r1, this.mDisableScreenShareProtections);
        this.mDevItems.add(r1 + 1, this.mDisableScreenShareProtectionsDiv);
        return;
    L17:
        if (this.mDevItems.contains(this.mDisableScreenShareProtectionsDiv) == true) goto L25;
        int r2 = this.mDevItems.indexOf(this.mDisableScreenShareProtections) + 1;
        this.mDevItems.add(r2, this.mDisableScreenShareProtectionsDiv);
        return;
    }

    private boolean showVerifierSetting() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "verifier_setting_visible", 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    private void updateVerifyAppsOverUsbOptions() {
        DevItem r0 = this.mVerifyAppsOverUsb;
        boolean r3 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "verifier_verify_adb_installs", 1) != 0) goto L6;
        r3 = false;
    L6:
        updateCheckBox(r0, r3);
        DevItem r1 = this.mVerifyAppsOverUsb;
        r1.mEnable = enableVerifierSetting();
    }

    private void updateBluetoothCodecSettings() {
        boolean r1 = false;
        if (BluetoothUtils.getA2dpActiveDevice() == null) goto L5;
        boolean r0 = true;
    L6:
        this.mBluetoothCodecChange.mEnable = r0;
        this.mBluetoothCodecSampleRate.mEnable = r0;
        this.mBluetoothCodecBits.mEnable = r0;
        BluetoothCodecConfig r3 = this.mCurrentBluetoothCodecConfig;
        if (r3 == null) goto L9;
        boolean r4 = true;
    L10:
        DevItem r5 = this.mBluetoothCodecChange;
        String r6 = "";
        if (r0 == false) goto L14;
        if (r4 == false) goto L14;
        String r7 = BluetoothCodecConfig.getCodecName(r3.getCodecType());
    L15:
        r5.mSubtitle = r7;
        DevItem r8 = this.mBluetoothCodecSampleRate;
        if (r0 == false) goto L19;
        if (r4 == false) goto L19;
        String r9 = BluetoothCodecHelper.sampleRateToString(this.mContext, this.mCurrentBluetoothCodecConfig.getSampleRate(), true);
    L20:
        r8.mSubtitle = r9;
        DevItem r10 = this.mBluetoothCodecBits;
        if (r0 == false) goto L24;
        if (r4 == false) goto L24;
        r6 = BluetoothCodecHelper.bitsPerSampleToString(this.mContext, this.mCurrentBluetoothCodecConfig.getBitsPerSample(), true);
    L24:
        r10.mSubtitle = r6;
        DevItem r11 = this.mBluetoothCodecSelect;
        if (r0 == false) goto L31;
        BluetoothCodecConfig r12 = this.mCurrentBluetoothCodecConfig;
        if (r12 == null) goto L31;
        if (r12.getCodecType() != 7) goto L31;
        r1 = true;
    L31:
        r11.mEnable = r1;
        return;
    L19:
        r9 = "";
    L14:
        r7 = "";
        goto L15
    L9:
        r4 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private void writeVerifyAppsOverUsbOptions(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "verifier_verify_adb_installs", r2 ? 1 : 0);
    }

    private void updateUsbInstallSwitcher() {
        boolean r2 = true;
        updateCheckBox(this.mAllowUsbInstall, !SystemProperties.getBoolean(PROP_ADB_INSTALL_WARNING, true));
        DevItem r0 = this.mAllowUsbInstall;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "adb_enabled", 0) == 1) goto L6;
        r2 = false;
    L6:
        r0.mEnable = r2;
    }

    private void writeAllowUsbInstall(boolean r1) {
        SystemProperties.set(PROP_ADB_INSTALL_WARNING, String.valueOf(!r1));
    }

    private boolean enableVerifierSetting() {
        ContentResolver r0 = getContentResolver();
        if (android.provider.Settings.Global.getInt(r0, "adb_enabled", 0) != 0) goto L6;
        return false;
    L6:
        if (android.provider.Settings.Global.getInt(r0, AdaptConstants.PACKAGE_VERIFIER_ENABLE, 1) != 0) goto L8;
        return false;
    L8:
        PackageManager r4 = getPackageManager();
        Intent r1 = new Intent("android.intent.action.PACKAGE_NEEDS_VERIFICATION");
        r1.setType(PACKAGE_MIME_TYPE);
        r1.addFlags(1);
        if (r4.queryBroadcastReceivers(r1, 0).size() != 0) goto L11;
        return false;
    L11:
        return true;
    }

    private void showAdbClearKeysDialog() {
        OAlertDialog r0 = this.mAdbKeysDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        OAlertDialog r1 = new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton().title(R.string.clear_adb_keys).message(R.string.adb_keys_warning_message).negativeButton(android.R.string.cancel, this).positiveButton(android.R.string.ok, this).createDialog();
        this.mAdbKeysDialog = r1;
        r1.show();
    }

    private void updateShowHwLayersUpdatesOptions() {
        updateCheckBox(this.mShowHwLayersUpdates, SystemProperties.getBoolean("debug.hwui.show_layers_updates", false));
    }

    private void writeShowHwLayersUpdatesOptions(boolean r2) {
        if (r2 == false) goto L4;
        String r3 = "true";
    L5:
        SystemProperties.set("debug.hwui.show_layers_updates", r3);
        pokeSystemPropertiesIfStatusOk();
        return;
    L4:
        r3 = null;
        goto L5
    }

    private void updateShowHwScreenUpdatesOptions() {
        updateCheckBox(this.mShowHwScreenUpdates, SystemProperties.getBoolean("debug.hwui.show_dirty_regions", false));
    }

    private void writeShowHwScreenUpdatesOptions(boolean r2) {
        if (r2 == false) goto L4;
        String r3 = "true";
    L5:
        SystemProperties.set("debug.hwui.show_dirty_regions", r3);
        pokeSystemPropertiesIfStatusOk();
        return;
    L4:
        r3 = null;
        goto L5
    }

    private void launchAppLimitOptions(View r5) {
        String[] r0 = getResources().getStringArray(R.array.app_process_limit_entries);
        String[] r1 = getResources().getStringArray(R.array.app_process_limit_values);
        launchOptionsActivity(new OptionsInfo(r0, r1, new AppLimitSelectListener(r1)), r1[getAppLimitIndex()], getString(R.string.app_process_limit_title), r5);
    }

    void pokeSystemPropertiesIfStatusOk() {
        if (this.mDontPokeProperties == true) goto L6;
        pokeSystemProperties();
        return;
    }

    static void pokeSystemProperties() {
        new SystemPropPoker().execute(new Void[0]);
    }

    private static boolean isPackageInstalled(Context r1, String r2) {
        if (r1.getPackageManager().getPackageInfo(r2, 0) == null) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    private boolean readWifiVerboseLoggingOptions() {
        if (AdaptWifi.readWifiVerboseLoggingOptions(this.mWifiManager) == true) goto L5;
        return false;
    L5:
        if (android.provider.Settings.Global.getInt(getContentResolver(), KEY_SHOW_WIFI_VERBOSE_LOG_SETTING, 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void writeWifiVerboseLoggingOptions(boolean r2) {
        AdaptWifi.writeWifiVerboseLoggingOptions(this.mWifiManager, r2);
        android.provider.Settings.Global.putInt(getContentResolver(), KEY_SHOW_WIFI_VERBOSE_LOG_SETTING, r2 ? 1 : 0);
    }

    private void launchUsbConfigSettings() {
        Intent r0 = new Intent(this, UsbConfigSettingsActivity.class);
        r0.putExtra("title_id", R.string.select_usb_config_title);
        r0.putExtra("back_text_id", this.mTitleRes);
        Utils.startActivity(this, r0);
    }

    private void updateUsbConfigurationValues(boolean r5) {
        if (this.mUsbConfiguration == null) goto L13;
        int r0 = UsbConfigSettingsActivity.getCurrentUsbConfigTitle(this);
        if (UsbConfigSettingsActivity.getCurrentUsbIsSource(this) == false) goto L7;
        DevItem r1 = this.mUsbConfiguration;
        r1.mSecSubtitle = getResources().getString(R.string.sm_usb_current_use_power);
    L8:
        DevItem r2 = this.mUsbConfiguration;
        r2.mSubtitle = getResources().getString(r0);
        if (r5 == false) goto L11;
        this.mHandler.sendEmptyMessageDelayed(1, 2000);
    L11:
        this.mDevAdapter.notifyDataSetChanged();
        return;
    L7:
        this.mUsbConfiguration.mSecSubtitle = "";
        goto L8
    }

    private void updateDeviceColorValues() {
        SettingsFeature.isSupportColorOverride();
    }

    private int getValueIndex(String[] r1, String r2) {
        return Arrays.asList(r1).indexOf(r2);
    }

    private void resetUsbConfigSettings() {
        new UsbBackend(this).setMode(0);
    }

    private void launchTNTScreenSettings() {
        Utils.startActivity(this, new Intent(this, Settings.TNTScreenSettingsActivity.class));
    }

    private void launchSimulateDeferMotionTimeSettings() {
        Utils.startActivity(this, new Intent(this, Settings.TNTSimulateDeferMotionEventSettingsActivity.class));
    }

    private void launchSimulateMotionDelaySettings() {
        Utils.startActivity(this, new Intent(this, Settings.SimulateMotionDelaySettingsActivity.class));
    }

    private void launchDelayForRemoveDisplaySettings() {
        Utils.startActivity(this, new Intent(this, Settings.TNTDelayForRemoveDisplaySettingsActivity.class));
    }

    private void launchTelephonyNetworkSettings() {
        Intent r0 = new Intent();
        r0.setClassName("com.android.phone", "com.bytedanceos.phone.settings.settings.mobilenetwork.MobileNetworkSettings");
        r0.setAction("android.intent.action.MAIN");
        r0.putExtra(INTENT_TELEPHONE_NETWORK_FROM, PARAMS_TELEPHONE_NETWORK_FROM);
        r0.putExtra(INTENT_TELEPHONE_NETWORK_TITLE, getString(R.string.telephony_network_settings));
        Utils.startActivity(this, r0);
    }

    private void updateTNTScreenSettingsValues() {
        DisplayInfo r0 = SmtPCUtils.getExtDisplayInfo(this.mContext);
        if (r0 == null) goto L5;
        DevItem r1 = this.mDpiSettings;
        r1.mSubtitle = Integer.toString(r0.logicalDensityDpi);
        return;
    L5:
        DisplayMetrics r2 = this.mContext.getResources().getDisplayMetrics();
        if (r2 == null) goto L10;
        DevItem r3 = this.mDpiSettings;
        r3.mSubtitle = Integer.toString(r2.densityDpi);
        return;
    }

    protected void updateSaMode() {
        this.mSaModeSwitch.mChecked = false;
    }

    private void updateMockModemStatus() {
        DevItem r2 = this.mMockModem;
        r2.mChecked = TextUtils.equals(SystemProperties.get(ALLOW_MOCK_MODEM_PROPERTY, "false"), "true");
    }

    private void changeSaMode(final boolean r3) {
        new Thread(new AnonymousClass12(this, r3)).start();
    }

    public void showSaModeEnableDialog() {
        if (this.mSaModeDialog != null) goto L5;
        OAlertDialog r0 = new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton().title(R.string.warning).negativeButton(getString(R.string.cancel), new DevelopmentSettings$$ExternalSyntheticLambda1(this)).createDialog();
        this.mSaModeDialog = r0;
        r0.setOnCancelListener(new DevelopmentSettings$$ExternalSyntheticLambda2(this));
    L5:
        this.mSaModeDialog.show();
    }

    /* JADX INFO: renamed from: lambda$showSaModeEnableDialog$1$com-android-settings-DevelopmentSettings, reason: not valid java name */
    /* synthetic */ void m122xa135dddf(DialogInterface r1, int r2) {
        this.mSaModeSwitch.mChecked = false;
        this.mDevAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: lambda$showSaModeEnableDialog$2$com-android-settings-DevelopmentSettings, reason: not valid java name */
    /* synthetic */ void m123xa89b12fe(DialogInterface r2) {
        this.mSaModeSwitch.mChecked = false;
        this.mDevAdapter.notifyDataSetChanged();
    }

    public void writeDcDimming(boolean r3) {
        android.provider.Settings.Global.putInt(getContentResolver(), "reduce_screen_strobe", r3 ? 1 : 0);
        if (SettingsFeature.isDarwin() == false) goto L8;
        if (r3 == false) goto L8;
        if (SettingsProviderUtils.getSystemScreenBrightness(this.mContext) > 0.275f) goto L8;
        return;
    L8:
        Calibration.setReduceScreenStrobeEnable(r3);
    }

    private void enableSceneAwareness(Context r4) {
        ComponentName r3 = new ComponentName(SCENE_AWARENESS_PACKAGE_NAME, SCENE_AWARENESS_CLASS_NAME);
        PackageManager r0 = r4.getPackageManager();
    L8:
        e = move-exception;
        OLog.e(TAG, "enableSceneAwareness error!", e);
        return;
    L4:
        if (r0.getComponentEnabledSetting(r3) == 1) goto L6;
        r0.setComponentEnabledSetting(r3, 1, 1);     // Catch: Exception -> L8
        ToastUtils.showInView(r4, R.string.scene_awareness_add_show);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        r0.setComponentEnabledSetting(r3, 2, 1);     // Catch: Exception -> L8
        ToastUtils.showInView(r4, R.string.scene_awareness_remove_show);     // Catch: Exception -> L8
        goto L11
    }

    private boolean isOemUnlockedAllowed() {
        OemLockManager r0 = this.mOemLockManager;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOemUnlockAllowed() == false) goto L7;
        return true;
    }

    private boolean enableOemUnlockPreference() {
        if (isBootloaderUnlocked() == false) goto L5;
    L7:
        return false;
    L5:
        if (isOemUnlockAllowedByUserAndCarrier() == false) goto L7;
        return true;
    }

    private boolean isBootloaderUnlocked() {
        OemLockManager r0 = this.mOemLockManager;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isDeviceOemUnlocked() == false) goto L7;
        return true;
    }

    private boolean isOemUnlockAllowedByUserAndCarrier() {
        UserHandle r0 = UserHandle.of(UserHandle.myUserId());
        OemLockManager r1 = this.mOemLockManager;
        if (r1 != null) goto L5;
    L9:
        return false;
    L5:
        if (r1.isOemUnlockAllowedByCarrier() == false) goto L9;
        if (this.mUm.hasBaseUserRestriction("no_factory_reset", r0) == true) goto L9;
        return true;
    }

    private void onOemUnlockConfirmed() {
        OemLockManager r1 = this.mOemLockManager;
        if (r1 != null) goto L6;
        OLog.e(TAG, "mOemLockManager is null");
        return;
    L6:
        r1.setOemUnlockAllowedByUser(true);
    }

    private boolean isSimLockedDevice() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.carrierlock") == true) goto L6;
        OLog.w(TAG, "getAllowedCarriers is unsupported without PackageManager#FEATURE_TELEPHONY_CARRIERLOCK");
        return false;
    L6:
        int r0 = this.mTelephonyManager.getPhoneCount();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L13;
        if (this.mTelephonyManager.getAllowedCarriers(r2).size() > 0) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return true;
    L13:
        return false;
    }

    private void updateOemUnlockSettingDescription() {
        if (isBootloaderUnlocked() == false) goto L6;
        int r0 = R.string.oem_unlock_enable_disabled_summary_bootloader_unlocked;
    L12:
        DevItem r1 = this.mOemUnlock;
        r1.mSecSubtitle = getResources().getString(r0);
        return;
    L6:
        if (isSimLockedDevice() == false) goto L9;
        r0 = R.string.oem_unlock_enable_disabled_summary_sim_locked_device;
        goto L12
    L9:
        if (isOemUnlockAllowedByUserAndCarrier() == true) goto L11;
        r0 = R.string.oem_unlock_enable_disabled_summary_connectivity_or_locked;
        goto L12
    L11:
        r0 = R.string.oem_unlock_enable_summary;
        goto L12
    }

    private void updateOemUnlockPreference() {
        updateCheckBox(this.mOemUnlock, isOemUnlockedAllowed());
        DevItem r0 = this.mOemUnlock;
        r0.mEnable = enableOemUnlockPreference();
        updateOemUnlockSettingDescription();
    }

    private void showOemUnlockConfirmDialog() {
        OAlertDialog r0 = this.mOemUnlockConfirmDialog;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        OAlertDialog r1 = new OAlertDialogBuilder(this).autoDismiss(false).horizontalButton().title(R.string.confirm_enable_oem_unlock_title).message(R.string.confirm_enable_oem_unlock_text).negativeButton(android.R.string.cancel, this).positiveButton(R.string.button_enable, this).createDialog();
        this.mOemUnlockConfirmDialog = r1;
        r1.show();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_DevelopmentSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(DevelopmentSettings r1) {
        com_android_settings_DevelopmentSettings_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_DevelopmentSettings_com_obric_hook_lancet_PrivacyHook_onCreate(DevelopmentSettings r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DevelopmentSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_DevelopmentSettings__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DevelopmentSettings_com_obric_hook_lancet_BatchedActivityLancet_onResume(DevelopmentSettings r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_DevelopmentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DevelopmentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(DevelopmentSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_DevelopmentSettings_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        DevelopmentSettings r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_DevelopmentSettings_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(DevelopmentSettings r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_DevelopmentSettings__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_DevelopmentSettings_com_obric_hook_lancet_BatchedActivityLancet_onStop(DevelopmentSettings r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_DevelopmentSettings_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_DevelopmentSettings_com_obric_hook_lancet_PrivacyHook_onResume(DevelopmentSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DevelopmentSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_DevelopmentSettings__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_DevelopmentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(DevelopmentSettings r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_DevelopmentSettings_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_DevelopmentSettings_com_obric_hook_lancet_PrivacyHook_onPause(DevelopmentSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DevelopmentSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_DevelopmentSettings__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DevelopmentSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(DevelopmentSettings r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_DevelopmentSettings_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        DevelopmentSettings r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_DevelopmentSettings_com_obric_hook_lancet_PrivacyHook_onStop(DevelopmentSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DevelopmentSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_DevelopmentSettings__onStop$___twin___();
    }

    @Insert("onDestroy")
    public static void com_android_settings_DevelopmentSettings_com_obric_hook_lancet_PrivacyHook_onDestroy(DevelopmentSettings r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        DevelopmentSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r3.com_android_settings_DevelopmentSettings__onDestroy$___twin___();
    }
}
