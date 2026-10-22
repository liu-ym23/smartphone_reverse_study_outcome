package com.obric.oui.popover.menu;

import a.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OPopoverEntranceMenuView extends OPopoverMenuView {
    public static final int i = 0;
    public static final int j = 0;

    @Metadata
    public static final class Builder {

        @Metadata
        public static final class BadgeInfo {

            @Metadata
            public static final enum Style extends Enum<Style> {
                public static final /* synthetic */ Style[] b = null;

                static {
                    b = new Style[]{new Style("DOT", 0), new Style("NUMBER", 1), new Style("ELLIPSIS", 2)};
                }

                public static Style valueOf(String r1) {
                    return (Style) Enum.valueOf(Style.class, r1);
                }

                public static Style[] values() {
                    return (Style[]) b.clone();
                }
            }
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class PopoverItem {

        @Metadata
        public static final class Companion {
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[Builder.BadgeInfo.Style.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[2] = 3;
        }
    }

    @Metadata
    public static final enum WidthLevel extends Enum<WidthLevel> {
        public static final /* synthetic */ WidthLevel[] b = null;

        static {
            b = new WidthLevel[]{new WidthLevel("WIDTH_LEVEL_STANDARD", 0, OPopoverEntranceMenuView.i), new WidthLevel("WIDTH_LEVEL_BROAD", 1, OPopoverEntranceMenuView.j)};
        }

        public WidthLevel(String r1, int r2, int r3) {
            super(r1, r2);
        }

        public static WidthLevel valueOf(String r1) {
            return (WidthLevel) Enum.valueOf(WidthLevel.class, r1);
        }

        public static WidthLevel[] values() {
            return (WidthLevel[]) b.clone();
        }
    }

    static {
        i = a.d("Resources.getSystem()", 1, 200);
        j = a.d("Resources.getSystem()", 1, 224);
    }

    private final int getAvailableItemWidth() {
        return 0;
    }

    private final int getVerticalPadding() {
        throw null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        if (getMeasuredHeight() <= 0) goto L6;
        setMeasuredDimension(getMeasuredWidth(), 0);
        return;
    }
}
