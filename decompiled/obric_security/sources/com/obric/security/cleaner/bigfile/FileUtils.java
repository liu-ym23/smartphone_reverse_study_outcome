package com.obric.security.cleaner.bigfile;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaFile;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import androidx.core.content.FileProvider;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class FileUtils {
    private static final String[] PREFIXES = null;
    public static final int TYPE_APK = 4;
    public static final int TYPE_AUDIO = 3;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OTHER = 5;
    public static final int TYPE_VIDEO = 2;

    public FileUtils() {
    }

    static {
        PREFIXES = new String[]{"/storage/emulated/0/", "/storage/emulated/10/"};
    }

    public static final Uri getUriForFile(Context context, String filePath) {
        return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", new File(filePath));
    }

    public static Uri getImageContentUri(String fileName, String parentDirectory) {
        Cursor r8 = SecurityCenterApplication.getApplication().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "relative_path=? AND _display_name=?", new String[]{parentDirectory + LibrarianImpl.Constants.SEPARATOR, fileName}, null);
        if (r8 != null) goto L5;
    L8:
        if (r8 == null) goto L12;
        r8.close();
        return null;
    L12:
        return null;
    L5:
        if (r8.moveToFirst() == false) goto L8;
        long r0 = r8.getLong(r8.getColumnIndexOrThrow("_id"));
        r8.close();
        return ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r0);
    }

    public static String getFileExtension(String fileName) {
        if (fileName != null) goto L5;
    L14:
        return null;
    L5:
        if (fileName.isEmpty() == true) goto L14;
        int r1 = fileName.lastIndexOf(46);
        if (r1 <= 0) goto L14;
        if (r1 == (fileName.length() - 1)) goto L14;
        return fileName.substring(r1 + 1).toLowerCase();
    }

    public static String getMimeTypeFromSystem(String filePath) {
        return MediaFile.getMimeTypeForFile(filePath);
    }

    public static String removeStoragePrefix(String filePath) {
        if (filePath != null) goto L4;
    L13:
        return filePath;
    L4:
        if (filePath.isEmpty() == true) goto L13;
        String[] r0 = PREFIXES;
        int r1 = r0.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        String r3 = r0[r2];
        if (filePath.startsWith(r3) == true) goto L11;
        r2 = r2 + 1;
        goto L7
    L11:
        return filePath.substring(r3.length());
    }

    public static String getParentDirectory(String filePath) {
        if (filePath != null) goto L5;
        return null;
    L5:
        if (filePath.isEmpty() == true) goto L13;
        File r2 = new File(filePath).getParentFile();
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.getPath();
    L13:
        return null;
    }

    public static int getFileType(String mimeType, String fileExtension) {
        if (fileExtension.isEmpty() == false) goto L6;
        return 0;
    L6:
        if (mimeType != null) goto L8;
    L11:
        if (mimeType != null) goto L13;
    L16:
        if (mimeType != null) goto L18;
    L21:
        if (fileExtension != null) goto L23;
        return 5;
    L23:
        if (fileExtension.equalsIgnoreCase("apk") == false) goto L28;
        return 4;
    L28:
        return 5;
    L18:
        if (mimeType.startsWith("audio") == false) goto L21;
        return 3;
    L13:
        if (mimeType.startsWith("video") == false) goto L16;
        return 2;
    L8:
        if (mimeType.startsWith(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L11;
        return 1;
    }

    public boolean isTaskMimeType(String mimeType, String methodName) {
        Object r5 = Class.forName("android.media.MediaFile").getMethod(methodName, new Class[]{String.class}).invoke(null, new Object[]{mimeType});     // Catch: Exception -> L9
        if (r5 != null) goto L6;
        return false;
    L6:
        if ((r5 instanceof Boolean) == false) goto L13;
        return ((Boolean) r5).booleanValue();
    L13:
        return false;
    L14:
        return false;
    }

    public static String getTokenWithData() {
        return Base64.encodeToString(("com.obric.security.fileprovider" + System.currentTimeMillis()).getBytes("UTF-8"), 0);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
