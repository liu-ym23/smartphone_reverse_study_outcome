package com.loc;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 extends o1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7591c;

    public p1(Context r2) {
        this.f7591c = false;
        this.f7590b = r2;
        this.f7591c = false;
    }

    @Override // com.loc.o1
    protected final boolean c() {
        if (l5.M(this.f7590b) != 1) goto L5;
    L9:
        return true;
    L5:
        if (this.f7591c == true) goto L9;
        return false;
    }
}
