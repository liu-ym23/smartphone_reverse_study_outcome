package javax.obex;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class ClientSession extends ObexSession {
    private static final String TAG = "ObexClientSession";
    private byte[] mConnectionId;
    private final InputStream mInput;
    private boolean mLocalSrmSupported;
    private int mMaxTxPacketSize;
    private boolean mObexConnected;
    private boolean mOpen;
    private final OutputStream mOutput;
    private boolean mRequestActive;
    private final ObexTransport mTransport;

    public ClientSession(ObexTransport r2) throws IOException {
        this.mConnectionId = null;
        this.mMaxTxPacketSize = 255;
        this.mInput = r2.openInputStream();
        this.mOutput = r2.openOutputStream();
        this.mOpen = true;
        this.mRequestActive = false;
        this.mLocalSrmSupported = r2.isSrmSupported();
        this.mTransport = r2;
    }

    public ClientSession(ObexTransport r2, boolean r3) throws IOException {
        this.mConnectionId = null;
        this.mMaxTxPacketSize = 255;
        this.mInput = r2.openInputStream();
        this.mOutput = r2.openOutputStream();
        this.mOpen = true;
        this.mRequestActive = false;
        this.mLocalSrmSupported = r3;
        this.mTransport = r2;
    }

    public HeaderSet connect(HeaderSet r11) throws IOException {
        ensureOpen();
        if (this.mObexConnected == true) goto L24;
        setRequestActive();
        if (r11 != null) goto L7;
        byte[] r12 = null;
        int r3 = 4;
    L11:
        byte[] r6 = new byte[r3];
        int r4 = ObexHelper.getMaxRxPacketSize(this.mTransport);
        r6[0] = 16;
        r6[1] = 0;
        r6[2] = (byte) (r4 >> 8);
        r6[3] = (byte) (r4 & 255);
        if (r12 == null) goto L15;
        System.arraycopy(r12, 0, r6, 4, r12.length);
    L15:
        if ((r3 + 3) > 65534) goto L22;
        HeaderSet r13 = new HeaderSet();
        sendRequest(128, r6, r13, null, false);
        if (r13.responseCode != 160) goto L19;
        this.mObexConnected = true;
    L19:
        setRequestInactive();
        return r13;
    L22:
        throw new IOException("Packet size exceeds max packet size for connect");
    L7:
        if (r11.nonce == null) goto L9;
        this.mChallengeDigest = new byte[16];
        System.arraycopy(r11.nonce, 0, this.mChallengeDigest, 0, 16);
    L9:
        r12 = ObexHelper.createHeader(r11, false);
        r3 = r12.length + 4;
        goto L11
    L24:
        throw new IOException("Already connected to server");
    }

    public Operation get(HeaderSet r5) throws IOException {
        if (this.mObexConnected == false) goto L19;
        setRequestActive();
        ensureOpen();
        if (r5 != null) goto L8;
        r5 = new HeaderSet();
    L11:
        if (this.mConnectionId == null) goto L14;
        r5.mConnectionID = new byte[4];
        System.arraycopy(this.mConnectionId, 0, r5.mConnectionID, 0, 4);
    L14:
        if (this.mLocalSrmSupported == false) goto L17;
        r5.setHeader(151, (byte) 1);
    L17:
        return new ClientOperation(this.mMaxTxPacketSize, this, r5, true);
    L8:
        if (r5.nonce == null) goto L11;
        this.mChallengeDigest = new byte[16];
        System.arraycopy(r5.nonce, 0, this.mChallengeDigest, 0, 16);
        goto L11
    L19:
        throw new IOException("Not connected to the server");
    }

    public void setConnectionID(long r3) {
        if (r3 < 0) goto L9;
        if (r3 > 4294967295L) goto L9;
        this.mConnectionId = ObexHelper.convertToByteArray(r3);
        return;
    L9:
        throw new IllegalArgumentException("Connection ID is not in a valid range");
    }

    public HeaderSet delete(HeaderSet r1) throws IOException {
        Operation r0 = put(r1);
        r0.getResponseCode();
        HeaderSet r2 = r0.getReceivedHeader();
        r0.close();
        return r2;
    }

    public HeaderSet disconnect(HeaderSet r9) throws IOException {
        if (this.mObexConnected == false) goto L31;
        setRequestActive();
        ensureOpen();
        if (r9 != null) goto L7;
        byte[] r10 = this.mConnectionId;
        if (r10 == null) goto L20;
        byte[] r2 = new byte[5];
        r2[0] = -53;
        System.arraycopy(r10, 0, r2, 1, 4);
        byte[] r4 = r2;
    L22:
        HeaderSet r11 = new HeaderSet();
        sendRequest(129, r4, r11, null, false);
        monitor-enter(this);
        this.mObexConnected = false;     // Catch: Throwable -> L27
        setRequestInactive();     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        return r11;
    L27:
        th = move-exception;
        throw th;
    L20:
        byte[] r12 = null;
    L21:
        r4 = r12;
        goto L22
    L7:
        if (r9.nonce == null) goto L10;
        this.mChallengeDigest = new byte[16];
        System.arraycopy(r9.nonce, 0, this.mChallengeDigest, 0, 16);
    L10:
        if (this.mConnectionId == null) goto L12;
        r9.mConnectionID = new byte[4];
        System.arraycopy(this.mConnectionId, 0, r9.mConnectionID, 0, 4);
    L12:
        r12 = ObexHelper.createHeader(r9, false);
        if ((r12.length + 3) <= this.mMaxTxPacketSize) goto L21;
        throw new IOException("Packet size exceeds max packet size");
    L31:
        throw new IOException("Not connected to the server");
    }

    public long getConnectionID() {
        byte[] r2 = this.mConnectionId;
        if (r2 != null) goto L7;
        return -1;
    L7:
        return ObexHelper.convertToLong(r2);
    }

    public Operation put(HeaderSet r5) throws IOException {
        if (this.mObexConnected == false) goto L19;
        setRequestActive();
        ensureOpen();
        if (r5 != null) goto L8;
        r5 = new HeaderSet();
    L11:
        if (this.mConnectionId == null) goto L14;
        r5.mConnectionID = new byte[4];
        System.arraycopy(this.mConnectionId, 0, r5.mConnectionID, 0, 4);
    L14:
        if (this.mLocalSrmSupported == false) goto L17;
        r5.setHeader(151, (byte) 1);
    L17:
        return new ClientOperation(this.mMaxTxPacketSize, this, r5, false);
    L8:
        if (r5.nonce == null) goto L11;
        this.mChallengeDigest = new byte[16];
        System.arraycopy(r5.nonce, 0, this.mChallengeDigest, 0, 16);
        goto L11
    L19:
        throw new IOException("Not connected to the server");
    }

    public void setAuthenticator(Authenticator r1) throws IOException {
        if (r1 == null) goto L6;
        this.mAuthenticator = r1;
        return;
    L6:
        throw new IOException("Authenticator may not be null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HeaderSet setPath(HeaderSet r11, boolean r12, boolean r13) throws IOException {
        if (this.mObexConnected == false) goto L28;
        setRequestActive();
        ensureOpen();
        if (r11 != null) goto L8;
        r11 = new HeaderSet();
    L11:
        if (r11.nonce == null) goto L14;
        this.mChallengeDigest = new byte[16];
        System.arraycopy(r11.nonce, 0, this.mChallengeDigest, 0, 16);
    L14:
        if (this.mConnectionId == null) goto L16;
        r11.mConnectionID = new byte[4];
        System.arraycopy(this.mConnectionId, 0, r11.mConnectionID, 0, 4);
    L16:
        byte[] r0 = ObexHelper.createHeader(r11, false);
        int r2 = r0.length + 2;
        int r14 = r12;
        if (r2 > this.mMaxTxPacketSize) goto L26;
        if (r13 == true) goto L20;
        r14 = (r12 ? 1 : 0) | 2;
    L20:
        byte[] r6 = new byte[r2];
        r6[0] = (byte) r14;
        r6[1] = 0;
        if (r11 == null) goto L23;
        System.arraycopy(r0, 0, r6, 2, r0.length);
    L23:
        HeaderSet r15 = new HeaderSet();
        sendRequest(133, r6, r15, null, false);
        setRequestInactive();
        return r15;
    L26:
        throw new IOException("Packet size exceeds max packet size");
    L8:
        if (r11.nonce == null) goto L11;
        this.mChallengeDigest = new byte[16];
        System.arraycopy(r11.nonce, 0, this.mChallengeDigest, 0, 16);
        goto L11
    L28:
        throw new IOException("Not connected to the server");
    }

    public synchronized void ensureOpen() throws IOException {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mOpen == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        throw new IOException("Connection closed");     // Catch: Throwable -> L9
    }

    synchronized void setRequestInactive() {
        monitor-enter(this);
        this.mRequestActive = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private synchronized void setRequestActive() throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mRequestActive == true) goto L9;
        this.mRequestActive = true;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException("OBEX request is already being performed");     // Catch: Throwable -> L10
    }

    public boolean sendRequest(int r14, byte[] r15, HeaderSet r16, PrivateInputStream r17, boolean r18) throws IOException {
        if (r15 == null) goto L10;
        if ((r15.length + 3) <= 65534) goto L10;
        throw new IOException("header too large ");
    L10:
        if (r18 == true) goto L12;
    L19:
        boolean r8 = false;
        boolean r9 = false;
    L20:
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        r10.write((byte) r14);
        if (r15 != null) goto L23;
        r10.write(0);
        r10.write(3);
    L24:
        if (r8 == true) goto L26;
        this.mOutput.write(r10.toByteArray());
        this.mOutput.flush();
    L26:
        if (r9 == true) goto L74;
        r16.responseCode = this.mInput.read();
        int r2 = (this.mInput.read() << 8) | this.mInput.read();
        if (r2 > ObexHelper.getMaxRxPacketSize(this.mTransport)) goto L73;
        if (r2 <= 3) goto L74;
        if (r14 != 128) goto L44;
        this.mInput.read();
        this.mInput.read();
        int r11 = (this.mInput.read() << 8) + this.mInput.read();
        this.mMaxTxPacketSize = r11;
        if (r11 <= 64512) goto L36;
        this.mMaxTxPacketSize = ObexHelper.MAX_CLIENT_PACKET_SIZE;
    L36:
        if (this.mMaxTxPacketSize <= ObexHelper.getMaxTxPacketSize(this.mTransport)) goto L39;
        Log.w(TAG, "An OBEX packet size of " + this.mMaxTxPacketSize + "was requested. Transport only allows: " + ObexHelper.getMaxTxPacketSize(this.mTransport) + " Lowering limit to this value.");
        this.mMaxTxPacketSize = ObexHelper.getMaxTxPacketSize(this.mTransport);
    L39:
        if (r2 <= 7) goto L43;
        int r3 = r2 - 7;
        byte[] r12 = new byte[r3];
        int r13 = this.mInput.read(r12);
    L41:
        if (r13 == r3) goto L50;
        r13 = r13 + this.mInput.read(r12, r13, r3 - r13);
    L50:
        byte[] r4 = ObexHelper.updateHeaderSet(r16, r12);
        if (r17 == null) goto L55;
        if (r4 == null) goto L55;
        r17.writeBytes(r4, 1);
    L55:
        if (r16.mConnectionID == null) goto L58;
        this.mConnectionId = new byte[4];
        System.arraycopy(r16.mConnectionID, 0, this.mConnectionId, 0, 4);
    L58:
        if (r16.mAuthResp == null) goto L65;
        if (handleAuthResp(r16.mAuthResp) == true) goto L65;
        setRequestInactive();
        throw new IOException("Authentication Failed");
    L65:
        if (r16.responseCode != 193) goto L74;
        if (r16.mAuthChall == null) goto L74;
        if (handleAuthChall(r16) == false) goto L74;
        r10.write(78);
        r10.write((byte) ((r16.mAuthResp.length + 3) >> 8));
        r10.write((byte) (r16.mAuthResp.length + 3));
        r10.write(r16.mAuthResp);
        r16.mAuthChall = null;
        r16.mAuthResp = null;
        int r5 = r10.size() - 3;
        byte[] r7 = new byte[r5];
        System.arraycopy(r10.toByteArray(), 3, r7, 0, r5);
        return sendRequest(r14, r7, r16, r17, false);
    L43:
        return true;
    L44:
        int r6 = r2 - 3;
        r12 = new byte[r6];
        int r19 = this.mInput.read(r12);
    L45:
        if (r19 == r6) goto L48;
        r19 = r19 + this.mInput.read(r12, r19, r6 - r19);
        goto L45
    L48:
        if (r14 != 255) goto L50;
        return true;
    L73:
        throw new IOException("Packet received exceeds packet size limit");
    L74:
        return true;
    L23:
        r10.write((byte) ((r15.length + 3) >> 8));
        r10.write((byte) (r15.length + 3));
        r10.write(r15);
        goto L24
    L12:
        if (r14 != 2) goto L14;
    L13:
        r8 = false;
        r9 = true;
        goto L20
    L14:
        if (r14 == 3) goto L13;
        if (r14 != 131) goto L19;
        r9 = false;
        r8 = true;
        goto L20
    }

    public void close() throws IOException {
        this.mOpen = false;
        this.mInput.close();
        this.mOutput.close();
    }

    public boolean isSrmSupported() {
        return this.mLocalSrmSupported;
    }

    public void setLocalSrmStatus(boolean r1) {
        this.mLocalSrmSupported = r1;
    }
}
