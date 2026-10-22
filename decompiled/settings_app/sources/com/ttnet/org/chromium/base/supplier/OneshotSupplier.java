package com.ttnet.org.chromium.base.supplier;

import com.ttnet.org.chromium.base.Callback;

/* JADX INFO: loaded from: classes5.dex */
public interface OneshotSupplier<T> extends Supplier<T> {
    T onAvailable(Callback<T> r1);
}
