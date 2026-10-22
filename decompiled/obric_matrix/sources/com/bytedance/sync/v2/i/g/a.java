package com.bytedance.sync.v2.i.g;

import com.bytedance.sync.v2.f.k;
import com.bytedance.sync.v2.i.d;
import com.bytedance.sync.v2.j.b;
import com.bytedance.sync.v2.j.f;
import com.bytedance.sync.v2.j.i;
import java.util.List;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a implements d<i> {
    public a() {
    }

    @Override // com.bytedance.sync.v2.i.d
    public /* bridge */ /* synthetic */ boolean a(i r1) {
        return c(r1);
    }

    @Override // com.bytedance.sync.v2.i.d
    public void b(b r1, List<f> r2) {
        o.g(r1, "header");
        o.g(r2, "topics");
        d.b.u.x.b.e("received http poll cmd, do http poll");
        ((k) com.ss.android.ug.bus.b.a(k.class)).G(true);
    }

    public boolean c(i r1) {
        o.g(r1, "obj");
        if (r1 != i.f6102h) goto L5;
        return true;
    L5:
        return false;
    }
}
