package cz.msebera.android.httpclient.conn.util;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class InetAddressUtils {
    private static final char COLON_CHAR = ':';
    private static final String IPV4_BASIC_PATTERN_STRING = "(([1-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){1}(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){2}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
    private static final Pattern IPV4_MAPPED_IPV6_PATTERN = null;
    private static final Pattern IPV4_PATTERN = null;
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = null;
    private static final Pattern IPV6_STD_PATTERN = null;
    private static final int MAX_COLON_COUNT = 7;

    private InetAddressUtils() {
    }

    static {
        IPV4_PATTERN = Pattern.compile("^(([1-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){1}(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){2}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
        IPV4_MAPPED_IPV6_PATTERN = Pattern.compile("^::[fF]{4}:(([1-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){1}(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){2}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
        IPV6_STD_PATTERN = Pattern.compile("^[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}$");
        IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)::(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)$");
    }

    public static boolean isIPv4Address(String r1) {
        return IPV4_PATTERN.matcher(r1).matches();
    }

    public static boolean isIPv4MappedIPv64Address(String r1) {
        return IPV4_MAPPED_IPV6_PATTERN.matcher(r1).matches();
    }

    public static boolean isIPv6StdAddress(String r1) {
        return IPV6_STD_PATTERN.matcher(r1).matches();
    }

    public static boolean isIPv6HexCompressedAddress(String r5) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r5.length()) goto L10;
        if (r5.charAt(r1) != ':') goto L8;
        r2 = r2 + 1;
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        if (r2 <= 7) goto L12;
        return false;
    L12:
        if (IPV6_HEX_COMPRESSED_PATTERN.matcher(r5).matches() == false) goto L19;
        return true;
    L19:
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
