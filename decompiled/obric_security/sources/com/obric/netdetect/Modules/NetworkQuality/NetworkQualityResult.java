package com.obric.netdetect.Modules.NetworkQuality;

import com.obric.netdetect.Utils.CodeConverter;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkQualityResult {
    public static final int BAND_24_GHZ = 1;
    public static final int BAND_5_GHZ = 2;
    public static final int BAND_6_GHZ = 3;
    public static final int BAND_UNKNOWN = 0;
    public static final int ERROR_CODE_NETWORK_NOT_AVAILABLE = 1;
    public static final int ERROR_CODE_UNKNOWN = 0;
    public static final int NETWORK_QUALITY_GOOD = 3;
    public static final int NETWORK_QUALITY_GREAT = 4;
    public static final int NETWORK_QUALITY_MODERATE = 2;
    public static final int NETWORK_QUALITY_POOR = 1;
    public static final int NETWORK_QUALITY_UNKNOWN = 0;
    public static final int TYPE_CDMA = 2;
    public static final int TYPE_GSM = 1;
    public static final int TYPE_LTE = 3;
    public static final int TYPE_NR = 6;
    public static final int TYPE_TDSCDMA = 5;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WCDMA = 4;
    private CellularNetworkQuality cellularNetworkQuality;
    public int errorCode;
    public String errorMsg;
    public int level;
    public int networkType;
    private WifiNetworkQuality wifiNetworkQuality;

    public class CellularNetworkQuality {
        public int rscp;
        public int rsrp;
        public int rsrq;
        public int rssi;
        public int sinr;
        final /* synthetic */ NetworkQualityResult this$0;
        public int type;

        public CellularNetworkQuality(NetworkQualityResult r1, int r2, int r3, int r4, int r5, int r6, int r7) {
            this.this$0 = r1;
            this.type = r2;
            this.rssi = r3;
            this.rscp = r4;
            this.rsrp = r5;
            this.rsrq = r6;
            this.sinr = r7;
        }

        public String toString() {
            return "{\n        Type: " + CodeConverter.convertCellularType(this.type) + "\n        Rssi: " + this.rssi + "\n        Rscp: " + this.rscp + "\n        Rsrp: " + this.rsrp + "\n        Rsrq: " + this.rsrq + "\n        Sinr: " + this.sinr + "\n    }";
        }
    }

    public class WifiNetworkQuality {
        public int band;
        public int jitter;
        public float jitterWeight;
        public int rssi;
        public int rxLinkSpeed;
        final /* synthetic */ NetworkQualityResult this$0;
        public int throughput;
        public int txLinkSpeed;

        public WifiNetworkQuality(NetworkQualityResult r1, int r2, int r3, float r4, int r5, int r6, int r7, int r8) {
            this.this$0 = r1;
            this.throughput = r2;
            this.jitter = r3;
            this.jitterWeight = r4;
            this.band = r5;
            this.rssi = r6;
            this.txLinkSpeed = r7;
            this.rxLinkSpeed = r8;
        }

        public String toString() {
            return "{\n        Throughput: " + this.throughput + "\n        Jitter: " + this.jitter + "\n        JitterWeight: " + this.jitterWeight + "\n        Band: " + this.band + "\n        rssi: " + this.rssi + "\n        txLinkSpeed: " + this.txLinkSpeed + "\n        rxLinkSpeed: " + this.rxLinkSpeed + "\n    }";
        }
    }

    public NetworkQualityResult() {
    }

    public NetworkQualityResult(int r1, int r2, int r3, String r4) {
        this.networkType = r1;
        this.level = r2;
        this.errorCode = r3;
        this.errorMsg = r4;
    }

    public WifiNetworkQuality getWifiNetworkQuality() {
        return this.wifiNetworkQuality;
    }

    public CellularNetworkQuality getCellularNetworkQuality() {
        return this.cellularNetworkQuality;
    }

    public void setWifiNetworkQuality(WifiNetworkQuality r1) {
        this.wifiNetworkQuality = r1;
    }

    public void setCellularNetworkQuality(CellularNetworkQuality r1) {
        this.cellularNetworkQuality = r1;
    }

    public NetworkQualityResult createWifiQualityResult(int r14, int r15, int r16, float r17, int r18, int r19, int r20, int r21) {
        NetworkQualityResult r0 = new NetworkQualityResult(1, r14, 0, "");
        r0.setWifiNetworkQuality(new WifiNetworkQuality(this, r15, r16, r17, r18, r19, r20, r21));
        return r0;
    }

    public NetworkQualityResult createCellularQualityResult(int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        NetworkQualityResult r0 = new NetworkQualityResult(2, r13, 0, "");
        r0.setCellularNetworkQuality(new CellularNetworkQuality(this, r14, r15, r16, r17, r18, r19));
        return r0;
    }

    public static NetworkQualityResult failed(int r3, int r4) {
        return new NetworkQualityResult(r3, 0, r4, CodeConverter.convertNetworkQualityErrorCode(r4));
    }

    public static NetworkQualityResult create() {
        return new NetworkQualityResult();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("NetworkQualityResult = {\n    NetworkType: ").append(CodeConverter.convertNetDetectType(this.networkType)).append("\n    Level: ").append(this.level).append("\n    WifiNetworkQuality: ");
        WifiNetworkQuality r1 = this.wifiNetworkQuality;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.toString();
    L6:
        StringBuilder r4 = r0.append(r3).append("\n    CellularNetworkQuality: ");
        CellularNetworkQuality r5 = this.cellularNetworkQuality;
        if (r5 == null) goto L10;
        r2 = r5.toString();
    L10:
        return r4.append(r2).append("\n    ErrorCode: ").append(this.errorCode).append("\n    ErrorMsg: ").append(this.errorMsg).append("\n}").toString();
    L5:
        r3 = null;
        goto L6
    }
}
