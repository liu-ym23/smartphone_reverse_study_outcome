package com.drakeet.multitype;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: OneToManyEndpoint.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002JR\u0010\u0003\u001a\u00020\u00042H\u0010\u0005\u001aD\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0016\u0012\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\r0\f0\u0006H\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH&JR\u0010\u0010\u001a\u00020\u00042H\u0010\u0005\u001aD\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0016\u0012\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\r0\u00110\u0006H\u0016J\u0016\u0010\u0010\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J@\u0010\u0013\u001a\u00020\u000426\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/drakeet/multitype/OneToManyEndpoint;", ExifInterface.GPS_DIRECTION_TRUE, "", "withJavaClassLinker", "", "classLinker", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "Ljava/lang/Class;", "Lcom/drakeet/multitype/ItemViewDelegate;", "javaClassLinker", "Lcom/drakeet/multitype/JavaClassLinker;", "withKotlinClassLinker", "Lkotlin/reflect/KClass;", "Lcom/drakeet/multitype/KotlinClassLinker;", "withLinker", "linker", "Lcom/drakeet/multitype/Linker;", "multitype"}, k = 1, mv = {1, 4, 2})
public interface OneToManyEndpoint<T> {

    /* JADX INFO: compiled from: OneToManyEndpoint.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static <T> void withLinker(OneToManyEndpoint<T> r1, final Function2<? super Integer, ? super T, Integer> r2) {
            Intrinsics.checkNotNullParameter(r2, "linker");
            r1.withLinker(new C01771(r2));
        }

        private static <T> void withJavaClassLinker(OneToManyEndpoint<T> r1, final Function2<? super Integer, ? super T, ? extends Class<? extends ItemViewDelegate<T, ?>>> r2) {
            r1.withJavaClassLinker(new AnonymousClass1(r2));
        }

        public static <T> void withKotlinClassLinker(OneToManyEndpoint<T> r1, final KotlinClassLinker<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "classLinker");
            withJavaClassLinker(r1, new C01761(r2));
        }

        public static <T> void withKotlinClassLinker(OneToManyEndpoint<T> r1, final Function2<? super Integer, ? super T, ? extends KClass<? extends ItemViewDelegate<T, ?>>> r2) {
            Intrinsics.checkNotNullParameter(r2, "classLinker");
            withJavaClassLinker(r1, new AnonymousClass2(r2));
        }
    }

    void withJavaClassLinker(JavaClassLinker<T> r1);

    void withKotlinClassLinker(KotlinClassLinker<T> r1);

    void withKotlinClassLinker(Function2<? super Integer, ? super T, ? extends KClass<? extends ItemViewDelegate<T, ?>>> r1);

    void withLinker(Linker<T> r1);

    void withLinker(Function2<? super Integer, ? super T, Integer> r1);
}
