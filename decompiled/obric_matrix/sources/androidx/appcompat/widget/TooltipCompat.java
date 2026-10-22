package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class TooltipCompat {

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static void setTooltipText(View r0, CharSequence r1) {
            r0.setTooltipText(r1);
        }
    }

    private TooltipCompat() {
    }

    public static void setTooltipText(@NonNull View r2, @Nullable CharSequence r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.setTooltipText(r2, r3);
        return;
    L5:
        TooltipCompatHandler.setTooltipText(r2, r3);
    }
}
