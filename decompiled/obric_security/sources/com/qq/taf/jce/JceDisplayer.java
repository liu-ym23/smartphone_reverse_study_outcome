package com.qq.taf.jce;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tmsdkobf.y5;
import tmsdkobf.y7;

/* JADX INFO: loaded from: classes4.dex */
public final class JceDisplayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f18a;
    private int b;

    public JceDisplayer(StringBuilder r1, int r2) {
        this.f18a = r1;
        this.b = r2;
    }

    private void a(String r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.b) goto L5;
        this.f18a.append('\t');
        r0 = r0 + 1;
        goto L4
    L5:
        if (r4 == null) goto L10;
        this.f18a.append(r4).append(": ");
        return;
    }

    public JceDisplayer display(boolean r1, String r2) {
        a(r2);
        StringBuilder r3 = this.f18a;
        if (r1 == false) goto L5;
        char r4 = 'T';
    L6:
        r3.append(r4).append('\n');
        return this;
    L5:
        r4 = 'F';
        goto L6
    }

    public JceDisplayer displaySimple(boolean r2, boolean r3) {
        StringBuilder r0 = this.f18a;
        if (r2 == false) goto L5;
        char r4 = 'T';
    L6:
        r0.append(r4);
        if (r3 == false) goto L9;
        this.f18a.append("|");
    L9:
        return this;
    L5:
        r4 = 'F';
        goto L6
    }

    public JceDisplayer display(byte r1, String r2) {
        a(r2);
        this.f18a.append(r1).append('\n');
        return this;
    }

    public JceDisplayer displaySimple(byte r2, boolean r3) {
        this.f18a.append(r2);
        if (r3 == false) goto L5;
        this.f18a.append("|");
    L5:
        return this;
    }

    public JceDisplayer(StringBuilder r2) {
        this.b = 0;
        this.f18a = r2;
    }

    public JceDisplayer display(char r1, String r2) {
        a(r2);
        this.f18a.append(r1).append('\n');
        return this;
    }

    public JceDisplayer display(short r1, String r2) {
        a(r2);
        this.f18a.append(r1).append('\n');
        return this;
    }

    public JceDisplayer displaySimple(char r2, boolean r3) {
        this.f18a.append(r2);
        if (r3 == false) goto L5;
        this.f18a.append("|");
    L5:
        return this;
    }

    public JceDisplayer display(int r1, String r2) {
        a(r2);
        this.f18a.append(r1).append('\n');
        return this;
    }

    public JceDisplayer displaySimple(short r2, boolean r3) {
        this.f18a.append(r2);
        if (r3 == false) goto L5;
        this.f18a.append("|");
    L5:
        return this;
    }

    public JceDisplayer display(long r1, String r3) {
        a(r3);
        this.f18a.append(r1).append('\n');
        return this;
    }

    public JceDisplayer display(float r1, String r2) {
        a(r2);
        this.f18a.append(r1).append('\n');
        return this;
    }

    public JceDisplayer displaySimple(int r2, boolean r3) {
        this.f18a.append(r2);
        if (r3 == false) goto L5;
        this.f18a.append("|");
    L5:
        return this;
    }

    public JceDisplayer display(double r1, String r3) {
        a(r3);
        this.f18a.append(r1).append('\n');
        return this;
    }

    public JceDisplayer displaySimple(long r2, boolean r4) {
        this.f18a.append(r2);
        if (r4 == false) goto L5;
        this.f18a.append("|");
    L5:
        return this;
    }

    public JceDisplayer display(String r2, String r3) {
        a(r3);
        if (r2 != null) goto L5;
        this.f18a.append("null").append('\n');
    L6:
        return this;
    L5:
        this.f18a.append(r2).append('\n');
        goto L6
    }

    public JceDisplayer displaySimple(float r2, boolean r3) {
        this.f18a.append(r2);
        if (r3 == false) goto L5;
        this.f18a.append("|");
    L5:
        return this;
    }

    public JceDisplayer display(byte[] r5, String r6) {
        a(r6);
        if (r5 != null) goto L7;
        this.f18a.append("null").append('\n');
        return this;
    L7:
        if (r5.length != 0) goto L10;
        this.f18a.append(r5.length).append(", []").append('\n');
        return this;
    L10:
        this.f18a.append(r5.length).append(", [").append('\n');
        JceDisplayer r7 = new JceDisplayer(this.f18a, this.b + 1);
        int r0 = r5.length;
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L13;
        r7.display(r5[r1], null);
        r1 = r1 + 1;
        goto L12
    L13:
        display(']', null);
        return this;
    }

    public JceDisplayer displaySimple(double r2, boolean r4) {
        this.f18a.append(r2);
        if (r4 == false) goto L5;
        this.f18a.append("|");
    L5:
        return this;
    }

    public JceDisplayer displaySimple(String r2, boolean r3) {
        if (r2 != null) goto L4;
        this.f18a.append("null");
    L5:
        if (r3 == false) goto L7;
        this.f18a.append("|");
    L7:
        return this;
    L4:
        this.f18a.append(r2);
        goto L5
    }

    public JceDisplayer displaySimple(byte[] r3, boolean r4) {
        if (r3 != null) goto L5;
    L11:
        if (r4 == false) goto L13;
        this.f18a.append("|");
    L13:
        return this;
    L5:
        if (r3.length == 0) goto L11;
        this.f18a.append(y5.a(r3));
        if (r4 == false) goto L10;
        this.f18a.append("|");
    L10:
        return this;
    }

    public JceDisplayer display(char[] r5, String r6) {
        a(r6);
        if (r5 != null) goto L7;
        this.f18a.append("null").append('\n');
        return this;
    L7:
        if (r5.length != 0) goto L10;
        this.f18a.append(r5.length).append(", []").append('\n');
        return this;
    L10:
        this.f18a.append(r5.length).append(", [").append('\n');
        JceDisplayer r7 = new JceDisplayer(this.f18a, this.b + 1);
        int r0 = r5.length;
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L13;
        r7.display(r5[r1], null);
        r1 = r1 + 1;
        goto L12
    L13:
        display(']', null);
        return this;
    }

    public JceDisplayer displaySimple(char[] r4, boolean r5) {
        if (r4 != null) goto L5;
    L11:
        if (r5 == false) goto L13;
        this.f18a.append("|");
    L13:
        return this;
    L5:
        if (r4.length == 0) goto L11;
        this.f18a.append(new String(r4));
        if (r5 == false) goto L10;
        this.f18a.append("|");
    L10:
        return this;
    }

    public JceDisplayer displaySimple(short[] r7, boolean r8) {
        if (r7 != null) goto L5;
    L18:
        this.f18a.append("[]");
        if (r8 == false) goto L21;
        this.f18a.append("|");
    L21:
        return this;
    L5:
        if (r7.length == 0) goto L18;
        this.f18a.append("[");
        JceDisplayer r1 = new JceDisplayer(this.f18a, this.b + 1);
        int r3 = 0;
    L9:
        if (r3 >= r7.length) goto L10;
        short r4 = r7[r3];
        if (r3 == 0) goto L17;
        this.f18a.append("|");
    L17:
        r1.displaySimple(r4, false);
        r3 = r3 + 1;
        goto L9
    L10:
        this.f18a.append("]");
        if (r8 == false) goto L13;
        this.f18a.append("|");
    L13:
        return this;
    }

    public JceDisplayer display(short[] r5, String r6) {
        a(r6);
        if (r5 != null) goto L7;
        this.f18a.append("null").append('\n');
        return this;
    L7:
        if (r5.length != 0) goto L10;
        this.f18a.append(r5.length).append(", []").append('\n');
        return this;
    L10:
        this.f18a.append(r5.length).append(", [").append('\n');
        JceDisplayer r7 = new JceDisplayer(this.f18a, this.b + 1);
        int r0 = r5.length;
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L13;
        r7.display(r5[r1], null);
        r1 = r1 + 1;
        goto L12
    L13:
        display(']', null);
        return this;
    }

    public JceDisplayer display(int[] r5, String r6) {
        a(r6);
        if (r5 != null) goto L7;
        this.f18a.append("null").append('\n');
        return this;
    L7:
        if (r5.length != 0) goto L10;
        this.f18a.append(r5.length).append(", []").append('\n');
        return this;
    L10:
        this.f18a.append(r5.length).append(", [").append('\n');
        JceDisplayer r7 = new JceDisplayer(this.f18a, this.b + 1);
        int r0 = r5.length;
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L13;
        r7.display(r5[r1], null);
        r1 = r1 + 1;
        goto L12
    L13:
        display(']', null);
        return this;
    }

    public JceDisplayer displaySimple(int[] r7, boolean r8) {
        if (r7 != null) goto L5;
    L18:
        this.f18a.append("[]");
        if (r8 == false) goto L21;
        this.f18a.append("|");
    L21:
        return this;
    L5:
        if (r7.length == 0) goto L18;
        this.f18a.append("[");
        JceDisplayer r1 = new JceDisplayer(this.f18a, this.b + 1);
        int r3 = 0;
    L9:
        if (r3 >= r7.length) goto L10;
        int r4 = r7[r3];
        if (r3 == 0) goto L17;
        this.f18a.append("|");
    L17:
        r1.displaySimple(r4, false);
        r3 = r3 + 1;
        goto L9
    L10:
        this.f18a.append("]");
        if (r8 == false) goto L13;
        this.f18a.append("|");
    L13:
        return this;
    }

    public JceDisplayer display(long[] r6, String r7) {
        a(r7);
        if (r6 != null) goto L7;
        this.f18a.append("null").append('\n');
        return this;
    L7:
        if (r6.length != 0) goto L10;
        this.f18a.append(r6.length).append(", []").append('\n');
        return this;
    L10:
        this.f18a.append(r6.length).append(", [").append('\n');
        JceDisplayer r8 = new JceDisplayer(this.f18a, this.b + 1);
        int r0 = r6.length;
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L13;
        r8.display(r6[r1], null);
        r1 = r1 + 1;
        goto L12
    L13:
        display(']', null);
        return this;
    }

    public JceDisplayer display(float[] r5, String r6) {
        a(r6);
        if (r5 != null) goto L7;
        this.f18a.append("null").append('\n');
        return this;
    L7:
        if (r5.length != 0) goto L10;
        this.f18a.append(r5.length).append(", []").append('\n');
        return this;
    L10:
        this.f18a.append(r5.length).append(", [").append('\n');
        JceDisplayer r7 = new JceDisplayer(this.f18a, this.b + 1);
        int r0 = r5.length;
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L13;
        r7.display(r5[r1], null);
        r1 = r1 + 1;
        goto L12
    L13:
        display(']', null);
        return this;
    }

    public JceDisplayer displaySimple(long[] r8, boolean r9) {
        if (r8 != null) goto L5;
    L18:
        this.f18a.append("[]");
        if (r9 == false) goto L21;
        this.f18a.append("|");
    L21:
        return this;
    L5:
        if (r8.length == 0) goto L18;
        this.f18a.append("[");
        JceDisplayer r1 = new JceDisplayer(this.f18a, this.b + 1);
        int r3 = 0;
    L9:
        if (r3 >= r8.length) goto L10;
        long r4 = r8[r3];
        if (r3 == 0) goto L17;
        this.f18a.append("|");
    L17:
        r1.displaySimple(r4, false);
        r3 = r3 + 1;
        goto L9
    L10:
        this.f18a.append("]");
        if (r9 == false) goto L13;
        this.f18a.append("|");
    L13:
        return this;
    }

    public JceDisplayer display(double[] r6, String r7) {
        a(r7);
        if (r6 != null) goto L7;
        this.f18a.append("null").append('\n');
        return this;
    L7:
        if (r6.length != 0) goto L10;
        this.f18a.append(r6.length).append(", []").append('\n');
        return this;
    L10:
        this.f18a.append(r6.length).append(", [").append('\n');
        JceDisplayer r8 = new JceDisplayer(this.f18a, this.b + 1);
        int r0 = r6.length;
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L13;
        r8.display(r6[r1], null);
        r1 = r1 + 1;
        goto L12
    L13:
        display(']', null);
        return this;
    }

    public <K, V> JceDisplayer display(Map<K, V> r5, String r6) {
        a(r6);
        if (r5 != null) goto L7;
        this.f18a.append("null").append('\n');
        return this;
    L7:
        if (r5.isEmpty() == false) goto L10;
        this.f18a.append(r5.size()).append(", {}").append('\n');
        return this;
    L10:
        this.f18a.append(r5.size()).append(", {").append('\n');
        JceDisplayer r7 = new JceDisplayer(this.f18a, this.b + 1);
        JceDisplayer r0 = new JceDisplayer(this.f18a, this.b + 2);
        Iterator<Map.Entry<K, V>> r8 = r5.entrySet().iterator();
    L12:
        if (r8.hasNext() == false) goto L13;
        Map.Entry<K, V> r1 = r8.next();
        r7.display('(', null);
        r0.display(r1.getKey(), null);
        r0.display(r1.getValue(), null);
        r7.display(')', null);
        goto L12
    L13:
        display('}', null);
        return this;
    }

    public JceDisplayer displaySimple(float[] r7, boolean r8) {
        if (r7 != null) goto L5;
    L18:
        this.f18a.append("[]");
        if (r8 == false) goto L21;
        this.f18a.append("|");
    L21:
        return this;
    L5:
        if (r7.length == 0) goto L18;
        this.f18a.append("[");
        JceDisplayer r1 = new JceDisplayer(this.f18a, this.b + 1);
        int r3 = 0;
    L9:
        if (r3 >= r7.length) goto L10;
        float r4 = r7[r3];
        if (r3 == 0) goto L17;
        this.f18a.append("|");
    L17:
        r1.displaySimple(r4, false);
        r3 = r3 + 1;
        goto L9
    L10:
        this.f18a.append("]");
        if (r8 == false) goto L13;
        this.f18a.append("|");
    L13:
        return this;
    }

    public <T> JceDisplayer display(T[] r5, String r6) {
        a(r6);
        if (r5 != null) goto L7;
        this.f18a.append("null").append('\n');
        return this;
    L7:
        if (r5.length != 0) goto L10;
        this.f18a.append(r5.length).append(", []").append('\n');
        return this;
    L10:
        this.f18a.append(r5.length).append(", [").append('\n');
        JceDisplayer r7 = new JceDisplayer(this.f18a, this.b + 1);
        int r0 = r5.length;
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L13;
        r7.display(r5[r1], null);
        r1 = r1 + 1;
        goto L12
    L13:
        display(']', null);
        return this;
    }

    public JceDisplayer displaySimple(double[] r9, boolean r10) {
        if (r9 != null) goto L5;
    L18:
        this.f18a.append("[]");
        if (r10 == false) goto L21;
        this.f18a.append("|");
    L21:
        return this;
    L5:
        if (r9.length == 0) goto L18;
        this.f18a.append("[");
        JceDisplayer r1 = new JceDisplayer(this.f18a, this.b + 1);
        int r4 = 0;
    L9:
        if (r4 >= r9.length) goto L10;
        double r5 = r9[r4];
        if (r4 == 0) goto L17;
        this.f18a.append("|");
    L17:
        r1.displaySimple(r5, false);
        r4 = r4 + 1;
        goto L9
    L10:
        this.f18a.append("[");
        if (r10 == false) goto L13;
        this.f18a.append("|");
    L13:
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> JceDisplayer display(Collection<T> r1, String r2) {
        if (r1 != null) goto L6;
        a(r2);
        this.f18a.append("null").append('\t');
        return this;
    L6:
        return display(r1.toArray(), r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> JceDisplayer display(T r3, String r4) {
        if (r3 != 0) goto L5;
        this.f18a.append("null").append('\n');
    L61:
        return this;
    L5:
        if ((r3 instanceof Byte) == false) goto L8;
        display(((Byte) r3).byteValue(), r4);
        goto L61
    L8:
        if ((r3 instanceof Boolean) == false) goto L11;
        display(((Boolean) r3).booleanValue(), r4);
        goto L61
    L11:
        if ((r3 instanceof Short) == false) goto L14;
        display(((Short) r3).shortValue(), r4);
        goto L61
    L14:
        if ((r3 instanceof Integer) == false) goto L17;
        display(((Integer) r3).intValue(), r4);
        goto L61
    L17:
        if ((r3 instanceof Long) == false) goto L20;
        display(((Long) r3).longValue(), r4);
        goto L61
    L20:
        if ((r3 instanceof Float) == false) goto L23;
        display(((Float) r3).floatValue(), r4);
        goto L61
    L23:
        if ((r3 instanceof Double) == false) goto L26;
        display(((Double) r3).doubleValue(), r4);
        goto L61
    L26:
        if ((r3 instanceof String) == false) goto L29;
        display((String) r3, r4);
        goto L61
    L29:
        if ((r3 instanceof Map) == false) goto L32;
        display((Map) r3, r4);
        goto L61
    L32:
        if ((r3 instanceof List) == false) goto L35;
        display((List) r3, r4);
        goto L61
    L35:
        if ((r3 instanceof JceStruct) == false) goto L38;
        display((JceStruct) r3, r4);
        goto L61
    L38:
        if ((r3 instanceof byte[]) == false) goto L41;
        display((byte[]) r3, r4);
        goto L61
    L41:
        if ((r3 instanceof boolean[]) == false) goto L44;
        display((boolean[]) r3, r4);
        goto L61
    L44:
        if ((r3 instanceof short[]) == false) goto L47;
        display((short[]) r3, r4);
        goto L61
    L47:
        if ((r3 instanceof int[]) == false) goto L50;
        display((int[]) r3, r4);
        goto L61
    L50:
        if ((r3 instanceof long[]) == false) goto L53;
        display((long[]) r3, r4);
        goto L61
    L53:
        if ((r3 instanceof float[]) == false) goto L56;
        display((float[]) r3, r4);
        goto L61
    L56:
        if ((r3 instanceof double[]) == false) goto L59;
        display((double[]) r3, r4);
        goto L61
    L59:
        if (r3.getClass().isArray() == false) goto L63;
        display((Object[]) r3, r4);
        goto L61
    L63:
        throw new y7("write object error: unsupport type.");
    }

    public <K, V> JceDisplayer displaySimple(Map<K, V> r7, boolean r8) {
        if (r7 != null) goto L5;
    L18:
        this.f18a.append("{}");
        if (r8 == false) goto L21;
        this.f18a.append("|");
    L21:
        return this;
    L5:
        if (r7.isEmpty() == true) goto L18;
        this.f18a.append("{");
        JceDisplayer r1 = new JceDisplayer(this.f18a, this.b + 2);
        Iterator<Map.Entry<K, V>> r9 = r7.entrySet().iterator();
        boolean r3 = true;
    L9:
        if (r9.hasNext() == false) goto L10;
        Map.Entry<K, V> r4 = r9.next();
        if (r3 == true) goto L17;
        this.f18a.append(",");
    L17:
        r1.displaySimple(r4.getKey(), true);
        r1.displaySimple(r4.getValue(), false);
        r3 = false;
        goto L9
    L10:
        this.f18a.append("}");
        if (r8 == false) goto L13;
        this.f18a.append("|");
    L13:
        return this;
    }

    public <T> JceDisplayer displaySimple(T[] r7, boolean r8) {
        if (r7 != null) goto L5;
    L18:
        this.f18a.append("[]");
        if (r8 == false) goto L21;
        this.f18a.append("|");
    L21:
        return this;
    L5:
        if (r7.length == 0) goto L18;
        this.f18a.append("[");
        JceDisplayer r1 = new JceDisplayer(this.f18a, this.b + 1);
        int r3 = 0;
    L9:
        if (r3 >= r7.length) goto L10;
        T r4 = r7[r3];
        if (r3 == 0) goto L17;
        this.f18a.append("|");
    L17:
        r1.displaySimple(r4, false);
        r3 = r3 + 1;
        goto L9
    L10:
        this.f18a.append("]");
        if (r8 == false) goto L13;
        this.f18a.append("|");
    L13:
        return this;
    }

    public JceDisplayer display(JceStruct r2, String r3) {
        display('{', r3);
        if (r2 != null) goto L5;
        this.f18a.append('\t').append("null");
    L6:
        display('}', null);
        return this;
    L5:
        r2.display(this.f18a, this.b + 1);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> JceDisplayer displaySimple(Collection<T> r2, boolean r3) {
        if (r2 != null) goto L8;
        this.f18a.append("[]");
        if (r3 == false) goto L6;
        this.f18a.append("|");
    L6:
        return this;
    L8:
        return displaySimple(r2.toArray(), r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> JceDisplayer displaySimple(T r3, boolean r4) {
        if (r3 != 0) goto L5;
        this.f18a.append("null").append('\n');
    L61:
        return this;
    L5:
        if ((r3 instanceof Byte) == false) goto L8;
        displaySimple(((Byte) r3).byteValue(), r4);
        goto L61
    L8:
        if ((r3 instanceof Boolean) == false) goto L11;
        displaySimple(((Boolean) r3).booleanValue(), r4);
        goto L61
    L11:
        if ((r3 instanceof Short) == false) goto L14;
        displaySimple(((Short) r3).shortValue(), r4);
        goto L61
    L14:
        if ((r3 instanceof Integer) == false) goto L17;
        displaySimple(((Integer) r3).intValue(), r4);
        goto L61
    L17:
        if ((r3 instanceof Long) == false) goto L20;
        displaySimple(((Long) r3).longValue(), r4);
        goto L61
    L20:
        if ((r3 instanceof Float) == false) goto L23;
        displaySimple(((Float) r3).floatValue(), r4);
        goto L61
    L23:
        if ((r3 instanceof Double) == false) goto L26;
        displaySimple(((Double) r3).doubleValue(), r4);
        goto L61
    L26:
        if ((r3 instanceof String) == false) goto L29;
        displaySimple((String) r3, r4);
        goto L61
    L29:
        if ((r3 instanceof Map) == false) goto L32;
        displaySimple((Map) r3, r4);
        goto L61
    L32:
        if ((r3 instanceof List) == false) goto L35;
        displaySimple((List) r3, r4);
        goto L61
    L35:
        if ((r3 instanceof JceStruct) == false) goto L38;
        displaySimple((JceStruct) r3, r4);
        goto L61
    L38:
        if ((r3 instanceof byte[]) == false) goto L41;
        displaySimple((byte[]) r3, r4);
        goto L61
    L41:
        if ((r3 instanceof boolean[]) == false) goto L44;
        displaySimple((boolean[]) r3, r4);
        goto L61
    L44:
        if ((r3 instanceof short[]) == false) goto L47;
        displaySimple((short[]) r3, r4);
        goto L61
    L47:
        if ((r3 instanceof int[]) == false) goto L50;
        displaySimple((int[]) r3, r4);
        goto L61
    L50:
        if ((r3 instanceof long[]) == false) goto L53;
        displaySimple((long[]) r3, r4);
        goto L61
    L53:
        if ((r3 instanceof float[]) == false) goto L56;
        displaySimple((float[]) r3, r4);
        goto L61
    L56:
        if ((r3 instanceof double[]) == false) goto L59;
        displaySimple((double[]) r3, r4);
        goto L61
    L59:
        if (r3.getClass().isArray() == false) goto L63;
        displaySimple((Object[]) r3, r4);
        goto L61
    L63:
        throw new y7("write object error: unsupport type.");
    }

    public JceDisplayer displaySimple(JceStruct r3, boolean r4) {
        this.f18a.append("{");
        if (r3 != null) goto L5;
        this.f18a.append('\t').append("null");
    L6:
        this.f18a.append("}");
        if (r4 == false) goto L9;
        this.f18a.append("|");
    L9:
        return this;
    L5:
        r3.displaySimple(this.f18a, this.b + 1);
        goto L6
    }
}
