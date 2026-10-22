package k;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public interface g extends z, ReadableByteChannel {
    String B(long r1);

    boolean G(long r1, h r3);

    String H(Charset r1);

    String P();

    int R();

    byte[] T(long r1);

    long a0();

    void b0(long r1);

    e c();

    e d();

    long f0();

    InputStream k();

    String m(long r1);

    h n(long r1);

    byte readByte();

    void readFully(byte[] r1);

    int readInt();

    long readLong();

    short readShort();

    void skip(long r1);

    byte[] t();

    boolean v();

    void y(e r1, long r2);
}
