package com.bytedanceos.security.multi.adpter;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.PowerManager;
import com.android.internal.app.IMediaContainerService;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.bytedanceos.security.reflect.ReflectHelper;
import com.bytedanceos.storage.StorageMeasurement;
import com.obric.olog.OLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class CommonSDKAdapter extends SDKAdapter {
    public static final String TAG = "CommonSDKAdapter";

    public CommonSDKAdapter() {
    }

    public static void getPackageSizeInfoAsUser(PackageManager pm, ApplicationInfo info, int userId, Object observer) {
        ReflectHelper.invokeMethod(pm, "getPackageSizeInfoAsUser", new Class[]{String.class, Integer.TYPE, Class.forName("android.content.pm.IPackageStatsObserver")}, new Object[]{info.packageName, Integer.valueOf(userId), observer});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.d(TAG, "getPackageSizeInfoAsUser exception =" + e);
    }

    public static StorageMeasurement.DeviceStorageInfo getDeviceStorageInfo(IMediaContainerService imcs, String path) {
        StorageMeasurement.DeviceStorageInfo r0 = new StorageMeasurement.DeviceStorageInfo();
        long[] r9 = (long[]) ReflectHelper.invokeMethod(imcs, "getFileSystemStats", new Class[]{String.class}, new Object[]{path});     // Catch: Exception -> L5
        long r3 = r9[0];     // Catch: Exception -> L5
        r0.totalSize = (long) Math.pow(2.0d, Long.toBinaryString(r3 << 1).length() - 1);     // Catch: Exception -> L5
        r0.availableSize = r9[1];     // Catch: Exception -> L5
        r0.systemSize = r0.totalSize - r3;     // Catch: Exception -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        OLog.d(TAG, "getDeviceStorageInfo exception =" + e);
        goto L7
    }

    public static void calculateMediaSize(HashMap<String, Long> mediaSize, Set<String> sMeasureMediaTypes, IMediaContainerService imcs) {
        Environment.UserEnvironment r0 = new Environment.UserEnvironment(ActivityManager.getCurrentUser());
        Iterator<String> r9 = sMeasureMediaTypes.iterator();     // Catch: Exception -> L8
    L5:
        if (r9.hasNext() == false) goto L15;
        String r1 = r9.next();     // Catch: Exception -> L8
        mediaSize.put(r1, Long.valueOf(((Long) ReflectHelper.invokeMethod(imcs, "calculateDirectorySize", new Class[]{String.class}, new Object[]{r0.getExternalStoragePublicDirectory(r1).toString()})).longValue()));     // Catch: Exception -> L8
        goto L5
    L15:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public static void setPowerSaveMode(PowerManager powerManager, boolean enable) {
        if (powerManager != null) goto L4;
        return;
    L4:
        ReflectHelper.invokeMethod(powerManager, "setPowerSaveMode", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(enable)});
    }

    public static int checkAppOp(AppOpsManager appOpsManager, String op, int uid, String packageName) {
        if (appOpsManager != null) goto L6;
        return OpsManagerHelper.get_MODE_INVALID();
    L6:
        return appOpsManager.checkOpNoThrow(op, uid, packageName);
    }
}
