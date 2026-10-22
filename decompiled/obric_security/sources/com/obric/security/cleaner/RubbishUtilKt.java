package com.obric.security.cleaner;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: compiled from: RubbishUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¨\u0006\u0005"}, d2 = {"getRubbishSuggestSize", "", "", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "getRubbishTotalSize", "app_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class RubbishUtilKt {
    public static final long getRubbishTotalSize(Collection<? extends RubbishEntity> r4) {
        long r0 = 0;
        if (r4 == null) goto L8;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r0 = r0 + ((RubbishEntity) r5.next()).getSize();
    L8:
        return r0;
    }

    public static final long getRubbishSuggestSize(Collection<? extends RubbishEntity> r4) {
        long r0 = 0;
        if (r4 == null) goto L10;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        RubbishEntity r2 = (RubbishEntity) r5.next();
        if (r2.isSuggest() == false) goto L6;
        r0 = r0 + r2.getSize();
    L10:
        return r0;
    }
}
