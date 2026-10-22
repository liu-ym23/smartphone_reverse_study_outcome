package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private SparseArray<ConstraintSet> mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    int mCurrentConstraintNumber;
    int mCurrentStateId;
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState;
    private SparseArray<State> mStateList;

    static class State {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants;

        public State(Context context, XmlPullParser parser) {
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            int r0 = 0;
            this.mIsLayout = false;
            TypedArray r7 = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.State);
            int r1 = r7.getIndexCount();
        L3:
            if (r0 >= r1) goto L13;
            int r2 = r7.getIndex(r0);
            if (r2 != R.styleable.State_android_id) goto L8;
            this.mId = r7.getResourceId(r2, this.mId);
        L12:
            r0 = r0 + 1;
            goto L3
        L8:
            if (r2 != R.styleable.State_constraints) goto L12;
            this.mConstraintID = r7.getResourceId(r2, this.mConstraintID);
            String r3 = context.getResources().getResourceTypeName(this.mConstraintID);
            context.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r3) == false) goto L12;
            this.mIsLayout = true;
            goto L12
        L13:
            r7.recycle();
        }

        void add(Variant size) {
            this.mVariants.add(size);
        }

        public int findMatch(float width, float height) {
            int r0 = 0;
        L4:
            if (r0 >= this.mVariants.size()) goto L9;
            if (this.mVariants.get(r0).match(width, height) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }
    }

    static class Variant {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context context, XmlPullParser parser) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            int r0 = 0;
            this.mIsLayout = false;
            TypedArray r7 = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.Variant);
            int r1 = r7.getIndexCount();
        L3:
            if (r0 >= r1) goto L23;
            int r2 = r7.getIndex(r0);
            if (r2 != R.styleable.Variant_constraints) goto L10;
            this.mConstraintID = r7.getResourceId(r2, this.mConstraintID);
            String r3 = context.getResources().getResourceTypeName(this.mConstraintID);
            context.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r3) == false) goto L22;
            this.mIsLayout = true;
        L22:
            r0 = r0 + 1;
            goto L3
        L10:
            if (r2 != R.styleable.Variant_region_heightLessThan) goto L13;
            this.mMaxHeight = r7.getDimension(r2, this.mMaxHeight);
            goto L22
        L13:
            if (r2 != R.styleable.Variant_region_heightMoreThan) goto L16;
            this.mMinHeight = r7.getDimension(r2, this.mMinHeight);
            goto L22
        L16:
            if (r2 != R.styleable.Variant_region_widthLessThan) goto L19;
            this.mMaxWidth = r7.getDimension(r2, this.mMaxWidth);
            goto L22
        L19:
            if (r2 != R.styleable.Variant_region_widthMoreThan) goto L21;
            this.mMinWidth = r7.getDimension(r2, this.mMinWidth);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r7.recycle();
        }

        boolean match(float widthDp, float heightDp) {
            if (Float.isNaN(this.mMinWidth) == true) goto L8;
            if (widthDp >= this.mMinWidth) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.mMinHeight) == true) goto L13;
            if (heightDp >= this.mMinHeight) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.mMaxWidth) == true) goto L18;
            if (widthDp <= this.mMaxWidth) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.mMaxHeight) == false) goto L20;
            return true;
        L20:
            if (heightDp <= this.mMaxHeight) goto L24;
            return false;
        L24:
            return true;
        }
    }

    public StateSet(Context context, XmlPullParser parser) {
        this.mDefaultState = -1;
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        load(context, parser);
    }

    private void load(Context context, XmlPullParser parser) {
        TypedArray r0 = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.StateSet);
        int r1 = r0.getIndexCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        int r4 = r0.getIndex(r3);
        if (r4 != R.styleable.StateSet_defaultState) goto L7;
        this.mDefaultState = r0.getResourceId(r4, this.mDefaultState);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        r0.recycle();
        int r2 = parser.getEventType();     // Catch: IOException -> L47 XmlPullParserException -> L49
        State r5 = null;
    L11:
        byte r6 = 1;
        if (r2 == 1) goto L67;
        if (r2 != 0) goto L15;
        parser.getName();     // Catch: IOException -> L47 XmlPullParserException -> L49
    L45:
        r2 = parser.next();     // Catch: IOException -> L47 XmlPullParserException -> L49
        goto L11
    L15:
        if (r2 == 2) goto L21;
        if (r2 != 3) goto L45;
        if ("StateSet".equals(parser.getName()) == false) goto L45;
        return;
    L21:
        String r7 = parser.getName();     // Catch: IOException -> L47 XmlPullParserException -> L49
        switch(r7.hashCode()) {
            case 80204913: goto L34;
            case 1301459538: goto L31;
            case 1382829617: goto L28;
            case 1901439077: goto L25;
            default: goto L36;
        };     // Catch: IOException -> L47 XmlPullParserException -> L49
    L36:
        r6 = -1;
    L37:
        if (r6 == 2) goto L43;
        if (r6 != 3) goto L45;
        Variant r8 = new Variant(context, parser);     // Catch: IOException -> L47 XmlPullParserException -> L49
        if (r5 == null) goto L45;
        r5.add(r8);     // Catch: IOException -> L47 XmlPullParserException -> L49
        goto L45
    L43:
        r5 = new State(context, parser);     // Catch: IOException -> L47 XmlPullParserException -> L49
        this.mStateList.put(r5.mId, r5);     // Catch: IOException -> L47 XmlPullParserException -> L49
        goto L45
    L25:
        if (r7.equals("Variant") == false) goto L36;
        r6 = 3;
        goto L37
    L28:
        if (r7.equals("StateSet") == false) goto L36;
    L31:
        if (r7.equals("LayoutDescription") == false) goto L36;
        r6 = 0;
        goto L37
    L34:
        if (r7.equals("State") == false) goto L36;
        r6 = 2;
        goto L37
    L67:
        return;
    L47:
        e = move-exception;
        e.printStackTrace();
        return;
    L49:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean needsToChange(int id, float width, float height) {
        int r0 = this.mCurrentStateId;
        if (r0 == id) goto L6;
        return true;
    L6:
        if (id != (-1)) goto L8;
        State r5 = this.mStateList.valueAt(0);
    L9:
        State r6 = r5;
        if (this.mCurrentConstraintNumber == (-1)) goto L15;
        if (r6.mVariants.get(this.mCurrentConstraintNumber).match(width, height) == false) goto L15;
        return false;
    L15:
        if (this.mCurrentConstraintNumber != r6.findMatch(width, height)) goto L17;
        return false;
    L17:
        return true;
    L8:
        r5 = this.mStateList.get(r0);
        goto L9
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int id, int width, int height) {
        return updateConstraints(-1, id, width, height);
    }

    public int convertToConstraintSet(int currentConstrainSettId, int stateId, float width, float height) {
        State r3 = this.mStateList.get(stateId);
        if (r3 != null) goto L6;
        return stateId;
    L6:
        if (width == (-1.0f)) goto L25;
        if (height == (-1.0f)) goto L25;
        Iterator<Variant> r5 = r3.mVariants.iterator();
        Variant r0 = null;
    L12:
        if (r5.hasNext() == false) goto L19;
        Variant r1 = r5.next();
        if (r1.match(width, height) == false) goto L12;
        if (currentConstrainSettId == r1.mConstraintID) goto L17;
        r0 = r1;
        goto L12
    L17:
        return currentConstrainSettId;
    L19:
        if (r0 == null) goto L23;
        return r0.mConstraintID;
    L23:
        return r3.mConstraintID;
    L25:
        if (r3.mConstraintID != currentConstrainSettId) goto L27;
        return currentConstrainSettId;
    L27:
        Iterator<Variant> r6 = r3.mVariants.iterator();
    L29:
        if (r6.hasNext() == false) goto L34;
        if (currentConstrainSettId != r6.next().mConstraintID) goto L29;
        return currentConstrainSettId;
    L34:
        return r3.mConstraintID;
    }

    public int updateConstraints(int currentId, int id, float width, float height) {
        if (currentId != id) goto L21;
        if (id != (-1)) goto L6;
        State r4 = this.mStateList.valueAt(0);
    L7:
        if (r4 != null) goto L10;
        return -1;
    L10:
        if (this.mCurrentConstraintNumber != (-1)) goto L12;
    L14:
        int r2 = r4.findMatch(width, height);
        if (currentId != r2) goto L17;
        return currentId;
    L17:
        if (r2 != (-1)) goto L20;
        return r4.mConstraintID;
    L20:
        return r4.mVariants.get(r2).mConstraintID;
    L12:
        if (r4.mVariants.get(currentId).match(width, height) == false) goto L14;
        return currentId;
    L6:
        r4 = this.mStateList.get(this.mCurrentStateId);
        goto L7
    L21:
        State r3 = this.mStateList.get(id);
        if (r3 != null) goto L24;
        return -1;
    L24:
        int r5 = r3.findMatch(width, height);
        if (r5 != (-1)) goto L28;
        return r3.mConstraintID;
    L28:
        return r3.mVariants.get(r5).mConstraintID;
    }
}
