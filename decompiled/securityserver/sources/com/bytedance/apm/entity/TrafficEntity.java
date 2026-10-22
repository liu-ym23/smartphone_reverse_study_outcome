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
        long r2 = this.frontMobileRecBytes;
        if (r2 <= 0) goto L5;
        r0.add(new TrafficLogEntity(r2, 1, 0, 0, r9));
    L5:
        long r3 = this.frontMobileSendBytes;
        if (r3 <= 0) goto L8;
        r0.add(new TrafficLogEntity(r3, 1, 0, 1, r9));
    L8:
        long r4 = this.frontWifiRecBytes;
        if (r4 <= 0) goto L11;
        r0.add(new TrafficLogEntity(r4, 1, 1, 0, r9));
    L11:
        long r5 = this.frontWifiSendBytes;
        if (r5 <= 0) goto L14;
        r0.add(new TrafficLogEntity(r5, 1, 1, 1, r9));
    L14:
        long r6 = this.backMobileRecBytes;
        if (r6 <= 0) goto L17;
        r0.add(new TrafficLogEntity(r6, 0, 0, 0, r9));
    L17:
        long r7 = this.backMobileSendBytes;
        if (r7 <= 0) goto L20;
        r0.add(new TrafficLogEntity(r7, 0, 0, 1, r9));
    L20:
        long r8 = this.backWifiRecBytes;
        if (r8 <= 0) goto L23;
        r0.add(new TrafficLogEntity(r8, 0, 1, 0, r9));
    L23:
        long r10 = this.backWifiSendBytes;
        if (r10 <= 0) goto L26;
        r0.add(new TrafficLogEntity(r10, 0, 1, 1, r9));
    L26:
        return r0;
    }

    public long getBackMobileRecBytes() {
        return this.backMobileRecBytes;
    }

    public long getBackMobileSendBytes() {
        return this.backMobileSendBytes;
    }

    public long getBackTotalBytes() {
        return this.backTotalBytes;
    }

    public long getBackWifiRecBytes() {
        return this.backWifiRecBytes;
    }

    public long getBackWifiSendBytes() {
        return this.backWifiSendBytes;
    }

    public long getFrontMobileRecBytes() {
        return this.frontMobileRecBytes;
    }

    public long getFrontMobileSendBytes() {
        return this.frontMobileSendBytes;
    }

    public long getFrontTotalBytes() {
        return this.frontTotalBytes;
    }

    public long getFrontWifiRecBytes() {
        return this.frontWifiRecBytes;
    }

    public long getFrontWifiSendBytes() {
        return this.frontWifiSendBytes;
    }

    public void setBackMobileRecBytes(long r1) {
        this.backMobileRecBytes = r1;
    }

    public void setBackMobileSendBytes(long r1) {
        this.backMobileSendBytes = r1;
    }

    public void setBackTotalBytes(long r1) {
        this.backTotalBytes = r1;
    }

    public void setBackWifiRecBytes(long r1) {
        this.backWifiRecBytes = r1;
    }

    public void setBackWifiSendBytes(long r1) {
        this.backWifiSendBytes = r1;
    }

    public void setFrontMobileRecBytes(long r1) {
        this.frontMobileRecBytes = r1;
    }

    public void setFrontMobileSendBytes(long r1) {
        this.frontMobileSendBytes = r1;
    }

    public void setFrontTotalBytes(long r1) {
        this.frontTotalBytes = r1;
    }

    public void setFrontWifiRecBytes(long r1) {
        this.frontWifiRecBytes = r1;
    }

    public void setFrontWifiSendBytes(long r1) {
        this.frontWifiSendBytes = r1;
    }

    public void setSid(long r1) {
        this.sid = r1;
    }

    public String toString() {
        return "TrafficEntity{frontWifiSendBytes=" + this.frontWifiSendBytes + ", frontWifiRecBytes=" + this.frontWifiRecBytes + ", frontMobileSendBytes=" + this.frontMobileSendBytes + ", frontMobileRecBytes=" + this.frontMobileRecBytes + ", backWifiSendBytes=" + this.backWifiSendBytes + ", backWifiRecBytes=" + this.backWifiRecBytes + ", backMobileSendBytes=" + this.backMobileSendBytes + ", backMobileRecBytes=" + this.backMobileRecBytes + ", frontTotalBytes=" + this.frontTotalBytes + ", backTotalBytes=" + this.backTotalBytes + "=" + this.sid + '}';
    }
}
