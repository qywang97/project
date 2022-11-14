package com.company;

import com.company.SingleTon.SingletonEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    static List<String> list = new ArrayList<>();
    public static String getPermutation(int n, int k) {
        boolean []b = new boolean[n];
        int row = 0;
        StringBuilder res = new StringBuilder();
        find(n,res,row,b,k);
        return list.get(k-1);
    }
    public static void find(int n ,StringBuilder res,int row,boolean[]b,int k){
        List<String> list1 = new ArrayList<>(4);
        if (row == n){
            list.add(res.toString());
            res = new StringBuilder();
            return ;
        }

        for(int i = 0; i < n ; i++){
            if (b[i]){
                continue;
            }
            b[i] = true;
            res.append(i+1);
            find(n,res,row+1,b,k);
            res.delete(row,row+1);
            b[i] = false;
            if (list.size() == k){
                return;
            }
        }
    }
//    public ListNode rotateRight(ListNode head, int k) {
//        if(head == null || head.next == null) return head;
//        if(k == 0) return head;
//        ListNode tail = head, newtail = head;
//        ListNode newhead;
//        int n = 1;
//        // 原来的尾结点指向原来的头结点，形成环
//        while(tail.next != null){
//            tail = tail.next;
//            n++;
//        }
//        tail.next = head;
//        // 找到断开环的位置
//        for(int i = 0; i < (n - k % n - 1); i++){
//            newtail = newtail.next;
//        }
//        // 新的头结点指向断开环的位置
//        newhead = newtail.next;
//        newtail.next = null;
//
//        return newhead;
//    }


    public void dfs(int m,int row,int[][]a,boolean[][]b,int res,int n,int l){
        if (row == n && l == m){
            res ++;
            return;
        }
        for (int i = 0;i<m;i++){
            if(b[i][row]){
                continue;
            }
            if(!b[0][0]){
                return;
            }
            b[i][row] = true;
            dfs(m,row + 1,a,b,res,n,i);
            b[i][row] = false;
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }


    //将字符转换为数字
    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if (!Character.isDigit(str.charAt(0))
                && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        int ans = 0;
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int tmp = ((neg ? Integer.MIN_VALUE : Integer.MIN_VALUE + 1) + (str.charAt(i) - '0')) / 10;
            if (tmp > ans) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 - (str.charAt(i++) - '0');
        }
        return neg ? ans : -ans;
    }
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int len = str.length();
        if (str.charAt(0)=='-'||str.charAt(0)=='+'||len==1){
            return false;
        }
        char c[] = str.toCharArray();

            boolean flag = false;
            int left = 0,right=len-1;
            while (c[left] == c[right] && left<len/2){
                left ++;
                right--;
            }
            if (left == len/2){
                flag = true;
            }
            return flag;

    }
    public static int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++res;
            }
        }
        return res;
    }


        public static int jump(int[] nums) {
            int position = nums.length - 1;
            int steps = 0;
            while (position > 0) {
                for (int i = 0; i < position; i++) {
                    if (i + nums[i] >= position) {
                        position = i;
                        steps++;
                        break;
                    }
                }
            }
            return steps;

//            int position = nums.length - 1; //要找的位置
//            int steps = 0;
//            while (position != 0) { //是否到了第 0 个位置
//                for (int i = 0; i < position; i++) {
//                    if (nums[i] >= position - i) {
//                        position = i; //更新要找的位置
//                        steps++;
//                        break;
//                    }
//                }
//            }

        }
    public int jump_1(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }





    public static int threeSum(int[] nums,int target) {// 总时间复杂度：O(n^2)
//[-1,2,1,-4]
        Arrays.sort(nums); // O(nlogn)
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
             int target1 = -(target-nums[i]);
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] == target1) {
                    ans=target;
                    break;
                } else if (nums[left] + nums[right] < target1) {
                    if(Math.abs(target-(nums[left] + nums[right]+nums[i]))<Math.abs(target-ans)){
                        ans =nums[left] + nums[right]+nums[i];
                    }
                    left++;
                } else {  // nums[left] + nums[right] > target
                    if(Math.abs(target-(nums[left] + nums[right]+nums[i]))< Math.abs(target-ans)){
                        ans =nums[left] + nums[right]+nums[i];
                    }
                    right--;
                }
            }
        }
        return ans;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
        }

        public static boolean isCommonPrefix(String[] strs, int length) {
            String str0 = strs[0].substring(0, length);
            int count = strs.length;
            for (int i = 1; i < count; i++) {
                String str = strs[i];
                for (int j = 0; j < length; j++) {
                    if (str0.charAt(j) != str.charAt(j)) {
                        return false;
                    }
                }
            }
            return true;
    }


    public static int intToRoman(String s) {
        int ans = 0;
        Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int len = s.length();
        for(int i=0;i<len;i++){
            int value = symbolValues.get(s.charAt(i));
            if (i<len-1&&value<symbolValues.get(s.charAt(i+1))){
                ans -=value;//先减1，后面会加上进位值   先-1再加五就是4
            }
            else{
                ans+=value;
            }
        }
     return ans;
    }
    public static int lengthOfLongestSubstring(String s){
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }


    // 最长回文串
    public static String findMedianSortedArrays(String s) {
        if (s.length() < 2)
            return s;
        //start表示最长回文串开始的位置，
        //maxLen表示最长回文串的长度
        int start = 0, maxLen = 0;
        int length = s.length();
        for (int i = 0; i < length; ) {
            //如果剩余子串长度小于目前查找到的最长回文子串的长度，直接终止循环
            // （因为即使他是回文子串，也不是最长的，所以直接终止循环，不再判断）
            if (length - i <= maxLen / 2)
                break;
            int left = i, right = i;
            while (right < length - 1 && s.charAt(right + 1) == s.charAt(right))
                ++right; //过滤掉重复的
            //下次在判断的时候从重复的下一个字符开始判断
            i = right + 1;
            //然后往两边判断，找出回文子串的长度
            while (right < length - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
                ++right;
                --left;
            }
            //保留最长的
            if (right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }
        }
        //截取回文子串
        return s.substring(start, start + maxLen);
    }

    public static boolean isNumber(String s) {
        if (s.charAt(0) != '.' && !Character.isDigit(s.charAt(0)) && s.charAt(0) != '+' &&s.charAt(0) != '-'){
            return false;
        }

        int flag =0;
        if (s.charAt(0) == '.'){
            flag = 2;
        }
        else if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            flag = 1;
        }
        int flag1 = 0;
        int l = s.length();
        if ( l == 1 && flag != 0){
            return false;
        }
        boolean flag3 = true;
        for (int i = 1;i < l;i++ ){
            if (flag == 0 || flag == 1){
                if (!Character.isDigit(s.charAt(i)) || s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                    if (s.charAt(i) == '.' && flag1 == 0){
                        flag1 ++;
                        continue;
                    }
                    if (s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                        flag3 = false;
                        if (i == l-1){
                            return false;
                        }
                        if (s.charAt(i + 1) != '+' && s.charAt(i + 1) != '-' && !Character.isDigit(s.charAt(i+1))){
                            return false;
                        }
                        if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-' ){
                            if (i==l-4 || !Character.isDigit(s.charAt(i+2))){
                                return false;
                            }
                        }
                        for (int j = i + 1 ;j < l;j++){
                           if (s.charAt(j) == '.'){
                               return false;
                           }


                        }

                    }
                    return false;
                }
            }
            else{
                if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != 'e' ){
                    return  false;
                }
                else if (s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                    flag3 = false;
                    if (i == l-1){
                        return false;
                    }
                    if (s.charAt(i + 1) != '+' || s.charAt(i + 1) != '-' || !Character.isDigit(s.charAt(i))){
                        return false;
                    }
                    if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-' ){
                        if (i==l-4 || !Character.isDigit(s.charAt(i+2))){
                            return false;
                        }
                    }
                    for (int j = i + 1 ;j < l;j++){
                        if (s.charAt(j) == '.'){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
//    1 2 3 1
    public int rob(int[] nums) {  // 不取相邻值的动态规划
        int len = nums.length;
        int a[] = new int[len];
        int max = 0;
        if (len == 1){
            a[0] = nums[0];
            return a[0];
        }
        if (len == 2){
            a[1] = nums[0]>nums[1]?nums[0]:nums[1];
            return a[1];
        }
        if (len == 3){
            a[2] = nums[0]+nums[2];
            return a[2]>nums[1]?a[2]:nums[1];
        }
        a[0] = nums[0];
        a[1] = nums[0]>nums[1]?nums[0]:nums[1];
        a[2] = nums[0]+nums[2];
        max = Math.max(a[2],a[1]);
        for (int i =3;i<len;i++){
            a[i] = Math.max(a[i-2] + nums[i],a[i-3] + nums[i]);
            max = Math.max(max,a[i]);
        }
        return max;
    }

//[1,3,1,3,100]
    public int rob_1(int[] nums) {// 环形数组
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    private int myRob(int[] nums) {
        int len =nums.length;
        int max = 0;
        int a[] = new int[len];
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        a[0] = nums[0];
        a[1] = nums[0]>nums[1]?nums[0]:nums[1];
        for(int i= 2;i<len ; i++) {
            a[i] = Math.max(nums[i]+a[i-2],a[i-1]);
        }
        return a[len];
    }
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int maxVal = 0;
            for (int val : nums) {
                maxVal = Math.max(maxVal, val);
            }
            int[] sum = new int[maxVal + 1];
            for (int val : nums) {
                sum[val] += val;
            }
            return rob(sum);
        }

        public int rob(int[] nums) {
            int size = nums.length;
            int first = nums[0], second = Math.max(nums[0], nums[1]);
            for (int i = 2; i < size; i++) {
                int temp = second;
                second = Math.max(first + nums[i], second);
                first = temp;
            }
            return second;
        }
    }


    public static void main(String[] args) throws ParseException, CloneNotSupportedException {
        Address address = new Address("CH" , "SD" , "QD");
        Customer customer1 = new Customer(1 , 23 , address);
        Customer customer2 = customer1.clone();
        customer2.getAddress().setCity("JN");
        customer2.setID(2);
        System.out.println(customer1==customer2);
        System.out.println("customer1:"+customer1.toString());
        System.out.println("customer2:"+customer2.toString());
        String date = "2012-12-21";
        System.out.println(getPermutation(4,9));
        //日期
//        Date f = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//        System.out.println(simpleDateFormat.parse(date));
//        System.out.println(simpleDateFormat1.format(simpleDateFormat.parse(date)));
        System.out.println(lengthOfLongestSubstring("abcdaa"));
        System.out.println(findMedianSortedArrays("abccbaa"));
        System.out.println(convert("abccbaa",4));
        System.out.println(myAtoi("-1001"));
        System.out.println(threeSum(new int[]{1,1,1,0},100));
        System.out.println(jump(new int[]{2,3,1,0,4,4,1,1,1}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        isNumber("2e0");
    }
}
class Customer implements Cloneable{
    public int ID;
    public int age;
    public Address address;
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Customer(int iD, int age, Address address) {
        super();
        ID = iD;
        this.age = age;
        this.address = address;
    }
    @Override
    public String toString() {
        return "Customer [ID=" + ID + ", age=" + age + ", address=" + address
                + "]";
    }
    @Override
    public Customer clone() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }
}
// *字符串匹配
class Solution_1 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        // 表示空字符串
        f[0][0] = true;
        for(int i = 1; i <= n; i++){
            // 边界条件
            f[0][i] = f[0][i - 1] && p.charAt(i - 1) == '*';
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    f[i][j] = f[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*'){
                    f[i][j] = f[i][j - 1] || f[i - 1][j];
                }
            }
        }
        return f[m][n];
    }
}
class Address{
    private String country;
    private String province;
    private String city;
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "Address [country=" + country + ", province=" + province
                + ", city=" + city + "]";
    }
    public Address(String country, String province, String city) {
        super();
        this.country = country;
        this.province = province;
        this.city = city;
    }

}



