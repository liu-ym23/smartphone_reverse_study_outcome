package okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.UByte;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
final class WebSocketReader {
    boolean closed;
    private final Buffer controlFrameBuffer;
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer;
    int opcode;
    final BufferedSource source;

    public interface FrameCallback {
        void onReadClose(int r1, String r2);

        void onReadMessage(String r1) throws IOException;

        void onReadMessage(ByteString r1) throws IOException;

        void onReadPing(ByteString r1);

        void onReadPong(ByteString r1);
    }

    WebSocketReader(boolean r2, BufferedSource r3, FrameCallback r4) {
        this.controlFrameBuffer = new Buffer();
        this.messageFrameBuffer = new Buffer();
        if (r3 == null) goto L18;
        if (r4 == null) goto L16;
        this.isClient = r2;
        this.source = r3;
        this.frameCallback = r4;
        Buffer.UnsafeCursor r5 = null;
        if (r2 == false) goto L8;
        byte[] r6 = null;
    L9:
        this.maskKey = r6;
        if (r2 == true) goto L13;
        r5 = new Buffer.UnsafeCursor();
    L13:
        this.maskCursor = r5;
        return;
    L8:
        r6 = new byte[4];
        goto L9
    L16:
        throw new NullPointerException("frameCallback == null");
    L18:
        throw new NullPointerException("source == null");
    }

    void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame == false) goto L5;
        readControlFrame();
        return;
    L5:
        readMessageFrame();
    }

    private void readHeader() throws IOException {
        if (this.closed == true) goto L73;
        long r0 = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        int r2 = this.source.readByte() & UByte.MAX_VALUE;
        this.source.timeout().timeout(r0, TimeUnit.NANOSECONDS);
        this.opcode = r2 & 15;
        boolean r1 = true;
        if ((r2 & 128) == 0) goto L9;
        boolean r3 = true;
    L10:
        this.isFinalFrame = r3;
        if ((r2 & 8) == 0) goto L13;
        boolean r4 = true;
    L14:
        this.isControlFrame = r4;
        if (r4 == false) goto L21;
        if (r3 == true) goto L21;
        throw new ProtocolException("Control frames must be final.");
    L21:
        if ((r2 & 64) == 0) goto L23;
        boolean r5 = true;
    L25:
        if ((r2 & 32) == 0) goto L27;
        boolean r6 = true;
    L29:
        if ((r2 & 16) == 0) goto L31;
        boolean r7 = true;
    L32:
        if (r5 == true) goto L68;
        if (r6 == true) goto L68;
        if (r7 == true) goto L68;
        int r8 = this.source.readByte() & UByte.MAX_VALUE;
        if ((r8 & 128) != 0) goto L40;
        r1 = false;
    L40:
        if (r1 == this.isClient) goto L42;
        long r9 = r8 & 127;
        this.frameLength = r9;
        if (r9 != 126) goto L51;
        this.frameLength = ((long) this.source.readShort()) & 65535;
    L58:
        if (this.isControlFrame == true) goto L60;
    L64:
        if (r1 == false) goto L76;
        this.source.readFully(this.maskKey);
        return;
    L76:
        return;
    L60:
        if (this.frameLength <= 125) goto L64;
        throw new ProtocolException("Control frame must be less than 125B.");
    L51:
        if (r9 != 127) goto L58;
        long r10 = this.source.readLong();
        this.frameLength = r10;
        if (r10 >= 0) goto L58;
        throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
    L42:
        if (this.isClient == false) goto L44;
        String r11 = "Server-sent frames must not be masked.";
    L46:
        throw new ProtocolException(r11);
    L44:
        r11 = "Client-sent frames must be masked.";
    L68:
        throw new ProtocolException("Reserved flags are unsupported.");
    L31:
        r7 = false;
        goto L32
    L27:
        r6 = false;
        goto L29
    L23:
        r5 = false;
        goto L25
    L13:
        r4 = false;
        goto L14
    L9:
        r3 = false;
    L69:
        th = move-exception;
        this.source.timeout().timeout(r0, TimeUnit.NANOSECONDS);
        throw th;
    L73:
        throw new IOException("closed");
    }

    private void readControlFrame() throws IOException {
        long r0 = this.frameLength;
        if (r0 <= 0) goto L8;
        this.source.readFully(this.controlFrameBuffer, r0);
        if (this.isClient == true) goto L8;
        this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
        this.maskCursor.seek(0);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
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
        long r1 = this.controlFrameBuffer.size();
        if (r1 == 1) goto L26;
        if (r1 == 0) goto L22;
        short r2 = this.controlFrameBuffer.readShort();
        String r3 = this.controlFrameBuffer.readUtf8();
        String r4 = WebSocketProtocol.closeCodeExceptionMessage(r2);
        if (r4 != null) goto L21;
    L23:
        this.frameCallback.onReadClose(r2, r3);
        this.closed = true;
        return;
    L21:
        throw new ProtocolException(r4);
    L22:
        r2 = 1005;
        r3 = "";
        goto L23
    L26:
        throw new ProtocolException("Malformed close payload length of 1.");
    L10:
        throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
    }

    private void readMessageFrame() throws IOException {
        int r0 = this.opcode;
        if (r0 != 1) goto L5;
    L9:
        readMessage();
        if (r0 != 1) goto L12;
        this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        return;
    L12:
        this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        return;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Unknown opcode: " + Integer.toHexString(r0));
    }

    private void readUntilNonControlFrame() throws IOException {
    L3:
        if (this.closed == true) goto L8;
        readHeader();
        if (this.isControlFrame == false) goto L11;
        readControlFrame();
        goto L3
    L11:
        return;
    }

    private void readMessage() throws IOException {
    L3:
        if (this.closed == true) goto L18;
        long r0 = this.frameLength;
        if (r0 <= 0) goto L10;
        this.source.readFully(this.messageFrameBuffer, r0);
        if (this.isClient == true) goto L10;
        this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
        this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L10:
        if (this.isFinalFrame == true) goto L11;
        readUntilNonControlFrame();
        if (this.opcode == 0) goto L3;
        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
    L11:
        return;
    L18:
        throw new IOException("closed");
    }
}
