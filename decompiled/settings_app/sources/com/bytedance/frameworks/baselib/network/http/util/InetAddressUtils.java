package com.bytedance.frameworks.baselib.network.http.util;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class InetAddressUtils {
    private static final Pattern IPV4_PATTERN = null;
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = null;
    private static final Pattern IPV6_STD_PATTERN = null;

    private InetAddressUtils() {
    }

    static {
        IPV4_PATTERN = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        IPV6_STD_PATTERN = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean isIPv4Address(String r1) {
        return IPV4_PATTERN.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean isIPv6StdAddress(String r1) {
        return IPV6_STD_PATTERN.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean isIPv6HexCompressedAddress(String r1) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean isIPv6Address(String r1) {
        if (isIPv6StdAddress(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (isIPv6HexCompressedAddress(r1) == true) goto L8;
        return false;
    }
}
