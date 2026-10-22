package com.bytedance.bdlocation.utils.json;

import android.location.Location;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.deserializer.BDLocationDeserializer;
import com.bytedance.bdlocation.utils.json.deserializer.LocationDeserializer;
import com.bytedance.bdlocation.utils.json.serializer.BDLocationSerializer;
import com.bytedance.bdlocation.utils.json.serializer.LocationSerializer;
import com.google.gson.Gson;
import com.google.gson.e;
import com.google.gson.j;
import java.lang.reflect.Type;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JsonUtil {
    public static Gson sGson;

    static {
        e r0 = new e();
        r0.a(new SuperclassExclusionStrategy());
        r0.b(new SuperclassExclusionStrategy());
        r0.g(Location.class, new LocationSerializer());
        r0.g(Location.class, new LocationDeserializer());
        r0.g(BDLocation.class, new BDLocationSerializer());
        r0.g(BDLocation.class, new BDLocationDeserializer());
        sGson = r0.d();
    }

    private JsonUtil() {
    }

    public static int safeOptInt(JSONObject r1, String r2, int r3) {
        if (r1 != null) goto L4;
        return r3;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        return r1.optInt(r2);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r3;
    L14:
        return r3;
    }

    public static long safeOptLong(JSONObject r1, String r2, long r3) {
        if (r1 != null) goto L4;
        return r3;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        return r1.optLong(r2, r3);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r3;
    L14:
        return r3;
    }

    public static String safeOptString(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L4;
        return r3;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        return r1.optString(r2);
    L8:
        th = move-exception;
        th.printStackTrace();
        return r3;
    L14:
        return r3;
    }

    public static void safePutBoolean(JSONObject r1, String r2, boolean r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.put(r2, r3);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutDouble(JSONObject r1, String r2, double r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.put(r2, r3);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutInt(JSONObject r1, String r2, int r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.put(r2, r3);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutLong(JSONObject r1, String r2, long r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.put(r2, r3);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void safePutString(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        r1.put(r2, r3);     // Catch: JSONException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static j safeToJsonTree(Object r3) {
        Logger.d("BDLocation", "Util#safeToJsonTree begin executing");
        return sGson.B(r3);
    L5:
        th = move-exception;
        Logger.d("BDLocation", "Util#safeToJsonTree occurs exception that " + th.getMessage());
        th.printStackTrace();
        return null;
    }

    public static j toJsonTreeSafely(Object r1) {
        return new Gson().B(r1);
    L4:
        return null;
    }

    public static j toJsonTreeSafely(Object r1, Type r2) {
        return new Gson().C(r1, r2);
    L4:
        return null;
    }
}
