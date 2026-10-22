package android.bluetooth.client.pbap;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import javax.obex.ClientOperation;
import javax.obex.ClientSession;
import javax.obex.HeaderSet;

/* JADX INFO: loaded from: classes.dex */
abstract class BluetoothPbapRequest {
    protected static final byte OAP_TAGID_FILTER = 6;
    protected static final byte OAP_TAGID_FORMAT = 7;
    protected static final byte OAP_TAGID_LIST_START_OFFSET = 5;
    protected static final byte OAP_TAGID_MAX_LIST_COUNT = 4;
    protected static final byte OAP_TAGID_NEW_MISSED_CALLS = 9;
    protected static final byte OAP_TAGID_ORDER = 1;
    protected static final byte OAP_TAGID_PHONEBOOK_SIZE = 8;
    protected static final byte OAP_TAGID_SEARCH_ATTRIBUTE = 3;
    protected static final byte OAP_TAGID_SEARCH_VALUE = 2;
    private static final String TAG = "BluetoothPbapRequest";
    private boolean mAborted;
    protected HeaderSet mHeaderSet;
    private ClientOperation mOp;
    protected int mResponseCode;

    public BluetoothPbapRequest() {
        this.mAborted = false;
        this.mOp = null;
        this.mHeaderSet = new HeaderSet();
    }

    public final boolean isSuccess() {
        if (this.mResponseCode != 160) goto L5;
        return true;
    L5:
        return false;
    }

    public void execute(ClientSession r6) throws IOException {
        Log.v(TAG, "execute");
        if (this.mAborted == false) goto L11;
        this.mResponseCode = 208;
        return;
    L11:
        ClientOperation r7 = (ClientOperation) r6.get(this.mHeaderSet);     // Catch: IOException -> L8
        this.mOp = r7;     // Catch: IOException -> L8
        r7.setGetFinalFlag(true);     // Catch: IOException -> L8
        this.mOp.continueOperation(true, false);     // Catch: IOException -> L8
        readResponseHeaders(this.mOp.getReceivedHeader());     // Catch: IOException -> L8
        InputStream r8 = this.mOp.openInputStream();     // Catch: IOException -> L8
        readResponse(r8);     // Catch: IOException -> L8
        r8.close();     // Catch: IOException -> L8
        this.mOp.close();     // Catch: IOException -> L8
        this.mResponseCode = this.mOp.getResponseCode();     // Catch: IOException -> L8
        Log.d(TAG, "mResponseCode=" + this.mResponseCode);     // Catch: IOException -> L8
        checkResponseCode(this.mResponseCode);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "IOException occured when processing request", e);
        this.mResponseCode = 208;
        throw e;
    }

    public void abort() {
        this.mAborted = true;
        ClientOperation r2 = this.mOp;
        if (r2 == null) goto L11;
        r2.abort();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "Exception occured when trying to abort", e);
        return;
    }

    protected void readResponse(InputStream r1) throws IOException {
        Log.v(TAG, "readResponse");
    }

    protected void readResponseHeaders(HeaderSet r1) {
        Log.v(TAG, "readResponseHeaders");
    }

    protected void checkResponseCode(int r1) throws IOException {
        Log.v(TAG, "checkResponseCode");
    }
}
