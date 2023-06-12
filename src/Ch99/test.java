package Ch99;

class C01Buyer{
	private int MyMoney;
	private int AppleCnt;
		
	public C01Buyer(int myMoney, int appleCnt) {
		super();
		MyMoney = myMoney;
		AppleCnt = appleCnt;
	}
	
	public void Payment(C01Seller seller, int money) {
		
		//1 MyMoney에서 money만큼 차감
		MyMoney-=money;
		
		//2 seller 에게 money전달, //3 seller로부터 사과개수받기
		
		int cnt = seller.Receive(money);
		
		//4 사과개수를 멤버인 AppleCnt누적
		AppleCnt+=cnt;
		
	}
	public void ShowInfo() {
		//속성 정보를 Console에 출력
		System.out.println("보유금액 : "+ MyMoney);
		System.out.println("사과개수 : "+ AppleCnt);
		
	}
}
class C01Seller{
	private int MyMoney;
	private int AppleCnt;
	public int Price;
	
	public C01Seller(int myMoney, int appleCnt, int price) {
		super();
		MyMoney = myMoney;
		AppleCnt = appleCnt;
		Price = price;
	}
	
	public int Receive(int money) {
		//1 money 를 MyMoney에 누적
		MyMoney+=money;
		//2 money에 해당되는 만큼 사과개수를 계산
		int revcnt=money/Price;
		//3 AppleCnt에서 계산된 만큼의 사과개수를 차감
		AppleCnt-=revcnt;
		//4 계산된 사과개수를 리턴
		return revcnt;
	}
	public void ShowInfo() {
		//속성정보를 Console에 출력
		System.out.println("보유금액 : "+ MyMoney);
		System.out.println("사과개수 : "+ AppleCnt);
		System.out.println("개당가격 : "+ Price);
	}
}

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		C01Seller 황다은 = new C01Seller(100000,100,1000);	//보유금액, 사과개수, 개당가격
		C01Buyer 김민수 = new C01Buyer(10000,0);		//보유금액, 사과개수
		C01Buyer 이주현 = new C01Buyer(20000,0);	
		C01Buyer 정재원 = new C01Buyer(30000,0);	
		김민수.Payment(황다은, 2000);
		이주현.Payment(황다은, 5000);
		정재원.Payment(황다은, 3000);
		System.out.println("---판매자 정보---");
		황다은.ShowInfo();
		System.out.println("---구매자 정보---");
		System.out.println("-김민수-");
		김민수.ShowInfo();
		System.out.println("-이주현-");
		이주현.ShowInfo();
		System.out.println("-정재원-");
		정재원.ShowInfo();
		

	}

}
