package com.bytedance.apm.p.g;

import android.text.TextUtils;
import com.bytedance.apm.util.t;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import d.b.b.n.c;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1681a = "https://mon.zijieapi.com/monitor/collect/c/logcollect";

    /* JADX INFO: renamed from: com.bytedance.apm.p.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC0051a {
        void a(boolean r1, int r2, Exception r3, JSONObject r4);
    }

    static {
    }

    public static void a(String r2) {
        f1681a = "https://" + r2 + "/monitor/collect/c/logcollect";
    }

    public static boolean b(String r7, String r8, String r9, List<String> r10, String r11, JSONObject r12, InterfaceC0051a r13) {
        IHttpService r3 = (IHttpService) c.a(IHttpService.class);     // Catch: Exception -> L46 IOException -> L50
        HashMap r4 = new HashMap();     // Catch: Exception -> L46 IOException -> L50
        r4.put("scene", r11);     // Catch: Exception -> L46 IOException -> L50
        IMultipartUploader r5 = r3.buildMultipartUpload(f1681a, "UTF-8", false, r4);     // Catch: Exception -> L46 IOException -> L50
        r5.addFormField(WsConstants.KEY_APP_ID, r7);     // Catch: Exception -> L46 IOException -> L50
        r5.addFormField("verify_info", t.a());     // Catch: Exception -> L46 IOException -> L50
        r5.addFormField(WsConstants.KEY_DEVICE_ID, r8);     // Catch: Exception -> L46 IOException -> L50
        r5.addFormField("os", LocationInfoConst.SYSTEM);     // Catch: Exception -> L46 IOException -> L50
        r5.addFormField("process_name", r9);     // Catch: Exception -> L46 IOException -> L50
        Iterator<String> r14 = r10.iterator();     // Catch: Exception -> L46 IOException -> L50
    L6:
        if (r14.hasNext() == false) goto L10;
        File r6 = new File(r14.next());     // Catch: Exception -> L46 IOException -> L50
        if (r6.exists() == false) goto L6;
        HashMap r15 = new HashMap();     // Catch: Exception -> L46 IOException -> L50
        r15.put("logtype", "alog");     // Catch: Exception -> L46 IOException -> L50
        r15.put("scene", r11);     // Catch: Exception -> L46 IOException -> L50
        r15.put("env", "params.txt");     // Catch: Exception -> L46 IOException -> L50
        r5.addFilePart(r6.getName(), r6, null, r15);     // Catch: Exception -> L46 IOException -> L50
        goto L6
    L10:
        HashMap r16 = new HashMap();     // Catch: Exception -> L46 IOException -> L50
        r16.put("filetype", "common_params");     // Catch: Exception -> L46 IOException -> L50
        r16.put("logtype", "env");     // Catch: Exception -> L46 IOException -> L50
        if (r12 != null) goto L13;
        String r17 = null;
    L15:
        if (TextUtils.isEmpty(r17) == false) goto L19;
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L46 IOException -> L50
        r18.put("defaultData", "none commonParams");     // Catch: JSONException -> L54 Exception -> L46 IOException -> L50
    L18:
        r17 = r18.toString();     // Catch: Exception -> L46 IOException -> L50
    L19:
        r5.addFilePart("params.txt", r17, "text/plain", r16);     // Catch: Exception -> L46 IOException -> L50
        HttpResponse r19 = r5.finish();     // Catch: Exception -> L46 IOException -> L50
    L41:
        e = move-exception;
        if (r13 != null) goto L44;
    L53:
        return false;
    L44:
        r13.a(false, 7, e, null);     // Catch: Exception -> L46 IOException -> L50
        goto L53
    L21:
        if (r19.getResponseBytes() != null) goto L25;
        if (r13 == null) goto L24;
        JSONObject r20 = new JSONObject();     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        r20.put("ALOG_UPLOAD_RESPONSE", "null");     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        r20.put("ALOG_UPLOAD_STATUS", r19.getStatusCode());     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        r13.a(false, 11, null, r20);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
    L24:
        return false;
    L25:
        JSONObject r21 = new JSONObject(new String(r19.getResponseBytes()));     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        if (r21.optInt("errno", -1) != 200) goto L38;
        String r22 = r21.optString("message");     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        if ("long escape".equals(r22) == false) goto L30;
    L36:
        r13.a(false, 13, null, r21);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        return false;
    L30:
        if ("drop data".equals(r22) == true) goto L36;
        if (r13 == null) goto L35;
        r13.a(true, -1, null, r21);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
    L35:
        return true;
    L38:
        if (r13 == null) goto L53;
        r13.a(false, 6, null, r21);     // Catch: JSONException -> L41 Exception -> L46 IOException -> L50
        goto L53
    L13:
        r17 = r12.toString();     // Catch: Exception -> L46 IOException -> L50
    L50:
        e = e;
        if (r13 == null) goto L53;
        int r23 = 8;
    L49:
        r13.a(false, r23, e, null);
    L46:
        e = e;
        if (r13 == null) goto L53;
        r23 = 10;
        goto L49
    }
}
