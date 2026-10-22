package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface LineFormatter {
    CharArrayBuffer appendProtocolVersion(CharArrayBuffer r1, ProtocolVersion r2);

    CharArrayBuffer formatHeader(CharArrayBuffer r1, Header r2);

    CharArrayBuffer formatRequestLine(CharArrayBuffer r1, RequestLine r2);

    CharArrayBuffer formatStatusLine(CharArrayBuffer r1, StatusLine r2);
}
