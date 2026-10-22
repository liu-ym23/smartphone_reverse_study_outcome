package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface HeaderValueParser {
    HeaderElement[] parseElements(CharArrayBuffer r1, ParserCursor r2) throws ParseException;

    HeaderElement parseHeaderElement(CharArrayBuffer r1, ParserCursor r2) throws ParseException;

    NameValuePair parseNameValuePair(CharArrayBuffer r1, ParserCursor r2) throws ParseException;

    NameValuePair[] parseParameters(CharArrayBuffer r1, ParserCursor r2) throws ParseException;
}
