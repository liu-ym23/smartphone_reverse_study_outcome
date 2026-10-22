package cz.msebera.android.httpclient;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ContentTooLongException extends IOException {
    private static final long serialVersionUID = -924287689552495383L;

    public ContentTooLongException(String r1) {
        super(r1);
    }

    public ContentTooLongException(String r1, Object... r2) {
        super(HttpException.clean(String.format(r1, r2)));
    }
}
