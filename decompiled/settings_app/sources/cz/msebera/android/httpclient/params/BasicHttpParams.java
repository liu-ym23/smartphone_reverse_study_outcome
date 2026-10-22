package cz.msebera.android.httpclient.params;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class BasicHttpParams extends AbstractHttpParams implements Serializable, Cloneable {
    private static final long serialVersionUID = -7086398485908701455L;
    private final Map<String, Object> parameters;

    public BasicHttpParams() {
        this.parameters = new ConcurrentHashMap();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public Object getParameter(String r1) {
        return this.parameters.get(r1);
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams setParameter(String r2, Object r3) {
        if (r2 != null) goto L4;
        return this;
    L4:
        if (r3 == null) goto L6;
        this.parameters.put(r2, r3);
    L7:
        return this;
    L6:
        this.parameters.remove(r2);
        goto L7
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public boolean removeParameter(String r2) {
        if (this.parameters.containsKey(r2) == false) goto L6;
        this.parameters.remove(r2);
        return true;
    L6:
        return false;
    }

    public void setParameters(String[] r4, Object r5) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        setParameter(r4[r1], r5);
        r1 = r1 + 1;
        goto L3
    }

    public boolean isParameterSet(String r1) {
        if (getParameter(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isParameterSetLocally(String r1) {
        if (this.parameters.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void clear() {
        this.parameters.clear();
    }

    @Override // cz.msebera.android.httpclient.params.HttpParams
    public HttpParams copy() {
        return (HttpParams) clone();
    L5:
        throw new UnsupportedOperationException("Cloning not supported");
    }

    public Object clone() throws CloneNotSupportedException {
        BasicHttpParams r0 = (BasicHttpParams) super.clone();
        copyParams(r0);
        return r0;
    }

    public void copyParams(HttpParams r3) {
        Iterator<Map.Entry<String, Object>> r2 = this.parameters.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<String, Object> r0 = r2.next();
        r3.setParameter(r0.getKey(), r0.getValue());
        goto L4
    }

    @Override // cz.msebera.android.httpclient.params.AbstractHttpParams, cz.msebera.android.httpclient.params.HttpParamsNames
    public Set<String> getNames() {
        return new HashSet(this.parameters.keySet());
    }

    public String toString() {
        return "[parameters=" + this.parameters + "]";
    }
}
