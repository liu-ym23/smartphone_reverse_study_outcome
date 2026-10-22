package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public final class PointerIconCompat {
    public static final int TYPE_ALIAS = 1010;
    public static final int TYPE_ALL_SCROLL = 1013;
    public static final int TYPE_ARROW = 1000;
    public static final int TYPE_CELL = 1006;
    public static final int TYPE_CONTEXT_MENU = 1001;
    public static final int TYPE_COPY = 1011;
    public static final int TYPE_CROSSHAIR = 1007;
    public static final int TYPE_DEFAULT = 1000;
    public static final int TYPE_GRAB = 1020;
    public static final int TYPE_GRABBING = 1021;
    public static final int TYPE_HAND = 1002;
    public static final int TYPE_HELP = 1003;
    public static final int TYPE_HORIZONTAL_DOUBLE_ARROW = 1014;
    public static final int TYPE_NO_DROP = 1012;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_TEXT = 1008;
    public static final int TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW = 1017;
    public static final int TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW = 1016;
    public static final int TYPE_VERTICAL_DOUBLE_ARROW = 1015;
    public static final int TYPE_VERTICAL_TEXT = 1009;
    public static final int TYPE_WAIT = 1004;
    public static final int TYPE_ZOOM_IN = 1018;
    public static final int TYPE_ZOOM_OUT = 1019;
    private final PointerIcon mPointerIcon;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static PointerIcon create(Bitmap r0, float r1, float r2) {
            return PointerIcon.create(r0, r1, r2);
        }

        @DoNotInline
        static PointerIcon getSystemIcon(Context r0, int r1) {
            return PointerIcon.getSystemIcon(r0, r1);
        }

        @DoNotInline
        static PointerIcon load(Resources r0, int r1) {
            return PointerIcon.load(r0, r1);
        }
    }

    private PointerIconCompat(PointerIcon r1) {
        this.mPointerIcon = r1;
    }

    @NonNull
    public static PointerIconCompat create(@NonNull Bitmap r2, float r3, float r4) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return new PointerIconCompat(Api24Impl.create(r2, r3, r4));
    L7:
        return new PointerIconCompat(null);
    }

    @NonNull
    public static PointerIconCompat getSystemIcon(@NonNull Context r2, int r3) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return new PointerIconCompat(Api24Impl.getSystemIcon(r2, r3));
    L7:
        return new PointerIconCompat(null);
    }

    @NonNull
    public static PointerIconCompat load(@NonNull Resources r2, int r3) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return new PointerIconCompat(Api24Impl.load(r2, r3));
    L7:
        return new PointerIconCompat(null);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Object getPointerIcon() {
        return this.mPointerIcon;
    }
}
