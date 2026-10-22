package tmsdkobf;

import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public interface u6 {
    WeakReference a(int r1, JceStruct r2, JceStruct r3, int r4, w6 r5);

    WeakReference a(int r1, JceStruct r2, JceStruct r3, int r4, w6 r5, long r6);

    WeakReference a(int r1, byte[] r2, int r3, v6 r4, long r5);

    a7 a(int r1, int r2);

    void a();

    void a(int r1, long r2, int r4, JceStruct r5);

    void a(int r1, JceStruct r2, int r3, a7 r4);

    void b();

    String c();

    void closeConnection();

    void d();
}
