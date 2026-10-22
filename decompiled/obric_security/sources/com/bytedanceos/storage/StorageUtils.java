package com.bytedanceos.storage;

import android.os.storage.VolumeInfo;
import bytedanceos.util.LogTag;

/* JADX INFO: loaded from: classes2.dex */
public class StorageUtils {
    public static final String ACTION_VIEW_FOLDER = "com.bytedance.action.VIEW_FOLDER";
    public static final String CLASS_NAME_FILEMANAGER = "com.bytedance.filemanager.MainActivity";
    public static final String INTENT_PATH = "path";
    public static final String INTENT_STORAGE_TYPE = "storageType";
    public static final String PACKAGE_NAME_FILEMANAGER = "com.obric.filemanager";
    public static final String TAG = "StorageUtils";
    public static final int TYPE_PRIMARY_STORAGE = 1;
    public static final int TYPE_SD = 2;
    public static final int TYPE_USB = 3;

    public StorageUtils() {
    }

    public static boolean isValidSdVolume(VolumeInfo vol) {
        boolean r0 = false;
        if (vol != null) goto L5;
    L11:
        if (r0 == false) goto L13;
        LogTag.d(TAG, "valid VolumeInfo " + vol);
    L13:
        return r0;
    L5:
        if (vol.getType() != 0) goto L11;
        if (vol.getDisk() == null) goto L11;
        if (vol.getDisk().isSd() == false) goto L11;
        r0 = true;
        goto L11
    }
}
