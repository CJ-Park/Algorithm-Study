# 콜라 문제
def solution(a, b, n):
    answer = 0
    left = 0
    while(n >= a):
        if(n % a == 0):
            answer += (n // a) * b  
            n = (n // a) * b
        else:
            left = n % a
            answer += (n // a) * b
            n = (n // a) * b + left
            left = 0
            
    return answer

print(solution(2, 1, 20));
print(solution(3, 1, 20));
print(solution(3, 2, 20));
