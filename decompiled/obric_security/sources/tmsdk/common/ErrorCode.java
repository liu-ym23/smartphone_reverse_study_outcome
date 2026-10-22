package tmsdk.common;

import tmsdkobf.q8;

/* JADX INFO: loaded from: classes5.dex */
public class ErrorCode {
    public static final int ERR_ARGUMENT = -6;
    public static final int ERR_CANCEL = -3;
    public static final int ERR_CONNECT_FORBID = -64;
    public static final int ERR_FILE_OP = -7000;
    public static final int ERR_FROM_SERVER = -205;
    public static final int ERR_GENERAL = -2;
    public static final int ERR_GET = -3000;
    public static final int ERR_ILLEGAL_ACCESS = -60;
    public static final int ERR_ILLEGAL_ARG = -57;
    public static final int ERR_ILLEGAL_STATE = -61;
    public static final int ERR_IO_EXCEPTION = -56;
    public static final int ERR_LICENSE_EXPIRED = -99999;
    public static final int ERR_MERGE_DIFF_OP = -8000;
    public static final int ERR_NONE = 0;
    public static final int ERR_NOT_COMPLETED = -7;
    public static final int ERR_NOT_FOUND = -1;
    public static final int ERR_NO_CONNECTION = -52;
    public static final int ERR_OPEN_CONNECTION = -1000;
    public static final int ERR_POST = -2000;
    public static final int ERR_PROTOCOL = -51;
    public static final int ERR_RECEIVE = -5000;
    public static final int ERR_RESPONSE = -4000;
    public static final int ERR_SECURITY = -58;
    public static final int ERR_SHARKNET_BASE = -65;
    public static final int ERR_SOCKET = -54;
    public static final int ERR_SOCKET_TIMEOUT = -55;
    public static final int ERR_UNKNOW = -999;
    public static final int ERR_UNKNOWN_HOST = -62;
    public static final int ERR_UNSUPPORTED_OP = -59;
    public static final int ERR_URL_MALFORMED = -53;
    public static final int ERR_WIFI_AUTHENTICATION = -63;
    public static final int ERR_WUP = -6000;
    public static final int WIFICONN_ASSERT_FILE_PROP_ERROR = -10125;
    public static final int WIFICONN_AUTO_CONNECT_FAILED = -10114;
    public static final int WIFICONN_AUTO_CONNECT_TIMEOUT = -10115;
    public static final int WIFICONN_CANCEL = -10123;
    public static final int WIFICONN_CATCH_AND_ENABLE_FAILED = -10122;
    public static final int WIFICONN_CHECK_FAILED = -10101;
    public static final int WIFICONN_CHECK_SUCCESS = -10102;
    public static final int WIFICONN_CHECK_SUCCESS_WITHOUT_NETWORK = -10103;
    public static final int WIFICONN_CHECK_WITHOUT_WIFI_MANAGER = -10104;
    public static final int WIFICONN_CONFIG_INVALID = -10106;
    public static final int WIFICONN_CONNECT_SUCCESS = -10105;
    public static final int WIFICONN_CONNECT_TIMEOUT = -10110;
    public static final int WIFICONN_CONNECT_UNKNOWN_ERROR = -10111;
    public static final int WIFICONN_CREATE_WIFI_CONFIG_ERROR = -10117;
    public static final int WIFICONN_DECRYPT_PASSWORD_ERROR = -10116;
    public static final int WIFICONN_ENABLE_NETWORK_FAILED = -10119;
    public static final int WIFICONN_GET_WIFI_CONFIGS_ERROR = -10118;
    public static final int WIFICONN_GUID_OR_HOST_ERROR = -10116;
    public static final int WIFICONN_NETWORK_VALUE_ERROR = -10121;
    public static final int WIFICONN_PASSWORD_ERROR = -10109;
    public static final int WIFICONN_ROUTER_ABNORMAL = -10107;
    public static final int WIFICONN_ROUTER_OVERLOAD = -10108;
    public static final int WIFICONN_TRY_OVER = -10120;
    public static final int WIFICONN_UNZIP_ASSERT_FILE_FAILED = -10124;
    public static final int WIFICONN_WIFI_DISABLED = -10112;
    public static final int WIFICONN_WIFI_INTERRUPT_BY_NEW_CONNECTION = -10113;
    public static final int W_TIMEOUT = -206;

    public ErrorCode() {
    }

    public static int fromESharkCode(int r2) {
        q8.d("TMSDK_", "ESharkCod = " + r2);
        if (r2 != 0) goto L6;
        return 0;
    L6:
        return -65;
    }
}
