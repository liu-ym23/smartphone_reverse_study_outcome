package com.android.settingslib.widget;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.GlobalProxyLancet;
import com.android.settingslib.R;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes.dex */
public class FooterPreference extends Preference {
    private static final String INTENT_URL_PREFIX = "intent:";
    public static final String KEY_FOOTER = "footer_preference";
    static final int ORDER_FOOTER = 2147483646;
    private static final String TAG = "FooterPreference";
    private CharSequence mContentDescription;
    int mIconVisibility;
    View.OnClickListener mLearnMoreListener;
    private FooterLearnMoreSpan mLearnMoreSpan;
    private CharSequence mLearnMoreText;

    public static class Builder {
        private CharSequence mContentDescription;
        private Context mContext;
        private String mKey;
        private CharSequence mLearnMoreText;
        private CharSequence mTitle;

        public Builder(Context r1) {
            this.mContext = r1;
        }

        public Builder setKey(String r1) {
            this.mKey = r1;
            return this;
        }

        public Builder setTitle(CharSequence r1) {
            this.mTitle = r1;
            return this;
        }

        public Builder setTitle(int r2) {
            this.mTitle = this.mContext.getText(r2);
            return this;
        }

        public Builder setContentDescription(CharSequence r1) {
            this.mContentDescription = r1;
            return this;
        }

        public Builder setContentDescription(int r2) {
            this.mContentDescription = this.mContext.getText(r2);
            return this;
        }

        public Builder setLearnMoreText(CharSequence r1) {
            this.mLearnMoreText = r1;
            return this;
        }

        public Builder setLearnMoreText(int r2) {
            this.mLearnMoreText = this.mContext.getText(r2);
            return this;
        }

        public FooterPreference build() {
            FooterPreference r0 = new FooterPreference(this.mContext);
            r0.setSelectable(false);
            if (TextUtils.isEmpty(this.mTitle) == true) goto L15;
            r0.setTitle(this.mTitle);
            if (TextUtils.isEmpty(this.mKey) == true) goto L8;
            r0.setKey(this.mKey);
        L8:
            if (TextUtils.isEmpty(this.mContentDescription) == true) goto L11;
            r0.setContentDescription(this.mContentDescription);
        L11:
            if (TextUtils.isEmpty(this.mLearnMoreText) == true) goto L13;
            r0.setLearnMoreText(this.mLearnMoreText);
        L13:
            return r0;
        L15:
            throw new IllegalArgumentException("Footer title cannot be empty!");
        }
    }

    static class FooterLearnMoreSpan extends URLSpan {
        private final View.OnClickListener mClickListener;

        FooterLearnMoreSpan(View.OnClickListener r2) {
            super("");
            this.mClickListener = r2;
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View r1) {
            View.OnClickListener r0 = this.mClickListener;
            if (r0 == null) goto L6;
            r0.onClick(r1);
            return;
        }
    }

    public FooterPreference(Context r2, AttributeSet r3) {
        super(r2, r3, R.attr.footerPreferenceStyle);
        this.mIconVisibility = 0;
        init();
    }

    public FooterPreference(Context r2) {
        this(r2, null);
    }

