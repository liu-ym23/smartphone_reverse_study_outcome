package com.bytedance.securityserver.robotspolicy;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class RobotsPolicyValidator {
    public static final List<String> ALLOWED_INTENTS = null;
    public static final String KEY_AGENT_INTENTS = "agent_intents";
    public static final String KEY_BRANDS = "brands";
    public static final String KEY_BYPASS_POLICY = "bypass_policy";
    public static final String KEY_DEFAULT_POLICY = "default_policy";
    public static final String KEY_OEM_GROUPS = "oem_groups";
    public static final String KEY_PACKAGE_NAME = "package";
    public static final String KEY_POLICY = "policy";
    public static final String KEY_POLICY_VERSION = "policy_version";
    public static final String KEY_SCHEMA = "schema";
    public static final String KEY_SCOPE = "scope";
    public static final String KEY_UPDATED_AT = "updated_at";
    private static final int MAX_OEM_GROUPS_SIZE = 32;
    public static final long MAX_POLICY_SIZE = 10240;
    private static final String TAG = "RobotsPolicyValidator";
    public static final String VALUE_SCHEMA = "AGRP-Policy/1.0";

    static {
        ArrayList r0 = new ArrayList();
        ALLOWED_INTENTS = r0;
        r0.add("modify_content");
        r0.add("delete_content");
        r0.add("account_incentive");
        r0.add("post_content");
    }

    private RobotsPolicyValidator() {
    }

    private static boolean hasInvalidAgentIntents(JSONObject r6) {
        Iterator<String> r2 = r6.keys();     // Catch: Exception -> L10
    L5:
        if (r2.hasNext() == false) goto L16;
        String r3 = r2.next();     // Catch: Exception -> L10
        if (ALLOWED_INTENTS.contains(r3) == false) goto L8;
        Object r4 = r6.get(r3);     // Catch: Exception -> L10
        if ((r4 instanceof Boolean) == true) goto L5;
        Log.w(TAG, "Invalid agent intent value type for " + r3 + ": " + r4.getClass().getSimpleName());     // Catch: Exception -> L10
        return true;
    L8:
        Log.w(TAG, "Invalid agent intent type: " + r3);     // Catch: Exception -> L10
        return true;
    L16:
        return false;
    L10:
        e = move-exception;
        Log.w(TAG, "Error validating agent intents", e);
        return true;
    }

    public static boolean isInvalidPolicy(JSONObject r19, String r20) {
    L12:
        e = move-exception;
        Log.w(TAG, "Policy validation failed for " + r20, e);
        return true;
    L4:
        if (r19.has(KEY_SCHEMA) == true) goto L6;
    L105:
        Log.w(TAG, "Invalid schema in policy for " + r20);     // Catch: Exception -> L12
        return true;
    L6:
        if (VALUE_SCHEMA.equals(r19.getString(KEY_SCHEMA)) == false) goto L105;
        if (r19.has(KEY_POLICY_VERSION) == true) goto L109;
        Log.w(TAG, "Missing policy_version in policy for " + r20);     // Catch: Exception -> L12
        return true;
    L109:
        r19.getInt(KEY_POLICY_VERSION);     // Catch: Exception -> L103
    L16:
        if (r19.has(KEY_UPDATED_AT) == true) goto L20;
        Log.w(TAG, "Missing updated_at in policy for " + r20);     // Catch: Exception -> L12
        return true;
    L20:
        if (r19.has("package") == false) goto L101;
        String r7 = r19.getString("package");     // Catch: Exception -> L12
        if (r20.equals(r7) == true) goto L27;
        Log.w(TAG, "Package name mismatch in policy: " + r7 + " vs " + r20);     // Catch: Exception -> L12
        return true;
    L27:
        if (r19.has(KEY_DEFAULT_POLICY) == false) goto L34;
        JSONObject r6 = r19.getJSONObject(KEY_DEFAULT_POLICY);     // Catch: Exception -> L12
        if (r6.has(KEY_AGENT_INTENTS) == false) goto L34;
        if (hasInvalidAgentIntents(r6.getJSONObject(KEY_AGENT_INTENTS)) == false) goto L34;
        return true;
    L34:
        if (r19.has(KEY_SCOPE) == false) goto L41;
        JSONObject r5 = r19.getJSONObject(KEY_SCOPE);     // Catch: Exception -> L12
        if (r5.has(KEY_AGENT_INTENTS) == false) goto L41;
        if (hasInvalidAgentIntents(r5.getJSONObject(KEY_AGENT_INTENTS)) == false) goto L41;
        return true;
    L41:
        if (r19.has(KEY_OEM_GROUPS) == false) goto L100;
        JSONArray r0 = r19.optJSONArray(KEY_OEM_GROUPS);     // Catch: Exception -> L12
        if (r0 != null) goto L47;
        Log.w(TAG, "Invalid oem_groups type, should be array");     // Catch: Exception -> L12
        return true;
    L47:
        if (r0.length() <= 32) goto L50;
        Log.w(TAG, "oem_groups array length exceeds 32");     // Catch: Exception -> L12
        return true;
    L50:
        int r4 = 0;
    L52:
        if (r4 >= r0.length()) goto L100;
        JSONObject r8 = r0.optJSONObject(r4);     // Catch: Exception -> L12
        if (r8 == null) goto L55;
        JSONArray r9 = r8.optJSONArray(KEY_BRANDS);     // Catch: Exception -> L12
        if (r9 == null) goto L98;
        if (r9.length() == 0) goto L98;
        int r10 = 0;
    L64:
        if (r10 >= r9.length()) goto L73;
        String r11 = r9.optString(r10, null);     // Catch: Exception -> L12
        if (r11 == null) goto L71;
        if (r11.contains("*") == true) goto L71;
        r10 = r10 + 1;     // Catch: Exception -> L12
    L71:
        Log.w(TAG, "Invalid brand value: " + r11);     // Catch: Exception -> L12
        return true;
    L73:
        boolean r12 = r8.has("policy");     // Catch: Exception -> L12
        boolean r13 = r8.has(KEY_BYPASS_POLICY);     // Catch: Exception -> L12
        if (r12 == false) goto L78;
        if (r13 == false) goto L78;
        Log.w(TAG, "oem_groups element cannot have both policy and bypass_policy");     // Catch: Exception -> L12
        return true;
    L78:
        if (r12 == true) goto L82;
        if (r13 == true) goto L82;
        Log.w(TAG, "oem_groups element must have either policy or bypass_policy");     // Catch: Exception -> L12
        return true;
    L82:
        if (r13 == true) goto L84;
    L87:
        if (r12 == false) goto L97;
        JSONObject r14 = r8.optJSONObject("policy");     // Catch: Exception -> L12
        if (r14 == null) goto L90;
        if (r14.has(KEY_AGENT_INTENTS) == false) goto L97;
        if (hasInvalidAgentIntents(r14.getJSONObject(KEY_AGENT_INTENTS)) == false) goto L97;
        return true;
    L90:
        Log.w(TAG, "policy in oem_groups must be an object");     // Catch: Exception -> L12
        return true;
    L97:
        r4 = r4 + 1;     // Catch: Exception -> L12
        goto L52
    L84:
        if (r8.optBoolean(KEY_BYPASS_POLICY, false) == true) goto L87;
        Log.w(TAG, "bypass_policy must be true if present");     // Catch: Exception -> L12
        return true;
    L98:
        Log.w(TAG, "brands field in oem_groups must be a non-empty array");     // Catch: Exception -> L12
        return true;
    L55:
        Log.w(TAG, "oem_groups element is not a json object");     // Catch: Exception -> L12
        return true;
    L100:
        return false;
    L101:
        Log.w(TAG, "Package name missing in policy for " + r20);     // Catch: Exception -> L12
        return true;
    L103:
        Log.w(TAG, "Invalid policy_version type for " + r20);     // Catch: Exception -> L12
        return true;
    }

    public static boolean isPolicyExpired(Context r9, String r10, int r11) {
        Cursor r12 = r9.getContentResolver().query(RobotsPolicyContract.buildPolicyUri(), new String[]{RobotsPolicyContract.COL_VERSION}, "package_name=?", new String[]{r10}, null);     // Catch: Exception -> L13
        if (r12 != null) goto L26;
    L21:
        if (r12 == null) goto L25;
        r12.close();     // Catch: Exception -> L13
    L25:
        return false;
    L26:
    L15:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Exception -> L13
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L13
        goto L20
    L6:
        if (r12.moveToFirst() == false) goto L21;
        int r2 = r12.getInt(0);     // Catch: Throwable -> L15
        Log.d(TAG, "Existing version for " + r10 + " is " + r2 + ", new version is " + r11);     // Catch: Throwable -> L15
        if (r2 < r11) goto L10;
        boolean r13 = true;
    L11:
        r12.close();     // Catch: Exception -> L13
        return r13;
    L10:
        r13 = false;
        goto L11
    L13:
        e = move-exception;
        Log.w(TAG, "Failed to query existing version for " + r10, e);
        goto L25
    }
}
