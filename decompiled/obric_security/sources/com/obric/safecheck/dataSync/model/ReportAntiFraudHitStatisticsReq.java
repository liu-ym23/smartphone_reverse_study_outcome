package com.obric.safecheck.dataSync.model;

/* JADX INFO: loaded from: classes4.dex */
public class ReportAntiFraudHitStatisticsReq {
    private String date_time;
    private String did;
    private AntiFraudHitCount hit_count;

    public ReportAntiFraudHitStatisticsReq() {
    }

    public AntiFraudHitCount getHitStatistics() {
        return this.hit_count;
    }

    public void setHitStatistics(AntiFraudHitCount hitStatistics) {
        this.hit_count = hitStatistics;
    }

    public String getDateTime() {
        return this.date_time;
    }

    public void setDateTime(String dateTime) {
        this.date_time = dateTime;
    }

    public String getDid() {
        return this.did;
    }

    public void setDid(String did) {
        this.did = did;
    }
}
