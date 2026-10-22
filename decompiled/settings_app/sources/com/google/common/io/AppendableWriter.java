package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class AppendableWriter extends Writer {
    private boolean closed;
    private final Appendable target;

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r1) throws IOException {
        return append(r1);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(@CheckForNull CharSequence r1) throws IOException {
        return append(r1);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(@CheckForNull CharSequence r1, int r2, int r3) throws IOException {
        return append(r1, r2, r3);
    }

    AppendableWriter(Appendable r1) {
        this.target = (Appendable) Preconditions.checkNotNull(r1);
    }

    @Override // java.io.Writer
    public void write(char[] r2, int r3, int r4) throws IOException {
        checkNotClosed();
        this.target.append(new String(r2, r3, r4));
    }

    @Override // java.io.Writer
    public void write(int r1) throws IOException {
        checkNotClosed();
        this.target.append((char) r1);
    }

    @Override // java.io.Writer
    public void write(String r1) throws IOException {
        Preconditions.checkNotNull(r1);
        checkNotClosed();
        this.target.append(r1);
    }

    @Override // java.io.Writer
    public void write(String r1, int r2, int r3) throws IOException {
        Preconditions.checkNotNull(r1);
        checkNotClosed();
        this.target.append(r1, r2, r3 + r2);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        checkNotClosed();
        Appendable r1 = this.target;
        if ((r1 instanceof Flushable) == false) goto L6;
        ((Flushable) r1).flush();
        return;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        Appendable r1 = this.target;
        if ((r1 instanceof Closeable) == false) goto L6;
        ((Closeable) r1).close();
        return;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char r2) throws IOException {
        checkNotClosed();
        this.target.append(r2);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@CheckForNull CharSequence r2) throws IOException {
        checkNotClosed();
        this.target.append(r2);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@CheckForNull CharSequence r2, int r3, int r4) throws IOException {
        checkNotClosed();
        this.target.append(r2, r3, r4);
        return this;
    }

    private void checkNotClosed() throws IOException {
        if (this.closed == true) goto L6;
        return;
    L6:
        throw new IOException("Cannot write to a closed writer.");
    }
}
