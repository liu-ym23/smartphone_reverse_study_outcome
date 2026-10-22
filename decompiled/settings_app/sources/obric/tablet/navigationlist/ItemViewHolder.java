package obric.tablet.navigationlist;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.R;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes5.dex */
public class ItemViewHolder extends ViewHolder {
    public static final int TYPE_ITEM_SWITCH = 1;
    public static final int TYPE_ITEM_TEXT = 0;
    View mBindView;
    ColorStateList mContentTextColorList;
    int mId;
    boolean mInEdit;
    int mLeftIconResId;
    String mName;
    int mNameResId;
    private OnItemChangedListener mOnItemChangedListener;
    private CompoundButton.OnCheckedChangeListener mOnSwitchCheckedChangeListener;
    ImageView mRightIcon;
    int mRightIconResId;
    String mRightText;
    boolean mSelected;
    private int mSubContentType;
    TextView mSubTitle;
    SwitchEx mSwitch;
    private boolean mSwitchChecked;

    public interface OnItemChangedListener {
        void onItemChanged(ItemViewHolder r1);
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public boolean canAcceptDragEvent() {
        return true;
    }

    public Bitmap getLeftIcon() {
        return null;
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public int getType() {
        return 0;
    }

    public void startEditName() {
        if (this.mInEdit == true) goto L11;
        this.mInEdit = true;
        View r0 = this.mBindView;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getTag() != this) goto L13;
        bindCommonView(-1, this.mBindView);
        return;
    L13:
        return;
    }

    public void stopEditName() {
        if (this.mInEdit == false) goto L18;
        this.mInEdit = false;
        View r0 = this.mBindView;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getTag() != this) goto L20;
        EditText r1 = (EditText) this.mBindView.findViewById(R.id.content_edit);
        if (r1 == null) goto L16;
        String r2 = r1.getText().toString();
        if (TextUtils.equals(this.mName, r2) == true) goto L16;
        this.mName = r2;
        OnItemChangedListener r3 = this.mOnItemChangedListener;
        if (r3 == null) goto L16;
        r3.onItemChanged(this);
    L16:
        bindCommonView(-1, this.mBindView);
        return;
    L20:
        return;
    }

    public ItemViewHolder(int r2) {
        this.mRightText = "";
        this.mSubContentType = 0;
        this.mId = r2;
    }

    public ItemViewHolder(int r2, int r3, int r4) {
        this.mRightText = "";
        this.mSubContentType = 0;
        this.mId = r2;
        this.mNameResId = r3;
        this.mLeftIconResId = r4;
    }

    public ItemViewHolder(int r2, String r3, int r4) {
        this.mRightText = "";
        this.mSubContentType = 0;
        this.mId = r2;
        this.mName = r3;
        this.mLeftIconResId = r4;
    }

    public ItemViewHolder(int r1, int r2, int r3, String r4) {
        this(r1, r2, r3);
        this.mRightText = r4;
    }

    public ItemViewHolder(int r1, String r2, int r3, String r4) {
        this(r1, r2, r3);
        this.mRightText = r4;
    }

    public ItemViewHolder(int r1, int r2, int r3, ColorStateList r4) {
        this(r1, r2, r3);
        this.mContentTextColorList = r4;
    }

    public ItemViewHolder(int r1, int r2, int r3, int r4) {
        this(r1, r2, r3);
        this.mSubContentType = r4;
    }

    public void setContentTextColorList(ColorStateList r1) {
        this.mContentTextColorList = r1;
    }

