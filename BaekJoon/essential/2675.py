# 문자열 반복
n = int(input())
for _ in range(n):
    R, S = input().split()
    for i in S:
        print(i*int(R), end='')
    print()

