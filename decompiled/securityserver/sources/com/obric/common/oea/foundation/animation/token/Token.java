package com.obric.common.oea.foundation.animation.token;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.apm6.fd.config.FdConfig;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.ss.android.common.ApiConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Token {

    @Metadata
    public static final enum Bounce extends Enum<Bounce> {
        public static final /* synthetic */ Bounce[] b = null;

        static {
            b = new Bounce[]{new Bounce("OUI_ANIMATION_BOUNCE_SMOOTH", 0, 0.0f, 1.0f), new Bounce("OUI_ANIMATION_BOUNCE_SNAPPY_1", 1, 0.05f, 0.95f), new Bounce("OUI_ANIMATION_BOUNCE_SNAPPY_2", 2, 0.1f, 0.9f), new Bounce("OUI_ANIMATION_BOUNCE_SNAPPY_3", 3, 0.15f, 0.85f), new Bounce("OUI_ANIMATION_BOUNCE_SNAPPY_4", 4, 0.2f, 0.8f), new Bounce("OUI_ANIMATION_BOUNCE_BOUNCY_1", 5, 0.25f, 0.75f), new Bounce("OUI_ANIMATION_BOUNCE_BOUNCY_2", 6, 0.3f, 0.7f), new Bounce("OUI_ANIMATION_BOUNCE_BOUNCY_3", 7, 0.35f, 0.65f), new Bounce("OUI_ANIMATION_BOUNCE_BOUNCY_4", 8, 0.4f, 0.6f)};
        }

        public Bounce(String r1, int r2, float r3, float r4) {
            super(r1, r2);
        }

        public static Bounce valueOf(String r1) {
            return (Bounce) Enum.valueOf(Bounce.class, r1);
        }

        public static Bounce[] values() {
            return (Bounce[]) b.clone();
        }
    }

    @Metadata
    public static final enum Delay extends Enum<Delay> {
        public static final /* synthetic */ Delay[] b = null;

        static {
            b = new Delay[]{new Delay("OUI_ANIMATION_DELAY_NONE", 0), new Delay("OUI_ANIMATION_DELAY_SHORT_1", 1), new Delay("OUI_ANIMATION_DELAY_SHORT_2", 2), new Delay("OUI_ANIMATION_DELAY_SHORT_3", 3), new Delay("OUI_ANIMATION_DELAY_SHORT_4", 4), new Delay("OUI_ANIMATION_DELAY_MEDIUM_1", 5), new Delay("OUI_ANIMATION_DELAY_MEDIUM_2", 6), new Delay("OUI_ANIMATION_DELAY_MEDIUM_3", 7), new Delay("OUI_ANIMATION_DELAY_MEDIUM_4", 8), new Delay("OUI_ANIMATION_DELAY_LONG_1", 9), new Delay("OUI_ANIMATION_DELAY_LONG_2", 10), new Delay("OUI_ANIMATION_DELAY_LONG_3", 11), new Delay("OUI_ANIMATION_DELAY_LONG_4", 12), new Delay("OUI_ANIMATION_DELAY_VERY_LONG_1", 13), new Delay("OUI_ANIMATION_DELAY_VERY_LONG_2", 14), new Delay("OUI_ANIMATION_DELAY_VERY_LONG_3", 15), new Delay("OUI_ANIMATION_DELAY_VERY_LONG_4", 16)};
        }

        public static Delay valueOf(String r1) {
            return (Delay) Enum.valueOf(Delay.class, r1);
        }

        public static Delay[] values() {
            return (Delay[]) b.clone();
        }
    }

    @Metadata
    public static final enum Duration extends Enum<Duration> {
        public static final /* synthetic */ Duration[] b = null;

        static {
            b = new Duration[]{new Duration("OUI_ANIMATION_DURATION_SHORT_1", 0, 50, 15791), new Duration("OUI_ANIMATION_DURATION_SHORT_2", 1, 100, 3948), new Duration("OUI_ANIMATION_DURATION_SHORT_3", 2, 150, 1755), new Duration("OUI_ANIMATION_DURATION_SHORT_4", 3, 200, 987), new Duration("OUI_ANIMATION_DURATION_MEDIUM_1", 4, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 632), new Duration("OUI_ANIMATION_DURATION_MEDIUM_2", 5, HttpStatus.SC_MULTIPLE_CHOICES, 439), new Duration("OUI_ANIMATION_DURATION_MEDIUM_3", 6, 350, 322), new Duration("OUI_ANIMATION_DURATION_MEDIUM_4", 7, 400, 247), new Duration("OUI_ANIMATION_DURATION_LONG_1", 8, 450, 195), new Duration("OUI_ANIMATION_DURATION_LONG_2", 9, 500, 158), new Duration("OUI_ANIMATION_DURATION_LONG_3", 10, 550, 131), new Duration("OUI_ANIMATION_DURATION_LONG_4", 11, 600, ApiConstants.OP_ERROR_ANTISPAM), new Duration("OUI_ANIMATION_DURATION_VERY_LONG_1", 12, TypedValues.TransitionType.TYPE_DURATION, 81), new Duration("OUI_ANIMATION_DURATION_VERY_LONG_2", 13, FdConfig.DEFAULT_FD_COUNT_THRESHOLD, 62), new Duration("OUI_ANIMATION_DURATION_VERY_LONG_3", 14, TypedValues.Custom.TYPE_INT, 49), new Duration("OUI_ANIMATION_DURATION_VERY_LONG_4", 15, 1000, 39)};
        }

        public Duration(String r1, int r2, int r3, int r4) {
            super(r1, r2);
        }

        public static Duration valueOf(String r1) {
            return (Duration) Enum.valueOf(Duration.class, r1);
        }

        public static Duration[] values() {
            return (Duration[]) b.clone();
        }
    }

    @Metadata
    public static final enum Easing extends Enum<Easing> {
        public static final /* synthetic */ Easing[] b = null;

        static {
            b = new Easing[]{new Easing("OUI_ANIMATION_EASING_LINEAR", new float[]{0.0f, 0.0f, 1.0f, 1.0f}, 0), new Easing("OUI_ANIMATION_EASING_STANDARD", new float[]{0.34f, 0.69f, 0.1f, 1.0f}, 1), new Easing("OUI_ANIMATION_EASING_EASE", new float[]{0.25f, 0.1f, 0.25f, 1.0f}, 2), new Easing("OUI_ANIMATION_EASING_EASE_IN", new float[]{0.42f, 0.0f, 1.0f, 1.0f}, 3), new Easing("OUI_ANIMATION_EASING_EASE_OUT", new float[]{0.0f, 0.0f, 0.58f, 1.0f}, 4), new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT", new float[]{0.42f, 0.0f, 0.58f, 1.0f}, 5), new Easing("OUI_ANIMATION_EASING_EASE_IN_SINE", new float[]{0.47f, 0.0f, 0.745f, 0.715f}, 6), new Easing("OUI_ANIMATION_EASING_EASE_OUT_SINE", new float[]{0.39f, 0.575f, 0.565f, 1.0f}, 7), new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_SINE", new float[]{0.445f, 0.05f, 0.55f, 0.95f}, 8), new Easing("OUI_ANIMATION_EASING_EASE_IN_QUAD", new float[]{0.26f, 0.0f, 0.6f, 0.2f}, 9), new Easing("OUI_ANIMATION_EASING_EASE_OUT_QUAD", new float[]{0.4f, 0.8f, 0.74f, 1.0f}, 10), new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUAD", new float[]{0.48f, 0.04f, 0.52f, 0.96f}, 11), new Easing("OUI_ANIMATION_EASING_EASE_IN_CUBIC", new float[]{0.4f, 0.0f, 0.68f, 0.06f}, 12), new Easing("OUI_ANIMATION_EASING_EASE_OUT_CUBIC", new float[]{0.32f, 0.94f, 0.6f, 1.0f}, 13), new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_CUBIC", new float[]{0.66f, 0.0f, 0.34f, 1.0f}, 14), new Easing("OUI_ANIMATION_EASING_EASE_IN_QUART", new float[]{0.52f, 0.0f, 0.74f, 0.0f}, 15), new Easing("OUI_ANIMATION_EASING_EASE_OUT_QUART", new float[]{0.26f, 1.0f, 0.48f, 1.0f}, 16), new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUART", new float[]{0.76f, 0.0f, 0.24f, 1.0f}, 17), new Easing("OUI_ANIMATION_EASING_EASE_IN_QUINT", new float[]{0.64f, 0.0f, 0.78f, 0.0f}, 18), new Easing("OUI_ANIMATION_EASING_EASE_OUT_QUINT", new float[]{0.22f, 1.0f, 0.36f, 1.0f}, 19), new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_QUINT", new float[]{0.84f, 0.0f, 0.16f, 1.0f}, 20), new Easing("OUI_ANIMATION_EASING_EASE_IN_EXPO", new float[]{0.66f, 0.0f, 0.86f, 0.0f}, 21), new Easing("OUI_ANIMATION_EASING_EASE_OUT_EXPO", new float[]{0.14f, 1.0f, 0.34f, 1.0f}, 22), new Easing("OUI_ANIMATION_EASING_EASE_IN_OUT_EXPO", new float[]{0.9f, 0.0f, 0.1f, 1.0f}, 23)};
        }

        public Easing(String r1, float[] r2, int r3) {
            super(r1, r3);
        }

        public static Easing valueOf(String r1) {
            return (Easing) Enum.valueOf(Easing.class, r1);
        }

        public static Easing[] values() {
            return (Easing[]) b.clone();
        }
    }
}
