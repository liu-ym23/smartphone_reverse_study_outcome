package com.obric.netdetect.Modules.NetworkInfo;

import com.obric.netdetect.Utils.CodeConverter;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkInfoResult {
    public static final int ERROR_CODE_NETWORK_NOT_AVAILABLE = 1;
    public static final int ERROR_CODE_UNKNOWN = 0;
    private CellularInfo cellularInfo;
    public int errorCode;
    public String errorMsg;
    private IpInfo ipInfo;
    private LinkInfo linkInfo;
    public int networkId;
    public int networkType;
    private WifiConnInfo wifiConnInfo;

    public static class CellularInfo {
        public int[] bands;
        public int bandwidth;
        public long cellId;
        public int fcn;
        public int latitude;
        public int level;
        public int longitude;
        public String mcc;
        public int rscp;
        public int rsrp;
        public int rsrq;
        public int rssi;
        public int sinr;
        public int tac;
        public int type;

        public CellularInfo(int r4, int r5, String r6, long r7, int r9, int r10, int r11, int r12, int r13, int[] r14, int r15, int r16, int r17, int r18, int r19) {
            this.type = r4;
            this.level = r5;
            this.mcc = r6;
            this.cellId = r7;
            this.tac = r9;
            this.longitude = r10;
            this.latitude = r11;
            this.fcn = r12;
            this.bandwidth = r13;
            this.bands = r14;
            this.rssi = r15;
            this.rscp = r16;
            this.rsrp = r17;
            this.rsrq = r18;
            this.sinr = r19;
        }

        public String toString() {
            return "{\n        Type: " + CodeConverter.convertCellularType(this.type) + "\n        Level: " + this.level + "\n        Mcc: " + this.mcc + "\n        CellId: " + this.cellId + "\n        Tac: " + this.tac + "\n        Longitude: " + this.longitude + "\n        Latitude: " + this.latitude + "\n        Fcn: " + this.fcn + "\n        Bandwidth: " + this.bandwidth + "\n        Bands: " + Arrays.toString(this.bands) + "\n        Rssi: " + this.rssi + "\n        Rscp: " + this.rscp + "\n        Rsrp: " + this.rsrp + "\n        Rsrq: " + this.rsrq + "\n        Sinr: " + this.sinr + "\n    }";
        }
    }

    public static class IpInfo {
        String city;
        String country;
        String location;
        String postal;
        String provider;
        String region;
        String timezone;
        String wanIp;

        public IpInfo(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
            this.wanIp = r1;
            this.country = r2;
            this.region = r3;
            this.city = r4;
            this.location = r5;
            this.provider = r6;
            this.postal = r7;
            this.timezone = r8;
        }

        public String toString() {
            return "{\n        WanIp： " + this.wanIp + "\n        Country： " + this.country + "\n        Region： " + this.region + "\n        City： " + this.city + "\n        Location： " + this.location + "\n        Provider： " + this.provider + "\n        Postal： " + this.postal + "\n        Timezone： " + this.timezone + "\n    }";
        }
    }

    public static class LinkInfo {
        public String dhcpServer;
        public List<String> dnsServers;
        public String ipv4Address;
        public String ipv4Gateway;
        public String ipv6Address;
        public String ipv6Gateway;

        public LinkInfo(String r1, String r2, String r3, String r4, String r5, List<String> r6) {
            this.ipv4Address = r1;
            this.ipv6Address = r2;
            this.ipv4Gateway = r3;
            this.ipv6Gateway = r4;
            this.dhcpServer = r5;
            this.dnsServers = r6;
        }

        public String toString() {
            return "{\n        Ipv4Address: " + this.ipv4Address + "\n        Ipv6Address: " + this.ipv6Address + "\n        Ipv4Gateway: " + this.ipv4Gateway + "\n        Ipv6Gateway: " + this.ipv6Gateway + "\n        DhcpServer: " + this.dhcpServer + "\n        DnsServers: " + Arrays.toString(this.dnsServers.toArray()) + "\n    }";
        }
    }

    public static class WifiConnInfo {
        public int band;
        public String bssid;
        public int frequency;
        public int rssi;
        public int rxLinkSpeed;
        public int securityType;
        public String ssid;
        public int txLinkSpeed;
        public int wifiStandard;

        public WifiConnInfo(String r1, String r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            this.ssid = r1;
            this.bssid = r2;
            this.frequency = r3;
            this.band = r4;
            this.wifiStandard = r5;
            this.securityType = r6;
            this.rssi = r7;
            this.txLinkSpeed = r8;
            this.rxLinkSpeed = r9;
        }

        public String toString() {
            return "{\n        Ssid: " + this.ssid + "\n        Bssid: " + this.bssid + "\n        Frequency: " + this.frequency + "\n        Band: " + this.band + "\n        WifiStandard: " + this.wifiStandard + "\n        SecurityType: " + this.securityType + "\n        Rssi: " + this.rssi + "\n        TxLinkSpeed: " + this.txLinkSpeed + "\n        RxLinkSpeed: " + this.rxLinkSpeed + "\n    }";
        }
    }

    public NetworkInfoResult(int r1, int r2, int r3, String r4) {
        this.networkType = r1;
        this.networkId = r2;
        this.errorCode = r3;
        this.errorMsg = r4;
    }

    public NetworkInfoResult(int r1, int r2, WifiConnInfo r3, CellularInfo r4, LinkInfo r5, IpInfo r6) {
        this.networkType = r1;
        this.networkId = r2;
        this.wifiConnInfo = r3;
        this.cellularInfo = r4;
        this.linkInfo = r5;
        this.ipInfo = r6;
    }

    public static NetworkInfoResult failed(int r3, int r4) {
        return new NetworkInfoResult(r3, -1, r4, CodeConverter.convertNetworkInfoErrorCode(r4));
    }

    public WifiConnInfo getWifiConnInfo() {
        return this.wifiConnInfo;
    }

    public CellularInfo getCellularInfo() {
        return this.cellularInfo;
    }

    public LinkInfo getLinkInfo() {
        return this.linkInfo;
    }

    public IpInfo getIpInfo() {
        return this.ipInfo;
    }

    public void setWifiInfo(WifiConnInfo r1) {
        this.wifiConnInfo = r1;
    }

    public void setCellularInfo(CellularInfo r1) {
        this.cellularInfo = r1;
    }

    public void setLinkInfo(LinkInfo r1) {
        this.linkInfo = r1;
    }

    public void setIpInfo(IpInfo r1) {
        this.ipInfo = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("NetworkInfoResult = {\n    NetworkType: ").append(CodeConverter.convertNetDetectType(this.networkType)).append("\n    NetworkId: ").append(this.networkId).append("\n    WifiInfo: ");
        WifiConnInfo r1 = this.wifiConnInfo;
        String r2 = null;
        if (r1 != null) goto L5;
        String r3 = null;
    L6:
        StringBuilder r4 = r0.append(r3).append("\n    CellularInfo: ");
        CellularInfo r5 = this.cellularInfo;
        if (r5 != null) goto L9;
        String r6 = null;
    L10:
        StringBuilder r7 = r4.append(r6).append("\n    LinkInfo: ");
        LinkInfo r8 = this.linkInfo;
        if (r8 != null) goto L13;
        String r9 = null;
    L14:
        StringBuilder r10 = r7.append(r9).append("\n    IpInfo: ");
        IpInfo r11 = this.ipInfo;
        if (r11 == null) goto L19;
        r2 = r11.toString();
    L19:
        return r10.append(r2).append("\n    ErrorCode: ").append(this.errorCode).append("\n    ErrorMsg: ").append(this.errorMsg).append("\n}").toString();
    L13:
        r9 = r8.toString();
        goto L14
    L9:
        r6 = r5.toString();
        goto L10
    L5:
        r3 = r1.toString();
        goto L6
    }
}
