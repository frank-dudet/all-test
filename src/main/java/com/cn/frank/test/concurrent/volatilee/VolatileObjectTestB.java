package com.cn.frank.test.concurrent.volatilee;

/**
 * Author: frank_du
 * Time : 2018/6/6 下午2:40
 * https://blog.csdn.net/u014108122/article/details/38173201
 */
public class VolatileObjectTestB implements Runnable {


    private volatile ObjectB objectB;

    public VolatileObjectTestB(ObjectB objectB) {
        this.objectB = objectB;
    }

    public ObjectB getObjectB() {
        return objectB;
    }

    public void setObjectB(ObjectB objectB) {
        this.objectB = objectB;
    }

    @Override
    public void run() {
        long i = 0;
//        ObjectSubB objectSubB = objectB.getObjectSubB();
//        while (objectSubB.isFlag()) {
        while (objectB.getObjectSubB().isFlag()) {
            i++;
//            System.out.println("------------------");
        }
        System.out.println("stop My Thread " + i);
    }

    public static void main(String[] args) throws InterruptedException {
        // 如果启动的时候加上-server 参数则会 输出 Java HotSpot(TM) Server VM
//        System.out.println(System.getProperty("java.vm.name"));

        ObjectSubB objectSubB = new ObjectSubB();
        ObjectB objectB = new ObjectB();
        objectB.setObjectSubB(objectSubB);

        VolatileObjectTestB test = new VolatileObjectTestB(objectB);
        new Thread(test).start();

        Thread.sleep(1000);
//        objectSubB.setFlag(false);
//        objectB.getObjectSubB().setFlag(false);

        new Thread(new StopClass(objectSubB)).start();
        Thread.sleep(1000);
        System.out.println("Main Thread " + objectSubB.isFlag());
    }


    static class ObjectB {

        private ObjectSubB objectSubB;

        public ObjectSubB getObjectSubB() {
            return objectSubB;
        }

        public void setObjectSubB(ObjectSubB objectSubB) {
            this.objectSubB = objectSubB;
        }
    }


    static class ObjectSubB {
        private boolean flag = true;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

    static class StopClass implements Runnable {

        private ObjectSubB objectSubB;

        public StopClass(ObjectSubB objectSubB) {
            this.objectSubB = objectSubB;
        }

        @Override
        public void run() {
            objectSubB.setFlag(false);
        }
    }
}
