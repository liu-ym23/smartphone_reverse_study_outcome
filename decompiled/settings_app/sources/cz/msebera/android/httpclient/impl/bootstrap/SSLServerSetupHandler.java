package cz.msebera.android.httpclient.impl.bootstrap;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;

/* JADX INFO: loaded from: classes5.dex */
public interface SSLServerSetupHandler {
    void initialize(SSLServerSocket r1) throws SSLException;
}
