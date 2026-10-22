package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.bytedance.frameworks.baselib.network.http.util.LangUtils;
import com.ss.android.http.legacy.HeaderElement;
import com.ss.android.http.legacy.NameValuePair;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class BasicHeaderElement implements HeaderElement, Cloneable {
    private final String name;
    private final NameValuePair[] parameters;
    private final String value;

    public BasicHeaderElement(String r1, String r2, NameValuePair[] r3) {
        if (r1 == null) goto L10;
        this.name = r1;
        this.value = r2;
        if (r3 == null) goto L7;
        this.parameters = r3;
        return;
    L7:
        this.parameters = new NameValuePair[0];
        return;
    L10:
        throw new IllegalArgumentException("Name may not be null");
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this != r5) goto L9;
        return true;
    L9:
        if ((r5 instanceof HeaderElement) == false) goto L18;
        BasicHeaderElement r6 = (BasicHeaderElement) r5;
        if (this.name.equals(r6.name) == true) goto L13;
        return false;
    L13:
        if (LangUtils.equals(this.value, r6.value) == true) goto L15;
        return false;
    L15:
        if (LangUtils.equals(this.parameters, r6.parameters) == true) goto L17;
        return false;
    L17:
        return true;
    L18:
        return false;
    }

    @Override // com.ss.android.http.legacy.HeaderElement
    public String getName() {
        return this.name;
    }

    @Override // com.ss.android.http.legacy.HeaderElement
    public NameValuePair getParameter(int r1) {
        return this.parameters[r1];
    }

    @Override // com.ss.android.http.legacy.HeaderElement
    public NameValuePair getParameterByName(String r4) {
        if (r4 == null) goto L13;
        int r0 = 0;
    L4:
        NameValuePair[] r1 = this.parameters;
        if (r0 >= r1.length) goto L10;
        NameValuePair r2 = r1[r0];
        if (r2.getName().equalsIgnoreCase(r4) == true) goto L16;
        r0 = r0 + 1;
        goto L4
    L16:
        return r2;
    L10:
        return null;
    L13:
        throw new IllegalArgumentException("Name may not be null");
    }

    @Override // com.ss.android.http.legacy.HeaderElement
    public int getParameterCount() {
        return this.parameters.length;
    }

    @Override // com.ss.android.http.legacy.HeaderElement
    public NameValuePair[] getParameters() {
        return (NameValuePair[]) this.parameters.clone();
    }

    @Override // com.ss.android.http.legacy.HeaderElement
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int r0 = LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
        int r1 = 0;
    L3:
        NameValuePair[] r2 = this.parameters;
        if (r1 >= r2.length) goto L6;
        r0 = LangUtils.hashCode(r0, r2[r1]);
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public String toString() {
        CharArrayBuffer r0 = new CharArrayBuffer(64);
        r0.append(this.name);
        if (this.value == null) goto L5;
        r0.append("=");
        r0.append(this.value);
    L5:
        int r1 = 0;
    L7:
        if (r1 >= this.parameters.length) goto L10;
        r0.append("; ");
        r0.append(this.parameters[r1]);
        r1 = r1 + 1;
        goto L7
    L10:
        return r0.toString();
    }

    public BasicHeaderElement(String r2, String r3) {
        this(r2, r3, null);
    }
}
