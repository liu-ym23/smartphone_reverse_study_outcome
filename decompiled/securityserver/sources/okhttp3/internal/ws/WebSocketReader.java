package okhttp3.internal.ws;

import com.bytedance.apm.battery.dao.DBHelper;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WebSocketReader implements Closeable {
    private boolean closed;
    private final Buffer controlFrameBuffer;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer;
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;

    @NotNull
    private final BufferedSource source;

    @Metadata
    public interface FrameCallback {
        void onReadClose(int r1, @NotNull String r2);

        void onReadMessage(@NotNull String r1);

        void onReadMessage(@NotNull ByteString r1);

        void onReadPing(@NotNull ByteString r1);

        void onReadPong(@NotNull ByteString r1);
    }

    public WebSocketReader(boolean r2, @NotNull BufferedSource r3, @NotNull FrameCallback r4, boolean r5, boolean r6) {
        Intrinsics.f(r3, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.f(r4, "frameCallback");
        this.isClient = r2;
        this.source = r3;
        this.frameCallback = r4;
        this.perMessageDeflate = r5;
        this.noContextTakeover = r6;
        this.controlFrameBuffer = new Buffer();
        this.messageFrameBuffer = new Buffer();
        Buffer.UnsafeCursor r7 = null;
        if (r2 == false) goto L5;
        byte[] r8 = null;
    L6:
        this.maskKey = r8;
        if (r2 == true) goto L10;
        r7 = new Buffer.UnsafeCursor();
    L10:
        this.maskCursor = r7;
        return;
    L5:
        r8 = new byte[4];
        goto L6
    }

    private final void readControlFrame() {
        long r0 = this.frameLength;
        if (r0 <= 0) goto L8;
        this.source.readFully(this.controlFrameBuffer, r0);
        if (this.isClient == true) goto L8;
        Buffer r1 = this.controlFrameBuffer;
        Buffer.UnsafeCursor r2 = this.maskCursor;
        Intrinsics.c(r2);
        r1.readAndWriteUnsafe(r2);
        this.maskCursor.seek(0);
        WebSocketProtocol r3 = WebSocketProtocol.INSTANCE;
        Buffer.UnsafeCursor r4 = this.maskCursor;
        byte[] r5 = this.maskKey;
        Intrinsics.c(r5);
        r3.toggleMask(r4, r5);
        this.maskCursor.close();
    L8:
        switch(this.opcode) {
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            default: goto L10;
        };
    L11:
        this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
        return;
    L12:
        this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
        return;
    L13:
        long r6 = this.controlFrameBuffer.size();
        if (r6 == 1) goto L26;
        if (r6 == 0) goto L22;
        short r7 = this.controlFrameBuffer.readShort();
        String r8 = this.controlFrameBuffer.readUtf8();
        String r9 = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(r7);
        if (r9 != null) goto L21;
    L23:
        this.frameCallback.onReadClose(r7, r8);
        this.closed = true;
        return;
    L21:
        throw new ProtocolException(r9);
    L22:
        r7 = 1005;
        r8 = "";
        goto L23
    L26:
        throw new ProtocolException("Malformed close payload length of 1.");
    L10:
        throw new ProtocolException("Unknown control opcode: " + Util.toHexString(this.opcode));
    }

    private final void readHeader() {
        if (this.closed == true) goto L83;
        long r0 = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        int r2 = Util.and(this.source.readByte(), 255);     // Catch: Throwable -> L79
        this.source.timeout().timeout(r0, TimeUnit.NANOSECONDS);
        int r1 = r2 & 15;
        this.opcode = r1;
        boolean r4 = false;
        if ((r2 & 128) == 0) goto L9;
        boolean r3 = true;
    L10:
        this.isFinalFrame = r3;
        if ((r2 & 8) == 0) goto L13;
        boolean r6 = true;
    L14:
        this.isControlFrame = r6;
        if (r6 == false) goto L21;
        if (r3 == true) goto L21;
        throw new ProtocolException("Control frames must be final.");
    L21:
        if ((r2 & 64) == 0) goto L23;
        boolean r5 = true;
    L25:
        if (r1 != 1) goto L27;
    L32:
        if (r5 == true) goto L34;
        boolean r7 = false;
    L39:
        this.readingCompressedMessage = r7;
    L41:
        if ((r2 & 32) != 0) goto L78;
        if ((r2 & 16) != 0) goto L76;
        int r8 = Util.and(this.source.readByte(), 255);
        if ((r8 & 128) == 0) goto L48;
        r4 = true;
    L48:
        if (r4 == this.isClient) goto L50;
        long r9 = r8 & 127;
        this.frameLength = r9;
        if (r9 != WebSocketProtocol.PAYLOAD_SHORT) goto L59;
        this.frameLength = Util.and(this.source.readShort(), 65535);
    L66:
        if (this.isControlFrame == true) goto L68;
    L72:
        if (r4 == false) goto L86;
        BufferedSource r10 = this.source;
        byte[] r11 = this.maskKey;
        Intrinsics.c(r11);
        r10.readFully(r11);
        return;
    L86:
        return;
    L68:
        if (this.frameLength <= 125) goto L72;
        throw new ProtocolException("Control frame must be less than 125B.");
    L59:
        if (r9 != 127) goto L66;
        long r12 = this.source.readLong();
        this.frameLength = r12;
        if (r12 >= 0) goto L66;
        throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
    L50:
        if (this.isClient == false) goto L52;
        String r13 = "Server-sent frames must not be masked.";
    L54:
        throw new ProtocolException(r13);
    L52:
        r13 = "Client-sent frames must be masked.";
        goto L54
    L76:
        throw new ProtocolException("Unexpected rsv3 flag");
    L78:
        throw new ProtocolException("Unexpected rsv2 flag");
    L34:
        if (this.perMessageDeflate == false) goto L37;
        r7 = true;
        goto L39
    L37:
        throw new ProtocolException("Unexpected rsv1 flag");
    L27:
        if (r1 == 2) goto L32;
        if (r5 == false) goto L41;
        throw new ProtocolException("Unexpected rsv1 flag");
    L23:
        r5 = false;
        goto L25
    L13:
        r6 = false;
        goto L14
    L9:
        r3 = false;
    L79:
        th = move-exception;
        this.source.timeout().timeout(r0, TimeUnit.NANOSECONDS);
        throw th;
    L83:
        throw new IOException("closed");
    }

    private final void readMessage() {
    L3:
        if (this.closed == true) goto L18;
        long r0 = this.frameLength;
        if (r0 <= 0) goto L10;
        this.source.readFully(this.messageFrameBuffer, r0);
        if (this.isClient == true) goto L10;
        Buffer r1 = this.messageFrameBuffer;
        Buffer.UnsafeCursor r2 = this.maskCursor;
        Intrinsics.c(r2);
        r1.readAndWriteUnsafe(r2);
        this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
        WebSocketProtocol r3 = WebSocketProtocol.INSTANCE;
        Buffer.UnsafeCursor r4 = this.maskCursor;
        byte[] r5 = this.maskKey;
        Intrinsics.c(r5);
        r3.toggleMask(r4, r5);
        this.maskCursor.close();
    L10:
        if (this.isFinalFrame == true) goto L11;
        readUntilNonControlFrame();
        if (this.opcode == 0) goto L3;
        throw new ProtocolException("Expected continuation opcode. Got: " + Util.toHexString(this.opcode));
    L11:
        return;
    L18:
        throw new IOException("closed");
    }

    private final void readMessageFrame() {
        int r0 = this.opcode;
        if (r0 != 1) goto L5;
    L9:
        readMessage();
        if (this.readingCompressedMessage == false) goto L16;
        MessageInflater r2 = this.messageInflater;
        if (r2 != null) goto L15;
        r2 = new MessageInflater(this.noContextTakeover);
        this.messageInflater = r2;
    L15:
        r2.inflate(this.messageFrameBuffer);
    L16:
        if (r0 != 1) goto L18;
        this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        return;
    L18:
        this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        return;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Unknown opcode: " + Util.toHexString(r0));
    }

    private final void readUntilNonControlFrame() {
    L3:
        if (this.closed == true) goto L8;
        readHeader();
        if (this.isControlFrame == false) goto L11;
        readControlFrame();
        goto L3
    L11:
        return;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageInflater r0 = this.messageInflater;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    @NotNull
    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() {
        readHeader();
        if (this.isControlFrame == false) goto L5;
        readControlFrame();
        return;
    L5:
        readMessageFrame();
    }
}
