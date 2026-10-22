package com.ss.android.k;

import d.b.h.a.a.g.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends b {
    public static boolean n(JSONObject r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if ("success".equals(r1.optString("message")) == false) goto L6;
        return true;
    }
}
