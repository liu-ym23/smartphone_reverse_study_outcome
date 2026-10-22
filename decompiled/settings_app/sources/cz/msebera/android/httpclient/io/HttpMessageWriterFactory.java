package cz.msebera.android.httpclient.io;

import cz.msebera.android.httpclient.HttpMessage;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpMessageWriterFactory<T extends HttpMessage> {
    HttpMessageWriter<T> create(SessionOutputBuffer r1);
}
