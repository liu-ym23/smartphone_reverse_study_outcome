package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.value.Keyframe;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class Layer {
    private final LottieComposition composition;
    private final boolean hidden;
    private final List<Keyframe<Float>> inOutKeyframes;
    private final long layerId;
    private final String layerName;
    private final LayerType layerType;
    private final List<Mask> masks;
    private final MatteType matteType;
    private final long parentId;
    private final int preCompHeight;
    private final int preCompWidth;
    private final String refId;
    private final List<ContentModel> shapes;
    private final int solidColor;
    private final int solidHeight;
    private final int solidWidth;
    private final float startFrame;
    private final AnimatableTextFrame text;
    private final AnimatableTextProperties textProperties;
    private final AnimatableFloatValue timeRemapping;
    private final float timeStretch;
    private final AnimatableTransform transform;

    public static final enum LayerType extends Enum<LayerType> {
        private static final /* synthetic */ LayerType[] $VALUES = null;
        public static final LayerType IMAGE = null;
        public static final LayerType NULL = null;
        public static final LayerType PRE_COMP = null;
        public static final LayerType SHAPE = null;
        public static final LayerType SOLID = null;
        public static final LayerType TEXT = null;
        public static final LayerType UNKNOWN = null;

        private LayerType(String r1, int r2) {
            super(r1, r2);
        }

        public static LayerType valueOf(String r1) {
            return (LayerType) Enum.valueOf(LayerType.class, r1);
        }

        public static LayerType[] values() {
            return (LayerType[]) $VALUES.clone();
        }

        static {
            LayerType r0 = new LayerType("PRE_COMP", 0);
            PRE_COMP = r0;
            LayerType r1 = new LayerType("SOLID", 1);
            SOLID = r1;
            LayerType r3 = new LayerType("IMAGE", 2);
            IMAGE = r3;
            LayerType r5 = new LayerType("NULL", 3);
            NULL = r5;
            LayerType r7 = new LayerType("SHAPE", 4);
            SHAPE = r7;
            LayerType r9 = new LayerType("TEXT", 5);
            TEXT = r9;
            LayerType r11 = new LayerType(NetworkStackConstant.UNKNOWN_TYPE, 6);
            UNKNOWN = r11;
            $VALUES = new LayerType[]{r0, r1, r3, r5, r7, r9, r11};
        }
    }

    public static final enum MatteType extends Enum<MatteType> {
        private static final /* synthetic */ MatteType[] $VALUES = null;
        public static final MatteType ADD = null;
        public static final MatteType INVERT = null;
        public static final MatteType NONE = null;
        public static final MatteType UNKNOWN = null;

        private MatteType(String r1, int r2) {
            super(r1, r2);
        }

        public static MatteType valueOf(String r1) {
            return (MatteType) Enum.valueOf(MatteType.class, r1);
        }

        public static MatteType[] values() {
            return (MatteType[]) $VALUES.clone();
        }

        static {
            MatteType r0 = new MatteType("NONE", 0);
            NONE = r0;
            MatteType r1 = new MatteType("ADD", 1);
            ADD = r1;
            MatteType r3 = new MatteType("INVERT", 2);
            INVERT = r3;
            MatteType r5 = new MatteType(NetworkStackConstant.UNKNOWN_TYPE, 3);
            UNKNOWN = r5;
            $VALUES = new MatteType[]{r0, r1, r3, r5};
        }
    }

    public Layer(List<ContentModel> r4, LottieComposition r5, String r6, long r7, LayerType r9, long r10, String r12, List<Mask> r13, AnimatableTransform r14, int r15, int r16, int r17, float r18, float r19, int r20, int r21, AnimatableTextFrame r22, AnimatableTextProperties r23, List<Keyframe<Float>> r24, MatteType r25, AnimatableFloatValue r26, boolean r27) {
        this.shapes = r4;
        this.composition = r5;
        this.layerName = r6;
        this.layerId = r7;
        this.layerType = r9;
        this.parentId = r10;
        this.refId = r12;
        this.masks = r13;
        this.transform = r14;
        this.solidWidth = r15;
        this.solidHeight = r16;
        this.solidColor = r17;
        this.timeStretch = r18;
        this.startFrame = r19;
        this.preCompWidth = r20;
        this.preCompHeight = r21;
        this.text = r22;
        this.textProperties = r23;
        this.inOutKeyframes = r24;
        this.matteType = r25;
        this.timeRemapping = r26;
        this.hidden = r27;
    }

    LottieComposition getComposition() {
        return this.composition;
    }

    float getTimeStretch() {
        return this.timeStretch;
    }

    float getStartProgress() {
        return this.startFrame / this.composition.getDurationFrames();
    }

    List<Keyframe<Float>> getInOutKeyframes() {
        return this.inOutKeyframes;
    }

    public long getId() {
        return this.layerId;
    }

    String getName() {
        return this.layerName;
    }

    String getRefId() {
        return this.refId;
    }

    int getPreCompWidth() {
        return this.preCompWidth;
    }

    int getPreCompHeight() {
        return this.preCompHeight;
    }

    List<Mask> getMasks() {
        return this.masks;
    }

    public LayerType getLayerType() {
        return this.layerType;
    }

    MatteType getMatteType() {
        return this.matteType;
    }

    long getParentId() {
        return this.parentId;
    }

    List<ContentModel> getShapes() {
        return this.shapes;
    }

    AnimatableTransform getTransform() {
        return this.transform;
    }

    int getSolidColor() {
        return this.solidColor;
    }

    int getSolidHeight() {
        return this.solidHeight;
    }

    int getSolidWidth() {
        return this.solidWidth;
    }

    AnimatableTextFrame getText() {
        return this.text;
    }

    AnimatableTextProperties getTextProperties() {
        return this.textProperties;
    }

    AnimatableFloatValue getTimeRemapping() {
        return this.timeRemapping;
    }

    public String toString() {
        return toString("");
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public String toString(String r8) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r8).append(getName()).append("\n");
        Layer r1 = this.composition.layerModelForId(getParentId());
        if (r1 == null) goto L9;
        r0.append("\t\tParents: ").append(r1.getName());
        Layer r2 = this.composition.layerModelForId(r1.getParentId());
    L5:
        if (r2 == null) goto L7;
        r0.append("->").append(r2.getName());
        r2 = this.composition.layerModelForId(r2.getParentId());
        goto L5
    L7:
        r0.append(r8).append("\n");
    L9:
        if (getMasks().isEmpty() == true) goto L12;
        r0.append(r8).append("\tMasks: ").append(getMasks().size()).append("\n");
    L12:
        if (getSolidWidth() == 0) goto L17;
        if (getSolidHeight() == 0) goto L17;
        r0.append(r8).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", new Object[]{Integer.valueOf(getSolidWidth()), Integer.valueOf(getSolidHeight()), Integer.valueOf(getSolidColor())}));
    L17:
        if (this.shapes.isEmpty() == true) goto L23;
        r0.append(r8).append("\tShapes:\n");
        Iterator<ContentModel> r7 = this.shapes.iterator();
    L20:
        if (r7.hasNext() == false) goto L23;
        r0.append(r8).append("\t\t").append(r7.next()).append("\n");
    L23:
        return r0.toString();
    }
}
