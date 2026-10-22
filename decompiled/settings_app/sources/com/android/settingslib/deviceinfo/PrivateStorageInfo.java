package com.android.settingslib.deviceinfo;

import android.app.AppGlobals;
import android.app.usage.StorageStatsManager;
import android.os.storage.VolumeInfo;
import android.util.Log;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class PrivateStorageInfo {
    private static final String TAG = "PrivateStorageInfo";
    public final long freeBytes;
    public final long totalBytes;

    public PrivateStorageInfo(long r1, long r3) {
        this.freeBytes = r1;
        this.totalBytes = r3;
    }

    public static PrivateStorageInfo getPrivateStorageInfo(StorageVolumeProvider r9) {
        StorageStatsManager r0 = (StorageStatsManager) AppGlobals.getInitialApplication().getSystemService(StorageStatsManager.class);
        Iterator<VolumeInfo> r1 = r9.getVolumes().iterator();
        long r2 = 0;
        long r4 = 0;
    L4:
        if (r1.hasNext() == false) goto L14;
        VolumeInfo r6 = r1.next();
        if (r6.getType() != 1) goto L4;
        if (r6.isMountedReadable() == false) goto L4;
        r4 = r4 + r9.getTotalBytes(r0, r6);     // Catch: IOException -> L11
        r2 = r2 + r9.getFreeBytes(r0, r6);
    L11:
        e = move-exception;
        Log.w(TAG, e);
        goto L4
    L14:
        return new PrivateStorageInfo(r2, r4);
    }

    public static long getTotalSize(VolumeInfo r0, long r1) {
        StorageStatsManager r2 = (StorageStatsManager) AppGlobals.getInitialApplication().getSystemService(StorageStatsManager.class);
        return r2.getTotalBytes(r0.getFsUuid());
    L5:
        e = move-exception;
        Log.w(TAG, e);
        return 0;
    }
}
