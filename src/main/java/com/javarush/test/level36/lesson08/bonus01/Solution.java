package com.javarush.test.level36.lesson08.bonus01;

/* Разбираемся в красно-черном дереве
Дана реализация красно-черного дерева.
Некоторые методы сломаны. Разберитесь в коде и исправьте ошибки.
Метод main не участвует в тестировании.
Все модификатры правильные.
Имена переменных и методов не изменяйте.
*/
public class Solution {
    public static void main(String[] args) {
        try {
            RedBlackTree.Node node = NodeHelperTestSolution.getEmptyNode();
            RedBlackTree newNode = new RedBlackTree();
            newNode.insert(5);
            NodeHelperTestSolution.setNewNodeValue("element", node, newNode.current);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
