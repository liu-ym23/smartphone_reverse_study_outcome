package com.android.settings.deviceinfo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.text.format.DateUtils;
import android.text.format.Formatter;
import com.android.internal.app.IMediaContainerService;
import com.obric.olog.OLog;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MigrateEstimateTask extends AsyncTask<Void, Void, Long> implements ServiceConnection {
    private static final ComponentName DEFAULT_CONTAINER_COMPONENT = null;
    private static final String EXTRA_SIZE_BYTES = "size_bytes";
    private static final long SPEED_ESTIMATE_BPS = 10485760;
    private final CountDownLatch mConnected;
    private final Context mContext;
    private IMediaContainerService mService;
    private long mSizeBytes;
    private final StorageManager mStorage;

    public abstract void onPostExecute(String r1, String r2);

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ Long doInBackground(Void[] r1) {
        return doInBackground2(r1);
    }

    @Override // android.os.AsyncTask
    protected /* bridge */ /* synthetic */ void onPostExecute(Long r1) {
        onPostExecute2(r1);
    }

    static {
        DEFAULT_CONTAINER_COMPONENT = new ComponentName("com.android.defcontainer", "com.android.defcontainer.DefaultContainerService");
    }

    public MigrateEstimateTask(Context r3) {
        this.mConnected = new CountDownLatch(1);
        this.mSizeBytes = -1;
        this.mContext = r3;
        this.mStorage = (StorageManager) r3.getSystemService(StorageManager.class);
    }

    public void copyFrom(Intent r4) {
        this.mSizeBytes = r4.getLongExtra(EXTRA_SIZE_BYTES, -1);
    }

    public void copyTo(Intent r4) {
        r4.putExtra(EXTRA_SIZE_BYTES, this.mSizeBytes);
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    protected Long doInBackground2(Void... r5) {
        long r0 = this.mSizeBytes;
        if (r0 != (-1)) goto L5;
        VolumeInfo r1 = this.mStorage.findEmulatedForPrivate(this.mContext.getPackageManager().getPrimaryStorageCurrentVolume());
        if (r1 != null) goto L10;
        OLog.w("StorageSettings", "Failed to find current primary storage");
        return -1L;
    L10:
        OLog.d("StorageSettings", "Estimating for current path " + r1.getPath().getAbsolutePath());
        this.mContext.bindServiceAsUser(new Intent().setComponent(DEFAULT_CONTAINER_COMPONENT), this, 1, UserHandle.SYSTEM);
        return -1L;
    L5:
        return Long.valueOf(r0);
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    protected void onPostExecute2(Long r7) {
        long r0 = r7.longValue();
        this.mSizeBytes = r0;
        long r1 = Math.max((r0 * 1000) / SPEED_ESTIMATE_BPS, 1000);
        onPostExecute(Formatter.formatFileSize(this.mContext, this.mSizeBytes), DateUtils.formatDuration(r1).toString());
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r1, IBinder r2) {
        this.mService = IMediaContainerService.Stub.asInterface(r2);
        this.mConnected.countDown();
    }
}
