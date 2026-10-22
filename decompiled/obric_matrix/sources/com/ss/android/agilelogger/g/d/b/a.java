package com.ss.android.agilelogger.g.d.b;

import com.ss.android.agilelogger.g.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {
    public a() {
    }

    @Override // com.ss.android.agilelogger.g.b
    public /* bridge */ /* synthetic */ String a(Object r1) {
        return b((String) r1);
    }

    public String b(String r4) {
        if (r4 == null) goto L18;
        if (r4.trim().length() == 0) goto L18;
    L14:
        e = move-exception;
        throw new com.ss.android.agilelogger.g.a("Parse JSON error. JSON string:" + r4, e);
    L6:
        if (r4.startsWith("{") == false) goto L9;
        return new JSONObject(r4).toString(4);
    L9:
        if (r4.startsWith("[") == false) goto L13;
        return new JSONArray(r4).toString(4);
    L13:
        throw new com.ss.android.agilelogger.g.a("JSON should start with { or [, but found " + r4);     // Catch: Exception -> L14
    L18:
        throw new com.ss.android.agilelogger.g.a("JSON empty.");
    }
}
