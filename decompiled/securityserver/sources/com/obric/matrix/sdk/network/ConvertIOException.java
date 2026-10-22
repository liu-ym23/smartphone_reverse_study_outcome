package com.obric.matrix.sdk.network;

import android.util.Log;
import com.bytedance.common.utility.StringUtils;
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
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class ConvertIOException {
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
    public static final String TAG = "ConvertIOException";

    private ConvertIOException() {
    }

    public static int ConvertIOExceptionToStatus(Throwable r12, String[] r13) {
        int r4 = 1;
        if (r12 != null) goto L5;
        return 1;
    L5:
        if (r13 != null) goto L8;
        r13 = new String[1];
    L8:
        if ((r12 instanceof HttpResponseException) == false) goto L11;
        r4 = ((HttpResponseException) r12).getStatusCode();
    L134:
        if (r4 != 2) goto L67;
        String r14 = r12.getMessage();     // Catch: Exception -> L133
        Log.d(TAG, "SC_CONNECT_TIMEOUT " + r14);     // Catch: Exception -> L133
        Matcher r15 = Pattern.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r14);     // Catch: Exception -> L133
        if (r15.matches() == true) goto L61;
    L66:
        Log.d(TAG, "SC_CONNECT_TIMEOUT ip " + r13[0]);     // Catch: Exception -> L133
        return r4;
    L61:
        if (r15.group(3) == null) goto L64;
        r13[0] = r15.group(3);     // Catch: Exception -> L133
        goto L66
    L64:
        if (r15.group(4) == null) goto L66;
        r13[0] = r15.group(4);     // Catch: Exception -> L133
        goto L66
    L67:
        if (r4 != 8) goto L102;
        Throwable r16 = r12.getCause();     // Catch: Exception -> L133
        if (r16 != null) goto L71;
        return r4;
    L71:
        if ((r16 instanceof ConnectException) == false) goto L137;
        String r17 = r16.getMessage();     // Catch: Exception -> L133
        Log.d(TAG, "SC_CONNECT_EXCEPTION " + r17);     // Catch: Exception -> L133
        Matcher r18 = Pattern.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r17);     // Catch: Exception -> L133
        if (r18.matches() == true) goto L75;
        String r19 = null;
    L101:
        Log.d(TAG, "SC_CONNECT_EXCEPTION ip " + r13[0] + " " + r19);     // Catch: Exception -> L133
        return r4;
    L75:
        if (r18.group(3) == null) goto L78;
        r13[0] = r18.group(3);     // Catch: Exception -> L133
    L80:
        r19 = r18.group(7);     // Catch: Exception -> L133
        if (r19 == null) goto L101;
        if ("ECONNRESET".equals(r19) == false) goto L86;
        r4 = 12;
        goto L101
    L86:
        if ("ECONNREFUSED".equals(r19) == false) goto L89;
        r4 = 13;
        goto L101
    L89:
        if ("EHOSTUNREACH".equals(r19) == false) goto L92;
        r4 = 14;
        goto L101
    L92:
        if ("ENETUNREACH".equals(r19) == false) goto L95;
        r4 = 15;
        goto L101
    L95:
        if ("EADDRNOTAVAIL".equals(r19) == false) goto L98;
        r4 = 16;
        goto L101
    L98:
        if ("EADDRINUSE".equals(r19) == false) goto L101;
        r4 = 17;
        goto L101
    L78:
        if (r18.group(4) == null) goto L80;
        r13[0] = r18.group(4);     // Catch: Exception -> L133
        goto L80
    L137:
        return r4;
    L102:
        if (r4 != 4) goto L139;
        String r110 = r12.getMessage();     // Catch: Exception -> L133
        if (r110.indexOf(" EIO (I/O error)") <= 0) goto L107;
        return 37;
    L107:
        if ((r12 instanceof FileNotFoundException) == false) goto L110;
    L141:
        return 33;
    L110:
        if (r110.indexOf(" ENOENT ") > 0) goto L141;
        if (r110.indexOf("No such file or directory") > 0) goto L141;
        if (r110.indexOf(" ENOSPC ") <= 0) goto L117;
    L131:
        return 32;
    L117:
        if (r110.indexOf("No space left on device") > 0) goto L131;
        if (r110.indexOf(" EDQUOT ") <= 0) goto L123;
        return 34;
    L123:
        if (r110.indexOf(" EROFS ") <= 0) goto L126;
        return 35;
    L126:
        if (r110.indexOf(" EACCES ") <= 0) goto L129;
        return 36;
    L129:
        if (r110.indexOf("ERR_TTNET_REQUEST_TIMED_OUT") <= 0) goto L145;
        return 38;
    L145:
        return r4;
    L139:
        return r4;
    L147:
        return r4;
    L11:
        if ((r12 instanceof DownloadFileTooLargeException) == false) goto L14;
        r4 = 20;
        goto L134
    L14:
        if ((r12 instanceof ConnectTimeoutException) == false) goto L17;
    L15:
        r4 = 2;
        goto L134
    L17:
        if ((r12 instanceof SocketTimeoutException) == false) goto L25;
        if (StringUtils.isEmpty(r12.getMessage()) == false) goto L21;
    L23:
        r4 = 3;
        goto L134
    L21:
        if (r12.getMessage().contains("connect timed out") == false) goto L23;
    L25:
        if ((r12 instanceof BindException) == false) goto L28;
        r4 = 7;
        goto L134
    L28:
        if ((r12 instanceof ConnectException) == false) goto L31;
        r4 = 8;
        goto L134
    L31:
        if ((r12 instanceof NoRouteToHostException) == false) goto L34;
        r4 = 9;
        goto L134
    L34:
        if ((r12 instanceof PortUnreachableException) == false) goto L37;
        r4 = 10;
        goto L134
    L37:
        if ((r12 instanceof SocketException) == false) goto L45;
        String r5 = r12.getMessage();
        if (r5 != null) goto L41;
    L43:
        r4 = 5;
        goto L134
    L41:
        if (r5.indexOf("reset by peer") < 0) goto L43;
        r4 = 6;
        goto L134
    L45:
        if ((r12 instanceof UnknownHostException) == false) goto L48;
        r4 = 11;
        goto L134
    L48:
        if ((r12 instanceof NoHttpResponseException) == false) goto L51;
        r4 = 18;
        goto L134
    L51:
        if ((r12 instanceof ClientProtocolException) == false) goto L54;
        r4 = 19;
        goto L134
    L54:
        if ((r12 instanceof IOException) == false) goto L134;
        r4 = 4;
        goto L134
    }
}
