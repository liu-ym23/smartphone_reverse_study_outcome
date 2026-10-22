package com.bytedance.apm.impl;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import d.b.r.k0.j;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Map<String, String> f1601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1602c;

    public b(String r1, @Nullable String r2, @Nullable Map<String, String> r3) {
        this.f1600a = r1;
        this.f1601b = r3;
        if (TextUtils.isEmpty(r2) == false) goto L7;
        JSONObject r4 = new JSONObject();
        r4.put("defaultData", "none commonParams");     // Catch: JSONException -> L9
    L6:
        this.f1602c = r4.toString();
        return;
    L7:
        this.f1602c = r2;
    }

    private String d(String r4, Map<String, String> r5) {
        StringBuilder r3 = new StringBuilder(r4);
        r3.append("\"");
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, String> r0 = r6.next();
        String r1 = r0.getKey();
        String r2 = r0.getValue();
        r3.append("; ");
        r3.append(r1);
        r3.append("=\"");
        r3.append(r2);
        r3.append("\"");
        goto L4
    L6:
        r3.deleteCharAt(r3.length() - 1);
        return r3.toString();
    }

    @Override // d.b.r.k0.j
    public String a() {
        return "text/plain";
    }

    @Override // d.b.r.k0.j
    public void b(OutputStream r1) {
        r1.write(this.f1602c.getBytes());
    }

    @Override // d.b.r.k0.j
    public String c() {
        return d(this.f1600a, this.f1601b);
    }

    @Override // d.b.r.k0.j
    public String e() {
        return null;
    }

    @Override // d.b.r.k0.j
    public long length() {
        return this.f1602c.getBytes().length;
    }
}
