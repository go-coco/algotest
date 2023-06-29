public enum Error {

	E0000("알 수 없는 오류 GRADIUS 내부 에러. 개발자 문의 필요"), E0001("DB 관련 에러 GRADIUS 내부 에러. 개발자 문의 필요"), E1000("중복 요청 에러"),
	E1001("파라메터 정보가 누락되었습니다."), E1002("사용자가 존재하지 않습니다."), E1101("파라메터 정보가 유효하지 않습니다."),
	E1204("사용자가 사용 중인 레벨에서 차단 중인 정책이 아닙니다 (임시정책 관리자 적용 시 해당)");

	private final String error;

	Error(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

}
