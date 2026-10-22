package com.qihoo360.mobilesafe.common.ui.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.base.CommonListRowDivider;
import com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog;
import com.qihoo360.mobilesafe.common.ui.row.CommonListRowE1;

/* JADX INFO: loaded from: classes4.dex */
public class CommonDialogListC1 extends CommonDialogNoticeBase implements AdapterView.OnItemClickListener, IDialog.IDialogList {
    protected DialogListAdapter mAdapter;
    private boolean mCheckVisible;
    protected TextUtils.TruncateAt mEllipsize;
    protected AdapterView.OnItemClickListener mItemClickListener;
    protected String[] mItems;
    protected int[] mItemsDrawId;
    protected ListView mListView;

    /* JADX INFO: renamed from: com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogListC1$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class DialogListAdapter extends BaseAdapter {
        final /* synthetic */ CommonDialogListC1 this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private DialogListAdapter(CommonDialogListC1 r1) {
            this.this$0 = r1;
        }

        /* synthetic */ DialogListAdapter(CommonDialogListC1 r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.this$0.mItems != null) goto L6;
            return 0;
        L6:
            return this.this$0.mItems.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            if (this.this$0.mItems != null) goto L6;
            return null;
        L6:
            return this.this$0.mItems[r2];
        }

        @Override // android.widget.Adapter
        public View getView(int r2, View r3, ViewGroup r4) {
            int[] r0 = this.this$0.mItemsDrawId;
            CommonDialogListC1 r1 = this.this$0;
            if (r0 == null) goto L6;
            return CommonDialogListC1.access$100(r1, r2, r3, r4);
        L6:
            return CommonDialogListC1.access$200(r1, r2, r3, r4);
        }
    }

    static /* synthetic */ View access$100(CommonDialogListC1 r0, int r1, View r2, ViewGroup r3) {
        return r0.getListImageRowView(r1, r2, r3);
    }

    static /* synthetic */ View access$200(CommonDialogListC1 r0, int r1, View r2, ViewGroup r3) {
        return r0.getListRowView(r1, r2, r3);
    }

    public CommonDialogListC1(Context r1) {
        super(r1);
        this.mEllipsize = null;
    }

    public CommonDialogListC1(Context r1, CommonDialogNoticeBase.TitleStyle r2) {
        super(r1);
        this.mEllipsize = null;
        setUIDialogTitleStyle(r2);
        setUIDialogButtonStyle(CommonDialogNoticeBase.ButtonStyle.BTN_STYLE_TYPE_NONE);
    }

    public CommonDialogListC1(Context r1, CommonDialogNoticeBase.TitleStyle r2, CommonDialogNoticeBase.ButtonStyle r3) {
        super(r1);
        this.mEllipsize = null;
        setUIDialogTitleStyle(r2);
        setUIDialogButtonStyle(r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.dialog.CommonDialogNoticeBase
    protected void initView() {
        super.initView();
        ListView r0 = new ListView(getContext());
        this.mListView = r0;
        r0.setDivider(null);
        this.mListView.setSelector(R.color.common_transparent);
        DialogListAdapter r1 = new DialogListAdapter(this, null);
        this.mAdapter = r1;
        this.mListView.setAdapter(r1);
        this.mListView.setOnItemClickListener(this);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-1, -2);
        r2.leftMargin = this._20dp;
        r2.rightMargin = this._20dp;
        this.mListView.setLayoutParams(r2);
        setUIDialogCenterView(this.mListView);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogList
    public void setUIDialogListTextEllipsize(TextUtils.TruncateAt r1) {
        this.mEllipsize = r1;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogList
    public void setUIDialogListItems(String[] r1) {
        this.mItems = r1;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogList
    public void setUIDialogListItemsWithImage(String[] r1, int[] r2) {
        this.mItems = r1;
        this.mItemsDrawId = r2;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogList
    public void setUIDialogListRightCheckVisible(boolean r1) {
        this.mCheckVisible = r1;
        if (r1 == false) goto L6;
        this.mListView.setChoiceMode(1);
        return;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogList
    public void setUIDialogListSelectItem(int r3) {
        this.mListView.setItemChecked(r3, true);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.i.dialog.IDialog.IDialogList
    public void setUIDialogListOnItemClickListener(AdapterView.OnItemClickListener r1) {
        this.mItemClickListener = r1;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r7, View r8, int r9, long r10) {
        AdapterView.OnItemClickListener r0 = this.mItemClickListener;
        if (r0 == null) goto L10;
        r0.onItemClick(r7, r8, r9, r10);
        if (this.mCheckVisible == false) goto L11;
        CommonListRowE1 r11 = (CommonListRowE1) r8;
        if (r11 == null) goto L12;
        r11.setUIRightChecked(true);
        setUIDialogListSelectItem(r9);
        return;
    L12:
        return;
    L11:
        return;
    }

    private View getListRowView(int r2, View r3, ViewGroup r4) {
        boolean r5 = false;
        if (r3 != null) goto L5;
        CommonListRowE1 r6 = new CommonListRowE1(getContext());
        r6.setInnerBackgroundResource(R.color.inner_common_transparent);
        r6.setUILeftIconVisible(false);
        r6.setUIDividerType(CommonListRowDivider.DIVIDER_TYPE.TYPE_FULL);
        r6.setUIRightSelectVisible(this.mCheckVisible);
    L6:
        r6.setUIFirstLineText(this.mItems[r2]);
        if (this.mCheckVisible == true) goto L9;
    L15:
        return r6;
    L9:
        if (this.mListView.getCheckedItemPosition() != r2) goto L11;
        r5 = true;
    L11:
        r6.setUIRightChecked(r5);
        if (r2 != getSelectedIdx()) goto L14;
        r6.setContentDescription(this.mItems[r2] + getContext().getString(R.string.common_selected));
        goto L15
    L14:
        r6.setContentDescription(this.mItems[r2] + getContext().getString(R.string.common_unselected));
        goto L15
    L5:
        r6 = (CommonListRowE1) r3;
        goto L6
    }

    private View getListImageRowView(int r2, View r3, ViewGroup r4) {
        boolean r5 = true;
        if (r3 != null) goto L5;
        CommonListRowE1 r6 = new CommonListRowE1(getContext());
        r6.setInnerBackgroundResource(R.color.inner_common_transparent);
        r6.setUILeftIconVisible(true);
        r6.setUIDividerType(CommonListRowDivider.DIVIDER_TYPE.TYPE_FULL);
        r6.setUIRightSelectVisible(this.mCheckVisible);
    L6:
        r6.setUILeftImageResource(this.mItemsDrawId[r2]);
        r6.setUIFirstLineText(this.mItems[r2]);
        if (this.mCheckVisible == true) goto L9;
    L16:
        return r6;
    L9:
        if (this.mListView.getCheckedItemPosition() == r2) goto L12;
        r5 = false;
    L12:
        r6.setUIRightChecked(r5);
        if (r2 != getSelectedIdx()) goto L15;
        r6.setContentDescription(this.mItems[r2] + getContext().getString(R.string.common_selected));
        goto L16
    L15:
        r6.setContentDescription(this.mItems[r2] + getContext().getString(R.string.common_unselected));
        goto L16
    L5:
        r6 = (CommonListRowE1) r3;
        goto L6
    }

    private int getSelectedIdx() {
        return this.mListView.getCheckedItemPosition();
    }
}
