package com.ss.android.http.legacy.message;

import com.ss.android.http.legacy.Header;
import com.ss.android.http.legacy.HeaderElement;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class BasicHeader implements Header, Cloneable {
    private final String name;
    private final String value;

    public BasicHeader(String r1, String r2) {
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

    @Override // com.ss.android.http.legacy.Header
    public HeaderElement[] getElements() {
        String r1 = this.value;
        if (r1 == null) goto L7;
        return BasicHeaderValueParser.parseElements(r1, null);
    L7:
        return new HeaderElement[0];
    }

    @Override // com.ss.android.http.legacy.Header
    public String getName() {
        return this.name;
    }

    @Override // com.ss.android.http.legacy.Header
    public String getValue() {
        return this.value;
    }

    public String toString() {
        return BasicLineFormatter.DEFAULT.formatHeader(null, this).toString();
    }
}
