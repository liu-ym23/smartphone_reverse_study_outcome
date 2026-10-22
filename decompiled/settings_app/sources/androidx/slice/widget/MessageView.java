package androidx.slice.widget;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.slice.SliceItem;
import androidx.slice.core.SliceQuery;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MessageView extends SliceChildView {
    private TextView mDetails;
    private ImageView mIcon;
    private int mRowIndex;

    @Override // androidx.slice.widget.SliceChildView
    public int getMode() {
        return 2;
    }

    @Override // androidx.slice.widget.SliceChildView
    public void resetView() {
    }

    public MessageView(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mDetails = (TextView) findViewById(R.id.summary);
        this.mIcon = (ImageView) findViewById(R.id.icon);
    }

    @Override // androidx.slice.widget.SliceChildView
    public void setSliceItem(SliceItem r2, boolean r3, int r4, int r5, SliceView.OnSliceActionListener r6) {
        setSliceActionListener(r6);
        this.mRowIndex = r4;
        SliceItem r7 = SliceQuery.findSubtype(r2, SlardarSettingsConsts.SETTING_IMAGE, "source");
        if (r7 != null) goto L5;
    L9:
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        Iterator<SliceItem> r9 = SliceQuery.findAll(r2, "text").iterator();
    L11:
        if (r9.hasNext() == false) goto L16;
        SliceItem r10 = r9.next();
        if (r8.length() == 0) goto L15;
        r8.append('\n');
    L15:
        r8.append(r10.getText());
        goto L11
    L16:
        this.mDetails.setText(r8.toString());
        return;
    L5:
        if (r7.getIcon() == null) goto L9;
        Drawable r11 = r7.getIcon().loadDrawable(getContext());
        if (r11 == null) goto L9;
        int r12 = (int) TypedValue.applyDimension(1, 24.0f, getContext().getResources().getDisplayMetrics());
        Bitmap r13 = Bitmap.createBitmap(r12, r12, Bitmap.Config.ARGB_8888);
        Canvas r14 = new Canvas(r13);
        r11.setBounds(0, 0, r12, r12);
        r11.draw(r14);
        this.mIcon.setImageBitmap(SliceViewUtil.getCircularBitmap(r13));
        goto L9
    }
}
