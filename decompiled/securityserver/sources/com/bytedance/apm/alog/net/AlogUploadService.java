package com.bytedance.apm.alog.net;

import a.a;
import android.text.TextUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.apm.util.SlardarProperties;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AlogUploadService {
    public static String UPLOAD_URL = "https://mon.zijieapi.com/monitor/collect/c/logcollect";

    public interface AlogCallBack {
        void onSuccess(boolean r1, int r2, Exception r3, JSONObject r4);
    }

    public AlogUploadService() {
    }

    public static void setUploadHost(String r2) {
        UPLOAD_URL = a.k("https://", r2, ReportConsts.FILE_COLLECT_PATH);
    }

    public static void setUploadUrl(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        UPLOAD_URL = r1;
        return;
    }

    public static boolean uploadAlogFiles(String r7, String r8, String r9, List<String> r10, String r11, JSONObject r12) {
        return uploadAlogFiles(r7, r8, r9, r10, r11, r12, null);
    }

    public static boolean uploadAlogFiles(String r7, String r8, String r9, List<String> r10, String r11, JSONObject r12, AlogCallBack r13) {
        IHttpService r3 = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Exception -> L10 IOException -> L12
        HashMap r4 = new HashMap();     // Catch: Exception -> L10 IOException -> L12
        r4.put("scene", r11);     // Catch: Exception -> L10 IOException -> L12
        IMultipartUploader r5 = r3.buildMultipartUpload(UPLOAD_URL, "UTF-8", false, r4);     // Catch: Exception -> L10 IOException -> L12
        r5.addFormField("aid", r7);     // Catch: Exception -> L10 IOException -> L12
        r5.addFormField("verify_info", SlardarProperties.getReleaseBuild());     // Catch: Exception -> L10 IOException -> L12
        r5.addFormField("device_id", r8);     // Catch: Exception -> L10 IOException -> L12
        r5.addFormField("os", "Android");     // Catch: Exception -> L10 IOException -> L12
        r5.addFormField("process_name", r9);     // Catch: Exception -> L10 IOException -> L12
        Iterator<String> r14 = r10.iterator();     // Catch: Exception -> L10 IOException -> L12
    L6:
        if (r14.hasNext() == false) goto L14;
        File r6 = new File(r14.next());     // Catch: Exception -> L10 IOException -> L12
        if (r6.exists() == false) goto L6;
        HashMap r15 = new HashMap();     // Catch: Exception -> L10 IOException -> L12
        r15.put("logtype", CloudControlInf.ALOG);     // Catch: Exception -> L10 IOException -> L12
        r15.put("scene", r11);     // Catch: Exception -> L10 IOException -> L12
        r15.put("env", "params.txt");     // Catch: Exception -> L10 IOException -> L12
        r5.addFilePart(r6.getName(), r6, null, r15);     // Catch: Exception -> L10 IOException -> L12
        goto L6
    L14:
        HashMap r16 = new HashMap();     // Catch: Exception -> L10 IOException -> L12
        r16.put("filetype", "common_params");     // Catch: Exception -> L10 IOException -> L12
        r16.put("logtype", "env");     // Catch: Exception -> L10 IOException -> L12
        if (r12 != null) goto L17;
        String r17 = null;
    L19:
        if (TextUtils.isEmpty(r17) == false) goto L23;
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L10 IOException -> L12
        r18.put("defaultData", "none commonParams");     // Catch: Exception -> L10 IOException -> L12 JSONException -> L56
    L22:
        r17 = r18.toString();     // Catch: Exception -> L10 IOException -> L12
    L23:
        r5.addFilePart("params.txt", r17, HTTP.PLAIN_TEXT_TYPE, r16);     // Catch: Exception -> L10 IOException -> L12
        HttpResponse r19 = r5.finish();     // Catch: Exception -> L10 IOException -> L12
    L28:
        e = move-exception;
        if (r13 != null) goto L49;
    L55:
        return false;
    L49:
        r13.onSuccess(false, 7, e, null);     // Catch: Exception -> L10 IOException -> L12
        goto L55
    L25:
        if (r19.getResponseBytes() != null) goto L31;
        if (r13 == null) goto L30;
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L10 IOException -> L12 JSONException -> L28
        r20.put("ALOG_UPLOAD_RESPONSE", "null");     // Catch: Exception -> L10 IOException -> L12 JSONException -> L28
        r20.put("ALOG_UPLOAD_STATUS", r19.getStatusCode());     // Catch: Exception -> L10 IOException -> L12 JSONException -> L28
        r13.onSuccess(false, 11, null, r20);     // Catch: Exception -> L10 IOException -> L12 JSONException -> L28
    L30:
        return false;
    L31:
        JSONObject r21 = new JSONObject(new String(r19.getResponseBytes()));     // Catch: Exception -> L10 IOException -> L12 JSONException -> L28
        int r22 = r21.optInt("errno", -1);     // Catch: Exception -> L10 IOException -> L12 JSONException -> L28
        if (r22 != 200) goto L44;
        String r23 = r21.optString("message");     // Catch: Exception -> L10 IOException -> L12 JSONException -> L28
        if (ReportConsts.RESPONSE_MESSAGE_LONG_ESCAPE.equals(r23) == false) goto L36;
    L42:
        r13.onSuccess(false, 13, null, r21);     // Catch: Exception -> L10 IOException -> L12 JSONException -> L28
        return false;
    L36:
        if ("drop data".equals(r23) == true) goto L42;
        if (r13 == null) goto L41;
        r13.onSuccess(true, -1, null, r21);     // Catch: Exception -> L10 IOException -> L12 JSONException -> L28
    L41:
        return true;
    L44:
        if (r13 == null) goto L55;
        JSONObject r24 = new JSONObject();     // Catch: Exception -> L10 IOException -> L12 JSONException -> L28
        r24.put(AlogMonitor.ALOG_RESULT_INFO, r22);     // Catch: Exception -> L10 IOException -> L12 JSONException -> L28
        r13.onSuccess(false, 6, null, r24);     // Catch: Exception -> L10 IOException -> L12 JSONException -> L28
        goto L55
    L17:
        r17 = r12.toString();     // Catch: Exception -> L10 IOException -> L12
    L12:
        e = move-exception;
        if (r13 == null) goto L55;
        r13.onSuccess(false, 8, e, null);
    L10:
        e = move-exception;
        if (r13 == null) goto L55;
        r13.onSuccess(false, 10, e, null);
        goto L55
    }
}
