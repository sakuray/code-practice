package com.sakuray.code.practice.offer;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class _31_整数中1出现的次数_从1到n整数中1出现的次数_ {


    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(101));
    }


    /**
     * 采取排列组合的思路进行求解，这里用4017为例
     * 个位：出现个位为1的可能有0001-4011，一共(401-0+1)*1=402，十百千的变化有402种，个位固定是1
     * 十位：出现十位为1的可能有0010-4010，一共40*10+8=408，
     *      这里解释一下，00-39共40种情况，个位变化有10种，所以是40*10，由于401的情况个位变化不足，所以使用单独计数0~7，共8种
     * 百位：出现百位为1的可能有0100-3100，一共4*100
     * 千位：出现千位为1的可能有1000-1999，一共1*1000种
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0, cur, p = 1;
        while(n / p != 0) {
            cur = (n / p) % 10; // 计算当前位的数值
            if(cur == 0) {  // 计算高位
                sum += (n / p / 10) * p;
            } else if (cur == 1) {  // 计算高位和同位
                sum += (n / p / 10) * p;
                sum += n % p + 1;
            } else {
                sum += (n / p / 10 + 1) * p;
            }
            p *= 10;
        }
        return sum;
    }

    public static int NumberOf1Between1AndN_Solution_1(int n) {
        int count = 0;//1的个数
        int i = 1;//当前位
        int current = 0,after = 0,before = 0;
        while((n/i)!= 0){
            current = (n/i)%10; //高位数字
            before = n/(i*10); //当前位数字
            after = n-(n/i)*i; //低位数字
            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if (current == 0)
                count += before*i;
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
            else if(current == 1)
                count += before * i + after + 1;
                //如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
            else{
                count += (before + 1) * i;
            }
            //前移一位
            i = i*10;
        }
        return count;
    }


    public static int NumberOfXBetween1AndN_Solution_2(int n,int x) {
        if(n<0||x<1||x>9)
            return 0;
        int high,low,curr,tmp,i = 1;
        high = n;
        int total = 0;
        while(high!=0){
            high = n/(int)Math.pow(10, i);// 获取第i位的高位
            tmp = n%(int)Math.pow(10, i);
            curr = tmp/(int)Math.pow(10, i-1);// 获取第i位
            low = tmp%(int)Math.pow(10, i-1);// 获取第i位的低位
            if(curr==x){
                total+= high*(int)Math.pow(10, i-1)+low+1;
            }else if(curr<x){
                total+=high*(int)Math.pow(10, i-1);
            }else{
                total+=(high+1)*(int)Math.pow(10, i-1);
            }
            i++;
        }
        return total;
    }

}
