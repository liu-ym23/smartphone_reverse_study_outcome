package com.obric.safecheck.database.entity;

/* JADX INFO: loaded from: classes4.dex */
public class PkgSignItem implements Item {
    private boolean isBlacklist;
    private String pkg;
    private String riskLevel;
    private String timestamp;
    private String tmd5;
    private String tsha1;
    private String tsha256;
    private String umd5;

    public PkgSignItem() {
    }

    public String getPkg() {
        return this.pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public String getRiskLevel() {
        return this.riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getTmd5() {
        return this.tmd5;
    }

    public void setTmd5(String tmd5) {
        this.tmd5 = tmd5;
    }

    public String getTsha1() {
        return this.tsha1;
    }

    public void setTsha1(String tsha1) {
        this.tsha1 = tsha1;
    }

    public String getTsha256() {
        return this.tsha256;
    }

    public void setTsha256(String tsha256) {
        this.tsha256 = tsha256;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isBlacklist() {
        return this.isBlacklist;
    }

    public void setBlacklist(boolean blacklist) {
        this.isBlacklist = blacklist;
    }

    public String getUmd5() {
        return this.umd5;
    }

    public void setUmd5(String umd5) {
        this.umd5 = umd5;
    }
}
