package com.bytedance.ttnet.j;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f6362a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f6363b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f6364c;

    public interface a {
        String a(String r1, String[] r2);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f6366b;

        public b(String r1, JSONObject r2) {
            this.f6365a = r1;
            this.f6366b = r2;
        }

        public boolean a() {
            if (TextUtils.isEmpty(this.f6365a) == false) goto L10;
            JSONObject r1 = this.f6366b;
            if (r1 != null) goto L7;
        L9:
            return false;
        L7:
            if (r1.length() <= 0) goto L9;
        L10:
            return true;
        }

        public JSONObject b() {
            if (this.f6366b != null) goto L6;
            this.f6366b = new JSONObject(this.f6365a);
        L6:
            return this.f6366b;
        }

        public String c() {
            if (TextUtils.isEmpty(this.f6365a) == false) goto L6;
            this.f6365a = this.f6366b.toString();
        L6:
            return this.f6365a;
        }
    }

    static {
    }

    public static boolean a() {
        return f6362a;
    }

    public static boolean b() {
        return f6363b;
    }

    public static boolean c(Object r3) {
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
        if ((r3 instanceof b) == true) goto L19;
        return false;
    L19:
        return ((b) r3).a();
    }

    public static JSONObject d(Object r1) {
        if ((r1 instanceof String) == false) goto L7;
        return new JSONObject((String) r1);
    L7:
        if ((r1 instanceof JSONObject) == false) goto L11;
        return (JSONObject) r1;
    L11:
        if ((r1 instanceof b) == true) goto L13;
        return null;
    L13:
        return ((b) r1).b();
    }

    public static String e(Object r3, JSONObject r4, String[] r5) {
        if (r5 != null) goto L5;
    L7:
        String r1 = null;
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L12;
        return null;
    L12:
        if (f6364c == null) goto L18;
        if ((r3 instanceof b) == false) goto L18;
        return f6364c.a(((b) r3).c(), r5);
    L18:
        return r4.optString(r1);
    L5:
        if (r5.length <= 0) goto L7;
        r1 = r5[r5.length - 1];
        goto L9
    }

    public static JSONObject f(Object r1) {
        if ((r1 instanceof JSONObject) == false) goto L7;
        return (JSONObject) r1;
    L7:
        if ((r1 instanceof b) == false) goto L11;
        return ((b) r1).b().optJSONObject("data");
    L11:
        return new JSONObject();
    }
}
