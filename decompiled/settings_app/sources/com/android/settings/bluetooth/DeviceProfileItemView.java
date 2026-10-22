package com.android.settings.bluetooth;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceProfileItemView extends RelativeLayout {
    private CheckBox checkbox;
    private ImageView icon;
    private ListContentItemSwitch itemSwitch;
    private TextView summary;
    private TextView title;

    public DeviceProfileItemView(Context r1) {
        super(r1);
        initViews(r1);
    }

    public DeviceProfileItemView(Context r1, AttributeSet r2) {
        super(r1, r2);
        initViews(r1);
    }

    public DeviceProfileItemView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        initViews(r1);
    }

    private void initViews(Context r4) {
        this.itemSwitch = (ListContentItemSwitch) LayoutInflater.from(r4).inflate(R.layout.device_profile_item_layout, null, false).findViewById(R.id.profile_item_container);
    }

    public void setTitle(CharSequence r1) {
        this.itemSwitch.setTitle(r1);
    }

    public void setIcon(Drawable r1) {
        this.itemSwitch.setIcon(r1);
    }

    public void setSummary(CharSequence r1) {
        this.itemSwitch.setSummary(r1);
    }

    public void setChecked(boolean r1) {
        this.itemSwitch.getSwitch().setChecked(r1);
    }
}
