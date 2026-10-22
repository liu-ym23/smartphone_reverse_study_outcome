package com.bytedanceos.security.permission;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OpenSystemConstant {
    private static final String[] NORMAL_FILTER_PERMISION = null;
    private static final List<OpenSystemApp> OPEN_SYSTEM_APPS = null;
    private static final String PKG_APPSTORE = "com.obric.appstore";
    private static final String PKG_BROWSER = "com.android.browser";
    private static final String PKG_BYTEDANCE_IME = "com.bytedanceos.ime";
    private static final String PKG_CALCULATOR = "com.bytedanceos.calculator";
    private static final String PKG_CALENDAR = "com.android.calendar";
    private static final String PKG_CAMERA = "com.android.camera2";
    private static final String PKG_CLOCK = "com.bytedanceos.clock";
    private static final String PKG_CLOUD = "com.bytedanceos.cloudsync";
    private static final String PKG_COMPASS = "com.bytedanceos.compass";
    private static final String PKG_CONTACTS = "com.android.contacts";
    private static final String PKG_EMAIL = "com.android.email";
    private static final String PKG_EXCANGE = "com.android.exchange";
    private static final String PKG_FILEMANAGER = "com.obric.filemanager";
    private static final String PKG_GALLERY = "com.android.gallery3d";
    private static final String PKG_GAMESTORE = "com.bytedanceos.gamestore";
    private static final String PKG_HANDINHAND = "com.bytedanceos.handinhand";
    private static final String PKG_HANDSHAKER = "com.bytedanceos.smartfolder.aoa";
    private static final String PKG_HEARINGAID = "com.bytedanceos.hearingaid";
    private static final String PKG_IDEAPILLS = "com.bytedanceos.ideapills";
    private static final String PKG_MAGICFLOW = "com.bytedanceos.magicflow";
    private static final String PKG_MMS = "com.android.mms";
    private static final String PKG_MUSIC = "com.obric.music";
    private static final String PKG_NOTES = "com.obric.notes";
    private static final String PKG_QUICKSEARCH = "com.obric.quicksearch";
    private static final String PKG_RECORDER = "com.obric.recorder";
    public static final String PKG_SCREEN_RECORDER = "com.obric.screenrecorder";
    private static final String PKG_SECURITY = "com.obric.security";
    private static final String PKG_TEXTBOOM = "com.bytedanceos.textboom";
    private static final String PKG_VOICE = "com.bytedanceos.sara";
    private static final String PKG_WEATHER = "com.bytedanceos.weather";
    private static final String PKG_WRITE = "com.bytedanceos.writer";

    public OpenSystemConstant() {
    }

    static {
        ArrayList r0 = new ArrayList();
        OPEN_SYSTEM_APPS = r0;
        String[] r2 = {"android.permission.READ_PHONE_STATE"};
        NORMAL_FILTER_PERMISION = r2;
        r0.add(new OpenSystemApp(PKG_CALCULATOR, r2, true));
        r0.add(new OpenSystemApp(PKG_CALENDAR, new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"}, true));
        r0.add(new OpenSystemApp("com.obric.recorder", r2, true));
        r0.add(new OpenSystemApp(PKG_MUSIC, r2, true));
        r0.add(new OpenSystemApp(PKG_MAGICFLOW, r2, true));
        r0.add(new OpenSystemApp(PKG_HANDSHAKER, r2, true));
        r0.add(new OpenSystemApp(PKG_WEATHER, r2, true));
        r0.add(new OpenSystemApp(PKG_NOTES, r2, true));
        r0.add(new OpenSystemApp(PKG_WRITE, r2, true));
        r0.add(new OpenSystemApp(PKG_CLOCK, r2, true));
        r0.add(new OpenSystemApp(PKG_MMS, r2, false));
        r0.add(new OpenSystemApp(PKG_CONTACTS, new String[]{"android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, true));
        r0.add(new OpenSystemApp("com.obric.filemanager", r2, true));
        r0.add(new OpenSystemApp(PKG_QUICKSEARCH, r2, false));
        r0.add(new OpenSystemApp(PKG_COMPASS, r2, true));
        r0.add(new OpenSystemApp(PKG_HANDINHAND, r2, true));
        r0.add(new OpenSystemApp(PKG_BROWSER, r2, true));
        r0.add(new OpenSystemApp(PKG_BYTEDANCE_IME, r2, true));
        r0.add(new OpenSystemApp(PKG_EMAIL, r2, false));
        r0.add(new OpenSystemApp(PKG_VOICE, r2, false));
        r0.add(new OpenSystemApp(PKG_GALLERY, r2, true));
        r0.add(new OpenSystemApp("com.bytedanceos.cloudsync", r2, false));
        r0.add(new OpenSystemApp(PKG_APPSTORE, new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, true));
        r0.add(new OpenSystemApp(PKG_SCREEN_RECORDER, r2, true));
        r0.add(new OpenSystemApp("com.android.camera2", r2, true));
        r0.add(new OpenSystemApp(PKG_GAMESTORE, new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, true));
        r0.add(new OpenSystemApp(PKG_TEXTBOOM, r2, false));
        r0.add(new OpenSystemApp(PKG_HEARINGAID, r2, true));
        r0.add(new OpenSystemApp("com.obric.security", new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_SMS", "android.permission.RECEIVE_SMS", "android.permission.RECEIVE_MMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"}, true));
        r0.add(new OpenSystemApp(PKG_IDEAPILLS, r2, false));
        r0.add(new OpenSystemApp(PKG_EXCANGE, r2, false));
    }

    public static List<OpenSystemApp> getAllOpenSystemApps() {
        return OPEN_SYSTEM_APPS;
    }
}
