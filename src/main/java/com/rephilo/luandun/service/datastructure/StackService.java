package com.rephilo.luandun.service.datastructure;

import org.springframework.stereotype.Service;

import java.util.Stack;

/**
 * 极简数据结构 第5章
 *
 * @author rephilo
 */
@Service
public class StackService {

    /**
     * 转换数字到其他进制
     *
     * @param number  原数字
     * @param decimal 要转换的进制
     * @return 转换结果
     */
    public String convertWithStack(int number, int decimal) {
        String d2c = "0123456789ABCDEF";
        StringBuilder result = new StringBuilder();

        //处理负数
        if (number < 0) {
            result.append("-");
            number = -number;
        }

        Stack<Character> stack = new Stack<>();
        do {
            //将新的进制数字推到栈中
            stack.push(d2c.toCharArray()[number % decimal]);
            number /= decimal;
        } while (number != 0);

        while (!stack.empty()) {
            //出栈拼接结果
            result.append(stack.pop());
        }

        return result.toString();
    }

    /**
     * 验证括号的两端是否完整
     *
     * @param content 文本内容
     * @return 验证结果
     */
    public Boolean bracketsValidator(String content) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < content.length(); i++) {
            String letter = String.valueOf(content.toCharArray()[i]);
            switch (letter) {
                case "(":
                case "[":
                case "{":
                    stack.push(letter);
                    break;
                case ")":
                    if (stack.empty() || !"(".equals(stack.peek())) {
                        return false;
                    }

                    stack.pop();
                    break;
                case "]":
                    if (stack.empty() || !"[".equals(stack.peek())) {
                        return false;
                    }

                    stack.pop();
                    break;
                case "}":
                    if (stack.empty() || !"{".equals(stack.peek())) {
                        return false;
                    }

                    stack.pop();
                    break;
                default:
                    return false;
            }
        }

        return stack.empty();
    }
}
