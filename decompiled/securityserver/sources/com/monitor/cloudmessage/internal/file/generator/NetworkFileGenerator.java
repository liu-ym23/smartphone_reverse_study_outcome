package com.monitor.cloudmessage.internal.file.generator;

import android.content.Context;
import android.text.TextUtils;
import com.monitor.cloudmessage.utils.FileUtils;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NetworkFileGenerator {
    private static final int DEFAULT_PING_TIME = 5;
    private static final String FROM_PING = "From";
    private static final String SMALL_FROM_PING = "from";

    public NetworkFileGenerator() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static File generateFile(Context r13, JSONObject r14) {
        String r15 = r14.optString("domain");
        OutputStream r2 = null;
        if (TextUtils.isEmpty(r15) == true) goto L109;
        JSONObject r1 = new JSONObject();
        if (r15.startsWith("http://") == false) goto L7;
    L9:
        String r3 = null;
    L138:
        String r4 = new URL(r15).getHost();     // Catch: Throwable -> L14 Exception -> L16
        String r5 = FileUtils.getCloudMsgDir(r13).getAbsolutePath();     // Catch: Throwable -> L14 Exception -> L16
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L14 Exception -> L16
        r6.append(r5);     // Catch: Throwable -> L14 Exception -> L16
        r6.append(File.separator);     // Catch: Throwable -> L14 Exception -> L16
        r6.append(r4 + ".txt");     // Catch: Throwable -> L14 Exception -> L16
        String r7 = r6.toString();     // Catch: Throwable -> L14 Exception -> L16
        r1.put("networkType", NetworkUtils.getNetworkAccessType(r13));     // Catch: Throwable -> L14 Exception -> L16
        r1.put("currentNativeIP", NetworkUtils.getNativeIp());     // Catch: Throwable -> L14 Exception -> L16
        r1.put("localDNS", NetworkUtils.getLocalDNS(r13));     // Catch: Throwable -> L14 Exception -> L16
        r1.put("localGateway", NetworkUtils.getGateway(r13));     // Catch: Throwable -> L14 Exception -> L16
        r1.put("uploadSpeed", NetworkUtils.getUploadSpeed(r13));     // Catch: Throwable -> L14 Exception -> L16
        r1.put("downloadSpeed", NetworkUtils.getDownloadSpeed(r13));     // Catch: Throwable -> L14 Exception -> L16
        r1.put("cdn", r4);     // Catch: Throwable -> L14 Exception -> L16
        r1.put("domainNameParse", NetworkUtils.parseDomainName(r4));     // Catch: Throwable -> L14 Exception -> L16
        if (NetworkUtils.testGet(r15, r1) == true) goto L19;
        if (r3 == null) goto L19;
        NetworkUtils.testGet(r3, r1);     // Catch: Throwable -> L14 Exception -> L16
    L19:
        Process r16 = Runtime.getRuntime().exec("ping -c 5 " + r4);     // Catch: Throwable -> L14 Exception -> L16
        OutputStream r17 = r16.getOutputStream();     // Catch: Throwable -> L14 Exception -> L16
        r17.close();     // Catch: Throwable -> L64 Exception -> L66
        long r8 = System.nanoTime();     // Catch: Throwable -> L64 Exception -> L66
        InputStream r0 = r16.getInputStream();     // Catch: Throwable -> L64 Exception -> L66
    L134:
        BufferedReader r9 = new BufferedReader(new InputStreamReader(r0, "UTF8"));     // Catch: Throwable -> L29 Exception -> L32
        JSONArray r10 = new JSONArray();     // Catch: Throwable -> L29 Exception -> L32
        float r11 = 0.0f;
    L22:
        String r12 = r9.readLine();     // Catch: Throwable -> L29 Exception -> L32
        if (r12 == null) goto L35;
        r10.put(r12);     // Catch: Throwable -> L29 Exception -> L32
        if (r12.contains(FROM_PING) == true) goto L34;
        if (r12.contains("from") == false) goto L22;
    L34:
        r11 = (System.nanoTime() - r8) / 1000000.0f;     // Catch: Throwable -> L29 Exception -> L32
        goto L22
    L35:
        r16.destroy();     // Catch: Throwable -> L29 Exception -> L32
        r1.put("pingResults", r10);     // Catch: Throwable -> L29 Exception -> L32
        r1.put("elapsedTime", r11);     // Catch: Throwable -> L29 Exception -> L32
        File r18 = new File(r5);     // Catch: Throwable -> L29 Exception -> L32
        if (r18.exists() == true) goto L38;
        r18.mkdirs();     // Catch: Throwable -> L29 Exception -> L32
    L38:
        FileWriter r19 = new FileWriter(r7);     // Catch: Throwable -> L29 Exception -> L32
        BufferedWriter r20 = new BufferedWriter(r19);     // Catch: Throwable -> L60 Exception -> L62
    L136:
        r20.write(r1.toString());     // Catch: Throwable -> L56 Exception -> L58
        r17.close();     // Catch: IOException -> L43
    L45:
        if (r0 != null) goto L124;
    L118:
        r20.close();     // Catch: IOException -> L52
        r19.close();     // Catch: IOException -> L52
    L55:
        return new File(r7);
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L55
    L124:
        r0.close();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        e.printStackTrace();
    L43:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L58:
        e = e;
    L59:
        FileWriter r110 = r19;
        e = e;
        InputStream r21 = r0;
        OutputStream r22 = r17;
        BufferedWriter r23 = r20;
    L128:
        e.printStackTrace();     // Catch: Throwable -> L88
        if (r22 != null) goto L126;
    L74:
        if (r21 != null) goto L120;
    L79:
        if (r23 != 0) goto L114;
    L83:
        if (r110 == null) goto L87;
        r110.close();     // Catch: IOException -> L81
    L81:
        e = move-exception;
        e.printStackTrace();
    L87:
        return null;
    L114:
        r23.close();     // Catch: IOException -> L81
        goto L83
    L120:
        r21.close();     // Catch: IOException -> L77
    L77:
        e = move-exception;
        e.printStackTrace();
        goto L79
    L126:
        r22.close();     // Catch: IOException -> L72
    L72:
        e = move-exception;
        e.printStackTrace();
    L88:
        th = th;
        r2 = r22;
        r0 = r21;
        BufferedWriter r24 = r23;
        FileWriter r111 = r110;
    L90:
        if (r2 != null) goto L122;
    L95:
        if (r0 != null) goto L116;
    L100:
        if (r24 != 0) goto L112;
    L104:
        if (r111 == null) goto L146;
        r111.close();     // Catch: IOException -> L102
        throw th;
    L102:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L146:
        throw th;
    L112:
        r24.close();     // Catch: IOException -> L102
        goto L104
    L116:
        r0.close();     // Catch: IOException -> L98
    L98:
        e = move-exception;
        e.printStackTrace();
        goto L100
    L122:
        r2.close();     // Catch: IOException -> L93
    L93:
        e = move-exception;
        e.printStackTrace();
    L56:
        th = th;
    L57:
        r2 = r17;
        r111 = r19;
        th = th;
        r24 = r20;
    L62:
        e = e;
        r20 = null;
    L60:
        th = th;
        r20 = null;
        goto L57
    L32:
        e = e;
        r21 = r0;
        r23 = 0;
        r22 = r17;
        r110 = null;
    L29:
        th = th;
        FileWriter r25 = null;
    L31:
        r2 = r17;
        r111 = r25;
        r24 = r25;
    L66:
        e = e;
        r22 = r17;
        FileWriter r112 = null;
        r21 = null;
    L18:
        r23 = r21;
        r110 = r112;
    L64:
        th = th;
        r0 = null;
        r25 = null;
        goto L31
    L16:
        e = e;
        r112 = null;
        r22 = null;
        r21 = null;
    L14:
        th = th;
        r111 = null;
        r0 = null;
        r24 = 0;
        goto L90
    L7:
        if (r15.startsWith("https://") == true) goto L9;
        r3 = "http://".concat(r15);
        r15 = "https://".concat(r15);
        goto L138
    L109:
        return null;
    }
}
