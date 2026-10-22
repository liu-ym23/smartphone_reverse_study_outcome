package com.ss.ttuploader;

import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TTImageXUploader extends TTImageUploaderAbstractListener implements TTImageUploaderListener {
    private TTImageXUploaderAbstractListener mAbstractListener;
    private TTImageUploader mImageUploader;
    private TTImageXUploaderListener mListener;

    public TTImageXUploader() {
        this.mAbstractListener = null;
        this.mListener = null;
        TTImageUploader r1 = new TTImageUploader(4);     // Catch: Throwable -> L5
        this.mImageUploader = r1;     // Catch: Throwable -> L5
        r1.setListener(this);     // Catch: Throwable -> L5
        this.mImageUploader.setAbstractListener(this);     // Catch: Throwable -> L5
    L8:
        if (this.mImageUploader == null) goto L11;
        return;
    L11:
        throw new Exception("create native uploader fail");
    L5:
        th = move-exception;
        this.mImageUploader = null;
        Log.e("ttmn", th.toString());
        goto L8
    }

    public static boolean isError() {
        return TTImageUploader.isError();
    }

    public void close() {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.close();
    }

    @Override // com.ss.ttuploader.TTImageUploaderAbstractListener
    public int imageUploadCheckNetState(int r1, int r2) {
        TTImageXUploaderAbstractListener r0 = this.mAbstractListener;
        if (r0 != null) goto L7;
        return -2;
    L7:
        return r0.imagexUploadCheckNetState(r1, r2);
    }

    @Override // com.ss.ttuploader.TTImageUploaderListener
    public void onNotify(int r11, long r12, TTImageInfo r14) {
        Log.e("ttmn", String.format("what:%d,parameter:%d", new Object[]{Integer.valueOf(r11), Long.valueOf(r12)}));
        if (r14 == null) goto L5;
        TTImageXInfo r2 = new TTImageXInfo(r14.mImageToskey, r14.mProgress, r14.mFileIndex, r14.mMetaInfo);
    L6:
        if (r11 != 0) goto L8;
    L7:
        this.mListener.onNotify(r11, r12, null);
        return;
    L8:
        if (r11 == 1) goto L7;
        if (r11 != 3) goto L14;
    L12:
        this.mListener.onNotify(r11, r12, r2);
        return;
    L14:
        if (r11 != 4) goto L16;
        r2.mErrcode = r14.mErrcode;
        r2.mProgress = r14.mProgress;
        goto L12
    L16:
        if (r11 == 2) goto L12;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public void setAbstractListener(TTImageXUploaderAbstractListener r1) {
        this.mAbstractListener = r1;
    }

    public void setEnableHttps(int r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setEnableHttps(r1);
    }

    public void setFileName(int r1, String[] r2) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setFileName(r1, r2);
    }

    public void setFilePath(int r1, String[] r2) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setFilePath(r1, r2);
    }

    public void setFileRetryCount(int r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setFileRetryCount(r1);
    }

    public void setImageUploadDomain(String r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setImageUploadDomain(r1);
    }

    public void setListener(TTImageXUploaderListener r1) {
        this.mListener = r1;
    }

    public void setMaxFailTime(int r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setMaxFailTime(r1);
    }

    public void setMediaDataReader(TTMediaDataReader r1, int r2) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setMediaDataReader(r1, r2);
    }

    public void setMediaDataReader(TTMediaDataReader r1, int r2, int r3) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setMediaDataReader(r1, r2, r3);
    }

    public void setOpenBoe(boolean r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setOpenBoe(r1);
    }

    public void setScenesTag(String r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setScenesTag(r1);
    }

    public void setServerParameter(String r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setServerParameter(r1);
    }

    public void setSliceReTryCount(int r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setSliceReTryCount(r1);
    }

    public void setSliceTimeout(int r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setSliceTimeout(r1);
    }

    public void setSocketNum(int r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setSocketNum(r1);
    }

    public void setStringValue(int r1, String r2) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setStringValue(r1, r2);
    }

    public void setTraceIDConfig(Map<Object, Object> r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTraceIDConfig(r1);
    }

    public void setTranTimeOutUnit(int r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setTranTimeOutUnit(r1);
    }

    public void setUploadToken(String r1) {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setUploadToken(r1);
    }

    public void start() {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.start();
    }

    public void stop() {
        TTImageUploader r0 = this.mImageUploader;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.stop();
    }
}
