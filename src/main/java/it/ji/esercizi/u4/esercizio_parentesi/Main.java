package it.ji.esercizi.u4.esercizio_parentesi;

import java.util.Stack;

public class Main {

//    Implementa il riconoscimento di stringhe parenteticamente corrette con i tre tipi diversi di parentesi
//    utilizzate nel linguaggio Java: tonde ( ), quadre [ ] e graffe { }.
//    Ciascun tipo di parentesi racchiude costrutti che possono essere nidificati: a ogni parentesi aperta
//    deve corrispondere una parentesi chiusa dello stesso tipo.
//    Scrivi un programma che verifichi che le parentesi siano disposte in modo corretto
    public static void main(String[] args) {

        System.out.println("Parentesi corrette: " + parentesi("()"));
        System.out.println("Parentesi corrette: " + parentesi("()[]{}"));
        System.out.println("Parentesi corrette: " + parentesi("({[]})"));
        System.out.println("Parentesi corrette: " + parentesi("({[]})()"));
        System.out.println("Parentesi corrette: " + parentesi("[({[]})]"));

        System.out.println("Gruppo errate: " + parentesi("(()"));
        System.out.println("Gruppo errate: " + parentesi("(()]"));
        System.out.println("Gruppo errate: " + parentesi("((){"));
        System.out.println("Gruppo errate: " + parentesi("((){}"));
        System.out.println("Gruppo errate: " + parentesi("((){}"));

    }


    public static boolean parentesi(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if ((s.charAt(i) == ')' && c != '(') || (s.charAt(i) == ']' && c != '[') || (s.charAt(i) == '}' && c != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


