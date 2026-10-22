package okhttp3.internal.ws;

import com.bytedance.apm.alog.AlogMonitor;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: WebSocketWriter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020!H\u0002J\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020!J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020!J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lokhttp3/internal/ws/WebSocketWriter;", "Ljava/io/Closeable;", "isClient", "", "sink", "Lokio/BufferedSink;", "random", "Ljava/util/Random;", "perMessageDeflate", "noContextTakeover", "minimumDeflateSize", "", "(ZLokio/BufferedSink;Ljava/util/Random;ZZJ)V", "maskCursor", "Lokio/Buffer$UnsafeCursor;", "maskKey", "", "messageBuffer", "Lokio/Buffer;", "messageDeflater", "Lokhttp3/internal/ws/MessageDeflater;", "getRandom", "()Ljava/util/Random;", "getSink", "()Lokio/BufferedSink;", "sinkBuffer", "writerClosed", "close", "", "writeClose", AlogMonitor.ALOG_RESULT_CODE, "", "reason", "Lokio/ByteString;", "writeControlFrame", "opcode", "payload", "writeMessageFrame", "formatOpcode", "data", "writePing", "writePong", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final BufferedSink sink;
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean r2, BufferedSink r3, Random r4, boolean r5, boolean r6, long r7) {
        Intrinsics.checkNotNullParameter(r3, "sink");
        Intrinsics.checkNotNullParameter(r4, "random");
        this.isClient = r2;
        this.sink = r3;
        this.random = r4;
        this.perMessageDeflate = r5;
        this.noContextTakeover = r6;
        this.minimumDeflateSize = r7;
        this.messageBuffer = new Buffer();
        this.sinkBuffer = r3.getBuffer();
        Buffer.UnsafeCursor r8 = null;
        if (r2 == false) goto L5;
        byte[] r9 = new byte[4];
    L6:
        this.maskKey = r9;
        if (r2 == false) goto L9;
        r8 = new Buffer.UnsafeCursor();
    L9:
        this.maskCursor = r8;
        return;
    L5:
        r9 = null;
        goto L6
    }

    public final BufferedSink getSink() {
        return this.sink;
    }

    public final Random getRandom() {
        return this.random;
    }

    public final void writePing(ByteString r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "payload");
        writeControlFrame(9, r2);
    }

    public final void writePong(ByteString r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "payload");
        writeControlFrame(10, r2);
    }

    public final void writeClose(int r2, ByteString r3) throws IOException {
        ByteString r0 = ByteString.EMPTY;
        if (r2 != 0) goto L5;
        if (r3 != null) goto L5;
    L18:
        writeControlFrame(8, r0);     // Catch: Throwable -> L15
        this.writerClosed = true;
        return;
    L15:
        th = move-exception;
        this.writerClosed = true;
        throw th;
    L5:
        if (r2 == 0) goto L7;
        WebSocketProtocol.INSTANCE.validateCloseCode(r2);
    L7:
        Buffer r1 = new Buffer();
        r1.writeShort(r2);
        if (r3 == null) goto L10;
        r1.write(r3);
    L10:
        r0 = r1.readByteString();
        goto L18
    }

    private final void writeControlFrame(int r6, ByteString r7) throws IOException {
        if (this.writerClosed == true) goto L20;
        int r0 = r7.size();
        if (r0 > 125) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L18;
        this.sinkBuffer.writeByte(r6 | 128);
        if (this.isClient == false) goto L14;
        this.sinkBuffer.writeByte(r0 | 128);
        Random r8 = this.random;
        byte[] r2 = this.maskKey;
        Intrinsics.checkNotNull(r2);
        r8.nextBytes(r2);
        this.sinkBuffer.write(this.maskKey);
        if (r0 <= 0) goto L15;
        long r3 = this.sinkBuffer.size();
        this.sinkBuffer.write(r7);
        Buffer r9 = this.sinkBuffer;
        Buffer.UnsafeCursor r10 = this.maskCursor;
        Intrinsics.checkNotNull(r10);
        r9.readAndWriteUnsafe(r10);
        this.maskCursor.seek(r3);
        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L15:
        this.sink.flush();
        return;
    L14:
        this.sinkBuffer.writeByte(r0);
        this.sinkBuffer.write(r7);
        goto L15
    L18:
        throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
    L7:
        r1 = false;
        goto L8
    L20:
        throw new IOException("closed");
    }

    public final void writeMessageFrame(int r6, ByteString r7) throws IOException {
        Intrinsics.checkNotNullParameter(r7, "data");
        if (this.writerClosed == true) goto L31;
        this.messageBuffer.write(r7);
        int r0 = 128;
        int r8 = r6 | 128;
        if (this.perMessageDeflate == true) goto L7;
    L12:
        long r1 = this.messageBuffer.size();
        this.sinkBuffer.writeByte(r8);
        if (this.isClient == true) goto L17;
        r0 = 0;
    L17:
        if (r1 > 125) goto L20;
        this.sinkBuffer.writeByte(((int) r1) | r0);
    L24:
        if (this.isClient == false) goto L28;
        Random r9 = this.random;
        byte[] r10 = this.maskKey;
        Intrinsics.checkNotNull(r10);
        r9.nextBytes(r10);
        this.sinkBuffer.write(this.maskKey);
        if (r1 <= 0) goto L28;
        Buffer r2 = this.messageBuffer;
        Buffer.UnsafeCursor r3 = this.maskCursor;
        Intrinsics.checkNotNull(r3);
        r2.readAndWriteUnsafe(r3);
        this.maskCursor.seek(0);
        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L28:
        this.sinkBuffer.write(this.messageBuffer, r1);
        this.sink.emit();
        return;
    L20:
        if (r1 > WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L22;
        this.sinkBuffer.writeByte(r0 | 126);
        this.sinkBuffer.writeShort((int) r1);
        goto L24
    L22:
        this.sinkBuffer.writeByte(r0 | 127);
        this.sinkBuffer.writeLong(r1);
        goto L24
    L7:
        if (r7.size() < this.minimumDeflateSize) goto L12;
        MessageDeflater r11 = this.messageDeflater;
        if (r11 != null) goto L11;
        r11 = new MessageDeflater(this.noContextTakeover);
        this.messageDeflater = r11;
    L11:
        r11.deflate(this.messageBuffer);
        r8 = r8 | 64;
        goto L12
    L31:
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater r0 = this.messageDeflater;
        if (r0 == null) goto L7;
        r0.close();
        return;
    }
}
