package tmsdk.common.tcc;

import java.util.Iterator;
import java.util.List;
import tmsdkobf.c0;
import tmsdkobf.dd;
import tmsdkobf.ed;

/* JADX INFO: loaded from: classes5.dex */
public class QSdcardScanner extends c0 {
    private long mNative;
    private ProgressListener mProgressListener;

    public interface ProgressListener {
        boolean onScanPathChange(String r1);
    }

    public QSdcardScanner(long r1, int r3, long r4, Object r6) {
        super(r3, r4);
        this.mNative = r1;
        if (r1 != 0) goto L12;
        return;
    L12:
        nativeInit(r1);     // Catch: NoSuchMethodError -> L10
        if ((r6 instanceof ed) == false) goto L14;
        setRules((ed) r6);
        return;
    L14:
        return;
    L10:
        nativeRelease(this.mNative);
        this.mNative = 0;
    }

    private native void nativeCancle(long r1);

    private native void nativeInit(long r1);

    private native void nativeRelease(long r1);

    private native void nativeScan(long r1, String r3);

    private native void nativeSetProgressListenLevel(long r1, int r3);

    private native void nativeSetRule(long r1, int r3, String[] r4, String[] r5);

    private native void nativeSetWhiteList(long r1, String[] r3);

    private void onFound(int r2, String r3, int r4, long r5, long r7, long r9, long r11) {
        if (this.mListener == null) goto L6;
        QFile r0 = new QFile(r3);
        r0.type = r4;
        r0.size = r5;
        r0.modifyTime = r7;
        r0.accessTime = r9;
        r0.createTime = r11;
        this.mListener.onFound(r2, r0);
        return;
    }

    @Override // tmsdkobf.c0
    protected void doCancleScan() {
        long r0 = this.mNative;
        if (r0 != 0) goto L5;
        return;
    L5:
        nativeCancle(r0);
    }

    @Override // tmsdkobf.c0
    protected void doStartScan(String r5) {
        long r0 = this.mNative;
        if (r0 != 0) goto L5;
        return;
    L5:
        nativeScan(r0, r5);
    }

    protected boolean onProgressChanger(String r1) {
        ProgressListener r0 = this.mProgressListener;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.onScanPathChange(r1);
    }

    public void registerProgressListener(int r5, ProgressListener r6) {
        long r0 = this.mNative;
        if (r0 != 0) goto L5;
        return;
    L5:
        this.mProgressListener = r6;
        nativeSetProgressListenLevel(r0, r5);
    }

    public void release() {
        long r0 = this.mNative;
        if (r0 != 0) goto L5;
        return;
    L5:
        nativeRelease(r0);
        this.mNative = 0;
    }

    public void setRules(ed r8) {
        long r0 = this.mNative;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (r8 == null) goto L19;
        String[] r2 = r8.b;
        if (r2 != null) goto L9;
    L11:
        List r1 = r8.f179a;
        if (r1 != null) goto L14;
        return;
    L14:
        if (r1.size() == 0) goto L22;
        Iterator r9 = r8.f179a.iterator();
    L17:
        if (r9.hasNext() == false) goto L23;
        dd r3 = (dd) r9.next();
        nativeSetRule(this.mNative, r3.f152a, r3.b, r3.c);
        goto L17
    L23:
        return;
    L22:
        return;
    L9:
        if (r2.length == 0) goto L11;
        nativeSetWhiteList(r0, r2);
        goto L11
    }
}
