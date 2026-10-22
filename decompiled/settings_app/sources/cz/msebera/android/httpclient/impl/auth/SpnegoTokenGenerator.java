package cz.msebera.android.httpclient.impl.auth;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface SpnegoTokenGenerator {
    byte[] generateSpnegoDERObject(byte[] r1) throws IOException;
}
