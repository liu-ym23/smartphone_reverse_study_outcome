package com.ss.android.k.c;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.k;
import d.b.h.a.a.h.l.d;
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
public final class a {
    public static int a(Throwable r8, String[] r9) {
        int r0 = 1;
        if (r8 != null) goto L5;
        return 1;
    L5:
        if (r9 != null) goto L8;
        r9 = new String[1];
    L8:
        if ((r8 instanceof d) == false) goto L11;
        r0 = ((d) r8).c();
    L142:
        if (r0 != 2) goto L69;
        String r10 = r8.getMessage();     // Catch: Exception -> L141
        if (Logger.debug() == false) goto L57;
        Logger.d("NetUtils", "SC_CONNECT_TIMEOUT " + r10);     // Catch: Exception -> L141
    L57:
        Matcher r11 = Pattern.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r10);     // Catch: Exception -> L141
        if (r11.matches() == false) goto L66;
        if (r11.group(3) == null) goto L63;
        r9[0] = r11.group(3);     // Catch: Exception -> L141
        goto L66
    L63:
        if (r11.group(4) == null) goto L66;
        r9[0] = r11.group(4);     // Catch: Exception -> L141
    L66:
        if (Logger.debug() == false) goto L140;
        StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L141
        r12.append("SC_CONNECT_TIMEOUT ip ");     // Catch: Exception -> L141
        r12.append(r9[0]);     // Catch: Exception -> L141
    L68:
        Logger.d("NetUtils", r12.toString());     // Catch: Exception -> L141
        return r0;
    L140:
        return r0;
    L69:
        if (r0 != 8) goto L109;
        Throwable r13 = r8.getCause();     // Catch: Exception -> L141
        if (r13 != null) goto L73;
        return r0;
    L73:
        if ((r13 instanceof ConnectException) == false) goto L145;
        String r14 = r13.getMessage();     // Catch: Exception -> L141
        if (Logger.debug() == false) goto L77;
        Logger.d("NetUtils", "SC_CONNECT_EXCEPTION " + r14);     // Catch: Exception -> L141
    L77:
        Matcher r15 = Pattern.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r14);     // Catch: Exception -> L141
        String r3 = null;
        if (r15.matches() == false) goto L107;
        if (r15.group(3) == null) goto L83;
        r9[0] = r15.group(3);     // Catch: Exception -> L141
    L85:
        r3 = r15.group(7);     // Catch: Exception -> L141
        if (r3 == null) goto L107;
        if ("ECONNRESET".equals(r3) == false) goto L92;
        int r16 = 12;
    L90:
        r0 = r16;
        goto L107
    L92:
        if ("ECONNREFUSED".equals(r3) == false) goto L95;
        r16 = 13;
        goto L90
    L95:
        if ("EHOSTUNREACH".equals(r3) == false) goto L98;
        r16 = 14;
        goto L90
    L98:
        if ("ENETUNREACH".equals(r3) == false) goto L101;
        r16 = 15;
        goto L90
    L101:
        if ("EADDRNOTAVAIL".equals(r3) == false) goto L104;
        r16 = 16;
        goto L90
    L104:
        if ("EADDRINUSE".equals(r3) == false) goto L107;
        r16 = 17;
        goto L90
    L83:
        if (r15.group(4) == null) goto L85;
        r9[0] = r15.group(4);     // Catch: Exception -> L141
    L107:
        if (Logger.debug() == false) goto L146;
        r12 = new StringBuilder();     // Catch: Exception -> L141
        r12.append("SC_CONNECT_EXCEPTION ip ");     // Catch: Exception -> L141
        r12.append(r9[0]);     // Catch: Exception -> L141
        r12.append(" ");     // Catch: Exception -> L141
        r12.append(r3);     // Catch: Exception -> L141
        goto L68
    L146:
        return r0;
    L145:
        return r0;
    L109:
        if (r0 != 4) goto L147;
        String r17 = r8.getMessage();     // Catch: Exception -> L141
        if (r17.indexOf(" EIO (I/O error)") <= 0) goto L115;
        int r18 = 37;
    L148:
        return r18;
    L115:
        if ((r8 instanceof FileNotFoundException) == false) goto L118;
    L149:
        return 33;
    L118:
        if (r17.indexOf(" ENOENT ") > 0) goto L149;
        if (r17.indexOf("No such file or directory") > 0) goto L149;
        if (r17.indexOf(" ENOSPC ") <= 0) goto L125;
    L139:
        r18 = 32;
        goto L148
    L125:
        if (r17.indexOf("No space left on device") > 0) goto L139;
        if (r17.indexOf(" EDQUOT ") <= 0) goto L131;
        r18 = 34;
        goto L148
    L131:
        if (r17.indexOf(" EROFS ") <= 0) goto L134;
        r18 = 35;
        goto L148
    L134:
        if (r17.indexOf(" EACCES ") <= 0) goto L137;
        r18 = 36;
        goto L148
    L137:
        if (r17.indexOf("ERR_TTNET_REQUEST_TIMED_OUT") <= 0) goto L150;
        r18 = 38;
        goto L148
    L150:
        return r0;
    L147:
        return r0;
    L151:
        return r0;
    L11:
        if ((r8 instanceof d.b.h.a.a.h.s.d) == false) goto L14;
        r0 = 20;
        goto L142
    L14:
        if ((r8 instanceof ConnectTimeoutException) == false) goto L17;
    L15:
        r0 = 2;
        goto L142
    L17:
        if ((r8 instanceof SocketTimeoutException) == false) goto L25;
        if (k.c(r8.getMessage()) == false) goto L21;
    L23:
        r0 = 3;
        goto L142
    L21:
        if (r8.getMessage().contains("connect timed out") == false) goto L23;
    L25:
        if ((r8 instanceof BindException) == false) goto L28;
        r0 = 7;
        goto L142
    L28:
        if ((r8 instanceof ConnectException) == false) goto L31;
        r0 = 8;
        goto L142
    L31:
        if ((r8 instanceof NoRouteToHostException) == false) goto L34;
        r0 = 9;
        goto L142
    L34:
        if ((r8 instanceof PortUnreachableException) == false) goto L37;
        r0 = 10;
        goto L142
    L37:
        if ((r8 instanceof SocketException) == false) goto L44;
        r0 = 5;
        String r1 = r8.getMessage();
        if (r1 == null) goto L142;
        if (r1.indexOf("reset by peer") < 0) goto L142;
        r0 = 6;
        goto L142
    L44:
        if ((r8 instanceof UnknownHostException) == false) goto L47;
        r0 = 11;
        goto L142
    L47:
        if ((r8 instanceof d.b.h.a.a.h.l.b) == false) goto L50;
        r0 = 19;
        goto L142
    L50:
        if ((r8 instanceof IOException) == false) goto L142;
        r0 = 4;
        goto L142
    }
}
