package androidx.appcompat.resources;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class Compatibility {

    public static class Api15Impl {
        private Api15Impl() {
        }

        public static void getValueForDensity(Resources r0, int r1, int r2, TypedValue r3, boolean r4) {
            r0.getValueForDensity(r1, r2, r3, r4);
        }
    }

    public static class Api18Impl {
        private Api18Impl() {
        }

        public static void setAutoCancel(ObjectAnimator r0, boolean r1) {
            r0.setAutoCancel(r1);
        }
    }

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void inflate(Drawable r0, Resources r1, XmlPullParser r2, AttributeSet r3, Resources.Theme r4) throws IOException, XmlPullParserException {
            r0.inflate(r1, r2, r3, r4);
        }

        public static int getChangingConfigurations(TypedArray r0) {
            return r0.getChangingConfigurations();
        }

        public static Drawable createFromXmlInner(Resources r0, XmlPullParser r1, AttributeSet r2, Resources.Theme r3) throws IOException, XmlPullParserException {
            return Drawable.createFromXmlInner(r0, r1, r2, r3);
        }
    }

    private Compatibility() {
    }
}
