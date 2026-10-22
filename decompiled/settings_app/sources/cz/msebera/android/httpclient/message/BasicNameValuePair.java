package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class BasicNameValuePair implements NameValuePair, Cloneable, Serializable {
    private static final long serialVersionUID = -6437800749411518984L;
    private final String name;
    private final String value;

    public BasicNameValuePair(String r2, String r3) {
        this.name = (String) Args.notNull(r2, "Name");
        this.value = r3;
    }

    @Override // cz.msebera.android.httpclient.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // cz.msebera.android.httpclient.NameValuePair
    public String getValue() {
        return this.value;
    }

    public String toString() {
        if (this.value == null) goto L5;
        StringBuilder r1 = new StringBuilder((this.name.length() + 1) + this.value.length());
        r1.append(this.name);
        r1.append("=");
        r1.append(this.value);
        return r1.toString();
    L5:
        return this.name;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NameValuePair) == false) goto L14;
        BasicNameValuePair r6 = (BasicNameValuePair) r5;
        if (this.name.equals(r6.name) == false) goto L13;
        if (LangUtils.equals(this.value, r6.value) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
