package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    private SparseArray<ConstraintSet> mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    int mCurrentConstraintNumber;
    int mCurrentStateId;
    ConstraintSet mDefaultConstraintSet;
    private SparseArray<State> mStateList;

    public static class State {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        ArrayList<Variant> mVariants;

        public State(Context r6, XmlPullParser r7) {
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            TypedArray r8 = r6.obtainStyledAttributes(Xml.asAttributeSet(r7), R.styleable.State);
            int r0 = r8.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L13;
            int r2 = r8.getIndex(r1);
            if (r2 != R.styleable.State_android_id) goto L8;
            this.mId = r8.getResourceId(r2, this.mId);
        L12:
            r1 = r1 + 1;
            goto L3
        L8:
            if (r2 != R.styleable.State_constraints) goto L12;
            this.mConstraintID = r8.getResourceId(r2, this.mConstraintID);
            String r3 = r6.getResources().getResourceTypeName(this.mConstraintID);
            r6.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r3) == false) goto L12;
            ConstraintSet r4 = new ConstraintSet();
            this.mConstraintSet = r4;
            r4.clone(r6, this.mConstraintID);
            goto L12
        L13:
            r8.recycle();
        }

        public void add(Variant r1) {
            this.mVariants.add(r1);
        }

        public int findMatch(float r3, float r4) {
            int r0 = 0;
        L4:
            if (r0 >= this.mVariants.size()) goto L9;
            if (this.mVariants.get(r0).match(r3, r4) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }
    }

    public static class Variant {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context r6, XmlPullParser r7) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            TypedArray r8 = r6.obtainStyledAttributes(Xml.asAttributeSet(r7), R.styleable.Variant);
            int r0 = r8.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L23;
            int r2 = r8.getIndex(r1);
            if (r2 != R.styleable.Variant_constraints) goto L10;
            this.mConstraintID = r8.getResourceId(r2, this.mConstraintID);
            String r3 = r6.getResources().getResourceTypeName(this.mConstraintID);
            r6.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r3) == false) goto L22;
            ConstraintSet r4 = new ConstraintSet();
            this.mConstraintSet = r4;
            r4.clone(r6, this.mConstraintID);
        L22:
            r1 = r1 + 1;
            goto L3
        L10:
            if (r2 != R.styleable.Variant_region_heightLessThan) goto L13;
            this.mMaxHeight = r8.getDimension(r2, this.mMaxHeight);
            goto L22
        L13:
            if (r2 != R.styleable.Variant_region_heightMoreThan) goto L16;
            this.mMinHeight = r8.getDimension(r2, this.mMinHeight);
            goto L22
        L16:
            if (r2 != R.styleable.Variant_region_widthLessThan) goto L19;
            this.mMaxWidth = r8.getDimension(r2, this.mMaxWidth);
            goto L22
        L19:
            if (r2 != R.styleable.Variant_region_widthMoreThan) goto L21;
            this.mMinWidth = r8.getDimension(r2, this.mMinWidth);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r8.recycle();
        }

        public boolean match(float r3, float r4) {
            if (Float.isNaN(this.mMinWidth) == true) goto L8;
            if (r3 >= this.mMinWidth) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.mMinHeight) == true) goto L13;
            if (r4 >= this.mMinHeight) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.mMaxWidth) == true) goto L18;
            if (r3 <= this.mMaxWidth) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.mMaxHeight) == false) goto L20;
            return true;
        L20:
            if (r4 <= this.mMaxHeight) goto L24;
            return false;
        L24:
            return true;
        }
    }

    public ConstraintLayoutStates(Context r2, ConstraintLayout r3, int r4) {
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        this.mConstraintLayout = r3;
        load(r2, r4);
    }

    private void load(Context r8, int r9) {
        XmlResourceParser r10 = r8.getResources().getXml(r9);
        int r0 = r10.getEventType();     // Catch: IOException -> L16 XmlPullParserException -> L18
        State r1 = null;
    L4:
        byte r2 = 1;
        if (r0 == 1) goto L60;
        if (r0 != 0) goto L8;
        r10.getName();     // Catch: IOException -> L16 XmlPullParserException -> L18
    L43:
        r0 = r10.next();     // Catch: IOException -> L16 XmlPullParserException -> L18
    L8:
        if (r0 != 2) goto L43;
        String r3 = r10.getName();     // Catch: IOException -> L16 XmlPullParserException -> L18
        switch(r3.hashCode()) {
            case -1349929691: goto L30;
            case 80204913: goto L27;
            case 1382829617: goto L24;
            case 1657696882: goto L21;
            case 1901439077: goto L14;
            default: goto L32;
        };     // Catch: IOException -> L16 XmlPullParserException -> L18
    L32:
        r2 = -1;
    L33:
        if (r2 == 2) goto L41;
        if (r2 == 3) goto L38;
        if (r2 != 4) goto L43;
        parseConstraintSet(r8, r10);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L43
    L38:
        Variant r4 = new Variant(r8, r10);     // Catch: IOException -> L16 XmlPullParserException -> L18
        if (r1 == null) goto L43;
        r1.add(r4);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L43
    L41:
        r1 = new State(r8, r10);     // Catch: IOException -> L16 XmlPullParserException -> L18
        this.mStateList.put(r1.mId, r1);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L43
    L14:
        if (r3.equals("Variant") == false) goto L32;
        r2 = 3;
        goto L33
    L21:
        if (r3.equals("layoutDescription") == false) goto L32;
        r2 = 0;
        goto L33
    L24:
        if (r3.equals("StateSet") == false) goto L32;
    L27:
        if (r3.equals("State") == false) goto L32;
        r2 = 2;
        goto L33
    L30:
        if (r3.equals("ConstraintSet") == false) goto L32;
        r2 = 4;
        goto L33
    L60:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseConstraintSet(Context r9, XmlPullParser r10) {
        ConstraintSet r0 = new ConstraintSet();
        int r1 = r10.getAttributeCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L27;
        String r3 = r10.getAttributeName(r2);
        String r4 = r10.getAttributeValue(r2);
        if (r3 == null) goto L20;
        if (r4 == null) goto L20;
        if (SlardarConfigConsts.CONFIG_ID.equals(r3) == false) goto L20;
        if (r4.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L13;
        int r5 = r9.getResources().getIdentifier(r4.substring(r4.indexOf(47) + 1), SlardarConfigConsts.CONFIG_ID, r9.getPackageName());
    L14:
        if (r5 == (-1)) goto L16;
    L19:
        r0.load(r9, r10);
        this.mConstraintSetMap.put(r5, r0);
        return;
    L16:
        if (r4.length() <= 1) goto L18;
        r5 = Integer.parseInt(r4.substring(1));
        goto L19
    L18:
        Log.e("ConstraintLayoutStates", "error in parsing id");
        goto L19
    L13:
        r5 = -1;
    L20:
        r2 = r2 + 1;
        goto L3
    }

    public boolean needsToChange(int r5, float r6, float r7) {
        int r0 = this.mCurrentStateId;
        if (r0 == r5) goto L6;
        return true;
    L6:
        if (r5 != (-1)) goto L9;
        State r8 = this.mStateList.valueAt(0);
    L8:
        State r9 = r8;
        int r1 = this.mCurrentConstraintNumber;
        if (r1 == (-1)) goto L16;
        if (r9.mVariants.get(r1).match(r6, r7) == false) goto L16;
        return false;
    L16:
        if (this.mCurrentConstraintNumber != r9.findMatch(r6, r7)) goto L18;
        return false;
    L18:
        return true;
    L9:
        r8 = this.mStateList.get(r0);
        goto L8
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r1) {
        this.mConstraintsChangedListener = r1;
    }

    public void updateConstraints(int r5, float r6, float r7) {
        int r0 = this.mCurrentStateId;
        if (r0 != r5) goto L29;
        if (r5 != (-1)) goto L6;
        State r8 = this.mStateList.valueAt(0);
    L7:
        int r1 = this.mCurrentConstraintNumber;
        if (r1 != (-1)) goto L10;
    L12:
        int r9 = r8.findMatch(r6, r7);
        if (this.mCurrentConstraintNumber != r9) goto L15;
        return;
    L15:
        if (r9 != (-1)) goto L17;
        ConstraintSet r10 = this.mDefaultConstraintSet;
    L18:
        if (r9 != (-1)) goto L20;
        int r11 = r8.mConstraintID;
    L21:
        if (r10 != null) goto L23;
        return;
    L23:
        this.mCurrentConstraintNumber = r9;
        ConstraintsChangedListener r12 = this.mConstraintsChangedListener;
        if (r12 == null) goto L26;
        r12.preLayoutChange(-1, r11);
    L26:
        r10.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r4 = this.mConstraintsChangedListener;
        if (r4 == null) goto L46;
        r4.postLayoutChange(-1, r11);
        return;
    L46:
        return;
    L20:
        r11 = r8.mVariants.get(r9).mConstraintID;
        goto L21
    L17:
        r10 = r8.mVariants.get(r9).mConstraintSet;
        goto L18
    L10:
        if (r8.mVariants.get(r1).match(r6, r7) == false) goto L12;
        return;
    L6:
        r8 = this.mStateList.get(r0);
        goto L7
    L29:
        this.mCurrentStateId = r5;
        State r2 = this.mStateList.get(r5);
        int r3 = r2.findMatch(r6, r7);
        if (r3 != (-1)) goto L32;
        ConstraintSet r13 = r2.mConstraintSet;
    L33:
        if (r3 != (-1)) goto L35;
        int r14 = r2.mConstraintID;
    L36:
        if (r13 != null) goto L39;
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + r5 + ", dim =" + r6 + ", " + r7);
        return;
    L39:
        this.mCurrentConstraintNumber = r3;
        ConstraintsChangedListener r15 = this.mConstraintsChangedListener;
        if (r15 == null) goto L42;
        r15.preLayoutChange(r5, r14);
    L42:
        r13.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r16 = this.mConstraintsChangedListener;
        if (r16 == null) goto L48;
        r16.postLayoutChange(r5, r14);
        return;
    L48:
        return;
    L35:
        r14 = r2.mVariants.get(r3).mConstraintID;
        goto L36
    L32:
        r13 = r2.mVariants.get(r3).mConstraintSet;
        goto L33
    }
}
