package com.bytedance.common.wschannel.client;

import androidx.annotation.NonNull;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    protected final c.a f3500a;

    public b(@NonNull c.a r1) {
        this.f3500a = r1;
    }

    @NonNull
    protected com.bytedance.common.wschannel.r.c b(int r4, int r5, boolean r6) {
        com.bytedance.common.wschannel.r.c r0 = com.bytedance.common.wschannel.r.c.f3663g;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L9;
        r0 = com.bytedance.common.wschannel.r.c.f3664h;
        goto L18
    L9:
        if (r5 != 2) goto L12;
        r0 = com.bytedance.common.wschannel.r.c.f3665i;
        goto L18
    L12:
        if (r5 != 3) goto L15;
        r0 = com.bytedance.common.wschannel.r.c.f3666j;
        goto L18
    L15:
        if (r5 != 4) goto L18;
        r0 = com.bytedance.common.wschannel.r.c.f3667k;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("AbsWsClientService", "state = " + r5 + " connectionState = " + r0);
    L20:
        this.f3500a.e(r4, r0, r6);
        return r0;
    }
}
