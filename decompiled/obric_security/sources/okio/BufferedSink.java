package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes5.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    Buffer buffer();

    BufferedSink emit() throws IOException;

    BufferedSink emitCompleteSegments() throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    OutputStream outputStream();

    BufferedSink write(ByteString r1) throws IOException;

    BufferedSink write(Source r1, long r2) throws IOException;

    BufferedSink write(byte[] r1) throws IOException;

    BufferedSink write(byte[] r1, int r2, int r3) throws IOException;

    long writeAll(Source r1) throws IOException;

    BufferedSink writeByte(int r1) throws IOException;

    BufferedSink writeDecimalLong(long r1) throws IOException;

    BufferedSink writeHexadecimalUnsignedLong(long r1) throws IOException;

    BufferedSink writeInt(int r1) throws IOException;

    BufferedSink writeIntLe(int r1) throws IOException;

    BufferedSink writeLong(long r1) throws IOException;

    BufferedSink writeLongLe(long r1) throws IOException;

    BufferedSink writeShort(int r1) throws IOException;

    BufferedSink writeShortLe(int r1) throws IOException;

    BufferedSink writeString(String r1, int r2, int r3, Charset r4) throws IOException;

    BufferedSink writeString(String r1, Charset r2) throws IOException;

    BufferedSink writeUtf8(String r1) throws IOException;

    BufferedSink writeUtf8(String r1, int r2, int r3) throws IOException;

    BufferedSink writeUtf8CodePoint(int r1) throws IOException;
}
