package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface KProperty0<V> extends KProperty<V>, Function0<V> {

    @Metadata
    public interface Getter<V> extends KProperty.Getter<V>, Function0<V> {
    }

    Object get();

    Object getDelegate();

    /* JADX INFO: renamed from: getGetter */
    Getter mo43getGetter();
}
