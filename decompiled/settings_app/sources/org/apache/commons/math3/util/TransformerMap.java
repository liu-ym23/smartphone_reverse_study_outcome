package org.apache.commons.math3.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

/* JADX INFO: loaded from: classes6.dex */
public class TransformerMap implements NumberTransformer, Serializable {
    private static final long serialVersionUID = 4605318041528645258L;
    private NumberTransformer defaultTransformer;
    private Map<Class<?>, NumberTransformer> map;

    public TransformerMap() {
        this.defaultTransformer = null;
        this.map = null;
        this.map = new HashMap();
        this.defaultTransformer = new DefaultTransformer();
    }

    public boolean containsClass(Class<?> r1) {
        return this.map.containsKey(r1);
    }

    public boolean containsTransformer(NumberTransformer r1) {
        return this.map.containsValue(r1);
    }

    public NumberTransformer getTransformer(Class<?> r1) {
        return this.map.get(r1);
    }

    public NumberTransformer putTransformer(Class<?> r1, NumberTransformer r2) {
        return this.map.put(r1, r2);
    }

    public NumberTransformer removeTransformer(Class<?> r1) {
        return this.map.remove(r1);
    }

    public void clear() {
        this.map.clear();
    }

    public Set<Class<?>> classes() {
        return this.map.keySet();
    }

    public Collection<NumberTransformer> transformers() {
        return this.map.values();
    }

    @Override // org.apache.commons.math3.util.NumberTransformer
    public double transform(Object r2) throws MathIllegalArgumentException {
        if ((r2 instanceof Number) == true) goto L12;
        if ((r2 instanceof String) == true) goto L12;
        NumberTransformer r1 = getTransformer(r2.getClass());
        if (r1 != null) goto L13;
        return Double.NaN;
    L13:
        return r1.transform(r2);
    L12:
        return this.defaultTransformer.transform(r2);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof TransformerMap) == false) goto L20;
        TransformerMap r7 = (TransformerMap) r6;
        if (this.defaultTransformer.equals(r7.defaultTransformer) == true) goto L11;
        return false;
    L11:
        if (this.map.size() == r7.map.size()) goto L13;
        return false;
    L13:
        Iterator<Map.Entry<Class<?>, NumberTransformer>> r5 = this.map.entrySet().iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Map.Entry<Class<?>, NumberTransformer> r1 = r5.next();
        if (r1.getValue().equals(r7.map.get(r1.getKey())) == true) goto L15;
        return false;
    L19:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.defaultTransformer.hashCode();
        Iterator<NumberTransformer> r2 = this.map.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = (r0 * 31) + r2.next().hashCode();
        goto L4
    L6:
        return r0;
    }
}
