package defpackage;

import h.a.f3.v;
import h.a.h0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import kotlinx.coroutines.android.AndroidDispatcherFactory;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;

/* JADX INFO: compiled from: ServiceLoader */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a {
    public static Iterator a() {
        return Arrays.asList(new h0[]{new AndroidExceptionPreHandler()}).iterator();
    L5:
        th = move-exception;
        throw new ServiceConfigurationError(th.getMessage(), th);
    }

    public static Iterator b() {
        return Arrays.asList(new v[]{new AndroidDispatcherFactory()}).iterator();
    L5:
        th = move-exception;
        throw new ServiceConfigurationError(th.getMessage(), th);
    }
}
