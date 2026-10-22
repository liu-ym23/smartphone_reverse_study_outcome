package androidx.appcompat.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class TooltipCompat {
    private TooltipCompat() {
    }

    public static void setTooltipText(@NonNull View r0, @Nullable CharSequence r1) {
        r0.setTooltipText(r1);
    }
}
