package cz.msebera.android.httpclient.ssl;

import java.net.Socket;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface PrivateKeyStrategy {
    String chooseAlias(Map<String, PrivateKeyDetails> r1, Socket r2);
}
