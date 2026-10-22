package android.bluetooth.client.pbap;

import android.accounts.Account;
import android.bluetooth.client.pbap.utils.ObexAppParameters;
import android.util.Log;
import com.android.vcard.VCardEntry;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
final class BluetoothPbapRequestPullVcardEntry extends BluetoothPbapRequest {
    private static final String TAG = "BluetoothPbapRequestPullVcardEntry";
    private static final String TYPE = "x-bt/vcard";
    private final Account mAccount;
    private final byte mFormat;
    private BluetoothPbapVcardList mResponse;

    public BluetoothPbapRequestPullVcardEntry(String r3, Account r4, long r5, byte r7) {
        this.mAccount = r4;
        this.mHeaderSet.setHeader(1, r3);
        this.mHeaderSet.setHeader(66, TYPE);
        if (r7 == 0) goto L6;
        if (r7 == 1) goto L6;
        r7 = 0;
    L6:
        ObexAppParameters r6 = new ObexAppParameters();
        if (r5 == 0) goto L9;
        r6.add((byte) 6, r5);
    L9:
        r6.add((byte) 7, r7);
        r6.addToHeaderSet(this.mHeaderSet);
        this.mFormat = r7;
    }

    @Override // android.bluetooth.client.pbap.BluetoothPbapRequest
    protected void readResponse(InputStream r4) throws IOException {
        Log.v(TAG, "readResponse");
        this.mResponse = new BluetoothPbapVcardList(this.mAccount, r4, this.mFormat);
    }

    @Override // android.bluetooth.client.pbap.BluetoothPbapRequest
    protected void checkResponseCode(int r3) throws IOException {
        Log.v(TAG, "checkResponseCode");
        if (this.mResponse.getCount() == 0) goto L5;
        return;
    L5:
        if (r3 != 196) goto L7;
    L11:
        Log.v(TAG, "Vcard Entry not found");
        return;
    L7:
        if (r3 == 198) goto L11;
        throw new IOException("Invalid response received");
    }

    public VCardEntry getVcard() {
        return this.mResponse.getFirst();
    }
}
