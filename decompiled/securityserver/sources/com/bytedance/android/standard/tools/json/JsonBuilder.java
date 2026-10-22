package com.bytedance.android.standard.tools.json;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsonBuilder {
    private JSONObject mJsonObject;

    public JsonBuilder() {
        this.mJsonObject = new JSONObject();
    }

    public JSONObject create() {
        return this.mJsonObject;
    }

    public JsonBuilder put(String r2, boolean r3) {
        this.mJsonObject.put(r2, r3);     // Catch: JSONException -> L4
    L6:
        return this;
    L4:
        e = move-exception;
        e.printStackTrace();
        this.mJsonObject.remove(r2);
        goto L6
    }

    public JsonBuilder put(String r2, int r3) {
        this.mJsonObject.put(r2, r3);     // Catch: JSONException -> L4
    L6:
        return this;
    L4:
        e = move-exception;
        e.printStackTrace();
        this.mJsonObject.remove(r2);
        goto L6
    }

    public JsonBuilder put(String r2, long r3) {
        this.mJsonObject.put(r2, r3);     // Catch: JSONException -> L4
    L6:
        return this;
    L4:
        e = move-exception;
        e.printStackTrace();
        this.mJsonObject.remove(r2);
        goto L6
    }

    public JsonBuilder put(String r2, double r3) {
        this.mJsonObject.put(r2, r3);     // Catch: JSONException -> L4
    L6:
        return this;
    L4:
        e = move-exception;
        e.printStackTrace();
        this.mJsonObject.remove(r2);
        goto L6
    }

    public JsonBuilder put(String r2, Object r3) {
        this.mJsonObject.put(r2, r3);     // Catch: JSONException -> L4
    L6:
        return this;
    L4:
        e = move-exception;
        e.printStackTrace();
        this.mJsonObject.remove(r2);
        goto L6
    }
}
