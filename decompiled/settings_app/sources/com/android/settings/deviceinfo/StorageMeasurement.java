package com.android.settings.deviceinfo;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageStats;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.StorageVolume;
import android.provider.MediaStore;
import android.text.format.Formatter;
import android.util.Log;
import android.util.SparseLongArray;
import bytedanceos.api.StorageManagerSmt;
import com.android.internal.app.IMediaContainerService;
import com.android.settings.ExecutorManager;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.SettingsFeature;
import com.android.settings.applications.PickApplicationActivity;
import com.google.android.collect.Maps;
import com.google.android.collect.Sets;
import com.obric.olog.OLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class StorageMeasurement {
    public static final ComponentName DEFAULT_CONTAINER_COMPONENT = null;
    private static final String DEFAULT_CONTAINER_PACKAGE = "com.android.defcontainer";
    private static final boolean LOCAL_LOGV = true;
    static final boolean LOGV = false;
    private static final String TAG = "StorageMeasurement";
    private static HashMap<StorageVolume, StorageMeasurement> sInstances;
    private static final Set<String> sMeasureMediaTypes = null;
    private long mAvailSize;
    List<FileInfo> mFileInfoForMisc;
    private final MeasurementHandler mHandler;
    private final boolean mIsInternal;
    private final boolean mIsPrimary;
    private long mOtherFileSize;
    private volatile WeakReference<MeasurementReceiver> mReceiver;
    private long mSystemSize;
    private long mTotalSize;
    private final StorageVolume mVolume;

    public static class DeviceStorageInfo {
        public long availableSize;
        public long otherFileSize;
        public long systemSize;
        public long totalSize;

        public DeviceStorageInfo() {
        }
    }

    static class FileInfo implements Comparable<FileInfo> {
        final String mFileName;
        final long mId;
        final long mSize;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(FileInfo r1) {
            return compareTo2(r1);
        }

        FileInfo(String r1, long r2, long r4) {
            this.mFileName = r1;
            this.mSize = r2;
            this.mId = r4;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(FileInfo r4) {
            if (this == r4) goto L11;
            long r0 = this.mSize;
            long r3 = r4.mSize;
            if (r0 != r3) goto L7;
            return 0;
        L7:
            if (r0 >= r3) goto L9;
            return 1;
        L9:
            return -1;
        L11:
            return 0;
        }

        public String toString() {
            return this.mFileName + " : " + this.mSize + ", id:" + this.mId;
        }
    }

    public static class MeasurementDetails {
        public long appsSize;
        public long audioSizeSumInDb;
        public long availSize;
        public HashMap<String, Long> mediaSize;
        public long miscSize;
        public long otherFileSize;
        public long systemSize;
        public long totalSize;

        public MeasurementDetails() {
            this.mediaSize = Maps.newHashMap();
        }
    }

    private class MeasurementHandler extends Handler {
        public static final int MSG_APP = 6;
        public static final int MSG_COMPLETED = 4;
        public static final int MSG_CONNECTED = 2;
        public static final int MSG_DISCONNECT = 3;
        public static final int MSG_INVALIDATE = 5;
        public static final int MSG_MEASURE = 1;
        private volatile boolean mBound;
        private MeasurementDetails mCached;
        private final WeakReference<Context> mContext;
        private final ServiceConnection mDefContainerConn;
        private IMediaContainerService mDefaultContainer;
        private Object mLock;
        final /* synthetic */ StorageMeasurement this$0;

        static /* synthetic */ IMediaContainerService access$002(MeasurementHandler r0, IMediaContainerService r1) {
            r0.mDefaultContainer = r1;
            return r1;
        }

        static /* synthetic */ boolean access$102(MeasurementHandler r0, boolean r1) {
            r0.mBound = r1;
            return r1;
        }

        public MeasurementHandler(StorageMeasurement r1, Context r2, Looper r3) {
            this.this$0 = r1;
            super(r3);
            this.mLock = new Object();
            this.mBound = false;
            this.mDefContainerConn = new AnonymousClass1(this);
            this.mContext = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            Context r1 = null;
            switch(r5.what) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L6;
                case 6: goto L5;
                default: goto L54;
            };
        L5:
            MeasurementDetails r6 = (MeasurementDetails) r5.obj;
            this.mCached = r6;
            StorageMeasurement.access$300(this.this$0, r6);
            return;
        L6:
            this.mCached = null;
            return;
        L7:
            MeasurementDetails r7 = (MeasurementDetails) r5.obj;
            this.mCached = r7;
            StorageMeasurement.access$200(this.this$0, r7);
            return;
        L8:
            Object r0 = this.mLock;
            monitor-enter(r0);
        L21:
            th = move-exception;
            throw th;
        L11:
            if (this.mBound == false) goto L19;
            WeakReference<Context> r8 = this.mContext;     // Catch: Throwable -> L21
            if (r8 == null) goto L15;
            r1 = r8.get();     // Catch: Throwable -> L21
        L15:
            if (r1 != null) goto L18;
            monitor-exit(r0);     // Catch: Throwable -> L21
            return;
        L18:
            this.mBound = false;     // Catch: Throwable -> L21
            r1.unbindService(this.mDefContainerConn);     // Catch: Throwable -> L21
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L21
            return;
        L24:
            IMediaContainerService r9 = (IMediaContainerService) r5.obj;
            measureApproximateStorage(r9);
            measureExactStorage(r9);
            return;
        L25:
            MeasurementDetails r10 = this.mCached;
            if (r10 == null) goto L28;
            StorageMeasurement.access$200(this.this$0, r10);
            return;
        L28:
            WeakReference<Context> r11 = this.mContext;
            if (r11 == null) goto L31;
            r1 = r11.get();
        L31:
            if (r1 != null) goto L33;
            return;
        L33:
            Object r12 = this.mLock;
            monitor-enter(r12);
        L41:
            th = move-exception;
            throw th;
        L36:
            if (this.mBound == false) goto L38;
            removeMessages(3);     // Catch: Throwable -> L41
            sendMessage(obtainMessage(2, this.mDefaultContainer));     // Catch: Throwable -> L41
        L39:
            monitor-exit(r12);     // Catch: Throwable -> L41
            return;
        L38:
            r1.bindServiceAsUser(new Intent().setComponent(StorageMeasurement.DEFAULT_CONTAINER_COMPONENT), this.mDefContainerConn, 1, UserHandle.OWNER);     // Catch: Throwable -> L41
            goto L39
        }

        private void measureApproximateStorage(IMediaContainerService r4) {
            if (StorageMeasurement.access$400(this.this$0) == null) goto L5;
            String r0 = StorageMeasurement.access$400(this.this$0).getPath();
        L6:
            DeviceStorageInfo r5 = MultiSDKAdapter.getDeviceStorageInfo(r4, r0);
            StorageMeasurement.access$502(this.this$0, r5.totalSize);
            StorageMeasurement.access$602(this.this$0, r5.availableSize);
            StorageMeasurement.access$702(this.this$0, r5.systemSize);
            StorageMeasurement.access$802(this.this$0, MultiSDKAdapter.getOtherFileSize());
            StorageMeasurement.access$900(this.this$0);
            return;
        L5:
            r0 = Environment.getDataDirectory().getPath();
            goto L6
        }

        private void measureExactStorage(final IMediaContainerService r6) {
            WeakReference<Context> r0 = this.mContext;
            if (r0 == null) goto L5;
            final Context r1 = r0.get();
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            final MeasurementDetails r2 = new MeasurementDetails();
            Message r3 = obtainMessage(6, r2);
            r2.totalSize = StorageMeasurement.access$500(this.this$0);
            r2.availSize = StorageMeasurement.access$600(this.this$0);
            r2.systemSize = StorageMeasurement.access$700(this.this$0);
            r2.otherFileSize = StorageMeasurement.access$800(this.this$0);
            ((UserManager) r1.getSystemService(PickApplicationActivity.EXTRA_USER)).getUsers();
            ActivityManager.getCurrentUser();
            AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            if (StorageMeasurement.access$1000(this.this$0) == false) goto L13;
            if (Environment.isExternalStorageEmulated() == false) goto L13;
        L14:
            boolean r4 = true;
        L16:
            if (r4 == false) goto L18;
            AsyncTask.execute(new AnonymousClass2(this, r2, r6));
        L18:
            AsyncTask.execute(new AnonymousClass3(this, r2, r1));
            r1.getPackageManager();
            if (StorageMeasurement.access$1000(this.this$0) == false) goto L21;
        L24:
            ExecutorManager.execute(new AnonymousClass4(this, r2));
            return;
        L21:
            if (StorageMeasurement.access$1100(this.this$0) == true) goto L24;
            r3.sendToTarget();
            return;
        L13:
            if (StorageMeasurement.access$1100(this.this$0) == true) goto L14;
            r4 = false;
            goto L16
        L5:
            r1 = null;
            goto L6
        }
    }

    public interface MeasurementReceiver {
        void updateAppSize(StorageMeasurement r1, MeasurementDetails r2);

        void updateApproximate(StorageMeasurement r1, long r2, long r4);

        void updateAudioSize(StorageMeasurement r1, MeasurementDetails r2);

        void updateDetails(StorageMeasurement r1, MeasurementDetails r2);

        void updateMediaSize(StorageMeasurement r1, MeasurementDetails r2);

        void updateUserSize(StorageMeasurement r1, MeasurementDetails r2);
    }

    private static class StatsObserver extends MultiSDKAdapter.PackageStatsObserverEx {
        private final int mCurrentUser;
        private final MeasurementDetails mDetails;
        private final Message mFinished;
        private final boolean mIsInternal;
        private int mRemaining;

        public StatsObserver(boolean r1, MeasurementDetails r2, int r3, Message r4, int r5) {
            this.mIsInternal = r1;
            this.mDetails = r2;
            this.mCurrentUser = r3;
            this.mFinished = r4;
            this.mRemaining = r5;
        }

        @Override // com.android.settings.MultiSDKAdapter.PackageStatsObserverEx
        public void onGetStatsCompleted(PackageStats r2, boolean r3) {
            MeasurementDetails r0 = this.mDetails;
            monitor-enter(r0);
            if (r3 == true) goto L14;
        L6:
            int r4 = this.mRemaining - 1;     // Catch: Throwable -> L11
            this.mRemaining = r4;     // Catch: Throwable -> L11
            if (r4 != 0) goto L9;
            this.mFinished.sendToTarget();     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        L14:
            addStatsLocked(r2);     // Catch: Throwable -> L11
            goto L6
        }

        private void addStatsLocked(PackageStats r11) {
            if (this.mIsInternal == false) goto L11;
            long r0 = r11.codeSize;
            long r2 = r11.dataSize;
            long r4 = r11.cacheSize;
            if (Environment.isExternalStorageEmulated() == false) goto L8;
            r0 = r0 + (r11.externalCodeSize + r11.externalObbSize);
            r2 = r2 + (r11.externalDataSize + r11.externalMediaSize);
            r4 = r4 + r11.externalCacheSize;
        L8:
            if (r11.userHandle != this.mCurrentUser) goto L10;
            this.mDetails.appsSize += r0;
            this.mDetails.appsSize += r2;
        L10:
            this.mDetails.appsSize += r4;
            return;
        L11:
            this.mDetails.appsSize += (((r11.externalCodeSize + r11.externalDataSize) + r11.externalMediaSize) + r11.externalObbSize) + r11.externalCacheSize;
        }
    }

    static /* synthetic */ boolean access$1000(StorageMeasurement r0) {
        return r0.mIsInternal;
    }

    static /* synthetic */ boolean access$1100(StorageMeasurement r0) {
        return r0.mIsPrimary;
    }

    static /* synthetic */ Set access$1200() {
        return sMeasureMediaTypes;
    }

    static /* synthetic */ void access$1300(StorageMeasurement r0, MeasurementDetails r1) {
        r0.sendMediaUpdate(r1);
    }

    static /* synthetic */ void access$1400(StorageMeasurement r0, MeasurementDetails r1) {
        r0.sendUserUpdate(r1);
    }

    static /* synthetic */ long access$1500(StorageMeasurement r0, Context r1) {
        return r0.measureSumSizeOfAudio(r1);
    }

    static /* synthetic */ void access$1600(StorageMeasurement r0, MeasurementDetails r1) {
        r0.sendAudioUpdate(r1);
    }

    static /* synthetic */ void access$200(StorageMeasurement r0, MeasurementDetails r1) {
        r0.sendExactUpdate(r1);
    }

    static /* synthetic */ void access$300(StorageMeasurement r0, MeasurementDetails r1) {
        r0.sendAppUpdate(r1);
    }

    static /* synthetic */ StorageVolume access$400(StorageMeasurement r0) {
        return r0.mVolume;
    }

    static /* synthetic */ long access$500(StorageMeasurement r2) {
        return r2.mTotalSize;
    }

    static /* synthetic */ long access$502(StorageMeasurement r0, long r1) {
        r0.mTotalSize = r1;
        return r1;
    }

    static /* synthetic */ long access$600(StorageMeasurement r2) {
        return r2.mAvailSize;
    }

    static /* synthetic */ long access$602(StorageMeasurement r0, long r1) {
        r0.mAvailSize = r1;
        return r1;
    }

    static /* synthetic */ long access$700(StorageMeasurement r2) {
        return r2.mSystemSize;
    }

    static /* synthetic */ long access$702(StorageMeasurement r0, long r1) {
        r0.mSystemSize = r1;
        return r1;
    }

    static /* synthetic */ long access$800(StorageMeasurement r2) {
        return r2.mOtherFileSize;
    }

    static /* synthetic */ long access$802(StorageMeasurement r0, long r1) {
        r0.mOtherFileSize = r1;
        return r1;
    }

    static /* synthetic */ void access$900(StorageMeasurement r0) {
        r0.sendInternalApproximateUpdate();
    }

    static {
        LOGV = Log.isLoggable(TAG, 2);
        DEFAULT_CONTAINER_COMPONENT = new ComponentName(DEFAULT_CONTAINER_PACKAGE, "com.android.defcontainer.DefaultContainerService");
        sMeasureMediaTypes = Sets.newHashSet(new String[]{Environment.DIRECTORY_DCIM, Environment.DIRECTORY_MOVIES, Environment.DIRECTORY_PICTURES, Environment.DIRECTORY_MUSIC, Environment.DIRECTORY_ALARMS, Environment.DIRECTORY_NOTIFICATIONS, Environment.DIRECTORY_RINGTONES, Environment.DIRECTORY_PODCASTS, Environment.DIRECTORY_DOWNLOADS, "Android"});
        sInstances = Maps.newHashMap();
    }

    public static StorageMeasurement getInstance(Context r2, StorageVolume r3) {
        HashMap<StorageVolume, StorageMeasurement> r0 = sInstances;
        monitor-enter(r0);
        StorageMeasurement r1 = sInstances.get(r3);     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        r1 = new StorageMeasurement(r2.getApplicationContext(), r3);     // Catch: Throwable -> L9
        sInstances.put(r3, r1);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    private StorageMeasurement(Context r3, StorageVolume r4) {
        this.mVolume = r4;
        boolean r0 = false;
        if (r4 != null) goto L5;
        boolean r1 = true;
    L6:
        this.mIsInternal = r1;
        if (r4 == null) goto L9;
        r0 = r4.isPrimary();
    L9:
        this.mIsPrimary = r0;
        HandlerThread r5 = new HandlerThread("MemoryMeasurement");
        r5.start();
        this.mHandler = new MeasurementHandler(this, r3, r5.getLooper());
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void setReceiver(MeasurementReceiver r2) {
        if (this.mReceiver != null) goto L5;
    L6:
        this.mReceiver = new WeakReference(r2);
        return;
    L5:
        if (this.mReceiver.get() == null) goto L6;
    }

    public void measure() {
        if (this.mHandler.hasMessages(1) == true) goto L6;
        this.mHandler.sendEmptyMessage(1);
        return;
    }

    public void cleanUp() {
        this.mReceiver = null;
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(3);
    }

    public void invalidate() {
        this.mHandler.sendEmptyMessage(5);
    }

    private void sendInternalApproximateUpdate() {
        if (this.mReceiver == null) goto L5;
        MeasurementReceiver r0 = this.mReceiver.get();
    L6:
        MeasurementReceiver r1 = r0;
        if (r1 != null) goto L9;
        return;
    L9:
        r1.updateApproximate(this, this.mTotalSize, this.mAvailSize);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void sendExactUpdate(MeasurementDetails r2) {
        if (this.mReceiver == null) goto L5;
        MeasurementReceiver r0 = this.mReceiver.get();
    L6:
        if (r0 == null) goto L8;
        r0.updateDetails(this, r2);
        return;
    L8:
        if (LOGV == false) goto L13;
        OLog.i(TAG, "measurements dropped because receiver is null! wasted effort");
        return;
    L13:
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void sendMediaUpdate(MeasurementDetails r2) {
        if (this.mReceiver == null) goto L5;
        MeasurementReceiver r0 = this.mReceiver.get();
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        r0.updateMediaSize(this, r2);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void sendUserUpdate(MeasurementDetails r2) {
        if (this.mReceiver == null) goto L5;
        MeasurementReceiver r0 = this.mReceiver.get();
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        r0.updateUserSize(this, r2);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void sendAudioUpdate(MeasurementDetails r2) {
        if (this.mReceiver == null) goto L5;
        MeasurementReceiver r0 = this.mReceiver.get();
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        r0.updateAudioSize(this, r2);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void sendAppUpdate(MeasurementDetails r2) {
        if (this.mReceiver == null) goto L5;
        MeasurementReceiver r0 = this.mReceiver.get();
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        r0.updateAppSize(this, r2);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private long measureSumSizeOfAudio(Context r7) {
        Cursor r6 = r7.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_size"}, null, null, null);
        boolean r0 = SettingsFeature.isSdMounted();
        long r1 = 0;
        if (r6 != null) goto L5;
    L16:
        OLog.d(TAG, "audio sum:" + Formatter.formatFileSize(r7, r1).replace('k', 'K'));
        return r1;
    L5:
        if (r6.moveToFirst() == false) goto L15;
    L6:
        if (r0 == false) goto L12;
        String r3 = r6.getString(0);
        String r4 = StorageManagerSmt.getExternalSdcardPath();
        if (r3 == null) goto L12;
        if (r3.startsWith(r4) == false) goto L12;
    L14:
        if (r6.moveToNext() == true) goto L6;
    L12:
        r1 = r1 + r6.getLong(1);
    L15:
        r6.close();
        goto L16
    }

    private static void addValue(SparseLongArray r2, int r3, long r4) {
        r2.put(r3, r2.get(r3) + r4);
    }
}
