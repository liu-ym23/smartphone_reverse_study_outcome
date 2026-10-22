package com.android.settingslib.deviceinfo;

import android.app.usage.StorageStatsManager;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StorageManagerVolumeProvider implements StorageVolumeProvider {
    private StorageManager mStorageManager;

    public StorageManagerVolumeProvider(StorageManager r1) {
        this.mStorageManager = r1;
    }

    @Override // com.android.settingslib.deviceinfo.StorageVolumeProvider
    public long getPrimaryStorageSize() {
        return this.mStorageManager.getPrimaryStorageSize();
    }

    @Override // com.android.settingslib.deviceinfo.StorageVolumeProvider
    public List<VolumeInfo> getVolumes() {
        return this.mStorageManager.getVolumes();
    }

    @Override // com.android.settingslib.deviceinfo.StorageVolumeProvider
    public VolumeInfo findEmulatedForPrivate(VolumeInfo r1) {
        return this.mStorageManager.findEmulatedForPrivate(r1);
    }

    @Override // com.android.settingslib.deviceinfo.StorageVolumeProvider
    public long getTotalBytes(StorageStatsManager r1, VolumeInfo r2) throws IOException {
        return r1.getTotalBytes(r2.getFsUuid());
    }

    @Override // com.android.settingslib.deviceinfo.StorageVolumeProvider
    public long getFreeBytes(StorageStatsManager r1, VolumeInfo r2) throws IOException {
        return r1.getFreeBytes(r2.getFsUuid());
    }
}
