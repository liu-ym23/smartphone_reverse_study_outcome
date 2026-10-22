package com.obric.security.cleaner;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: compiled from: RubbishEntityWrapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/security/cleaner/RubbishEntityWrapper;", "", "entity", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "position", "", "(Ltmsdk/fg/module/cleanV2/RubbishEntity;I)V", "getEntity", "()Ltmsdk/fg/module/cleanV2/RubbishEntity;", "getPosition", "()I", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RubbishEntityWrapper {
    private final RubbishEntity entity;
    private final int position;

    public RubbishEntityWrapper(RubbishEntity r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        this.entity = r2;
        this.position = r3;
    }

    public /* synthetic */ RubbishEntityWrapper(RubbishEntity r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = -1;
    L5:
        this(r1, r2);
    }

    public final RubbishEntity getEntity() {
        return this.entity;
    }

    public final int getPosition() {
        return this.position;
    }
}
