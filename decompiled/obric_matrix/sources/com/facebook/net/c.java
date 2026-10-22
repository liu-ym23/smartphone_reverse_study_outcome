package com.facebook.net;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.k;
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
public class c {
    public static int a(Throwable r9, String[] r10) {
        int r0 = 1;
        if (r9 != null) goto L5;
        return 1;
    L5:
        if (r10 != null) goto L7;
        r10 = new String[1];
    L7:
        int r4 = 40;
        if ((r9 instanceof d.b.h.a.a.h.l.d) == false) goto L11;
        r0 = ((d.b.h.a.a.h.l.d) r9).c();
    L54:
        boolean r1 = r9 instanceof IOException;
        if (r1 == true) goto L57;
    L59:
        r4 = r0;
    L61:
        if (r1 == true) goto L63;
    L65:
        if (r1 == false) goto L153;
        r4 = 4;
    L153:
        if (r4 != 2) goto L84;
        String r11 = r9.getMessage();     // Catch: Exception -> L152
        if (Logger.debug() == false) goto L72;
        Logger.d("NetUtils", "SC_CONNECT_TIMEOUT " + r11);     // Catch: Exception -> L152
    L72:
        Matcher r12 = Pattern.compile("Connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})):(\\d+) +timed out").matcher(r11);     // Catch: Exception -> L152
        if (r12.matches() == false) goto L81;
        if (r12.group(3) == null) goto L78;
        r10[0] = r12.group(3);     // Catch: Exception -> L152
        goto L81
    L78:
        if (r12.group(4) == null) goto L81;
        r10[0] = r12.group(4);     // Catch: Exception -> L152
    L81:
        if (Logger.debug() == false) goto L151;
        StringBuilder r13 = new StringBuilder();     // Catch: Exception -> L152
        r13.append("SC_CONNECT_TIMEOUT ip ");     // Catch: Exception -> L152
        r13.append(r10[0]);     // Catch: Exception -> L152
    L83:
        Logger.d("NetUtils", r13.toString());     // Catch: Exception -> L152
        return r4;
    L151:
        return r4;
    L84:
        if (r4 != 8) goto L123;
        Throwable r14 = r9.getCause();     // Catch: Exception -> L152
        if (r14 != null) goto L88;
        return r4;
    L88:
        if ((r14 instanceof ConnectException) == false) goto L156;
        String r15 = r14.getMessage();     // Catch: Exception -> L152
        if (Logger.debug() == false) goto L92;
        Logger.d("NetUtils", "SC_CONNECT_EXCEPTION " + r15);     // Catch: Exception -> L152
    L92:
        Matcher r16 = Pattern.compile("failed to connect to +([\\w\\.\\-]+)?/(\\[([a-zA-Z0-9:]+)\\]|(\\d{1,3}(\\.\\d{1,3}){3,3})) \\(port \\d+\\)( +after \\d+ms)?: +\\w+ failed: (E[A-Z]+) .*").matcher(r15);     // Catch: Exception -> L152
        String r2 = null;
        if (r16.matches() == false) goto L121;
        if (r16.group(3) == null) goto L98;
        r10[0] = r16.group(3);     // Catch: Exception -> L152
    L100:
        r2 = r16.group(7);     // Catch: Exception -> L152
        if (r2 == null) goto L121;
        if ("ECONNRESET".equals(r2) == false) goto L106;
        r4 = 12;
        goto L121
    L106:
        if ("ECONNREFUSED".equals(r2) == false) goto L109;
        r4 = 13;
        goto L121
    L109:
        if ("EHOSTUNREACH".equals(r2) == false) goto L112;
        r4 = 14;
        goto L121
    L112:
        if ("ENETUNREACH".equals(r2) == false) goto L115;
        r4 = 15;
        goto L121
    L115:
        if ("EADDRNOTAVAIL".equals(r2) == false) goto L118;
        r4 = 16;
        goto L121
    L118:
        if ("EADDRINUSE".equals(r2) == false) goto L121;
        r4 = 17;
        goto L121
    L98:
        if (r16.group(4) == null) goto L100;
        r10[0] = r16.group(4);     // Catch: Exception -> L152
    L121:
        if (Logger.debug() == false) goto L157;
        r13 = new StringBuilder();     // Catch: Exception -> L152
        r13.append("SC_CONNECT_EXCEPTION ip ");     // Catch: Exception -> L152
        r13.append(r10[0]);     // Catch: Exception -> L152
        r13.append(" ");     // Catch: Exception -> L152
        r13.append(r2);     // Catch: Exception -> L152
        goto L83
    L157:
        return r4;
    L156:
        return r4;
    L123:
        if (r4 != 4) goto L158;
        String r17 = r9.getMessage();     // Catch: Exception -> L152
        if (r17.indexOf(" EIO (I/O error)") <= 0) goto L129;
        int r18 = 37;
    L159:
        return r18;
    L129:
        if ((r9 instanceof FileNotFoundException) == false) goto L132;
    L160:
        return 33;
    L132:
        if (r17.indexOf(" ENOENT ") > 0) goto L160;
        if (r17.indexOf("No such file or directory") > 0) goto L160;
        if (r17.indexOf(" ENOSPC ") <= 0) goto L139;
    L150:
        r18 = 32;
        goto L159
    L139:
        if (r17.indexOf("No space left on device") > 0) goto L150;
        if (r17.indexOf(" EDQUOT ") <= 0) goto L145;
        r18 = 34;
        goto L159
    L145:
        if (r17.indexOf(" EROFS ") <= 0) goto L148;
        r18 = 35;
        goto L159
    L148:
        if (r17.indexOf(" EACCES ") <= 0) goto L161;
        r18 = 36;
        goto L159
    L161:
        return r4;
    L158:
        return r4;
    L162:
        return r4;
    L63:
        if ("network not available".equals(r9.getMessage()) == false) goto L65;
        r4 = 41;
        goto L153
    L57:
        if ("Canceled".equals(r9.getMessage()) == false) goto L59;
    L11:
        if ((r9 instanceof d.b.h.a.a.h.s.d) == false) goto L14;
        r0 = 20;
        goto L54
    L14:
        if ((r9 instanceof ConnectTimeoutException) == false) goto L17;
    L15:
        r0 = 2;
        goto L54
    L17:
        if ((r9 instanceof SocketTimeoutException) == false) goto L25;
        if (k.c(r9.getMessage()) == false) goto L21;
    L23:
        r0 = 3;
        goto L54
    L21:
        if (r9.getMessage().contains("connect timed out") == false) goto L23;
    L25:
        if ((r9 instanceof BindException) == false) goto L28;
        r0 = 7;
        goto L54
    L28:
        if ((r9 instanceof ConnectException) == false) goto L31;
        r0 = 8;
        goto L54
    L31:
        if ((r9 instanceof NoRouteToHostException) == false) goto L34;
        r0 = 9;
        goto L54
    L34:
        if ((r9 instanceof PortUnreachableException) == false) goto L37;
        r0 = 10;
        goto L54
    L37:
        if ((r9 instanceof SocketException) == false) goto L44;
        r0 = 5;
        String r3 = r9.getMessage();
        if (r3 == null) goto L54;
        if (r3.indexOf("reset by peer") < 0) goto L54;
        r0 = 6;
        goto L54
    L44:
        if ((r9 instanceof UnknownHostException) == false) goto L47;
        r0 = 11;
        goto L54
    L47:
        if ((r9 instanceof d.b.h.a.a.h.l.b) == false) goto L50;
        r0 = 19;
        goto L54
    L50:
        if ((r9 instanceof IOException) == false) goto L54;
        if ("request canceled".equals(r9.getMessage()) == false) goto L54;
        r0 = 40;
        goto L54
    }
}
