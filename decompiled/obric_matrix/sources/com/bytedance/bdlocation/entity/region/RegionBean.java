package com.bytedance.bdlocation.entity.region;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RegionBean {
    public static final int DEFAULT_EXPIRE_TIME = 21600000;
    private static final String KEY_ASCINAME = "ASCIName";
    private static final String KEY_CODE = "Code";
    private static final String KEY_EXPIRE_TIME = "expire_time";
    private static final String KEY_GEO_NAME = "GeoNameID";
    private static final String KEY_NAME = "Name";
    private static final String KEY_SOURCE = "source";
    public static final int TYPE_SOURCE_CLIENT_CACHE = 1;
    public static final int TYPE_SOURCE_CLIENT_FALLBACK = 2;
    public static final int TYPE_SOURCE_CLIENT_REALTIME = 0;

    @Nullable
    public String asciName;

    @Nullable
    public String code;

    @Nullable
    public String errorCode;
    public long expireTime;
    public long geoNameID;

    @Nullable
    public String name;
    public int source;

    private RegionBean() {
    }

    public static RegionBean buildFromErrorCode(String r1) {
        RegionBean r0 = new RegionBean();
        r0.errorCode = r1;
        return r0;
    }

    @Nullable
    public static RegionBean buildFromJsonString(String r7, int r8) {
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return null;
    L10:
        JSONObject r0 = new JSONObject(r7);     // Catch: JSONException -> L7
        RegionBean r9 = new RegionBean();     // Catch: JSONException -> L7
        r9.code = JsonUtil.safeOptString(r0, KEY_CODE, null);     // Catch: JSONException -> L7
        r9.geoNameID = JsonUtil.safeOptLong(r0, KEY_GEO_NAME, 0);     // Catch: JSONException -> L7
        r9.asciName = JsonUtil.safeOptString(r0, KEY_ASCINAME, null);     // Catch: JSONException -> L7
        r9.name = JsonUtil.safeOptString(r0, KEY_NAME, null);     // Catch: JSONException -> L7
        r9.expireTime = JsonUtil.safeOptLong(r0, KEY_EXPIRE_TIME, System.currentTimeMillis() + 21600000);     // Catch: JSONException -> L7
        r9.source = r8;     // Catch: JSONException -> L7
        return r9;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static RegionBean buildFromLocal(String r5) {
        RegionBean r0 = new RegionBean();
        r0.source = 2;
        r0.code = r5;
        r0.expireTime = System.currentTimeMillis() + 21600000;
        return r0;
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(this.errorCode) == true) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(this.code) == false) goto L9;
        return false;
    L9:
        if (this.expireTime > 0) goto L11;
        return false;
    L11:
        if (System.currentTimeMillis() > this.expireTime) goto L15;
        return true;
    L15:
        return false;
    }

    public String parseToJsonString() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put(KEY_CODE, this.code);     // Catch: JSONException -> L4
        r0.put(KEY_GEO_NAME, this.geoNameID);     // Catch: JSONException -> L4
        r0.put(KEY_ASCINAME, this.asciName);     // Catch: JSONException -> L4
        r0.put(KEY_NAME, this.name);     // Catch: JSONException -> L4
        r0.put(KEY_EXPIRE_TIME, this.expireTime);     // Catch: JSONException -> L4
        r0.put(KEY_SOURCE, this.source);     // Catch: JSONException -> L4
        return r0.toString();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String toString() {
        return "RegionBean{code='" + this.code + "', geoNameID=" + this.geoNameID + ", asciName='" + this.asciName + "', name='" + this.name + "', source=" + this.source + ", expireTime=" + this.expireTime + '}';
    }
}
