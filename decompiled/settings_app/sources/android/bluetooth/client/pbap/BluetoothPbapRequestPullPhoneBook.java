package android.bluetooth.client.pbap;

import android.accounts.Account;
import android.bluetooth.client.pbap.utils.ObexAppParameters;
import android.util.Log;
import com.android.vcard.VCardEntry;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.obex.HeaderSet;

/* JADX INFO: loaded from: classes.dex */
final class BluetoothPbapRequestPullPhoneBook extends BluetoothPbapRequest {
    private static final boolean DBG = true;
    private static final String TAG = "BluetoothPbapRequestPullPhoneBook";
    private static final String TYPE = "x-bt/phonebook";
    private Account mAccount;
    private final byte mFormat;
    private int mNewMissedCalls;
    private BluetoothPbapVcardList mResponse;

    public BluetoothPbapRequestPullPhoneBook(String r4, Account r5, long r6, byte r8, int r9, int r10) {
        this.mNewMissedCalls = -1;
        this.mAccount = r5;
        if (r9 < 0) goto L26;
        if (r9 > 65535) goto L26;
        if (r10 < 0) goto L24;
        if (r10 > 65535) goto L24;
        this.mHeaderSet.setHeader(1, r4);
        this.mHeaderSet.setHeader(66, TYPE);
        ObexAppParameters r7 = new ObexAppParameters();
        if (r8 == 0) goto L13;
        if (r8 == 1) goto L13;
        r8 = 0;
    L13:
        if (r6 == 0) goto L15;
        r7.add((byte) 6, r6);
    L15:
        r7.add((byte) 7, r8);
        if (r9 <= 0) goto L18;
        r7.add((byte) 4, (short) r9);
    L19:
        if (r10 <= 0) goto L21;
        r7.add((byte) 5, (short) r10);
    L21:
        r7.addToHeaderSet(this.mHeaderSet);
        this.mFormat = r8;
        return;
    L18:
        r7.add((byte) 4, -1);
    L24:
        throw new IllegalArgumentException("listStartOffset should be [0..65535]");
    L26:
        throw new IllegalArgumentException("maxListCount should be [0..65535]");
    }

    @Override // android.bluetooth.client.pbap.BluetoothPbapRequest
    protected void readResponse(InputStream r5) throws IOException {
        Log.v(TAG, "readResponse");
        this.mResponse = new BluetoothPbapVcardList(this.mAccount, r5, this.mFormat);
        Log.d(TAG, "Read " + this.mResponse.getCount() + " entries.");
    }

    @Override // android.bluetooth.client.pbap.BluetoothPbapRequest
    protected void readResponseHeaders(HeaderSet r3) {
        Log.v(TAG, "readResponseHeaders");
        ObexAppParameters r4 = ObexAppParameters.fromHeaderSet(r3);
        if (r4.exists((byte) 9) == false) goto L6;
        this.mNewMissedCalls = r4.getByte((byte) 9);
        return;
    }

    public ArrayList<VCardEntry> getList() {
        return this.mResponse.getList();
    }

    public int getNewMissedCalls() {
        return this.mNewMissedCalls;
    }
}
