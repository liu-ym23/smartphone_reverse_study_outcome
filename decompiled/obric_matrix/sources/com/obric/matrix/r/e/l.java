package com.obric.matrix.r.e;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0005\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0018\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/common_utils/utils/StringUtils;", "", "()V", "TAG", "", "stringToMap", "", "input", "map", "", "toSafeJson", "Lorg/json/JSONObject;", "jsonStr", "toUrlEncodeStr", "date", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f9944a = null;

    static {
        f9944a = new l();
    }

    private l() {
    }

    public final Map<String, String> a(String r6, Map<String, String> r7) {
        if (r6 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L33;
        if (r7 == null) goto L48;
        JSONObject r2 = new JSONObject(r6);     // Catch: Exception -> L35
        Iterator<String> r8 = r2.keys();     // Catch: Exception -> L35
        kotlin.n0.d.o.e(r8, "json.keys()");     // Catch: Exception -> L35
    L14:
        if (r8.hasNext() == false) goto L32;
        String r3 = r8.next();     // Catch: Exception -> L35
        if (r3 == null) goto L31;
        String r4 = r3;     // Catch: Exception -> L35
        String r5 = r2.getString(r4);     // Catch: Exception -> L35
        if (r4.length() != 0) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == true) goto L14;
        kotlin.n0.d.o.e(r5, "value");     // Catch: Exception -> L35
        if (r5.length() != 0) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == true) goto L14;
        r7.put(r4, r5);     // Catch: Exception -> L35
        goto L14
    L26:
        r10 = false;
        goto L27
    L20:
        r9 = false;
        goto L21
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L35
    L32:
        return r7;
    L48:
        return null;
    L33:
        return null;
    L5:
        if (r6.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final JSONObject b(String r1) {
        return new JSONObject(r1);
    L4:
        return null;
    }

    public final String c(String r2) {
        kotlin.n0.d.o.f(r2, "date");
        String r1 = URLEncoder.encode(r2, "utf-8");     // Catch: Exception -> L5
        kotlin.n0.d.o.e(r1, "{\n            URLEncoder…(date, \"utf-8\")\n        }");     // Catch: Exception -> L5
        return r1;
    L5:
        e = move-exception;
        com.obric.matrix.r.c.c.g("StringUtils", "toUrlEncodeStr exception occurs", e);
        return "";
    }
}
