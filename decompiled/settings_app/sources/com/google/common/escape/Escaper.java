package com.google.common.escape;

import com.google.common.base.Function;
import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: loaded from: classes3.dex */
@DoNotMock("Use Escapers.nullEscaper() or another methods from the *Escapers classes")
@ElementTypesAreNonnullByDefault
public abstract class Escaper {
    private final Function<String, String> asFunction;

    public abstract String escape(String r1);

    protected Escaper() {
        this.asFunction = new AnonymousClass1(this);
    }

    public final Function<String, String> asFunction() {
        return this.asFunction;
    }
}
