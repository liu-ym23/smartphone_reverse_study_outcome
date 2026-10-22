package com.obric.oui.infopanel.action;

import android.view.View;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OInfoPanelSingleBtnActionView extends LinearLayout implements IOInfoPanelActionView {

    @Metadata
    public static final enum Style extends Enum<Style> {
        public static final /* synthetic */ Style[] b = null;

        static {
            b = new Style[]{new Style("PRIMARY", 0), new Style("SECONDARY", 1)};
        }

        public static Style valueOf(String r1) {
            return (Style) Enum.valueOf(Style.class, r1);
        }

        public static Style[] values() {
            return (Style[]) b.clone();
        }
    }

    @NotNull
    public View getView() {
        return this;
    }

    public final void setBtnOnClickListener(@NotNull View.OnClickListener r1) {
        Intrinsics.f(r1, "listener");
        throw null;
    }

    public final void setBtnText(@NotNull CharSequence r1) {
        Intrinsics.f(r1, "text");
        throw null;
    }
}
