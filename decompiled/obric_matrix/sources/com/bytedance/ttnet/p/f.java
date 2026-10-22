package com.bytedance.ttnet.p;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f6538a;

    public f() {
        this.f6538a = new CopyOnWriteArraySet();
    }

    public void a(JSONObject r4) {
        this.f6538a.clear();
        JSONArray r5 = r4.optJSONArray("dl");
        if (r5 == null) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= r5.length()) goto L15;
        String r1 = r5.optString(r0);
        if (TextUtils.isEmpty(r1) == true) goto L10;
        this.f6538a.add(r1);
    L10:
        r0 = r0 + 1;
        goto L6
    L15:
        return;
    }

    public boolean b() {
        if (this.f6538a.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void c(d.b.r.h0.c r1) {
        if (i.i(this.f6538a, r1.A()) == true) goto L5;
        return;
    L5:
        Logger.debug();
        throw new d.b.h.a.a.h.l.c();
    }
}
