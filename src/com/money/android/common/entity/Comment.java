/**
 * 
 */
package com.money.android.common.entity;

/**
 * @author ChenHongLi
 *
 */
public class Comment {
	/**缩略图路径*/
	private String headPath;
	private String title;
	private String content;
	private String time;
	private int commentCount;
	public Comment(){}
	public Comment(String headPath,String title,String content,String time,int commentCount){
		this.headPath = headPath;
		this.title = title;
		this.content = content;
		this.time = time;
		this.commentCount = commentCount;
	}
	public String getHeadPath() {
		return headPath;
	}
	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
}
