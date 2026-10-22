package com.android.apksigner;

import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public class CertInfoObject {
    private long mEndTime;
    private String mHash1;
    private String mHash2;
    private LinkedHashSet<String> mSignerVersion;
    private long mStartTime;

    public CertInfoObject(String r1, String r2, long r3, long r5) {
        this.mHash1 = r1;
        this.mHash2 = r2;
        this.mStartTime = r3;
        this.mEndTime = r5;
        this.mSignerVersion = new LinkedHashSet();
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public String getHash1() {
        return this.mHash1;
    }

    public String getHash2() {
        return this.mHash2;
    }

    public String getSignerVersion() {
        return String.join(",", this.mSignerVersion);
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public void setSignerVersion(String r1) {
        this.mSignerVersion.add(r1);
    }

    public String toString() {
        return "Hash1=" + this.mHash1 + ", Hash2=" + this.mHash2 + ", SignerVersion=" + getSignerVersion() + ", StartTime=" + this.mStartTime + ", EndTime=" + this.mEndTime + ";";
    }
}
