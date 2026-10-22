package com.ss.android.i.n.a;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f11917b;

    public c() {
    }

    public static c d() {
        return new c();
    }

    public c a(String r2, Object r3) {
        if (this.f11917b != null) goto L8;
        this.f11917b = new Bundle();
    L8:
        this.f11917b.putString(r2, r3.toString());     // Catch: Exception -> L7
    L6:
        return this;
    }

    public c b(String r2) {
        this.f11916a = r2;
        a("params_for_special", "uc_login");
        return this;
    }

    public void c() {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L12
        Bundle r1 = this.f11917b;     // Catch: Exception -> L12
        if (r1 == null) goto L10;
        Iterator<String> r2 = r1.keySet().iterator();     // Catch: Exception -> L12
    L6:
        if (r2.hasNext() == false) goto L10;
        String r3 = r2.next();     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r0.put(r3, this.f11917b.get(r3));     // Catch: Exception -> L12
    L10:
        a.a(this.f11916a, r0);     // Catch: Exception -> L12
        return;
    }
}
