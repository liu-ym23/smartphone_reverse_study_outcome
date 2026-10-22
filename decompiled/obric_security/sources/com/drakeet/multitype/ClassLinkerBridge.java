package com.drakeet.multitype;

import androidx.exifinterface.media.ExifInterface;
import com.bytedanceos.security.Utils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClassLinkerBridge.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000f*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u000fB-\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eR \u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/drakeet/multitype/ClassLinkerBridge;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/drakeet/multitype/Linker;", "javaClassLinker", "Lcom/drakeet/multitype/JavaClassLinker;", "delegates", "", "Lcom/drakeet/multitype/ItemViewDelegate;", "(Lcom/drakeet/multitype/JavaClassLinker;[Lcom/drakeet/multitype/ItemViewDelegate;)V", "[Lcom/drakeet/multitype/ItemViewDelegate;", Utils.INTENT_KEY_INDEX, "", "position", "item", "(ILjava/lang/Object;)I", "Companion", "multitype"}, k = 1, mv = {1, 4, 2})
public final class ClassLinkerBridge<T> implements Linker<T> {
    public static final Companion Companion = null;
    private final ItemViewDelegate<T, ?>[] delegates;
    private final JavaClassLinker<T> javaClassLinker;

    /* JADX INFO: compiled from: ClassLinkerBridge.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0016\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u0005\u0012\u0002\b\u00030\n0\t¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/drakeet/multitype/ClassLinkerBridge$Companion;", "", "()V", "toLinker", "Lcom/drakeet/multitype/Linker;", ExifInterface.GPS_DIRECTION_TRUE, "javaClassLinker", "Lcom/drakeet/multitype/JavaClassLinker;", "delegates", "", "Lcom/drakeet/multitype/ItemViewDelegate;", "(Lcom/drakeet/multitype/JavaClassLinker;[Lcom/drakeet/multitype/ItemViewDelegate;)Lcom/drakeet/multitype/Linker;", "multitype"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final <T> Linker<T> toLinker(JavaClassLinker<T> r2, ItemViewDelegate<T, ?>[] r3) {
            Intrinsics.checkNotNullParameter(r2, "javaClassLinker");
            Intrinsics.checkNotNullParameter(r3, "delegates");
            return new ClassLinkerBridge(r2, r3, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private ClassLinkerBridge(JavaClassLinker<T> r1, ItemViewDelegate<T, ?>[] r2) {
        this.javaClassLinker = r1;
        this.delegates = r2;
    }

    public /* synthetic */ ClassLinkerBridge(JavaClassLinker r1, ItemViewDelegate[] r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Override // com.drakeet.multitype.Linker
    public int index(int r5, T r6) {
        Class<? extends ItemViewDelegate<T, ?>> r7 = this.javaClassLinker.index(r5, r6);
        ItemViewDelegate<T, ?>[] r8 = this.delegates;
        int r0 = r8.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        if (Intrinsics.areEqual(r8[r1].getClass(), r7) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 == (-1)) goto L12;
        return r1;
    L12:
        StringBuilder r2 = new StringBuilder("The delegates'(");
        String r4 = Arrays.toString(this.delegates);
        Intrinsics.checkNotNullExpressionValue(r4, "java.util.Arrays.toString(this)");
        throw new IndexOutOfBoundsException(r2.append(r4).append(") you registered do not contain this ").append(r7.getName()).append('.').toString());
    L9:
        r1 = -1;
        goto L10
    }
}
