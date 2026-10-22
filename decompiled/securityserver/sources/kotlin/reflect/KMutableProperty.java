package kotlin.reflect;

import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface KMutableProperty<V> extends KProperty<V> {

    @Metadata
    public interface Setter<V> extends KProperty.Accessor<V>, KFunction<Unit> {
    }
}
