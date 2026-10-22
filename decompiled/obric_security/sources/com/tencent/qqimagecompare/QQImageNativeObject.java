package com.tencent.qqimagecompare;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QQImageNativeObject {
    protected long mThisC;

    public QQImageNativeObject() {
    }

    protected abstract long createNativeObject();

    protected abstract void destroyNativeObject(long r1);

    public void finish() {
        long r0 = this.mThisC;
        if (r0 == 0) goto L6;
        destroyNativeObject(r0);
        this.mThisC = 0;
        return;
    }

    public long getThisPointAddressInC() {
        return this.mThisC;
    }

    public void init() {
        if (this.mThisC != 0) goto L6;
        this.mThisC = createNativeObject();
        return;
    }
}
