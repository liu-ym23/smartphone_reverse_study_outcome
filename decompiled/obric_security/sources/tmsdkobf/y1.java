package tmsdkobf;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f629a;
    public String b;

    public y1() {
        this.b = "GBK";
    }

    public final void a() {
        ByteBuffer r0 = this.f629a;
        byte r1 = r0.get();
        byte r2 = (byte) (r1 & 15);
        if (((r1 & 240) >> 4) != 15) goto L5;
        r0.get();
    L5:
        a(r2);
    }

    public boolean b(int r7) {
    L17:
        ByteBuffer r1 = this.f629a.duplicate();     // Catch: Throwable -> L16
        byte r2 = r1.get();     // Catch: Throwable -> L16
        byte r3 = (byte) (r2 & 15);     // Catch: Throwable -> L16
        int r4 = (r2 & 240) >> 4;     // Catch: Throwable -> L16
        if (r4 != 15) goto L6;
        r4 = r1.get() & UByte.MAX_VALUE;     // Catch: Throwable -> L16
        int r5 = 2;
    L7:
        if (r7 <= r4) goto L13;
        if (r3 == 11) goto L13;
        a(r5);     // Catch: Throwable -> L16
        a(r3);     // Catch: Throwable -> L16
    L13:
        if (r7 == r4) goto L15;
        return false;
    L15:
        return true;
    L6:
        r5 = 1;
    L22:
        return false;
    }

    public final void a(int r2) {
        ByteBuffer r1 = this.f629a;
        r1.position(r1.position() + r2);
    }

    public final void a(byte r7) {
        int r4 = 0;
        switch(r7) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L17;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L35;
            case 12: goto L35;
            case 13: goto L6;
            default: goto L5;
        };
    L6:
        ByteBuffer r0 = this.f629a;
        byte r1 = r0.get();
        byte r5 = (byte) (r1 & 15);
        if (((r1 & 240) >> 4) != 15) goto L9;
        r0.get();
    L9:
        if (r5 != 0) goto L12;
        a(a(0, 0, true));
        return;
    L12:
        throw new w1("skipField with invalid type, type value: " + r7 + ", " + r5);
    L13:
        b();
        return;
    L14:
        int r8 = a(0, 0, true);
    L15:
        if (r4 >= r8) goto L45;
        a();
        r4 = r4 + 1;
        goto L15
    L45:
        return;
    L17:
        int r9 = a(0, 0, true);
    L19:
        if (r4 >= (r9 * 2)) goto L46;
        a();
        r4 = r4 + 1;
        goto L19
    L46:
        return;
    L21:
        a(this.f629a.getInt());
        return;
    L22:
        int r10 = this.f629a.get();
        if (r10 >= 0) goto L25;
        r10 = r10 + 256;
    L25:
        a(r10);
        return;
    L26:
        a(8);
        return;
    L27:
        a(4);
        return;
    L28:
        a(8);
        return;
    L29:
        a(4);
        return;
    L30:
        a(2);
        return;
    L31:
        a(1);
        return;
    L35:
        return;
    L5:
        throw new w1("invalid type.");
    }

    public void b() {
    L3:
        if (this.f629a.remaining() == 0) goto L10;
        ByteBuffer r0 = this.f629a;
        byte r1 = r0.get();
        byte r2 = (byte) (r1 & 15);
        if (((r1 & 240) >> 4) != 15) goto L8;
        r0.get();
    L8:
        a(r2);
        if (r2 != 11) goto L3;
        return;
    }

    public String b(int r3, boolean r4) {
        if (b(r3) == false) goto L32;
        ByteBuffer r5 = this.f629a;
        byte r6 = r5.get();
        byte r0 = (byte) (r6 & 15);
        if (((r6 & 240) >> 4) != 15) goto L8;
        r5.get();
    L8:
        if (r0 != 6) goto L10;
        int r7 = this.f629a.get();
        if (r7 >= 0) goto L28;
        r7 = r7 + 256;
    L28:
        byte[] r8 = new byte[r7];
        this.f629a.get(r8);
        String r9 = new String(r8, this.b);     // Catch: UnsupportedEncodingException -> L31
    L42:
        return r9;
    L43:
        return new String(r8);
    L10:
        if (r0 != 7) goto L12;
        int r10 = this.f629a.getInt();
        if (r10 > 104857600) goto L24;
        if (r10 < 0) goto L24;
        byte[] r11 = new byte[r10];
        this.f629a.get(r11);
        r9 = new String(r11, this.b);     // Catch: UnsupportedEncodingException -> L22
    L41:
        return new String(r11);
    L24:
        throw new w1("String too long: " + r10);
    L12:
        if (r0 != 11) goto L15;
    L33:
        return null;
    L15:
        throw new w1("type mismatch.");
    L32:
        if (r4 == false) goto L33;
        throw new w1("require field not exist.");
    }

    public boolean a(boolean r1, int r2, boolean r3) {
        if (a(r1 ? 1 : 0, r2, r3) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public byte a(byte r3, int r4, boolean r5) {
        if (b(r4) == false) goto L16;
        ByteBuffer r6 = this.f629a;
        byte r7 = r6.get();
        byte r0 = (byte) (r7 & 15);
        if (((r7 & 240) >> 4) != 15) goto L7;
        r6.get();
    L7:
        if (r0 == 0) goto L21;
        if (r0 != 11) goto L11;
        return r3;
    L11:
        if (r0 != 12) goto L14;
        return 0;
    L14:
        throw new w1("type mismatch.");
    L21:
        return this.f629a.get();
    L16:
        if (r5 == true) goto L19;
        return r3;
    L19:
        throw new w1("require field not exist.");
    }

    public short a(short r3, int r4, boolean r5) {
        if (b(r4) == false) goto L19;
        ByteBuffer r6 = this.f629a;
        byte r7 = r6.get();
        byte r0 = (byte) (r7 & 15);
        if (((r7 & 240) >> 4) != 15) goto L7;
        r6.get();
    L7:
        if (r0 == 0) goto L25;
        if (r0 == 1) goto L24;
        if (r0 != 11) goto L13;
        return r3;
    L13:
        if (r0 != 12) goto L16;
        return 0;
    L16:
        throw new w1("type mismatch.");
    L24:
        return this.f629a.getShort();
    L25:
        return this.f629a.get();
    L19:
        if (r5 == true) goto L22;
        return r3;
    L22:
        throw new w1("require field not exist.");
    }

    public final Object[] b(Object r5, int r6, boolean r7) {
        if (b(r6) == false) goto L22;
        ByteBuffer r8 = this.f629a;
        byte r9 = r8.get();
        byte r0 = (byte) (r9 & 15);
        if (((r9 & 240) >> 4) != 15) goto L8;
        r8.get();
    L8:
        if (r0 != 9) goto L10;
        int r1 = a(0, 0, true);
        if (r1 < 0) goto L21;
        Object[] r2 = (Object[]) Array.newInstance(r5.getClass(), r1);
        int r3 = 0;
    L17:
        if (r3 >= r1) goto L19;
        r2[r3] = a(r5, 0, true);
        r3 = r3 + 1;
        goto L17
    L19:
        return r2;
    L21:
        throw new w1("size invalid: " + r1);
    L10:
        if (r0 != 11) goto L13;
        return null;
    L13:
        throw new w1("type mismatch.");
    L22:
        if (r7 == true) goto L26;
        return null;
    L26:
        throw new w1("require field not exist.");
    }

    public int a(int r3, int r4, boolean r5) {
        if (b(r4) == false) goto L22;
        ByteBuffer r6 = this.f629a;
        byte r7 = r6.get();
        byte r0 = (byte) (r7 & 15);
        if (((r7 & 240) >> 4) != 15) goto L7;
        r6.get();
    L7:
        if (r0 == 0) goto L29;
        if (r0 == 1) goto L28;
        if (r0 == 2) goto L27;
        if (r0 != 11) goto L15;
        return r3;
    L15:
        if (r0 != 12) goto L18;
        return 0;
    L18:
        throw new w1("type mismatch.");
    L27:
        return this.f629a.getInt();
    L28:
        return this.f629a.getShort();
    L29:
        return this.f629a.get();
    L22:
        if (r5 == true) goto L25;
        return r3;
    L25:
        throw new w1("require field not exist.");
    }

    public long a(long r3, int r5, boolean r6) {
        if (b(r5) == false) goto L26;
        ByteBuffer r7 = this.f629a;
        byte r8 = r7.get();
        byte r0 = (byte) (r8 & 15);
        if (((r8 & 240) >> 4) != 15) goto L8;
        r7.get();
    L8:
        if (r0 != 11) goto L10;
        return r3;
    L10:
        if (r0 == 12) goto L25;
        if (r0 != 0) goto L13;
        int r2 = this.f629a.get();
    L31:
        return r2;
    L13:
        if (r0 != 1) goto L15;
        r2 = this.f629a.getShort();
        goto L31
    L15:
        if (r0 != 2) goto L17;
        r2 = this.f629a.getInt();
        goto L31
    L17:
        if (r0 != 3) goto L20;
        return this.f629a.getLong();
    L20:
        throw new w1("type mismatch.");
    L25:
        return 0;
    L26:
        if (r6 == true) goto L29;
        return r3;
    L29:
        throw new w1("require field not exist.");
    }

    public float a(float r4, int r5, boolean r6) {
        if (b(r5) == false) goto L16;
        ByteBuffer r7 = this.f629a;
        byte r8 = r7.get();
        byte r0 = (byte) (r8 & 15);
        if (((r8 & 240) >> 4) != 15) goto L7;
        r7.get();
    L7:
        if (r0 == 4) goto L21;
        if (r0 != 11) goto L11;
        return r4;
    L11:
        if (r0 != 12) goto L14;
        return 0.0f;
    L14:
        throw new w1("type mismatch.");
    L21:
        return this.f629a.getFloat();
    L16:
        if (r6 == true) goto L19;
        return r4;
    L19:
        throw new w1("require field not exist.");
    }

    public double a(double r4, int r6, boolean r7) {
        if (b(r6) == false) goto L19;
        ByteBuffer r8 = this.f629a;
        byte r9 = r8.get();
        byte r0 = (byte) (r9 & 15);
        if (((r9 & 240) >> 4) != 15) goto L7;
        r8.get();
    L7:
        if (r0 == 4) goto L25;
        if (r0 == 5) goto L24;
        if (r0 != 11) goto L13;
        return r4;
    L13:
        if (r0 != 12) goto L16;
        return 0.0d;
    L16:
        throw new w1("type mismatch.");
    L24:
        return this.f629a.getDouble();
    L25:
        return this.f629a.getFloat();
    L19:
        if (r7 == true) goto L22;
        return r4;
    L22:
        throw new w1("require field not exist.");
    }

    public HashMap a(Map r7, int r8, boolean r9) {
        HashMap r0 = new HashMap();
        if (r7 == null) goto L31;
        if (r7.isEmpty() == true) goto L31;
        Map.Entry r10 = (Map.Entry) r7.entrySet().iterator().next();
        Object r1 = r10.getKey();
        Object r11 = r10.getValue();
        if (b(r8) == false) goto L26;
        ByteBuffer r12 = this.f629a;
        byte r13 = r12.get();
        byte r2 = (byte) (r13 & 15);
        if (((r13 & 240) >> 4) != 15) goto L13;
        r12.get();
    L13:
        if (r2 != 8) goto L15;
        int r3 = a(0, 0, true);
        if (r3 < 0) goto L25;
        int r4 = 0;
    L22:
        if (r4 >= r3) goto L35;
        r0.put(a(r1, 0, true), a(r11, 1, true));
        r4 = r4 + 1;
        goto L22
    L35:
        return r0;
    L25:
        throw new w1("size invalid: " + r3);
    L15:
        if (r2 != 11) goto L18;
        return r0;
    L18:
        throw new w1("type mismatch.");
    L26:
        if (r9 == true) goto L29;
        return r0;
    L29:
        throw new w1("require field not exist.");
    L31:
        return new HashMap();
    }

    public byte[] a(int r7, boolean r8) {
        if (b(r7) == false) goto L35;
        ByteBuffer r9 = this.f629a;
        byte r0 = r9.get();
        byte r1 = (byte) (r0 & 15);
        if (((r0 & 240) >> 4) != 15) goto L8;
        r9.get();
    L8:
        if (r1 != 9) goto L10;
        int r10 = a(0, 0, true);
        if (r10 < 0) goto L34;
        byte[] r11 = new byte[r10];
        int r2 = 0;
    L30:
        if (r2 >= r10) goto L42;
        r11[r2] = a(r11[0], 0, true);
        r2 = r2 + 1;
        goto L30
    L42:
        return r11;
    L34:
        throw new w1("size invalid: " + r10);
    L10:
        if (r1 != 11) goto L12;
    L36:
        return null;
    L12:
        if (r1 != 13) goto L26;
        ByteBuffer r12 = this.f629a;
        byte r4 = r12.get();
        byte r5 = (byte) (r4 & 15);
        if (((r4 & 240) >> 4) != 15) goto L17;
        r12.get();
    L17:
        if (r5 != 0) goto L24;
        int r3 = a(0, 0, true);
        if (r3 < 0) goto L22;
        byte[] r13 = new byte[r3];
        this.f629a.get(r13);
        return r13;
    L22:
        throw new w1("invalid size, tag: " + r7 + ", type: " + r1 + ", " + r5 + ", size: " + r3);
    L24:
        throw new w1("type mismatch, tag: " + r7 + ", type: " + r1 + ", " + r5);
    L26:
        throw new w1("type mismatch.");
    L35:
        if (r8 == false) goto L36;
        throw new w1("require field not exist.");
    }

    public i3 a(i3 r3, int r4, boolean r5) {
        if (b(r4) == true) goto L21;
        if (r5 == true) goto L20;
        return null;
    L20:
        throw new w1("require field not exist.");
    L21:
        i3 r6 = (i3) r3.getClass().newInstance();     // Catch: Exception -> L13
        ByteBuffer r7 = this.f629a;
        byte r8 = r7.get();
        byte r0 = (byte) (r8 & 15);
        if (((r8 & 240) >> 4) != 15) goto L9;
        r7.get();
    L9:
        if (r0 != 10) goto L12;
        r6.a(this);
        b();
        return r6;
    L12:
        throw new w1("type mismatch.");
    L13:
        e = move-exception;
        throw new w1(e.getMessage());
    }

    public Object a(Object r11, int r12, boolean r13) {
        int r1 = 0;
        if ((r11 instanceof Byte) == false) goto L7;
        return Byte.valueOf(a((byte) 0, r12, r13));
    L7:
        if ((r11 instanceof Boolean) == false) goto L11;
        return Boolean.valueOf(a(false, r12, r13));
    L11:
        if ((r11 instanceof Short) == false) goto L15;
        return Short.valueOf(a(0, r12, r13));
    L15:
        if ((r11 instanceof Integer) == false) goto L19;
        return Integer.valueOf(a(0, r12, r13));
    L19:
        if ((r11 instanceof Long) == false) goto L23;
        return Long.valueOf(a(0, r12, r13));
    L23:
        if ((r11 instanceof Float) == false) goto L27;
        return Float.valueOf(a(0.0f, r12, r13));
    L27:
        if ((r11 instanceof Double) == false) goto L31;
        return Double.valueOf(a(0.0d, r12, r13));
    L31:
        if ((r11 instanceof String) == false) goto L35;
        return b(r12, r13);
    L35:
        if ((r11 instanceof Map) == true) goto L37;
        double[] r2 = null;
        boolean[] r3 = null;
        r3 = null;
        short[] r4 = null;
        r4 = null;
        int[] r5 = null;
        r5 = null;
        long[] r6 = null;
        r6 = null;
        float[] r7 = null;
        r7 = null;
        r2 = null;
        if ((r11 instanceof List) == false) goto L55;
        List r14 = (List) r11;
        if (r14 == null) goto L53;
        if (r14.isEmpty() == true) goto L53;
        Object[] r10 = b(r14.get(0), r12, r13);
        if (r10 == null) goto L220;
        ArrayList r8 = new ArrayList();
    L50:
        if (r1 >= r10.length) goto L221;
        r8.add(r10[r1]);
        r1 = r1 + 1;
        goto L50
    L221:
        return r8;
    L220:
        return null;
    L53:
        return new ArrayList();
    L55:
        if ((r11 instanceof i3) == false) goto L59;
        return a((i3) r11, r12, r13);
    L59:
        if (r11.getClass().isArray() == false) goto L212;
        if ((r11 instanceof byte[]) == true) goto L210;
        if ((r11 instanceof Byte[]) == true) goto L210;
        if ((r11 instanceof boolean[]) == false) goto L89;
        if (b(r12) == false) goto L84;
        ByteBuffer r15 = this.f629a;
        byte r16 = r15.get();
        byte r17 = (byte) (r16 & 15);
        if (((r16 & 240) >> 4) != 15) goto L72;
        r15.get();
    L72:
        if (r17 == 9) goto L77;
        if (r17 != 11) goto L76;
    L85:
        return r3;
    L76:
        throw new w1("type mismatch.");
    L77:
        int r18 = a(0, 0, true);
        if (r18 < 0) goto L83;
        r3 = new boolean[r18];
        int r19 = 0;
    L80:
        if (r19 >= r18) goto L85;
        r3[r19] = a(r3[0], 0, true);
        r19 = r19 + 1;
        goto L80
    L83:
        throw new w1("size invalid: " + r18);
    L84:
        if (r13 == false) goto L85;
        throw new w1("require field not exist.");
    L89:
        if ((r11 instanceof short[]) == false) goto L112;
        if (b(r12) == false) goto L107;
        ByteBuffer r110 = this.f629a;
        byte r111 = r110.get();
        byte r112 = (byte) (r111 & 15);
        if (((r111 & 240) >> 4) != 15) goto L95;
        r110.get();
    L95:
        if (r112 == 9) goto L100;
        if (r112 != 11) goto L99;
    L108:
        return r4;
    L99:
        throw new w1("type mismatch.");
    L100:
        int r113 = a(0, 0, true);
        if (r113 < 0) goto L106;
        r4 = new short[r113];
        int r114 = 0;
    L103:
        if (r114 >= r113) goto L108;
        r4[r114] = a(r4[0], 0, true);
        r114 = r114 + 1;
        goto L103
    L106:
        throw new w1("size invalid: " + r113);
    L107:
        if (r13 == false) goto L108;
        throw new w1("require field not exist.");
    L112:
        if ((r11 instanceof int[]) == false) goto L135;
        if (b(r12) == false) goto L130;
        ByteBuffer r115 = this.f629a;
        byte r116 = r115.get();
        byte r117 = (byte) (r116 & 15);
        if (((r116 & 240) >> 4) != 15) goto L118;
        r115.get();
    L118:
        if (r117 == 9) goto L123;
        if (r117 != 11) goto L122;
    L131:
        return r5;
    L122:
        throw new w1("type mismatch.");
    L123:
        int r118 = a(0, 0, true);
        if (r118 < 0) goto L129;
        r5 = new int[r118];
        int r119 = 0;
    L126:
        if (r119 >= r118) goto L131;
        r5[r119] = a(r5[0], 0, true);
        r119 = r119 + 1;
        goto L126
    L129:
        throw new w1("size invalid: " + r118);
    L130:
        if (r13 == false) goto L131;
        throw new w1("require field not exist.");
    L135:
        if ((r11 instanceof long[]) == false) goto L158;
        if (b(r12) == false) goto L153;
        ByteBuffer r120 = this.f629a;
        byte r121 = r120.get();
        byte r122 = (byte) (r121 & 15);
        if (((r121 & 240) >> 4) != 15) goto L141;
        r120.get();
    L141:
        if (r122 == 9) goto L146;
        if (r122 != 11) goto L145;
    L154:
        return r6;
    L145:
        throw new w1("type mismatch.");
    L146:
        int r123 = a(0, 0, true);
        if (r123 < 0) goto L152;
        r6 = new long[r123];
        int r124 = 0;
    L149:
        if (r124 >= r123) goto L154;
        r6[r124] = a(r6[0], 0, true);
        r124 = r124 + 1;
        goto L149
    L152:
        throw new w1("size invalid: " + r123);
    L153:
        if (r13 == false) goto L154;
        throw new w1("require field not exist.");
    L158:
        if ((r11 instanceof float[]) == false) goto L181;
        if (b(r12) == false) goto L176;
        ByteBuffer r125 = this.f629a;
        byte r126 = r125.get();
        byte r127 = (byte) (r126 & 15);
        if (((r126 & 240) >> 4) != 15) goto L164;
        r125.get();
    L164:
        if (r127 == 9) goto L169;
        if (r127 != 11) goto L168;
    L177:
        return r7;
    L168:
        throw new w1("type mismatch.");
    L169:
        int r128 = a(0, 0, true);
        if (r128 < 0) goto L175;
        r7 = new float[r128];
        int r129 = 0;
    L172:
        if (r129 >= r128) goto L177;
        r7[r129] = a(r7[0], 0, true);
        r129 = r129 + 1;
        goto L172
    L175:
        throw new w1("size invalid: " + r128);
    L176:
        if (r13 == false) goto L177;
        throw new w1("require field not exist.");
    L181:
        if ((r11 instanceof double[]) == true) goto L183;
        Object[] r130 = (Object[]) r11;
        if (r130.length == 0) goto L208;
        return b(r130[0], r12, r13);
    L208:
        throw new w1("unable to get type of key and value.");
    L183:
        if (b(r12) == false) goto L199;
        ByteBuffer r131 = this.f629a;
        byte r132 = r131.get();
        byte r133 = (byte) (r132 & 15);
        if (((r132 & 240) >> 4) != 15) goto L187;
        r131.get();
    L187:
        if (r133 == 9) goto L192;
        if (r133 != 11) goto L191;
    L200:
        return r2;
    L191:
        throw new w1("type mismatch.");
    L192:
        int r134 = a(0, 0, true);
        if (r134 < 0) goto L198;
        r2 = new double[r134];
        int r135 = 0;
    L195:
        if (r135 >= r134) goto L200;
        r2[r135] = a(r2[0], 0, true);
        r135 = r135 + 1;
        goto L195
    L198:
        throw new w1("size invalid: " + r134);
    L199:
        if (r13 == false) goto L200;
        throw new w1("require field not exist.");
    L210:
        return a(r12, r13);
    L212:
        throw new w1("read object error: unsupport type.");
    L37:
        return a((Map) r11, r12, r13);
    }

    public y1(byte[] r2) {
        this.b = "GBK";
        this.f629a = ByteBuffer.wrap(r2);
    }

    public y1(byte[] r2, int r3) {
        this.b = "GBK";
        ByteBuffer r4 = ByteBuffer.wrap(r2);
        this.f629a = r4;
        r4.position(r3);
    }
}
