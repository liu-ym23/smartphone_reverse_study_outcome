package com.bytedance.apm.impl;

import com.bytedance.frameworks.baselib.network.http.cronet.e.e;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.obric.matrix.common_api.INetworkApi;
import d.b.r.d0;
import d.b.r.k0.g;
import d.b.r.k0.i;
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

    protected static List<d.b.r.h0.b> convertHeaderMap(Map<String, String> r4) {
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
        r0.add(new d.b.r.h0.b(r1.getKey(), r1.getValue()));
        goto L8
    }

    public static byte[] toByteArray(InputStream r5) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
        if (r5 == null) goto L5;
    L6:
        int r4 = r5.read(r1);
        if ((-1) == r4) goto L9;
        r0.write(r1, 0, r4);
        goto L6
    L9:
        r5.close();
        return r0.toByteArray();
    L5:
        return new byte[0];
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public IMultipartUploader buildMultipartUpload(String r2, String r3, boolean r4) {
        return new d(r2, r3, r4, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public IMultipartUploader buildMultipartUpload(String r1, String r2, boolean r3, Map<String, String> r4) {
        return new d(r1, r2, r3, r4);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public HttpResponse doGet(String r2, Map<String, String> r3) {
        d0<i> r1 = ((RetrofitMonitorService) com.bytedance.ttnet.s.d.f(r2, RetrofitMonitorService.class)).fetch(r2, r3, false).execute();
        byte[] r4 = toByteArray(r1.a().d());
        return new HttpResponse(r1.b(), r4);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public HttpResponse doPost(String r5, byte[] r6, Map<String, String> r7) {
        RetrofitMonitorService r4 = (RetrofitMonitorService) com.bytedance.ttnet.s.d.f(r5, RetrofitMonitorService.class);
        List<d.b.r.h0.b> r8 = convertHeaderMap(r7);
        int r1 = 0;
        d.b.r.b<i> r9 = r4.report(r5, new g(INetworkApi.DEFAULT_CONTENT_TYPE, r6, new String[0]), r8, false);
        HashMap r10 = new HashMap();
        byte[] r11 = null;
        d0<i> r12 = r9.execute();     // Catch: Throwable -> L11
        r11 = toByteArray(r12.a().d());     // Catch: Throwable -> L11
        List<d.b.r.h0.b> r13 = r12.d();     // Catch: Throwable -> L11
        if (com.bytedance.apm.util.i.b(r13) == true) goto L9;
        Iterator<d.b.r.h0.b> r14 = r13.iterator();     // Catch: Throwable -> L11
    L7:
        if (r14.hasNext() == false) goto L9;
        d.b.r.h0.b r0 = r14.next();     // Catch: Throwable -> L11
        r10.put(r0.a(), r0.b());     // Catch: Throwable -> L11
    L9:
        int r15 = r12.b();     // Catch: Throwable -> L11
    L21:
        return new HttpResponse(r15, r10, r11);
    L11:
        th = move-exception;
        if ((th instanceof d.b.h.a.a.h.l.d) == false) goto L16;
        r1 = ((d.b.h.a.a.h.l.d) th).c();     // Catch: Exception -> L22
    L16:
        if ((th instanceof e) == false) goto L19;
        r15 = ((e) th).e();     // Catch: Exception -> L22
    L19:
        r15 = r1;
        goto L21
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public HttpResponse uploadFiles(String r1, List<File> r2, Map<String, String> r3) {
        return com.bytedance.apm.util.d.a(r1, r2, r3);
    }
}
