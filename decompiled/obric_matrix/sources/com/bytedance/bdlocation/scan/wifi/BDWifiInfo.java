package com.bytedance.bdlocation.scan.wifi;

/* JADX INFO: loaded from: classes.dex */
public class BDWifiInfo {

    @com.google.gson.y.c("BSSID")
    private String bssid;

    @com.google.gson.y.c("channel")
    private int channel;

    @com.google.gson.y.c("isCurrent")
    private boolean isCurrent;

    @com.google.gson.y.c("RSSI")
    private int rssi;

    @com.google.gson.y.c("SSID")
    private String ssid;

    @com.google.gson.y.c("Timestamp")
    private long timeStamp;

    public BDWifiInfo() {
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L18;
        BDWifiInfo r6 = (BDWifiInfo) r5;
        String r4 = this.bssid;
        if (r4 == null) goto L14;
        return r4.equals(r6.bssid);
    L14:
        if (r6.bssid != null) goto L17;
        return true;
    L17:
        return false;
    }

    public String getBssid() {
        return this.bssid;
    }

    public int getChannel() {
        return this.channel;
    }

    public int getRssi() {
        return this.rssi;
    }

    public String getSsid() {
        return this.ssid;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public int hashCode() {
        String r0 = this.bssid;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public boolean isCurrent() {
        return this.isCurrent;
    }

    public BDWifiInfo setBssid(String r1) {
        this.bssid = r1;
        return this;
    }

    public BDWifiInfo setChannel(int r1) {
        this.channel = r1;
        return this;
    }

    public BDWifiInfo setCurrent(boolean r1) {
        this.isCurrent = r1;
        return this;
    }

    public BDWifiInfo setRssi(int r1) {
        this.rssi = r1;
        return this;
    }

    public BDWifiInfo setSsid(String r1) {
        this.ssid = r1;
        return this;
    }

    public void setTimeStamp(long r1) {
        this.timeStamp = r1;
    }

    public String toString() {
        return "WifiInfo{bssid='" + this.bssid + "', channel='" + this.channel + "', isCurrent=" + this.isCurrent + ", rssi=" + this.rssi + ", ssid='" + this.ssid + "', timeStamp='" + this.timeStamp + "'}";
    }
}
