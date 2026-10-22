package com.obric.oui.material;

import kotlin.Metadata;

/* JADX INFO: compiled from: OMaterial.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\b\u0005\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/oui/material/OMaterial;", "", "()V", "ENABLE_BLEND_MODE_COMPAT", "", "BackdropCaptureMode", "BlurDirection", "CurveType", "DrawMode", "EffectLevel", "RenderSeparateType", "RenderViewType", "SourceType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OMaterial {
    public static boolean ENABLE_BLEND_MODE_COMPAT;
    public static final OMaterial INSTANCE = null;

    /* JADX INFO: compiled from: OMaterial.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/material/OMaterial$BackdropCaptureMode;", "", "()V", "BACKDROP", "", "LAYER", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BackdropCaptureMode {
        public static final int BACKDROP = 0;
        public static final BackdropCaptureMode INSTANCE = null;
        public static final int LAYER = 1;

        static {
            INSTANCE = new BackdropCaptureMode();
        }

        private BackdropCaptureMode() {
        }
    }

    /* JADX INFO: compiled from: OMaterial.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/material/OMaterial$BlurDirection;", "", "()V", "NONE", "", "NORMAL", "PROGRESS_DOWN_UP", "PROGRESS_LEFT_RIGHT", "PROGRESS_RIGHT_LEFT", "PROGRESS_UP_DOWN", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BlurDirection {
        public static final BlurDirection INSTANCE = null;
        public static final int NONE = -1;
        public static final int NORMAL = 0;
        public static final int PROGRESS_DOWN_UP = 1;
        public static final int PROGRESS_LEFT_RIGHT = 3;
        public static final int PROGRESS_RIGHT_LEFT = 4;
        public static final int PROGRESS_UP_DOWN = 2;

        static {
            INSTANCE = new BlurDirection();
        }

        private BlurDirection() {
        }
    }

    /* JADX INFO: compiled from: OMaterial.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/material/OMaterial$CurveType;", "", "()V", "IN_CUBIC", "", "IN_OUT_CUBIC", "IN_OUT_QUAD", "IN_QUAD", "LINEAR", "OUT_CUBIC", "OUT_QUAD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CurveType {
        public static final CurveType INSTANCE = null;
        public static final int IN_CUBIC = 4;
        public static final int IN_OUT_CUBIC = 6;
        public static final int IN_OUT_QUAD = 3;
        public static final int IN_QUAD = 1;
        public static final int LINEAR = 0;
        public static final int OUT_CUBIC = 5;
        public static final int OUT_QUAD = 2;

        static {
            INSTANCE = new CurveType();
        }

        private CurveType() {
        }
    }

    /* JADX INFO: compiled from: OMaterial.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/oui/material/OMaterial$DrawMode;", "", "()V", "ALL_TEXTURES", "", "BACKGROUND", "NONE", "SPEC_TEXTURE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DrawMode {
        public static final int ALL_TEXTURES = 4;
        public static final int BACKGROUND = 1;
        public static final DrawMode INSTANCE = null;
        public static final int NONE = 0;
        public static final int SPEC_TEXTURE = 2;

        static {
            INSTANCE = new DrawMode();
        }

        private DrawMode() {
        }
    }

    /* JADX INFO: compiled from: OMaterial.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/material/OMaterial$EffectLevel;", "", "()V", "FLUID", "", "NONE", "NORMAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EffectLevel {
        public static final int FLUID = 2;
        public static final EffectLevel INSTANCE = null;
        public static final int NONE = 0;
        public static final int NORMAL = 1;

        static {
            INSTANCE = new EffectLevel();
        }

        private EffectLevel() {
        }
    }

    /* JADX INFO: compiled from: OMaterial.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/material/OMaterial$RenderSeparateType;", "", "()V", "BACKGROUND", "", "FOREGROUND", "NONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RenderSeparateType {
        public static final int BACKGROUND = 1;
        public static final int FOREGROUND = 2;
        public static final RenderSeparateType INSTANCE = null;
        public static final int NONE = 0;

        static {
            INSTANCE = new RenderSeparateType();
        }

        private RenderSeparateType() {
        }
    }

    /* JADX INFO: compiled from: OMaterial.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/material/OMaterial$RenderViewType;", "", "()V", "BACKGROUND", "", "FOREGROUND", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RenderViewType {
        public static final int BACKGROUND = 0;
        public static final int FOREGROUND = 1;
        public static final RenderViewType INSTANCE = null;

        static {
            INSTANCE = new RenderViewType();
        }

        private RenderViewType() {
        }
    }

    /* JADX INFO: compiled from: OMaterial.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/material/OMaterial$SourceType;", "", "()V", "ANDROID_BACKDROP_WINDOW", "", "BACKDROP_VIEW", "BACKDROP_VIEW_COMPLEX", "BACKDROP_WINDOW", "NONE", "SELF", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SourceType {
        public static final int ANDROID_BACKDROP_WINDOW = 4;
        public static final int BACKDROP_VIEW = 2;
        public static final int BACKDROP_VIEW_COMPLEX = 5;
        public static final int BACKDROP_WINDOW = 3;
        public static final SourceType INSTANCE = null;
        public static final int NONE = 0;
        public static final int SELF = 1;

        static {
            INSTANCE = new SourceType();
        }

        private SourceType() {
        }
    }

    static {
        INSTANCE = new OMaterial();
    }

    private OMaterial() {
    }
}
