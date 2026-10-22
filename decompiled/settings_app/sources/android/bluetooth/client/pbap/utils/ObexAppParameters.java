package android.bluetooth.client.pbap.utils;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.obex.HeaderSet;

/* JADX INFO: loaded from: classes.dex */
public final class ObexAppParameters {
    private final HashMap<Byte, byte[]> mParams;

    public ObexAppParameters() {
        this.mParams = new HashMap();
    }

    public ObexAppParameters(byte[] r6) {
        this.mParams = new HashMap();
        if (r6 == 0) goto L14;
        int r1 = 0;
    L6:
        if (r1 >= r6.length) goto L18;
        if ((r6.length - r1) < 2) goto L19;
        int r2 = r1 + 1;
        byte r3 = r6[r1];
        int r4 = r2 + 1;
        int r5 = r6[r2];
        if (((r6.length - r4) - r5) < 0) goto L20;
        byte[] r7 = new byte[r5];
        System.arraycopy(r6, r4, r7, 0, r5);
        add(r3, r7);
        r1 = r4 + r5;
        goto L6
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public static ObexAppParameters fromHeaderSet(HeaderSet r1) {
        return new ObexAppParameters((byte[]) r1.getHeader(76));
    L5:
        return null;
    }

    public byte[] getHeader() {
        Iterator<Map.Entry<Byte, byte[]>> r0 = this.mParams.entrySet().iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r2 = r2 + (r0.next().getValue().length + 2);
        goto L4
    L6:
        byte[] r1 = new byte[r2];
        Iterator<Map.Entry<Byte, byte[]>> r7 = this.mParams.entrySet().iterator();
        int r3 = 0;
    L8:
        if (r7.hasNext() == false) goto L10;
        Map.Entry<Byte, byte[]> r4 = r7.next();
        int r5 = r4.getValue().length;
        int r6 = r3 + 1;
        r1[r3] = r4.getKey().byteValue();
        int r8 = r6 + 1;
        r1[r6] = (byte) r5;
        System.arraycopy(r4.getValue(), 0, r1, r8, r5);
        r3 = r8 + r5;
        goto L8
    L10:
        return r1;
    }

    public void addToHeaderSet(HeaderSet r2) {
        if (this.mParams.size() <= 0) goto L6;
        r2.setHeader(76, getHeader());
        return;
    }

    public boolean exists(byte r1) {
        return this.mParams.containsKey(Byte.valueOf(r1));
    }

    public void add(byte r2, byte r3) {
        byte[] r4 = ByteBuffer.allocate(1).put(r3).array();
        this.mParams.put(Byte.valueOf(r2), r4);
    }

    public void add(byte r2, short r3) {
        byte[] r4 = ByteBuffer.allocate(2).putShort(r3).array();
        this.mParams.put(Byte.valueOf(r2), r4);
    }

    public void add(byte r2, int r3) {
        byte[] r4 = ByteBuffer.allocate(4).putInt(r3).array();
        this.mParams.put(Byte.valueOf(r2), r4);
    }

    public void add(byte r2, long r3) {
        byte[] r4 = ByteBuffer.allocate(8).putLong(r3).array();
        this.mParams.put(Byte.valueOf(r2), r4);
    }

    public void add(byte r1, String r2) {
        byte[] r3 = r2.getBytes();
        this.mParams.put(Byte.valueOf(r1), r3);
    }

    public void add(byte r1, byte[] r2) {
        this.mParams.put(Byte.valueOf(r1), r2);
    }

    public byte getByte(byte r2) {
        byte[] r1 = this.mParams.get(Byte.valueOf(r2));
        if (r1 != null) goto L5;
        return 0;
    L5:
        if (r1.length >= 1) goto L8;
        return 0;
    L8:
        return ByteBuffer.wrap(r1).get();
    }

    public short getShort(byte r2) {
        byte[] r1 = this.mParams.get(Byte.valueOf(r2));
        if (r1 != null) goto L5;
        return 0;
    L5:
        if (r1.length >= 2) goto L8;
        return 0;
    L8:
        return ByteBuffer.wrap(r1).getShort();
    }

    public int getInt(byte r2) {
        byte[] r1 = this.mParams.get(Byte.valueOf(r2));
        if (r1 != null) goto L5;
        return 0;
    L5:
        if (r1.length >= 4) goto L8;
        return 0;
    L8:
        return ByteBuffer.wrap(r1).getInt();
    }

    public String getString(byte r1) {
        byte[] r0 = this.mParams.get(Byte.valueOf(r1));
        if (r0 != null) goto L7;
        return null;
    L7:
        return new String(r0);
    }

    public byte[] getByteArray(byte r1) {
        return this.mParams.get(Byte.valueOf(r1));
    }

    public String toString() {
        return this.mParams.toString();
    }
}
