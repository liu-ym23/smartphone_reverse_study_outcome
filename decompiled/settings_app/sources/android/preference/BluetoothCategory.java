package android.preference;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothCategory extends androidx.preference.PreferenceCategory {
    private View.OnClickListener mOnClickListener;
    boolean needShowLoadingView;
    boolean needTopPadding;
    private View rootView;
    private boolean showLoadingView;

    public BluetoothCategory(Context r2, boolean r3) {
        super(r2);
        this.showLoadingView = false;
        this.needShowLoadingView = true;
        init(r2, r3, true);
    }

    public BluetoothCategory(Context r2, boolean r3, boolean r4) {
        super(r2);
        this.showLoadingView = false;
        this.needShowLoadingView = true;
        init(r2, r3, r4);
    }

    public BluetoothCategory(Context r2, boolean r3, boolean r4, boolean r5) {
        super(r2);
        this.showLoadingView = false;
        this.needShowLoadingView = true;
        init(r2, r3, r4);
        this.needShowLoadingView = r5;
    }

    private void init(Context r1, boolean r2, boolean r3) {
        this.needTopPadding = r3;
        if (r2 == false) goto L5;
        setLayoutResource(R.layout.bluetooth_lande_preference_category);
        return;
    L5:
        if (r3 == false) goto L7;
        setLayoutResource(R.layout.bluetooth_preference_category);
        return;
    L7:
        setLayoutResource(R.layout.bluetooth_preference_category_new);
    }

    @Override // androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        View r4 = r3.itemView;
        this.rootView = r4;
        if (this.needTopPadding == false) goto L11;
        FrameLayout r0 = (FrameLayout) r4.findViewById(R.id.refresh_container);
        if (r0 == null) goto L11;
        if (this.needShowLoadingView == false) goto L9;
        int r1 = 0;
    L10:
        r0.setVisibility(r1);
        goto L11
    L9:
        r1 = 8;
    L11:
        setupLoadingView(r4);
    }

    public boolean isShowLoadingView() {
        return this.showLoadingView;
    }

    public void showLoadingView(boolean r1) {
        this.showLoadingView = r1;
        View r2 = this.rootView;
        if (r2 == null) goto L6;
        setupLoadingView(r2);
        return;
    }

    private void setupLoadingView(View r5) {
        ODownloadProgressView r0 = (ODownloadProgressView) r5.findViewById(R.id.loading_view);
        OTextView r6 = (OTextView) r5.findViewById(R.id.refresh);
        if (r0 == null) goto L11;
        if (r6 != null) goto L7;
        return;
    L7:
        if (this.showLoadingView == false) goto L9;
        r6.setVisibility(8);
        r0.setVisibility(0);
        return;
    L9:
        r0.setVisibility(8);
        r6.setVisibility(0);
        r6.setOnClickListener(this.mOnClickListener);
        return;
    }

    public void setOnClickListener(View.OnClickListener r1) {
        this.mOnClickListener = r1;
    }
}
