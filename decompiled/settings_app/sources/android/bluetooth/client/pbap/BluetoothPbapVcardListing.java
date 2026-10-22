package android.bluetooth.client.pbap;

import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
class BluetoothPbapVcardListing {
    private static final String TAG = "BluetoothPbapVcardListing";
    ArrayList<BluetoothPbapCard> mCards;

    public BluetoothPbapVcardListing(InputStream r2) throws IOException {
        this.mCards = new ArrayList();
        parse(r2);
    }

    private void parse(InputStream r5) throws IOException {
        XmlPullParser r0 = Xml.newPullParser();
        r0.setInput(r5, "UTF-8");     // Catch: XmlPullParserException -> L13
        int r6 = r0.getEventType();     // Catch: XmlPullParserException -> L13
    L5:
        if (r6 == 1) goto L22;
        if (r6 != 2) goto L11;
        if (r0.getName().equals("card") == false) goto L11;
        BluetoothPbapCard r7 = new BluetoothPbapCard(r0.getAttributeValue(null, "handle"), r0.getAttributeValue(null, "name"));     // Catch: XmlPullParserException -> L13
        this.mCards.add(r7);     // Catch: XmlPullParserException -> L13
    L11:
        r6 = r0.next();     // Catch: XmlPullParserException -> L13
        goto L5
    L22:
        return;
    L13:
        e = move-exception;
        Log.e(TAG, "XML parser error when parsing XML", e);
    }

    public ArrayList<BluetoothPbapCard> getList() {
        return this.mCards;
    }
}
