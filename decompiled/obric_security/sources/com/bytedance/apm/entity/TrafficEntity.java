package com.bytedance.apm.entity;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TrafficEntity {
    private long backMobileRecBytes;
    private long backMobileSendBytes;
    public long backTotalBytes;
    private long backWifiRecBytes;
    private long backWifiSendBytes;
    private long frontMobileRecBytes;
    private long frontMobileSendBytes;
    public long frontTotalBytes;
    private long frontWifiRecBytes;
    private long frontWifiSendBytes;
    public long sid;

    public TrafficEntity() {
    }

    public List<TrafficLogEntity> convertToTrafficLogList() {
        ArrayList r0 = new ArrayList();
        long r9 = System.currentTimeMillis();
        if (this.frontMobileRecBytes <= 0) goto L6;
        r0.add(new TrafficLogEntity(this.frontMobileRecBytes, 1, 0, 0, r9));
    L6:
        if (this.frontMobileSendBytes <= 0) goto L9;
        r0.add(new TrafficLogEntity(this.frontMobileSendBytes, 1, 0, 1, r9));
    L9:
        if (this.frontWifiRecBytes <= 0) goto L12;
        r0.add(new TrafficLogEntity(this.frontWifiRecBytes, 1, 1, 0, r9));
    L12:
        if (this.frontWifiSendBytes <= 0) goto L15;
        r0.add(new TrafficLogEntity(this.frontWifiSendBytes, 1, 1, 1, r9));
    L15:
        if (this.backMobileRecBytes <= 0) goto L18;
        r0.add(new TrafficLogEntity(this.backMobileRecBytes, 0, 0, 0, r9));
    L18:
        if (this.backMobileSendBytes <= 0) goto L21;
        r0.add(new TrafficLogEntity(this.backMobileSendBytes, 0, 0, 1, r9));
    L21:
        if (this.backWifiRecBytes <= 0) goto L24;
        r0.add(new TrafficLogEntity(this.backWifiRecBytes, 0, 1, 0, r9));
    L24:
        if (this.backWifiSendBytes <= 0) goto L26;
        r0.add(new TrafficLogEntity(this.backWifiSendBytes, 0, 1, 1, r9));
    L26:
        return r0;
    }

    public void setSid(long r1) {
        this.sid = r1;
    }

    public long getFrontWifiSendBytes() {
        return this.frontWifiSendBytes;
    }

    public void setFrontWifiSendBytes(long r1) {
        this.frontWifiSendBytes = r1;
    }

    public long getFrontWifiRecBytes() {
        return this.frontWifiRecBytes;
    }

    public void setFrontWifiRecBytes(long r1) {
        this.frontWifiRecBytes = r1;
    }

    public long getFrontMobileSendBytes() {
        return this.frontMobileSendBytes;
    }

    public void setFrontMobileSendBytes(long r1) {
        this.frontMobileSendBytes = r1;
    }

    public long getFrontMobileRecBytes() {
        return this.frontMobileRecBytes;
    }

    public void setFrontMobileRecBytes(long r1) {
        this.frontMobileRecBytes = r1;
    }

    public long getBackWifiSendBytes() {
        return this.backWifiSendBytes;
    }

    public void setBackWifiSendBytes(long r1) {
        this.backWifiSendBytes = r1;
    }

    public long getBackWifiRecBytes() {
        return this.backWifiRecBytes;
    }

    public void setBackWifiRecBytes(long r1) {
        this.backWifiRecBytes = r1;
    }

    public long getBackMobileSendBytes() {
        return this.backMobileSendBytes;
    }

    public void setBackMobileSendBytes(long r1) {
        this.backMobileSendBytes = r1;
    }

    public long getBackMobileRecBytes() {
        return this.backMobileRecBytes;
    }

    public void setBackMobileRecBytes(long r1) {
        this.backMobileRecBytes = r1;
    }

    public long getFrontTotalBytes() {
        return this.frontTotalBytes;
    }

    public void setFrontTotalBytes(long r1) {
        this.frontTotalBytes = r1;
    }

    public long getBackTotalBytes() {
        return this.backTotalBytes;
    }

    public void setBackTotalBytes(long r1) {
        this.backTotalBytes = r1;
    }

    public String toString() {
        return "TrafficEntity{frontWifiSendBytes=" + this.frontWifiSendBytes + ", frontWifiRecBytes=" + this.frontWifiRecBytes + ", frontMobileSendBytes=" + this.frontMobileSendBytes + ", frontMobileRecBytes=" + this.frontMobileRecBytes + ", backWifiSendBytes=" + this.backWifiSendBytes + ", backWifiRecBytes=" + this.backWifiRecBytes + ", backMobileSendBytes=" + this.backMobileSendBytes + ", backMobileRecBytes=" + this.backMobileRecBytes + ", frontTotalBytes=" + this.frontTotalBytes + ", backTotalBytes=" + this.backTotalBytes + "=" + this.sid + '}';
    }
}
