package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.bluetooth.BluetoothNumberPicker;

/* JADX INFO: loaded from: classes2.dex */
public final class DataDialogAllItemBinding implements ViewBinding {
    public final Button cancel;
    public final TextView choseDate;
    public final Button confirm;
    public final BluetoothNumberPicker numberPicker;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DataDialogAllItemBinding(LinearLayout r1, Button r2, TextView r3, Button r4, BluetoothNumberPicker r5) {
        this.rootView = r1;
        this.cancel = r2;
        this.choseDate = r3;
        this.confirm = r4;
        this.numberPicker = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DataDialogAllItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DataDialogAllItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.data_dialog_all_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DataDialogAllItemBinding bind(View r8) {
        int r0 = R.id.cancel;
        Button r4 = (Button) ViewBindings.findChildViewById(r8, R.id.cancel);
        if (r4 == null) goto L13;
        r0 = R.id.chose_date;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.chose_date);
        if (r5 == null) goto L13;
        r0 = R.id.confirm;
        Button r6 = (Button) ViewBindings.findChildViewById(r8, R.id.confirm);
        if (r6 == null) goto L13;
        r0 = R.id.number_picker;
        BluetoothNumberPicker r7 = (BluetoothNumberPicker) ViewBindings.findChildViewById(r8, R.id.number_picker);
        if (r7 == null) goto L13;
        return new DataDialogAllItemBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
