package l.b.a;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
class y1 implements Enumeration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k f21816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f21817b;

    public y1(byte[] r3) {
        this.f21816a = new k(r3, true);
        this.f21817b = a();
    }

    private Object a() {
        return this.f21816a.C();
    L4:
        e = move-exception;
        throw new s("malformed DER construction: " + e, e);
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        if (this.f21817b == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        Object r0 = this.f21817b;
        if (r0 == null) goto L7;
        this.f21817b = a();
        return r0;
    L7:
        throw new NoSuchElementException();
    }
}
