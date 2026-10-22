package com.google.common.io;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Resources {

    private static final class UrlByteSource extends ByteSource {
        private final URL url;

        /* synthetic */ UrlByteSource(URL r1, AnonymousClass1 r2) {
            this(r1);
        }

        private UrlByteSource(URL r1) {
            this.url = (URL) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return this.url.openStream();
        }

        public String toString() {
            String r2 = String.valueOf(this.url);
            return new StringBuilder(String.valueOf(r2).length() + 24).append("Resources.asByteSource(").append(r2).append(")").toString();
        }
    }

    private Resources() {
    }

    public static ByteSource asByteSource(URL r2) {
        return new UrlByteSource(r2, null);
    }

    public static CharSource asCharSource(URL r0, Charset r1) {
        return asByteSource(r0).asCharSource(r1);
    }

    public static byte[] toByteArray(URL r0) throws IOException {
        return asByteSource(r0).read();
    }

    public static String toString(URL r0, Charset r1) throws IOException {
        return asCharSource(r0, r1).read();
    }

    @ParametricNullness
    public static <T> T readLines(URL r0, Charset r1, LineProcessor<T> r2) throws IOException {
        return (T) asCharSource(r0, r1).readLines(r2);
    }

    public static List<String> readLines(URL r1, Charset r2) throws IOException {
        return (List) readLines(r1, r2, new AnonymousClass1());
    }

    public static void copy(URL r0, OutputStream r1) throws IOException {
        asByteSource(r0).copyTo(r1);
    }

    public static URL getResource(String r3) {
        URL r0 = ((ClassLoader) MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(r3);
        if (r0 == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "resource %s not found.", r3);
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public static URL getResource(Class<?> r3, String r4) {
        URL r0 = r3.getResource(r4);
        if (r0 == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "resource %s relative to %s not found.", r4, r3.getName());
        return r0;
    L5:
        r1 = false;
        goto L6
    }
}
