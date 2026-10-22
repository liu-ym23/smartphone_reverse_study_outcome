package com.bytedance.sync.v2;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sync.v2.f.f;
import com.bytedance.sync.v2.f.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b implements f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<j> f5868f;

    public b() {
        this.f5868f = new ArrayList();
    }

    @Override // com.bytedance.sync.v2.f.f
    public void H(WsChannelMsg r2) {
        Iterator<T> r1 = this.f5868f.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        j r0 = (j) r1.next();
        if (r0 == null) goto L4;
        r0.F(r2);
        goto L4
    }

    @Override // com.bytedance.sync.v2.f.f
    public void h0(j r1) {
        if (r1 == null) goto L5;
        this.f5868f.add(r1);
        return;
    }
}
