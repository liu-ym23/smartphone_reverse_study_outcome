package android.bluetooth.client.pbap;

import android.bluetooth.client.pbap.utils.ObexAppParameters;
import android.util.Log;
import javax.obex.HeaderSet;

/* JADX INFO: loaded from: classes.dex */
class BluetoothPbapRequestPullPhoneBookSize extends BluetoothPbapRequest {
    private static final String TAG = "BluetoothPbapRequestPullPhoneBookSize";
    private static final String TYPE = "x-bt/phonebook";
    private int mSize;

    public BluetoothPbapRequestPullPhoneBookSize(String r3) {
        this.mHeaderSet.setHeader(1, r3);
        this.mHeaderSet.setHeader(66, TYPE);
        ObexAppParameters r4 = new ObexAppParameters();
        r4.add((byte) 4, 0);
        r4.addToHeaderSet(this.mHeaderSet);
    }

    @Override // android.bluetooth.client.pbap.BluetoothPbapRequest
    protected void readResponseHeaders(HeaderSet r3) {
        Log.v(TAG, "readResponseHeaders");
        this.mSize = ObexAppParameters.fromHeaderSet(r3).getShort((byte) 8);
    }

    public int getSize() {
        return this.mSize;
    }
}
