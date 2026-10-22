package com.bytedance.apm.impl;

import com.bytedance.apm.util.u;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IMultipartUploader;
import d.b.r.d0;
import d.b.r.k0.h;
import d.b.r.k0.i;
import d.b.r.k0.j;
import d.b.r.k0.k;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements IMultipartUploader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f1606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, j> f1607c;

    public d(String r1, String r2, boolean r3, Map<String, String> r4) {
        this.f1607c = new HashMap();
        this.f1605a = r1;
        this.f1606b = r4;
    }

    private HttpResponse a(String r5, Map<String, j> r6, Map<String, String> r7) {
        RetrofitMonitorService r4 = (RetrofitMonitorService) com.bytedance.ttnet.s.d.f(r5, RetrofitMonitorService.class);
        HashMap r0 = new HashMap();
        d0<i> r8 = r4.uploadFiles(r5, r6, DefaultTTNetImpl.convertHeaderMap(r7)).execute();     // Catch: Throwable -> L11
        byte[] r9 = DefaultTTNetImpl.toByteArray(r8.a().d());     // Catch: Throwable -> L11
        List<d.b.r.h0.b> r10 = r8.d();     // Catch: Throwable -> L11
        if (com.bytedance.apm.util.i.b(r10) == true) goto L9;
        Iterator<d.b.r.h0.b> r11 = r10.iterator();     // Catch: Throwable -> L11
    L7:
        if (r11.hasNext() == false) goto L9;
        d.b.r.h0.b r12 = r11.next();     // Catch: Throwable -> L11
        r0.put(r12.a(), r12.b());     // Catch: Throwable -> L11
    L9:
        int r13 = r8.b();     // Catch: Throwable -> L11
    L19:
        return new HttpResponse(r13, r0, r9);
    L11:
        th = move-exception;
        th.printStackTrace();
        JSONObject r14 = new JSONObject();
        r14.put("exception", th.getMessage() + u.a(th));     // Catch: Exception -> L15
        r14.put("exception_object", th.toString());     // Catch: Exception -> L15
    L17:
        r9 = r14.toString().getBytes();
        r13 = 100001;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r3, File r4, String r5, Map<String, String> r6) {
        this.f1607c.put(r3, new c(r6, new h(null, r4)));
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r1, String r2, String r3, Map<String, String> r4) {
        this.f1607c.put(r1, new b(r1, r2, r4));
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFormField(String r2, String r3) {
        this.f1607c.put(r2, new k(r3));
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public HttpResponse finish() {
        return a(this.f1605a, this.f1607c, this.f1606b);
    }
}
