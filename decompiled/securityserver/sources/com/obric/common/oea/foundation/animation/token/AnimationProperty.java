package com.obric.common.oea.foundation.animation.token;

import androidx.constraintlayout.motion.widget.Key;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AnimationProperty {

    @Metadata
    public static final enum FloatProperty extends Enum<FloatProperty> {
        public static final FloatProperty c = null;
        public static final FloatProperty e = null;
        public static final /* synthetic */ FloatProperty[] f = null;
        public final String b;

        @Metadata
        public static final class Companion {
        }

        static {
            FloatProperty r0 = new FloatProperty("X", 0, "x");
            FloatProperty r1 = new FloatProperty("Y", 1, "y");
            FloatProperty r2 = new FloatProperty("SCALE_X", 2, "scaleX");
            c = r2;
            FloatProperty r3 = new FloatProperty("SCALE_Y", 3, "scaleY");
            e = r3;
            f = new FloatProperty[]{r0, r1, r2, r3, new FloatProperty("ROTATION", 4, Key.ROTATION), new FloatProperty("ROTATION_X", 5, "rotationX"), new FloatProperty("ROTATION_Y", 6, "rotationY"), new FloatProperty("TRANSLATION_X", 7, "translationX"), new FloatProperty("TRANSLATION_Y", 8, "translationY"), new FloatProperty("ALPHA", 9, "alpha")};
        }

        public FloatProperty(String r1, int r2, String r3) {
            super(r1, r2);
            this.b = r3;
        }

        public static FloatProperty valueOf(String r1) {
            return (FloatProperty) Enum.valueOf(FloatProperty.class, r1);
        }

        public static FloatProperty[] values() {
            return (FloatProperty[]) f.clone();
        }
    }

    @Metadata
    public static final enum IntProperty extends Enum<IntProperty> {
        public static final /* synthetic */ IntProperty[] b = null;

        @Metadata
        public static final class Companion {
        }

        static {
            b = new IntProperty[]{new IntProperty("BACKGROUND_COLOR", 0, "backgroundColor"), new IntProperty("TEXT_COLOR", 1, "textColor"), new IntProperty("STROKE_COLOR", 2, "strokeColor"), new IntProperty("FILL_COLOR", 3, "fillColor"), new IntProperty("WIDTH", 4, "width"), new IntProperty("HEIGHT", 5, "height")};
        }

        public IntProperty(String r1, int r2, String r3) {
            super(r1, r2);
        }

        public static IntProperty valueOf(String r1) {
            return (IntProperty) Enum.valueOf(IntProperty.class, r1);
        }

        public static IntProperty[] values() {
            return (IntProperty[]) b.clone();
        }
    }
}
