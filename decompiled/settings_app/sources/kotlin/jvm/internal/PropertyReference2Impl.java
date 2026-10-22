package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: loaded from: classes5.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(KDeclarationContainer r2, String r3, String r4) {
        super(((ClassBasedDeclarationContainer) r2).getJClass(), r3, r4, !(r2 instanceof KClass) ? 1 : 0);
    }

    public PropertyReference2Impl(Class r1, String r2, String r3, int r4) {
        super(r1, r2, r3, r4);
    }

    @Override // kotlin.reflect.KProperty2
    public Object get(Object r3, Object r4) {
        return getGetter().call(new Object[]{r3, r4});
    }
}
