package com.tencent.qqimagecompare;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class QQImageFeatureHSV extends QQImageNativeObject {
    public QQImageFeatureHSV() {
    }

    private native int CompareC(long r1, QQImageFeatureHSV r3);

    private static native void FreeSerializationBufferC(ByteBuffer r0);

    private native int GetImageFeatureC(long r1, Bitmap r3);

    private native ByteBuffer SerializationC(long r1);

    private native int UnserializationC(long r1, byte[] r3);

    public int compare(QQImageFeatureHSV r3) {
        return CompareC(this.mThisC, r3);
    }

    @Override // com.tencent.qqimagecompare.QQImageNativeObject
    protected native long createNativeObject();

    @Override // com.tencent.qqimagecompare.QQImageNativeObject
    protected native void destroyNativeObject(long r1);

    public int getImageFeature(Bitmap r3) {
        return GetImageFeatureC(this.mThisC, r3);
    }

    public byte[] serialization() {
        ByteBuffer r2 = SerializationC(this.mThisC);
        byte[] r0 = new byte[r2.limit()];
        r2.get(r0);
        FreeSerializationBufferC(r2);
        return r0;
    }

    public int unserialization(byte[] r3) {
        return UnserializationC(this.mThisC, r3);
    }
}
