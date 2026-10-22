package com.android.settings;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.obric.olog.OLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class WallpaperUtils {
    public static final String BYTEDANCE_WALLPAPER_PACKAGE = "com.bytedanceos.wallpapers";
    public static final Uri CONTENT_URI = null;
    public static final String EXTRA_WALLPAPER_SUBTYPE = "extra_wallpaper_subtype";
    public static final String EXTRA_WALLPAPER_TYPE = "extra_wallpaper_type";
    private static final String TAG = "WallpaperUtils";
    public static final int TYPE_AUTO_SWITCH = 4;
    public static final int TYPE_LATEST = 5;
    public static final int TYPE_LOCKSCREEN = 1;
    public static final int TYPE_MEETING = 7;
    public static final int TYPE_ORIGINAL_LAUNCHER = 2;
    public static final int TYPE_TABLET = 6;
    public static final int TYPE_THUMB_PULLDOWN_WALLPAPAER = 3;
    public static String WALLPAPER_RESOURCE_URI = "android.resource://com.bytedanceos.wallpapers/drawable/";

    public static final enum PaperSubtype extends Enum<PaperSubtype> {
        private static final /* synthetic */ PaperSubtype[] $VALUES = null;
        public static final PaperSubtype CLASSIC = null;
        public static final PaperSubtype CUSTOMIZE = null;
        public static final PaperSubtype NETWORK = null;
        private String subtypeName;

        private static /* synthetic */ PaperSubtype[] $values() {
            return new PaperSubtype[]{CLASSIC, NETWORK, CUSTOMIZE};
        }

        public static PaperSubtype valueOf(String r1) {
            return (PaperSubtype) Enum.valueOf(PaperSubtype.class, r1);
        }

        public static PaperSubtype[] values() {
            return (PaperSubtype[]) $VALUES.clone();
        }

        static {
            CLASSIC = new PaperSubtype("CLASSIC", 0, "classic");
            NETWORK = new PaperSubtype("NETWORK", 1, "network");
            CUSTOMIZE = new PaperSubtype("CUSTOMIZE", 2, "customize");
            $VALUES = $values();
        }

        private PaperSubtype(String r1, int r2, String r3) {
            super(r1, r2);
            this.subtypeName = r3;
        }
    }

    public WallpaperUtils() {
    }

    static {
        CONTENT_URI = Uri.parse("content://com.obric.wallpaper/wallpapers");
    }

    public static Uri getDefaultWallpaperUri(Context r2, int r3) {
        if (r3 != 1) goto L5;
        String r4 = android.provider.Settings.Global.getString(r2.getContentResolver(), "default_lockscreen_uri");
    L10:
        if (TextUtils.isEmpty(r4) == false) goto L13;
        return null;
    L13:
        return Uri.parse(r4);
    L5:
        if (r3 == 3) goto L7;
        r4 = null;
        goto L10
    L7:
        r4 = android.provider.Settings.Global.getString(r2.getContentResolver(), "default_thumb_pulldown_wallpaper_uri");
        goto L10
    }

    public static String getUserSettingWallpaper(Context r1, int r2) {
        if (r2 == 1) goto L9;
        if (r2 == 3) goto L11;
        return null;
    L11:
        return android.provider.Settings.Global.getString(r1.getContentResolver(), "custom_thumb_pulldown_wallpaper_uri");
    L9:
        return android.provider.Settings.System.getString(r1.getContentResolver(), "lockscreen_background");
    }

    public static void setUserSettingWallpaper(Context r3, Uri r4, int r5) {
        if (r5 != 1) goto L5;
        android.provider.Settings.System.putString(r3.getContentResolver(), "lockscreen_background", r4.toString());
        putToHistoryWallpapers(r3, r4, r5);
        return;
    L5:
        if (r5 != 3) goto L11;
        android.provider.Settings.Global.putString(r3.getContentResolver(), "custom_thumb_pulldown_wallpaper_uri", r4.toString());
        return;
    }

    private static void putToHistoryWallpapers(Context r7, Uri r8, int r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        ContentResolver r10 = r7.getContentResolver();
        Uri r6 = CONTENT_URI;
        Cursor r0 = r10.query(r6, null, "wallpaper_uri='" + r8 + "'", null, null);
        if (r0 != null) goto L7;
    L10:
        ContentValues r1 = new ContentValues();
        r1.put("wallpaper_uri", r8.toString());
        r1.put("wallpaper_type", Integer.valueOf(r9));
        r1.put("setting_time", Long.valueOf(System.currentTimeMillis()));
        r10.insert(r6, r1);
    L11:
        if (r0 == null) goto L14;
        r0.close();
        return;
    L14:
        return;
    L7:
        if (r0.getCount() == 0) goto L10;
        OLog.d(TAG, "wallpaper:" + r8 + " already exists in history wallpapers.");
        goto L11
    }

    public static Bitmap getResizedWallpaperBitmap(Context r0, int r1) {
        Bitmap r2 = getWallpaperBitmap(r0, r1);
        if (r2 != null) goto L5;
        return r2;
    L5:
        return Utils.resizeWallpaper(r2, Utils.THUMBNAIL_WIDTH);
    }

    public static Bitmap getWallpaperBitmap(Context r7, int r8) {
        String r1 = getUserSettingWallpaper(r7, r8);
        Bitmap r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        InputStream r5 = null;
        r4 = null;
        r4 = null;
        r4 = null;
        if (TextUtils.isEmpty(r1) == true) goto L44;
        Uri r2 = Uri.parse(r1);
        if (r2 == null) goto L44;
        String r3 = r2.getScheme();
        if ("file".equals(r3) == false) goto L9;
    L64:
        r4 = MediaStore.Images.Media.getBitmap(r7.getContentResolver(), r2);     // Catch: IOException -> L40 FileNotFoundException -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L44
    L9:
        if ("android.resource".equals(r3) == true) goto L64;
        if ("content".equals(r3) == false) goto L44;
        InputStream r6 = r7.getContentResolver().openInputStream(r2);     // Catch: Throwable -> L24 Exception -> L26
        r4 = ((BitmapDrawable) Drawable.createFromResourceStream(null, null, r6, null, null)).getBitmap();     // Catch: Throwable -> L20 Exception -> L22
        if (r6 == null) goto L44;
        r6.close();     // Catch: IOException -> L18
    L54:
    L22:
        e = e;
    L28:
        OLog.w(TAG, "Unable to open content: " + r2, e);     // Catch: Throwable -> L20
        if (r6 == null) goto L44;
        r6.close();     // Catch: IOException -> L18
    L20:
        th = th;
        r5 = r6;
    L32:
        if (r5 != null) goto L57;
    L37:
        throw th;
    L57:
        r5.close();     // Catch: IOException -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L26:
        e = e;
        r6 = null;
    L24:
        th = th;
    L18:
        e = move-exception;
        e.printStackTrace();
    L44:
        if (r4 != null) goto L66;
        Uri r9 = getDefaultWallpaperUri(r7, r8);
        if (r9 != null) goto L52;
        OLog.d(TAG, "default wallpaper uri is null");
        return r4;
    L52:
        return MediaStore.Images.Media.getBitmap(r7.getContentResolver(), r9);
    L68:
        return r4;
    L66:
        return r4;
    }
}
