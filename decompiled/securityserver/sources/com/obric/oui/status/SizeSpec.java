package com.obric.oui.status;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum SizeSpec extends Enum<SizeSpec> {
    public static final /* synthetic */ SizeSpec[] b = null;

    @Metadata
    public static final class Companion {
    }

    static {
        b = new SizeSpec[]{new SizeSpec("LARGE", 0), new SizeSpec("MEDIUM", 1), new SizeSpec("SMALL", 2)};
    }

    public static SizeSpec valueOf(String r1) {
        return (SizeSpec) Enum.valueOf(SizeSpec.class, r1);
    }

    public static SizeSpec[] values() {
        return (SizeSpec[]) b.clone();
    }
}
