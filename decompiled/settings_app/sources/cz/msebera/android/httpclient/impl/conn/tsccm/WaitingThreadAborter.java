package cz.msebera.android.httpclient.impl.conn.tsccm;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class WaitingThreadAborter {
    private boolean aborted;
    private WaitingThread waitingThread;

    public WaitingThreadAborter() {
    }

    public void abort() {
        this.aborted = true;
        WaitingThread r1 = this.waitingThread;
        if (r1 == null) goto L6;
        r1.interrupt();
        return;
    }

    public void setWaitingThread(WaitingThread r1) {
        this.waitingThread = r1;
        if (this.aborted == false) goto L6;
        r1.interrupt();
        return;
    }
}
