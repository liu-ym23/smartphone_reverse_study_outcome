package com.obric.securitycenter.api;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlobalManagerCreator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0005¢\u0006\u0002\u0010\nJ*\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00052\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\b0\u0006R&\u0010\u0003\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/securitycenter/api/GlobalManagerCreator;", "", "()V", "managerCreatorMap", "", "Ljava/lang/Class;", "Lkotlin/Function0;", "getManager", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "(Ljava/lang/Class;)Ljava/lang/Object;", "registerManager", "", "creator", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GlobalManagerCreator {
    public static final GlobalManagerCreator INSTANCE = null;
    private static final Map<Class<?>, Function0<Object>> managerCreatorMap = null;

    private GlobalManagerCreator() {
    }

    static {
        INSTANCE = new GlobalManagerCreator();
        managerCreatorMap = new LinkedHashMap();
    }

    public final <T> void registerManager(Class<T> r1, Function0<? extends T> r2) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        Intrinsics.checkNotNullParameter(r2, "creator");
        managerCreatorMap.put(r1, r2);
    }

    public final <T> T getManager(Class<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        Function0<Object> r0 = managerCreatorMap.get(r1);
        if (r0 != null) goto L8;
        return null;
    L8:
        return (T) r0.invoke();
    L10:
        return null;
    }
}
