package com.android.settings.deviceinfo;

import android.content.Context;
import android.content.Intent;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.provider.Settings;
import android.text.TextUtils;
import com.android.settings.PreferenceMgr;
import com.android.settings.SettingsFeature;
import com.android.settings.search.Index;
import com.obric.olog.OLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class StorageUtils {
    public static final String ACTION_VIEW_FOLDER = "com.bytedance.action.VIEW_FOLDER";
    public static final String CLASS_NAME_FILEMANAGER = "com.bytedance.filemanager.MainActivity";
    public static final String CURRENT_POSITION = "current_position";
    public static final String EXTERNAL_FORMAT_BEGIN = "com.bytedance.action.format_external_begin";
    public static final String EXTERNAL_FORMAT_END = "com.bytedance.action.format_external_end";
    public static final String INTENT_PATH = "path";
    public static final String INTENT_STORAGE_TYPE = "storageType";
    public static final String PACKAGE_NAME_FILEMANAGER = "com.obric.filemanager";
    public static final int POP_UP_EXTERNAL = 1;
    public static final int POP_UP_INTERNAL = 0;
    public static final int POSITION_OF_BACKUP_ITEM = 0;
    public static final String TAG = "StorageUtils";
    public static final int TYPE_PRIMARY_STORAGE = 1;
    public static final int TYPE_SD = 2;
    public static final int TYPE_USB = 3;
    public static boolean isFormatting = false;
    private static final List<String> sAppStorageKeyList = null;

    public StorageUtils() {
    }

    static {
        List<String> r0 = Arrays.asList(new String[]{"storage_path_camera", "storage_path_music", "storage_path_recording", "storage_path_captivate", "storage_path_screenshot", "storage_path_mail_attachment_download", "storage_path_browser_download", "storage_path_local_backup"});
        sAppStorageKeyList = r0;
        POSITION_OF_BACKUP_ITEM = r0.indexOf("storage_path_local_backup");
    }

    public static int getStoragePathValue(Context r2, int r3) {
        if (r3 != POSITION_OF_BACKUP_ITEM) goto L5;
        int r0 = 1;
    L7:
        return Settings.Global.getInt(r2.getContentResolver(), sAppStorageKeyList.get(r3), r0);
    L5:
        r0 = 0;
        goto L7
    }

    public static void putStoragePathValue(Context r1, int r2, int r3) {
        putStoragePathValue(r1, r2, r3, false);
    }

    public static void putStoragePathValue(Context r1, int r2, int r3, boolean r4) {
        if (r3 != 0) goto L4;
    L6:
        String r5 = sAppStorageKeyList.get(r2);
        Settings.Global.putInt(r1.getContentResolver(), r5, r3);
        if (r4 == false) goto L10;
        PreferenceMgr.getInstance(r1).putInt(createPreferKeyPrefix(getFirstValidSDVolumeInfo(r1)) + r5, r3);
        return;
    L10:
        return;
    L4:
        if (r3 == 1) goto L6;
    }

    private static VolumeInfo getFirstValidSDVolumeInfo(Context r2) {
        OLog.d(TAG, " getFirstValidSDVolumeInfo");
        if (SettingsFeature.isSdMounted() == false) goto L10;
        Iterator r3 = ((StorageManager) r2.getSystemService("storage")).getVolumes().iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        VolumeInfo r0 = (VolumeInfo) r3.next();
        if (isValidSdVolume(r0) == false) goto L6;
        return r0;
    L10:
        return null;
    }

    public static void updateStoragePath(Intent r4, Context r5) {
        String r6 = r4.getStringExtra("android.os.storage.extra.VOLUME_ID");
        if (TextUtils.isEmpty(r6) == false) goto L6;
        OLog.d(TAG, " empty volume id: " + r6);
        return;
    L6:
        VolumeInfo r7 = ((StorageManager) r5.getSystemService(StorageManager.class)).findVolumeById(r6);
        if (isValidSdVolume(r7) == false) goto L20;
        int r0 = r7.getState();
        OLog.d(TAG, "volumeState =========== " + r0);
        if (r0 == 2) goto L15;
        if (r0 != 5) goto L22;
        saveOldPath(r5, r7);
        resetAllStoragePaths(r5);
        return;
    L22:
        return;
    L15:
        if (r7.equals(getFirstValidSDVolumeInfo(r5)) == true) goto L18;
        OLog.d(TAG, "only restore first partition sdcard");
        return;
    L18:
        restoreOldPath(r5, r7);
        return;
    }

    private static void resetAllStoragePaths(Context r3) {
        OLog.d(TAG, "resetAllStoragePaths");
        int r1 = 0;
    L4:
        if (r1 >= sAppStorageKeyList.size()) goto L6;
        putStoragePathValue(r3, r1, 0);
        r1 = r1 + 1;
        goto L4
    }

    private static String createPreferKeyPrefix(VolumeInfo r2) {
        if (r2 != null) goto L4;
    L6:
        String r3 = "";
    L7:
        String r4 = Index.ENTRIES_SEPARATOR + r3 + Index.ENTRIES_SEPARATOR;
        OLog.d(TAG, "prefix " + r4);
        return r4;
    L4:
        if (r2.getPath() == null) goto L6;
        r3 = r2.getPath().getAbsolutePath();
        goto L7
    }

    public static boolean isValidSdVolume(VolumeInfo r3) {
        boolean r0 = false;
        if (r3 != null) goto L5;
    L11:
        if (r0 == false) goto L13;
        OLog.d(TAG, "valid VolumeInfo " + r3);
    L13:
        return r0;
    L5:
        if (r3.getType() != 0) goto L11;
        if (r3.getDisk() == null) goto L11;
        if (r3.getDisk().isSd() == false) goto L11;
        r0 = true;
        goto L11
    }

    public static void restoreOldPathAfterBoot(Context r2) {
        OLog.d(TAG, "restoreOldPathAfterBoot");
        VolumeInfo r0 = getFirstValidSDVolumeInfo(r2);
        if (r0 == null) goto L5;
        restoreOldPath(r2, r0);
        return;
    L5:
        resetAllStoragePaths(r2);
    }

    public static void saveOldPath(Context r5, VolumeInfo r6) {
        OLog.d(TAG, "save old path for\n" + r6);
        PreferenceMgr r0 = PreferenceMgr.getInstance(r5);
        String r7 = createPreferKeyPrefix(r6);
        int r1 = 0;
    L3:
        List<String> r2 = sAppStorageKeyList;
        if (r1 >= r2.size()) goto L12;
        int r3 = getStoragePathValue(r5, r1);
        String r4 = r2.get(r1);
        if (r3 != 0) goto L8;
    L10:
        r0.putInt(r7 + r4, r3);
    L11:
        r1 = r1 + 1;
        goto L3
    L8:
        if (r3 == 1) goto L10;
    }

    public static void restoreOldPath(Context r7, VolumeInfo r8) {
        OLog.d(TAG, "restore old path for\n" + r8);
        PreferenceMgr r0 = PreferenceMgr.getInstance(r7);
        String r9 = createPreferKeyPrefix(r8);
        int r2 = 0;
    L3:
        List<String> r3 = sAppStorageKeyList;
        if (r2 >= r3.size()) goto L15;
        String r4 = r3.get(r2);
        if (r2 != POSITION_OF_BACKUP_ITEM) goto L8;
        int r5 = 1;
    L9:
        int r6 = r0.getInt(r9 + r4, r5);
        if (r6 == 0) goto L13;
        if (r6 == 1) goto L13;
    L14:
        r2 = r2 + 1;
    L13:
        putStoragePathValue(r7, r2, r6);
        goto L14
    L8:
        r5 = 0;
        goto L9
    }
}
