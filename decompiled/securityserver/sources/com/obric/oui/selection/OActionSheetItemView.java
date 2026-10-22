package com.obric.oui.selection;

import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import com.obric.oui.lisitem.OListItemGeneral;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata
public final class OActionSheetItemView extends OListItemGeneral {
    public final void setIcon(@Nullable Drawable r1) {
        setContentImage(r1);
    }

    public final void setTitle(@NotNull String r2) {
        Intrinsics.f(r2, "str");
        setTitleString(r2);
    }
}
