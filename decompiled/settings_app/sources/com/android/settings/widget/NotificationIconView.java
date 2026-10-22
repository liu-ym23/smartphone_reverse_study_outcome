package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.notificationcustom.QuickWidget;

/* JADX INFO: loaded from: classes.dex */
public class NotificationIconView extends RelativeLayout {
    private ImageView mIcon;
    private TextView mNameView;

    public NotificationIconView(Context r2) {
        super(r2, null);
        init(r2);
    }

    public NotificationIconView(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r1);
    }

    public NotificationIconView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init(r1);
    }

    private void init(Context r3) {
        View r4 = LayoutInflater.from(r3).inflate(R.layout.notification_icon_layout, this, true);
        this.mIcon = (ImageView) r4.findViewById(R.id.icon);
        this.mNameView = (TextView) r4.findViewById(R.id.name);
    }

    public void bindView(QuickWidget r3) {
        this.mIcon.setImageResource(r3.imageResId);
        this.mNameView.setText(r3.title);
        setTag(r3);
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
