package com.obric.oui.banner.configs;

import com.obric.oui.window.OWindowConfigController;
import com.obric.oui.window.bean.WindowSizeClass;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridTriptychBannerConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/obric/oui/banner/configs/GridTriptychBannerConfigController;", "", "()V", "getGridTriptychBannerConfig", "Lcom/obric/oui/banner/configs/GridTriptychBannerConfig;", "windowSize", "Lcom/obric/oui/window/bean/WindowSizeClass;", "getTriptychBannerCardWidth", "", "currentWindowSizeClass", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GridTriptychBannerConfigController {
    public static final GridTriptychBannerConfigController INSTANCE = null;

    /* JADX INFO: compiled from: GridTriptychBannerConfig.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[WindowSizeClass.values().length];
            r0[WindowSizeClass.MINUS_ERROR_SIZE.ordinal()] = 1;
            r0[WindowSizeClass.FLOATING_WINDOW.ordinal()] = 2;
            r0[WindowSizeClass.SMALL_SPLIT_SCREEN.ordinal()] = 3;
            r0[WindowSizeClass.SMALLER_ANDROID_SCREEN.ordinal()] = 4;
            r0[WindowSizeClass.SMALL.ordinal()] = 5;
            r0[WindowSizeClass.STANDARD.ordinal()] = 6;
            r0[WindowSizeClass.NORMAL.ordinal()] = 7;
            r0[WindowSizeClass.LARGE.ordinal()] = 8;
            r0[WindowSizeClass.OVERSIZE.ordinal()] = 9;
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new GridTriptychBannerConfigController();
    }

    private GridTriptychBannerConfigController() {
    }

    @JvmStatic
    public static final GridTriptychBannerConfig getGridTriptychBannerConfig(WindowSizeClass r12) {
        Intrinsics.checkNotNullParameter(r12, "windowSize");
        switch(WhenMappings.$EnumSwitchMapping$0[r12.ordinal()]) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L11:
        return new GridTriptychBannerConfig(17.0f, 10, 0, 4, null);
    L12:
        return new GridTriptychBannerConfig(17.0f, 10, 0, 4, null);
    L13:
        return new GridTriptychBannerConfig(16.0f, 6, 0, 4, null);
    L10:
        return new GridTriptychBannerConfig(16.0f, 8, 0, 4, null);
    }

    @JvmStatic
    public static final int getTriptychBannerCardWidth(WindowSizeClass r3) {
        Intrinsics.checkNotNullParameter(r3, "currentWindowSizeClass");
        int r0 = getGridTriptychBannerConfig(r3).getGridSpan();
        return (int) ((r0 * OWindowConfigController.INSTANCE.getBaseGridColumnWidth()) + ((r0 - 1) * r3.getBaseGridConfig().getPageGutter().getGutterDp()));
    }
}
