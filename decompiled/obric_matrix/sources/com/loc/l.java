package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7479b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f7480c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f7481d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f7482e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f7483f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f7484g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7485a;

    final class a implements l5.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private l f7486a;

        a() {
            this.f7486a = new l();
        }

        @Override // com.loc.l5.c
        public final String a() {
            return l.e();
        }

        @Override // com.loc.l5.c
        public final String a(String r1, String r2, String r3, String r4) {
            return this.f7486a.c(r1, r2, r3, r4);
        }

        @Override // com.loc.l5.c
        public final String b(Context r1, String r2) {
            return l.b(r1, r2);
        }

        @Override // com.loc.l5.c
        public final Map<String, String> b() {
            return this.f7486a.d();
        }

        @Override // com.loc.l5.c
        public final t0 c(byte[] r1, Map<String, String> r2) {
            return new n0(r1, r2);
        }
    }

    static {
        f7479b = u5.u("SRFZHZUVZT3BOa0ZiemZRQQ");
        f7480c = u5.u("FbGJzX3Nkaw");
        f7481d = u5.u("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
        f7482e = u5.u("FQU5EU0RLMTA");
        f7483f = u5.u("FMTAw");
        f7484g = false;
    }

    public l() {
        this.f7485a = "";
    }

    public static l5.c a() {
        return new a();
    }

    public static String b(Context r2, String r3) {
        JSONObject r0 = new JSONObject(r3);     // Catch: JSONException -> L8
        if (r0.optInt(u5.u("UY29kZQ")) != 1) goto L14;
        String r4 = new JSONObject(r0.optString(u5.u("FZGF0YQ"))).optString(u5.u("FYWRpdQ"));     // Catch: JSONException -> L8
        if (TextUtils.isEmpty(r4) == true) goto L15;
        m.b(r4);     // Catch: JSONException -> L8
        h.a(r2).c(r4);     // Catch: JSONException -> L8
        return r4;
    L15:
        return "";
    L14:
        return "";
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String e() {
        return m.a();
    }

    private String f() {
        if (TextUtils.isEmpty(this.f7485a) == false) goto L5;
        String r0 = m5.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer r1 = new StringBuffer();
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r3 >= r0.length()) goto L10;
        r1.append((char) (r0.charAt(r3) - (r3 % 48)));
        r3 = r3 + 1;
        goto L8
    L10:
        String r4 = r1.toString();
        StringBuffer r5 = new StringBuffer();
    L12:
        if (r2 >= (r4.length() / 2)) goto L14;
        r5.append((char) ((r4.charAt(r2) + r4.charAt((r4.length() - 1) - r2)) / 2));
        r2 = r2 + 1;
        goto L12
    L14:
        String r6 = r5.toString();
        this.f7485a = r6;
        return r6;
    L5:
        return this.f7485a;
    }

    public final String c(String r3, String r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();
        r0.put(u5.u("LdGlk"), r3);     // Catch: Throwable -> L5
        r0.put(u5.u("FZGl1"), r4);     // Catch: Throwable -> L5
        r0.put(u5.u("AZGl1Mg"), r5);     // Catch: Throwable -> L5
        r0.put(u5.u("EZGl1Mw"), r6);     // Catch: Throwable -> L5
    L7:
        String r7 = r0.toString();
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return null;
    L10:
        String r8 = o.b();
        if (TextUtils.isEmpty(r8) == true) goto L18;
        String r9 = j.a(k0.a((r7 + "\u0000").getBytes(), r8.getBytes()));
        if (TextUtils.isEmpty(r9) == true) goto L18;
        return u5.u("Fa2V5PQ") + URLEncoder.encode(j.a(n.b(r8.getBytes("utf-8"), n.a(f())))) + u5.u("SJmRhdGE9") + URLEncoder.encode(r9);
    L16:
        th = move-exception;
        th.printStackTrace();
    L18:
        return null;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public final synchronized Map<String, String> d() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (f7484g == false) goto L9;
        monitor-exit(this);
        return null;
    L9:
        f7484g = true;     // Catch: Throwable -> L12
        HashMap r0 = new HashMap();     // Catch: Throwable -> L12
        r0.put(u5.u("FZW50"), u5.u("FMg"));     // Catch: Throwable -> L12
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L12
        r1.append(u5.u("SY2hhbm5lbD0"));     // Catch: Throwable -> L12
        String r2 = f7480c;     // Catch: Throwable -> L12
        r1.append(r2);     // Catch: Throwable -> L12
        r1.append(u5.u("SJmRpdj0"));     // Catch: Throwable -> L12
        String r3 = f7482e;     // Catch: Throwable -> L12
        r1.append(r3);     // Catch: Throwable -> L12
        StringBuffer r4 = new StringBuffer();     // Catch: Throwable -> L12
        r4.append(r2);     // Catch: Throwable -> L12
        r4.append(r3);     // Catch: Throwable -> L12
        r4.append(u5.u("FQA"));     // Catch: Throwable -> L12
        r4.append(f7481d);     // Catch: Throwable -> L12
        String r5 = o.d(r4.toString());     // Catch: Throwable -> L12
        r1.append(u5.u("FJnNpZ249"));     // Catch: Throwable -> L12
        r1.append(r5.toUpperCase(Locale.US));     // Catch: Throwable -> L12
        r1.append(u5.u("SJm91dHB1dD1qc29u") + "\u0000");     // Catch: Throwable -> L12
        r0.put(u5.u("FaW4"), j.a(k0.a(r1.toString().getBytes(), f7479b.getBytes())));     // Catch: Throwable -> L12
        r0.put(u5.u("Sa2V5dA"), f7483f);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r0;
    }
}
