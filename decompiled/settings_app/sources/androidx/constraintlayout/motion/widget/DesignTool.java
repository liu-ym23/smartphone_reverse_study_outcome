package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class DesignTool implements ProxyInterface {
    private static final boolean DEBUG = false;
    private static final String TAG = "DesignTool";
    static final HashMap<Pair<Integer, Integer>, String> allAttributes = null;
    static final HashMap<String, String> allMargins = null;
    private String mLastEndState;
    private int mLastEndStateId;
    private String mLastStartState;
    private int mLastStartStateId;
    private final MotionLayout mMotionLayout;
    private MotionScene mSceneCache;

    public DesignTool(MotionLayout motionLayout) {
        this.mLastStartState = null;
        this.mLastEndState = null;
        this.mLastStartStateId = -1;
        this.mLastEndStateId = -1;
        this.mMotionLayout = motionLayout;
    }

    static {
        HashMap<Pair<Integer, Integer>, String> r0 = new HashMap();
        allAttributes = r0;
        HashMap<String, String> r1 = new HashMap();
        allMargins = r1;
        r0.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        r0.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        r0.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        r0.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        r0.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        r0.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        r0.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        r0.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        r0.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        r0.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        r0.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        r0.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        r0.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        r1.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        r1.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        r1.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        r1.put("layout_constraintTop_toTopOf", "layout_marginTop");
        r1.put("layout_constraintStart_toStartOf", "layout_marginStart");
        r1.put("layout_constraintStart_toEndOf", "layout_marginStart");
        r1.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        r1.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        r1.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        r1.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        r1.put("layout_constraintRight_toRightOf", "layout_marginRight");
        r1.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    private static int GetPxFromDp(int dpi, String value) {
        if (value != null) goto L5;
        return 0;
    L5:
        int r1 = value.indexOf(100);
        if (r1 != (-1)) goto L9;
        return 0;
    L9:
        return (int) ((Integer.valueOf(value.substring(0, r1)).intValue() * dpi) / 160.0f);
    }

    private static void Connect(int dpi, ConstraintSet set, View view, HashMap<String, String> attributes, int from, int to) {
        String r0 = allAttributes.get(Pair.create(Integer.valueOf(from), Integer.valueOf(to)));
        String r1 = attributes.get(r0);
        if (r1 == null) goto L10;
        String r2 = allMargins.get(r0);
        if (r2 == null) goto L7;
        int r8 = GetPxFromDp(dpi, attributes.get(r2));
    L8:
        int r5 = Integer.parseInt(r1);
        int r3 = view.getId();
        set.connect(r3, from, r5, to, r8);
        return;
    L7:
        r8 = 0;
        goto L8
    }

    private static void SetBias(ConstraintSet set, View view, HashMap<String, String> attributes, int type) {
        if (type != 1) goto L5;
        String r1 = "layout_constraintVertical_bias";
    L6:
        String r4 = attributes.get(r1);
        if (r4 == null) goto L13;
        if (type != 0) goto L10;
        set.setHorizontalBias(view.getId(), Float.parseFloat(r4));
        return;
    L10:
        if (type != 1) goto L15;
        set.setVerticalBias(view.getId(), Float.parseFloat(r4));
        return;
    L15:
        return;
    L13:
        return;
    L5:
        r1 = "layout_constraintHorizontal_bias";
        goto L6
    }

    private static void SetDimensions(int dpi, ConstraintSet set, View view, HashMap<String, String> attributes, int type) {
        if (type != 1) goto L5;
        String r0 = "layout_height";
    L6:
        String r4 = attributes.get(r0);
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.equalsIgnoreCase("wrap_content") == true) goto L11;
        int r1 = GetPxFromDp(dpi, r4);
    L12:
        if (type != 0) goto L14;
        set.constrainWidth(view.getId(), r1);
        return;
    L14:
        set.constrainHeight(view.getId(), r1);
        return;
    L11:
        r1 = -2;
        goto L12
    L5:
        r0 = "layout_width";
        goto L6
    }

    private static void SetAbsolutePositions(int dpi, ConstraintSet set, View view, HashMap<String, String> attributes) {
        String r0 = attributes.get("layout_editor_absoluteX");
        if (r0 == null) goto L5;
        set.setEditorAbsoluteX(view.getId(), GetPxFromDp(dpi, r0));
    L5:
        String r5 = attributes.get("layout_editor_absoluteY");
        if (r5 == null) goto L9;
        set.setEditorAbsoluteY(view.getId(), GetPxFromDp(dpi, r5));
        return;
    }

    public int getAnimationPath(Object view, float[] path, int len) {
        if (this.mMotionLayout.mScene != null) goto L6;
        return -1;
    L6:
        MotionController r1 = this.mMotionLayout.mFrameArrayList.get(view);
        if (r1 != null) goto L10;
        return 0;
    L10:
        r1.buildPath(path, len);
        return len;
    }

    public void getAnimationRectangles(Object view, float[] path) {
        if (this.mMotionLayout.mScene != null) goto L5;
        return;
    L5:
        int r0 = this.mMotionLayout.mScene.getDuration() / 16;
        MotionController r1 = this.mMotionLayout.mFrameArrayList.get(view);
        if (r1 != null) goto L8;
        return;
    L8:
        r1.buildRectangles(path, r0);
    }

    public int getAnimationKeyFrames(Object view, float[] key) {
        if (this.mMotionLayout.mScene != null) goto L6;
        return -1;
    L6:
        int r0 = this.mMotionLayout.mScene.getDuration() / 16;
        MotionController r1 = this.mMotionLayout.mFrameArrayList.get(view);
        if (r1 != null) goto L10;
        return 0;
    L10:
        r1.buildKeyFrames(key, null);
        return r0;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float position) {
        if (this.mMotionLayout.mScene != null) goto L5;
        MotionLayout r0 = this.mMotionLayout;
        r0.mScene = this.mSceneCache;
    L5:
        this.mMotionLayout.setProgress(position);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setState(String id) {
        if (id != null) goto L5;
        id = "motion_base";
    L5:
        if (this.mLastStartState != id) goto L7;
        return;
    L7:
        this.mLastStartState = id;
        this.mLastEndState = null;
        if (this.mMotionLayout.mScene != null) goto L10;
        MotionLayout r0 = this.mMotionLayout;
        r0.mScene = this.mSceneCache;
    L10:
        int r3 = this.mMotionLayout.lookUpConstraintId(id);
        this.mLastStartStateId = r3;
        if (r3 != 0) goto L13;
    L19:
        this.mMotionLayout.requestLayout();
        return;
    L13:
        if (r3 != this.mMotionLayout.getStartState()) goto L16;
        this.mMotionLayout.setProgress(0.0f);
        goto L19
    L16:
        if (r3 != this.mMotionLayout.getEndState()) goto L18;
        this.mMotionLayout.setProgress(1.0f);
        goto L19
    L18:
        this.mMotionLayout.transitionToState(r3);
        this.mMotionLayout.setProgress(1.0f);
        goto L19
    }

    public String getStartState() {
        int r0 = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == r0) goto L5;
        String r1 = this.mMotionLayout.getConstraintSetNames(r0);
        if (r1 == null) goto L10;
        this.mLastStartState = r1;
        this.mLastStartStateId = r0;
    L10:
        return this.mMotionLayout.getConstraintSetNames(r0);
    L5:
        return this.mLastStartState;
    }

    public String getEndState() {
        int r0 = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == r0) goto L5;
        String r1 = this.mMotionLayout.getConstraintSetNames(r0);
        if (r1 == null) goto L9;
        this.mLastEndState = r1;
        this.mLastEndStateId = r0;
    L9:
        return r1;
    L5:
        return this.mLastEndState;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getState() {
        if (this.mLastStartState == null) goto L15;
        if (this.mLastEndState == null) goto L15;
        float r0 = getProgress();
        if (r0 > 0.01f) goto L11;
        return this.mLastStartState;
    L11:
        if (r0 < 0.99f) goto L15;
        return this.mLastEndState;
    L15:
        return this.mLastStartState;
    }

    public boolean isInTransition() {
        if (this.mLastStartState != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLastEndState == null) goto L7;
        return true;
    }

    public void setTransition(String start, String end) {
        if (this.mMotionLayout.mScene != null) goto L5;
        MotionLayout r0 = this.mMotionLayout;
        r0.mScene = this.mSceneCache;
    L5:
        int r1 = this.mMotionLayout.lookUpConstraintId(start);
        int r2 = this.mMotionLayout.lookUpConstraintId(end);
        this.mMotionLayout.setTransition(r1, r2);
        this.mLastStartStateId = r1;
        this.mLastEndStateId = r2;
        this.mLastStartState = start;
        this.mLastEndState = end;
    }

    public void disableAutoTransition(boolean disable) {
        this.mMotionLayout.disableAutoTransition(disable);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public int getKeyFramePositions(Object view, int[] type, float[] pos) {
        MotionController r0 = this.mMotionLayout.mFrameArrayList.get((View) view);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getKeyFramePositions(type, pos);
    }

    public int getKeyFrameInfo(Object view, int type, int[] info) {
        MotionController r0 = this.mMotionLayout.mFrameArrayList.get((View) view);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getKeyFrameInfo(type, info);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(Object view, int type, float x, float y) {
        if ((view instanceof View) == true) goto L5;
        return 0.0f;
    L5:
        MotionController r2 = this.mMotionLayout.mFrameArrayList.get((View) view);
        if (r2 != null) goto L9;
        return 0.0f;
    L9:
        return r2.getKeyFrameParameter(type, x, y);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setKeyFrame(Object view, int position, String name, Object value) {
        if (this.mMotionLayout.mScene == null) goto L6;
        this.mMotionLayout.mScene.setKeyframe((View) view, position, name, value);
        this.mMotionLayout.mTransitionGoalPosition = position / 100.0f;
        this.mMotionLayout.mTransitionLastPosition = 0.0f;
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(Object view, int position, int type, float x, float y) {
        if ((view instanceof View) == true) goto L6;
        return false;
    L6:
        if (this.mMotionLayout.mScene == null) goto L13;
        MotionController r4 = this.mMotionLayout.mFrameArrayList.get(view);
        int r0 = (int) (this.mMotionLayout.mTransitionPosition * 100.0f);
        if (r4 == null) goto L13;
        View r3 = (View) view;
        if (this.mMotionLayout.mScene.hasKeyFramePosition(r3, r0) == false) goto L13;
        float r5 = r4.getKeyFrameParameter(2, x, y);
        float r6 = r4.getKeyFrameParameter(5, x, y);
        this.mMotionLayout.mScene.setKeyframe(r3, r0, "motion:percentX", Float.valueOf(r5));
        this.mMotionLayout.mScene.setKeyframe(r3, r0, "motion:percentY", Float.valueOf(r6));
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.invalidate();
        return true;
    L13:
        return false;
    }

    public void setViewDebug(Object view, int debugMode) {
        if ((view instanceof View) == true) goto L5;
        return;
    L5:
        MotionController r2 = this.mMotionLayout.mFrameArrayList.get(view);
        if (r2 == null) goto L9;
        r2.setDrawPath(debugMode);
        this.mMotionLayout.invalidate();
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int cmd, String type, Object viewObject, float[] in, int inLength, float[] out, int outLength) {
        View r4 = (View) viewObject;
        if (cmd != 0) goto L5;
        MotionController r5 = null;
    L13:
        if (cmd == 0) goto L26;
        if (cmd != 1) goto L16;
        int r1 = this.mMotionLayout.mScene.getDuration() / 16;
        r5.buildPath(out, r1);
        return r1;
    L16:
        if (cmd != 2) goto L18;
        int r2 = this.mMotionLayout.mScene.getDuration() / 16;
        r5.buildKeyFrames(out, null);
        return r2;
    L18:
        if (cmd == 3) goto L20;
        return -1;
    L20:
        int r3 = this.mMotionLayout.mScene.getDuration() / 16;
        return r5.getAttributeValues(type, out, outLength);
    L26:
        return 1;
    L5:
        if (this.mMotionLayout.mScene != null) goto L7;
        return -1;
    L7:
        if (r4 == null) goto L10;
        r5 = this.mMotionLayout.mFrameArrayList.get(r4);
        if (r5 != null) goto L13;
    L10:
        return -1;
    }

    public Object getKeyframe(int type, int target, int position) {
        if (this.mMotionLayout.mScene != null) goto L7;
        return null;
    L7:
        return this.mMotionLayout.mScene.getKeyFrame(this.mMotionLayout.getContext(), type, target, position);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Object getKeyframeAtLocation(Object viewObject, float x, float y) {
        View r2 = (View) viewObject;
        if (this.mMotionLayout.mScene != null) goto L7;
        return -1;
    L7:
        if (r2 == null) goto L13;
        MotionController r1 = this.mMotionLayout.mFrameArrayList.get(r2);
        if (r1 != null) goto L11;
        return null;
    L11:
        ViewGroup r3 = (ViewGroup) r2.getParent();
        return r1.getPositionKeyframe(r3.getWidth(), r3.getHeight(), x, y);
    L13:
        return null;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Boolean getPositionKeyframe(Object keyFrame, Object view, float x, float y, String[] attribute, float[] value) {
        if ((keyFrame instanceof KeyPositionBase) == false) goto L7;
        KeyPositionBase r3 = (KeyPositionBase) keyFrame;
        View r2 = (View) view;
        this.mMotionLayout.mFrameArrayList.get(r2).positionKeyframe(r2, r3, x, y, attribute, value);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return true;
    L7:
        return false;
    }

    public Object getKeyframe(Object view, int type, int position) {
        if (this.mMotionLayout.mScene != null) goto L6;
        return null;
    L6:
        int r2 = ((View) view).getId();
        return this.mMotionLayout.mScene.getKeyFrame(this.mMotionLayout.getContext(), type, r2, position);
    }

    public void setKeyframe(Object keyFrame, String tag, Object value) {
        if ((keyFrame instanceof Key) == false) goto L6;
        ((Key) keyFrame).setValue(tag, value);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setAttributes(int dpi, String constraintSetId, Object opaqueView, Object opaqueAttributes) {
        View r12 = (View) opaqueView;
        HashMap r13 = (HashMap) opaqueAttributes;
        int r11 = this.mMotionLayout.lookUpConstraintId(constraintSetId);
        ConstraintSet r6 = this.mMotionLayout.mScene.getConstraintSet(r11);
        if (r6 != null) goto L5;
        return;
    L5:
        r6.clear(r12.getId());
        SetDimensions(dpi, r6, r12, r13, 0);
        SetDimensions(dpi, r6, r12, r13, 1);
        Connect(dpi, r6, r12, r13, 6, 6);
        Connect(dpi, r6, r12, r13, 6, 7);
        Connect(dpi, r6, r12, r13, 7, 7);
        Connect(dpi, r6, r12, r13, 7, 6);
        Connect(dpi, r6, r12, r13, 1, 1);
        Connect(dpi, r6, r12, r13, 1, 2);
        Connect(dpi, r6, r12, r13, 2, 2);
        Connect(dpi, r6, r12, r13, 2, 1);
        Connect(dpi, r6, r12, r13, 3, 3);
        Connect(dpi, r6, r12, r13, 3, 4);
        Connect(dpi, r6, r12, r13, 4, 3);
        Connect(dpi, r6, r12, r13, 4, 4);
        Connect(dpi, r6, r12, r13, 5, 5);
        SetBias(r6, r12, r13, 0);
        SetBias(r6, r12, r13, 1);
        SetAbsolutePositions(dpi, r6, r12, r13);
        this.mMotionLayout.updateState(r11, r6);
        this.mMotionLayout.requestLayout();
    }

    public void dumpConstraintSet(String set) {
        if (this.mMotionLayout.mScene != null) goto L5;
        this.mMotionLayout.mScene = this.mSceneCache;
    L5:
        int r0 = this.mMotionLayout.lookUpConstraintId(set);
        System.out.println(" dumping  " + set + " (" + r0 + ")");
        this.mMotionLayout.mScene.getConstraintSet(r0).dump(this.mMotionLayout.mScene, new int[0]);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
