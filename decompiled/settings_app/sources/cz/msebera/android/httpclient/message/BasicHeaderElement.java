package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHeaderElement implements HeaderElement, Cloneable {
    private final String name;
    private final NameValuePair[] parameters;
    private final String value;

    public BasicHeaderElement(String r2, String r3, NameValuePair[] r4) {
        this.name = (String) Args.notNull(r2, "Name");
        this.value = r3;
        if (r4 == null) goto L5;
        this.parameters = r4;
        return;
    L5:
        this.parameters = new NameValuePair[0];
    }

    public BasicHeaderElement(String r2, String r3) {
        this(r2, r3, null);
    }

    @Override // cz.msebera.android.httpclient.HeaderElement
    public String getName() {
        return this.name;
    }

    @Override // cz.msebera.android.httpclient.HeaderElement
    public String getValue() {
        return this.value;
    }

    @Override // cz.msebera.android.httpclient.HeaderElement
    public NameValuePair[] getParameters() {
        return (NameValuePair[]) this.parameters.clone();
    }

    @Override // cz.msebera.android.httpclient.HeaderElement
    public int getParameterCount() {
        return this.parameters.length;
    }

    @Override // cz.msebera.android.httpclient.HeaderElement
    public NameValuePair getParameter(int r1) {
        return this.parameters[r1];
    }

    @Override // cz.msebera.android.httpclient.HeaderElement
    public NameValuePair getParameterByName(String r5) {
        Args.notNull(r5, "Name");
        NameValuePair[] r4 = this.parameters;
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        NameValuePair r2 = r4[r1];
        if (r2.getName().equalsIgnoreCase(r5) == true) goto L12;
        r1 = r1 + 1;
        goto L3
    L12:
        return r2;
    L8:
        return null;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HeaderElement) == false) goto L16;
        BasicHeaderElement r6 = (BasicHeaderElement) r5;
        if (this.name.equals(r6.name) == false) goto L15;
        if (LangUtils.equals(this.value, r6.value) == false) goto L15;
        if (LangUtils.equals(this.parameters, r6.parameters) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
        NameValuePair[] r4 = this.parameters;
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0 = LangUtils.hashCode(r0, r4[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.name);
        if (this.value == null) goto L5;
        r0.append("=");
        r0.append(this.value);
    L5:
        NameValuePair[] r5 = this.parameters;
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L9;
        NameValuePair r3 = r5[r2];
        r0.append(VectorFormat.DEFAULT_SEPARATOR);
        r0.append(r3);
        r2 = r2 + 1;
        goto L6
    L9:
        return r0.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
