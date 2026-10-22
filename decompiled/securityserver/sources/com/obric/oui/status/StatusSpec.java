package com.obric.oui.status;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum StatusSpec extends Enum<StatusSpec> {
    public static final /* synthetic */ StatusSpec[] b = null;

    @Metadata
    public static final class Companion {
    }

    static {
        b = new StatusSpec[]{new StatusSpec("EMPTY", 0), new StatusSpec("LOADING", 1)};
    }

    public static StatusSpec valueOf(String r1) {
        return (StatusSpec) Enum.valueOf(StatusSpec.class, r1);
    }

    public static StatusSpec[] values() {
        return (StatusSpec[]) b.clone();
    }
}
