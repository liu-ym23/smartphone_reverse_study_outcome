package com.bytedance.sync.v2.presistence.b;

import androidx.room.TypeConverter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    @TypeConverter
    public static String a(Map<String, String> r2) {
        if (r2 != null) goto L8;
        return "";
    L8:
        return new JSONObject(r2).toString();
    L7:
        return "";
    }

    @TypeConverter
    public static Map<String, String> b(String r4) {
        HashMap r0 = new HashMap();
        JSONObject r1 = new JSONObject(r4);     // Catch: Exception -> L9
        Iterator<String> r5 = r1.keys();     // Catch: Exception -> L9
    L5:
        if (r5.hasNext() == false) goto L8;
        String r2 = r5.next();     // Catch: Exception -> L9
        r0.put(r2, r1.optString(r2));     // Catch: Exception -> L9
    L8:
        return r0;
    }
}
