package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = null;
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = -1;
    private static final String TAG = "AppCompatSpinner";
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private SpinnerPopup mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    @VisibleForTesting
    public class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        private ListAdapter mListAdapter;

        @VisibleForTesting
        AlertDialog mPopup;
        private CharSequence mPrompt;
        final /* synthetic */ AppCompatSpinner this$0;

        public DialogPopup(AppCompatSpinner r1) {
            this.this$0 = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void dismiss() {
            AlertDialog r0 = this.mPopup;
            if (r0 == null) goto L6;
            r0.dismiss();
            this.mPopup = null;
            return;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            return this.mPrompt;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public boolean isShowing() {
            AlertDialog r0 = this.mPopup;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isShowing();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r4, int r5) {
            this.this$0.setSelection(r5);
            if (this.this$0.getOnItemClickListener() == null) goto L5;
            this.this$0.performItemClick(null, r5, this.mListAdapter.getItemId(r5));
        L5:
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r1) {
            this.mListAdapter = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setBackgroundDrawable(Drawable r1) {
            Log.e(AppCompatSpinner.TAG, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOffset(int r1) {
            Log.e(AppCompatSpinner.TAG, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int r1) {
            Log.e(AppCompatSpinner.TAG, "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence r1) {
            this.mPrompt = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setVerticalOffset(int r1) {
            Log.e(AppCompatSpinner.TAG, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int r4, int r5) {
            if (this.mListAdapter != null) goto L5;
            return;
        L5:
            AlertDialog.Builder r0 = new AlertDialog.Builder(this.this$0.getPopupContext());
            CharSequence r1 = this.mPrompt;
            if (r1 == null) goto L8;
            r0.setTitle(r1);
        L8:
            AlertDialog r2 = r0.setSingleChoiceItems(this.mListAdapter, this.this$0.getSelectedItemPosition(), this).create();
            this.mPopup = r2;
            ListView r3 = r2.getListView();
            r3.setTextDirection(r4);
            r3.setTextAlignment(r5);
            this.mPopup.show();
        }
    }

    public static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter mAdapter;
        private ListAdapter mListAdapter;

        public DropDownAdapter(@Nullable SpinnerAdapter r2, @Nullable Resources.Theme r3) {
            this.mAdapter = r2;
            if ((r2 instanceof ListAdapter) == false) goto L5;
            this.mListAdapter = (ListAdapter) r2;
        L5:
            if (r3 != null) goto L7;
            return;
        L7:
            if ((r2 instanceof android.widget.ThemedSpinnerAdapter) == false) goto L12;
            android.widget.ThemedSpinnerAdapter r4 = (android.widget.ThemedSpinnerAdapter) r2;
            if (r4.getDropDownViewTheme() == r3) goto L18;
            r4.setDropDownViewTheme(r3);
            return;
        L18:
            return;
        L12:
            if ((r2 instanceof ThemedSpinnerAdapter) == false) goto L20;
            ThemedSpinnerAdapter r5 = (ThemedSpinnerAdapter) r2;
            if (r5.getDropDownViewTheme() != null) goto L21;
            r5.setDropDownViewTheme(r3);
            return;
        L21:
            return;
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter r0 = this.mListAdapter;
            if (r0 != null) goto L5;
            return true;
        L5:
            return r0.areAllItemsEnabled();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int r1, View r2, ViewGroup r3) {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.getDropDownView(r1, r2, r3);
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.getItem(r1);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 != null) goto L6;
            return -1;
        L6:
            return r0.getItemId(r1);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int r1) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int r1, View r2, ViewGroup r3) {
            return getDropDownView(r1, r2, r3);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.hasStableIds() == false) goto L7;
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            if (getCount() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int r1) {
            ListAdapter r0 = this.mListAdapter;
            if (r0 != null) goto L5;
            return true;
        L5:
            return r0.isEnabled(r1);
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver r1) {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 == null) goto L6;
            r0.registerDataSetObserver(r1);
            return;
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver r1) {
            SpinnerAdapter r0 = this.mAdapter;
            if (r0 == null) goto L6;
            r0.unregisterDataSetObserver(r1);
            return;
        }
    }

    @VisibleForTesting
    public class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        ListAdapter mAdapter;
        private CharSequence mHintText;
        private int mOriginalHorizontalOffset;
        private final Rect mVisibleRect;
        final /* synthetic */ AppCompatSpinner this$0;

        public DropdownPopup(final AppCompatSpinner r1, Context r2, AttributeSet r3, int r4) {
            this.this$0 = r1;
            super(r2, r3, r4);
            this.mVisibleRect = new Rect();
            setAnchorView(r1);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new AnonymousClass1(this, r1));
        }

        public static /* synthetic */ void access$001(DropdownPopup r0) {
            super.show();
        }

        public void computeContentWidth() {
            Drawable r0 = getBackground();
            if (r0 == null) goto L8;
            r0.getPadding(this.this$0.mTempRect);
            if (ViewUtils.isLayoutRtl(this.this$0) == false) goto L7;
            int r1 = this.this$0.mTempRect.right;
        L9:
            int r2 = this.this$0.getPaddingLeft();
            int r3 = this.this$0.getPaddingRight();
            int r4 = this.this$0.getWidth();
            AppCompatSpinner r5 = this.this$0;
            int r6 = r5.mDropDownWidth;
            if (r6 != (-2)) goto L16;
            int r7 = r5.compatMeasureContentWidth((SpinnerAdapter) this.mAdapter, getBackground());
            int r8 = this.this$0.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect r9 = this.this$0.mTempRect;
            int r10 = (r8 - r9.left) - r9.right;
            if (r7 <= r10) goto L14;
            r7 = r10;
        L14:
            setContentWidth(Math.max(r7, (r4 - r2) - r3));
        L20:
            if (ViewUtils.isLayoutRtl(this.this$0) == false) goto L22;
            int r11 = (((r4 - r3) - getWidth()) - getHorizontalOriginalOffset()) + r1;
        L23:
            setHorizontalOffset(r11);
            return;
        L22:
            r11 = (r2 + getHorizontalOriginalOffset()) + r1;
            goto L23
        L16:
            if (r6 != (-1)) goto L18;
            setContentWidth((r4 - r2) - r3);
            goto L20
        L18:
            setContentWidth(r6);
            goto L20
        L7:
            r1 = -this.this$0.mTempRect.left;
            goto L9
        L8:
            Rect r12 = this.this$0.mTempRect;
            r12.right = 0;
            r12.left = 0;
            r1 = 0;
            goto L9
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public CharSequence getHintText() {
            return this.mHintText;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public int getHorizontalOriginalOffset() {
            return this.mOriginalHorizontalOffset;
        }

        public boolean isVisibleToUser(View r2) {
            if (ViewCompat.isAttachedToWindow(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (r2.getGlobalVisibleRect(this.mVisibleRect) == false) goto L7;
            return true;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setAdapter(ListAdapter r1) {
            super.setAdapter(r1);
            this.mAdapter = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setHorizontalOriginalOffset(int r1) {
            this.mOriginalHorizontalOffset = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void setPromptText(CharSequence r1) {
            this.mHintText = r1;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public void show(int r4, int r5) {
            boolean r0 = isShowing();
            computeContentWidth();
            setInputMethodMode(2);
            super.show();
            ListView r1 = getListView();
            r1.setChoiceMode(1);
            r1.setTextDirection(r4);
            r1.setTextAlignment(r5);
            setSelection(this.this$0.getSelectedItemPosition());
            if (r0 == false) goto L5;
            return;
        L5:
            ViewTreeObserver r6 = this.this$0.getViewTreeObserver();
            if (r6 == null) goto L9;
            final ViewTreeObserver.OnGlobalLayoutListener r7 = new AnonymousClass2(this);
            r6.addOnGlobalLayoutListener(r7);
            setOnDismissListener(new AnonymousClass3(this, r7));
            return;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mShowDropdown;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeByte(this.mShowDropdown ? 1 : 0);
        }

        public SavedState(Parcel r1) {
            super(r1);
            if (r1.readByte() == 0) goto L5;
            boolean r2 = true;
        L6:
            this.mShowDropdown = r2;
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    @VisibleForTesting
    public interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getHorizontalOriginalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter r1);

        void setBackgroundDrawable(Drawable r1);

        void setHorizontalOffset(int r1);

        void setHorizontalOriginalOffset(int r1);

        void setPromptText(CharSequence r1);

        void setVerticalOffset(int r1);

        void show(int r1, int r2);
    }

    static {
        ATTRS_ANDROID_SPINNERMODE = new int[]{R.attr.spinnerMode};
    }

    public AppCompatSpinner(@NonNull Context r2) {
        this(r2, null);
    }

    public int compatMeasureContentWidth(SpinnerAdapter r11, Drawable r12) {
        int r0 = 0;
        if (r11 != null) goto L5;
        return 0;
    L5:
        int r1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int r2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int r3 = Math.max(0, getSelectedItemPosition());
        int r4 = Math.min(r11.getCount(), r3 + 15);
        int r6 = Math.max(0, r3 - (15 - (r4 - r3)));
        View r7 = null;
        int r5 = 0;
    L6:
        if (r6 >= r4) goto L14;
        int r8 = r11.getItemViewType(r6);
        if (r8 == r0) goto L10;
        r7 = null;
        r0 = r8;
    L10:
        r7 = r11.getView(r6, r7, this);
        if (r7.getLayoutParams() != null) goto L13;
        r7.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    L13:
        r7.measure(r1, r2);
        r5 = Math.max(r5, r7.getMeasuredWidth());
        r6 = r6 + 1;
        goto L6
    L14:
        if (r12 == null) goto L20;
        r12.getPadding(this.mTempRect);
        Rect r10 = this.mTempRect;
        return r5 + (r10.left + r10.right);
    L20:
        return r5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.applySupportBackgroundTint();
        return;
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L7;
        return r0.getHorizontalOffset();
    L7:
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L7;
        return r0.getVerticalOffset();
    L7:
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.mPopup == null) goto L7;
        return this.mDropDownWidth;
    L7:
        return super.getDropDownWidth();
    }

    @VisibleForTesting
    public final SpinnerPopup getInternalPopup() {
        return this.mPopup;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L7;
        return r0.getBackground();
    L7:
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L6;
        return r0.getHintText();
    L6:
        return super.getPrompt();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup r0 = this.mPopup;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mPopup.dismiss();
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        if (this.mPopup != null) goto L5;
        return;
    L5:
        if (View.MeasureSpec.getMode(r3) != Integer.MIN_VALUE) goto L9;
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(r3)), getMeasuredHeight());
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        if (r3.mShowDropdown == false) goto L8;
        ViewTreeObserver r4 = getViewTreeObserver();
        if (r4 == null) goto L9;
        r4.addOnGlobalLayoutListener(new AnonymousClass2(this));
        return;
    L9:
        return;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        SpinnerPopup r2 = this.mPopup;
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        r0.mShowDropdown = r3;
        return r0;
    L5:
        if (r2.isShowing() == false) goto L7;
        r3 = true;
        goto L8
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        ForwardingListener r0 = this.mForwardingListener;
        if (r0 == null) goto L9;
        if (r0.onTouch(this, r2) == false) goto L9;
        return true;
    L9:
        return super.onTouchEvent(r2);
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L10;
        if (r0.isShowing() == true) goto L11;
        showPopup();
        return true;
    L11:
        return true;
    L10:
        return super.performClick();
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r1) {
        setAdapter((SpinnerAdapter) r1);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r1) {
        super.setBackgroundDrawable(r1);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundDrawable(r1);
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int r1) {
        super.setBackgroundResource(r1);
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.onSetBackgroundResource(r1);
        return;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int r2) {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L5;
        r0.setHorizontalOriginalOffset(r2);
        this.mPopup.setHorizontalOffset(r2);
        return;
    L5:
        super.setDropDownHorizontalOffset(r2);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int r2) {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L5;
        r0.setVerticalOffset(r2);
        return;
    L5:
        super.setDropDownVerticalOffset(r2);
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int r2) {
        if (this.mPopup == null) goto L5;
        this.mDropDownWidth = r2;
        return;
    L5:
        super.setDropDownWidth(r2);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable r2) {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L5;
        r0.setBackgroundDrawable(r2);
        return;
    L5:
        super.setPopupBackgroundDrawable(r2);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@DrawableRes int r2) {
        setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), r2));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence r2) {
        SpinnerPopup r0 = this.mPopup;
        if (r0 == null) goto L5;
        r0.setPromptText(r2);
        return;
    L5:
        super.setPrompt(r2);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@Nullable ColorStateList r1) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintList(r1);
        return;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode r1) {
        AppCompatBackgroundHelper r0 = this.mBackgroundTintHelper;
        if (r0 == null) goto L6;
        r0.setSupportBackgroundTintMode(r1);
        return;
    }

    public void showPopup() {
        this.mPopup.show(getTextDirection(), getTextAlignment());
    }

    public AppCompatSpinner(@NonNull Context r3, int r4) {
        this(r3, null, androidx.appcompat.R.attr.spinnerStyle, r4);
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter r3) {
        if (this.mPopupSet == true) goto L6;
        this.mTempAdapter = r3;
        return;
    L6:
        super.setAdapter(r3);
        if (this.mPopup == null) goto L13;
        Context r0 = this.mPopupContext;
        if (r0 != null) goto L11;
        r0 = getContext();
    L11:
        this.mPopup.setAdapter(new DropDownAdapter(r3, r0.getTheme()));
        return;
    }

    public AppCompatSpinner(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, androidx.appcompat.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(@NonNull Context r2, @Nullable AttributeSet r3, int r4) {
        this(r2, r3, r4, -1);
    }

    public AppCompatSpinner(@NonNull Context r7, @Nullable AttributeSet r8, int r9, int r10) {
        this(r7, r8, r9, r10, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, androidx.appcompat.widget.AppCompatSpinner] */
    public AppCompatSpinner(@NonNull Context r7, @Nullable AttributeSet r8, int r9, int r10, Resources.Theme r11) {
        super(r7, r8, r9);
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TintTypedArray r0 = TintTypedArray.obtainStyledAttributes(r7, r8, androidx.appcompat.R.styleable.Spinner, r9, 0);
        this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this);
        if (r11 == null) goto L5;
        this.mPopupContext = new ContextThemeWrapper(r7, r11);
    L9:
        ?? r12 = -1;
        ?? r2 = 0;
        if (r10 != (-1)) goto L32;
        TypedArray r13 = r7.obtainStyledAttributes(r8, ATTRS_ANDROID_SPINNERMODE, r9, 0);     // Catch: Throwable -> L21 Exception -> L23
        boolean r3 = r13.hasValue(0);     // Catch: Throwable -> L16 Exception -> L18
        r12 = r13;
        if (r3 == false) goto L20;
        r10 = r13.getInt(0, 0);     // Catch: Throwable -> L16 Exception -> L18
        r12 = r13;
    L20:
        r12.recycle();
    L18:
        e = e;
    L25:
        Log.i(TAG, "Could not read android:spinnerMode", e);     // Catch: Throwable -> L16
        r12 = r13;
        if (r13 == null) goto L32;
    L23:
        e = e;
        r13 = null;
    L21:
        th = th;
    L28:
        if (r2 == 0) goto L30;
        r2.recycle();
    L30:
        throw th;
    L32:
        if (r10 == 0) goto L36;
        if (r10 != 1) goto L37;
        final DropdownPopup r14 = new DropdownPopup(this, this.mPopupContext, r8, r9);
        TintTypedArray r1 = TintTypedArray.obtainStyledAttributes(this.mPopupContext, r8, androidx.appcompat.R.styleable.Spinner, r9, 0);
        this.mDropDownWidth = r1.getLayoutDimension(androidx.appcompat.R.styleable.Spinner_android_dropDownWidth, -2);
        r14.setBackgroundDrawable(r1.getDrawable(androidx.appcompat.R.styleable.Spinner_android_popupBackground));
        r14.setPromptText(r0.getString(androidx.appcompat.R.styleable.Spinner_android_prompt));
        r1.recycle();
        this.mPopup = r14;
        this.mForwardingListener = new AnonymousClass1(this, this, r14);
    L37:
        CharSequence[] r15 = r0.getTextArray(androidx.appcompat.R.styleable.Spinner_android_entries);
        if (r15 == null) goto L40;
        ArrayAdapter r4 = new ArrayAdapter(r7, R.layout.simple_spinner_item, r15);
        r4.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        setAdapter(r4);
    L40:
        r0.recycle();
        this.mPopupSet = true;
        SpinnerAdapter r16 = this.mTempAdapter;
        if (r16 == null) goto L43;
        setAdapter(r16);
        this.mTempAdapter = null;
    L43:
        this.mBackgroundTintHelper.loadFromAttributes(r8, r9);
        return;
    L36:
        DialogPopup r17 = new DialogPopup(this);
        this.mPopup = r17;
        r17.setPromptText(r0.getString(androidx.appcompat.R.styleable.Spinner_android_prompt));
    L16:
        th = th;
        r2 = r12;
        goto L28
    L5:
        int r18 = r0.getResourceId(androidx.appcompat.R.styleable.Spinner_popupTheme, 0);
        if (r18 == 0) goto L8;
        this.mPopupContext = new ContextThemeWrapper(r7, r18);
        goto L9
    L8:
        this.mPopupContext = r7;
        goto L9
    }
}
