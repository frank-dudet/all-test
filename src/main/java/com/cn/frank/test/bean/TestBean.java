package com.cn.frank.test.bean;


import java.util.List;

/**
 * Author: frank_du
 * Time : 2017/2/20 下午7:47
 */
public class TestBean implements Comparable<TestBean>{

    private String className;

    private String methodName;

    private List<String> list;


    public TestBean() {
    }

    public TestBean(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public int compareTo(TestBean o) {
        if(o.getClassName().equalsIgnoreCase(className)) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestBean)) return false;

        TestBean bean = (TestBean) o;

        if (className != null ? !className.equals(bean.className) : bean.className != null) return false;
        return true;

    }

    @Override
    public int hashCode() {
        int result = className != null ? className.hashCode() : 0;
        result = 31 * result + (methodName != null ? methodName.hashCode() : 0);
        return result;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
