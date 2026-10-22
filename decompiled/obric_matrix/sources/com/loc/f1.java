package com.loc;

/* JADX INFO: loaded from: classes2.dex */
public final class f1 extends i1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StringBuilder f7284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7285d;

    public f1(i1 r1) {
        super(r1);
        this.f7284c = new StringBuilder();
        this.f7285d = true;
    }

    @Override // com.loc.i1
    protected final byte[] b(byte[] r3) {
        byte[] r4 = u5.o(this.f7284c.toString());
        this.f7372b = r4;
        this.f7285d = true;
        StringBuilder r2 = this.f7284c;
        r2.delete(0, r2.length());
        return r4;
    }

    @Override // com.loc.i1
    public final void c(byte[] r3) {
        String r4 = u5.g(r3);
        if (this.f7285d == false) goto L5;
        this.f7285d = false;
    L6:
        StringBuilder r2 = this.f7284c;
        r2.append("{\"log\":\"");
        r2.append(r4);
        r2.append("\"}");
        return;
    L5:
        this.f7284c.append(",");
        goto L6
    }
}
