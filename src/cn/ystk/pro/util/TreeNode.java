package cn.ystk.pro.util;
import java.util.List;
/**
 * 
 * 功能:树形节点实体类 版本: 1.0 开发人员: 徐长江 创建日期: 2017年4月10日 修改日期: 2017年4月10日 修改列表:
 */
public class TreeNode {
	/** 节点id */
	private String id;

	/** 父节点 id 默认值为0 */
	private String pId = "0";

	/** 节点名称 */
	private String name;
	/**
	 * 属性节点uri地址
	 */
	private String moduleUrl;

	private List<TreeNode> treeNode;

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getModuleUrl() {
		return moduleUrl;
	}

	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}

	public List<TreeNode> getTreeNode() {
		return treeNode;
	}

	public void setTreeNode(List<TreeNode> treeNode) {
		this.treeNode = treeNode;
	}
}
