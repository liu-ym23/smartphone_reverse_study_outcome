package androidx.slice.widget;

import android.R;
import android.app.RemoteInput;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.slice.SliceItem;
import androidx.slice.core.SliceAction;
import androidx.slice.core.SliceActionImpl;
import androidx.slice.core.SliceQuery;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActionRow extends FrameLayout {
    private static final int MAX_ACTIONS = 5;
    private static final String TAG = "ActionRow";
    private final LinearLayout mActionsGroup;
    private int mColor;
    private final boolean mFullActions;
    private final int mIconPadding;
    private final int mSize;

    public ActionRow(Context r3, boolean r4) {
        super(r3);
        this.mColor = -16777216;
        this.mFullActions = r4;
        this.mSize = (int) TypedValue.applyDimension(1, 48.0f, r3.getResources().getDisplayMetrics());
        this.mIconPadding = (int) TypedValue.applyDimension(1, 12.0f, r3.getResources().getDisplayMetrics());
        LinearLayout r5 = new LinearLayout(r3);
        this.mActionsGroup = r5;
        r5.setOrientation(0);
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        addView(r5);
    }

    private void setColor(int r4) {
        this.mColor = r4;
        int r0 = 0;
    L4:
        if (r0 >= this.mActionsGroup.getChildCount()) goto L12;
        View r1 = this.mActionsGroup.getChildAt(r0);
        if (((Integer) r1.getTag()).intValue() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        ImageViewCompat.setImageTintList((ImageView) r1, ColorStateList.valueOf(this.mColor));
    L11:
        r0 = r0 + 1;
        goto L4
    L8:
        r2 = false;
        goto L9
    }

    private ImageView addAction(IconCompat r3, boolean r4) {
        ImageView r0 = new ImageView(getContext());
        int r1 = this.mIconPadding;
        r0.setPadding(r1, r1, r1, r1);
        r0.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r0.setImageDrawable(r3.loadDrawable(getContext()));
        if (r4 == false) goto L5;
        ImageViewCompat.setImageTintList(r0, ColorStateList.valueOf(this.mColor));
    L5:
        r0.setBackground(SliceViewUtil.getDrawable(getContext(), R.attr.selectableItemBackground));
        r0.setTag(Boolean.valueOf(r4));
        addAction(r0);
        return r0;
    }

    public void setActions(List<SliceAction> r6, int r7) {
        removeAllViews();
        this.mActionsGroup.removeAllViews();
        addView(this.mActionsGroup);
        if (r7 == (-1)) goto L5;
        setColor(r7);
    L5:
        Iterator<SliceAction> r8 = r6.iterator();
    L6:
        int r0 = 0;
        boolean r1 = false;
        if (r8.hasNext() == false) goto L25;
        SliceAction r9 = r8.next();
        if (this.mActionsGroup.getChildCount() >= 5) goto L10;
        SliceActionImpl r2 = (SliceActionImpl) r9;
        SliceItem r3 = r2.getSliceItem();
        final SliceItem r4 = r2.getActionItem();
        SliceItem r5 = SliceQuery.find(r3, "input");
        SliceItem r10 = SliceQuery.find(r3, SlardarSettingsConsts.SETTING_IMAGE);
        if (r5 == null) goto L16;
        if (r10 == null) goto L16;
        handleSetRemoteInputActions(r5, r10, r4);
    L16:
        if (r9.getIcon() == null) goto L6;
        IconCompat r11 = r9.getIcon();
        if (r11 == null) goto L6;
        if (r4 == null) goto L6;
        if (r9.getImageMode() != 0) goto L23;
        r1 = true;
    L23:
        addAction(r11, r1).setOnClickListener(new AnonymousClass1(this, r4));
        goto L6
    L10:
        return;
    L25:
        if (getChildCount() != 0) goto L28;
        r0 = 8;
    L28:
        setVisibility(r0);
    }

    private void addAction(View r4) {
        LinearLayout r0 = this.mActionsGroup;
        int r3 = this.mSize;
        r0.addView(r4, new LinearLayout.LayoutParams(r3, r3, 1.0f));
    }

    private void handleSetRemoteInputActions(final SliceItem r2, SliceItem r3, final SliceItem r4) {
        if (r2.getRemoteInput().getAllowFreeFormInput() == false) goto L6;
        addAction(r3.getIcon(), !r3.hasHint("no_tint")).setOnClickListener(new AnonymousClass2(this, r4, r2));
        createRemoteInputView(this.mColor, getContext());
        return;
    }

    private void createRemoteInputView(int r3, Context r4) {
        RemoteInputView r5 = RemoteInputView.inflate(r4, this);
        r5.setVisibility(4);
        addView(r5, new FrameLayout.LayoutParams(-1, -1));
        r5.setBackgroundColor(r3);
    }

    boolean handleRemoteInputClick(View r7, SliceItem r8, RemoteInput r9) {
        if (r9 != null) goto L5;
        return false;
    L5:
        ViewParent r1 = r7.getParent().getParent();
        RemoteInputView r2 = null;
    L6:
        if (r1 == null) goto L13;
        if ((r1 instanceof View) == false) goto L12;
        r2 = findRemoteInputView((View) r1);
        if (r2 != null) goto L13;
    L12:
        r1 = r1.getParent();
    L13:
        if (r2 != null) goto L15;
        return false;
    L15:
        int r6 = r7.getWidth();
        if ((r7 instanceof TextView) == false) goto L20;
        TextView r3 = (TextView) r7;
        if (r3.getLayout() == null) goto L20;
        r6 = Math.min(r6, ((int) r3.getLayout().getLineWidth(0)) + (r3.getCompoundPaddingLeft() + r3.getCompoundPaddingRight()));
    L20:
        int r4 = r7.getLeft() + (r6 / 2);
        int r10 = r7.getTop() + (r7.getHeight() / 2);
        int r11 = r2.getWidth();
        int r5 = r2.getHeight() - r10;
        int r12 = r11 - r4;
        r2.setRevealParameters(r4, r10, Math.max(Math.max(r4 + r10, r4 + r5), Math.max(r12 + r10, r12 + r5)));
        r2.setAction(r8);
        r2.setRemoteInput(new RemoteInput[]{r9}, r9);
        r2.focusAnimated();
        return true;
    }

    private RemoteInputView findRemoteInputView(View r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return (RemoteInputView) r1.findViewWithTag(RemoteInputView.VIEW_TAG);
    }
}
