package cz.msebera.android.httpclient;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpRequestFactory {
    HttpRequest newHttpRequest(RequestLine r1) throws MethodNotSupportedException;

    HttpRequest newHttpRequest(String r1, String r2) throws MethodNotSupportedException;
}
