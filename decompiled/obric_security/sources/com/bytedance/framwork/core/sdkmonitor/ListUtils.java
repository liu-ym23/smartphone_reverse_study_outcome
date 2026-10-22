package com.bytedance.framwork.core.sdkmonitor;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ListUtils {
    public ListUtils() {
    }

    public static boolean isEmpty(List<?> r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.size() == 0) goto L7;
        return false;
    }

    public static String[] toArray(Set<String> r4) {
        String[] r0 = new String[r4.size()];
        Iterator<String> r5 = r4.iterator();
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0[r1] = r5.next();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static List<String> parseList(JSONObject r4, String r5) {
        JSONArray r6 = r4.optJSONArray(r5);     // Catch: Exception -> L15
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.length() <= 0) goto L21;
        int r7 = r6.length();     // Catch: Exception -> L15
        ArrayList r0 = new ArrayList(r7);     // Catch: Exception -> L15
        int r1 = 0;
    L7:
        if (r1 >= r7) goto L12;
        String r2 = r6.getString(r1);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r2) == true) goto L11;
        r0.add(r2);     // Catch: Exception -> L15
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        return r0;
    L21:
        return null;
    L22:
        return null;
    }

    public static List<Pattern> parsePatterns(JSONObject r4, String r5) {
        JSONArray r6 = r4.optJSONArray(r5);     // Catch: Exception -> L15
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.length() <= 0) goto L21;
        int r7 = r6.length();     // Catch: Exception -> L15
        ArrayList r0 = new ArrayList(r7);     // Catch: Exception -> L15
        int r1 = 0;
    L7:
        if (r1 >= r7) goto L12;
        String r2 = r6.getString(r1);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r2) == true) goto L11;
        r0.add(Pattern.compile(r2));     // Catch: Exception -> L15
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        return r0;
    L21:
        return null;
    L22:
        return null;
    }
}
