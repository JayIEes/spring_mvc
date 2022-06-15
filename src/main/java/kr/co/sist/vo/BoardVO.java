package kr.co.sist.vo;

public class BoardVO {
	private int startNum, endNum, currentPage;//시작번호,끝번호, 현재 페이지번호
	private String field,keyword;// 검색 필드명, 검색키워드 
	
	public BoardVO() {
		currentPage=1; //dispatcherServlet이 subquery를 요청하면 VO객체를 생성하여 할당해주는데 
		//최초페이지는 1페이지가 되어야 하므로 생성자에서 1을 넣어준다.
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "BoardVO [startNum=" + startNum + ", endNum=" + endNum + ", currentPage=" + currentPage + ", field="
				+ field + ", keyword=" + keyword + "]";
	}

}
