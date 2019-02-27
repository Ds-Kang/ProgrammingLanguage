student=io.open("student.txt","r") --읽을 파일 불러오기

for i=0,2,1 do --3줄의 line을 읽기위해 3번 반복
	res=student:read("*line") --한 줄씩 읽어서 res에 저장
	space=string.find(res," ") --단어를 단위로 나누기 위해 space의 index 찾기
	res=string.sub(res,space+1,#res) --찾은 index+1을 기준으로 문장의 맨 뒤까지 읽기 -> 각각의 정보
	if (i==0) then
		studnet_number=res --학번정보을 불러와서 student_number에 저장하였다.
	elseif (i==1) then
		name=res --이름정보을 불러와서 name에 저장하였다.
	else 
		major=res --학과정보을 불러와서 major에 저장하였다.
	end
end
io.close(student) --error 방지를 위한 파일 close
print(studnet_number,major,name,"입니다") --화면에 학번, 학과, 이름을 출력함

save=io.open("save.txt","w") --저장할 파일 불러오기
save:write(studnet_number,major,name,"입니다") --텍스트 파일에 학번, 학과, 이름을 출력함
io.close(save) --error 방지를 위한 파일 close
