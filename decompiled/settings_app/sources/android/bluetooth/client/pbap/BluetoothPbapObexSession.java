package android.bluetooth.client.pbap;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.lang.ref.WeakReference;
import javax.obex.ClientSession;
import javax.obex.HeaderSet;
import javax.obex.ObexTransport;

/* JADX INFO: loaded from: classes.dex */
final class BluetoothPbapObexSession {
    static final int CONNECTED = 0;
    static final int CONNECTING = 1;
    private static final boolean DBG = true;
    static final int DISCONNECTED = 2;
    static final int MSG_CONNECT = 0;
    static final int MSG_REQUEST = 1;
    static final int OBEX_SESSION_AUTHENTICATION_REQUEST = 105;
    static final int OBEX_SESSION_AUTHENTICATION_TIMEOUT = 106;
    static final int OBEX_SESSION_CONNECTED = 100;
    static final int OBEX_SESSION_DISCONNECTED = 102;
    static final int OBEX_SESSION_FAILED = 101;
    static final int OBEX_SESSION_REQUEST_COMPLETED = 103;
    static final int OBEX_SESSION_REQUEST_FAILED = 104;
    private static final byte[] PBAP_TARGET = null;
    private static final String TAG = "BluetoothPbapObexSession";
    private BluetoothPbapObexAuthenticator mAuth;
    private ClientSession mClientSession;
    private Handler mHandler;
    private Handler mSessionHandler;
    private int mState;
    private HandlerThread mThread;
    private final ObexTransport mTransport;

    private static class ObexClientHandler extends Handler {
        WeakReference<BluetoothPbapObexSession> mInst;

        ObexClientHandler(Looper r1, BluetoothPbapObexSession r2) {
            super(r1);
            this.mInst = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            BluetoothPbapObexSession r3 = this.mInst.get();
            if (r3 != null) goto L7;
            Log.e(BluetoothPbapObexSession.TAG, "The instance class is no longer around; terminating.");
            return;
        L7:
            if (r3.isConnected() != 0) goto L9;
        L12:
            int r1 = r4.what;
            if (r1 != 0) goto L15;
            BluetoothPbapObexSession.access$000(r3);
            return;
        L15:
            if (r1 == 1) goto L17;
            Log.e(BluetoothPbapObexSession.TAG, "Unknwown message type: " + r4.what);
            return;
        L17:
            BluetoothPbapObexSession.access$100(r3, (BluetoothPbapRequest) r4.obj);
            return;
        L9:
            if (r4.what == 0) goto L12;
            Log.w(BluetoothPbapObexSession.TAG, "Cannot execute " + r4 + " when not CONNECTED.");
        }
    }

    static /* synthetic */ void access$000(BluetoothPbapObexSession r0) {
        r0.connect();
    }

    static /* synthetic */ void access$100(BluetoothPbapObexSession r0, BluetoothPbapRequest r1) {
        r0.executeRequest(r1);
    }

    static {
        PBAP_TARGET = new byte[]{121, 97, 53, -16, -16, -59, 17, -40, 9, 102, 8, 0, 32, 12, -102, 102};
    }

    public BluetoothPbapObexSession(ObexTransport r2) {
        this.mAuth = null;
        this.mState = 2;
        this.mTransport = r2;
    }

