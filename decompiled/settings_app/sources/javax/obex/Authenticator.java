package javax.obex;

/* JADX INFO: loaded from: classes5.dex */
public interface Authenticator {
    PasswordAuthentication onAuthenticationChallenge(String r1, boolean r2, boolean r3);

    byte[] onAuthenticationResponse(byte[] r1);
}
