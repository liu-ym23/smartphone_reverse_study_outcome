package d.a.a;

import d.a.a.i.m;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e extends a implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map<String, Object> f12376k;

    public e() {
        this(16, false);
    }

    public e(int r1, boolean r2) {
        if (r2 == false) goto L5;
        Map<String, Object> r3 = new LinkedHashMap(r1);
    L6:
        this.f12376k = r3;
        return;
    L5:
        r3 = new HashMap(r1);
        goto L6
    }

    public e(Map<String, Object> r1) {
        this.f12376k = r1;
    }

    public e(boolean r2) {
        this(16, r2);
    }

    @Override // java.util.Map
    public void clear() {
        this.f12376k.clear();
    }

    public Object clone() {
        return new e(new LinkedHashMap(this.f12376k));
    }

    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        return this.f12376k.containsKey(r1);
    }

    @Override // java.util.Map
    public boolean containsValue(Object r1) {
        return this.f12376k.containsValue(r1);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.f12376k.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object r1) {
        return this.f12376k.equals(r1);
    }

    @Override // java.util.Map
    public Object get(Object r1) {
        return this.f12376k.get(r1);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f12376k.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r7, Method r8, Object[] r9) {
        Class<?>[] r10 = r8.getParameterTypes();
        String r2 = null;
        if (r10.length != 1) goto L31;
        if (r8.getName().equals("equals") == false) goto L9;
        return Boolean.valueOf(equals(r9[0]));
    L9:
        if (r8.getReturnType() != Void.TYPE) goto L29;
        d.a.a.h.b r11 = (d.a.a.h.b) r8.getAnnotation(d.a.a.h.b.class);
        if (r11 != null) goto L13;
    L15:
        String r12 = null;
    L16:
        if (r12 != null) goto L26;
        String r13 = r8.getName();
        if (r13.startsWith("set") == false) goto L25;
        String r14 = r13.substring(3);
        if (r14.length() == 0) goto L23;
        r12 = Character.toLowerCase(r14.charAt(0)) + r14.substring(1);
        goto L26
    L23:
        throw new d("illegal setter");
    L25:
        throw new d("illegal setter");
    L26:
        this.f12376k.put(r12, r9[0]);
        return null;
    L13:
        if (r11.name().length() == 0) goto L15;
        r12 = r11.name();
        goto L16
    L29:
        throw new d("illegal setter");
    L31:
        if (r10.length != 0) goto L70;
        if (r8.getReturnType() == Void.TYPE) goto L68;
        d.a.a.h.b r15 = (d.a.a.h.b) r8.getAnnotation(d.a.a.h.b.class);
        if (r15 != null) goto L37;
    L39:
        if (r2 != null) goto L66;
        String r16 = r8.getName();
        if (r16.startsWith("get") == false) goto L49;
        String r17 = r16.substring(3);
        if (r17.length() == 0) goto L47;
        StringBuilder r18 = new StringBuilder();
    L45:
        r18.append(Character.toLowerCase(r17.charAt(0)));
        r18.append(r17.substring(1));
        r2 = r18.toString();
        goto L66
    L47:
        throw new d("illegal getter");
    L49:
        if (r16.startsWith("is") == false) goto L56;
        r17 = r16.substring(2);
        if (r17.length() == 0) goto L54;
        r18 = new StringBuilder();
        goto L45
    L54:
        throw new d("illegal getter");
    L56:
        if (r16.startsWith("hashCode") == false) goto L60;
        return Integer.valueOf(hashCode());
    L60:
        if (r16.startsWith("toString") == false) goto L64;
        return toString();
    L64:
        throw new d("illegal getter");
    L66:
        return d.a.a.k.d.c(this.f12376k.get(r2), r8.getGenericReturnType(), m.f12444e);
    L37:
        if (r15.name().length() == 0) goto L39;
        r2 = r15.name();
        goto L39
    L68:
        throw new d("illegal getter");
    L70:
        throw new UnsupportedOperationException(r8.toGenericString());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f12376k.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.f12376k.keySet();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(String r1, Object r2) {
        return u(r1, r2);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> r1) {
        this.f12376k.putAll(r1);
    }

    @Override // java.util.Map
    public Object remove(Object r1) {
        return this.f12376k.remove(r1);
    }

    @Override // java.util.Map
    public int size() {
        return this.f12376k.size();
    }

    public Map<String, Object> t() {
        return this.f12376k;
    }

    public Object u(String r1, Object r2) {
        return this.f12376k.put(r1, r2);
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.f12376k.values();
    }
}
