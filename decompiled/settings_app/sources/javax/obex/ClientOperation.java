package javax.obex;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class ClientOperation implements Operation, BaseStream {
    private static final String TAG = "ObexClientOperation";
    private static final boolean V = false;
    private boolean mEndOfBodySent;
    private String mExceptionMessage;
    private boolean mGetFinalFlag;
    private boolean mGetOperation;
    private boolean mInputOpen;
    private int mMaxPacketSize;
    private boolean mOperationDone;
    private ClientSession mParent;
    private PrivateInputStream mPrivateInput;
    private boolean mPrivateInputOpen;
    private PrivateOutputStream mPrivateOutput;
    private boolean mPrivateOutputOpen;
    private HeaderSet mReplyHeader;
    private HeaderSet mRequestHeader;
    private boolean mSendBodyHeader;
    private boolean mSrmActive;
    private boolean mSrmEnabled;
    private boolean mSrmWaitingForRemote;

    @Override // javax.obex.Operation
    public String getEncoding() {
        return null;
    }

    static {
        V = ObexHelper.VDBG;
    }

    public ClientOperation(int r4, ClientSession r5, HeaderSet r6, boolean r7) throws IOException {
        this.mSendBodyHeader = true;
        this.mSrmActive = false;
        this.mSrmEnabled = false;
        this.mSrmWaitingForRemote = true;
        this.mParent = r5;
        this.mEndOfBodySent = false;
        this.mInputOpen = true;
        this.mOperationDone = false;
        this.mMaxPacketSize = r4;
        this.mGetOperation = r7;
        this.mGetFinalFlag = false;
        this.mPrivateInputOpen = false;
        this.mPrivateOutputOpen = false;
        this.mPrivateInput = null;
        this.mPrivateOutput = null;
        this.mReplyHeader = new HeaderSet();
        this.mRequestHeader = new HeaderSet();
        int[] r8 = r6.getHeaderList();
        if (r8 == null) goto L9;
        int r9 = 0;
    L6:
        if (r9 >= r8.length) goto L9;
        HeaderSet r10 = this.mRequestHeader;
        int r0 = r8[r9];
        r10.setHeader(r0, r6.getHeader(r0));
        r9 = r9 + 1;
    L9:
        if (r6.mAuthChall == null) goto L12;
        this.mRequestHeader.mAuthChall = new byte[r6.mAuthChall.length];
        System.arraycopy(r6.mAuthChall, 0, this.mRequestHeader.mAuthChall, 0, r6.mAuthChall.length);
    L12:
        if (r6.mAuthResp == null) goto L15;
        this.mRequestHeader.mAuthResp = new byte[r6.mAuthResp.length];
        System.arraycopy(r6.mAuthResp, 0, this.mRequestHeader.mAuthResp, 0, r6.mAuthResp.length);
    L15:
        if (r6.mConnectionID == null) goto L19;
        this.mRequestHeader.mConnectionID = new byte[4];
        System.arraycopy(r6.mConnectionID, 0, this.mRequestHeader.mConnectionID, 0, 4);
        return;
    }

    public void setGetFinalFlag(boolean r1) {
        this.mGetFinalFlag = r1;
    }

    @Override // javax.obex.Operation
    public synchronized void abort() throws IOException {
        monitor-enter(this);
        ensureOpen();     // Catch: Throwable -> L22
        if (this.mOperationDone == true) goto L6;
    L10:
        this.mExceptionMessage = "Operation aborted";     // Catch: Throwable -> L22
        if (this.mOperationDone == false) goto L13;
    L19:
        close();     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L13:
        if (this.mReplyHeader.responseCode != 144) goto L19;
        this.mOperationDone = true;     // Catch: Throwable -> L22
        this.mParent.sendRequest(255, null, this.mReplyHeader, null, false);     // Catch: Throwable -> L22
        if (this.mReplyHeader.responseCode != 160) goto L18;
        this.mExceptionMessage = null;     // Catch: Throwable -> L22
        goto L19
    L18:
        throw new IOException("Invalid response code from server");     // Catch: Throwable -> L22
    L6:
        if (this.mReplyHeader.responseCode == 144) goto L10;
        throw new IOException("Operation has already ended");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    @Override // javax.obex.Operation
    public synchronized int getResponseCode() throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mReplyHeader.responseCode != (-1)) goto L6;
    L7:
        validateConnection();     // Catch: Throwable -> L11
    L8:
        int r0 = this.mReplyHeader.responseCode;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L6:
        if (this.mReplyHeader.responseCode != 144) goto L8;
        goto L7
    }

    @Override // javax.obex.Operation
    public String getType() {
        return (String) this.mReplyHeader.getHeader(66);
    L4:
        e = move-exception;
        if (V == false) goto L12;
        Log.d(TAG, "Exception occured - returning null", e);
        return null;
    L12:
        return null;
    }

    @Override // javax.obex.Operation
    public long getLength() {
        Long r4 = (Long) this.mReplyHeader.getHeader(195);     // Catch: IOException -> L8
        if (r4 != null) goto L6;
        return -1;
    L6:
        return r4.longValue();
    L8:
        e = move-exception;
        if (V == false) goto L12;
        Log.d(TAG, "Exception occured - returning -1", e);
    L12:
        return -1;
    }

    @Override // javax.obex.Operation
    public InputStream openInputStream() throws IOException {
        ensureOpen();
        if (this.mPrivateInputOpen == true) goto L13;
        if (this.mGetOperation == false) goto L8;
        validateConnection();
    L10:
        this.mPrivateInputOpen = true;
        return this.mPrivateInput;
    L8:
        if (this.mPrivateInput != null) goto L10;
        this.mPrivateInput = new PrivateInputStream(this);
        goto L10
    L13:
        throw new IOException("no more input streams available");
    }

    @Override // javax.obex.Operation
    public DataInputStream openDataInputStream() throws IOException {
        return new DataInputStream(openInputStream());
    }

    @Override // javax.obex.Operation
    public OutputStream openOutputStream() throws IOException {
        ensureOpen();
        ensureNotDone();
        if (this.mPrivateOutputOpen == true) goto L10;
        if (this.mPrivateOutput != null) goto L7;
        this.mPrivateOutput = new PrivateOutputStream(this, getMaxPacketSize());
    L7:
        this.mPrivateOutputOpen = true;
        return this.mPrivateOutput;
    L10:
        throw new IOException("no more output streams available");
    }

    @Override // javax.obex.Operation
    public int getMaxPacketSize() {
        return (this.mMaxPacketSize - 6) - getHeaderLength();
    }

    @Override // javax.obex.Operation
    public int getHeaderLength() {
        return ObexHelper.createHeader(this.mRequestHeader, false).length;
    }

    @Override // javax.obex.Operation
    public DataOutputStream openDataOutputStream() throws IOException {
        return new DataOutputStream(openOutputStream());
    }

    @Override // javax.obex.Operation
    public void close() throws IOException {
        this.mInputOpen = false;
        this.mPrivateInputOpen = false;
        this.mPrivateOutputOpen = false;
        this.mParent.setRequestInactive();
    }

    @Override // javax.obex.Operation
    public HeaderSet getReceivedHeader() throws IOException {
        ensureOpen();
        return this.mReplyHeader;
    }

    @Override // javax.obex.Operation
    public void sendHeaders(HeaderSet r6) throws IOException {
        ensureOpen();
        if (this.mOperationDone == true) goto L15;
        if (r6 == null) goto L13;
        int[] r0 = r6.getHeaderList();
        if (r0 == null) goto L11;
        int r1 = 0;
    L9:
        if (r1 >= r0.length) goto L17;
        HeaderSet r2 = this.mRequestHeader;
        int r3 = r0[r1];
        r2.setHeader(r3, r6.getHeader(r3));
        r1 = r1 + 1;
        goto L9
    L17:
        return;
    L11:
        return;
    L13:
        throw new IOException("Headers may not be null");
    L15:
        throw new IOException("Operation has already exchanged all data");
    }

    @Override // javax.obex.BaseStream
    public void ensureNotDone() throws IOException {
        if (this.mOperationDone == true) goto L6;
        return;
    L6:
        throw new IOException("Operation has completed");
    }

    @Override // javax.obex.BaseStream
    public void ensureOpen() throws IOException {
        this.mParent.ensureOpen();
        if (this.mExceptionMessage != null) goto L10;
        if (this.mInputOpen == false) goto L8;
        return;
    L8:
        throw new IOException("Operation has already ended");
    L10:
        throw new IOException(this.mExceptionMessage);
    }

    private void validateConnection() throws IOException {
        ensureOpen();
        if (this.mPrivateInput != null) goto L5;
    L6:
        startProcessing();
        return;
    L5:
        if (this.mReplyHeader.responseCode == (-1)) goto L6;
    }

    private boolean sendRequest(int r18) throws IOException {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        byte[] r2 = ObexHelper.createHeader(this.mRequestHeader, true);
        PrivateOutputStream r4 = this.mPrivateOutput;
        if (r4 == null) goto L5;
        int r5 = r4.size();
    L7:
        if (((r2.length + 3) + 3) <= this.mMaxPacketSize) goto L41;
        int r3 = 0;
        int r6 = 0;
        int r8 = 0;
    L10:
        if (r3 == r2.length) goto L36;
        r3 = ObexHelper.findHeaderEnd(r2, r6, this.mMaxPacketSize - 3);
        if (r3 == (-1)) goto L13;
        int r10 = r3 - r6;
        byte[] r13 = new byte[r10];
        System.arraycopy(r2, r6, r13, 0, r10);
        r8 = r8 + r10;
        if (r8 != r2.length) goto L24;
        int r12 = 131;
    L26:
        if (this.mParent.sendRequest(r12, r13, this.mReplyHeader, this.mPrivateInput, false) == false) goto L27;
        if (this.mReplyHeader.responseCode == 160) goto L30;
        if (this.mReplyHeader.responseCode != 144) goto L34;
        r6 = r3;
        goto L10
    L34:
        return false;
    L30:
        Log.i(TAG, "sendRequest return OBEX_HTTP_OK");
        return true;
    L27:
        return false;
    L24:
        r12 = 3;
        goto L26
    L13:
        this.mOperationDone = true;
        abort();
        this.mExceptionMessage = "Header larger then can be sent in a packet";
        this.mInputOpen = false;
        PrivateInputStream r7 = this.mPrivateInput;
        if (r7 == null) goto L16;
        r7.close();
    L16:
        PrivateOutputStream r0 = this.mPrivateOutput;
        if (r0 == null) goto L20;
        r0.close();
    L20:
        throw new IOException("OBEX Packet exceeds max packet size");
    L36:
        checkForSrm();
        if (r5 <= 0) goto L39;
        return true;
    L39:
        return false;
    L41:
        if (this.mSendBodyHeader == true) goto L43;
        int r9 = r18 | 128;
    L44:
        int r11 = r9;
        r1.write(r2);
        if (r5 <= 0) goto L62;
        int r14 = this.mMaxPacketSize;
        if (r5 <= ((r14 - r2.length) - 6)) goto L49;
        r5 = (r14 - r2.length) - 6;
        boolean r15 = true;
    L50:
        byte[] r16 = this.mPrivateOutput.readBytes(r5);
        if (this.mPrivateOutput.isClosed() == false) goto L58;
        if (r15 == true) goto L58;
        if (this.mEndOfBodySent == true) goto L58;
        if ((r11 & 128) == 0) goto L58;
        r1.write(73);
        this.mEndOfBodySent = true;
    L59:
        r5 = r5 + 3;
        r1.write((byte) (r5 >> 8));
        r1.write((byte) r5);
        if (r16 == null) goto L64;
        r1.write(r16);
    L64:
        if (this.mPrivateOutputOpen == false) goto L74;
        if (r5 > 0) goto L74;
        if (this.mEndOfBodySent == true) goto L74;
        if ((r11 & 128) != 0) goto L71;
        r1.write(72);
    L72:
        r1.write((byte) 0);
        r1.write((byte) 3);
        goto L74
    L71:
        r1.write(73);
        this.mEndOfBodySent = true;
    L74:
        if (r1.size() != 0) goto L81;
        if (this.mParent.sendRequest(r11, null, this.mReplyHeader, this.mPrivateInput, this.mSrmActive) == true) goto L78;
        return false;
    L78:
        checkForSrm();
        return r15;
    L81:
        if (r1.size() > 0) goto L83;
    L85:
        checkForSrm();
        PrivateOutputStream r17 = this.mPrivateOutput;
        if (r17 == null) goto L91;
        if (r17.size() <= 0) goto L91;
        return true;
    L91:
        return r15;
    L83:
        if (this.mParent.sendRequest(r11, r1.toByteArray(), this.mReplyHeader, this.mPrivateInput, this.mSrmActive) == true) goto L85;
        return false;
    L58:
        r1.write(72);
        goto L59
    L49:
        r15 = false;
        goto L50
    L62:
        r15 = false;
        goto L64
    L43:
        r9 = r18;
        goto L44
    L5:
        r5 = -1;
        goto L7
    }

    private void checkForSrm() throws IOException {
        Byte r0 = (Byte) this.mReplyHeader.getHeader(151);
        if (this.mParent.isSrmSupported() != true) goto L9;
        if (r0 == null) goto L9;
        if (r0.byteValue() != 1) goto L9;
        this.mSrmEnabled = true;
    L9:
        if (this.mSrmEnabled == false) goto L16;
        this.mSrmWaitingForRemote = false;
        Byte r1 = (Byte) this.mReplyHeader.getHeader(152);
        if (r1 == null) goto L16;
        if (r1.byteValue() != 1) goto L16;
        this.mSrmWaitingForRemote = true;
        this.mReplyHeader.setHeader(152, null);
    L16:
        if (this.mSrmWaitingForRemote == false) goto L18;
        return;
    L18:
        if (this.mSrmEnabled != true) goto L22;
        this.mSrmActive = true;
        return;
    }

    private synchronized void startProcessing() throws IOException {
        monitor-enter(this);
    L44:
        th = move-exception;
        throw th;
    L4:
        if (this.mPrivateInput != null) goto L7;
        this.mPrivateInput = new PrivateInputStream(this);     // Catch: Throwable -> L44
    L7:
        if (this.mGetOperation == false) goto L30;
        if (this.mOperationDone == false) goto L11;
    L42:
        monitor-exit(this);
        return;
    L11:
        if (this.mGetFinalFlag == true) goto L25;
        this.mReplyHeader.responseCode = 144;     // Catch: Throwable -> L44
        boolean r0 = true;
    L13:
        if (r0 == false) goto L18;
        if (this.mReplyHeader.responseCode != 144) goto L18;
        r0 = sendRequest(3);     // Catch: Throwable -> L44
    L18:
        if (this.mReplyHeader.responseCode != 144) goto L21;
        this.mParent.sendRequest(131, null, this.mReplyHeader, this.mPrivateInput, this.mSrmActive);     // Catch: Throwable -> L44
    L21:
        if (this.mReplyHeader.responseCode == 144) goto L23;
        this.mOperationDone = true;     // Catch: Throwable -> L44
        goto L42
    L23:
        checkForSrm();     // Catch: Throwable -> L44
        goto L42
    L25:
        if (sendRequest(131) == true) goto L28;
        this.mOperationDone = true;     // Catch: Throwable -> L44
        goto L42
    L28:
        throw new IOException("FINAL_GET forced, data didn't fit into one packet");     // Catch: Throwable -> L44
    L30:
        if (this.mOperationDone == true) goto L37;
        this.mReplyHeader.responseCode = 144;     // Catch: Throwable -> L44
        boolean r1 = true;
    L32:
        if (r1 == false) goto L37;
        if (this.mReplyHeader.responseCode != 144) goto L37;
        r1 = sendRequest(2);     // Catch: Throwable -> L44
    L37:
        if (this.mReplyHeader.responseCode != 144) goto L40;
        this.mParent.sendRequest(130, null, this.mReplyHeader, this.mPrivateInput, this.mSrmActive);     // Catch: Throwable -> L44
    L40:
        if (this.mReplyHeader.responseCode == 144) goto L42;
        this.mOperationDone = true;     // Catch: Throwable -> L44
        goto L42
    }

    @Override // javax.obex.BaseStream
    public synchronized boolean continueOperation(boolean r10, boolean r11) throws IOException {
        monitor-enter(this);
    L53:
        th = move-exception;
        throw th;
    L4:
        if (this.mGetOperation == false) goto L33;
        if (r11 == true) goto L7;
    L14:
        if (r11 == true) goto L30;
        if (this.mOperationDone == true) goto L30;
        if (this.mPrivateInput != null) goto L21;
        this.mPrivateInput = new PrivateInputStream(this);     // Catch: Throwable -> L53
    L21:
        if (this.mGetFinalFlag == true) goto L23;
        sendRequest(3);     // Catch: Throwable -> L53
    L25:
        if (this.mReplyHeader.responseCode == 144) goto L27;
        this.mOperationDone = true;     // Catch: Throwable -> L53
    L27:
        monitor-exit(this);
        return true;
    L23:
        sendRequest(131);     // Catch: Throwable -> L53
    L30:
        if (this.mOperationDone == false) goto L51;
        monitor-exit(this);
        return false;
    L51:
        monitor-exit(this);
        return false;
    L7:
        if (this.mOperationDone == true) goto L14;
        this.mParent.sendRequest(131, null, this.mReplyHeader, this.mPrivateInput, this.mSrmActive);     // Catch: Throwable -> L53
        if (this.mReplyHeader.responseCode == 144) goto L11;
        this.mOperationDone = true;     // Catch: Throwable -> L53
    L12:
        monitor-exit(this);
        return true;
    L11:
        checkForSrm();     // Catch: Throwable -> L53
        goto L12
    L33:
        if (r11 == false) goto L35;
    L42:
        if (r11 == false) goto L48;
        if (this.mOperationDone == true) goto L48;
        monitor-exit(this);
        return false;
    L48:
        if (this.mOperationDone == false) goto L51;
        monitor-exit(this);
        return false;
    L35:
        if (this.mOperationDone == true) goto L42;
        if (this.mReplyHeader.responseCode != (-1)) goto L39;
        this.mReplyHeader.responseCode = 144;     // Catch: Throwable -> L53
    L39:
        sendRequest(2);     // Catch: Throwable -> L53
        monitor-exit(this);
        return true;
    }

    @Override // javax.obex.BaseStream
    public void streamClosed(boolean r12) throws IOException {
        boolean r2 = false;
        if (this.mGetOperation == true) goto L31;
        if (r12 == false) goto L6;
    L26:
        if (r12 == true) goto L28;
        return;
    L28:
        if (this.mOperationDone == false) goto L95;
        this.mOperationDone = true;
        return;
    L95:
        return;
    L6:
        if (this.mOperationDone == true) goto L26;
        PrivateOutputStream r13 = this.mPrivateOutput;
        if (r13 != null) goto L10;
    L14:
        r2 = true;
    L16:
        if (this.mReplyHeader.responseCode != (-1)) goto L18;
        this.mReplyHeader.responseCode = 144;
    L18:
        if (r2 == false) goto L23;
        if (this.mReplyHeader.responseCode != 144) goto L23;
        r2 = sendRequest(2);
    L23:
        if (this.mReplyHeader.responseCode != 144) goto L25;
        sendRequest(130);
        goto L23
    L25:
        this.mOperationDone = true;
        return;
    L10:
        if (r13.size() > 0) goto L14;
        if (ObexHelper.createHeader(this.mRequestHeader, false).length > 0) goto L14;
    L31:
        if (r12 == true) goto L33;
    L49:
        if (r12 == false) goto L51;
        return;
    L51:
        if (this.mOperationDone == true) goto L99;
        PrivateOutputStream r14 = this.mPrivateOutput;
        if (r14 != null) goto L55;
    L59:
        boolean r15 = true;
    L61:
        if (this.mPrivateInput != null) goto L63;
        this.mPrivateInput = new PrivateInputStream(this);
    L63:
        PrivateOutputStream r1 = this.mPrivateOutput;
        if (r1 != null) goto L66;
    L68:
        r2 = r15;
    L69:
        this.mReplyHeader.responseCode = 144;
    L70:
        if (r2 == false) goto L74;
        if (this.mReplyHeader.responseCode != 144) goto L74;
        r2 = sendRequest(3);
    L74:
        sendRequest(131);
        if (this.mReplyHeader.responseCode == 144) goto L100;
        this.mOperationDone = true;
        return;
    L100:
        return;
    L66:
        if (r1.size() > 0) goto L68;
    L55:
        if (r14.size() > 0) goto L59;
        if (ObexHelper.createHeader(this.mRequestHeader, false).length > 0) goto L59;
        r15 = false;
        goto L61
    L99:
        return;
    L33:
        if (this.mOperationDone == true) goto L49;
        if (this.mReplyHeader.responseCode != (-1)) goto L38;
        this.mReplyHeader.responseCode = 144;
    L38:
        if (this.mReplyHeader.responseCode != 144) goto L44;
        if (this.mOperationDone == true) goto L44;
        if (sendRequest(131) == true) goto L38;
    L44:
        if (this.mReplyHeader.responseCode != 144) goto L48;
        if (this.mOperationDone == true) goto L48;
        this.mParent.sendRequest(131, null, this.mReplyHeader, this.mPrivateInput, false);
    L48:
        this.mOperationDone = true;
    }

    @Override // javax.obex.Operation
    public void noBodyHeader() {
        this.mSendBodyHeader = false;
    }
}
