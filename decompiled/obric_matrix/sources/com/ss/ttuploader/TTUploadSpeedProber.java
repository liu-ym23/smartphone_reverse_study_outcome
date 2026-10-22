package com.ss.ttuploader;

import android.content.Context;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTUploadSpeedProber implements TTVideoUploaderListener {
    public static final int MsgIsSpeedProbeComplete = 0;
    public static final int MsgIsSpeedProbeFail = 1;
    public static final int MsgIsSpeedProbeTimeOut = 2;
    private Context mContext;
    private long mEndTime;
    private long mEndTime1;
    private String mFilePath;
    private InputStream mInputStream;
    AtomicBoolean mIsEnd;
    private TTUploadSpeedProberListener mListener;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private long mStartTime;
    private long mStartTime1;
    private int mTestSize;
    private Timer mTimer;
    private TTVideoUploader mUploader;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;

    public TTUploadSpeedProber(Context r3, int r4) {
        ReentrantReadWriteLock r0 = new ReentrantReadWriteLock();
        this.mReadWritedLock = r0;
        if (r3 == null) goto L20;
        String r1 = getFilePath(r3);
        this.mFilePath = r1;
        if (r1 == null) goto L18;
        if (initFile(r4) == false) goto L16;
        this.mTestSize = r4;
        this.mContext = r3;
        TTVideoUploader r5 = new TTVideoUploader();     // Catch: Throwable -> L12
        this.mUploader = r5;     // Catch: Throwable -> L12
        r5.setPathName(this.mFilePath);
        this.mUploader.setListener(this);
        this.mUploader.setTestSpeed(true);
        this.mReadLock = r0.readLock();
        this.mWriteLock = r0.writeLock();
        this.mStartTime = 0;
        this.mEndTime = 0;
        this.mStartTime1 = 0;
        this.mEndTime1 = 0;
        this.mTimer = new Timer();
        this.mIsEnd = new AtomicBoolean(false);
        return;
    L12:
        th = move-exception;
        throw new Exception("TTUploadSpeedProber create image uploader fail" + th.toString());
    L16:
        throw new Exception("init file fail");
    L18:
        throw new Exception("get file path null");
    L20:
        throw new Exception("context is null create TTUploadSpeedProber fail");
    }

    static /* synthetic */ ReentrantReadWriteLock.WriteLock access$000(TTUploadSpeedProber r0) {
        return r0.mWriteLock;
    }

    static /* synthetic */ TTVideoUploader access$100(TTUploadSpeedProber r0) {
        return r0.mUploader;
    }

    static /* synthetic */ TTVideoUploader access$102(TTUploadSpeedProber r0, TTVideoUploader r1) {
        r0.mUploader = r1;
        return r1;
    }

    static /* synthetic */ TTUploadSpeedProberListener access$200(TTUploadSpeedProber r0) {
        return r0.mListener;
    }

    private String getFilePath(Context r3) {
        String r4 = r3.getApplicationContext().getFilesDir().getAbsolutePath();     // Catch: Exception -> L11
        if (r4 != null) goto L6;
        return null;
    L6:
        StringBuilder r2 = new StringBuilder();
        r2.append(r4);
        String r5 = File.separator;
        r2.append(r5);
        r2.append("speedprober");
        String r6 = r2.toString();
        File r0 = new File(r6);
        if (r0.exists() == true) goto L10;
        r0.mkdirs();
    L10:
        return r6 + r5 + "speedprober.test";
    L14:
        return null;
    }

    private boolean initFile(int r7) {
        FileWriter r1 = null;
        File r2 = new File(this.mFilePath);     // Catch: Throwable -> L23
        if (r2.exists() == true) goto L6;
    L5:
        r2.createNewFile();     // Catch: Throwable -> L23
        byte[] r3 = new byte[1024];     // Catch: Throwable -> L23
        int r4 = 0;
    L8:
        if (r4 >= 1024) goto L10;
        r3[r4] = 97;     // Catch: Throwable -> L23
        r4 = r4 + 1;     // Catch: Throwable -> L23
        goto L8
    L10:
        String r5 = new String(r3);     // Catch: Throwable -> L23
        FileWriter r6 = new FileWriter(r2, true);     // Catch: Throwable -> L23
        int r8 = (r7 / 1024) + 1;     // Catch: Throwable -> L16
        int r9 = 0;
    L12:
        if (r9 > r8) goto L14;
        r6.write(r5);     // Catch: Throwable -> L16
        r9 = r9 + 1;     // Catch: Throwable -> L16
        goto L12
    L14:
        r6.close();     // Catch: Throwable -> L16
        return true;
    L16:
        r1 = r6;
        goto L17
    L6:
        r2.delete();     // Catch: Throwable -> L23
    L17:
        if (r1 != null) goto L26;
    L22:
        return false;
    L26:
        r1.close();     // Catch: IOException -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public void close() {
        this.mWriteLock.lock();
        TTVideoUploader r0 = this.mUploader;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.close();     // Catch: Throwable -> L8
        this.mUploader = null;     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    }

    @Override // com.ss.ttuploader.TTVideoUploaderListener
    public String getStringFromExtern(int r1) {
        return null;
    }

    @Override // com.ss.ttuploader.TTVideoUploaderListener
    public void onLog(int r1, int r2, String r3) {
    }

    @Override // com.ss.ttuploader.TTVideoUploaderListener
    public void onNotify(int r4, long r5, TTVideoInfo r7) {
        int r0 = 1;
        if (r4 != 0) goto L20;
        this.mEndTime = System.currentTimeMillis();
        if (this.mListener == null) goto L32;
        this.mIsEnd.set(true);
        JSONObject r6 = null;
        if (r7 == null) goto L10;
        r6 = r7.mLog;
    L10:
        if (r6 != null) goto L30;
    L15:
        int r8 = 0;
    L16:
        TTUploadSpeedProberListener r3 = this.mListener;
        if (r8 <= 0) goto L19;
        r0 = 0;
    L19:
        r3.onNotify(r0, r8);
        return;
    L30:
        r8 = r6.getJSONObject("speedinfo").getJSONObject(BDLocationException.ERROR_TIMEOUT).getInt("avspeed");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L32:
        return;
    L20:
        if (r4 != 1) goto L25;
        if (r5 != 2) goto L34;
        this.mStartTime1 = System.currentTimeMillis();
        return;
    L34:
        return;
    L25:
        if (r4 != 2) goto L36;
        this.mIsEnd.set(true);
        this.mEndTime = 0;
        TTUploadSpeedProberListener r9 = this.mListener;
        if (r9 == null) goto L37;
        r9.onNotify(1, r5);
        return;
    L37:
        return;
    }

    @Override // com.ss.ttuploader.TTVideoUploaderListener
    public void onUploadVideoStage(int r1, long r2) {
    }

    public void setListener(TTUploadSpeedProberListener r1) {
        if (r1 == null) goto L5;
        this.mListener = r1;
        return;
    }

    public void start(String r5, String r6, String r7, long r8) {
        this.mWriteLock.lock();
    L8:
        th = move-exception;
        this.mWriteLock.unlock();
        throw th;
    L4:
        if (this.mStartTime != 0) goto L6;
        this.mStartTime = System.currentTimeMillis();     // Catch: Throwable -> L8
        this.mUploader.setVideoUploadDomain(r5);     // Catch: Throwable -> L8
        this.mUploader.setAuthorization(r6);     // Catch: Throwable -> L8
        this.mUploader.setUserKey(r7);     // Catch: Throwable -> L8
        this.mUploader.setSocketNum(1);     // Catch: Throwable -> L8
        this.mUploader.setSliceSize(524288);     // Catch: Throwable -> L8
        this.mUploader.setSliceTimeout(10);     // Catch: Throwable -> L8
        this.mUploader.setFileRetryCount(0);     // Catch: Throwable -> L8
        this.mUploader.setSliceReTryCount(0);     // Catch: Throwable -> L8
        this.mUploader.start();     // Catch: Throwable -> L8
        this.mTimer.schedule(new AnonymousClass1(this), r8);     // Catch: Throwable -> L8
    L6:
        this.mWriteLock.unlock();
    }

    @Override // com.ss.ttuploader.TTVideoUploaderListener
    public int videoUploadCheckNetState(int r1, int r2) {
        return 1;
    }
}
