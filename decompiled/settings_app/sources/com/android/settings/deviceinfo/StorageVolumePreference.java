package com.android.settings.deviceinfo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.storage.StorageManager;
import android.os.storage.VolumeInfo;
import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class StorageVolumePreference extends Preference {
    private int mColor;
    private final StorageManager mStorageManager;
    private final View.OnClickListener mUnmountListener;
    private int mUsedPercent;
    private final VolumeInfo mVolume;

    static /* synthetic */ VolumeInfo access$000(StorageVolumePreference r0) {
        return r0.mVolume;
    }

    public StorageVolumePreference(Context r13, VolumeInfo r14, int r15) {
        super(r13);
        this.mUsedPercent = -1;
        this.mUnmountListener = new AnonymousClass1(this);
        StorageManager r1 = (StorageManager) r13.getSystemService(StorageManager.class);
        this.mStorageManager = r1;
        this.mVolume = r14;
        this.mColor = r15;
        setLayoutResource(R.layout.storage_volume);
        setKey(r14.getId());
        setTitle(r1.getBestVolumeDescription(r14));
        if (HeaderConstants.PRIVATE.equals(r14.getId()) == false) goto L5;
        Drawable r16 = r13.getDrawable(R.drawable.ic_settings_storage);
    L7:
        if (r14.isMountedReadable() == false) goto L14;
        File r0 = r14.getPath();
        long r2 = r0.getFreeSpace();
        long r4 = r0.getTotalSpace();
        long r6 = r4 - r2;
        setSummary(r13.getString(R.string.storage_volume_summary, new Object[]{Formatter.formatFileSize(r13, r6).replace('k', 'K'), Formatter.formatFileSize(r13, r4).replace('k', 'K')}));
        if (r4 <= 0) goto L12;
        this.mUsedPercent = (int) ((r6 * 100) / r4);
    L12:
        if (r2 >= r1.getStorageLowBytes(r0)) goto L15;
        this.mColor = StorageSettings.COLOR_WARNING;
        r16 = r13.getDrawable(R.drawable.ic_warning_24dp);
    L15:
        r16.mutate();
        r16.setTint(this.mColor);
        setIcon(r16);
        if (r14.getType() == 0) goto L18;
        return;
    L18:
        if (r14.isMountedReadable() == false) goto L22;
        setWidgetLayoutResource(R.layout.preference_storage_action);
        return;
    L22:
        return;
    L14:
        setSummary(r14.getStateDescription());
        this.mUsedPercent = -1;
        goto L15
    L5:
        r16 = r13.getDrawable(R.drawable.ic_settings_storage);
        goto L7
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r4) {
        ImageView r0 = (ImageView) r4.findViewById(R.id.unmount);
        if (r0 == null) goto L5;
        r0.setImageTintList(ColorStateList.valueOf(Color.parseColor("#8a000000")));
        r0.setOnClickListener(this.mUnmountListener);
    L5:
        ProgressBar r1 = (ProgressBar) r4.findViewById(android.R.id.progress);
        if (this.mVolume.getType() == 1) goto L8;
    L10:
        r1.setVisibility(8);
    L11:
        super.onBindViewHolder(r4);
        return;
    L8:
        if (this.mUsedPercent == (-1)) goto L10;
        r1.setVisibility(0);
        r1.setProgress(this.mUsedPercent);
        r1.setProgressTintList(ColorStateList.valueOf(this.mColor));
        goto L11
    }
}
