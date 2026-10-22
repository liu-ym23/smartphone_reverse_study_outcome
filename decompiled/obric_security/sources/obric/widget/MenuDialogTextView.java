package obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes5.dex */
public class MenuDialogTextView extends FontFitTextView {
    private float limitX;
    private int screenWidth;

    public MenuDialogTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics r2 = context.getResources().getDisplayMetrics();
        this.limitX = (r2.density * 93.0f) + 0.5f;
        this.screenWidth = Math.min(r2.widthPixels, r2.heightPixels);
        setMinTextSize(getResources().getDimension(R.dimen.menu_dialog_item_text_min_size));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int r0 = getWidth();
        if (r0 <= this.screenWidth) goto L5;
        float r1 = event.getX();
        int r2 = event.getActionMasked();
        if (r2 == 0) goto L20;
        if (r2 != 1) goto L10;
    L14:
        float r3 = this.limitX;
        if (r1 >= r3) goto L17;
    L18:
        setPressed(false);
        return true;
    L17:
        if (r1 > (r0 - r3)) goto L18;
    L26:
        return super.onTouchEvent(event);
    L10:
        if (r2 == 2) goto L14;
        if (r2 == 3) goto L14;
    L20:
        float r4 = this.limitX;
        if (r1 >= r4) goto L23;
    L27:
        return true;
    L23:
        if (r1 <= (r0 - r4)) goto L26;
    L5:
        return super.onTouchEvent(event);
    }
}
