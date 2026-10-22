package com.bytedanceos.security.multi.adpter;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import com.android.internal.app.IMediaContainerService;
import com.bytedanceos.storage.StorageMeasurement;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SDKAdapter {
    private static final String TAG = "SDKAdapter";

    public static void calculateMediaSize(HashMap<String, Long> mediaSize, Set<String> sMeasureMediaTypes, IMediaContainerService imcs) {
    }

    public static long getAppSize() {
        return 0;
    }

    public static StorageMeasurement.DeviceStorageInfo getDeviceStorageInfo(IMediaContainerService imcs, String path) {
        return null;
    }

    public static long getOtherFileSize() {
        return 0;
    }

    public static void getPackageSizeInfoAsUser(PackageManager pm, ApplicationInfo info, int userId, Object observer) {
    }

    public static void setPowerSaveMode(PowerManager mPowerManager, boolean enable) {
    }

    public SDKAdapter() {
    }
}
