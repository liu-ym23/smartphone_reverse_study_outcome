package z0;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f23358a = null;

    static {
        f23358a = LazyKt.lazy(new s1.b(6));
        LazyKt.lazy(new s1.b(7));
    }

    public static final Gson a() {
        return (Gson) f23358a.getValue();
    }
}
