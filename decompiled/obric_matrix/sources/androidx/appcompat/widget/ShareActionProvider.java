package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ActionProvider;

/* JADX INFO: loaded from: classes.dex */
public class ShareActionProvider extends ActionProvider {
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    final Context mContext;
    private int mMaxShownActivityCount;
    private ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener;
    OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    String mShareHistoryFileName;

    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider r1, Intent r2);
    }

    private class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
        final /* synthetic */ ShareActionProvider this$0;

        ShareActivityChooserModelPolicy(ShareActionProvider r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean onChooseActivity(ActivityChooserModel r1, Intent r2) {
            ShareActionProvider r0 = this.this$0;
            OnShareTargetSelectedListener r3 = r0.mOnShareTargetSelectedListener;
            if (r3 == null) goto L7;
            r3.onShareTargetSelected(r0, r2);
            return false;
        L7:
            return false;
        }
    }

    private class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ShareActionProvider this$0;

        ShareMenuItemOnMenuItemClickListener(ShareActionProvider r1) {
            this.this$0 = r1;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r3) {
            ShareActionProvider r0 = this.this$0;
            Intent r4 = ActivityChooserModel.get(r0.mContext, r0.mShareHistoryFileName).chooseActivity(r3.getItemId());
            if (r4 == null) goto L12;
            String r1 = r4.getAction();
            if ("android.intent.action.SEND".equals(r1) == false) goto L7;
        L8:
            this.this$0.updateIntent(r4);
        L9:
            this.this$0.mContext.startActivity(r4);
            return true;
        L7:
            if ("android.intent.action.SEND_MULTIPLE".equals(r1) == false) goto L9;
        L12:
            return true;
        }
    }

    public ShareActionProvider(Context r2) {
        super(r2);
        this.mMaxShownActivityCount = 4;
        this.mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener(this);
        this.mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.mContext = r2;
    }

    private void setActivityChooserPolicyIfNeeded() {
        if (this.mOnShareTargetSelectedListener != null) goto L6;
        return;
    L6:
        if (this.mOnChooseActivityListener != null) goto L8;
        this.mOnChooseActivityListener = new ShareActivityChooserModelPolicy(this);
    L8:
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
    }

    @Override // androidx.core.view.ActionProvider
    public boolean hasSubMenu() {
        return true;
    }

    @Override // androidx.core.view.ActionProvider
    public View onCreateActionView() {
        ActivityChooserView r0 = new ActivityChooserView(this.mContext);
        if (r0.isInEditMode() == true) goto L5;
        r0.setActivityChooserModel(ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName));
    L5:
        TypedValue r1 = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, r1, true);
        r0.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.mContext, r1.resourceId));
        r0.setProvider(this);
        r0.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        r0.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return r0;
    }

    @Override // androidx.core.view.ActionProvider
    public void onPrepareSubMenu(SubMenu r9) {
        r9.clear();
        ActivityChooserModel r0 = ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName);
        PackageManager r1 = this.mContext.getPackageManager();
        int r2 = r0.getActivityCount();
        int r3 = Math.min(r2, this.mMaxShownActivityCount);
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        ResolveInfo r6 = r0.getActivity(r5);
        r9.add(0, r5, r5, r6.loadLabel(r1)).setIcon(r6.loadIcon(r1)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        r5 = r5 + 1;
        goto L3
    L5:
        if (r3 >= r2) goto L9;
        SubMenu r10 = r9.addSubMenu(0, r3, r3, this.mContext.getString(R.string.abc_activity_chooser_view_see_all));
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L12;
        ResolveInfo r7 = r0.getActivity(r4);
        r10.add(0, r4, r4, r7.loadLabel(r1)).setIcon(r7.loadIcon(r1)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        r4 = r4 + 1;
        goto L7
    L12:
        return;
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener r1) {
        this.mOnShareTargetSelectedListener = r1;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(String r1) {
        this.mShareHistoryFileName = r1;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent r3) {
        if (r3 == null) goto L8;
        String r0 = r3.getAction();
        if ("android.intent.action.SEND".equals(r0) == false) goto L6;
    L7:
        updateIntent(r3);
        goto L8
    L6:
        if ("android.intent.action.SEND_MULTIPLE".equals(r0) == true) goto L7;
    L8:
        ActivityChooserModel.get(this.mContext, this.mShareHistoryFileName).setIntent(r3);
    }

    void updateIntent(Intent r2) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        int r1 = 134742016;
    L6:
        r2.addFlags(r1);
        return;
    L5:
        r1 = 524288;
        goto L6
    }
}
