package w;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileInputStream f22667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Charset f22668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f22669c;
    public int d;
    public int e;

    public d(FileInputStream r5, Charset r10) {
        if (r10 == null) goto L11;
        if (r10.equals(e.f22670a) == false) goto L9;
        this.f22667a = r5;
        this.f22668b = r10;
        this.f22669c = new byte[8192];
        return;
    L9:
        throw new IllegalArgumentException("Unsupported encoding");
    L11:
        throw null;
    }

    public final String b() {
        FileInputStream r5 = this.f22667a;
        monitor-enter(r5);
        byte[] r10 = this.f22669c;     // Catch: Throwable -> L23
        if (r10 == null) goto L48;
        if (this.d < this.e) goto L13;
        int r11 = this.f22667a.read(r10, 0, r10.length);     // Catch: Throwable -> L23
        if (r11 == (-1)) goto L12;
        this.d = 0;     // Catch: Throwable -> L23
        this.e = r11;     // Catch: Throwable -> L23
        goto L13
    L12:
        throw new EOFException();     // Catch: Throwable -> L23
    L13:
        int r12 = this.d;     // Catch: Throwable -> L23
    L15:
        if (r12 == this.e) goto L30;
        byte[] r13 = this.f22669c;     // Catch: Throwable -> L23
        if (r13[r12] == 10) goto L18;
        r12 = r12 + 1;     // Catch: Throwable -> L23
        goto L15
    L18:
        int r14 = this.d;     // Catch: Throwable -> L23
        if (r12 == r14) goto L25;
        int r15 = r12 - 1;     // Catch: Throwable -> L23
        if (r13[r15] != 13) goto L25;
    L26:
        String r16 = new String(r13, r14, r15 - r14, this.f22668b.name());     // Catch: Throwable -> L23
        this.d = r12 + 1;     // Catch: Throwable -> L23
        monitor-exit(r5);     // Catch: Throwable -> L23
        return r16;
    L25:
        r15 = r12;
        goto L26
    L30:
        com.bytedance.forest.model.d r17 = new com.bytedance.forest.model.d(this, (this.e - this.d) + 80);     // Catch: Throwable -> L23
    L31:
        byte[] r18 = this.f22669c;     // Catch: Throwable -> L23
        int r19 = this.d;     // Catch: Throwable -> L23
        r17.write(r18, r19, this.e - r19);     // Catch: Throwable -> L23
        this.e = -1;     // Catch: Throwable -> L23
        byte[] r20 = this.f22669c;     // Catch: Throwable -> L23
        int r21 = this.f22667a.read(r20, 0, r20.length);     // Catch: Throwable -> L23
        if (r21 == (-1)) goto L46;
        this.d = 0;     // Catch: Throwable -> L23
        this.e = r21;     // Catch: Throwable -> L23
        int r22 = 0;
    L35:
        if (r22 == this.e) goto L31;
        byte[] r23 = this.f22669c;     // Catch: Throwable -> L23
        if (r23[r22] == 10) goto L38;
        r22 = r22 + 1;     // Catch: Throwable -> L23
        goto L35
    L38:
        int r24 = this.d;     // Catch: Throwable -> L23
        if (r22 == r24) goto L41;
        r17.write(r23, r24, r22 - r24);     // Catch: Throwable -> L23
    L41:
        this.d = r22 + 1;     // Catch: Throwable -> L23
        String r25 = r17.toString();     // Catch: Throwable -> L23
        monitor-exit(r5);     // Catch: Throwable -> L23
        return r25;
    L46:
        throw new EOFException();     // Catch: Throwable -> L23
    L48:
        throw new IOException("LineReader is closed");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        FileInputStream r5 = this.f22667a;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f22669c == null) goto L9;
        this.f22669c = null;     // Catch: Throwable -> L7
        this.f22667a.close();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r5);     // Catch: Throwable -> L7
    }
}
