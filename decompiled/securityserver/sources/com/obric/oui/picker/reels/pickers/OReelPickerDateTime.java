package com.obric.oui.picker.reels.pickers;

import androidx.annotation.RequiresApi;
import com.obric.oui.picker.OPicker;
import com.obric.oui.picker.reels.OReelPicker;
import java.time.LocalDateTime;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(28)
@Metadata
public final class OReelPickerDateTime implements OPicker<LocalDateTime> {

    @Metadata
    public static final class Builder implements OReelPickerBuilder<OReelPickerDateTime, LocalDateTime> {

        @Metadata
        public final class ReelChangedListener implements OReelPicker.ReelChangedListener {
        }
    }

    @Metadata
    public static final class Reels {
    }
}
