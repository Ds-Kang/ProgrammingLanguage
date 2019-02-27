package main

import (
  "fmt"
  "os"
  ) //파일 입출력을 위한 os와 print를 위한 fmt를 import한다.

func main() {
    var t string
    var student_number string
    var name string
    var major string //변수 선언
    read, _ :=os.Open("student.txt") //읽을 파일 불러오기
    for i:=0;i<6;i++{ //변수를 쉽게 설정
        fmt.Fscan(read,&t)//스페이스를 기준으로 정보를 읽어온다.
        if(i==1) {
            student_number=t //2번째 부분인 학번을 불러와서 student_number에 저장하였다.
        }
        if(i==3) {
            name=t //4번째 부분인 이름을 불러와서 name에 저장하였다.
        }
        if(i==5) {
            major=t //6번째 부분인 학과을 불러와서 major에 저장하였다.
        }
    }
    read.Close() //error 방지를 위한 파일 close
    fmt.Println(student_number,major,name+"입니다.") //화면에 학번, 학과, 이름을 출력함
    write, _ :=os.Create("save.txt") //저장할 파일 불러오기
    fmt.Fprintln(write,student_number,major,name+"입니다.") //텍스트 파일에 학번, 학과, 이름을 출력함
    write.Close() //error 방지를 위한 파일 close

}