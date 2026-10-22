package tmsdkobf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class dg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f155a;
    public static Map b;

    static {
        f155a = new HashMap();
        b = new HashMap();
        HashSet r0 = new HashSet();
        r0.add("18C867F0717AA67B2AB7347505BA07ED");
        Map r1 = f155a;
        int[] r2 = xk.f626J;
        r1.put(xk.a(r2), r0);
        HashSet r3 = new HashSet();
        r3.add("31223B0BDF1DEF1FE8252971ADA3B577");
        r3.add("CCD4AD38DC6669F875BC37E3F8840648");
        r3.add("AA3978F41FD96FF9914A669E186474C7");
        r3.add("775E696D09856872FDD8AB4F3F06B1E0");
        r3.add("A6B745BF24A2C277527716F6F36EB68D");
        r3.add("A01EECAB85E9E3BA2B0F6A158C855C29");
        Map r4 = f155a;
        int[] r5 = xk.K;
        r4.put(xk.a(r5), r3);
        b.put(xk.a(r2), 105118);
        b.put(xk.a(r5), 105178);
    }
}
