package com.android.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.VolleyLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class DiskBasedCache implements Cache {
    private static final int CACHE_MAGIC = 538247942;
    private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
    static final float HYSTERESIS_FACTOR = 0.9f;
    private final Map<String, CacheHeader> mEntries;
    private final int mMaxCacheSizeInBytes;
    private final FileSupplier mRootDirectorySupplier;
    private long mTotalSize;

    static class CacheHeader {
        final List<Header> allResponseHeaders;
        final String etag;
        final String key;
        final long lastModified;
        final long serverDate;
        long size;
        final long softTtl;
        final long ttl;

        private CacheHeader(String r1, String r2, long r3, long r5, long r7, long r9, List<Header> r11) {
            this.key = r1;
            if ("".equals(r2) == false) goto L5;
            r2 = null;
        L5:
            this.etag = r2;
            this.serverDate = r3;
            this.lastModified = r5;
            this.ttl = r7;
            this.softTtl = r9;
            this.allResponseHeaders = r11;
        }

        CacheHeader(String r13, Cache.Entry r14) {
            this(r13, r14.etag, r14.serverDate, r14.lastModified, r14.ttl, r14.softTtl, getAllResponseHeaders(r14));
        }

        private static List<Header> getAllResponseHeaders(Cache.Entry r1) {
            if (r1.allResponseHeaders == null) goto L7;
            return r1.allResponseHeaders;
        L7:
            return HttpHeaderParser.toAllHeaderList(r1.responseHeaders);
        }

        static CacheHeader readHeader(CountingInputStream r14) throws IOException {
            if (DiskBasedCache.readInt(r14) != DiskBasedCache.CACHE_MAGIC) goto L7;
            return new CacheHeader(DiskBasedCache.readString(r14), DiskBasedCache.readString(r14), DiskBasedCache.readLong(r14), DiskBasedCache.readLong(r14), DiskBasedCache.readLong(r14), DiskBasedCache.readLong(r14), DiskBasedCache.readHeaderList(r14));
        L7:
            throw new IOException();
        }

        Cache.Entry toCacheEntry(byte[] r4) {
            Cache.Entry r0 = new Cache.Entry();
            r0.data = r4;
            r0.etag = this.etag;
            r0.serverDate = this.serverDate;
            r0.lastModified = this.lastModified;
            r0.ttl = this.ttl;
            r0.softTtl = this.softTtl;
            r0.responseHeaders = HttpHeaderParser.toHeaderMap(this.allResponseHeaders);
            r0.allResponseHeaders = Collections.unmodifiableList(this.allResponseHeaders);
            return r0;
        }

        boolean writeHeader(OutputStream r5) {
            DiskBasedCache.writeInt(r5, DiskBasedCache.CACHE_MAGIC);     // Catch: IOException -> L8
            DiskBasedCache.writeString(r5, this.key);     // Catch: IOException -> L8
            String r0 = this.etag;     // Catch: IOException -> L8
            if (r0 != null) goto L6;
            r0 = "";
        L6:
            DiskBasedCache.writeString(r5, r0);     // Catch: IOException -> L8
            DiskBasedCache.writeLong(r5, this.serverDate);     // Catch: IOException -> L8
            DiskBasedCache.writeLong(r5, this.lastModified);     // Catch: IOException -> L8
            DiskBasedCache.writeLong(r5, this.ttl);     // Catch: IOException -> L8
            DiskBasedCache.writeLong(r5, this.softTtl);     // Catch: IOException -> L8
            DiskBasedCache.writeHeaderList(this.allResponseHeaders, r5);     // Catch: IOException -> L8
            r5.flush();     // Catch: IOException -> L8
            return true;
        L8:
            e = move-exception;
            VolleyLog.d("%s", new Object[]{e.toString()});
            return false;
        }
    }

    static class CountingInputStream extends FilterInputStream {
        private long bytesRead;
        private final long length;

        CountingInputStream(InputStream r1, long r2) {
            super(r1);
            this.length = r2;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int r0 = super.read();
            if (r0 == (-1)) goto L5;
            this.bytesRead++;
        L5:
            return r0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] r3, int r4, int r5) throws IOException {
            int r6 = super.read(r3, r4, r5);
            if (r6 == (-1)) goto L5;
            this.bytesRead += (long) r6;
        L5:
            return r6;
        }

        long bytesRead() {
            return this.bytesRead;
        }

        long bytesRemaining() {
            return this.length - this.bytesRead;
        }
    }

    public interface FileSupplier {
        File get();
    }

    public DiskBasedCache(final File r5, int r6) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0;
        this.mRootDirectorySupplier = new AnonymousClass1(this, r5);
        this.mMaxCacheSizeInBytes = r6;
    }

    public DiskBasedCache(FileSupplier r5, int r6) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0;
        this.mRootDirectorySupplier = r5;
        this.mMaxCacheSizeInBytes = r6;
    }

    public DiskBasedCache(File r2) {
        this(r2, DEFAULT_DISK_USAGE_BYTES);
    }

    public DiskBasedCache(FileSupplier r2) {
        this(r2, DEFAULT_DISK_USAGE_BYTES);
    }

    @Override // com.android.volley.Cache
    public synchronized void clear() {
        monitor-enter(this);
        File[] r0 = this.mRootDirectorySupplier.get().listFiles();     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        int r2 = r0.length;     // Catch: Throwable -> L11
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r0[r3].delete();     // Catch: Throwable -> L11
        r3 = r3 + 1;     // Catch: Throwable -> L11
    L8:
        this.mEntries.clear();     // Catch: Throwable -> L11
        this.mTotalSize = 0;     // Catch: Throwable -> L11
        VolleyLog.d("Cache cleared.", new Object[0]);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Cache
    public synchronized Cache.Entry get(String r11) {
        monitor-enter(this);
        CacheHeader r0 = this.mEntries.get(r11);     // Catch: Throwable -> L28
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        File r2 = getFileForKey(r11);     // Catch: Throwable -> L28
        CountingInputStream r6 = new CountingInputStream(new BufferedInputStream(createInputStream(r2)), r2.length());     // Catch: IOException -> L24 Throwable -> L28
        CacheHeader r7 = CacheHeader.readHeader(r6);     // Catch: Throwable -> L21
        if (TextUtils.equals(r11, r7.key) == true) goto L17;
        VolleyLog.d("%s: key=%s, found=%s", new Object[]{r2.getAbsolutePath(), r11, r7.key});     // Catch: Throwable -> L21
        removeEntry(r11);     // Catch: Throwable -> L21
        r6.close();     // Catch: IOException -> L24 Throwable -> L28
        monitor-exit(this);
        return null;
    L17:
        Cache.Entry r1 = r0.toCacheEntry(streamToBytes(r6, r6.bytesRemaining()));     // Catch: Throwable -> L21
        r6.close();     // Catch: IOException -> L24 Throwable -> L28
        monitor-exit(this);
        return r1;
    L21:
        th = move-exception;
        r6.close();     // Catch: IOException -> L24 Throwable -> L28
        throw th;     // Catch: IOException -> L24 Throwable -> L28
    L24:
        e = move-exception;
        VolleyLog.d("%s: %s", new Object[]{r2.getAbsolutePath(), e.toString()});     // Catch: Throwable -> L28
        remove(r11);     // Catch: Throwable -> L28
        return null;
    L28:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Cache
    public synchronized void initialize() {
        monitor-enter(this);
        File r0 = this.mRootDirectorySupplier.get();     // Catch: Throwable -> L27
        int r2 = 0;
        if (r0.exists() == false) goto L6;
        File[] r1 = r0.listFiles();     // Catch: Throwable -> L27
        if (r1 != null) goto L14;
        monitor-exit(this);
        return;
    L14:
        int r3 = r1.length;     // Catch: Throwable -> L27
    L15:
        if (r2 >= r3) goto L25;
        File r4 = r1[r2];     // Catch: Throwable -> L27
        long r5 = r4.length();     // Catch: IOException -> L23 Throwable -> L27
        CountingInputStream r6 = new CountingInputStream(new BufferedInputStream(createInputStream(r4)), r5);     // Catch: IOException -> L23 Throwable -> L27
        CacheHeader r7 = CacheHeader.readHeader(r6);     // Catch: Throwable -> L20
        r7.size = r5;     // Catch: Throwable -> L20
        putEntry(r7.key, r7);     // Catch: Throwable -> L20
        r6.close();     // Catch: IOException -> L23 Throwable -> L27
    L24:
        r2 = r2 + 1;
    L20:
        th = move-exception;
        r6.close();     // Catch: IOException -> L23 Throwable -> L27
        throw th;     // Catch: IOException -> L23 Throwable -> L27
    L23:
        r4.delete();     // Catch: Throwable -> L27
        goto L24
    L25:
        monitor-exit(this);
        return;
    L6:
        if (r0.mkdirs() == true) goto L8;
        VolleyLog.e("Unable to create cache dir %s", new Object[]{r0.getAbsolutePath()});     // Catch: Throwable -> L27
    L8:
        monitor-exit(this);
        return;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Cache
    public synchronized void invalidate(String r4, boolean r5) {
        monitor-enter(this);
        Cache.Entry r0 = get(r4);     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        r0.softTtl = 0;     // Catch: Throwable -> L11
        if (r5 == false) goto L8;
        r0.ttl = 0;     // Catch: Throwable -> L11
    L8:
        put(r4, r0);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Cache
    public synchronized void put(String r8, Cache.Entry r9) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if ((this.mTotalSize + ((long) r9.data.length)) > this.mMaxCacheSizeInBytes) goto L7;
    L10:
        File r0 = getFileForKey(r8);     // Catch: Throwable -> L23
        BufferedOutputStream r3 = new BufferedOutputStream(createOutputStream(r0));     // Catch: IOException -> L17 Throwable -> L23
        CacheHeader r4 = new CacheHeader(r8, r9);     // Catch: IOException -> L17 Throwable -> L23
        if (r4.writeHeader(r3) == false) goto L15;
        r3.write(r9.data);     // Catch: IOException -> L17 Throwable -> L23
        r3.close();     // Catch: IOException -> L17 Throwable -> L23
        r4.size = r0.length();     // Catch: IOException -> L17 Throwable -> L23
        putEntry(r8, r4);     // Catch: IOException -> L17 Throwable -> L23
        pruneIfNeeded();     // Catch: IOException -> L17 Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L15:
        r3.close();     // Catch: IOException -> L17 Throwable -> L23
        VolleyLog.d("Failed to write header for %s", new Object[]{r0.getAbsolutePath()});     // Catch: IOException -> L17 Throwable -> L23
        throw new IOException();     // Catch: IOException -> L17 Throwable -> L23
    L18:
        if (r0.delete() == true) goto L20;
        VolleyLog.d("Could not clean up file %s", new Object[]{r0.getAbsolutePath()});     // Catch: Throwable -> L23
    L20:
        initializeIfRootDirectoryDeleted();     // Catch: Throwable -> L23
        goto L21
    L7:
        if (r9.data.length <= (this.mMaxCacheSizeInBytes * HYSTERESIS_FACTOR)) goto L10;
        monitor-exit(this);
    }

    @Override // com.android.volley.Cache
    public synchronized void remove(String r4) {
        monitor-enter(this);
        boolean r0 = getFileForKey(r4).delete();     // Catch: Throwable -> L8
        removeEntry(r4);     // Catch: Throwable -> L8
        if (r0 == true) goto L6;
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[]{r4, getFilenameForKey(r4)});     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private String getFilenameForKey(String r3) {
        int r2 = r3.length() / 2;
        return String.valueOf(r3.substring(0, r2).hashCode()) + String.valueOf(r3.substring(r2).hashCode());
    }

    public File getFileForKey(String r3) {
        return new File(this.mRootDirectorySupplier.get(), getFilenameForKey(r3));
    }

    private void initializeIfRootDirectoryDeleted() {
        if (this.mRootDirectorySupplier.get().exists() == true) goto L6;
        VolleyLog.d("Re-initializing cache after external clearing.", new Object[0]);
        this.mEntries.clear();
        this.mTotalSize = 0;
        initialize();
        return;
    }

    private void pruneIfNeeded() {
        if (this.mTotalSize >= this.mMaxCacheSizeInBytes) goto L6;
        return;
    L6:
        if (VolleyLog.DEBUG == false) goto L8;
        VolleyLog.v("Pruning old cache entries.", new Object[0]);
    L8:
        long r2 = this.mTotalSize;
        long r4 = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, CacheHeader>> r0 = this.mEntries.entrySet().iterator();
        int r6 = 0;
    L10:
        if (r0.hasNext() == false) goto L18;
        CacheHeader r7 = r0.next().getValue();
        if (getFileForKey(r7.key).delete() == false) goto L14;
        this.mTotalSize -= r7.size;
    L15:
        r0.remove();
        r6 = r6 + 1;
        if (this.mTotalSize >= (this.mMaxCacheSizeInBytes * HYSTERESIS_FACTOR)) goto L10;
    L14:
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[]{r7.key, getFilenameForKey(r7.key)});
    L18:
        if (VolleyLog.DEBUG == false) goto L24;
        VolleyLog.v("pruned %d files, %d bytes, %d ms", new Object[]{Integer.valueOf(r6), Long.valueOf(this.mTotalSize - r2), Long.valueOf(SystemClock.elapsedRealtime() - r4)});
        return;
    }

    private void putEntry(String r8, CacheHeader r9) {
        if (this.mEntries.containsKey(r8) == true) goto L5;
        this.mTotalSize += r9.size;
    L6:
        this.mEntries.put(r8, r9);
        return;
    L5:
        this.mTotalSize += r9.size - this.mEntries.get(r8).size;
        goto L6
    }

    private void removeEntry(String r5) {
        CacheHeader r6 = this.mEntries.remove(r5);
        if (r6 == null) goto L6;
        this.mTotalSize -= r6.size;
        return;
    }

    static byte[] streamToBytes(CountingInputStream r5, long r6) throws IOException {
        long r0 = r5.bytesRemaining();
        if (r6 < 0) goto L11;
        if (r6 > r0) goto L11;
        int r2 = (int) r6;
        if (r2 != r6) goto L11;
        byte[] r7 = new byte[r2];
        new DataInputStream(r5).readFully(r7);
        return r7;
    L11:
        throw new IOException("streamToBytes length=" + r6 + ", maxLength=" + r0);
    }

    InputStream createInputStream(File r1) throws FileNotFoundException {
        return new FileInputStream(r1);
    }

    OutputStream createOutputStream(File r1) throws FileNotFoundException {
        return new FileOutputStream(r1);
    }

    private static int read(InputStream r1) throws IOException {
        int r2 = r1.read();
        if (r2 == (-1)) goto L6;
        return r2;
    L6:
        throw new EOFException();
    }

    static void writeInt(OutputStream r1, int r2) throws IOException {
        r1.write((r2 >> 0) & 255);
        r1.write((r2 >> 8) & 255);
        r1.write((r2 >> 16) & 255);
        r1.write((r2 >> 24) & 255);
    }

    static int readInt(InputStream r2) throws IOException {
        int r0 = (((read(r2) << 0) | 0) | (read(r2) << 8)) | (read(r2) << 16);
        return (read(r2) << 24) | r0;
    }

    static void writeLong(OutputStream r2, long r3) throws IOException {
        r2.write((byte) (r3 >>> 0));
        r2.write((byte) (r3 >>> 8));
        r2.write((byte) (r3 >>> 16));
        r2.write((byte) (r3 >>> 24));
        r2.write((byte) (r3 >>> 32));
        r2.write((byte) (r3 >>> 40));
        r2.write((byte) (r3 >>> 48));
        r2.write((byte) (r3 >>> 56));
    }

    static long readLong(InputStream r7) throws IOException {
        return (((((((((((long) read(r7)) & 255) << 0) | 0) | ((((long) read(r7)) & 255) << 8)) | ((((long) read(r7)) & 255) << 16)) | ((((long) read(r7)) & 255) << 24)) | ((((long) read(r7)) & 255) << 32)) | ((((long) read(r7)) & 255) << 40)) | ((((long) read(r7)) & 255) << 48)) | ((255 & ((long) read(r7))) << 56);
    }

    static void writeString(OutputStream r2, String r3) throws IOException {
        byte[] r4 = r3.getBytes("UTF-8");
        writeLong(r2, r4.length);
        r2.write(r4, 0, r4.length);
    }

    static String readString(CountingInputStream r2) throws IOException {
        return new String(streamToBytes(r2, readLong(r2)), "UTF-8");
    }

    static void writeHeaderList(List<Header> r2, OutputStream r3) throws IOException {
        if (r2 == null) goto L7;
        writeInt(r3, r2.size());
        Iterator<Header> r4 = r2.iterator();
    L5:
        if (r4.hasNext() == false) goto L10;
        Header r0 = r4.next();
        writeString(r3, r0.getName());
        writeString(r3, r0.getValue());
        goto L5
    L10:
        return;
    L7:
        writeInt(r3, 0);
    }

    static List<Header> readHeaderList(CountingInputStream r6) throws IOException {
        int r0 = readInt(r6);
        if (r0 < 0) goto L12;
        if (r0 != 0) goto L6;
        List<Header> r1 = Collections.emptyList();
    L7:
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L10;
        r1.add(new Header(readString(r6).intern(), readString(r6).intern()));
        r2 = r2 + 1;
        goto L8
    L10:
        return r1;
    L6:
        r1 = new ArrayList();
        goto L7
    L12:
        throw new IOException("readHeaderList size=" + r0);
    }
}
