package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.bytedance.apm.constant.SlardarConfigConsts;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintHelper extends View {
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds;
    protected HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected String mReferenceTags;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;

    protected void applyLayoutFeaturesInConstraintSet(ConstraintLayout container) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    public void resolveRtl(ConstraintWidget widget, boolean isRtl) {
    }

    public void updatePostConstraints(ConstraintLayout container) {
    }

    public void updatePostLayout(ConstraintLayout container) {
    }

    public void updatePostMeasure(ConstraintLayout container) {
    }

    public void updatePreDraw(ConstraintLayout container) {
    }

    public ConstraintHelper(Context context) {
        super(context);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = context;
        init(null);
    }

    public ConstraintHelper(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = context;
        init(attrs);
    }

    public ConstraintHelper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = context;
        init(attrs);
    }

    protected void init(AttributeSet attrs) {
        if (attrs == null) goto L18;
        TypedArray r5 = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
        int r0 = r5.getIndexCount();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L12;
        int r2 = r5.getIndex(r1);
        if (r2 != R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) goto L9;
        String r3 = r5.getString(r2);
        this.mReferenceIds = r3;
        setIds(r3);
    L11:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 != R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) goto L11;
        String r4 = r5.getString(r2);
        this.mReferenceTags = r4;
        setReferenceTags(r4);
        goto L11
    L12:
        r5.recycle();
        return;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r0 = this.mReferenceIds;
        if (r0 == null) goto L5;
        setIds(r0);
    L5:
        String r1 = this.mReferenceTags;
        if (r1 == null) goto L9;
        setReferenceTags(r1);
        return;
    }

    public void addView(View view) {
        if (view != this) goto L5;
        return;
    L5:
        if (view.getId() != (-1)) goto L9;
        Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        return;
    L9:
        if (view.getParent() != null) goto L12;
        Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
        return;
    L12:
        this.mReferenceIds = null;
        addRscID(view.getId());
        requestLayout();
    }

    public int removeView(View view) {
        int r6 = view.getId();
        int r0 = -1;
        if (r6 != (-1)) goto L5;
        return -1;
    L5:
        this.mReferenceIds = null;
        int r2 = 0;
    L7:
        if (r2 >= this.mCount) goto L16;
        if (this.mIds[r2] == r6) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        int r7 = r2;
    L11:
        int r1 = this.mCount;
        if (r7 >= (r1 - 1)) goto L14;
        int[] r3 = this.mIds;
        int r4 = r7 + 1;
        r3[r7] = r3[r4];
        r7 = r4;
        goto L11
    L14:
        this.mIds[r1 - 1] = 0;
        this.mCount = r1 - 1;
        r0 = r2;
    L16:
        requestLayout();
        return r0;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    public void setReferencedIds(int[] ids) {
        this.mReferenceIds = null;
        int r0 = 0;
        this.mCount = 0;
    L4:
        if (r0 >= ids.length) goto L6;
        addRscID(ids[r0]);
        r0 = r0 + 1;
        goto L4
    }

    private void addRscID(int id) {
        if (id != getId()) goto L5;
        return;
    L5:
        int r0 = this.mCount + 1;
        int[] r1 = this.mIds;
        if (r0 <= r1.length) goto L8;
        this.mIds = Arrays.copyOf(r1, r1.length * 2);
    L8:
        int[] r2 = this.mIds;
        int r3 = this.mCount;
        r2[r3] = id;
        this.mCount = r3 + 1;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mUseViewMeasure == false) goto L5;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public void validateParams() {
        if (this.mHelperWidget != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintWidget r2 = (ConstraintWidget) this.mHelperWidget;
        ((ConstraintLayout.LayoutParams) r0).widget = r2;
        return;
    }

    private void addID(String idString) {
        if (idString != null) goto L4;
        return;
    L4:
        if (idString.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        String r4 = idString.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r0 = (ConstraintLayout) getParent();
    L12:
        int r1 = findId(r4);
        if (r1 == 0) goto L15;
        this.mMap.put(Integer.valueOf(r1), r4);
        addRscID(r1);
        return;
    L15:
        Log.w("ConstraintHelper", "Could not find id of \"" + r4 + "\"");
    }

    private void addTag(String tagString) {
        if (tagString != null) goto L4;
        return;
    L4:
        if (tagString.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        String r8 = tagString.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r0 = (ConstraintLayout) getParent();
    L14:
        if (r0 != null) goto L17;
        Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
        return;
    L17:
        int r2 = r0.getChildCount();
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L35;
        View r4 = r0.getChildAt(r3);
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L27;
        if (r8.equals(((ConstraintLayout.LayoutParams) r5).constraintTag) == false) goto L27;
        if (r4.getId() != (-1)) goto L26;
        Log.w("ConstraintHelper", "to use ConstraintTag view " + r4.getClass().getSimpleName() + " must have an ID");
        goto L27
    L26:
        addRscID(r4.getId());
    L27:
        r3 = r3 + 1;
        goto L18
    L35:
        return;
    L12:
        r0 = null;
        goto L14
    }

    private int findId(String referenceId) {
        if ((getParent() instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r0 = (ConstraintLayout) getParent();
    L6:
        int r3 = 0;
        if (isInEditMode() == false) goto L12;
        if (r0 == null) goto L12;
        Object r2 = r0.getDesignInformation(0, referenceId);
        if ((r2 instanceof Integer) == false) goto L12;
        r3 = ((Integer) r2).intValue();
    L12:
        if (r3 != 0) goto L15;
        if (r0 == null) goto L15;
        r3 = findId(r0, referenceId);
    L15:
        if (r3 == 0) goto L21;
    L17:
        if (r3 == 0) goto L19;
        return r3;
    L19:
        return this.myContext.getResources().getIdentifier(referenceId, SlardarConfigConsts.CONFIG_ID, this.myContext.getPackageName());
    L21:
        r3 = R.id.class.getField(referenceId).getInt(null);     // Catch: Exception -> L20
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private int findId(ConstraintLayout container, String idString) {
        if (idString == null) goto L21;
        if (container == null) goto L21;
        Resources r6 = this.myContext.getResources();
        if (r6 != null) goto L9;
        return 0;
    L9:
        int r1 = container.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L21;
        View r3 = container.getChildAt(r2);
        if (r3.getId() == (-1)) goto L20;
        String r4 = r6.getResourceEntryName(r3.getId());     // Catch: Resources.NotFoundException -> L15
    L17:
        if (idString.equals(r4) == false) goto L20;
        return r3.getId();
    L15:
        r4 = null;
    L20:
        r2 = r2 + 1;
    L21:
        return 0;
    }

    protected void setIds(String idList) {
        this.mReferenceIds = idList;
        if (idList != null) goto L5;
        return;
    L5:
        int r0 = 0;
        this.mCount = 0;
    L6:
        int r1 = idList.indexOf(44, r0);
        if (r1 == (-1)) goto L8;
        addID(idList.substring(r0, r1));
        r0 = r1 + 1;
        goto L6
    L8:
        addID(idList.substring(r0));
    }

    protected void setReferenceTags(String tagList) {
        this.mReferenceTags = tagList;
        if (tagList != null) goto L5;
        return;
    L5:
        int r0 = 0;
        this.mCount = 0;
    L6:
        int r1 = tagList.indexOf(44, r0);
        if (r1 == (-1)) goto L8;
        addTag(tagList.substring(r0, r1));
        r0 = r1 + 1;
        goto L6
    L8:
        addTag(tagList.substring(r0));
    }

    protected void applyLayoutFeatures(ConstraintLayout container) {
        int r0 = getVisibility();
        float r1 = getElevation();
        int r2 = 0;
    L4:
        if (r2 >= this.mCount) goto L11;
        View r3 = container.getViewById(this.mIds[r2]);
        if (r3 == null) goto L10;
        r3.setVisibility(r0);
        if (r1 <= 0.0f) goto L10;
        r3.setTranslationZ(r3.getTranslationZ() + r1);
    L10:
        r2 = r2 + 1;
        goto L4
    }

    protected void applyLayoutFeatures() {
        ViewParent r0 = getParent();
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof ConstraintLayout) == false) goto L9;
        applyLayoutFeatures((ConstraintLayout) r0);
        return;
    }

    public void updatePreLayout(ConstraintLayout container) {
        if (isInEditMode() == false) goto L5;
        setIds(this.mReferenceIds);
    L5:
        Helper r0 = this.mHelperWidget;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.removeAllIds();
        int r1 = 0;
    L10:
        if (r1 >= this.mCount) goto L19;
        int r2 = this.mIds[r1];
        View r3 = container.getViewById(r2);
        if (r3 != null) goto L16;
        String r4 = this.mMap.get(Integer.valueOf(r2));
        int r5 = findId(container, r4);
        if (r5 == 0) goto L16;
        this.mIds[r1] = r5;
        this.mMap.put(Integer.valueOf(r5), r4);
        r3 = container.getViewById(r5);
    L16:
        if (r3 == null) goto L18;
        this.mHelperWidget.add(container.getViewWidget(r3));
    L18:
        r1 = r1 + 1;
        goto L10
    L19:
        this.mHelperWidget.updateConstraints(container.mLayoutWidget);
    }

    public void updatePreLayout(ConstraintWidgetContainer container, Helper helper, SparseArray<ConstraintWidget> map) {
        helper.removeAllIds();
        int r2 = 0;
    L4:
        if (r2 >= this.mCount) goto L6;
        helper.add(map.get(this.mIds[r2]));
        r2 = r2 + 1;
        goto L4
    }

    protected View[] getViews(ConstraintLayout layout) {
        View[] r0 = this.mViews;
        if (r0 != null) goto L5;
    L6:
        this.mViews = new View[this.mCount];
    L7:
        int r1 = 0;
    L9:
        if (r1 >= this.mCount) goto L12;
        int r2 = this.mIds[r1];
        this.mViews[r1] = layout.getViewById(r2);
        r1 = r1 + 1;
        goto L9
    L12:
        return this.mViews;
    L5:
        if (r0.length == this.mCount) goto L7;
        goto L6
    }

    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget child, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> mapIdToWidget) {
        if (constraint.layout.mReferenceIds == null) goto L6;
        setReferencedIds(constraint.layout.mReferenceIds);
    L11:
        if (child == null) goto L21;
        child.removeAllIds();
        if (constraint.layout.mReferenceIds == null) goto L25;
        int r1 = 0;
    L16:
        if (r1 >= constraint.layout.mReferenceIds.length) goto L26;
        ConstraintWidget r4 = mapIdToWidget.get(constraint.layout.mReferenceIds[r1]);
        if (r4 == null) goto L20;
        child.add(r4);
    L20:
        r1 = r1 + 1;
        goto L16
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L6:
        if (constraint.layout.mReferenceIdString == null) goto L11;
        if (constraint.layout.mReferenceIdString.length() <= 0) goto L10;
        ConstraintSet.Layout r5 = constraint.layout;
        r5.mReferenceIds = convertReferenceString(this, constraint.layout.mReferenceIdString);
        goto L11
    L10:
        constraint.layout.mReferenceIds = null;
        goto L11
    }

    private int[] convertReferenceString(View view, String referenceIdString) {
        String[] r6 = referenceIdString.split(",");
        view.getContext();
        int[] r5 = new int[r6.length];
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= r6.length) goto L10;
        int r2 = findId(r6[r0].trim());
        if (r2 == 0) goto L8;
        r5[r1] = r2;
        r1 = r1 + 1;
    L8:
        r0 = r0 + 1;
        goto L4
    L10:
        if (r1 != r6.length) goto L12;
        return r5;
    L12:
        return Arrays.copyOf(r5, r1);
    }

    @Override // android.view.View
    public void setTag(int key, Object tag) {
        super.setTag(key, tag);
        if (tag == null) goto L5;
        return;
    L5:
        if (this.mReferenceIds != null) goto L9;
        addRscID(key);
        return;
    }

    public boolean containsId(final int id) {
        int[] r4 = this.mIds;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (r4[r2] == id) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    public int indexFromId(final int id) {
        int[] r4 = this.mIds;
        int r0 = r4.length;
        int r1 = -1;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        r1 = r1 + 1;
        if (r4[r2] == id) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return r1;
    }
}
