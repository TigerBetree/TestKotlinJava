package com.test.java.datastruct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 计算ViewGroup的最大深度
 */
public class ViewGroupDepth {

    public static void main(String[] args) {
        ViewGroup vg = new ViewGroup();
        vg.addChild(new View());

        ViewGroup vg1 = new ViewGroup();
        ViewGroup vg2 = new ViewGroup();
        vg2.addChild(new View());

        ViewGroup vg3 = new ViewGroup();
        vg3.addChild(new View());

        vg2.addChild(vg3);

        vg1.addChild(vg2);
        vg1.addChild(new View());

        vg.addChild(vg1);

        System.out.println("getMaxDepth : " + getMaxDepth(vg));
        System.out.println("getMaxDepth2 : " + getMaxDepth2(vg));
    }

    public static int getMaxDepth(ViewGroup viewGroup) {
        int maxDepth = 0;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof ViewGroup) {
                int childDepth = getMaxDepth((ViewGroup) child);
                maxDepth = Math.max(maxDepth, childDepth);
            }
        }
        return maxDepth + 1;
    }
    public static int getMaxDepth2(ViewGroup viewGroup) {
        Queue<ViewGroup> q = new LinkedList<>();
        q.add(viewGroup);
        int currentLevelCount = 1;
        int nextLevelCount = 0;
        int level = 0;
        while (!q.isEmpty()) {
            ViewGroup temp = q.poll();
            currentLevelCount--;
            for (int i = 0; i < temp.getChildCount(); i++) {
                View child = temp.getChildAt(i);
                if (child instanceof ViewGroup) {
                    q.add((ViewGroup) child);
                    nextLevelCount++;
                }
            }
            if (currentLevelCount == 0) {
                level++;
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        return level;
    }
}

class View {

}

class ViewGroup extends View {
    List<View> childs = new ArrayList<>();

    public void addChild(View view) {
        childs.add(view);
    }

    public int getChildCount() {
        return childs.size();
    }

    public View getChildAt(int index) {
        return childs.get(index);
    }
}
