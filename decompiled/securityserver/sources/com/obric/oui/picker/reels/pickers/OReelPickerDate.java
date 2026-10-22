package com.obric.oui.picker.reels.pickers;

import a.a;
import androidx.annotation.RequiresApi;
import com.obric.oui.picker.OPicker;
import com.obric.oui.picker.reels.OReelPicker;
import java.time.LocalDate;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
@Metadata
public final class OReelPickerDate implements OPicker<LocalDate> {

    @Metadata
    public static final class Builder implements OReelPickerBuilder<OReelPickerDate, LocalDate> {

        @Metadata
        public final class ReelChangedListener implements OReelPicker.ReelChangedListener {
        }
    }

    @Metadata
    public static final class Reels {
    }

    @Metadata
    public static final class SelectionDate implements Cloneable {
        public final Object clone() {
            Object r1 = super.clone();
            if (r1 == null) goto L7;
            return (SelectionDate) r1;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.picker.reels.pickers.OReelPickerDate.SelectionDate");
        }

        public final boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            if ((r1 instanceof SelectionDate) == false) goto L6;
            ((SelectionDate) r1).getClass();
            return true;
        L6:
            return false;
        }

        public final int hashCode() {
            int r0 = a.c(0, Integer.hashCode(0) * 31, 31);
            return Integer.hashCode(0) + r0;
        }

        public final String toString() {
            return "SelectionDate(year=0, month=0, day=0)";
        }
    }
}
