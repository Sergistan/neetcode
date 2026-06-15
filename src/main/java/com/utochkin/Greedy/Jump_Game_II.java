package com.utochkin.Greedy;
/*
Вам дан массив целых чисел nums, где nums[i] обозначает максимальную длину прыжка вправо от индекса i.
Например, если вы находитесь в позиции nums[i], то можете прыгнуть в любую позицию i + j, где: j <= nums[i] i + j < nums.length Изначально вы находитесь в позиции nums[0].
Верните минимальное количество прыжков, необходимых для того, чтобы добраться до последней позиции в массиве (индекс nums.length - 1).
Можно предположить, что правильный ответ всегда существует.
 */
public class Jump_Game_II {
    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};

        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int res = 0;
        int l = 0; // диапазон индексов слева l
        int r = 0; // и справа r (самый правый индекс, который достижим за res прыжков)

        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]); // В каждом окне [l, r] мы выбираем: самую дальнюю позицию, которую можно достичь следующим прыжком (farthest)
            }
            l = r + 1;
            r = farthest;
            res++; // Каждое расширение диапазона = один прыжок
        }
        return res;
    }
}
