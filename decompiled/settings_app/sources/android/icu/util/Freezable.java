package android.icu.util;

/* JADX INFO: loaded from: classes.dex */
public interface Freezable<T> extends Cloneable {
    T cloneAsThawed();

    T freeze();

    boolean isFrozen();
}
