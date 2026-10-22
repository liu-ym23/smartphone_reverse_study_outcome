package kotlin.reflect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface KMutableProperty0<V> extends KProperty0<V>, KMutableProperty<V> {

    @Metadata
    public interface Setter<V> extends KMutableProperty.Setter<V>, Function1<V, Unit> {
    }

    /* JADX INFO: renamed from: getSetter */
    Setter mo44getSetter();
}
