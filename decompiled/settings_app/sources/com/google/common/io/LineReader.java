package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class LineReader {
    private final char[] buf;
    private final CharBuffer cbuf;
    private final LineBuffer lineBuf;
    private final Queue<String> lines;
    private final Readable readable;

    @CheckForNull
    private final Reader reader;

    static /* synthetic */ Queue access$000(LineReader r0) {
        return r0.lines;
    }

    public LineReader(Readable r2) {
        CharBuffer r0 = CharStreams.createBuffer();
        this.cbuf = r0;
        this.buf = r0.array();
        this.lines = new ArrayDeque();
        this.lineBuf = new AnonymousClass1(this);
        this.readable = (Readable) Preconditions.checkNotNull(r2);
        if ((r2 instanceof Reader) == false) goto L5;
        Reader r3 = (Reader) r2;
    L6:
        this.reader = r3;
        return;
    L5:
        r3 = null;
        goto L6
    }

    @CheckForNull
    public String readLine() throws IOException {
    L3:
        if (this.lines.peek() != null) goto L13;
        Java8Compatibility.clear(this.cbuf);
        Reader r0 = this.reader;
        if (r0 == null) goto L7;
        char[] r2 = this.buf;
        int r1 = r0.read(r2, 0, r2.length);
    L9:
        if (r1 == (-1)) goto L10;
        this.lineBuf.add(this.buf, 0, r1);
        goto L3
    L10:
        this.lineBuf.finish();
        goto L13
    L7:
        r1 = this.readable.read(this.cbuf);
    L13:
        return this.lines.poll();
    }
}
