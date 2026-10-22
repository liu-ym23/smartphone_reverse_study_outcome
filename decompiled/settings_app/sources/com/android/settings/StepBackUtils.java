package com.android.settings;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class StepBackUtils {
    private static final String TAG = "StepBackUtils";

    public StepBackUtils() {
    }

    public static Fragment getSupportFragment(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L10;
        return null;
    L10:
        return (Fragment) Class.forName(r4).getConstructor(new Class[0]).newInstance(new Object[0]);
    L7:
        e = move-exception;
        e.printStackTrace();
        OLog.w(TAG, "failed create class " + r4);
        return null;
    }

    public static List<String> getStepBackList(String r3) {
        ArrayList r0 = new ArrayList();
        r3.hashCode();
        byte r2 = -1;
        switch(r3.hashCode()) {
            case -1332136208: goto L30;
            case -1294005119: goto L26;
            case -1159034472: goto L22;
            case 116980: goto L18;
            case 3128418: goto L14;
            case 258514750: goto L10;
            case 1342238105: goto L6;
            default: goto L33;
        };
    L33:
        switch(r2) {
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L39;
            case 5: goto L39;
            case 6: goto L35;
            default: goto L34;
        };
    L34:
        OLog.d(TAG, "getStepBackList: Mismatch : " + r3);
        goto L39
    L35:
        r0.add(PageConstants.PAGE_TNT_NETWORK_SETTINGS);
        goto L39
    L36:
        r0.add(PageConstants.PAGE_TNT_BYTEDANCE_SETTINGS);
        goto L39
    L37:
        r0.add(PageConstants.PAGE_CATEGORY_PREFERRED);
        goto L39
    L38:
        r0.add(PageConstants.PAGE_TNT_NOTIFICATION_SETTINGS);
    L39:
        return r0;
    L6:
        if (r3.equals("wifi_ap") == false) goto L33;
        r2 = 6;
        goto L33
    L10:
        if (r3.equals(PageConstants.LAUNCH_PAGE_SCREEN_OFF_TIMEOUT) == false) goto L33;
        r2 = 5;
        goto L33
    L14:
        if (r3.equals(PageConstants.LAUNCH_PAGE_EYES) == false) goto L33;
        r2 = 4;
        goto L33
    L18:
        if (r3.equals(PageConstants.LAUNCH_PAGE_VPN) == false) goto L33;
        r2 = 3;
        goto L33
    L22:
        if (r3.equals(PageConstants.LAUNCH_PAGE_WIFI_DISPLAY) == false) goto L33;
        r2 = 2;
        goto L33
    L26:
        if (r3.equals(PageConstants.LAUNCH_PAGE_PREFERRED) == false) goto L33;
        r2 = 1;
        goto L33
    L30:
        if (r3.equals(PageConstants.LAUNCH_PAGE_SYSTEM_NOTIFICATION_BANNER) == false) goto L33;
        r2 = 0;
        goto L33
    }

    public static Fragment getLaunchFragment(String r2) {
        r2.hashCode();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case -1383258675: goto L74;
            case -1332136208: goto L70;
            case -1294005119: goto L66;
            case -1159034472: goto L62;
            case -1113643348: goto L58;
            case -907689876: goto L54;
            case 116980: goto L50;
            case 3088947: goto L46;
            case 3128418: goto L42;
            case 3649301: goto L38;
            case 109627663: goto L34;
            case 258514750: goto L30;
            case 503739367: goto L26;
            case 595233003: goto L22;
            case 1342238105: goto L18;
            case 1474694658: goto L14;
            case 1843485230: goto L10;
            case 1968882350: goto L6;
            default: goto L77;
        };
    L77:
        switch(r1) {
            case 0: goto L95;
            case 1: goto L94;
            case 2: goto L93;
            case 3: goto L92;
            case 4: goto L91;
            case 5: goto L91;
            case 6: goto L90;
            case 7: goto L89;
            case 8: goto L88;
            case 9: goto L87;
            case 10: goto L86;
            case 11: goto L85;
            case 12: goto L84;
            case 13: goto L83;
            case 14: goto L82;
            case 15: goto L81;
            case 16: goto L80;
            case 17: goto L79;
            default: goto L78;
        };
    L78:
        OLog.d(TAG, "getLaunchFragment: Mismatch : " + r2);
        goto L91
    L79:
        String r3 = PageConstants.PAGE_TNT_BLUETOOTH_SETTINGS;
    L97:
        return getSupportFragment(r3);
    L80:
        r3 = PageConstants.PAGE_TNT_NETWORK_SETTINGS;
        goto L97
    L81:
        r3 = PageConstants.PAGE_TNT_WALLPAPER_SETTINGS;
        goto L97
    L82:
        r3 = PageConstants.PAGE_TNT_WIFI_AP_SETTINGS;
        goto L97
    L83:
        r3 = PageConstants.PAGE_TNT_NOTIFICATION_SETTINGS;
        goto L97
    L84:
        r3 = PageConstants.PAGE_TNT_KEYBOARD_SETTINGS;
        goto L97
    L85:
        r3 = PageConstants.PAGE_TNT_SCREEN_OFF_TIMEOUT_SETTINGS;
        goto L97
    L86:
        r3 = PageConstants.PAGE_TNT_SOUND_SETTINGS;
        goto L97
    L87:
        r3 = PageConstants.PAGE_TNT_WIFI_SETTINGS;
        goto L97
    L88:
        r3 = PageConstants.PAGE_TNT_EYES_PROTECTION;
        goto L97
    L89:
        r3 = PageConstants.PAGE_TNT_DOCK_SETTINGS;
        goto L97
    L90:
        r3 = PageConstants.PAGE_TNT_VPN_SETTINGS;
    L91:
        r3 = null;
        goto L97
    L92:
        r3 = PageConstants.PAGE_TNT_WIFI_DISPLAY_SETTINGS;
        goto L97
    L93:
        r3 = PageConstants.PAGE_PREFERRED;
        goto L97
    L94:
        r3 = PageConstants.PAGE_TNT_SYSTEM_NOTIFICATION_BANNER_SETTINGS;
        goto L97
    L95:
        r3 = PageConstants.PAGE_TNT_BOSTON_SETTINGS;
        goto L97
    L6:
        if (r2.equals("bluetooth") == false) goto L77;
        r1 = 17;
        goto L77
    L10:
        if (r2.equals("network") == false) goto L77;
        r1 = 16;
        goto L77
    L14:
        if (r2.equals(PageConstants.LAUNCH_PAGE_WALLPAPER) == false) goto L77;
        r1 = 15;
        goto L77
    L18:
        if (r2.equals("wifi_ap") == false) goto L77;
        r1 = 14;
        goto L77
    L22:
        if (r2.equals("notification") == false) goto L77;
        r1 = 13;
        goto L77
    L26:
        if (r2.equals("keyboard") == false) goto L77;
        r1 = 12;
        goto L77
    L30:
        if (r2.equals(PageConstants.LAUNCH_PAGE_SCREEN_OFF_TIMEOUT) == false) goto L77;
        r1 = 11;
        goto L77
    L34:
        if (r2.equals(PageConstants.LAUNCH_PAGE_SOUND) == false) goto L77;
        r1 = 10;
        goto L77
    L38:
        if (r2.equals("wifi") == false) goto L77;
        r1 = 9;
        goto L77
    L42:
        if (r2.equals(PageConstants.LAUNCH_PAGE_EYES) == false) goto L77;
        r1 = 8;
        goto L77
    L46:
        if (r2.equals(PageConstants.LAUNCH_PAGE_DOCK) == false) goto L77;
        r1 = 7;
        goto L77
    L50:
        if (r2.equals(PageConstants.LAUNCH_PAGE_VPN) == false) goto L77;
        r1 = 6;
        goto L77
    L54:
        if (r2.equals(PageConstants.LAUNCH_PAGE_SCREEN) == false) goto L77;
        r1 = 5;
        goto L77
    L58:
        if (r2.equals(PageConstants.LAUNCH_PAGE_READ_MODE) == false) goto L77;
        r1 = 4;
        goto L77
    L62:
        if (r2.equals(PageConstants.LAUNCH_PAGE_WIFI_DISPLAY) == false) goto L77;
        r1 = 3;
        goto L77
    L66:
        if (r2.equals(PageConstants.LAUNCH_PAGE_PREFERRED) == false) goto L77;
        r1 = 2;
        goto L77
    L70:
        if (r2.equals(PageConstants.LAUNCH_PAGE_SYSTEM_NOTIFICATION_BANNER) == false) goto L77;
        r1 = 1;
        goto L77
    L74:
        if (r2.equals(PageConstants.LAUNCH_PAGE_BOSTON) == false) goto L77;
        r1 = 0;
        goto L77
    }
}
