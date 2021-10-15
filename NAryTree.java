/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NAry.NAryTree;

import NAry.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTree {
    public static class NodoArbol{
        int val;
        List<NodoArbol> hijos = new LinkedList<>();

        NodoArbol(int data){
            val = data;
        }

        NodoArbol(int data,List<NodoArbol> child){
            val = data;
            hijos = child;
        }
    }

    private static void printNAryTree(NodoArbol root){
        if(root == null) return;
        Queue<NodoArbol> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                NodoArbol node = queue.poll();
                assert node != null;
                System.out.print(node.val + " ");
                for (NodoArbol item : node.hijos) {
                    queue.offer(item);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NodoArbol root = new NodoArbol(1);
        root.hijos.add(new NodoArbol(2));
        root.hijos.add(new NodoArbol(3));
        root.hijos.add(new NodoArbol(4));
        root.hijos.get(0).hijos.add(new NodoArbol(5));
        root.hijos.get(0).hijos.add(new NodoArbol(6));
        root.hijos.get(0).hijos.add(new NodoArbol(7));
        root.hijos.get(1).hijos.add(new NodoArbol(8));
        root.hijos.get(2).hijos.add(new NodoArbol(9));
        root.hijos.get(2).hijos.add(new NodoArbol(10));
        root.hijos.get(2).hijos.add(new NodoArbol(11));
        printNAryTree(root);
    }
}