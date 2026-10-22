package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CipherSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lokio/CipherSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "cipher", "Ljavax/crypto/Cipher;", "(Lokio/BufferedSource;Ljavax/crypto/Cipher;)V", "blockSize", "", "buffer", "Lokio/Buffer;", "getCipher", "()Ljavax/crypto/Cipher;", "closed", "", "final", "close", "", "doFinal", "read", "", "sink", "byteCount", "refill", "timeout", "Lokio/Timeout;", "update", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CipherSource implements Source {
    private final int blockSize;
    private final Buffer buffer;
    private final Cipher cipher;
    private boolean closed;

    /* JADX INFO: renamed from: final, reason: not valid java name */
    private boolean f4final;
    private final BufferedSource source;

    public CipherSource(BufferedSource r2, Cipher r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "cipher");
        this.source = r2;
        this.cipher = r3;
        int r4 = r3.getBlockSize();
        this.blockSize = r4;
        this.buffer = new Buffer();
        if (r4 <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("Block cipher required " + r3).toString());
    L5:
        r1 = false;
        goto L6
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // okio.Source
    public long read(Buffer r6, long r7) throws IOException {
        Intrinsics.checkNotNullParameter(r6, "sink");
        if (r7 < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L16;
        if ((true ^ this.closed) == false) goto L14;
        if (r7 != 0) goto L11;
        return 0;
    L11:
        refill();
        return this.buffer.read(r6, r7);
    L14:
        throw new IllegalStateException("closed".toString());
    L16:
        throw new IllegalArgumentException(("byteCount < 0: " + r7).toString());
    L5:
        r4 = false;
        goto L6
    }

    private final void refill() {
    L3:
        if (this.buffer.size() != 0) goto L14;
        if (this.f4final == true) goto L15;
        if (this.source.exhausted() == true) goto L8;
        update();
        goto L3
    L8:
        this.f4final = true;
        doFinal();
        return;
    L15:
        return;
    }

    private final void update() {
        Segment r0 = this.source.getBuffer().head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.limit - r0.pos;
        int r2 = this.cipher.getOutputSize(r1);
    L4:
        if (r2 <= 8192) goto L10;
        int r3 = this.blockSize;
        if (r1 <= r3) goto L7;
        r1 = r1 - r3;
        r2 = this.cipher.getOutputSize(r1);
        goto L4
    L7:
        this.f4final = true;
        Buffer r4 = this.buffer;
        byte[] r9 = this.cipher.doFinal(this.source.readByteArray());
        Intrinsics.checkNotNullExpressionValue(r9, "cipher.doFinal(source.readByteArray())");
        r4.write(r9);
        return;
    L10:
        Segment r5 = this.buffer.writableSegment$okio(r2);
        int r6 = this.cipher.update(r0.data, r0.pos, r1, r5.data, r5.pos);
        this.source.skip(r1);
        r5.limit += r6;
        Buffer r7 = this.buffer;
        r7.setSize$okio(r7.size() + ((long) r6));
        if (r5.pos != r5.limit) goto L16;
        this.buffer.head = r5.pop();
        SegmentPool.recycle(r5);
        return;
    }

    private final void doFinal() {
        int r0 = this.cipher.getOutputSize(0);
        if (r0 != 0) goto L5;
        return;
    L5:
        Segment r1 = this.buffer.writableSegment$okio(r0);
        int r2 = this.cipher.doFinal(r1.data, r1.pos);
        r1.limit += r2;
        Buffer r3 = this.buffer;
        r3.setSize$okio(r3.size() + ((long) r2));
        if (r1.pos != r1.limit) goto L9;
        this.buffer.head = r1.pop();
        SegmentPool.recycle(r1);
        return;
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }
}
