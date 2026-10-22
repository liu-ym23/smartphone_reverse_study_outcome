package obric.api;

import android.util.Singleton;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes5.dex */
public class KeyEventSmt {
    public static final int FLAG_FROM_GESTURE = 8192;
    public static final int FLAG_FROM_SCALE_TASK = 4096;
    public static final int FLAG_FROM_SIMULATION = 16384;
    public static final int FLAG_MAC_MODE = 2048;
    public static final int KEYCODE_ALBUM = 304;
    public static final int KEYCODE_APP_DRAWER = 300;
    public static final int KEYCODE_APP_MULTITASK = 299;
    public static final int KEYCODE_ARRANGE_WINDOW = 313;
    public static final int KEYCODE_BIG_BANG = 302;
    public static final int KEYCODE_BOSTON_LONG_POWER = 325;
    public static final int KEYCODE_CLICK = 292;
    public static final int KEYCODE_CUSTOM = 303;
    public static final int KEYCODE_DOUBLECLICK = 291;
    public static final int KEYCODE_F13 = 314;
    public static final int KEYCODE_F14 = 315;
    public static final int KEYCODE_F15 = 316;
    public static final int KEYCODE_F16 = 317;
    public static final int KEYCODE_F17 = 318;
    public static final int KEYCODE_F18 = 319;
    public static final int KEYCODE_F19 = 320;
    public static final int KEYCODE_F20 = 321;
    public static final int KEYCODE_FILE_MANAGER = 305;
    public static final int KEYCODE_FOD = 293;
    public static final int KEYCODE_IDEAR_PILLS = 297;
    public static final int KEYCODE_IDEAR_PILLS_CREATOR = 307;
    public static final int KEYCODE_IM = 298;
    public static final int KEYCODE_KEY_CAPSULE = 294;
    public static final int KEYCODE_LOCAL_SEARCH = 296;
    public static final int KEYCODE_MEDIA_HEART = 289;
    public static final int KEYCODE_NETWORK_SEARCH = 295;
    public static final int KEYCODE_SCREENSHOT = 301;
    public static final int KEYCODE_SCREEN_LEFTBUTTON = 308;
    public static final int KEYCODE_SCREEN_RIGHTBUTTON = 309;
    public static final int KEYCODE_SCREEN_SWITCHBUTTON = 310;
    public static final int KEYCODE_SMART = 290;
    public static final int KEYCODE_TEXT = 306;
    public static final int KEYCODE_TNT_SCREEN_OFF = 312;
    public static final int KEYCODE_TNT_SCREEN_ON = 311;
    static final String TAG = "KeyEventSmt";
    static final Singleton<KeyEventSmt> sKeyEventSmt = null;

    public final void setKeyCode(KeyEvent r1, int r2) {
    }

    /* synthetic */ KeyEventSmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sKeyEventSmt = new AnonymousClass1();
    }

    public static KeyEventSmt getInstance() {
        return (KeyEventSmt) sKeyEventSmt.get();
    }

    private KeyEventSmt() {
    }
}
