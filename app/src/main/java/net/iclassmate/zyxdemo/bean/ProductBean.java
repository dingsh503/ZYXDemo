package net.iclassmate.zyxdemo.bean;

/**
 * Created by xydbj on 2017.3.24.
 */

public class ProductBean {

    private String name;
    private int id;

    public ProductBean(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
