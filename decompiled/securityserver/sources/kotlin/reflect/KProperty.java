package kotlin.reflect;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface KProperty<V> extends KCallable<V> {

    @Metadata
    public interface Accessor<V> {
    }

    @Metadata
    public static final class DefaultImpls {
    }

    @Metadata
    public interface Getter<V> extends Accessor<V>, KFunction<V> {
    }

    boolean isConst();

    boolean isLateinit();
}
