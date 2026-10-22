package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CipherSink.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0018H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lokio/CipherSink;", "Lokio/Sink;", "sink", "Lokio/BufferedSink;", "cipher", "Ljavax/crypto/Cipher;", "(Lokio/BufferedSink;Ljavax/crypto/Cipher;)V", "blockSize", "", "getCipher", "()Ljavax/crypto/Cipher;", "closed", "", "close", "", "doFinal", "", "flush", "timeout", "Lokio/Timeout;", "update", "source", "Lokio/Buffer;", "remaining", "", "write", "byteCount", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CipherSink implements Sink {
    private final int blockSize;
    private final Cipher cipher;
    private boolean closed;
    private final BufferedSink sink;

    public CipherSink(BufferedSink r2, Cipher r3) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        Intrinsics.checkNotNullParameter(r3, "cipher");
        this.sink = r2;
        this.cipher = r3;
        int r4 = r3.getBlockSize();
        this.blockSize = r4;
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

    @Override // okio.Sink
    public void write(Buffer r8, long r9) throws IOException {
        Intrinsics.checkNotNullParameter(r8, "source");
        _UtilKt.checkOffsetAndCount(r8.size(), 0, r9);
        if ((!this.closed) == false) goto L9;
    L5:
        if (r9 <= 0) goto L7;
        r9 = r9 - ((long) update(r8, r9));
        goto L5
    L7:
        return;
    L9:
        throw new IllegalStateException("closed".toString());
    }

    private final int update(Buffer r11, long r12) {
        Segment r0 = r11.head;
        Intrinsics.checkNotNull(r0);
        int r1 = (int) Math.min(r12, r0.limit - r0.pos);
        Buffer r2 = this.sink.getBuffer();
        int r3 = this.cipher.getOutputSize(r1);
    L4:
        if (r3 <= 8192) goto L10;
        int r4 = this.blockSize;
        if (r1 <= r4) goto L7;
        r1 = r1 - r4;
        r3 = this.cipher.getOutputSize(r1);
        goto L4
    L7:
        BufferedSink r5 = this.sink;
        byte[] r10 = this.cipher.update(r11.readByteArray(r12));
        Intrinsics.checkNotNullExpressionValue(r10, "cipher.update(source.readByteArray(remaining))");
        r5.write(r10);
        return (int) r12;
    L10:
        Segment r13 = r2.writableSegment$okio(r3);
        int r14 = this.cipher.update(r0.data, r0.pos, r1, r13.data, r13.limit);
        r13.limit += r14;
        r2.setSize$okio(r2.size() + ((long) r14));
        if (r13.pos != r13.limit) goto L13;
        r2.head = r13.pop();
        SegmentPool.recycle(r13);
    L13:
        this.sink.emitCompleteSegments();
        r11.setSize$okio(r11.size() - ((long) r1));
        r0.pos += r1;
        if (r0.pos != r0.limit) goto L16;
        r11.head = r0.pop();
        SegmentPool.recycle(r0);
    L16:
        return r1;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.sink.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == false) goto L5;
        return;
    L5:
        this.closed = true;
        Throwable r0 = doFinal();
        this.sink.close();     // Catch: Throwable -> L8
    L11:
        if (r0 != null) goto L13;
        return;
    L13:
        throw r0;
    L8:
        th = move-exception;
        if (r0 != null) goto L11;
        r0 = th;
        goto L11
    }

    private final Throwable doFinal() {
        int r0 = this.cipher.getOutputSize(0);
        Throwable r1 = null;
        if (r0 != 0) goto L6;
        return null;
    L6:
        if (r0 > 8192) goto L20;
        Buffer r2 = this.sink.getBuffer();
        Segment r3 = r2.writableSegment$okio(r0);
        int r7 = this.cipher.doFinal(r3.data, r3.limit);     // Catch: Throwable -> L14
        r3.limit += r7;     // Catch: Throwable -> L14
        r2.setSize$okio(r2.size() + ((long) r7));     // Catch: Throwable -> L14
    L17:
        if (r3.pos != r3.limit) goto L19;
        r2.head = r3.pop();
        SegmentPool.recycle(r3);
    L19:
        return r1;
    L14:
        th = move-exception;
        r1 = th;
        goto L17
    L20:
        BufferedSink r4 = this.sink;     // Catch: Throwable -> L9
        byte[] r8 = this.cipher.doFinal();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullExpressionValue(r8, "cipher.doFinal()");     // Catch: Throwable -> L9
        r4.write(r8);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        return th;
    }
}
