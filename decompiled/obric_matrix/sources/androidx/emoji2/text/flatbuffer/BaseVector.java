package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class BaseVector {
    protected ByteBuffer bb;
    private int element_size;
    private int length;
    private int vector;

    public BaseVector() {
    }

    protected int __element(int r2) {
        return this.vector + (r2 * this.element_size);
    }

    protected void __reset(int r1, int r2, ByteBuffer r3) {
        this.bb = r3;
        if (r3 == null) goto L5;
        this.vector = r1;
        this.length = r3.getInt(r1 - 4);
        this.element_size = r2;
        return;
    L5:
        this.vector = 0;
        this.length = 0;
        this.element_size = 0;
    }

    protected int __vector() {
        return this.vector;
    }

    public int length() {
        return this.length;
    }

    public void reset() {
        __reset(0, 0, null);
    }
}
