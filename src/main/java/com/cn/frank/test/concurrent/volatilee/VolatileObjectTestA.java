package com.cn.frank.test.concurrent.volatilee;

/**
 * Author: frank_du
 * Time : 2018/6/6 下午2:40
 */
public class VolatileObjectTestA implements Runnable {

    //加上volatile 就可以正常结束While循环了
    private volatile ObjectA objectA;

    public VolatileObjectTestA(ObjectA objectA) {
        this.objectA = objectA;
    }

    public ObjectA getObjectA() {
        return objectA;
    }

    public void setObjectA(ObjectA objectA) {
        this.objectA = objectA;
    }

    @Override
    public void run() {
        long i = 0;
        while (objectA.isFlag()) {
            i++;
//            System.out.println("------------------");
        }
        System.out.println("stop My Thread " + i);
    }

    public void stop() {
        objectA.setFlag(false);
    }

    public static void main(String[] args) throws InterruptedException {
        // 如果启动的时候加上-server 参数则会 输出 Java HotSpot(TM) Server VM
//        System.out.println(System.getProperty("java.vm.name"));

        VolatileObjectTestA test = new VolatileObjectTestA(new ObjectA());
        new Thread(test).start();

        Thread.sleep(1000);
        test.stop();
        Thread.sleep(1000);
        System.out.println("Main Thread " + test.getObjectA().isFlag());
    }


    static class ObjectA {
        private boolean flag = true;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

    }
}
