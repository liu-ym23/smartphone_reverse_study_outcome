package com.bytedance.apm.net;

import a.a;
import android.text.TextUtils;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
class MultipartUtility implements IMultipartUploader {
    private static final int BUFFER_SIZE = 8192;
    private static final String LINE_FEED = "\r\n";
    private final String boundary;
    private String charset;
    private DataOutputStream dataOutputStream;
    private boolean gzip;
    private GZIPOutputStream gzipOutputStream;
    private Map<String, String> header;
    private HttpURLConnection httpConn;

    public MultipartUtility(String r4, String r5, boolean r6, Map<String, String> r7) {
        this.charset = r5;
        this.gzip = r6;
        this.header = r7;
        String r8 = "AAA" + System.currentTimeMillis() + "AAA";
        this.boundary = r8;
        HttpURLConnection r9 = (HttpURLConnection) new URL(r4).openConnection();
        this.httpConn = r9;
        r9.setUseCaches(false);
        this.httpConn.setDoOutput(true);
        this.httpConn.setDoInput(true);
        this.httpConn.setRequestMethod(HttpMethodContrants.POST);
        this.httpConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + r8);
        if (r7 == null) goto L8;
        Iterator<Map.Entry<String, String>> r10 = r7.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        Map.Entry<String, String> r11 = r10.next();
        this.httpConn.setRequestProperty(r11.getKey(), r11.getValue());
    L8:
        this.httpConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.boundary);
        if (r6 == false) goto L11;
        this.httpConn.setRequestProperty("Content-Encoding", "gzip");
        this.gzipOutputStream = new GZIPOutputStream(this.httpConn.getOutputStream());
        return;
    L11:
        this.dataOutputStream = new DataOutputStream(this.httpConn.getOutputStream());
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r4, File r5, String r6, Map<String, String> r7) {
        String r0 = r5.getName();
        StringBuilder r1 = new StringBuilder(100);
        r1.append("--");
        r1.append(this.boundary);
        r1.append("\r\nContent-Disposition: form-data; name=\"");
        r1.append(r4);
        r1.append("\"; filename=\"");
        r1.append(r0);
        r1.append("\"");
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        Map.Entry<String, String> r2 = r8.next();
        r1.append("; ");
        r1.append(r2.getKey());
        r1.append("=\"");
        r1.append(r2.getValue());
        r1.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r6) == true) goto L9;
        r1.append("\r\nContent-Type: ");
        r1.append(r6);
        r1.append(LINE_FEED);
    L9:
        r1.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.gzip == false) goto L12;
        this.gzipOutputStream.write(r1.toString().getBytes());
    L13:
        FileInputStream r9 = new FileInputStream(r5);
        byte[] r10 = new byte[8192];
    L14:
        int r11 = r9.read(r10);
        if (r11 == (-1)) goto L20;
        if (this.gzip == true) goto L18;
        this.dataOutputStream.write(r10, 0, r11);
        goto L14
    L18:
        this.gzipOutputStream.write(r10, 0, r11);
        goto L14
    L20:
        r9.close();
        if (this.gzip == false) goto L23;
        this.gzipOutputStream.write(LINE_FEED.getBytes());
        return;
    L23:
        this.dataOutputStream.write(LINE_FEED.getBytes());
        this.dataOutputStream.flush();
        return;
    L12:
        this.dataOutputStream.write(r1.toString().getBytes());
        goto L13
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFormField(String r3, String r4) {
        StringBuilder r0 = new StringBuilder(100);
        r0.append("--");
        r0.append(this.boundary);
        r0.append("\r\nContent-Disposition: form-data; name=\"");
        r0.append(r3);
        r0.append("\"\r\nContent-Type: text/plain; charset=");
        r0.append(this.charset);
        r0.append("\r\n\r\n");
        r0.append(r4);
        r0.append(LINE_FEED);
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.gzip == false) goto L8;
        this.gzipOutputStream.write(r0.toString().getBytes());     // Catch: IOException -> L6
    L12:
        return;
    L8:
        this.dataOutputStream.write(r0.toString().getBytes());     // Catch: IOException -> L6
        goto L12
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public HttpResponse finish() {
        ArrayList r0 = new ArrayList();
        byte[] r1 = ("\r\n--" + this.boundary + "--\r\n").getBytes();
        if (this.gzip == false) goto L5;
        this.gzipOutputStream.write(r1);
        this.gzipOutputStream.finish();
        this.gzipOutputStream.close();
    L6:
        int r2 = this.httpConn.getResponseCode();
        if (r2 != 200) goto L19;
        BufferedReader r3 = new BufferedReader(new InputStreamReader(this.httpConn.getInputStream()));
    L9:
        String r4 = r3.readLine();
        if (r4 == null) goto L12;
        r0.add(r4);
        goto L9
    L12:
        r3.close();
        this.httpConn.disconnect();
        StringBuilder r5 = new StringBuilder();
        Iterator r6 = r0.iterator();
    L14:
        if (r6.hasNext() == false) goto L17;
        r5.append((String) r6.next());
        goto L14
    L17:
        return new HttpResponse(r2, r5.toString().getBytes());
    L19:
        throw new IOException(a.e(r2, "Server returned non-OK status: "));
    L5:
        this.dataOutputStream.write(r1);
        this.dataOutputStream.flush();
        this.dataOutputStream.close();
        goto L6
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r4, String r5, String r6, Map<String, String> r7) {
        StringBuilder r0 = new StringBuilder(100);
        r0.append("--");
        r0.append(this.boundary);
        r0.append("\r\nContent-Disposition: form-data; name=\"");
        r0.append(r4);
        r0.append("\"; filename=\"");
        r0.append(r4);
        r0.append("\"");
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        Map.Entry<String, String> r1 = r8.next();
        r0.append("; ");
        r0.append(r1.getKey());
        r0.append("=\"");
        r0.append(r1.getValue());
        r0.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r6) == true) goto L9;
        r0.append("\r\nContent-Type: ");
        r0.append(r6);
        r0.append(LINE_FEED);
    L9:
        r0.append(LINE_FEED);
        if (this.gzip == false) goto L12;
        this.gzipOutputStream.write(r0.toString().getBytes());
    L13:
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        if (this.gzip == false) goto L18;
        this.gzipOutputStream.write(r5.getBytes());
    L20:
        if (this.gzip == false) goto L22;
        this.gzipOutputStream.write(LINE_FEED.getBytes());
        return;
    L22:
        this.dataOutputStream.write(LINE_FEED.getBytes());
        this.dataOutputStream.flush();
        return;
    L18:
        this.dataOutputStream.write(r5.getBytes());
        goto L20
    L12:
        this.dataOutputStream.write(r0.toString().getBytes());
        goto L13
    }
}
