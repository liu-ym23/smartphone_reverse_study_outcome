package com.obric.server.security.audit;

import android.text.TextUtils;
import com.android.server.wm.ObricActivityTaskManagerServiceImpl;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class RobotsLog {
    private static final String FIELD_PAYLOAD_ENCRYPTED = "payload_encrypted";
    private static final String FIELD_PAYLOAD_MODE = "payload_mode";
    private static final String FIELD_PAYLOAD_RAW_ENABLED = "payload_raw_enabled";
    private static final String PAYLOAD_MODE_ENCRYPTED_ONLY = "encrypted_only";

    RobotsLog() {
    }

    public boolean isValidPayload(String json) {
        if (json != null) goto L10;
        return false;
    L10:
        new JSONObject(json);     // Catch: JSONException -> L8
        return true;
    L9:
        return false;
    }

    public AuditLogEntry buildEntry(long ts, String instructionId, String json) {
        JSONObject o = new JSONObject(json);     // Catch: JSONException -> L12
        JSONObject dec = parseNestedObject(o, "agent_decision");     // Catch: JSONException -> L12
        boolean rawEnabled = isPayloadRawEnabled(o);     // Catch: JSONException -> L12
        byte[] payloadEncrypted = extractPayloadEncrypted(o);     // Catch: JSONException -> L12
        if (payloadEncrypted == null) goto L6;
        removePayloadEncrypted(o);     // Catch: JSONException -> L12
    L6:
        removeInternalPayloadModeFields(o);     // Catch: JSONException -> L12
        if (rawEnabled == false) goto L9;
        byte[] payloadRaw = o.toString().getBytes(StandardCharsets.UTF_8);     // Catch: JSONException -> L12
    L10:
        String[] timestampStrHolder = new String[1];     // Catch: JSONException -> L12
        long resolvedTs = resolveTs(o, ts, timestampStrHolder);     // Catch: JSONException -> L12
        return AuditLogEntry.builder().ts(resolvedTs).instructionId(resolveInstructionId(o, dec, instructionId)).targetPackage(o.optString(ObricActivityTaskManagerServiceImpl.TARGET_PACKAGE, "")).deviceId(o.optString("device_id", "")).uid(o.optString("uid", "")).isAgentRelated(1).logSource(optNullableString(o, ObricActivityTaskManagerServiceImpl.LOG_SOURCE)).timestampStr(timestampStrHolder[0]).targetActivity(optNullableString(o, ObricActivityTaskManagerServiceImpl.TARGET_ACTIVITY)).intentType(optNullableString(o, "intent_type")).agentName(optNullableString(o, ObricActivityTaskManagerServiceImpl.AGENT_NAME)).payloadRaw(payloadRaw).payloadEncrypted(payloadEncrypted).payloadFormat(2).build();
    L9:
        payloadRaw = null;
    L13:
        AuditLogEntry.Builder r5 = AuditLogEntry.builder().ts(ts).instructionId(instructionId).targetPackage("").isAgentRelated(1);
        if (json == null) goto L16;
        byte[] r7 = json.getBytes(StandardCharsets.UTF_8);
    L18:
        return r5.payloadRaw(r7).payloadFormat(2).build();
    L16:
        r7 = null;
        goto L18
    }

    private static JSONObject parseNestedObject(JSONObject o, String key) {
        Object raw = o.opt(key);
        if ((raw instanceof JSONObject) == false) goto L7;
        return (JSONObject) raw;
    L7:
        if ((raw instanceof String) == true) goto L9;
    L14:
        return null;
    L9:
        if (((String) raw).isEmpty() == true) goto L14;
        return new JSONObject((String) raw);
    L13:
        return null;
    }

    private static String resolveInstructionId(JSONObject o, JSONObject dec, String fallbackInstructionId) {
        String v = o.optString("instruction_id", "");
        if (TextUtils.isEmpty(v) == true) goto L5;
        return v;
    L5:
        if (dec == null) goto L9;
        String v2 = dec.optString("instruction_id", "");
        if (TextUtils.isEmpty(v2) == true) goto L9;
        return v2;
    L9:
        return fallbackInstructionId;
    }

    private static long resolveTs(JSONObject o, long fallbackTs, String[] timestampStrHolder) {
        if (o.has(ObricActivityTaskManagerServiceImpl.TIMESTAMP) == true) goto L5;
    L19:
        return fallbackTs;
    L5:
        if (o.isNull(ObricActivityTaskManagerServiceImpl.TIMESTAMP) == true) goto L19;
        Object tsValue = o.opt(ObricActivityTaskManagerServiceImpl.TIMESTAMP);
        if ((tsValue instanceof Number) == false) goto L11;
        long resolved = ((Number) tsValue).longValue();
        timestampStrHolder[0] = String.valueOf(resolved);
        return resolved;
    L11:
        String tsStr = optNullableString(o, ObricActivityTaskManagerServiceImpl.TIMESTAMP);
        if (TextUtils.isEmpty(tsStr) == false) goto L14;
        return fallbackTs;
    L14:
        timestampStrHolder[0] = tsStr;
        return Long.parseLong(tsStr);
    L18:
        return fallbackTs;
    }

    private static byte[] extractPayloadEncrypted(JSONObject o) {
        if (o != null) goto L5;
    L14:
        return null;
    L5:
        if (o.has(FIELD_PAYLOAD_ENCRYPTED) == false) goto L14;
        if (o.isNull(FIELD_PAYLOAD_ENCRYPTED) == true) goto L14;
        String text = o.optString(FIELD_PAYLOAD_ENCRYPTED, "");
        if (TextUtils.isEmpty(text) == false) goto L13;
        return null;
    L13:
        return text.getBytes(StandardCharsets.UTF_8);
    }

    private static String optNullableString(JSONObject o, String key) {
        if (o != null) goto L4;
        return null;
    L4:
        if (o.has(key) == true) goto L6;
        return null;
    L6:
        if (o.isNull(key) == false) goto L9;
        return null;
    L9:
        return o.optString(key, "");
    }

    private static void removePayloadEncrypted(JSONObject o) {
        if (o.has(FIELD_PAYLOAD_ENCRYPTED) == false) goto L6;
        o.remove(FIELD_PAYLOAD_ENCRYPTED);
        return;
    }

    private static boolean isPayloadRawEnabled(JSONObject o) {
        if (o != null) goto L6;
        return true;
    L6:
        if (PAYLOAD_MODE_ENCRYPTED_ONLY.equals(o.optString(FIELD_PAYLOAD_MODE, "")) == false) goto L9;
        return false;
    L9:
        if (o.has(FIELD_PAYLOAD_RAW_ENABLED) == true) goto L11;
    L13:
        return true;
    L11:
        if (o.optBoolean(FIELD_PAYLOAD_RAW_ENABLED, true) == true) goto L13;
        return false;
    }

    private static void removeInternalPayloadModeFields(JSONObject o) {
        if (o.has(FIELD_PAYLOAD_MODE) == false) goto L6;
        o.remove(FIELD_PAYLOAD_MODE);
    L6:
        if (o.has(FIELD_PAYLOAD_RAW_ENABLED) == false) goto L9;
        o.remove(FIELD_PAYLOAD_RAW_ENABLED);
        return;
    }
}
