package android.bluetooth.client.pbap;

import android.os.Handler;
import android.util.Log;
import javax.obex.Authenticator;
import javax.obex.PasswordAuthentication;

/* JADX INFO: loaded from: classes.dex */
class BluetoothPbapObexAuthenticator implements Authenticator {
    private static final String TAG = "BluetoothPbapObexAuthenticator";
    private final Handler mCallback;
    private boolean mReplied;
    private String mSessionKey;

    @Override // javax.obex.Authenticator
    public byte[] onAuthenticationResponse(byte[] r1) {
        return null;
    }

    public BluetoothPbapObexAuthenticator(Handler r1) {
        this.mCallback = r1;
    }

    public synchronized void setReply(String r4) {
        monitor-enter(this);
        Log.d(TAG, "setReply key=" + r4);     // Catch: Throwable -> L7
        this.mSessionKey = r4;     // Catch: Throwable -> L7
        this.mReplied = true;     // Catch: Throwable -> L7
        notify();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // javax.obex.Authenticator
    public PasswordAuthentication onAuthenticationChallenge(String r2, boolean r3, boolean r4) {
        this.mReplied = false;
        Log.d(TAG, "onAuthenticationChallenge: sending request");
        this.mCallback.obtainMessage(105).sendToTarget();
        monitor-enter(this);
    L22:
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mReplied == true) goto L9;
        Log.v(TAG, "onAuthenticationChallenge: waiting for response");     // Catch: InterruptedException -> L8 Throwable -> L17
        wait();     // Catch: InterruptedException -> L8 Throwable -> L17
    L8:
        Log.e(TAG, "Interrupted while waiting for challenge response");     // Catch: Throwable -> L17
        goto L22
    L9:
        monitor-exit(this);     // Catch: Throwable -> L17
        String r5 = this.mSessionKey;
        if (r5 != null) goto L13;
    L15:
        Log.v(TAG, "onAuthenticationChallenge: mSessionKey is empty, timeout/cancel occured");
        return null;
    L13:
        if (r5.length() == 0) goto L15;
        Log.v(TAG, "onAuthenticationChallenge: mSessionKey=" + this.mSessionKey);
        return new PasswordAuthentication(null, this.mSessionKey.getBytes());
    }
}
