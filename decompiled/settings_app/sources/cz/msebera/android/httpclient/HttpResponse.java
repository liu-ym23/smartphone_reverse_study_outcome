package cz.msebera.android.httpclient;

import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpResponse extends HttpMessage {
    HttpEntity getEntity();

    Locale getLocale();

    StatusLine getStatusLine();

    void setEntity(HttpEntity r1);

    void setLocale(Locale r1);

    void setReasonPhrase(String r1) throws IllegalStateException;

    void setStatusCode(int r1) throws IllegalStateException;

    void setStatusLine(ProtocolVersion r1, int r2);

    void setStatusLine(ProtocolVersion r1, int r2, String r3);

    void setStatusLine(StatusLine r1);
}
