package cz.msebera.android.httpclient;

/* JADX INFO: loaded from: classes5.dex */
public interface HeaderElement {
    String getName();

    NameValuePair getParameter(int r1);

    NameValuePair getParameterByName(String r1);

    int getParameterCount();

    NameValuePair[] getParameters();

    String getValue();
}
