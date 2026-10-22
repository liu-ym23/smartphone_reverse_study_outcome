package okio;

import a.a;
import com.bytedance.apm.battery.dao.DBHelper;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class GzipSource implements Source {
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(@NotNull Source r3) {
        Intrinsics.f(r3, DBHelper.BATTERY_COL_SOURCE);
        RealBufferedSource r0 = new RealBufferedSource(r3);
        this.source = r0;
        Inflater r4 = new Inflater(true);
        this.inflater = r4;
        this.inflaterSource = new InflaterSource(r0, r4);
        this.crc = new CRC32();
    }

    private final void checkEqual(String r1, int r2, int r3) {
        if (r3 != r2) goto L5;
        return;
    L5:
        throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{r1, Integer.valueOf(r3), Integer.valueOf(r2)}, 3)));
    }

    private final void consumeHeader() {
        this.source.require(10);
        byte r7 = this.source.bufferField.getByte(3);
        if (((r7 >> 1) & 1) != 1) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        updateCrc(this.source.bufferField, 0, 10);
    L8:
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8);
        if (((r7 >> 2) & 1) != 1) goto L18;
        this.source.require(2);
        if (r10 == false) goto L13;
        updateCrc(this.source.bufferField, 0, 2);
    L13:
        long r11 = this.source.bufferField.readShortLe();
        this.source.require(r11);
        if (r10 == false) goto L16;
        updateCrc(this.source.bufferField, 0, r11);
    L16:
        this.source.skip(r11);
    L18:
        if (((r7 >> 3) & 1) != 1) goto L27;
        long r15 = this.source.indexOf((byte) 0);
        if (r15 == (-1)) goto L25;
        if (r10 == false) goto L23;
        updateCrc(this.source.bufferField, 0, r15 + 1);
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
        updateCrc(this.source.bufferField, 0, r8 + 1);
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

    private final void consumeTrailer() {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private final void updateCrc(Buffer r5, long r6, long r8) {
        Segment r7 = r5.head;
        Intrinsics.c(r7);
    L3:
        int r0 = r7.limit;
        int r1 = r7.pos;
        if (r6 < (r0 - r1)) goto L7;
        r6 = r6 - ((long) (r0 - r1));
        r7 = r7.next;
        Intrinsics.c(r7);
    L7:
        if (r8 <= 0) goto L9;
        int r9 = (int) (((long) r7.pos) + r6);
        int r10 = (int) Math.min(r7.limit - r9, r8);
        this.crc.update(r7.data, r9, r10);
        r8 = r8 - ((long) r10);
        r7 = r7.next;
        Intrinsics.c(r7);
        r6 = 0;
        goto L7
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }

    @Override // okio.Source
    public long read(@NotNull Buffer r13, long r14) {
        Intrinsics.f(r13, "sink");
        if (r14 < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L28;
        if (r14 != 0) goto L10;
        return 0;
    L10:
        if (this.section != 0) goto L13;
        consumeHeader();
        this.section = 1;
    L13:
        if (this.section != 1) goto L20;
        long r8 = r13.size();
        long r15 = this.inflaterSource.read(r13, r14);
        if (r15 == (-1)) goto L18;
        updateCrc(r13, r8, r15);
        return r15;
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
        throw new IllegalArgumentException(a.h("byteCount < 0: ", r14).toString());
    L5:
        r4 = false;
        goto L6
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }
}
