package com.obric.netdetect.Utils;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes3.dex */
public class CodeConverter {
    private static final String TAG = "ErrorCodeConverter";

    public static String convertCellularType(int r0) {
        switch(r0) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return "Unknown";
    L5:
        return "NR";
    L7:
        return "TD-SCDMA";
    L9:
        return "WCDMA";
    L11:
        return "LTE";
    L13:
        return "CDMA";
    L15:
        return "GSM";
    }

    public static String convertDnsResolveErrorCode(int r1) {
        if (r1 != 0) goto L4;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L4:
        if (r1 != 1) goto L6;
        return "network not available";
    L6:
        if (r1 != 2) goto L8;
        return "dns resolve url is invalid";
    L8:
        if (r1 != 4) goto L10;
        return "dns resolve url cannot be dns resolved";
    L10:
        if (r1 == 5) goto L13;
        return null;
    L13:
        return "dns resolve timeout";
    }

    public static String convertDnsResolveResult(int r1) {
        if (r1 != 0) goto L4;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L4:
        if (r1 != 1) goto L6;
        return "success";
    L6:
        if (r1 == 2) goto L9;
        return null;
    L9:
        return "failed";
    }

    public static String convertHttpProbeErrorCode(int r1) {
        if (r1 != 0) goto L4;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L4:
        if (r1 != 1) goto L6;
        return "network not available";
    L6:
        if (r1 != 2) goto L8;
        return "http probe url is invalid";
    L8:
        if (r1 != 3) goto L10;
        return "http probe url cannot be dns resolved";
    L10:
        if (r1 == 4) goto L13;
        return null;
    L13:
        return "http probe socket timeout";
    }

    public static String convertHttpProbeResult(int r1) {
        if (r1 != 0) goto L4;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L4:
        if (r1 != 1) goto L6;
        return "success";
    L6:
        if (r1 != 2) goto L8;
        return "portal";
    L8:
        if (r1 == 3) goto L11;
        return null;
    L11:
        return "failed";
    }

    public static String convertIpProbeResult(int r1) {
        if (r1 != 1) goto L5;
        return "failed";
    L5:
        if (r1 != 2) goto L7;
        return "available";
    L7:
        if (r1 == 3) goto L10;
        return null;
    L10:
        return "conflict";
    }

    public static String convertNetDetectType(int r1) {
        if (r1 != 1) goto L5;
        return "Wi-Fi";
    L5:
        if (r1 != 2) goto L7;
        return "Cellular";
    L7:
        if (r1 != 3) goto L9;
        return "Ethernet";
    L9:
        if (r1 == 4) goto L12;
        return "Unknown";
    L12:
        return "Bluetooth";
    }

    public static String convertNetworkInfoErrorCode(int r1) {
        if (r1 != 0) goto L4;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L4:
        if (r1 == 1) goto L7;
        return null;
    L7:
        return "network not available";
    }

    public static String convertNetworkQualityErrorCode(int r1) {
        if (r1 != 0) goto L4;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L4:
        if (r1 == 1) goto L7;
        return null;
    L7:
        return "network not available";
    }

    public static String convertPingErrorCode(int r1) {
        if (r1 != (-8)) goto L5;
        return "ping host ip unknown";
    L5:
        if (r1 != (-7)) goto L7;
        return "ping not supported";
    L7:
        if (r1 != (-5)) goto L9;
        return "ping not default network";
    L9:
        if (r1 != (-4)) goto L11;
        return "ping timeout";
    L11:
        if (r1 != (-3)) goto L13;
        return "ping recv fail";
    L13:
        if (r1 != (-2)) goto L15;
        return "ping send fail";
    L15:
        if (r1 == (-1)) goto L18;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L18:
        return "ping socket fail";
    }

    public static String convertPingResult(int r1) {
        if (r1 != 0) goto L4;
        return "failed";
    L4:
        if (r1 != 1) goto L6;
        return "partial";
    L6:
        if (r1 == 2) goto L9;
        return null;
    L9:
        return "success";
    }

    public CodeConverter() {
    }
}
