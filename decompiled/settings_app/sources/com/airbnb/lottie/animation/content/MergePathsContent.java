package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class MergePathsContent implements PathContent, GreedyContent {
    private final Path firstPath;
    private final MergePaths mergePaths;
    private final String name;
    private final Path path;
    private final List<PathContent> pathContents;
    private final Path remainderPath;

    /* JADX INFO: renamed from: com.airbnb.lottie.animation.content.MergePathsContent$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode = null;

        static {
            int[] r0 = new int[MergePaths.MergePathsMode.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode = r0;
            r0[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.ADD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public MergePathsContent(MergePaths r2) {
        this.firstPath = new Path();
        this.remainderPath = new Path();
        this.path = new Path();
        this.pathContents = new ArrayList();
        this.name = r2.getName();
        this.mergePaths = r2;
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void absorbContent(ListIterator<Content> r3) {
    L3:
        if (r3.hasPrevious() == false) goto L8;
        if (r3.previous() != this) goto L3;
    L8:
        if (r3.hasPrevious() == false) goto L12;
        Content r0 = r3.previous();
        if ((r0 instanceof PathContent) == false) goto L8;
        this.pathContents.add((PathContent) r0);
        r3.remove();
        goto L8
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> r3, List<Content> r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.pathContents.size()) goto L6;
        this.pathContents.get(r0).setContents(r3, r4);
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        this.path.reset();
        if (this.mergePaths.isHidden() == true) goto L5;
        int r0 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$MergePaths$MergePathsMode[this.mergePaths.getMode().ordinal()];
        if (r0 != 1) goto L9;
        addPaths();
    L23:
        return this.path;
    L9:
        if (r0 != 2) goto L11;
        opFirstPathWithRest(Path.Op.UNION);
        goto L23
    L11:
        if (r0 != 3) goto L13;
        opFirstPathWithRest(Path.Op.REVERSE_DIFFERENCE);
        goto L23
    L13:
        if (r0 != 4) goto L15;
        opFirstPathWithRest(Path.Op.INTERSECT);
        goto L23
    L15:
        if (r0 != 5) goto L23;
        opFirstPathWithRest(Path.Op.XOR);
        goto L23
    L5:
        return this.path;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    private void addPaths() {
        int r0 = 0;
    L4:
        if (r0 >= this.pathContents.size()) goto L6;
        this.path.addPath(this.pathContents.get(r0).getPath());
        r0 = r0 + 1;
        goto L4
    }

    private void opFirstPathWithRest(Path.Op r8) {
        this.remainderPath.reset();
        this.firstPath.reset();
        int r0 = this.pathContents.size() - 1;
    L3:
        if (r0 < 1) goto L11;
        PathContent r2 = this.pathContents.get(r0);
        if ((r2 instanceof ContentGroup) == false) goto L9;
        ContentGroup r3 = (ContentGroup) r2;
        List<PathContent> r4 = r3.getPathList();
        int r5 = r4.size() - 1;
    L7:
        if (r5 < 0) goto L10;
        Path r6 = r4.get(r5).getPath();
        r6.transform(r3.getTransformationMatrix());
        this.remainderPath.addPath(r6);
        r5 = r5 - 1;
    L10:
        r0 = r0 - 1;
        goto L3
    L9:
        this.remainderPath.addPath(r2.getPath());
        goto L10
    L11:
        int r1 = 0;
        PathContent r7 = this.pathContents.get(0);
        if ((r7 instanceof ContentGroup) == false) goto L17;
        ContentGroup r9 = (ContentGroup) r7;
        List<PathContent> r10 = r9.getPathList();
    L15:
        if (r1 >= r10.size()) goto L18;
        Path r11 = r10.get(r1).getPath();
        r11.transform(r9.getTransformationMatrix());
        this.firstPath.addPath(r11);
        r1 = r1 + 1;
    L18:
        this.path.op(this.firstPath, this.remainderPath, r8);
        return;
    L17:
        this.firstPath.set(r7.getPath());
        goto L18
    }
}
