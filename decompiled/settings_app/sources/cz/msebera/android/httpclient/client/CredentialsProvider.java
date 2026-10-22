package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;

/* JADX INFO: loaded from: classes5.dex */
public interface CredentialsProvider {
    void clear();

    Credentials getCredentials(AuthScope r1);

    void setCredentials(AuthScope r1, Credentials r2);
}
