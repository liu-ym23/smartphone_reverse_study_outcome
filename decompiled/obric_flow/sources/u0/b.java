package u0;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f22207a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f22208b = null;

    static {
        f22207a = Collections.synchronizedMap(new WeakHashMap());
        f22208b = Collections.synchronizedMap(new WeakHashMap());
    }
}
