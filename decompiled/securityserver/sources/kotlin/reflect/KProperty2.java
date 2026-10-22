package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface KProperty2<D, E, V> extends KProperty<V>, Function2<D, E, V> {

    @Metadata
    public interface Getter<D, E, V> extends KProperty.Getter<V>, Function2<D, E, V> {
    }

    Getter getGetter();
}
