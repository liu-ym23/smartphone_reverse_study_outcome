package com.obric.capabilitykit.corecommon;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/corecommon/ReflectUtil;", "", "()V", "tryCast", ExifInterface.GPS_DIRECTION_TRUE, "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ReflectUtil {
    public static final ReflectUtil INSTANCE = null;

    static {
        INSTANCE = new ReflectUtil();
    }

    private ReflectUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> T tryCast(Object r2) {
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((r2 instanceof Object) == false) goto L5;
        return r2;
    L5:
        return null;
    }
}
