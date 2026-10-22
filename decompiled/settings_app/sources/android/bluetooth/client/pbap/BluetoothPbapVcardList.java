package android.bluetooth.client.pbap;

import android.accounts.Account;
import com.android.vcard.VCardEntry;
import com.android.vcard.VCardEntryConstructor;
import com.android.vcard.VCardEntryCounter;
import com.android.vcard.VCardEntryHandler;
import com.android.vcard.VCardInterpreter;
import com.android.vcard.VCardParser;
import com.android.vcard.VCardParser_V21;
import com.android.vcard.VCardParser_V30;
import com.android.vcard.exception.VCardException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class BluetoothPbapVcardList {
    private final Account mAccount;
    private final ArrayList<VCardEntry> mCards;

    class CardEntryHandler implements VCardEntryHandler {
        final /* synthetic */ BluetoothPbapVcardList this$0;

        @Override // com.android.vcard.VCardEntryHandler
        public void onEnd() {
        }

        @Override // com.android.vcard.VCardEntryHandler
        public void onStart() {
        }

        CardEntryHandler(BluetoothPbapVcardList r1) {
            this.this$0 = r1;
        }

        @Override // com.android.vcard.VCardEntryHandler
        public void onEntryCreated(VCardEntry r1) {
            BluetoothPbapVcardList.access$000(this.this$0).add(r1);
        }
    }

    static /* synthetic */ ArrayList access$000(BluetoothPbapVcardList r0) {
        return r0.mCards;
    }

    public BluetoothPbapVcardList(Account r2, InputStream r3, byte r4) throws IOException {
        this.mCards = new ArrayList();
        this.mAccount = r2;
        parse(r3, r4);
    }

    private void parse(InputStream r4, byte r5) throws IOException {
        if (r5 != 1) goto L5;
        VCardParser r6 = new VCardParser_V30();
    L6:
        VCardEntryConstructor r0 = new VCardEntryConstructor(-1040187392, this.mAccount);
        VCardInterpreter r1 = new VCardEntryCounter();
        r0.addEntryHandler(new CardEntryHandler(this));
        r6.addInterpreter(r0);
        r6.addInterpreter(r1);
        r6.parse(r4);     // Catch: VCardException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        r6 = new VCardParser_V21();
        goto L6
    }

    public int getCount() {
        return this.mCards.size();
    }

    public ArrayList<VCardEntry> getList() {
        return this.mCards;
    }

    public VCardEntry getFirst() {
        return this.mCards.get(0);
    }
}
