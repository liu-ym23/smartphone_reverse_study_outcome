package com.obric.oui.res;

import android.R;
import android.util.StateSet;
import com.obric.oui.color.BlendConfig;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class BlendConfigStateListCore {
    private static final int[] NORMAL = null;
    private static final BlendConfig[] TRANSPARENT_CONFIGS = null;
    private final BlendConfig[][] configs;
    private final BlendConfig[] defaultConfig;
    private final int[][] stateSpecs;

    static {
        NORMAL = new int[]{R.attr.state_enabled};
        TRANSPARENT_CONFIGS = new BlendConfig[]{BlendConfig.TRANSPARENT};
    }

    private BlendConfigStateListCore(int[][] r3, BlendConfig[][] r4, BlendConfig[] r5) {
        if (r3.length != r4.length) goto L11;
        if (r3.length == 0) goto L9;
        this.stateSpecs = r3;
        this.configs = r4;
        this.defaultConfig = r5;
        return;
    L9:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    L11:
        throw new IllegalArgumentException("stateSpecs.size(" + r3.length + ") must equal configs.size(" + r4.length + ")");
    }

    public boolean isStateful() {
        int[][] r4 = this.stateSpecs;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].length > 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public BlendConfig[] getDefaultBlendConfig() {
        return this.defaultConfig;
    }

    public BlendConfigStateListCore deepCopy() {
        int[][] r0 = new int[this.stateSpecs.length][];
        int r1 = 0;
        int r2 = 0;
    L3:
        int[][] r3 = this.stateSpecs;
        if (r2 >= r3.length) goto L6;
        int[] r4 = r3[r2];
        r0[r2] = Arrays.copyOf(r4, r4.length);
        r2 = r2 + 1;
        goto L3
    L6:
        BlendConfig[][] r5 = new BlendConfig[this.configs.length][];
    L7:
        BlendConfig[][] r6 = this.configs;
        if (r1 >= r6.length) goto L11;
        r5[r1] = copyBlendConfigs(r6[r1]);
        r1 = r1 + 1;
        goto L7
    L11:
        return new BlendConfigStateListCore(r0, r5, copyBlendConfigs(this.defaultConfig));
    }

    public BlendConfig[] getConfigForState(int[] r2) {
        return getConfigForState(r2, this.defaultConfig);
    }

    public BlendConfig[] getConfigForState(int[] r4, BlendConfig[] r5) {
        int r0 = 0;
    L3:
        int[][] r1 = this.stateSpecs;
        if (r0 >= r1.length) goto L10;
        if (StateSet.stateSetMatches(r1[r0], r4) == true) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return this.configs[r0];
    L10:
        return r5;
    }

    public static BlendConfig[] getConfigForTransition(BlendConfig[] r0, BlendConfig[] r1, float r2) {
        return BlendConfig.lerp(r0, r1, r2);
    }

    public static BlendConfigStateListCore valueOf(BlendConfig[] r5) {
        return new BlendConfigStateListCore(new int[][]{NORMAL}, new BlendConfig[][]{r5}, r5);
    }

    public static BlendConfigStateListCore valueOf(BlendConfig r2) {
        return valueOf(new BlendConfig[]{r2});
    }

    public static BlendConfigStateListCore of(int[][] r3, BlendConfig[][] r4) {
        if (r3.length != r4.length) goto L21;
        if (r3.length == 0) goto L19;
        int r1 = 0;
    L8:
        if (r1 >= r3.length) goto L13;
        if (r3[r1].length == 0) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        BlendConfig[] r2 = r4[r1];
    L14:
        if (r2 != null) goto L17;
        r2 = r4[0];
    L17:
        return new BlendConfigStateListCore(r3, r4, r2);
    L13:
        r2 = null;
        goto L14
    L19:
        throw new IllegalArgumentException("states must not be empty");
    L21:
        throw new IllegalArgumentException("states.size(" + r3.length + ") must equal configs.size(" + r4.length + ")");
    }

    public static BlendConfigStateListCore of() {
        return of(TRANSPARENT_CONFIGS);
    }

    public static BlendConfigStateListCore of(BlendConfig[] r0) {
        return of(r0, r0);
    }

    public static BlendConfigStateListCore of(BlendConfig[] r0, BlendConfig[] r1) {
        return of(r0, r1, r1);
    }

    public static BlendConfigStateListCore of(BlendConfig[] r0, BlendConfig[] r1, BlendConfig[] r2) {
        return of(r0, r1, r2, r0);
    }

    public static BlendConfigStateListCore of(BlendConfig[] r0, BlendConfig[] r1, BlendConfig[] r2, BlendConfig[] r3) {
        return of(r0, r1, r2, r3, r0);
    }

    public static BlendConfigStateListCore of(BlendConfig[] r6, BlendConfig[] r7, BlendConfig[] r8, BlendConfig[] r9, BlendConfig[] r10) {
        return of(r6, r7, r8, r9, r10, r6);
    }

    public static BlendConfigStateListCore of(BlendConfig[] r3, BlendConfig[] r4, BlendConfig[] r5, BlendConfig[] r6, BlendConfig[] r7, BlendConfig[] r8) {
        if (Arrays.equals(r3, r4) == false) goto L15;
        if (Arrays.equals(r3, r5) == false) goto L15;
        if (Arrays.equals(r3, r6) == false) goto L15;
        if (Arrays.equals(r3, r7) == false) goto L15;
        if (Arrays.equals(r3, r8) == false) goto L15;
        return valueOf(r3);
    L15:
        return new BlendConfigStateListCore(getMaterialStateSpecs(), new BlendConfig[][]{r5, r5, r4, r4, r6, r7, r5, r4, r8, r3}, r3);
    }

    public static BlendConfigStateListCore ofWithOverlay() {
        return ofWithOverlay(TRANSPARENT_CONFIGS);
    }

    public static BlendConfigStateListCore ofWithOverlay(BlendConfig[] r0) {
        return ofWithOverlay(r0, r0);
    }

    public static BlendConfigStateListCore ofWithOverlay(BlendConfig[] r1, BlendConfig[] r2) {
        return ofWithOverlay(r1, r2, BlendConfig.TRANSPARENT);
    }

    public static BlendConfigStateListCore ofWithOverlay(BlendConfig[] r1, BlendConfig[] r2, BlendConfig r3) {
        return ofWithOverlay(r1, r2, r3, BlendConfig.TRANSPARENT);
    }

    public static BlendConfigStateListCore ofWithOverlay(BlendConfig[] r1, BlendConfig[] r2, BlendConfig r3, BlendConfig r4) {
        return ofWithOverlay(r1, r2, r3, r4, BlendConfig.TRANSPARENT);
    }

    public static BlendConfigStateListCore ofWithOverlay(BlendConfig[] r6, BlendConfig[] r7, BlendConfig r8, BlendConfig r9, BlendConfig r10) {
        return ofWithOverlay(r6, r7, r8, r9, r10, r10);
    }

    public static BlendConfigStateListCore ofWithOverlay(BlendConfig[] r4, BlendConfig[] r5, BlendConfig r6, BlendConfig r7, BlendConfig r8, BlendConfig r9) {
        BlendConfig r0 = new BlendConfig(0, r6.getBlendMode());
        BlendConfig[] r1 = append(r4, r0);
        BlendConfig[] r10 = append(r5, r0);
        BlendConfig[] r11 = append(r4, r8);
        BlendConfig[] r12 = append(r4, r9);
        BlendConfig[] r13 = append(r4, r6);
        BlendConfig[] r14 = append(r4, r7);
        return new BlendConfigStateListCore(getMaterialStateSpecs(), new BlendConfig[][]{r12, r12, r11, r11, r13, r14, r12, r11, r10, r1}, r4);
    }

    public static BlendConfigStateListCore ofWithOverlayArray() {
        return ofWithOverlayArray(TRANSPARENT_CONFIGS);
    }

    public static BlendConfigStateListCore ofWithOverlayArray(BlendConfig[] r0) {
        return ofWithOverlayArray(r0, r0);
    }

    public static BlendConfigStateListCore ofWithOverlayArray(BlendConfig[] r1, BlendConfig[] r2) {
        return ofWithOverlayArray(r1, r2, TRANSPARENT_CONFIGS);
    }

    public static BlendConfigStateListCore ofWithOverlayArray(BlendConfig[] r1, BlendConfig[] r2, BlendConfig[] r3) {
        return ofWithOverlayArray(r1, r2, r3, TRANSPARENT_CONFIGS);
    }

    public static BlendConfigStateListCore ofWithOverlayArray(BlendConfig[] r1, BlendConfig[] r2, BlendConfig[] r3, BlendConfig[] r4) {
        return ofWithOverlayArray(r1, r2, r3, r4, TRANSPARENT_CONFIGS);
    }

    public static BlendConfigStateListCore ofWithOverlayArray(BlendConfig[] r6, BlendConfig[] r7, BlendConfig[] r8, BlendConfig[] r9, BlendConfig[] r10) {
        return ofWithOverlayArray(r6, r7, r8, r9, r10, r10);
    }

    public static BlendConfigStateListCore ofWithOverlayArray(BlendConfig[] r6, BlendConfig[] r7, BlendConfig[] r8, BlendConfig[] r9, BlendConfig[] r10, BlendConfig[] r11) {
        int r0 = Math.max(Math.max(r8.length, r9.length), Math.max(r10.length, r11.length));
        BlendConfig[] r12 = normalizeOverlay(r8, r0);
        BlendConfig[] r13 = normalizeOverlay(r9, r0);
        BlendConfig[] r14 = normalizeOverlay(r10, r0);
        BlendConfig[] r15 = normalizeOverlay(r11, r0);
        BlendConfig[] r1 = new BlendConfig[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = new BlendConfig(0, r12[r3].getBlendMode());
        r3 = r3 + 1;
        goto L3
    L5:
        BlendConfig[] r2 = append(r6, r1);
        BlendConfig[] r16 = append(r7, r1);
        BlendConfig[] r17 = append(r6, r14);
        BlendConfig[] r18 = append(r6, r15);
        return new BlendConfigStateListCore(getMaterialStateSpecs(), new BlendConfig[][]{r18, r18, r17, r17, append(r6, r12), append(r6, r13), r18, r17, r16, r2}, r2);
    }

    public static BlendConfigStateListCore ofSimple() {
        return ofSimple(BlendConfig.TRANSPARENT);
    }

    public static BlendConfigStateListCore ofSimple(BlendConfig r0) {
        return ofSimple(r0, r0);
    }

    public static BlendConfigStateListCore ofSimple(BlendConfig r0, BlendConfig r1) {
        return ofSimple(r0, r1, r1);
    }

    public static BlendConfigStateListCore ofSimple(BlendConfig r0, BlendConfig r1, BlendConfig r2) {
        return ofSimple(r0, r1, r2, r0);
    }

    public static BlendConfigStateListCore ofSimple(BlendConfig r0, BlendConfig r1, BlendConfig r2, BlendConfig r3) {
        return ofSimple(r0, r1, r2, r3, r0);
    }

    public static BlendConfigStateListCore ofSimple(BlendConfig r6, BlendConfig r7, BlendConfig r8, BlendConfig r9, BlendConfig r10) {
        return ofSimple(r6, r7, r8, r9, r10, r6);
    }

    public static BlendConfigStateListCore ofSimple(BlendConfig r7, BlendConfig r8, BlendConfig r9, BlendConfig r10, BlendConfig r11, BlendConfig r12) {
        return of(new BlendConfig[]{r7}, new BlendConfig[]{r8}, new BlendConfig[]{r9}, new BlendConfig[]{r10}, new BlendConfig[]{r11}, new BlendConfig[]{r12});
    }

    private static BlendConfig[] normalizeOverlay(BlendConfig[] r3, int r4) {
        if (r3.length != r4) goto L5;
        return r3;
    L5:
        BlendConfig[] r0 = new BlendConfig[r4];
        int r1 = 0;
    L6:
        if (r1 >= r4) goto L12;
        if (r1 >= r3.length) goto L10;
        BlendConfig r2 = r3[r1];
    L11:
        r0[r1] = r2;
        r1 = r1 + 1;
        goto L6
    L10:
        r2 = BlendConfig.TRANSPARENT;
        goto L11
    L12:
        return r0;
    }

    private static int[][] getMaterialStateSpecs() {
        return new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    private static BlendConfig[] append(BlendConfig[] r1, BlendConfig r2) {
        BlendConfig[] r0 = (BlendConfig[]) Arrays.copyOf(r1, r1.length + 1);
        r0[r1.length] = r2;
        return r0;
    }

    private static BlendConfig[] append(BlendConfig[] r3, BlendConfig[] r4) {
        BlendConfig[] r0 = (BlendConfig[]) Arrays.copyOf(r3, r3.length + r4.length);
        System.arraycopy(r4, 0, r0, r3.length, r4.length);
        return r0;
    }

    private static BlendConfig[] copyBlendConfigs(BlendConfig[] r3) {
        BlendConfig[] r0 = new BlendConfig[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0[r1] = r3[r1].copy();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
