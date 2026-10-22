package com.obric.common.oea.style.scene.alpha.alphaplayer.model;

import com.bytedanceos.security.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ScaleType.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "", Utils.INTENT_KEY_INDEX, "", "(Ljava/lang/String;II)V", "ScaleToFill", "ScaleAspectFitCenter", "ScaleAspectFill", "TopFill", "BottomFill", "LeftFill", "RightFill", "TopFit", "BottomFit", "LeftFit", "RightFit", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum ScaleType extends Enum<ScaleType> {
    private static final /* synthetic */ ScaleType[] $VALUES = null;
    public static final ScaleType BottomFill = null;
    public static final ScaleType BottomFit = null;
    public static final Companion Companion = null;
    public static final ScaleType LeftFill = null;
    public static final ScaleType LeftFit = null;
    public static final ScaleType RightFill = null;
    public static final ScaleType RightFit = null;
    public static final ScaleType ScaleAspectFill = null;
    public static final ScaleType ScaleAspectFitCenter = null;
    public static final ScaleType ScaleToFill = null;
    public static final ScaleType TopFill = null;
    public static final ScaleType TopFit = null;

    /* JADX INFO: compiled from: ScaleType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType$Companion;", "", "()V", "convertFrom", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", Utils.INTENT_KEY_INDEX, "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final ScaleType convertFrom(int r1) {
            switch(r1) {
                case 1: goto L14;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L20;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L17;
                case 10: goto L16;
                default: goto L15;
            };
        L15:
            return ScaleType.ScaleToFill;
        L16:
            return ScaleType.RightFit;
        L17:
            return ScaleType.LeftFit;
        L18:
            return ScaleType.BottomFit;
        L19:
            return ScaleType.TopFit;
        L20:
            return ScaleType.RightFill;
        L21:
            return ScaleType.LeftFill;
        L22:
            return ScaleType.BottomFill;
        L23:
            return ScaleType.TopFill;
        L24:
            return ScaleType.ScaleAspectFill;
        L14:
            return ScaleType.ScaleAspectFitCenter;
        }
    }

    public static ScaleType valueOf(String r1) {
        return (ScaleType) Enum.valueOf(ScaleType.class, r1);
    }

    public static ScaleType[] values() {
        return (ScaleType[]) $VALUES.clone();
    }

    private ScaleType(String r1, int r2, int r3) {
        super(r1, r2);
    }

    static {
        ScaleType r1 = new ScaleType("ScaleToFill", 0, 0);
        ScaleToFill = r1;
        ScaleType r2 = new ScaleType("ScaleAspectFitCenter", 1, 1);
        ScaleAspectFitCenter = r2;
        ScaleType r3 = new ScaleType("ScaleAspectFill", 2, 2);
        ScaleAspectFill = r3;
        ScaleType r4 = new ScaleType("TopFill", 3, 3);
        TopFill = r4;
        ScaleType r5 = new ScaleType("BottomFill", 4, 4);
        BottomFill = r5;
        ScaleType r6 = new ScaleType("LeftFill", 5, 5);
        LeftFill = r6;
        ScaleType r7 = new ScaleType("RightFill", 6, 6);
        RightFill = r7;
        ScaleType r8 = new ScaleType("TopFit", 7, 7);
        TopFit = r8;
        ScaleType r9 = new ScaleType("BottomFit", 8, 8);
        BottomFit = r9;
        ScaleType r10 = new ScaleType("LeftFit", 9, 9);
        LeftFit = r10;
        ScaleType r11 = new ScaleType("RightFit", 10, 10);
        RightFit = r11;
        $VALUES = new ScaleType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Companion = new Companion(null);
    }
}
