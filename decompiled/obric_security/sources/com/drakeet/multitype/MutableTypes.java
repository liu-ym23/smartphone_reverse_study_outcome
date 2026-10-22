package com.drakeet.multitype;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: MutableTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0014\u0010\u000e\u001a\u00020\u00032\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0006\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u001c\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0006H\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/drakeet/multitype/MutableTypes;", "Lcom/drakeet/multitype/Types;", "initialCapacity", "", GloableSearchConfig.KEY_CONFIGS, "", "Lcom/drakeet/multitype/Type;", "(ILjava/util/List;)V", "getInitialCapacity", "()I", PerfConsts.PERF_DISK_FILE_SIZE, "getSize", "getTypes", "()Ljava/util/List;", "firstIndexOf", "clazz", "Ljava/lang/Class;", "getType", ExifInterface.GPS_DIRECTION_TRUE, Utils.INTENT_KEY_INDEX, "register", "", "type", "unregister", "", "multitype"}, k = 1, mv = {1, 4, 2})
public class MutableTypes implements Types {
    private final int initialCapacity;
    private final List<Type<?>> types;

    /* JADX WARN: Multi-variable type inference failed */
    public MutableTypes() {
        int r2 = 0;
        this(r2, null, 3, 0 == true ? 1 : 0);
    }

    public MutableTypes(int r2, List<Type<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, GloableSearchConfig.KEY_CONFIGS);
        this.initialCapacity = r2;
        this.types = r3;
    }

    public int getInitialCapacity() {
        return this.initialCapacity;
    }

    public /* synthetic */ MutableTypes(int r1, ArrayList r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = new ArrayList(r1);
    L8:
        this(r1, r2);
    }

    public List<Type<?>> getTypes() {
        return this.types;
    }

    @Override // com.drakeet.multitype.Types
    public int getSize() {
        return getTypes().size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.drakeet.multitype.Types
    public <T> void register(Type<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        getTypes().add(r2);
    }

    @Override // com.drakeet.multitype.Types
    public boolean unregister(final Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return CollectionsKt.removeAll(getTypes(), new AnonymousClass1(r2));
    }

    @Override // com.drakeet.multitype.Types
    public <T> Type<T> getType(int r1) {
        Object r0 = getTypes().get(r1);
        if (r0 == null) goto L7;
        return (Type) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.drakeet.multitype.Type<T>");
    }

    @Override // com.drakeet.multitype.Types
    public int firstIndexOf(Class<?> r6) {
        Intrinsics.checkNotNullParameter(r6, "clazz");
        Iterator<Type<?>> r0 = getTypes().iterator();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r0.next().getClazz(), r6) == true) goto L10;
        r2 = r2 + 1;
    L10:
        if (r2 == (-1)) goto L12;
        return r2;
    L12:
        Iterator<Type<?>> r5 = getTypes().iterator();
    L14:
        if (r5.hasNext() == false) goto L24;
        if (r5.next().getClazz().isAssignableFrom(r6) == true) goto L19;
        r1 = r1 + 1;
        goto L14
    L19:
        return r1;
    L24:
        return -1;
    L9:
        r2 = -1;
        goto L10
    }
}
