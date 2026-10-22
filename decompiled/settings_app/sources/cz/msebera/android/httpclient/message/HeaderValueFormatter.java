package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface HeaderValueFormatter {
    CharArrayBuffer formatElements(CharArrayBuffer r1, HeaderElement[] r2, boolean r3);

    CharArrayBuffer formatHeaderElement(CharArrayBuffer r1, HeaderElement r2, boolean r3);

    CharArrayBuffer formatNameValuePair(CharArrayBuffer r1, NameValuePair r2, boolean r3);

    CharArrayBuffer formatParameters(CharArrayBuffer r1, NameValuePair[] r2, boolean r3);
}
