package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class Scene {
    private Context mContext;
    private Runnable mEnterAction;
    private Runnable mExitAction;
    private View mLayout;
    private int mLayoutId;
    private ViewGroup mSceneRoot;

    public Scene(@NonNull ViewGroup r2) {
        this.mLayoutId = -1;
        this.mSceneRoot = r2;
    }

    private Scene(ViewGroup r2, int r3, Context r4) {
        this.mLayoutId = -1;
        this.mContext = r4;
        this.mSceneRoot = r2;
        this.mLayoutId = r3;
    }

    public Scene(@NonNull ViewGroup r2, @NonNull View r3) {
        this.mLayoutId = -1;
        this.mSceneRoot = r2;
        this.mLayout = r3;
    }

    @Nullable
    public static Scene getCurrentScene(@NonNull ViewGroup r1) {
        return (Scene) r1.getTag(R.id.transition_current_scene);
    }

    @NonNull
    public static Scene getSceneForLayout(@NonNull ViewGroup r2, @LayoutRes int r3, @NonNull Context r4) {
        int r0 = R.id.transition_scene_layoutid_cache;
        SparseArray r1 = (SparseArray) r2.getTag(r0);
        if (r1 != null) goto L5;
        r1 = new SparseArray();
        r2.setTag(r0, r1);
    L5:
        Scene r5 = (Scene) r1.get(r3);
        if (r5 == null) goto L8;
        return r5;
    L8:
        Scene r6 = new Scene(r2, r3, r4);
        r1.put(r3, r6);
        return r6;
    }

    static void setCurrentScene(@NonNull ViewGroup r1, @Nullable Scene r2) {
        r1.setTag(R.id.transition_current_scene, r2);
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

    public void exit() {
        if (getCurrentScene(this.mSceneRoot) != this) goto L8;
        Runnable r1 = this.mExitAction;
        if (r1 == null) goto L9;
        r1.run();
        return;
    L9:
        return;
    }

    @NonNull
    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    boolean isCreatedFromLayoutResource() {
        if (this.mLayoutId <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setEnterAction(@Nullable Runnable r1) {
        this.mEnterAction = r1;
    }

    public void setExitAction(@Nullable Runnable r1) {
        this.mExitAction = r1;
    }
}
