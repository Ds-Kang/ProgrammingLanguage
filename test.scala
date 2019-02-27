import java.io._ //파일 입력을 위해 import한다.
import scala.io.Source //파일 출력을 위해 import한다.

object Demo {
	def main(args: Array[String]) {
		var i=0
		var student_number,name,major=""
		for(line<-Source.fromFile("student_eg.txt").getLines()){ //읽을 파일을 한 줄씩 불러와서 line에 입력
			val s=line.split(" ")(1).mkString("") //각 line의 space를 기준으로 2번째 항인 각 정보를 s에 저장함. 
			if(i==0) {
				student_number=s //1번재 줄인 학번을 불러와서 student_number에 저장하였다.
			}
			else if(i==1) {
				name=s //2번째 줄인 이름을 불러와서 name에 저장하였다.
			}
			else{
				major=s //3번째 줄인 학과을 불러와서 major에 저장하였다.
			}
			i+=1 //각 줄을 구분하기 위해 i를 사용하였다.
		}
    	val writer = new PrintWriter(new File("save_eg.txt" )) //저장할 파일 불러오기

    	println(s"I'm ${major} major ${student_number} ${name}") //화면에 학번, 학과, 이름을 출력함
	    writer.write(s"I'm ${major} major ${student_number} ${name}") //텍스트 파일에 학번, 학과, 이름을 출력함
	    writer.close() //error 방지를 위한 파일 close
	}
}