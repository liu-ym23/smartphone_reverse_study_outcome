package com.bytedanceos.securitycenter.memory;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.google.gson.annotations.SerializedName;
import com.obric.olog.OLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class StorageDistributionCollector {
    private static final String TAG = "StorageCollector";

    public static class StorageData {

        @SerializedName("app_bytes")
        public long appBytes;

        @SerializedName("audio_bytes")
        public long audioBytes;

        @SerializedName("avail_bytes")
        public long availBytes;

        @SerializedName("download_bytes")
        public long downloadBytes;

        @SerializedName("image_bytes")
        public long imageBytes;

        @SerializedName("other_file_bytes")
        public long otherFileBytes;

        @SerializedName("system_bytes")
        public long systemBytes;

        @SerializedName("total_bytes")
        public long totalBytes;

        @SerializedName("used_bytes")
        public long usedBytes;

        @SerializedName("video_bytes")
        public long videoBytes;

        public StorageData() {
        }

        public String toString() {
            return "StorageData{total=" + this.totalBytes + ", used=" + this.usedBytes + ", app=" + this.appBytes + ", system=" + this.systemBytes + '}';
        }
    }

    public StorageDistributionCollector() {
    }

    public static StorageData collect(Context context) {
        StorageData r6 = new StorageData();
        StatFs r1 = new StatFs(Environment.getDataDirectory().getPath());
        r6.totalBytes = r1.getTotalBytes();
        r6.availBytes = r1.getAvailableBytes();
        r6.usedBytes = r6.totalBytes - r6.availBytes;
        r6.appBytes = MultiSdkAdapter.getAppSize();     // Catch: Exception -> L10
        HashMap r0 = new HashMap();     // Catch: Exception -> L10
        MultiSdkAdapter.calculateMediaSize(r0, null, null);     // Catch: Exception -> L10
        r6.imageBytes = getSafe(r0, Environment.DIRECTORY_PICTURES);     // Catch: Exception -> L10
        r6.videoBytes = getSafe(r0, Environment.DIRECTORY_MOVIES);     // Catch: Exception -> L10
        r6.audioBytes = getSafe(r0, Environment.DIRECTORY_MUSIC);     // Catch: Exception -> L10
        r6.downloadBytes = getSafe(r0, Environment.DIRECTORY_DOWNLOADS);     // Catch: Exception -> L10
        r6.otherFileBytes = MultiSdkAdapter.getOtherFileSize() - r6.downloadBytes;     // Catch: Exception -> L10
        if (r6.otherFileBytes >= 0) goto L6;
        r6.otherFileBytes = 0;     // Catch: Exception -> L10
    L6:
        long r2 = ((((r6.appBytes + r6.imageBytes) + r6.videoBytes) + r6.audioBytes) + r6.downloadBytes) + r6.otherFileBytes;     // Catch: Exception -> L10
        r6.systemBytes = r6.usedBytes - r2;     // Catch: Exception -> L10
        if (r6.systemBytes >= 0) goto L12;
        r6.systemBytes = 0;     // Catch: Exception -> L10
    L12:
        return r6;
    L10:
        e = move-exception;
        OLog.e(TAG, "Error collecting detailed storage info", e);
        goto L12
    }

    private static long getSafe(Map<String, Long> map, String key) {
        Long r0 = map.get(key);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.longValue();
    }
}
