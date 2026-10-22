package com.bytedance.apm.net;

import android.text.TextUtils;
import com.bytedance.apm.util.l;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.obric.matrix.common_api.INetworkApi;
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

/* JADX INFO: loaded from: classes.dex */
class b implements IMultipartUploader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HttpURLConnection f1655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f1658e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DataOutputStream f1659f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private GZIPOutputStream f1660g;

    public b(String r4, String r5, boolean r6, Map<String, String> r7) {
        this.f1656c = r5;
        this.f1657d = r6;
        this.f1658e = r7;
        String r8 = "AAA" + System.currentTimeMillis() + "AAA";
        this.f1654a = r8;
        HttpURLConnection r9 = l.a(r4);
        this.f1655b = r9;
        r9.setUseCaches(false);
        this.f1655b.setDoOutput(true);
        this.f1655b.setDoInput(true);
        this.f1655b.setRequestMethod("POST");
        this.f1655b.setRequestProperty(INetworkApi.CONTENT_TYPE, "multipart/form-data; boundary=" + r8);
        if (r7 == null) goto L8;
        Iterator<Map.Entry<String, String>> r10 = r7.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        Map.Entry<String, String> r11 = r10.next();
        this.f1655b.setRequestProperty(r11.getKey(), r11.getValue());
    L8:
        this.f1655b.setRequestProperty(INetworkApi.CONTENT_TYPE, "multipart/form-data; boundary=" + this.f1654a);
        if (r6 == false) goto L11;
        this.f1655b.setRequestProperty("Content-Encoding", "gzip");
        this.f1660g = new GZIPOutputStream(this.f1655b.getOutputStream());
        return;
    L11:
        this.f1659f = new DataOutputStream(this.f1655b.getOutputStream());
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r5, File r6, String r7, Map<String, String> r8) {
        String r0 = r6.getName();
        StringBuilder r1 = new StringBuilder(100);
        r1.append("--");
        r1.append(this.f1654a);
        r1.append("\r\n");
        r1.append("Content-Disposition: form-data; name=\"");
        r1.append(r5);
        r1.append("\"; filename=\"");
        r1.append(r0);
        r1.append("\"");
        Iterator<Map.Entry<String, String>> r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        Map.Entry<String, String> r2 = r9.next();
        r1.append("; ");
        r1.append(r2.getKey());
        r1.append("=\"");
        r1.append(r2.getValue());
        r1.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L9;
        r1.append("\r\n");
        r1.append("Content-Type: ");
        r1.append(r7);
        r1.append("\r\n");
    L9:
        r1.append("\r\n");
        r1.append("Content-Transfer-Encoding: binary");
        r1.append("\r\n");
        r1.append("\r\n");
        if (this.f1657d == false) goto L12;
        this.f1660g.write(r1.toString().getBytes());
    L13:
        FileInputStream r10 = new FileInputStream(r6);
        byte[] r11 = new byte[8192];
    L14:
        int r12 = r10.read(r11);
        if (r12 == (-1)) goto L20;
        if (this.f1657d == true) goto L18;
        this.f1659f.write(r11, 0, r12);
        goto L14
    L18:
        this.f1660g.write(r11, 0, r12);
        goto L14
    L20:
        r10.close();
        if (this.f1657d == false) goto L23;
        this.f1660g.write("\r\n".getBytes());
        return;
    L23:
        this.f1659f.write("\r\n".getBytes());
        this.f1659f.flush();
        return;
    L12:
        this.f1659f.write(r1.toString().getBytes());
        goto L13
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r5, String r6, String r7, Map<String, String> r8) {
        StringBuilder r0 = new StringBuilder(100);
        r0.append("--");
        r0.append(this.f1654a);
        r0.append("\r\n");
        r0.append("Content-Disposition: form-data; name=\"");
        r0.append(r5);
        r0.append("\"; filename=\"");
        r0.append(r5);
        r0.append("\"");
        Iterator<Map.Entry<String, String>> r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        Map.Entry<String, String> r2 = r9.next();
        r0.append("; ");
        r0.append(r2.getKey());
        r0.append("=\"");
        r0.append(r2.getValue());
        r0.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r7) == true) goto L9;
        r0.append("\r\n");
        r0.append("Content-Type: ");
        r0.append(r7);
        r0.append("\r\n");
    L9:
        r0.append("\r\n");
        if (this.f1657d == false) goto L12;
        this.f1660g.write(r0.toString().getBytes());
    L13:
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        if (this.f1657d == false) goto L18;
        this.f1660g.write(r6.getBytes());
    L20:
        if (this.f1657d == false) goto L22;
        this.f1660g.write("\r\n".getBytes());
        return;
    L22:
        this.f1659f.write("\r\n".getBytes());
        this.f1659f.flush();
        return;
    L18:
        this.f1659f.write(r6.getBytes());
        goto L20
    L12:
        this.f1659f.write(r0.toString().getBytes());
        goto L13
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFormField(String r4, String r5) {
        StringBuilder r0 = new StringBuilder(100);
        r0.append("--");
        r0.append(this.f1654a);
        r0.append("\r\n");
        r0.append("Content-Disposition: form-data; name=\"");
        r0.append(r4);
        r0.append("\"");
        r0.append("\r\n");
        r0.append("Content-Type: text/plain; charset=");
        r0.append(this.f1656c);
        r0.append("\r\n");
        r0.append("\r\n");
        r0.append(r5);
        r0.append("\r\n");
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.f1657d == false) goto L6;
        this.f1660g.write(r0.toString().getBytes());     // Catch: IOException -> L8
    L11:
        return;
    L6:
        this.f1659f.write(r0.toString().getBytes());     // Catch: IOException -> L8
        goto L11
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public HttpResponse finish() {
        ArrayList r0 = new ArrayList();
        byte[] r1 = ("\r\n--" + this.f1654a + "--\r\n").getBytes();
        if (this.f1657d == false) goto L5;
        this.f1660g.write(r1);
        this.f1660g.finish();
        this.f1660g.close();
    L6:
        int r2 = this.f1655b.getResponseCode();
        if (r2 != 200) goto L19;
        BufferedReader r3 = new BufferedReader(new InputStreamReader(this.f1655b.getInputStream()));
    L9:
        String r4 = r3.readLine();
        if (r4 == null) goto L12;
        r0.add(r4);
        goto L9
    L12:
        r3.close();
        this.f1655b.disconnect();
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
        this.f1659f.write(r1);
        this.f1659f.flush();
        this.f1659f.close();
        goto L6
    }
}
