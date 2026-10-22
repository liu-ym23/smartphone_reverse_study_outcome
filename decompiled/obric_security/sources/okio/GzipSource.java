package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes5.dex */
public final class GzipSource implements Source {
    private static final byte FCOMMENT = 4;
    private static final byte FEXTRA = 2;
    private static final byte FHCRC = 1;
    private static final byte FNAME = 3;
    private static final byte SECTION_BODY = 1;
    private static final byte SECTION_DONE = 3;
    private static final byte SECTION_HEADER = 0;
    private static final byte SECTION_TRAILER = 2;
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private int section;
    private final BufferedSource source;

    public GzipSource(Source r3) {
        this.section = 0;
        this.crc = new CRC32();
        if (r3 == null) goto L7;
        Inflater r0 = new Inflater(true);
        this.inflater = r0;
        BufferedSource r4 = Okio.buffer(r3);
        this.source = r4;
        this.inflaterSource = new InflaterSource(r4, r0);
        return;
    L7:
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.Source
    public long read(Buffer r12, long r13) throws IOException {
        if (r13 < 0) goto L25;
        if (r13 != 0) goto L7;
        return 0;
    L7:
        if (this.section != 0) goto L10;
        consumeHeader();
        this.section = 1;
    L10:
        if (this.section != 1) goto L17;
        long r7 = r12.size;
        long r14 = this.inflaterSource.read(r12, r13);
        if (r14 == (-1)) goto L15;
        updateCrc(r12, r7, r14);
        return r14;
    L15:
        this.section = 2;
    L17:
        if (this.section != 2) goto L23;
        consumeTrailer();
        this.section = 3;
        if (this.source.exhausted() == true) goto L23;
        throw new IOException("gzip finished without exhausting source");
    L23:
        return -1;
    L25:
        throw new IllegalArgumentException("byteCount < 0: " + r13);
    }

    private void consumeHeader() throws IOException {
        this.source.require(10);
        byte r7 = this.source.buffer().getByte(3);
        if (((r7 >> 1) & 1) != 1) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        updateCrc(this.source.buffer(), 0, 10);
    L8:
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8);
        if (((r7 >> 2) & 1) != 1) goto L18;
        this.source.require(2);
        if (r10 == false) goto L13;
        updateCrc(this.source.buffer(), 0, 2);
    L13:
        long r11 = this.source.buffer().readShortLe();
        this.source.require(r11);
        if (r10 == false) goto L16;
        updateCrc(this.source.buffer(), 0, r11);
    L16:
        this.source.skip(r11);
    L18:
        if (((r7 >> 3) & 1) != 1) goto L27;
        long r15 = this.source.indexOf((byte) 0);
        if (r15 == (-1)) goto L25;
        if (r10 == false) goto L23;
        updateCrc(this.source.buffer(), 0, r15 + 1);
    L23:
        this.source.skip(r15 + 1);
        goto L27
    L25:
        throw new EOFException();
    L27:
        if (((r7 >> 4) & 1) != 1) goto L35;
        long r8 = this.source.indexOf((byte) 0);
        if (r8 == (-1)) goto L34;
        if (r10 == false) goto L32;
        updateCrc(this.source.buffer(), 0, r8 + 1);
    L32:
        this.source.skip(r8 + 1);
        goto L35
    L34:
        throw new EOFException();
    L35:
        if (r10 == false) goto L38;
        checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
        this.crc.reset();
        return;
    L38:
        return;
    L5:
        r10 = false;
        goto L6
    }

    private void consumeTrailer() throws IOException {
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

    private void updateCrc(Buffer r5, long r6, long r8) {
        Segment r7 = r5.head;
    L4:
        if (r6 < (r7.limit - r7.pos)) goto L7;
        r6 = r6 - ((long) (r7.limit - r7.pos));
        r7 = r7.next;
    L7:
        if (r8 <= 0) goto L9;
        int r9 = (int) (((long) r7.pos) + r6);
        int r10 = (int) Math.min(r7.limit - r9, r8);
        this.crc.update(r7.data, r9, r10);
        r8 = r8 - ((long) r10);
        r7 = r7.next;
        r6 = 0;
        goto L7
    }

    private void checkEqual(String r3, int r4, int r5) throws IOException {
        if (r5 != r4) goto L5;
        return;
    L5:
        throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{r3, Integer.valueOf(r5), Integer.valueOf(r4)}));
    }
}
