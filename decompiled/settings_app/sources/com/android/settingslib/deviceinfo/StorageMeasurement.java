package com.android.settingslib.deviceinfo;

import android.app.usage.ExternalStorageStats;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.pm.UserInfo;
import android.icu.text.DateFormat;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.VolumeInfo;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseLongArray;
import com.GlobalProxyLancet;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StorageMeasurement {
    private static final String TAG = "StorageMeasurement";
    private final Context mContext;
    private WeakReference<MeasurementReceiver> mReceiver;
    private final VolumeInfo mSharedVolume;
    private final StorageStatsManager mStats;
    private final UserManager mUser;
    private final VolumeInfo mVolume;

    /* JADX INFO: renamed from: com.android.settingslib.deviceinfo.StorageMeasurement$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class MeasureTask extends AsyncTask<Void, Void, MeasurementDetails> {
        final /* synthetic */ StorageMeasurement this$0;

        private MeasureTask(StorageMeasurement r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MeasureTask(StorageMeasurement r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ MeasurementDetails doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(MeasurementDetails r1) {
            onPostExecute2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected MeasurementDetails doInBackground2(Void... r1) {
            return StorageMeasurement.access$100(this.this$0);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(MeasurementDetails r2) {
            if (StorageMeasurement.access$200(this.this$0) == null) goto L5;
            MeasurementReceiver r1 = (MeasurementReceiver) StorageMeasurement.access$200(this.this$0).get();
        L6:
            if (r1 == null) goto L9;
            r1.onDetailsChanged(r2);
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static class MeasurementDetails {
        public SparseLongArray appsSize;
        public long availSize;
        public long cacheSize;
        public SparseArray<HashMap<String, Long>> mediaSize;
        public SparseLongArray miscSize;
        public long totalSize;
        public SparseLongArray usersSize;

        public MeasurementDetails() {
            this.usersSize = new SparseLongArray();
            this.appsSize = new SparseLongArray();
            this.mediaSize = new SparseArray();
            this.miscSize = new SparseLongArray();
        }

        public String toString() {
            return "MeasurementDetails: [totalSize: " + this.totalSize + " availSize: " + this.availSize + " cacheSize: " + this.cacheSize + " mediaSize: " + this.mediaSize + " miscSize: " + this.miscSize + "usersSize: " + this.usersSize + "]";
        }
    }

    public interface MeasurementReceiver {
        void onDetailsChanged(MeasurementDetails r1);
    }

    static /* synthetic */ MeasurementDetails access$100(StorageMeasurement r0) {
        return r0.measureExactStorage();
    }

    static /* synthetic */ WeakReference access$200(StorageMeasurement r0) {
        return r0.mReceiver;
    }

    public StorageMeasurement(Context r2, VolumeInfo r3, VolumeInfo r4) {
        Context r5 = r2.getApplicationContext();
        this.mContext = r5;
        this.mUser = (UserManager) r5.getSystemService(UserManager.class);
        this.mStats = (StorageStatsManager) r5.getSystemService(StorageStatsManager.class);
        this.mVolume = r3;
        this.mSharedVolume = r4;
    }

    public void setReceiver(MeasurementReceiver r2) {
        WeakReference<MeasurementReceiver> r0 = this.mReceiver;
        if (r0 != null) goto L5;
    L6:
        this.mReceiver = new WeakReference(r2);
        return;
    L5:
        if (r0.get() == null) goto L6;
    }

    public void forceMeasure() {
        measure();
    }

    public void measure() {
        new MeasureTask(this, null).execute(new Void[0]);
    }

    public void onDestroy() {
        this.mReceiver = null;
    }

    private MeasurementDetails measureExactStorage() {
        List r1 = this.mUser.getUsers();
        long r2 = SystemClock.elapsedRealtime();
        MeasurementDetails r4 = new MeasurementDetails();
        VolumeInfo r5 = this.mVolume;
        if (r5 != null) goto L6;
        return r4;
    L6:
        if (r5.getType() != 0) goto L8;
    L43:
        r4.totalSize = this.mVolume.getPath().getTotalSpace();
        r4.availSize = this.mVolume.getPath().getUsableSpace();
        return r4;
    L8:
        if (this.mVolume.getType() == 5) goto L43;
        r4.totalSize = this.mStats.getTotalBytes(this.mVolume.fsUuid);     // Catch: IOException -> L40
        r4.availSize = this.mStats.getFreeBytes(this.mVolume.fsUuid);     // Catch: IOException -> L40
        long r6 = SystemClock.elapsedRealtime();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Measured total storage in " + (r6 - r2) + DateFormat.MINUTE_SECOND);
        VolumeInfo r3 = this.mSharedVolume;
        if (r3 != null) goto L14;
    L23:
        long r7 = SystemClock.elapsedRealtime();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Measured shared storage in " + (r7 - r6) + DateFormat.MINUTE_SECOND);
        if (this.mVolume.getType() == 1) goto L26;
    L38:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Measured private storage in " + (SystemClock.elapsedRealtime() - r7) + DateFormat.MINUTE_SECOND);
        return r4;
    L26:
        if (this.mVolume.isMountedReadable() == false) goto L38;
        Iterator r8 = r1.iterator();
    L29:
        if (r8.hasNext() == false) goto L38;
        UserInfo r9 = (UserInfo) r8.next();
        StorageStats r10 = this.mStats.queryStatsForUser(this.mVolume.fsUuid, UserHandle.of(r9.id));     // Catch: IOException -> L36
        if (r9.id != UserHandle.myUserId()) goto L35;
        addValue(r4.usersSize, r9.id, r10.getAppBytes());
    L35:
        addValue(r4.usersSize, r9.id, r10.getDataBytes());
        addValue(r4.appsSize, r9.id, r10.getAppBytes() + r10.getDataBytes());
        r4.cacheSize += r10.getCacheBytes();
    L36:
        e = move-exception;
        Log.w(TAG, e);
        goto L29
    L14:
        if (r3.isMountedReadable() == false) goto L23;
        Iterator r11 = r1.iterator();
    L17:
        if (r11.hasNext() == false) goto L23;
        UserInfo r12 = (UserInfo) r11.next();
        HashMap<String, Long> r13 = new HashMap();
        r4.mediaSize.put(r12.id, r13);
        ExternalStorageStats r14 = this.mStats.queryExternalStatsForUser(this.mSharedVolume.fsUuid, UserHandle.of(r12.id));     // Catch: IOException -> L21
        addValue(r4.usersSize, r12.id, r14.getTotalBytes());
        r13.put(Environment.DIRECTORY_MUSIC, Long.valueOf(r14.getAudioBytes()));
        r13.put(Environment.DIRECTORY_MOVIES, Long.valueOf(r14.getVideoBytes()));
        r13.put(Environment.DIRECTORY_PICTURES, Long.valueOf(r14.getImageBytes()));
        addValue(r4.miscSize, r12.id, ((r14.getTotalBytes() - r14.getAudioBytes()) - r14.getVideoBytes()) - r14.getImageBytes());
    L21:
        e = move-exception;
        Log.w(TAG, e);
    L40:
        e = move-exception;
        Log.w(TAG, e);
        return r4;
    }

    private static void addValue(SparseLongArray r2, int r3, long r4) {
        r2.put(r3, r2.get(r3) + r4);
    }
}
