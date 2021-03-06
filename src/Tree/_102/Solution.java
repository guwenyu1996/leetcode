package Tree._102;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // Solution 1: iteration
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        helper(root, 0, result);
        return result;
    }

    public void helper(TreeNode node, int level, List<List<Integer>> result){

        if(result.size() == level){
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
        }

        result.get(level).add(node.val);

        if(node.left != null)
            helper(node.left, level+1, result);
        if(node.right != null)
            helper(node.right, level+1, result);
    }

    // Solution 2: iteration
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> treeQ = new LinkedList<>();
        Queue<Integer> degreeQ = new LinkedList<> ();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<> ();

        if(root == null)
            return result;
        treeQ.offer(root);
        degreeQ.offer(0);
        int currDegree = 0;

        while(!treeQ.isEmpty()){
            TreeNode node = treeQ.poll();
            int degree = degreeQ.poll();

            if(node.left != null)
                updateQueues(treeQ, degreeQ, node.left, degree+1);

            if(node.right != null)
                updateQueues(treeQ, degreeQ, node.right, degree+1);

            if(degree != currDegree){
                result.add(temp);
                temp = new ArrayList<>();
                currDegree ++;
            }
            temp.add(node.val);
        }
        result.add(temp);
        return result;
    }

    public void updateQueues(Queue<TreeNode> treeQ, Queue<Integer> degreeQ, TreeNode node, int degree){
        treeQ.offer(node);
        degreeQ.offer(degree);
    }

    // Solution 2: improve
    public List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> treeQ = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<> ();

        if(root == null)
            return result;
        treeQ.offer(root);
        int currDegree = 0;

        while(!treeQ.isEmpty()){
            temp = new ArrayList<> ();

            int level_length = treeQ.size();
            for(int i = 0; i < level_length; i ++){
                TreeNode node = treeQ.poll();
                temp.add(node.val);

                if(node.left != null)
                    treeQ.offer(node.left);
                if(node.right != null)
                    treeQ.offer(node.right);
            }

            currDegree ++;
            result.add(temp);
        }

        return result;
    }
}
