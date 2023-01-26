package com.slow;

import java.util.Scanner;

/**
 * ClassName: Customer
 * Package: com.slow
 * Description:
 *
 * @Author: cyxstart
 * @CreateTime: 2023/1/20 0020
 * @Version:
 *
 */
public class Customer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scanner.next();
        System.out.println(name);
    }
}
