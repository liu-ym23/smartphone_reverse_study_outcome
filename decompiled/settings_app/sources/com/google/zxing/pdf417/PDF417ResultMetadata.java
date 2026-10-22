package com.google.zxing.pdf417;

/* JADX INFO: loaded from: classes4.dex */
public final class PDF417ResultMetadata {
    private String addressee;
    private int checksum;
    private String fileId;
    private String fileName;
    private long fileSize;
    private boolean lastSegment;
    private int[] optionalData;
    private int segmentCount;
    private int segmentIndex;
    private String sender;
    private long timestamp;

    public PDF417ResultMetadata() {
        this.segmentCount = -1;
        this.fileSize = -1;
        this.timestamp = -1;
        this.checksum = -1;
    }

    public int getSegmentIndex() {
        return this.segmentIndex;
    }

    public void setSegmentIndex(int r1) {
        this.segmentIndex = r1;
    }

    public String getFileId() {
        return this.fileId;
    }

    public void setFileId(String r1) {
        this.fileId = r1;
    }

    @Deprecated
    public int[] getOptionalData() {
        return this.optionalData;
    }

    @Deprecated
    public void setOptionalData(int[] r1) {
        this.optionalData = r1;
    }

    public boolean isLastSegment() {
        return this.lastSegment;
    }

    public void setLastSegment(boolean r1) {
        this.lastSegment = r1;
    }

    public int getSegmentCount() {
        return this.segmentCount;
    }

    public void setSegmentCount(int r1) {
        this.segmentCount = r1;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String r1) {
        this.sender = r1;
    }

    public String getAddressee() {
        return this.addressee;
    }

    public void setAddressee(String r1) {
        this.addressee = r1;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String r1) {
        this.fileName = r1;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long r1) {
        this.fileSize = r1;
    }

    public int getChecksum() {
        return this.checksum;
    }

    public void setChecksum(int r1) {
        this.checksum = r1;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long r1) {
        this.timestamp = r1;
    }
}
