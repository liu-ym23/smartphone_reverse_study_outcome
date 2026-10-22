package com.obric.oui.lisitem;

import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OListItemSwitch extends OListItemSettings {
    @NotNull
    public final OSwitch getSwitch() {
        return null;
    }

    public final void setChecked(boolean r1) {
        throw null;
    }

    @Override // com.obric.oui.lisitem.OListItemGeneral, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        throw null;
    }

    public final void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener r1) {
    }
}
