package com.android.settings.deviceinfo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.text.format.Formatter;
import android.widget.ProgressBar;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class StorageItemPreference extends Preference {
    private static final int PROGRESS_MAX = 100;
    public int color;
    private int progress;
    private ProgressBar progressBar;
    public int userHandle;

    public StorageItemPreference(Context r1) {
        super(r1);
        this.progress = -1;
        setLayoutResource(R.layout.storage_item);
    }

    public StorageItemPreference(Context r2, int r3) {
        super(r2);
        this.progress = -1;
        setLayoutResource(R.layout.storage_item_preference);
        if (r3 == 0) goto L5;
        this.color = r2.getResources().getColor(r3);
        Resources r4 = r2.getResources();
        r4.getDimensionPixelSize(R.dimen.device_memory_usage_button_width);
        r4.getDimensionPixelSize(R.dimen.device_memory_usage_button_height);
    L6:
        setSummary(R.string.memory_calculating_size);
        return;
    L5:
        this.color = -65281;
        goto L6
    }

    private static ShapeDrawable createRectShape(int r2, int r3, int r4) {
        ShapeDrawable r0 = new ShapeDrawable(new RectShape());
        r0.setIntrinsicHeight(r3);
        r0.setIntrinsicWidth(r2);
        r0.getPaint().setColor(r4);
        return r0;
    }

    public void setStorageSize(long r7, long r9) {
        if (r7 != 0) goto L5;
        String r2 = String.valueOf(0);
    L6:
        setSummary(r2);
        if (r9 != 0) goto L9;
        this.progress = 0;
    L10:
        updateProgressBar();
        return;
    L9:
        this.progress = (int) ((r7 * 100) / r9);
        goto L10
    L5:
        r2 = Formatter.formatFileSize(getContext(), r7).replace('k', 'K');
        goto L6
    }

    protected void updateProgressBar() {
        ProgressBar r0 = this.progressBar;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.progress != (-1)) goto L9;
        r0.setVisibility(8);
        return;
    L9:
        r0.setVisibility(0);
        this.progressBar.setMax(100);
        this.progressBar.setProgress(this.progress);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        this.progressBar = (ProgressBar) r2.findViewById(android.R.id.progress);
        updateProgressBar();
        super.onBindViewHolder(r2);
    }
}
