package com.obric.netdetect.Modules.HttpProbe;

import com.obric.netdetect.Utils.CodeConverter;

/* JADX INFO: loaded from: classes3.dex */
public class HttpProbeResult {
    public static final int ERROR_CODE_HTTP_PROBE_SOCKET_TIMEOUT = 4;
    public static final int ERROR_CODE_HTTP_PROBE_UNKNOWN_HOST = 3;
    public static final int ERROR_CODE_HTTP_PROBE_URL_INVALID = 2;
    public static final int ERROR_CODE_NETWORK_NOT_AVAILABLE = 1;
    public static final int ERROR_CODE_UNKNOWN = 0;
    public static final int FAILED_RESPONSE_CODE = 599;
    public static final int HTTP_PROBE_RESULT_FAILED = 3;
    public static final int HTTP_PROBE_RESULT_PORTAL = 2;
    public static final int HTTP_PROBE_RESULT_SUCCESS = 1;
    public static final int HTTP_PROBE_RESULT_UNKNOWN = 0;
    public static final int RTT_INVALID = -1;
    public static final int SUCCESS_RESPONSE_CODE_200 = 200;
    public static final int SUCCESS_RESPONSE_CODE_204 = 204;
    public int errorCode;
    public String errorMsg;
    public int networkType;
    public int probeResult;
    public String probeUrl;
    public String redirectUrl;
    public int responseCode;
    public int rtt;

    public static boolean isSuccessCode(int r1) {
        if (r1 != 204) goto L5;
        return true;
    L5:
        return false;
    }

    public HttpProbeResult(int r1, String r2, String r3, int r4, int r5, int r6, int r7, String r8) {
        this.networkType = r1;
        this.probeUrl = r2;
        this.redirectUrl = r3;
        this.probeResult = r4;
        this.rtt = r5;
        this.responseCode = r6;
        this.errorCode = r7;
        this.errorMsg = r8;
    }

    public static HttpProbeResult failed(int r10, String r11, int r12, int r13) {
        return new HttpProbeResult(r10, r11, null, 3, -1, r12, r13, CodeConverter.convertHttpProbeErrorCode(r13));
    }

    public static HttpProbeResult success(int r10, String r11, int r12, int r13) {
        return new HttpProbeResult(r10, r11, null, 1, r12, r13, 0, null);
    }

    public static HttpProbeResult portal(int r10, String r11, String r12, int r13) {
        return new HttpProbeResult(r10, r11, r12, 2, -1, r13, 0, null);
    }

    public static boolean isPortalCode(int r1) {
        if (isSuccessCode(r1) == false) goto L5;
    L9:
        return false;
    L5:
        if (r1 < 200) goto L9;
        if (r1 > 399) goto L9;
        return true;
    }

    public static boolean isFailedCode(int r1) {
        if (isSuccessCode(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (isPortalCode(r1) == true) goto L7;
        return true;
    }

    public String toString() {
        return "HttpProbeResult = {\n    NetworkType: " + CodeConverter.convertNetDetectType(this.networkType) + "\n    ProbeResult: " + CodeConverter.convertHttpProbeResult(this.probeResult) + "\n    HttpResponseCode: " + this.responseCode + "\n    ProbeUrl: " + this.probeUrl + "\n    RedirectUrl: " + this.redirectUrl + "\n    Rtt: " + this.rtt + "ms\n    ErrorCode: " + this.errorCode + "\n    ErrorMsg: " + this.errorMsg + "\n}";
    }
}
