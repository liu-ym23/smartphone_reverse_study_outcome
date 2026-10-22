package javax.obex;

/* JADX INFO: loaded from: classes5.dex */
public class ServerRequestHandler {
    private long mConnectionId;

    public boolean isSrmSupported() {
        return false;
    }

    public int onAbort(HeaderSet r1, HeaderSet r2) {
        return 209;
    }

    public void onAuthenticationFailure(byte[] r1) {
    }

    public void onClose() {
    }

    public int onConnect(HeaderSet r1, HeaderSet r2) {
        return 160;
    }

    public int onDelete(HeaderSet r1, HeaderSet r2) {
        return 209;
    }

    public void onDisconnect(HeaderSet r1, HeaderSet r2) {
    }

    public int onGet(Operation r1) {
        return 209;
    }

    public int onPut(Operation r1) {
        return 209;
    }

    public int onSetPath(HeaderSet r1, HeaderSet r2, boolean r3, boolean r4) {
        return 209;
    }

    public void updateStatus(String r1) {
    }

    protected ServerRequestHandler() {
        this.mConnectionId = -1;
    }

    public void setConnectionId(long r3) {
        if (r3 < (-1)) goto L9;
        if (r3 > 4294967295L) goto L9;
        this.mConnectionId = r3;
        return;
    L9:
        throw new IllegalArgumentException("Illegal Connection ID");
    }

    public long getConnectionId() {
        return this.mConnectionId;
    }
}
