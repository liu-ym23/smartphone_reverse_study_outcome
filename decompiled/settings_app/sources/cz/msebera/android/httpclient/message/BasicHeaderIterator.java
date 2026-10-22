package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.util.Args;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHeaderIterator implements HeaderIterator {
    protected final Header[] allHeaders;
    protected int currentIndex;
    protected String headerName;

    public BasicHeaderIterator(Header[] r2, String r3) {
        this.allHeaders = (Header[]) Args.notNull(r2, "Header array");
        this.headerName = r3;
        this.currentIndex = findNext(-1);
    }

    protected int findNext(int r4) {
        if (r4 >= (-1)) goto L5;
        return -1;
    L5:
        int r1 = this.allHeaders.length - 1;
        boolean r2 = false;
    L6:
        if (r2 == true) goto L9;
        if (r4 >= r1) goto L9;
        r4 = r4 + 1;
        r2 = filterHeader(r4);
    L9:
        if (r2 == true) goto L11;
        return -1;
    L11:
        return r4;
    }

    protected boolean filterHeader(int r2) {
        String r0 = this.headerName;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.equalsIgnoreCase(this.allHeaders[r2].getName()) == true) goto L8;
        return false;
    }

    @Override // cz.msebera.android.httpclient.HeaderIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentIndex < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // cz.msebera.android.httpclient.HeaderIterator
    public Header nextHeader() throws NoSuchElementException {
        int r0 = this.currentIndex;
        if (r0 < 0) goto L7;
        this.currentIndex = findNext(r0);
        return this.allHeaders[r0];
    L7:
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        return nextHeader();
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing headers is not supported.");
    }
}
