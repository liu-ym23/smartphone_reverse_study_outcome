package com.bytedance.apm.impl;

import com.bytedance.apm.util.FileUploadUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DefaultTTNetImpl implements IHttpService {
    public DefaultTTNetImpl() {
    }

    public static List<Header> convertHeaderMap(Map<String, String> r4) {
        ArrayList r0 = new ArrayList();
        if (r4 != null) goto L5;
    L13:
        return r0;
    L5:
        if (r4.isEmpty() == true) goto L13;
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        Map.Entry<String, String> r1 = r5.next();
        if (r1 == null) goto L8;
        r0.add(new Header(r1.getKey(), r1.getValue()));
        goto L8
    }

    public static byte[] toByteArray(InputStream r5) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
        if (r5 == null) goto L5;
    L6:
        int r3 = r5.read(r1);
        if ((-1) == r3) goto L9;
        r0.write(r1, 0, r3);
        goto L6
    L9:
        r5.close();
        return r0.toByteArray();
    L5:
        return new byte[0];
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public IMultipartUploader buildMultipartUpload(String r2, String r3, boolean r4) {
        return new TTNetMultipartUploader(r2, r3, r4, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public HttpResponse doGet(String r2, Map<String, String> r3) {
        SsResponse<TypedInput> r1 = ((RetrofitMonitorService) RetrofitUtils.createSsService(r2, RetrofitMonitorService.class)).fetch(r2, r3, false).execute();
        byte[] r4 = toByteArray(r1.body().in());
        return new HttpResponse(r1.code(), r4);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public HttpResponse doPost(String r5, byte[] r6, Map<String, String> r7) {
        RetrofitMonitorService r4 = (RetrofitMonitorService) RetrofitUtils.createSsService(r5, RetrofitMonitorService.class);
        List<Header> r8 = convertHeaderMap(r7);
        int r1 = 0;
        Call<TypedInput> r9 = r4.report(r5, new TypedByteArray("application/json; charset=utf-8", r6, new String[0]), r8, false);
        HashMap r10 = new HashMap();
        byte[] r11 = null;
        SsResponse<TypedInput> r12 = r9.execute();     // Catch: Throwable -> L9
        r11 = toByteArray(r12.body().in());     // Catch: Throwable -> L9
        List<Header> r13 = r12.headers();     // Catch: Throwable -> L9
        if (ListUtils.isEmpty(r13) == true) goto L11;
        Iterator<Header> r14 = r13.iterator();     // Catch: Throwable -> L9
    L7:
        if (r14.hasNext() == false) goto L11;
        Header r0 = r14.next();     // Catch: Throwable -> L9
        r10.put(r0.getName(), r0.getValue());     // Catch: Throwable -> L9
    L11:
        int r15 = r12.code();     // Catch: Throwable -> L9
    L22:
        return new HttpResponse(r15, r10, r11);
    L9:
        th = move-exception;
        if ((th instanceof HttpResponseException) == false) goto L17;
        r1 = ((HttpResponseException) th).getStatusCode();     // Catch: Exception -> L23
    L17:
        if ((th instanceof CronetIOException) == false) goto L20;
        r15 = ((CronetIOException) th).getStatusCode();     // Catch: Exception -> L23
    L20:
        r15 = r1;
        goto L22
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public HttpResponse uploadFiles(String r1, List<File> r2, Map<String, String> r3) {
        return FileUploadUtils.uploadFiles(r1, r2, r3);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public IMultipartUploader buildMultipartUpload(String r1, String r2, boolean r3, Map<String, String> r4) {
        return new TTNetMultipartUploader(r1, r2, r3, r4);
    }
}
