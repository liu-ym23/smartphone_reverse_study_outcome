package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class nf extends z9 {
    protected HashMap f;
    private HashMap g;
    JceInputStream h;

    public nf() {
        this.f = null;
        this.g = new HashMap();
        this.h = new JceInputStream();
    }

    @Override // tmsdkobf.z9
    public /* bridge */ /* synthetic */ Object a(String r1) {
        return super.a(r1);
    }

    public void b() {
        this.g.clear();
    }

    @Override // tmsdkobf.z9
    public /* bridge */ /* synthetic */ void c(String r1) {
        super.c(r1);
    }

    public void d() {
        this.f = new HashMap();
    }

    private void b(String r1, Object r2) {
        this.g.put(r1, r2);
    }

    @Override // tmsdkobf.z9
    public void a(String r3, Object r4) {
        if (this.f == null) goto L15;
        if (r3 == null) goto L14;
        if (r4 == null) goto L12;
        if ((r4 instanceof Set) == true) goto L10;
        JceOutputStream r0 = new JceOutputStream();
        r0.setServerEncoding(this.d);
        r0.write(r4, 0);
        byte[] r5 = a8.a(r0.getByteBuffer());
        this.f.put(r3, r5);
        return;
    L10:
        throw new IllegalArgumentException("can not support Set");
    L12:
        throw new IllegalArgumentException("put value can not is null");
    L14:
        throw new IllegalArgumentException("put key can not is null");
    L15:
        super.a(r3, r4);
    }

    public boolean c() {
        HashMap r0 = this.f;
        if (r0 == null) goto L7;
        return r0.isEmpty();
    L7:
        return this.f658a.isEmpty();
    }

    public Object c(String r5, Object r6) {
        HashMap r0 = this.f;
        if (r0 == null) goto L20;
        if (r0.containsKey(r5) == true) goto L8;
        return null;
    L8:
        if (this.g.containsKey(r5) == false) goto L36;
        return this.g.get(r5);
    L36:
        Object r7 = a((byte[]) this.f.get(r5), r6);     // Catch: Exception -> L16
        if (r7 == null) goto L15;
        b(r5, r7);     // Catch: Exception -> L16
    L15:
        return r7;
    L16:
        e = move-exception;
        throw new t9(e);
    L20:
        if (this.f658a.containsKey(r5) == true) goto L23;
        return null;
    L23:
        if (this.g.containsKey(r5) == true) goto L25;
        byte[] r2 = new byte[0];
        Iterator r1 = ((HashMap) this.f658a.get(r5)).entrySet().iterator();
        if (r1.hasNext() == false) goto L34;
        Map.Entry r3 = (Map.Entry) r1.next();
        String r4 = (String) r3.getKey();
        r2 = (byte[]) r3.getValue();
    L34:
        this.h.wrap(r2);     // Catch: Exception -> L31
        this.h.setServerEncoding(this.d);     // Catch: Exception -> L31
        Object r8 = this.h.read(r6, 0, true);     // Catch: Exception -> L31
        b(r5, r8);     // Catch: Exception -> L31
        return r8;
    L31:
        e = move-exception;
        throw new t9(e);
    L25:
        return this.g.get(r5);
    }

    private Object a(byte[] r2, Object r3) {
        this.h.wrap(r2);
        this.h.setServerEncoding(this.d);
        return this.h.read(r3, 0, true);
    }

    @Override // tmsdkobf.z9
    public byte[] a() {
        if (this.f == null) goto L7;
        JceOutputStream r0 = new JceOutputStream(0);
        r0.setServerEncoding(this.d);
        r0.write(this.f, 0);
        return a8.a(r0.getByteBuffer());
    L7:
        return super.a();
    }

    @Override // tmsdkobf.z9
    public void a(byte[] r4) {
        super.a(r4);     // Catch: Exception -> L4
        return;
    L4:
        this.h.wrap(r4);
        this.h.setServerEncoding(this.d);
        HashMap r5 = new HashMap(1);
        r5.put("", new byte[0]);
        this.f = this.h.readMap(r5, 0, false);
    }
}
