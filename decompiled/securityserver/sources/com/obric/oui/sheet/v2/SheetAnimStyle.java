package com.obric.oui.sheet.v2;

import android.util.Log;
import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SheetAnimStyle {

    @Metadata
    public static final enum HeightLevel extends Enum<HeightLevel> {
        public static final /* synthetic */ HeightLevel[] b = null;

        static {
            b = new HeightLevel[]{new HeightLevel("SMALL", 0), new HeightLevel("MEDIUM", 1), new HeightLevel("LARGE", 2)};
        }

        public static HeightLevel valueOf(String r1) {
            return (HeightLevel) Enum.valueOf(HeightLevel.class, r1);
        }

        public static HeightLevel[] values() {
            return (HeightLevel[]) b.clone();
        }
    }

    static {
    }

    public static final void a(View r2, float r3, float r4, float r5) {
        r2.setAlpha(((r5 - r4) * RangesKt.a(r3, 0.0f, 1.0f)) + r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("SheetAnimStyle", "updateDimViewWithAnim: " + e.getMessage());
    }

    public static final void b(Window r2, float r3, float r4, float r5) {
        r2.setDimAmount(((r5 - r4) * RangesKt.a(r3, 0.0f, 1.0f)) + r4);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w("SheetAnimStyle", "updateWindowDimWithAnim: " + e.getMessage());
    }
}
