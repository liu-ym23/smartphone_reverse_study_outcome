package com.ss.android.http.legacy.message;

import com.bytedance.frameworks.baselib.network.http.util.CharArrayBuffer;
import com.ss.android.http.legacy.Header;
import com.ss.android.http.legacy.HeaderIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class HeaderGroup implements Cloneable {
    private List headers;

    public HeaderGroup() {
        this.headers = new ArrayList(16);
    }

    public void addHeader(Header r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.headers.add(r1);
    }

    public void clear() {
        this.headers.clear();
    }

    public Object clone() {
        HeaderGroup r0 = (HeaderGroup) super.clone();
        r0.headers = new ArrayList(this.headers);
        return r0;
    }

    public boolean containsHeader(String r4) {
        int r1 = 0;
    L4:
        if (r1 >= this.headers.size()) goto L10;
        if (((Header) this.headers.get(r1)).getName().equalsIgnoreCase(r4) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public HeaderGroup copy() {
        HeaderGroup r0 = new HeaderGroup();
        r0.headers.addAll(this.headers);
        return r0;
    }

    public Header[] getAllHeaders() {
        List r1 = this.headers;
        return (Header[]) r1.toArray(new Header[r1.size()]);
    }

    public Header getCondensedHeader(String r5) {
        Header[] r4 = getHeaders(r5);
        if (r4.length != 0) goto L6;
        return null;
    L6:
        int r2 = 1;
        if (r4.length == 1) goto L9;
        CharArrayBuffer r0 = new CharArrayBuffer(128);
        r0.append(r4[0].getValue());
    L12:
        if (r2 >= r4.length) goto L15;
        r0.append(", ");
        r0.append(r4[r2].getValue());
        r2 = r2 + 1;
        goto L12
    L15:
        return new BasicHeader(r5.toLowerCase(Locale.ENGLISH), r0.toString());
    L9:
        return r4[0];
    }

    public Header getFirstHeader(String r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.headers.size()) goto L9;
        Header r1 = (Header) this.headers.get(r0);
        if (r1.getName().equalsIgnoreCase(r4) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    public Header[] getHeaders(String r5) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.headers.size()) goto L10;
        Header r2 = (Header) this.headers.get(r1);
        if (r2.getName().equalsIgnoreCase(r5) == false) goto L8;
        r0.add(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return (Header[]) r0.toArray(new Header[r0.size()]);
    }

    public Header getLastHeader(String r4) {
        int r0 = this.headers.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        Header r1 = (Header) this.headers.get(r0);
        if (r1.getName().equalsIgnoreCase(r4) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r1;
    L8:
        return null;
    }

    public HeaderIterator iterator() {
        return new BasicListHeaderIterator(this.headers, null);
    }

    public void removeHeader(Header r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.headers.remove(r1);
    }

    public void setHeaders(Header[] r4) {
        clear();
        if (r4 != null) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r4.length) goto L9;
        this.headers.add(r4[r0]);
        r0 = r0 + 1;
        goto L7
    }

    public void updateHeader(Header r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = 0;
    L6:
        if (r0 >= this.headers.size()) goto L12;
        if (((Header) this.headers.get(r0)).getName().equalsIgnoreCase(r4.getName()) == true) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        this.headers.set(r0, r4);
        return;
    L12:
        this.headers.add(r4);
    }

    public HeaderIterator iterator(String r2) {
        return new BasicListHeaderIterator(this.headers, r2);
    }
}
