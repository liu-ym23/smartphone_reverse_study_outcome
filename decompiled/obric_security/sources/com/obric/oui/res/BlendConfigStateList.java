package com.obric.oui.res;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.oui.color.BlendConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlendConfigStateList.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0000J+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\r\u0010\u0011\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/res/BlendConfigStateList;", "", "core", "Lcom/obric/oui/res/BlendConfigStateListCore;", "(Lcom/obric/oui/res/BlendConfigStateListCore;)V", "deepCopy", "getConfigForState", "", "Lcom/obric/oui/color/BlendConfig;", "stateSet", "", "defaultConfig", "([I[Lcom/obric/oui/color/BlendConfig;)[Lcom/obric/oui/color/BlendConfig;", "getDefaultBlendConfig", "()[Lcom/obric/oui/color/BlendConfig;", "isStateful", "", "toCore", "toCore$OUI_standardRelease", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlendConfigStateList {
    public static final Companion Companion = null;
    private final BlendConfigStateListCore core;

    /* JADX INFO: compiled from: BlendConfigStateList.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\nJm\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0002\u0010\u0013J/\u0010\u000b\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0004H\u0007¢\u0006\u0002\u0010\u0017JD\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0005H\u0007JU\u0010\u0019\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u001eJm\u0010\u001f\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0002\u0010\u0013J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0005H\u0007J\u001b\u0010 \u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"Lcom/obric/oui/res/BlendConfigStateList$Companion;", "", "()V", "getConfigForTransition", "", "Lcom/obric/oui/color/BlendConfig;", "fromConfigs", "toConfigs", "progress", "", "([Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;F)[Lcom/obric/oui/color/BlendConfig;", "of", "Lcom/obric/oui/res/BlendConfigStateList;", "normal", "activated", "checked", "pressed", "hovered", "disabled", "([Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;)Lcom/obric/oui/res/BlendConfigStateList;", "states", "", Constants.KEY_CONFIG, "([[I[[Lcom/obric/oui/color/BlendConfig;)Lcom/obric/oui/res/BlendConfigStateList;", "ofSimple", "ofWithOverlay", "pressedOverlay", "hoveredOverlay", "activatedOverlay", "checkedOverlay", "([Lcom/obric/oui/color/BlendConfig;[Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/color/BlendConfig;Lcom/obric/oui/color/BlendConfig;)Lcom/obric/oui/res/BlendConfigStateList;", "ofWithOverlayArray", "valueOf", "config", "([Lcom/obric/oui/color/BlendConfig;)Lcom/obric/oui/res/BlendConfigStateList;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final BlendConfigStateList of() {
            return of$default(this, null, null, null, null, null, null, 63, null);
        }

        @JvmStatic
        public final BlendConfigStateList of(BlendConfig[] r11) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            return of$default(this, r11, null, null, null, null, null, 62, null);
        }

        @JvmStatic
        public final BlendConfigStateList of(BlendConfig[] r11, BlendConfig[] r12) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "activated");
            return of$default(this, r11, r12, null, null, null, null, 60, null);
        }

        @JvmStatic
        public final BlendConfigStateList of(BlendConfig[] r11, BlendConfig[] r12, BlendConfig[] r13) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "activated");
            Intrinsics.checkNotNullParameter(r13, "checked");
            return of$default(this, r11, r12, r13, null, null, null, 56, null);
        }

        @JvmStatic
        public final BlendConfigStateList of(BlendConfig[] r11, BlendConfig[] r12, BlendConfig[] r13, BlendConfig[] r14) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "activated");
            Intrinsics.checkNotNullParameter(r13, "checked");
            Intrinsics.checkNotNullParameter(r14, "pressed");
            return of$default(this, r11, r12, r13, r14, null, null, 48, null);
        }

        @JvmStatic
        public final BlendConfigStateList of(BlendConfig[] r11, BlendConfig[] r12, BlendConfig[] r13, BlendConfig[] r14, BlendConfig[] r15) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "activated");
            Intrinsics.checkNotNullParameter(r13, "checked");
            Intrinsics.checkNotNullParameter(r14, "pressed");
            Intrinsics.checkNotNullParameter(r15, "hovered");
            return of$default(this, r11, r12, r13, r14, r15, null, 32, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofSimple() {
            return ofSimple$default(this, null, null, null, null, null, null, 63, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofSimple(BlendConfig r11) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            return ofSimple$default(this, r11, null, null, null, null, null, 62, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofSimple(BlendConfig r11, BlendConfig r12) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "activated");
            return ofSimple$default(this, r11, r12, null, null, null, null, 60, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofSimple(BlendConfig r11, BlendConfig r12, BlendConfig r13) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "activated");
            Intrinsics.checkNotNullParameter(r13, "checked");
            return ofSimple$default(this, r11, r12, r13, null, null, null, 56, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofSimple(BlendConfig r11, BlendConfig r12, BlendConfig r13, BlendConfig r14) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "activated");
            Intrinsics.checkNotNullParameter(r13, "checked");
            Intrinsics.checkNotNullParameter(r14, "pressed");
            return ofSimple$default(this, r11, r12, r13, r14, null, null, 48, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofSimple(BlendConfig r11, BlendConfig r12, BlendConfig r13, BlendConfig r14, BlendConfig r15) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "activated");
            Intrinsics.checkNotNullParameter(r13, "checked");
            Intrinsics.checkNotNullParameter(r14, "pressed");
            Intrinsics.checkNotNullParameter(r15, "hovered");
            return ofSimple$default(this, r11, r12, r13, r14, r15, null, 32, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlay() {
            return ofWithOverlay$default(this, null, null, null, null, null, null, 63, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlay(BlendConfig[] r11) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            return ofWithOverlay$default(this, r11, null, null, null, null, null, 62, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlay(BlendConfig[] r11, BlendConfig[] r12) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "disabled");
            return ofWithOverlay$default(this, r11, r12, null, null, null, null, 60, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlay(BlendConfig[] r11, BlendConfig[] r12, BlendConfig r13) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "disabled");
            Intrinsics.checkNotNullParameter(r13, "pressedOverlay");
            return ofWithOverlay$default(this, r11, r12, r13, null, null, null, 56, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlay(BlendConfig[] r11, BlendConfig[] r12, BlendConfig r13, BlendConfig r14) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "disabled");
            Intrinsics.checkNotNullParameter(r13, "pressedOverlay");
            Intrinsics.checkNotNullParameter(r14, "hoveredOverlay");
            return ofWithOverlay$default(this, r11, r12, r13, r14, null, null, 48, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlay(BlendConfig[] r11, BlendConfig[] r12, BlendConfig r13, BlendConfig r14, BlendConfig r15) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "disabled");
            Intrinsics.checkNotNullParameter(r13, "pressedOverlay");
            Intrinsics.checkNotNullParameter(r14, "hoveredOverlay");
            Intrinsics.checkNotNullParameter(r15, "activatedOverlay");
            return ofWithOverlay$default(this, r11, r12, r13, r14, r15, null, 32, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlayArray() {
            return ofWithOverlayArray$default(this, null, null, null, null, null, null, 63, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlayArray(BlendConfig[] r11) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            return ofWithOverlayArray$default(this, r11, null, null, null, null, null, 62, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlayArray(BlendConfig[] r11, BlendConfig[] r12) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "disabled");
            return ofWithOverlayArray$default(this, r11, r12, null, null, null, null, 60, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlayArray(BlendConfig[] r11, BlendConfig[] r12, BlendConfig[] r13) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "disabled");
            Intrinsics.checkNotNullParameter(r13, "pressedOverlay");
            return ofWithOverlayArray$default(this, r11, r12, r13, null, null, null, 56, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlayArray(BlendConfig[] r11, BlendConfig[] r12, BlendConfig[] r13, BlendConfig[] r14) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "disabled");
            Intrinsics.checkNotNullParameter(r13, "pressedOverlay");
            Intrinsics.checkNotNullParameter(r14, "hoveredOverlay");
            return ofWithOverlayArray$default(this, r11, r12, r13, r14, null, null, 48, null);
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlayArray(BlendConfig[] r11, BlendConfig[] r12, BlendConfig[] r13, BlendConfig[] r14, BlendConfig[] r15) {
            Intrinsics.checkNotNullParameter(r11, "normal");
            Intrinsics.checkNotNullParameter(r12, "disabled");
            Intrinsics.checkNotNullParameter(r13, "pressedOverlay");
            Intrinsics.checkNotNullParameter(r14, "hoveredOverlay");
            Intrinsics.checkNotNullParameter(r15, "activatedOverlay");
            return ofWithOverlayArray$default(this, r11, r12, r13, r14, r15, null, 32, null);
        }

        private Companion() {
        }

        @JvmStatic
        public final BlendConfig[] getConfigForTransition(BlendConfig[] r1, BlendConfig[] r2, float r3) {
            Intrinsics.checkNotNullParameter(r1, "fromConfigs");
            Intrinsics.checkNotNullParameter(r2, "toConfigs");
            BlendConfig[] r0 = BlendConfigStateListCore.getConfigForTransition(r1, r2, r3);
            Intrinsics.checkNotNullExpressionValue(r0, "getConfigForTransition(f…igs, toConfigs, progress)");
            return r0;
        }

        @JvmStatic
        public final BlendConfigStateList valueOf(BlendConfig[] r2) {
            Intrinsics.checkNotNullParameter(r2, Constants.KEY_CONFIG);
            BlendConfigStateListCore r3 = BlendConfigStateListCore.valueOf(r2);
            Intrinsics.checkNotNullExpressionValue(r3, "valueOf(configs)");
            return new BlendConfigStateList(r3, null);
        }

        @JvmStatic
        public final BlendConfigStateList valueOf(BlendConfig r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            BlendConfigStateListCore r3 = BlendConfigStateListCore.valueOf(r2);
            Intrinsics.checkNotNullExpressionValue(r3, "valueOf(config)");
            return new BlendConfigStateList(r3, null);
        }

        @JvmStatic
        public final BlendConfigStateList of(int[][] r1, BlendConfig[][] r2) {
            Intrinsics.checkNotNullParameter(r1, "states");
            Intrinsics.checkNotNullParameter(r2, Constants.KEY_CONFIG);
            BlendConfigStateListCore r3 = BlendConfigStateListCore.of(r1, r2);
            Intrinsics.checkNotNullExpressionValue(r3, "of(states, configs)");
            return new BlendConfigStateList(r3, null);
        }

        public static /* synthetic */ BlendConfigStateList of$default(Companion r6, BlendConfig[] r7, BlendConfig[] r8, BlendConfig[] r9, BlendConfig[] r10, BlendConfig[] r11, BlendConfig[] r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L5;
            BlendConfig[] r0 = {BlendConfig.TRANSPARENT};
        L7:
            if ((r13 & 2) == 0) goto L9;
            BlendConfig[] r1 = r0;
        L11:
            if ((r13 & 4) == 0) goto L13;
            BlendConfig[] r2 = r1;
        L15:
            if ((r13 & 8) == 0) goto L17;
            BlendConfig[] r3 = r0;
        L19:
            if ((r13 & 16) == 0) goto L21;
            BlendConfig[] r4 = r0;
        L23:
            if ((r13 & 32) == 0) goto L25;
            BlendConfig[] r5 = r0;
        L27:
            return r6.of(r0, r1, r2, r3, r4, r5);
        L25:
            r5 = r12;
            goto L27
        L21:
            r4 = r11;
            goto L23
        L17:
            r3 = r10;
            goto L19
        L13:
            r2 = r9;
            goto L15
        L9:
            r1 = r8;
            goto L11
        L5:
            r0 = r7;
            goto L7
        }

        @JvmStatic
        public final BlendConfigStateList of(BlendConfig[] r1, BlendConfig[] r2, BlendConfig[] r3, BlendConfig[] r4, BlendConfig[] r5, BlendConfig[] r6) {
            Intrinsics.checkNotNullParameter(r1, "normal");
            Intrinsics.checkNotNullParameter(r2, "activated");
            Intrinsics.checkNotNullParameter(r3, "checked");
            Intrinsics.checkNotNullParameter(r4, "pressed");
            Intrinsics.checkNotNullParameter(r5, "hovered");
            Intrinsics.checkNotNullParameter(r6, "disabled");
            BlendConfigStateListCore r7 = BlendConfigStateListCore.of(r1, r2, r3, r4, r5, r6);
            Intrinsics.checkNotNullExpressionValue(r7, "of(normal, activated, ch…essed, hovered, disabled)");
            return new BlendConfigStateList(r7, null);
        }

        public static /* synthetic */ BlendConfigStateList ofWithOverlay$default(Companion r6, BlendConfig[] r7, BlendConfig[] r8, BlendConfig r9, BlendConfig r10, BlendConfig r11, BlendConfig r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L5;
            BlendConfig[] r0 = {BlendConfig.TRANSPARENT};
        L7:
            if ((r13 & 2) == 0) goto L9;
            BlendConfig[] r1 = r0;
        L11:
            if ((r13 & 4) == 0) goto L13;
            BlendConfig r2 = BlendConfig.TRANSPARENT;
        L15:
            if ((r13 & 8) == 0) goto L17;
            BlendConfig r3 = BlendConfig.TRANSPARENT;
        L19:
            if ((r13 & 16) == 0) goto L21;
            BlendConfig r4 = BlendConfig.TRANSPARENT;
        L23:
            if ((r13 & 32) == 0) goto L25;
            BlendConfig r5 = r4;
        L27:
            return r6.ofWithOverlay(r0, r1, r2, r3, r4, r5);
        L25:
            r5 = r12;
            goto L27
        L21:
            r4 = r11;
            goto L23
        L17:
            r3 = r10;
            goto L19
        L13:
            r2 = r9;
            goto L15
        L9:
            r1 = r8;
            goto L11
        L5:
            r0 = r7;
            goto L7
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlay(BlendConfig[] r1, BlendConfig[] r2, BlendConfig r3, BlendConfig r4, BlendConfig r5, BlendConfig r6) {
            Intrinsics.checkNotNullParameter(r1, "normal");
            Intrinsics.checkNotNullParameter(r2, "disabled");
            Intrinsics.checkNotNullParameter(r3, "pressedOverlay");
            Intrinsics.checkNotNullParameter(r4, "hoveredOverlay");
            Intrinsics.checkNotNullParameter(r5, "activatedOverlay");
            Intrinsics.checkNotNullParameter(r6, "checkedOverlay");
            BlendConfigStateListCore r7 = BlendConfigStateListCore.ofWithOverlay(r1, r2, r3, r4, r5, r6);
            Intrinsics.checkNotNullExpressionValue(r7, "ofWithOverlay(\n         …Overlay\n                )");
            return new BlendConfigStateList(r7, null);
        }

        public static /* synthetic */ BlendConfigStateList ofWithOverlayArray$default(Companion r7, BlendConfig[] r8, BlendConfig[] r9, BlendConfig[] r10, BlendConfig[] r11, BlendConfig[] r12, BlendConfig[] r13, int r14, Object r15) {
            if ((r14 & 1) == 0) goto L5;
            BlendConfig[] r0 = {BlendConfig.TRANSPARENT};
        L7:
            if ((r14 & 2) == 0) goto L9;
            BlendConfig[] r3 = r0;
        L11:
            if ((r14 & 4) == 0) goto L13;
            BlendConfig[] r4 = {BlendConfig.TRANSPARENT};
        L15:
            if ((r14 & 8) == 0) goto L17;
            BlendConfig[] r5 = {BlendConfig.TRANSPARENT};
        L19:
            if ((r14 & 16) == 0) goto L21;
            BlendConfig[] r2 = {BlendConfig.TRANSPARENT};
        L23:
            if ((r14 & 32) == 0) goto L25;
            BlendConfig[] r1 = r2;
        L27:
            return r7.ofWithOverlayArray(r0, r3, r4, r5, r2, r1);
        L25:
            r1 = r13;
            goto L27
        L21:
            r2 = r12;
            goto L23
        L17:
            r5 = r11;
            goto L19
        L13:
            r4 = r10;
            goto L15
        L9:
            r3 = r9;
            goto L11
        L5:
            r0 = r8;
            goto L7
        }

        @JvmStatic
        public final BlendConfigStateList ofWithOverlayArray(BlendConfig[] r1, BlendConfig[] r2, BlendConfig[] r3, BlendConfig[] r4, BlendConfig[] r5, BlendConfig[] r6) {
            Intrinsics.checkNotNullParameter(r1, "normal");
            Intrinsics.checkNotNullParameter(r2, "disabled");
            Intrinsics.checkNotNullParameter(r3, "pressedOverlay");
            Intrinsics.checkNotNullParameter(r4, "hoveredOverlay");
            Intrinsics.checkNotNullParameter(r5, "activatedOverlay");
            Intrinsics.checkNotNullParameter(r6, "checkedOverlay");
            BlendConfigStateListCore r7 = BlendConfigStateListCore.ofWithOverlayArray(r1, r2, r3, r4, r5, r6);
            Intrinsics.checkNotNullExpressionValue(r7, "ofWithOverlayArray(\n    …Overlay\n                )");
            return new BlendConfigStateList(r7, null);
        }

        public static /* synthetic */ BlendConfigStateList ofSimple$default(Companion r4, BlendConfig r5, BlendConfig r6, BlendConfig r7, BlendConfig r8, BlendConfig r9, BlendConfig r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = BlendConfig.TRANSPARENT;
        L6:
            if ((r11 & 2) == 0) goto L8;
            BlendConfig r13 = r5;
        L10:
            if ((r11 & 4) == 0) goto L12;
            BlendConfig r0 = r13;
        L14:
            if ((r11 & 8) == 0) goto L16;
            BlendConfig r1 = r5;
        L18:
            if ((r11 & 16) == 0) goto L20;
            BlendConfig r2 = r5;
        L22:
            if ((r11 & 32) == 0) goto L24;
            BlendConfig r3 = r5;
        L26:
            return r4.ofSimple(r5, r13, r0, r1, r2, r3);
        L24:
            r3 = r10;
            goto L26
        L20:
            r2 = r9;
            goto L22
        L16:
            r1 = r8;
            goto L18
        L12:
            r0 = r7;
            goto L14
        L8:
            r13 = r6;
            goto L10
        }

        @JvmStatic
        public final BlendConfigStateList ofSimple(BlendConfig r1, BlendConfig r2, BlendConfig r3, BlendConfig r4, BlendConfig r5, BlendConfig r6) {
            Intrinsics.checkNotNullParameter(r1, "normal");
            Intrinsics.checkNotNullParameter(r2, "activated");
            Intrinsics.checkNotNullParameter(r3, "checked");
            Intrinsics.checkNotNullParameter(r4, "pressed");
            Intrinsics.checkNotNullParameter(r5, "hovered");
            Intrinsics.checkNotNullParameter(r6, "disabled");
            BlendConfigStateListCore r7 = BlendConfigStateListCore.ofSimple(r1, r2, r3, r4, r5, r6);
            Intrinsics.checkNotNullExpressionValue(r7, "ofSimple(normal, activat…essed, hovered, disabled)");
            return new BlendConfigStateList(r7, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ BlendConfigStateList(BlendConfigStateListCore r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    @JvmStatic
    public static final BlendConfig[] getConfigForTransition(BlendConfig[] r1, BlendConfig[] r2, float r3) {
        return Companion.getConfigForTransition(r1, r2, r3);
    }

    @JvmStatic
    public static final BlendConfigStateList of() {
        return Companion.of();
    }

    @JvmStatic
    public static final BlendConfigStateList of(BlendConfig[] r1) {
        return Companion.of(r1);
    }

    @JvmStatic
    public static final BlendConfigStateList of(BlendConfig[] r1, BlendConfig[] r2) {
        return Companion.of(r1, r2);
    }

    @JvmStatic
    public static final BlendConfigStateList of(BlendConfig[] r1, BlendConfig[] r2, BlendConfig[] r3) {
        return Companion.of(r1, r2, r3);
    }

    @JvmStatic
    public static final BlendConfigStateList of(BlendConfig[] r1, BlendConfig[] r2, BlendConfig[] r3, BlendConfig[] r4) {
        return Companion.of(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final BlendConfigStateList of(BlendConfig[] r6, BlendConfig[] r7, BlendConfig[] r8, BlendConfig[] r9, BlendConfig[] r10) {
        return Companion.of(r6, r7, r8, r9, r10);
    }

    @JvmStatic
    public static final BlendConfigStateList of(BlendConfig[] r7, BlendConfig[] r8, BlendConfig[] r9, BlendConfig[] r10, BlendConfig[] r11, BlendConfig[] r12) {
        return Companion.of(r7, r8, r9, r10, r11, r12);
    }

    @JvmStatic
    public static final BlendConfigStateList of(int[][] r1, BlendConfig[][] r2) {
        return Companion.of(r1, r2);
    }

    @JvmStatic
    public static final BlendConfigStateList ofSimple() {
        return Companion.ofSimple();
    }

    @JvmStatic
    public static final BlendConfigStateList ofSimple(BlendConfig r1) {
        return Companion.ofSimple(r1);
    }

    @JvmStatic
    public static final BlendConfigStateList ofSimple(BlendConfig r1, BlendConfig r2) {
        return Companion.ofSimple(r1, r2);
    }

    @JvmStatic
    public static final BlendConfigStateList ofSimple(BlendConfig r1, BlendConfig r2, BlendConfig r3) {
        return Companion.ofSimple(r1, r2, r3);
    }

    @JvmStatic
    public static final BlendConfigStateList ofSimple(BlendConfig r1, BlendConfig r2, BlendConfig r3, BlendConfig r4) {
        return Companion.ofSimple(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final BlendConfigStateList ofSimple(BlendConfig r6, BlendConfig r7, BlendConfig r8, BlendConfig r9, BlendConfig r10) {
        return Companion.ofSimple(r6, r7, r8, r9, r10);
    }

    @JvmStatic
    public static final BlendConfigStateList ofSimple(BlendConfig r7, BlendConfig r8, BlendConfig r9, BlendConfig r10, BlendConfig r11, BlendConfig r12) {
        return Companion.ofSimple(r7, r8, r9, r10, r11, r12);
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlay() {
        return Companion.ofWithOverlay();
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlay(BlendConfig[] r1) {
        return Companion.ofWithOverlay(r1);
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlay(BlendConfig[] r1, BlendConfig[] r2) {
        return Companion.ofWithOverlay(r1, r2);
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlay(BlendConfig[] r1, BlendConfig[] r2, BlendConfig r3) {
        return Companion.ofWithOverlay(r1, r2, r3);
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlay(BlendConfig[] r1, BlendConfig[] r2, BlendConfig r3, BlendConfig r4) {
        return Companion.ofWithOverlay(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlay(BlendConfig[] r6, BlendConfig[] r7, BlendConfig r8, BlendConfig r9, BlendConfig r10) {
        return Companion.ofWithOverlay(r6, r7, r8, r9, r10);
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlay(BlendConfig[] r7, BlendConfig[] r8, BlendConfig r9, BlendConfig r10, BlendConfig r11, BlendConfig r12) {
        return Companion.ofWithOverlay(r7, r8, r9, r10, r11, r12);
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlayArray() {
        return Companion.ofWithOverlayArray();
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlayArray(BlendConfig[] r1) {
        return Companion.ofWithOverlayArray(r1);
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlayArray(BlendConfig[] r1, BlendConfig[] r2) {
        return Companion.ofWithOverlayArray(r1, r2);
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlayArray(BlendConfig[] r1, BlendConfig[] r2, BlendConfig[] r3) {
        return Companion.ofWithOverlayArray(r1, r2, r3);
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlayArray(BlendConfig[] r1, BlendConfig[] r2, BlendConfig[] r3, BlendConfig[] r4) {
        return Companion.ofWithOverlayArray(r1, r2, r3, r4);
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlayArray(BlendConfig[] r6, BlendConfig[] r7, BlendConfig[] r8, BlendConfig[] r9, BlendConfig[] r10) {
        return Companion.ofWithOverlayArray(r6, r7, r8, r9, r10);
    }

    @JvmStatic
    public static final BlendConfigStateList ofWithOverlayArray(BlendConfig[] r7, BlendConfig[] r8, BlendConfig[] r9, BlendConfig[] r10, BlendConfig[] r11, BlendConfig[] r12) {
        return Companion.ofWithOverlayArray(r7, r8, r9, r10, r11, r12);
    }

    @JvmStatic
    public static final BlendConfigStateList valueOf(BlendConfig r1) {
        return Companion.valueOf(r1);
    }

    @JvmStatic
    public static final BlendConfigStateList valueOf(BlendConfig[] r1) {
        return Companion.valueOf(r1);
    }

    public final BlendConfig[] getConfigForState(int[] r3) {
        Intrinsics.checkNotNullParameter(r3, "stateSet");
        return getConfigForState$default(this, r3, null, 2, null);
    }

    private BlendConfigStateList(BlendConfigStateListCore r1) {
        this.core = r1;
    }

    public final boolean isStateful() {
        return this.core.isStateful();
    }

    public final BlendConfig[] getDefaultBlendConfig() {
        BlendConfig[] r1 = this.core.getDefaultBlendConfig();
        Intrinsics.checkNotNullExpressionValue(r1, "core.defaultBlendConfig");
        return r1;
    }

    public final BlendConfigStateList deepCopy() {
        BlendConfigStateListCore r2 = this.core.deepCopy();
        Intrinsics.checkNotNullExpressionValue(r2, "core.deepCopy()");
        return new BlendConfigStateList(r2);
    }

    public static /* synthetic */ BlendConfig[] getConfigForState$default(BlendConfigStateList r0, int[] r1, BlendConfig[] r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0.getDefaultBlendConfig();
    L6:
        return r0.getConfigForState(r1, r2);
    }

    public final BlendConfig[] getConfigForState(int[] r2, BlendConfig[] r3) {
        Intrinsics.checkNotNullParameter(r2, "stateSet");
        Intrinsics.checkNotNullParameter(r3, "defaultConfig");
        BlendConfig[] r1 = this.core.getConfigForState(r2, r3);
        Intrinsics.checkNotNullExpressionValue(r1, "core.getConfigForState(stateSet, defaultConfig)");
        return r1;
    }

    public final BlendConfigStateListCore toCore$OUI_standardRelease() {
        return this.core;
    }
}
