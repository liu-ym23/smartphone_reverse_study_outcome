package com.obric.matrix.sdk.network;

import android.util.Log;
import com.android.settings.utils.HanziToPinyin;
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

/* JADX INFO: loaded from: classes4.dex */
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
    L135:
        if (r4 != 2) goto L67;
        String r14 = r12.getMessage();     // Catch: Exception -> L134
        Log.d("ConvertIOException", "SC_CONNECT_TIMEOUT " + r14);     // Catch: Exception -> L134
        Matcher r15 = Pattern.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r14);     // Catch: Exception -> L134
        if (r15.matches() == true) goto L61;
    L66:
        Log.d("ConvertIOException", "SC_CONNECT_TIMEOUT ip " + r13[0]);     // Catch: Exception -> L134
        return r4;
    L61:
        if (r15.group(3) == null) goto L64;
        r13[0] = r15.group(3);     // Catch: Exception -> L134
        goto L66
    L64:
        if (r15.group(4) == null) goto L66;
        r13[0] = r15.group(4);     // Catch: Exception -> L134
        goto L66
    L67:
        if (r4 != 8) goto L102;
        Throwable r16 = r12.getCause();     // Catch: Exception -> L134
        if (r16 != null) goto L71;
        return r4;
    L71:
        if ((r16 instanceof ConnectException) == false) goto L137;
        String r17 = r16.getMessage();     // Catch: Exception -> L134
        Log.d("ConvertIOException", "SC_CONNECT_EXCEPTION " + r17);     // Catch: Exception -> L134
        Matcher r18 = Pattern.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r17);     // Catch: Exception -> L134
        if (r18.matches() == true) goto L75;
        String r19 = null;
    L101:
        Log.d("ConvertIOException", "SC_CONNECT_EXCEPTION ip " + r13[0] + HanziToPinyin.Token.SEPARATOR + r19);     // Catch: Exception -> L134
        return r4;
    L75:
        if (r18.group(3) == null) goto L78;
        r13[0] = r18.group(3);     // Catch: Exception -> L134
    L80:
        r19 = r18.group(7);     // Catch: Exception -> L134
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
        r13[0] = r18.group(4);     // Catch: Exception -> L134
        goto L80
    L137:
        return r4;
    L102:
        if (r4 != 4) goto L139;
        String r110 = r12.getMessage();     // Catch: Exception -> L134
        if (r110.indexOf(" EIO (I/O error)") <= 0) goto L108;
        int r111 = 37;
    L140:
        return r111;
    L108:
        if ((r12 instanceof FileNotFoundException) == false) goto L111;
    L141:
        return 33;
    L111:
        if (r110.indexOf(" ENOENT ") > 0) goto L141;
        if (r110.indexOf("No such file or directory") > 0) goto L141;
        if (r110.indexOf(" ENOSPC ") <= 0) goto L118;
    L132:
        r111 = 32;
        goto L140
    L118:
        if (r110.indexOf("No space left on device") > 0) goto L132;
        if (r110.indexOf(" EDQUOT ") <= 0) goto L124;
        r111 = 34;
        goto L140
    L124:
        if (r110.indexOf(" EROFS ") <= 0) goto L127;
        r111 = 35;
        goto L140
    L127:
        if (r110.indexOf(" EACCES ") <= 0) goto L130;
        r111 = 36;
        goto L140
    L130:
        if (r110.indexOf("ERR_TTNET_REQUEST_TIMED_OUT") <= 0) goto L142;
        r111 = 38;
        goto L140
    L142:
        return r4;
    L139:
        return r4;
    L143:
        return r4;
    L11:
        if ((r12 instanceof DownloadFileTooLargeException) == false) goto L14;
        r4 = 20;
        goto L135
    L14:
        if ((r12 instanceof ConnectTimeoutException) == false) goto L17;
    L15:
        r4 = 2;
        goto L135
    L17:
        if ((r12 instanceof SocketTimeoutException) == false) goto L25;
        if (StringUtils.isEmpty(r12.getMessage()) == false) goto L21;
    L23:
        r4 = 3;
        goto L135
    L21:
        if (r12.getMessage().contains("connect timed out") == false) goto L23;
    L25:
        if ((r12 instanceof BindException) == false) goto L28;
        r4 = 7;
        goto L135
    L28:
        if ((r12 instanceof ConnectException) == false) goto L31;
        r4 = 8;
        goto L135
    L31:
        if ((r12 instanceof NoRouteToHostException) == false) goto L34;
        r4 = 9;
        goto L135
    L34:
        if ((r12 instanceof PortUnreachableException) == false) goto L37;
        r4 = 10;
        goto L135
    L37:
        if ((r12 instanceof SocketException) == false) goto L45;
        String r5 = r12.getMessage();
        if (r5 != null) goto L41;
    L43:
        r4 = 5;
        goto L135
    L41:
        if (r5.indexOf("reset by peer") < 0) goto L43;
        r4 = 6;
        goto L135
    L45:
        if ((r12 instanceof UnknownHostException) == false) goto L48;
        r4 = 11;
        goto L135
    L48:
        if ((r12 instanceof NoHttpResponseException) == false) goto L51;
        r4 = 18;
        goto L135
    L51:
        if ((r12 instanceof ClientProtocolException) == false) goto L54;
        r4 = 19;
        goto L135
    L54:
        if ((r12 instanceof IOException) == false) goto L135;
        r4 = 4;
        goto L135
    }
}
