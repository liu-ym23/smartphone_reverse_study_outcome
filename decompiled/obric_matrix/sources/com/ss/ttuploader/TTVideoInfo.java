package com.ss.ttuploader;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoInfo {
    public String mAlgorithm;
    public String mCoverUri;
    public String mCoverUrl;
    public String mEncryptionVideoTosKey;
    public long mErrcode;
    public String mExtra;
    public JSONObject mLog;

    @Deprecated
    public String mObjectId;

    @Deprecated
    public String mPlainObjectId;
    public long mProgress;
    public String mSecretKey;
    public String mSourceMd5;
    public String mTosKey;
    public String mVersion;
    public String mVideoId;
    public String mVideoMediaInfo;

    public TTVideoInfo(String r1, String r2, String r3, long r4, String r6, String r7) {
        this.mVideoId = r1;
        this.mCoverUrl = r2;
        this.mCoverUri = r3;
        this.mProgress = r4;
        this.mErrcode = r4;
        this.mTosKey = r6;
        this.mVideoMediaInfo = r7;
        this.mLog = null;
    }

    public TTVideoInfo(String r1, String r2, String r3, String r4, long r5, String r7, String r8, String r9) {
        this.mObjectId = r1;
        this.mEncryptionVideoTosKey = r1;
        this.mSecretKey = r2;
        this.mAlgorithm = r3;
        this.mVersion = r4;
        this.mProgress = r5;
        this.mSourceMd5 = r7;
        this.mExtra = r8;
        this.mPlainObjectId = r9;
        this.mTosKey = r9;
        this.mLog = null;
    }
}
