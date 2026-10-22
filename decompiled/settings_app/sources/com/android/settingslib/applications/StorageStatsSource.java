package com.android.settingslib.applications;

import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class StorageStatsSource {
    private StorageStatsManager mStorageStatsManager;

    public interface AppStorageStats {
        long getCacheBytes();

        long getCodeBytes();

        long getDataBytes();

        long getTotalBytes();
    }

    public static class AppStorageStatsImpl implements AppStorageStats {
        private StorageStats mStats;

        public AppStorageStatsImpl(StorageStats r1) {
            this.mStats = r1;
        }

        @Override // com.android.settingslib.applications.StorageStatsSource.AppStorageStats
        public long getCodeBytes() {
            return this.mStats.getAppBytes();
        }

        @Override // com.android.settingslib.applications.StorageStatsSource.AppStorageStats
        public long getDataBytes() {
            return this.mStats.getDataBytes();
        }

        @Override // com.android.settingslib.applications.StorageStatsSource.AppStorageStats
        public long getCacheBytes() {
            return this.mStats.getCacheBytes();
        }

        @Override // com.android.settingslib.applications.StorageStatsSource.AppStorageStats
        public long getTotalBytes() {
            return this.mStats.getAppBytes() + this.mStats.getDataBytes();
        }
    }

    public static class ExternalStorageStats {
        public long appBytes;
        public long audioBytes;
        public long imageBytes;
        public long totalBytes;
        public long videoBytes;

        public ExternalStorageStats(long r1, long r3, long r5, long r7, long r9) {
            this.totalBytes = r1;
            this.audioBytes = r3;
            this.videoBytes = r5;
            this.imageBytes = r7;
            this.appBytes = r9;
        }

        public ExternalStorageStats(android.app.usage.ExternalStorageStats r3) {
            this.totalBytes = r3.getTotalBytes();
            this.audioBytes = r3.getAudioBytes();
            this.videoBytes = r3.getVideoBytes();
            this.imageBytes = r3.getImageBytes();
            this.appBytes = r3.getAppBytes();
        }
    }

    public StorageStatsSource(Context r2) {
        this.mStorageStatsManager = (StorageStatsManager) r2.getSystemService(StorageStatsManager.class);
    }

    public ExternalStorageStats getExternalStorageStats(String r2, UserHandle r3) throws IOException {
        return new ExternalStorageStats(this.mStorageStatsManager.queryExternalStatsForUser(r2, r3));
    }

    public AppStorageStats getStatsForUid(String r2, int r3) throws IOException {
        return new AppStorageStatsImpl(this.mStorageStatsManager.queryStatsForUid(r2, r3));
    }

    public AppStorageStats getStatsForPackage(String r2, String r3, UserHandle r4) throws PackageManager.NameNotFoundException, IOException {
        return new AppStorageStatsImpl(this.mStorageStatsManager.queryStatsForPackage(r2, r3, r4));
    }

    public long getCacheQuotaBytes(String r1, int r2) {
        return this.mStorageStatsManager.getCacheQuotaBytes(r1, r2);
    }

    public long getTotalBytes(UUID r1) throws IOException {
        return this.mStorageStatsManager.getTotalBytes(r1);
    }
}
