package com.obric.oui.forms;

import androidx.appcompat.widget.LinearLayoutCompat;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/forms/OFormItem;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lcom/obric/oui/text/OTextView;", "getLabelView", "()Lcom/obric/oui/text/OTextView;", "Lcom/obric/oui/forms/OInputView;", "getInputView", "()Lcom/obric/oui/forms/OInputView;", "g", "Lcom/obric/oui/forms/OInputView;", "vInput", "f", "Lcom/obric/oui/text/OTextView;", "vLabel", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OFormItem extends LinearLayoutCompat {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OTextView f11021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final OInputView f11022g;

    public final OInputView getInputView() {
        return this.f11022g;
    }

    public final OTextView getLabelView() {
        return this.f11021f;
    }
}
