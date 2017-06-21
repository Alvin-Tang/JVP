package com.jvp.common.util;

import java.util.ArrayList;
import java.util.List;

import com.jvp.common.model.Tree;

public class TreeUtil {

	public static List<Tree> formatTree(List<Tree> trees) {
		List<Tree> treelist = new ArrayList<Tree>();
		if (trees != null && trees.size() > 0) {
			List<Tree> list = new ArrayList<Tree>();
			for (Tree treeJson : trees) {
				if (treeJson.getPid() == null || treeJson.getPid() == 0) {
					list.add(treeJson);
				}
			}
			for (Tree treeJson : list) {
				Tree root = new Tree();
				root = treeJson;
				setChildren(trees, root);
				treelist.add(root);
			}
		}
		return treelist;
	}

	private static void setChildren(List<Tree> trees, Tree pTree) {
		for (int i = 0; i < trees.size(); i++) {
			Tree tree = new Tree();
			tree = trees.get(i);
			if (tree.getPid() != null && tree.getPid() != 0) {
				if (tree.getPid()==pTree.getId()) {
					setChildren(trees, tree);
					pTree.getChildren().add(tree);
				}
			}
		}
	}
}