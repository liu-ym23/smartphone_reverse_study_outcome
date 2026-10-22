package com.qq.taf.jce;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tmsdkobf.y5;
import tmsdkobf.y7;

/* JADX INFO: loaded from: classes4.dex */
public class JceOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteBuffer f21a;
    protected String b;

    public JceOutputStream(ByteBuffer r2) {
        this.b = "GBK";
        this.f21a = r2;
    }

    private void a(Object[] r4, int r5) {
        reserve(8);
        writeHead((byte) 9, r5);
        write(r4.length, 0);
        int r6 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L4;
        write(r4[r1], 0);
        r1 = r1 + 1;
        goto L3
    }

    public static void main(String[] r3) {
        JceOutputStream r4 = new JceOutputStream();
        r4.write(1311768467283714885L, 0);
        ByteBuffer r0 = r4.getByteBuffer();
        PrintStream r1 = System.out;
        r1.println(y5.a(r0.array()));
        r1.println(Arrays.toString(r4.toByteArray()));
    }

    public ByteBuffer getByteBuffer() {
        return this.f21a;
    }

    public void reserve(int r4) {
        if (this.f21a.remaining() >= r4) goto L6;
        ByteBuffer r5 = ByteBuffer.allocate((this.f21a.capacity() + r4) * 2);
        r5.put(this.f21a.array(), 0, this.f21a.position());
        this.f21a = r5;
        return;
    }

    public int setServerEncoding(String r1) {
        this.b = r1;
        return 0;
    }

    public byte[] toByteArray() {
        byte[] r0 = new byte[this.f21a.position()];
        System.arraycopy(this.f21a.array(), 0, r0, 0, this.f21a.position());
        return r0;
    }

    public void write(boolean r1, int r2) {
        write(r1 ? 1 : 0, r2);
    }

    public void writeByteString(String r3, int r4) {
        reserve(r3.length() + 10);
        byte[] r5 = y5.a(r3);
        if (r5.length <= 255) goto L5;
        writeHead((byte) 7, r4);
        this.f21a.putInt(r5.length);
        this.f21a.put(r5);
        return;
    L5:
        writeHead((byte) 6, r4);
        this.f21a.put((byte) r5.length);
        this.f21a.put(r5);
    }

    public void writeHead(byte r2, int r3) {
        if (r3 >= 15) goto L6;
        this.f21a.put((byte) (r2 | (r3 << 4)));
        return;
    L6:
        if (r3 >= 256) goto L10;
        this.f21a.put((byte) (r2 | 240));
        this.f21a.put((byte) r3);
        return;
    L10:
        throw new y7("tag is too large: " + r3);
    }

    public void writeStringByte(String r3, int r4) {
        byte[] r5 = y5.a(r3);
        reserve(r5.length + 10);
        if (r5.length <= 255) goto L5;
        writeHead((byte) 7, r4);
        this.f21a.putInt(r5.length);
        this.f21a.put(r5);
        return;
    L5:
        writeHead((byte) 6, r4);
        this.f21a.put((byte) r5.length);
        this.f21a.put(r5);
    }

    public void write(byte r2, int r3) {
        reserve(3);
        if (r2 != 0) goto L5;
        writeHead(JceStruct.ZERO_TAG, r3);
        return;
    L5:
        writeHead((byte) 0, r3);
        this.f21a.put(r2);
    }

    public void write(short r2, int r3) {
        reserve(4);
        if (r2 >= (-128)) goto L5;
    L7:
        writeHead((byte) 1, r3);
        this.f21a.putShort(r2);
        return;
    L5:
        if (r2 > 127) goto L7;
        write((byte) r2, r3);
    }

    public void write(int r2, int r3) {
        reserve(6);
        if (r2 >= (-32768)) goto L5;
    L7:
        writeHead((byte) 2, r3);
        this.f21a.putInt(r2);
        return;
    L5:
        if (r2 > 32767) goto L7;
        write((short) r2, r3);
    }

    public void write(long r3, int r5) {
        reserve(10);
        if (r3 >= (-2147483648L)) goto L5;
    L7:
        writeHead((byte) 3, r5);
        this.f21a.putLong(r3);
        return;
    L5:
        if (r3 > 2147483647L) goto L7;
        write((int) r3, r5);
    }

    public void write(float r2, int r3) {
        reserve(6);
        writeHead((byte) 4, r3);
        this.f21a.putFloat(r2);
    }

    public void write(double r2, int r4) {
        reserve(10);
        writeHead((byte) 5, r4);
        this.f21a.putDouble(r2);
    }

    public void write(String r3, int r4) {
        byte[] r5 = r3.getBytes(this.b);     // Catch: UnsupportedEncodingException -> L4
    L5:
        reserve(r5.length + 10);
        if (r5.length <= 255) goto L8;
        writeHead((byte) 7, r4);
        this.f21a.putInt(r5.length);
        this.f21a.put(r5);
        return;
    L8:
        writeHead((byte) 6, r4);
        this.f21a.put((byte) r5.length);
        this.f21a.put(r5);
        return;
    L4:
        r5 = r3.getBytes();
        goto L5
    }

    public <K, V> void write(Map<K, V> r3, int r4) {
        reserve(8);
        writeHead((byte) 8, r4);
        if (r3 != null) goto L5;
        int r0 = 0;
    L6:
        write(r0, 0);
        if (r3 == null) goto L13;
        Iterator<Map.Entry<K, V>> r5 = r3.entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        Map.Entry<K, V> r1 = r5.next();
        write(r1.getKey(), 0);
        write(r1.getValue(), 1);
        goto L10
    L15:
        return;
    L13:
        return;
    L5:
        r0 = r3.size();
        goto L6
    }

    public void write(boolean[] r4, int r5) {
        reserve(8);
        writeHead((byte) 9, r5);
        write(r4.length, 0);
        int r6 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L4;
        write(r4[r1], 0);
        r1 = r1 + 1;
        goto L3
    }

    public void write(byte[] r2, int r3) {
        reserve(r2.length + 8);
        writeHead(JceStruct.SIMPLE_LIST, r3);
        writeHead((byte) 0, 0);
        write(r2.length, 0);
        this.f21a.put(r2);
    }

    public void write(short[] r4, int r5) {
        reserve(8);
        writeHead((byte) 9, r5);
        write(r4.length, 0);
        int r6 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L4;
        write(r4[r1], 0);
        r1 = r1 + 1;
        goto L3
    }

    public void write(int[] r4, int r5) {
        reserve(8);
        writeHead((byte) 9, r5);
        write(r4.length, 0);
        int r6 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L4;
        write(r4[r1], 0);
        r1 = r1 + 1;
        goto L3
    }

    public void write(long[] r5, int r6) {
        reserve(8);
        writeHead((byte) 9, r6);
        write(r5.length, 0);
        int r7 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L4;
        write(r5[r1], 0);
        r1 = r1 + 1;
        goto L3
    }

    public void write(float[] r4, int r5) {
        reserve(8);
        writeHead((byte) 9, r5);
        write(r4.length, 0);
        int r6 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L4;
        write(r4[r1], 0);
        r1 = r1 + 1;
        goto L3
    }

    public void write(double[] r5, int r6) {
        reserve(8);
        writeHead((byte) 9, r6);
        write(r5.length, 0);
        int r7 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L4;
        write(r5[r1], 0);
        r1 = r1 + 1;
        goto L3
    }

    public <T> void write(T[] r1, int r2) {
        a(r1, r2);
    }

    public <T> void write(Collection<T> r2, int r3) {
        reserve(8);
        writeHead((byte) 9, r3);
        if (r2 != null) goto L5;
        int r0 = 0;
    L6:
        write(r0, 0);
        if (r2 == null) goto L13;
        Iterator<T> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L15;
        write(r4.next(), 0);
        goto L10
    L15:
        return;
    L13:
        return;
    L5:
        r0 = r2.size();
        goto L6
    }

    public void write(JceStruct r3, int r4) {
        reserve(2);
        writeHead((byte) 10, r4);
        r3.writeTo(this);
        reserve(2);
        writeHead(JceStruct.STRUCT_END, 0);
    }

    public void write(Byte r1, int r2) {
        write(r1.byteValue(), r2);
    }

    public void write(Boolean r1, int r2) {
        write(r1.booleanValue(), r2);
    }

    public void write(Short r1, int r2) {
        write(r1.shortValue(), r2);
    }

    public void write(Integer r1, int r2) {
        write(r1.intValue(), r2);
    }

    public void write(Long r3, int r4) {
        write(r3.longValue(), r4);
    }

    public void write(Float r1, int r2) {
        write(r1.floatValue(), r2);
    }

    public void write(Double r3, int r4) {
        write(r3.doubleValue(), r4);
    }

    public void write(Object r3, int r4) {
        if ((r3 instanceof Byte) == false) goto L6;
        write(((Byte) r3).byteValue(), r4);
        return;
    L6:
        if ((r3 instanceof Boolean) == false) goto L9;
        write(((Boolean) r3).booleanValue(), r4);
        return;
    L9:
        if ((r3 instanceof Short) == false) goto L12;
        write(((Short) r3).shortValue(), r4);
        return;
    L12:
        if ((r3 instanceof Integer) == false) goto L15;
        write(((Integer) r3).intValue(), r4);
        return;
    L15:
        if ((r3 instanceof Long) == false) goto L18;
        write(((Long) r3).longValue(), r4);
        return;
    L18:
        if ((r3 instanceof Float) == false) goto L21;
        write(((Float) r3).floatValue(), r4);
        return;
    L21:
        if ((r3 instanceof Double) == false) goto L24;
        write(((Double) r3).doubleValue(), r4);
        return;
    L24:
        if ((r3 instanceof String) == false) goto L27;
        write((String) r3, r4);
        return;
    L27:
        if ((r3 instanceof Map) == false) goto L30;
        write((Map) r3, r4);
        return;
    L30:
        if ((r3 instanceof List) == false) goto L33;
        write((List) r3, r4);
        return;
    L33:
        if ((r3 instanceof JceStruct) == false) goto L36;
        write((JceStruct) r3, r4);
        return;
    L36:
        if ((r3 instanceof byte[]) == false) goto L39;
        write((byte[]) r3, r4);
        return;
    L39:
        if ((r3 instanceof boolean[]) == false) goto L42;
        write((boolean[]) r3, r4);
        return;
    L42:
        if ((r3 instanceof short[]) == false) goto L45;
        write((short[]) r3, r4);
        return;
    L45:
        if ((r3 instanceof int[]) == false) goto L48;
        write((int[]) r3, r4);
        return;
    L48:
        if ((r3 instanceof long[]) == false) goto L51;
        write((long[]) r3, r4);
        return;
    L51:
        if ((r3 instanceof float[]) == false) goto L54;
        write((float[]) r3, r4);
        return;
    L54:
        if ((r3 instanceof double[]) == false) goto L57;
        write((double[]) r3, r4);
        return;
    L57:
        if (r3.getClass().isArray() == false) goto L60;
        a((Object[]) r3, r4);
        return;
    L60:
        if ((r3 instanceof Collection) == false) goto L64;
        write((Collection) r3, r4);
        return;
    L64:
        throw new y7("write object error: unsupport type. " + r3.getClass());
    }

    public JceOutputStream(int r2) {
        this.b = "GBK";
        this.f21a = ByteBuffer.allocate(r2);
    }

    public JceOutputStream() {
        this(128);
    }
}