    public void setRightText(String r1) {
        this.mRightText = r1;
        View r2 = this.mBindView;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getTag() != this) goto L9;
        this.mSubTitle.setText(this.mRightText);
        return;
    }

    public void setSwitchChecked(boolean r1) {
        this.mSwitchChecked = r1;
        if (this.mSwitch != null) goto L5;
        return;
    L5:
        if (this.mBindView.getTag() != this) goto L9;
        this.mSwitch.setChecked(this.mSwitchChecked);
        return;
    }

    public void setRightIconResId(int r1) {
        this.mRightIconResId = r1;
        ImageView r0 = this.mRightIcon;
        if (r0 == null) goto L6;
        r0.setImageResource(r1);
        return;
    }

    public void setName(String r2) {
        this.mName = r2;
        this.mNameResId = 0;
        View r3 = this.mBindView;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getTag() != this) goto L9;
        ((TextView) this.mBindView.findViewById(R.id.content)).setText(this.mName);
        return;
    }

    public View getBindView() {
        View r0 = this.mBindView;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getTag() == this) goto L7;
        return null;
    L7:
        return this.mBindView;
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public void bindView(int r1, View r2) {
        bindCommonView(r1, r2);
        bindSubContentView(r2);
    }

    protected void bindCommonView(int r5, View r6) {
        this.mBindView = r6;
        ImageView r7 = (ImageView) r6.findViewById(R.id.left_icon);
        int r0 = this.mLeftIconResId;
        if (r0 <= 0) goto L5;
        r7.setImageResource(r0);
    L6:
        TextView r8 = (TextView) r6.findViewById(R.id.content);
        if (this.mNameResId <= 0) goto L9;
        this.mName = r8.getContext().getString(this.mNameResId);
    L9:
        r8.setText(this.mName);
        ColorStateList r1 = this.mContentTextColorList;
        if (r1 == null) goto L12;
        r8.setTextColor(r1);
    L12:
        r6.setActivated(this.mSelected);
        EditText r2 = (EditText) r6.findViewById(R.id.content_edit);
        if (r2 != null) goto L15;
        return;
    L15:
        r2.setText(this.mName);
        if (this.mInEdit == false) goto L18;
        r8.setVisibility(8);
        r2.setVisibility(0);
        r2.requestFocus();
        r2.setSelection(this.mName.length());
        r2.setImeActionLabel(r2.getResources().getText(R.string.btn_done), 6);
        r2.setOnEditorActionListener(new AnonymousClass1(this));
        r6.setBackgroundResource(R.drawable.nav_item_new);
        return;
    L18:
        r8.setVisibility(0);
        r2.setVisibility(8);
        r6.setBackgroundResource(R.drawable.nav_list_item_selector);
        return;
    L5:
        r7.setImageBitmap(getLeftIcon());
        goto L6
    }

    private void bindSubContentView(View r6) {
        TextView r0 = (TextView) r6.findViewById(R.id.sub_content);
        this.mSubTitle = r0;
        int r2 = 0;
        if (this.mSubContentType != 0) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        this.mSubTitle.setText(this.mRightText);
        SwitchEx r3 = (SwitchEx) r6.findViewById(R.id.id_switch_ex);
        this.mSwitch = r3;
        if (this.mSubContentType != 1) goto L9;
        int r4 = 0;
    L10:
        r3.setVisibility(r4);
        this.mSwitch.setChecked(this.mSwitchChecked);
        this.mSwitch.setOnCheckedChangeListener(this.mOnSwitchCheckedChangeListener);
        ImageView r7 = (ImageView) r6.findViewById(R.id.right_icon);
        this.mRightIcon = r7;
        if (this.mRightIconResId > 0) goto L14;
        r2 = 8;
    L14:
        r7.setVisibility(r2);
        int r8 = this.mRightIconResId;
        if (r8 <= 0) goto L18;
        this.mRightIcon.setImageResource(r8);
        return;
    L18:
        return;
    L9:
        r4 = 8;
        goto L10
    L5:
        r1 = 8;
        goto L6
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public View createView(LayoutInflater r2, ViewGroup r3) {
        return r2.inflate(R.layout.nav_list_item_layout, r3, false);
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public void onItemClicked(View r2) {
        this.mSelected = true;
        r2.setActivated(true);
    }

    public void setSelected(boolean r2) {
        this.mSelected = r2;
        View r0 = this.mBindView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getTag() != this) goto L9;
        this.mBindView.setActivated(r2);
        return;
    }

    public void setOnItemChangedListener(OnItemChangedListener r1) {
        this.mOnItemChangedListener = r1;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        this.mOnSwitchCheckedChangeListener = r1;
    }

    public boolean isSelected() {
        return this.mSelected;
    }

    public boolean isInEdit() {
        return this.mInEdit;
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubContentType() {
        return this.mSubContentType;
    }

    public boolean isSwitchChecked() {
        return this.mSwitchChecked;
    }
}
