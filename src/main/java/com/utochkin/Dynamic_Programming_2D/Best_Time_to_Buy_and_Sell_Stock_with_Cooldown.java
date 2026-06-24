package com.utochkin.Dynamic_Programming_2D;

import java.util.HashMap;
import java.util.Map;

/*
Вам дан целочисленный массив prices, где prices[i] — цена NeetCoin в i-й день.
Вы можете покупать и продавать один NeetCoin несколько раз, но с учетом следующих ограничений:
    - После продажи NeetCoin вы не сможете купить еще один на следующий день (то есть период ожидания составляет один день).
    - Одновременно у вас может быть не более одного NeetCoin.
Вы можете совершать столько транзакций, сколько захотите.
Верните максимальную прибыль, которую вы можете получить.
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    private static Map<String, Integer> dp = new HashMap<>();

    public static int maxProfit(int[] prices) {
        return dfs(0, true, prices); // Какую максимальную прибыль можно получить начиная с дня i. buying = true -> У меня нет акции. Я могу купить.
    }

    /*
        Из состояния покупки:
        dfs(i,true)
        есть два действия:
        купить
        или
        пропустить день

        Из состояния продажи:
        dfs(i,false)
        есть два действия:
        продать
        или
        держать дальше

        И рекурсия перебирает все возможные стратегии, а memo не даёт пересчитывать одинаковые состояния повторно.
     */
    private static int dfs(int i, boolean buying, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }

        String key = i + "-" + buying;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int cooldown = dfs(i + 1, buying, prices); // Ничего не делаем
        if (buying) {
            int buy = dfs(i + 1, false, prices) - prices[i]; // купили
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(i + 2, true, prices) + prices[i]; // продали (i + 2 т.к. после продажи покупать можно только через день)
            dp.put(key, Math.max(sell, cooldown));
        }

        return dp.get(key);
    }

    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 0, 2};

        System.out.println(maxProfit(prices));
    }
}