/*普通回溯*/
 class Solution_2 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(path);
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


}
/*回溯重复问题*/
class Solution_3 {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}

// *数组跳跃
class Solution_jump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            // 如果当前位置大于最大可达距离，表示后边的已经不可达
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

// 区间合并
class Solution_7 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}



class Solution_5 {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
    public int fib(int n) {//动态规划
        if (n < 2){
            return  n;
        }
        if (n == 2){
            return  n;
        }
        int l = 0, m1 = 0, m2 = 1 , r = 1;
        for(int i = 3 ; i <= n; i++){
            l = m1;
            m1 = m2 ;
            m2 = r ;
            r = l + m1 + m2;
        }
        return r;
    }
    public int lastWordLength(String s) {//动态规划
       int index = s.length();
        while (s.charAt(index) == ' '){
            index --;
        }
        int r = 0;
        while (index >= 0 && s.charAt(index) != ' ' ){
            r ++;
            index --;
        }
        return r;
    }
}

 class Solution_6 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // 也可以在上面遍历的同时求出 res 的最大值，这里我们为了语义清晰分开写，大家可以自行选择
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}




// N皇后回溯
class Solution_4 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }


    public void backTrack(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0;col < n; ++col) {
            if (isValid (row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTrack(n, row+1, chessboard);
                chessboard[row][col] = '.';
            }
        }

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        if(n<2){
            dp[0]=dp[1]=0;
        }
        for (int i=2; i<n ;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }


    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
// 矩阵旋转 -- 模拟法（模拟过程）
class Solution_8 {
    public int[][] generateMatrix(int n) {
         // 设置拐弯方向的边界值
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            //首先从左到右，到达最右边时，推出本次循环，然后往下走（行固定）
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            // 往下走行加一
            t++;
            // 往下走，列不变
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            // 准备往左走，列减一
            r--;
            // 往左走，行不变
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }

    class Solution_9 {// 动态规划

        public int minPathSum(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int dp[][] = new int[row+1][col+1];
            dp[0][0]=grid[0][0];
            for (int i = 1;i<= row ;i++){
                dp[i][0]=dp[i-1][0]+grid[i][0];
            }
            for (int j = 1;j<= col ;j++){
                dp[0][j]=dp[0][j-1]+grid[0][j];
            }
            for (int i = 1;i<= row ;i++){
                for (int j =1;j<= col;j++){
                    dp[i][j] = Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
                }
            }
            return dp[row][col];
        }



        class Solution {
            public int deleteAndEarn(int[] nums) {
                int maxVal = 0;
                for (int val : nums) {
                    maxVal = Math.max(maxVal, val);
                }
                int[] sum = new int[maxVal + 1];
                for (int val : nums) {
                    sum[val] += val;
                }
                return rob(sum);
            }

            public int rob(int[] nums) {
                int size = nums.length;
                int first = nums[0], second = Math.max(nums[0], nums[1]);
                for (int i = 2; i < size; i++) {
                    int temp = second;
                    second = Math.max(first + nums[i], second);
                    first = temp;
                }
                return second;
            }
        }


        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid == null || obstacleGrid.length == 0) {
                return 0;
            }
            int nums[] = new int[8];
            int len = nums.length;
            int pos = 0;
            for (int i = 0; i < len;i++){
                if (nums[i] == 0){
                    int temp = nums[i];
                    nums[i] = nums[pos];
                    nums[pos] = temp;
                    pos++;
                }
            }
            for (int i = pos; i < len;i++){
                if (nums[i] == 1){
                    int temp = nums[i];
                    nums[i] = nums[pos];
                    nums[pos] = temp;
                    pos++;
                }
            }

            // 定义 dp 数组并初始化第 1 行和第 1 列。
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
                dp[i][0] = 1;
            }
            for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
                dp[0][j] = 1;
            }

            // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 0) {//判断是否有障碍物，没有障碍物才继续
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
    // 滑动窗口
    class Solution {
        Map<Character, Integer> ori = new HashMap<Character, Integer>();
        Map<Character, Integer> cnt = new HashMap<Character, Integer>();

        public String minWindow(String s, String t) {
            int tLen = t.length();
            for (int i = 0; i < tLen; i++) {
                char c = t.charAt(i);
                ori.put(c, ori.getOrDefault(c, 0) + 1);
            }
            int l = 0, r = -1;
            int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
            int sLen = s.length();
            while (r < sLen) {
                ++r;
                if (r < sLen && ori.containsKey(s.charAt(r))) {
                    cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
                }
                while (check() && l <= r) {
                    if (r - l + 1 < len) {
                        len = r - l + 1;
                        ansL = l;
                        ansR = l + len;
                    }
                    if (ori.containsKey(s.charAt(l))) {
                        cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                    }
                    ++l;
                }
            }
            return ansL == -1 ? "" : s.substring(ansL, ansR);
        }

        public boolean check() {
            Iterator iter = ori.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Character key = (Character) entry.getKey();
                Integer val = (Integer) entry.getValue();
                if (cnt.getOrDefault(key, 0) < val) {
                    return false;
                }
            }
            return true;
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), ans);
        return ans;
    }
    // 顺向指针数组合并
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }
    // 子集
    class Solution6 {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            dfs(false, 0, nums);
            return ans;
        }


        public void dfs(boolean choosePre, int cur, int[] nums) {
            if (cur == nums.length) {
                ans.add(new ArrayList<Integer>(t));
                return;
            }
            dfs(false, cur + 1, nums);
            if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
                return;
            }
            t.add(nums[cur]);
            dfs(true, cur + 1, nums);
            t.remove(t.size() - 1);
        }
    }

    class Solution3 {
        public int numDecodings(String s) {
            int n = s.length();
            int[] f = new int[n + 1];
            f[0] = 1;
            for (int i = 1; i <= n; ++i) {
                if (s.charAt(i - 1) != '0') {
                    f[i] += f[i - 1];
                }
                if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                    f[i] += f[i - 2];
                }
            }
            return f[n];
        }
    }

    private void dfs(int i, int n, int k, ArrayList<Integer> list, List<List<Integer>> ans) {
        if (list.size() + n - i + 1 < k) {
            return;
        }
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            dfs(j + 1, n, k, list, ans);
            list.remove(list.size() - 1);
        }
    }
}








