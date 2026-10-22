package com.obric.oui.picker.reels.pickers;

import androidx.annotation.RequiresApi;
import com.obric.oui.picker.OPicker;
import com.obric.oui.picker.reels.OReelPicker;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(28)
@Metadata
public final class OReelCustomPicker implements OPicker<CustomData> {

    @Metadata
    public static final class Builder implements OReelPickerBuilder<OReelCustomPicker, CustomData> {

        @Metadata
        public final class ReelChangedListener implements OReelPicker.ReelChangedListener {
        }
    }

    @Metadata
    public static final class CustomData {
        public final boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            if ((r1 instanceof CustomData) == false) goto L6;
            ((CustomData) r1).getClass();
            return true;
        L6:
            return false;
        }

        public final int hashCode() {
            int r0 = Integer.hashCode(0) * 31;
            return Integer.hashCode(0) + r0;
        }

        public final String toString() {
            return "CustomData(down=0, up=0)";
        }
    }

    @Metadata
    public static final class Reels {
    }
}
