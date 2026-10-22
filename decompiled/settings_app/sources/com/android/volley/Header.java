package com.android.volley;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class Header {
    private final String mName;
    private final String mValue;

    public Header(String r1, String r2) {
        this.mName = r1;
        this.mValue = r2;
    }

    public final String getName() {
        return this.mName;
    }

    public final String getValue() {
        return this.mValue;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        Header r6 = (Header) r5;
        if (TextUtils.equals(this.mName, r6.mName) == false) goto L16;
        if (TextUtils.equals(this.mValue, r6.mValue) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return (this.mName.hashCode() * 31) + this.mValue.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.mName + ",value=" + this.mValue + "]";
    }
}
