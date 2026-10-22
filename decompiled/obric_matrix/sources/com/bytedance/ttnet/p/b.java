package com.bytedance.ttnet.p;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import d.b.r.y;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends i.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f6498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, Integer> f6499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<String> f6500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6501h;

    public b() {
        this.f6498e = new f();
        this.f6499f = new ConcurrentHashMap();
        this.f6500g = new CopyOnWriteArraySet();
        this.f6501h = 1000;
    }

    private int i(d.b.r.h0.c r3) {
        this.f6498e.c(r3);
        if (this.f6499f.isEmpty() == true) goto L9;
        Integer r2 = i.g(this.f6499f, r3.A());
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.intValue();
    L9:
        if (this.f6500g.isEmpty() == false) goto L11;
        return -1;
    L11:
        if (i.i(this.f6500g, r3.A()) == false) goto L13;
        return 0;
    L13:
        return this.f6501h;
    }

    @Override // d.b.r.l0.b
    public void a(d.b.r.h0.c r9, y r10) {
        long r5 = i(r9);
        Logger.debug();
        this.f6557a.h(r9, false, true, r5, r10);
    }

    @Override // d.b.r.l0.b
    public boolean b(d.b.r.h0.c r10, y r11, Executor r12, Runnable r13) {
        long r4 = i(r10);
        Logger.debug();
        return this.f6557a.g(r10, false, r4, r13, r12, r11);
    }

    @Override // com.bytedance.ttnet.p.i.a
    public boolean e(JSONObject r6) {
        super.e(r6);
        if (r6.isNull("bl_with_delay_ms") == true) goto L5;
    L7:
        this.f6498e.a(r6);
        this.f6557a.d(r6, this.f6558b);
        JSONObject r0 = r6.optJSONObject("bl_with_delay_ms");
        if (r0 == null) goto L13;
        Iterator<String> r7 = r0.keys();
    L11:
        if (r7.hasNext() == false) goto L24;
        String r1 = r7.next();
        this.f6499f.put(r1, Integer.valueOf(r0.optInt(r1)));
    L24:
        if (this.f6498e.b() == false) goto L26;
    L29:
        return true;
    L26:
        if (this.f6499f.isEmpty() == false) goto L29;
        if (this.f6500g.isEmpty() == false) goto L29;
        return false;
    L13:
        JSONArray r2 = r6.optJSONArray("wl");
        if (r2 == null) goto L22;
        int r3 = 0;
    L17:
        if (r3 >= r2.length()) goto L22;
        String r4 = r2.optString(r3);
        if (TextUtils.isEmpty(r4) == true) goto L21;
        this.f6500g.add(r4);
    L21:
        r3 = r3 + 1;
    L22:
        this.f6501h = r6.optInt("delay_time_ms", 1000);
        goto L24
    L5:
        if (r6.isNull("wl") == false) goto L7;
        return false;
    }

    @Override // com.bytedance.ttnet.p.i.a
    public void g() {
        super.g();
        this.f6557a.f();
    }

    @Override // com.bytedance.ttnet.p.i.a
    i.b h() {
        return i.b.f6562h;
    }
}
