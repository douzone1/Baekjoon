package Douzone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//https://fbtmdwhd33.tistory.com/83
//이름 국어 영어 수학 점수 주어짐 클래스 생성 
		//국어점수 내림차순
		//국어점수 동일할 시 영어점수 오름차순
		//국어점수 & 영어점수 같을 시 수학점수 내림차순
		//모든 점수가 같으면 이름 오름차순(아스키 코드 기준)
public class ScoreSort{
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int row = sc.nextInt();		
		
		//값을 입력할 열이4개인 2차원 배열 선언 
		String[][] stScore = new String[row][4];
		
		//각 열마다 이름과 국,영,수 점수 입력
		for(int i = 0; i < stScore.length; i++) {
			for(int j = 0; j < stScore[i].length; j++) {
				stScore[i][j] = sc.next();
			}
		}
		
		Arrays.sort(stScore, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				//국어점수 오름차순			
				if(Integer.valueOf(o1[1]) > Integer.valueOf(o2[1])) {					
					 return -1;
				}
				//국어점수, 수학점수, 영어점수 같을 때 이름순 오름차순
				else if(Integer.valueOf(o1[1]) == Integer.valueOf(o2[1])) {
					if(Integer.valueOf(o1[2]) == Integer.valueOf(o2[2])) {
						if(Integer.valueOf(o1[3]) == Integer.valueOf(o2[3])) {
							return o1[0].compareTo(o2[0]);
						}					
					//국어점수, 영어점수 같을 때 수학점수 내림차순
						return Integer.compare(Integer.valueOf(o2[3]), Integer.valueOf(o1[3]));
					}
					return Integer.compare(Integer.valueOf(o1[2]), Integer.valueOf(o2[2]));
				}
				return 1;
			}
		});
		
		for(int i = 0; i < stScore.length; i ++) {
			System.out.println(stScore[i][0]);
		}
	}
}