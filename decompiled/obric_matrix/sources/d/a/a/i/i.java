package d.a.a.i;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class i implements d.a.a.i.q.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f12434a = null;

    static {
        f12434a = new i();
    }

    i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.a.a.i.q.f
    public <T> T a(b r1, Type r2, Object r3) {
        if ((r2 instanceof GenericArrayType) == false) goto L14;
        Type r0 = ((GenericArrayType) r2).getGenericComponentType();
        if ((r0 instanceof TypeVariable) == false) goto L7;
        r0 = ((TypeVariable) r0).getBounds()[0];
    L7:
        ArrayList r4 = new ArrayList();
        r1.M(r0, r4);
        if ((r0 instanceof Class) == false) goto L12;
        T r5 = (T) ((Object[]) Array.newInstance((Class) r0, r4.size()));
        r4.toArray(r5);
        return r5;
    L12:
        return (T) r4.toArray();
    L14:
        return (T) r1.L(r3);
    }
}
