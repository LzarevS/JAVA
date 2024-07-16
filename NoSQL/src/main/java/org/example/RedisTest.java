package org.example;

import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Random;

import static java.lang.System.out;

public class RedisTest {

    private static final String QUEUE_KEY = "user_queue";

    public static void main(String[] args) throws InterruptedException {
        RedissonClient redisson = null;
        try {
            Config config = new Config();
            config.useSingleServer().setAddress("redis://127.0.0.1:6379");
            redisson = org.redisson.Redisson.create(config);
        } catch (RedisConnectionException e) {
            out.println("Не удалось подключиться к Redis");
            out.println(e.getMessage());
            return;
        }

        RQueue<Integer> userQueue = redisson.getQueue(QUEUE_KEY);

        int totalUsers = 20;
        for (int i = 1; i <= totalUsers; i++) {
            userQueue.add(i);
            out.println("Добавлен пользователь " + i + " в очередь");
        }

        Random random = new Random();
        int userToShow;
        while (true) {
            userToShow = userQueue.poll();
            if (userToShow != -1) {
                out.println("— Показываем пользователя " + userToShow + " на главной странице");
                userQueue.add(userToShow); // Перемещаем пользователя в конец очереди
                out.println("Пользователь " + userToShow + " перемещен в конец очереди");
            } else {
                out.println("Очередь пуста.");
            }

            if (random.nextInt(10) == 0) {
                int paidUser = userQueue.poll(); // Пользователь оплачивает услугу, чтобы переместиться в начало очереди
                if (paidUser != -1) {
                    out.println("> Пользователь " + paidUser + " оплатил услугу приоритетного показа\n" +
                            "— Показываем пользователя "  + paidUser   + " на главной странице");
                    userQueue.add(paidUser); // Перемещаем оплатившего пользователя в начало очереди
                    out.println("Пользователь " + paidUser + " перемещен в начало очереди");
                }
            }

            Thread.sleep(1000); // Ждем 1 секунду перед следующей итерацией
        }
    }
}
