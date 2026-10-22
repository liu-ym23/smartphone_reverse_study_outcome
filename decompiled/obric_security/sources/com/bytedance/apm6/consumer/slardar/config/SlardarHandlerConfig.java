package com.bytedance.apm6.consumer.slardar.config;

import android.text.TextUtils;
import com.bytedance.apm6.util.ListUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SlardarHandlerConfig {
    public static final int TYPE_ZSTD = 1;
    public static final int TYPE_ZSTD_DICT = 2;
    private int compressType;
    private List<String> exceptionUrl;
    private boolean isEncrypt;
    private boolean isUploadInternalExcetpion;
    private int keepDays;
    private int maxSizeMB;
    private int maxSizeMBToday;
    private long onceReportMaxSizeBytes;
    private long reportInterval;
    private List<String> reportUrlList;
    private List<String> traceReportUrl;

    public SlardarHandlerConfig() {
        this.isEncrypt = true;
        this.isUploadInternalExcetpion = true;
    }

    public void setCompressType(int r1) {
        this.compressType = r1;
    }

    public int getCompressType() {
        return this.compressType;
    }

    public void setOnceReportMaxSizeBytes(long r1) {
        this.onceReportMaxSizeBytes = r1;
    }

    public void setReportInterval(long r1) {
        this.reportInterval = r1;
    }

    public void setReportUrlList(List<String> r2) {
        if (ListUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        this.reportUrlList = r2;
    }

    public List<String> getReportUrlList() {
        return this.reportUrlList;
    }

    public void setExceptionUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        this.exceptionUrl = r0;
        r0.add(r2);
    }

    public void setTraceReportUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        this.traceReportUrl = r0;
        r0.add(r2);
    }

    public List<String> getTraceReportUrl() {
        return this.traceReportUrl;
    }

    public List<String> getExceptionUrl() {
        return this.exceptionUrl;
    }

    public void setEncrypt(boolean r1) {
        this.isEncrypt = r1;
    }

    public boolean isEncrypt() {
        return this.isEncrypt;
    }

    public boolean isUploadInternalException() {
        return this.isUploadInternalExcetpion;
    }

    public void setUploadInternalException(boolean r1) {
        this.isUploadInternalExcetpion = r1;
    }

    public long getOnceReportMaxSizeBytes() {
        return this.onceReportMaxSizeBytes;
    }

    public long getReportInterval() {
        return this.reportInterval;
    }

    public int getMaxSizeMB() {
        return this.maxSizeMB;
    }

    public void setMaxSizeMB(int r1) {
        this.maxSizeMB = r1;
    }

    public int getKeepDays() {
        return this.keepDays;
    }

    public void setKeepDays(int r1) {
        this.keepDays = r1;
    }

    public int getMaxSizeMBToday() {
        return this.maxSizeMBToday;
    }

    public void setMaxSizeMBToday(int r1) {
        this.maxSizeMBToday = r1;
    }

    public String toString() {
        return "SlardarHandlerConfig{onceReportMaxSizeBytes=" + this.onceReportMaxSizeBytes + ", reportUrlList=" + this.reportUrlList + ", exceptionUrl=" + this.exceptionUrl + ", traceReportUrl=" + this.traceReportUrl + ", isEncrypt=" + this.isEncrypt + ", isUploadInternalExcetpion=" + this.isUploadInternalExcetpion + ", reportInterval=" + this.reportInterval + ", maxSizeMB=" + this.maxSizeMB + ", keepDays=" + this.keepDays + ", maxSizeMBToday=" + this.maxSizeMBToday + '}';
    }
}
