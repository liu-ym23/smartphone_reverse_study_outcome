package com.android.settings.notification;

import android.content.Context;
import android.net.Uri;
import android.preference.SeekBarVolumizer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import com.android.settings.SeekBarPreference;
import com.obric.olog.OLog;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class VolumeSeekBarPreference extends SeekBarPreference {
    private static final String TAG = "VolumeSeekBarPreference";
    private Callback mCallback;
    private int mIconResId;
    private ImageView mIconView;
    private int mMuteIconResId;
    private boolean mMuted;
    private SeekBar mSeekBar;
    private boolean mStopped;
    private int mStream;
    private String mSuppressionText;
    private TextView mSuppressionTextView;
    private SeekBarVolumizer mVolumizer;
    private boolean mZenMuted;

    public interface Callback {
        void onSampleStarting(SeekBarVolumizer r1);

        void onStreamValueChanged(int r1, int r2);
    }

    static /* synthetic */ Callback access$000(VolumeSeekBarPreference r0) {
        return r0.mCallback;
    }

    static /* synthetic */ int access$100(VolumeSeekBarPreference r0) {
        return r0.mStream;
    }

    static /* synthetic */ boolean access$200(VolumeSeekBarPreference r0) {
        return r0.mMuted;
    }

    static /* synthetic */ boolean access$202(VolumeSeekBarPreference r0, boolean r1) {
        r0.mMuted = r1;
        return r1;
    }

    static /* synthetic */ boolean access$300(VolumeSeekBarPreference r0) {
        return r0.mZenMuted;
    }

    static /* synthetic */ boolean access$302(VolumeSeekBarPreference r0, boolean r1) {
        r0.mZenMuted = r1;
        return r1;
    }

    static /* synthetic */ void access$400(VolumeSeekBarPreference r0) {
        r0.updateIconView();
    }

    public VolumeSeekBarPreference(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        setLayoutResource(R.layout.preference_volume_slider);
    }

    public VolumeSeekBarPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public VolumeSeekBarPreference(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public VolumeSeekBarPreference(Context r2) {
        this(r2, null);
    }

    public void setStream(int r1) {
        this.mStream = r1;
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    public void onActivityResume() {
        if (this.mStopped == false) goto L6;
        init();
        return;
    }

    public void onActivityPause() {
        this.mStopped = true;
        SeekBarVolumizer r1 = this.mVolumizer;
        if (r1 == null) goto L6;
        r1.stop();
        return;
    }

    @Override // com.android.settings.SeekBarPreference, com.android.settingslib.RestrictedPreference, com.android.settingslib.widget.TwoTargetPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        if (this.mStream != 0) goto L6;
        OLog.w(TAG, "No stream found, not binding volumizer");
        return;
    L6:
        this.mSeekBar = (SeekBar) r2.findViewById(android.R.id.time);
        this.mIconView = (ImageView) r2.findViewById(android.R.id.icon);
        this.mSuppressionTextView = (TextView) r2.findViewById(R.id.suppression_text);
        init();
    }

    private void init() {
        if (this.mSeekBar != null) goto L5;
        return;
    L5:
        SeekBarVolumizer.Callback r0 = new AnonymousClass1(this);
        if (this.mStream != 3) goto L8;
        Uri r1 = getMediaVolumeUri();
    L10:
        if (this.mVolumizer != null) goto L12;
        this.mVolumizer = new SeekBarVolumizer(getContext(), this.mStream, r1, r0);
    L12:
        this.mVolumizer.start();
        this.mVolumizer.setSeekBar(this.mSeekBar);
        updateIconView();
        this.mCallback.onStreamValueChanged(this.mStream, this.mSeekBar.getProgress());
        updateSuppressionText();
        if (isEnabled() == true) goto L16;
        this.mSeekBar.setEnabled(false);
        this.mVolumizer.stop();
        return;
    L16:
        return;
    L8:
        r1 = null;
        goto L10
    }

    @Override // com.android.settings.SeekBarPreference, android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        super.onProgressChanged(r1, r2, r3);
        this.mCallback.onStreamValueChanged(this.mStream, r2);
    }

    private void updateIconView() {
        ImageView r0 = this.mIconView;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = this.mIconResId;
        if (r1 == 0) goto L8;
        r0.setImageResource(r1);
        return;
    L8:
        int r2 = this.mMuteIconResId;
        if (r2 != 0) goto L11;
    L15:
        r0.setImageDrawable(getIcon());
        return;
    L11:
        if (this.mMuted == false) goto L15;
        if (this.mZenMuted == true) goto L15;
        r0.setImageResource(r2);
    }

    public void showIcon(int r2) {
        if (this.mIconResId != r2) goto L5;
        return;
    L5:
        this.mIconResId = r2;
        updateIconView();
    }

    public void setMuteIcon(int r2) {
        if (this.mMuteIconResId != r2) goto L5;
        return;
    L5:
        this.mMuteIconResId = r2;
        updateIconView();
    }

    private Uri getMediaVolumeUri() {
        return Uri.parse("android.resource://" + getContext().getPackageName() + "/2131886129");
    }

    public void setSuppressionText(String r2) {
        if (Objects.equals(r2, this.mSuppressionText) == false) goto L5;
        return;
    L5:
        this.mSuppressionText = r2;
        updateSuppressionText();
    }

    private void updateSuppressionText() {
        TextView r0 = this.mSuppressionTextView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mSeekBar == null) goto L16;
        r0.setText(this.mSuppressionText);
        boolean r1 = !TextUtils.isEmpty(this.mSuppressionText);
        TextView r2 = this.mSuppressionTextView;
        int r3 = 0;
        if (r1 == false) goto L9;
        int r4 = 0;
    L10:
        r2.setVisibility(r4);
        SeekBar r5 = this.mSeekBar;
        if (r1 == false) goto L13;
        r3 = 4;
    L13:
        r5.setVisibility(r3);
        return;
    L9:
        r4 = 4;
        goto L10
    }
}
