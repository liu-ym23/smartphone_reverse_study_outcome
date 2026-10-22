package com.obric.oui.picker.reels.pickers;

import androidx.annotation.RequiresApi;
import java.time.DayOfWeek;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
@Metadata
public final class Utils {

    @Metadata
    public final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f257a = null;

        static {
            int[] r0 = new int[DayOfWeek.values().length];
            f257a = r0;
            r0[DayOfWeek.MONDAY.ordinal()] = 1;
            r0[DayOfWeek.TUESDAY.ordinal()] = 2;
            r0[DayOfWeek.WEDNESDAY.ordinal()] = 3;
            r0[DayOfWeek.THURSDAY.ordinal()] = 4;
            r0[DayOfWeek.FRIDAY.ordinal()] = 5;
            r0[DayOfWeek.SATURDAY.ordinal()] = 6;
            r0[DayOfWeek.SUNDAY.ordinal()] = 7;
        }
    }
}
