package javax.obex;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class ServerSession extends ObexSession implements Runnable {
    private static final String TAG = "Obex ServerSession";
    private static final boolean V = false;
    private boolean mClosed;
    private InputStream mInput;
    private ServerRequestHandler mListener;
    private int mMaxPacketLength;
    private OutputStream mOutput;
    private Thread mProcessThread;
    private ObexTransport mTransport;
    private boolean setMTU;
    private boolean updateMtu;
    private int updatedMtuSize;

    private int validateResponseCode(int r2) {
        if (r2 < 160) goto L8;
        if (r2 > 166) goto L8;
        return r2;
    L8:
        if (r2 < 176) goto L13;
        if (r2 > 181) goto L13;
        return r2;
    L13:
        if (r2 < 192) goto L18;
        if (r2 > 207) goto L18;
        return r2;
    L18:
        if (r2 < 208) goto L23;
        if (r2 > 213) goto L23;
        return r2;
    L23:
        if (r2 >= 224) goto L25;
    L27:
        return 208;
    L25:
        if (r2 > 225) goto L27;
        return r2;
    }

    static {
        V = ObexHelper.VDBG;
    }

    public ServerSession(ObexTransport r2, ServerRequestHandler r3, Authenticator r4) throws IOException {
        this.setMTU = false;
        this.updateMtu = false;
        this.updatedMtuSize = 0;
        this.mAuthenticator = r4;
        this.mTransport = r2;
        this.mInput = r2.openInputStream();
        this.mOutput = this.mTransport.openOutputStream();
        this.mListener = r3;
        this.mMaxPacketLength = 256;
        this.mClosed = false;
        Thread r5 = new Thread(this);
        this.mProcessThread = r5;
        r5.start();
    }

    public void setMaxPacketSize(int r3) {
        if (V == false) goto L5;
        Log.v(TAG, "setMaxPacketSize" + r3);
    L5:
        this.mMaxPacketLength = r3;
    }

    public int getMaxPacketSize() {
        return this.mMaxPacketLength;
    }

    public void reduceMTU(boolean r1) {
        this.setMTU = r1;
    }

    public void updateMTU(int r2) {
        this.updateMtu = true;
        this.updatedMtuSize = r2;
        Log.i(TAG, "updateMTU: " + r2);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean r2 = false;
    L3:
        if (r2 == true) goto L39;
        if (this.mClosed == true) goto L39;
        boolean r3 = V;     // Catch: Exception -> L35 NullPointerException -> L37
        if (r3 == false) goto L9;
        Log.v(TAG, "Waiting for incoming request...");     // Catch: Exception -> L35 NullPointerException -> L37
    L9:
        int r4 = this.mInput.read();     // Catch: Exception -> L35 NullPointerException -> L37
        if (r3 == false) goto L13;
        Log.v(TAG, "Read request: " + r4);     // Catch: Exception -> L35 NullPointerException -> L37
    L13:
        if (r4 != (-1)) goto L15;
        Log.d(TAG, "Read request returned -1, exiting from loop");     // Catch: Exception -> L35 NullPointerException -> L37
        r2 = true;
        goto L3
    L15:
        if (r4 != 133) goto L17;
        handleSetPathRequest();     // Catch: Exception -> L35 NullPointerException -> L37
        goto L3
    L17:
        if (r4 != 255) goto L19;
        handleAbortRequest();     // Catch: Exception -> L35 NullPointerException -> L37
        goto L3
    L19:
        if (r4 == 2) goto L30;
        int r5 = 3;
        if (r4 == 3) goto L29;
        switch(r4) {
            case 128: goto L28;
            case 129: goto L27;
            case 130: goto L30;
            case 131: goto L29;
            default: goto L23;
        };     // Catch: Exception -> L35 NullPointerException -> L37
    L27:
        handleDisconnectRequest();     // Catch: Exception -> L35 NullPointerException -> L37
        goto L3
    L28:
        handleConnectRequest();     // Catch: Exception -> L35 NullPointerException -> L37
        goto L3
    L23:
        int r6 = (this.mInput.read() << 8) + this.mInput.read();     // Catch: Exception -> L35 NullPointerException -> L37
    L24:
        if (r5 >= r6) goto L26;
        this.mInput.read();     // Catch: Exception -> L35 NullPointerException -> L37
        r5 = r5 + 1;     // Catch: Exception -> L35 NullPointerException -> L37
        goto L24
    L26:
        sendResponse(209, null);     // Catch: Exception -> L35 NullPointerException -> L37
    L29:
        handleGetRequest(r4);     // Catch: Exception -> L35 NullPointerException -> L37
    L30:
        handlePutRequest(r4);     // Catch: Exception -> L35 NullPointerException -> L37
        goto L3
    L37:
        e = move-exception;
        Log.d(TAG, "Exception occured - ignoring", e);
    L35:
        e = move-exception;
        Log.d(TAG, "Exception occured - ignoring", e);
    L39:
        close();
    }

    private void handleAbortRequest() throws IOException {
        HeaderSet r0 = new HeaderSet();
        HeaderSet r1 = new HeaderSet();
        int r2 = (this.mInput.read() << 8) + this.mInput.read();
        if (r2 <= ObexHelper.getMaxRxPacketSize(this.mTransport)) goto L5;
        int r3 = 206;
    L9:
        sendResponse(r3, null);
        return;
    L5:
        int r4 = 3;
    L6:
        if (r4 >= r2) goto L8;
        this.mInput.read();
        r4 = r4 + 1;
        goto L6
    L8:
        int r5 = this.mListener.onAbort(r0, r1);
        Log.v(TAG, "onAbort request handler return value- " + r5);
        r3 = validateResponseCode(r5);
        goto L9
    }

    private void handlePutRequest(int r10) throws IOException {
        boolean r0 = V;
        if (r0 == false) goto L5;
        Log.v(TAG, "handlePutRequest");
    L5:
        ServerOperation r2 = new ServerOperation(this, this.mInput, r10, this.mMaxPacketLength, this.mListener);
    L29:
        e = move-exception;
        if (V == false) goto L34;
        Log.d(TAG, "Exception occured - sending OBEX_HTTP_INTERNAL_ERROR reply", e);
    L34:
        if (r2.isAborted == true) goto L43;
        sendResponse(208, null);
        return;
    L43:
        return;
    L7:
        if (r2.finalBitSet == true) goto L9;
    L11:
        int r11 = validateResponseCode(this.mListener.onPut(r2));     // Catch: Exception -> L29
    L13:
        if (r11 == 160) goto L20;
        if (r2.isAborted == true) goto L20;
        if (r0 == false) goto L18;
        Log.v(TAG, "handlePutRequest pre != HTTP_OK sendReply");     // Catch: Exception -> L29
    L18:
        r2.sendReply(r11);     // Catch: Exception -> L29
        return;
    L20:
        if (r2.isAborted == false) goto L22;
        return;
    L22:
        if (r2.finalBitSet == true) goto L27;
        if (V == false) goto L26;
        Log.v(TAG, "handlePutRequest pre looped sendReply");     // Catch: Exception -> L29
    L26:
        r2.sendReply(144);     // Catch: Exception -> L29
        goto L22
    L27:
        r2.sendReply(r11);     // Catch: Exception -> L29
        return;
    L9:
        if (r2.isValidBody() == true) goto L11;
        r11 = validateResponseCode(this.mListener.onDelete(r2.requestHeader, r2.replyHeader));     // Catch: Exception -> L29
        goto L13
    }

    private void handleGetRequest(int r9) throws IOException {
        if (V == false) goto L5;
        Log.v(TAG, "handleGetRequest");
    L5:
        ServerOperation r0 = new ServerOperation(this, this.mInput, r9, this.mMaxPacketLength, this.mListener);
        int r10 = validateResponseCode(this.mListener.onGet(r0));     // Catch: Exception -> L10
        if (r0.isAborted == true) goto L18;
        r0.sendReply(r10);     // Catch: Exception -> L10
        return;
    L18:
        return;
    L10:
        e = move-exception;
        if (V == false) goto L14;
        Log.d(TAG, "Exception occured - sending OBEX_HTTP_INTERNAL_ERROR reply", e);
    L14:
        sendResponse(208, null);
    }

    public void sendResponse(int r9, byte[] r10) throws IOException {
        boolean r0 = V;
        if (r0 == false) goto L5;
        Log.v(TAG, "sendResponse code " + r9 + " header : " + r10);
    L5:
        OutputStream r8 = this.mOutput;
        if (r8 != null) goto L9;
        return;
    L9:
        if (r10 == null) goto L14;
        int r6 = r10.length + 3;
        if (r0 == false) goto L13;
        Log.v(TAG, "header != null totalLength = " + r6);
    L13:
        byte[] r1 = new byte[r6];
        r1[0] = (byte) r9;
        r1[1] = (byte) (r6 >> 8);
        r1[2] = (byte) r6;
        System.arraycopy(r10, 0, r1, 3, r10.length);
    L15:
        r8.write(r1);
        r8.flush();
        return;
    L14:
        r1 = new byte[]{(byte) r9, 0, (byte) 3};
        goto L15
    }

    private void handleSetPathRequest() throws IOException {
        HeaderSet r0 = new HeaderSet();
        HeaderSet r2 = new HeaderSet();
        int r3 = (this.mInput.read() << 8) + this.mInput.read();
        int r4 = this.mInput.read();
        this.mInput.read();
        byte[] r10 = null;
        if (r3 <= ObexHelper.getMaxRxPacketSize(this.mTransport)) goto L7;
        int r1 = 206;
    L5:
        int r5 = 3;
    L58:
        byte[] r6 = new byte[r5];
        r6[0] = (byte) r1;
        r6[1] = (byte) (r5 >> 8);
        r6[2] = (byte) r5;
        if (r10 == null) goto L61;
        System.arraycopy(r10, 0, r6, 3, r10.length);
    L61:
        this.mOutput.write(r6);
        this.mOutput.flush();
        return;
    L7:
        if (r3 <= 5) goto L24;
        int r7 = r3 - 5;
        byte[] r13 = new byte[r7];
        int r15 = this.mInput.read(r13);
    L9:
        if (r15 == r7) goto L11;
        r15 = r15 + this.mInput.read(r13, r15, r7 - r15);
        goto L9
    L11:
        ObexHelper.updateHeaderSet(r0, r13);
        if (this.mListener.getConnectionId() != (-1)) goto L14;
    L16:
        this.mListener.setConnectionId(1);
    L18:
        if (r0.mAuthResp == null) goto L24;
        if (handleAuthResp(r0.mAuthResp) == true) goto L22;
        this.mListener.onAuthenticationFailure(ObexHelper.getTagValue((byte) 1, r0.mAuthResp));
        int r14 = 193;
    L23:
        r0.mAuthResp = null;
    L25:
        if (r14 != 193) goto L27;
        r1 = r14;
        goto L5
    L27:
        if (r0.mAuthChall == null) goto L30;
        handleAuthChall(r0);
        r2.mAuthResp = new byte[r0.mAuthResp.length];
        System.arraycopy(r0.mAuthResp, 0, r2.mAuthResp, 0, r2.mAuthResp.length);
        r0.mAuthChall = null;
        r0.mAuthResp = null;
    L30:
        if ((r4 & 1) == 0) goto L32;
        boolean r8 = true;
    L34:
        if ((r4 & 2) == 0) goto L36;
        boolean r9 = false;
    L63:
        r1 = validateResponseCode(this.mListener.onSetPath(r0, r2, r8, r9));
        if (r2.nonce == null) goto L42;
        this.mChallengeDigest = new byte[16];
        System.arraycopy(r2.nonce, 0, this.mChallengeDigest, 0, 16);
    L43:
        long r11 = this.mListener.getConnectionId();
        if (r11 != (-1)) goto L46;
        r2.mConnectionID = null;
    L47:
        byte[] r12 = ObexHelper.createHeader(r2, false);
        int r16 = r12.length + 3;
        if (r16 <= this.mMaxPacketLength) goto L50;
        r1 = 208;
        goto L5
    L50:
        r10 = r12;
        r5 = r16;
        goto L58
    L46:
        r2.mConnectionID = ObexHelper.convertToByteArray(r11);
        goto L47
    L42:
        this.mChallengeDigest = null;
    L51:
        e = move-exception;
        if (V == false) goto L55;
        Log.d(TAG, "Exception occured - sending OBEX_HTTP_INTERNAL_ERROR reply", e);
    L55:
        sendResponse(208, null);
        return;
    L36:
        r9 = true;
        goto L63
    L32:
        r8 = false;
        goto L34
    L22:
        r14 = -1;
        goto L23
    L14:
        if (r0.mConnectionID == null) goto L16;
        this.mListener.setConnectionId(ObexHelper.convertToLong(r0.mConnectionID));
    L24:
        r14 = -1;
        goto L25
    }

    private void handleDisconnectRequest() throws IOException {
        HeaderSet r0 = new HeaderSet();
        HeaderSet r1 = new HeaderSet();
        int r2 = (this.mInput.read() << 8) + this.mInput.read();
        byte[] r7 = null;
        if (r2 <= ObexHelper.getMaxRxPacketSize(this.mTransport)) goto L6;
        int r3 = 206;
    L5:
        int r4 = 3;
    L45:
        if (r7 == null) goto L47;
        byte[] r5 = new byte[r7.length + 3];
    L48:
        r5[0] = (byte) r3;
        r5[1] = (byte) (r4 >> 8);
        r5[2] = (byte) r4;
        if (r7 == null) goto L51;
        System.arraycopy(r7, 0, r5, 3, r7.length);
    L51:
        this.mOutput.write(r5);
        this.mOutput.flush();
        return;
    L47:
        r5 = new byte[3];
        goto L48
    L6:
        if (r2 <= 3) goto L12;
        int r6 = r2 - 3;
        byte[] r8 = new byte[r6];
        int r9 = this.mInput.read(r8);
    L8:
        if (r9 == r6) goto L10;
        r9 = r9 + this.mInput.read(r8, r9, r6 - r9);
        goto L8
    L10:
        ObexHelper.updateHeaderSet(r0, r8);
    L12:
        if (this.mListener.getConnectionId() != (-1)) goto L14;
    L16:
        this.mListener.setConnectionId(1);
    L17:
        int r10 = 160;
        if (r0.mAuthResp != null) goto L20;
    L23:
        if (r10 != 193) goto L25;
        r4 = 3;
    L44:
        r3 = r10;
        goto L45
    L25:
        if (r0.mAuthChall == null) goto L53;
        handleAuthChall(r0);
        r0.mAuthChall = null;
    L53:
        this.mListener.onDisconnect(r0, r1);     // Catch: Exception -> L37
        long r11 = this.mListener.getConnectionId();
        if (r11 != (-1)) goto L32;
        r1.mConnectionID = null;
    L33:
        byte[] r12 = ObexHelper.createHeader(r1, false);
        r4 = r12.length + 3;
        if (r4 <= this.mMaxPacketLength) goto L36;
        r3 = 208;
        goto L5
    L36:
        r7 = r12;
        goto L44
    L32:
        r1.mConnectionID = ObexHelper.convertToByteArray(r11);
    L37:
        e = move-exception;
        if (V == false) goto L41;
        Log.d(TAG, "Exception occured - sending OBEX_HTTP_INTERNAL_ERROR reply", e);
    L41:
        sendResponse(208, null);
        return;
    L20:
        if (handleAuthResp(r0.mAuthResp) == true) goto L22;
        this.mListener.onAuthenticationFailure(ObexHelper.getTagValue((byte) 1, r0.mAuthResp));
        r10 = 193;
    L22:
        r0.mAuthResp = null;
        goto L23
    L14:
        if (r0.mConnectionID == null) goto L16;
        this.mListener.setConnectionId(ObexHelper.convertToLong(r0.mConnectionID));
        goto L17
    }

    private void handleConnectRequest() throws IOException {
        HeaderSet r0 = new HeaderSet();
        HeaderSet r1 = new HeaderSet();
        boolean r2 = V;
        if (r2 == false) goto L5;
        Log.v(TAG, "handleConnectRequest()");
    L5:
        int r4 = (this.mInput.read() << 8) + this.mInput.read();
        if (r2 == false) goto L8;
        Log.v(TAG, "handleConnectRequest() - packetLength: " + r4);
    L8:
        int r5 = this.mInput.read();
        int r6 = this.mInput.read();
        int r7 = this.mInput.read();
        this.mMaxPacketLength = r7;
        this.mMaxPacketLength = (r7 << 8) + this.mInput.read();
        if (r2 == false) goto L12;
        Log.v(TAG, "handleConnectRequest() - version: " + r5 + " MaxLength: " + this.mMaxPacketLength + " flags: " + r6);
    L12:
        if (this.setMTU == false) goto L15;
        this.mMaxPacketLength = 8192;
        this.setMTU = false;
    L23:
        Log.d(TAG, "handleConnectRequest() - Updated MaxPacketLengh: " + this.mMaxPacketLength);
        if (this.mMaxPacketLength <= ObexHelper.getMaxTxPacketSize(this.mTransport)) goto L26;
        Log.w(TAG, "Requested MaxObexPacketSize " + this.mMaxPacketLength + " is larger than the max size supported by the transport: " + ObexHelper.getMaxTxPacketSize(this.mTransport) + " Reducing to this size.");
        this.mMaxPacketLength = ObexHelper.getMaxTxPacketSize(this.mTransport);
    L26:
        byte[] r9 = null;
        if (r4 <= ObexHelper.getMaxRxPacketSize(this.mTransport)) goto L30;
        int r3 = 206;
    L29:
        int r8 = 7;
    L70:
        byte[] r10 = ObexHelper.convertToByteArray(r8);
        byte[] r11 = new byte[r8];
        int r12 = ObexHelper.getMaxRxPacketSize(this.mTransport);
        if (r12 > this.mMaxPacketLength) goto L73;
    L76:
        r11[0] = (byte) r3;
        r11[1] = r10[2];
        r11[2] = r10[3];
        r11[3] = 16;
        r11[4] = 0;
        r11[5] = (byte) (r12 >> 8);
        r11[6] = (byte) (r12 & 255);
        if (r9 == null) goto L79;
        System.arraycopy(r9, 0, r11, 7, r9.length);
    L79:
        this.mOutput.write(r11);
        this.mOutput.flush();
        return;
    L73:
        if (V == false) goto L75;
        Log.v(TAG, "Set maxRxLength to min of maxRxServrLen:" + r12 + " and MaxNegotiated from Client: " + this.mMaxPacketLength);
    L75:
        r12 = this.mMaxPacketLength;
        goto L76
    L30:
        if (r4 <= 7) goto L36;
        int r13 = r4 - 7;
        byte[] r14 = new byte[r13];
        int r15 = this.mInput.read(r14);
    L32:
        if (r15 == r13) goto L34;
        r15 = r15 + this.mInput.read(r14, r15, r13 - r15);
        goto L32
    L34:
        ObexHelper.updateHeaderSet(r0, r14);
    L36:
        if (this.mListener.getConnectionId() != (-1)) goto L38;
    L40:
        this.mListener.setConnectionId(1);
    L41:
        int r16 = -1;
        if (r0.mAuthResp != null) goto L44;
    L47:
        if (r16 != 193) goto L49;
        r8 = 7;
        r3 = r16;
        goto L70
    L49:
        if (r0.mAuthChall == null) goto L81;
        handleAuthChall(r0);
        r1.mAuthResp = new byte[r0.mAuthResp.length];
        System.arraycopy(r0.mAuthResp, 0, r1.mAuthResp, 0, r1.mAuthResp.length);
        r0.mAuthChall = null;
        r0.mAuthResp = null;
    L81:
        r3 = validateResponseCode(this.mListener.onConnect(r0, r1));     // Catch: Exception -> L64
        if (r1.nonce == null) goto L55;
        this.mChallengeDigest = new byte[16];     // Catch: Exception -> L64
        System.arraycopy(r1.nonce, 0, this.mChallengeDigest, 0, 16);     // Catch: Exception -> L64
    L56:
        long r17 = this.mListener.getConnectionId();     // Catch: Exception -> L64
        if (r17 != (-1)) goto L59;
        r1.mConnectionID = null;     // Catch: Exception -> L64
    L60:
        byte[] r18 = ObexHelper.createHeader(r1, false);     // Catch: Exception -> L64
        r8 = r18.length + 7;     // Catch: Exception -> L64
        if (r8 > this.mMaxPacketLength) goto L68;
        r9 = r18;
    L68:
        r3 = 208;
        goto L29
    L59:
        r1.mConnectionID = ObexHelper.convertToByteArray(r17);     // Catch: Exception -> L64
        goto L60
    L55:
        this.mChallengeDigest = null;     // Catch: Exception -> L64
    L64:
        e = move-exception;
        if (V == false) goto L68;
        Log.d(TAG, "Exception occured - sending OBEX_HTTP_INTERNAL_ERROR reply", e);
        goto L68
    L44:
        if (handleAuthResp(r0.mAuthResp) == true) goto L46;
        this.mListener.onAuthenticationFailure(ObexHelper.getTagValue((byte) 1, r0.mAuthResp));
        r16 = 193;
    L46:
        r0.mAuthResp = null;
        goto L47
    L38:
        if (r0.mConnectionID == null) goto L40;
        this.mListener.setConnectionId(ObexHelper.convertToLong(r0.mConnectionID));
        goto L41
    L15:
        if (this.updateMtu == false) goto L21;
        Log.d(TAG, "mMaxPacketLength: " + this.mMaxPacketLength + ", updatedMtuSize: " + this.updatedMtuSize);
        int r19 = this.mMaxPacketLength;
        int r20 = this.updatedMtuSize;
        if (r19 <= r20) goto L19;
        this.mMaxPacketLength = r20;
    L19:
        this.updateMtu = false;
        goto L23
    L21:
        if (this.mMaxPacketLength <= 65534) goto L23;
        this.mMaxPacketLength = ObexHelper.MAX_PACKET_SIZE_INT;
        goto L23
    }

    public synchronized void close() {
        monitor-enter(this);
        ServerRequestHandler r0 = this.mListener;     // Catch: Throwable -> L24
        if (r0 == null) goto L29;
        r0.onClose();     // Catch: Throwable -> L24
    L29:
        this.mClosed = true;     // Catch: Exception -> L17 Throwable -> L24
        InputStream r1 = this.mInput;     // Catch: Exception -> L17 Throwable -> L24
        if (r1 == null) goto L10;
        r1.close();     // Catch: Exception -> L17 Throwable -> L24
    L10:
        OutputStream r2 = this.mOutput;     // Catch: Exception -> L17 Throwable -> L24
        if (r2 == null) goto L13;
        r2.close();     // Catch: Exception -> L17 Throwable -> L24
    L13:
        ObexTransport r3 = this.mTransport;     // Catch: Exception -> L17 Throwable -> L24
        if (r3 == null) goto L21;
        r3.close();     // Catch: Exception -> L17 Throwable -> L24
    L21:
        this.mTransport = null;     // Catch: Throwable -> L24
        this.mInput = null;     // Catch: Throwable -> L24
        this.mOutput = null;     // Catch: Throwable -> L24
        this.mListener = null;     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L17:
        e = move-exception;
        if (V == false) goto L21;
        Log.d(TAG, "Exception occured during close() - ignore", e);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public ObexTransport getTransport() {
        return this.mTransport;
    }
}
