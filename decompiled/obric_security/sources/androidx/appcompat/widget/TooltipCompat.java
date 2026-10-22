package androidx.appcompat.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class TooltipCompat {

    static class Api26Impl {
        private Api26Impl() {
        }

        static void setTooltipText(View r0, CharSequence r1) {
            r0.setTooltipText(r1);
        }
    }

    public static void setTooltipText(View r0, CharSequence r1) {
        Api26Impl.setTooltipText(r0, r1);
    }

    private TooltipCompat() {
    }
}
