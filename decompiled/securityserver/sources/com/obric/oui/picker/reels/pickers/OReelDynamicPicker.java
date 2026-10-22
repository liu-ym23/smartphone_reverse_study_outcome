package com.obric.oui.picker.reels.pickers;

import androidx.annotation.RequiresApi;
import com.obric.oui.picker.OPicker;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(28)
@Metadata
public final class OReelDynamicPicker implements OPicker<PickedData> {

    @Metadata
    public static final class Builder implements OReelPickerBuilder<OReelDynamicPicker, PickedData> {
    }

    @Metadata
    public static final class PickedData {
        public final boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            if ((r1 instanceof PickedData) == true) goto L7;
            return false;
        L7:
            PickedData r2 = (PickedData) r1;
            throw null;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }
}