    public synchronized boolean start(Handler r4) {
        monitor-enter(this);
        Log.d(TAG, "start");     // Catch: Throwable -> L17
        int r0 = this.mState;     // Catch: Throwable -> L17
        if (r0 != 0) goto L6;
    L15:
        monitor-exit(this);
        return false;
    L6:
        if (r0 == 1) goto L15;
        this.mState = 1;     // Catch: Throwable -> L17
        this.mSessionHandler = r4;     // Catch: Throwable -> L17
        this.mAuth = new BluetoothPbapObexAuthenticator(this.mSessionHandler);     // Catch: Throwable -> L17
        HandlerThread r5 = new HandlerThread("BluetoothPbapObexSessionThread");     // Catch: Throwable -> L17
        this.mThread = r5;     // Catch: Throwable -> L17
        r5.start();     // Catch: Throwable -> L17
        ObexClientHandler r6 = new ObexClientHandler(this.mThread.getLooper(), this);     // Catch: Throwable -> L17
        this.mHandler = r6;     // Catch: Throwable -> L17
        if (r6.sendMessage(r6.obtainMessage(0)) == true) goto L13;
        this.mState = 2;     // Catch: Throwable -> L17
        monitor-exit(this);
        return false;
    L13:
        monitor-exit(this);
        return true;
    L17:
        th = move-exception;
        throw th;
    }

    public void stop() {
        Log.d(TAG, "stop");
        this.mThread.quit();
        disconnect(false);
    }

    public void abort() {
        stop();
    }

    public boolean schedule(BluetoothPbapRequest r3) {
        Log.d(TAG, "schedule() called with: " + r3);
        Handler r2 = this.mHandler;
        if (r2.sendMessage(r2.obtainMessage(1, r3)) == true) goto L6;
        Log.e(TAG, "Adding messages failed, obex must be disconnected.");
        return false;
    L6:
        return true;
    }

    public int isConnected() {
        return this.mState;
    }

    private void connect() {
        Log.d(TAG, "connect()");
        ClientSession r2 = new ClientSession(this.mTransport);     // Catch: IOException -> L5
        this.mClientSession = r2;     // Catch: IOException -> L5
        r2.setAuthenticator(this.mAuth);     // Catch: IOException -> L5
        boolean r3 = true;
    L7:
        HeaderSet r4 = new HeaderSet();
        r4.setHeader(70, PBAP_TARGET);
        if (this.mClientSession.connect(r4).getResponseCode() == 160) goto L12;
        disconnect(true);     // Catch: IOException -> L21
    L12:
        monitor-enter(this);
        if (r3 == false) goto L15;
        this.mSessionHandler.obtainMessage(100).sendToTarget();     // Catch: Throwable -> L18
        this.mState = 0;     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L15:
        this.mSessionHandler.obtainMessage(102).sendToTarget();     // Catch: Throwable -> L18
        this.mState = 2;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L11:
        r3 = false;
    L5:
        e = move-exception;
        Log.d(TAG, "connect() exception: " + e);
        r3 = false;
        goto L7
    }

    private synchronized void disconnect(boolean r4) {
        monitor-enter(this);
        Log.d(TAG, "disconnect()");     // Catch: Throwable -> L17
        if (this.mState == 2) goto L8;
        monitor-exit(this);
        return;
    L8:
        ClientSession r0 = this.mClientSession;     // Catch: Throwable -> L17
        if (r0 != null) goto L23;
    L12:
        if (r4 == false) goto L14;
        this.mSessionHandler.obtainMessage(102).sendToTarget();     // Catch: Throwable -> L17
    L14:
        this.mState = 2;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L23:
        r0.disconnect(null);     // Catch: IOException -> L20 Throwable -> L17
        this.mClientSession.close();     // Catch: IOException -> L20 Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private void executeRequest(BluetoothPbapRequest r4) {
        r4.execute(this.mClientSession);     // Catch: IOException -> L4
    L7:
        if (r4.isSuccess() == false) goto L9;
        this.mSessionHandler.obtainMessage(103, r4).sendToTarget();
        return;
    L9:
        this.mSessionHandler.obtainMessage(104, r4).sendToTarget();
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Error during executeRequest " + e);
        disconnect(true);
        goto L7
    }

    public boolean setAuthReply(String r3) {
        Log.d(TAG, "setAuthReply key=" + r3);
        BluetoothPbapObexAuthenticator r2 = this.mAuth;
        if (r2 != null) goto L6;
        return false;
    L6:
        r2.setReply(r3);
        return true;
    }
}
