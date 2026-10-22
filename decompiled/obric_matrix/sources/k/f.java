package k;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
public interface f extends x, WritableByteChannel {
    f D(String r1);

    f I(byte[] r1, int r2, int r3);

    f K(long r1);

    f U(byte[] r1);

    f W(h r1);

    e c();

    f c0(long r1);

    e d();

    OutputStream e0();

    @Override // k.x, java.io.Flushable
    void flush();

    f o();

    f p(int r1);

    f q(int r1);

    f r(long r1);

    f u(int r1);

    f w(int r1);

    f z();
}
