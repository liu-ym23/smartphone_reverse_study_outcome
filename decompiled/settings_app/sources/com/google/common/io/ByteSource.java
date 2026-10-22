package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ByteSource {

    class AsCharSource extends CharSource {
        final Charset charset;
        final /* synthetic */ ByteSource this$0;

        AsCharSource(ByteSource r1, Charset r2) {
            this.this$0 = r1;
            this.charset = (Charset) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.io.CharSource
        public ByteSource asByteSource(Charset r2) {
            if (r2.equals(this.charset) == false) goto L7;
            return this.this$0;
        L7:
            return super.asByteSource(r2);
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() throws IOException {
            return new InputStreamReader(this.this$0.openStream(), this.charset);
        }

        @Override // com.google.common.io.CharSource
        public String read() throws IOException {
            return new String(this.this$0.read(), this.charset);
        }

        public String toString() {
            String r0 = this.this$0.toString();
            String r3 = String.valueOf(this.charset);
            return new StringBuilder((String.valueOf(r0).length() + 15) + String.valueOf(r3).length()).append(r0).append(".asCharSource(").append(r3).append(")").toString();
        }
    }

    private static class ByteArrayByteSource extends ByteSource {
        final byte[] bytes;
        final int length;
        final int offset;

        ByteArrayByteSource(byte[] r3) {
            this(r3, 0, r3.length);
        }

        ByteArrayByteSource(byte[] r1, int r2, int r3) {
            this.bytes = r1;
            this.offset = r2;
            this.length = r3;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return new ByteArrayInputStream(this.bytes, this.offset, this.length);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() throws IOException {
            return openStream();
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() {
            if (this.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.io.ByteSource
        public long size() {
            return this.length;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            return Optional.of(Long.valueOf(this.length));
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() {
            byte[] r0 = this.bytes;
            int r1 = this.offset;
            return Arrays.copyOfRange(r0, r1, this.length + r1);
        }

        @Override // com.google.common.io.ByteSource
        @ParametricNullness
        public <T> T read(ByteProcessor<T> r3) throws IOException {
            r3.processBytes(this.bytes, this.offset, this.length);
            return r3.getResult();
        }

        @Override // com.google.common.io.ByteSource
        public long copyTo(OutputStream r4) throws IOException {
            r4.write(this.bytes, this.offset, this.length);
            return this.length;
        }

        @Override // com.google.common.io.ByteSource
        public HashCode hash(HashFunction r3) throws IOException {
            return r3.hashBytes(this.bytes, this.offset, this.length);
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long r7, long r9) {
            boolean r3 = true;
            if (r7 < 0) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2, "offset (%s) may not be negative", r7);
            if (r9 >= 0) goto L10;
            r3 = false;
        L10:
            Preconditions.checkArgument(r3, "length (%s) may not be negative", r9);
            long r8 = Math.min(r7, this.length);
            long r10 = Math.min(r9, ((long) this.length) - r8);
            return new ByteArrayByteSource(this.bytes, this.offset + ((int) r8), (int) r10);
        L5:
            r2 = false;
            goto L6
        }

        public String toString() {
            String r3 = Ascii.truncate(BaseEncoding.base16().encode(this.bytes, this.offset, this.length), 30, "...");
            return new StringBuilder(String.valueOf(r3).length() + 17).append("ByteSource.wrap(").append(r3).append(")").toString();
        }
    }

    private static final class ConcatenatedByteSource extends ByteSource {
        final Iterable<? extends ByteSource> sources;

        ConcatenatedByteSource(Iterable<? extends ByteSource> r1) {
            this.sources = (Iterable) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return new MultiInputStream(this.sources.iterator());
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws IOException {
            Iterator<? extends ByteSource> r1 = this.sources.iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            if (r1.next().isEmpty() == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            Iterable<? extends ByteSource> r6 = this.sources;
            if ((r6 instanceof Collection) == false) goto L5;
            Iterator<? extends ByteSource> r7 = r6.iterator();
            long r2 = 0;
        L8:
            if (r7.hasNext() == false) goto L18;
            Optional<Long> r4 = r7.next().sizeIfKnown();
            if (r4.isPresent() == false) goto L12;
            r2 = r2 + r4.get().longValue();
            if (r2 >= 0) goto L8;
            return Optional.of(Long.MAX_VALUE);
        L12:
            return Optional.absent();
        L18:
            return Optional.of(Long.valueOf(r2));
        L5:
            return Optional.absent();
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws IOException {
            Iterator<? extends ByteSource> r6 = this.sources.iterator();
            long r2 = 0;
        L4:
            if (r6.hasNext() == false) goto L9;
            r2 = r2 + r6.next().size();
            if (r2 >= 0) goto L4;
            return Long.MAX_VALUE;
        L9:
            return r2;
        }

        public String toString() {
            String r2 = String.valueOf(this.sources);
            return new StringBuilder(String.valueOf(r2).length() + 19).append("ByteSource.concat(").append(r2).append(")").toString();
        }
    }

    private static final class EmptyByteSource extends ByteArrayByteSource {
        static final EmptyByteSource INSTANCE = null;

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource
        public String toString() {
            return "ByteSource.empty()";
        }

        static {
            INSTANCE = new EmptyByteSource();
        }

        EmptyByteSource() {
            super(new byte[0]);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(Charset r1) {
            Preconditions.checkNotNull(r1);
            return CharSource.empty();
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource, com.google.common.io.ByteSource
        public byte[] read() {
            return this.bytes;
        }
    }

    private final class SlicedByteSource extends ByteSource {
        final long length;
        final long offset;
        final /* synthetic */ ByteSource this$0;

        SlicedByteSource(ByteSource r6, long r7, long r9) {
            this.this$0 = r6;
            boolean r2 = true;
            if (r7 < 0) goto L5;
            boolean r8 = true;
        L6:
            Preconditions.checkArgument(r8, "offset (%s) may not be negative", r7);
            if (r9 >= 0) goto L10;
            r2 = false;
        L10:
            Preconditions.checkArgument(r2, "length (%s) may not be negative", r9);
            this.offset = r7;
            this.length = r9;
            return;
        L5:
            r8 = false;
            goto L6
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return sliceStream(this.this$0.openStream());
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() throws IOException {
            return sliceStream(this.this$0.openBufferedStream());
        }

        private InputStream sliceStream(InputStream r5) throws IOException {
            long r0 = this.offset;
            if (r0 <= 0) goto L17;
            if (ByteStreams.skipUpTo(r5, r0) >= this.offset) goto L17;
            r5.close();
            return new ByteArrayInputStream(new byte[0]);
        L9:
            th = move-exception;
            Closer r1 = Closer.create();
            r1.register(r5);
        L13:
            th = move-exception;
            r1.close();
            throw th;
        L12:
            throw r1.rethrow(th);     // Catch: Throwable -> L13
        L17:
            return ByteStreams.limit(r5, this.length);
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long r7, long r9) {
            boolean r3 = true;
            if (r7 < 0) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2, "offset (%s) may not be negative", r7);
            if (r9 >= 0) goto L10;
            r3 = false;
        L10:
            Preconditions.checkArgument(r3, "length (%s) may not be negative", r9);
            long r4 = this.length - r7;
            if (r4 > 0) goto L14;
            return ByteSource.empty();
        L14:
            return this.this$0.slice(this.offset + r7, Math.min(r9, r4));
        L5:
            r2 = false;
            goto L6
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws IOException {
            if (this.length != 0) goto L5;
        L8:
            return true;
        L5:
            if (super.isEmpty() == true) goto L8;
            return false;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            Optional<Long> r0 = this.this$0.sizeIfKnown();
            if (r0.isPresent() == false) goto L7;
            long r1 = r0.get().longValue();
            long r2 = Math.min(this.offset, r1);
            return Optional.of(Long.valueOf(Math.min(this.length, r1 - r2)));
        L7:
            return Optional.absent();
        }

        public String toString() {
            String r0 = this.this$0.toString();
            long r1 = this.offset;
            long r3 = this.length;
            return new StringBuilder(String.valueOf(r0).length() + 50).append(r0).append(".slice(").append(r1).append(", ").append(r3).append(")").toString();
        }
    }

    public abstract InputStream openStream() throws IOException;

    protected ByteSource() {
    }

    public CharSource asCharSource(Charset r2) {
        return new AsCharSource(this, r2);
    }

    public InputStream openBufferedStream() throws IOException {
        InputStream r1 = openStream();
        if ((r1 instanceof BufferedInputStream) == false) goto L6;
        return (BufferedInputStream) r1;
    L6:
        return new BufferedInputStream(r1);
    }

    public ByteSource slice(long r8, long r10) {
        return new SlicedByteSource(this, r8, r10);
    }

    public boolean isEmpty() throws IOException {
        Optional<Long> r0 = sizeIfKnown();
        boolean r2 = true;
        if (r0.isPresent() == true) goto L5;
        Closer r1 = Closer.create();
        if (((InputStream) r1.register(openStream())).read() == (-1)) goto L15;
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

    public Optional<Long> sizeIfKnown() {
        return Optional.absent();
    }

    public long size() throws IOException {
        Optional<Long> r0 = sizeIfKnown();
        if (r0.isPresent() == true) goto L5;
        Closer r1 = Closer.create();
        long r2 = countBySkipping((InputStream) r1.register(openStream()));     // Catch: Throwable -> L10 IOException -> L13
        r1.close();
        return r2;
    L13:
        r1.close();
        Closer r3 = Closer.create();
        long r4 = ByteStreams.exhaust((InputStream) r3.register(openStream()));     // Catch: Throwable -> L17
        r3.close();
        return r4;
    L17:
        th = move-exception;
    L20:
        th = move-exception;
        r3.close();
        throw th;
    L19:
        throw r3.rethrow(th);     // Catch: Throwable -> L20
    L10:
        th = move-exception;
        r1.close();
        throw th;
    L5:
        return r0.get().longValue();
    }

    private long countBySkipping(InputStream r7) throws IOException {
        long r2 = 0;
    L3:
        long r4 = ByteStreams.skipUpTo(r7, 2147483647L);
        if (r4 <= 0) goto L6;
        r2 = r2 + r4;
        goto L3
    L6:
        return r2;
    }

    public long copyTo(OutputStream r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        long r1 = ByteStreams.copy((InputStream) r0.register(openStream()), r2);     // Catch: Throwable -> L6
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

    public long copyTo(ByteSink r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        long r1 = ByteStreams.copy((InputStream) r0.register(openStream()), (OutputStream) r0.register(r2.openStream()));     // Catch: Throwable -> L6
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

    public byte[] read() throws IOException {
        Closer r0 = Closer.create();
        InputStream r1 = (InputStream) r0.register(openStream());     // Catch: Throwable -> L9
        Optional<Long> r4 = sizeIfKnown();     // Catch: Throwable -> L9
        if (r4.isPresent() == false) goto L6;
        byte[] r5 = ByteStreams.toByteArray(r1, r4.get().longValue());     // Catch: Throwable -> L9
    L7:
        r0.close();
        return r5;
    L6:
        r5 = ByteStreams.toByteArray(r1);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
    L12:
        th = move-exception;
        r0.close();
        throw th;
    L11:
        throw r0.rethrow(th);     // Catch: Throwable -> L12
    }

    public <T> T read(ByteProcessor<T> r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        T r1 = (T) ByteStreams.readBytes((InputStream) r0.register(openStream()), r2);
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

    public HashCode hash(HashFunction r2) throws IOException {
        Hasher r3 = r2.newHasher();
        copyTo(Funnels.asOutputStream(r3));
        return r3.hash();
    }

    public boolean contentEquals(ByteSource r7) throws IOException {
        Preconditions.checkNotNull(r7);
        byte[] r0 = ByteStreams.createBuffer();
        byte[] r1 = ByteStreams.createBuffer();
        Closer r2 = Closer.create();
        InputStream r6 = (InputStream) r2.register(openStream());     // Catch: Throwable -> L15
        InputStream r8 = (InputStream) r2.register(r7.openStream());     // Catch: Throwable -> L15
    L4:
        int r3 = ByteStreams.read(r6, r0, 0, r0.length);     // Catch: Throwable -> L15
        if (r3 != ByteStreams.read(r8, r1, 0, r1.length)) goto L13;
        if (Arrays.equals(r0, r1) == false) goto L13;
        if (r3 == r0.length) goto L4;
        r2.close();
        return true;
    L13:
        r2.close();
        return false;
    L15:
        th = move-exception;
    L18:
        th = move-exception;
        r2.close();
        throw th;
    L17:
        throw r2.rethrow(th);     // Catch: Throwable -> L18
    }

    public static ByteSource concat(Iterable<? extends ByteSource> r1) {
        return new ConcatenatedByteSource(r1);
    }

    public static ByteSource concat(Iterator<? extends ByteSource> r0) {
        return concat(ImmutableList.copyOf(r0));
    }

    public static ByteSource concat(ByteSource... r0) {
        return concat(ImmutableList.copyOf(r0));
    }

    public static ByteSource wrap(byte[] r1) {
        return new ByteArrayByteSource(r1);
    }

    public static ByteSource empty() {
        return EmptyByteSource.INSTANCE;
    }
}
