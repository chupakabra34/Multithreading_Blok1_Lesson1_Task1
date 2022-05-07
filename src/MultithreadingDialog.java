/**
 * \* Created with IntelliJ IDEA.
 * \* Author: Prekrasnov Sergei
 * \* Date: 05.05.2022
 * \* ----- group JAVA-27 -----
 * \*
 * \* Description: Домашнее задание к занятию 1.1 Многопоточное (параллельное) программирование. Работа с потоками
 * \*
 * \* Задача: Межпоточный диалог
 * \
 */
public class MultithreadingDialog {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup myGroup = new ThreadGroup("MyThread");
        final Thread firstThread = new MyThread(myGroup,"Поток - 1");
        final Thread secondThread = new MyThread(myGroup, "Поток - 2");
        final Thread threeThread = new MyThread(myGroup, "Поток - 3");
        final Thread fourThread = new MyThread(myGroup, "Поток - 4");
        System.out.println("Начинаем создавать потоки...");
        firstThread.start();
        secondThread.start();
        threeThread.start();
        fourThread.start();
        Thread.sleep(10000);
        myGroup.interrupt();
        firstThread.join();
        secondThread.join();
        threeThread.join();
        fourThread.join();
        System.out.println("Завершаем все потоки...");
    }
}