package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.bytedance.frameworks.baselib.network.http.util.LangUtils;
import com.ss.android.http.legacy.NameValuePair;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class BasicNameValuePair implements NameValuePair, Cloneable {
    private final String name;
    private final String value;

    public BasicNameValuePair(String r1, String r2) {
        if (r1 == null) goto L7;
        this.name = r1;
        this.value = r2;
        return;
    L7:
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
        if ((r5 instanceof NameValuePair) == false) goto L16;
        BasicNameValuePair r6 = (BasicNameValuePair) r5;
        if (this.name.equals(r6.name) == true) goto L13;
        return false;
    L13:
        if (LangUtils.equals(this.value, r6.value) == true) goto L15;
        return false;
    L15:
        return true;
    L16:
        return false;
    }

    @Override // com.ss.android.http.legacy.NameValuePair
    public String getName() {
        return this.name;
    }

    @Override // com.ss.android.http.legacy.NameValuePair
    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
    }

    public String toString() {
        int r0 = this.name.length();
        String r1 = this.value;
        if (r1 == null) goto L5;
        r0 = r0 + (r1.length() + 1);
    L5:
        CharArrayBuffer r2 = new CharArrayBuffer(r0);
        r2.append(this.name);
        if (this.value == null) goto L9;
        r2.append("=");
        r2.append(this.value);
    L9:
        return r2.toString();
    }
}
