package com.obric.oui.window.listener;

import androidx.lifecycle.Observer;
import com.obric.oui.window.bean.WindowSizeWithPageSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class WindowConfigChangeListener$Companion$observeOnMainThread$observer$1<T> implements Observer {
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r1) {
        Intrinsics.e((WindowSizeWithPageSize) r1, "it");
        throw null;
    }
}
