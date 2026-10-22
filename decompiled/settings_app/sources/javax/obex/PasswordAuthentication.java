package javax.obex;

/* JADX INFO: loaded from: classes5.dex */
public final class PasswordAuthentication {
    private final byte[] mPassword;
    private byte[] mUserName;

    public PasswordAuthentication(byte[] r4, byte[] r5) {
        if (r4 == null) goto L5;
        byte[] r1 = new byte[r4.length];
        this.mUserName = r1;
        System.arraycopy(r4, 0, r1, 0, r4.length);
    L5:
        byte[] r6 = new byte[r5.length];
        this.mPassword = r6;
        System.arraycopy(r5, 0, r6, 0, r5.length);
    }

    public byte[] getUserName() {
        return this.mUserName;
    }

    public byte[] getPassword() {
        return this.mPassword;
    }
}
