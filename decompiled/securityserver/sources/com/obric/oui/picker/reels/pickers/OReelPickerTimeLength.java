package com.obric.oui.picker.reels.pickers;

import a.a;
import androidx.annotation.RequiresApi;
import com.obric.oui.picker.OPicker;
import com.obric.oui.picker.reels.OReelPicker;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(28)
@Metadata
public final class OReelPickerTimeLength implements OPicker<TimeLength> {

    @Metadata
    public static final class Builder implements OReelPickerBuilder<OReelPickerTimeLength, TimeLength> {

        @Metadata
        public final class ReelChangedListener implements OReelPicker.ReelChangedListener {
        }
    }

    @Metadata
    public static final class Reels {
    }

    @Metadata
    public static final class TimeLength {
        public final boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            if ((r1 instanceof TimeLength) == false) goto L6;
            ((TimeLength) r1).getClass();
            return true;
        L6:
            return false;
        }

        public final int hashCode() {
            int r0 = a.c(0, Integer.hashCode(0) * 31, 31);
            return Integer.hashCode(0) + r0;
        }

        public final String toString() {
            return "TimeLength(hour=0, minute=0, second=0)";
        }
    }
}
