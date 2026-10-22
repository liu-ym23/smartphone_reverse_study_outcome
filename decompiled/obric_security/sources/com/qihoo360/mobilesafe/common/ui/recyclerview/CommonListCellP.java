package com.qihoo360.mobilesafe.common.ui.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class CommonListCellP extends RelativeLayout {
    private ImageView checkbox;
    private Paint debugPaint;
    private TextView desc;
    private ImageView flag;
    private ImageView icon;
    private ImageView image;
    private View mask;
    private Type type;

    /* JADX INFO: renamed from: com.qihoo360.mobilesafe.common.ui.recyclerview.CommonListCellP$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$qihoo360$mobilesafe$common$ui$recyclerview$CommonListCellP$Type = null;

        static {
            int[] r0 = new int[Type.values().length];
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$recyclerview$CommonListCellP$Type = r0;
            r0[Type.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$recyclerview$CommonListCellP$Type[Type.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$recyclerview$CommonListCellP$Type[Type.EMOJI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$qihoo360$mobilesafe$common$ui$recyclerview$CommonListCellP$Type[Type.AVATAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final class Decoration extends RecyclerView.ItemDecoration {
        public static final int STYLE_A = 1;
        public static final int STYLE_B = 2;
        private SparseArray<Rect> offsetsCache;
        private int style;

        public Decoration(int r2) {
            this.offsetsCache = new SparseArray();
            this.style = r2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
            if ((r11 instanceof CommonListCellP) == true) goto L6;
            return;
        L6:
            if (r12.getAdapter() != null) goto L8;
            return;
        L8:
            if (r12.getLayoutManager() != null) goto L10;
            return;
        L10:
            if ((r12.getLayoutManager() instanceof GridLayoutManager) == false) goto L59;
            GridLayoutManager r14 = (GridLayoutManager) r12.getLayoutManager();
            GridLayoutManager.SpanSizeLookup r0 = r14.getSpanSizeLookup();
            int r15 = r14.getSpanCount();
            int r1 = r12.getChildViewHolder(r11).getAdapterPosition();
            if (r1 != (-1)) goto L17;
            Rect r9 = this.offsetsCache.get(r11.hashCode());
            if (r9 == null) goto L56;
            r10.set(r9);
            return;
        L56:
            return;
        L17:
            int r2 = r0.getSpanIndex(r1, r15);
            int r3 = CommonUtils.dip2px(r12.getContext(), 6.0f);
            int r4 = r3 * 2;
            r10.left = r3;
            r10.top = r3;
            r10.right = r3;
            r10.bottom = 0;
            int r5 = r2 + 1;
            int r6 = r5;
        L19:
            if (r5 >= r15) goto L24;
            if (r0.getSpanSize(r1 + r5) != 1) goto L24;
            r6 = r6 + 1;
            r5 = r5 + 1;
        L24:
            if (r2 != 0) goto L27;
            r10.left = r4;
            r10.right = 0;
        L29:
            int r16 = (r1 - r2) - 1;
            if (r16 >= 0) goto L33;
            r10.top = r4;
        L39:
            int r7 = (r1 + r6) - r2;
            if (r7 <= (r12.getAdapter().getItemCount() - 1)) goto L43;
            r10.bottom = r4;
        L49:
            Rect r17 = this.offsetsCache.get(r11.hashCode());
            if (r17 == null) goto L52;
            r17.set(r10);
            return;
        L52:
            this.offsetsCache.put(r11.hashCode(), new Rect(r10));
            return;
        L43:
            if (r0.getSpanSize(r7) == 1) goto L49;
            if (this.style == 1) goto L48;
            r4 = 0;
        L48:
            r10.bottom = r4;
            goto L49
        L33:
            if (r0.getSpanSize(r16) == 1) goto L39;
            if (this.style != 1) goto L37;
            int r18 = r4;
        L38:
            r10.top = r18;
            goto L39
        L37:
            r18 = 0;
            goto L38
        L27:
            if (r2 != (r15 - 1)) goto L29;
            r10.left = 0;
            r10.right = r4;
            goto L29
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type AVATAR = null;
        public static final Type EMOJI = null;
        public static final Type IMAGE = null;
        public static final Type VIDEO = null;

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            Type r0 = new Type("IMAGE", 0);
            IMAGE = r0;
            Type r1 = new Type("VIDEO", 1);
            VIDEO = r1;
            Type r3 = new Type("EMOJI", 2);
            EMOJI = r3;
            Type r5 = new Type("AVATAR", 3);
            AVATAR = r5;
            $VALUES = new Type[]{r0, r1, r3, r5};
        }
    }

    public CommonListCellP(Context r2) {
        this(r2, null);
    }

    public CommonListCellP(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CommonListCellP(Context r6, AttributeSet r7, int r8) {
        super(r6, r7, r8);
        this.type = Type.IMAGE;
        ImageView r9 = new ImageView(r6);
        this.image = r9;
        r9.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.image, new RelativeLayout.LayoutParams(-1, -1));
        View r10 = new View(r6);
        this.mask = r10;
        r10.setBackgroundColor(Color.parseColor("#66FFFFFF"));
        addView(this.mask, new RelativeLayout.LayoutParams(-1, -1));
        this.icon = new ImageView(r6);
        RelativeLayout.LayoutParams r11 = new RelativeLayout.LayoutParams(-2, -2);
        r11.addRule(13);
        addView(this.icon, r11);
        int r12 = CommonUtils.dip2px(r6, 4.0f);
        TextView r1 = new TextView(r6);
        this.desc = r1;
        r1.setIncludeFontPadding(false);
        this.desc.setGravity(16);
        this.desc.setPadding(r12, 0, 0, 0);
        this.desc.setTextColor(getResources().getColor(R.color.inner_common_text_color_10));
        this.desc.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.inner_common_font_size_f));
        this.desc.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, 1291845632}));
        RelativeLayout.LayoutParams r2 = new RelativeLayout.LayoutParams(-1, CommonUtils.dip2px(r6, 21.0f));
        r2.addRule(12);
        addView(this.desc, r2);
        ImageView r3 = new ImageView(r6);
        this.checkbox = r3;
        r3.setImageResource(R.drawable.inner_row_checkbox2_selector);
        this.checkbox.setPadding(r12, r12, r12, r12);
        RelativeLayout.LayoutParams r13 = new RelativeLayout.LayoutParams(-2, -2);
        r13.addRule(12);
        r13.addRule(11);
        addView(this.checkbox, r13);
        ImageView r14 = new ImageView(r6);
        this.flag = r14;
        addView(r14, -2, -2);
        resetUIState(Type.IMAGE);
    }

    public void resetUIState(Type r3) {
        if (r3 != null) goto L4;
        r3 = Type.IMAGE;
    L4:
        this.type = r3;
        setUIFlagImage(null);
        setIcon();
        this.mask.setVisibility(8);
        setUIDescText(null);
        this.checkbox.setSelected(false);
        this.checkbox.setOnClickListener(null);
    }

    public ImageView getUIImageView() {
        return this.image;
    }

    public void setUIDescText(CharSequence r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        this.desc.setVisibility(8);
        return;
    L5:
        this.desc.setVisibility(0);
        this.desc.setText(r3);
    }

    public void setUIFlagImage(Drawable r1) {
        this.flag.setImageDrawable(r1);
    }

    public void setUIFlagCenterCrop(boolean r2) {
        if (r2 == false) goto L4;
        RelativeLayout.LayoutParams r3 = new RelativeLayout.LayoutParams(-1, -1);
        this.flag.setLayoutParams(r3);
        this.flag.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return;
    L4:
        RelativeLayout.LayoutParams r4 = new RelativeLayout.LayoutParams(-2, -2);
        this.flag.setLayoutParams(r4);
    }

    public void setCheckboxVisible(boolean r1) {
        ImageView r0 = this.checkbox;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void setUIChecked(boolean r3) {
        View r0 = this.mask;
        if (r3 == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        this.checkbox.setSelected(r3);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public boolean isUIChecked() {
        return this.checkbox.isSelected();
    }

    public void setUISelectedListener(View.OnClickListener r1) {
        this.checkbox.setOnClickListener(r1);
    }

    public void setUILoadingImageSuccess() {
        if (this.type == Type.VIDEO) goto L6;
        this.icon.setImageDrawable(null);
        return;
    }

    public Drawable getUIPlaceholder() {
        if (AnonymousClass1.$SwitchMap$com$qihoo360$mobilesafe$common$ui$recyclerview$CommonListCellP$Type[this.type.ordinal()] == 1) goto L7;
        return CommonUtils.getBorderDrawable(getResources().getColor(R.color.inner_common_bg_color_7), getResources().getColor(R.color.inner_common_bg_color_1), 0);
    L7:
        return getContext().getResources().getDrawable(R.color.inner_common_bg_color_12);
    }

    public Drawable getUIErrorDrawable() {
        return getUIPlaceholder();
    }

    private void setIcon() {
        int r0 = AnonymousClass1.$SwitchMap$com$qihoo360$mobilesafe$common$ui$recyclerview$CommonListCellP$Type[this.type.ordinal()];
        if (r0 != 1) goto L5;
        this.icon.setImageResource(R.drawable.inner_common_icon_video);
        return;
    L5:
        if (r0 != 2) goto L7;
        this.icon.setImageResource(R.drawable.inner_common_icon_image);
        return;
    L7:
        if (r0 != 3) goto L9;
        this.icon.setImageResource(R.drawable.inner_common_icon_emoji);
        return;
    L9:
        if (r0 != 4) goto L19;
        this.icon.setImageResource(R.drawable.inner_common_icon_avatar);
        return;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int r2, int r3) {
        int r4 = View.MeasureSpec.getMode(r2);
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r2), r4));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r1) {
        super.dispatchDraw(r1);
    }
}
