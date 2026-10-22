package org.apache.commons.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes6.dex */
public class LineIterator implements Iterator {
    private final BufferedReader bufferedReader;
    private String cachedLine;
    private boolean finished;

    protected boolean isValidLine(String r1) {
        return true;
    }

    public LineIterator(Reader r2) throws IllegalArgumentException {
        this.finished = false;
        if (r2 == null) goto L10;
        if ((r2 instanceof BufferedReader) == false) goto L7;
        this.bufferedReader = (BufferedReader) r2;
        return;
    L7:
        this.bufferedReader = new BufferedReader(r2);
        return;
    L10:
        throw new IllegalArgumentException("Reader must not be null");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.cachedLine == null) goto L6;
        return true;
    L6:
        if (this.finished == false) goto L19;
        return false;
    L19:
        String r0 = this.bufferedReader.readLine();     // Catch: IOException -> L16
        if (r0 == null) goto L10;
        if (isValidLine(r0) == false) goto L19;
        this.cachedLine = r0;     // Catch: IOException -> L16
        return true;
    L10:
        this.finished = true;     // Catch: IOException -> L16
        return false;
    L16:
        e = move-exception;
        close();
        throw new IllegalStateException(e.toString());
    }

    @Override // java.util.Iterator
    public Object next() {
        return nextLine();
    }

    public String nextLine() {
        if (hasNext() == false) goto L7;
        String r0 = this.cachedLine;
        this.cachedLine = null;
        return r0;
    L7:
        throw new NoSuchElementException("No more lines");
    }

    public void close() {
        this.finished = true;
        IOUtils.closeQuietly(this.bufferedReader);
        this.cachedLine = null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Remove unsupported on LineIterator");
    }

    public static void closeQuietly(LineIterator r0) {
        if (r0 == null) goto L5;
        r0.close();
        return;
    }
}
