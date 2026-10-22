package com.android.settings.vpn2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import com.android.settings.utils.NullSafe;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public class ManageablePreference23 extends Preference {
    public static int STATE_NONE = -1;
    protected int mBackgroundId;
    private View mBottomView;
    private Drawable mIcon;
    private int mIconRes;
    boolean mIsAlwaysOn;
    private OCardListItem mItemContainer;
    private int mItemCount;
    protected String mItemSubtitle;
    private OSectionTitleBar mItemSubtitleView;
    View.OnClickListener mListener;
    View mManageView;
    int mState;
    private String mSummary;
    private String mTitle;
    private View mView;

    static {
    }

    public ManageablePreference23(Context r2, AttributeSet r3, View.OnClickListener r4) {
        super(r2, r3);
        this.mIsAlwaysOn = false;
        this.mState = STATE_NONE;
        this.mIconRes = 0;
        this.mBackgroundId = 2;
        this.mItemSubtitle = "";
        this.mItemCount = -1;
        this.mListener = r4;
        setPersistent(false);
        setOrder(0);
        setLayoutResource(R.layout.preference_vpn);
        View r5 = LayoutInflater.from(getContext()).inflate(R.layout.preference_vpn, null, false);
        this.mView = r5;
        OCardListItem r6 = (OCardListItem) NullSafe.nonNull(r5.findViewById(R.id.list_item_container));
        this.mItemContainer = r6;
        this.mManageView = r6.getTailIconView();
        this.mItemContainer.setTailIcon(R.drawable.ic_vpn_info);
        this.mManageView.setOnClickListener(this.mListener);
        this.mItemContainer.setTitle(this.mTitle);
        this.mItemContainer.setSubTitle(this.mSummary);
        this.mItemContainer.showSubTitle(true);
        this.mManageView.setTag(this);
        this.mItemContainer.setOnContentClickListener(new ManageablePreference23$$ExternalSyntheticLambda0(this));
        this.mItemSubtitleView = (OSectionTitleBar) NullSafe.nonNull(this.mView.findViewById(R.id.list_item_subtitle));
        this.mBottomView = NullSafe.nonNull(this.mView.findViewById(R.id.layout_bottom));
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settings-vpn2-ManageablePreference23, reason: not valid java name */
    /* synthetic */ void m627lambda$new$0$comandroidsettingsvpn2ManageablePreference23(View r1) {
        Preference.OnPreferenceClickListener r2 = getOnPreferenceClickListener();
        if (r2 == null) goto L6;
        r2.onPreferenceClick(this);
        return;
    }

    public boolean isAlwaysOn() {
        return this.mIsAlwaysOn;
    }

    public void setAlwaysOn(boolean r2) {
        if (this.mIsAlwaysOn == r2) goto L6;
        this.mIsAlwaysOn = r2;
        setSummary(getItemSummary());
        return;
    }

    public int getState() {
        return this.mState;
    }

    public void setState(int r2) {
        if (this.mState == r2) goto L6;
        this.mState = r2;
        setSummary(getItemSummary());
        notifyHierarchyChanged();
        return;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        View r4 = r3.itemView;
        if (r4 == this.mView) goto L5;
        this.mView = r4;
        OCardListItem r0 = (OCardListItem) NullSafe.nonNull(r4.findViewById(R.id.list_item_container));
        this.mItemContainer = r0;
        this.mManageView = r0.getTailIconView();
        this.mItemContainer.setTailIcon(R.drawable.ic_vpn_info);
        this.mManageView.setOnClickListener(this.mListener);
        this.mManageView.setTag(this);
        this.mItemContainer.setOnContentClickListener(new ManageablePreference23$$ExternalSyntheticLambda1(this));
        this.mItemSubtitleView = (OSectionTitleBar) NullSafe.nonNull(this.mView.findViewById(R.id.list_item_subtitle));
        this.mBottomView = NullSafe.nonNull(this.mView.findViewById(R.id.layout_bottom));
    L5:
        setIcon(this.mIcon);
        setBackgroundId(this.mBackgroundId);
        setItemSubtitle(this.mItemSubtitle);
        this.mItemContainer.setTitle(this.mTitle);
        final String r1 = getItemSummary();
        updateSubTitle(r1);
        r4.post(new ManageablePreference23$$ExternalSyntheticLambda2(this, r1));
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$1$com-android-settings-vpn2-ManageablePreference23, reason: not valid java name */
    /* synthetic */ void m628xda394537(View r1) {
        Preference.OnPreferenceClickListener r2 = getOnPreferenceClickListener();
        if (r2 == null) goto L6;
        r2.onPreferenceClick(this);
        return;
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$2$com-android-settings-vpn2-ManageablePreference23, reason: not valid java name */
    /* synthetic */ void m629xcbe2eb56(String r1) {
        setSummary(r1);
    }

    @Override // androidx.preference.Preference
    public void setIcon(int r2) {
        setIcon(getContext().getDrawable(r2));
    }

    @Override // androidx.preference.Preference
    public void setIcon(Drawable r2) {
        this.mIcon = r2;
        this.mItemContainer.setIcon(r2);
        this.mItemContainer.showIcon(true);
    }

    @Override // androidx.preference.Preference
    public void setTitle(CharSequence r2) {
        super.setTitle(r2);
        this.mTitle = r2.toString();
        OCardListItem r1 = this.mItemContainer;
        if (r1 == null) goto L6;
        r1.setTitle(r2.toString());
        return;
    }

    @Override // androidx.preference.Preference
    public void setSummary(CharSequence r2) {
        super.setSummary(r2);
        this.mSummary = r2.toString();
        OCardListItem r0 = this.mItemContainer;
        if (r0 == null) goto L6;
        r0.setSubTitle(r2.toString());
        this.mItemContainer.showSubTitle(true);
        return;
    }

    protected void updateSubTitle(String r2) {
        OCardListItem r0 = this.mItemContainer;
        if (r0 == null) goto L6;
        r0.setSubTitle(r2);
        this.mItemContainer.showSubTitle(true);
        return;
    }

    private String getItemSummary() {
        Resources r0 = getContext().getResources();
        String[] r1 = r0.getStringArray(R.array.vpn_states);
        int r2 = this.mState;
        if (r2 != STATE_NONE) goto L5;
    L8:
        String r3 = "";
    L10:
        if (this.mIsAlwaysOn == false) goto L17;
        String r4 = r0.getString(R.string.vpn_always_on_active_description);
        if (TextUtils.isEmpty(r3) == true) goto L16;
        r4 = r0.getString(R.string.join_two_unrelated_items, new Object[]{r3, r4});
    L16:
        return r4;
    L17:
        return r3;
    L5:
        if (r2 == 5) goto L8;
        r3 = r1[r2];
        goto L10
    }

    public void setBackgroundId(int r6) {
        this.mBackgroundId = r6;
        OCardListItem r0 = this.mItemContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mView != null) goto L7;
        return;
    L7:
        if (this.mBottomView == null) goto L24;
        r0.setCardPosition(r6);
        View r7 = this.mView.findViewById(R.id.layout_gap_top);
        View r1 = this.mView.findViewById(R.id.layout_gap_bottom);
        r7.setVisibility(8);
        r1.setVisibility(8);
        this.mBottomView.setVisibility(8);
        int r2 = this.mBackgroundId;
        if (r2 != 0) goto L12;
        r7.setVisibility(0);
        r1.setVisibility(0);
        return;
    L12:
        if (r2 != 1) goto L15;
        r7.setVisibility(0);
        return;
    L15:
        if (r2 != 3) goto L27;
        r1.setVisibility(0);
        int r8 = this.mItemCount;
        if (r8 != (-1)) goto L19;
        return;
    L19:
        if ((r8 - 1) != getOrder()) goto L29;
        this.mBottomView.setVisibility(0);
        r1.setVisibility(8);
        return;
    L29:
        return;
    L27:
        return;
    }

    public void setItemSubtitle(String r2) {
        this.mItemSubtitle = r2;
        if (this.mItemSubtitleView != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.mItemSubtitleView.setTitleText(this.mItemSubtitle);
        this.mItemSubtitleView.setVisibility(0);
        return;
    L7:
        this.mItemSubtitleView.setVisibility(8);
    }

    public void setItemCount(int r1) {
        this.mItemCount = r1;
    }

    public String printLog() {
        return "" + this.mTitle + "  :" + this.mSummary + "  mBackgroundId:" + this.mBackgroundId;
    }
}
