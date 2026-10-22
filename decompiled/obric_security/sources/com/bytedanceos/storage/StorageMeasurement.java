package com.bytedanceos.storage;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.content.pm.UserInfo;
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
import bytedanceos.util.LogTag;
import com.android.internal.app.IMediaContainerService;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.google.android.collect.Maps;
import com.google.android.collect.Sets;
import com.obric.olog.OLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
    private MeasurementHandler mHandler;
    private final boolean mIsInternal;
    private final boolean mIsPrimary;
    private boolean mMeasureDetail;
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
        public /* bridge */ /* synthetic */ int compareTo(FileInfo that) {
            return compareTo2(that);
        }

        FileInfo(String fileName, long size, long id) {
            this.mFileName = fileName;
            this.mSize = size;
            this.mId = id;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(FileInfo that) {
            if (this == that) goto L11;
            long r0 = this.mSize;
            long r3 = that.mSize;
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

        public MeasurementHandler(final StorageMeasurement this$0, Context context, Looper looper) {
            this.this$0 = this$0;
            super(looper);
            this.mLock = new Object();
            this.mBound = false;
            this.mDefContainerConn = new AnonymousClass1(this);
            this.mContext = new WeakReference(context);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Context r1 = null;
            switch(msg.what) {
                case 1: goto L27;
                case 2: goto L24;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L6;
                case 6: goto L5;
                default: goto L62;
            };
        L5:
            MeasurementDetails r5 = (MeasurementDetails) msg.obj;
            this.mCached = r5;
            StorageMeasurement.access$400(this.this$0, r5);
            return;
        L6:
            this.mCached = null;
            return;
        L7:
            MeasurementDetails r6 = (MeasurementDetails) msg.obj;
            this.mCached = r6;
            StorageMeasurement.access$200(this.this$0, r6);
            return;
        L8:
            Object r0 = this.mLock;
            monitor-enter(r0);
        L21:
            th = move-exception;
            throw th;
        L11:
            if (this.mBound == false) goto L19;
            WeakReference<Context> r7 = this.mContext;     // Catch: Throwable -> L21
            if (r7 == null) goto L15;
            r1 = r7.get();     // Catch: Throwable -> L21
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
            IMediaContainerService r8 = (IMediaContainerService) msg.obj;
            measureApproximateStorage(r8);
            if (StorageMeasurement.access$300(this.this$0) == false) goto L58;
            measureExactStorage(r8);
            return;
        L58:
            return;
        L27:
            MeasurementDetails r9 = this.mCached;
            if (r9 == null) goto L30;
            StorageMeasurement.access$200(this.this$0, r9);
            return;
        L30:
            WeakReference<Context> r10 = this.mContext;
            if (r10 == null) goto L33;
            Context r11 = r10.get();
        L34:
            if (r11 != null) goto L36;
            return;
        L36:
            Object r2 = this.mLock;
            monitor-enter(r2);
        L49:
            th = move-exception;
            throw th;
        L39:
            if (MultiSdkAdapter.isBeforeP() == true) goto L44;
            sendMessage(obtainMessage(2, null));     // Catch: Throwable -> L49
            monitor-exit(r2);     // Catch: Throwable -> L49
            return;
        L44:
            if (this.mBound == false) goto L46;
            removeMessages(3);     // Catch: Throwable -> L49
            sendMessage(obtainMessage(2, this.mDefaultContainer));     // Catch: Throwable -> L49
        L47:
            monitor-exit(r2);     // Catch: Throwable -> L49
            return;
        L46:
            r11.bindServiceAsUser(new Intent().setComponent(StorageMeasurement.DEFAULT_CONTAINER_COMPONENT), this.mDefContainerConn, 1, UserHandle.OWNER);     // Catch: Throwable -> L49
            goto L47
        L33:
            r11 = null;
            goto L34
        }

        private void measureApproximateStorage(IMediaContainerService imcs) {
            if (StorageMeasurement.access$500(this.this$0) == null) goto L5;
            String r0 = StorageMeasurement.access$500(this.this$0).getPath();
        L6:
            DeviceStorageInfo r4 = MultiSdkAdapter.getDeviceStorageInfo(imcs, r0);
            if (r4 == null) goto L9;
            StorageMeasurement.access$602(this.this$0, r4.totalSize);
            StorageMeasurement.access$702(this.this$0, r4.availableSize);
            StorageMeasurement.access$802(this.this$0, r4.systemSize);
        L9:
            StorageMeasurement.access$900(this.this$0);
            return;
        L5:
            r0 = Environment.getDataDirectory().getPath();
            goto L6
        }

        private void measureExactStorage(final IMediaContainerService imcs) {
            WeakReference<Context> r0 = this.mContext;
            if (r0 == null) goto L5;
            final Context r1 = r0.get();
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            final MeasurementDetails r3 = new MeasurementDetails();
            Message r5 = obtainMessage(6, r3);
            r3.totalSize = StorageMeasurement.access$600(this.this$0);
            r3.availSize = StorageMeasurement.access$700(this.this$0);
            r3.systemSize = StorageMeasurement.access$800(this.this$0);
            r3.otherFileSize = StorageMeasurement.access$1000(this.this$0);
            UserManager r2 = (UserManager) r1.getSystemService("user");
            List r4 = new ArrayList();
            if (r2 == null) goto L11;
            r4 = r2.getUsers();
        L11:
            List r7 = r4;
            int r6 = ActivityManager.getCurrentUser();
            AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            if (StorageMeasurement.access$1100(this.this$0) == false) goto L16;
            if (Environment.isExternalStorageEmulated() == false) goto L16;
        L17:
            boolean r8 = true;
        L19:
            if (r8 == false) goto L21;
            AsyncTask.execute(new AnonymousClass2(this, r3, imcs));
        L21:
            AsyncTask.execute(new AnonymousClass3(this, r3, r1));
            PackageManager r10 = r1.getPackageManager();
            if (StorageMeasurement.access$1100(this.this$0) == true) goto L28;
            if (StorageMeasurement.access$1200(this.this$0) == true) goto L28;
            r5.sendToTarget();
            return;
        L28:
            if (MultiSdkAdapter.sdkIsBeforeO() == false) goto L37;
            if (r10 == null) goto L42;
            List<ApplicationInfo> r9 = r10.getInstalledApplications(8704);
            int r11 = r7.size() * r9.size();
            StatsObserver r12 = new StatsObserver(StorageMeasurement.access$1100(this.this$0), r3, r6, r5, r11);
            Iterator r13 = r7.iterator();
        L32:
            if (r13.hasNext() == false) goto L43;
            UserInfo r14 = (UserInfo) r13.next();
            Iterator<ApplicationInfo> r15 = r9.iterator();
        L35:
            if (r15.hasNext() == false) goto L32;
            MultiSdkAdapter.getPackageSizeInfoAsUser(r10, r15.next(), r14.id, r12);
            goto L35
        L43:
            return;
        L42:
            return;
        L37:
            ExecutorManager.execute(new AnonymousClass4(this, r3));
            return;
        L16:
            if (StorageMeasurement.access$1200(this.this$0) == true) goto L17;
            r8 = false;
            goto L19
        L5:
            r1 = null;
            goto L6
        }
    }

    public interface MeasurementReceiver {
        void updateAppSize(StorageMeasurement meas, MeasurementDetails details);

        void updateApproximate(StorageMeasurement meas, long totalSize, long availSize);

        void updateAudioSize(StorageMeasurement meas, MeasurementDetails details);

        void updateDetails(StorageMeasurement meas, MeasurementDetails details);

        void updateMediaSize(StorageMeasurement meas, MeasurementDetails details);

        void updateOtherFileSize(StorageMeasurement meas, MeasurementDetails details);

        void updateUserSize(StorageMeasurement meas, MeasurementDetails details);
    }

    private static class StatsObserver extends IPackageStatsObserver.Stub {
        private final int mCurrentUser;
        private final MeasurementDetails mDetails;
        private final Message mFinished;
        private final boolean mIsInternal;
        private int mRemaining;

        public StatsObserver(boolean isInternal, MeasurementDetails details, int currentUser, Message finished, int remaining) {
            this.mIsInternal = isInternal;
            this.mDetails = details;
            this.mCurrentUser = currentUser;
            this.mFinished = finished;
            this.mRemaining = remaining;
        }

        public void onGetStatsCompleted(PackageStats stats, boolean succeeded) {
            MeasurementDetails r0 = this.mDetails;
            monitor-enter(r0);
            if (succeeded == true) goto L14;
        L6:
            int r2 = this.mRemaining - 1;     // Catch: Throwable -> L11
            this.mRemaining = r2;     // Catch: Throwable -> L11
            if (r2 != 0) goto L9;
            this.mFinished.sendToTarget();     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        L14:
            addStatsLocked(stats);     // Catch: Throwable -> L11
            goto L6
        }

        private void addStatsLocked(PackageStats stats) {
            if (this.mIsInternal == false) goto L11;
            long r0 = stats.codeSize;
            long r2 = stats.dataSize;
            long r4 = stats.cacheSize;
            if (Environment.isExternalStorageEmulated() == false) goto L8;
            r0 = r0 + (stats.externalCodeSize + stats.externalObbSize);
            r2 = r2 + (stats.externalDataSize + stats.externalMediaSize);
            r4 = r4 + stats.externalCacheSize;
        L8:
            if (stats.userHandle != this.mCurrentUser) goto L10;
            this.mDetails.appsSize += r0;
            this.mDetails.appsSize += r2;
        L10:
            this.mDetails.appsSize += r4;
            return;
        L11:
            this.mDetails.appsSize += (((stats.externalCodeSize + stats.externalDataSize) + stats.externalMediaSize) + stats.externalObbSize) + stats.externalCacheSize;
        }
    }

    static /* synthetic */ long access$1000(StorageMeasurement r2) {
        return r2.mOtherFileSize;
    }

    static /* synthetic */ long access$1002(StorageMeasurement r0, long r1) {
        r0.mOtherFileSize = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1100(StorageMeasurement r0) {
        return r0.mIsInternal;
    }

    static /* synthetic */ boolean access$1200(StorageMeasurement r0) {
        return r0.mIsPrimary;
    }

    static /* synthetic */ Set access$1300() {
        return sMeasureMediaTypes;
    }

    static /* synthetic */ void access$1400(StorageMeasurement r0, MeasurementDetails r1) {
        r0.sendMediaUpdate(r1);
    }

    static /* synthetic */ void access$1500(StorageMeasurement r0, MeasurementDetails r1) {
        r0.sendUserUpdate(r1);
    }

    static /* synthetic */ long access$1600(StorageMeasurement r0, Context r1) {
        return r0.measureSumSizeOfAudio(r1);
    }

    static /* synthetic */ void access$1700(StorageMeasurement r0, MeasurementDetails r1) {
        r0.sendAudioUpdate(r1);
    }

    static /* synthetic */ void access$1800(StorageMeasurement r0, MeasurementDetails r1) {
        r0.sendOtherFileUpdate(r1);
    }

    static /* synthetic */ void access$200(StorageMeasurement r0, MeasurementDetails r1) {
        r0.sendExactUpdate(r1);
    }

    static /* synthetic */ boolean access$300(StorageMeasurement r0) {
        return r0.mMeasureDetail;
    }

    static /* synthetic */ void access$400(StorageMeasurement r0, MeasurementDetails r1) {
        r0.sendAppUpdate(r1);
    }

    static /* synthetic */ StorageVolume access$500(StorageMeasurement r0) {
        return r0.mVolume;
    }

    static /* synthetic */ long access$600(StorageMeasurement r2) {
        return r2.mTotalSize;
    }

    static /* synthetic */ long access$602(StorageMeasurement r0, long r1) {
        r0.mTotalSize = r1;
        return r1;
    }

    static /* synthetic */ long access$700(StorageMeasurement r2) {
        return r2.mAvailSize;
    }

    static /* synthetic */ long access$702(StorageMeasurement r0, long r1) {
        r0.mAvailSize = r1;
        return r1;
    }

    static /* synthetic */ long access$800(StorageMeasurement r2) {
        return r2.mSystemSize;
    }

    static /* synthetic */ long access$802(StorageMeasurement r0, long r1) {
        r0.mSystemSize = r1;
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

    public static StorageMeasurement getInstance(Context context, StorageVolume volume) {
        HashMap<StorageVolume, StorageMeasurement> r0 = sInstances;
        monitor-enter(r0);
        StorageMeasurement r1 = sInstances.get(volume);     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        r1 = new StorageMeasurement(context.getApplicationContext(), volume);     // Catch: Throwable -> L9
        sInstances.put(volume, r1);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    public void setMeasureDetail(boolean measure) {
        this.mMeasureDetail = measure;
    }

    private StorageMeasurement(Context context, StorageVolume volume) {
        boolean r0 = true;
        this.mMeasureDetail = true;
        this.mVolume = volume;
        boolean r1 = false;
        if (volume == null) goto L6;
        r0 = false;
    L6:
        this.mIsInternal = r0;
        if (volume == null) goto L9;
        r1 = volume.isPrimary();
    L9:
        this.mIsPrimary = r1;
        HandlerThread r4 = new HandlerThread("MemoryMeasurement");
        r4.start();
        Looper r5 = r4.getLooper();
        if (r5 == null) goto L13;
        this.mHandler = new MeasurementHandler(this, context, r5);
        return;
    }

    public void setReceiver(MeasurementReceiver receiver) {
        if (this.mReceiver != null) goto L5;
    L6:
        this.mReceiver = new WeakReference(receiver);
        return;
    L5:
        if (this.mReceiver.get() == null) goto L6;
    }

    public void resetReciver() {
        this.mReceiver = null;
        this.mHandler.removeMessages(1);
    }

    public void measure() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(1);
    }

    public void cleanUp() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(3);
    }

    public void invalidate() {
        this.mHandler.sendEmptyMessage(5);
    }

    private void sendInternalApproximateUpdate() {
    L11:
        e = move-exception;
        OLog.e(TAG, "sendInternalApproximateUpdate", e);
        return;
    L3:
        if (this.mReceiver == null) goto L5;
        MeasurementReceiver r0 = this.mReceiver.get();     // Catch: Exception -> L11
    L6:
        MeasurementReceiver r1 = r0;
        if (r1 != null) goto L9;
        return;
    L9:
        r1.updateApproximate(this, this.mTotalSize, this.mAvailSize);     // Catch: Exception -> L11
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void sendExactUpdate(MeasurementDetails details) {
    L14:
        e = move-exception;
        OLog.e(TAG, "sendExactUpdate", e);
        return;
    L4:
        if (this.mReceiver == null) goto L6;
        MeasurementReceiver r1 = this.mReceiver.get();     // Catch: Exception -> L14
    L7:
        if (r1 == null) goto L9;
        r1.updateDetails(this, details);     // Catch: Exception -> L14
        return;
    L9:
        if (LOGV == false) goto L18;
        OLog.i(TAG, "measurements dropped because receiver is null! wasted effort");     // Catch: Exception -> L14
        return;
    L18:
        return;
    L6:
        r1 = null;
        goto L7
    }

    private void sendMediaUpdate(MeasurementDetails details) {
    L10:
        e = move-exception;
        OLog.e(TAG, "sendMediaUpdate", e);
        return;
    L3:
        if (this.mReceiver == null) goto L5;
        MeasurementReceiver r0 = this.mReceiver.get();     // Catch: Exception -> L10
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        r0.updateMediaSize(this, details);     // Catch: Exception -> L10
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void sendUserUpdate(MeasurementDetails details) {
    L10:
        e = move-exception;
        OLog.e(TAG, "sendUserUpdate", e);
        return;
    L3:
        if (this.mReceiver == null) goto L5;
        MeasurementReceiver r0 = this.mReceiver.get();     // Catch: Exception -> L10
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        r0.updateUserSize(this, details);     // Catch: Exception -> L10
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void sendOtherFileUpdate(MeasurementDetails details) {
    L10:
        e = move-exception;
        OLog.e(TAG, "sendOtherFileUpdate", e);
        return;
    L3:
        if (this.mReceiver == null) goto L5;
        MeasurementReceiver r0 = this.mReceiver.get();     // Catch: Exception -> L10
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        r0.updateOtherFileSize(this, details);     // Catch: Exception -> L10
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void sendAudioUpdate(MeasurementDetails details) {
    L10:
        e = move-exception;
        OLog.e(TAG, "sendAudioUpdate", e);
        return;
    L3:
        if (this.mReceiver == null) goto L5;
        MeasurementReceiver r0 = this.mReceiver.get();     // Catch: Exception -> L10
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        r0.updateAudioSize(this, details);     // Catch: Exception -> L10
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void sendAppUpdate(MeasurementDetails details) {
    L10:
        e = move-exception;
        OLog.e(TAG, "sendAppUpdate", e);
        return;
    L3:
        if (this.mReceiver == null) goto L5;
        MeasurementReceiver r0 = this.mReceiver.get();     // Catch: Exception -> L10
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        r0.updateAppSize(this, details);     // Catch: Exception -> L10
        return;
    L5:
        r0 = null;
        goto L6
    }

    private long measureSumSizeOfAudio(Context context) {
        LogTag.d(TAG, "measureSumSizeOfAudio start");
        Cursor r7 = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_size"}, null, null, null);     // Catch: Exception -> L5
    L7:
        DeviceUtils.isSdMounted();
        long r1 = 0;
        if (r7 != null) goto L10;
    L14:
        LogTag.d(TAG, "measureSumSizeOfAudio audio sum:" + Formatter.formatFileSize(context, r1));
        return r1;
    L10:
        if (r7.moveToFirst() == false) goto L13;
    L11:
        r1 = r1 + r7.getLong(0);
        if (r7.moveToNext() == true) goto L11;
    L13:
        r7.close();
    L5:
        e = move-exception;
        LogTag.e(TAG, "measureSumSizeOfAudio error");
        e.printStackTrace();
        r7 = null;
        goto L7
    }

    private static void addValue(SparseLongArray array, int key, long value) {
        array.put(key, array.get(key) + value);
    }
}