    private void linkifyTitle(TextView r10) {
        CharSequence r0 = getTitle();
        if ((r0 instanceof Spanned) == true) goto L5;
        return;
    L5:
        int r4 = 0;
        ClickableSpan[] r1 = (ClickableSpan[]) ((Spanned) r0).getSpans(0, r0.length(), ClickableSpan.class);
        if (r1.length != 0) goto L8;
        return;
    L8:
        SpannableString r2 = new SpannableString(r0);
        int r3 = r1.length;
    L9:
        if (r4 >= r3) goto L24;
        ClickableSpan r5 = r1[r4];
        if ((r5 instanceof URLSpan) == false) goto L23;
        URLSpan r6 = (URLSpan) r5;
        String r7 = r6.getURL();
        if (r7 == null) goto L23;
        if (r7.startsWith(INTENT_URL_PREFIX) == false) goto L23;
        int r8 = r2.getSpanStart(r6);
        int r9 = r2.getSpanEnd(r6);
        r2.removeSpan(r6);
        final Intent r11 = Intent.parseUri(r7, 1);     // Catch: URISyntaxException -> L21
        r2.setSpan(new AnonymousClass1(this, r11), r8, r9, 33);     // Catch: URISyntaxException -> L21
    L21:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Invalid URI " + r7, e);
    L23:
        r4 = r4 + 1;
        goto L9
    L24:
        r10.setText(r2);
        r10.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r6) {
        super.onBindViewHolder(r6);
        TextView r0 = (TextView) r6.itemView.findViewById(android.R.id.title);
        if (r0 != null) goto L5;
    L8:
        TextView r1 = (TextView) r6.itemView.findViewById(R.id.settingslib_learn_more);
        if (r1 != null) goto L11;
    L21:
        View r7 = r6.itemView.findViewById(R.id.icon_frame);
        if (r7 == null) goto L25;
        r7.setVisibility(this.mIconVisibility);
        return;
    L25:
        return;
    L11:
        if (this.mLearnMoreListener == null) goto L20;
        r1.setVisibility(0);
        if (TextUtils.isEmpty(this.mLearnMoreText) == false) goto L15;
        this.mLearnMoreText = r1.getText();
    L16:
        SpannableString r2 = new SpannableString(this.mLearnMoreText);
        FooterLearnMoreSpan r3 = this.mLearnMoreSpan;
        if (r3 == null) goto L19;
        r2.removeSpan(r3);
    L19:
        FooterLearnMoreSpan r4 = new FooterLearnMoreSpan(this.mLearnMoreListener);
        this.mLearnMoreSpan = r4;
        r2.setSpan(r4, 0, r2.length(), 0);
        r1.setText(r2);
        goto L21
    L15:
        r1.setText(this.mLearnMoreText);
        goto L16
    L20:
        r1.setVisibility(8);
        goto L21
    L5:
        if (TextUtils.isEmpty(this.mContentDescription) == true) goto L7;
        r0.setContentDescription(this.mContentDescription);
    L7:
        linkifyTitle(r0);
        goto L8
    }

    @Override // androidx.preference.Preference
    public void setSummary(CharSequence r1) {
        setTitle(r1);
    }

    @Override // androidx.preference.Preference
    public void setSummary(int r1) {
        setTitle(r1);
    }

    @Override // androidx.preference.Preference
    public CharSequence getSummary() {
        return getTitle();
    }

    public void setContentDescription(CharSequence r2) {
        if (TextUtils.equals(this.mContentDescription, r2) == true) goto L6;
        this.mContentDescription = r2;
        notifyChanged();
        return;
    }

    CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public void setLearnMoreText(CharSequence r2) {
        if (TextUtils.equals(this.mLearnMoreText, r2) == true) goto L6;
        this.mLearnMoreText = r2;
        notifyChanged();
        return;
    }

    public void setLearnMoreAction(View.OnClickListener r2) {
        if (this.mLearnMoreListener == r2) goto L6;
        this.mLearnMoreListener = r2;
        notifyChanged();
        return;
    }

    public void setIconVisibility(int r2) {
        if (this.mIconVisibility != r2) goto L5;
        return;
    L5:
        this.mIconVisibility = r2;
        notifyChanged();
    }

    private void init() {
        setLayoutResource(R.layout.preference_footer);
        if (getIcon() != null) goto L5;
        setIcon(R.drawable.settingslib_ic_info_outline_24);
    L5:
        setOrder(ORDER_FOOTER);
        if (TextUtils.isEmpty(getKey()) == false) goto L8;
        setKey(KEY_FOOTER);
    L8:
        setSelectable(false);
    }
}
