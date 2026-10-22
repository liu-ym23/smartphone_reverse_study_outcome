package okio;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class Okio {
    public static final Sink appendingSink(File r0) throws FileNotFoundException {
        return Okio__JvmOkioKt.appendingSink(r0);
    }

    public static final FileSystem asResourceFileSystem(ClassLoader r0) {
        return Okio__JvmOkioKt.asResourceFileSystem(r0);
    }

    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    public static final BufferedSink buffer(Sink r0) {
        return Okio__OkioKt.buffer(r0);
    }

    public static final BufferedSource buffer(Source r0) {
        return Okio__OkioKt.buffer(r0);
    }

    public static final CipherSink cipherSink(Sink r0, Cipher r1) {
        return Okio__JvmOkioKt.cipherSink(r0, r1);
    }

    public static final CipherSource cipherSource(Source r0, Cipher r1) {
        return Okio__JvmOkioKt.cipherSource(r0, r1);
    }

    public static final HashingSink hashingSink(Sink r0, MessageDigest r1) {
        return Okio__JvmOkioKt.hashingSink(r0, r1);
    }

    public static final HashingSink hashingSink(Sink r0, Mac r1) {
        return Okio__JvmOkioKt.hashingSink(r0, r1);
    }

    public static final HashingSource hashingSource(Source r0, MessageDigest r1) {
        return Okio__JvmOkioKt.hashingSource(r0, r1);
    }

    public static final HashingSource hashingSource(Source r0, Mac r1) {
        return Okio__JvmOkioKt.hashingSource(r0, r1);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError r0) {
        return Okio__JvmOkioKt.isAndroidGetsocknameError(r0);
    }

    public static final FileSystem openZip(FileSystem r0, Path r1) throws IOException {
        return Okio__JvmOkioKt.openZip(r0, r1);
    }

    public static final Sink sink(File r0) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(r0);
    }

    public static final Sink sink(File r0, boolean r1) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(r0, r1);
    }

    public static final Sink sink(OutputStream r0) {
        return Okio__JvmOkioKt.sink(r0);
    }

    public static final Sink sink(Socket r0) throws IOException {
        return Okio__JvmOkioKt.sink(r0);
    }

    public static final Sink sink(java.nio.file.Path r0, OpenOption... r1) throws IOException {
        return Okio__JvmOkioKt.sink(r0, r1);
    }

    public static /* synthetic */ Sink sink$default(File r0, boolean r1, int r2, Object r3) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink$default(r0, r1, r2, r3);
    }

    public static final Source source(File r0) throws FileNotFoundException {
        return Okio__JvmOkioKt.source(r0);
    }

    public static final Source source(InputStream r0) {
        return Okio__JvmOkioKt.source(r0);
    }

    public static final Source source(Socket r0) throws IOException {
        return Okio__JvmOkioKt.source(r0);
    }

    public static final Source source(java.nio.file.Path r0, OpenOption... r1) throws IOException {
        return Okio__JvmOkioKt.source(r0, r1);
    }

    public static final <T extends Closeable, R> R use(T r0, Function1<? super T, ? extends R> r1) {
        return (R) Okio__OkioKt.use(r0, r1);
    }
}
