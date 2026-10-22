package com.bytedance.apm.net;

import android.text.TextUtils;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes3.dex */
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

    public MultipartUtility(String r4, String r5, boolean r6, Map<String, String> r7) throws IOException {
        this.charset = r5;
        this.gzip = r6;
        this.header = r7;
        String r8 = "AAA" + System.currentTimeMillis() + "AAA";
        this.boundary = r8;
        HttpURLConnection r9 = NetUtils.getUrlConnection(r4);
        this.httpConn = r9;
        r9.setUseCaches(false);
        this.httpConn.setDoOutput(true);
        this.httpConn.setDoInput(true);
        this.httpConn.setRequestMethod("POST");
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
    public void addFormField(String r4, String r5) {
        StringBuilder r0 = new StringBuilder(100);
        r0.append("--").append(this.boundary).append("\r\nContent-Disposition: form-data; name=\"").append(r4).append("\"\r\nContent-Type: text/plain; charset=").append(this.charset).append("\r\n\r\n").append(r5).append("\r\n");
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.gzip == false) goto L6;
        this.gzipOutputStream.write(r0.toString().getBytes());     // Catch: IOException -> L8
    L11:
        return;
    L6:
        this.dataOutputStream.write(r0.toString().getBytes());     // Catch: IOException -> L8
        goto L11
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r5, File r6, String r7, Map<String, String> r8) throws IOException {
        String r0 = r6.getName();
        StringBuilder r1 = new StringBuilder(100);
        r1.append("--").append(this.boundary).append("\r\nContent-Disposition: form-data; name=\"").append(r5).append("\"; filename=\"").append(r0).append("\"");
        Iterator<Map.Entry<String, String>> r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        Map.Entry<String, String> r10 = r9.next();
        r1.append(VectorFormat.DEFAULT_SEPARATOR).append(r10.getKey()).append("=\"").append(r10.getValue()).append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L9;
        r1.append("\r\nContent-Type: ").append(r7).append("\r\n");
    L9:
        r1.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.gzip == false) goto L12;
        this.gzipOutputStream.write(r1.toString().getBytes());
    L13:
        FileInputStream r11 = new FileInputStream(r6);
        byte[] r12 = new byte[8192];
    L14:
        int r13 = r11.read(r12);
        if (r13 == (-1)) goto L20;
        if (this.gzip == true) goto L18;
        this.dataOutputStream.write(r12, 0, r13);
        goto L14
    L18:
        this.gzipOutputStream.write(r12, 0, r13);
        goto L14
    L20:
        r11.close();
        if (this.gzip == false) goto L23;
        this.gzipOutputStream.write("\r\n".getBytes());
        return;
    L23:
        this.dataOutputStream.write("\r\n".getBytes());
        this.dataOutputStream.flush();
        return;
    L12:
        this.dataOutputStream.write(r1.toString().getBytes());
        goto L13
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r5, String r6, String r7, Map<String, String> r8) throws IOException {
        StringBuilder r0 = new StringBuilder(100);
        r0.append("--").append(this.boundary).append("\r\nContent-Disposition: form-data; name=\"").append(r5).append("\"; filename=\"").append(r5).append("\"");
        Iterator<Map.Entry<String, String>> r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        Map.Entry<String, String> r10 = r9.next();
        r0.append(VectorFormat.DEFAULT_SEPARATOR).append(r10.getKey()).append("=\"").append(r10.getValue()).append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L9;
        r0.append("\r\nContent-Type: ").append(r7).append("\r\n");
    L9:
        r0.append("\r\n");
        if (this.gzip == false) goto L12;
        this.gzipOutputStream.write(r0.toString().getBytes());
    L13:
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        if (this.gzip == false) goto L18;
        this.gzipOutputStream.write(r6.getBytes());
    L20:
        if (this.gzip == false) goto L22;
        this.gzipOutputStream.write("\r\n".getBytes());
        return;
    L22:
        this.dataOutputStream.write("\r\n".getBytes());
        this.dataOutputStream.flush();
        return;
    L18:
        this.dataOutputStream.write(r6.getBytes());
        goto L20
    L12:
        this.dataOutputStream.write(r0.toString().getBytes());
        goto L13
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public HttpResponse finish() throws IOException {
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
        throw new IOException("Server returned non-OK status: " + r2);
    L5:
        this.dataOutputStream.write(r1);
        this.dataOutputStream.flush();
        this.dataOutputStream.close();
        goto L6
    }
}
