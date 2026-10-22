package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipKt;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\n\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\r\u001a\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0015\u001a\u00020\u0016*\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0012\u0010\u0015\u001a\u00020\u0016*\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u0012\u0010\u001b\u001a\u00020\u001c*\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0012\u0010\u001b\u001a\u00020\u001c*\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u0012\u0010\u001d\u001a\u00020\f*\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f\u001a\u0016\u0010 \u001a\u00020\t*\u00020\n2\b\b\u0002\u0010!\u001a\u00020\u0004H\u0007\u001a\n\u0010 \u001a\u00020\t*\u00020\"\u001a\n\u0010 \u001a\u00020\t*\u00020#\u001a%\u0010 \u001a\u00020\t*\u00020$2\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&\"\u00020'H\u0007¢\u0006\u0002\u0010(\u001a\n\u0010)\u001a\u00020\u0014*\u00020\n\u001a\n\u0010)\u001a\u00020\u0014*\u00020*\u001a\n\u0010)\u001a\u00020\u0014*\u00020#\u001a%\u0010)\u001a\u00020\u0014*\u00020$2\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&\"\u00020'H\u0007¢\u0006\u0002\u0010+\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0003\u001a\u00020\u0004*\u00060\u0005j\u0002`\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0007¨\u0006,"}, d2 = {"logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "appendingSink", "Lokio/Sink;", "Ljava/io/File;", "asResourceFileSystem", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "cipherSink", "Lokio/CipherSink;", "cipher", "Ljavax/crypto/Cipher;", "cipherSource", "Lokio/CipherSource;", "Lokio/Source;", "hashingSink", "Lokio/HashingSink;", "digest", "Ljava/security/MessageDigest;", "mac", "Ljavax/crypto/Mac;", "hashingSource", "Lokio/HashingSource;", "openZip", "zipPath", "Lokio/Path;", "sink", "append", "Ljava/io/OutputStream;", "Ljava/net/Socket;", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "source", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "okio/Okio")
final /* synthetic */ class Okio__JvmOkioKt {
    private static final Logger logger = null;

    public static final /* synthetic */ Logger access$getLogger$p() {
        return logger;
    }

    public static final Sink sink(File r3) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return Okio.sink$default(r3, false, 1, null);
    }

    public static final Sink sink(OutputStream r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new OutputStreamSink(r2, new Timeout());
    }

    public static final Source source(InputStream r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new InputStreamSource(r2, new Timeout());
    }

    public static final Sink sink(Socket r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        SocketAsyncTimeout r0 = new SocketAsyncTimeout(r3);
        OutputStream r4 = r3.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(r4, "getOutputStream()");
        return r0.sink(new OutputStreamSink(r4, r0));
    }

    public static final Source source(Socket r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        SocketAsyncTimeout r0 = new SocketAsyncTimeout(r3);
        InputStream r4 = r3.getInputStream();
        Intrinsics.checkNotNullExpressionValue(r4, "getInputStream()");
        return r0.source(new InputStreamSource(r4, r0));
    }

    static {
        logger = Logger.getLogger("okio.Okio");
    }

    public static final Sink sink(File r1, boolean r2) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Okio.sink(new FileOutputStream(r1, r2));
    }

    public static /* synthetic */ Sink sink$default(File r0, boolean r1, int r2, Object r3) throws FileNotFoundException {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return Okio.sink(r0, r1);
    }

    public static final Sink appendingSink(File r2) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return Okio.sink(new FileOutputStream(r2, true));
    }

    public static final Source source(File r2) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new InputStreamSource(new FileInputStream(r2), Timeout.NONE);
    }

    public static final Sink sink(java.nio.file.Path r1, OpenOption... r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        OutputStream r3 = Files.newOutputStream(r1, (OpenOption[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.checkNotNullExpressionValue(r3, "newOutputStream(this, *options)");
        return Okio.sink(r3);
    }

    public static final Source source(java.nio.file.Path r1, OpenOption... r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "options");
        InputStream r3 = Files.newInputStream(r1, (OpenOption[]) Arrays.copyOf(r2, r2.length));
        Intrinsics.checkNotNullExpressionValue(r3, "newInputStream(this, *options)");
        return Okio.source(r3);
    }

    public static final CipherSink cipherSink(Sink r1, Cipher r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "cipher");
        return new CipherSink(Okio.buffer(r1), r2);
    }

    public static final CipherSource cipherSource(Source r1, Cipher r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "cipher");
        return new CipherSource(Okio.buffer(r1), r2);
    }

    public static final HashingSink hashingSink(Sink r1, Mac r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "mac");
        return new HashingSink(r1, r2);
    }

    public static final HashingSource hashingSource(Source r1, Mac r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "mac");
        return new HashingSource(r1, r2);
    }

    public static final HashingSink hashingSink(Sink r1, MessageDigest r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "digest");
        return new HashingSink(r1, r2);
    }

    public static final HashingSource hashingSource(Source r1, MessageDigest r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "digest");
        return new HashingSource(r1, r2);
    }

    public static final FileSystem openZip(FileSystem r2, Path r3) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "zipPath");
        return ZipKt.openZip$default(r3, r2, null, 4, null);
    }

    public static final FileSystem asResourceFileSystem(ClassLoader r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new ResourceFileSystem(r2, true);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.getCause() == null) goto L11;
        String r5 = r4.getMessage();
        if (r5 == null) goto L7;
        boolean r6 = StringsKt.contains$default(r5, "getsockname failed", false, 2, null);
    L8:
        if (r6 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r6 = false;
        goto L8
    L11:
        return false;
    }
}
