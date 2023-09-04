package com.test.java.datastruct.link;

import java.util.ArrayList;

public class Test1 {

    public boolean isPail (ListNode head) {
        // write code here
        if(head == null){
            return false;
        }

        if(head.next == null){
            return true;
        }

        ArrayList<Integer> mList = new ArrayList<Integer>();
        while(head != null){
            mList.add(head.val);
            head = head.next;
        }

        int l = 0;
        int r = mList.size() - 1;
        while(l <= r){
            int left = mList.get(l);
            int right = mList.get(r);
            if(left != right){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
