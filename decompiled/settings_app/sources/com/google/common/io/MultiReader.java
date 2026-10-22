package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class MultiReader extends Reader {

    @CheckForNull
    private Reader current;
    private final Iterator<? extends CharSource> it;

    MultiReader(Iterator<? extends CharSource> r1) throws IOException {
        this.it = r1;
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.it.hasNext() == false) goto L6;
        this.current = this.it.next().openStream();
        return;
    }

    @Override // java.io.Reader
    public int read(char[] r3, int r4, int r5) throws IOException {
        Preconditions.checkNotNull(r3);
        Reader r0 = this.current;
        if (r0 != null) goto L5;
        return -1;
    L5:
        int r1 = r0.read(r3, r4, r5);
        if (r1 != (-1)) goto L9;
        advance();
        return read(r3, r4, r5);
    L9:
        return r1;
    }

    @Override // java.io.Reader
    public long skip(long r6) throws IOException {
        if (r6 < 0) goto L5;
        boolean r3 = true;
    L6:
        Preconditions.checkArgument(r3, "n is negative");
        if (r6 <= 0) goto L14;
    L8:
        Reader r2 = this.current;
        if (r2 == null) goto L14;
        long r4 = r2.skip(r6);
        if (r4 > 0) goto L12;
        advance();
        goto L8
    L12:
        return r4;
    L14:
        return 0;
    L5:
        r3 = false;
        goto L6
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader r0 = this.current;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.ready() == false) goto L7;
        return true;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader r0 = this.current;
        if (r0 != null) goto L11;
        return;
    L11:
        r0.close();     // Catch: Throwable -> L7
        this.current = null;
        return;
    L7:
        th = move-exception;
        this.current = null;
        throw th;
    }
}
