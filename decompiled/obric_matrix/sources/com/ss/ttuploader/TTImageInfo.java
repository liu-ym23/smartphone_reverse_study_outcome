package com.ss.ttuploader;

/* JADX INFO: loaded from: classes2.dex */
public class TTImageInfo {
    public String mAlgorithm;
    public String mEncryptionImageTosKey;
    public long mErrcode;
    public String mExtra;
    public int mFileIndex;
    public String mImageToskey;

    @Deprecated
    public String mImageUri;
    public String mMetaInfo;

    @Deprecated
    public String mObjectId;

    @Deprecated
    public String mPlainObjectId;
    public long mProgress;
    public String mSecretKey;
    public String mSourceMd5;
    public String mVersion;

    public TTImageInfo(String r2, long r3, int r5, String r6) {
        this.mFileIndex = -1;
        this.mImageUri = r2;
        this.mImageToskey = r2;
        this.mProgress = r3;
        this.mErrcode = r3;
        this.mFileIndex = r5;
        this.mMetaInfo = r6;
    }

    public TTImageInfo(String r2, String r3, String r4, String r5, String r6, String r7, String r8, String r9, long r10, int r12) {
        this.mFileIndex = -1;
        this.mObjectId = r2;
        this.mEncryptionImageTosKey = r2;
        this.mSecretKey = r3;
        this.mAlgorithm = r4;
        this.mVersion = r5;
        this.mImageUri = r6;
        this.mProgress = r10;
        this.mFileIndex = r12;
        this.mSourceMd5 = r7;
        this.mExtra = r8;
        this.mPlainObjectId = r9;
        this.mImageToskey = r9;
    }
}
