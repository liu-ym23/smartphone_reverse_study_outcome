package com.bytedance.apm.alog.net;

import android.text.TextUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.apm.util.SlardarProperties;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.monitor.cloudmessage.consts.CloudControlInf;
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

    static {
    }

    public AlogUploadService() {
    }

    public static void setUploadUrl(String r1) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        UPLOAD_URL = r1;
        return;
    }

    public static void setUploadHost(String r2) {
        UPLOAD_URL = "https://" + r2 + ReportConsts.FILE_COLLECT_PATH;
    }

    public static boolean uploadAlogFiles(String r7, String r8, String r9, List<String> r10, String r11, JSONObject r12) {
        return uploadAlogFiles(r7, r8, r9, r10, r11, r12, null);
    }

    public static boolean uploadAlogFiles(String r7, String r8, String r9, List<String> r10, String r11, JSONObject r12, AlogCallBack r13) {
        IHttpService r3 = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Exception -> L46 IOException -> L49
        HashMap r4 = new HashMap();     // Catch: Exception -> L46 IOException -> L49
        r4.put("scene", r11);     // Catch: Exception -> L46 IOException -> L49
        IMultipartUploader r5 = r3.buildMultipartUpload(UPLOAD_URL, "UTF-8", false, r4);     // Catch: Exception -> L46 IOException -> L49
        r5.addFormField("aid", r7);     // Catch: Exception -> L46 IOException -> L49
        r5.addFormField("verify_info", SlardarProperties.getReleaseBuild());     // Catch: Exception -> L46 IOException -> L49
        r5.addFormField("device_id", r8);     // Catch: Exception -> L46 IOException -> L49
        r5.addFormField("os", "Android");     // Catch: Exception -> L46 IOException -> L49
        r5.addFormField("process_name", r9);     // Catch: Exception -> L46 IOException -> L49
        Iterator<String> r14 = r10.iterator();     // Catch: Exception -> L46 IOException -> L49
    L6:
        if (r14.hasNext() == false) goto L10;
        File r6 = new File(r14.next());     // Catch: Exception -> L46 IOException -> L49
        if (r6.exists() == false) goto L6;
        HashMap r15 = new HashMap();     // Catch: Exception -> L46 IOException -> L49
        r15.put("logtype", CloudControlInf.ALOG);     // Catch: Exception -> L46 IOException -> L49
        r15.put("scene", r11);     // Catch: Exception -> L46 IOException -> L49
        r15.put("env", "params.txt");     // Catch: Exception -> L46 IOException -> L49
        r5.addFilePart(r6.getName(), r6, null, r15);     // Catch: Exception -> L46 IOException -> L49
        goto L6
    L10:
        HashMap r16 = new HashMap();     // Catch: Exception -> L46 IOException -> L49
        r16.put("filetype", "common_params");     // Catch: Exception -> L46 IOException -> L49
        r16.put("logtype", "env");     // Catch: Exception -> L46 IOException -> L49
        if (r12 != null) goto L13;
        String r17 = null;
    L15:
        if (TextUtils.isEmpty(r17) == false) goto L19;
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L46 IOException -> L49
        r18.put("defaultData", "none commonParams");     // Catch: JSONException -> L53 Exception -> L46 IOException -> L49
    L18:
        r17 = r18.toString();     // Catch: Exception -> L46 IOException -> L49
    L19:
        r5.addFilePart("params.txt", r17, "text/plain", r16);     // Catch: Exception -> L46 IOException -> L49
        HttpResponse r19 = r5.finish();     // Catch: Exception -> L46 IOException -> L49
    L41:
        e = move-exception;
        if (r13 != null) goto L44;
    L52:
        return false;
    L44:
        r13.onSuccess(false, 7, e, null);     // Catch: Exception -> L46 IOException -> L49
        goto L52
    L21:
        if (r19.getResponseBytes() != null) goto L25;
        if (r13 == null) goto L24;
        JSONObject r20 = new JSONObject();     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        r20.put("ALOG_UPLOAD_RESPONSE", "null");     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        r20.put("ALOG_UPLOAD_STATUS", r19.getStatusCode());     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        r13.onSuccess(false, 11, null, r20);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
    L24:
        return false;
    L25:
        JSONObject r21 = new JSONObject(new String(r19.getResponseBytes()));     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        int r22 = r21.optInt("errno", -1);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        if (r22 != 200) goto L38;
        String r23 = r21.optString("message");     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        if (ReportConsts.RESPONSE_MESSAGE_LONG_ESCAPE.equals(r23) == false) goto L30;
    L36:
        r13.onSuccess(false, 13, null, r21);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        return false;
    L30:
        if ("drop data".equals(r23) == true) goto L36;
        if (r13 == null) goto L35;
        r13.onSuccess(true, -1, null, r21);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
    L35:
        return true;
    L38:
        if (r13 == null) goto L52;
        JSONObject r24 = new JSONObject();     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        r24.put(AlogMonitor.ALOG_RESULT_INFO, r22);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        r13.onSuccess(false, 6, null, r24);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L49
        goto L52
    L13:
        r17 = r12.toString();     // Catch: Exception -> L46 IOException -> L49
    L49:
        e = move-exception;
        if (r13 == null) goto L52;
        r13.onSuccess(false, 8, e, null);
    L46:
        e = move-exception;
        if (r13 == null) goto L52;
        r13.onSuccess(false, 10, e, null);
        goto L52
    }
}
