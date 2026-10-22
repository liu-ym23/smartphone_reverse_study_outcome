package z8;

import com.bytedance.crash.j;
import com.bytedance.crash.n;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f23418a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f23419b = null;

    static {
        f23418a = new ConcurrentLinkedQueue();
        new ConcurrentHashMap();
        f23419b = new Object();
    }

    public static String a(Object r5) {
        if (r5 == f23419b) goto L5;
        Iterator r10 = f23418a.iterator();
    L8:
        if (r10.hasNext() == false) goto L15;
        j r11 = (j) r10.next();
        if (r11 == null) goto L8;
        if (r11.f4055a != r5) goto L8;
        return r11.a();
    L15:
        return null;
    L5:
        return n.d().i();
    }
}
