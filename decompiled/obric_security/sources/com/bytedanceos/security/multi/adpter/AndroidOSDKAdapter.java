package com.bytedanceos.security.multi.adpter;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.os.StatFs;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import com.android.internal.app.IMediaContainerService;
import com.bytedanceos.security.reflect.ReflectHelper;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.storage.DeviceUtils;
import com.bytedanceos.storage.StorageMeasurement;
import com.obric.olog.OLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidOSDKAdapter extends SDKAdapter {
    public static final String TAG = "AndroidOSDKAdapter";

    public AndroidOSDKAdapter() {
    }

    public static StorageMeasurement.DeviceStorageInfo getDeviceStorageInfo(IMediaContainerService imcs, String path) {
        StorageMeasurement.DeviceStorageInfo r6 = new StorageMeasurement.DeviceStorageInfo();
        new File(path);     // Catch: Exception -> L19
        Class<?> r7 = Class.forName("android.app.usage.StorageStatsManager");     // Catch: Exception -> L19
        if (r7 != null) goto L6;
        return null;
    L6:
        Object r8 = SecurityCenterApplication.getApplication().getSystemService(r7);     // Catch: Exception -> L19
        if (r8 != null) goto L9;
        return null;
    L9:
        StorageManager r0 = (StorageManager) SecurityCenterApplication.getApplication().getSystemService(StorageManager.class);     // Catch: Exception -> L19
        if (r0 != null) goto L12;
        return r6;
    L12:
        Iterator r1 = r0.getVolumes().iterator();     // Catch: Exception -> L19
    L14:
        if (r1.hasNext() == false) goto L21;
        VolumeInfo r2 = (VolumeInfo) r1.next();     // Catch: Exception -> L19
        if (r2.isPrimary() == false) goto L14;
        r6.totalSize = ((Long) ReflectHelper.invokeMethod(r8, "getTotalBytes", new Class[]{String.class}, new Object[]{r2.fsUuid})).longValue();     // Catch: Exception -> L19
        r6.availableSize = getSDAvailableSize();     // Catch: Exception -> L19
    L21:
        return r6;
    L19:
        e = move-exception;
        OLog.d(TAG, "getDeviceStorageInfo exception =" + e);
        goto L21
    }

    public static long getOtherFileSize() {
        Context r2 = SecurityCenterApplication.getApplication().getApplicationContext();     // Catch: Exception -> L37
        Class<?> r3 = Class.forName("android.app.usage.StorageStatsManager");     // Catch: Exception -> L37
        if (r3 != null) goto L6;
        return 0;
    L6:
        Object r4 = SecurityCenterApplication.getApplication().getSystemService(r3);     // Catch: Exception -> L37
        if (r4 != null) goto L9;
        return 0;
    L9:
        StorageManager r5 = (StorageManager) r2.getSystemService(StorageManager.class);     // Catch: Exception -> L37
        if (r5 != null) goto L12;
        return 0;
    L12:
        Iterator r6 = r5.getVolumes().iterator();     // Catch: Exception -> L37
    L14:
        if (r6.hasNext() == false) goto L46;
        VolumeInfo r7 = (VolumeInfo) r6.next();     // Catch: Exception -> L37
        if (r7.isPrimary() == false) goto L14;
        Object r8 = ReflectHelper.invokeMethod(r4, "queryExternalStatsForUser", new Class[]{String.class, UserHandle.class}, new Object[]{r7.fsUuid, UserHandle.SYSTEM});     // Catch: Exception -> L37
        if (r8 != null) goto L20;
        return 0;
    L20:
        Long r9 = (Long) ReflectHelper.getVariable(r8, "totalBytes");     // Catch: Exception -> L37
        if (r9 != null) goto L23;
        return 0;
    L23:
        Long r10 = (Long) ReflectHelper.getVariable(r8, "audioBytes");     // Catch: Exception -> L37
        if (r10 == null) goto L26;
        r9 = Long.valueOf(r9.longValue() - r10.longValue());     // Catch: Exception -> L37
    L26:
        Long r11 = (Long) ReflectHelper.getVariable(r8, "videoBytes");     // Catch: Exception -> L37
        if (r11 == null) goto L29;
        r9 = Long.valueOf(r9.longValue() - r11.longValue());     // Catch: Exception -> L37
    L29:
        Long r12 = (Long) ReflectHelper.getVariable(r8, "imageBytes");     // Catch: Exception -> L37
        if (r12 == null) goto L32;
        r9 = Long.valueOf(r9.longValue() - r12.longValue());     // Catch: Exception -> L37
    L32:
        Long r13 = (Long) ReflectHelper.getVariable(r8, "appBytes");     // Catch: Exception -> L37
        if (r13 == null) goto L35;
        r9 = Long.valueOf(r9.longValue() - r13.longValue());     // Catch: Exception -> L37
    L35:
        return r9.longValue();
    L46:
        return 0;
    L37:
        e = move-exception;
        OLog.d(TAG, "getOtherFileSize exception =" + e);
        return 0;
    }

    public static void calculateMediaSize(HashMap<String, Long> mediaSize, Set<String> sMeasureMediaTypes, IMediaContainerService imcs) {
        Environment.UserEnvironment r9 = new Environment.UserEnvironment(ActivityManager.getCurrentUser());     // Catch: Exception -> L30
        Class<?> r10 = Class.forName("android.app.usage.StorageStatsManager");     // Catch: Exception -> L30
        if (r10 != null) goto L5;
        return;
    L5:
        Object r11 = SecurityCenterApplication.getApplication().getSystemService(r10);     // Catch: Exception -> L30
        if (r11 != null) goto L8;
        return;
    L8:
        StorageManager r0 = (StorageManager) SecurityCenterApplication.getApplication().getSystemService(StorageManager.class);     // Catch: Exception -> L30
        if (r0 != null) goto L11;
        return;
    L11:
        Iterator r1 = r0.getVolumes().iterator();     // Catch: Exception -> L30
    L12:
        if (r1.hasNext() == false) goto L41;
        VolumeInfo r2 = (VolumeInfo) r1.next();     // Catch: Exception -> L30
        if (r2.isPrimary() == false) goto L12;
        Object r3 = ReflectHelper.invokeMethod(r11, "queryExternalStatsForUser", new Class[]{String.class, UserHandle.class}, new Object[]{r2.fsUuid, UserHandle.SYSTEM});     // Catch: Exception -> L30
        if (r3 == null) goto L18;
        Long r4 = (Long) ReflectHelper.getVariable(r3, "imageBytes");     // Catch: Exception -> L30
        if (r4 == null) goto L22;
        mediaSize.put(Environment.DIRECTORY_PICTURES, r4);     // Catch: Exception -> L30
    L22:
        Long r5 = (Long) ReflectHelper.getVariable(r3, "videoBytes");     // Catch: Exception -> L30
        if (r5 == null) goto L25;
        mediaSize.put(Environment.DIRECTORY_MOVIES, r5);     // Catch: Exception -> L30
    L25:
        Long r6 = (Long) ReflectHelper.getVariable(r3, "audioBytes");     // Catch: Exception -> L30
        if (r6 == null) goto L28;
        mediaSize.put(Environment.DIRECTORY_MUSIC, r6);     // Catch: Exception -> L30
    L28:
        mediaSize.put(Environment.DIRECTORY_DOWNLOADS, Long.valueOf(DeviceUtils.getDirectorySize(r9.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS))));     // Catch: Exception -> L30
        goto L12
    L18:
        return;
    L41:
        return;
    L30:
        e = move-exception;
        OLog.d(TAG, "calculateMediaSize exception =" + e);
    }

    public static long getAppSize() {
        long r1 = 0;
        Context r0 = SecurityCenterApplication.getApplication().getApplicationContext();     // Catch: Exception -> L42
        Class<?> r3 = Class.forName("android.app.usage.StorageStatsManager");     // Catch: Exception -> L42
        if (r3 != null) goto L6;
        return 0;
    L6:
        Object r4 = r0.getSystemService(r3);     // Catch: Exception -> L42
        if (r4 != null) goto L9;
        return 0;
    L9:
        StorageManager r5 = (StorageManager) r0.getSystemService(StorageManager.class);     // Catch: Exception -> L42
        int r6 = 2;
        Object r2 = ReflectHelper.invokeMethod(r0.getPackageManager(), "getInstalledApplicationsAsUser", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{0, 0});     // Catch: Exception -> L42
        if (r2 != null) goto L12;
        return 0;
    L12:
        List r7 = (List) r2;     // Catch: Exception -> L42
        UserHandle r8 = UserHandle.of(0);     // Catch: Exception -> L42
        int r9 = r7.size();     // Catch: Exception -> L42
        long r10 = 0;
        int r11 = 0;
    L14:
        if (r11 >= r9) goto L62;
        ApplicationInfo r12 = (ApplicationInfo) r7.get(r11);     // Catch: Exception -> L40
        Class[] r15 = new Class[3];     // Catch: Exception -> L38
        r15[0] = String.class;     // Catch: Exception -> L38
        r15[1] = String.class;     // Catch: Exception -> L38
        r15[r6] = UserHandle.class;     // Catch: Exception -> L38
        Object[] r14 = new Object[3];     // Catch: Exception -> L38
        r14[0] = r12.volumeUuid;     // Catch: Exception -> L47
        r14[1] = r12.packageName;     // Catch: Exception -> L47
        r14[r6] = r8;     // Catch: Exception -> L47
        Object r13 = ReflectHelper.invokeMethod(r4, "queryStatsForPackage", r15, r14);     // Catch: Exception -> L47
        if (r13 == null) goto L37;
        Long r16 = (Long) ReflectHelper.invokeMethod(r13, "getDataBytes", null, null);     // Catch: Exception -> L47
        Class[] r17 = new Class[r6];     // Catch: Exception -> L47
        r17[0] = String.class;     // Catch: Exception -> L47
        r17[1] = Integer.TYPE;     // Catch: Exception -> L47
        Object[] r18 = new Object[r6];     // Catch: Exception -> L47
        r18[0] = r12.volumeUuid;     // Catch: Exception -> L47
        r18[1] = Integer.valueOf(r12.uid);     // Catch: Exception -> L47
        Long r19 = (Long) ReflectHelper.invokeMethod(r4, "getCacheQuotaBytes", r17, r18);     // Catch: Exception -> L47
        Long r110 = (Long) ReflectHelper.invokeMethod(r13, "getCacheBytes", null, null);     // Catch: Exception -> L47
        Long r20 = (Long) ReflectHelper.invokeMethod(r13, "getAppBytes", null, null);     // Catch: Exception -> L47
        if (r16 == null) goto L37;
        long r111 = r16.longValue();     // Catch: Exception -> L47
        if (r19 != null) goto L27;
        long r112 = 0;
        r19 = 0L;     // Catch: Exception -> L46
    L28:
        if (r110 != null) goto L30;
        r110 = Long.valueOf(r112);     // Catch: Exception -> L46
    L30:
        if (r20 != null) goto L33;
        r20 = Long.valueOf(r112);     // Catch: Exception -> L46
    L33:
        if (r19.longValue() >= r110.longValue()) goto L36;
        r111 = (r111 - r110.longValue()) + r19.longValue();     // Catch: Exception -> L46
    L36:
        r10 = r10 + (r111 + r20.longValue());
    L39:
        r11 = r11 + 1;
        r1 = r112;
        r6 = 2;
        goto L14
    L27:
        r112 = 0;
    L37:
        r112 = 0;
    L38:
        r112 = r1;
    L40:
        e = e;
        r1 = r10;
    L44:
        OLog.d(TAG, "getAppSize exception =" + e);
        return r1;
    L62:
        return r10;
    L42:
        e = e;
        goto L44
    }

    public static long getSDAvailableSize() {
        return new StatFs(Environment.getExternalStorageDirectory().getPath()).getAvailableBytes();
    }
}
