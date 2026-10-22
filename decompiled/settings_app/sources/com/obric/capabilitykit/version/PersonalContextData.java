package com.obric.capabilitykit.version;

import android.os.Bundle;
import com.obric.capabilitykit.entity.app.EntityType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/version/PersonalContextData;", "", "supportEntityTypes", "", "", "(Ljava/util/Set;)V", "getSupportEntityTypes", "()Ljava/util/Set;", "fillBundle", "", "bundle", "Landroid/os/Bundle;", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PersonalContextData {
    public static final Companion Companion = null;
    private static final String SUPPORT_ENTITY_TYPE_KEY = "support_entity_type";
    private final Set<Integer> supportEntityTypes;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/version/PersonalContextData$Companion;", "", "()V", "SUPPORT_ENTITY_TYPE_KEY", "", "createFromBundle", "Lcom/obric/capabilitykit/version/PersonalContextData;", "bundle", "Landroid/os/Bundle;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final PersonalContextData createFromBundle(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "bundle");
            int[] r3 = r2.getIntArray(PersonalContextData.SUPPORT_ENTITY_TYPE_KEY);
            if (r3 == null) goto L6;
            Set<Integer> r4 = ArraysKt.toSet(r3);
            if (r4 == null) goto L6;
        L8:
            return new PersonalContextData(r4);
        L6:
            r4 = EntityType.INSTANCE.getClassMap().keySet();
            goto L8
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PersonalContextData(Set<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "supportEntityTypes");
        this.supportEntityTypes = r2;
    }

    public final void fillBundle(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        r2.putIntArray(SUPPORT_ENTITY_TYPE_KEY, CollectionsKt.toIntArray(this.supportEntityTypes));
    }

    public final Set<Integer> getSupportEntityTypes() {
        return this.supportEntityTypes;
    }
}
