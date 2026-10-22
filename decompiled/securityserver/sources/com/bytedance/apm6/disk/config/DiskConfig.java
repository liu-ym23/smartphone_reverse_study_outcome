package com.bytedance.apm6.disk.config;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiskConfig {
    private List<String> complianceRelativePaths;
    private List<String> customRelativePaths;
    private long diskThresholdBytes;
    private long fileThresholdBytes;
    private long folderThresholdBytes;
    private List<String> ignoredRelativePaths;
    private boolean isEnable;
    private boolean isSample;
    private long outdatedIntervalMs;
    private int reportExceptionDirMaxCount;
    private int reportMaxCount;
    private int reportMaxOutdatedCount;
    private int reportMaxTopCount;

    public DiskConfig() {
    }

    public List<String> getComplianceRelativePaths() {
        return this.complianceRelativePaths;
    }

    public List<String> getCustomRelativePaths() {
        return this.customRelativePaths;
    }

    public long getDiskThresholdBytes() {
        return this.diskThresholdBytes;
    }

    public long getFileThresholdBytes() {
        return this.fileThresholdBytes;
    }

    public long getFolderThresholdBytes() {
        return this.folderThresholdBytes;
    }

    public List<String> getIgnoredRelativePaths() {
        return this.ignoredRelativePaths;
    }

    public long getOutdatedIntervalMs() {
        return this.outdatedIntervalMs;
    }

    public int getReportExceptionDirMaxCount() {
        return this.reportExceptionDirMaxCount;
    }

    public int getReportMaxCount() {
        return this.reportMaxCount;
    }

    public int getReportMaxOutdatedCount() {
        return this.reportMaxOutdatedCount;
    }

    public int getReportMaxTopCount() {
        return this.reportMaxTopCount;
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public boolean isSample() {
        return this.isSample;
    }

    public void setComplianceRelativePaths(List<String> r1) {
        this.complianceRelativePaths = r1;
    }

    public void setCustomRelativePaths(List<String> r1) {
        this.customRelativePaths = r1;
    }

    public void setDiskThresholdBytes(long r1) {
        this.diskThresholdBytes = r1;
    }

    public void setEnable(boolean r1) {
        this.isEnable = r1;
    }

    public void setFileThresholdBytes(long r1) {
        this.fileThresholdBytes = r1;
    }

    public void setFolderThresholdBytes(long r1) {
        this.folderThresholdBytes = r1;
    }

    public void setIgnoredRelativePaths(List<String> r1) {
        this.ignoredRelativePaths = r1;
    }

    public void setOutdatedIntervalMs(long r1) {
        this.outdatedIntervalMs = r1;
    }

    public void setReportExceptionDirMaxCount(int r1) {
        this.reportExceptionDirMaxCount = r1;
    }

    public void setReportMaxCount(int r1) {
        this.reportMaxCount = r1;
    }

    public void setReportMaxOutdatedCount(int r1) {
        this.reportMaxOutdatedCount = r1;
    }

    public void setReportMaxTopCount(int r1) {
        this.reportMaxTopCount = r1;
    }

    public void setSample(boolean r1) {
        this.isSample = r1;
    }

    public String toString() {
        return "DiskConfig{isEnable=" + this.isEnable + ", diskThresholdBytes=" + this.diskThresholdBytes + ", folderThresholdBytes=" + this.folderThresholdBytes + ", fileThresholdBytes=" + this.fileThresholdBytes + ", reportMaxCount=" + this.reportMaxCount + ", reportMaxOutdatedCount=" + this.reportMaxOutdatedCount + ", reportMaxTopCount=" + this.reportMaxTopCount + ", reportExceptionDirMaxCount=" + this.reportExceptionDirMaxCount + ", outdatedIntervalMs=" + this.outdatedIntervalMs + ", customRelativePaths=" + this.customRelativePaths + ", ignoredRelativePaths=" + this.ignoredRelativePaths + ", complianceRelativePaths=" + this.complianceRelativePaths + ", isSample=" + this.isSample + '}';
    }
}
