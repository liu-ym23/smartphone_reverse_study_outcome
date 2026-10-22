package com.obric.oui.material;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: compiled from: MaskMaterialOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/material/MaskMaterialOwner;", "", "applyMaskMaterial", "", "apply", "", "setBackdropTarget", "view", "Landroid/view/View;", "updateBackdropSrcType", "srcType", "", "updateBackdropTargetType", "isBackdropView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MaskMaterialOwner {
    void applyMaskMaterial(boolean r1);

    void setBackdropTarget(View r1);

    void updateBackdropSrcType(int r1);

    void updateBackdropTargetType(boolean r1);
}
