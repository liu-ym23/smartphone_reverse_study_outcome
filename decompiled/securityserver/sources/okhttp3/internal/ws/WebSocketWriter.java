package okhttp3.internal.ws;

import com.bytedance.common.wschannel.WsConstants;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;

    @NotNull
    private final Random random;

    @NotNull
    private final BufferedSink sink;
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean r2, @NotNull BufferedSink r3, @NotNull Random r4, boolean r5, boolean r6, long r7) {
        Intrinsics.f(r3, "sink");
        Intrinsics.f(r4, "random");
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

    private final void writeControlFrame(int r6, ByteString r7) {
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
        Intrinsics.c(r2);
        r8.nextBytes(r2);
        this.sinkBuffer.write(this.maskKey);
        if (r0 <= 0) goto L15;
        long r3 = this.sinkBuffer.size();
        this.sinkBuffer.write(r7);
        Buffer r9 = this.sinkBuffer;
        Buffer.UnsafeCursor r10 = this.maskCursor;
        Intrinsics.c(r10);
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater r0 = this.messageDeflater;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    @NotNull
    public final Random getRandom() {
        return this.random;
    }

    @NotNull
    public final BufferedSink getSink() {
        return this.sink;
    }

    public final void writeClose(int r2, @Nullable ByteString r3) {
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

    public final void writeMessageFrame(int r6, @NotNull ByteString r7) {
        Intrinsics.f(r7, "data");
        if (this.writerClosed == true) goto L32;
        this.messageBuffer.write(r7);
        int r0 = r6 | 128;
        if (this.perMessageDeflate == true) goto L7;
    L13:
        long r8 = this.messageBuffer.size();
        this.sinkBuffer.writeByte(r0);
        if (this.isClient == false) goto L16;
        int r1 = 128;
    L18:
        if (r8 > 125) goto L21;
        this.sinkBuffer.writeByte(r1 | ((int) r8));
    L25:
        if (this.isClient == false) goto L29;
        Random r2 = this.random;
        byte[] r3 = this.maskKey;
        Intrinsics.c(r3);
        r2.nextBytes(r3);
        this.sinkBuffer.write(this.maskKey);
        if (r8 <= 0) goto L29;
        Buffer r4 = this.messageBuffer;
        Buffer.UnsafeCursor r5 = this.maskCursor;
        Intrinsics.c(r5);
        r4.readAndWriteUnsafe(r5);
        this.maskCursor.seek(0);
        WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L29:
        this.sinkBuffer.write(this.messageBuffer, r8);
        this.sink.emit();
        return;
    L21:
        if (r8 > WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L23;
        this.sinkBuffer.writeByte(r1 | WebSocketProtocol.PAYLOAD_SHORT);
        this.sinkBuffer.writeShort((int) r8);
        goto L25
    L23:
        this.sinkBuffer.writeByte(r1 | 127);
        this.sinkBuffer.writeLong(r8);
        goto L25
    L16:
        r1 = 0;
        goto L18
    L7:
        if (r7.size() < this.minimumDeflateSize) goto L13;
        MessageDeflater r9 = this.messageDeflater;
        if (r9 != null) goto L12;
        r9 = new MessageDeflater(this.noContextTakeover);
        this.messageDeflater = r9;
    L12:
        r9.deflate(this.messageBuffer);
        r0 = r6 | 192;
        goto L13
    L32:
        throw new IOException("closed");
    }

    public final void writePing(@NotNull ByteString r2) {
        Intrinsics.f(r2, WsConstants.KEY_PAYLOAD);
        writeControlFrame(9, r2);
    }

    public final void writePong(@NotNull ByteString r2) {
        Intrinsics.f(r2, WsConstants.KEY_PAYLOAD);
        writeControlFrame(10, r2);
    }
}
