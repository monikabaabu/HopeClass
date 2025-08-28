package H_05_07_25;
import java.io.*;
import java.util.*;
//You are building a digital library system where each book is represented by a unique book ID. The library catalog is stored as a doubly linked list, allowing users to navigate through the list of books. Occasionally, books are removed from the library, and when a book is removed from the end of the catalog, it should no longer appear in the list. Your task is to write a program that deletes the last book from the catalog and prints the updated list of book IDs.
//
//Write a program to delete the last book from the doubly linked list representing the library catalog. After the deletion, print the updated list of book IDs. If the list is empty, Print the message as “List is empty”.
//
//Input Format
//
//The first line contains an integer N, the number of books initially in the catalog. The second line contains N space-separated integers representing the book IDs.
//
//Constraints
//
//The input values are all positive integers. There will be at least 1 book in the catalog initially.
//
//        Output Format
//
//Print the updated list of book IDs in sequence from the start to the end of the catalog after the last book has been removed.
//
//Sample Input 0
//
//        101 102 103 104 105
//Sample Output 0
//
//        101 102 103 104
//Explanation 0
//
//The catalog is initialized with 5 book IDs: 101 102 103 104 105. The last book ID 105 is removed from the end of the catalog. The updated list after deletion is 101 102 103 104.
//
//Sample Input 1
//
//        701
//Sample Output 1
//
//List is empty
//Explanation 1
//
//The catalog initially contains one book ID: 701. After removing the last book (701), the list becomes empty.So that print "List is empty"





public class Linkedlist {

    class node {
        int data;
        node next;
        node(int d) {
            data = d;
        }
    }

    class ll {
        node head = null;
        node old = null;

        void ins(int d) {
            node nn = new node(d);
            if (head == null) {
                head = nn;
                old = nn;
            } else {
                old.next = nn;
                old = nn;
            }
        }

        void dis() {
            if (head == null) {
                System.out.print("List is empty");
                return;
            }

            node t = head;
            while (t != null) {
                System.out.print(t.data + " ");
                t = t.next;
            }
        }

        void del() {
            if (head == null || head.next == null) {
                head = null;
                System.out.print("List is empty");
                return;
            }

            node t = head;
            while (t.next.next != null) {
                t = t.next;
            }
            t.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist obj = new Linkedlist();     // ✅ Create outer class object
        Linkedlist.ll l = obj.new ll();        // ✅ Use outer class object to create inner class object

        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            l.ins(a);
        }

        l.del();
        l.dis();
    }
}
