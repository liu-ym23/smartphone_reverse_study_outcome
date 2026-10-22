package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.ss.android.http.legacy.HeaderElement;
import com.ss.android.http.legacy.NameValuePair;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface HeaderValueParser {
    HeaderElement[] parseElements(CharArrayBuffer r1, ParserCursor r2);

    HeaderElement parseHeaderElement(CharArrayBuffer r1, ParserCursor r2);

    NameValuePair parseNameValuePair(CharArrayBuffer r1, ParserCursor r2);

    NameValuePair[] parseParameters(CharArrayBuffer r1, ParserCursor r2);
}
