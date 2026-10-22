package com.bytedance.apm.impl;

import com.android.settings.InstrumentedFragment;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.StackUtils;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
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
        SsResponse<TypedInput> r6 = r2.uploadFiles(r3, r4, DefaultTTNetImpl.convertHeaderMap(r5)).execute();     // Catch: Throwable -> L11
        byte[] r7 = DefaultTTNetImpl.toByteArray(r6.body().in());     // Catch: Throwable -> L11
        List<Header> r8 = r6.headers();     // Catch: Throwable -> L11
        if (ListUtils.isEmpty(r8) == true) goto L9;
        Iterator<Header> r9 = r8.iterator();     // Catch: Throwable -> L11
    L7:
        if (r9.hasNext() == false) goto L9;
        Header r10 = r9.next();     // Catch: Throwable -> L11
        r0.put(r10.getName(), r10.getValue());     // Catch: Throwable -> L11
    L9:
        int r11 = r6.code();     // Catch: Throwable -> L11
    L19:
        return new HttpResponse(r11, r0, r7);
    L11:
        th = move-exception;
        th.printStackTrace();
        JSONObject r12 = new JSONObject();
        r12.put("exception", th.getMessage() + StackUtils.getStack(th));     // Catch: Exception -> L15
        r12.put(AlogMonitor.ALOG_RESULT_EXCEPTION_OBJECT, th.toString());     // Catch: Exception -> L15
    L17:
        r7 = r12.toString().getBytes();
        r11 = InstrumentedFragment.PREFERENCE_ACTIVITY_FRAGMENT;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
