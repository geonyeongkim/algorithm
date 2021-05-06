package main.leetcode.greedy;

/*
* greedy로 해결 가능!!! -> O(1)
* 현재 idx에서 가장 멀리갈 수 있는 값(currMax)과, 다음으로 가장 멀리갈 수 있는 값(nextMax)을 for-each에서 구함.
*
* i가 currMax 라는 것은 한번 jump step을 할때가 되었다는 의미이며, jump시에는 가장 멀리갈 수 있는 nextMax를 사용.
*
* 문제 마지막에 어떻게든 last index에는 도달한다는 가정이 있기에 greedy 문제가 되지 않았나 생각이 듬.
* 그렇지 않고, 딱 last index에 맞게 갈 수 있는 최소 점프 수를 구하는거라면 dp로 해야할걸로 예상
* */
public class JumpGameIIGreedy {
    public int jump(int[] nums) {
        int count = 0, currMax = 0, nextMax = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);

            if (i == currMax) {
                count++;
                currMax = nextMax;
            }
        }

        return count;
    }
}
