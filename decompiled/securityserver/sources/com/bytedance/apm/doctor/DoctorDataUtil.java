package com.bytedance.apm.doctor;

import android.text.TextUtils;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.ApmBaseContext;
import com.ss.android.common.util.ToolUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DoctorDataUtil {
    public static final String KEY_DATA = "data";
    public static final String KEY_LIST = "list";
    private static AtomicInteger eventNum;

    static {
        eventNum = new AtomicInteger(0);
    }

    public DoctorDataUtil() {
    }

    public static void onReceivedEvent(String r5, JSONObject r6, boolean r7) {
        JSONObject r2 = r6.optJSONObject(DoctorConstants.DATA_DOCTOR);
        if (r2 != null) goto L15;
        r2 = new JSONObject();
    L15:
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (r2.optInt(DoctorConstants.DATA_ID, -1) != (-1)) goto L11;
        r2.put(DoctorConstants.DATA_ID, eventNum.incrementAndGet());     // Catch: Exception -> L9
    L11:
        r2.put(DoctorConstants.DATA_PROCESS, ToolUtils.getCurProcessName(ApmBaseContext.getContext()));     // Catch: Exception -> L9
        r2.put(DoctorConstants.DATA_TYPE, r5);     // Catch: Exception -> L9
        r2.put(DoctorConstants.DATA_SAMPLE, r7);     // Catch: Exception -> L9
        r2.put(DoctorConstants.DATA_SAVE_DB_IMMEDIATE, false);     // Catch: Exception -> L9
        r2.put(DoctorConstants.DATA_UPLOAD_IMMEDIATE, false);     // Catch: Exception -> L9
        r2.put(DoctorConstants.DATA_AID, ApmContext.getAid());     // Catch: Exception -> L9
        r6.put(DoctorConstants.DATA_DOCTOR, r2);     // Catch: Exception -> L9
        JSONObject r8 = new JSONObject(r6.toString());     // Catch: Exception -> L9
        DoctorManager.getInstance().onDataEvent(DoctorConstants.DATA_RECEIVE, r8);     // Catch: Exception -> L9
        DoctorManager.getInstance().onDataEvent(DoctorConstants.DATA_CACHE, r8);     // Catch: Exception -> L9
    }

    public static void saveToFileEvent(JSONObject r2) {
        if (r2 != null) goto L7;
        return;
    L7:
        JSONObject r0 = new JSONObject(r2.toString());     // Catch: Exception -> L6
        DoctorManager.getInstance().onDataEvent(DoctorConstants.DATA_SAVE_TO_DB, r0);     // Catch: Exception -> L6
        return;
    }

    public static void sendBeginEvent(byte[] r2) {
        List<JSONObject> r3 = toJSONObject(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        Iterator<JSONObject> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        sendEvent(r4.next(), DoctorConstants.DATA_SEND_BEGIN);
        goto L7
    }

    private static void sendEvent(JSONObject r1, String r2) {
        if (r1 != null) goto L7;
        return;
    L7:
        DoctorManager.getInstance().onDataEvent(r2, r1);     // Catch: Exception -> L6
        return;
    }

    public static void sendFailEvent(byte[] r2) {
        Iterator<JSONObject> r3 = toJSONObject(r2).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        JSONObject r0 = r3.next();
        sendEvent(r0, DoctorConstants.DATA_SEND_FAIL);
        sendEvent(r0, DoctorConstants.DATA_SEND_END);
        goto L4
    }

    public static void sendResponseEvent(byte[] r4, JSONObject r5) {
        Iterator<JSONObject> r6 = toJSONObject(r4).iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        JSONObject r1 = r6.next();
        JSONObject r2 = new JSONObject(r5.toString());     // Catch: JSONException -> L9
        JSONObject r3 = r1.optJSONObject(DoctorConstants.DATA_DOCTOR);     // Catch: JSONException -> L9
        if (r3 == null) goto L11;
        r2.put(DoctorConstants.DATA_DOCTOR, r3);     // Catch: JSONException -> L9
    L11:
        sendEvent(r2, DoctorConstants.DATA_SEND_RESPONSE);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L4
    }

    public static void sendSuccessEvent(byte[] r4) {
        Iterator<JSONObject> r5 = toJSONObject(r4).iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        JSONObject r0 = r5.next();
        JSONObject r1 = r0.optJSONObject(DoctorConstants.DATA_DOCTOR);     // Catch: Exception -> L11
        if (r1 == null) goto L9;
        r1.put(DoctorConstants.DATA_SEND_RESULT, 200);     // Catch: Exception -> L11
    L9:
        sendEvent(r0, DoctorConstants.DATA_SEND_SUCCESS);
        sendEvent(r0, DoctorConstants.DATA_SEND_END);
        goto L4
    }

    private static List<JSONObject> toJSONObject(byte[] r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        String r2 = new String(r7);
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return null;
    L8:
        ArrayList r8 = new ArrayList();
        JSONObject r3 = new JSONObject(r2);     // Catch: Exception -> L35
        int r5 = 0;
        if (r3.has("list") == false) goto L29;
        JSONArray r0 = r3.optJSONArray("list");     // Catch: Exception -> L35
        if (r0 != null) goto L15;
        return null;
    L15:
        int r1 = 0;
    L17:
        if (r1 >= r0.length()) goto L34;
        JSONObject r4 = r0.getJSONObject(r1);     // Catch: Exception -> L35
        if (r4 == null) goto L28;
        JSONArray r6 = r4.optJSONArray("data");     // Catch: Exception -> L35
        if (r6 == null) goto L28;
        int r9 = 0;
    L26:
        if (r9 >= r6.length()) goto L28;
        r8.add(r6.getJSONObject(r9));     // Catch: Exception -> L35
        r9 = r9 + 1;     // Catch: Exception -> L35
    L28:
        r1 = r1 + 1;     // Catch: Exception -> L35
        goto L17
    L29:
        JSONArray r10 = r3.optJSONArray("data");     // Catch: Exception -> L35
    L31:
        if (r5 >= r10.length()) goto L34;
        r8.add(r10.getJSONObject(r5));     // Catch: Exception -> L35
        r5 = r5 + 1;
    L34:
        return r8;
    }
}
