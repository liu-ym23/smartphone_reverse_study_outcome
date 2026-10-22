package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface LineParser {
    boolean hasProtocolVersion(CharArrayBuffer r1, ParserCursor r2);

    Header parseHeader(CharArrayBuffer r1) throws ParseException;

    ProtocolVersion parseProtocolVersion(CharArrayBuffer r1, ParserCursor r2) throws ParseException;

    RequestLine parseRequestLine(CharArrayBuffer r1, ParserCursor r2) throws ParseException;

    StatusLine parseStatusLine(CharArrayBuffer r1, ParserCursor r2) throws ParseException;
}
