package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
abstract class z9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected HashMap f658a;
    protected HashMap b;
    private HashMap c;
    protected String d;
    JceInputStream e;

    z9() {
        this.f658a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = "GBK";
        this.e = new JceInputStream();
    }

    private Object b(String r2) {
        if (this.b.containsKey(r2) == true) goto L7;
        Object r0 = h0.b(r2);
        this.b.put(r2, r0);
        return r0;
    L7:
        return this.b.get(r2);
    }

    public void a(String r5, Object r6) {
        if (r5 == null) goto L13;
        if (r6 == null) goto L11;
        if ((r6 instanceof Set) == true) goto L9;
        JceOutputStream r0 = new JceOutputStream();
        r0.setServerEncoding(this.d);
        r0.write(r6, 0);
        byte[] r1 = a8.a(r0.getByteBuffer());
        HashMap r2 = new HashMap(1);
        ArrayList r3 = new ArrayList(1);
        a(r3, r6);
        r2.put(h0.a(r3), r1);
        this.c.remove(r5);
        this.f658a.put(r5, r2);
        return;
    L9:
        throw new IllegalArgumentException("can not support Set");
    L11:
        throw new IllegalArgumentException("put value can not is null");
    L13:
        throw new IllegalArgumentException("put key can not is null");
    }

    public void c(String r1) {
        this.d = r1;
    }

    private void b(String r1, Object r2) {
        this.c.put(r1, r2);
    }

    public Object a(String r6) {
        String r1 = null;
        if (this.f658a.containsKey(r6) == true) goto L6;
        return null;
    L6:
        if (this.c.containsKey(r6) == true) goto L8;
        byte[] r3 = new byte[0];
        Iterator r0 = ((HashMap) this.f658a.get(r6)).entrySet().iterator();
        if (r0.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) r0.next();
        r1 = (String) r2.getKey();
        r3 = (byte[]) r2.getValue();
    L17:
        Object r4 = b(r1);     // Catch: Exception -> L14
        this.e.wrap(r3);     // Catch: Exception -> L14
        this.e.setServerEncoding(this.d);     // Catch: Exception -> L14
        Object r5 = this.e.read(r4, 0, true);     // Catch: Exception -> L14
        b(r6, r5);     // Catch: Exception -> L14
        return r5;
    L14:
        e = move-exception;
        e.printStackTrace();
        throw new t9(e);
    L8:
        return this.c.get(r6);
    }

    private void a(ArrayList r6, Object r7) {
        if (r7.getClass().isArray() == false) goto L13;
        if (r7.getClass().getComponentType().toString().equals("byte") == false) goto L11;
        if (Array.getLength(r7) <= 0) goto L9;
        r6.add("java.util.List");
        a(r6, Array.get(r7, 0));
        return;
    L9:
        r6.add("Array");
        r6.add("?");
        return;
    L11:
        throw new IllegalArgumentException("only byte[] is supported");
    L13:
        if ((r7 instanceof Array) == true) goto L29;
        if ((r7 instanceof List) == false) goto L21;
        r6.add("java.util.List");
        List r8 = (List) r7;
        if (r8.size() <= 0) goto L19;
        a(r6, r8.get(0));
        return;
    L19:
        r6.add("?");
        return;
    L21:
        if ((r7 instanceof Map) == false) goto L26;
        r6.add("java.util.Map");
        Map r9 = (Map) r7;
        if (r9.size() <= 0) goto L25;
        Object r0 = r9.keySet().iterator().next();
        Object r10 = r9.get(r0);
        r6.add(r0.getClass().getName());
        a(r6, r10);
        return;
    L25:
        r6.add("?");
        r6.add("?");
        return;
    L26:
        r6.add(r7.getClass().getName());
        return;
    L29:
        throw new IllegalArgumentException("can not support Array, please use List");
    }

    public byte[] a() {
        JceOutputStream r0 = new JceOutputStream(0);
        r0.setServerEncoding(this.d);
        r0.write(this.f658a, 0);
        return a8.a(r0.getByteBuffer());
    }

    public void a(byte[] r5) {
        this.e.wrap(r5);
        this.e.setServerEncoding(this.d);
        HashMap r6 = new HashMap(1);
        HashMap r1 = new HashMap(1);
        r1.put("", new byte[0]);
        r6.put("", r1);
        this.f658a = this.e.readMap(r6, 0, false);
    }
}
