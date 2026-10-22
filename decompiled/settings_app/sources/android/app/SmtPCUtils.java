package android.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.display.IDisplayManager;
import android.os.Bundle;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.provider.Settings;
import android.view.Display;
import android.view.DisplayInfo;
import android.view.KeyEvent;
import androidx.core.view.MotionEventCompat;
import com.android.settings.Constants;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SmtPCUtils {
    public static final String ACTION_BACKLIGHT_EXTRA = "backlight_state";
    public static final String ACTION_BACKLIGHT_STATE = "android.intent.action.BACKLIGHT_STATE";
    public static final int APPLICATION_CENTER = 4;
    public static final String BYTEDANCE_LAUNCHER_ACTIVITY = "com.bytedanceos.launcher.Launcher";
    public static final int CAPTION_MODE_SWITCH_AUTO = 0;
    public static final int CAPTION_MODE_SWITCH_MANUAL = 1;
    public static final int DEFAULT_OPERATING_MODE = 0;
    public static final int DESKTOP_MODE_DEFAULT = 0;
    public static final int DESKTOP_MODE_MEETING = 1;
    public static final int DESKTOP_MODE_PC = 0;
    public static final int DESKTOP_MODE_SHIFT = 8;
    public static final int DIRECTION_BOTTOM = 1;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_RIGHT = 3;
    public static final int DIRECTION_TOP = 0;
    public static final int DVR_VIRTUAL_LAST_ID = 5;
    public static final ArrayList<String> DisableWindowBackgroundAPP = null;
    public static final int EXTEND_DISPLAY_MIRROR_MODE = 0;
    public static final int EXTEND_DISPLAY_PC_MODE = 1;
    public static final int EXTEND_DISPLAY_UNKNOWN_MODE = -1;
    public static final int EXTERNAL_TOUCHPAD_ID = 20;
    public static final int EXTERNAL_WIRELESS_TOUCHPAD_ID = 21;
    public static final ComponentName[] FIXED_FULLSCREEN_APPS = null;
    public static final String HANDSHAKER_DISPLAY_PKG = "com.bytedanceos.smartfolder.aoa";
    public static final boolean IS_PRODUCT_LARK_PHONE = false;
    public static final String KEY_HOT_KEY = "hot_key";
    public static final ComponentName LAUNCHER_COMPONENT = null;
    public static final String META_DATA_OF_REVONE_ENTRY = "revone_entry";
    public static final String META_DATA_OF_REVONE_ENTRY_EXTRA = "revone_entry_extra";
    public static final int OPERATING_MODE_MOUSE = 0;
    public static final int OPERATING_MODE_TOUCH = 1;
    public static final int OPERATING_MODE_UNKNOWN = -1;
    public static final String ORIGINAL_LAUNCHER_ACTIVITY = "com.android.launcher3.Launcher";
    public static final int PC_MODE_NONE = 2;
    public static final int PC_MODE_ON_MAIN_DISPLAY = 1;
    public static final int PC_PRODUCT_MEETING = 1;
    public static final int PC_PRODUCT_NONE = 0;
    public static final int PC_PRODUCT_TV = 2;
    public static final String PKG_BROWSER = "com.android.browser";
    public static final String PKG_BYTEDANCE_IME = "com.bytedanceos.ime";
    public static final String PKG_CALCULATOR = "com.bytedanceos.calculator";
    public static final String PKG_CAMERA_2 = "com.android.camera2";
    public static final String PKG_DESKTOP_LAUNCHER = "com.bytedanceos.desktop";
    public static final String PKG_DESKTOP_RECENTSPSP = "com.android.desktop.recentspsp";
    public static final String PKG_DESKTOP_SETUPWIZARD = "com.bytedance.table.setupwizard";
    public static final String PKG_DESKTOP_SYSTEMUI = "com.android.desktop.systemui";
    public static final String PKG_EYE_TRACK = "com.invensun.seven.trackserver";
    public static final String PKG_IN_CALL_UI = "com.android.incallui";
    public static final String PKG_ORIGINAL_LAUNCHER = "com.android.launcher3";
    public static final String PKG_PHONE_LAUNCHER = "com.bytedanceos.launcher";
    public static final String PKG_PHONE_SYSTEMUI = "com.android.systemui";
    public static final String PKG_POWER_SAVING_LAUNCHER = "com.bytedanceos.powersaving.launcher";
    public static final String PKG_SARA = "com.bytedanceos.sara";
    public static final String PKG_SIDE_BAR = "com.bytedanceos.sidebar";
    public static final String PKG_TELECOM_SERVER = "com.android.server.telecom";
    public static final String PROCESS_DESKTOP_SYSTEMUI = "com.android.desktop.systemui";
    public static final String PROCESS_LAUNCHPAD = "com.bytedanceos.launchpad";
    public static final String PROCESS_STYLUS_BLUETOOTH_SERVICE = "com.android.settings:StylusBluetoothService";
    public static final int PRODUCT_PHONE = 0;
    public static final int PRODUCT_PHONE_AND_TNT = 1;
    public static final int PRODUCT_TV = 2;
    public static final int RESIZABLE_INNER_WIDTH = 4;
    public static final String REVONE_ACTION_OPERATING_MODE_CHANGED = "revone.action.OPERATING_MODE_CHANGED";
    public static final String REVONE_EXTRA_OPERATING_MODE = "revone.extra.OPERATING_MODE";
    public static final String SCREEN_SAVERS_CLS = "com.bytedanceos.screensaver.detail.ScreenSaverActivity";
    public static final String SCREEN_SAVERS_PKG = "com.bytedanceos.screensaver";
    public static final ComponentName SETUPWIZARD_COMPONENT = null;
    private static final boolean SHOW_OVERLAY_DISPLAY = false;
    public static final String SMART_SIDE_BAR_CLIPBOARD = "com.bytedanceos.sidebar.revone.ClipBordActivity";
    public static final String SMART_SIDE_BAR_FILEMANAGER = "com.bytedance.filemanager.tablet.SidebarActivity";
    public static final String SMART_SIDE_BAR_GALLERY = "com.android.gallery3d.app.SideBarGallery";
    public static final String SMART_SIDE_BAR_PACKAGE_CLIPBOARD = "com.bytedanceos.sidebar";
    public static final String SMART_SIDE_BAR_PACKAGE_FILEMANAGER = "com.obric.filemanager";
    public static final String SMART_SIDE_BAR_PACKAGE_GALLERY = "com.android.gallery3d";
    public static final String SMART_SIDE_BAR_PACKAGE_THINKBOOST = "com.bytedanceos.thinkboost";
    public static final String SMT_PCM_SERVICE = "smt_pcm";
    public static final String SMT_VOICE_HANDLE_POPUP_WINDOW_NAME = "smt_voice_handle_popup";
    public static final String SMT_VOICE_POPUP_WINDOW_NAME = "smt_voice_popup";
    private static final boolean SUPPORT_WIRELESS_DISPLAY = true;
    public static final int SWITCH_DESKTOP_DIRECTION_DEFAULT = 0;
    public static final int SWITCH_DESKTOP_FROM_LEFT_TO_RIGHT = 0;
    public static final int SWITCH_DESKTOP_FROM_RIGHT_TO_LEFT = 1;
    public static final String TNT_ANYWHERE_DISPLAY_PKG = "com.bytedanceos.tntanywhere";
    public static final int TNT_VIRTUAL_DISPLAY_ID = 100000;
    public static final String TNT_VIRTUAL_DISPLAY_NAME = "smt.tnt.virtual.display";
    public static final int TOGGLE_HOME_CANCEL = 3;
    public static final int TOGGLE_HOME_NONE = 1;
    public static final int TOGGLE_HOME_SLIDE_IN = 0;
    public static final int TOGGLE_HOME_SLIDE_OUT = 1;
    public static final int TOGGLE_HOME_SUCCESS = 0;
    public static final int TOGGLE_HOME_TOGGLING = 2;
    public static final int TOGGLE_HOME_UNSUPPORT = 2;
    public static final int TOGGLE_RECENT_CLOSE = 2;
    public static final int TOGGLE_RECENT_DEFAULT = 0;
    public static final int TOGGLE_RECENT_OPEN = 1;
    public static final boolean USE_VIRTUAL_DISPLAY = true;
    private static final String VIRTUAL_DISPLAY_PKG = null;
    public static final String VOICE_COMMAND = "voicecommand";
    public static final int WINDOW_MODE_FULLSCREEN = 4;
    public static final int WINDOW_MODE_LANDSCAPE = 1;
    public static final int WINDOW_MODE_MAXIMIZED = 2;
    public static final int WINDOW_MODE_PORTRAIT = 0;
    public static final int WINDOW_MODE_UNKNOWN = -1;
    public static final ComponentName WX_SDK_BASE_COMPONENT = null;
    public static final ComponentName WX_SDK_SEND_COMPONENT = null;
    public static final Set<String> sSupportMultiWinList = null;

    public static boolean generateHotKeys(KeyEvent r0, Bundle r1) {
        return false;
    }

    public static int getCaptionBarHeightByPackage(String r0) {
        return 0;
    }

    public static int getDefaultAndSupportedDpiForResolution(int r0, int r1, List<String> r2) {
        return 0;
    }

    public static Rect getDefaultWindowBounds(boolean r0) {
        return null;
    }

    public static int getDesktopMode(int r1) {
        return (r1 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static Context getDisplayContext(Context r0, int r1, Configuration r2) {
        return null;
    }

    public static Display getExtDisplay(Context r0) {
        return null;
    }

    public static Display getExtDisplay(Context r0, int r1) {
        return null;
    }

    public static int getExtDisplayId() {
        return 0;
    }

    public static int getFocusedDisplayId() {
        return 0;
    }

    public static int getPackageDisplayId(String r0, int r1) {
        return 0;
    }

    public static int getSwitchDesktopModeDirection(int r0) {
        return r0 & 255;
    }

    public static boolean isCurrentKeyConflict(String r0, String r1, boolean r2) {
        return false;
    }

    public static boolean isExternalDisplaySupport2k() {
        return false;
    }

    @Deprecated
    public static boolean isPcCastMode() {
        return false;
    }

    @Deprecated
    public static boolean isPcDynamicStack(int r0) {
        return false;
    }

    public static boolean isPcMode(Context r0) {
        return false;
    }

    public static boolean isPcMode(Configuration r0) {
        return false;
    }

    public static boolean isTntDisplay() {
        return false;
    }

    public static boolean isTouchpadDeviceId(int r1) {
        if (r1 != 21) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 20) goto L8;
        return false;
    }

    public static final boolean isValidExtDisplay(Display r0) {
        return false;
    }

    public static void registerSmtTaskStackListener(ITaskStackListener r0) {
    }

    public static boolean shouldNotOK(KeyEvent r0, boolean r1) {
        return false;
    }

    public static int smtGetDeferEventsCount() {
        return 0;
    }

    public static void smtPinTask(int r0, boolean r1) {
    }

    public static void smtUpdatePersistentConfigurationForDisplay(Configuration r0, int r1) {
    }

    public static void unRegisterSmtTaskStackListener(ITaskStackListener r0) {
    }

    static {
        SETUPWIZARD_COMPONENT = ComponentName.unflattenFromString("com.bytedance.table.setupwizard/.WelcomeActivity");
        ComponentName r0 = ComponentName.unflattenFromString("com.bytedanceos.desktop/.Desktop");
        LAUNCHER_COMPONENT = r0;
        WX_SDK_BASE_COMPONENT = new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.base.stub.WXEntryActivity");
        WX_SDK_SEND_COMPONENT = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
        VIRTUAL_DISPLAY_PKG = SystemProperties.get("persist.sys.virtual_display_pkg", "com.bytedance.wirelesscast");
        SHOW_OVERLAY_DISPLAY = SystemProperties.getBoolean("persist.easycast.show_overlay_display", false);
        IS_PRODUCT_LARK_PHONE = SystemProperties.getBoolean("ro.product.feature.lkp", false);
        FIXED_FULLSCREEN_APPS = new ComponentName[]{r0, ComponentName.unflattenFromString("android/bytedanceos.app.ResolverActivity"), ComponentName.unflattenFromString("android/bytedanceos.app.ChooserActivity"), ComponentName.unflattenFromString("com.bytedanceos.sara/com.bytedanceos.sara.bubble.revone.floatsphereCreateActivity")};
        ArrayList<String> r1 = new ArrayList(1);
        DisableWindowBackgroundAPP = r1;
        r1.add("com.tencent.mm/com.tencent.mm.plugin.voip.ui.VideoActivity");
        HashSet r2 = new HashSet();
        sSupportMultiWinList = r2;
        r2.add("com.taobao.taobao");
        r2.add("com.twitter.android");
        r2.add("com.facebook.katana");
    }

    public SmtPCUtils() {
    }

    public static int getExtDisplayId(Context r1) {
        if (r1 != null) goto L5;
        return -1;
    L5:
        Display r2 = getExtDisplay(r1);
        if (r2 != null) goto L8;
        return -1;
    L8:
        return r2.getDisplayId();
    }

    public static Context getDisplayContext(Context r2, int r3) {
        Configuration r1 = (Configuration) null;
        return getDisplayContext(r2, r3, null);
    }

    public static Context getFocusedDisplayContext(Context r1) {
        return getDisplayContext(r1, getFocusedDisplayId());
    }

    public static final boolean isValidExtDisplayId(Context r0) {
        if (r0 != null) goto L5;
        return false;
    L5:
        return isPcMode(r0);
    }

    public static boolean isInPCModeList(String r6) {
        String[] r1 = {VIRTUAL_DISPLAY_PKG, "com.easycast.source", "com.easycast.sourcetest", Constants.PACKAGE_COM_BYTEDANCEOS_BOSTON_PHONE, TNT_VIRTUAL_DISPLAY_NAME, "ScreenCastThread-display", HANDSHAKER_DISPLAY_PKG, TNT_ANYWHERE_DISPLAY_PKG};
        int r2 = 0;
    L3:
        if (r2 >= 8) goto L9;
        if (r1[r2].equals(r6) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        OLog.i("SmtPCUtils", "isInPCModeList : " + r6);
        return true;
    L9:
        return false;
    }

    public static final boolean isValidExtDisplayType(int r1, String r2) {
        if (2 != r1) goto L5;
    L14:
        return true;
    L5:
        if (3 == r1) goto L14;
        if (5 != r1) goto L11;
        if (isInPCModeList(r2) == true) goto L14;
    L11:
        if (4 == r1) goto L14;
        return false;
    }

    public static int getCaptionBarHeight() {
        String r1 = (String) null;
        return getCaptionBarHeightByPackage(null);
    }

    public static DisplayInfo getExtDisplayInfo(Context r1) {
        IDisplayManager r0 = IDisplayManager.Stub.asInterface(ServiceManager.getService("display"));
        if (r0 == null) goto L7;
        if (r1 == null) goto L12;
        return r0.getDisplayInfo(getExtDisplayId(r1));
    L13:
        return null;
    L12:
        return null;
    L7:
        return null;
    }

    public static int getDesktopMode(Context r2) {
        return getDesktopMode(Settings.Global.getInt(r2.getContentResolver(), "revone_desktop_mode_switch", 0));
    }
}
