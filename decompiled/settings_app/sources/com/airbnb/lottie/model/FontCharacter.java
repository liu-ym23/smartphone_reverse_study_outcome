package com.airbnb.lottie.model;

import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FontCharacter {
    private final char character;
    private final String fontFamily;
    private final List<ShapeGroup> shapes;
    private final double size;
    private final String style;
    private final double width;

    public static int hashFor(char r1, String r2, String r3) {
        return ((((0 + r1) * 31) + r2.hashCode()) * 31) + r3.hashCode();
    }

    public FontCharacter(List<ShapeGroup> r1, char r2, double r3, double r5, String r7, String r8) {
        this.shapes = r1;
        this.character = r2;
        this.size = r3;
        this.width = r5;
        this.style = r7;
        this.fontFamily = r8;
    }

    public List<ShapeGroup> getShapes() {
        return this.shapes;
    }

    double getSize() {
        return this.size;
    }

    public double getWidth() {
        return this.width;
    }

    String getStyle() {
        return this.style;
    }

    public int hashCode() {
        return hashFor(this.character, this.fontFamily, this.style);
    }
}
