package com.ss.android.http.legacy.message;

import com.ss.android.http.legacy.Header;
import com.ss.android.http.legacy.HeaderIterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class BasicListHeaderIterator implements HeaderIterator {
    protected final List allHeaders;
    protected int currentIndex;
    protected String headerName;
    protected int lastIndex;

    public BasicListHeaderIterator(List r1, String r2) {
        if (r1 == null) goto L7;
        this.allHeaders = r1;
        this.headerName = r2;
        this.currentIndex = findNext(-1);
        this.lastIndex = -1;
        return;
    L7:
        throw new IllegalArgumentException("Header list must not be null.");
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
        String r3 = ((Header) this.allHeaders.get(r2)).getName();
        return this.headerName.equalsIgnoreCase(r3);
    }

    @Override // com.ss.android.http.legacy.HeaderIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentIndex < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.http.legacy.HeaderIterator
    public Header nextHeader() throws NoSuchElementException {
        int r0 = this.currentIndex;
        if (r0 < 0) goto L7;
        this.lastIndex = r0;
        this.currentIndex = findNext(r0);
        return (Header) this.allHeaders.get(r0);
    L7:
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        return nextHeader();
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        int r0 = this.lastIndex;
        if (r0 < 0) goto L7;
        this.allHeaders.remove(r0);
        this.lastIndex = -1;
        this.currentIndex--;
        return;
    L7:
        throw new IllegalStateException("No header to remove.");
    }
}
