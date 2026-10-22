package okhttp3.internal.ws;

import com.bytedance.apm.alog.AlogMonitor;
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

/* JADX INFO: compiled from: WebSocketReader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001&B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u001fJ\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0002R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006'"}, d2 = {"Lokhttp3/internal/ws/WebSocketReader;", "Ljava/io/Closeable;", "isClient", "", "source", "Lokio/BufferedSource;", "frameCallback", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "perMessageDeflate", "noContextTakeover", "(ZLokio/BufferedSource;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;ZZ)V", "closed", "controlFrameBuffer", "Lokio/Buffer;", "frameLength", "", "isControlFrame", "isFinalFrame", "maskCursor", "Lokio/Buffer$UnsafeCursor;", "maskKey", "", "messageFrameBuffer", "messageInflater", "Lokhttp3/internal/ws/MessageInflater;", "opcode", "", "readingCompressedMessage", "getSource", "()Lokio/BufferedSource;", "close", "", "processNextFrame", "readControlFrame", "readHeader", "readMessage", "readMessageFrame", "readUntilNonControlFrame", "FrameCallback", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    private final BufferedSource source;

    /* JADX INFO: compiled from: WebSocketReader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH&¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "", "onReadClose", "", AlogMonitor.ALOG_RESULT_CODE, "", "reason", "", "onReadMessage", "text", "bytes", "Lokio/ByteString;", "onReadPing", "payload", "onReadPong", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface FrameCallback {
        void onReadClose(int r1, String r2);

        void onReadMessage(String r1) throws IOException;

        void onReadMessage(ByteString r1) throws IOException;

        void onReadPing(ByteString r1);

        void onReadPong(ByteString r1);
    }

    public WebSocketReader(boolean r2, BufferedSource r3, FrameCallback r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "frameCallback");
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

    public final BufferedSource getSource() {
        return this.source;
    }

    public final void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame == false) goto L5;
        readControlFrame();
        return;
    L5:
        readMessageFrame();
    }

    private final void readHeader() throws IOException, ProtocolException {
        if (this.closed == true) goto L89;
        long r0 = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        int r2 = Util.and(this.source.readByte(), 255);     // Catch: Throwable -> L85
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
        if ((r2 & 32) == 0) goto L43;
        boolean r8 = true;
    L44:
        if (r8 == true) goto L84;
        if ((r2 & 16) == 0) goto L48;
        boolean r9 = true;
    L49:
        if (r9 == true) goto L82;
        int r10 = Util.and(this.source.readByte(), 255);
        if ((r10 & 128) == 0) goto L54;
        r4 = true;
    L54:
        if (r4 == this.isClient) goto L56;
        long r11 = r10 & 127;
        this.frameLength = r11;
        if (r11 != 126) goto L65;
        this.frameLength = Util.and(this.source.readShort(), 65535);
    L72:
        if (this.isControlFrame == true) goto L74;
    L78:
        if (r4 == false) goto L92;
        BufferedSource r12 = this.source;
        byte[] r13 = this.maskKey;
        Intrinsics.checkNotNull(r13);
        r12.readFully(r13);
        return;
    L92:
        return;
    L74:
        if (this.frameLength <= 125) goto L78;
        throw new ProtocolException("Control frame must be less than 125B.");
    L65:
        if (r11 != 127) goto L72;
        long r14 = this.source.readLong();
        this.frameLength = r14;
        if (r14 >= 0) goto L72;
        throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
    L56:
        if (this.isClient == false) goto L58;
        String r15 = "Server-sent frames must not be masked.";
    L60:
        throw new ProtocolException(r15);
    L58:
        r15 = "Client-sent frames must be masked.";
        goto L60
    L82:
        throw new ProtocolException("Unexpected rsv3 flag");
    L48:
        r9 = false;
        goto L49
    L84:
        throw new ProtocolException("Unexpected rsv2 flag");
    L43:
        r8 = false;
        goto L44
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
    L85:
        th = move-exception;
        this.source.timeout().timeout(r0, TimeUnit.NANOSECONDS);
        throw th;
    L89:
        throw new IOException("closed");
    }

    private final void readControlFrame() throws IOException {
        long r0 = this.frameLength;
        if (r0 <= 0) goto L8;
        this.source.readFully(this.controlFrameBuffer, r0);
        if (this.isClient == true) goto L8;
        Buffer r1 = this.controlFrameBuffer;
        Buffer.UnsafeCursor r2 = this.maskCursor;
        Intrinsics.checkNotNull(r2);
        r1.readAndWriteUnsafe(r2);
        this.maskCursor.seek(0);
        WebSocketProtocol r3 = WebSocketProtocol.INSTANCE;
        Buffer.UnsafeCursor r4 = this.maskCursor;
        byte[] r5 = this.maskKey;
        Intrinsics.checkNotNull(r5);
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
        throw new ProtocolException(Intrinsics.stringPlus("Unknown control opcode: ", Util.toHexString(this.opcode)));
    }

    private final void readMessageFrame() throws IOException {
        int r0 = this.opcode;
        if (r0 != 1) goto L5;
    L9:
        readMessage();
        if (this.readingCompressedMessage == false) goto L15;
        MessageInflater r2 = this.messageInflater;
        if (r2 != null) goto L14;
        r2 = new MessageInflater(this.noContextTakeover);
        this.messageInflater = r2;
    L14:
        r2.inflate(this.messageFrameBuffer);
    L15:
        if (r0 != 1) goto L17;
        this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        return;
    L17:
        this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        return;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException(Intrinsics.stringPlus("Unknown opcode: ", Util.toHexString(r0)));
    }

    private final void readUntilNonControlFrame() throws IOException {
    L3:
        if (this.closed == true) goto L8;
        readHeader();
        if (this.isControlFrame == false) goto L11;
        readControlFrame();
        goto L3
    L11:
        return;
    }

    private final void readMessage() throws IOException {
    L3:
        if (this.closed == true) goto L18;
        long r0 = this.frameLength;
        if (r0 <= 0) goto L10;
        this.source.readFully(this.messageFrameBuffer, r0);
        if (this.isClient == true) goto L10;
        Buffer r1 = this.messageFrameBuffer;
        Buffer.UnsafeCursor r2 = this.maskCursor;
        Intrinsics.checkNotNull(r2);
        r1.readAndWriteUnsafe(r2);
        this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
        WebSocketProtocol r3 = WebSocketProtocol.INSTANCE;
        Buffer.UnsafeCursor r4 = this.maskCursor;
        byte[] r5 = this.maskKey;
        Intrinsics.checkNotNull(r5);
        r3.toggleMask(r4, r5);
        this.maskCursor.close();
    L10:
        if (this.isFinalFrame == true) goto L11;
        readUntilNonControlFrame();
        if (this.opcode == 0) goto L3;
        throw new ProtocolException(Intrinsics.stringPlus("Expected continuation opcode. Got: ", Util.toHexString(this.opcode)));
    L11:
        return;
    L18:
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater r0 = this.messageInflater;
        if (r0 == null) goto L7;
        r0.close();
        return;
    }
}
