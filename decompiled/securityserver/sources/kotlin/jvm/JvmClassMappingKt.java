package kotlin.jvm;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class JvmClassMappingKt {
    public static final Class a(KClass r2) {
        Intrinsics.f(r2, "<this>");
        Class r3 = ((ClassBasedDeclarationContainer) r2).a();
        if (r3.isPrimitive() == true) goto L5;
        return r3;
    L5:
        String r0 = r3.getName();
        switch(r0.hashCode()) {
            case -1325958191: goto L41;
            case 104431: goto L37;
            case 3039496: goto L33;
            case 3052374: goto L29;
            case 3327612: goto L25;
            case 3625364: goto L21;
            case 64711720: goto L17;
            case 97526364: goto L13;
            case 109413500: goto L9;
            default: goto L53;
        };
    L53:
        return r3;
    L9:
        if (r0.equals("short") == false) goto L54;
        return Short.class;
    L54:
        return r3;
    L13:
        if (r0.equals("float") == false) goto L55;
        return Float.class;
    L55:
        return r3;
    L17:
        if (r0.equals("boolean") == false) goto L56;
        return Boolean.class;
    L56:
        return r3;
    L21:
        if (r0.equals("void") == false) goto L57;
        return Void.class;
    L57:
        return r3;
    L25:
        if (r0.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L58;
        return Long.class;
    L58:
        return r3;
    L29:
        if (r0.equals("char") == false) goto L59;
        return Character.class;
    L59:
        return r3;
    L33:
        if (r0.equals("byte") == false) goto L60;
        return Byte.class;
    L60:
        return r3;
    L37:
        if (r0.equals("int") == false) goto L61;
        return Integer.class;
    L61:
        return r3;
    L41:
        if (r0.equals("double") == false) goto L62;
        return Double.class;
    L62:
        return r3;
    }
}
