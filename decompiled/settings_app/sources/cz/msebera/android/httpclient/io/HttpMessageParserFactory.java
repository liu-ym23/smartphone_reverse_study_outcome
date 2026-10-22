package cz.msebera.android.httpclient.io;

import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.config.MessageConstraints;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpMessageParserFactory<T extends HttpMessage> {
    HttpMessageParser<T> create(SessionInputBuffer r1, MessageConstraints r2);
}
