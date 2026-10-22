package com.ss.ttuploader.net;

/* JADX INFO: loaded from: classes2.dex */
public class TTUploadDNSInfo {
    public Error mErr;
    public String mErrorStr;
    public long mExpiredTime;
    public String mExtraInfo;
    public String mHost;
    public String mId;
    public String mIpList;
    public int mType;

    public TTUploadDNSInfo(int r1, String r2, String r3, long r4, String r6) {
        this.mType = r1;
        this.mHost = r2;
        this.mIpList = r3;
        this.mExpiredTime = r4;
        this.mId = r6;
        this.mErr = null;
    }

    public TTUploadDNSInfo(int r1, String r2, String r3, long r4, String r6, String r7) {
        this.mType = r1;
        this.mHost = r2;
        this.mIpList = r3;
        this.mExpiredTime = r4;
        this.mId = r6;
        this.mErrorStr = r7;
        this.mErr = null;
    }
}
