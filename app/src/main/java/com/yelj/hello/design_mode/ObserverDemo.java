package com.yelj.hello.design_mode;

import java.util.ArrayList;

/**
 * Author: Alex.ylj
 * 2019-05-09 15:58 Thursday
 * Description: 观察者模式
 */
public class ObserverDemo {

    //抽象观察者
    interface Watcher {

        void update();
    }

    //抽象被观察者
    interface Watched {

        void addWatcher(Watcher watcher);

        void removeWatcher(Watcher watcher);

        void notifyWatcher();
    }

    //具体的观察者
    public static class Police implements Watcher {

        @Override
        public void update() {
            System.out.println("我是警察");
        }
    }

    public static class Thief implements Watcher {

        @Override
        public void update() {
            System.out.println("我是小偷");
        }
    }

    //具体的被观察者
    public static class BossMoney implements Watched {

        private ArrayList<Watcher> watchers = new ArrayList<>();

        @Override
        public void addWatcher(Watcher watcher) {
            watchers.add(watcher);
        }

        @Override
        public void removeWatcher(Watcher watcher) {
            watchers.remove(watcher);
        }

        @Override
        public void notifyWatcher() {
            for (Watcher watcher : watchers) {
                System.out.println("收到通知 className: " + watcher.getClass().getSimpleName());
                watcher.update();
            }
        }
    }

    public static void main(String[] args) {
        BossMoney bossMoney = new BossMoney();

        Police police = new Police();
        Thief thief = new Thief();

        bossMoney.addWatcher(police);
        bossMoney.addWatcher(thief);

        bossMoney.notifyWatcher();
    }
}
