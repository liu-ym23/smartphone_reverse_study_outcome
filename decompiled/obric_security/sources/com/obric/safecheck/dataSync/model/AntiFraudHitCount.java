package com.obric.safecheck.dataSync.model;

/* JADX INFO: loaded from: classes4.dex */
public class AntiFraudHitCount {
    private long apk_count;
    private long phone_number_count;
    private long url_count;

    public AntiFraudHitCount() {
    }

    public long getApkCount() {
        return this.apk_count;
    }

    public void setApkCount(long apkCount) {
        this.apk_count = apkCount;
    }

    public long getUrlCount() {
        return this.url_count;
    }

    public void setUrlCount(long urlCount) {
        this.url_count = urlCount;
    }

    public long getPhoneNumberCount() {
        return this.phone_number_count;
    }

    public void setPhoneNumberCount(long phoneNumberCount) {
        this.phone_number_count = phoneNumberCount;
    }
}
