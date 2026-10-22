package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class Scene {
    private Context mContext;
    private Runnable mEnterAction;
    private Runnable mExitAction;
    private View mLayout;
    private int mLayoutId;
    private ViewGroup mSceneRoot;

    public static Scene getSceneForLayout(ViewGroup r2, int r3, Context r4) {
        SparseArray r0 = (SparseArray) r2.getTag(R.id.transition_scene_layoutid_cache);
        if (r0 != null) goto L5;
        r0 = new SparseArray();
        r2.setTag(R.id.transition_scene_layoutid_cache, r0);
    L5:
        Scene r1 = (Scene) r0.get(r3);
        if (r1 == null) goto L8;
        return r1;
    L8:
        Scene r5 = new Scene(r2, r3, r4);
        r0.put(r3, r5);
        return r5;
    }

    public Scene(ViewGroup r2) {
        this.mLayoutId = -1;
        this.mSceneRoot = r2;
    }

    private Scene(ViewGroup r1, int r2, Context r3) {
        this.mContext = r3;
        this.mSceneRoot = r1;
        this.mLayoutId = r2;
    }

    public Scene(ViewGroup r2, View r3) {
        this.mLayoutId = -1;
        this.mSceneRoot = r2;
        this.mLayout = r3;
    }

    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    public void exit() {
        if (getCurrentScene(this.mSceneRoot) != this) goto L8;
        Runnable r1 = this.mExitAction;
        if (r1 == null) goto L9;
        r1.run();
        return;
    L9:
        return;
    }

    public void enter() {
        if (this.mLayoutId <= 0) goto L5;
    L6:
        getSceneRoot().removeAllViews();
        if (this.mLayoutId <= 0) goto L9;
        LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
    L10:
        Runnable r0 = this.mEnterAction;
        if (r0 == null) goto L13;
        r0.run();
    L13:
        setCurrentScene(this.mSceneRoot, this);
        return;
    L9:
        this.mSceneRoot.addView(this.mLayout);
        goto L10
    L5:
        if (this.mLayout == null) goto L10;
        goto L6
    }

    static void setCurrentScene(ViewGroup r1, Scene r2) {
        r1.setTag(R.id.transition_current_scene, r2);
    }

    public static Scene getCurrentScene(ViewGroup r1) {
        return (Scene) r1.getTag(R.id.transition_current_scene);
    }

    public void setEnterAction(Runnable r1) {
        this.mEnterAction = r1;
    }

    public void setExitAction(Runnable r1) {
        this.mExitAction = r1;
    }

    boolean isCreatedFromLayoutResource() {
        if (this.mLayoutId <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
