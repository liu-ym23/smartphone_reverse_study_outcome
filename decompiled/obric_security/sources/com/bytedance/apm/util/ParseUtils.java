package com.bytedance.apm.util;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ParseUtils {
    public ParseUtils() {
    }

    public static boolean isHostEquals(String r2, List<String> r3) {
        if (com.bytedance.apm6.util.ListUtils.isEmpty(r3) == false) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L14;
        String r4 = Uri.parse(r2).getHost();     // Catch: Throwable -> L15
        Iterator<String> r5 = r3.iterator();     // Catch: Throwable -> L15
    L9:
        if (r5.hasNext() == false) goto L14;
        if (r4.equalsIgnoreCase(r5.next()) == false) goto L9;
        return true;
    }

    public static boolean isMatch(String r3, List<String> r4, List<Pattern> r5) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        if (com.bytedance.apm6.util.ListUtils.isEmpty(r4) == true) goto L23;
        Iterator<String> r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L23;
        if (r3.contains(r6.next()) == false) goto L9;
        return true;
    L23:
        String r7 = new URI(r3).getPath();     // Catch: Throwable -> L22
        if (com.bytedance.apm6.util.ListUtils.isEmpty(r5) == true) goto L21;
        Iterator<Pattern> r8 = r5.iterator();     // Catch: Throwable -> L22
    L17:
        if (r8.hasNext() == false) goto L21;
        if (r8.next().matcher(r7).matches() == false) goto L17;
        return true;
    L21:
        return false;
    }

    public static JSONObject getJsonObject(JSONObject r1, String r2) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return r1.optJSONObject(r2);
    }

    public static List<String> parseList(JSONObject r5, String r6) {
        JSONArray r7 = r5.optJSONArray(r6);     // Catch: Exception -> L13
        if (com.bytedance.apm6.util.JsonUtils.isEmpty(r7) == false) goto L6;
        return null;
    L6:
        int r8 = r7.length();     // Catch: Exception -> L13
        ArrayList r1 = new ArrayList(r8);     // Catch: Exception -> L13
        int r2 = 0;
    L7:
        if (r2 >= r8) goto L12;
        String r3 = r7.getString(r2);     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r3) == true) goto L11;
        r1.add(r3);     // Catch: Exception -> L13
    L11:
        r2 = r2 + 1;
        goto L7
    L12:
        return r1;
    L13:
        return null;
    }

    public static List<String> parseMapList(JSONObject r5, String r6) {
        JSONObject r7 = r5.optJSONObject(r6);     // Catch: Exception -> L14
        if (com.bytedance.apm6.util.JsonUtils.isEmpty(r7) == false) goto L6;
        return null;
    L6:
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L14
        Iterator<String> r1 = r7.keys();     // Catch: Exception -> L14
    L8:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next();     // Catch: Exception -> L14
        if (r7.optInt(r2) != 1) goto L8;
        r8.add(r2);     // Catch: Exception -> L14
        goto L8
    L13:
        return r8;
    L14:
        return null;
    }

    public static List<String> parseListFromStr(JSONObject r1, String r2) {
        String r3 = r1.optString(r2, "");
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return Collections.EMPTY_LIST;
    L7:
        return Arrays.asList(r3.split(","));
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

    public static List<Pattern> parseMapPatterns(JSONObject r5, String r6) {
        JSONObject r7 = r5.optJSONObject(r6);     // Catch: Exception -> L14
        if (com.bytedance.apm6.util.JsonUtils.isEmpty(r7) == false) goto L6;
        return null;
    L6:
        ArrayList r8 = new ArrayList();     // Catch: Exception -> L14
        Iterator<String> r1 = r7.keys();     // Catch: Exception -> L14
    L8:
        if (r1.hasNext() == false) goto L13;
        String r2 = r1.next();     // Catch: Exception -> L14
        if (r7.optInt(r2) != 1) goto L8;
        r8.add(Pattern.compile(r2));     // Catch: Exception -> L14
        goto L8
    L13:
        return r8;
    L14:
        return null;
    }
}
