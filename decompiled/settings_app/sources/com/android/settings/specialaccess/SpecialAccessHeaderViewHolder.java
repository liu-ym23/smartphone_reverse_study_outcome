package com.android.settings.specialaccess;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public class SpecialAccessHeaderViewHolder extends RecyclerView.ViewHolder {
    final OSectionTitleBar mHeaderText;

    public void setFirstHeader(boolean r1) {
    }

    public SpecialAccessHeaderViewHolder(View r2) {
        super(r2);
        this.mHeaderText = (OSectionTitleBar) r2.findViewById(R.id.header_text);
    }

    public static View newView(ViewGroup r3) {
        return LayoutInflater.from(r3.getContext()).inflate(R.layout.special_access_app_list_header, r3, false);
    }

    public void setHeaderVisible(boolean r1) {
        OSectionTitleBar r0 = this.mHeaderText;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void setEnabled(boolean r1) {
        this.itemView.setEnabled(r1);
    }

    public void setTitle(CharSequence r2, CharSequence r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.mHeaderText.setTitleText(r2);
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return;
    L7:
        this.mHeaderText.setContentDescription(r3);
    }
}
