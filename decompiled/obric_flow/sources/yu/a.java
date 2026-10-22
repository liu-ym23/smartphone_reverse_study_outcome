package yu;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f23352a = null;

    static {
        f23352a = new ConcurrentHashMap();
    }

    public static final String a(KClass r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ConcurrentHashMap r10 = f23352a;
        String r11 = (String) r10.get(r5);
        if (r11 != null) goto L6;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r5, "kClass");
        String r12 = JvmClassMappingKt.getJavaClass(r5).getName();
        r10.put(r5, r12);
        return r12;
    L6:
        return r11;
    }
}
