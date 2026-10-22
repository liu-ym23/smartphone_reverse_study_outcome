package kotlin.s0.w.d.l0.i;

import java.io.IOException;
import java.io.InputStream;
import kotlin.s0.w.d.l0.i.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<MessageType extends q> implements s<MessageType> {
    static {
        g.c();
    }

    public b() {
    }

    private MessageType e(MessageType r2) {
        if (r2 != null) goto L4;
    L8:
        return r2;
    L4:
        if (r2.isInitialized() == true) goto L8;
        k r1 = f(r2).a();
        r1.i(r2);
        throw r1;
    }

    private w f(MessageType r1) {
        if ((r1 instanceof a) == false) goto L7;
        return ((a) r1).b();
    L7:
        return new w(r1);
    }

    @Override // kotlin.s0.w.d.l0.i.s
    public /* bridge */ /* synthetic */ Object a(InputStream r1, g r2) {
        return h(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.i.s
    public /* bridge */ /* synthetic */ Object c(InputStream r1, g r2) {
        return g(r1, r2);
    }

    @Override // kotlin.s0.w.d.l0.i.s
    public /* bridge */ /* synthetic */ Object d(d r1, g r2) {
        return i(r1, r2);
    }

    public MessageType g(InputStream r1, g r2) {
        MessageType r3 = (MessageType) j(r1, r2);
        e(r3);
        return r3;
    }

    public MessageType h(InputStream r1, g r2) {
        MessageType r3 = (MessageType) k(r1, r2);
        e(r3);
        return r3;
    }

    public MessageType i(d r1, g r2) {
        MessageType r3 = (MessageType) l(r1, r2);
        e(r3);
        return r3;
    }

    public MessageType j(InputStream r3, g r4) {
        int r0 = r3.read();     // Catch: IOException -> L9
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        return (MessageType) k(new a.AbstractC0550a.C0551a(r3, e.B(r0, r3)), r4);
    L9:
        e = move-exception;
        throw new k(e.getMessage());
    }

    public MessageType k(InputStream r1, g r2) {
        e r3 = e.g(r1);
        MessageType r0 = b(r3, r2);
        r3.a(0);     // Catch: k -> L5
        return r0;
    L5:
        e = move-exception;
        e.i(r0);
        throw e;
    }

    public MessageType l(d r1, g r2) {
        e r3 = r1.s();     // Catch: k -> L9
        MessageType r0 = b(r3, r2);     // Catch: k -> L9
        r3.a(0);     // Catch: k -> L6
        return r0;
    L6:
        e = move-exception;
        e.i(r0);     // Catch: k -> L9
        throw e;     // Catch: k -> L9
    L9:
        e = move-exception;
        throw e;
    }
}
