package android.bluetooth.client.pbap;

import android.bluetooth.client.pbap.utils.ObexAppParameters;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.obex.HeaderSet;

/* JADX INFO: loaded from: classes.dex */
final class BluetoothPbapRequestPullVcardListing extends BluetoothPbapRequest {
    private static final String TAG = "BluetoothPbapRequestPullVcardListing";
    private static final String TYPE = "x-bt/vcard-listing";
    private int mNewMissedCalls;
    private BluetoothPbapVcardListing mResponse;

    public BluetoothPbapRequestPullVcardListing(String r4, byte r5, byte r6, String r7, int r8, int r9) {
        this.mResponse = null;
        this.mNewMissedCalls = -1;
        if (r8 < 0) goto L24;
        if (r8 > 65535) goto L24;
        if (r9 < 0) goto L22;
        if (r9 > 65535) goto L22;
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        this.mHeaderSet.setHeader(1, r4);
        this.mHeaderSet.setHeader(66, TYPE);
        ObexAppParameters r10 = new ObexAppParameters();
        if (r5 < 0) goto L13;
        r10.add((byte) 1, r5);
    L13:
        if (r7 == null) goto L15;
        r10.add((byte) 3, r6);
        r10.add((byte) 2, r7);
    L15:
        if (r8 <= 0) goto L17;
        r10.add((byte) 4, (short) r8);
    L17:
        if (r9 <= 0) goto L19;
        r10.add((byte) 5, (short) r9);
    L19:
        r10.addToHeaderSet(this.mHeaderSet);
        return;
    L22:
        throw new IllegalArgumentException("listStartOffset should be [0..65535]");
    L24:
        throw new IllegalArgumentException("maxListCount should be [0..65535]");
    }

    @Override // android.bluetooth.client.pbap.BluetoothPbapRequest
    protected void readResponse(InputStream r3) throws IOException {
        Log.v(TAG, "readResponse");
        this.mResponse = new BluetoothPbapVcardListing(r3);
    }

    @Override // android.bluetooth.client.pbap.BluetoothPbapRequest
    protected void readResponseHeaders(HeaderSet r3) {
        Log.v(TAG, "readResponseHeaders");
        ObexAppParameters r4 = ObexAppParameters.fromHeaderSet(r3);
        if (r4.exists((byte) 9) == false) goto L6;
        this.mNewMissedCalls = r4.getByte((byte) 9);
        return;
    }

    public ArrayList<BluetoothPbapCard> getList() {
        return this.mResponse.getList();
    }

    public int getNewMissedCalls() {
        return this.mNewMissedCalls;
    }
}
