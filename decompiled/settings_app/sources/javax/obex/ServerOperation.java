package javax.obex;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class ServerOperation implements Operation, BaseStream {
    private static final String TAG = "ObexServerOperation";
    private static final boolean V = false;
    public boolean finalBitSet;
    public boolean isAborted;
    private boolean mClosed;
    private String mExceptionString;
    private boolean mGetOperation;
    private boolean mHasBody;
    private InputStream mInput;
    private ServerRequestHandler mListener;
    private int mMaxPacketLength;
    private ServerSession mParent;
    private PrivateInputStream mPrivateInput;
    private PrivateOutputStream mPrivateOutput;
    private boolean mPrivateOutputOpen;
    private boolean mRequestFinished;
    private int mResponseSize;
    private boolean mSendBodyHeader;
    private boolean mSrmActive;
    private boolean mSrmEnabled;
    private boolean mSrmLocalWait;
    private boolean mSrmResponseSent;
    private boolean mSrmWaitingForRemote;
    private ObexTransport mTransport;
    public HeaderSet replyHeader;
    public HeaderSet requestHeader;

    @Override // javax.obex.BaseStream
    public void ensureNotDone() throws IOException {
    }

    @Override // javax.obex.Operation
    public String getEncoding() {
        return null;
    }

    @Override // javax.obex.BaseStream
    public void streamClosed(boolean r1) throws IOException {
    }

    static {
        V = ObexHelper.VDBG;
    }

    public ServerOperation(ServerSession r6, InputStream r7, int r8, int r9, ServerRequestHandler r10) throws IOException {
        this.mSendBodyHeader = true;
        this.mSrmEnabled = false;
        this.mSrmActive = false;
        this.mSrmResponseSent = false;
        this.mSrmWaitingForRemote = true;
        this.mSrmLocalWait = false;
        boolean r2 = V;
        if (r2 == false) goto L5;
        Log.v(TAG, "ServerOperation");
    L5:
        this.isAborted = false;
        this.mParent = r6;
        this.mInput = r7;
        this.mMaxPacketLength = r9;
        this.mClosed = false;
        this.requestHeader = new HeaderSet();
        this.replyHeader = new HeaderSet();
        this.mPrivateInput = new PrivateInputStream(this);
        this.mResponseSize = 3;
        this.mListener = r10;
        this.mRequestFinished = false;
        this.mPrivateOutputOpen = false;
        this.mHasBody = false;
        this.mTransport = r6.getTransport();
        if (r8 != 2) goto L8;
    L19:
        this.mGetOperation = false;
        if ((r8 & 128) != 0) goto L22;
        this.finalBitSet = false;
    L23:
        ObexPacket r11 = ObexPacket.read(r8, this.mInput);
        if (r11.mLength <= ObexHelper.getMaxRxPacketSize(this.mTransport)) goto L26;
        this.mParent.sendResponse(206, null);
        throw new IOException("Packet received was too large. Length: " + r11.mLength + " maxLength: " + ObexHelper.getMaxRxPacketSize(this.mTransport));
    L26:
        if (r11.mLength <= 3) goto L43;
        if (handleObexPacket(r11) == true) goto L30;
        return;
    L30:
        if (r2 == false) goto L33;
        Log.v(TAG, "Get App confirmation if SRM ENABLED case: " + this.mSrmEnabled + " not hasBody case: " + this.mHasBody);
    L33:
        if (this.mHasBody == true) goto L43;
        if (this.mSrmEnabled == true) goto L43;
    L37:
        if (this.mGetOperation == true) goto L43;
        if (this.finalBitSet == true) goto L43;
        sendReply(144);
        if (this.mPrivateInput.available() <= 0) goto L37;
    L43:
        if (V == false) goto L46;
        Log.v(TAG, "Get App confirmation if SRM ENABLED case: " + this.mSrmEnabled + " not finalPacket: " + this.finalBitSet + " not GETOp Case: " + this.mGetOperation);
    L46:
        if (this.mSrmEnabled == true) goto L56;
        if (this.mGetOperation == true) goto L56;
        if (this.finalBitSet == true) goto L56;
        if (this.mPrivateInput.available() != 0) goto L56;
        sendReply(144);
        if (this.mPrivateInput.available() <= 0) goto L46;
    L56:
        if (this.mGetOperation == false) goto L60;
        if (this.mRequestFinished == true) goto L77;
        sendReply(144);
        goto L56
    L77:
        return;
    L60:
        return;
    L22:
        this.finalBitSet = true;
        this.mRequestFinished = true;
        goto L23
    L8:
        if (r8 == 130) goto L19;
        if (r8 == 3) goto L16;
        if (r8 == 131) goto L16;
        throw new IOException("ServerOperation can not handle such request");
    L16:
        this.mGetOperation = true;
        this.finalBitSet = false;
        if (r8 != 131) goto L23;
        this.mRequestFinished = true;
        goto L23
    }

    private boolean handleObexPacket(ObexPacket r7) throws IOException {
        byte[] r8 = updateRequestHeaders(r7);
        if (r8 == null) goto L6;
        this.mHasBody = true;
    L6:
        if (this.mListener.getConnectionId() != (-1)) goto L8;
    L10:
        this.mListener.setConnectionId(1);
    L12:
        if (this.requestHeader.mAuthResp == null) goto L19;
        if (this.mParent.handleAuthResp(this.requestHeader.mAuthResp) == true) goto L17;
        this.mExceptionString = "Authentication Failed";
        this.mParent.sendResponse(193, null);
        this.mClosed = true;
        this.requestHeader.mAuthResp = null;
        return false;
    L17:
        this.requestHeader.mAuthResp = null;
    L19:
        if (this.requestHeader.mAuthChall == null) goto L21;
        this.mParent.handleAuthChall(this.requestHeader);
        HeaderSet r1 = this.replyHeader;
        r1.mAuthResp = new byte[this.requestHeader.mAuthResp.length];
        System.arraycopy(this.requestHeader.mAuthResp, 0, this.replyHeader.mAuthResp, 0, this.replyHeader.mAuthResp.length);
        this.requestHeader.mAuthResp = null;
        this.requestHeader.mAuthChall = null;
    L21:
        if (r8 == null) goto L23;
        this.mPrivateInput.writeBytes(r8, 1);
    L23:
        return true;
    L8:
        if (this.requestHeader.mConnectionID == null) goto L10;
        this.mListener.setConnectionId(ObexHelper.convertToLong(this.requestHeader.mConnectionID));
        goto L12
    }

    private byte[] updateRequestHeaders(ObexPacket r6) throws IOException {
        if (r6.mPayload == null) goto L5;
        byte[] r0 = ObexHelper.updateHeaderSet(this.requestHeader, r6.mPayload);
    L6:
        Byte r1 = (Byte) this.requestHeader.getHeader(151);
        if (this.mTransport.isSrmSupported() == false) goto L14;
        if (r1 == null) goto L14;
        if (r1.byteValue() != 1) goto L14;
        this.mSrmEnabled = true;
        if (V == false) goto L14;
        Log.d(TAG, "SRM is now ENABLED (but not active) for this operation");
    L14:
        checkForSrmWait(r6.mHeaderId);
        if (this.mSrmWaitingForRemote == false) goto L17;
    L22:
        return r0;
    L17:
        if (this.mSrmEnabled == false) goto L22;
        if (V == false) goto L21;
        Log.d(TAG, "SRM is now ACTIVE for this operation");
    L21:
        this.mSrmActive = true;
        goto L22
    L5:
        r0 = null;
        goto L6
    }

    private void checkForSrmWait(int r3) {
        if (this.mSrmEnabled == true) goto L5;
        return;
    L5:
        if (r3 == 3) goto L22;
        if (r3 == 131) goto L22;
        if (r3 == 2) goto L22;
        return;
    L22:
        this.mSrmWaitingForRemote = false;     // Catch: IOException -> L17
        Byte r4 = (Byte) this.requestHeader.getHeader(152);     // Catch: IOException -> L17
        if (r4 != null) goto L14;
        return;
    L14:
        if (r4.byteValue() != 1) goto L27;
        this.mSrmWaitingForRemote = true;     // Catch: IOException -> L17
        this.requestHeader.setHeader(152, null);     // Catch: IOException -> L17
        return;
    L27:
        return;
    L17:
        e = move-exception;
        if (V == false) goto L28;
        Log.w(TAG, "Exception while extracting header", e);
        return;
    }

    public boolean isValidBody() {
        return this.mHasBody;
    }

    @Override // javax.obex.BaseStream
    public synchronized boolean continueOperation(boolean r5, boolean r6) throws IOException {
        monitor-enter(this);
        boolean r7 = V;     // Catch: Throwable -> L35
        if (r7 == false) goto L7;
        Log.v(TAG, "continueOperation");     // Catch: Throwable -> L35
    L7:
        if (this.mGetOperation == false) goto L9;
        if (r7 == false) goto L32;
        Log.v(TAG, "Get continueOperation ");     // Catch: Throwable -> L35
    L32:
        sendReply(144);     // Catch: Throwable -> L35
        monitor-exit(this);
        return true;
    L9:
        if (this.finalBitSet == true) goto L28;
        if (r5 == false) goto L17;
        sendReply(144);     // Catch: Throwable -> L35
        if (r7 == false) goto L14;
        Log.v(TAG, "continueOperation:ServerSet SRM sendEmpty clause");     // Catch: Throwable -> L35
    L14:
        monitor-exit(this);
        return true;
    L17:
        if (this.mResponseSize <= 3) goto L19;
    L23:
        sendReply(144);     // Catch: Throwable -> L35
        if (r7 == false) goto L26;
        Log.v(TAG, "continueOperation: Server setting SRM");     // Catch: Throwable -> L35
    L26:
        monitor-exit(this);
        return true;
    L19:
        if (this.mPrivateOutput.size() > 0) goto L23;
        monitor-exit(this);
        return false;
    L28:
        monitor-exit(this);
        return false;
    L35:
        th = move-exception;
        throw th;
    }

    public synchronized boolean sendReply(int r17) throws IOException {
        monitor-enter(this);
        ByteArrayOutputStream r4 = new ByteArrayOutputStream();     // Catch: Throwable -> L149
        long r5 = this.mListener.getConnectionId();     // Catch: Throwable -> L149
        if (r5 != (-1)) goto L7;
        this.replyHeader.mConnectionID = null;     // Catch: Throwable -> L149
    L9:
        if (this.mSrmEnabled == true) goto L11;
    L16:
        boolean r6 = false;
    L18:
        if (this.mSrmEnabled == true) goto L20;
    L24:
        byte[] r7 = ObexHelper.createHeader(this.replyHeader, true);     // Catch: Throwable -> L149
        PrivateOutputStream r10 = this.mPrivateOutput;     // Catch: Throwable -> L149
        if (r10 == null) goto L27;
        int r11 = r10.size();     // Catch: Throwable -> L149
    L28:
        int r12 = r11;
        boolean r13 = V;     // Catch: Throwable -> L149
        if (r13 == false) goto L32;
        Log.v(TAG, "mMaxPcKLen :" + this.mMaxPacketLength + " headerArryLen :" + r7.length);     // Catch: Throwable -> L149
    L32:
        if ((r7.length + 3) <= this.mMaxPacketLength) goto L53;
        int r2 = 0;
    L34:
        int r3 = r2;
        if (r2 == r7.length) goto L48;
        r2 = ObexHelper.findHeaderEnd(r7, r3, this.mMaxPacketLength - 3);     // Catch: Throwable -> L149
        if (r2 == (-1)) goto L38;
        int r8 = r2 - r3;     // Catch: Throwable -> L149
        byte[] r9 = new byte[r8];     // Catch: Throwable -> L149
        System.arraycopy(r7, r3, r9, 0, r8);     // Catch: Throwable -> L149
        this.mParent.sendResponse(r17, r9);     // Catch: Throwable -> L149
        goto L34
    L38:
        this.mClosed = true;     // Catch: Throwable -> L149
        PrivateInputStream r0 = this.mPrivateInput;     // Catch: Throwable -> L149
        if (r0 == null) goto L41;
        r0.close();     // Catch: Throwable -> L149
    L41:
        PrivateOutputStream r1 = this.mPrivateOutput;     // Catch: Throwable -> L149
        if (r1 == null) goto L44;
        r1.close();     // Catch: Throwable -> L149
    L44:
        this.mParent.sendResponse(208, null);     // Catch: Throwable -> L149
        throw new IOException("OBEX Packet exceeds max packet size");     // Catch: Throwable -> L149
    L48:
        if (r11 <= 0) goto L51;
        monitor-exit(this);
        return true;
    L51:
        monitor-exit(this);
        return false;
    L53:
        r4.write(r7);     // Catch: Throwable -> L149
        boolean r14 = this.mGetOperation;     // Catch: Throwable -> L149
        if (r14 == false) goto L58;
        if (r17 != 160) goto L58;
        this.finalBitSet = true;     // Catch: Throwable -> L149
    L58:
        if (this.mSrmActive == false) goto L77;
        if (r14 == true) goto L64;
        if (r17 != 144) goto L64;
        if (this.mSrmResponseSent != true) goto L64;
    L63:
        boolean r15 = false;
        boolean r16 = true;
    L75:
        if (r13 == false) goto L78;
        Log.v(TAG, "type==" + r17 + " skipSend==" + r16 + " skipReceive==" + r15);     // Catch: Throwable -> L149
    L78:
        if (r6 == false) goto L83;
        if (r13 == false) goto L81;
        Log.v(TAG, "SRM Enabled (srmRespSendPending == true)- sending SRM Enable response");     // Catch: Throwable -> L149
    L81:
        this.mSrmResponseSent = true;     // Catch: Throwable -> L149
    L83:
        if (this.finalBitSet == false) goto L85;
    L86:
        if (r11 <= 0) goto L102;
        int r18 = this.mMaxPacketLength;     // Catch: Throwable -> L149
        if (r11 <= ((r18 - r7.length) - 6)) goto L90;
        r11 = (r18 - r7.length) - 6;     // Catch: Throwable -> L149
    L90:
        byte[] r19 = this.mPrivateOutput.readBytes(r11);     // Catch: Throwable -> L149
        if (this.finalBitSet == true) goto L99;
        if (this.mPrivateOutput.isClosed() == true) goto L99;
        if (this.mSendBodyHeader != true) goto L102;
        r4.write(72);     // Catch: Throwable -> L149
        int r110 = r11 + 3;     // Catch: Throwable -> L149
        r4.write((byte) (r110 >> 8));     // Catch: Throwable -> L149
        r4.write((byte) r110);     // Catch: Throwable -> L149
        r4.write(r19);     // Catch: Throwable -> L149
    L99:
        if (this.mSendBodyHeader != true) goto L102;
        r4.write(73);     // Catch: Throwable -> L149
        int r111 = r11 + 3;     // Catch: Throwable -> L149
        r4.write((byte) (r111 >> 8));     // Catch: Throwable -> L149
        r4.write((byte) r111);     // Catch: Throwable -> L149
        r4.write(r19);     // Catch: Throwable -> L149
    L102:
        if (this.finalBitSet == false) goto L108;
        if (r17 != 160) goto L108;
        if (r12 > 0) goto L108;
        if (this.mSendBodyHeader == false) goto L108;
        r4.write(73);     // Catch: Throwable -> L149
        r4.write((byte) 0);     // Catch: Throwable -> L149
        r4.write((byte) 3);     // Catch: Throwable -> L149
    L108:
        if (r16 == true) goto L111;
        this.mResponseSize = 3;     // Catch: Throwable -> L149
        this.mParent.sendResponse(r17, r4.toByteArray());     // Catch: Throwable -> L149
    L111:
        if (r17 == 144) goto L113;
        monitor-exit(this);
        return false;
    L113:
        if (this.mGetOperation == false) goto L116;
        if (r15 == false) goto L116;
        checkSrmRemoteAbort();     // Catch: Throwable -> L149
    L143:
        monitor-exit(this);
        return true;
    L116:
        ObexPacket r20 = ObexPacket.read(this.mInput);     // Catch: Throwable -> L149
        int r21 = r20.mHeaderId;     // Catch: Throwable -> L149
        if (r21 == 2) goto L126;
        if (r21 == 130) goto L126;
        if (r21 == 3) goto L126;
        if (r21 == 131) goto L126;
        if (r21 != 255) goto L124;
        handleRemoteAbort();     // Catch: Throwable -> L149
        goto L143
    L124:
        this.mParent.sendResponse(192, null);     // Catch: Throwable -> L149
        this.mClosed = true;     // Catch: Throwable -> L149
        this.mExceptionString = "Bad Request Received";     // Catch: Throwable -> L149
        throw new IOException("Bad Request Received");     // Catch: Throwable -> L149
    L126:
        if (r21 != 130) goto L128;
        this.finalBitSet = true;     // Catch: Throwable -> L149
    L131:
        if (r20.mLength <= ObexHelper.getMaxRxPacketSize(this.mTransport)) goto L133;
        this.mParent.sendResponse(206, null);     // Catch: Throwable -> L149
        throw new IOException("Packet received was too large");     // Catch: Throwable -> L149
    L133:
        if (r20.mLength > 3) goto L139;
        if (this.mSrmEnabled == false) goto L143;
        if (r20.mLength != 3) goto L143;
    L139:
        if (handleObexPacket(r20) == true) goto L143;
        monitor-exit(this);
        return false;
    L128:
        if (r21 != 131) goto L131;
        this.mRequestFinished = true;     // Catch: Throwable -> L149
        goto L131
    L85:
        if (r7.length >= (this.mMaxPacketLength - 20)) goto L102;
    L64:
        if (r14 == true) goto L66;
    L70:
        if (r14 == true) goto L72;
    L74:
        r16 = false;
        r15 = false;
        goto L75
    L72:
        if (this.mRequestFinished != true) goto L74;
        r16 = false;
        r15 = true;
        goto L75
    L66:
        if (this.mRequestFinished == true) goto L70;
        if (this.mSrmResponseSent != true) goto L70;
    L77:
        r16 = false;
        r15 = false;
        goto L78
    L27:
        r11 = -1;
        goto L28
    L20:
        if (this.mGetOperation == true) goto L24;
        if (this.mSrmLocalWait == false) goto L24;
        this.replyHeader.setHeader(151, (byte) 1);     // Catch: Throwable -> L149
        goto L24
    L11:
        if (this.mSrmResponseSent == true) goto L16;
        if (V == false) goto L15;
        Log.v(TAG, "mSrmEnabled==true, sending SRM enable response.");     // Catch: Throwable -> L149
    L15:
        this.replyHeader.setHeader(151, (byte) 1);     // Catch: Throwable -> L149
        r6 = true;
        goto L18
    L7:
        this.replyHeader.mConnectionID = ObexHelper.convertToByteArray(r5);     // Catch: Throwable -> L149
    L149:
        th = move-exception;
        throw th;
    }

    private void checkSrmRemoteAbort() throws IOException {
        if (this.mInput.available() <= 0) goto L9;
        ObexPacket r0 = ObexPacket.read(this.mInput);
        if (r0.mHeaderId != 255) goto L7;
        handleRemoteAbort();
        return;
    L7:
        Log.w(TAG, "Received unexpected request from client - discarding...\n   headerId: " + r0.mHeaderId + " length: " + r0.mLength);
        return;
    }

    private void handleRemoteAbort() throws IOException {
        this.mParent.sendResponse(160, null);
        this.mClosed = true;
        this.isAborted = true;
        this.mExceptionString = "Abort Received";
        throw new IOException("Abort Received");
    }

    @Override // javax.obex.Operation
    public void abort() throws IOException {
        throw new IOException("Called from a server");
    }

    @Override // javax.obex.Operation
    public HeaderSet getReceivedHeader() throws IOException {
        ensureOpen();
        return this.requestHeader;
    }

    @Override // javax.obex.Operation
    public void sendHeaders(HeaderSet r6) throws IOException {
        ensureOpen();
        if (r6 == null) goto L12;
        int[] r0 = r6.getHeaderList();
        if (r0 == null) goto L10;
        int r1 = 0;
    L8:
        if (r1 >= r0.length) goto L14;
        HeaderSet r2 = this.replyHeader;
        int r3 = r0[r1];
        r2.setHeader(r3, r6.getHeader(r3));
        r1 = r1 + 1;
        goto L8
    L14:
        return;
    L10:
        return;
    L12:
        throw new IOException("Headers may not be null");
    }

    @Override // javax.obex.Operation
    public int getResponseCode() throws IOException {
        throw new IOException("Called from a server");
    }

    @Override // javax.obex.Operation
    public String getType() {
        return (String) this.requestHeader.getHeader(66);
    L4:
        return null;
    }

    @Override // javax.obex.Operation
    public long getLength() {
        Long r3 = (Long) this.requestHeader.getHeader(195);     // Catch: IOException -> L8
        if (r3 != null) goto L6;
        return -1;
    L6:
        return r3.longValue();
    L11:
        return -1;
    }

    @Override // javax.obex.Operation
    public int getMaxPacketSize() {
        return (this.mMaxPacketLength - 6) - getHeaderLength();
    }

    @Override // javax.obex.Operation
    public int getHeaderLength() {
        long r0 = this.mListener.getConnectionId();
        if (r0 != (-1)) goto L5;
        this.replyHeader.mConnectionID = null;
    L7:
        return ObexHelper.createHeader(this.replyHeader, false).length;
    L5:
        HeaderSet r2 = this.replyHeader;
        r2.mConnectionID = ObexHelper.convertToByteArray(r0);
        goto L7
    }

    @Override // javax.obex.Operation
    public InputStream openInputStream() throws IOException {
        ensureOpen();
        return this.mPrivateInput;
    }

    @Override // javax.obex.Operation
    public DataInputStream openDataInputStream() throws IOException {
        return new DataInputStream(openInputStream());
    }

    @Override // javax.obex.Operation
    public OutputStream openOutputStream() throws IOException {
        ensureOpen();
        if (this.mPrivateOutputOpen == true) goto L14;
        if (this.mRequestFinished == false) goto L12;
        if (this.mPrivateOutput != null) goto L9;
        this.mPrivateOutput = new PrivateOutputStream(this, getMaxPacketSize());
    L9:
        this.mPrivateOutputOpen = true;
        return this.mPrivateOutput;
    L12:
        throw new IOException("no  output streams available ,request not finished");
    L14:
        throw new IOException("no more input streams available, stream already opened");
    }

    @Override // javax.obex.Operation
    public DataOutputStream openDataOutputStream() throws IOException {
        return new DataOutputStream(openOutputStream());
    }

    @Override // javax.obex.Operation
    public void close() throws IOException {
        ensureOpen();
        this.mClosed = true;
    }

    @Override // javax.obex.BaseStream
    public void ensureOpen() throws IOException {
        if (this.mExceptionString != null) goto L10;
        if (this.mClosed == true) goto L8;
        return;
    L8:
        throw new IOException("Operation has already ended");
    L10:
        throw new IOException(this.mExceptionString);
    }

    @Override // javax.obex.Operation
    public void noBodyHeader() {
        this.mSendBodyHeader = false;
    }
}
