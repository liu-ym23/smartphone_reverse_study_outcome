package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GzipSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lokio/GzipSource;", "Lokio/Source;", "source", "(Lokio/Source;)V", "crc", "Ljava/util/zip/CRC32;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "section", "", "Lokio/RealBufferedSource;", "checkEqual", "", "name", "", "expected", "", "actual", "close", "consumeHeader", "consumeTrailer", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "offset", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GzipSource implements Source {
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(Source r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        RealBufferedSource r0 = new RealBufferedSource(r3);
        this.source = r0;
        Inflater r4 = new Inflater(true);
        this.inflater = r4;
        this.inflaterSource = new InflaterSource(r0, r4);
        this.crc = new CRC32();
    }

    @Override // okio.Source
    public long read(Buffer r12, long r13) throws IOException {
        Intrinsics.checkNotNullParameter(r12, "sink");
        if (r13 < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L28;
        if (r13 != 0) goto L10;
        return 0;
    L10:
        if (this.section != 0) goto L13;
        consumeHeader();
        this.section = 1;
    L13:
        if (this.section != 1) goto L20;
        long r7 = r12.size();
        long r14 = this.inflaterSource.read(r12, r13);
        if (r14 == (-1)) goto L18;
        updateCrc(r12, r7, r14);
        return r14;
    L18:
        this.section = 2;
    L20:
        if (this.section != 2) goto L26;
        consumeTrailer();
        this.section = 3;
        if (this.source.exhausted() == true) goto L26;
        throw new IOException("gzip finished without exhausting source");
    L26:
        return -1;
    L28:
        throw new IllegalArgumentException(("byteCount < 0: " + r13).toString());
    L5:
        r4 = false;
        goto L6
    }

    private final void consumeHeader() throws IOException {
        this.source.require(10);
        byte r7 = this.source.bufferField.getByte(3);
        boolean r8 = true;
        if (((r7 >> 1) & 1) != 1) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        updateCrc(this.source.bufferField, 0, 10);
    L8:
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8);
        if (((r7 >> 2) & 1) != 1) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L21;
        this.source.require(2);
        if (r10 == false) goto L16;
        updateCrc(this.source.bufferField, 0, 2);
    L16:
        long r11 = this.source.bufferField.readShortLe();
        this.source.require(r11);
        if (r10 == false) goto L19;
        updateCrc(this.source.bufferField, 0, r11);
    L19:
        this.source.skip(r11);
    L21:
        if (((r7 >> 3) & 1) != 1) goto L23;
        boolean r1 = true;
    L25:
        if (r1 == false) goto L34;
        long r15 = this.source.indexOf((byte) 0);
        if (r15 == (-1)) goto L32;
        if (r10 == false) goto L30;
        updateCrc(this.source.bufferField, 0, r15 + 1);
    L30:
        this.source.skip(r15 + 1);
        goto L34
    L32:
        throw new EOFException();
    L34:
        if (((r7 >> 4) & 1) == 1) goto L37;
        r8 = false;
    L37:
        if (r8 == false) goto L45;
        long r9 = this.source.indexOf((byte) 0);
        if (r9 == (-1)) goto L44;
        if (r10 == false) goto L42;
        updateCrc(this.source.bufferField, 0, r9 + 1);
    L42:
        this.source.skip(r9 + 1);
        goto L45
    L44:
        throw new EOFException();
    L45:
        if (r10 == false) goto L48;
        checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
        this.crc.reset();
        return;
    L48:
        return;
    L23:
        r1 = false;
        goto L25
    L11:
        r0 = false;
        goto L12
    L5:
        r10 = false;
        goto L6
    }

    private final void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    private final void updateCrc(Buffer r5, long r6, long r8) {
        Segment r7 = r5.head;
        Intrinsics.checkNotNull(r7);
    L4:
        if (r6 < (r7.limit - r7.pos)) goto L7;
        r6 = r6 - ((long) (r7.limit - r7.pos));
        r7 = r7.next;
        Intrinsics.checkNotNull(r7);
    L7:
        if (r8 <= 0) goto L9;
        int r9 = (int) (((long) r7.pos) + r6);
        int r10 = (int) Math.min(r7.limit - r9, r8);
        this.crc.update(r7.data, r9, r10);
        r8 = r8 - ((long) r10);
        r7 = r7.next;
        Intrinsics.checkNotNull(r7);
        r6 = 0;
        goto L7
    }

    private final void checkEqual(String r4, int r5, int r6) {
        if (r6 != r5) goto L4;
        return;
    L4:
        String r7 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{r4, Integer.valueOf(r6), Integer.valueOf(r5)}, 3));
        Intrinsics.checkNotNullExpressionValue(r7, "format(this, *args)");
        throw new IOException(r7);
    }
}
