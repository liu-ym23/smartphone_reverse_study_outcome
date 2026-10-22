package com.loc;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 extends o1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f7561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f7562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f7564e;

    public n1(Context r1, int r2, String r3, o1 r4) {
        super(r4);
        this.f7561b = r2;
        this.f7563d = r3;
        this.f7564e = r1;
    }

    @Override // com.loc.o1
    public final void b(boolean r3) {
        super.b(r3);
        if (r3 == false) goto L6;
        String r4 = this.f7563d;
        long r0 = System.currentTimeMillis();
        this.f7562c = r0;
        t.e(this.f7564e, r4, String.valueOf(r0));
        return;
    }

    @Override // com.loc.o1
    protected final boolean c() {
        long r2 = 0;
        if (this.f7562c != 0) goto L10;
        String r0 = t.b(this.f7564e, this.f7563d);
        if (TextUtils.isEmpty(r0) == true) goto L8;
        r2 = Long.parseLong(r0);
    L8:
        this.f7562c = r2;
    L10:
        if ((System.currentTimeMillis() - this.f7562c) >= this.f7561b) goto L13;
        return false;
    L13:
        return true;
    }
}
