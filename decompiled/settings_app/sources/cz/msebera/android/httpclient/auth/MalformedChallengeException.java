package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.ProtocolException;

/* JADX INFO: loaded from: classes5.dex */
public class MalformedChallengeException extends ProtocolException {
    private static final long serialVersionUID = 814586927989932284L;

    public MalformedChallengeException() {
    }

    public MalformedChallengeException(String r1) {
        super(r1);
    }

    public MalformedChallengeException(String r1, Throwable r2) {
        super(r1, r2);
    }
}
