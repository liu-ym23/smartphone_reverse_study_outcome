package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Logger;

/* JADX INFO: loaded from: classes.dex */
public class MergePaths implements ContentModel {
    private final boolean hidden;
    private final MergePathsMode mode;
    private final String name;

    public static final enum MergePathsMode extends Enum<MergePathsMode> {
        private static final /* synthetic */ MergePathsMode[] $VALUES = null;
        public static final MergePathsMode ADD = null;
        public static final MergePathsMode EXCLUDE_INTERSECTIONS = null;
        public static final MergePathsMode INTERSECT = null;
        public static final MergePathsMode MERGE = null;
        public static final MergePathsMode SUBTRACT = null;

        private MergePathsMode(String r1, int r2) {
            super(r1, r2);
        }

        public static MergePathsMode valueOf(String r1) {
            return (MergePathsMode) Enum.valueOf(MergePathsMode.class, r1);
        }

        public static MergePathsMode[] values() {
            return (MergePathsMode[]) $VALUES.clone();
        }

        static {
            MergePathsMode r0 = new MergePathsMode("MERGE", 0);
            MERGE = r0;
            MergePathsMode r1 = new MergePathsMode("ADD", 1);
            ADD = r1;
            MergePathsMode r3 = new MergePathsMode("SUBTRACT", 2);
            SUBTRACT = r3;
            MergePathsMode r5 = new MergePathsMode("INTERSECT", 3);
            INTERSECT = r5;
            MergePathsMode r7 = new MergePathsMode("EXCLUDE_INTERSECTIONS", 4);
            EXCLUDE_INTERSECTIONS = r7;
            $VALUES = new MergePathsMode[]{r0, r1, r3, r5, r7};
        }

        public static MergePathsMode forId(int r1) {
            if (r1 == 1) goto L23;
            if (r1 == 2) goto L21;
            if (r1 == 3) goto L19;
            if (r1 == 4) goto L17;
            if (r1 == 5) goto L15;
            return MERGE;
        L15:
            return EXCLUDE_INTERSECTIONS;
        L17:
            return INTERSECT;
        L19:
            return SUBTRACT;
        L21:
            return ADD;
        L23:
            return MERGE;
        }
    }

    public MergePaths(String r1, MergePathsMode r2, boolean r3) {
        this.name = r1;
        this.mode = r2;
        this.hidden = r3;
    }

    public String getName() {
        return this.name;
    }

    public MergePathsMode getMode() {
        return this.mode;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable r1, BaseLayer r2) {
        if (r1.enableMergePathsForKitKatAndAbove() == true) goto L7;
        Logger.warning("Animation contains merge paths but they are disabled.");
        return null;
    L7:
        return new MergePathsContent(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.mode + '}';
    }
}
