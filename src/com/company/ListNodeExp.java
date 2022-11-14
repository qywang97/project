package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ListNodeExp {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
            HashMap<String, Integer> map = new HashMap<>();
            int one_word = words[0].length();
            int word_num = words.length;
            int all_len = one_word * word_num;
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            for (int i = 0; i < s.length() - all_len + 1; i++) {
                String tmp = s.substring(i, i + all_len);
                HashMap<String, Integer> tmp_map = new HashMap<>();
                for (int j = 0; j < all_len; j += one_word) {
                    String w = tmp.substring(j, j + one_word);
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                }
                if (map.equals(tmp_map)) res.add(i);
            }
            return res;
        }
    }
    public void swap(int[] nums, int i, int j) {//交换位置
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {//数组反转
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


    class Solution1 {
        public int divide(int dividend, int divisor) {
            // 考虑被除数为最小值的情况
            if (dividend == Integer.MIN_VALUE) {
                if (divisor == 1) {
                    return Integer.MIN_VALUE;
                }
                if (divisor == -1) {
                    return Integer.MAX_VALUE;
                }
            }
            // 考虑除数为最小值的情况
            if (divisor == Integer.MIN_VALUE) {
                return dividend == Integer.MIN_VALUE ? 1 : 0;
            }
            // 考虑被除数为 0 的情况
            if (dividend == 0) {
                return 0;
            }

            // 一般情况，使用二分查找
            // 将所有的正数取相反数，这样就只需要考虑一种情况
            boolean rev = false;
            if (dividend > 0) {
                dividend = -dividend;
                rev = !rev;
            }
            if (divisor > 0) {
                divisor = -divisor;
                rev = !rev;
            }

            int left = 1, right = Integer.MAX_VALUE, ans = 0;
            while (left <= right) {
                // 注意溢出，并且不能使用除法
                int mid = left + ((right - left) >> 1);
                boolean check = quickAdd(divisor, mid, dividend);
                if (check) {
                    ans = mid;
                    // 注意溢出
                    if (mid == Integer.MAX_VALUE) {
                        break;
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return rev ? -ans : ans;
        }

        // 快速乘
        public boolean quickAdd(int y, int z, int x) {
            // x 和 y 是负数，z 是正数
            // 需要判断 z * y >= x 是否成立
            int result = 0, add = y;
            while (z != 0) {
                if ((z & 1) != 0) {
                    // 需要保证 result + add >= x
                    if (result < x - add) {
                        return false;
                    }
                    result += add;
                }
                if (z != 1) {
                    // 需要保证 add + add >= x
                    if (add < x - add) {
                        return false;
                    }
                    add += add;
                }
                // 不能使用除法
                z >>= 1;
            }
            return true;
        }
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m+n];
        int p1 = 0, p2 =0;
        while (p1 < m || p2 < n){
            if (p1 == m){
                temp[p1 + p2] = nums2[p2];
                p2 ++;
            }
            else if (p2 == n){
                temp[p1 + p2] = nums1[p1];
                p1 ++;
            }
            else if (nums1[p1]<nums2[p2]){
                temp[p1 + p2] = nums1[p1];
                p1 ++;
            }
            else{
                temp[p1 + p2] = nums2[p2];
                p2 ++;
            }
        }
        for (int i = 0;i <m+n;i++){
            nums1[i] = temp[i];
        }

    }

    public static void main(String[] args) {
        //先创建几个节点
        HeroNode heroNode1 = new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3 = new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4 = new HeroNode(4,"林冲","豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入节点
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode4);

        //显示链表
        singleLinkedList.list();
        System.out.println(generateParenthesis(3));
        System.out.println(combinationSum(new int[]{2147483647,2147483646,2147483645,3,2,1,-1,0,-2147483648},7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
//        dfs(candidates, target, ans, combine, idx + 1);
        dfs(candidates, target - candidates[idx], ans, combine, idx+1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx+1);
            combine.remove(combine.size() - 1);
        }
    }

    static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if(cur.length()==max*2){
            ans.add(cur.toString());
            return;
        }
        if (open < max){
            cur.append("(");
            backtrack(ans,cur,open+1,close,max);
            cur.deleteCharAt(cur.length()-1);
        }
        if (close < open){
            cur.append(")");
            backtrack(ans,cur,open,close+1,max);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}

//定义SingleLinkList管理我们的英雄
class SingleLinkedList{//每个链表都要建一个类来维护
    //先初始化一个头结点,头节点不要动,不存放具体的数据
    private HeroNode head = new HeroNode(0,"","");

    //添加节点到单链表
    //当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后的这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能动，因此需要一个辅助变量temp遍历
        HeroNode temp = head;
        //遍历链表找到最后
        while(true){
            //找到链表的最后
            if(temp.next==null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp= temp.next;
        }
        //退出white循环时，temp就指向了链表的最后
        temp.next = heroNode;
    }

    //根据排名将英雄插入到指定的位置
    //如果有这个排名，添加失败，给出提示
    public void addByOrder(HeroNode heroNode){
        //因为头结点不能动，所以仍然通过一个辅助变量找到添加的位置
        //找的temp应该位于添加位置的前一个节点，否则加不进去
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在，默认为false
        while (true){
            if(temp.next==null){
                break;
            }
            //temp.next.no>heroNode.no位置找到了，就在temp和temp.next之间插入
            //temp.next.no<heroNode.no就继续找，因为不确定后面还有没有更小的
            if(temp.next.no>heroNode.no){//位置找到了，就在temp和temp.next之间插入
                break;
            }else if(temp.next.no == heroNode.no){//说明希望添加的heroNode节点已经存在
                flag = true;//说明编号已经存在
                break;
            }
            //后移
            temp = temp.next;
        }
        //退出循环后，先判断flag的值
        if(flag){//不能添加,说明编号已经存在
            System.out.printf("准备插入英雄的编号%d已经存在了，不能加入\n",heroNode.no);
        }else{
            //插入到链表中,temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    public int searchInsert(int[] nums, int target) {
        if(nums.length<1){
            return 0;
        }
        int l = 0 ,r=nums.length;
        int index = 0;
        while (l<r){
            int m = (l+r)/2;
            if(nums[m]==target ){
                index = m;
                break;
            }
            if(nums[m]>target && m<nums.length-1){
                if(nums[m+1]<target){
                    index=m+1;
                    break;
                }
                r = m - 1;
            }
            else{
                if(nums[m-1]>target && m>0){
                    index=m-1;
                    break;
                }
                l = m+1;
            }
        }
        return index;
    }
    //显示链表
    public void list(){
        //先判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因袭需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            //判断链表是否到最后
            if(temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

}
class Solution {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();


    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }


}
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //构造方法
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                '}';
    }
//    public boolean isValid(String s) {
//        int n = s.length();
//        if (n % 2 == 1) {
//            return false;
//        }
//
//        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
//            put(')', '(');
//            put(']', '[');
//            put('}', '{');
//        }};
//        Deque<Character> stack = new LinkedList<Character>();
//        for (int i = 0; i < n; i++) {
//            char temp = s.charAt(i);
//            if (pairs.containsKey(temp)) {
//                if (stack.isEmpty()||stack.peek()!=pairs.get(temp)){
//                    return false;
//                }
//                stack.pop();
//            }
//            else{
//                stack.push(temp);
//            }
//        }
//        return  stack.isEmpty();
//    }
public HeroNode mergeTwoLists(HeroNode l1, HeroNode l2) {// 递归需要有终止条件
    if (l1 == null) {
        return l2;
    } else if (l2 == null) {
        return l1;
    } else if (l1.no < l2.no) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}




}

