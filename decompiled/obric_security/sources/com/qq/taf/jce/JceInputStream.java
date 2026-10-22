package com.qq.taf.jce;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import tmsdkobf.x7;
import tmsdkobf.y5;

/* JADX INFO: loaded from: classes4.dex */
public final class JceInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteBuffer f19a;
    protected String b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f20a;
        public int b;

        public a() {
        }
    }

    public JceInputStream() {
        this.b = "GBK";
    }

    private int a(a r1) {
        return readHead(r1, this.f19a.duplicate());
    }

    public static void main(String[] r0) {
    }

    public static int readHead(a r2, ByteBuffer r3) {
        byte r0 = r3.get();
        r2.f20a = (byte) (r0 & 15);
        int r1 = (r0 & 240) >> 4;
        r2.b = r1;
        if (r1 != 15) goto L6;
        r2.b = r3.get() & UByte.MAX_VALUE;
        return 2;
    L6:
        return 1;
    }

    public JceStruct directRead(JceStruct r1, int r2, boolean r3) {
        if (skipToTag(r2) == true) goto L18;
        if (r3 == true) goto L17;
        return null;
    L17:
        throw new x7("require field not exist.");
    L18:
        JceStruct r4 = r1.newInit();     // Catch: Exception -> L10
        a r5 = new a();
        readHead(r5);
        if (r5.f20a != 10) goto L9;
        r4.readFrom(this);
        skipToStructEnd();
        return r4;
    L9:
        throw new x7("type mismatch.");
    L10:
        e = move-exception;
        throw new x7(e.getMessage());
    }

    public ByteBuffer getBs() {
        return this.f19a;
    }

    public boolean read(boolean r1, int r2, boolean r3) {
        if (read((byte) 0, r2, r3) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public <T> T[] readArray(T[] r2, int r3, boolean r4) {
        if (r2 == null) goto L8;
        if (r2.length == 0) goto L8;
        return (T[]) a(r2[0], r3, r4);
    L8:
        throw new x7("unable to get type of key and value.");
    }

    public String readByteString(String r1, int r2, boolean r3) {
        if (skipToTag(r2) == false) goto L23;
        a r4 = new a();
        readHead(r4);
        byte r5 = r4.f20a;
        if (r5 != 6) goto L7;
        int r6 = this.f19a.get();
        if (r6 >= 0) goto L22;
        r6 = r6 + 256;
    L22:
        byte[] r7 = new byte[r6];
        this.f19a.get(r7);
        return y5.a(r7);
    L7:
        if (r5 != 7) goto L9;
        int r8 = this.f19a.getInt();
        if (r8 > 104857600) goto L18;
        if (r8 < 0) goto L18;
        byte[] r9 = new byte[r8];
        this.f19a.get(r9);
        return y5.a(r9);
    L18:
        throw new x7("String too long: " + r8);
    L9:
        if (r5 != 11) goto L12;
        return r1;
    L12:
        throw new x7("type mismatch.");
    L23:
        if (r3 == true) goto L26;
        return r1;
    L26:
        throw new x7("require field not exist.");
    }

    public List readList(int r8, boolean r9) {
        ArrayList r0 = new ArrayList();
        if (skipToTag(r8) == false) goto L37;
        a r10 = new a();
        readHead(r10);
        if (r10.f20a != 9) goto L36;
        int r2 = read(0, 0, true);
        if (r2 < 0) goto L34;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L38;
        a r4 = new a();
        readHead(r4);
        switch(r4.f20a) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L32;
            case 9: goto L32;
            case 10: goto L41;
            case 11: goto L32;
            case 12: goto L15;
            default: goto L14;
        };
    L15:
        r0.add(new Integer(0));
        goto L32
    L21:
        a(this.f19a.getInt());
        goto L32
    L22:
        int r5 = this.f19a.get();
        if (r5 >= 0) goto L25;
        r5 = r5 + 256;
    L25:
        a(r5);
        goto L32
    L26:
        a(8);
        goto L32
    L27:
        a(4);
        goto L32
    L28:
        a(8);
        goto L32
    L29:
        a(4);
        goto L32
    L30:
        a(2);
        goto L32
    L31:
        a(1);
        goto L32
    L41:
        JceStruct r6 = (JceStruct) Class.forName(JceStruct.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L18
        r6.readFrom(this);     // Catch: Exception -> L18
        skipToStructEnd();     // Catch: Exception -> L18
        r0.add(r6);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        e.printStackTrace();
        throw new x7("type mismatch." + e);
    L14:
        throw new x7("type mismatch.");
    L32:
        r3 = r3 + 1;
    L38:
        return r0;
    L34:
        throw new x7("size invalid: " + r2);
    L36:
        throw new x7("type mismatch.");
    L37:
        if (r9 == false) goto L38;
        throw new x7("require field not exist.");
    }

    public <K, V> HashMap<K, V> readMap(Map<K, V> r2, int r3, boolean r4) {
        return (HashMap) a(new HashMap(), r2, r3, r4);
    }

    public String readString(int r2, boolean r3) {
        if (skipToTag(r2) == false) goto L29;
        a r4 = new a();
        readHead(r4);
        byte r5 = r4.f20a;
        if (r5 != 6) goto L7;
        int r6 = this.f19a.get();
        if (r6 >= 0) goto L25;
        r6 = r6 + 256;
    L25:
        byte[] r7 = new byte[r6];
        this.f19a.get(r7);
        String r8 = new String(r7, this.b);     // Catch: UnsupportedEncodingException -> L28
    L39:
        return r8;
    L40:
        return new String(r7);
    L7:
        if (r5 != 7) goto L9;
        int r9 = this.f19a.getInt();
        if (r9 > 104857600) goto L21;
        if (r9 < 0) goto L21;
        byte[] r10 = new byte[r9];
        this.f19a.get(r10);
        r8 = new String(r10, this.b);     // Catch: UnsupportedEncodingException -> L19
    L38:
        return new String(r10);
    L21:
        throw new x7("String too long: " + r9);
    L9:
        if (r5 != 11) goto L12;
    L30:
        return null;
    L12:
        throw new x7("type mismatch.");
    L29:
        if (r3 == false) goto L30;
        throw new x7("require field not exist.");
    }

    public Map<String, String> readStringMap(int r6, boolean r7) {
        HashMap r0 = new HashMap();
        if (skipToTag(r6) == false) goto L19;
        a r8 = new a();
        readHead(r8);
        byte r9 = r8.f20a;
        if (r9 != 8) goto L7;
        int r1 = read(0, 0, true);
        if (r1 < 0) goto L18;
        int r2 = 0;
    L14:
        if (r2 >= r1) goto L20;
        r0.put(readString(0, true), readString(1, true));
        r2 = r2 + 1;
    L20:
        return r0;
    L18:
        throw new x7("size invalid: " + r1);
    L7:
        if (r9 == 11) goto L20;
        throw new x7("type mismatch.");
    L19:
        if (r7 == false) goto L20;
        throw new x7("require field not exist.");
    }

    public int setServerEncoding(String r1) {
        this.b = r1;
        return 0;
    }

    public void skipToStructEnd() {
        a r0 = new a();
    L4:
        if (this.f19a.remaining() == 0) goto L8;
        readHead(r0);
        a(r0.f20a);
        if (r0.f20a != 11) goto L4;
        return;
    }

    public boolean skipToTag(int r7) {
        a r1 = new a();     // Catch: Throwable -> L15
    L4:
        int r2 = a(r1);     // Catch: Throwable -> L15
        int r3 = r1.b;     // Catch: Throwable -> L15
        if (r7 <= r3) goto L11;
        if (r1.f20a == 11) goto L11;
        a(r2);     // Catch: Throwable -> L15
        a(r1.f20a);     // Catch: Throwable -> L15
    L11:
        if (r7 != r3) goto L14;
        return true;
    L14:
        return false;
    }

    public void warp(byte[] r1) {
        wrap(r1);
    }

    public void wrap(byte[] r1) {
        this.f19a = ByteBuffer.wrap(r1);
    }

    private void a(int r2) {
        ByteBuffer r1 = this.f19a;
        r1.position(r1.position() + r2);
    }

    public byte read(byte r1, int r2, boolean r3) {
        if (skipToTag(r2) == false) goto L14;
        a r4 = new a();
        readHead(r4);
        byte r5 = r4.f20a;
        if (r5 == 0) goto L19;
        if (r5 != 11) goto L9;
        return r1;
    L9:
        if (r5 != 12) goto L12;
        return 0;
    L12:
        throw new x7("type mismatch.");
    L19:
        return this.f19a.get();
    L14:
        if (r3 == true) goto L17;
        return r1;
    L17:
        throw new x7("require field not exist.");
    }

    private void a() {
        a r0 = new a();
        readHead(r0);
        a(r0.f20a);
    }

    public <T> List<T> readArray(List<T> r2, int r3, boolean r4) {
        if (r2 == null) goto L16;
        if (r2.isEmpty() == true) goto L16;
        int r0 = 0;
        Object[] r1 = a(r2.get(0), r3, r4);
        if (r1 != null) goto L10;
        return null;
    L10:
        ArrayList r5 = new ArrayList();
    L12:
        if (r0 >= r1.length) goto L13;
        r5.add(r1[r0]);
        r0 = r0 + 1;
        goto L12
    L13:
        return r5;
    L16:
        return new ArrayList();
    }

    private void a(byte r6) {
        int r4 = 0;
        switch(r6) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L16;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L35;
            case 12: goto L35;
            case 13: goto L6;
            default: goto L5;
        };
    L6:
        a r0 = new a();
        readHead(r0);
        if (r0.f20a != 0) goto L10;
        a(read(0, 0, true));
        return;
    L10:
        throw new x7("skipField with invalid type, type value: " + r6 + ", " + r0.f20a);
    L11:
        skipToStructEnd();
        return;
    L12:
        int r7 = read(0, 0, true);
    L13:
        if (r4 >= r7) goto L45;
        a();
        r4 = r4 + 1;
        goto L13
    L45:
        return;
    L16:
        int r8 = read(0, 0, true);
    L18:
        if (r4 >= (r8 * 2)) goto L46;
        a();
        r4 = r4 + 1;
        goto L18
    L46:
        return;
    L21:
        a(this.f19a.getInt());
        return;
    L22:
        int r9 = this.f19a.get();
        if (r9 >= 0) goto L25;
        r9 = r9 + 256;
    L25:
        a(r9);
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
        throw new x7("invalid type.");
    }

    public void readHead(a r1) {
        readHead(r1, this.f19a);
    }

    public short read(short r1, int r2, boolean r3) {
        if (skipToTag(r2) == false) goto L17;
        a r4 = new a();
        readHead(r4);
        byte r5 = r4.f20a;
        if (r5 == 0) goto L23;
        if (r5 == 1) goto L22;
        if (r5 != 11) goto L11;
        return r1;
    L11:
        if (r5 != 12) goto L14;
        return 0;
    L14:
        throw new x7("type mismatch.");
    L22:
        return this.f19a.getShort();
    L23:
        return this.f19a.get();
    L17:
        if (r3 == true) goto L20;
        return r1;
    L20:
        throw new x7("require field not exist.");
    }

    private Map a(Map r6, Map r7, int r8, boolean r9) {
        if (r7 == null) goto L28;
        if (r7.isEmpty() == true) goto L28;
        Map.Entry r10 = (Map.Entry) r7.entrySet().iterator().next();
        Object r0 = r10.getKey();
        Object r11 = r10.getValue();
        if (skipToTag(r8) == false) goto L23;
        a r12 = new a();
        readHead(r12);
        byte r13 = r12.f20a;
        if (r13 != 8) goto L11;
        int r1 = read(0, 0, true);
        if (r1 < 0) goto L22;
        int r2 = 0;
    L18:
        if (r2 >= r1) goto L24;
        r6.put(read(r0, 0, true), read(r11, 1, true));
        r2 = r2 + 1;
    L24:
        return r6;
    L22:
        throw new x7("size invalid: " + r1);
    L11:
        if (r13 == 11) goto L24;
        throw new x7("type mismatch.");
    L23:
        if (r9 == false) goto L24;
        throw new x7("require field not exist.");
    L28:
        return new HashMap();
    }

    public int read(int r1, int r2, boolean r3) {
        if (skipToTag(r2) == false) goto L20;
        a r4 = new a();
        readHead(r4);
        byte r5 = r4.f20a;
        if (r5 == 0) goto L27;
        if (r5 == 1) goto L26;
        if (r5 == 2) goto L25;
        if (r5 != 11) goto L13;
        return r1;
    L13:
        if (r5 != 12) goto L16;
        return 0;
    L16:
        throw new x7("type mismatch.");
    L25:
        return this.f19a.getInt();
    L26:
        return this.f19a.getShort();
    L27:
        return this.f19a.get();
    L20:
        if (r3 == true) goto L23;
        return r1;
    L23:
        throw new x7("require field not exist.");
    }

    public long read(long r1, int r3, boolean r4) {
        if (skipToTag(r3) == false) goto L21;
        a r2 = new a();
        readHead(r2);
        byte r5 = r2.f20a;
        if (r5 == 12) goto L20;
        if (r5 != 0) goto L8;
        int r0 = this.f19a.get();
    L25:
        return r0;
    L8:
        if (r5 != 1) goto L10;
        r0 = this.f19a.getShort();
        goto L25
    L10:
        if (r5 != 2) goto L12;
        r0 = this.f19a.getInt();
        goto L25
    L12:
        if (r5 != 3) goto L15;
        return this.f19a.getLong();
    L15:
        throw new x7("type mismatch.");
    L20:
        return 0;
    L21:
        if (r4 == true) goto L24;
        return r1;
    L24:
        throw new x7("require field not exist.");
    }

    private Object[] a(Object r5, int r6, boolean r7) {
        if (skipToTag(r6) == false) goto L19;
        a r8 = new a();
        readHead(r8);
        byte r9 = r8.f20a;
        if (r9 != 9) goto L7;
        int r0 = read(0, 0, true);
        if (r0 < 0) goto L18;
        Object[] r1 = (Object[]) Array.newInstance(r5.getClass(), r0);
        int r2 = 0;
    L14:
        if (r2 >= r0) goto L15;
        r1[r2] = read(r5, 0, true);
        r2 = r2 + 1;
        goto L14
    L15:
        return r1;
    L18:
        throw new x7("size invalid: " + r0);
    L7:
        if (r9 != 11) goto L10;
        return null;
    L10:
        throw new x7("type mismatch.");
    L19:
        if (r7 == true) goto L23;
        return null;
    L23:
        throw new x7("require field not exist.");
    }

    public float read(float r1, int r2, boolean r3) {
        if (skipToTag(r2) == false) goto L14;
        a r4 = new a();
        readHead(r4);
        byte r5 = r4.f20a;
        if (r5 == 4) goto L19;
        if (r5 != 11) goto L9;
        return r1;
    L9:
        if (r5 != 12) goto L12;
        return 0.0f;
    L12:
        throw new x7("type mismatch.");
    L19:
        return this.f19a.getFloat();
    L14:
        if (r3 == true) goto L17;
        return r1;
    L17:
        throw new x7("require field not exist.");
    }

    public double read(double r1, int r3, boolean r4) {
        if (skipToTag(r3) == false) goto L17;
        a r5 = new a();
        readHead(r5);
        byte r6 = r5.f20a;
        if (r6 == 4) goto L23;
        if (r6 == 5) goto L22;
        if (r6 != 11) goto L11;
        return r1;
    L11:
        if (r6 != 12) goto L14;
        return 0.0d;
    L14:
        throw new x7("type mismatch.");
    L22:
        return this.f19a.getDouble();
    L23:
        return this.f19a.getFloat();
    L17:
        if (r4 == true) goto L20;
        return r1;
    L20:
        throw new x7("require field not exist.");
    }

    public String read(String r1, int r2, boolean r3) {
        if (skipToTag(r2) == false) goto L30;
        a r4 = new a();
        readHead(r4);
        byte r5 = r4.f20a;
        if (r5 != 6) goto L7;
        int r6 = this.f19a.get();
        if (r6 >= 0) goto L25;
        r6 = r6 + 256;
    L25:
        byte[] r7 = new byte[r6];
        this.f19a.get(r7);
        String r8 = new String(r7, this.b);     // Catch: UnsupportedEncodingException -> L28
    L31:
        return r8;
    L28:
        String r0 = new String(r7);
    L38:
        return r0;
    L7:
        if (r5 != 7) goto L9;
        int r9 = this.f19a.getInt();
        if (r9 > 104857600) goto L21;
        if (r9 < 0) goto L21;
        byte[] r10 = new byte[r9];
        this.f19a.get(r10);
        r8 = new String(r10, this.b);     // Catch: UnsupportedEncodingException -> L19
    L19:
        r0 = new String(r10);
    L21:
        throw new x7("String too long: " + r9);
    L9:
        if (r5 != 11) goto L12;
        return r1;
    L12:
        throw new x7("type mismatch.");
    L30:
        if (r3 == true) goto L33;
        return r1;
    L33:
        throw new x7("require field not exist.");
    }

    public String[] read(String[] r1, int r2, boolean r3) {
        return (String[]) readArray(r1, r2, r3);
    }

    public boolean[] read(boolean[] r4, int r5, boolean r6) {
        if (skipToTag(r5) == false) goto L19;
        a r7 = new a();
        readHead(r7);
        byte r8 = r7.f20a;
        if (r8 != 9) goto L7;
        int r9 = read(0, 0, true);
        if (r9 < 0) goto L18;
        boolean[] r0 = new boolean[r9];
        int r1 = 0;
    L14:
        if (r1 >= r9) goto L25;
        r0[r1] = read(r0[0], 0, true);
        r1 = r1 + 1;
        goto L14
    L25:
        return r0;
    L18:
        throw new x7("size invalid: " + r9);
    L7:
        if (r8 != 11) goto L10;
    L20:
        return null;
    L10:
        throw new x7("type mismatch.");
    L19:
        if (r6 == false) goto L20;
        throw new x7("require field not exist.");
    }

    public byte[] read(byte[] r6, int r7, boolean r8) {
        if (skipToTag(r7) == false) goto L29;
        a r9 = new a();
        readHead(r9);
        byte r10 = r9.f20a;
        if (r10 != 9) goto L7;
        int r11 = read(0, 0, true);
        if (r11 < 0) goto L28;
        byte[] r12 = new byte[r11];
        int r13 = 0;
    L24:
        if (r13 >= r11) goto L36;
        r12[r13] = read(r12[0], 0, true);
        r13 = r13 + 1;
        goto L24
    L36:
        return r12;
    L28:
        throw new x7("size invalid: " + r11);
    L7:
        if (r10 != 11) goto L9;
    L30:
        return null;
    L9:
        if (r10 != 13) goto L20;
        a r14 = new a();
        readHead(r14);
        if (r14.f20a != 0) goto L18;
        int r0 = read(0, 0, true);
        if (r0 < 0) goto L16;
        byte[] r15 = new byte[r0];
        this.f19a.get(r15);
        return r15;
    L16:
        throw new x7("invalid size, tag: " + r7 + ", type: " + r9.f20a + ", " + r14.f20a + ", size: " + r0);
    L18:
        throw new x7("type mismatch, tag: " + r7 + ", type: " + r9.f20a + ", " + r14.f20a);
    L20:
        throw new x7("type mismatch.");
    L29:
        if (r8 == false) goto L30;
        throw new x7("require field not exist.");
    }

    public short[] read(short[] r4, int r5, boolean r6) {
        if (skipToTag(r5) == false) goto L19;
        a r7 = new a();
        readHead(r7);
        byte r8 = r7.f20a;
        if (r8 != 9) goto L7;
        int r9 = read(0, 0, true);
        if (r9 < 0) goto L18;
        short[] r0 = new short[r9];
        int r1 = 0;
    L14:
        if (r1 >= r9) goto L25;
        r0[r1] = read(r0[0], 0, true);
        r1 = r1 + 1;
        goto L14
    L25:
        return r0;
    L18:
        throw new x7("size invalid: " + r9);
    L7:
        if (r8 != 11) goto L10;
    L20:
        return null;
    L10:
        throw new x7("type mismatch.");
    L19:
        if (r6 == false) goto L20;
        throw new x7("require field not exist.");
    }

    public int[] read(int[] r4, int r5, boolean r6) {
        if (skipToTag(r5) == false) goto L19;
        a r7 = new a();
        readHead(r7);
        byte r8 = r7.f20a;
        if (r8 != 9) goto L7;
        int r9 = read(0, 0, true);
        if (r9 < 0) goto L18;
        int[] r0 = new int[r9];
        int r1 = 0;
    L14:
        if (r1 >= r9) goto L25;
        r0[r1] = read(r0[0], 0, true);
        r1 = r1 + 1;
        goto L14
    L25:
        return r0;
    L18:
        throw new x7("size invalid: " + r9);
    L7:
        if (r8 != 11) goto L10;
    L20:
        return null;
    L10:
        throw new x7("type mismatch.");
    L19:
        if (r6 == false) goto L20;
        throw new x7("require field not exist.");
    }

    public long[] read(long[] r5, int r6, boolean r7) {
        if (skipToTag(r6) == false) goto L19;
        a r8 = new a();
        readHead(r8);
        byte r9 = r8.f20a;
        if (r9 != 9) goto L7;
        int r10 = read(0, 0, true);
        if (r10 < 0) goto L18;
        long[] r0 = new long[r10];
        int r1 = 0;
    L14:
        if (r1 >= r10) goto L25;
        r0[r1] = read(r0[0], 0, true);
        r1 = r1 + 1;
        goto L14
    L25:
        return r0;
    L18:
        throw new x7("size invalid: " + r10);
    L7:
        if (r9 != 11) goto L10;
    L20:
        return null;
    L10:
        throw new x7("type mismatch.");
    L19:
        if (r7 == false) goto L20;
        throw new x7("require field not exist.");
    }

    public float[] read(float[] r4, int r5, boolean r6) {
        if (skipToTag(r5) == false) goto L19;
        a r7 = new a();
        readHead(r7);
        byte r8 = r7.f20a;
        if (r8 != 9) goto L7;
        int r9 = read(0, 0, true);
        if (r9 < 0) goto L18;
        float[] r0 = new float[r9];
        int r1 = 0;
    L14:
        if (r1 >= r9) goto L25;
        r0[r1] = read(r0[0], 0, true);
        r1 = r1 + 1;
        goto L14
    L25:
        return r0;
    L18:
        throw new x7("size invalid: " + r9);
    L7:
        if (r8 != 11) goto L10;
    L20:
        return null;
    L10:
        throw new x7("type mismatch.");
    L19:
        if (r6 == false) goto L20;
        throw new x7("require field not exist.");
    }

    public double[] read(double[] r5, int r6, boolean r7) {
        if (skipToTag(r6) == false) goto L19;
        a r8 = new a();
        readHead(r8);
        byte r9 = r8.f20a;
        if (r9 != 9) goto L7;
        int r10 = read(0, 0, true);
        if (r10 < 0) goto L18;
        double[] r0 = new double[r10];
        int r1 = 0;
    L14:
        if (r1 >= r10) goto L25;
        r0[r1] = read(r0[0], 0, true);
        r1 = r1 + 1;
        goto L14
    L25:
        return r0;
    L18:
        throw new x7("size invalid: " + r10);
    L7:
        if (r9 != 11) goto L10;
    L20:
        return null;
    L10:
        throw new x7("type mismatch.");
    L19:
        if (r7 == false) goto L20;
        throw new x7("require field not exist.");
    }

    public JceStruct read(JceStruct r1, int r2, boolean r3) {
        if (skipToTag(r2) == true) goto L18;
        if (r3 == true) goto L17;
        return null;
    L17:
        throw new x7("require field not exist.");
    L18:
        JceStruct r4 = (JceStruct) r1.getClass().newInstance();     // Catch: Exception -> L10
        a r5 = new a();
        readHead(r5);
        if (r5.f20a != 10) goto L9;
        r4.readFrom(this);
        skipToStructEnd();
        return r4;
    L9:
        throw new x7("type mismatch.");
    L10:
        e = move-exception;
        throw new x7(e.getMessage());
    }

    public JceStruct[] read(JceStruct[] r1, int r2, boolean r3) {
        return (JceStruct[]) readArray(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object read(T r3, int r4, boolean r5) {
        if ((r3 instanceof Byte) == false) goto L7;
        return Byte.valueOf(read((byte) 0, r4, r5));
    L7:
        if ((r3 instanceof Boolean) == false) goto L11;
        return Boolean.valueOf(read(false, r4, r5));
    L11:
        if ((r3 instanceof Short) == false) goto L15;
        return Short.valueOf(read(0, r4, r5));
    L15:
        if ((r3 instanceof Integer) == false) goto L19;
        return Integer.valueOf(read(0, r4, r5));
    L19:
        if ((r3 instanceof Long) == false) goto L23;
        return Long.valueOf(read(0, r4, r5));
    L23:
        if ((r3 instanceof Float) == false) goto L27;
        return Float.valueOf(read(0.0f, r4, r5));
    L27:
        if ((r3 instanceof Double) == false) goto L31;
        return Double.valueOf(read(0.0d, r4, r5));
    L31:
        if ((r3 instanceof String) == false) goto L35;
        return readString(r4, r5);
    L35:
        if ((r3 instanceof Map) == false) goto L39;
        return readMap((Map) r3, r4, r5);
    L39:
        if ((r3 instanceof List) == false) goto L43;
        return readArray((List) r3, r4, r5);
    L43:
        if ((r3 instanceof JceStruct) == false) goto L47;
        return read((JceStruct) r3, r4, r5);
    L47:
        if (r3.getClass().isArray() == false) goto L82;
        if ((r3 instanceof byte[]) == true) goto L80;
        if ((r3 instanceof Byte[]) == true) goto L80;
        if ((r3 instanceof boolean[]) == false) goto L58;
        return read(null, r4, r5);
    L58:
        if ((r3 instanceof short[]) == false) goto L62;
        return read(null, r4, r5);
    L62:
        if ((r3 instanceof int[]) == false) goto L66;
        return read(null, r4, r5);
    L66:
        if ((r3 instanceof long[]) == false) goto L70;
        return read(null, r4, r5);
    L70:
        if ((r3 instanceof float[]) == false) goto L74;
        return read(null, r4, r5);
    L74:
        if ((r3 instanceof double[]) == false) goto L78;
        return read(null, r4, r5);
    L78:
        return readArray((Object[]) r3, r4, r5);
    L80:
        return read(null, r4, r5);
    L82:
        throw new x7("read object error: unsupport type.");
    }

    public JceInputStream(ByteBuffer r2) {
        this.b = "GBK";
        this.f19a = r2;
    }

    public JceInputStream(byte[] r2) {
        this.b = "GBK";
        this.f19a = ByteBuffer.wrap(r2);
    }

    public JceInputStream(byte[] r2, int r3) {
        this.b = "GBK";
        ByteBuffer r4 = ByteBuffer.wrap(r2);
        this.f19a = r4;
        r4.position(r3);
    }
}
