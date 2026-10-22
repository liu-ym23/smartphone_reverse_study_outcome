package com.drakeet.multitype;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: OneToManyBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0002J;\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002&\u0010\u0012\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00130\n\"\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0013H\u0017¢\u0006\u0002\u0010\u0014J;\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002&\u0010\t\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u000b0\n\"\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u000bH\u0017¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0019\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/drakeet/multitype/OneToManyBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/drakeet/multitype/OneToManyFlow;", "Lcom/drakeet/multitype/OneToManyEndpoint;", "adapter", "Lcom/drakeet/multitype/MultiTypeAdapter;", "clazz", "Ljava/lang/Class;", "(Lcom/drakeet/multitype/MultiTypeAdapter;Ljava/lang/Class;)V", "delegates", "", "Lcom/drakeet/multitype/ItemViewDelegate;", "[Lcom/drakeet/multitype/ItemViewDelegate;", "doRegister", "", "linker", "Lcom/drakeet/multitype/Linker;", "to", "binders", "Lcom/drakeet/multitype/ItemViewBinder;", "([Lcom/drakeet/multitype/ItemViewBinder;)Lcom/drakeet/multitype/OneToManyBuilder;", "([Lcom/drakeet/multitype/ItemViewDelegate;)Lcom/drakeet/multitype/OneToManyBuilder;", "withJavaClassLinker", "javaClassLinker", "Lcom/drakeet/multitype/JavaClassLinker;", "withLinker", "multitype"}, k = 1, mv = {1, 4, 2})
public final class OneToManyBuilder<T> implements OneToManyFlow<T>, OneToManyEndpoint<T> {
    private final MultiTypeAdapter adapter;
    private final Class<T> clazz;
    private ItemViewDelegate<T, ?>[] delegates;

    public OneToManyBuilder(MultiTypeAdapter r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        Intrinsics.checkNotNullParameter(r3, "clazz");
        this.adapter = r2;
        this.clazz = r3;
    }

    @Override // com.drakeet.multitype.OneToManyFlow
    public /* bridge */ /* synthetic */ OneToManyEndpoint to(ItemViewBinder[] r1) {
        return to(r1);
    }

    @Override // com.drakeet.multitype.OneToManyFlow
    public /* bridge */ /* synthetic */ OneToManyEndpoint to(ItemViewDelegate[] r1) {
        return to(r1);
    }

    @Override // com.drakeet.multitype.OneToManyEndpoint
    public void withKotlinClassLinker(KotlinClassLinker<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "classLinker");
        OneToManyEndpoint.DefaultImpls.withKotlinClassLinker(this, r2);
    }

    @Override // com.drakeet.multitype.OneToManyEndpoint
    public void withKotlinClassLinker(Function2<? super Integer, ? super T, ? extends KClass<? extends ItemViewDelegate<T, ?>>> r2) {
        Intrinsics.checkNotNullParameter(r2, "classLinker");
        OneToManyEndpoint.DefaultImpls.withKotlinClassLinker(this, r2);
    }

    @Override // com.drakeet.multitype.OneToManyEndpoint
    public void withLinker(Function2<? super Integer, ? super T, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "linker");
        OneToManyEndpoint.DefaultImpls.withLinker(this, r2);
    }

    @Override // com.drakeet.multitype.OneToManyFlow
    @SafeVarargs
    public OneToManyBuilder<T> to(ItemViewDelegate<T, ?>... r2) {
        Intrinsics.checkNotNullParameter(r2, "delegates");
        this.delegates = r2;
        return this;
    }

    @Override // com.drakeet.multitype.OneToManyFlow
    @SafeVarargs
    public OneToManyBuilder<T> to(ItemViewBinder<T, ?>... r2) {
        Intrinsics.checkNotNullParameter(r2, "binders");
        this.delegates = r2;
        return this;
    }

    @Override // com.drakeet.multitype.OneToManyEndpoint
    public void withLinker(Linker<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "linker");
        doRegister(r2);
    }

    @Override // com.drakeet.multitype.OneToManyEndpoint
    public void withJavaClassLinker(JavaClassLinker<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "javaClassLinker");
        ClassLinkerBridge.Companion r0 = ClassLinkerBridge.Companion;
        ItemViewDelegate<T, ?>[] r1 = this.delegates;
        Intrinsics.checkNotNull(r1);
        withLinker(r0.toLinker(r3, r1));
    }

    private final void doRegister(Linker<T> r8) {
        ItemViewDelegate<T, ?>[] r0 = this.delegates;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        ItemViewDelegate<T, ?> r3 = r0[r2];
        this.adapter.register$multitype(new Type(this.clazz, r3, r8));
        r2 = r2 + 1;
        goto L3
    }
}
