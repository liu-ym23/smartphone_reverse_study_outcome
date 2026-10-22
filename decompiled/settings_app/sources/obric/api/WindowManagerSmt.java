package obric.api;

import android.graphics.Rect;
import android.util.Singleton;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes5.dex */
public class WindowManagerSmt {
    public static final int IWINDOWMANAGER_REQUEST_MAGNIFICATIONSPEC = 2000;
    public static final int IWINDOWMANAGER_REQUEST_ZOOM_TO_SIDEBAR = 2001;
    public static final int IWINDOW_DISPATCH_ZOOMED_STATE_TRANSACTION = 10000;
    static final String TAG = "WindowManagerSmt";
    public static final int TYPE_SCREENSHOT_APP_WITH_KEYGUARD = 4;
    public static final int TYPE_SCREENSHOT_APP_WITH_WALLPAPER = 2;
    public static final int TYPE_ZOOM_DISPLAY = 0;
    public static final int TYPE_ZOOM_INVALID = -1;
    public static final int TYPE_ZOOM_PINNED = 3;
    public static final boolean USING_BYTEDANCE_KEYGUARD = true;
    static final Singleton<WindowManagerSmt> sWindowManagerSmt = null;

    @Deprecated
    public void getThumbModeCropGlobal(WindowManager r1, Rect r2) {
    }

    @Deprecated
    public boolean isWindowInSideBarMode(WindowManager r1) {
        return false;
    }

    @Deprecated
    public boolean isWindowInSideBarModeGlobal(WindowManager r1) {
        return false;
    }

    @Deprecated
    public boolean isWindowInTopDownMode(WindowManager r1) {
        return false;
    }

    @Deprecated
    public boolean isWindowInTopDownModeGlobal(WindowManager r1) {
        return false;
    }

    @Deprecated
    public boolean isWindowInthumbMode(WindowManager r1) {
        return false;
    }

    @Deprecated
    public boolean isWindowInthumbModeGlobal(WindowManager r1) {
        return false;
    }

    @Deprecated
    public void resetWindowOneHandedState(WindowManager r1) {
    }

    /* synthetic */ WindowManagerSmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sWindowManagerSmt = new AnonymousClass1();
    }

    public static WindowManagerSmt getInstance() {
        return (WindowManagerSmt) sWindowManagerSmt.get();
    }

    private WindowManagerSmt() {
    }
}
