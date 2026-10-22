package com.obric.common.oea.foundation.animation.token;

import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: AnimationProperty.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/AnimationProperty;", "", "()V", "FloatProperty", "IntProperty", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AnimationProperty {

    /* JADX INFO: compiled from: AnimationProperty.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty;", "", "propertyName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPropertyName", "()Ljava/lang/String;", "X", "Y", "SCALE_X", "SCALE_Y", "ROTATION", "ROTATION_X", "ROTATION_Y", "TRANSLATION_X", "TRANSLATION_Y", "ALPHA", "Companion", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum FloatProperty extends Enum<FloatProperty> {
        private static final /* synthetic */ FloatProperty[] $VALUES = null;
        public static final FloatProperty ALPHA = null;
        public static final Companion Companion = null;
        public static final FloatProperty ROTATION = null;
        public static final FloatProperty ROTATION_X = null;
        public static final FloatProperty ROTATION_Y = null;
        public static final FloatProperty SCALE_X = null;
        public static final FloatProperty SCALE_Y = null;
        public static final FloatProperty TRANSLATION_X = null;
        public static final FloatProperty TRANSLATION_Y = null;
        public static final FloatProperty X = null;
        public static final FloatProperty Y = null;
        private final String propertyName;

        /* JADX INFO: compiled from: AnimationProperty.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty$Companion;", "", "()V", "fromString", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty;", "value", "", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public final FloatProperty fromString(String r5) {
                Intrinsics.checkNotNullParameter(r5, "value");
                FloatProperty[] r4 = FloatProperty.values();
                int r0 = r4.length;
                int r1 = 0;
            L3:
                if (r1 >= r0) goto L7;
                FloatProperty r2 = r4[r1];
                r1 = r1 + 1;
                if (Intrinsics.areEqual(r2.getPropertyName(), r5) == false) goto L3;
                return r2;
            L7:
                return null;
            }
        }

        public static FloatProperty valueOf(String r1) {
            return (FloatProperty) Enum.valueOf(FloatProperty.class, r1);
        }

        public static FloatProperty[] values() {
            return (FloatProperty[]) $VALUES.clone();
        }

        private FloatProperty(String r1, int r2, String r3) {
            super(r1, r2);
            this.propertyName = r3;
        }

        public final String getPropertyName() {
            return this.propertyName;
        }

        static {
            FloatProperty r1 = new FloatProperty("X", 0, MaterialConfigFormatNames.X);
            X = r1;
            FloatProperty r2 = new FloatProperty("Y", 1, "y");
            Y = r2;
            FloatProperty r3 = new FloatProperty("SCALE_X", 2, "scaleX");
            SCALE_X = r3;
            FloatProperty r4 = new FloatProperty("SCALE_Y", 3, "scaleY");
            SCALE_Y = r4;
            FloatProperty r5 = new FloatProperty("ROTATION", 4, "rotation");
            ROTATION = r5;
            FloatProperty r6 = new FloatProperty("ROTATION_X", 5, "rotationX");
            ROTATION_X = r6;
            FloatProperty r7 = new FloatProperty("ROTATION_Y", 6, "rotationY");
            ROTATION_Y = r7;
            FloatProperty r8 = new FloatProperty("TRANSLATION_X", 7, "translationX");
            TRANSLATION_X = r8;
            FloatProperty r9 = new FloatProperty("TRANSLATION_Y", 8, "translationY");
            TRANSLATION_Y = r9;
            FloatProperty r10 = new FloatProperty("ALPHA", 9, "alpha");
            ALPHA = r10;
            $VALUES = new FloatProperty[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
            Companion = new Companion(null);
        }
    }

    /* JADX INFO: compiled from: AnimationProperty.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty;", "", "propertyName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPropertyName", "()Ljava/lang/String;", "BACKGROUND_COLOR", "TEXT_COLOR", "STROKE_COLOR", "FILL_COLOR", "WIDTH", "HEIGHT", "Companion", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum IntProperty extends Enum<IntProperty> {
        private static final /* synthetic */ IntProperty[] $VALUES = null;
        public static final IntProperty BACKGROUND_COLOR = null;
        public static final Companion Companion = null;
        public static final IntProperty FILL_COLOR = null;
        public static final IntProperty HEIGHT = null;
        public static final IntProperty STROKE_COLOR = null;
        public static final IntProperty TEXT_COLOR = null;
        public static final IntProperty WIDTH = null;
        private final String propertyName;

        /* JADX INFO: compiled from: AnimationProperty.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty$Companion;", "", "()V", "fromString", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty;", "value", "", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public final IntProperty fromString(String r5) {
                Intrinsics.checkNotNullParameter(r5, "value");
                IntProperty[] r4 = IntProperty.values();
                int r0 = r4.length;
                int r1 = 0;
            L3:
                if (r1 >= r0) goto L7;
                IntProperty r2 = r4[r1];
                r1 = r1 + 1;
                if (Intrinsics.areEqual(r2.getPropertyName(), r5) == false) goto L3;
                return r2;
            L7:
                return null;
            }
        }

        public static IntProperty valueOf(String r1) {
            return (IntProperty) Enum.valueOf(IntProperty.class, r1);
        }

        public static IntProperty[] values() {
            return (IntProperty[]) $VALUES.clone();
        }

        private IntProperty(String r1, int r2, String r3) {
            super(r1, r2);
            this.propertyName = r3;
        }

        public final String getPropertyName() {
            return this.propertyName;
        }

        static {
            IntProperty r1 = new IntProperty("BACKGROUND_COLOR", 0, "backgroundColor");
            BACKGROUND_COLOR = r1;
            IntProperty r2 = new IntProperty("TEXT_COLOR", 1, "textColor");
            TEXT_COLOR = r2;
            IntProperty r3 = new IntProperty("STROKE_COLOR", 2, "strokeColor");
            STROKE_COLOR = r3;
            IntProperty r4 = new IntProperty("FILL_COLOR", 3, "fillColor");
            FILL_COLOR = r4;
            IntProperty r5 = new IntProperty("WIDTH", 4, MaterialConfigFormatNames.WIDTH);
            WIDTH = r5;
            IntProperty r6 = new IntProperty("HEIGHT", 5, MonthWeekEventsView.VIEW_PARAMS_HEIGHT);
            HEIGHT = r6;
            $VALUES = new IntProperty[]{r1, r2, r3, r4, r5, r6};
            Companion = new Companion(null);
        }
    }

    private AnimationProperty() {
    }

    public /* synthetic */ AnimationProperty(DefaultConstructorMarker r1) {
        this();
    }
}
