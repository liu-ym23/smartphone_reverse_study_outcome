package androidx.appcompat.resources;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class Compatibility {

    @RequiresApi(15)
    public static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        public static void getValueForDensity(@NonNull Resources r0, int r1, int r2, @NonNull TypedValue r3, boolean r4) {
            r0.getValueForDensity(r1, r2, r3, r4);
        }
    }

    @RequiresApi(18)
    public static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static void setAutoCancel(@NonNull ObjectAnimator r0, boolean r1) {
            r0.setAutoCancel(r1);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @NonNull
        @DoNotInline
        public static Drawable createFromXmlInner(@NonNull Resources r0, @NonNull XmlPullParser r1, @NonNull AttributeSet r2, @Nullable Resources.Theme r3) {
            return Drawable.createFromXmlInner(r0, r1, r2, r3);
        }

        @DoNotInline
        public static int getChangingConfigurations(@NonNull TypedArray r0) {
            return r0.getChangingConfigurations();
        }

        @DoNotInline
        public static void inflate(@NonNull Drawable r0, @NonNull Resources r1, @NonNull XmlPullParser r2, @NonNull AttributeSet r3, @Nullable Resources.Theme r4) {
            r0.inflate(r1, r2, r3, r4);
        }
    }

    private Compatibility() {
    }
}
