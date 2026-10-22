package l.b.c.b;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;

/* JADX INFO: loaded from: classes2.dex */
class b extends OutputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Signature f21868f;

    b(Signature r1) {
        this.f21868f = r1;
    }

    @Override // java.io.OutputStream
    public void write(int r1) {
        this.f21868f.update((byte) r1);     // Catch: SignatureException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1) {
        this.f21868f.update(r1);     // Catch: SignatureException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1, int r2, int r3) {
        this.f21868f.update(r1, r2, r3);     // Catch: SignatureException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.getMessage());
    }
}
