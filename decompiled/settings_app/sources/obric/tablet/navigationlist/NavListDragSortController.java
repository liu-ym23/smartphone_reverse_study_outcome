package obric.tablet.navigationlist;

import android.graphics.Point;
import android.view.View;
import com.android.settings.R;
import obric.tablet.dslv.DragSortController;
import obric.tablet.dslv.DragSortListView;

/* JADX INFO: loaded from: classes5.dex */
public class NavListDragSortController extends DragSortController {
    private DragPolicy mDragPolicy;
    private DragSortListView mDslv;
    private int mFloatBGColor;
    private View mFloatView;
    private int mPositionX;

    public interface DragPolicy {
        boolean canDrag(int r1);
    }

    public NavListDragSortController(DragSortListView r3) {
        this(r3, 0, 0, 1);
    }

    public NavListDragSortController(DragSortListView r7, int r8, int r9, int r10) {
        this(r7, r8, r9, r10, 0);
    }

    public NavListDragSortController(DragSortListView r8, int r9, int r10, int r11, int r12) {
        this(r8, r9, r10, r11, r12, 0);
    }

    public NavListDragSortController(DragSortListView r1, int r2, int r3, int r4, int r5, int r6) {
        super(r1, r2, r3, r4, r5, r6);
        this.mFloatBGColor = -1;
        this.mDslv = r1;
        setShadowPadding(0);
    }

    @Override // obric.tablet.dslv.SimpleFloatViewManager
    public void setBackgroundColor(int r1) {
        this.mFloatBGColor = r1;
    }

    public void setDragPolicy(DragPolicy r1) {
        this.mDragPolicy = r1;
    }

    @Override // obric.tablet.dslv.DragSortController
    public boolean startDrag(int r3, int r4, int r5) {
        DragPolicy r0 = this.mDragPolicy;
        int r1 = 0;
        if (r0 == null) goto L8;
        if (r0.canDrag(r3) == true) goto L8;
        return false;
    L8:
        if (isSortEnabled() == false) goto L11;
        r1 = 12;
    L11:
        if (isRemoveEnabled() == false) goto L13;
        r1 = r1 | 3;
    L13:
        boolean r6 = startDrag(r3 - this.mDslv.getHeaderViewsCount(), r1, r4, r5);
        this.mDslv.setItemHeightCollapsed(this.mFloatView.getMeasuredHeight());
        return r6;
    }

    @Override // obric.tablet.dslv.SimpleFloatViewManager, obric.tablet.dslv.DragSortListView.FloatViewManager
    public View onCreateFloatView(int r2) {
        View r3 = super.onCreateFloatView(r2);
        this.mFloatView = r3;
        r3.setBackgroundColor(this.mFloatBGColor);
        return this.mFloatView;
    }

    @Override // obric.tablet.dslv.DragSortController, obric.tablet.dslv.SimpleFloatViewManager, obric.tablet.dslv.DragSortListView.FloatViewManager
    public void onDragFloatView(View r4, Point r5, Point r6) {
        super.onDragFloatView(r4, r5, r6);
        if (isRemoveEnabled() == false) goto L27;
        int r7 = this.mPositionX;
        int r8 = r5.x;
        this.mPositionX = r8;
        if (r7 >= 0) goto L8;
        r7 = -r7;
    L8:
        if (r8 >= 0) goto L11;
        r8 = -r8;
    L11:
        int r9 = this.mDslv.getWidth() / 2;
        int r0 = this.mDslv.getWidth();
        if (r8 >= r0) goto L14;
        float r1 = (r0 - r8) / r0;
        this.mDslv.setFloatAlpha(this.mDslv.getFloatAlpha() / (r1 * r1));
    L14:
        if (r7 > r9) goto L16;
        if (r8 <= r9) goto L16;
    L18:
        boolean r2 = true;
    L20:
        if (r2 == true) goto L22;
        return;
    L22:
        if (r7 > r9) goto L25;
        if (r8 <= r9) goto L25;
        this.mFloatView.setBackgroundResource(R.drawable.nav_item_new);
        return;
    L25:
        this.mFloatView.setBackgroundColor(this.mFloatBGColor);
        return;
    L16:
        if (r7 <= r9) goto L19;
        if (r8 <= r9) goto L18;
    L19:
        r2 = false;
        goto L20
    }

    @Override // obric.tablet.dslv.SimpleFloatViewManager, obric.tablet.dslv.DragSortListView.FloatViewManager
    public void onDestroyFloatView(View r1) {
        super.onDestroyFloatView(r1);
        this.mPositionX = 0;
    }
}
