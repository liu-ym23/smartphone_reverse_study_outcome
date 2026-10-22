package okio;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface BufferedSink extends Sink, WritableByteChannel {
    @Deprecated
    @NotNull
    Buffer buffer();

    @NotNull
    BufferedSink emit();

    @NotNull
    BufferedSink emitCompleteSegments();

    @Override // okio.Sink, java.io.Flushable
    void flush();

    @NotNull
    Buffer getBuffer();

    @NotNull
    OutputStream outputStream();

    @NotNull
    BufferedSink write(@NotNull ByteString r1);

    @NotNull
    BufferedSink write(@NotNull ByteString r1, int r2, int r3);

    @NotNull
    BufferedSink write(@NotNull Source r1, long r2);

    @NotNull
    BufferedSink write(@NotNull byte[] r1);

    @NotNull
    BufferedSink write(@NotNull byte[] r1, int r2, int r3);

    long writeAll(@NotNull Source r1);

    @NotNull
    BufferedSink writeByte(int r1);

    @NotNull
    BufferedSink writeDecimalLong(long r1);

    @NotNull
    BufferedSink writeHexadecimalUnsignedLong(long r1);

    @NotNull
    BufferedSink writeInt(int r1);

    @NotNull
    BufferedSink writeIntLe(int r1);

    @NotNull
    BufferedSink writeLong(long r1);

    @NotNull
    BufferedSink writeLongLe(long r1);

    @NotNull
    BufferedSink writeShort(int r1);

    @NotNull
    BufferedSink writeShortLe(int r1);

    @NotNull
    BufferedSink writeString(@NotNull String r1, int r2, int r3, @NotNull Charset r4);

    @NotNull
    BufferedSink writeString(@NotNull String r1, @NotNull Charset r2);

    @NotNull
    BufferedSink writeUtf8(@NotNull String r1);

    @NotNull
    BufferedSink writeUtf8(@NotNull String r1, int r2, int r3);

    @NotNull
    BufferedSink writeUtf8CodePoint(int r1);
}
