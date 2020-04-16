//实现一个基本的计算器来计算一个简单的字符串表达式的值。 
//
// 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格 。 
//
// 示例 1: 
//
// 输入: "1 + 1"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: " 2-1 + 2 "
//输出: 3 
//
// 示例 3: 
//
// 输入: "(1+(4+5+2)-3)+(6+8)"
//输出: 23 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int pow = 1;
        for (int i=n-1;i>=0;i--){
            if (array[i]==' '){
                continue;
            }
            if (array[i]>='0'&&array[i]<='9'){
                num += (array[i]-'0')*pow;
                pow *=10;
            }else{
                if (pow!=1){
                    stack.push(num);
                    //初始化
                    pow=1;
                    num=0;
                }
                if (array[i]=='+'||array[i]=='-'){
                    stack.push(array[i]=='+'?1:-1);
                }else if (array[i]=='('){
                    int res = evaluateExpr(stack);
                    //')'出栈
                    stack.pop();
                    stack.push(res);
                }else if (array[i]==')'){
                    stack.push(-2);
                }
            }
        }
        if (pow!=1){
            stack.push(num);
        }
        return evaluateExpr(stack);
    }
    private int evaluateExpr(Stack<Integer> stack){
        int res = stack.pop();
        while (!stack.isEmpty()&&stack.peek()!=-2){
            res += stack.pop()*stack.pop();
        }
        //遇到')'为止
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
