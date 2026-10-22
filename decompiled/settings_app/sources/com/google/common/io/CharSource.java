package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class CharSource {

    private final class AsByteSource extends ByteSource {
        final Charset charset;
        final /* synthetic */ CharSource this$0;

        AsByteSource(CharSource r1, Charset r2) {
            this.this$0 = r1;
            this.charset = (Charset) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(Charset r2) {
            if (r2.equals(this.charset) == false) goto L7;
            return this.this$0;
        L7:
            return super.asCharSource(r2);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return new ReaderInputStream(this.this$0.openStream(), this.charset, 8192);
        }

        public String toString() {
            String r0 = this.this$0.toString();
            String r3 = String.valueOf(this.charset);
            return new StringBuilder((String.valueOf(r0).length() + 15) + String.valueOf(r3).length()).append(r0).append(".asByteSource(").append(r3).append(")").toString();
        }
    }

    private static class CharSequenceCharSource extends CharSource {
        private static final Splitter LINE_SPLITTER = null;
        protected final CharSequence seq;

        static /* synthetic */ Splitter access$100() {
            return LINE_SPLITTER;
        }

        static {
            LINE_SPLITTER = Splitter.onPattern("\r\n|\n|\r");
        }

        protected CharSequenceCharSource(CharSequence r1) {
            this.seq = (CharSequence) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() {
            return new CharSequenceReader(this.seq);
        }

        @Override // com.google.common.io.CharSource
        public String read() {
            return this.seq.toString();
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() {
            if (this.seq.length() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.io.CharSource
        public long length() {
            return this.seq.length();
        }

        @Override // com.google.common.io.CharSource
        public Optional<Long> lengthIfKnown() {
            return Optional.of(Long.valueOf(this.seq.length()));
        }

        private Iterator<String> linesIterator() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.io.CharSource
        public Stream<String> lines() {
            return Streams.stream(linesIterator());
        }

        @Override // com.google.common.io.CharSource
        @CheckForNull
        public String readFirstLine() {
            Iterator<String> r1 = linesIterator();
            if (r1.hasNext() == true) goto L7;
            return null;
        L7:
            return r1.next();
        }

        @Override // com.google.common.io.CharSource
        public ImmutableList<String> readLines() {
            return ImmutableList.copyOf(linesIterator());
        }

        @Override // com.google.common.io.CharSource
        @ParametricNullness
        public <T> T readLines(LineProcessor<T> r2) throws IOException {
            Iterator<String> r1 = linesIterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            if (r2.processLine(r1.next()) == true) goto L4;
        L8:
            return r2.getResult();
        }

        public String toString() {
            String r2 = Ascii.truncate(this.seq, 30, "...");
            return new StringBuilder(String.valueOf(r2).length() + 17).append("CharSource.wrap(").append(r2).append(")").toString();
        }
    }

    private static final class ConcatenatedCharSource extends CharSource {
        private final Iterable<? extends CharSource> sources;

        ConcatenatedCharSource(Iterable<? extends CharSource> r1) {
            this.sources = (Iterable) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() throws IOException {
            return new MultiReader(this.sources.iterator());
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() throws IOException {
            Iterator<? extends CharSource> r1 = this.sources.iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            if (r1.next().isEmpty() == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // com.google.common.io.CharSource
        public Optional<Long> lengthIfKnown() {
            Iterator<? extends CharSource> r4 = this.sources.iterator();
            long r0 = 0;
        L4:
            if (r4.hasNext() == false) goto L11;
            Optional<Long> r2 = r4.next().lengthIfKnown();
            if (r2.isPresent() == false) goto L8;
            r0 = r0 + r2.get().longValue();
            goto L4
        L8:
            return Optional.absent();
        L11:
            return Optional.of(Long.valueOf(r0));
        }

        @Override // com.google.common.io.CharSource
        public long length() throws IOException {
            Iterator<? extends CharSource> r4 = this.sources.iterator();
            long r0 = 0;
        L4:
            if (r4.hasNext() == false) goto L6;
            r0 = r0 + r4.next().length();
            goto L4
        L6:
            return r0;
        }

        public String toString() {
            String r2 = String.valueOf(this.sources);
            return new StringBuilder(String.valueOf(r2).length() + 19).append("CharSource.concat(").append(r2).append(")").toString();
        }
    }

    private static final class EmptyCharSource extends StringCharSource {
        private static final EmptyCharSource INSTANCE = null;

        @Override // com.google.common.io.CharSource.CharSequenceCharSource
        public String toString() {
            return "CharSource.empty()";
        }

        static /* synthetic */ EmptyCharSource access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new EmptyCharSource();
        }

        private EmptyCharSource() {
            super("");
        }
    }

    private static class StringCharSource extends CharSequenceCharSource {
        protected StringCharSource(String r1) {
            super(r1);
        }

        @Override // com.google.common.io.CharSource.CharSequenceCharSource, com.google.common.io.CharSource
        public Reader openStream() {
            return new StringReader((String) this.seq);
        }

        @Override // com.google.common.io.CharSource
        public long copyTo(Appendable r2) throws IOException {
            r2.append(this.seq);
            return this.seq.length();
        }

        @Override // com.google.common.io.CharSource
        public long copyTo(CharSink r3) throws IOException {
            Preconditions.checkNotNull(r3);
            Closer r0 = Closer.create();
            ((Writer) r0.register(r3.openStream())).write((String) this.seq);     // Catch: Throwable -> L6
            long r2 = this.seq.length();     // Catch: Throwable -> L6
            r0.close();
            return r2;
        L6:
            th = move-exception;
        L9:
            th = move-exception;
            r0.close();
            throw th;
        L8:
            throw r0.rethrow(th);     // Catch: Throwable -> L9
        }
    }

    public abstract Reader openStream() throws IOException;

    protected CharSource() {
    }

    public ByteSource asByteSource(Charset r2) {
        return new AsByteSource(this, r2);
    }

    public BufferedReader openBufferedStream() throws IOException {
        Reader r1 = openStream();
        if ((r1 instanceof BufferedReader) == false) goto L6;
        return (BufferedReader) r1;
    L6:
        return new BufferedReader(r1);
    }

    public Stream<String> lines() throws IOException {
        final BufferedReader r2 = openBufferedStream();
        return (Stream) r2.lines().onClose(new CharSource$$ExternalSyntheticLambda0(r2));
    }

    static /* synthetic */ void lambda$lines$0(BufferedReader r1) {
        r1.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new UncheckedIOException(e);
    }

    public Optional<Long> lengthIfKnown() {
        return Optional.absent();
    }

    public long length() throws IOException {
        Optional<Long> r0 = lengthIfKnown();
        if (r0.isPresent() == true) goto L5;
        Closer r1 = Closer.create();
        long r2 = countBySkipping((Reader) r1.register(openStream()));     // Catch: Throwable -> L10
        r1.close();
        return r2;
    L10:
        th = move-exception;
    L13:
        th = move-exception;
        r1.close();
        throw th;
    L12:
        throw r1.rethrow(th);     // Catch: Throwable -> L13
    L5:
        return r0.get().longValue();
    }

    private long countBySkipping(Reader r7) throws IOException {
        long r2 = 0;
    L3:
        long r4 = r7.skip(Long.MAX_VALUE);
        if (r4 == 0) goto L6;
        r2 = r2 + r4;
        goto L3
    L6:
        return r2;
    }

    public long copyTo(Appendable r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        long r1 = CharStreams.copy((Reader) r0.register(openStream()), r2);     // Catch: Throwable -> L6
        r0.close();
        return r1;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r0.close();
        throw th;
    L8:
        throw r0.rethrow(th);     // Catch: Throwable -> L9
    }

    public long copyTo(CharSink r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        long r1 = CharStreams.copy((Reader) r0.register(openStream()), (Writer) r0.register(r2.openStream()));     // Catch: Throwable -> L6
        r0.close();
        return r1;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r0.close();
        throw th;
    L8:
        throw r0.rethrow(th);     // Catch: Throwable -> L9
    }

    public String read() throws IOException {
        Closer r0 = Closer.create();
        String r1 = CharStreams.toString((Reader) r0.register(openStream()));     // Catch: Throwable -> L6
        r0.close();
        return r1;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r0.close();
        throw th;
    L8:
        throw r0.rethrow(th);     // Catch: Throwable -> L9
    }

    @CheckForNull
    public String readFirstLine() throws IOException {
        Closer r0 = Closer.create();
        String r1 = ((BufferedReader) r0.register(openBufferedStream())).readLine();     // Catch: Throwable -> L6
        r0.close();
        return r1;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r0.close();
        throw th;
    L8:
        throw r0.rethrow(th);     // Catch: Throwable -> L9
    }

    public ImmutableList<String> readLines() throws IOException {
        Closer r0 = Closer.create();
        BufferedReader r3 = (BufferedReader) r0.register(openBufferedStream());     // Catch: Throwable -> L10
        ArrayList r1 = Lists.newArrayList();     // Catch: Throwable -> L10
    L4:
        String r2 = r3.readLine();     // Catch: Throwable -> L10
        if (r2 == null) goto L7;
        r1.add(r2);     // Catch: Throwable -> L10
        goto L4
    L7:
        ImmutableList<String> r4 = ImmutableList.copyOf(r1);     // Catch: Throwable -> L10
        r0.close();
        return r4;
    L10:
        th = move-exception;
    L13:
        th = move-exception;
        r0.close();
        throw th;
    L12:
        throw r0.rethrow(th);     // Catch: Throwable -> L13
    }

    @ParametricNullness
    public <T> T readLines(LineProcessor<T> r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        T r1 = (T) CharStreams.readLines((Reader) r0.register(openStream()), r2);
        r0.close();
        return r1;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r0.close();
        throw th;
    L8:
        throw r0.rethrow(th);     // Catch: Throwable -> L9
    }

    public void forEachLine(Consumer<? super String> r1) throws IOException {
        Stream<String> r0 = lines();     // Catch: UncheckedIOException -> L14
        r0.forEachOrdered(r1);     // Catch: Throwable -> L7
        if (r0 == null) goto L22;
        r0.close();     // Catch: UncheckedIOException -> L14
        return;
    L22:
        return;
    L7:
        th = move-exception;
        if (r0 != null) goto L17;
    L13:
        throw th;     // Catch: UncheckedIOException -> L14
    L17:
        r0.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: UncheckedIOException -> L14
    L14:
        e = move-exception;
        throw e.getCause();
    }

    public boolean isEmpty() throws IOException {
        Optional<Long> r0 = lengthIfKnown();
        boolean r2 = true;
        if (r0.isPresent() == true) goto L5;
        Closer r1 = Closer.create();
        if (((Reader) r1.register(openStream())).read() == (-1)) goto L15;
        r2 = false;
    L15:
        r1.close();
        return r2;
    L17:
        th = move-exception;
    L20:
        th = move-exception;
        r1.close();
        throw th;
    L19:
        throw r1.rethrow(th);     // Catch: Throwable -> L20
    L5:
        if (r0.get().longValue() != 0) goto L8;
        return true;
    L8:
        return false;
    }

    public static CharSource concat(Iterable<? extends CharSource> r1) {
        return new ConcatenatedCharSource(r1);
    }

    public static CharSource concat(Iterator<? extends CharSource> r0) {
        return concat(ImmutableList.copyOf(r0));
    }

    public static CharSource concat(CharSource... r0) {
        return concat(ImmutableList.copyOf(r0));
    }

    public static CharSource wrap(CharSequence r1) {
        if ((r1 instanceof String) == false) goto L6;
        return new StringCharSource((String) r1);
    L6:
        return new CharSequenceCharSource(r1);
    }

    public static CharSource empty() {
        return EmptyCharSource.access$000();
    }
}
