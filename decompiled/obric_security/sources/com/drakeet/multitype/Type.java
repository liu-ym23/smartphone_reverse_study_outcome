package com.drakeet.multitype;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Type.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004HÆ\u0003J\u0013\u0010\u0011\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0006HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\bHÆ\u0003JE\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00042\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0019\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0005\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/drakeet/multitype/Type;", ExifInterface.GPS_DIRECTION_TRUE, "", "clazz", "Ljava/lang/Class;", "delegate", "Lcom/drakeet/multitype/ItemViewDelegate;", "linker", "Lcom/drakeet/multitype/Linker;", "(Ljava/lang/Class;Lcom/drakeet/multitype/ItemViewDelegate;Lcom/drakeet/multitype/Linker;)V", "getClazz", "()Ljava/lang/Class;", "getDelegate", "()Lcom/drakeet/multitype/ItemViewDelegate;", "getLinker", "()Lcom/drakeet/multitype/Linker;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "multitype"}, k = 1, mv = {1, 4, 2})
public final class Type<T> {
    private final Class<? extends T> clazz;
    private final ItemViewDelegate<T, ?> delegate;
    private final Linker<T> linker;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Type copy$default(Type r0, Class r1, ItemViewDelegate r2, Linker r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.clazz;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.delegate;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.linker;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Class<? extends T> component1() {
        return this.clazz;
    }

    public final ItemViewDelegate<T, ?> component2() {
        return this.delegate;
    }

    public final Linker<T> component3() {
        return this.linker;
    }

    public final Type<T> copy(Class<? extends T> r1, ItemViewDelegate<T, ?> r2, Linker<T> r3) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        Intrinsics.checkNotNullParameter(r2, "delegate");
        Intrinsics.checkNotNullParameter(r3, "linker");
        return new Type(r1, r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof Type) == false) goto L12;
        Type r4 = (Type) r3;
        if (Intrinsics.areEqual(this.clazz, r4.clazz) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.delegate, r4.delegate) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.linker, r4.linker) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Class<? extends T> r0 = this.clazz;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ItemViewDelegate<T, ?> r4 = this.delegate;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Linker<T> r7 = this.linker;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "Type(clazz=" + this.clazz + ", delegate=" + this.delegate + ", linker=" + this.linker + ")";
    }

    public Type(Class<? extends T> r2, ItemViewDelegate<T, ?> r3, Linker<T> r4) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "delegate");
        Intrinsics.checkNotNullParameter(r4, "linker");
        this.clazz = r2;
        this.delegate = r3;
        this.linker = r4;
    }

    public final Class<? extends T> getClazz() {
        return this.clazz;
    }

    public final ItemViewDelegate<T, ?> getDelegate() {
        return this.delegate;
    }

    public final Linker<T> getLinker() {
        return this.linker;
    }
}
