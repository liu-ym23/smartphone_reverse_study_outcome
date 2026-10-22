package com.obric.capabilitykit;

import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u001a\u0014\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0007"}, d2 = {"mapToIdStringList", "", "", "appEntityList", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "printStringArray", "array", "capabilitykit_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class q {

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<String, CharSequence> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
            super(1);
        }

        public final CharSequence a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(String r1) {
            return a(r1);
        }
    }

    public static final List<String> a(List<? extends AppEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "appEntityList");
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.add(((AppEntity) r3.next()).getId());
        goto L4
    L6:
        return r0;
    }

    public static final String b(List<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "array");
        return CollectionsKt.joinToString$default(r10, ",", null, null, 0, null, a.a, 30, null);
    }
}
