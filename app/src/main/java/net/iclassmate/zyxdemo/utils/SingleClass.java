package net.iclassmate.zyxdemo.utils;

/**
 * Created by xydbj on 2016.11.22.
 */
public class SingleClass {

    //持有私有的静态实例，防止被引用
    private static SingleClass singleClass = null;

    //构造私有方法，防止被实例化
    private SingleClass(){

    }

    //双重锁定:只在第一次初始化的时候加上同步锁
    public static SingleClass getInstance(){
        if (singleClass == null){
            synchronized (SingleClass.class){
                if (singleClass == null){
                    singleClass = new SingleClass();
                }
            }
        }
        return  singleClass;
    }
}
