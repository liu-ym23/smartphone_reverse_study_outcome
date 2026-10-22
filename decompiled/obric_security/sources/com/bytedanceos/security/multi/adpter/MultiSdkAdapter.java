package com.bytedanceos.security.multi.adpter;

import android.app.AppOpsManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import com.android.internal.app.IMediaContainerService;
import com.bytedanceos.storage.StorageMeasurement;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class MultiSdkAdapter extends SDKAdapter {
    private CommonSDKAdapter mCommconSDK;
    private AndroidOSDKAdapter mOSDK;

    private static class SDK_VERSION {
        public static final int SDK_M = 23;
        public static final int SDK_O = 26;
        public static final int SDK_P = 28;
        public static final int SDK_Q = 29;

        private SDK_VERSION() {
        }
    }

    public static boolean isAfterQ() {
        return true;
    }

    public static boolean isBeforeP() {
        return false;
    }

    public static boolean sdkIsBeforeO() {
        return false;
    }

    private MultiSdkAdapter() {
        this.mCommconSDK = new CommonSDKAdapter();
        this.mOSDK = new AndroidOSDKAdapter();
    }

    public static void getPackageSizeInfoAsUser(PackageManager pm, ApplicationInfo info, int userId, Object observer) {
        AndroidOSDKAdapter.getPackageSizeInfoAsUser(pm, info, userId, observer);
    }

    public static StorageMeasurement.DeviceStorageInfo getDeviceStorageInfo(IMediaContainerService imcs, String path) {
        return AndroidOSDKAdapter.getDeviceStorageInfo(imcs, path);
    }

    public static long getOtherFileSize() {
        return AndroidOSDKAdapter.getOtherFileSize();
    }

    public static void calculateMediaSize(HashMap<String, Long> mediaSize, Set<String> sMeasureMediaTypes, IMediaContainerService imcs) {
        AndroidOSDKAdapter.calculateMediaSize(mediaSize, sMeasureMediaTypes, imcs);
    }

    public static long getAppSize() {
        return AndroidOSDKAdapter.getAppSize();
    }

    public static void setPowerSaveMode(PowerManager powerManager, boolean enable) {
        AndroidQSDKAdapter.setPowerSaveMode(powerManager, enable);
    }

    public static int checkAppOp(AppOpsManager appOpsManager, String op, int uid, String packageName) {
        if (isBeforeP() == false) goto L7;
        return CommonSDKAdapter.checkAppOp(appOpsManager, op, uid, packageName);
    L7:
        return AndroidPSDKAdapter.checkAppOp(appOpsManager, op, uid, packageName);
    }
}
