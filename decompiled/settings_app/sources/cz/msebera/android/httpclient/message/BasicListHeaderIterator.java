package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public class BasicListHeaderIterator implements HeaderIterator {
    protected final List<Header> allHeaders;
    protected int currentIndex;
    protected String headerName;
    protected int lastIndex;

    public BasicListHeaderIterator(List<Header> r2, String r3) {
        this.allHeaders = (List) Args.notNull(r2, "Header list");
        this.headerName = r3;
        this.currentIndex = findNext(-1);
        this.lastIndex = -1;
    }

    protected int findNext(int r4) {
        if (r4 >= (-1)) goto L5;
        return -1;
    L5:
        int r1 = this.allHeaders.size() - 1;
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
        if (this.headerName != null) goto L6;
        return true;
    L6:
        String r3 = this.allHeaders.get(r2).getName();
        return this.headerName.equalsIgnoreCase(r3);
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
        this.lastIndex = r0;
        this.currentIndex = findNext(r0);
        return this.allHeaders.get(r0);
    L7:
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        return nextHeader();
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        if (this.lastIndex < 0) goto L5;
        boolean r0 = true;
    L6:
        Asserts.check(r0, "No header to remove");
        this.allHeaders.remove(this.lastIndex);
        this.lastIndex = -1;
        this.currentIndex--;
        return;
    L5:
        r0 = false;
        goto L6
    }
}
