package com.obric.oui.chip;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class OChip extends OUIFrameLayout {
    public static final /* synthetic */ int l = 0;
    public Function2 k;

    @Metadata
    public static final enum Style extends Enum<Style> {
        public static final /* synthetic */ Style[] b = null;

        static {
            b = new Style[]{new Style("Default", 0), new Style("Rect", 1)};
        }

        public static Style valueOf(String r1) {
            return (Style) Enum.valueOf(Style.class, r1);
        }

        public static Style[] values() {
            return (Style[]) b.clone();
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[Style.values().length];
            r0[0] = 1;
            r0[1] = 2;
        }
    }

    @NotNull
    public final ImageView getChipIcon() {
        return null;
    }

    @NotNull
    public final ImageView getCloseIcon() {
        return null;
    }

    @NotNull
    public final CharSequence getText() {
        throw null;
    }

    @NotNull
    public final TextView getTextView() {
        return null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    public final void setOnCheckedListener(@NotNull Function2<? super OChip, ? super Boolean, Unit> r2) {
        Intrinsics.f(r2, "l");
        this.k = r2;
    }

    public final void setOnCloseListener(@Nullable View.OnClickListener r1) {
        throw null;
    }

    public final void setText(@NotNull CharSequence r1) {
        Intrinsics.f(r1, "value");
        throw null;
    }
}
