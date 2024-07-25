package pkg3.dto;

/**
 * 인터페이스 상속 키워드 : implements (구현하다)
 */
public class PHJCalculator implements Calculater {

	@Override
	public int plus(int a, int b) {
		int result = a+b;
		if (result > MAX_NUM) result = MAX_NUM;
		if (result < MIN_NUM) result = MIN_NUM;
		return result;
	}

	@Override
	public int minus(int a, int b) {
		int result = a-b;
		if (result > MAX_NUM) result = MAX_NUM;
		if (result < MIN_NUM) result = MIN_NUM;
		return result;
	}

	@Override
	public int multi(int a, int b) {
		int result = a * b;
		if (result > MAX_NUM) result = MAX_NUM;
		if (result < MIN_NUM) result = MIN_NUM;
		return result;
	}

	@Override
	public int div(int a, int b) {
		int result = a/b;
		if (result > MAX_NUM) result = MAX_NUM;
		if (result < MIN_NUM) result = MIN_NUM;
		return result;
	}

	@Override
	public int mod(int a, int b) {
		int result = a%b;
		if (result > MAX_NUM) result = MAX_NUM;
		if (result < MIN_NUM) result = MIN_NUM;
		return result;
	}

	@Override
	public int pow(int a, int x) {
		int result = 1;
		
		if(x>0) {
			for(int i =0 ; i < x ; i++) {
				result *= a;
			}
		}
			
		if(x==0) result = 1;
		
		if (result > MAX_NUM) result = MAX_NUM;
		if (result < MIN_NUM) result = MIN_NUM;
		return result;
	}

	@Override
	public double arrOfCircle(int r) {
		return r*r*PI;
	}

	@Override
	public String toBinary(int num) {
		String result = "";
		int i = 1;
		
		while(i <= num/2) {
			i*=2;
		}
		
		int c = 0;
		
		while(i > 1) {
		
			c = num/i;
			switch(c) {
			case 1 : result += "1"; break;
			case 0 : result += "0"; break;
			default : result += "S";
			}
			
			num %= i;
			i /= 2;
		}
		
		switch(num) {
		case 1 : result += "1"; break;
		case 0 : result += "0"; break;
		default : result += "S";
		}
		
		return result;
	}

	@Override
	public String toHexadecimal(int num) {
		String result = "";
		int i = 1;
		
		while(i <= num/16) {
			i*=16;
		}
		
		int c = 0;
		
		while(i > 1) {
			
			c = num/i;
			switch(c) {
			case 0:  result +="0"; break;
			case 1:  result +="1"; break;
			case 2:  result +="2"; break;
			case 3:  result +="3"; break;
			case 4:  result +="4"; break;
			case 5:  result +="5"; break;
			case 6:  result +="6"; break;
			case 7:  result +="7"; break;
			case 8:  result +="8"; break;
			case 9:  result +="9"; break;
			case 10: result +="a"; break;
			case 11: result +="b"; break;
			case 12: result +="c"; break;
			case 13: result +="d"; break;
			case 14: result +="e"; break;
			case 15: result +="f"; break;
			default : result +="S";
			}
			
			num %= i;
			i /= 16;
		}
		
		switch(num) {
		case 0:  result +="0"; break;
		case 1:  result +="1"; break;
		case 2:  result +="2"; break;
		case 3:  result +="3"; break;
		case 4:  result +="4"; break;
		case 5:  result +="5"; break;
		case 6:  result +="6"; break;
		case 7:  result +="7"; break;
		case 8:  result +="8"; break;
		case 9:  result +="9"; break;
		case 10: result +="a"; break;
		case 11: result +="b"; break;
		case 12: result +="c"; break;
		case 13: result +="d"; break;
		case 14: result +="e"; break;
		case 15: result +="f"; break;
		default : result +="S";
		}
		
		return result;
	}
	

}
