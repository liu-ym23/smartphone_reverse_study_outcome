package com.bytedance.apm.impl;

import com.bytedance.apm.util.ListUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class TTNetMultipartUploader implements IMultipartUploader {
    private String charset;
    private boolean gzip;
    private Map<String, String> header;
    private Map<String, TypedOutput> partMap;
    private String requestURL;

    public TTNetMultipartUploader(String r2, String r3, boolean r4, Map<String, String> r5) {
        this.partMap = new HashMap();
        this.requestURL = r2;
        this.header = r5;
        this.charset = r3;
        this.gzip = r4;
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFormField(String r2, String r3) {
        this.partMap.put(r2, new TypedString(r3));
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r3, File r4, String r5, Map<String, String> r6) throws IOException {
        this.partMap.put(r3, new MonitorFiledPart(r6, new TypedFile(null, r4)));
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r1, String r2, String r3, Map<String, String> r4) throws IOException {
        this.partMap.put(r1, new MonitorAdditionalPart(r1, r2, r4));
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public HttpResponse finish() throws IOException {
        return uploadMultiPartFiles(this.requestURL, this.partMap, this.header);
    }

    private HttpResponse uploadMultiPartFiles(String r3, Map<String, TypedOutput> r4, Map<String, String> r5) {
        RetrofitMonitorService r2 = (RetrofitMonitorService) RetrofitUtils.createSsService(r3, RetrofitMonitorService.class);
        HashMap r0 = new HashMap();
        byte[] r1 = null;
        SsResponse<TypedInput> r6 = r2.uploadFiles(r3, r4, DefaultTTNetImpl.convertHeaderMap(r5)).execute();     // Catch: Throwable -> L11
        r1 = DefaultTTNetImpl.toByteArray(r6.body().in());     // Catch: Throwable -> L11
        List<Header> r7 = r6.headers();     // Catch: Throwable -> L11
        if (ListUtils.isEmpty(r7) == true) goto L9;
        Iterator<Header> r8 = r7.iterator();     // Catch: Throwable -> L11
    L7:
        if (r8.hasNext() == false) goto L9;
        Header r9 = r8.next();     // Catch: Throwable -> L11
        r0.put(r9.getName(), r9.getValue());     // Catch: Throwable -> L11
    L9:
        int r10 = r6.code();     // Catch: Throwable -> L11
    L21:
        return new HttpResponse(r10, r0, r1);
    L11:
        th = move-exception;
        th.printStackTrace();
        if ((th instanceof HttpResponseException) == false) goto L15;
        int r11 = ((HttpResponseException) th).getStatusCode();
    L17:
        if ((th instanceof CronetIOException) == false) goto L19;
        r10 = ((CronetIOException) th).getStatusCode();
        goto L21
    L19:
        r10 = r11;
        goto L21
    L15:
        r11 = 0;
        goto L17
    }
}
