# 푸드파이트 대회
# food 배열 사이즈 구하기
# 각 idx의 원소 반토막 //2 로 나온 만큼 idx를 출력
def solution(food):
    answer = ''
    length = len(food)

    for i in range(1, length) :
        count = food[i] // 2
        for j in range(0, count) :
            answer += str(i)
    reverse = "".join(reversed(answer))
    return answer + '0' + reverse

print(solution([1,7,1,2]));