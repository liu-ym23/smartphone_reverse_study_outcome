package com.ttnet.org.chromium.net;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes5.dex */
public final class UploadDataProviders {

    private static final class ByteBufferUploadProvider extends UploadDataProvider {
        private final ByteBuffer mUploadBuffer;

        /* synthetic */ ByteBufferUploadProvider(ByteBuffer r1, AnonymousClass1 r2) {
            this(r1);
        }

        private ByteBufferUploadProvider(ByteBuffer r1) {
            this.mUploadBuffer = r1;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return this.mUploadBuffer.limit();
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r5, ByteBuffer r6) {
            if (r6.hasRemaining() == false) goto L11;
            if (r6.remaining() < this.mUploadBuffer.remaining()) goto L7;
            r6.put(this.mUploadBuffer);
        L8:
            r5.onReadSucceeded(false);
            return;
        L7:
            int r0 = this.mUploadBuffer.limit();
            ByteBuffer r1 = this.mUploadBuffer;
            r1.limit(r1.position() + r6.remaining());
            r6.put(this.mUploadBuffer);
            this.mUploadBuffer.limit(r0);
            goto L8
        L11:
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r2) {
            this.mUploadBuffer.position(0);
            r2.onRewindSucceeded();
        }
    }

    private interface FileChannelProvider {
        FileChannel getChannel() throws IOException;
    }

    private static final class FileUploadProvider extends UploadDataProvider {
        private volatile FileChannel mChannel;
        private final Object mLock;
        private final FileChannelProvider mProvider;

        /* synthetic */ FileUploadProvider(FileChannelProvider r1, AnonymousClass1 r2) {
            this(r1);
        }

        private FileUploadProvider(FileChannelProvider r2) {
            this.mLock = new Object();
            this.mProvider = r2;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() throws IOException {
            return getChannel().size();
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink r5, ByteBuffer r6) throws IOException {
            if (r6.hasRemaining() == false) goto L13;
            FileChannel r4 = getChannel();
            int r1 = 0;
        L5:
            if (r1 != 0) goto L10;
            int r2 = r4.read(r6);
            if (r2 == (-1)) goto L10;
            r1 = r1 + r2;
        L10:
            r5.onReadSucceeded(false);
            return;
        L13:
            throw new IllegalStateException("Cronet passed a buffer with no bytes remaining");
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink r3) throws IOException {
            getChannel().position(0);
            r3.onRewindSucceeded();
        }

        private FileChannel getChannel() throws IOException {
            if (this.mChannel != null) goto L15;
            Object r0 = this.mLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (this.mChannel != null) goto L9;
            this.mChannel = this.mProvider.getChannel();     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
        L15:
            return this.mChannel;
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            FileChannel r0 = this.mChannel;
            if (r0 == null) goto L6;
            r0.close();
            return;
        }
    }

    public static UploadDataProvider create(final File r2) {
        return new FileUploadProvider(new AnonymousClass1(r2), null);
    }

    public static UploadDataProvider create(final ParcelFileDescriptor r2) {
        return new FileUploadProvider(new AnonymousClass2(r2), null);
    }

    public static UploadDataProvider create(ByteBuffer r2) {
        return new ByteBufferUploadProvider(r2.slice(), null);
    }

    public static UploadDataProvider create(byte[] r1, int r2, int r3) {
        return new ByteBufferUploadProvider(ByteBuffer.wrap(r1, r2, r3).slice(), null);
    }

    public static UploadDataProvider create(byte[] r2) {
        return create(r2, 0, r2.length);
    }

    private UploadDataProviders() {
    }
}
