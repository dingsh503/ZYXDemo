package net.iclassmate.zyxdemo.bean;

/**
 * Created by xydbj on 2016.11.28.
 */
public class GradeClass {
    private int type;
    private ClassClass classClass;

    @Override
    public String toString() {
        return "GradeClass{" +
                "type=" + type +
                ", classClass=" + classClass +
                '}';
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ClassClass getClassClass() {
        return classClass;
    }

    public void setClassClass(ClassClass classClass) {
        this.classClass = classClass;
    }
}
