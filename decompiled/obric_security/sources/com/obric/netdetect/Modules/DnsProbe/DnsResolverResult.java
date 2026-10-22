package com.obric.netdetect.Modules.DnsProbe;

import com.obric.netdetect.Utils.CodeConverter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class DnsResolverResult {
    public static final int ERROR_CODE_HOST_INVALID = 3;
    public static final int ERROR_CODE_NETWORK_NOT_AVAILABLE = 1;
    public static final int ERROR_CODE_TIMEOUT = 5;
    public static final int ERROR_CODE_UNKNOWN = 0;
    public static final int ERROR_CODE_UNKNOWN_HOST = 4;
    public static final int ERROR_CODE_URL_INVALID = 2;
    public static final int RESULT_FAILED = 2;
    public static final int RESULT_SUCCESS = 1;
    public static final int RESULT_UNKNOWN = 0;
    public int errorCode;
    public String errorMessage;
    public String hostname;
    public String[] ipv4Addresses;
    public String[] ipv6Addresses;
    public int networkType;
    public int resolveResult;

    public DnsResolverResult(int r1, int r2, String r3, String[] r4, String[] r5, int r6, String r7) {
        this.networkType = r1;
        this.resolveResult = r2;
        this.hostname = r3;
        this.ipv4Addresses = r4;
        this.ipv6Addresses = r5;
        this.errorCode = r6;
        this.errorMessage = r7;
    }

    public static DnsResolverResult success(int r9, String r10, String[] r11, String[] r12) {
        return new DnsResolverResult(r9, 1, r10, r11, r12, 0, null);
    }

    public static DnsResolverResult failed(int r9, String r10, int r11) {
        return new DnsResolverResult(r9, 2, r10, null, null, r11, CodeConverter.convertDnsResolveErrorCode(r11));
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("DnsResolverResult = {\n    NetworkType: ").append(CodeConverter.convertNetDetectType(this.networkType)).append("\n    ResolveResult: ").append(CodeConverter.convertDnsResolveResult(this.resolveResult)).append("\n    HostName: ").append(this.hostname).append("\n    Ipv4Addresses: ");
        String[] r1 = this.ipv4Addresses;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = Arrays.toString(r1);
    L6:
        StringBuilder r4 = r0.append(r3).append("\n    Ipv6Addresses: ");
        String[] r5 = this.ipv6Addresses;
        if (r5 == null) goto L10;
        r2 = Arrays.toString(r5);
    L10:
        return r4.append(r2).append("\n    ErrorCode: ").append(this.errorCode).append("\n    ErrorMessage: ").append(this.errorMessage).append("\n}").toString();
    L5:
        r3 = null;
        goto L6
    }
}
