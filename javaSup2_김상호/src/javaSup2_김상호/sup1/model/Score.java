package javaSup2_김상호.sup1.model;

public class Score {

	private int 국어;
	private int 영어;
	private int 수학;
	private int 총점;
	private double 평균;
	public Score() {
		// TODO Auto-generated constructor stub
	}
	public Score(int 국어, int 영어, int 수학) {
		this.국어 = 국어;
		this.영어 = 영어;
		this.수학 = 수학;
	}
	public void 결과() {
		총점 = 국어 + 영어 + 수학;
		평균 = (국어 + 영어 + 수학) / 3.0;
		String 결과 = ((국어>=50)&&(영어>=50)&&(수학>=50))&&(평균>=50) ? "합격" : "불합격";
		System.out.println(결과);
		
	}
}
