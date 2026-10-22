package javax.obex;

import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ObexSession {
    private static final String TAG = "ObexSession";
    private static final boolean V = false;
    protected Authenticator mAuthenticator;
    protected byte[] mChallengeDigest;

    public ObexSession() {
    }

    static {
        V = ObexHelper.VDBG;
    }

    public boolean handleAuthChall(HeaderSet r11) throws IOException {
        if (this.mAuthenticator != null) goto L5;
        return false;
    L5:
        byte[] r0 = ObexHelper.getTagValue((byte) 0, r11.mAuthChall);
        byte[] r2 = ObexHelper.getTagValue((byte) 1, r11.mAuthChall);
        byte[] r4 = ObexHelper.getTagValue((byte) 2, r11.mAuthChall);
        if (r4 == null) goto L18;
        int r7 = r4.length - 1;
        byte[] r8 = new byte[r7];
        System.arraycopy(r4, 1, r8, 0, r7);
        int r5 = r4[0] & 255;
        if (r5 == 0) goto L47;
        if (r5 == 1) goto L47;
        if (r5 != 255) goto L13;
        String r6 = ObexHelper.convertToUnicode(r8, false);
    L19:
        if (r2 == null) goto L27;
        byte r3 = r2[0];
        if ((r3 & 1) == 0) goto L23;
        boolean r9 = true;
    L25:
        if ((r3 & 2) == 0) goto L28;
        boolean r10 = false;
    L29:
        r11.mAuthChall = null;
        PasswordAuthentication r12 = this.mAuthenticator.onAuthenticationChallenge(r6, r9, r10);     // Catch: Exception -> L42
        if (r12 != null) goto L33;
        return false;
    L33:
        byte[] r13 = r12.getPassword();
        if (r13 != null) goto L36;
        return false;
    L36:
        byte[] r14 = r12.getUserName();
        if (r14 == null) goto L39;
        r11.mAuthResp = new byte[r14.length + 38];
        r11.mAuthResp[36] = 1;
        r11.mAuthResp[37] = (byte) r14.length;
        System.arraycopy(r14, 0, r11.mAuthResp, 38, r14.length);
    L40:
        byte[] r15 = new byte[(r0.length + r13.length) + 1];
        System.arraycopy(r0, 0, r15, 0, r0.length);
        r15[r0.length] = 58;
        System.arraycopy(r13, 0, r15, r0.length + 1, r13.length);
        r11.mAuthResp[0] = 0;
        r11.mAuthResp[1] = 16;
        System.arraycopy(ObexHelper.computeMd5Hash(r15), 0, r11.mAuthResp, 2, 16);
        r11.mAuthResp[18] = 2;
        r11.mAuthResp[19] = 16;
        System.arraycopy(r0, 0, r11.mAuthResp, 20, 16);
        return true;
    L39:
        r11.mAuthResp = new byte[36];
    L42:
        e = move-exception;
        if (V == false) goto L46;
        Log.d(TAG, "Exception occured - returning false", e);
    L46:
        return false;
    L28:
        r10 = true;
        goto L29
    L23:
        r9 = false;
        goto L25
    L27:
        r9 = false;
        goto L28
    L13:
        throw new IOException("Unsupported Encoding Scheme");
    L47:
        r6 = new String(r8, "ISO8859_1");     // Catch: Exception -> L16
    L17:
        throw new IOException("Unsupported Encoding Scheme");
    L18:
        r6 = null;
        goto L19
    }

    public boolean handleAuthResp(byte[] r7) {
        Authenticator r0 = this.mAuthenticator;
        if (r0 != null) goto L5;
        return false;
    L5:
        byte[] r1 = r0.onAuthenticationResponse(ObexHelper.getTagValue((byte) 1, r7));
        if (r1 != null) goto L8;
        return false;
    L8:
        byte[] r3 = new byte[r1.length + 16];
        System.arraycopy(this.mChallengeDigest, 0, r3, 0, 16);
        System.arraycopy(r1, 0, r3, 16, r1.length);
        byte[] r6 = ObexHelper.computeMd5Hash(r3);
        byte[] r8 = ObexHelper.getTagValue((byte) 0, r7);
        int r2 = 0;
    L9:
        if (r2 >= 16) goto L14;
        if (r6[r2] != r8[r2]) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return false;
    L14:
        return true;
    }
}
