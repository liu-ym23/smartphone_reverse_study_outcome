package okio;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public final class Pipe {
    final Buffer buffer;
    final long maxBufferSize;
    private final Sink sink;
    boolean sinkClosed;
    private final Source source;
    boolean sourceClosed;

    final class PipeSink implements Sink {
        final /* synthetic */ Pipe this$0;
        final Timeout timeout;

        PipeSink(Pipe r1) {
            this.this$0 = r1;
            this.timeout = new Timeout();
        }

        @Override // okio.Sink
        public void write(Buffer r8, long r9) throws IOException {
            Buffer r0 = this.this$0.buffer;
            monitor-enter(r0);
        L20:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.sinkClosed == true) goto L19;
        L7:
            if (r9 <= 0) goto L16;
            if (this.this$0.sourceClosed == true) goto L15;
            long r3 = this.this$0.maxBufferSize - this.this$0.buffer.size();     // Catch: Throwable -> L20
            if (r3 == 0) goto L12;
            long r1 = Math.min(r3, r9);     // Catch: Throwable -> L20
            this.this$0.buffer.write(r8, r1);     // Catch: Throwable -> L20
            r9 = r9 - r1;     // Catch: Throwable -> L20
            this.this$0.buffer.notifyAll();     // Catch: Throwable -> L20
            goto L7
        L12:
            this.timeout.waitUntilNotified(this.this$0.buffer);     // Catch: Throwable -> L20
            goto L7
        L15:
            throw new IOException("source is closed");     // Catch: Throwable -> L20
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L20
            return;
        L19:
            throw new IllegalStateException("closed");     // Catch: Throwable -> L20
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Buffer r0 = this.this$0.buffer;
            monitor-enter(r0);
        L17:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.sinkClosed == true) goto L16;
            if (this.this$0.sourceClosed == true) goto L9;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L17
            return;
        L9:
            if (this.this$0.buffer.size() <= 0) goto L13;
            throw new IOException("source is closed");     // Catch: Throwable -> L17
        L16:
            throw new IllegalStateException("closed");     // Catch: Throwable -> L17
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Buffer r0 = this.this$0.buffer;
            monitor-enter(r0);
        L18:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.sinkClosed == false) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L18
            return;
        L9:
            if (this.this$0.sourceClosed == true) goto L11;
        L15:
            this.this$0.sinkClosed = true;     // Catch: Throwable -> L18
            this.this$0.buffer.notifyAll();     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            return;
        L11:
            if (this.this$0.buffer.size() <= 0) goto L15;
            throw new IOException("source is closed");     // Catch: Throwable -> L18
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }
    }

    final class PipeSource implements Source {
        final /* synthetic */ Pipe this$0;
        final Timeout timeout;

        PipeSource(Pipe r1) {
            this.this$0 = r1;
            this.timeout = new Timeout();
        }

        @Override // okio.Source
        public long read(Buffer r6, long r7) throws IOException {
            Buffer r0 = this.this$0.buffer;
            monitor-enter(r0);
        L19:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.sourceClosed == true) goto L18;
        L7:
            if (this.this$0.buffer.size() != 0) goto L14;
            if (this.this$0.sinkClosed == true) goto L10;
            this.timeout.waitUntilNotified(this.this$0.buffer);     // Catch: Throwable -> L19
            goto L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return -1;
        L14:
            long r8 = this.this$0.buffer.read(r6, r7);     // Catch: Throwable -> L19
            this.this$0.buffer.notifyAll();     // Catch: Throwable -> L19
            monitor-exit(r0);     // Catch: Throwable -> L19
            return r8;
        L18:
            throw new IllegalStateException("closed");     // Catch: Throwable -> L19
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Buffer r0 = this.this$0.buffer;
            monitor-enter(r0);
            this.this$0.sourceClosed = true;     // Catch: Throwable -> L7
            this.this$0.buffer.notifyAll();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long r3) {
        this.buffer = new Buffer();
        this.sink = new PipeSink(this);
        this.source = new PipeSource(this);
        if (r3 < 1) goto L7;
        this.maxBufferSize = r3;
        return;
    L7:
        throw new IllegalArgumentException("maxBufferSize < 1: " + r3);
    }

    public final Source source() {
        return this.source;
    }

    public final Sink sink() {
        return this.sink;
    }
}
