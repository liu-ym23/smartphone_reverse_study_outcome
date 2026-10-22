package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface BufferedSource extends Source, ReadableByteChannel {
    @Deprecated
    @NotNull
    Buffer buffer();

    boolean exhausted();

    @NotNull
    Buffer getBuffer();

    long indexOf(byte r1);

    long indexOf(byte r1, long r2);

    long indexOf(byte r1, long r2, long r4);

    long indexOf(@NotNull ByteString r1);

    long indexOf(@NotNull ByteString r1, long r2);

    long indexOfElement(@NotNull ByteString r1);

    long indexOfElement(@NotNull ByteString r1, long r2);

    @NotNull
    InputStream inputStream();

    @NotNull
    BufferedSource peek();

    boolean rangeEquals(long r1, @NotNull ByteString r3);

    boolean rangeEquals(long r1, @NotNull ByteString r3, int r4, int r5);

    int read(@NotNull byte[] r1);

    int read(@NotNull byte[] r1, int r2, int r3);

    long readAll(@NotNull Sink r1);

    byte readByte();

    @NotNull
    byte[] readByteArray();

    @NotNull
    byte[] readByteArray(long r1);

    @NotNull
    ByteString readByteString();

    @NotNull
    ByteString readByteString(long r1);

    long readDecimalLong();

    void readFully(@NotNull Buffer r1, long r2);

    void readFully(@NotNull byte[] r1);

    long readHexadecimalUnsignedLong();

    int readInt();

    int readIntLe();

    long readLong();

    long readLongLe();

    short readShort();

    short readShortLe();

    @NotNull
    String readString(long r1, @NotNull Charset r3);

    @NotNull
    String readString(@NotNull Charset r1);

    @NotNull
    String readUtf8();

    @NotNull
    String readUtf8(long r1);

    int readUtf8CodePoint();

    @Nullable
    String readUtf8Line();

    @NotNull
    String readUtf8LineStrict();

    @NotNull
    String readUtf8LineStrict(long r1);

    boolean request(long r1);

    void require(long r1);

    int select(@NotNull Options r1);

    void skip(long r1);
}
