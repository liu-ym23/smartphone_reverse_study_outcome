package com.ss.android.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.component.silkroad.mohist.http.R;
import com.bytedance.frameworks.baselib.network.http.exception.ClientProtocolException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NoHttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.DownloadFileTooLargeException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class NetUtils {
    public static final int SC_BIND_EXCEPTION = 7;
    public static final int SC_CLIENT_PROTOCOL_EXCEPTION = 19;
    public static final int SC_CONNECT_EXCEPTION = 8;
    public static final int SC_CONNECT_TIMEOUT = 2;
    public static final int SC_EACCES = 36;
    public static final int SC_EADDRINUSE = 17;
    public static final int SC_EADDRNOTAVAIL = 16;
    public static final int SC_ECONNREFUSED = 13;
    public static final int SC_ECONNRESET = 12;
    public static final int SC_EDQUOT = 34;
    public static final int SC_EHOSTUNREACH = 14;
    public static final int SC_EIO = 37;
    public static final int SC_ENETUNREACH = 15;
    public static final int SC_ENOENT = 33;
    public static final int SC_EROFS = 35;
    public static final int SC_FILE_TOO_LARGE = 20;
    public static final int SC_IO_EXCEPTION = 4;
    public static final int SC_NO_HTTP_RESPONSE = 18;
    public static final int SC_NO_REOUTE_TO_HOST = 9;
    public static final int SC_NO_SPACE = 32;
    public static final int SC_PORT_UNREACHABLE = 10;
    public static final int SC_RESET_BY_PEER = 6;
    public static final int SC_SOCKET_EXCEPTION = 5;
    public static final int SC_SOCKET_TIMEOUT = 3;
    public static final int SC_TTNET_TIME_OUT = 38;
    public static final int SC_UNKNOWN = 1;
    public static final int SC_UNKNOWN_HOST = 11;
    public static final String TAG = "NetUtils";

    private NetUtils() {
    }

    public static int checkApiException(Context r6, Throwable r7) {
        if ((r7 instanceof ConnectTimeoutException) == false) goto L6;
        int r8 = 13;
    L26:
        if (r6 == null) goto L33;
        if (r8 == 15) goto L30;
        if (r8 == 14) goto L30;
        return r8;
    L30:
        if (isNetworkAvailable(r6) == true) goto L35;
        return 12;
    L35:
        return r8;
    L33:
        return r8;
    L6:
        if ((r7 instanceof SocketTimeoutException) == false) goto L9;
        r8 = 14;
        goto L26
    L9:
        if ((r7 instanceof SocketException) == false) goto L13;
        Logger.v(TAG, "api socket exception: " + r7);
    L11:
        r8 = 15;
        goto L26
    L13:
        if ((r7 instanceof SSLPeerUnverifiedException) == false) goto L16;
        Logger.v(TAG, "api ssl exception: " + r7);
        r8 = 21;
        goto L26
    L16:
        if ((r7 instanceof HttpResponseException) == false) goto L23;
        if (((HttpResponseException) r7).getStatusCode() != 503) goto L20;
        int r0 = 19;
    L21:
        Logger.w(TAG, "server error: " + r7);
        r8 = r0;
        goto L26
    L20:
        r0 = 16;
        goto L21
    L23:
        if ((r7 instanceof IOException) == false) goto L25;
        Logger.v(TAG, "api io exception: " + r7);
        goto L11
    L25:
        Logger.w(TAG, "api exception: " + r7);
        r8 = 18;
        goto L26
    }

    public static int checkHttpRequestException(Throwable r12, String[] r13) {
        int r4 = 1;
        if (r12 != null) goto L5;
        return 1;
    L5:
        if (r13 != null) goto L8;
        r13 = new String[1];
    L8:
        if ((r12 instanceof HttpResponseException) == false) goto L11;
        r4 = ((HttpResponseException) r12).getStatusCode();
    L144:
        if (r4 != 2) goto L72;
        String r14 = r12.getMessage();     // Catch: Exception -> L143
        if (Logger.debug() == false) goto L61;
        Logger.d(TAG, "SC_CONNECT_TIMEOUT " + r14);     // Catch: Exception -> L143
    L61:
        Matcher r15 = Pattern.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r14);     // Catch: Exception -> L143
        if (r15.matches() == false) goto L70;
        if (r15.group(3) == null) goto L67;
        r13[0] = r15.group(3);     // Catch: Exception -> L143
        goto L70
    L67:
        if (r15.group(4) == null) goto L70;
        r13[0] = r15.group(4);     // Catch: Exception -> L143
    L70:
        if (Logger.debug() == false) goto L145;
        Logger.d(TAG, "SC_CONNECT_TIMEOUT ip " + r13[0]);     // Catch: Exception -> L143
        return r4;
    L145:
        return r4;
    L72:
        if (r4 != 8) goto L112;
        Throwable r16 = r12.getCause();     // Catch: Exception -> L143
        if (r16 != null) goto L76;
        return r4;
    L76:
        if ((r16 instanceof ConnectException) == false) goto L148;
        String r17 = r16.getMessage();     // Catch: Exception -> L143
        if (Logger.debug() == false) goto L80;
        Logger.d(TAG, "SC_CONNECT_EXCEPTION " + r17);     // Catch: Exception -> L143
    L80:
        Matcher r18 = Pattern.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r17);     // Catch: Exception -> L143
        if (r18.matches() == true) goto L83;
        String r19 = null;
    L110:
        if (Logger.debug() == false) goto L149;
        Logger.d(TAG, "SC_CONNECT_EXCEPTION ip " + r13[0] + " " + r19);     // Catch: Exception -> L143
        return r4;
    L149:
        return r4;
    L83:
        if (r18.group(3) == null) goto L86;
        r13[0] = r18.group(3);     // Catch: Exception -> L143
    L88:
        r19 = r18.group(7);     // Catch: Exception -> L143
        if (r19 == null) goto L110;
        if ("ECONNRESET".equals(r19) == false) goto L94;
        r4 = 12;
        goto L110
    L94:
        if ("ECONNREFUSED".equals(r19) == false) goto L97;
        r4 = 13;
        goto L110
    L97:
        if ("EHOSTUNREACH".equals(r19) == false) goto L100;
        r4 = 14;
        goto L110
    L100:
        if ("ENETUNREACH".equals(r19) == false) goto L103;
        r4 = 15;
        goto L110
    L103:
        if ("EADDRNOTAVAIL".equals(r19) == false) goto L106;
        r4 = 16;
        goto L110
    L106:
        if ("EADDRINUSE".equals(r19) == false) goto L110;
        r4 = 17;
        goto L110
    L86:
        if (r18.group(4) == null) goto L88;
        r13[0] = r18.group(4);     // Catch: Exception -> L143
        goto L88
    L148:
        return r4;
    L112:
        if (r4 != 4) goto L151;
        String r110 = r12.getMessage();     // Catch: Exception -> L143
        if (r110.indexOf(" EIO (I/O error)") <= 0) goto L117;
        return 37;
    L117:
        if ((r12 instanceof FileNotFoundException) == false) goto L120;
    L153:
        return 33;
    L120:
        if (r110.indexOf(" ENOENT ") > 0) goto L153;
        if (r110.indexOf("No such file or directory") > 0) goto L153;
        if (r110.indexOf(" ENOSPC ") <= 0) goto L127;
    L141:
        return 32;
    L127:
        if (r110.indexOf("No space left on device") > 0) goto L141;
        if (r110.indexOf(" EDQUOT ") <= 0) goto L133;
        return 34;
    L133:
        if (r110.indexOf(" EROFS ") <= 0) goto L136;
        return 35;
    L136:
        if (r110.indexOf(" EACCES ") <= 0) goto L139;
        return 36;
    L139:
        if (r110.indexOf("ERR_TTNET_REQUEST_TIMED_OUT") <= 0) goto L157;
        return 38;
    L157:
        return r4;
    L151:
        return r4;
    L159:
        return r4;
    L11:
        if ((r12 instanceof DownloadFileTooLargeException) == false) goto L14;
        r4 = 20;
        goto L144
    L14:
        if ((r12 instanceof ConnectTimeoutException) == false) goto L17;
    L15:
        r4 = 2;
        goto L144
    L17:
        if ((r12 instanceof SocketTimeoutException) == false) goto L25;
        if (StringUtils.isEmpty(r12.getMessage()) == false) goto L21;
    L23:
        r4 = 3;
        goto L144
    L21:
        if (r12.getMessage().contains("connect timed out") == false) goto L23;
    L25:
        if ((r12 instanceof BindException) == false) goto L28;
        r4 = 7;
        goto L144
    L28:
        if ((r12 instanceof ConnectException) == false) goto L31;
        r4 = 8;
        goto L144
    L31:
        if ((r12 instanceof NoRouteToHostException) == false) goto L34;
        r4 = 9;
        goto L144
    L34:
        if ((r12 instanceof PortUnreachableException) == false) goto L37;
        r4 = 10;
        goto L144
    L37:
        if ((r12 instanceof SocketException) == false) goto L45;
        String r5 = r12.getMessage();
        if (r5 != null) goto L41;
    L43:
        r4 = 5;
        goto L144
    L41:
        if (r5.indexOf("reset by peer") < 0) goto L43;
        r4 = 6;
        goto L144
    L45:
        if ((r12 instanceof UnknownHostException) == false) goto L48;
        r4 = 11;
        goto L144
    L48:
        if ((r12 instanceof NoHttpResponseException) == false) goto L51;
        r4 = 18;
        goto L144
    L51:
        if ((r12 instanceof ClientProtocolException) == false) goto L54;
        r4 = 19;
        goto L144
    L54:
        if ((r12 instanceof IOException) == false) goto L144;
        r4 = 4;
        goto L144
    }

    public static int getApiErrorStringRes(int r0) {
        switch(r0) {
            case 12: goto L18;
            case 13: goto L16;
            case 14: goto L14;
            case 15: goto L12;
            case 16: goto L10;
            case 17: goto L8;
            case 18: goto L4;
            case 19: goto L6;
            default: goto L4;
        };
    L4:
        return R.string.ss_error_unknown;
    L6:
        return R.string.ss_error_service_unavailable;
    L8:
        return R.string.ss_error_api_error;
    L10:
        return R.string.ss_error_server_error;
    L12:
        return R.string.ss_error_network_error;
    L14:
        return R.string.ss_error_network_timeout;
    L16:
        return R.string.ss_error_connect_timeout;
    L18:
        return R.string.ss_error_no_connections;
    }

    public static String getNetWorkType(Context r2) {
        if (r2 != null) goto L17;
        return null;
    L17:
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L12
        if (r3 != null) goto L8;
    L14:
        return null;
    L8:
        if (r3.isAvailable() == false) goto L14;
        return r3.getTypeName();
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean isNetworkAvailable(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L8
        if (r3 == null) goto L10;
        if (r3.isAvailable() == false) goto L15;
        return true;
    L15:
        return false;
    L10:
        return false;
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
