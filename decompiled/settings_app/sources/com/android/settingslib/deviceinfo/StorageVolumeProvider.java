package com.android.settingslib.deviceinfo;

import android.app.usage.StorageStatsManager;
import android.os.storage.VolumeInfo;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface StorageVolumeProvider {
    VolumeInfo findEmulatedForPrivate(VolumeInfo r1);

    long getFreeBytes(StorageStatsManager r1, VolumeInfo r2) throws IOException;

    long getPrimaryStorageSize();

    long getTotalBytes(StorageStatsManager r1, VolumeInfo r2) throws IOException;

    List<VolumeInfo> getVolumes();
}
