package android.bluetooth.client.pbap;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class BluetoothPbapSession implements Handler.Callback {
    public static final int ACTION_LISTING = 14;
    public static final int ACTION_PHONEBOOK_SIZE = 16;
    public static final int ACTION_VCARD = 15;
    public static final int AUTH_REQUESTED = 8;
    public static final int AUTH_TIMEOUT = 9;
    private static final String PBAP_UUID = "0000112f-0000-1000-8000-00805f9b34fb";
    public static final int REQUEST_COMPLETED = 3;
    public static final int REQUEST_FAILED = 4;
    private static final int RFCOMM_CONNECTED = 1;
    private static final int RFCOMM_FAILED = 2;
    public static final int SESSION_CONNECTED = 6;
    public static final int SESSION_CONNECTING = 5;
    public static final int SESSION_DISCONNECTED = 7;
    private static final String TAG = "android.bluetooth.client.pbap.BluetoothPbapSession";
    private final BluetoothAdapter mAdapter;
    private RfcommConnectThread mConnectThread;
    private final BluetoothDevice mDevice;
    private final HandlerThread mHandlerThread;
    private BluetoothPbapObexSession mObexSession;
    private final Handler mParentHandler;
    private BluetoothPbapRequest mPendingRequest;
    private final Handler mSessionHandler;
    private BluetoothPbapObexTransport mTransport;

    private class RfcommConnectThread extends Thread {
        private static final String TAG = "RfcommConnectThread";
        private BluetoothSocket mSocket;
        final /* synthetic */ BluetoothPbapSession this$0;

        public RfcommConnectThread(BluetoothPbapSession r1) {
            this.this$0 = r1;
            super(TAG);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (BluetoothPbapSession.access$000(this.this$0).isDiscovering() == false) goto L10;
            BluetoothPbapSession.access$000(this.this$0).cancelDiscovery();
        L10:
            BluetoothSocket r0 = BluetoothPbapSession.access$100(this.this$0).createRfcommSocketToServiceRecord(UUID.fromString(BluetoothPbapSession.PBAP_UUID));     // Catch: IOException -> L7
            this.mSocket = r0;     // Catch: IOException -> L7
            r0.connect();     // Catch: IOException -> L7
            BluetoothPbapObexTransport r1 = new BluetoothPbapObexTransport(this.mSocket);     // Catch: IOException -> L7
            BluetoothPbapSession.access$200(this.this$0).obtainMessage(1, r1).sendToTarget();     // Catch: IOException -> L7
            return;
        L7:
            e = move-exception;
            Log.e(TAG, "mSocket.connect: failed", e);
            closeSocket();
            BluetoothPbapSession.access$200(this.this$0).obtainMessage(2).sendToTarget();
        }

        public void closeSocket() {
            BluetoothSocket r2 = this.mSocket;     // Catch: IOException -> L6
            if (r2 == null) goto L11;
            r2.close();     // Catch: IOException -> L6
            return;
        L11:
            return;
        L6:
            e = move-exception;
            Log.e(TAG, "Error when closing socket", e);
        }
    }

    static /* synthetic */ BluetoothAdapter access$000(BluetoothPbapSession r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ BluetoothDevice access$100(BluetoothPbapSession r0) {
        return r0.mDevice;
    }

    static /* synthetic */ Handler access$200(BluetoothPbapSession r0) {
        return r0.mSessionHandler;
    }

    public BluetoothPbapSession(BluetoothDevice r3, Handler r4) {
        this.mPendingRequest = null;
        BluetoothAdapter r1 = BluetoothAdapter.getDefaultAdapter();
        this.mAdapter = r1;
        if (r1 == null) goto L7;
        this.mDevice = r3;
        this.mParentHandler = r4;
        this.mConnectThread = null;
        this.mTransport = null;
        this.mObexSession = null;
        HandlerThread r5 = new HandlerThread("PBAP session handler", 10);
        this.mHandlerThread = r5;
        r5.start();
        this.mSessionHandler = new Handler(r5.getLooper(), this);
        return;
    L7:
        throw new NullPointerException("No Bluetooth adapter in the system");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r7) {
        Log.d(TAG, "Handler: msg: " + r7.what);
        int r0 = r7.what;
        if (r0 != 1) goto L5;
        this.mConnectThread = null;
        this.mTransport = (BluetoothPbapObexTransport) r7.obj;
        startObexSession();
    L24:
        return true;
    L5:
        if (r0 == 2) goto L20;
        switch(r0) {
            case 100: goto L17;
            case 101: goto L14;
            case 102: goto L13;
            case 103: goto L12;
            case 104: goto L11;
            case 105: goto L10;
            case 106: goto L9;
            default: goto L7;
        };
    L7:
        return false;
    L9:
        setAuthResponse(null);
        this.mParentHandler.obtainMessage(9).sendToTarget();
        goto L24
    L10:
        this.mParentHandler.obtainMessage(8).sendToTarget();
        Handler r6 = this.mSessionHandler;
        r6.sendMessageDelayed(r6.obtainMessage(106), 30000);
        goto L24
    L11:
        this.mParentHandler.obtainMessage(4, r7.obj).sendToTarget();
        goto L24
    L12:
        this.mParentHandler.obtainMessage(3, r7.obj).sendToTarget();
        goto L24
    L13:
        this.mParentHandler.obtainMessage(7).sendToTarget();
        stopRfcomm();
        goto L24
    L14:
        stopObexSession();
        this.mParentHandler.obtainMessage(7).sendToTarget();
        BluetoothPbapRequest r8 = this.mPendingRequest;
        if (r8 == null) goto L24;
        this.mParentHandler.obtainMessage(4, r8).sendToTarget();
        this.mPendingRequest = null;
        goto L24
    L17:
        this.mParentHandler.obtainMessage(6).sendToTarget();
        BluetoothPbapRequest r9 = this.mPendingRequest;
        if (r9 == null) goto L24;
        this.mObexSession.schedule(r9);
        this.mPendingRequest = null;
        goto L24
    L20:
        this.mConnectThread = null;
        this.mParentHandler.obtainMessage(7).sendToTarget();
        BluetoothPbapRequest r10 = this.mPendingRequest;
        if (r10 == null) goto L24;
        this.mParentHandler.obtainMessage(4, r10).sendToTarget();
        this.mPendingRequest = null;
        goto L24
    }

    public void start() {
        Log.d(TAG, "start");
        startRfcomm();
    }

    public void stop() {
        Log.d(TAG, "Stop");
        stopObexSession();
        stopRfcomm();
    }

    public void abort() {
        Log.d(TAG, "abort");
        BluetoothPbapRequest r0 = this.mPendingRequest;
        if (r0 == null) goto L5;
        this.mParentHandler.obtainMessage(4, r0).sendToTarget();
        this.mPendingRequest = null;
    L5:
        BluetoothPbapObexSession r3 = this.mObexSession;
        if (r3 == null) goto L9;
        r3.abort();
        return;
    }

    public boolean makeRequest(BluetoothPbapRequest r3) {
        Log.v(TAG, "makeRequest: " + r3.getClass().getSimpleName());
        if (this.mPendingRequest == null) goto L6;
        Log.w(TAG, "makeRequest: request already queued, exiting");
        return false;
    L6:
        BluetoothPbapObexSession r0 = this.mObexSession;
        if (r0 != null) goto L11;
        this.mPendingRequest = r3;
        startRfcomm();
        return true;
    L11:
        return r0.schedule(r3);
    }

    public boolean setAuthResponse(String r3) {
        Log.d(TAG, "setAuthResponse key=" + r3);
        this.mSessionHandler.removeMessages(106);
        BluetoothPbapObexSession r2 = this.mObexSession;
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.setAuthReply(r3);
    }

    private void startRfcomm() {
        Log.d(TAG, "startRfcomm");
        if (this.mConnectThread == null) goto L5;
        return;
    L5:
        if (this.mObexSession != null) goto L9;
        this.mParentHandler.obtainMessage(5).sendToTarget();
        RfcommConnectThread r0 = new RfcommConnectThread(this);
        this.mConnectThread = r0;
        r0.start();
        return;
    }

    private void stopRfcomm() {
        Log.d(TAG, "stopRfcomm");
        RfcommConnectThread r0 = this.mConnectThread;
        if (r0 != null) goto L13;
    L6:
        BluetoothPbapObexTransport r1 = this.mTransport;
        if (r1 == null) goto L17;
        r1.close();     // Catch: IOException -> L11
    L9:
        this.mTransport = null;
        return;
    L17:
        return;
    L13:
        r0.closeSocket();     // Catch: InterruptedException -> L12
        this.mConnectThread.join();     // Catch: InterruptedException -> L12
    L5:
        this.mConnectThread = null;
        goto L6
    }

    private void startObexSession() {
        Log.d(TAG, "startObexSession");
        BluetoothPbapObexSession r0 = new BluetoothPbapObexSession(this.mTransport);
        this.mObexSession = r0;
        r0.start(this.mSessionHandler);
    }

    private void stopObexSession() {
        Log.d(TAG, "stopObexSession");
        BluetoothPbapObexSession r0 = this.mObexSession;
        if (r0 == null) goto L6;
        r0.stop();
        this.mObexSession = null;
        return;
    }
}
