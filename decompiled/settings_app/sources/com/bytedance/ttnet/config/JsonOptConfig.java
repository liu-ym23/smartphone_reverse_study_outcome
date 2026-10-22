package com.bytedance.ttnet.config;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class JsonOptConfig {
    private static volatile boolean mEnableJsonOpt = false;
    private static volatile boolean mEnableTNCJsonOpt = false;
    private static volatile IJsonHandler mJsonHandler;

    public interface IJsonHandler {
        String optString(String r1, String[] r2);
    }

    public static class JsonWrapper {
        private JSONObject mJsonObject;
        private String mJsonStr;

        public JsonWrapper(String r1, JSONObject r2) {
            this.mJsonStr = r1;
            this.mJsonObject = r2;
        }

        public String jsonStr() {
            if (TextUtils.isEmpty(this.mJsonStr) == false) goto L6;
            this.mJsonStr = this.mJsonObject.toString();
        L6:
            return this.mJsonStr;
        }

        public JSONObject jsonObject() throws JSONException {
            if (this.mJsonObject != null) goto L6;
            this.mJsonObject = new JSONObject(this.mJsonStr);
        L6:
            return this.mJsonObject;
        }

        public boolean isValid() {
            if (TextUtils.isEmpty(this.mJsonStr) == false) goto L10;
            JSONObject r1 = this.mJsonObject;
            if (r1 != null) goto L7;
        L9:
            return false;
        L7:
            if (r1.length() <= 0) goto L9;
        L10:
            return true;
        }
    }

    static {
    }

    public JsonOptConfig() {
    }

    public static void enableJsonOpt(boolean r0) {
        mEnableJsonOpt = r0;
    }

    public static boolean isJsonOptEnable() {
        return mEnableJsonOpt;
    }

    public static void enableTNCJsonOpt(boolean r0) {
        mEnableTNCJsonOpt = r0;
    }

    public static boolean isTNCJsonOptEnable() {
        return mEnableTNCJsonOpt;
    }

    public static boolean isValid(Object r3) {
        if ((r3 instanceof String) == false) goto L10;
        if (((String) r3).length() <= 0) goto L8;
        return true;
    L8:
        return false;
    L10:
        if ((r3 instanceof JSONObject) == false) goto L17;
        if (((JSONObject) r3).length() <= 0) goto L15;
        return true;
    L15:
        return false;
    L17:
        if ((r3 instanceof JsonWrapper) == true) goto L19;
        return false;
    L19:
        return ((JsonWrapper) r3).isValid();
    }

    public static JSONObject jsonObject(Object r1) throws JSONException {
        if ((r1 instanceof String) == false) goto L7;
        return new JSONObject((String) r1);
    L7:
        if ((r1 instanceof JSONObject) == false) goto L11;
        return (JSONObject) r1;
    L11:
        if ((r1 instanceof JsonWrapper) == true) goto L13;
        return null;
    L13:
        return ((JsonWrapper) r1).jsonObject();
    }

    public static JSONObject tncJSONObject(Object r1) {
        if ((r1 instanceof JSONObject) == false) goto L7;
        return (JSONObject) r1;
    L7:
        if ((r1 instanceof JsonWrapper) == false) goto L13;
        return ((JsonWrapper) r1).jsonObject().optJSONObject("data");
    L10:
        th = move-exception;
        th.printStackTrace();
    L13:
        return new JSONObject();
    }

    public static void setJsonHandler(IJsonHandler r0) {
        mJsonHandler = r0;
    }

    public static String optString(Object r3, JSONObject r4, String[] r5) {
        if (r5 != null) goto L5;
    L7:
        String r1 = null;
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L12;
        return null;
    L12:
        if (mJsonHandler == null) goto L18;
        if ((r3 instanceof JsonWrapper) == false) goto L18;
        return mJsonHandler.optString(((JsonWrapper) r3).jsonStr(), r5);
    L18:
        return r4.optString(r1);
    L5:
        if (r5.length <= 0) goto L7;
        r1 = r5[r5.length - 1];
        goto L9
    }
}
