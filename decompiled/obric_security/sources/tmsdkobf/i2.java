package tmsdkobf;

import com.qq.taf.jce.JceStruct;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f259a;

    public i2(int r1) {
        this.f259a = ByteBuffer.allocate(r1);
    }

    public void a(int r4) {
        if (this.f259a.remaining() >= r4) goto L6;
        ByteBuffer r5 = ByteBuffer.allocate((this.f259a.capacity() + r4) * 2);
        r5.put(this.f259a.array(), 0, this.f259a.position());
        this.f259a = r5;
        return;
    }

    public void b(byte r2, int r3) {
        if (r3 >= 15) goto L6;
        this.f259a.put((byte) (r2 | (r3 << 4)));
        return;
    L6:
        if (r3 >= 256) goto L10;
        this.f259a.put((byte) (r2 | 240));
        this.f259a.put((byte) r3);
        return;
    L10:
        throw new x1("tag is too large: " + r3);
    }

    public void a(byte r2, int r3) {
        a(3);
        if (r2 != 0) goto L5;
        b(JceStruct.ZERO_TAG, r3);
        return;
    L5:
        b((byte) 0, r3);
        this.f259a.put(r2);
    }

    public void a(short r2, int r3) {
        a(4);
        if (r2 >= (-128)) goto L5;
    L7:
        b((byte) 1, r3);
        this.f259a.putShort(r2);
        return;
    L5:
        if (r2 > 127) goto L7;
        a((byte) r2, r3);
    }

    public void a(int r2, int r3) {
        a(6);
        if (r2 >= (-32768)) goto L5;
    L7:
        b((byte) 2, r3);
        this.f259a.putInt(r2);
        return;
    L5:
        if (r2 > 32767) goto L7;
        a((short) r2, r3);
    }

    public void a(long r3, int r5) {
        a(10);
        if (r3 >= (-2147483648L)) goto L5;
    L7:
        b((byte) 3, r5);
        this.f259a.putLong(r3);
        return;
    L5:
        if (r3 > 2147483647L) goto L7;
        a((int) r3, r5);
    }

    public void a(float r2, int r3) {
        a(6);
        b((byte) 4, r3);
        this.f259a.putFloat(r2);
    }

    public void a(String r3, int r4) {
        byte[] r5 = r3.getBytes("GBK");     // Catch: UnsupportedEncodingException -> L4
    L5:
        a(r5.length + 10);
        if (r5.length <= 255) goto L8;
        b((byte) 7, r4);
        this.f259a.putInt(r5.length);
        this.f259a.put(r5);
        return;
    L8:
        b((byte) 6, r4);
        this.f259a.put((byte) r5.length);
        this.f259a.put(r5);
        return;
    L4:
        r5 = r3.getBytes();
        goto L5
    }

    public void a(Map r3, int r4) {
        a(8);
        b((byte) 8, r4);
        if (r3 != null) goto L5;
        int r0 = 0;
    L6:
        a(r0, 0);
        if (r3 == null) goto L12;
        Iterator r5 = r3.entrySet().iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        Map.Entry r1 = (Map.Entry) r5.next();
        a(r1.getKey(), 0);
        a(r1.getValue(), 1);
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        r0 = r3.size();
        goto L6
    }

    public void a(byte[] r2, int r3) {
        a(r2.length + 8);
        b(JceStruct.SIMPLE_LIST, r3);
        b((byte) 0, 0);
        a(r2.length, 0);
        this.f259a.put(r2);
    }

    public void a(Collection r2, int r3) {
        a(8);
        b((byte) 9, r3);
        if (r2 != null) goto L5;
        int r0 = 0;
    L6:
        a(r0, 0);
        if (r2 == null) goto L12;
        Iterator r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        a(r4.next(), 0);
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        r0 = r2.size();
        goto L6
    }

    public void a(i3 r3, int r4) {
        a(2);
        b((byte) 10, r4);
        r3.a(this);
        a(2);
        b(JceStruct.STRUCT_END, 0);
    }

    public void a(Object r8, int r9) {
        if ((r8 instanceof Byte) == false) goto L6;
        a(((Byte) r8).byteValue(), r9);
        return;
    L6:
        if ((r8 instanceof Boolean) == false) goto L9;
        a(((Boolean) r8).booleanValue() ? 1 : 0, r9);
        return;
    L9:
        if ((r8 instanceof Short) == false) goto L12;
        a(((Short) r8).shortValue(), r9);
        return;
    L12:
        if ((r8 instanceof Integer) == false) goto L15;
        a(((Integer) r8).intValue(), r9);
        return;
    L15:
        if ((r8 instanceof Long) == false) goto L18;
        a(((Long) r8).longValue(), r9);
        return;
    L18:
        if ((r8 instanceof Float) == false) goto L21;
        a(((Float) r8).floatValue(), r9);
        return;
    L21:
        if ((r8 instanceof Double) == false) goto L24;
        double r3 = ((Double) r8).doubleValue();
        a(10);
        b((byte) 5, r9);
        this.f259a.putDouble(r3);
        return;
    L24:
        if ((r8 instanceof String) == false) goto L27;
        a((String) r8, r9);
        return;
    L27:
        if ((r8 instanceof Map) == false) goto L30;
        a((Map) r8, r9);
        return;
    L30:
        if ((r8 instanceof List) == false) goto L33;
        a((List) r8, r9);
        return;
    L33:
        if ((r8 instanceof i3) == false) goto L36;
        a((i3) r8, r9);
        return;
    L36:
        if ((r8 instanceof byte[]) == false) goto L39;
        a((byte[]) r8, r9);
        return;
    L39:
        if ((r8 instanceof boolean[]) == false) goto L44;
        boolean[] r10 = (boolean[]) r8;
        a(8);
        b((byte) 9, r9);
        a(r10.length, 0);
        int r11 = r10.length;
        int r0 = 0;
    L41:
        if (r0 >= r11) goto L98;
        a(r10[r0] ? 1 : 0, 0);
        r0 = r0 + 1;
        goto L41
    L98:
        return;
    L44:
        if ((r8 instanceof short[]) == false) goto L49;
        short[] r12 = (short[]) r8;
        a(8);
        b((byte) 9, r9);
        a(r12.length, 0);
        int r13 = r12.length;
        int r1 = 0;
    L46:
        if (r1 >= r13) goto L99;
        a(r12[r1], 0);
        r1 = r1 + 1;
        goto L46
    L99:
        return;
    L49:
        if ((r8 instanceof int[]) == false) goto L54;
        int[] r14 = (int[]) r8;
        a(8);
        b((byte) 9, r9);
        a(r14.length, 0);
        int r15 = r14.length;
        int r2 = 0;
    L51:
        if (r2 >= r15) goto L100;
        a(r14[r2], 0);
        r2 = r2 + 1;
        goto L51
    L100:
        return;
    L54:
        if ((r8 instanceof long[]) == false) goto L59;
        long[] r16 = (long[]) r8;
        a(8);
        b((byte) 9, r9);
        a(r16.length, 0);
        int r17 = r16.length;
        int r4 = 0;
    L56:
        if (r4 >= r17) goto L101;
        a(r16[r4], 0);
        r4 = r4 + 1;
        goto L56
    L101:
        return;
    L59:
        if ((r8 instanceof float[]) == false) goto L64;
        float[] r18 = (float[]) r8;
        a(8);
        b((byte) 9, r9);
        a(r18.length, 0);
        int r19 = r18.length;
        int r5 = 0;
    L61:
        if (r5 >= r19) goto L102;
        a(r18[r5], 0);
        r5 = r5 + 1;
        goto L61
    L102:
        return;
    L64:
        if ((r8 instanceof double[]) == false) goto L69;
        double[] r20 = (double[]) r8;
        a(8);
        b((byte) 9, r9);
        a(r20.length, 0);
        int r21 = r20.length;
        int r6 = 0;
    L66:
        if (r6 >= r21) goto L103;
        double r7 = r20[r6];
        a(10);
        b((byte) 5, 0);
        this.f259a.putDouble(r7);
        r6 = r6 + 1;
        goto L66
    L103:
        return;
    L69:
        if (r8.getClass().isArray() == false) goto L74;
        Object[] r22 = (Object[]) r8;
        a(8);
        b((byte) 9, r9);
        a(r22.length, 0);
        int r23 = r22.length;
        int r24 = 0;
    L71:
        if (r24 >= r23) goto L104;
        a(r22[r24], 0);
        r24 = r24 + 1;
        goto L71
    L104:
        return;
    L74:
        if ((r8 instanceof Collection) == false) goto L78;
        a((Collection) r8, r9);
        return;
    L78:
        throw new x1(p.a("write object error: unsupport type. ").append(r8.getClass()).toString());
    }
}
