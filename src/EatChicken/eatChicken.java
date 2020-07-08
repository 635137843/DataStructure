package EatChicken;

public class eatChicken {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Productor(container).start();
        new Customer(container).start();
    }


}

//定义一只鸡
class Chicken {
    private int id;//商品编号

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

//生产者
class Productor extends Thread {
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    //生产
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("生产了" + i + "只鸡");
            container.push(new Chicken(i));
        }
    }
}

//消费者
class Customer extends Thread {
    SynContainer container;

    public Customer(SynContainer container) {
        this.container = container;
    }

    //消费
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            container.pop();
            System.out.println("消费了-----" + container.pop().getId() + "只鸡");
        }
    }
}

//缓冲区
class SynContainer {
    //定义容器大小
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int count;

    public synchronized void push(Chicken chicken) {
        //如果容器满了，就需要等待消费者消费
        if (count == chickens.length - 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        chickens[count] = chicken;

        count++;
        //可以通知消费者消费了
        this.notifyAll();
    }

    public synchronized Chicken pop() {
        //是否有产品可消费
        if (count == 0) {
            //等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        Chicken chicken = chickens[count];

        this.notifyAll();
        return chicken;
    }
}
