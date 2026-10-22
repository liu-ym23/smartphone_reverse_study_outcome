package com.obric.oui.infopanel.action;

import android.view.View;
import android.widget.LinearLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OInfoPanelDoubleBtnActionView extends LinearLayout implements IOInfoPanelActionView {

    @Metadata
    public static final enum Style extends Enum<Style> {
        public static final /* synthetic */ Style[] b = null;

        static {
            b = new Style[]{new Style("PRIMARY_SECONDARY", 0), new Style("ONLY_SECONDARY", 1)};
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
}
