package com.obric.oui.window.interfaces;

import com.obric.oui.window.bean.WindowSizeWithPageSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnWindowConfigChangeListener.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/window/interfaces/OnWindowConfigChangeListener;", "", "onChange", "", "windowSizeWithPageSize", "Lcom/obric/oui/window/bean/WindowSizeWithPageSize;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OnWindowConfigChangeListener {

    /* JADX INFO: compiled from: OnWindowConfigChangeListener.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onChange(OnWindowConfigChangeListener r1, WindowSizeWithPageSize r2) {
            Intrinsics.checkNotNullParameter(r1, "this");
            Intrinsics.checkNotNullParameter(r2, "windowSizeWithPageSize");
        }
    }

    void onChange(WindowSizeWithPageSize r1);
}
