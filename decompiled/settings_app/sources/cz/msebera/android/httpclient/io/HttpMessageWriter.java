package cz.msebera.android.httpclient.io;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpMessageWriter<T extends HttpMessage> {
    void write(T r1) throws IOException, HttpException;
}
