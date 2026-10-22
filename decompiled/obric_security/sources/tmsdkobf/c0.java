package tmsdkobf;

import tmsdk.common.tcc.QFile;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c0 {
    protected long mFlag;
    protected a mListener;
    protected int mType;

    public interface a {
        void onFound(int r1, QFile r2);
    }

    public c0(int r1, long r2) {
        this.mType = r1;
        this.mFlag = r2;
    }

    public void cancleScan() {
        doCancleScan();
    }

    protected abstract void doCancleScan();

    protected abstract void doStartScan(String r1);

    public void setListener(a r1) {
        this.mListener = r1;
    }

    public void startScan(String r1) {
        doStartScan(r1);
    }
}
